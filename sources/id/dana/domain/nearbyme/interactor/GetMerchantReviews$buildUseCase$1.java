package id.dana.domain.nearbyme.interactor;

import id.dana.domain.nearbyme.interactor.GetMerchantReviews;
import id.dana.domain.nearbyme.model.MerchantReviews;
import id.dana.domain.social.Result;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.domain.nearbyme.interactor.GetMerchantReviews", f = "GetMerchantReviews.kt", i = {0}, l = {41}, m = "buildUseCase", n = {"currentUserId"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class GetMerchantReviews$buildUseCase$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetMerchantReviews this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetMerchantReviews$buildUseCase$1(GetMerchantReviews getMerchantReviews, Continuation<? super GetMerchantReviews$buildUseCase$1> continuation) {
        super(continuation);
        this.this$0 = getMerchantReviews;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.buildUseCase((GetMerchantReviews.Param) null, (Continuation<? super Result<MerchantReviews>>) this);
    }
}
