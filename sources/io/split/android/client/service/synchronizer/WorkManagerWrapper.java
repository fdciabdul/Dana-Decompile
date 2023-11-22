package io.split.android.client.service.synchronizer;

import androidx.view.Observer;
import androidx.view.ProcessLifecycleOwner;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.google.common.base.Preconditions;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.impressions.ImpressionManagerConfig;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsWorkManagerWrapper;
import io.split.android.client.service.workmanager.EventsRecorderWorker;
import io.split.android.client.service.workmanager.ImpressionsRecorderWorker;
import io.split.android.client.service.workmanager.MySegmentsSyncWorker;
import io.split.android.client.service.workmanager.SplitsSyncWorker;
import io.split.android.client.service.workmanager.UniqueKeysRecorderWorker;
import io.split.android.client.utils.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class WorkManagerWrapper implements MySegmentsWorkManagerWrapper {
    private final String mApiKey;
    private final String mDatabaseName;
    private WeakReference<SplitTaskExecutionListener> mFetcherExecutionListener;
    private final SplitClientConfig mSplitClientConfig;
    private final WorkManager mWorkManager;
    private final Set<String> mShouldLoadFromLocal = new HashSet();
    private final Constraints mConstraints = buildConstraints();

    public WorkManagerWrapper(WorkManager workManager, SplitClientConfig splitClientConfig, String str, String str2) {
        this.mWorkManager = (WorkManager) Preconditions.checkNotNull(workManager);
        this.mDatabaseName = (String) Preconditions.checkNotNull(str2);
        this.mSplitClientConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        this.mApiKey = (String) Preconditions.checkNotNull(str);
    }

    public void setFetcherExecutionListener(SplitTaskExecutionListener splitTaskExecutionListener) {
        this.mFetcherExecutionListener = new WeakReference<>(splitTaskExecutionListener);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsWorkManagerWrapper
    public void removeWork() {
        this.mWorkManager.MyBillsEntityDataFactory(SplitTaskType.SPLITS_SYNC.toString());
        this.mWorkManager.MyBillsEntityDataFactory(SplitTaskType.MY_SEGMENTS_SYNC.toString());
        this.mWorkManager.MyBillsEntityDataFactory(SplitTaskType.EVENTS_RECORDER.toString());
        this.mWorkManager.MyBillsEntityDataFactory(SplitTaskType.IMPRESSIONS_RECORDER.toString());
        this.mWorkManager.MyBillsEntityDataFactory(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK.toString());
        WeakReference<SplitTaskExecutionListener> weakReference = this.mFetcherExecutionListener;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public void scheduleWork() {
        scheduleWork(SplitTaskType.SPLITS_SYNC.toString(), SplitsSyncWorker.class, buildSplitSyncInputData());
        scheduleWork(SplitTaskType.EVENTS_RECORDER.toString(), EventsRecorderWorker.class, buildEventsRecorderInputData());
        scheduleWork(SplitTaskType.IMPRESSIONS_RECORDER.toString(), ImpressionsRecorderWorker.class, buildImpressionsRecorderInputData());
        if (isNoneImpressionsMode()) {
            scheduleWork(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK.toString(), UniqueKeysRecorderWorker.class, buildUniqueKeysRecorderInputData());
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsWorkManagerWrapper
    public void scheduleMySegmentsWork(Set<String> set) {
        scheduleWork(SplitTaskType.MY_SEGMENTS_SYNC.toString(), MySegmentsSyncWorker.class, buildMySegmentsSyncInputData(set));
    }

    private void scheduleWork(String str, Class<? extends ListenableWorker> cls, Data data) {
        PeriodicWorkRequest.Builder builder = new PeriodicWorkRequest.Builder(cls, this.mSplitClientConfig.backgroundSyncPeriod(), TimeUnit.MINUTES);
        builder.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = buildInputData(data);
        PeriodicWorkRequest.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = this.mConstraints;
        this.mWorkManager.KClassImpl$Data$declaredNonStaticMembers$2(str, ExistingPeriodicWorkPolicy.REPLACE, MyBillsEntityDataFactory.MyBillsEntityDataFactory().MyBillsEntityDataFactory(15L, TimeUnit.MINUTES).KClassImpl$Data$declaredNonStaticMembers$2());
        observeWorkState(cls.getCanonicalName());
    }

    private void observeWorkState(final String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Adding work manager observer for request id ");
        sb.append(str);
        Logger.d(sb.toString());
        ThreadUtils.runInMainThread(new Runnable() { // from class: io.split.android.client.service.synchronizer.WorkManagerWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                WorkManagerWrapper.this.mWorkManager.BuiltInFictitiousFunctionClassFactory(str).PlaceComponentResult(ProcessLifecycleOwner.PlaceComponentResult(), new Observer<List<WorkInfo>>() { // from class: io.split.android.client.service.synchronizer.WorkManagerWrapper.1.1
                    @Override // androidx.view.Observer
                    public void onChanged(List<WorkInfo> list) {
                        if (list == null) {
                            return;
                        }
                        for (WorkInfo workInfo : list) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Work manager task: ");
                            sb2.append(workInfo.PlaceComponentResult);
                            sb2.append(", state: ");
                            sb2.append(workInfo.KClassImpl$Data$declaredNonStaticMembers$2);
                            Logger.d(sb2.toString());
                            WorkManagerWrapper.this.updateTaskStatus(workInfo);
                        }
                    }
                });
            }
        });
    }

    private Data buildInputData(Data data) {
        Data.Builder builder = new Data.Builder();
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_DATABASE_NAME, this.mDatabaseName);
        builder.MyBillsEntityDataFactory.put("apiKey", this.mApiKey);
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED, Boolean.valueOf(this.mSplitClientConfig.encryptionEnabled()));
        if (data != null) {
            builder.BuiltInFictitiousFunctionClassFactory(data.MyBillsEntityDataFactory);
        }
        Data data2 = new Data(builder.MyBillsEntityDataFactory);
        Data.getAuthRequestContext(data2);
        return data2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTaskStatus(WorkInfo workInfo) {
        SplitTaskType taskTypeFromTags;
        if (this.mFetcherExecutionListener == null || workInfo == null || workInfo.PlaceComponentResult == null || !WorkInfo.State.ENQUEUED.equals(workInfo.KClassImpl$Data$declaredNonStaticMembers$2) || (taskTypeFromTags = taskTypeFromTags(workInfo.PlaceComponentResult)) == null) {
            return;
        }
        if (!this.mShouldLoadFromLocal.contains(taskTypeFromTags.toString())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Avoiding update for ");
            sb.append(taskTypeFromTags);
            Logger.d(sb.toString());
            this.mShouldLoadFromLocal.add(taskTypeFromTags.toString());
            return;
        }
        SplitTaskExecutionListener splitTaskExecutionListener = this.mFetcherExecutionListener.get();
        if (splitTaskExecutionListener != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Updating for ");
            sb2.append(taskTypeFromTags);
            Logger.d(sb2.toString());
            splitTaskExecutionListener.taskExecuted(SplitTaskExecutionInfo.success(taskTypeFromTags));
        }
    }

    private SplitTaskType taskTypeFromTags(Set<String> set) {
        if (set.contains(SplitsSyncWorker.class.getCanonicalName())) {
            return SplitTaskType.SPLITS_SYNC;
        }
        if (set.contains(MySegmentsSyncWorker.class.getCanonicalName())) {
            return SplitTaskType.MY_SEGMENTS_SYNC;
        }
        return null;
    }

    private Data buildSplitSyncInputData() {
        Data.Builder builder = new Data.Builder();
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_SPLIT_CACHE_EXPIRATION, Long.valueOf(this.mSplitClientConfig.cacheExpirationInSeconds()));
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.endpoint());
        builder.MyBillsEntityDataFactory.put(ServiceConstants.SHOULD_RECORD_TELEMETRY, Boolean.valueOf(this.mSplitClientConfig.shouldRecordTelemetry()));
        Data data = new Data(builder.MyBillsEntityDataFactory);
        Data.getAuthRequestContext(data);
        return buildInputData(data);
    }

    private Data buildMySegmentsSyncInputData(Set<String> set) {
        Data.Builder builder = new Data.Builder();
        String[] strArr = new String[set.size()];
        set.toArray(strArr);
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.endpoint());
        builder.MyBillsEntityDataFactory.put("key", strArr);
        builder.MyBillsEntityDataFactory.put(ServiceConstants.SHOULD_RECORD_TELEMETRY, Boolean.valueOf(this.mSplitClientConfig.shouldRecordTelemetry()));
        Data data = new Data(builder.MyBillsEntityDataFactory);
        Data.getAuthRequestContext(data);
        return buildInputData(data);
    }

    private Data buildEventsRecorderInputData() {
        Data.Builder builder = new Data.Builder();
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.eventsEndpoint());
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_EVENTS_PER_PUSH, Integer.valueOf(this.mSplitClientConfig.eventsPerPush()));
        builder.MyBillsEntityDataFactory.put(ServiceConstants.SHOULD_RECORD_TELEMETRY, Boolean.valueOf(this.mSplitClientConfig.shouldRecordTelemetry()));
        Data data = new Data(builder.MyBillsEntityDataFactory);
        Data.getAuthRequestContext(data);
        return buildInputData(data);
    }

    private Data buildImpressionsRecorderInputData() {
        Data.Builder builder = new Data.Builder();
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.eventsEndpoint());
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_IMPRESSIONS_PER_PUSH, Integer.valueOf(this.mSplitClientConfig.impressionsPerPush()));
        builder.MyBillsEntityDataFactory.put(ServiceConstants.SHOULD_RECORD_TELEMETRY, Boolean.valueOf(this.mSplitClientConfig.shouldRecordTelemetry()));
        Data data = new Data(builder.MyBillsEntityDataFactory);
        Data.getAuthRequestContext(data);
        return buildInputData(data);
    }

    private Data buildUniqueKeysRecorderInputData() {
        Data.Builder builder = new Data.Builder();
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.telemetryEndpoint());
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_UNIQUE_KEYS_PER_PUSH, Integer.valueOf(this.mSplitClientConfig.mtkPerPush()));
        builder.MyBillsEntityDataFactory.put(ServiceConstants.WORKER_PARAM_UNIQUE_KEYS_ESTIMATED_SIZE_IN_BYTES, 150L);
        Data data = new Data(builder.MyBillsEntityDataFactory);
        Data.getAuthRequestContext(data);
        return buildInputData(data);
    }

    private Constraints buildConstraints() {
        Constraints.Builder builder = new Constraints.Builder();
        builder.PlaceComponentResult = this.mSplitClientConfig.backgroundSyncWhenBatteryWifiOnly() ? NetworkType.UNMETERED : NetworkType.CONNECTED;
        builder.MyBillsEntityDataFactory = this.mSplitClientConfig.backgroundSyncWhenBatteryNotLow();
        return new Constraints(builder);
    }

    private boolean isNoneImpressionsMode() {
        return ImpressionManagerConfig.Mode.fromImpressionMode(this.mSplitClientConfig.impressionsMode()).isNone();
    }
}
