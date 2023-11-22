package io.split.android.client.service.impressions.strategy;

import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.impressions.ImpressionManagerRetryTimerProviderImpl;
import io.split.android.client.service.impressions.ImpressionsCounter;
import io.split.android.client.service.impressions.ImpressionsMode;
import io.split.android.client.service.impressions.ImpressionsObserver;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.impressions.unique.UniqueKeysTrackerImpl;
import io.split.android.client.service.synchronizer.RecorderSyncHelperImpl;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;

/* loaded from: classes6.dex */
public class ImpressionStrategyProvider {
    private final long mImpressionsChunkSize;
    private final int mImpressionsCounterRefreshRate;
    private final int mImpressionsQueueSize;
    private final int mImpressionsRefreshRate;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final ImpressionsTaskFactory mSplitTaskFactory;
    private final SplitStorageContainer mStorageContainer;
    private final TelemetryRuntimeProducer mTelemetryStorage;
    private final int mUniqueKeysRefreshRate;
    private final boolean mUserConsentIsGranted;

    public ImpressionStrategyProvider(SplitTaskExecutor splitTaskExecutor, SplitStorageContainer splitStorageContainer, ImpressionsTaskFactory impressionsTaskFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, int i, long j, int i2, int i3, int i4, boolean z) {
        this.mSplitTaskExecutor = splitTaskExecutor;
        this.mStorageContainer = splitStorageContainer;
        this.mSplitTaskFactory = impressionsTaskFactory;
        this.mTelemetryStorage = telemetryRuntimeProducer;
        this.mImpressionsQueueSize = i;
        this.mImpressionsChunkSize = j;
        this.mImpressionsRefreshRate = i2;
        this.mImpressionsCounterRefreshRate = i3;
        this.mUniqueKeysRefreshRate = i4;
        this.mUserConsentIsGranted = z;
    }

    /* renamed from: io.split.android.client.service.impressions.strategy.ImpressionStrategyProvider$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$impressions$ImpressionsMode;

        static {
            int[] iArr = new int[ImpressionsMode.values().length];
            $SwitchMap$io$split$android$client$service$impressions$ImpressionsMode = iArr;
            try {
                iArr[ImpressionsMode.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$impressions$ImpressionsMode[ImpressionsMode.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ProcessStrategy getStrategy(ImpressionsMode impressionsMode) {
        ImpressionManagerRetryTimerProviderImpl impressionManagerRetryTimerProviderImpl = new ImpressionManagerRetryTimerProviderImpl(this.mSplitTaskExecutor);
        int i = AnonymousClass1.$SwitchMap$io$split$android$client$service$impressions$ImpressionsMode[impressionsMode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new NoneStrategy(this.mSplitTaskExecutor, this.mSplitTaskFactory, new ImpressionsCounter(), new UniqueKeysTrackerImpl(), impressionManagerRetryTimerProviderImpl.getImpressionsCountTimer(), impressionManagerRetryTimerProviderImpl.getUniqueKeysTimer(), this.mImpressionsCounterRefreshRate, this.mUniqueKeysRefreshRate, this.mUserConsentIsGranted);
            }
            return new OptimizedStrategy(new ImpressionsObserver(500L), new ImpressionsCounter(), new RecorderSyncHelperImpl(SplitTaskType.IMPRESSIONS_RECORDER, this.mStorageContainer.getImpressionsStorage(), this.mImpressionsQueueSize, this.mImpressionsChunkSize, this.mSplitTaskExecutor), this.mSplitTaskExecutor, this.mSplitTaskFactory, this.mTelemetryStorage, impressionManagerRetryTimerProviderImpl.getImpressionsTimer(), impressionManagerRetryTimerProviderImpl.getImpressionsCountTimer(), this.mImpressionsRefreshRate, this.mImpressionsCounterRefreshRate, this.mUserConsentIsGranted);
        }
        return new DebugStrategy(new RecorderSyncHelperImpl(SplitTaskType.IMPRESSIONS_RECORDER, this.mStorageContainer.getImpressionsStorage(), this.mImpressionsQueueSize, this.mImpressionsChunkSize, this.mSplitTaskExecutor), this.mSplitTaskExecutor, this.mSplitTaskFactory, this.mTelemetryStorage, impressionManagerRetryTimerProviderImpl.getImpressionsTimer(), this.mImpressionsRefreshRate);
    }
}
