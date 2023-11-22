package id.dana.nearbyme.merchantreview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.nearbyme.merchantreview.MerchantReviewWorker", f = "MerchantReviewWorker.kt", i = {0}, l = {39}, m = "doWork$suspendImpl", n = {"this"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class MerchantReviewWorker$doWork$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MerchantReviewWorker<R> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantReviewWorker$doWork$1(MerchantReviewWorker<R> merchantReviewWorker, Continuation<? super MerchantReviewWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = merchantReviewWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MerchantReviewWorker.PlaceComponentResult(this.this$0, this);
    }
}
