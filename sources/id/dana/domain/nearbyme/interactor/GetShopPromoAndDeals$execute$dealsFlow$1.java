package id.dana.domain.nearbyme.interactor;

import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals;
import id.dana.domain.nearbyme.model.MerchantProductInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "Lid/dana/domain/nearbyme/model/MerchantProductInfo;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals$execute$dealsFlow$1", f = "GetShopPromoAndDeals.kt", i = {}, l = {41, 40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class GetShopPromoAndDeals$execute$dealsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends MerchantProductInfo>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetShopPromoAndDeals.Params $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetShopPromoAndDeals this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetShopPromoAndDeals$execute$dealsFlow$1(GetShopPromoAndDeals getShopPromoAndDeals, GetShopPromoAndDeals.Params params, Continuation<? super GetShopPromoAndDeals$execute$dealsFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = getShopPromoAndDeals;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetShopPromoAndDeals$execute$dealsFlow$1 getShopPromoAndDeals$execute$dealsFlow$1 = new GetShopPromoAndDeals$execute$dealsFlow$1(this.this$0, this.$params, continuation);
        getShopPromoAndDeals$execute$dealsFlow$1.L$0 = obj;
        return getShopPromoAndDeals$execute$dealsFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends MerchantProductInfo>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super List<MerchantProductInfo>>) flowCollector, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super List<MerchantProductInfo>> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetShopPromoAndDeals$execute$dealsFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        MerchantInfoRepository merchantInfoRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            merchantInfoRepository = this.this$0.merchantInfoRepository;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = MerchantInfoRepository.CC.getMerchantPromoDanaDeal$default(merchantInfoRepository, this.$params.getMerchantId(), this.$params.getShopId(), 0, this.$params.getDealsPageSize(), this, 4, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
