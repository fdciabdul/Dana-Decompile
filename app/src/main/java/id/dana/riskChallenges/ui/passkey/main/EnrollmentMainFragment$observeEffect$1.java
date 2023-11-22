package id.dana.riskChallenges.ui.passkey.main;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.domain.core.usecase.NoParams;
import id.dana.passkey.CreatePasskeyCallback;
import id.dana.passkey.Passkey;
import id.dana.passkey.exception.PasskeyException;
import id.dana.passkey.model.CreatePasskeyResponse;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyFinish;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCeremony;
import id.dana.riskChallenges.ui.passkey.EnrollmentSuccessFragment;
import id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$observeEffect$1;
import id.dana.riskChallenges.ui.passkey.main.EnrollmentMainUiState;
import id.dana.utils.concurrent.ThreadExecutor;
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

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$observeEffect$1", f = "EnrollmentMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EnrollmentMainFragment$observeEffect$1 extends SuspendLambda implements Function2<EnrollmentMainUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EnrollmentMainFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnrollmentMainFragment$observeEffect$1(EnrollmentMainFragment enrollmentMainFragment, Continuation<? super EnrollmentMainFragment$observeEffect$1> continuation) {
        super(2, continuation);
        this.this$0 = enrollmentMainFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EnrollmentMainFragment$observeEffect$1 enrollmentMainFragment$observeEffect$1 = new EnrollmentMainFragment$observeEffect$1(this.this$0, continuation);
        enrollmentMainFragment$observeEffect$1.L$0 = obj;
        return enrollmentMainFragment$observeEffect$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(EnrollmentMainUiState enrollmentMainUiState, Continuation<? super Unit> continuation) {
        return ((EnrollmentMainFragment$observeEffect$1) create(enrollmentMainUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            EnrollmentMainUiState enrollmentMainUiState = (EnrollmentMainUiState) this.L$0;
            ThreadExecutor threadExecutor = null;
            if (!Intrinsics.areEqual(enrollmentMainUiState, EnrollmentMainUiState.GotoEnrollmentSuccess.INSTANCE)) {
                if (enrollmentMainUiState instanceof EnrollmentMainUiState.OnPasskeyEnrollmentStartFailedRisk) {
                    this.this$0.getErrorConfigVersion = "";
                    EnrollmentMainFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, ((EnrollmentMainUiState.OnPasskeyEnrollmentStartFailedRisk) enrollmentMainUiState).getAuthRequestContext);
                } else if (enrollmentMainUiState instanceof EnrollmentMainUiState.OnPasskeyEnrollmentStartFailed) {
                    this.this$0.getErrorConfigVersion = "";
                    EnrollmentMainFragment.scheduleImpl(this.this$0).moveToNextValue();
                } else if (enrollmentMainUiState instanceof EnrollmentMainUiState.OnPasskeyEnrollmentFinishFailed) {
                    this.this$0.getErrorConfigVersion = "";
                    DanaAlertDialog BuiltInFictitiousFunctionClassFactory = EnrollmentMainFragment.BuiltInFictitiousFunctionClassFactory(this.this$0);
                    FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                    Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                    BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
                } else if (enrollmentMainUiState instanceof EnrollmentMainUiState.OnPasskeyPromptOpen) {
                    EnrollmentMainViewModel NetworkUserEntityData$$ExternalSyntheticLambda1 = EnrollmentMainFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(this.this$0);
                    str = this.this$0.lookAheadTest;
                    str2 = this.this$0.scheduleImpl;
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    NetworkUserEntityData$$ExternalSyntheticLambda1.lookAheadTest.PlaceComponentResult(str, str2);
                    Passkey NetworkUserEntityData$$ExternalSyntheticLambda0 = EnrollmentMainFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(this.this$0);
                    String str3 = ((EnrollmentMainUiState.OnPasskeyPromptOpen) enrollmentMainUiState).BuiltInFictitiousFunctionClassFactory;
                    FragmentActivity requireActivity = this.this$0.requireActivity();
                    ThreadExecutor threadExecutor2 = this.this$0.threadExecutor;
                    if (threadExecutor2 != null) {
                        threadExecutor = threadExecutor2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    NetworkUserEntityData$$ExternalSyntheticLambda0.register(str3, requireActivity, threadExecutor, new AnonymousClass1(this.this$0));
                } else if (enrollmentMainUiState instanceof EnrollmentMainUiState.OnPasskeyPromptNeedVerificationMethods) {
                    EnrollmentMainFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, ((EnrollmentMainUiState.OnPasskeyPromptNeedVerificationMethods) enrollmentMainUiState).MyBillsEntityDataFactory);
                }
            } else {
                FragmentTransaction beginTransaction = EnrollmentMainFragment.moveToNextValue(this.this$0).PlaceComponentResult.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
                FragmentExtKt.BuiltInFictitiousFunctionClassFactory(beginTransaction);
                Intrinsics.checkNotNullExpressionValue(beginTransaction.MyBillsEntityDataFactory(R.id.initRecordTimeStamp, EnrollmentSuccessFragment.class, null, null), "");
                if (!beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                }
                beginTransaction.scheduleImpl = true;
                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
                beginTransaction.getAuthRequestContext();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainFragment$observeEffect$1$1;", "Lid/dana/passkey/CreatePasskeyCallback;", "Lid/dana/passkey/exception/PasskeyException;", "p0", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Lid/dana/passkey/exception/PasskeyException;)V", "Lid/dana/passkey/model/CreatePasskeyResponse;", "onResult", "(Lid/dana/passkey/model/CreatePasskeyResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$observeEffect$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 implements CreatePasskeyCallback {
        final /* synthetic */ EnrollmentMainFragment BuiltInFictitiousFunctionClassFactory;

        AnonymousClass1(EnrollmentMainFragment enrollmentMainFragment) {
            this.BuiltInFictitiousFunctionClassFactory = enrollmentMainFragment;
        }

        @Override // id.dana.passkey.CreatePasskeyCallback
        public final void onResult(CreatePasskeyResponse p0) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(p0, "");
            EnrollmentMainViewModel NetworkUserEntityData$$ExternalSyntheticLambda1 = EnrollmentMainFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(this.BuiltInFictitiousFunctionClassFactory);
            str = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
            str2 = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter("TRUE", "");
            NetworkUserEntityData$$ExternalSyntheticLambda1.lookAheadTest.BuiltInFictitiousFunctionClassFactory(str, str2, "TRUE");
            final EnrollmentMainViewModel NetworkUserEntityData$$ExternalSyntheticLambda12 = EnrollmentMainFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(this.BuiltInFictitiousFunctionClassFactory);
            Intrinsics.checkNotNullParameter(p0, "");
            PasskeyCeremonyFinish passkeyCeremonyFinish = NetworkUserEntityData$$ExternalSyntheticLambda12.PlaceComponentResult;
            PasskeyCeremony.Type.Registration registration = PasskeyCeremony.Type.Registration.INSTANCE;
            Object json = JSON.toJSON(p0);
            if (json != null) {
                passkeyCeremonyFinish.execute(new PasskeyCeremony.Params(registration, (JSONObject) json, null, null, 12, null), new Function1<NoParams, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainViewModel$startPasskeyCeremonyFinish$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(NoParams noParams) {
                        invoke2(noParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(NoParams noParams) {
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(noParams, "");
                        mutableStateFlow = EnrollmentMainViewModel.this.BuiltInFictitiousFunctionClassFactory;
                        do {
                            value = mutableStateFlow.getValue();
                            EnrollmentMainUiState enrollmentMainUiState = (EnrollmentMainUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, EnrollmentMainUiState.GotoEnrollmentSuccess.INSTANCE));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainViewModel$startPasskeyCeremonyFinish$2
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
                        Intrinsics.checkNotNullParameter(th, "");
                        mutableStateFlow = EnrollmentMainViewModel.this.BuiltInFictitiousFunctionClassFactory;
                        do {
                            value = mutableStateFlow.getValue();
                            EnrollmentMainUiState enrollmentMainUiState = (EnrollmentMainUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new EnrollmentMainUiState.OnPasskeyEnrollmentFinishFailed()));
                    }
                });
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        }

        @Override // id.dana.passkey.CreatePasskeyCallback
        public final void onError(PasskeyException p0) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(p0, "");
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
            PasskeyException passkeyException = p0;
            Intrinsics.checkNotNullParameter(passkeyException, "");
            authRequestContext.getAuthRequestContext.recordException(passkeyException);
            EnrollmentMainViewModel NetworkUserEntityData$$ExternalSyntheticLambda1 = EnrollmentMainFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(this.BuiltInFictitiousFunctionClassFactory);
            str = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
            str2 = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter("FALSE", "");
            NetworkUserEntityData$$ExternalSyntheticLambda1.lookAheadTest.BuiltInFictitiousFunctionClassFactory(str, str2, "FALSE");
            this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = "";
            FragmentActivity activity = this.BuiltInFictitiousFunctionClassFactory.getActivity();
            if (activity != null) {
                final EnrollmentMainFragment enrollmentMainFragment = this.BuiltInFictitiousFunctionClassFactory;
                activity.runOnUiThread(new Runnable() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$observeEffect$1$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        EnrollmentMainFragment$observeEffect$1.AnonymousClass1.getAuthRequestContext(EnrollmentMainFragment.this);
                    }
                });
            }
        }

        public static /* synthetic */ void getAuthRequestContext(EnrollmentMainFragment enrollmentMainFragment) {
            Intrinsics.checkNotNullParameter(enrollmentMainFragment, "");
            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = EnrollmentMainFragment.BuiltInFictitiousFunctionClassFactory(enrollmentMainFragment);
            FragmentManager parentFragmentManager = enrollmentMainFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            Intrinsics.checkNotNullParameter(parentFragmentManager, "");
            BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
        }
    }
}
