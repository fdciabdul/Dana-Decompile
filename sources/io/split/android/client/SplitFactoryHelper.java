package io.split.android.client;

import android.content.Context;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.events.EventsManagerCoordinator;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.SplitApiFacade;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.http.mysegments.MySegmentsFetcherFactoryImpl;
import io.split.android.client.service.impressions.strategy.ImpressionStrategyProvider;
import io.split.android.client.service.impressions.strategy.ProcessStrategy;
import io.split.android.client.service.sseclient.EventStreamParser;
import io.split.android.client.service.sseclient.ReconnectBackoffCounter;
import io.split.android.client.service.sseclient.SseJwtParser;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.notifications.MySegmentsPayloadDecoder;
import io.split.android.client.service.sseclient.notifications.MySegmentsV2PayloadDecoder;
import io.split.android.client.service.sseclient.notifications.NotificationParser;
import io.split.android.client.service.sseclient.notifications.NotificationProcessor;
import io.split.android.client.service.sseclient.notifications.SplitsChangeNotification;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorFactoryImpl;
import io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry;
import io.split.android.client.service.sseclient.reactor.SplitUpdatesWorker;
import io.split.android.client.service.sseclient.sseclient.BackoffCounterTimer;
import io.split.android.client.service.sseclient.sseclient.PushNotificationManager;
import io.split.android.client.service.sseclient.sseclient.SseAuthenticator;
import io.split.android.client.service.sseclient.sseclient.SseClient;
import io.split.android.client.service.sseclient.sseclient.SseClientImpl;
import io.split.android.client.service.sseclient.sseclient.SseHandler;
import io.split.android.client.service.sseclient.sseclient.SseRefreshTokenTimer;
import io.split.android.client.service.sseclient.sseclient.StreamingComponents;
import io.split.android.client.service.synchronizer.SyncGuardian;
import io.split.android.client.service.synchronizer.SyncGuardianImpl;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.service.synchronizer.SyncManagerImpl;
import io.split.android.client.service.synchronizer.Synchronizer;
import io.split.android.client.service.synchronizer.WorkManagerWrapper;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerFactoryImpl;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerFactoryImpl;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry;
import io.split.android.client.shared.ClientComponentsRegisterImpl;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.storage.cipher.EncryptionMigrationTask;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.cipher.SplitCipherFactory;
import io.split.android.client.storage.cipher.SplitEncryptionLevel;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.storage.events.PersistentEventsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.TelemetrySynchronizer;
import io.split.android.client.telemetry.TelemetrySynchronizerImpl;
import io.split.android.client.telemetry.TelemetrySynchronizerStub;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.telemetry.storage.TelemetryStorage;
import io.split.android.client.utils.Utils;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes6.dex */
public class SplitFactoryHelper {
    private static final int DB_MAGIC_CHARS_COUNT = 4;

    public String getDatabaseName(SplitClientConfig splitClientConfig, String str, Context context) {
        String buildDatabaseName = buildDatabaseName(splitClientConfig, str);
        File databasePath = context.getDatabasePath(buildDatabaseName);
        if (databasePath.exists()) {
            return buildDatabaseName;
        }
        File databasePath2 = context.getDatabasePath(buildLegacyDatabaseName(splitClientConfig, str));
        if (databasePath2.exists()) {
            databasePath2.renameTo(databasePath);
        }
        return buildDatabaseName;
    }

    private String buildDatabaseName(SplitClientConfig splitClientConfig, String str) {
        int length = str.length();
        if (length > 4) {
            String substring = str.substring(0, 4);
            String substring2 = str.substring(length - 4);
            StringBuilder sb = new StringBuilder();
            sb.append(substring);
            sb.append(substring2);
            return sb.toString();
        }
        return splitClientConfig.defaultDataFolder();
    }

    private String buildLegacyDatabaseName(SplitClientConfig splitClientConfig, String str) {
        String convertApiKeyToFolder = Utils.convertApiKeyToFolder(str);
        return convertApiKeyToFolder == null ? splitClientConfig.defaultDataFolder() : convertApiKeyToFolder;
    }

