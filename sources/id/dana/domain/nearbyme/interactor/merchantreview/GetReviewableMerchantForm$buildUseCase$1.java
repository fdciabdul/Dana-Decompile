package id.dana.domain.nearbyme.interactor.merchantreview;

import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm;
import id.dana.domain.nearbyme.model.MerchantConsult;
import id.dana.domain.social.Result;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm", f = "GetReviewableMerchantForm.kt", i = {}, l = {41}, m = "buildUseCase", n = {}, s = {})
/* loaded from: classes4.dex */
public final class GetReviewableMerchantForm$buildUseCase$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetReviewableMerchantForm this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetReviewableMerchantForm$buildUseCase$1(GetReviewableMerchantForm getReviewableMerchantForm, Continuation<? super GetReviewableMerchantForm$buildUseCase$1> continuation) {
        super(continuation);
        this.this$0 = getReviewableMerchantForm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.buildUseCase((GetReviewableMerchantForm.Param) null, (Continuation<? super Result<MerchantConsult>>) this);
    }
}
