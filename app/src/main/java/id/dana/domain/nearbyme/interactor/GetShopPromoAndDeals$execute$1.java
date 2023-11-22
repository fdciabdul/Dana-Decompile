package id.dana.domain.nearbyme.interactor;

import id.dana.domain.nearbyme.model.MerchantProductInfo;
import id.dana.domain.nearbyme.model.PromoDealsInfo;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.social.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0000H\u008a@"}, d2 = {"", "Lid/dana/domain/nearbyme/model/PromoInfo;", "promoInfo", "Lid/dana/domain/nearbyme/model/MerchantProductInfo;", "dealsInfo", "Lid/dana/domain/social/Result$Success;", "Lid/dana/domain/nearbyme/model/PromoDealsInfo;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals$execute$1", f = "GetShopPromoAndDeals.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class GetShopPromoAndDeals$execute$1 extends SuspendLambda implements Function3<List<? extends PromoInfo>, List<? extends MerchantProductInfo>, Continuation<? super Result.Success<? extends PromoDealsInfo>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetShopPromoAndDeals$execute$1(Continuation<? super GetShopPromoAndDeals$execute$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(List<? extends PromoInfo> list, List<? extends MerchantProductInfo> list2, Continuation<? super Result.Success<? extends PromoDealsInfo>> continuation) {
        return invoke2((List<PromoInfo>) list, (List<MerchantProductInfo>) list2, (Continuation<? super Result.Success<PromoDealsInfo>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(List<PromoInfo> list, List<MerchantProductInfo> list2, Continuation<? super Result.Success<PromoDealsInfo>> continuation) {
        GetShopPromoAndDeals$execute$1 getShopPromoAndDeals$execute$1 = new GetShopPromoAndDeals$execute$1(continuation);
        getShopPromoAndDeals$execute$1.L$0 = list;
        getShopPromoAndDeals$execute$1.L$1 = list2;
        return getShopPromoAndDeals$execute$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new Result.Success(new PromoDealsInfo((List) this.L$0, (List) this.L$1));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
