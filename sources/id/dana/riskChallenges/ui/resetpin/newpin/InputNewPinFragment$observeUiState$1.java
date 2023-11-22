package id.dana.riskChallenges.ui.resetpin.newpin;

import androidx.core.content.ContextCompat;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentInputNewPinBinding;
import id.dana.riskChallenges.ui.resetpin.newpin.viewmodel.InputNewPinUiState;
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
@DebugMetadata(c = "id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$observeUiState$1", f = "InputNewPinFragment.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class InputNewPinFragment$observeUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InputNewPinFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputNewPinFragment$observeUiState$1(InputNewPinFragment inputNewPinFragment, Continuation<? super InputNewPinFragment$observeUiState$1> continuation) {
        super(2, continuation);
        this.this$0 = inputNewPinFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputNewPinFragment$observeUiState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputNewPinFragment$observeUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$observeUiState$1$1", f = "InputNewPinFragment.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$observeUiState$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InputNewPinFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InputNewPinFragment inputNewPinFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = inputNewPinFragment;
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
                StateFlow<InputNewPinUiState> stateFlow = InputNewPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0).getAuthRequestContext;
                final InputNewPinFragment inputNewPinFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment.observeUiState.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
                    public final Object emit(InputNewPinUiState inputNewPinUiState, Continuation<? super Unit> continuation) {
                        if (inputNewPinUiState instanceof InputNewPinUiState.PinValid) {
                            InputNewPinFragment inputNewPinFragment2 = InputNewPinFragment.this;
                            String str = InputNewPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(inputNewPinFragment2).MyBillsEntityDataFactory;
                            InputNewPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(inputNewPinFragment2, str != null ? str : "", ((InputNewPinUiState.PinValid) inputNewPinUiState).PlaceComponentResult);
                            InputNewPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(InputNewPinFragment.this).PlaceComponentResult();
                        } else if (!(inputNewPinUiState instanceof InputNewPinUiState.PinRepetitive)) {
                            if (!(inputNewPinUiState instanceof InputNewPinUiState.PinSequential)) {
                                if (inputNewPinUiState instanceof InputNewPinUiState.None) {
                                    VB vb = InputNewPinFragment.this.PlaceComponentResult;
                                    if (vb != 0) {
                                        ((FragmentInputNewPinBinding) vb).MyBillsEntityDataFactory.setText("");
                                        VB vb2 = InputNewPinFragment.this.PlaceComponentResult;
                                        if (vb2 != 0) {
                                            ((FragmentInputNewPinBinding) vb2).MyBillsEntityDataFactory.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(InputNewPinFragment.this.requireContext(), R.color.BuiltInFictitiousFunctionClassFactory));
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                }
                            } else {
                                VB vb3 = InputNewPinFragment.this.PlaceComponentResult;
                                if (vb3 != 0) {
                                    ((FragmentInputNewPinBinding) vb3).MyBillsEntityDataFactory.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(InputNewPinFragment.this.requireContext(), R.color.PlaceComponentResult));
                                    InputNewPinFragment.lookAheadTest(InputNewPinFragment.this);
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            }
                        } else {
                            VB vb4 = InputNewPinFragment.this.PlaceComponentResult;
                            if (vb4 != 0) {
                                ((FragmentInputNewPinBinding) vb4).MyBillsEntityDataFactory.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(InputNewPinFragment.this.requireContext(), R.color.PlaceComponentResult));
                                InputNewPinFragment.moveToNextValue(InputNewPinFragment.this);
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
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
