package id.dana.domain.nearbyme.interactor.merchantreview;

import id.dana.contract.deeplink.path.FeatureParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm", f = "GetReviewableMerchantForm.kt", i = {0, 0, 0, 0, 0}, l = {81}, m = "getReviewableMerchantConsult", n = {"this", FeatureParams.SHOP_ID, "hasMore", "pageNum", "ignoreFormDismissCheck"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"})
/* loaded from: classes4.dex */
public final class GetReviewableMerchantForm$getReviewableMerchantConsult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetReviewableMerchantForm this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetReviewableMerchantForm$getReviewableMerchantConsult$1(GetReviewableMerchantForm getReviewableMerchantForm, Continuation<? super GetReviewableMerchantForm$getReviewableMerchantConsult$1> continuation) {
        super(continuation);
        this.this$0 = getReviewableMerchantForm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object reviewableMerchantConsult;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        reviewableMerchantConsult = this.this$0.getReviewableMerchantConsult(null, false, this);
        return reviewableMerchantConsult;
    }
}