    public Map<String, String> buildHeaders(SplitClientConfig splitClientConfig, String str) {
        SplitHttpHeadersBuilder splitHttpHeadersBuilder = new SplitHttpHeadersBuilder();
        splitHttpHeadersBuilder.addJsonTypeHeaders();
        splitHttpHeadersBuilder.setHostIp(splitClientConfig.ip());
        splitHttpHeadersBuilder.setHostname(splitClientConfig.hostname());
        splitHttpHeadersBuilder.setClientVersion(SplitClientConfig.splitSdkVersion);
        splitHttpHeadersBuilder.setApiToken(str);
        return splitHttpHeadersBuilder.build();
    }

    public Map<String, String> buildStreamingHeaders(String str) {
        SplitHttpHeadersBuilder splitHttpHeadersBuilder = new SplitHttpHeadersBuilder();
        splitHttpHeadersBuilder.addStreamingTypeHeaders();
        splitHttpHeadersBuilder.setAblyApiToken(str);
        splitHttpHeadersBuilder.setClientVersion(SplitClientConfig.splitSdkVersion);
        return splitHttpHeadersBuilder.build();
    }

    public SplitStorageContainer buildStorageContainer(UserConsent userConsent, SplitRoomDatabase splitRoomDatabase, boolean z, SplitCipher splitCipher, TelemetryStorage telemetryStorage) {
        boolean z2 = userConsent == UserConsent.GRANTED;
        PersistentEventsStorage persistentEventsStorage = StorageFactory.getPersistentEventsStorage(splitRoomDatabase, splitCipher);
        PersistentImpressionsStorage persistentImpressionsStorage = StorageFactory.getPersistentImpressionsStorage(splitRoomDatabase, splitCipher);
        return new SplitStorageContainer(StorageFactory.getSplitsStorage(splitRoomDatabase, splitCipher), StorageFactory.getMySegmentsStorage(splitRoomDatabase, splitCipher), StorageFactory.getPersistentSplitsStorage(splitRoomDatabase, splitCipher), StorageFactory.getEventsStorage(persistentEventsStorage, z2), persistentEventsStorage, StorageFactory.getImpressionsStorage(persistentImpressionsStorage, z2), persistentImpressionsStorage, StorageFactory.getPersistentImpressionsCountStorage(splitRoomDatabase, splitCipher), StorageFactory.getPersistentImpressionsUniqueStorage(splitRoomDatabase, splitCipher), StorageFactory.getAttributesStorage(), StorageFactory.getPersistentAttributesStorage(splitRoomDatabase, splitCipher), getTelemetryStorage(z, telemetryStorage));
    }

    public String buildSplitsFilterQueryString(SplitClientConfig splitClientConfig) {
        SyncConfig syncConfig = splitClientConfig.syncConfig();
        if (syncConfig != null) {
            return new FilterBuilder().addFilters(syncConfig.getFilters()).build();
        }
        return null;
    }

    public SplitApiFacade buildApiFacade(SplitClientConfig splitClientConfig, HttpClient httpClient, String str) throws URISyntaxException {
        return new SplitApiFacade(ServiceFactory.getSplitsFetcher(httpClient, splitClientConfig.endpoint(), str), new MySegmentsFetcherFactoryImpl(httpClient, splitClientConfig.endpoint()), ServiceFactory.getSseAuthenticationFetcher(httpClient, splitClientConfig.authServiceUrl()), ServiceFactory.getEventsRecorder(httpClient, splitClientConfig.eventsEndpoint()), ServiceFactory.getImpressionsRecorder(httpClient, splitClientConfig.eventsEndpoint()), ServiceFactory.getImpressionsCountRecorder(httpClient, splitClientConfig.eventsEndpoint()), ServiceFactory.getUniqueKeysRecorder(httpClient, splitClientConfig.telemetryEndpoint()), ServiceFactory.getTelemetryConfigRecorder(httpClient, splitClientConfig.telemetryEndpoint()), ServiceFactory.getTelemetryStatsRecorder(httpClient, splitClientConfig.telemetryEndpoint()));
    }

