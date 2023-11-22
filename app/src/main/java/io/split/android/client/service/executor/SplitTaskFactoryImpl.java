package io.split.android.client.service.executor;

import com.google.common.base.Preconditions;
import io.split.android.client.FilterGrouper;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.TestingConfig;
import io.split.android.client.dtos.Split;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.service.CleanUpDatabaseTask;
import io.split.android.client.service.SplitApiFacade;
import io.split.android.client.service.events.EventsRecorderTask;
import io.split.android.client.service.events.EventsRecorderTaskConfig;
import io.split.android.client.service.impressions.ImpressionsCountPerFeature;
import io.split.android.client.service.impressions.ImpressionsCountRecorderTask;
import io.split.android.client.service.impressions.ImpressionsRecorderTask;
import io.split.android.client.service.impressions.ImpressionsRecorderTaskConfig;
import io.split.android.client.service.impressions.SaveImpressionsCountTask;
import io.split.android.client.service.impressions.unique.SaveUniqueImpressionsTask;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTask;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTaskConfig;
import io.split.android.client.service.splits.FilterSplitsInCacheTask;
import io.split.android.client.service.splits.LoadSplitsTask;
import io.split.android.client.service.splits.SplitChangeProcessor;
import io.split.android.client.service.splits.SplitInPlaceUpdateTask;
import io.split.android.client.service.splits.SplitKillTask;
import io.split.android.client.service.splits.SplitsSyncHelper;
import io.split.android.client.service.splits.SplitsSyncTask;
import io.split.android.client.service.splits.SplitsUpdateTask;
import io.split.android.client.service.sseclient.ReconnectBackoffCounter;
import io.split.android.client.service.telemetry.TelemetryConfigRecorderTask;
import io.split.android.client.service.telemetry.TelemetryStatsRecorderTask;
import io.split.android.client.service.telemetry.TelemetryTaskFactory;
import io.split.android.client.service.telemetry.TelemetryTaskFactoryImpl;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.telemetry.storage.TelemetryStorage;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class SplitTaskFactoryImpl implements SplitTaskFactory {
    private final ISplitEventsManager mEventsManager;
    private final SplitApiFacade mSplitApiFacade;
    private final SplitChangeProcessor mSplitChangeProcessor;
    private final SplitClientConfig mSplitClientConfig;
    private final String mSplitsFilterQueryString;
    private final SplitStorageContainer mSplitsStorageContainer;
    private final SplitsSyncHelper mSplitsSyncHelper;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    private final TelemetryTaskFactory mTelemetryTaskFactory;

    public SplitTaskFactoryImpl(SplitClientConfig splitClientConfig, SplitApiFacade splitApiFacade, SplitStorageContainer splitStorageContainer, String str, ISplitEventsManager iSplitEventsManager, TestingConfig testingConfig) {
        this.mSplitClientConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        SplitApiFacade splitApiFacade2 = (SplitApiFacade) Preconditions.checkNotNull(splitApiFacade);
        this.mSplitApiFacade = splitApiFacade2;
        SplitStorageContainer splitStorageContainer2 = (SplitStorageContainer) Preconditions.checkNotNull(splitStorageContainer);
        this.mSplitsStorageContainer = splitStorageContainer2;
        this.mSplitsFilterQueryString = str;
        this.mEventsManager = iSplitEventsManager;
        SplitChangeProcessor splitChangeProcessor = new SplitChangeProcessor();
        this.mSplitChangeProcessor = splitChangeProcessor;
        TelemetryStorage telemetryStorage = splitStorageContainer2.getTelemetryStorage();
        this.mTelemetryRuntimeProducer = telemetryStorage;
        if (testingConfig != null) {
            this.mSplitsSyncHelper = new SplitsSyncHelper(splitApiFacade2.getSplitFetcher(), splitStorageContainer2.getSplitsStorage(), splitChangeProcessor, telemetryStorage, new ReconnectBackoffCounter(1, testingConfig.getCdnBackoffTime()));
        } else {
            this.mSplitsSyncHelper = new SplitsSyncHelper(splitApiFacade2.getSplitFetcher(), splitStorageContainer2.getSplitsStorage(), new SplitChangeProcessor(), telemetryStorage);
        }
        this.mTelemetryTaskFactory = new TelemetryTaskFactoryImpl(splitApiFacade2.getTelemetryConfigRecorder(), splitApiFacade2.getTelemetryStatsRecorder(), telemetryStorage, splitClientConfig, splitStorageContainer2.getSplitsStorage(), splitStorageContainer2.getMySegmentsStorageContainer());
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public EventsRecorderTask createEventsRecorderTask() {
        return new EventsRecorderTask(this.mSplitApiFacade.getEventsRecorder(), this.mSplitsStorageContainer.getPersistentEventsStorage(), new EventsRecorderTaskConfig(this.mSplitClientConfig.eventsPerPush()), this.mSplitsStorageContainer.getTelemetryStorage());
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public ImpressionsRecorderTask createImpressionsRecorderTask() {
        return new ImpressionsRecorderTask(this.mSplitApiFacade.getImpressionsRecorder(), this.mSplitsStorageContainer.getPersistentImpressionsStorage(), new ImpressionsRecorderTaskConfig(this.mSplitClientConfig.impressionsPerPush(), 150L, this.mSplitClientConfig.shouldRecordTelemetry()), this.mSplitsStorageContainer.getTelemetryStorage());
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public SplitsSyncTask createSplitsSyncTask(boolean z) {
        return SplitsSyncTask.build(this.mSplitsSyncHelper, this.mSplitsStorageContainer.getSplitsStorage(), z, this.mSplitClientConfig.cacheExpirationInSeconds(), this.mSplitsFilterQueryString, this.mEventsManager, this.mSplitsStorageContainer.getTelemetryStorage());
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public LoadSplitsTask createLoadSplitsTask() {
        return new LoadSplitsTask(this.mSplitsStorageContainer.getSplitsStorage());
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public SplitKillTask createSplitKillTask(Split split) {
        return new SplitKillTask(this.mSplitsStorageContainer.getSplitsStorage(), split, this.mEventsManager);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public SplitsUpdateTask createSplitsUpdateTask(long j) {
        return new SplitsUpdateTask(this.mSplitsSyncHelper, this.mSplitsStorageContainer.getSplitsStorage(), j, this.mEventsManager);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public FilterSplitsInCacheTask createFilterSplitsInCacheTask() {
        return new FilterSplitsInCacheTask(this.mSplitsStorageContainer.getPersistentSplitsStorage(), new FilterGrouper().group(this.mSplitClientConfig.syncConfig().getFilters()), this.mSplitsFilterQueryString);
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public CleanUpDatabaseTask createCleanUpDatabaseTask(long j) {
        return new CleanUpDatabaseTask(this.mSplitsStorageContainer.getPersistentEventsStorage(), this.mSplitsStorageContainer.getPersistentImpressionsStorage(), this.mSplitsStorageContainer.getImpressionsCountStorage(), this.mSplitsStorageContainer.getPersistentImpressionsUniqueStorage(), j);
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public SaveImpressionsCountTask createSaveImpressionsCountTask(List<ImpressionsCountPerFeature> list) {
        return new SaveImpressionsCountTask(this.mSplitsStorageContainer.getImpressionsCountStorage(), list);
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public ImpressionsCountRecorderTask createImpressionsCountRecorderTask() {
        return new ImpressionsCountRecorderTask(this.mSplitApiFacade.getImpressionsCountRecorder(), this.mSplitsStorageContainer.getImpressionsCountStorage(), this.mSplitsStorageContainer.getTelemetryStorage());
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public SaveUniqueImpressionsTask createSaveUniqueImpressionsTask(Map<String, Set<String>> map) {
        return new SaveUniqueImpressionsTask(this.mSplitsStorageContainer.getPersistentImpressionsUniqueStorage(), map);
    }

    @Override // io.split.android.client.service.impressions.ImpressionsTaskFactory
    public UniqueKeysRecorderTask createUniqueImpressionsRecorderTask() {
        return new UniqueKeysRecorderTask(this.mSplitApiFacade.getUniqueKeysRecorder(), this.mSplitsStorageContainer.getPersistentImpressionsUniqueStorage(), new UniqueKeysRecorderTaskConfig(this.mSplitClientConfig.mtkPerPush(), 150L));
    }

    @Override // io.split.android.client.service.telemetry.TelemetryTaskFactory
    public TelemetryConfigRecorderTask getTelemetryConfigRecorderTask() {
        return this.mTelemetryTaskFactory.getTelemetryConfigRecorderTask();
    }

    @Override // io.split.android.client.service.telemetry.TelemetryTaskFactory
    public TelemetryStatsRecorderTask getTelemetryStatsRecorderTask() {
        return this.mTelemetryTaskFactory.getTelemetryStatsRecorderTask();
    }

    @Override // io.split.android.client.service.executor.SplitTaskFactory
    public SplitInPlaceUpdateTask createSplitsUpdateTask(Split split, long j) {
        return new SplitInPlaceUpdateTask(this.mSplitsStorageContainer.getSplitsStorage(), this.mSplitChangeProcessor, this.mEventsManager, this.mTelemetryRuntimeProducer, split, j);
    }
}
