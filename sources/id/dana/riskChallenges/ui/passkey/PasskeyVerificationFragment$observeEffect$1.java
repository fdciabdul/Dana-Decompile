package id.dana.riskChallenges.ui.passkey;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.domain.otp.model.VerifyOtpResponse;
import id.dana.network.exception.NetworkException;
import id.dana.passkey.GetPasskeyCallback;
import id.dana.passkey.Passkey;
import id.dana.passkey.exception.PasskeyException;
import id.dana.passkey.exception.UserCancellationException;
import id.dana.passkey.model.GetPasskeyResponse;
import id.dana.riskChallenges.domain.otp.interactor.VerifyOtp;
import id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$observeEffect$1;
import id.dana.riskChallenges.ui.passkey.PasskeyVerificationUiState;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.JSONExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$observeEffect$1", f = "PasskeyVerificationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class PasskeyVerificationFragment$observeEffect$1 extends SuspendLambda implements Function2<PasskeyVerificationUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PasskeyVerificationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasskeyVerificationFragment$observeEffect$1(PasskeyVerificationFragment passkeyVerificationFragment, Continuation<? super PasskeyVerificationFragment$observeEffect$1> continuation) {
        super(2, continuation);
        this.this$0 = passkeyVerificationFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PasskeyVerificationFragment$observeEffect$1 passkeyVerificationFragment$observeEffect$1 = new PasskeyVerificationFragment$observeEffect$1(this.this$0, continuation);
        passkeyVerificationFragment$observeEffect$1.L$0 = obj;
        return passkeyVerificationFragment$observeEffect$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PasskeyVerificationUiState passkeyVerificationUiState, Continuation<? super Unit> continuation) {
        return ((PasskeyVerificationFragment$observeEffect$1) create(passkeyVerificationUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PasskeyVerificationUiState passkeyVerificationUiState = (PasskeyVerificationUiState) this.L$0;
            if (passkeyVerificationUiState instanceof PasskeyVerificationUiState.OnPasskeyPromptOpen) {
                PasskeyVerificationViewModel scheduleImpl = PasskeyVerificationFragment.scheduleImpl(this.this$0);
                str = this.this$0.GetContactSyncConfig;
                str2 = this.this$0.lookAheadTest;
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                scheduleImpl.MyBillsEntityDataFactory.PlaceComponentResult(str, str2);
                Passkey KClassImpl$Data$declaredNonStaticMembers$2 = PasskeyVerificationFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0);
                String str3 = ((PasskeyVerificationUiState.OnPasskeyPromptOpen) passkeyVerificationUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                FragmentActivity requireActivity = this.this$0.requireActivity();
                ThreadExecutor threadExecutor = this.this$0.threadExecutor;
                if (threadExecutor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    threadExecutor = null;
                }
                KClassImpl$Data$declaredNonStaticMembers$2.login(str3, requireActivity, threadExecutor, new AnonymousClass1(this.this$0));
            } else if (passkeyVerificationUiState instanceof PasskeyVerificationUiState.LoginPasskeySucceed) {
                PasskeyVerificationFragment.BuiltInFictitiousFunctionClassFactory(this.this$0, ((PasskeyVerificationUiState.LoginPasskeySucceed) passkeyVerificationUiState).MyBillsEntityDataFactory);
            } else if (passkeyVerificationUiState instanceof PasskeyVerificationUiState.OnPasskeyAuthStartFailed) {
                PasskeyVerificationFragment.MyBillsEntityDataFactory(this.this$0).moveToNextValue();
            } else if (passkeyVerificationUiState instanceof PasskeyVerificationUiState.LoginPasskeyFailed) {
                DanaAlertDialog PlaceComponentResult = PasskeyVerificationFragment.PlaceComponentResult(this.this$0);
                FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                PlaceComponentResult.show(parentFragmentManager, "DanaAlertDialog");
            } else if (passkeyVerificationUiState instanceof PasskeyVerificationUiState.OnPasskeyAuthStartFailedRisk) {
                PasskeyVerificationFragment.MyBillsEntityDataFactory(this.this$0, ((PasskeyVerificationUiState.OnPasskeyAuthStartFailedRisk) passkeyVerificationUiState).PlaceComponentResult);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationFragment$observeEffect$1$1;", "Lid/dana/passkey/GetPasskeyCallback;", "Lid/dana/passkey/exception/PasskeyException;", "p0", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Lid/dana/passkey/exception/PasskeyException;)V", "Lid/dana/passkey/model/GetPasskeyResponse;", "onResult", "(Lid/dana/passkey/model/GetPasskeyResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$observeEffect$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 implements GetPasskeyCallback {
        final /* synthetic */ PasskeyVerificationFragment BuiltInFictitiousFunctionClassFactory;

        AnonymousClass1(PasskeyVerificationFragment passkeyVerificationFragment) {
            this.BuiltInFictitiousFunctionClassFactory = passkeyVerificationFragment;
        }

        @Override // id.dana.passkey.GetPasskeyCallback
        public final void onResult(final GetPasskeyResponse p0) {
            String str;
            String str2;
            String str3;
            String str4;
            Intrinsics.checkNotNullParameter(p0, "");
            PasskeyVerificationViewModel scheduleImpl = PasskeyVerificationFragment.scheduleImpl(this.BuiltInFictitiousFunctionClassFactory);
            str = this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig;
            str2 = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter("TRUE", "");
            scheduleImpl.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(str, str2, "TRUE");
            final PasskeyVerificationViewModel scheduleImpl2 = PasskeyVerificationFragment.scheduleImpl(this.BuiltInFictitiousFunctionClassFactory);
            str3 = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
            str4 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(p0, "");
            VerifyOtp verifyOtp = scheduleImpl2.getAuthRequestContext;
            VerifyOtp.Params.Companion companion = VerifyOtp.Params.INSTANCE;
            verifyOtp.execute(VerifyOtp.Params.Companion.getAuthRequestContext(JSONExtKt.PlaceComponentResult().toJson(p0), str3, str4, "PASSKEYS", "LOGIN", null, 96), new Function1<VerifyOtpResponse, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationViewModel$startOtpVerify$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(VerifyOtpResponse verifyOtpResponse) {
                    invoke2(verifyOtpResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(VerifyOtpResponse verifyOtpResponse) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    String id2;
                    Intrinsics.checkNotNullParameter(verifyOtpResponse, "");
                    mutableStateFlow = PasskeyVerificationViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    GetPasskeyResponse getPasskeyResponse = p0;
                    do {
                        value = mutableStateFlow.getValue();
                        PasskeyVerificationUiState passkeyVerificationUiState = (PasskeyVerificationUiState) value;
                        id2 = getPasskeyResponse.getId();
                        Intrinsics.checkNotNullExpressionValue(id2, "");
                    } while (!mutableStateFlow.compareAndSet(value, new PasskeyVerificationUiState.LoginPasskeySucceed(id2)));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationViewModel$startOtpVerify$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    MutableStateFlow mutableStateFlow2;
                    Object value2;
                    Intrinsics.checkNotNullParameter(th, "");
                    if (th instanceof NetworkException) {
                        mutableStateFlow2 = PasskeyVerificationViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            PasskeyVerificationUiState passkeyVerificationUiState = (PasskeyVerificationUiState) value2;
                        } while (!mutableStateFlow2.compareAndSet(value2, new PasskeyVerificationUiState.OnPasskeyAuthStartFailedRisk(th)));
                        return;
                    }
                    mutableStateFlow = PasskeyVerificationViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    do {
                        value = mutableStateFlow.getValue();
                        PasskeyVerificationUiState passkeyVerificationUiState2 = (PasskeyVerificationUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new PasskeyVerificationUiState.LoginPasskeyFailed(th)));
                }
            });
        }

        @Override // id.dana.passkey.GetPasskeyCallback
        public final void onError(PasskeyException p0) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(p0, "");
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
            PasskeyException passkeyException = p0;
            Intrinsics.checkNotNullParameter(passkeyException, "");
            authRequestContext.getAuthRequestContext.recordException(passkeyException);
            PasskeyVerificationViewModel scheduleImpl = PasskeyVerificationFragment.scheduleImpl(this.BuiltInFictitiousFunctionClassFactory);
            str = this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig;
            str2 = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter("FALSE", "");
            scheduleImpl.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(str, str2, "FALSE");
            if (p0 instanceof UserCancellationException) {
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(passkeyException);
                return;
            }
            FragmentActivity activity = this.BuiltInFictitiousFunctionClassFactory.getActivity();
            if (activity != null) {
                final PasskeyVerificationFragment passkeyVerificationFragment = this.BuiltInFictitiousFunctionClassFactory;
                activity.runOnUiThread(new Runnable() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$observeEffect$1$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PasskeyVerificationFragment$observeEffect$1.AnonymousClass1.PlaceComponentResult(PasskeyVerificationFragment.this);
                    }
                });
            }
        }

        public static /* synthetic */ void PlaceComponentResult(PasskeyVerificationFragment passkeyVerificationFragment) {
            Intrinsics.checkNotNullParameter(passkeyVerificationFragment, "");
            PasskeyVerificationFragment.MyBillsEntityDataFactory(passkeyVerificationFragment).moveToNextValue();
        }
    }
}