    public WorkManagerWrapper buildWorkManagerWrapper(Context context, SplitClientConfig splitClientConfig, String str, String str2) {
        WorkManager PlaceComponentResult;
        PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
        return new WorkManagerWrapper(PlaceComponentResult, splitClientConfig, str, str2);
    }

    public SyncManager buildSyncManager(SplitClientConfig splitClientConfig, SplitTaskExecutor splitTaskExecutor, Synchronizer synchronizer, TelemetrySynchronizer telemetrySynchronizer, PushNotificationManager pushNotificationManager, PushManagerEventBroadcaster pushManagerEventBroadcaster, SplitUpdatesWorker splitUpdatesWorker, SyncGuardian syncGuardian) {
        return new SyncManagerImpl(splitClientConfig, synchronizer, pushNotificationManager, splitUpdatesWorker, pushManagerEventBroadcaster, splitClientConfig.syncEnabled() ? new BackoffCounterTimer(splitTaskExecutor, new ReconnectBackoffCounter(1)) : null, syncGuardian, telemetrySynchronizer);
    }

    PushNotificationManager getPushNotificationManager(SplitTaskExecutor splitTaskExecutor, SseAuthenticator sseAuthenticator, PushManagerEventBroadcaster pushManagerEventBroadcaster, SseClient sseClient, TelemetryRuntimeProducer telemetryRuntimeProducer, long j, long j2) {
        return new PushNotificationManager(pushManagerEventBroadcaster, sseAuthenticator, sseClient, new SseRefreshTokenTimer(splitTaskExecutor, pushManagerEventBroadcaster), telemetryRuntimeProducer, j, j2, (ScheduledExecutorService) null);
    }

    public SseClient getSseClient(String str, NotificationParser notificationParser, NotificationProcessor notificationProcessor, TelemetryRuntimeProducer telemetryRuntimeProducer, PushManagerEventBroadcaster pushManagerEventBroadcaster, HttpClient httpClient) {
        return new SseClientImpl(URI.create(str), httpClient, new EventStreamParser(), new SseHandler(notificationParser, notificationProcessor, telemetryRuntimeProducer, pushManagerEventBroadcaster));
    }

    public TelemetrySynchronizer getTelemetrySynchronizer(SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, long j, boolean z) {
        if (z) {
            return new TelemetrySynchronizerImpl(splitTaskExecutor, splitTaskFactory, j);
        }
        return new TelemetrySynchronizerStub();
    }

    public ClientComponentsRegisterImpl getClientComponentsRegister(SplitClientConfig splitClientConfig, SplitTaskExecutor splitTaskExecutor, EventsManagerCoordinator eventsManagerCoordinator, Synchronizer synchronizer, NotificationParser notificationParser, NotificationProcessor notificationProcessor, SseAuthenticator sseAuthenticator, SplitStorageContainer splitStorageContainer, SyncManager syncManager, CompressionUtilProvider compressionUtilProvider) {
        MySegmentsV2PayloadDecoder mySegmentsV2PayloadDecoder = new MySegmentsV2PayloadDecoder();
        PersistentAttributesStorage persistentAttributesStorage = splitClientConfig.persistentAttributesEnabled() ? splitStorageContainer.getPersistentAttributesStorage() : null;
        return new ClientComponentsRegisterImpl(splitClientConfig, new MySegmentsSynchronizerFactoryImpl(new RetryBackoffCounterTimerFactory(), splitTaskExecutor, splitClientConfig.segmentsRefreshRate()), splitStorageContainer, new AttributesSynchronizerFactoryImpl(splitTaskExecutor, persistentAttributesStorage), (AttributesSynchronizerRegistry) synchronizer, (MySegmentsSynchronizerRegistry) synchronizer, (MySegmentsUpdateWorkerRegistry) syncManager, eventsManagerCoordinator, sseAuthenticator, notificationProcessor, splitClientConfig.syncEnabled() ? new MySegmentsNotificationProcessorFactoryImpl(notificationParser, splitTaskExecutor, mySegmentsV2PayloadDecoder, compressionUtilProvider) : null, mySegmentsV2PayloadDecoder);
    }

