package id.dana.riskChallenges.ui.otp.otpwhatsapp;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import id.dana.analytics.tracker.riskchallenges.model.RiskChallengeTrackerModel;
import id.dana.challenge.otp.WhatsAppOtpReceiver;
import id.dana.core.ui.constant.BottomInfoSnackbarState;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.dialog.DanaLogoProgressView;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.richview.BottomInfoSnackbar;
import id.dana.core.ui.richview.OtpInputView;
import id.dana.core.ui.richview.RetryAndTimerView;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.domain.otp.model.OtpChannel;
import id.dana.richview.socialshare.AppPackageName;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.databinding.LayoutOtpVerifyBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.domain.model.RequestOtpModel;
import id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel;
import id.dana.riskChallenges.ui.util.StringWrapperExtKt;
import id.dana.riskChallenges.ui.util.mapper.RiskChallengeMapper;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import id.dana.riskChallenges.ui.util.strategy.SetterFallbackStrategy;
import id.dana.riskChallenges.ui.util.tracker.SetterRiskChallengeTracker;
import id.dana.utils.StringWrapper;
import id.dana.utils.StringWrapperKt;
import id.dana.utils.danah5.DanaH5Facade;
import id.dana.utils.danah5.DanaH5Listener;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B#\u0012\u0006\u0010\b\u001a\u00020\u0019\u0012\b\u0010/\u001a\u0004\u0018\u00010\u000e\u0012\b\u00100\u001a\u0004\u0018\u00010%¢\u0006\u0004\b1\u00102J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0011X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u00020\u0017X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0016\u0010\f\u001a\u00020\u001c8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u001d\u001a\u0004\u0018\u00010%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0013\u0010&\u001a\u00020+X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0012\u0010-\u001a\u00020,X\u0087\"¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsappSharedLogicHandler;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lid/dana/riskChallenges/ui/util/strategy/SetterFallbackStrategy;", "Lid/dana/riskChallenges/ui/util/tracker/SetterRiskChallengeTracker;", "", "MyBillsEntityDataFactory", "()V", "Landroidx/lifecycle/LifecycleOwner;", "p0", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "Lid/dana/riskChallenges/databinding/LayoutOtpVerifyBinding;", "Lid/dana/riskChallenges/databinding/LayoutOtpVerifyBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/richview/BottomInfoSnackbar;", "Lkotlin/Lazy;", "Ldagger/Lazy;", "Lid/dana/utils/danah5/DanaH5Facade;", "danaH5Facade", "Ldagger/Lazy;", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "getAuthRequestContext", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "Landroid/content/BroadcastReceiver;", "lookAheadTest", "Landroid/content/BroadcastReceiver;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "moveToNextValue", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Landroid/view/ViewGroup;", "scheduleImpl", "Landroid/view/ViewGroup;", "Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsappSharedLogicHandler$snackbarErrorCallback$1;", "getErrorConfigVersion", "Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsappSharedLogicHandler$snackbarErrorCallback$1;", "Lid/dana/riskChallenges/ui/otp/viewmodel/OtpChallengeViewModel;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "p1", "p2", "<init>", "(Landroidx/fragment/app/Fragment;Lid/dana/riskChallenges/databinding/LayoutOtpVerifyBinding;Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtpWhatsappSharedLogicHandler implements DefaultLifecycleObserver, SetterFallbackStrategy, SetterRiskChallengeTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Fragment getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final LayoutOtpVerifyBinding BuiltInFictitiousFunctionClassFactory;
    @Inject
    public dagger.Lazy<DanaH5Facade> danaH5Facade;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Lazy scheduleImpl;
    private final OtpWhatsappSharedLogicHandler$snackbarErrorCallback$1 getErrorConfigVersion;
    private final BroadcastReceiver lookAheadTest;
    private RiskChallengesComponent moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ViewGroup NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.getAuthRequestContext();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.MyBillsEntityDataFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.PlaceComponentResult();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.scheduleImpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object getAuthRequestContext(id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler r6, java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$setSuccessVerify$1
            if (r0 == 0) goto L14
            r0 = r8
            id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$setSuccessVerify$1 r0 = (id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$setSuccessVerify$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$setSuccessVerify$1 r0 = new id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$setSuccessVerify$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$0
            id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler r6 = (id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L64
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r8)
            r6.MyBillsEntityDataFactory()
            id.dana.riskChallenges.databinding.LayoutOtpVerifyBinding r8 = r6.BuiltInFictitiousFunctionClassFactory
            if (r8 == 0) goto L55
            id.dana.core.ui.richview.OtpInputView r8 = r8.MyBillsEntityDataFactory
            if (r8 == 0) goto L55
            id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda7 r2 = new id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda7
            r2.<init>()
            boolean r8 = r8.post(r2)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
        L55:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r8 != r1) goto L64
            return r1
        L64:
            androidx.fragment.app.Fragment r8 = r6.getAuthRequestContext
            androidx.fragment.app.FragmentManager r8 = r8.getParentFragmentManager()
            r0 = 2
            kotlin.Pair[] r0 = new kotlin.Pair[r0]
            r1 = 0
            r2 = -1
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            java.lang.String r4 = "KEY_RESULT"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r4, r2)
            r0[r1] = r2
            java.lang.String r1 = "KEY_RISK_TOKEN"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r1, r7)
            r0[r3] = r7
            android.os.Bundle r7 = androidx.core.os.BundleKt.PlaceComponentResult(r0)
            java.lang.String r0 = "KEY_RISK_CHALLENGE_FRAGMENT"
            r8.setFragmentResult(r0, r7)
            androidx.fragment.app.Fragment r6 = r6.getAuthRequestContext
            boolean r7 = r6 instanceof com.google.android.material.bottomsheet.BottomSheetDialogFragment
            if (r7 == 0) goto L95
            com.google.android.material.bottomsheet.BottomSheetDialogFragment r6 = (com.google.android.material.bottomsheet.BottomSheetDialogFragment) r6
            goto L96
        L95:
            r6 = 0
        L96:
            if (r6 == 0) goto L9b
            r6.dismissNow()
        L9b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler.getAuthRequestContext(id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.view.FullLifecycleObserver
    public final void onCreate(LifecycleOwner p0) {
        RetryAndTimerView retryAndTimerView;
        RetryAndTimerView retryAndTimerView2;
        RetryAndTimerView retryAndTimerView3;
        RetryAndTimerView retryAndTimerView4;
        RetryAndTimerView retryAndTimerView5;
        RetryAndTimerView retryAndTimerView6;
        RetryAndTimerView retryAndTimerView7;
        OtpInputView otpInputView;
        OtpInputView otpInputView2;
        Intrinsics.checkNotNullParameter(p0, "");
        DefaultLifecycleObserver.CC.KClassImpl$Data$declaredNonStaticMembers$2();
        Context applicationContext = this.getAuthRequestContext.requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.riskChallenges.di.provider.RiskChallengesProvider");
        }
        RiskChallengesComponent BuiltInFictitiousFunctionClassFactory = ((RiskChallengesProvider) applicationContext).provideRiskChallengesComponent().BuiltInFictitiousFunctionClassFactory();
        this.moveToNextValue = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(p0), null, null, new OtpWhatsappSharedLogicHandler$observeUiState$1(p0, this, null), 3, null);
        OtpChallengeViewModel otpChallengeViewModel = (OtpChallengeViewModel) this.scheduleImpl.getValue();
        Bundle arguments = this.getAuthRequestContext.getArguments();
        String string = arguments != null ? arguments.getString("KEY_PHONE_NUMBER") : null;
        if (string == null) {
            string = "";
        }
        Intrinsics.checkNotNullParameter(string, "");
        otpChallengeViewModel.moveToNextValue = string;
        OtpChallengeViewModel otpChallengeViewModel2 = (OtpChallengeViewModel) this.scheduleImpl.getValue();
        Bundle arguments2 = this.getAuthRequestContext.getArguments();
        String string2 = arguments2 != null ? arguments2.getString("KEY_SECURITY_ID") : null;
        if (string2 == null) {
            string2 = "";
        }
        Intrinsics.checkNotNullParameter(string2, "");
        otpChallengeViewModel2.DatabaseTableConfigUtil = string2;
        OtpChallengeViewModel otpChallengeViewModel3 = (OtpChallengeViewModel) this.scheduleImpl.getValue();
        Bundle arguments3 = this.getAuthRequestContext.getArguments();
        String string3 = arguments3 != null ? arguments3.getString("KEY_USE_CASE_STRATEGY") : null;
        if (string3 == null) {
            string3 = "";
        }
        Intrinsics.checkNotNullParameter(string3, "");
        otpChallengeViewModel3.NetworkUserEntityData$$ExternalSyntheticLambda1 = string3;
        OtpChallengeViewModel otpChallengeViewModel4 = (OtpChallengeViewModel) this.scheduleImpl.getValue();
        Bundle arguments4 = this.getAuthRequestContext.getArguments();
        String string4 = arguments4 != null ? arguments4.getString("KEY_OTP_CHANNEL") : null;
        if (string4 == null) {
            string4 = "";
        }
        Intrinsics.checkNotNullParameter(string4, "");
        otpChallengeViewModel4.scheduleImpl = string4;
        OtpChallengeViewModel otpChallengeViewModel5 = (OtpChallengeViewModel) this.scheduleImpl.getValue();
        String str = Intrinsics.areEqual(((OtpChallengeViewModel) this.scheduleImpl.getValue()).scheduleImpl, OtpChannel.WHATSAPP) ? "WHATSAPP_OTP" : "OTP_SMS";
        Intrinsics.checkNotNullParameter(str, "");
        otpChallengeViewModel5.PrepareContext = str;
        OtpChallengeViewModel otpChallengeViewModel6 = (OtpChallengeViewModel) this.scheduleImpl.getValue();
        Bundle arguments5 = this.getAuthRequestContext.getArguments();
        String string5 = arguments5 != null ? arguments5.getString("KEY_SERVICE_CODE") : null;
        if (string5 == null) {
            string5 = "";
        }
        Intrinsics.checkNotNullParameter(string5, "");
        otpChallengeViewModel6.initRecordTimeStamp = string5;
        OtpChallengeViewModel otpChallengeViewModel7 = (OtpChallengeViewModel) this.scheduleImpl.getValue();
        Bundle arguments6 = this.getAuthRequestContext.getArguments();
        otpChallengeViewModel7.PlaceComponentResult = arguments6 != null && arguments6.getBoolean("KEY_IS_SEND_MONEY", false);
        OtpChallengeViewModel otpChallengeViewModel8 = (OtpChallengeViewModel) this.scheduleImpl.getValue();
        Bundle arguments7 = this.getAuthRequestContext.getArguments();
        String string6 = arguments7 != null ? arguments7.getString("KEY_SCENARIO") : null;
        if (string6 == null) {
            string6 = "";
        }
        Intrinsics.checkNotNullParameter(string6, "");
        otpChallengeViewModel8.KClassImpl$Data$declaredNonStaticMembers$2 = string6;
        OtpChallengeViewModel otpChallengeViewModel9 = (OtpChallengeViewModel) this.scheduleImpl.getValue();
        Bundle arguments8 = this.getAuthRequestContext.getArguments();
        otpChallengeViewModel9.NetworkUserEntityData$$ExternalSyntheticLambda2 = arguments8 != null ? arguments8.getString("KEY_RISK_TOKEN") : null;
        SetterFallbackStrategy.CC.KClassImpl$Data$declaredNonStaticMembers$2(RiskChallengeKey.WHATSAPP_OTP, (OtpChallengeViewModel) this.scheduleImpl.getValue(), this.getAuthRequestContext.getArguments());
        SetterRiskChallengeTracker.CC.BuiltInFictitiousFunctionClassFactory((OtpChallengeViewModel) this.scheduleImpl.getValue(), this.getAuthRequestContext.getArguments());
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = this.BuiltInFictitiousFunctionClassFactory;
        AppCompatTextView appCompatTextView = layoutOtpVerifyBinding != null ? layoutOtpVerifyBinding.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(this.getAuthRequestContext.getString(R.string.res_0x7f1310bf_verifypinstatemanager_executeriskchallenge_2_1, ((OtpChallengeViewModel) this.scheduleImpl.getValue()).moveToNextValue));
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding2 = this.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding2 != null && (otpInputView2 = layoutOtpVerifyBinding2.MyBillsEntityDataFactory) != null) {
            otpInputView2.setOtpView(4);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding3 = this.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding3 != null && (otpInputView = layoutOtpVerifyBinding3.MyBillsEntityDataFactory) != null) {
            otpInputView.setOtpListener(new OtpInputView.OtpListener() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$initView$1
                @Override // id.dana.core.ui.richview.OtpInputView.OtpListener
                public final void BuiltInFictitiousFunctionClassFactory(String p02) {
                    LayoutOtpVerifyBinding layoutOtpVerifyBinding4;
                    Intrinsics.checkNotNullParameter(p02, "");
                    layoutOtpVerifyBinding4 = OtpWhatsappSharedLogicHandler.this.BuiltInFictitiousFunctionClassFactory;
                    KeyboardHelper.getAuthRequestContext(layoutOtpVerifyBinding4.MyBillsEntityDataFactory);
                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).MyBillsEntityDataFactory(p02);
                }

                @Override // id.dana.core.ui.richview.OtpInputView.OtpListener
                public final void getAuthRequestContext(String p02) {
                    LayoutOtpVerifyBinding layoutOtpVerifyBinding4;
                    Intrinsics.checkNotNullParameter(p02, "");
                    layoutOtpVerifyBinding4 = OtpWhatsappSharedLogicHandler.this.BuiltInFictitiousFunctionClassFactory;
                    layoutOtpVerifyBinding4.MyBillsEntityDataFactory.setNormalBorder();
                }
            });
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding4 = this.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding4 != null && (retryAndTimerView7 = layoutOtpVerifyBinding4.getAuthRequestContext) != null) {
            retryAndTimerView7.setOnTryAgainClick(new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$initView$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    OtpWhatsappSharedLogicHandler.this.PlaceComponentResult = true;
                    OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).BuiltInFictitiousFunctionClassFactory(OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).NetworkUserEntityData$$ExternalSyntheticLambda1, OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).DatabaseTableConfigUtil, false);
                }
            });
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding5 = this.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding5 != null && (retryAndTimerView6 = layoutOtpVerifyBinding5.getAuthRequestContext) != null) {
            retryAndTimerView6.setOnFallbackClick(new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$initView$3
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Fragment fragment;
                    Fragment fragment2;
                    fragment = OtpWhatsappSharedLogicHandler.this.getAuthRequestContext;
                    if (FragmentExtKt.PlaceComponentResult(fragment)) {
                        OtpChallengeViewModel initRecordTimeStamp = OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this);
                        String PlaceComponentResult = initRecordTimeStamp.MyBillsEntityDataFactory.PlaceComponentResult();
                        String authRequestContext = initRecordTimeStamp.MyBillsEntityDataFactory.getAuthRequestContext();
                        int builtInFictitiousFunctionClassFactory = initRecordTimeStamp.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory();
                        int myBillsEntityDataFactory = initRecordTimeStamp.MyBillsEntityDataFactory.getMyBillsEntityDataFactory();
                        Throwable lookAheadTest = initRecordTimeStamp.MyBillsEntityDataFactory.getLookAheadTest();
                        String PlaceComponentResult2 = lookAheadTest != null ? StringWrapperExtKt.PlaceComponentResult(lookAheadTest) : null;
                        Throwable lookAheadTest2 = initRecordTimeStamp.MyBillsEntityDataFactory.getLookAheadTest();
                        RiskChallengeTrackerModel.RiskChallengeCompleteModel riskChallengeCompleteModel = new RiskChallengeTrackerModel.RiskChallengeCompleteModel(PlaceComponentResult, authRequestContext, false, false, builtInFictitiousFunctionClassFactory, myBillsEntityDataFactory, lookAheadTest2 != null ? StringWrapperExtKt.MyBillsEntityDataFactory(lookAheadTest2) : null, PlaceComponentResult2);
                        Intrinsics.checkNotNullParameter(riskChallengeCompleteModel, "");
                        initRecordTimeStamp.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(riskChallengeCompleteModel);
                        fragment2 = OtpWhatsappSharedLogicHandler.this.getAuthRequestContext;
                        FragmentManager parentFragmentManager = fragment2.getParentFragmentManager();
                        Pair[] pairArr = new Pair[4];
                        pairArr[0] = TuplesKt.to("KEY_RESULT", 0);
                        pairArr[1] = TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE);
                        pairArr[2] = TuplesKt.to("KEY_TRY_TO_FALLBACK", Boolean.TRUE);
                        String str2 = OtpWhatsappSharedLogicHandler.initRecordTimeStamp(OtpWhatsappSharedLogicHandler.this).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                        pairArr[3] = TuplesKt.to("KEY_HISTORY_FALLBACK_MODEL", new HistoryFallbackModel(RiskChallengeKey.WHATSAPP_OTP, str2 != null ? str2 : ""));
                        parentFragmentManager.setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(pairArr));
                    }
                }
            });
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding6 = this.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding6 != null && (retryAndTimerView5 = layoutOtpVerifyBinding6.getAuthRequestContext) != null) {
            retryAndTimerView5.setResendText(R.string.otp_button_resend);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding7 = this.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding7 != null && (retryAndTimerView4 = layoutOtpVerifyBinding7.getAuthRequestContext) != null) {
            retryAndTimerView4.setHasFallback(((OtpChallengeViewModel) this.scheduleImpl.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        RiskChallengeMapper riskChallengeMapper = RiskChallengeMapper.INSTANCE;
        String str2 = ((OtpChallengeViewModel) this.scheduleImpl.getValue()).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str2 == null) {
            str2 = "";
        }
        Integer PlaceComponentResult = RiskChallengeMapper.PlaceComponentResult(str2);
        if (PlaceComponentResult != null) {
            String string7 = this.getAuthRequestContext.getString(PlaceComponentResult.intValue());
            Intrinsics.checkNotNullExpressionValue(string7, "");
            LayoutOtpVerifyBinding layoutOtpVerifyBinding8 = this.BuiltInFictitiousFunctionClassFactory;
            if (layoutOtpVerifyBinding8 != null && (retryAndTimerView3 = layoutOtpVerifyBinding8.getAuthRequestContext) != null) {
                String string8 = this.getAuthRequestContext.getString(R.string.otp_fallback_button, string7);
                Intrinsics.checkNotNullExpressionValue(string8, "");
                retryAndTimerView3.setFallbackText(string8);
            }
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding9 = this.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding9 != null && (retryAndTimerView2 = layoutOtpVerifyBinding9.getAuthRequestContext) != null) {
            retryAndTimerView2.setRemainingAttempts(4);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding10 = this.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding10 != null && (retryAndTimerView = layoutOtpVerifyBinding10.getAuthRequestContext) != null) {
            retryAndTimerView.setupButton(RetryAndTimerView.ButtonState.TRY_AGAIN);
        }
        PendingIntent activity = PendingIntent.getActivity(this.getAuthRequestContext.requireActivity().getApplicationContext(), 0, new Intent(), Build.VERSION.SDK_INT >= 31 ? 67108864 : 0);
        Intent intent = new Intent();
        intent.setPackage("com.whatsapp");
        intent.setAction("com.whatsapp.otp.OTP_REQUESTED");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        PendingIntent pendingIntent = activity;
        extras.putParcelable(WhatsAppOtpReceiver.CI, pendingIntent);
        intent.putExtras(extras);
        Context applicationContext2 = this.getAuthRequestContext.requireActivity().getApplicationContext();
        if (applicationContext2 != null) {
            applicationContext2.sendBroadcast(intent);
        }
        Intrinsics.checkNotNullExpressionValue(activity, "");
        Intent intent2 = new Intent();
        intent2.setPackage(AppPackageName.WHATSAPP_FOR_BUSINESS);
        intent2.setAction("com.whatsapp.otp.OTP_REQUESTED");
        Bundle extras2 = intent2.getExtras();
        if (extras2 == null) {
            extras2 = new Bundle();
        }
        extras2.putParcelable(WhatsAppOtpReceiver.CI, pendingIntent);
        intent2.putExtras(extras2);
        Context applicationContext3 = this.getAuthRequestContext.requireActivity().getApplicationContext();
        if (applicationContext3 != null) {
            applicationContext3.sendBroadcast(intent2);
        }
        ((OtpChallengeViewModel) this.scheduleImpl.getValue()).BuiltInFictitiousFunctionClassFactory(((OtpChallengeViewModel) this.scheduleImpl.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda1, ((OtpChallengeViewModel) this.scheduleImpl.getValue()).DatabaseTableConfigUtil, true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.whatsapp.OTP_RETRIEVED");
        intentFilter.addAction(WhatsAppOtpReceiver.ACTION_RECEIVE_OTP);
        ContextCompat.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.requireContext(), this.lookAheadTest, intentFilter, 4);
    }

    private final void MyBillsEntityDataFactory() {
        DanaLogoProgressView danaLogoProgressView;
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = this.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding != null && (danaLogoProgressView = layoutOtpVerifyBinding.BuiltInFictitiousFunctionClassFactory) != null) {
            danaLogoProgressView.setVisibility(8);
            danaLogoProgressView.stopRefresh();
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding2 = this.BuiltInFictitiousFunctionClassFactory;
        OtpInputView otpInputView = layoutOtpVerifyBinding2 != null ? layoutOtpVerifyBinding2.MyBillsEntityDataFactory : null;
        if (otpInputView != null) {
            otpInputView.setVisibility(0);
        }
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$snackbarErrorCallback$1] */
    public OtpWhatsappSharedLogicHandler(final Fragment fragment, LayoutOtpVerifyBinding layoutOtpVerifyBinding, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(fragment, "");
        this.getAuthRequestContext = fragment;
        this.BuiltInFictitiousFunctionClassFactory = layoutOtpVerifyBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewGroup;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = OtpWhatsappSharedLogicHandler.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        final Function0 function03 = null;
        this.scheduleImpl = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(fragment, Reflection.getOrCreateKotlinClass(OtpChallengeViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.PlaceComponentResult(Lazy.this).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = Function0.this;
                if (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) {
                    ViewModelStoreOwner PlaceComponentResult = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$danaLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaLogoLoadingDialog invoke() {
                Fragment fragment2;
                fragment2 = OtpWhatsappSharedLogicHandler.this.getAuthRequestContext;
                Context requireContext = fragment2.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                return new DanaLogoLoadingDialog(requireContext);
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$bottomInfoSnackbar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomInfoSnackbar invoke() {
                ViewGroup viewGroup2;
                viewGroup2 = OtpWhatsappSharedLogicHandler.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (viewGroup2 != null) {
                    BottomInfoSnackbar.Companion companion = BottomInfoSnackbar.INSTANCE;
                    return BottomInfoSnackbar.Companion.getAuthRequestContext(viewGroup2);
                }
                return null;
            }
        });
        this.lookAheadTest = new BroadcastReceiver() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$otpReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                String stringExtra = intent != null ? intent.getStringExtra(WhatsAppOtpReceiver.OTP) : null;
                if (stringExtra == null) {
                    stringExtra = "";
                }
                if (stringExtra.length() > 0) {
                    Intrinsics.areEqual(stringExtra, "null");
                }
            }
        };
        this.getErrorConfigVersion = new BaseTransientBottomBar.BaseCallback<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$snackbarErrorCallback$1
            /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
            
                r2 = r1.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
             */
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final /* synthetic */ void onDismissed(id.dana.core.ui.richview.BottomInfoSnackbar r2, int r3) {
                /*
                    r1 = this;
                    id.dana.core.ui.richview.BottomInfoSnackbar r2 = (id.dana.core.ui.richview.BottomInfoSnackbar) r2
                    id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler r2 = id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler.this
                    androidx.fragment.app.Fragment r2 = id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler.GetContactSyncConfig(r2)
                    boolean r2 = id.dana.core.ui.extension.FragmentExtKt.PlaceComponentResult(r2)
                    if (r2 == 0) goto L26
                    id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler r2 = id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler.this
                    id.dana.riskChallenges.databinding.LayoutOtpVerifyBinding r2 = id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler.getErrorConfigVersion(r2)
                    if (r2 == 0) goto L26
                    id.dana.core.ui.richview.OtpInputView r2 = r2.MyBillsEntityDataFactory
                    if (r2 == 0) goto L26
                    r3 = 4
                    r2.setOtpView(r3)
                    r2.setNormalBorder()
                    r3 = 1
                    r0 = 0
                    id.dana.core.ui.richview.OtpInputView.requestFocusAndShowKeyboard$default(r2, r0, r3, r0)
                L26:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$snackbarErrorCallback$1.onDismissed(java.lang.Object, int):void");
            }
        };
    }

    public static /* synthetic */ void PlaceComponentResult(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        Intrinsics.checkNotNullParameter(otpWhatsappSharedLogicHandler, "");
        KeyboardHelper.getAuthRequestContext(otpWhatsappSharedLogicHandler.getAuthRequestContext.getGetAuthRequestContext());
        otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.clearFocusAndHideKeyboard();
        otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setSuccessBorder();
    }

    public static /* synthetic */ void getAuthRequestContext(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        Intrinsics.checkNotNullParameter(otpWhatsappSharedLogicHandler, "");
        otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.requestFocus();
        EditText editText = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(editText);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        Intrinsics.checkNotNullParameter(otpWhatsappSharedLogicHandler, "");
        otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.clearFocusInput();
        KeyboardHelper.getAuthRequestContext(otpWhatsappSharedLogicHandler.getAuthRequestContext.getGetAuthRequestContext());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        Intrinsics.checkNotNullParameter(otpWhatsappSharedLogicHandler, "");
        otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.requestFocusAndShowKeyboard(OtpInputView.FocusIndex.LAST);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        EditText editText;
        Intrinsics.checkNotNullParameter(otpWhatsappSharedLogicHandler, "");
        otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setDisableView();
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding == null || (editText = layoutOtpVerifyBinding.PlaceComponentResult) == null) {
            return;
        }
        editText.post(new OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda0(otpWhatsappSharedLogicHandler));
    }

    public static /* synthetic */ void lookAheadTest(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        EditText editText;
        Intrinsics.checkNotNullParameter(otpWhatsappSharedLogicHandler, "");
        otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setDisableView();
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding == null || (editText = layoutOtpVerifyBinding.PlaceComponentResult) == null) {
            return;
        }
        editText.post(new OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda0(otpWhatsappSharedLogicHandler));
    }

    public static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        Intrinsics.checkNotNullParameter(otpWhatsappSharedLogicHandler, "");
        otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.requestFocusAndShowKeyboard(OtpInputView.FocusIndex.LAST);
    }

    public static /* synthetic */ void scheduleImpl(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        Intrinsics.checkNotNullParameter(otpWhatsappSharedLogicHandler, "");
        OtpInputView otpInputView = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(otpInputView, "");
        OtpInputView.requestFocusAndShowKeyboard$default(otpInputView, null, 1, null);
    }

    public static final /* synthetic */ DanaLogoLoadingDialog moveToNextValue(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        return (DanaLogoLoadingDialog) otpWhatsappSharedLogicHandler.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ OtpChallengeViewModel initRecordTimeStamp(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        return (OtpChallengeViewModel) otpWhatsappSharedLogicHandler.scheduleImpl.getValue();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler, String str) {
        RetryAndTimerView retryAndTimerView;
        RetryAndTimerView retryAndTimerView2;
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar != null) {
            bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
            Intrinsics.checkNotNullParameter(str, "");
            bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(str);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding != null && (retryAndTimerView2 = layoutOtpVerifyBinding.getAuthRequestContext) != null) {
            retryAndTimerView2.setupButton(RetryAndTimerView.ButtonState.TRY_AGAIN);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding2 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding2 == null || (retryAndTimerView = layoutOtpVerifyBinding2.getAuthRequestContext) == null) {
            return;
        }
        retryAndTimerView.setResendText(R.string.otp_button_resend);
    }

    public static final /* synthetic */ void DatabaseTableConfigUtil(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        OtpInputView otpInputView;
        otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory();
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar != null) {
            bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
            bottomInfoSnackbar.removeCallback(otpWhatsappSharedLogicHandler.getErrorConfigVersion);
            String string = otpWhatsappSharedLogicHandler.getAuthRequestContext.getString(R.string.getSupportButtonTintMode);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(string);
            bottomInfoSnackbar.show();
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding == null || (otpInputView = layoutOtpVerifyBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        otpInputView.post(new Runnable() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                OtpWhatsappSharedLogicHandler.lookAheadTest(OtpWhatsappSharedLogicHandler.this);
            }
        });
    }

    public static final /* synthetic */ void getAuthRequestContext(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler, StringWrapper stringWrapper) {
        OtpInputView otpInputView;
        String authRequestContext;
        BottomInfoSnackbar bottomInfoSnackbar;
        otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory();
        BottomInfoSnackbar bottomInfoSnackbar2 = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar2 != null) {
            bottomInfoSnackbar2.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
        }
        Context context = otpWhatsappSharedLogicHandler.getAuthRequestContext.getContext();
        if (context != null && (authRequestContext = StringWrapperKt.getAuthRequestContext(context, stringWrapper)) != null && (bottomInfoSnackbar = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue()) != null) {
            Intrinsics.checkNotNullParameter(authRequestContext, "");
            bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(authRequestContext);
        }
        BottomInfoSnackbar bottomInfoSnackbar3 = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar3 != null) {
            bottomInfoSnackbar3.removeCallback(otpWhatsappSharedLogicHandler.getErrorConfigVersion);
        }
        BottomInfoSnackbar bottomInfoSnackbar4 = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar4 != null) {
            bottomInfoSnackbar4.addCallback(otpWhatsappSharedLogicHandler.getErrorConfigVersion);
        }
        BottomInfoSnackbar bottomInfoSnackbar5 = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar5 != null) {
            bottomInfoSnackbar5.show();
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding == null || (otpInputView = layoutOtpVerifyBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        otpInputView.post(new Runnable() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                OtpWhatsappSharedLogicHandler.KClassImpl$Data$declaredNonStaticMembers$2(OtpWhatsappSharedLogicHandler.this);
            }
        });
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler, String str) {
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar != null) {
            bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
            Intrinsics.checkNotNullParameter(str, "");
            bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(str);
            bottomInfoSnackbar.addCallback(new BaseTransientBottomBar.BaseCallback<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$setFirstTimeErrorRequestOtp$1$1
                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                public final /* synthetic */ void onDismissed(BottomInfoSnackbar bottomInfoSnackbar2, int i) {
                    Fragment fragment;
                    Fragment fragment2;
                    fragment = OtpWhatsappSharedLogicHandler.this.getAuthRequestContext;
                    if (FragmentExtKt.PlaceComponentResult(fragment)) {
                        fragment2 = OtpWhatsappSharedLogicHandler.this.getAuthRequestContext;
                        fragment2.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0), TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE)));
                    }
                }
            });
            bottomInfoSnackbar.show();
        }
    }

    public static final /* synthetic */ void PrepareContext(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        OtpInputView otpInputView;
        OtpInputView otpInputView2;
        otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory();
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding != null && (otpInputView2 = layoutOtpVerifyBinding.MyBillsEntityDataFactory) != null) {
            otpInputView2.setError();
        }
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar != null) {
            bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
        }
        BottomInfoSnackbar bottomInfoSnackbar2 = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar2 != null) {
            String string = otpWhatsappSharedLogicHandler.getAuthRequestContext.getString(R.string.otp_error_invalid_otp);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            bottomInfoSnackbar2.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(string);
        }
        BottomInfoSnackbar bottomInfoSnackbar3 = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar3 != null) {
            bottomInfoSnackbar3.removeCallback(otpWhatsappSharedLogicHandler.getErrorConfigVersion);
        }
        BottomInfoSnackbar bottomInfoSnackbar4 = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar4 != null) {
            bottomInfoSnackbar4.addCallback(otpWhatsappSharedLogicHandler.getErrorConfigVersion);
        }
        BottomInfoSnackbar bottomInfoSnackbar5 = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar5 != null) {
            bottomInfoSnackbar5.show();
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding2 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding2 == null || (otpInputView = layoutOtpVerifyBinding2.MyBillsEntityDataFactory) == null) {
            return;
        }
        otpInputView.post(new Runnable() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                OtpWhatsappSharedLogicHandler.NetworkUserEntityData$$ExternalSyntheticLambda0(OtpWhatsappSharedLogicHandler.this);
            }
        });
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler, RequestOtpModel requestOtpModel) {
        OtpInputView otpInputView;
        RetryAndTimerView retryAndTimerView;
        RetryAndTimerView retryAndTimerView2;
        RetryAndTimerView retryAndTimerView3;
        RetryAndTimerView retryAndTimerView4;
        OtpInputView otpInputView2;
        OtpInputView otpInputView3;
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding != null && (otpInputView3 = layoutOtpVerifyBinding.MyBillsEntityDataFactory) != null) {
            otpInputView3.setOtpView(requestOtpModel.BuiltInFictitiousFunctionClassFactory);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding2 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding2 != null && (otpInputView2 = layoutOtpVerifyBinding2.MyBillsEntityDataFactory) != null) {
            otpInputView2.setNormalBorder();
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding3 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding3 != null && (retryAndTimerView4 = layoutOtpVerifyBinding3.getAuthRequestContext) != null) {
            retryAndTimerView4.setRemainingAttempts(requestOtpModel.PlaceComponentResult);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding4 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding4 != null && (retryAndTimerView3 = layoutOtpVerifyBinding4.getAuthRequestContext) != null) {
            retryAndTimerView3.setTimeUntilNextAttempt(requestOtpModel.getAuthRequestContext * 1000);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding5 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding5 != null && (retryAndTimerView2 = layoutOtpVerifyBinding5.getAuthRequestContext) != null) {
            retryAndTimerView2.setResendText(R.string.otp_button_resend);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding6 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding6 != null && (retryAndTimerView = layoutOtpVerifyBinding6.getAuthRequestContext) != null) {
            retryAndTimerView.setupButton(RetryAndTimerView.ButtonState.COUNTDOWN_TIMER);
        }
        if (otpWhatsappSharedLogicHandler.PlaceComponentResult) {
            BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
            if (bottomInfoSnackbar != null) {
                bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.SUCCESS);
                String string = otpWhatsappSharedLogicHandler.getAuthRequestContext.getString(R.string.otp_resend_whatsapp_success);
                Intrinsics.checkNotNullExpressionValue(string, "");
                Intrinsics.checkNotNullParameter(string, "");
                bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(string);
                bottomInfoSnackbar.show();
            }
            otpWhatsappSharedLogicHandler.PlaceComponentResult = false;
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding7 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding7 == null || (otpInputView = layoutOtpVerifyBinding7.MyBillsEntityDataFactory) == null) {
            return;
        }
        otpInputView.post(new Runnable() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                OtpWhatsappSharedLogicHandler.scheduleImpl(OtpWhatsappSharedLogicHandler.this);
            }
        });
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda8(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        OtpInputView otpInputView;
        otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory();
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) otpWhatsappSharedLogicHandler.MyBillsEntityDataFactory.getValue();
        if (bottomInfoSnackbar != null) {
            bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
            bottomInfoSnackbar.removeCallback(otpWhatsappSharedLogicHandler.getErrorConfigVersion);
            String string = otpWhatsappSharedLogicHandler.getAuthRequestContext.getString(R.string.otp_error_too_often_request);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(string);
            bottomInfoSnackbar.show();
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding == null || (otpInputView = layoutOtpVerifyBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        otpInputView.post(new Runnable() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                OtpWhatsappSharedLogicHandler.MyBillsEntityDataFactory(OtpWhatsappSharedLogicHandler.this);
            }
        });
    }

    public static final /* synthetic */ void isLayoutRequested(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        FragmentManager supportFragmentManager;
        Context requireContext = otpWhatsappSharedLogicHandler.getAuthRequestContext.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = otpWhatsappSharedLogicHandler.getAuthRequestContext.getString(R.string.newProxyInstance);
        builder.moveToNextValue = otpWhatsappSharedLogicHandler.getAuthRequestContext.getString(R.string.limit_otp_description);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_limit_otp;
        builder.lookAheadTest = Boolean.FALSE;
        String string = otpWhatsappSharedLogicHandler.getAuthRequestContext.getString(R.string.limit_otp_button);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String str = string;
        Intrinsics.checkNotNullParameter(str, "");
        builder.PrepareContext = str;
        builder.PlaceComponentResult = 128;
        builder.MyBillsEntityDataFactory = 128;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$showLimitOtpDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Fragment fragment;
                Fragment fragment2;
                fragment = OtpWhatsappSharedLogicHandler.this.getAuthRequestContext;
                if (FragmentExtKt.PlaceComponentResult(fragment)) {
                    fragment2 = OtpWhatsappSharedLogicHandler.this.getAuthRequestContext;
                    fragment2.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0), TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE)));
                }
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        builder.newProxyInstance = function0;
        DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        FragmentActivity activity = otpWhatsappSharedLogicHandler.getAuthRequestContext.getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        Intrinsics.checkNotNullParameter(supportFragmentManager, "");
        BuiltInFictitiousFunctionClassFactory.show(supportFragmentManager, "DanaAlertDialog");
    }

    public static final /* synthetic */ void newProxyInstance(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler) {
        EditText editText;
        DanaLogoProgressView danaLogoProgressView;
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        OtpInputView otpInputView = layoutOtpVerifyBinding != null ? layoutOtpVerifyBinding.MyBillsEntityDataFactory : null;
        if (otpInputView != null) {
            otpInputView.setVisibility(4);
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding2 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding2 != null && (danaLogoProgressView = layoutOtpVerifyBinding2.BuiltInFictitiousFunctionClassFactory) != null) {
            danaLogoProgressView.setVisibility(0);
            danaLogoProgressView.startRefresh();
        }
        LayoutOtpVerifyBinding layoutOtpVerifyBinding3 = otpWhatsappSharedLogicHandler.BuiltInFictitiousFunctionClassFactory;
        if (layoutOtpVerifyBinding3 == null || (editText = layoutOtpVerifyBinding3.PlaceComponentResult) == null) {
            return;
        }
        editText.post(new OtpWhatsappSharedLogicHandler$$ExternalSyntheticLambda0(otpWhatsappSharedLogicHandler));
    }

    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        dagger.Lazy<DanaH5Facade> lazy = this.danaH5Facade;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        DanaH5Facade danaH5Facade = lazy.get();
        Intrinsics.checkNotNullExpressionValue(danaH5Facade, "");
        danaH5Facade.startContainerFullUrlWithSendCredentialsWithoutTimeOut(p0, new DanaH5Listener() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p02) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p02) {
                OtpWhatsappSharedLogicHandler.moveToNextValue(OtpWhatsappSharedLogicHandler.this).PlaceComponentResult();
            }
        }, null, "portrait");
    }
}
