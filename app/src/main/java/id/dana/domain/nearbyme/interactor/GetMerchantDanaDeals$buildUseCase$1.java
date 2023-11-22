package id.dana.domain.nearbyme.interactor;

import id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals;
import id.dana.domain.nearbyme.model.MerchantProductInfo;
import id.dana.domain.social.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals", f = "GetMerchantDanaDeals.kt", i = {}, l = {36}, m = "buildUseCase", n = {}, s = {})
/* loaded from: classes4.dex */
public final class GetMerchantDanaDeals$buildUseCase$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetMerchantDanaDeals this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetMerchantDanaDeals$buildUseCase$1(GetMerchantDanaDeals getMerchantDanaDeals, Continuation<? super GetMerchantDanaDeals$buildUseCase$1> continuation) {
        super(continuation);
        this.this$0 = getMerchantDanaDeals;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.buildUseCase((GetMerchantDanaDeals.Params) null, (Continuation<? super Result<? extends List<MerchantProductInfo>>>) this);
    }
}
