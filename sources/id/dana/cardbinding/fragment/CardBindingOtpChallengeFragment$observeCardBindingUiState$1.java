package id.dana.cardbinding.fragment;

import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cardbinding.viewmodel.CardBindingUiState;
import id.dana.cardbinding.viewmodel.CardBindingViewModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.challenge.ChallengeControl;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$observeCardBindingUiState$1", f = "CardBindingOtpChallengeFragment.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class CardBindingOtpChallengeFragment$observeCardBindingUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CardBindingOtpChallengeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBindingOtpChallengeFragment$observeCardBindingUiState$1(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment, Continuation<? super CardBindingOtpChallengeFragment$observeCardBindingUiState$1> continuation) {
        super(2, continuation);
        this.this$0 = cardBindingOtpChallengeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardBindingOtpChallengeFragment$observeCardBindingUiState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CardBindingOtpChallengeFragment$observeCardBindingUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$observeCardBindingUiState$1$1", f = "CardBindingOtpChallengeFragment.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$observeCardBindingUiState$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CardBindingOtpChallengeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = cardBindingOtpChallengeFragment;
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
                CardBindingViewModel cardBindingViewModel = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
                if (cardBindingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cardBindingViewModel = null;
                }
                StateFlow<CardBindingUiState> stateFlow = cardBindingViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
                final CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment.observeCardBindingUiState.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
                    public final Object emit(CardBindingUiState cardBindingUiState, Continuation<? super Unit> continuation) {
                        Object obj2;
                        boolean z = false;
                        if (cardBindingUiState instanceof CardBindingUiState.OnSuccessCashierPay) {
                            CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment2 = CardBindingOtpChallengeFragment.this;
                            CardBindingUiState.OnSuccessCashierPay onSuccessCashierPay = (CardBindingUiState.OnSuccessCashierPay) cardBindingUiState;
                            AttributeCashierPayModel attributeCashierPayModel = onSuccessCashierPay.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (attributeCashierPayModel != null && attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                z = true;
                            }
                            if (z) {
                                cardBindingOtpChallengeFragment2.getBaseActivity().getIntent().putExtra(ChallengeControl.Key.IS_RISK_PHASE_2, true);
                                cardBindingOtpChallengeFragment2.getBaseActivity().getIntent().putExtra(ChallengeControl.Key.CASHIER_PAY_MODEL, onSuccessCashierPay.BuiltInFictitiousFunctionClassFactory);
                                CardBindingOtpChallengeFragment.lookAheadTest(cardBindingOtpChallengeFragment2);
                                CardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(cardBindingOtpChallengeFragment2);
                                obj2 = Unit.INSTANCE;
                            } else {
                                String str = onSuccessCashierPay.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
                                CashierPayParamModel cashierPayParamModel = new CashierPayParamModel(str == null ? "" : str, null, null, false, null, null, null, false, 254, null);
                                CardBindingViewModel cardBindingViewModel2 = cardBindingOtpChallengeFragment2.KClassImpl$Data$declaredNonStaticMembers$2;
                                CardBindingViewModel cardBindingViewModel3 = cardBindingViewModel2;
                                if (cardBindingViewModel2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    cardBindingViewModel3 = null;
                                }
                                cardBindingViewModel3.KClassImpl$Data$declaredNonStaticMembers$2(cashierPayParamModel);
                                obj2 = cashierPayParamModel;
                            }
                            if (obj2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return obj2;
                            }
                        } else if (cardBindingUiState instanceof CardBindingUiState.OnSuccessPayQuery) {
                            CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment3 = CardBindingOtpChallengeFragment.this;
                            cardBindingOtpChallengeFragment3.getBaseActivity().getIntent().putExtra(ChallengeControl.Key.IS_RISK_PHASE_2, false);
                            cardBindingOtpChallengeFragment3.getBaseActivity().getIntent().putExtra(ChallengeControl.Key.CASHIER_PAY_MODEL, ((CardBindingUiState.OnSuccessPayQuery) cardBindingUiState).BuiltInFictitiousFunctionClassFactory);
                            CardBindingOtpChallengeFragment.lookAheadTest(cardBindingOtpChallengeFragment3);
                            CardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(cardBindingOtpChallengeFragment3);
                        } else if (cardBindingUiState instanceof CardBindingUiState.ShowProgress) {
                            CardBindingOtpChallengeFragment.getErrorConfigVersion(CardBindingOtpChallengeFragment.this);
                        } else if (cardBindingUiState instanceof CardBindingUiState.DismissProgress) {
                            CardBindingOtpChallengeFragment.PlaceComponentResult(CardBindingOtpChallengeFragment.this);
                        } else if (cardBindingUiState instanceof CardBindingUiState.OnError) {
                            CardBindingOtpChallengeFragment.this.getAuthRequestContext(((CardBindingUiState.OnError) cardBindingUiState).BuiltInFictitiousFunctionClassFactory);
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
