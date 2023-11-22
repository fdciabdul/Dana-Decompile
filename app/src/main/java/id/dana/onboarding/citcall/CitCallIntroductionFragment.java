package id.dana.onboarding.citcall;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
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
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.data.login.source.network.model.LoginIdType;
import id.dana.databinding.FragmentCitcallIntroductionBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCitCallIntroductionComponent;
import id.dana.di.modules.CitCallIntroductionModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.citcall.model.CitcallPermission;
import id.dana.domain.citcall.model.MiscallConsult;
import id.dana.domain.citcall.model.MiscallResponse;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import id.dana.onboarding.citcall.CitCallContract;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.performancetracker.VerifyMethodAnalyticTracker;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.utils.OSUtil;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import id.dana.utils.permission.ManifestPermission;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 22\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u00012B\u0007¢\u0006\u0004\b1\u0010\nJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001e\u001a\u00020\u001dX\u0087\"¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0013\u001a\u00020$8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010!\u001a\u00020'8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0016\u001a\u00020*8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010%\u001a\u00020*8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010\u001a\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0012R\u0016\u0010.\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u0010\u001bR\u0016\u0010(\u001a\u00020*8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b0\u0010,"}, d2 = {"Lid/dana/onboarding/citcall/CitCallIntroductionFragment;", "Lid/dana/base/KeyBaseFragment;", "Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/onboarding/citcall/CitCallIntroductionKey;", "Lid/dana/databinding/FragmentCitcallIntroductionBinding;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/content/Context;", "p0", "onAttach", "(Landroid/content/Context;)V", "onStart", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "PlaceComponentResult", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "getErrorConfigVersion", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/onboarding/citcall/CitCallIntroductionFragment$callbackPermission$1;", "lookAheadTest", "Lid/dana/onboarding/citcall/CitCallIntroductionFragment$callbackPermission$1;", "getAuthRequestContext", "", "scheduleImpl", "Z", "MyBillsEntityDataFactory", "Lid/dana/onboarding/citcall/CitCallPresenter;", "citCallPresenter", "Lid/dana/onboarding/citcall/CitCallPresenter;", "Lid/dana/dialog/DanaLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/dialog/DanaLoadingDialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "moveToNextValue", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "initRecordTimeStamp", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "", "DatabaseTableConfigUtil", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda7", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CitCallIntroductionFragment extends KeyBaseFragment<OnboardingActivity, CitCallIntroductionKey, FragmentCitcallIntroductionBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private DanaLoadingDialog KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final FragmentPermissionRequest scheduleImpl;
    private final FragmentPermissionRequest PlaceComponentResult;
    @Inject
    public CitCallPresenter citCallPresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final FragmentPermissionRequest BuiltInFictitiousFunctionClassFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private OnboardingNavigationManagerWithMenu NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CitCallIntroductionFragment$callbackPermission$1 getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String lookAheadTest = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String moveToNextValue = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private String initRecordTimeStamp = "";

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final MeasureLoadAndRenderingScreen getErrorConfigVersion = new MeasureLoadAndRenderingScreen();

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
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_citcall_introduction;
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.onboarding.citcall.CitCallIntroductionFragment$callbackPermission$1] */
    public CitCallIntroductionFragment() {
        ?? r1 = new PermissionCallback() { // from class: id.dana.onboarding.citcall.CitCallIntroductionFragment$callbackPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                CitCallPresenter citCallPresenter = CitCallIntroductionFragment.this.citCallPresenter;
                if (citCallPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    citCallPresenter = null;
                }
                citCallPresenter.PlaceComponentResult(CitCallIntroductionFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(CitCallIntroductionFragment.this));
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CitCallPresenter citCallPresenter = CitCallIntroductionFragment.this.citCallPresenter;
                if (citCallPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    citCallPresenter = null;
                }
                citCallPresenter.PlaceComponentResult(CitCallIntroductionFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(CitCallIntroductionFragment.this));
            }
        };
        this.getAuthRequestContext = r1;
        CitCallIntroductionFragment citCallIntroductionFragment = this;
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(citCallIntroductionFragment);
        String[] strArr = {ManifestPermission.READ_CALL_LOG, "android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = (PermissionCallback) r1;
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.PlaceComponentResult = builder.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder2 = new FragmentPermissionRequest.Builder(citCallIntroductionFragment);
        String[] strArr2 = {ManifestPermission.READ_CALL_LOG, "android.permission.READ_PHONE_STATE"};
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder2.getAuthRequestContext = ArraysKt.toSet(strArr2);
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder2.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.scheduleImpl = builder2.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder3 = new FragmentPermissionRequest.Builder(citCallIntroductionFragment);
        String[] strArr3 = {"android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE"};
        Intrinsics.checkNotNullParameter(strArr3, "");
        builder3.getAuthRequestContext = ArraysKt.toSet(strArr3);
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder3.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.BuiltInFictitiousFunctionClassFactory = builder3.PlaceComponentResult();
    }

    public static final /* synthetic */ FragmentCitcallIntroductionBinding KClassImpl$Data$declaredNonStaticMembers$2(CitCallIntroductionFragment citCallIntroductionFragment) {
        return (FragmentCitcallIntroductionBinding) citCallIntroductionFragment.getBinding();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentCitcallIntroductionBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentCitcallIntroductionBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.getErrorConfigVersion;
        Intrinsics.checkNotNullParameter("citcall_introduction_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("citcall_introduction_screen_render");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.IDLE_REGISTRATION_CITCALL_INTRODUCTION_SCREEN);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/onboarding/citcall/CitCallIntroductionFragment$Companion;", "", "", "p0", "", "p1", "p2", "p3", "p4", "Lid/dana/onboarding/citcall/CitCallIntroductionFragment;", "getAuthRequestContext", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)Lid/dana/onboarding/citcall/CitCallIntroductionFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CitCallIntroductionFragment getAuthRequestContext(String p0, boolean p1, boolean p2, String p3, String p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Bundle bundle = new Bundle();
            bundle.putString("phoneNumber", p0);
            bundle.putBoolean(ChallengeControl.Key.HELP_BUTTON_CHATBOT_FEATURE, p1);
            bundle.putBoolean("REFERRAL_FEATURE", p2);
            bundle.putString("PRIZE_NAME", p3);
            bundle.putString(ChallengeControl.Key.SECURITY_ID, p4);
            CitCallIntroductionFragment citCallIntroductionFragment = new CitCallIntroductionFragment();
            citCallIntroductionFragment.setArguments(bundle);
            return citCallIntroductionFragment;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CitCallIntroductionFragment citCallIntroductionFragment) {
        Intrinsics.checkNotNullParameter(citCallIntroductionFragment, "");
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("regis_verify_citcall_flow_loadtime");
        OnboardingFirebaseTracker onboardingFirebaseTracker2 = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter(TrackerKey.Event.IDLE_REGISTRATION_CITCALL_INTRODUCTION_SCREEN, "");
        final CitCallPresenter citCallPresenter = null;
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, TrackerKey.Event.IDLE_REGISTRATION_CITCALL_INTRODUCTION_SCREEN);
        VerifyMethodAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CITCALL_TIME);
        VerifyMethodAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.CITCALL_VERIFICATION_DURATION_REGISTRATION);
        CitCallPresenter citCallPresenter2 = citCallIntroductionFragment.citCallPresenter;
        if (citCallPresenter2 != null) {
            citCallPresenter = citCallPresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        if (OSUtil.GetContactSyncConfig()) {
            citCallPresenter.MyBillsEntityDataFactory.execute(Unit.INSTANCE, new Function1<CitcallPermission, Unit>() { // from class: id.dana.onboarding.citcall.CitCallPresenter$requestCitCallPermission$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CitcallPermission citcallPermission) {
                    invoke2(citcallPermission);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CitcallPermission citcallPermission) {
                    CitCallContract.View view;
                    Intrinsics.checkNotNullParameter(citcallPermission, "");
                    view = CitCallPresenter.this.PlaceComponentResult;
                    view.MyBillsEntityDataFactory(citcallPermission.getEnableReadCallLog(), citcallPermission.getEnableCallPhone());
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.citcall.CitCallPresenter$requestCitCallPermission$2
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
                    CitCallContract.View view;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = CitCallPresenter.this.PlaceComponentResult;
                    view.MyBillsEntityDataFactory(true, false);
                }
            });
        } else {
            citCallPresenter.PlaceComponentResult.MyBillsEntityDataFactory(false, true);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(CitCallIntroductionFragment citCallIntroductionFragment) {
        Intrinsics.checkNotNullParameter(citCallIntroductionFragment, "");
        FragmentActivity activity = citCallIntroductionFragment.getActivity();
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = null;
        OnboardingActivity onboardingActivity = activity instanceof OnboardingActivity ? (OnboardingActivity) activity : null;
        if (onboardingActivity != null) {
            onboardingActivity.setFromCitCall(true);
            onboardingActivity.setOtpPurpose(ChallengeEvent.OTPPurpose.MISCALL_FAILOVER);
        }
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("regis_verify_citcall_flow_loadtime", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "regis_verify_citcall_flow_loadtime");
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu2 = citCallIntroductionFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (onboardingNavigationManagerWithMenu2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            onboardingNavigationManagerWithMenu = onboardingNavigationManagerWithMenu2;
        }
        onboardingNavigationManagerWithMenu.getAuthRequestContext.goBack();
    }

    public static final /* synthetic */ void getAuthRequestContext(CitCallIntroductionFragment citCallIntroductionFragment, boolean z, boolean z2) {
        if (z && z2) {
            citCallIntroductionFragment.PlaceComponentResult.check();
        } else if (z2) {
            citCallIntroductionFragment.BuiltInFictitiousFunctionClassFactory.check();
        } else {
            citCallIntroductionFragment.scheduleImpl.check();
        }
    }

    public static final /* synthetic */ MiscallConsult NetworkUserEntityData$$ExternalSyntheticLambda0(CitCallIntroductionFragment citCallIntroductionFragment) {
        String str = citCallIntroductionFragment.lookAheadTest;
        return new MiscallConsult(str, LoginIdType.MOBILE_NO, "REGISTER", str);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final CitCallIntroductionFragment citCallIntroductionFragment, CitCallDialogState citCallDialogState) {
        BaseActivity baseActivity = citCallIntroductionFragment.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        new CitCallErrorDialog(baseActivity, citCallDialogState, new View.OnClickListener() { // from class: id.dana.onboarding.citcall.CitCallIntroductionFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CitCallIntroductionFragment.PlaceComponentResult(CitCallIntroductionFragment.this);
            }
        }).MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DanaButtonSecondaryView danaButtonSecondaryView;
        Bundle arguments = getArguments();
        byte b = 0;
        if (arguments != null) {
            String string = arguments.getString("phoneNumber");
            if (string == null) {
                string = "";
            }
            this.lookAheadTest = string;
            this.MyBillsEntityDataFactory = arguments.getBoolean(ChallengeControl.Key.HELP_BUTTON_CHATBOT_FEATURE, false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = arguments.getBoolean("REFERRAL_FEATURE", false);
            String string2 = arguments.getString("PRIZE_NAME");
            if (string2 == null) {
                string2 = "";
            }
            this.moveToNextValue = string2;
            String string3 = arguments.getString(ChallengeControl.Key.SECURITY_ID);
            if (string3 == null) {
                string3 = "";
            }
            this.initRecordTimeStamp = string3;
        }
        DaggerCitCallIntroductionComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerCitCallIntroductionComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (CitCallIntroductionModule) Preconditions.getAuthRequestContext(new CitCallIntroductionModule(new CitCallContract.View() { // from class: id.dana.onboarding.citcall.CitCallIntroductionFragment$getCitCallIntroductionModule$1
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
                OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
                String str;
                boolean z;
                String str2;
                String str3;
                Intrinsics.checkNotNullParameter(p0, "");
                onboardingNavigationManagerWithMenu = CitCallIntroductionFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (onboardingNavigationManagerWithMenu == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    onboardingNavigationManagerWithMenu = null;
                }
                str = CitCallIntroductionFragment.this.lookAheadTest;
                String prefix = p0.getPrefix();
                String str4 = prefix == null ? "" : prefix;
                z = CitCallIntroductionFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                str2 = CitCallIntroductionFragment.this.moveToNextValue;
                str3 = CitCallIntroductionFragment.this.initRecordTimeStamp;
                Integer timeUntilNextAttempt = p0.getTimeUntilNextAttempt();
                int intValue = timeUntilNextAttempt != null ? timeUntilNextAttempt.intValue() : 0;
                Integer remainingAttempts = p0.getRemainingAttempts();
                int intValue2 = remainingAttempts != null ? remainingAttempts.intValue() : 0;
                Integer currentAttempts = p0.getCurrentAttempts();
                int intValue3 = currentAttempts != null ? currentAttempts.intValue() : 0;
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str4, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                CitCallVerifyKey citCallVerifyKey = new CitCallVerifyKey(str, str4, z, str2, str3, intValue, intValue2, intValue3);
                Intrinsics.checkNotNullParameter(citCallVerifyKey, "");
                onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(citCallVerifyKey);
            }

            @Override // id.dana.onboarding.citcall.CitCallContract.View
            public final void getAuthRequestContext() {
                CitCallIntroductionFragment.MyBillsEntityDataFactory(CitCallIntroductionFragment.this, CitCallDialogState.NETWORK_TIMEOUT);
            }

            @Override // id.dana.onboarding.citcall.CitCallContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                CitCallIntroductionFragment.MyBillsEntityDataFactory(CitCallIntroductionFragment.this, CitCallDialogState.NETWORK_TIMEOUT);
            }

            @Override // id.dana.onboarding.citcall.CitCallContract.View
            public final void MyBillsEntityDataFactory() {
                CitCallIntroductionFragment.MyBillsEntityDataFactory(CitCallIntroductionFragment.this, CitCallDialogState.RISK_CONSULT);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                FragmentCitcallIntroductionBinding KClassImpl$Data$declaredNonStaticMembers$2 = CitCallIntroductionFragment.KClassImpl$Data$declaredNonStaticMembers$2(CitCallIntroductionFragment.this);
                DanaButtonSecondaryView danaButtonSecondaryView2 = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory : null;
                if (danaButtonSecondaryView2 != null) {
                    danaButtonSecondaryView2.setEnabled(false);
                }
                if (CitCallIntroductionFragment.this.getBaseActivity() != null) {
                    CitCallIntroductionFragment citCallIntroductionFragment = CitCallIntroductionFragment.this;
                    DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(CitCallIntroductionFragment.this.getBaseActivity());
                    if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                        danaLoadingDialog.MyBillsEntityDataFactory.show();
                        danaLoadingDialog.getAuthRequestContext.startRefresh();
                    }
                    citCallIntroductionFragment.KClassImpl$Data$declaredNonStaticMembers$2 = danaLoadingDialog;
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                DanaLoadingDialog danaLoadingDialog;
                FragmentCitcallIntroductionBinding KClassImpl$Data$declaredNonStaticMembers$2 = CitCallIntroductionFragment.KClassImpl$Data$declaredNonStaticMembers$2(CitCallIntroductionFragment.this);
                DanaLoadingDialog danaLoadingDialog2 = null;
                DanaButtonSecondaryView danaButtonSecondaryView2 = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory : null;
                if (danaButtonSecondaryView2 != null) {
                    danaButtonSecondaryView2.setEnabled(true);
                }
                danaLoadingDialog = CitCallIntroductionFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (danaLoadingDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    danaLoadingDialog2 = danaLoadingDialog;
                }
                danaLoadingDialog2.PlaceComponentResult();
            }

            @Override // id.dana.onboarding.citcall.CitCallContract.View
            public final void MyBillsEntityDataFactory(boolean p0, boolean p1) {
                CitCallIntroductionFragment.getAuthRequestContext(CitCallIntroductionFragment.this, p0, p1);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, CitCallIntroductionModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerCitCallIntroductionComponent.CitCallIntroductionComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, b).BuiltInFictitiousFunctionClassFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        CitCallPresenter citCallPresenter = this.citCallPresenter;
        if (citCallPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            citCallPresenter = null;
        }
        abstractPresenterArr[0] = citCallPresenter;
        registerPresenter(abstractPresenterArr);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager();
            FragmentCitcallIntroductionBinding fragmentCitcallIntroductionBinding = (FragmentCitcallIntroductionBinding) getBinding();
            if (fragmentCitcallIntroductionBinding != null && (danaButtonSecondaryView = fragmentCitcallIntroductionBinding.MyBillsEntityDataFactory) != null) {
                danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.citcall.CitCallIntroductionFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CitCallIntroductionFragment.BuiltInFictitiousFunctionClassFactory(CitCallIntroductionFragment.this);
                    }
                });
            }
            View view = getView();
            if (view != null) {
                MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.getErrorConfigVersion;
                Intrinsics.checkNotNullParameter(view, "");
                FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
                FirstDrawListener.Companion.MyBillsEntityDataFactory(view, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }
}
