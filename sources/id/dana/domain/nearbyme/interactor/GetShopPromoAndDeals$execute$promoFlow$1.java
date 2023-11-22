package id.dana.domain.nearbyme.interactor;

import id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals;
import id.dana.domain.nearbyme.model.PromoInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "Lid/dana/domain/nearbyme/model/PromoInfo;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals$execute$promoFlow$1", f = "GetShopPromoAndDeals.kt", i = {}, l = {34, 34, 36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class GetShopPromoAndDeals$execute$promoFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends PromoInfo>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetShopPromoAndDeals.Params $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetShopPromoAndDeals this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetShopPromoAndDeals$execute$promoFlow$1(GetShopPromoAndDeals.Params params, GetShopPromoAndDeals getShopPromoAndDeals, Continuation<? super GetShopPromoAndDeals$execute$promoFlow$1> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = getShopPromoAndDeals;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetShopPromoAndDeals$execute$promoFlow$1 getShopPromoAndDeals$execute$promoFlow$1 = new GetShopPromoAndDeals$execute$promoFlow$1(this.$params, this.this$0, continuation);
        getShopPromoAndDeals$execute$promoFlow$1.L$0 = obj;
        return getShopPromoAndDeals$execute$promoFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends PromoInfo>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super List<PromoInfo>>) flowCollector, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super List<PromoInfo>> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetShopPromoAndDeals$execute$promoFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0064 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 3
            r4 = 1
            if (r1 == 0) goto L26
            if (r1 == r4) goto L1e
            if (r1 == r2) goto L1a
            if (r1 != r3) goto L12
            goto L1a
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L75
        L1e:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L56
        L26:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals$Params r8 = r7.$params
            boolean r8 = r8.getShouldFetchPromo()
            if (r8 == 0) goto L65
            id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals r8 = r7.this$0
            id.dana.domain.nearbyme.MerchantInfoRepository r8 = id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals.access$getMerchantInfoRepository$p(r8)
            id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals$Params r3 = r7.$params
            java.lang.String r3 = r3.getMerchantId()
            id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals$Params r5 = r7.$params
            java.lang.String r5 = r5.getShopId()
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = r8.getMerchantPromo(r3, r5, r6)
            if (r8 != r0) goto L56
            return r0
        L56:
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r7.L$0 = r4
            r7.label = r2
            java.lang.Object r8 = r1.emit(r8, r3)
            if (r8 != r0) goto L75
            return r0
        L65:
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.label = r3
            java.lang.Object r8 = r1.emit(r8, r2)
            if (r8 != r0) goto L75
            return r0
        L75:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals$execute$promoFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
