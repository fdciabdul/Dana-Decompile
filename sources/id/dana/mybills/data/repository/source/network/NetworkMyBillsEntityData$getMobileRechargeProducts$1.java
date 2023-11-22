package id.dana.mybills.data.repository.source.network;

import id.dana.mybills.data.model.request.ProductQueryRequestEntity;
import id.dana.mybills.data.model.response.MobileRechargeProductResult;
import id.dana.network.base.ResultResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/mybills/data/model/response/MobileRechargeProductResult;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$1", f = "NetworkMyBillsEntityData.kt", i = {0}, l = {117, 118}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class NetworkMyBillsEntityData$getMobileRechargeProducts$1 extends SuspendLambda implements Function2<FlowCollector<? super ResultResponse<MobileRechargeProductResult>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProductQueryRequestEntity $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkMyBillsEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkMyBillsEntityData$getMobileRechargeProducts$1(NetworkMyBillsEntityData networkMyBillsEntityData, ProductQueryRequestEntity productQueryRequestEntity, Continuation<? super NetworkMyBillsEntityData$getMobileRechargeProducts$1> continuation) {
        super(2, continuation);
        this.this$0 = networkMyBillsEntityData;
        this.$request = productQueryRequestEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkMyBillsEntityData$getMobileRechargeProducts$1 networkMyBillsEntityData$getMobileRechargeProducts$1 = new NetworkMyBillsEntityData$getMobileRechargeProducts$1(this.this$0, this.$request, continuation);
        networkMyBillsEntityData$getMobileRechargeProducts$1.L$0 = obj;
        return networkMyBillsEntityData$getMobileRechargeProducts$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ResultResponse<MobileRechargeProductResult>> flowCollector, Continuation<? super Unit> continuation) {
        return ((NetworkMyBillsEntityData$getMobileRechargeProducts$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        MyBillsRestFacade myBillsRestFacade;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            myBillsRestFacade = this.this$0.PlaceComponentResult;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = myBillsRestFacade.BuiltInFictitiousFunctionClassFactory(this.$request, this);
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
        if (flowCollector.emit((ResultResponse) obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