    public StreamingComponents buildStreamingComponents(SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, SplitClientConfig splitClientConfig, HttpClient httpClient, SplitApiFacade splitApiFacade, SplitStorageContainer splitStorageContainer) {
        if (!splitClientConfig.syncEnabled()) {
            return new StreamingComponents();
        }
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        NotificationParser notificationParser = new NotificationParser();
        NotificationProcessor notificationProcessor = new NotificationProcessor(splitTaskExecutor, splitTaskFactory, notificationParser, linkedBlockingDeque, new MySegmentsPayloadDecoder());
        PushManagerEventBroadcaster pushManagerEventBroadcaster = new PushManagerEventBroadcaster();
        SseClient sseClient = getSseClient(splitClientConfig.streamingServiceUrl(), notificationParser, notificationProcessor, splitStorageContainer.getTelemetryStorage(), pushManagerEventBroadcaster, httpClient);
        SseAuthenticator sseAuthenticator = new SseAuthenticator(splitApiFacade.getSseAuthenticationFetcher(), new SseJwtParser());
        return new StreamingComponents(getPushNotificationManager(splitTaskExecutor, sseAuthenticator, pushManagerEventBroadcaster, sseClient, splitStorageContainer.getTelemetryStorage(), splitClientConfig.defaultSSEConnectionDelay(), splitClientConfig.sseDisconnectionDelay()), linkedBlockingDeque, notificationParser, notificationProcessor, sseAuthenticator, pushManagerEventBroadcaster, new SyncGuardianImpl(splitClientConfig));
    }

    public ProcessStrategy getImpressionStrategy(SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, SplitStorageContainer splitStorageContainer, SplitClientConfig splitClientConfig) {
        return new ImpressionStrategyProvider(splitTaskExecutor, splitStorageContainer, splitTaskFactory, splitStorageContainer.getTelemetryStorage(), splitClientConfig.impressionsQueueSize(), splitClientConfig.impressionsChunkSize(), splitClientConfig.impressionsRefreshRate(), splitClientConfig.impressionsCounterRefreshRate(), splitClientConfig.mtkRefreshRate(), splitClientConfig.userConsent() == UserConsent.GRANTED).getStrategy(splitClientConfig.impressionsMode());
    }

    public SplitCipher migrateEncryption(String str, SplitRoomDatabase splitRoomDatabase, SplitTaskExecutor splitTaskExecutor, boolean z, SplitTaskExecutionListener splitTaskExecutionListener) {
        SplitEncryptionLevel splitEncryptionLevel;
        if (z) {
            splitEncryptionLevel = SplitEncryptionLevel.AES_128_CBC;
        } else {
            splitEncryptionLevel = SplitEncryptionLevel.NONE;
        }
        SplitCipher create = SplitCipherFactory.create(str, splitEncryptionLevel);
        splitTaskExecutor.submit(new EncryptionMigrationTask(str, splitRoomDatabase, z, create), splitTaskExecutionListener);
        return create;
    }

    public SplitUpdatesWorker getSplitUpdatesWorker(SplitClientConfig splitClientConfig, SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, Synchronizer synchronizer, BlockingQueue<SplitsChangeNotification> blockingQueue, SplitsStorage splitsStorage, CompressionUtilProvider compressionUtilProvider) {
        if (splitClientConfig.syncEnabled()) {
            return new SplitUpdatesWorker(synchronizer, blockingQueue, splitsStorage, compressionUtilProvider, splitTaskExecutor, splitTaskFactory);
        }
        return null;
    }

    private TelemetryStorage getTelemetryStorage(boolean z, TelemetryStorage telemetryStorage) {
        return telemetryStorage != null ? telemetryStorage : StorageFactory.getTelemetryStorage(z);
    }
}
