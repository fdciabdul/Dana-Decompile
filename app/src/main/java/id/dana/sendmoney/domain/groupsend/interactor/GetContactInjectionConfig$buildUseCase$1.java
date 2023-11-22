package id.dana.sendmoney.domain.groupsend.interactor;

import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.ContactInjectionConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/domain/featureconfig/model/ContactInjectionConfig;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.domain.groupsend.interactor.GetContactInjectionConfig$buildUseCase$1", f = "GetContactInjectionConfig.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GetContactInjectionConfig$buildUseCase$1 extends SuspendLambda implements Function2<FlowCollector<? super ContactInjectionConfig>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetContactInjectionConfig this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetContactInjectionConfig$buildUseCase$1(GetContactInjectionConfig getContactInjectionConfig, Continuation<? super GetContactInjectionConfig$buildUseCase$1> continuation) {
        super(2, continuation);
        this.this$0 = getContactInjectionConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetContactInjectionConfig$buildUseCase$1 getContactInjectionConfig$buildUseCase$1 = new GetContactInjectionConfig$buildUseCase$1(this.this$0, continuation);
        getContactInjectionConfig$buildUseCase$1.L$0 = obj;
        return getContactInjectionConfig$buildUseCase$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ContactInjectionConfig> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetContactInjectionConfig$buildUseCase$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FeatureConfigRepository featureConfigRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            featureConfigRepository = this.this$0.MyBillsEntityDataFactory;
            ContactInjectionConfig blockingFirst = featureConfigRepository.getContactInjectionConfig().blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            this.label = 1;
            if (flowCollector.emit(blockingFirst, this) == coroutine_suspended) {
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
