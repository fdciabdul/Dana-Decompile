package id.dana.data.util;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u0010\tR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/util/RetryWithDelay;", "Lio/reactivex/functions/Function;", "Lio/reactivex/Observable;", "", SecurityConstants.KEY_TEXT, "apply", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "", "maxRetries", "I", "getMaxRetries", "()I", "retryCount", "", "retryDelayMillis", "J", "getRetryDelayMillis", "()J", "<init>", "(IJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RetryWithDelay implements Function<Observable<? extends Throwable>, Observable<?>> {
    private final int maxRetries;
    private int retryCount;
    private final long retryDelayMillis;

    public RetryWithDelay(int i, long j) {
        this.maxRetries = i;
        this.retryDelayMillis = j;
    }

    @JvmName(name = "getMaxRetries")
    public final int getMaxRetries() {
        return this.maxRetries;
    }

    @JvmName(name = "getRetryDelayMillis")
    public final long getRetryDelayMillis() {
        return this.retryDelayMillis;
    }

    @Override // io.reactivex.functions.Function
    public final Observable<?> apply(Observable<? extends Throwable> r3) {
        Intrinsics.checkNotNullParameter(r3, "");
        Observable flatMap = r3.flatMap(new Function<Throwable, Observable<?>>() { // from class: id.dana.data.util.RetryWithDelay$apply$1
            @Override // io.reactivex.functions.Function
            public final Observable<?> apply(Throwable throwable) {
                int i;
                int i2;
                Intrinsics.checkNotNullParameter(throwable, "");
                RetryWithDelay retryWithDelay = RetryWithDelay.this;
                i = retryWithDelay.retryCount;
                retryWithDelay.retryCount = i + 1;
                i2 = retryWithDelay.retryCount;
                if (i2 <= RetryWithDelay.this.getMaxRetries()) {
                    Observable<Long> timer = Observable.timer(RetryWithDelay.this.getRetryDelayMillis(), TimeUnit.MILLISECONDS);
                    Intrinsics.checkNotNullExpressionValue(timer, "");
                    return timer;
                }
                throw new IllegalStateException(throwable.toString());
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }
}
