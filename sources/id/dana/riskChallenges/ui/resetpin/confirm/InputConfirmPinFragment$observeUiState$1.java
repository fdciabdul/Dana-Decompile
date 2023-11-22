package id.dana.riskChallenges.ui.resetpin.confirm;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.core.ui.dialog.DanaSuccessDialogFragment;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentInputConfirmPinBinding;
import id.dana.riskChallenges.ui.resetpin.confirm.viewmodel.InputConfirmPinUiState;
import id.dana.utils.StringWrapperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$observeUiState$1", f = "InputConfirmPinFragment.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class InputConfirmPinFragment$observeUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InputConfirmPinFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputConfirmPinFragment$observeUiState$1(InputConfirmPinFragment inputConfirmPinFragment, Continuation<? super InputConfirmPinFragment$observeUiState$1> continuation) {
        super(2, continuation);
        this.this$0 = inputConfirmPinFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputConfirmPinFragment$observeUiState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputConfirmPinFragment$observeUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$observeUiState$1$1", f = "InputConfirmPinFragment.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$observeUiState$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InputConfirmPinFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InputConfirmPinFragment inputConfirmPinFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = inputConfirmPinFragment;
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
                StateFlow<InputConfirmPinUiState> stateFlow = InputConfirmPinFragment.lookAheadTest(this.this$0).NetworkUserEntityData$$ExternalSyntheticLambda0;
                final InputConfirmPinFragment inputConfirmPinFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment.observeUiState.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
                    public final Object emit(InputConfirmPinUiState inputConfirmPinUiState, Continuation<? super Unit> continuation) {
                        String authRequestContext;
                        Job launch$default;
                        if (inputConfirmPinUiState instanceof InputConfirmPinUiState.PinNotMatched) {
                            InputConfirmPinFragment.lookAheadTest(InputConfirmPinFragment.this).BuiltInFictitiousFunctionClassFactory();
                            Context context = InputConfirmPinFragment.this.getContext();
                            if (context != null) {
                                VB vb = InputConfirmPinFragment.this.PlaceComponentResult;
                                if (vb != 0) {
                                    ((FragmentInputConfirmPinBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.PlaceComponentResult));
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            }
                            InputConfirmPinFragment.moveToNextValue(InputConfirmPinFragment.this);
                        } else if (!(inputConfirmPinUiState instanceof InputConfirmPinUiState.ShowLoading)) {
                            if (inputConfirmPinUiState instanceof InputConfirmPinUiState.DismissLoading) {
                                InputConfirmPinFragment.getAuthRequestContext(InputConfirmPinFragment.this);
                            } else {
                                if (inputConfirmPinUiState instanceof InputConfirmPinUiState.SuccessResetPin) {
                                    InputConfirmPinFragment.lookAheadTest(InputConfirmPinFragment.this).BuiltInFictitiousFunctionClassFactory();
                                    InputConfirmPinFragment inputConfirmPinFragment2 = InputConfirmPinFragment.this;
                                    final InputConfirmPinFragment inputConfirmPinFragment3 = InputConfirmPinFragment.this;
                                    InputConfirmPinFragment.PlaceComponentResult(inputConfirmPinFragment2, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment.observeUiState.1.1.1.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            InputConfirmPinFragment.getAuthRequestContext(InputConfirmPinFragment.this);
                                        }
                                    });
                                    launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass3(InputConfirmPinFragment.this, null), 3, null);
                                    if (launch$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        return launch$default;
                                    }
                                } else {
                                    if (inputConfirmPinUiState instanceof InputConfirmPinUiState.FailedResetPin) {
                                        InputConfirmPinFragment.lookAheadTest(InputConfirmPinFragment.this).BuiltInFictitiousFunctionClassFactory();
                                        InputConfirmPinFragment inputConfirmPinFragment4 = InputConfirmPinFragment.this;
                                        final InputConfirmPinFragment inputConfirmPinFragment5 = InputConfirmPinFragment.this;
                                        InputConfirmPinFragment.PlaceComponentResult(inputConfirmPinFragment4, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment.observeUiState.1.1.1.4
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                InputConfirmPinFragment.getAuthRequestContext(InputConfirmPinFragment.this);
                                            }
                                        });
                                        InputConfirmPinFragment inputConfirmPinFragment6 = InputConfirmPinFragment.this;
                                        Context context2 = inputConfirmPinFragment6.getContext();
                                        authRequestContext = context2 != null ? StringWrapperKt.getAuthRequestContext(context2, ((InputConfirmPinUiState.FailedResetPin) inputConfirmPinUiState).MyBillsEntityDataFactory) : null;
                                        if (authRequestContext == null) {
                                            authRequestContext = "";
                                        }
                                        InputConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(inputConfirmPinFragment6, authRequestContext);
                                        VB vb2 = InputConfirmPinFragment.this.PlaceComponentResult;
                                        if (vb2 != 0) {
                                            ((FragmentInputConfirmPinBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setText("");
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else if (inputConfirmPinUiState instanceof InputConfirmPinUiState.FailedSelfUnfreeze) {
                                        InputConfirmPinFragment.lookAheadTest(InputConfirmPinFragment.this).BuiltInFictitiousFunctionClassFactory();
                                        InputConfirmPinFragment inputConfirmPinFragment7 = InputConfirmPinFragment.this;
                                        final InputConfirmPinFragment inputConfirmPinFragment8 = InputConfirmPinFragment.this;
                                        InputConfirmPinFragment.PlaceComponentResult(inputConfirmPinFragment7, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment.observeUiState.1.1.1.5
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                InputConfirmPinFragment.getAuthRequestContext(InputConfirmPinFragment.this);
                                            }
                                        });
                                        InputConfirmPinFragment inputConfirmPinFragment9 = InputConfirmPinFragment.this;
                                        Context context3 = inputConfirmPinFragment9.getContext();
                                        authRequestContext = context3 != null ? StringWrapperKt.getAuthRequestContext(context3, ((InputConfirmPinUiState.FailedSelfUnfreeze) inputConfirmPinUiState).KClassImpl$Data$declaredNonStaticMembers$2) : null;
                                        InputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory(inputConfirmPinFragment9, authRequestContext != null ? authRequestContext : "");
                                    }
                                }
                            }
                        } else {
                            VB vb3 = InputConfirmPinFragment.this.PlaceComponentResult;
                            if (vb3 != 0) {
                                ((FragmentInputConfirmPinBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2.clearFocus();
                                InputConfirmPinFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(InputConfirmPinFragment.this);
                                InputConfirmPinFragment.lookAheadTest(InputConfirmPinFragment.this).BuiltInFictitiousFunctionClassFactory();
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                    @DebugMetadata(c = "id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$observeUiState$1$1$1$3", f = "InputConfirmPinFragment.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$observeUiState$1$1$1$3  reason: invalid class name */
                    /* loaded from: classes5.dex */
                    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ InputConfirmPinFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(InputConfirmPinFragment inputConfirmPinFragment, Continuation<? super AnonymousClass3> continuation) {
                            super(2, continuation);
                            this.this$0 = inputConfirmPinFragment;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass3(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                ((DanaSuccessDialogFragment) r4.getAuthRequestContext.getValue()).show(this.this$0.getParentFragmentManager(), "FullDanaLoading");
                                this.label = 1;
                                if (DelayKt.delay(1500L, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj);
                            }
                            ((DanaSuccessDialogFragment) this.this$0.getAuthRequestContext.getValue()).dismiss();
                            InputConfirmPinFragment.scheduleImpl(this.this$0);
                            return Unit.INSTANCE;
                        }
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
