package io.split.android.client.service.impressions;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import io.split.android.client.RetryBackoffCounterTimerFactory;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;

/* loaded from: classes6.dex */
public class ImpressionManagerRetryTimerProviderImpl implements ImpressionManagerRetryTimerProvider {
    private final Supplier<RetryBackoffCounterTimer> mImpressionsCountRetrySupplier;
    private final Supplier<RetryBackoffCounterTimer> mImpressionsRetrySupplier;
    private final RetryBackoffCounterTimerFactory mRetryBackoffCounterTimerFactory;
    private final SplitTaskExecutor mTaskExecutor;
    private final Supplier<RetryBackoffCounterTimer> mUniqueKeysRetrySupplier;

    public ImpressionManagerRetryTimerProviderImpl(SplitTaskExecutor splitTaskExecutor) {
        this(splitTaskExecutor, new RetryBackoffCounterTimerFactory());
    }

    ImpressionManagerRetryTimerProviderImpl(SplitTaskExecutor splitTaskExecutor, RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory) {
        this.mUniqueKeysRetrySupplier = Suppliers.memoize(buildBackoffTimerDelegate());
        this.mImpressionsRetrySupplier = Suppliers.memoize(buildBackoffTimerDelegate());
        this.mImpressionsCountRetrySupplier = Suppliers.memoize(buildBackoffTimerDelegate());
        this.mRetryBackoffCounterTimerFactory = (RetryBackoffCounterTimerFactory) Preconditions.checkNotNull(retryBackoffCounterTimerFactory);
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
    }

    @Override // io.split.android.client.service.impressions.ImpressionManagerRetryTimerProvider
    public RetryBackoffCounterTimer getUniqueKeysTimer() {
        return this.mUniqueKeysRetrySupplier.get();
    }

    @Override // io.split.android.client.service.impressions.ImpressionManagerRetryTimerProvider
    public RetryBackoffCounterTimer getImpressionsTimer() {
        return this.mImpressionsRetrySupplier.get();
    }

    @Override // io.split.android.client.service.impressions.ImpressionManagerRetryTimerProvider
    public RetryBackoffCounterTimer getImpressionsCountTimer() {
        return this.mImpressionsCountRetrySupplier.get();
    }

    private Supplier<RetryBackoffCounterTimer> buildBackoffTimerDelegate() {
        return new Supplier<RetryBackoffCounterTimer>() { // from class: io.split.android.client.service.impressions.ImpressionManagerRetryTimerProviderImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.common.base.Supplier
            public RetryBackoffCounterTimer get() {
                return ImpressionManagerRetryTimerProviderImpl.this.mRetryBackoffCounterTimerFactory.createWithFixedInterval(ImpressionManagerRetryTimerProviderImpl.this.mTaskExecutor, 1, 3);
            }
        };
    }
}
