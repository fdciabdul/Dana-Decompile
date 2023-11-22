package id.dana.utils.retry;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.utils.retry.RetryHelper", f = "RetryHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {117, 130, 138, 149, 158}, m = "retrySuspend", n = {"this", "operationType", "block", "holdLoginV2Processing", "predicate", "delayInMillis", "logError", "logErrorRetryOperationType", "maxRetry", "this", "operationType", "block", "holdLoginV2Processing", "predicate", "delayInMillis", "logError", "logErrorRetryOperationType", "maxRetry", "factor", "this", "operationType", "block", "holdLoginV2Processing", "predicate", "delayInMillis", "logError", "logErrorRetryOperationType", "maxRetry", "this", "operationType", "block", "logError", "logErrorRetryOperationType", "maxRetry"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* loaded from: classes5.dex */
public final class RetryHelper$retrySuspend$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RetryHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryHelper$retrySuspend$1(RetryHelper retryHelper, Continuation<? super RetryHelper$retrySuspend$1> continuation) {
        super(continuation);
        this.this$0 = retryHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.PlaceComponentResult(null, null, null, null, 0, null, null, null, this);
    }
}
