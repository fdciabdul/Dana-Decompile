package id.dana.onboarding.confirmpin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.kernel.RVEvents;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.KeyBaseActivity;
import id.dana.base.KeyBaseFragment;
import id.dana.base.MenuItemButtonListener;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.FragmentConfirmPinBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.ConfirmPinComponent;
import id.dana.di.component.DaggerConfirmPinComponent;
import id.dana.di.modules.ConfirmPinModule;
import id.dana.di.modules.TncSummaryModules;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.extension.view.InputExtKt;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import id.dana.onboarding.confirmpin.ConfirmPinContract;
import id.dana.onboarding.createpin.CreatePinKey;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.onboarding.welcome.WelcomeKey;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher;
import id.dana.textbehavior.InvalidReason;
import id.dana.textbehavior.OnValidatedListener;
import id.dana.textbehavior.TextBehavior;
import id.dana.textbehavior.validate.Validator;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.FileUtil;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 B2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001BB\u0007¢\u0006\u0004\bA\u0010\bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\bR\u0018\u0010 \u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001fR\u0018\u0010\u001c\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001fR\u0013\u0010\u0019\u001a\u00020%X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b&\u0010'R\u0013\u0010*\u001a\u00020(X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010)\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010,R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010\u001fR\u0018\u0010-\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00101\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010\u001fR\u0012\u00107\u001a\u000206X\u0087\"¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010.\u001a\u0002098\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u00100\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010\u001fR\u0018\u0010<\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u0010\u001fR\u0012\u0010?\u001a\u00020>X\u0087\"¢\u0006\u0006\n\u0004\b?\u0010@"}, d2 = {"Lid/dana/onboarding/confirmpin/ConfirmPinFragment;", "Lid/dana/base/KeyBaseFragment;", "Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/onboarding/confirmpin/ConfirmPinKey;", "Lid/dana/databinding/FragmentConfirmPinBinding;", "Lid/dana/onboarding/confirmpin/ConfirmPinContract$View;", "", "dismissProgress", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "Landroid/content/Context;", "p0", "onAttach", "(Landroid/content/Context;)V", "", "onBackPressed", "()Z", "onDestroy", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "p1", "PlaceComponentResult", "(ZZ)V", "onStart", "BuiltInFictitiousFunctionClassFactory", "showProgress", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/di/component/ConfirmPinComponent;", "moveToNextValue", "Lid/dana/di/component/ConfirmPinComponent;", "scheduleImpl", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "getErrorConfigVersion", "Lkotlin/Lazy;", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "lookAheadTest", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "GetContactSyncConfig", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "PrepareContext", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/onboarding/confirmpin/ConfirmPinContract$Presenter;", "presenter", "Lid/dana/onboarding/confirmpin/ConfirmPinContract$Presenter;", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "isLayoutRequested", "newProxyInstance", "Lid/dana/tncsummary/TncSummaryContract$Presenter;", "tncSummaryPresenter", "Lid/dana/tncsummary/TncSummaryContract$Presenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmPinFragment extends KeyBaseFragment<OnboardingActivity, ConfirmPinKey, FragmentConfirmPinBinding> implements ConfirmPinContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private String initRecordTimeStamp;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private OnboardingNavigationManagerWithMenu GetContactSyncConfig;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private ConfirmPinComponent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private String isLayoutRequested;
    @Inject
    public ConfirmPinContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public TncSummaryContract.Presenter tncSummaryPresenter;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final MeasureLoadAndRenderingScreen DatabaseTableConfigUtil = new MeasureLoadAndRenderingScreen();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<FirebasePerformanceMonitor>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$firebasePerformanceMonitor$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FirebasePerformanceMonitor invoke() {
            return FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean lookAheadTest = true;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean scheduleImpl = true;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<EnrollPasskeyLauncher>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$enrollPasskeyLauncher$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EnrollPasskeyLauncher invoke() {
            EnrollPasskeyLauncher.Builder builder = new EnrollPasskeyLauncher.Builder(ConfirmPinFragment.this);
            Intrinsics.checkNotNullParameter("Registration", "");
            builder.moveToNextValue = "Registration";
            Intrinsics.checkNotNullParameter("Enroll", "");
            builder.PlaceComponentResult = "Enroll";
            Intrinsics.checkNotNullParameter("HOME", "");
            builder.MyBillsEntityDataFactory = "HOME";
            final ConfirmPinFragment confirmPinFragment = ConfirmPinFragment.this;
            Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$enrollPasskeyLauncher$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle) {
                    OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
                    Intrinsics.checkNotNullParameter(bundle, "");
                    onboardingNavigationManagerWithMenu = ConfirmPinFragment.this.GetContactSyncConfig;
                    if (onboardingNavigationManagerWithMenu != null) {
                        WelcomeKey welcomeKey = new WelcomeKey();
                        Intrinsics.checkNotNullParameter(welcomeKey, "");
                        onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(welcomeKey);
                    }
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            builder.getErrorConfigVersion = function1;
            final ConfirmPinFragment confirmPinFragment2 = ConfirmPinFragment.this;
            Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$enrollPasskeyLauncher$2.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle) {
                    OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
                    Intrinsics.checkNotNullParameter(bundle, "");
                    onboardingNavigationManagerWithMenu = ConfirmPinFragment.this.GetContactSyncConfig;
                    if (onboardingNavigationManagerWithMenu != null) {
                        WelcomeKey welcomeKey = new WelcomeKey();
                        Intrinsics.checkNotNullParameter(welcomeKey, "");
                        onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(welcomeKey);
                    }
                }
            };
            Intrinsics.checkNotNullParameter(function12, "");
            builder.PlaceComponentResult = function12;
            final ConfirmPinFragment confirmPinFragment3 = ConfirmPinFragment.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$enrollPasskeyLauncher$2.3
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
                    OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
                    onboardingNavigationManagerWithMenu = ConfirmPinFragment.this.GetContactSyncConfig;
                    if (onboardingNavigationManagerWithMenu != null) {
                        WelcomeKey welcomeKey = new WelcomeKey();
                        Intrinsics.checkNotNullParameter(welcomeKey, "");
                        onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(welcomeKey);
                    }
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
            return builder.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    });

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_confirm_pin;
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ FragmentConfirmPinBinding PlaceComponentResult(ConfirmPinFragment confirmPinFragment) {
        return (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentConfirmPinBinding BuiltInFictitiousFunctionClassFactory = FragmentConfirmPinBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        PinEntryEditText pinEntryEditText;
        super.onStart();
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("idle_registration_confirm_pin_screen");
        FragmentConfirmPinBinding fragmentConfirmPinBinding = (FragmentConfirmPinBinding) getBinding();
        if (fragmentConfirmPinBinding != null && (pinEntryEditText = fragmentConfirmPinBinding.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.requestFocus();
        }
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2((Activity) baseActivity);
    }

    @Override // id.dana.base.BaseFragment
    public final boolean onBackPressed() {
        if (this.moveToNextValue) {
            return true;
        }
        if (this.lookAheadTest) {
            OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
            Intrinsics.checkNotNullParameter("idle_registration_confirm_pin_screen", "");
            OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "idle_registration_confirm_pin_screen");
            this.lookAheadTest = false;
        }
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.GetContactSyncConfig;
        if (onboardingNavigationManagerWithMenu != null) {
            String str = this.initRecordTimeStamp;
            if (str == null) {
                str = "";
            }
            String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = this.MyBillsEntityDataFactory;
            String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            CreatePinKey.Companion companion = CreatePinKey.INSTANCE;
            CreatePinKey BuiltInFictitiousFunctionClassFactory = CreatePinKey.Companion.BuiltInFictitiousFunctionClassFactory(str, str2, str3, str4);
            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
            onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(BuiltInFictitiousFunctionClassFactory);
            return true;
        }
        return true;
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        AppCompatTextView appCompatTextView;
        PinEntryEditText pinEntryEditText;
        PinEntryEditText pinEntryEditText2;
        PinEntryEditText pinEntryEditText3;
        PinEntryEditText pinEntryEditText4;
        String str;
        Bundle arguments = getArguments();
        byte b = 0;
        if (arguments != null) {
            this.initRecordTimeStamp = arguments.getString("phoneNumber");
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = arguments.getString("nickname");
            this.MyBillsEntityDataFactory = arguments.getString("avatarUri");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = arguments.getString("pin");
            String string = arguments.getString("referralCode");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = string;
            if (TextUtils.isEmpty(string)) {
                str = "None";
            } else {
                if (string == null) {
                    string = "";
                }
                str = StringsKt.startsWith$default(string, "https", false, 2, (Object) null) ? TrackerKey.SourceType.DEEP_LINK : TrackerKey.SourceType.USER_INPUT;
            }
            this.isLayoutRequested = str;
        }
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            DaggerConfirmPinComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerConfirmPinComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ConfirmPinModule) Preconditions.getAuthRequestContext(new ConfirmPinModule(this));
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (TncSummaryModules) Preconditions.getAuthRequestContext(new TncSummaryModules(new TncSummaryContract.View() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$initInjector$1
                @Override // id.dana.tncsummary.TncSummaryContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(List<AgreementInfo> p0) {
                }

                @Override // id.dana.tncsummary.TncSummaryContract.View
                public final void PlaceComponentResult(boolean p0) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, ConfirmPinModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, TncSummaryModules.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, ApplicationComponent.class);
            this.BuiltInFictitiousFunctionClassFactory = new DaggerConfirmPinComponent.ConfirmPinComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, b);
        }
        ConfirmPinComponent confirmPinComponent = this.BuiltInFictitiousFunctionClassFactory;
        if (confirmPinComponent != null) {
            confirmPinComponent.PlaceComponentResult(this);
        }
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[2];
        ConfirmPinContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        TncSummaryContract.Presenter presenter2 = this.tncSummaryPresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        abstractPresenterArr[1] = presenter2;
        registerPresenter(abstractPresenterArr);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            OnboardingNavigationManagerWithMenu navigationManager = ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager();
            this.GetContactSyncConfig = navigationManager;
            if (navigationManager != null) {
                navigationManager.PlaceComponentResult = new MenuItemButtonListener() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$$ExternalSyntheticLambda1
                    @Override // id.dana.base.MenuItemButtonListener
                    public final void PlaceComponentResult() {
                        ConfirmPinFragment.BuiltInFictitiousFunctionClassFactory(ConfirmPinFragment.this);
                    }
                };
            }
            KeyboardHelper.PlaceComponentResult(getBaseActivity().getWindow().getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$getKeyboardVisibilityListener$1
                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void MyBillsEntityDataFactory() {
                }

                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    ConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(ConfirmPinFragment.this).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.USER_INTERACTION_REGISTRATION_PIN_CONFIRMATION);
                    ConfirmPinFragment.this.scheduleImpl = false;
                }
            });
            FragmentConfirmPinBinding fragmentConfirmPinBinding = (FragmentConfirmPinBinding) getBinding();
            if (fragmentConfirmPinBinding != null && (pinEntryEditText4 = fragmentConfirmPinBinding.MyBillsEntityDataFactory) != null) {
                pinEntryEditText4.addTextChangedListener(new TextWatcher() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$setInputPinTextChangedListener$$inlined$addTextChangedListener$default$1
                    @Override // android.text.TextWatcher
                    public final void afterTextChanged(Editable p0) {
                    }

                    @Override // android.text.TextWatcher
                    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    }

                    @Override // android.text.TextWatcher
                    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                        PinEntryEditText pinEntryEditText5;
                        ConfirmPinFragment.getErrorConfigVersion(ConfirmPinFragment.this);
                        FragmentConfirmPinBinding PlaceComponentResult = ConfirmPinFragment.PlaceComponentResult(ConfirmPinFragment.this);
                        boolean z = false;
                        if (PlaceComponentResult != null && (pinEntryEditText5 = PlaceComponentResult.MyBillsEntityDataFactory) != null && String.valueOf(p0).length() == pinEntryEditText5.getMaxLength()) {
                            z = true;
                        }
                        if (z) {
                            FirebasePerformanceMonitor KClassImpl$Data$declaredNonStaticMembers$22 = ConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(ConfirmPinFragment.this);
                            Intrinsics.checkNotNullParameter(TrackerKey.Event.USER_INTERACTION_REGISTRATION_PIN_CONFIRMATION, "");
                            Trace trace = KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2.get(TrackerKey.Event.USER_INTERACTION_REGISTRATION_PIN_CONFIRMATION);
                            if (trace != null) {
                                trace.stop();
                            }
                        }
                    }
                });
            }
            FragmentConfirmPinBinding fragmentConfirmPinBinding2 = (FragmentConfirmPinBinding) getBinding();
            if (fragmentConfirmPinBinding2 != null && (pinEntryEditText3 = fragmentConfirmPinBinding2.MyBillsEntityDataFactory) != null) {
                pinEntryEditText3.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$$ExternalSyntheticLambda2
                    @Override // id.dana.core.ui.richview.PinEntryEditText.OnPinEnteredListener
                    public final /* synthetic */ void MyBillsEntityDataFactory() {
                        PinEntryEditText.OnPinEnteredListener.CC.MyBillsEntityDataFactory();
                    }

                    @Override // id.dana.core.ui.richview.PinEntryEditText.OnPinEnteredListener
                    public final void getAuthRequestContext(CharSequence charSequence) {
                        ConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(ConfirmPinFragment.this, charSequence);
                    }
                });
            }
            getLifecycle().BuiltInFictitiousFunctionClassFactory((EnrollPasskeyLauncher) this.PlaceComponentResult.getValue());
            FragmentConfirmPinBinding fragmentConfirmPinBinding3 = (FragmentConfirmPinBinding) getBinding();
            TextBehavior.EditTextBehaviorBuilder PlaceComponentResult = TextBehavior.Builder.PlaceComponentResult(fragmentConfirmPinBinding3 != null ? fragmentConfirmPinBinding3.MyBillsEntityDataFactory : null);
            Validator validator = new Validator() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$createInputValidator$1
                @Override // id.dana.textbehavior.validate.Validator
                public final boolean MyBillsEntityDataFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    return p0.length() >= 6;
                }

                @Override // id.dana.textbehavior.validate.Validator
                public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                    PinEntryEditText pinEntryEditText5;
                    FragmentConfirmPinBinding PlaceComponentResult2 = ConfirmPinFragment.PlaceComponentResult(ConfirmPinFragment.this);
                    if (PlaceComponentResult2 != null && (pinEntryEditText5 = PlaceComponentResult2.MyBillsEntityDataFactory) != null) {
                        pinEntryEditText5.setText("");
                    }
                    String string2 = ConfirmPinFragment.this.getString(R.string.msg_pin_less_than6_error);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    return string2;
                }
            };
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = new ArrayList();
            }
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.add(validator);
            PlaceComponentResult.MyBillsEntityDataFactory = new OnValidatedListener() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$createOnInputValidatedListener$1
                @Override // id.dana.textbehavior.OnValidatedListener
                public final void getAuthRequestContext(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.textbehavior.OnValidatedListener
                public final void MyBillsEntityDataFactory(String p0, List<? extends InvalidReason> p1) {
                    OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                    onboardingNavigationManagerWithMenu = ConfirmPinFragment.this.GetContactSyncConfig;
                    if (onboardingNavigationManagerWithMenu != null) {
                        onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(false);
                    }
                }
            };
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
            FragmentConfirmPinBinding fragmentConfirmPinBinding4 = (FragmentConfirmPinBinding) getBinding();
            if (fragmentConfirmPinBinding4 != null && (pinEntryEditText2 = fragmentConfirmPinBinding4.MyBillsEntityDataFactory) != null) {
                pinEntryEditText2.focus();
            }
            AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
            AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda6();
            FragmentConfirmPinBinding fragmentConfirmPinBinding5 = (FragmentConfirmPinBinding) getBinding();
            if (fragmentConfirmPinBinding5 != null && (pinEntryEditText = fragmentConfirmPinBinding5.MyBillsEntityDataFactory) != null) {
                pinEntryEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$$ExternalSyntheticLambda5
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        boolean KClassImpl$Data$declaredNonStaticMembers$22;
                        KClassImpl$Data$declaredNonStaticMembers$22 = ConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(ConfirmPinFragment.this, i);
                        return KClassImpl$Data$declaredNonStaticMembers$22;
                    }
                });
            }
            FragmentConfirmPinBinding fragmentConfirmPinBinding6 = (FragmentConfirmPinBinding) getBinding();
            if (fragmentConfirmPinBinding6 != null && (appCompatTextView = fragmentConfirmPinBinding6.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ConfirmPinFragment.MyBillsEntityDataFactory(ConfirmPinFragment.this);
                    }
                });
            }
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.DatabaseTableConfigUtil;
                Intrinsics.checkNotNullParameter(getAuthRequestContext, "");
                FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
                FirstDrawListener.Companion.MyBillsEntityDataFactory(getAuthRequestContext, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.DatabaseTableConfigUtil;
        Intrinsics.checkNotNullParameter("reconfirm_pin_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("reconfirm_pin_screen_render");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((EnrollPasskeyLauncher) this.PlaceComponentResult.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(ConfirmPinFragment confirmPinFragment, int i) {
        PinEntryEditText pinEntryEditText;
        PinEntryEditText pinEntryEditText2;
        PinEntryEditText pinEntryEditText3;
        Intrinsics.checkNotNullParameter(confirmPinFragment, "");
        if (i == 6) {
            FragmentConfirmPinBinding fragmentConfirmPinBinding = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
            Editable editable = null;
            if (((fragmentConfirmPinBinding == null || (pinEntryEditText3 = fragmentConfirmPinBinding.MyBillsEntityDataFactory) == null) ? null : pinEntryEditText3.getText()) != null) {
                FragmentConfirmPinBinding fragmentConfirmPinBinding2 = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
                if (fragmentConfirmPinBinding2 != null && (pinEntryEditText2 = fragmentConfirmPinBinding2.MyBillsEntityDataFactory) != null) {
                    editable = pinEntryEditText2.getText();
                }
                if (String.valueOf(editable).length() >= 6) {
                    OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                    OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("confirm_pin_flow_loadtime");
                    confirmPinFragment.BuiltInFictitiousFunctionClassFactory();
                    return true;
                }
            }
            FragmentConfirmPinBinding fragmentConfirmPinBinding3 = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
            if (fragmentConfirmPinBinding3 != null && (pinEntryEditText = fragmentConfirmPinBinding3.MyBillsEntityDataFactory) != null) {
                pinEntryEditText.setText("");
            }
            confirmPinFragment.showToast(confirmPinFragment.getString(R.string.msg_pin_less_than6_error));
        }
        return false;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        this.moveToNextValue = true;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.GetContactSyncConfig;
        if (onboardingNavigationManagerWithMenu != null) {
            onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightProgressBar(true);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        this.moveToNextValue = false;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.GetContactSyncConfig;
        if (onboardingNavigationManagerWithMenu != null) {
            onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightProgressBar(false);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("confirm_pin_flow_loadtime", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "confirm_pin_flow_loadtime");
        getBaseActivity().showWarningDialog(p0);
    }

    @Override // id.dana.onboarding.confirmpin.ConfirmPinContract.View
    public final void PlaceComponentResult(final boolean p0, final boolean p1) {
        ConfirmPinContract.Presenter presenter;
        String str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.getErrorConfigVersion = p0;
        ConfirmPinContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        String userId = UserInfoManager.instance().getUserId();
        String str2 = userId == null ? "" : userId;
        String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String str4 = str3 == null ? "" : str3;
        String str5 = this.isLayoutRequested;
        String str6 = str5 == null ? "" : str5;
        str = MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2;
        String str7 = str == null ? "" : str;
        String moveToNextValue = TextUtil.moveToNextValue("KYC0");
        Intrinsics.checkNotNullExpressionValue(moveToNextValue, "");
        presenter.KClassImpl$Data$declaredNonStaticMembers$2(str2, str4, str6, str7, moveToNextValue);
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("confirm_pin_flow_loadtime", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "confirm_pin_flow_loadtime");
        getBaseActivity().showSuccessDialog(getString(R.string.msg_registration_complete), new DialogInterface.OnDismissListener() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ConfirmPinFragment.MyBillsEntityDataFactory(p1, this, p0);
            }
        });
    }

    @Override // id.dana.onboarding.confirmpin.ConfirmPinContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("confirm_pin_flow_loadtime", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "confirm_pin_flow_loadtime");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJA\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/onboarding/confirmpin/ConfirmPinFragment$Companion;", "", "", "p0", "p1", "p2", "p3", "p4", "Lid/dana/onboarding/confirmpin/ConfirmPinFragment;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/onboarding/confirmpin/ConfirmPinFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static ConfirmPinFragment PlaceComponentResult(String p0, String p1, String p2, String p3, String p4) {
            Bundle bundle = new Bundle();
            bundle.putString("phoneNumber", p0);
            bundle.putString("nickname", p1);
            bundle.putString("avatarUri", p2);
            bundle.putString("pin", p3);
            bundle.putString("referralCode", p4);
            ConfirmPinFragment confirmPinFragment = new ConfirmPinFragment();
            confirmPinFragment.setArguments(bundle);
            return confirmPinFragment;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(boolean z, final ConfirmPinFragment confirmPinFragment, boolean z2) {
        Intrinsics.checkNotNullParameter(confirmPinFragment, "");
        if (z) {
            EnrollPasskeyLauncher.Companion companion = EnrollPasskeyLauncher.INSTANCE;
            if (EnrollPasskeyLauncher.Companion.PlaceComponentResult()) {
                ((EnrollPasskeyLauncher) confirmPinFragment.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory();
                return;
            }
        }
        if (z2) {
            OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
            OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("dana_viz_flow_loadtime");
            String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.DANA_VIZ_INTRO);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            DanaH5.startContainerFullUrl(authRequestContext, new DanaH5Listener() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$onRegisterSuccess$lambda-7$$inlined$withDanaH5Callback$1
                @Override // id.dana.utils.danah5.DanaH5Listener
                public final void onContainerCreated(Bundle p0) {
                }

                @Override // id.dana.utils.danah5.DanaH5Listener
                public final void onContainerDestroyed(Bundle p0) {
                    OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
                    OnboardingFirebaseTracker onboardingFirebaseTracker2 = OnboardingFirebaseTracker.INSTANCE;
                    Intrinsics.checkNotNullParameter("dana_viz_flow_loadtime", "");
                    OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "dana_viz_flow_loadtime");
                    onboardingNavigationManagerWithMenu = ConfirmPinFragment.this.GetContactSyncConfig;
                    if (onboardingNavigationManagerWithMenu != null) {
                        WelcomeKey welcomeKey = new WelcomeKey();
                        Intrinsics.checkNotNullParameter(welcomeKey, "");
                        onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(welcomeKey);
                    }
                }
            });
            return;
        }
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = confirmPinFragment.GetContactSyncConfig;
        if (onboardingNavigationManagerWithMenu != null) {
            WelcomeKey welcomeKey = new WelcomeKey();
            Intrinsics.checkNotNullParameter(welcomeKey, "");
            onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(welcomeKey);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ConfirmPinFragment confirmPinFragment) {
        Intrinsics.checkNotNullParameter(confirmPinFragment, "");
        confirmPinFragment.onBackPressed();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ConfirmPinFragment confirmPinFragment) {
        AppCompatTextView appCompatTextView;
        PinEntryEditText pinEntryEditText;
        PinEntryEditText pinEntryEditText2;
        AppCompatTextView appCompatTextView2;
        Intrinsics.checkNotNullParameter(confirmPinFragment, "");
        FragmentConfirmPinBinding fragmentConfirmPinBinding = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
        if (Intrinsics.areEqual(String.valueOf((fragmentConfirmPinBinding == null || (appCompatTextView2 = fragmentConfirmPinBinding.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : appCompatTextView2.getText()), confirmPinFragment.getString(R.string.show_pin))) {
            FragmentConfirmPinBinding fragmentConfirmPinBinding2 = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
            if (fragmentConfirmPinBinding2 != null && (pinEntryEditText2 = fragmentConfirmPinBinding2.MyBillsEntityDataFactory) != null) {
                pinEntryEditText2.showCharacters();
            }
            FragmentConfirmPinBinding fragmentConfirmPinBinding3 = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
            appCompatTextView = fragmentConfirmPinBinding3 != null ? fragmentConfirmPinBinding3.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (appCompatTextView != null) {
                appCompatTextView.setText(confirmPinFragment.getString(R.string.hide_pin));
                return;
            }
            return;
        }
        FragmentConfirmPinBinding fragmentConfirmPinBinding4 = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
        if (fragmentConfirmPinBinding4 != null && (pinEntryEditText = fragmentConfirmPinBinding4.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.hideCharacters();
        }
        FragmentConfirmPinBinding fragmentConfirmPinBinding5 = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
        appCompatTextView = fragmentConfirmPinBinding5 != null ? fragmentConfirmPinBinding5.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(confirmPinFragment.getString(R.string.show_pin));
        }
    }

    public static /* synthetic */ void getAuthRequestContext(ConfirmPinFragment confirmPinFragment) {
        PinEntryEditText pinEntryEditText;
        Intrinsics.checkNotNullParameter(confirmPinFragment, "");
        FragmentConfirmPinBinding fragmentConfirmPinBinding = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
        if (fragmentConfirmPinBinding != null && (pinEntryEditText = fragmentConfirmPinBinding.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.focus();
        }
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = confirmPinFragment.GetContactSyncConfig;
        if (onboardingNavigationManagerWithMenu != null) {
            String str = confirmPinFragment.initRecordTimeStamp;
            if (str == null) {
                str = "";
            }
            String str2 = confirmPinFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = confirmPinFragment.MyBillsEntityDataFactory;
            String str4 = confirmPinFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            CreatePinKey.Companion companion = CreatePinKey.INSTANCE;
            CreatePinKey BuiltInFictitiousFunctionClassFactory = CreatePinKey.Companion.BuiltInFictitiousFunctionClassFactory(str, str2, str3, str4);
            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
            onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final ConfirmPinFragment confirmPinFragment, CharSequence charSequence) {
        PinEntryEditText pinEntryEditText;
        Intrinsics.checkNotNullParameter(confirmPinFragment, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        String obj = charSequence.toString();
        if (obj.length() >= 6) {
            KeyboardHelper.MyBillsEntityDataFactory(confirmPinFragment.getBaseActivity());
            if (Intrinsics.areEqual(obj, confirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2)) {
                OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = confirmPinFragment.GetContactSyncConfig;
                if (onboardingNavigationManagerWithMenu != null) {
                    onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(true);
                }
                OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("confirm_pin_flow_loadtime");
                confirmPinFragment.BuiltInFictitiousFunctionClassFactory();
                return;
            }
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu2 = confirmPinFragment.GetContactSyncConfig;
            if (onboardingNavigationManagerWithMenu2 != null) {
                onboardingNavigationManagerWithMenu2.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(false);
            }
            FragmentConfirmPinBinding fragmentConfirmPinBinding = (FragmentConfirmPinBinding) confirmPinFragment.getBinding();
            if (fragmentConfirmPinBinding != null && (pinEntryEditText = fragmentConfirmPinBinding.MyBillsEntityDataFactory) != null) {
                InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
            }
            confirmPinFragment.getBaseActivity().showWarningDialog(confirmPinFragment.getString(R.string.msg_confirm_pin_not_match), new DialogInterface.OnDismissListener() { // from class: id.dana.onboarding.confirmpin.ConfirmPinFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ConfirmPinFragment.getAuthRequestContext(ConfirmPinFragment.this);
                }
            });
        }
    }

    public static final /* synthetic */ FirebasePerformanceMonitor KClassImpl$Data$declaredNonStaticMembers$2(ConfirmPinFragment confirmPinFragment) {
        return (FirebasePerformanceMonitor) confirmPinFragment.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ void getErrorConfigVersion(ConfirmPinFragment confirmPinFragment) {
        if (confirmPinFragment.lookAheadTest) {
            OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
            Intrinsics.checkNotNullParameter("idle_registration_confirm_pin_screen", "");
            OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "idle_registration_confirm_pin_screen");
            confirmPinFragment.lookAheadTest = false;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        ConfirmPinContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda2, FileUtil.MyBillsEntityDataFactory(getContext(), this.MyBillsEntityDataFactory), this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
    }
}
