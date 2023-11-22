package id.dana.sendmoney.domain.groupsend.interactor;

import id.dana.domain.usereducation.repository.UserEducationRepository;
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

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.domain.groupsend.interactor.GetBottomSheetOnBoardingFlow$buildUseCase$1", f = "GetBottomSheetOnBoarding.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GetBottomSheetOnBoardingFlow$buildUseCase$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $param;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetBottomSheetOnBoardingFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBottomSheetOnBoardingFlow$buildUseCase$1(GetBottomSheetOnBoardingFlow getBottomSheetOnBoardingFlow, String str, Continuation<? super GetBottomSheetOnBoardingFlow$buildUseCase$1> continuation) {
        super(2, continuation);
        this.this$0 = getBottomSheetOnBoardingFlow;
        this.$param = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetBottomSheetOnBoardingFlow$buildUseCase$1 getBottomSheetOnBoardingFlow$buildUseCase$1 = new GetBottomSheetOnBoardingFlow$buildUseCase$1(this.this$0, this.$param, continuation);
        getBottomSheetOnBoardingFlow$buildUseCase$1.L$0 = obj;
        return getBottomSheetOnBoardingFlow$buildUseCase$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetBottomSheetOnBoardingFlow$buildUseCase$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserEducationRepository userEducationRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            userEducationRepository = this.this$0.BuiltInFictitiousFunctionClassFactory;
            Boolean blockingFirst = userEducationRepository.isNeedToShowBottomSheetOnBoarding(this.$param).blockingFirst();
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
