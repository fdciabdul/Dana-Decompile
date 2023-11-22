package id.dana.mybills.data.repository;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "kotlin.jvm.PlatformType", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$1", f = "MyBillsEntityRepository.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class MyBillsEntityRepository$getUserCurrentBalance$1 extends SuspendLambda implements Function2<FlowCollector<? super UserInfoRpcResult>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyBillsEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsEntityRepository$getUserCurrentBalance$1(MyBillsEntityRepository myBillsEntityRepository, Continuation<? super MyBillsEntityRepository$getUserCurrentBalance$1> continuation) {
        super(2, continuation);
        this.this$0 = myBillsEntityRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MyBillsEntityRepository$getUserCurrentBalance$1 myBillsEntityRepository$getUserCurrentBalance$1 = new MyBillsEntityRepository$getUserCurrentBalance$1(this.this$0, continuation);
        myBillsEntityRepository$getUserCurrentBalance$1.L$0 = obj;
        return myBillsEntityRepository$getUserCurrentBalance$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super UserInfoRpcResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((MyBillsEntityRepository$getUserCurrentBalance$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            holdLoginV1EntityRepository = this.this$0.BuiltInFictitiousFunctionClassFactory;
            this.label = 1;
            if (flowCollector.emit((UserInfoRpcResult) holdLoginV1EntityRepository.authenticatedRequest(MyBillsEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0).getBalance()).blockingFirst(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
