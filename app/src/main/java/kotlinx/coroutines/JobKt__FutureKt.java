package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a!\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "Ljava/util/concurrent/Future;", "future", "", "cancelFutureOnCancellation", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/util/concurrent/Future;)V"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes9.dex */
final /* synthetic */ class JobKt__FutureKt {
    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        cancellableContinuation.invokeOnCancellation(new CancelFutureOnCancel(future));
    }
}
