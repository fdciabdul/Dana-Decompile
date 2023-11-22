package id.dana.onboarding.citcall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleOwnerKt;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.perf.FirebasePerformance;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.KeyBaseActivity;
import id.dana.base.KeyBaseFragment;
import id.dana.challenge.ChallengeControl;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.richview.InputPhoneView;
import id.dana.core.ui.util.connectivity.ConnectivityMonitor;
import id.dana.core.ui.util.connectivity.mapper.ConnectivityModelMapperKt;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import id.dana.data.login.source.network.model.LoginIdType;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.FragmentCitcallVerifyBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCitCallVerifyComponent;
import id.dana.di.modules.CitCallIntroductionModule;
import id.dana.di.modules.CitCallVerifyModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.LoginInfoDialog;
import id.dana.domain.citcall.model.MiscallConsult;
import id.dana.domain.citcall.model.MiscallResponse;
import id.dana.extension.view.InputExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.CitCallVerifyDataModel;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import id.dana.onboarding.citcall.CitCallContract;
import id.dana.onboarding.citcall.CitCallVerifyContract;
import id.dana.onboarding.citcall.CitCallVerifyFragment;
import id.dana.onboarding.createpin.CreatePinKey;
import id.dana.onboarding.referral.VerifyReferralCodeKey;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.performancetracker.VerifyMethodAnalyticTracker;
import id.dana.riskChallenges.ui.missedCallOtp.PhoneStateReceiver;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.textbehavior.InvalidReason;
import id.dana.textbehavior.OnValidatedListener;
import id.dana.tracker.EventTracker;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.utils.DANAToast;
import id.dana.utils.DanaTextWatcher;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.TextUtil;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 M2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002NMB\u0007¢\u0006\u0004\bL\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0007J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0007J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0007J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0007J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\n\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u0007J\u000f\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u0007R\u0012\u0010 \u001a\u00020\u001fX\u0087\"¢\u0006\u0006\n\u0004\b \u0010!R\u0012\u0010#\u001a\u00020\"X\u0087\"¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010%R\u0013\u0010\n\u001a\u00020&X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u001e\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0013\u0010\u0006\u001a\u00020/X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b0\u0010(R\u0014\u0010-\u001a\u0002018\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u0010'\u001a\u0002048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010*\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00100\u001a\u00020\u00138\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b9\u00108R\u0016\u00102\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010:\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b;\u00108R\u0018\u00109\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u00107\u001a\u00020?8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0013\u00105\u001a\u00020BX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bC\u0010(R\u0018\u0010;\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010%R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bE\u0010%R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bF\u0010%R\u0016\u0010D\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bG\u00108R\u0016\u0010E\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u0010.R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bI\u0010%R\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u0010.R\u0014\u0010G\u001a\u0002018\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bK\u00103"}, d2 = {"Lid/dana/onboarding/citcall/CitCallVerifyFragment;", "Lid/dana/base/KeyBaseFragment;", "Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/onboarding/citcall/CitCallVerifyKey;", "Lid/dana/databinding/FragmentCitcallVerifyBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "Landroid/content/Context;", "onAttach", "(Landroid/content/Context;)V", "", "onBackPressed", "()Z", "onDestroyView", "onPause", "onResume", "onStart", "onStop", "Lid/dana/onboarding/citcall/CitCallVerifyFragment$ButtonState;", "(Lid/dana/onboarding/citcall/CitCallVerifyFragment$ButtonState;)V", "PlaceComponentResult", "MyBillsEntityDataFactory", "Lid/dana/onboarding/citcall/CitCallPresenter;", "citCallPresenter", "Lid/dana/onboarding/citcall/CitCallPresenter;", "Lid/dana/onboarding/citcall/CitCallVerifyPresenter;", "citCallVerifyPresenter", "Lid/dana/onboarding/citcall/CitCallVerifyPresenter;", "Ljava/lang/String;", "Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "Landroid/os/CountDownTimer;", "lookAheadTest", "Landroid/os/CountDownTimer;", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "I", "Lid/dana/dialog/DanaLoadingDialog;", "getErrorConfigVersion", "Landroid/content/BroadcastReceiver;", "scheduleImpl", "Landroid/content/BroadcastReceiver;", "Lid/dana/utils/DanaTextWatcher;", "DatabaseTableConfigUtil", "Lid/dana/utils/DanaTextWatcher;", "initRecordTimeStamp", "Z", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/dialog/LoginInfoDialog;", "newProxyInstance", "Lid/dana/dialog/LoginInfoDialog;", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "PrepareContext", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda6", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda5", "whenAvailable", "<init>", "Companion", "ButtonState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CitCallVerifyFragment extends KeyBaseFragment<OnboardingActivity, CitCallVerifyKey, FragmentCitcallVerifyBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private int isLayoutRequested;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    @Inject
    public CitCallPresenter citCallPresenter;
    @Inject
    public CitCallVerifyPresenter citCallVerifyPresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private CountDownTimer BuiltInFictitiousFunctionClassFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private LoginInfoDialog GetContactSyncConfig;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<ConnectivityMonitor>() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$connectivityMonitor$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivityMonitor invoke() {
            Context requireContext = CitCallVerifyFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            return new ConnectivityMonitor(requireContext);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy DatabaseTableConfigUtil = LazyKt.lazy(new Function0<OnboardingNavigationManagerWithMenu>() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$onboardingNavigationManager$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final OnboardingNavigationManagerWithMenu invoke() {
            BaseActivity baseActivity = CitCallVerifyFragment.this.getBaseActivity();
            if (baseActivity != null) {
                return ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager();
            }
            throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
        }
    });

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String newProxyInstance = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda8 = "";

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(CitCallVerifyFragment.this.requireActivity());
        }
    });

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private String PrepareContext = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda3 = 1000;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory = 1;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final DanaTextWatcher NetworkUserEntityData$$ExternalSyntheticLambda0 = new DanaTextWatcher();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean scheduleImpl = true;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final MeasureLoadAndRenderingScreen initRecordTimeStamp = new MeasureLoadAndRenderingScreen();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final BroadcastReceiver moveToNextValue = new BroadcastReceiver() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$fourDigitsReceiver$1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            int i;
            InputPhoneView inputPhoneView;
            EditText input;
            InputPhoneView inputPhoneView2;
            Intrinsics.checkNotNullParameter(intent, "");
            String stringExtra = intent.getStringExtra(PhoneStateReceiver.LAST_FOUR_DIGIT);
            String str = stringExtra;
            if ((str == null || str.length() == 0) || Intrinsics.areEqual(stringExtra, "null")) {
                return;
            }
            i = CitCallVerifyFragment.this.MyBillsEntityDataFactory;
            VerifyMethodAnalyticTracker.getAuthRequestContext(SummaryActivity.CHECKED, String.valueOf(i), TrackerKey.Event.CITCALL_VERIFICATION_DURATION_REGISTRATION);
            CitCallVerifyFragment.this.lookAheadTest = true;
            FragmentCitcallVerifyBinding moveToNextValue = CitCallVerifyFragment.moveToNextValue(CitCallVerifyFragment.this);
            if (moveToNextValue != null && (inputPhoneView2 = moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                inputPhoneView2.setInput(stringExtra);
            }
            FragmentCitcallVerifyBinding moveToNextValue2 = CitCallVerifyFragment.moveToNextValue(CitCallVerifyFragment.this);
            if (moveToNextValue2 == null || (inputPhoneView = moveToNextValue2.KClassImpl$Data$declaredNonStaticMembers$2) == null || (input = inputPhoneView.getInput()) == null) {
                return;
            }
            input.setSelection(stringExtra.length());
        }
    };

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final BroadcastReceiver NetworkUserEntityData$$ExternalSyntheticLambda6 = new BroadcastReceiver() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$verifyCommandReceiver$1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "");
            if (intent.hasExtra(PhoneStateReceiver.VERIFY) && intent.getBooleanExtra(PhoneStateReceiver.VERIFY, false)) {
                CitCallVerifyFragment.this.MyBillsEntityDataFactory();
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(r2), Dispatchers.getIO(), null, new CitCallVerifyFragment$forceSetConnected$1(CitCallVerifyFragment.this, null), 2, null);
            }
        }
    };

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/onboarding/citcall/CitCallVerifyFragment$ButtonState;", "", "<init>", "(Ljava/lang/String;I)V", "COUNTDOWN_TIMER", "TRY_AGAIN", "SEND_OTP_SMS"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum ButtonState {
        COUNTDOWN_TIMER,
        TRY_AGAIN,
        SEND_OTP_SMS
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[ButtonState.values().length];
            iArr[ButtonState.COUNTDOWN_TIMER.ordinal()] = 1;
            iArr[ButtonState.TRY_AGAIN.ordinal()] = 2;
            iArr[ButtonState.SEND_OTP_SMS.ordinal()] = 3;
            PlaceComponentResult = iArr;
        }
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
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

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_citcall_verify;
    }

    public static final /* synthetic */ FragmentCitcallVerifyBinding moveToNextValue(CitCallVerifyFragment citCallVerifyFragment) {
        return (FragmentCitcallVerifyBinding) citCallVerifyFragment.getBinding();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentCitcallVerifyBinding authRequestContext = FragmentCitcallVerifyBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.initRecordTimeStamp;
        Intrinsics.checkNotNullParameter("citcall_verify_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("citcall_verify_screen_render");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        String string = getString(R.string.citcall_success_toast_miss_call, TextUtil.getAuthRequestContext(getAuthRequestContext(this.newProxyInstance), getAuthRequestContext(this.newProxyInstance)));
        Intrinsics.checkNotNullExpressionValue(string, "");
        DANAToast.getAuthRequestContext(baseActivity, string);
    }

    private static String getAuthRequestContext(String p0) {
        return StringsKt.contains$default((CharSequence) p0, (CharSequence) "+62", false, 2, (Object) null) ? StringsKt.replace$default(p0, "+62", "0", false, 4, (Object) null) : p0;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        FragmentActivity activity = getActivity();
        OnboardingActivity onboardingActivity = activity instanceof OnboardingActivity ? (OnboardingActivity) activity : null;
        if (onboardingActivity != null) {
            onboardingActivity.setFromCitCall(true);
            onboardingActivity.setOtpPurpose(ChallengeEvent.OTPPurpose.MISCALL_FAILOVER);
        }
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("regis_verify_citcall_flow_loadtime", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "regis_verify_citcall_flow_loadtime");
        ((OnboardingNavigationManagerWithMenu) this.DatabaseTableConfigUtil.getValue()).getAuthRequestContext.jumpToRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(ButtonState p0) {
        MaterialTextView materialTextView;
        FragmentCitcallVerifyBinding fragmentCitcallVerifyBinding = (FragmentCitcallVerifyBinding) getBinding();
        if (fragmentCitcallVerifyBinding == null || (materialTextView = fragmentCitcallVerifyBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        int i = WhenMappings.PlaceComponentResult[p0.ordinal()];
        if (i != 1) {
            if (i == 2) {
                materialTextView.setText(getString(R.string.citcall_verification_try_again));
                materialTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.f27072131100488));
                materialTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CitCallVerifyFragment.getAuthRequestContext(CitCallVerifyFragment.this);
                    }
                });
                materialTextView.setEnabled(true);
                return;
            } else if (i == 3) {
                materialTextView.setText(getString(R.string.citcall_send_me_otp_sms));
                materialTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.f27072131100488));
                materialTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CitCallVerifyFragment.MyBillsEntityDataFactory(CitCallVerifyFragment.this);
                    }
                });
                materialTextView.setEnabled(true);
                return;
            } else {
                return;
            }
        }
        materialTextView.setEnabled(false);
        materialTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.f24032131100003));
        double d = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        Double.isNaN(d);
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = (int) Math.ceil(d / 1000.0d);
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            final long millis = TimeUnit.SECONDS.toMillis(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            final long millis2 = TimeUnit.SECONDS.toMillis(1L);
            this.BuiltInFictitiousFunctionClassFactory = new CountDownTimer(millis, millis2) { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$setupButton$1$1
                @Override // android.os.CountDownTimer
                public final void onTick(long p02) {
                    int i2;
                    int i3;
                    String valueOf;
                    int i4;
                    int i5;
                    i2 = CitCallVerifyFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    if (i2 / 10 <= 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append('0');
                        i5 = CitCallVerifyFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                        sb.append(i5);
                        valueOf = sb.toString();
                    } else {
                        i3 = CitCallVerifyFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                        valueOf = String.valueOf(i3);
                    }
                    FragmentCitcallVerifyBinding moveToNextValue = CitCallVerifyFragment.moveToNextValue(CitCallVerifyFragment.this);
                    MaterialTextView materialTextView2 = moveToNextValue != null ? moveToNextValue.BuiltInFictitiousFunctionClassFactory : null;
                    if (materialTextView2 != null) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = CitCallVerifyFragment.this.getString(R.string.citcall_otp_timer);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        String format = String.format(string, Arrays.copyOf(new Object[]{valueOf}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "");
                        materialTextView2.setText(format);
                    }
                    CitCallVerifyFragment citCallVerifyFragment = CitCallVerifyFragment.this;
                    i4 = citCallVerifyFragment.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    citCallVerifyFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 = i4 - 1;
                }

                @Override // android.os.CountDownTimer
                public final void onFinish() {
                    int i2;
                    i2 = CitCallVerifyFragment.this.isLayoutRequested;
                    if (i2 > 0) {
                        CitCallVerifyFragment.this.getAuthRequestContext(CitCallVerifyFragment.ButtonState.TRY_AGAIN);
                    } else {
                        CitCallVerifyFragment.this.getAuthRequestContext(CitCallVerifyFragment.ButtonState.SEND_OTP_SMS);
                    }
                }
            };
        }
        CountDownTimer countDownTimer = this.BuiltInFictitiousFunctionClassFactory;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.IDLE_REGISTRATION_CITCALL_INPUT_OTP_SCREEN);
        MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        CitCallVerifyPresenter citCallVerifyPresenter;
        InputPhoneView inputPhoneView;
        EditText input;
        if (this.lookAheadTest && this.getErrorConfigVersion) {
            CitCallVerifyPresenter citCallVerifyPresenter2 = this.citCallVerifyPresenter;
            Editable editable = null;
            if (citCallVerifyPresenter2 != null) {
                citCallVerifyPresenter = citCallVerifyPresenter2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                citCallVerifyPresenter = null;
            }
            FragmentCitcallVerifyBinding fragmentCitcallVerifyBinding = (FragmentCitcallVerifyBinding) getBinding();
            if (fragmentCitcallVerifyBinding != null && (inputPhoneView = fragmentCitcallVerifyBinding.KClassImpl$Data$declaredNonStaticMembers$2) != null && (input = inputPhoneView.getInput()) != null) {
                editable = input.getText();
            }
            citCallVerifyPresenter.MyBillsEntityDataFactory(String.valueOf(editable), this.PrepareContext, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.MyBillsEntityDataFactory);
            this.lookAheadTest = false;
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PhoneStateReceiver.ACTION_LAST_FOUR_DIGIT);
        intentFilter.addAction(PhoneStateReceiver.ACTION_VERIFY);
        ContextCompat.PlaceComponentResult(requireContext(), this.moveToNextValue, intentFilter, "android.permission.READ_PHONE_STATE", null, 4);
        ContextCompat.PlaceComponentResult(requireContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda6, intentFilter, "android.permission.READ_PHONE_STATE", null, 4);
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.moveToNextValue);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.unregisterReceiver(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        }
        ((ConnectivityMonitor) this.getAuthRequestContext.getValue()).PlaceComponentResult(getViewLifecycleOwner());
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.BuiltInFictitiousFunctionClassFactory;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        _$_clearFindViewByIdCache();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/onboarding/citcall/CitCallVerifyFragment$Companion;", "", "Lid/dana/model/CitCallVerifyDataModel;", "p0", "Lid/dana/onboarding/citcall/CitCallVerifyFragment;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/model/CitCallVerifyDataModel;)Lid/dana/onboarding/citcall/CitCallVerifyFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CitCallVerifyFragment BuiltInFictitiousFunctionClassFactory(CitCallVerifyDataModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Bundle bundle = new Bundle();
            bundle.putString("phoneNumber", p0.MyBillsEntityDataFactory);
            bundle.putString("citcallPrefix", p0.PlaceComponentResult);
            bundle.putInt("timeUntilNextAttempt", p0.KClassImpl$Data$declaredNonStaticMembers$2);
            bundle.putInt("remainingAttempts", p0.moveToNextValue);
            bundle.putInt("currentAttempts", p0.getAuthRequestContext);
            bundle.putBoolean("REFERRAL_FEATURE", p0.getScheduleImpl());
            bundle.putString("PRIZE_NAME", p0.BuiltInFictitiousFunctionClassFactory);
            bundle.putString(ChallengeControl.Key.SECURITY_ID, p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
            CitCallVerifyFragment citCallVerifyFragment = new CitCallVerifyFragment();
            citCallVerifyFragment.setArguments(bundle);
            return citCallVerifyFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        KeyboardHelper.MyBillsEntityDataFactory(getBaseActivity());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CitCallVerifyFragment citCallVerifyFragment) {
        Intrinsics.checkNotNullParameter(citCallVerifyFragment, "");
        citCallVerifyFragment.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void PlaceComponentResult(CitCallVerifyFragment citCallVerifyFragment) {
        Intrinsics.checkNotNullParameter(citCallVerifyFragment, "");
        citCallVerifyFragment.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void getAuthRequestContext(FragmentCitcallVerifyBinding fragmentCitcallVerifyBinding) {
        Intrinsics.checkNotNullParameter(fragmentCitcallVerifyBinding, "");
        InputExtKt.PlaceComponentResult(fragmentCitcallVerifyBinding.KClassImpl$Data$declaredNonStaticMembers$2.getInput());
    }

    public static /* synthetic */ void getAuthRequestContext(CitCallVerifyFragment citCallVerifyFragment) {
        Intrinsics.checkNotNullParameter(citCallVerifyFragment, "");
        VerifyMethodAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.CITCALL_VERIFICATION_DURATION_REGISTRATION);
        CitCallPresenter citCallPresenter = citCallVerifyFragment.citCallPresenter;
        if (citCallPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            citCallPresenter = null;
        }
        String str = citCallVerifyFragment.newProxyInstance;
        citCallPresenter.PlaceComponentResult(new MiscallConsult(str, LoginIdType.MOBILE_NO, "REGISTER", str));
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CitCallVerifyFragment citCallVerifyFragment) {
        Intrinsics.checkNotNullParameter(citCallVerifyFragment, "");
        boolean z = citCallVerifyFragment.NetworkUserEntityData$$ExternalSyntheticLambda7;
        String str = citCallVerifyFragment.newProxyInstance;
        if (z && z) {
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = (OnboardingNavigationManagerWithMenu) citCallVerifyFragment.DatabaseTableConfigUtil.getValue();
            if (str == null) {
                str = "";
            }
            String str2 = citCallVerifyFragment.NetworkUserEntityData$$ExternalSyntheticLambda8;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            VerifyReferralCodeKey verifyReferralCodeKey = new VerifyReferralCodeKey(str, str2);
            Intrinsics.checkNotNullParameter(verifyReferralCodeKey, "");
            onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(verifyReferralCodeKey);
        } else {
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu2 = (OnboardingNavigationManagerWithMenu) citCallVerifyFragment.DatabaseTableConfigUtil.getValue();
            String str3 = str != null ? str : "";
            String prependZeroToPhoneNumber = NumberUtils.prependZeroToPhoneNumber(str);
            Intrinsics.checkNotNullExpressionValue(prependZeroToPhoneNumber, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(prependZeroToPhoneNumber, "");
            CreatePinKey.Companion companion = CreatePinKey.INSTANCE;
            CreatePinKey BuiltInFictitiousFunctionClassFactory = CreatePinKey.Companion.BuiltInFictitiousFunctionClassFactory(str3, prependZeroToPhoneNumber, null, null);
            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
            onboardingNavigationManagerWithMenu2.getAuthRequestContext.goTo(BuiltInFictitiousFunctionClassFactory);
        }
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("regis_verify_citcall_flow_loadtime", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "regis_verify_citcall_flow_loadtime");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CitCallVerifyFragment citCallVerifyFragment, ConnectivityModel connectivityModel) {
        Intrinsics.checkNotNullParameter(citCallVerifyFragment, "");
        Intrinsics.checkNotNullExpressionValue(connectivityModel, "");
        citCallVerifyFragment.getErrorConfigVersion = ConnectivityModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(connectivityModel);
        citCallVerifyFragment.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "");
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(editText);
    }

    public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(String str, boolean z) {
        boolean z2 = true;
        if (z) {
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            }
            return z2 ? TrackerKey.DefaultValue.DEFAULT_ERROR_CODE : str;
        }
        String str3 = str;
        if (str3 != null && str3.length() != 0) {
            z2 = false;
        }
        return z2 ? TrackerKey.DefaultValue.DEFAULT_ERROR_MESSAGE : str;
    }

    public static final /* synthetic */ ConnectivityMonitor lookAheadTest(CitCallVerifyFragment citCallVerifyFragment) {
        return (ConnectivityMonitor) citCallVerifyFragment.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ DanaLoadingDialog getErrorConfigVersion(CitCallVerifyFragment citCallVerifyFragment) {
        return (DanaLoadingDialog) citCallVerifyFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda7(CitCallVerifyFragment citCallVerifyFragment) {
        citCallVerifyFragment.getErrorConfigVersion = true;
        citCallVerifyFragment.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final CitCallVerifyFragment citCallVerifyFragment, CitCallDialogState citCallDialogState) {
        BaseActivity baseActivity = citCallVerifyFragment.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        new CitCallErrorDialog(baseActivity, citCallDialogState, new View.OnClickListener() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CitCallVerifyFragment.PlaceComponentResult(CitCallVerifyFragment.this);
            }
        }).MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda5(final CitCallVerifyFragment citCallVerifyFragment) {
        LoginInfoDialog.Builder builder = new LoginInfoDialog.Builder(citCallVerifyFragment.getBaseActivity());
        builder.PlaceComponentResult = citCallVerifyFragment.getString(R.string.verification_success);
        builder.MyBillsEntityDataFactory = true;
        LoginInfoDialog.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.SUCCESS;
        Integer num = 1000;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = num.intValue();
        MyBillsEntityDataFactory.getAuthRequestContext = new DialogInterface.OnDismissListener() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                CitCallVerifyFragment.BuiltInFictitiousFunctionClassFactory(CitCallVerifyFragment.this);
            }
        };
        LoginInfoDialog loginInfoDialog = new LoginInfoDialog(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsEntityDataFactory, (byte) 0);
        loginInfoDialog.MyBillsEntityDataFactory();
        citCallVerifyFragment.GetContactSyncConfig = loginInfoDialog;
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        InputPhoneView inputPhoneView;
        EditText input;
        InputPhoneView inputPhoneView2;
        DaggerCitCallVerifyComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerCitCallVerifyComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (CitCallVerifyModule) Preconditions.getAuthRequestContext(new CitCallVerifyModule(new CitCallVerifyContract.View() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$getCitCallVerifyModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.onboarding.citcall.CitCallVerifyContract.View
            public final void MyBillsEntityDataFactory() {
                CitCallVerifyFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
                CitCallVerifyFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(CitCallVerifyFragment.this);
                Context context = CitCallVerifyFragment.this.getContext();
                if (context != null) {
                    VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(context, TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CITCALL_TIME, TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CITCALL_SUCCESS, null, null);
                }
            }

            @Override // id.dana.onboarding.citcall.CitCallVerifyContract.View
            public final void MyBillsEntityDataFactory(String p0, String p1) {
                FragmentActivity activity = CitCallVerifyFragment.this.getActivity();
                if (activity != null) {
                    CitCallVerifyFragment citCallVerifyFragment = CitCallVerifyFragment.this;
                    DANAToast dANAToast = DANAToast.PlaceComponentResult;
                    BaseActivity baseActivity = citCallVerifyFragment.getBaseActivity();
                    Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                    String string = activity.getString(R.string.citcall_wrong_otp_message);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    DANAToast.PlaceComponentResult(baseActivity, string);
                }
                Context context = CitCallVerifyFragment.this.getContext();
                if (context != null) {
                    VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(context, TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CITCALL_TIME, TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CITCALL_FAILED, CitCallVerifyFragment.KClassImpl$Data$declaredNonStaticMembers$2(p0, true), CitCallVerifyFragment.KClassImpl$Data$declaredNonStaticMembers$2(p1, false));
                }
            }

            @Override // id.dana.onboarding.citcall.CitCallVerifyContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                int i;
                FragmentActivity activity = CitCallVerifyFragment.this.getActivity();
                if (activity != null) {
                    CitCallVerifyFragment citCallVerifyFragment = CitCallVerifyFragment.this;
                    DANAToast dANAToast = DANAToast.PlaceComponentResult;
                    BaseActivity baseActivity = citCallVerifyFragment.getBaseActivity();
                    Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                    String string = activity.getString(R.string.citcall_otp_reach_limit_message);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    DANAToast.PlaceComponentResult(baseActivity, string);
                }
                i = CitCallVerifyFragment.this.MyBillsEntityDataFactory;
                VerifyMethodAnalyticTracker.getAuthRequestContext("false", String.valueOf(i), TrackerKey.Event.CITCALL_VERIFICATION_DURATION_REGISTRATION);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                DanaLoadingDialog errorConfigVersion = CitCallVerifyFragment.getErrorConfigVersion(CitCallVerifyFragment.this);
                if (errorConfigVersion.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                errorConfigVersion.MyBillsEntityDataFactory.show();
                errorConfigVersion.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CitCallVerifyFragment.getErrorConfigVersion(CitCallVerifyFragment.this).PlaceComponentResult();
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (CitCallIntroductionModule) Preconditions.getAuthRequestContext(new CitCallIntroductionModule(new CitCallContract.View() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$getCitCallIntroductionModule$1
            @Override // id.dana.onboarding.citcall.CitCallContract.View
            public final void MyBillsEntityDataFactory(boolean p0, boolean p1) {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.onboarding.citcall.CitCallContract.View
            public final void PlaceComponentResult(MiscallResponse p0) {
                InputPhoneView inputPhoneView3;
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                CitCallVerifyFragment citCallVerifyFragment = CitCallVerifyFragment.this;
                String prefix = p0.getPrefix();
                citCallVerifyFragment.PlaceComponentResult = prefix != null ? prefix : "";
                Integer timeUntilNextAttempt = p0.getTimeUntilNextAttempt();
                citCallVerifyFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 = timeUntilNextAttempt != null ? timeUntilNextAttempt.intValue() : 0;
                Integer remainingAttempts = p0.getRemainingAttempts();
                citCallVerifyFragment.isLayoutRequested = remainingAttempts != null ? remainingAttempts.intValue() : 0;
                Integer currentAttempts = p0.getCurrentAttempts();
                citCallVerifyFragment.MyBillsEntityDataFactory = currentAttempts != null ? currentAttempts.intValue() : citCallVerifyFragment.MyBillsEntityDataFactory;
                FragmentCitcallVerifyBinding moveToNextValue = CitCallVerifyFragment.moveToNextValue(CitCallVerifyFragment.this);
                if (moveToNextValue != null && (inputPhoneView3 = moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                    CitCallVerifyFragment citCallVerifyFragment2 = CitCallVerifyFragment.this;
                    InputExtKt.MyBillsEntityDataFactory(inputPhoneView3.getInput());
                    str = citCallVerifyFragment2.PlaceComponentResult;
                    InputPhoneView.setPrefixMissedCallOtp$default(inputPhoneView3, str, 0, 2, null);
                }
                CitCallVerifyFragment.this.getAuthRequestContext(CitCallVerifyFragment.ButtonState.COUNTDOWN_TIMER);
                CitCallVerifyFragment.this.PlaceComponentResult();
            }

            @Override // id.dana.onboarding.citcall.CitCallContract.View
            public final void getAuthRequestContext() {
                CitCallVerifyFragment.MyBillsEntityDataFactory(CitCallVerifyFragment.this, CitCallDialogState.NETWORK_TIMEOUT);
            }

            @Override // id.dana.onboarding.citcall.CitCallContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                CitCallVerifyFragment.MyBillsEntityDataFactory(CitCallVerifyFragment.this, CitCallDialogState.NETWORK_TIMEOUT);
            }

            @Override // id.dana.onboarding.citcall.CitCallContract.View
            public final void MyBillsEntityDataFactory() {
                CitCallVerifyFragment.MyBillsEntityDataFactory(CitCallVerifyFragment.this, CitCallDialogState.RISK_CONSULT);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                DanaLoadingDialog errorConfigVersion = CitCallVerifyFragment.getErrorConfigVersion(CitCallVerifyFragment.this);
                if (errorConfigVersion.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                errorConfigVersion.MyBillsEntityDataFactory.show();
                errorConfigVersion.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CitCallVerifyFragment.getErrorConfigVersion(CitCallVerifyFragment.this).PlaceComponentResult();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, CitCallVerifyModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, CitCallIntroductionModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerCitCallVerifyComponent.CitCallVerifyComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(new AbstractContract.AbstractPresenter[0]);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("phoneNumber");
            if (string == null) {
                string = "";
            }
            this.newProxyInstance = string;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = arguments.getBoolean("REFERRAL_FEATURE", false);
            String string2 = arguments.getString("PRIZE_NAME");
            if (string2 == null) {
                string2 = "";
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = string2;
            String string3 = arguments.getString("citcallPrefix");
            if (string3 == null) {
                string3 = "";
            }
            this.PlaceComponentResult = string3;
            String string4 = arguments.getString(ChallengeControl.Key.SECURITY_ID);
            if (string4 == null) {
                string4 = "";
            }
            this.PrepareContext = string4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = arguments.getInt("timeUntilNextAttempt");
            this.isLayoutRequested = arguments.getInt("remainingAttempts");
            this.MyBillsEntityDataFactory = arguments.getInt("currentAttempts");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = arguments.getString(ChallengeControl.Key.OTP_PURPOSE);
        }
        FragmentCitcallVerifyBinding fragmentCitcallVerifyBinding = (FragmentCitcallVerifyBinding) getBinding();
        if (fragmentCitcallVerifyBinding != null && (inputPhoneView2 = fragmentCitcallVerifyBinding.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            InputPhoneView.setPrefixMissedCallOtp$default(inputPhoneView2, this.PlaceComponentResult, 0, 2, null);
            inputPhoneView2.requestFocus();
            inputPhoneView2.setOnValidatedListener(new OnValidatedListener() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$setupCitCallPrefix$1$1
                @Override // id.dana.textbehavior.OnValidatedListener
                public final void MyBillsEntityDataFactory(String p0, List<InvalidReason> p1) {
                }

                @Override // id.dana.textbehavior.OnValidatedListener
                public final void getAuthRequestContext(String p0) {
                    boolean z;
                    CitCallVerifyPresenter citCallVerifyPresenter;
                    String str;
                    String str2;
                    String str3;
                    int i;
                    z = CitCallVerifyFragment.this.lookAheadTest;
                    if (z) {
                        return;
                    }
                    CitCallVerifyPresenter citCallVerifyPresenter2 = CitCallVerifyFragment.this.citCallVerifyPresenter;
                    if (citCallVerifyPresenter2 != null) {
                        citCallVerifyPresenter = citCallVerifyPresenter2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        citCallVerifyPresenter = null;
                    }
                    String str4 = p0 == null ? "" : p0;
                    str = CitCallVerifyFragment.this.PrepareContext;
                    str2 = CitCallVerifyFragment.this.newProxyInstance;
                    str3 = CitCallVerifyFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    i = CitCallVerifyFragment.this.MyBillsEntityDataFactory;
                    citCallVerifyPresenter.MyBillsEntityDataFactory(str4, str, str2, str3, i);
                    OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                    Intrinsics.checkNotNullParameter(TrackerKey.Event.USER_INTERACTION_REGISTRATION_CITCALL_OTP_INPUT, "");
                    OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, TrackerKey.Event.USER_INTERACTION_REGISTRATION_CITCALL_OTP_INPUT);
                }
            });
        }
        getAuthRequestContext(ButtonState.COUNTDOWN_TIMER);
        FragmentCitcallVerifyBinding fragmentCitcallVerifyBinding2 = (FragmentCitcallVerifyBinding) getBinding();
        if (fragmentCitcallVerifyBinding2 != null && (inputPhoneView = fragmentCitcallVerifyBinding2.KClassImpl$Data$declaredNonStaticMembers$2) != null && (input = inputPhoneView.getInput()) != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(input, new TextWatcher() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$observeCompleteInputAndFirstInputOtp$1$1
                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    int i;
                    boolean z;
                    String str;
                    Intrinsics.checkNotNullParameter(p0, "");
                    i = CitCallVerifyFragment.this.MyBillsEntityDataFactory;
                    VerifyMethodAnalyticTracker.getAuthRequestContext(SummaryActivity.CHECKED, String.valueOf(i), TrackerKey.Event.CITCALL_VERIFICATION_DURATION_REGISTRATION);
                    if (!TextUtils.isEmpty(p0)) {
                        CitCallVerifyPresenter citCallVerifyPresenter = CitCallVerifyFragment.this.citCallVerifyPresenter;
                        if (citCallVerifyPresenter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            citCallVerifyPresenter = null;
                        }
                        str = CitCallVerifyFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (!citCallVerifyPresenter.PlaceComponentResult) {
                            citCallVerifyPresenter.PlaceComponentResult = true;
                            EventTracker.PlaceComponentResult(citCallVerifyPresenter.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(str));
                        }
                    }
                    z = CitCallVerifyFragment.this.scheduleImpl;
                    if (z) {
                        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.USER_INTERACTION_REGISTRATION_CITCALL_OTP_INPUT);
                        OnboardingFirebaseTracker onboardingFirebaseTracker2 = OnboardingFirebaseTracker.INSTANCE;
                        Intrinsics.checkNotNullParameter(TrackerKey.Event.IDLE_REGISTRATION_CITCALL_INPUT_OTP_SCREEN, "");
                        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, TrackerKey.Event.IDLE_REGISTRATION_CITCALL_INPUT_OTP_SCREEN);
                        CitCallVerifyFragment.this.scheduleImpl = false;
                    }
                }
            });
        }
        final FragmentCitcallVerifyBinding fragmentCitcallVerifyBinding3 = (FragmentCitcallVerifyBinding) getBinding();
        if (fragmentCitcallVerifyBinding3 != null) {
            fragmentCitcallVerifyBinding3.KClassImpl$Data$declaredNonStaticMembers$2.postDelayed(new Runnable() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CitCallVerifyFragment.getAuthRequestContext(FragmentCitcallVerifyBinding.this);
                }
            }, 500L);
            final EditText input2 = fragmentCitcallVerifyBinding3.KClassImpl$Data$declaredNonStaticMembers$2.getInput();
            input2.post(new Runnable() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CitCallVerifyFragment.MyBillsEntityDataFactory(input2);
                }
            });
            KeyboardHelper.PlaceComponentResult(fragmentCitcallVerifyBinding3.getAuthRequestContext, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$setupKeyboardListener$1$3
                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void MyBillsEntityDataFactory() {
                }

                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    AppCompatImageView appCompatImageView = FragmentCitcallVerifyBinding.this.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                    ViewExtKt.PlaceComponentResult(appCompatImageView, 0, 0, 0, 0);
                    ScrollView scrollView = FragmentCitcallVerifyBinding.this.getAuthRequestContext;
                    View requireView = this.requireView();
                    Intrinsics.checkNotNullExpressionValue(requireView, "");
                    scrollView.smoothScrollTo(0, KeyboardHelper.getAuthRequestContext(requireView));
                }
            });
        }
        if ((this.PlaceComponentResult.length() > 0 ? (byte) 1 : (byte) 0) != 0) {
            PlaceComponentResult();
        }
        View getAuthRequestContext = getGetAuthRequestContext();
        if (getAuthRequestContext != null) {
            MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.initRecordTimeStamp;
            Intrinsics.checkNotNullParameter(getAuthRequestContext, "");
            FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
            FirstDrawListener.Companion.MyBillsEntityDataFactory(getAuthRequestContext, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
        }
        ((ConnectivityMonitor) this.getAuthRequestContext.getValue()).PlaceComponentResult(getViewLifecycleOwner(), new Observer() { // from class: id.dana.onboarding.citcall.CitCallVerifyFragment$$ExternalSyntheticLambda5
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                CitCallVerifyFragment.MyBillsEntityDataFactory(CitCallVerifyFragment.this, (ConnectivityModel) obj);
            }
        });
    }

    @Override // id.dana.base.BaseFragment
    public final boolean onBackPressed() {
        ((OnboardingNavigationManagerWithMenu) this.DatabaseTableConfigUtil.getValue()).getAuthRequestContext.goBack();
        return true;
    }
}
