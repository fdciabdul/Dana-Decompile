package id.dana.sendmoney.data.repository.globalsend.source.network;

import id.dana.network.base.ResultResponse;
import id.dana.sendmoney.data.api.globalsend.validate.model.request.TransferValidateEntityRequest;
import id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$1", f = "NetworkGlobalSendEntityData.kt", i = {0}, l = {84, 85}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes2.dex */
final class NetworkGlobalSendEntityData$validate$1 extends SuspendLambda implements Function2<FlowCollector<? super ResultResponse<TransferValidateEntityResult>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ TransferValidateEntityRequest $requestModel;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkGlobalSendEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkGlobalSendEntityData$validate$1(NetworkGlobalSendEntityData networkGlobalSendEntityData, TransferValidateEntityRequest transferValidateEntityRequest, Continuation<? super NetworkGlobalSendEntityData$validate$1> continuation) {
        super(2, continuation);
        this.this$0 = networkGlobalSendEntityData;
        this.$requestModel = transferValidateEntityRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkGlobalSendEntityData$validate$1 networkGlobalSendEntityData$validate$1 = new NetworkGlobalSendEntityData$validate$1(this.this$0, this.$requestModel, continuation);
        networkGlobalSendEntityData$validate$1.L$0 = obj;
        return networkGlobalSendEntityData$validate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ResultResponse<TransferValidateEntityResult>> flowCollector, Continuation<? super Unit> continuation) {
        return ((NetworkGlobalSendEntityData$validate$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        GlobalSendSecureApi globalSendSecureApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            globalSendSecureApi = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = globalSendSecureApi.BuiltInFictitiousFunctionClassFactory(this.$requestModel, this);
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
