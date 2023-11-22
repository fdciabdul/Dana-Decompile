package id.dana.cardbinding.activity;

import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.R;
import id.dana.cardbinding.viewmodel.OtpCardBindingUiState;
import id.dana.cashier.VerificationMethod;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import id.dana.databinding.ActivityCardBindingCameraBinding;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.utils.DANAToast;
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

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.cardbinding.activity.CardBindingCameraActivity$observeOtpUiState$1", f = "CardBindingCameraActivity.kt", i = {}, l = {347}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class CardBindingCameraActivity$observeOtpUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CardBindingCameraActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBindingCameraActivity$observeOtpUiState$1(CardBindingCameraActivity cardBindingCameraActivity, Continuation<? super CardBindingCameraActivity$observeOtpUiState$1> continuation) {
        super(2, continuation);
        this.this$0 = cardBindingCameraActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardBindingCameraActivity$observeOtpUiState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CardBindingCameraActivity$observeOtpUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.cardbinding.activity.CardBindingCameraActivity$observeOtpUiState$1$1", f = "CardBindingCameraActivity.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.cardbinding.activity.CardBindingCameraActivity$observeOtpUiState$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CardBindingCameraActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CardBindingCameraActivity cardBindingCameraActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = cardBindingCameraActivity;
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
                StateFlow<OtpCardBindingUiState> stateFlow = this.this$0.getOtpVm().moveToNextValue;
                final CardBindingCameraActivity cardBindingCameraActivity = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity.observeOtpUiState.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
                    public final Object emit(OtpCardBindingUiState otpCardBindingUiState, Continuation<? super Unit> continuation) {
                        String str;
                        String str2;
                        ActivityCardBindingCameraBinding binding;
                        String str3;
                        CardBindingCameraActivity cardBindingCameraActivity2 = CardBindingCameraActivity.this;
                        if (otpCardBindingUiState instanceof OtpCardBindingUiState.OnVerifyBankPhoneOtp) {
                            OtpCardBindingUiState.OnVerifyBankPhoneOtp onVerifyBankPhoneOtp = (OtpCardBindingUiState.OnVerifyBankPhoneOtp) otpCardBindingUiState;
                            cardBindingCameraActivity2.MyBillsEntityDataFactory(VerificationMethod.BANK_OTP, Boxing.boxInt(onVerifyBankPhoneOtp.PlaceComponentResult), Boxing.boxInt(onVerifyBankPhoneOtp.KClassImpl$Data$declaredNonStaticMembers$2));
                        } else {
                            if (otpCardBindingUiState instanceof OtpCardBindingUiState.OnSuccessSendOtp) {
                                str3 = cardBindingCameraActivity2.NetworkUserEntityData$$ExternalSyntheticLambda8;
                                OtpCardBindingUiState.OnSuccessSendOtp onSuccessSendOtp = (OtpCardBindingUiState.OnSuccessSendOtp) otpCardBindingUiState;
                                cardBindingCameraActivity2.MyBillsEntityDataFactory(str3 != null ? str3 : "", Boxing.boxInt(onSuccessSendOtp.PlaceComponentResult), Boxing.boxInt(onSuccessSendOtp.KClassImpl$Data$declaredNonStaticMembers$2));
                            } else {
                                boolean z = otpCardBindingUiState instanceof OtpCardBindingUiState.OnErrorSendOtp;
                                if (z ? true : otpCardBindingUiState instanceof OtpCardBindingUiState.OnError) {
                                    if (z) {
                                        str = ((OtpCardBindingUiState.OnErrorSendOtp) otpCardBindingUiState).getAuthRequestContext;
                                    } else {
                                        str = ((OtpCardBindingUiState.OnError) otpCardBindingUiState).MyBillsEntityDataFactory;
                                    }
                                    DANAToast dANAToast = DANAToast.PlaceComponentResult;
                                    CardBindingCameraActivity cardBindingCameraActivity3 = cardBindingCameraActivity2;
                                    if (str == null) {
                                        str2 = cardBindingCameraActivity2.getString(R.string.card_binding_cashier_main_error_description);
                                        Intrinsics.checkNotNullExpressionValue(str2, "");
                                    } else {
                                        str2 = str;
                                    }
                                    DANAToast.PlaceComponentResult(cardBindingCameraActivity3, str2);
                                    binding = cardBindingCameraActivity2.getBinding();
                                    QueryCardPolicyInfoModel queryCardPolicyInfoModel = binding.SubSequence.getQueryCardPolicyInfoModel();
                                    String str4 = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.initRecordTimeStamp : null;
                                    cardBindingCameraActivity2.PlaceComponentResult(str4 != null ? str4 : "", str);
                                } else if (otpCardBindingUiState instanceof OtpCardBindingUiState.ShowProgress) {
                                    DanaLoadingDialog access$getDanaLoadingDialog = CardBindingCameraActivity.access$getDanaLoadingDialog(cardBindingCameraActivity2);
                                    if (!access$getDanaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                                        access$getDanaLoadingDialog.MyBillsEntityDataFactory.show();
                                        access$getDanaLoadingDialog.getAuthRequestContext.startRefresh();
                                    }
                                } else if (otpCardBindingUiState instanceof OtpCardBindingUiState.DismissProgress) {
                                    CardBindingCameraActivity.access$getDanaLoadingDialog(cardBindingCameraActivity2).PlaceComponentResult();
                                }
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
