package id.dana.riskChallenges.ui.otp.otpsms;

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
@DebugMetadata(c = "id.dana.riskChallenges.ui.otp.otpsms.OtpSmsSharedLogicHandler$observeUiState$1", f = "OtpSmsSharedLogicHandler.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class OtpSmsSharedLogicHandler$observeUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $owner;
    int label;
    final /* synthetic */ OtpSmsSharedLogicHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtpSmsSharedLogicHandler$observeUiState$1(LifecycleOwner lifecycleOwner, OtpSmsSharedLogicHandler otpSmsSharedLogicHandler, Continuation<? super OtpSmsSharedLogicHandler$observeUiState$1> continuation) {
        super(2, continuation);
        this.$owner = lifecycleOwner;
        this.this$0 = otpSmsSharedLogicHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OtpSmsSharedLogicHandler$observeUiState$1(this.$owner, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OtpSmsSharedLogicHandler$observeUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.riskChallenges.ui.otp.otpsms.OtpSmsSharedLogicHandler$observeUiState$1$1", f = "OtpSmsSharedLogicHandler.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.riskChallenges.ui.otp.otpsms.OtpSmsSharedLogicHandler$observeUiState$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OtpSmsSharedLogicHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OtpSmsSharedLogicHandler otpSmsSharedLogicHandler, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = otpSmsSharedLogicHandler;
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
                StateFlow<OtpChallengeUIState> stateFlow = OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(this.this$0).NetworkUserEntityData$$ExternalSyntheticLambda7;
                final OtpSmsSharedLogicHandler otpSmsSharedLogicHandler = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.riskChallenges.ui.otp.otpsms.OtpSmsSharedLogicHandler.observeUiState.1.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r1v1 */
                    /* JADX WARN: Type inference failed for: r1v7 */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
                    public final Object emit(OtpChallengeUIState otpChallengeUIState, Continuation<? super Unit> continuation) {
                        Fragment fragment;
                        Fragment fragment2;
                        boolean z;
                        LayoutOtpVerifyBinding layoutOtpVerifyBinding;
                        RetryAndTimerView retryAndTimerView;
                        if (otpChallengeUIState instanceof OtpChallengeUIState.OnSuccessRequestOtp) {
                            OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                            OtpSmsSharedLogicHandler.getAuthRequestContext(OtpSmsSharedLogicHandler.this, ((OtpChallengeUIState.OnSuccessRequestOtp) otpChallengeUIState).MyBillsEntityDataFactory);
                        } else {
                            if (otpChallengeUIState instanceof OtpChallengeUIState.ShowProgress) {
                                z = OtpSmsSharedLogicHandler.this.getAuthRequestContext;
                                if (z) {
                                    layoutOtpVerifyBinding = OtpSmsSharedLogicHandler.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                    if (layoutOtpVerifyBinding != null && (retryAndTimerView = layoutOtpVerifyBinding.getAuthRequestContext) != null) {
                                        retryAndTimerView.setLoadingView(true);
                                        r1 = Unit.INSTANCE;
                                    }
                                    if (r1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        return r1;
                                    }
                                } else {
                                    DanaLogoLoadingDialog DatabaseTableConfigUtil = OtpSmsSharedLogicHandler.DatabaseTableConfigUtil(OtpSmsSharedLogicHandler.this);
                                    if (!DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
                                        DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2.show();
                                        DatabaseTableConfigUtil.MyBillsEntityDataFactory.startRefresh();
                                    }
                                }
                            } else if (otpChallengeUIState instanceof OtpChallengeUIState.DismissProgress) {
                                OtpSmsSharedLogicHandler.DatabaseTableConfigUtil(OtpSmsSharedLogicHandler.this).PlaceComponentResult();
                            } else {
                                if (otpChallengeUIState instanceof OtpChallengeUIState.OnErrorRequestOtp) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpSmsSharedLogicHandler otpSmsSharedLogicHandler2 = OtpSmsSharedLogicHandler.this;
                                    fragment2 = otpSmsSharedLogicHandler2.PlaceComponentResult;
                                    Context context = fragment2.getContext();
                                    r1 = context != null ? StringWrapperKt.getAuthRequestContext(context, ((OtpChallengeUIState.OnErrorRequestOtp) otpChallengeUIState).getAuthRequestContext) : 0;
                                    OtpSmsSharedLogicHandler.KClassImpl$Data$declaredNonStaticMembers$2(otpSmsSharedLogicHandler2, r1 != null ? r1 : "");
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.OnErrorFirstTimeRequestOtp) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpSmsSharedLogicHandler otpSmsSharedLogicHandler3 = OtpSmsSharedLogicHandler.this;
                                    fragment = otpSmsSharedLogicHandler3.PlaceComponentResult;
                                    Context context2 = fragment.getContext();
                                    r1 = context2 != null ? StringWrapperKt.getAuthRequestContext(context2, ((OtpChallengeUIState.OnErrorFirstTimeRequestOtp) otpChallengeUIState).MyBillsEntityDataFactory) : 0;
                                    OtpSmsSharedLogicHandler.MyBillsEntityDataFactory(otpSmsSharedLogicHandler3, r1 != 0 ? r1 : "");
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.OnAutoFillSmsOtp) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).MyBillsEntityDataFactory(((OtpChallengeUIState.OnAutoFillSmsOtp) otpChallengeUIState).getAuthRequestContext);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.OnErrorDailyLimit) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda8(OtpSmsSharedLogicHandler.this);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifyProgress) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda6(OtpSmsSharedLogicHandler.this);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifyFailed) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpSmsSharedLogicHandler.BuiltInFictitiousFunctionClassFactory(OtpSmsSharedLogicHandler.this, ((OtpChallengeUIState.VerifyFailed) otpChallengeUIState).BuiltInFictitiousFunctionClassFactory);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifyInvalidOtp) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpSmsSharedLogicHandler.PrepareContext(OtpSmsSharedLogicHandler.this);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifyExpired) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda7(OtpSmsSharedLogicHandler.this);
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.VerifySuccess) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                                    Object PlaceComponentResult = OtpSmsSharedLogicHandler.PlaceComponentResult(OtpSmsSharedLogicHandler.this, ((OtpChallengeUIState.VerifySuccess) otpChallengeUIState).getAuthRequestContext, continuation);
                                    return PlaceComponentResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? PlaceComponentResult : Unit.INSTANCE;
                                } else if (otpChallengeUIState instanceof OtpChallengeUIState.TooManyVerifyOtp) {
                                    OtpSmsSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda1(OtpSmsSharedLogicHandler.this).initRecordTimeStamp();
                                    OtpSmsSharedLogicHandler.isLayoutRequested(OtpSmsSharedLogicHandler.this);
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
