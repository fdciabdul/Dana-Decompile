package id.dana.cardbinding.fragment;

import android.content.Intent;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.R;
import id.dana.cardbinding.viewmodel.OtpCardBindingUiState;
import id.dana.cardbinding.viewmodel.OtpCardBindingViewModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.challenge.ChallengeControl;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.utils.KeyboardHelper;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$observeOtpUiState$1", f = "CardBindingOtpChallengeFragment.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class CardBindingOtpChallengeFragment$observeOtpUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CardBindingOtpChallengeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBindingOtpChallengeFragment$observeOtpUiState$1(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment, Continuation<? super CardBindingOtpChallengeFragment$observeOtpUiState$1> continuation) {
        super(2, continuation);
        this.this$0 = cardBindingOtpChallengeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardBindingOtpChallengeFragment$observeOtpUiState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CardBindingOtpChallengeFragment$observeOtpUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$observeOtpUiState$1$1", f = "CardBindingOtpChallengeFragment.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$observeOtpUiState$1$1  reason: invalid class name */
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
                OtpCardBindingViewModel otpCardBindingViewModel = this.this$0.moveToNextValue;
                if (otpCardBindingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    otpCardBindingViewModel = null;
                }
                StateFlow<OtpCardBindingUiState> stateFlow = otpCardBindingViewModel.moveToNextValue;
                final CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment.observeOtpUiState.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
                    public final Object emit(OtpCardBindingUiState otpCardBindingUiState, Continuation<? super Unit> continuation) {
                        String str;
                        SendBankOtpModel sendBankOtpModel;
                        if (otpCardBindingUiState instanceof OtpCardBindingUiState.OnSuccessCashierAgreement) {
                            OtpCardBindingUiState.OnSuccessCashierAgreement onSuccessCashierAgreement = (OtpCardBindingUiState.OnSuccessCashierAgreement) otpCardBindingUiState;
                            AttributeCashierPayModel attributeCashierPayModel = new AttributeCashierPayModel(onSuccessCashierAgreement.getAuthRequestContext.PlaceComponentResult, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null);
                            sendBankOtpModel = CardBindingOtpChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            CashierPayModel cashierPayModel = new CashierPayModel(attributeCashierPayModel, sendBankOtpModel != null ? sendBankOtpModel.moveToNextValue : null, Boxing.boxBoolean(true), null, null);
                            Intent intent = CardBindingOtpChallengeFragment.this.getBaseActivity().getIntent();
                            intent.putExtra(ChallengeControl.Key.CASHIER_PAY_MODEL, cashierPayModel);
                            intent.putExtra(ChallengeControl.Key.CASHIER_AGREEMENT_MODEL, onSuccessCashierAgreement.getAuthRequestContext);
                            CardBindingOtpChallengeFragment.lookAheadTest(CardBindingOtpChallengeFragment.this);
                            CardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(CardBindingOtpChallengeFragment.this);
                        } else if (otpCardBindingUiState instanceof OtpCardBindingUiState.OnVerifyBankPhoneOtp) {
                            CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment2 = CardBindingOtpChallengeFragment.this;
                            OtpCardBindingUiState.OnVerifyBankPhoneOtp onVerifyBankPhoneOtp = (OtpCardBindingUiState.OnVerifyBankPhoneOtp) otpCardBindingUiState;
                            cardBindingOtpChallengeFragment2.initRecordTimeStamp = onVerifyBankPhoneOtp.KClassImpl$Data$declaredNonStaticMembers$2;
                            CardBindingOtpChallengeFragment.getAuthRequestContext(cardBindingOtpChallengeFragment2, onVerifyBankPhoneOtp.PlaceComponentResult);
                            CardBindingOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(cardBindingOtpChallengeFragment2);
                        } else if (otpCardBindingUiState instanceof OtpCardBindingUiState.OnSuccessSendOtp) {
                            CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment3 = CardBindingOtpChallengeFragment.this;
                            OtpCardBindingUiState.OnSuccessSendOtp onSuccessSendOtp = (OtpCardBindingUiState.OnSuccessSendOtp) otpCardBindingUiState;
                            cardBindingOtpChallengeFragment3.initRecordTimeStamp = onSuccessSendOtp.KClassImpl$Data$declaredNonStaticMembers$2;
                            CardBindingOtpChallengeFragment.getAuthRequestContext(cardBindingOtpChallengeFragment3, onSuccessSendOtp.PlaceComponentResult);
                            CardBindingOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(cardBindingOtpChallengeFragment3);
                        } else {
                            boolean z = otpCardBindingUiState instanceof OtpCardBindingUiState.OnErrorSendOtp;
                            if (z ? true : otpCardBindingUiState instanceof OtpCardBindingUiState.OnError) {
                                if (z) {
                                    str = ((OtpCardBindingUiState.OnErrorSendOtp) otpCardBindingUiState).getAuthRequestContext;
                                } else {
                                    str = ((OtpCardBindingUiState.OnError) otpCardBindingUiState).MyBillsEntityDataFactory;
                                }
                                CardBindingOtpChallengeFragment.this.getAuthRequestContext(str);
                                PinEntryEditText pinEntryEditText = (PinEntryEditText) CardBindingOtpChallengeFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k);
                                if (pinEntryEditText != null) {
                                    pinEntryEditText.setVisibility(0);
                                }
                            } else if (otpCardBindingUiState instanceof OtpCardBindingUiState.OnSmsReceived) {
                                CardBindingOtpChallengeFragment.this.startActivityForResult((Intent) ((OtpCardBindingUiState.OnSmsReceived) otpCardBindingUiState).MyBillsEntityDataFactory.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT"), 1);
                                KeyboardHelper.BuiltInFictitiousFunctionClassFactory((PinEntryEditText) CardBindingOtpChallengeFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k));
                            } else if (otpCardBindingUiState instanceof OtpCardBindingUiState.ShowProgress) {
                                CardBindingOtpChallengeFragment.getErrorConfigVersion(CardBindingOtpChallengeFragment.this);
                            } else if (otpCardBindingUiState instanceof OtpCardBindingUiState.DismissProgress) {
                                CardBindingOtpChallengeFragment.PlaceComponentResult(CardBindingOtpChallengeFragment.this);
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
