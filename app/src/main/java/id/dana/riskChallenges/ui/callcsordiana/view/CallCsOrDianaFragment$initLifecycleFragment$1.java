package id.dana.riskChallenges.ui.callcsordiana.view;

import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.domain.featureconfig.model.HelpButtonConfig;
import id.dana.riskChallenges.ui.callcsordiana.viewmodel.CallCsOrDianaUiState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$initLifecycleFragment$1", f = "CallCsOrDianaFragment.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class CallCsOrDianaFragment$initLifecycleFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CallCsOrDianaFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallCsOrDianaFragment$initLifecycleFragment$1(CallCsOrDianaFragment callCsOrDianaFragment, Continuation<? super CallCsOrDianaFragment$initLifecycleFragment$1> continuation) {
        super(2, continuation);
        this.this$0 = callCsOrDianaFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallCsOrDianaFragment$initLifecycleFragment$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallCsOrDianaFragment$initLifecycleFragment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$initLifecycleFragment$1$1", f = "CallCsOrDianaFragment.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$initLifecycleFragment$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CallCsOrDianaFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CallCsOrDianaFragment callCsOrDianaFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = callCsOrDianaFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<CallCsOrDianaUiState> stateFlow = CallCsOrDianaFragment.BuiltInFictitiousFunctionClassFactory(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2;
                final CallCsOrDianaFragment callCsOrDianaFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment.initLifecycleFragment.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
                    public final Object emit(CallCsOrDianaUiState callCsOrDianaUiState, Continuation<? super Unit> continuation) {
                        Unit unit = null;
                        if (callCsOrDianaUiState instanceof CallCsOrDianaUiState.OnGetHelpButtonChatBotFeature) {
                            CallCsOrDianaFragment.BuiltInFictitiousFunctionClassFactory(CallCsOrDianaFragment.this, ((CallCsOrDianaUiState.OnGetHelpButtonChatBotFeature) callCsOrDianaUiState).BuiltInFictitiousFunctionClassFactory);
                            DanaLogoLoadingDialog MyBillsEntityDataFactory = CallCsOrDianaFragment.MyBillsEntityDataFactory(CallCsOrDianaFragment.this);
                            if (MyBillsEntityDataFactory != null) {
                                MyBillsEntityDataFactory.PlaceComponentResult();
                                unit = Unit.INSTANCE;
                            }
                            if (unit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return unit;
                            }
                        } else if (callCsOrDianaUiState instanceof CallCsOrDianaUiState.OnErrorGetHelpButtonChatBotFeature) {
                            CallCsOrDianaFragment.BuiltInFictitiousFunctionClassFactory(CallCsOrDianaFragment.this, new HelpButtonConfig(false, "", ""));
                            DanaLogoLoadingDialog MyBillsEntityDataFactory2 = CallCsOrDianaFragment.MyBillsEntityDataFactory(CallCsOrDianaFragment.this);
                            if (MyBillsEntityDataFactory2 != null) {
                                MyBillsEntityDataFactory2.PlaceComponentResult();
                                unit = Unit.INSTANCE;
                            }
                            if (unit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return unit;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
