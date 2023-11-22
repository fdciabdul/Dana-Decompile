package id.dana.riskChallenges.ui.otp.otpwhatsapp;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.richview.RetryAndTimerView;
import id.dana.riskChallenges.databinding.LayoutOtpVerifyBinding;
import id.dana.riskChallenges.ui.otp.OtpChallengeUIState;
import id.dana.utils.StringWrapperKt;
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
@DebugMetadata(c = "id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$observeUiState$1", f = "OtpWhatsappSharedLogicHandler.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class OtpWhatsappSharedLogicHandler$observeUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $owner;
    int label;
    final /* synthetic */ OtpWhatsappSharedLogicHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtpWhatsappSharedLogicHandler$observeUiState$1(LifecycleOwner lifecycleOwner, OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler, Continuation<? super OtpWhatsappSharedLogicHandler$observeUiState$1> continuation) {
        super(2, continuation);
        this.$owner = lifecycleOwner;
        this.this$0 = otpWhatsappSharedLogicHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OtpWhatsappSharedLogicHandler$observeUiState$1(this.$owner, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OtpWhatsappSharedLogicHandler$observeUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$observeUiState$1$1", f = "OtpWhatsappSharedLogicHandler.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$observeUiState$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OtpWhatsappSharedLogicHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = otpWhatsappSharedLogicHandler;
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
                StateFlow<OtpChallengeUIState> stateFlow = OtpWhatsappSharedLogicHandler.initRecordTimeStamp(this.this$0).NetworkUserEntityData$$ExternalSyntheticLambda7;
                final OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler.observeUiState.1.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r1v1 */
                    /* JADX WARN: Type inference failed for: r1v7 */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
                    public final Object emit(OtpChallengeUIState otpChallengeUIState, Continuation<? super Unit> continuation) {
                        Fragment fragment;
                        Fragment fragment2;
                        boolean z;
                        LayoutOtpVerifyBinding layoutOtpVerifyBinding;
                        RetryAndTimerView retryAndTimerView;
                        if (otpChallengeUIState instanceof OtpChallengeUIState.OnSuccessRequestOtp) {
                            OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).initRecordTimeStamp();
                            OtpWhatsappSharedLogicHandler.KClassImpl$Data$declaredNonStaticMembers$2(OtpWhatsappSharedLogicHandler.this, ((OtpChallengeUIState.OnSuccessRequestOtp) otpChallengeUIState).MyBillsEntityDataFactory);
                        } else {
                            if (otpChallengeUIState instanceof OtpChallengeUIState.ShowProgress) {
                                z = OtpWhatsappSharedLogicHandler.this.PlaceComponentResult;
                                if (z) {
                                    layoutOtpVerifyBinding = OtpWhatsappSharedLogicHandler.this.BuiltInFictitiousFunctionClassFactory;
                                    if (layoutOtpVerifyBinding != null && (retryAndTimerView = layoutOtpVerifyBinding.getAuthRequestContext) != null) {
                                        retryAndTimerView.setLoadingView(true);
                                        r1 = Unit.INSTANCE;
                                    }
                                    if (r1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        return r1;
                                    }
                                } else {
                                    DanaLogoLoadingDialog moveToNextValue = OtpWhatsappSharedLogicHandler.moveToNextValue(OtpWhatsappSharedLogicHandler.this);
                                    if (!moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
                                        moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.show();
                                        moveToNextValue.MyBillsEntityDataFactory.startRefresh();
                                    }
                                }
                            } else if (otpChallengeUIState instanceof OtpChallengeUIState.DismissProgress) {
                                OtpWhatsappSharedLogicHandler.moveToNextValue(OtpWhatsappSharedLogicHandler.this).PlaceComponentResult();
                            } else {
                                if (otpChallengeUIState instanceof OtpChallengeUIState.OnErrorRequestOtp) {
                                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler2 = OtpWhatsappSharedLogicHandler.this;
                                    fragment2 = otpWhatsappSharedLogicHandler2.getAuthRequestContext;
                                    Context context = fragment2.getContext();
                                    r1 = context != null ? StringWrapperKt.getAuthRequestContext(context, ((OtpChallengeUIState.OnErrorRequestOtp) otpChallengeUIState).getAuthRequestContext) : 0;
                                    OtpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory(otpWhatsappSharedLogicHandler2, r1 != null ? r1 : "");
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.OnErrorFirstTimeRequestOtp) {
                                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler3 = OtpWhatsappSharedLogicHandler.this;
                                    fragment = otpWhatsappSharedLogicHandler3.getAuthRequestContext;
                                    Context context2 = fragment.getContext();
                                    r1 = context2 != null ? StringWrapperKt.getAuthRequestContext(context2, ((OtpChallengeUIState.OnErrorFirstTimeRequestOtp) otpChallengeUIState).MyBillsEntityDataFactory) : 0;
                                    OtpWhatsappSharedLogicHandler.MyBillsEntityDataFactory(otpWhatsappSharedLogicHandler3, r1 != 0 ? r1 : "");
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.OnAutoFillSmsOtp) {
                                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).MyBillsEntityDataFactory(((OtpChallengeUIState.OnAutoFillSmsOtp) otpChallengeUIState).getAuthRequestContext);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.OnErrorDailyLimit) {
                                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpWhatsappSharedLogicHandler.isLayoutRequested(OtpWhatsappSharedLogicHandler.this);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifyFailed) {
                                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpWhatsappSharedLogicHandler.getAuthRequestContext(OtpWhatsappSharedLogicHandler.this, ((OtpChallengeUIState.VerifyFailed) otpChallengeUIState).BuiltInFictitiousFunctionClassFactory);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifyInvalidOtp) {
                                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpWhatsappSharedLogicHandler.PrepareContext(OtpWhatsappSharedLogicHandler.this);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifyExpired) {
                                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpWhatsappSharedLogicHandler.DatabaseTableConfigUtil(OtpWhatsappSharedLogicHandler.this);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifySuccess) {
                                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).initRecordTimeStamp();
                                    Object authRequestContext = OtpWhatsappSharedLogicHandler.getAuthRequestContext(OtpWhatsappSharedLogicHandler.this, ((OtpChallengeUIState.VerifySuccess) otpChallengeUIState).getAuthRequestContext, continuation);
                                    return authRequestContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? authRequestContext : Unit.INSTANCE;
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.TooManyVerifyOtp) {
                                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpWhatsappSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda8(OtpWhatsappSharedLogicHandler.this);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifyProgress) {
                                    OtpWhatsappSharedLogicHandler.newProxyInstance(OtpWhatsappSharedLogicHandler.this);
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
            if (RepeatOnLifecycleKt.KClassImpl$Data$declaredNonStaticMembers$2(this.$owner, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
