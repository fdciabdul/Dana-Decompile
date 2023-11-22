package io.split.android.client;

import android.content.Context;
import io.split.android.client.api.Key;
import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.events.EventsManagerCoordinator;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.factory.FactoryMonitor;
import io.split.android.client.factory.FactoryMonitorImpl;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.impressions.SyncImpressionListener;
import io.split.android.client.lifecycle.SplitLifecycleManager;
import io.split.android.client.lifecycle.SplitLifecycleManagerImpl;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpClientImpl;
import io.split.android.client.service.SplitApiFacade;
import io.split.android.client.service.executor.SplitSingleThreadTaskExecutor;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskExecutorImpl;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.executor.SplitTaskFactoryImpl;
import io.split.android.client.service.impressions.StrategyImpressionManager;
import io.split.android.client.service.sseclient.sseclient.StreamingComponents;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.service.synchronizer.SynchronizerImpl;
import io.split.android.client.service.synchronizer.SynchronizerSpy;
import io.split.android.client.service.synchronizer.WorkManagerWrapper;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistryImpl;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.shared.SplitClientContainerImpl;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.telemetry.TelemetrySynchronizer;
import io.split.android.client.telemetry.storage.TelemetryStorage;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.ApiKeyValidatorImpl;
import io.split.android.client.validators.EventValidatorImpl;
import io.split.android.client.validators.KeyValidatorImpl;
import io.split.android.client.validators.SplitValidatorImpl;
import io.split.android.client.validators.ValidationConfig;
import io.split.android.client.validators.ValidationErrorInfo;
import io.split.android.client.validators.ValidationMessageLoggerImpl;
import io.split.android.engine.experiments.SplitParser;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class SplitFactoryImpl implements SplitFactory {
    private final String mApiKey;
    private final SplitClientContainer mClientContainer;
    private final Key mDefaultClientKey;
    private final Runnable mDestroyer;
    private final FactoryMonitor mFactoryMonitor;
    private boolean mIsTerminated;
    private final SplitLifecycleManager mLifecycleManager;
    private final SplitManager mManager;
    private final SplitTaskExecutionListener mMigrationExecutionListener;
    private final SplitStorageContainer mStorageContainer;
    private final SyncManager mSyncManager;
    private final UserConsentManager mUserConsentManager;

    public SplitFactoryImpl(String str, Key key, SplitClientConfig splitClientConfig, Context context) throws URISyntaxException {
        this(str, key, splitClientConfig, context, null, null, null, null, null, null);
    }

    private SplitFactoryImpl(String str, Key key, SplitClientConfig splitClientConfig, Context context, HttpClient httpClient, SplitRoomDatabase splitRoomDatabase, SynchronizerSpy synchronizerSpy, TestingConfig testingConfig, SplitLifecycleManager splitLifecycleManager, TelemetryStorage telemetryStorage) throws URISyntaxException {
        KeyValidatorImpl keyValidatorImpl;
        SplitRoomDatabase splitRoomDatabase2 = splitRoomDatabase;
        this.mIsTerminated = false;
        FactoryMonitor sharedInstance = FactoryMonitorImpl.getSharedInstance();
        this.mFactoryMonitor = sharedInstance;
        this.mDefaultClientKey = key;
        final long currentTimeMillis = System.currentTimeMillis();
        SplitFactoryHelper splitFactoryHelper = new SplitFactoryHelper();
        setupValidations(splitClientConfig);
        ApiKeyValidatorImpl apiKeyValidatorImpl = new ApiKeyValidatorImpl();
        KeyValidatorImpl keyValidatorImpl2 = new KeyValidatorImpl();
        ValidationMessageLoggerImpl validationMessageLoggerImpl = new ValidationMessageLoggerImpl();
        HttpClient build = httpClient == null ? new HttpClientImpl.Builder().setConnectionTimeout(splitClientConfig.connectionTimeout()).setReadTimeout(splitClientConfig.readTimeout()).setProxy(splitClientConfig.proxy()).setDevelopmentSslConfig(splitClientConfig.developmentSslConfig()).setContext(context).setProxyAuthenticator(splitClientConfig.authenticator()).build() : httpClient;
        ValidationErrorInfo validate = keyValidatorImpl2.validate(key.matchingKey(), key.bucketingKey());
        if (validate != null) {
            validationMessageLoggerImpl.log(validate, "factory instantiation");
        }
        ValidationErrorInfo validate2 = apiKeyValidatorImpl.validate(str);
        if (validate2 != null) {
            validationMessageLoggerImpl.log(validate2, "factory instantiation");
        }
        int count = sharedInstance.count(str);
        if (count > 0) {
            StringBuilder sb = new StringBuilder();
            keyValidatorImpl = keyValidatorImpl2;
            sb.append("You already have ");
            sb.append(count);
            sb.append(count == 1 ? " factory" : " factories");
            sb.append(" with this SDK Key. We recommend keeping only one instance of the factory at all times (Singleton pattern) and reusing it throughout your application.");
            validationMessageLoggerImpl.w(sb.toString(), "factory instantiation");
        } else {
            keyValidatorImpl = keyValidatorImpl2;
            if (sharedInstance.count() > 0) {
                validationMessageLoggerImpl.w("You already have an instance of the Split factory. Make sure you definitely want this additional instance. We recommend keeping only one instance of the factory at all times (Singleton pattern) and reusing it throughout your application.", "factory instantiation");
            }
        }
        sharedInstance.add(str);
        this.mApiKey = str;
        String databaseName = splitFactoryHelper.getDatabaseName(splitClientConfig, str, context);
        if (splitRoomDatabase2 == null) {
            splitRoomDatabase2 = SplitRoomDatabase.getDatabase(context, databaseName);
        } else {
            Logger.d("Using test database");
            PrintStream printStream = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("USING TEST DB: ");
            sb2.append(splitRoomDatabase2);
            printStream.println(sb2.toString());
        }
        SplitRoomDatabase splitRoomDatabase3 = splitRoomDatabase2;
        build.addHeaders(splitFactoryHelper.buildHeaders(splitClientConfig, str));
        build.addStreamingHeaders(splitFactoryHelper.buildStreamingHeaders(str));
        final SplitTaskExecutorImpl splitTaskExecutorImpl = new SplitTaskExecutorImpl();
        final EventsManagerCoordinator eventsManagerCoordinator = new EventsManagerCoordinator();
        SplitTaskExecutionListener splitTaskExecutionListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.SplitFactoryImpl.1
            {
                SplitFactoryImpl.this = this;
            }

            @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
            public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
                eventsManagerCoordinator.notifyInternalEvent(SplitInternalEvent.ENCRYPTION_MIGRATION_DONE);
            }
        };
        this.mMigrationExecutionListener = splitTaskExecutionListener;
        final HttpClient httpClient2 = build;
        SplitStorageContainer buildStorageContainer = splitFactoryHelper.buildStorageContainer(splitClientConfig.userConsent(), splitRoomDatabase3, splitClientConfig.shouldRecordTelemetry(), splitFactoryHelper.migrateEncryption(str, splitRoomDatabase3, splitTaskExecutorImpl, splitClientConfig.encryptionEnabled(), splitTaskExecutionListener), telemetryStorage);
        this.mStorageContainer = buildStorageContainer;
        String buildSplitsFilterQueryString = splitFactoryHelper.buildSplitsFilterQueryString(splitClientConfig);
        SplitApiFacade buildApiFacade = splitFactoryHelper.buildApiFacade(splitClientConfig, httpClient2, buildSplitsFilterQueryString);
        SplitTaskFactoryImpl splitTaskFactoryImpl = new SplitTaskFactoryImpl(splitClientConfig, buildApiFacade, buildStorageContainer, buildSplitsFilterQueryString, eventsManagerCoordinator, testingConfig);
        cleanUpDabase(splitTaskExecutorImpl, splitTaskFactoryImpl);
        WorkManagerWrapper buildWorkManagerWrapper = splitFactoryHelper.buildWorkManagerWrapper(context, splitClientConfig, str, databaseName);
        final SplitSingleThreadTaskExecutor splitSingleThreadTaskExecutor = new SplitSingleThreadTaskExecutor();
        StrategyImpressionManager strategyImpressionManager = new StrategyImpressionManager(splitFactoryHelper.getImpressionStrategy(splitTaskExecutorImpl, splitTaskFactoryImpl, buildStorageContainer, splitClientConfig));
        RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory = new RetryBackoffCounterTimerFactory();
        StreamingComponents buildStreamingComponents = splitFactoryHelper.buildStreamingComponents(splitTaskExecutorImpl, splitTaskFactoryImpl, splitClientConfig, httpClient2, buildApiFacade, buildStorageContainer);
        SynchronizerImpl synchronizerImpl = r6;
        SynchronizerImpl synchronizerImpl2 = new SynchronizerImpl(splitClientConfig, splitTaskExecutorImpl, splitSingleThreadTaskExecutor, splitTaskFactoryImpl, buildWorkManagerWrapper, retryBackoffCounterTimerFactory, buildStorageContainer.getTelemetryStorage(), new AttributesSynchronizerRegistryImpl(), new MySegmentsSynchronizerRegistryImpl(), strategyImpressionManager, buildStorageContainer.getEventsStorage(), eventsManagerCoordinator, buildStreamingComponents.getPushManagerEventBroadcaster());
        if (synchronizerSpy != null) {
            synchronizerSpy.setSynchronizer(synchronizerImpl);
            synchronizerImpl = synchronizerSpy;
        }
        CompressionUtilProvider compressionUtilProvider = new CompressionUtilProvider();
        final TelemetrySynchronizer telemetrySynchronizer = splitFactoryHelper.getTelemetrySynchronizer(splitTaskExecutorImpl, splitTaskFactoryImpl, splitClientConfig.telemetryRefreshRate(), splitClientConfig.shouldRecordTelemetry());
        SyncManager buildSyncManager = splitFactoryHelper.buildSyncManager(splitClientConfig, splitTaskExecutorImpl, synchronizerImpl, telemetrySynchronizer, buildStreamingComponents.getPushNotificationManager(), buildStreamingComponents.getPushManagerEventBroadcaster(), splitFactoryHelper.getSplitUpdatesWorker(splitClientConfig, splitTaskExecutorImpl, splitTaskFactoryImpl, synchronizerImpl, buildStreamingComponents.getSplitsUpdateNotificationQueue(), buildStorageContainer.getSplitsStorage(), compressionUtilProvider), buildStreamingComponents.getSyncGuardian());
        this.mSyncManager = buildSyncManager;
        if (splitLifecycleManager == null) {
            this.mLifecycleManager = new SplitLifecycleManagerImpl();
        } else {
            this.mLifecycleManager = splitLifecycleManager;
        }
        this.mLifecycleManager.register(buildSyncManager);
        ImpressionListener syncImpressionListener = new SyncImpressionListener(buildSyncManager);
        if (splitClientConfig.impressionListener() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(syncImpressionListener);
            arrayList.add(splitClientConfig.impressionListener());
            syncImpressionListener = new ImpressionListener.FederatedImpressionListener(arrayList);
        }
        final ImpressionListener impressionListener = syncImpressionListener;
        EventsTracker buildEventsTracker = buildEventsTracker();
        this.mUserConsentManager = new UserConsentManagerImpl(splitClientConfig, buildStorageContainer.getImpressionsStorage(), buildStorageContainer.getEventsStorage(), buildSyncManager, buildEventsTracker, strategyImpressionManager, splitTaskExecutorImpl);
        this.mClientContainer = new SplitClientContainerImpl(key.matchingKey(), this, splitClientConfig, buildSyncManager, telemetrySynchronizer, buildStorageContainer, splitTaskExecutorImpl, buildApiFacade, validationMessageLoggerImpl, keyValidatorImpl, impressionListener, buildStreamingComponents.getPushNotificationManager(), splitFactoryHelper.getClientComponentsRegister(splitClientConfig, splitTaskExecutorImpl, eventsManagerCoordinator, synchronizerImpl, buildStreamingComponents.getNotificationParser(), buildStreamingComponents.getNotificationProcessor(), buildStreamingComponents.getSseAuthenticator(), buildStorageContainer, buildSyncManager, compressionUtilProvider), buildWorkManagerWrapper, buildEventsTracker);
        this.mDestroyer = new Runnable() { // from class: io.split.android.client.SplitFactoryImpl.2
            {
                SplitFactoryImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.w("Shutdown called for split");
                try {
                    try {
                        SplitFactoryImpl.this.mStorageContainer.getTelemetryStorage().recordSessionLength(System.currentTimeMillis() - currentTimeMillis);
                        telemetrySynchronizer.flush();
                        telemetrySynchronizer.destroy();
                        Logger.d("Successful shutdown of telemetry");
                        SplitFactoryImpl.this.mSyncManager.stop();
                        Logger.d("Flushing impressions and events");
                        SplitFactoryImpl.this.mLifecycleManager.destroy();
                        Logger.d("Successful shutdown of lifecycle manager");
                        SplitFactoryImpl.this.mFactoryMonitor.remove(SplitFactoryImpl.this.mApiKey);
                        Logger.d("Successful shutdown of segment fetchers");
                        impressionListener.close();
                        Logger.d("Successful shutdown of ImpressionListener");
                        httpClient2.close();
                        Logger.d("Successful shutdown of httpclient");
                        SplitFactoryImpl.this.mManager.destroy();
                        Logger.d("Successful shutdown of manager");
                        splitTaskExecutorImpl.stop();
                        splitSingleThreadTaskExecutor.stop();
                        Logger.d("Successful shutdown of task executor");
                        SplitFactoryImpl.this.mStorageContainer.getAttributesStorageContainer().destroy();
                        Logger.d("Successful shutdown of attributes storage");
                    } catch (Exception e) {
                        Logger.e(e, "We could not shutdown split", new Object[0]);
                    }
                } finally {
                    SplitFactoryImpl.this.mIsTerminated = true;
                }
            }
        };
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: io.split.android.client.SplitFactoryImpl.3
            {
                SplitFactoryImpl.this = this;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SplitFactoryImpl.this.destroy();
            }
        });
        client();
        this.mManager = new SplitManagerImpl(buildStorageContainer.getSplitsStorage(), new SplitValidatorImpl(), new SplitParser(buildStorageContainer.getMySegmentsStorageContainer()));
        buildSyncManager.start();
        if (splitClientConfig.shouldRecordTelemetry()) {
            int count2 = sharedInstance.count(str);
            buildStorageContainer.getTelemetryStorage().recordActiveFactories(count2);
            buildStorageContainer.getTelemetryStorage().recordRedundantFactories(count2 - 1);
        }
        Logger.i("Android SDK initialized!");
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client() {
        return client(this.mDefaultClientKey);
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(Key key) {
        return this.mClientContainer.getClient(key);
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(String str) {
        return this.mClientContainer.getClient(new Key(str));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(String str, String str2) {
        return this.mClientContainer.getClient(new Key(str, str2));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitManager manager() {
        return this.mManager;
    }

    @Override // io.split.android.client.SplitFactory
    public void destroy() {
        synchronized (SplitFactoryImpl.class) {
            if (!this.mIsTerminated) {
                new Thread(this.mDestroyer).start();
            }
        }
    }

    @Override // io.split.android.client.SplitFactory
    public void flush() {
        this.mSyncManager.flush();
    }

    @Override // io.split.android.client.SplitFactory
    public void setUserConsent(boolean z) {
        UserConsent userConsent = z ? UserConsent.GRANTED : UserConsent.DECLINED;
        UserConsentManager userConsentManager = this.mUserConsentManager;
        if (userConsentManager == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("User consent manager not initialized. Unable to set mode ");
            sb.append(userConsent.toString());
            Logger.e(sb.toString());
            return;
        }
        userConsentManager.setStatus(userConsent);
    }

    @Override // io.split.android.client.SplitFactory
    public UserConsent getUserConsent() {
        return this.mUserConsentManager.getStatus();
    }

    private void setupValidations(SplitClientConfig splitClientConfig) {
        ValidationConfig.getInstance().setMaximumKeyLength(splitClientConfig.maximumKeyLength());
        ValidationConfig.getInstance().setTrackEventNamePattern(splitClientConfig.trackEventNamePattern());
    }

    private void cleanUpDabase(SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory) {
        splitTaskExecutor.submit(splitTaskFactory.createCleanUpDatabaseTask(System.currentTimeMillis() / 1000), null);
    }

    private EventsTracker buildEventsTracker() {
        return new EventsTrackerImpl(new EventValidatorImpl(new KeyValidatorImpl(), this.mStorageContainer.getSplitsStorage()), new ValidationMessageLoggerImpl(), this.mStorageContainer.getTelemetryStorage(), new EventPropertiesProcessorImpl(), this.mSyncManager);
    }
}
