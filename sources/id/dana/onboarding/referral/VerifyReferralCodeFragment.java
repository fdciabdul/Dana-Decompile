package id.dana.onboarding.referral;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.firebase.perf.FirebasePerformance;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.KeyBaseActivity;
import id.dana.base.KeyBaseFragment;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.util.connectivity.ConnectivityMonitor;
import id.dana.core.ui.util.connectivity.ConnectivityMonitorKt;
import id.dana.core.ui.util.connectivity.mapper.ConnectivityModelMapperKt;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.FragmentVerifyReferralCodeBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerReferralComponent;
import id.dana.di.component.ReferralComponent;
import id.dana.di.modules.ReferralModule;
import id.dana.dialog.CommonDialog;
import id.dana.dialog.CommonDialog$$ExternalSyntheticLambda0;
import id.dana.domain.featureconfig.model.PersonalizedReferralConfig;
import id.dana.extension.view.InputExtKt;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import id.dana.onboarding.createpin.CreatePinKey;
import id.dana.onboarding.referral.ReferralContract;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import id.dana.utils.permission.ManifestPermission;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;
import pl.charmas.android.reactivelocation2.observables.location.LastKnownLocationObservableOnSubscribe;
import pl.charmas.android.reactivelocation2.observables.location.LocationUpdatesObservableOnSubscribe;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 k2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001kB\u0005¢\u0006\u0002\u0010\u0006J\b\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020/2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020/2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020\u0014H\u0002J\b\u00106\u001a\u00020/H\u0016J\b\u00107\u001a\u000208H\u0014J\u0010\u00109\u001a\u00020/2\u0006\u00101\u001a\u000202H\u0002J\b\u0010:\u001a\u00020/H\u0002J\u0010\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u000208H\u0002J\b\u0010=\u001a\u00020/H\u0014J\b\u0010>\u001a\u00020/H\u0002J\b\u0010?\u001a\u00020/H\u0002J\b\u0010@\u001a\u00020/H\u0002J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0014J\b\u0010D\u001a\u00020/H\u0002J\"\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u0002082\u0006\u0010<\u001a\u0002082\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020/H\u0016J\b\u0010M\u001a\u00020/H\u0016J\u0012\u0010N\u001a\u00020/2\b\u0010O\u001a\u0004\u0018\u000102H\u0016J\u0016\u0010P\u001a\u00020/2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0016J\b\u0010T\u001a\u00020/H\u0016J\b\u0010U\u001a\u00020/H\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0002J\b\u0010X\u001a\u00020/H\u0016J\u0012\u0010Y\u001a\u00020/2\b\u0010O\u001a\u0004\u0018\u000102H\u0016J\b\u0010Z\u001a\u00020/H\u0016J\u0010\u0010[\u001a\u00020/2\u0006\u00101\u001a\u000202H\u0002J\b\u0010\\\u001a\u00020/H\u0002J\b\u0010]\u001a\u00020/H\u0002J$\u0010^\u001a\u00020/2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u0002022\n\b\u0002\u0010b\u001a\u0004\u0018\u000102H\u0002J\b\u0010c\u001a\u00020/H\u0016J\"\u0010d\u001a\u00020/2\u0006\u0010b\u001a\u0002022\u0006\u0010a\u001a\u0002022\b\b\u0002\u0010e\u001a\u00020\u0014H\u0002J\b\u0010f\u001a\u00020/H\u0002J\b\u0010g\u001a\u00020/H\u0002J\b\u0010h\u001a\u00020/H\u0002J\u001a\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020\u00142\b\u0010O\u001a\u0004\u0018\u000102H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006l"}, d2 = {"Lid/dana/onboarding/referral/VerifyReferralCodeFragment;", "Lid/dana/base/KeyBaseFragment;", "Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/onboarding/referral/VerifyReferralCodeKey;", "Lid/dana/databinding/FragmentVerifyReferralCodeBinding;", "Lid/dana/onboarding/referral/ReferralContract$View;", "()V", "connectivityMonitor", "Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "getConnectivityMonitor", "()Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "connectivityMonitor$delegate", "Lkotlin/Lazy;", "getLocationDisposable", "Lio/reactivex/disposables/Disposable;", "gpsPermission", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "gpsServiceRequestDisposable", "inputBoxListenerDisposable", "isFirstTimeInputReferral", "", "isFirstTimeTextChanged", "isNetworkAvailable", "loadingDialog", "Lid/dana/dialog/CommonDialog;", "locationPermissionDialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "locationPermissionSubject", "Lid/dana/toggle/locationpermission/LocationPermissionSubject;", "getLocationPermissionSubject", "()Lid/dana/toggle/locationpermission/LocationPermissionSubject;", "setLocationPermissionSubject", "(Lid/dana/toggle/locationpermission/LocationPermissionSubject;)V", "measureLoadAndRenderingScreen", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "onboardingNavigationManager", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "referralComponent", "Lid/dana/di/component/ReferralComponent;", "verifyReferralCodePresenter", "Lid/dana/onboarding/referral/ReferralContract$Presenter;", "getVerifyReferralCodePresenter$annotations", "getVerifyReferralCodePresenter", "()Lid/dana/onboarding/referral/ReferralContract$Presenter;", "setVerifyReferralCodePresenter", "(Lid/dana/onboarding/referral/ReferralContract$Presenter;)V", "callLocationPermissionSubject", "", "checkLocationPermissionAndSendReferralCode", "referralCode", "", "checkLocationService", "disableButtonClick", "enable", "dismissProgress", "getLayout", "", "getUserCurrentLocationAndSendReferralCode", "handleOnGPSPermissionResult", "handleOnGPSServiceResult", "resultCode", IAPSyncCommand.COMMAND_INIT, "initInjector", "initListener", "initLoading", "initViewBinding", "view", "Landroid/view/View;", "initializePermissionDialog", "onActivityResult", RequestPermission.REQUEST_CODE, "data", "Landroid/content/Intent;", "onAttach", HummerConstants.CONTEXT, "Landroid/content/Context;", "onCityRequiredError", "onDestroy", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "errorMessage", "onGetPersonalizedReferral", "content", "", "Lid/dana/domain/featureconfig/model/PersonalizedReferralConfig;", "onMockGpsDetected", "onPause", "onResume", "onSkip", "onStart", "onVerifyReferralCodeFail", "onVerifyReferralCodeSuccess", "proceedToCreatePinPage", "requestGPSService", "setupKeyboardListener", "showMessageDialog", "status", "Lid/dana/core/ui/constant/DialogType;", "message", "title", "showProgress", "showReferralMessageDialog", "isSingleButton", "startUserInteractionInputReferralTimerTracker", "stopUserIdleTimerTracker", "stopUserInteractionInputReferralTimerTracker", "trackReferralVerification", TrackerKey.Property.IS_SUCCESS, "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyReferralCodeFragment extends KeyBaseFragment<OnboardingActivity, VerifyReferralCodeKey, FragmentVerifyReferralCodeBinding> implements ReferralContract.View {
    public static final Companion PlaceComponentResult = new Companion(null);
    private CommonDialog DatabaseTableConfigUtil;
    private MaterialDialog GetContactSyncConfig;
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private OnboardingNavigationManagerWithMenu NetworkUserEntityData$$ExternalSyntheticLambda7;
    private ReferralComponent PrepareContext;
    private Disposable getErrorConfigVersion;
    @Inject
    public LocationPermissionSubject locationPermissionSubject;
    private Disposable moveToNextValue;
    private final FragmentPermissionRequest scheduleImpl;
    @Inject
    public ReferralContract.Presenter verifyReferralCodePresenter;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<ConnectivityMonitor>() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$connectivityMonitor$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivityMonitor invoke() {
            BaseActivity baseActivity = VerifyReferralCodeFragment.this.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            return new ConnectivityMonitor(baseActivity);
        }
    });
    private final MeasureLoadAndRenderingScreen isLayoutRequested = new MeasureLoadAndRenderingScreen();
    private boolean initRecordTimeStamp = true;

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
        return R.layout.fragment_verify_referral_code;
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
    }

    public VerifyReferralCodeFragment() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$gpsPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    VerifyReferralCodeFragment.lookAheadTest(VerifyReferralCodeFragment.this);
                    return;
                }
                VerifyReferralCodeFragment.this.dismissProgress();
                VerifyReferralCodeFragment verifyReferralCodeFragment = VerifyReferralCodeFragment.this;
                DialogType dialogType = DialogType.WARNING;
                String string = VerifyReferralCodeFragment.this.getString(R.string.referral_invalid_code);
                Intrinsics.checkNotNullExpressionValue(string, "");
                verifyReferralCodeFragment.MyBillsEntityDataFactory(dialogType, string, (String) null);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.scheduleImpl = builder.PlaceComponentResult();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
    }

    public static final /* synthetic */ FragmentVerifyReferralCodeBinding MyBillsEntityDataFactory(VerifyReferralCodeFragment verifyReferralCodeFragment) {
        return (FragmentVerifyReferralCodeBinding) verifyReferralCodeFragment.getBinding();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentVerifyReferralCodeBinding BuiltInFictitiousFunctionClassFactory = FragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "");
        super.onAttach(r3);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.isLayoutRequested;
        Intrinsics.checkNotNullParameter("referral_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("referral_screen_render");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r2, int resultCode, Intent data) {
        AppCompatEditText appCompatEditText;
        Editable text;
        super.onActivityResult(r2, resultCode, data);
        if (r2 == 100) {
            String str = null;
            if (resultCode == -1) {
                FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) getBinding();
                if (fragmentVerifyReferralCodeBinding != null && (appCompatEditText = fragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory) != null && (text = appCompatEditText.getText()) != null) {
                    str = text.toString();
                }
                PlaceComponentResult(str != null ? str : "");
                return;
            }
            dismissProgress();
            DialogType dialogType = DialogType.WARNING;
            String string = getString(R.string.referral_invalid_code);
            Intrinsics.checkNotNullExpressionValue(string, "");
            MyBillsEntityDataFactory(dialogType, string, (String) null);
        }
    }

    private final void MyBillsEntityDataFactory(final String str) {
        showProgress();
        LocationUtil.LocationRequestBuilder locationRequestBuilder = new LocationUtil.LocationRequestBuilder((Application) getBaseActivity().getDanaApplication());
        ReactiveLocationProvider reactiveLocationProvider = locationRequestBuilder.BuiltInFictitiousFunctionClassFactory;
        Observable<Location> MyBillsEntityDataFactory = LastKnownLocationObservableOnSubscribe.MyBillsEntityDataFactory(reactiveLocationProvider.MyBillsEntityDataFactory, reactiveLocationProvider.KClassImpl$Data$declaredNonStaticMembers$2);
        ReactiveLocationProvider reactiveLocationProvider2 = locationRequestBuilder.BuiltInFictitiousFunctionClassFactory;
        Disposable subscribe = MyBillsEntityDataFactory.switchIfEmpty(LocationUpdatesObservableOnSubscribe.BuiltInFictitiousFunctionClassFactory(reactiveLocationProvider2.MyBillsEntityDataFactory, reactiveLocationProvider2.KClassImpl$Data$declaredNonStaticMembers$2, LocationUtil.LocationRequestBuilder.PlaceComponentResult())).subscribe(new Consumer() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerifyReferralCodeFragment.MyBillsEntityDataFactory(VerifyReferralCodeFragment.this, str, (Location) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.moveToNextValue = subscribe;
    }

    private final void PlaceComponentResult() {
        LocationUtil.LocationRequestBuilder locationRequestBuilder = new LocationUtil.LocationRequestBuilder((Application) getBaseActivity().getDanaApplication());
        locationRequestBuilder.MyBillsEntityDataFactory.setAlwaysShow(true);
        locationRequestBuilder.MyBillsEntityDataFactory.addLocationRequest(LocationUtil.LocationRequestBuilder.PlaceComponentResult());
        Disposable subscribe = locationRequestBuilder.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(locationRequestBuilder.MyBillsEntityDataFactory.build()).subscribe(new Consumer() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerifyReferralCodeFragment.BuiltInFictitiousFunctionClassFactory(VerifyReferralCodeFragment.this, (LocationSettingsResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = subscribe;
    }

    private final void PlaceComponentResult(String str) {
        if (getContext() != null) {
            if (!LocationUtil.BuiltInFictitiousFunctionClassFactory(getContext())) {
                MaterialDialog materialDialog = this.GetContactSyncConfig;
                if (materialDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    materialDialog = null;
                }
                materialDialog.show();
            } else if (LocationUtil.getAuthRequestContext(getContext())) {
                MyBillsEntityDataFactory(str);
            } else {
                PlaceComponentResult();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        Disposable disposable = this.getErrorConfigVersion;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("phoneNumber") : null;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (onboardingNavigationManagerWithMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingNavigationManagerWithMenu = null;
        }
        String str = string == null ? "" : string;
        String prependZeroToPhoneNumber = NumberUtils.prependZeroToPhoneNumber(string);
        Intrinsics.checkNotNullExpressionValue(prependZeroToPhoneNumber, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(prependZeroToPhoneNumber, "");
        CreatePinKey.Companion companion = CreatePinKey.INSTANCE;
        CreatePinKey BuiltInFictitiousFunctionClassFactory = CreatePinKey.Companion.BuiltInFictitiousFunctionClassFactory(str, prependZeroToPhoneNumber, null, null);
        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
        onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.onboarding.referral.ReferralContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        AppCompatEditText appCompatEditText;
        dismissProgress();
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) getBinding();
        String valueOf = String.valueOf((fragmentVerifyReferralCodeBinding == null || (appCompatEditText = fragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory) == null) ? null : appCompatEditText.getText());
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("phoneNumber") : null;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (onboardingNavigationManagerWithMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingNavigationManagerWithMenu = null;
        }
        String str = string == null ? "" : string;
        String prependZeroToPhoneNumber = NumberUtils.prependZeroToPhoneNumber(string);
        Intrinsics.checkNotNullExpressionValue(prependZeroToPhoneNumber, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(prependZeroToPhoneNumber, "");
        CreatePinKey.Companion companion = CreatePinKey.INSTANCE;
        CreatePinKey BuiltInFictitiousFunctionClassFactory = CreatePinKey.Companion.BuiltInFictitiousFunctionClassFactory(str, prependZeroToPhoneNumber, null, valueOf);
        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
        onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(BuiltInFictitiousFunctionClassFactory);
        DialogType dialogType = DialogType.SUCCESS;
        String string2 = getString(R.string.referral_valid_code_message);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        MyBillsEntityDataFactory(dialogType, string2, getString(R.string.referral_valid_code));
    }

    @Override // id.dana.onboarding.referral.ReferralContract.View
    public final void BuiltInFictitiousFunctionClassFactory(boolean z, String str) {
        AppCompatEditText appCompatEditText;
        Editable text;
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) getBinding();
        String obj = (fragmentVerifyReferralCodeBinding == null || (appCompatEditText = fragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory) == null || (text = appCompatEditText.getText()) == null) ? null : text.toString();
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.REGISTRATION_REFERRAL_INPUT;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Referral Code", obj).BuiltInFictitiousFunctionClassFactory("Success", z).MyBillsEntityDataFactory("Failed Reason", str);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public final void MyBillsEntityDataFactory(DialogType dialogType, String str, String str2) {
        CommonDialog.Builder builder = new CommonDialog.Builder(getContext());
        builder.PlaceComponentResult = true;
        builder.DatabaseTableConfigUtil = dialogType;
        builder.GetContactSyncConfig = str2;
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        new CommonDialog(builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder.scheduleImpl, builder).MyBillsEntityDataFactory();
    }

    private final void PlaceComponentResult(String str, String str2, boolean z) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(requireContext);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning;
        builder.SubSequence = str;
        builder.GetContactSyncConfig = str2;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(getString(R.string.referral_got_it), new Function1<View, Unit>() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$showReferralMessageDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    VerifyReferralCodeFragment.this.BuiltInFictitiousFunctionClassFactory();
                }
            });
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(getString(R.string.try_again), new VerifyReferralCodeFragment$showReferralMessageDialog$2(this));
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(getString(R.string.later), new Function1<View, Unit>() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$showReferralMessageDialog$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    VerifyReferralCodeFragment.this.BuiltInFictitiousFunctionClassFactory();
                }
            });
        }
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().show();
    }

    @Override // id.dana.onboarding.referral.ReferralContract.View
    public final void getAuthRequestContext(String str) {
        dismissProgress();
        if (Intrinsics.areEqual(str, "Too Much Attempt")) {
            String string = getString(R.string.referral_too_much_attempt);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = getString(R.string.referral_too_much_attempt_message);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            PlaceComponentResult(string, string2, true);
            FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) getBinding();
            DanaButtonSecondaryView danaButtonSecondaryView = fragmentVerifyReferralCodeBinding != null ? fragmentVerifyReferralCodeBinding.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (danaButtonSecondaryView != null) {
                danaButtonSecondaryView.setEnabled(false);
            }
            Disposable disposable = this.getErrorConfigVersion;
            if (disposable != null) {
                disposable.dispose();
            }
        } else if (Intrinsics.areEqual(str, "System Busy")) {
            String string3 = getString(R.string.referral_something_went_wrong_title);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            String string4 = getString(R.string.referral_something_went_wrong_message);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            PlaceComponentResult(string3, string4, false);
        } else {
            String string5 = getString(R.string.referral_invalid_code);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            String string6 = getString(R.string.referral_invalid_code_message);
            Intrinsics.checkNotNullExpressionValue(string6, "");
            PlaceComponentResult(string5, string6, false);
        }
    }

    @Override // id.dana.onboarding.referral.ReferralContract.View
    public final void MyBillsEntityDataFactory() {
        AppCompatEditText appCompatEditText;
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) getBinding();
        PlaceComponentResult(String.valueOf((fragmentVerifyReferralCodeBinding == null || (appCompatEditText = fragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory) == null) ? null : appCompatEditText.getText()));
    }

    @Override // id.dana.onboarding.referral.ReferralContract.View
    public final void getAuthRequestContext() {
        AppCompatEditText appCompatEditText;
        dismissProgress();
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) getBinding();
        if (fragmentVerifyReferralCodeBinding != null && (appCompatEditText = fragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory) != null) {
            appCompatEditText.setText("");
        }
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (onboardingNavigationManagerWithMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingNavigationManagerWithMenu = null;
        }
        VerifyReferralCodeErrorKey verifyReferralCodeErrorKey = new VerifyReferralCodeErrorKey();
        Intrinsics.checkNotNullParameter(verifyReferralCodeErrorKey, "");
        onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(verifyReferralCodeErrorKey);
    }

    @Override // id.dana.onboarding.referral.ReferralContract.View
    public final void MyBillsEntityDataFactory(List<PersonalizedReferralConfig> list) {
        Intrinsics.checkNotNullParameter(list, "");
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), "en")) {
            for (PersonalizedReferralConfig personalizedReferralConfig : list) {
                if (Intrinsics.areEqual(personalizedReferralConfig.getContentLanguage(), "en")) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        for (PersonalizedReferralConfig personalizedReferralConfig2 : list) {
            if ((!Intrinsics.areEqual(personalizedReferralConfig2.getContentLanguage(), "en")) != false) {
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) getBinding();
        AppCompatTextView appCompatTextView = fragmentVerifyReferralCodeBinding != null ? fragmentVerifyReferralCodeBinding.moveToNextValue : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(personalizedReferralConfig2.getTitle());
        }
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding2 = (FragmentVerifyReferralCodeBinding) getBinding();
        AppCompatTextView appCompatTextView2 = fragmentVerifyReferralCodeBinding2 != null ? fragmentVerifyReferralCodeBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(personalizedReferralConfig2.getBodyMessage());
        }
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding3 = (FragmentVerifyReferralCodeBinding) getBinding();
        AppCompatTextView appCompatTextView3 = fragmentVerifyReferralCodeBinding3 != null ? fragmentVerifyReferralCodeBinding3.getAuthRequestContext : null;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(personalizedReferralConfig2.getInfo());
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        KeyboardHelper.MyBillsEntityDataFactory(getBaseActivity());
        CommonDialog commonDialog = this.DatabaseTableConfigUtil;
        if (commonDialog != null) {
            commonDialog.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        CommonDialog commonDialog = this.DatabaseTableConfigUtil;
        if (commonDialog != null) {
            new Handler().postDelayed(new CommonDialog$$ExternalSyntheticLambda0(commonDialog), 500L);
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ConnectivityMonitorKt.MyBillsEntityDataFactory((ConnectivityMonitor) this.lookAheadTest.getValue(), 1000L).PlaceComponentResult(this, new Observer() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$$ExternalSyntheticLambda4
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                VerifyReferralCodeFragment.getAuthRequestContext(VerifyReferralCodeFragment.this, (ConnectivityModel) obj);
            }
        });
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        ((ConnectivityMonitor) this.lookAheadTest.getValue()).PlaceComponentResult((LifecycleOwner) this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("idle_registration_referral_screen");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/onboarding/referral/VerifyReferralCodeFragment$Companion;", "", "", "p0", "p1", "Lid/dana/onboarding/referral/VerifyReferralCodeFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/onboarding/referral/VerifyReferralCodeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static VerifyReferralCodeFragment KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
            Bundle bundle = new Bundle();
            bundle.putString("phoneNumber", p0);
            bundle.putString("referralName", p1);
            VerifyReferralCodeFragment verifyReferralCodeFragment = new VerifyReferralCodeFragment();
            verifyReferralCodeFragment.setArguments(bundle);
            return verifyReferralCodeFragment;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyReferralCodeFragment verifyReferralCodeFragment, LocationSettingsResult locationSettingsResult) {
        PendingIntent resolution;
        PendingIntent resolution2;
        Intrinsics.checkNotNullParameter(verifyReferralCodeFragment, "");
        Intrinsics.checkNotNullParameter(locationSettingsResult, "");
        Disposable disposable = null;
        if (locationSettingsResult.getStatus().getStatusCode() == 6) {
            Status status = locationSettingsResult.getStatus();
            if (((status == null || (resolution2 = status.getResolution()) == null) ? null : resolution2.getIntentSender()) != null) {
                VerifyReferralCodeFragment verifyReferralCodeFragment2 = verifyReferralCodeFragment;
                Status status2 = locationSettingsResult.getStatus();
                verifyReferralCodeFragment2.startIntentSenderForResult((status2 == null || (resolution = status2.getResolution()) == null) ? null : resolution.getIntentSender(), 100, null, 0, 0, 0, null);
            }
        }
        Disposable disposable2 = verifyReferralCodeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (disposable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            disposable = disposable2;
        }
        disposable.dispose();
    }

    public static /* synthetic */ void getAuthRequestContext(VerifyReferralCodeFragment verifyReferralCodeFragment, ConnectivityModel connectivityModel) {
        Intrinsics.checkNotNullParameter(verifyReferralCodeFragment, "");
        Intrinsics.checkNotNullExpressionValue(connectivityModel, "");
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = ConnectivityModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(connectivityModel);
        verifyReferralCodeFragment.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2;
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) verifyReferralCodeFragment.getBinding();
        AppCompatButton appCompatButton = fragmentVerifyReferralCodeBinding != null ? fragmentVerifyReferralCodeBinding.PlaceComponentResult : null;
        if (appCompatButton != null) {
            appCompatButton.setEnabled(KClassImpl$Data$declaredNonStaticMembers$2);
        }
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding2 = (FragmentVerifyReferralCodeBinding) verifyReferralCodeFragment.getBinding();
        AppCompatButton appCompatButton2 = fragmentVerifyReferralCodeBinding2 != null ? fragmentVerifyReferralCodeBinding2.PlaceComponentResult : null;
        if (appCompatButton2 != null) {
            appCompatButton2.setAlpha(KClassImpl$Data$declaredNonStaticMembers$2 ? 1.0f : 0.4f);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyReferralCodeFragment verifyReferralCodeFragment) {
        AppCompatEditText appCompatEditText;
        Intrinsics.checkNotNullParameter(verifyReferralCodeFragment, "");
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) verifyReferralCodeFragment.getBinding();
        if (fragmentVerifyReferralCodeBinding == null || (appCompatEditText = fragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        InputExtKt.PlaceComponentResult(appCompatEditText);
    }

    public static /* synthetic */ void getAuthRequestContext(VerifyReferralCodeFragment verifyReferralCodeFragment) {
        AppCompatEditText appCompatEditText;
        Editable text;
        Intrinsics.checkNotNullParameter(verifyReferralCodeFragment, "");
        verifyReferralCodeFragment.showProgress();
        ReferralContract.Presenter presenter = verifyReferralCodeFragment.verifyReferralCodePresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) verifyReferralCodeFragment.getBinding();
        presenter.getAuthRequestContext((fragmentVerifyReferralCodeBinding == null || (appCompatEditText = fragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory) == null || (text = appCompatEditText.getText()) == null) ? null : text.toString());
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("user_interaction_registration_voucher_code_input", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "user_interaction_registration_voucher_code_input");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VerifyReferralCodeFragment verifyReferralCodeFragment) {
        Intrinsics.checkNotNullParameter(verifyReferralCodeFragment, "");
        if (verifyReferralCodeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
            Intrinsics.checkNotNullParameter("idle_registration_referral_screen", "");
            OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "idle_registration_referral_screen");
            verifyReferralCodeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        }
        OnboardingFirebaseTracker onboardingFirebaseTracker2 = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("user_interaction_registration_voucher_code_input", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "user_interaction_registration_voucher_code_input");
        verifyReferralCodeFragment.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(VerifyReferralCodeFragment verifyReferralCodeFragment, String str, Location location) {
        Intrinsics.checkNotNullParameter(verifyReferralCodeFragment, "");
        Intrinsics.checkNotNullParameter(str, "");
        ReferralContract.Presenter presenter = verifyReferralCodeFragment.verifyReferralCodePresenter;
        Disposable disposable = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        Intrinsics.checkNotNullExpressionValue(location, "");
        presenter.KClassImpl$Data$declaredNonStaticMembers$2(str, location);
        Disposable disposable2 = verifyReferralCodeFragment.moveToNextValue;
        if (disposable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            disposable = disposable2;
        }
        disposable.dispose();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyReferralCodeFragment verifyReferralCodeFragment, CharSequence charSequence) {
        DanaButtonSecondaryView danaButtonSecondaryView;
        Intrinsics.checkNotNullParameter(verifyReferralCodeFragment, "");
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) verifyReferralCodeFragment.getBinding();
        if (fragmentVerifyReferralCodeBinding == null || (danaButtonSecondaryView = fragmentVerifyReferralCodeBinding.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        danaButtonSecondaryView.setEnabled(charSequence.length() == 6 && verifyReferralCodeFragment.initRecordTimeStamp);
        if (danaButtonSecondaryView.isEnabled()) {
            danaButtonSecondaryView.setActiveButton(verifyReferralCodeFragment.getString(R.string.btn_check_code), null);
        } else {
            danaButtonSecondaryView.setDisabled(verifyReferralCodeFragment.getString(R.string.btn_check_code));
        }
    }

    public static final /* synthetic */ void lookAheadTest(VerifyReferralCodeFragment verifyReferralCodeFragment) {
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        Editable text;
        FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) verifyReferralCodeFragment.getBinding();
        boolean z = false;
        if (fragmentVerifyReferralCodeBinding != null && (appCompatEditText2 = fragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory) != null && (text = appCompatEditText2.getText()) != null) {
            if (text.length() > 0) {
                z = true;
            }
        }
        if (z) {
            FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding2 = (FragmentVerifyReferralCodeBinding) verifyReferralCodeFragment.getBinding();
            String valueOf = String.valueOf((fragmentVerifyReferralCodeBinding2 == null || (appCompatEditText = fragmentVerifyReferralCodeBinding2.BuiltInFictitiousFunctionClassFactory) == null) ? null : appCompatEditText.getText());
            if (LocationUtil.getAuthRequestContext(verifyReferralCodeFragment.getContext())) {
                verifyReferralCodeFragment.MyBillsEntityDataFactory(valueOf);
            } else {
                verifyReferralCodeFragment.PlaceComponentResult();
            }
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(VerifyReferralCodeFragment verifyReferralCodeFragment) {
        if (verifyReferralCodeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
            OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("user_interaction_registration_voucher_code_input");
            verifyReferralCodeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        }
    }

    public static final /* synthetic */ void getErrorConfigVersion(VerifyReferralCodeFragment verifyReferralCodeFragment) {
        if (verifyReferralCodeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
            Intrinsics.checkNotNullParameter("idle_registration_referral_screen", "");
            OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "idle_registration_referral_screen");
            verifyReferralCodeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        AppCompatButton appCompatButton;
        DanaButtonSecondaryView danaButtonSecondaryView;
        AppCompatEditText appCompatEditText3;
        if (this.PrepareContext == null) {
            DaggerReferralComponent.Builder authRequestContext = DaggerReferralComponent.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            authRequestContext.PlaceComponentResult = (ReferralModule) Preconditions.getAuthRequestContext(new ReferralModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PlaceComponentResult, ReferralModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
            DaggerReferralComponent.ReferralComponentImpl referralComponentImpl = new DaggerReferralComponent.ReferralComponentImpl(authRequestContext.PlaceComponentResult, authRequestContext.MyBillsEntityDataFactory, r1 ? (byte) 1 : (byte) 0);
            Intrinsics.checkNotNullExpressionValue(referralComponentImpl, "");
            this.PrepareContext = referralComponentImpl;
        }
        ReferralComponent referralComponent = this.PrepareContext;
        ReferralContract.Presenter presenter = null;
        if (referralComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            referralComponent = null;
        }
        referralComponent.MyBillsEntityDataFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        ReferralContract.Presenter presenter2 = this.verifyReferralCodePresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        abstractPresenterArr[0] = presenter2;
        registerPresenter(abstractPresenterArr);
        CommonDialog.Builder builder = new CommonDialog.Builder(getContext());
        builder.PlaceComponentResult = false;
        builder.DatabaseTableConfigUtil = DialogType.WAITING;
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = getString(R.string.checking);
        CommonDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        this.DatabaseTableConfigUtil = new CommonDialog(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$2);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager();
            Disposable disposable = this.getErrorConfigVersion;
            if (disposable != null) {
                disposable.dispose();
            }
            FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding = (FragmentVerifyReferralCodeBinding) getBinding();
            this.getErrorConfigVersion = (fragmentVerifyReferralCodeBinding == null || (appCompatEditText3 = fragmentVerifyReferralCodeBinding.BuiltInFictitiousFunctionClassFactory) == null) ? null : RxTextView.textChanges(appCompatEditText3).debounce(300L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VerifyReferralCodeFragment.BuiltInFictitiousFunctionClassFactory(VerifyReferralCodeFragment.this, (CharSequence) obj);
                }
            });
            FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding2 = (FragmentVerifyReferralCodeBinding) getBinding();
            if (fragmentVerifyReferralCodeBinding2 != null && (danaButtonSecondaryView = fragmentVerifyReferralCodeBinding2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VerifyReferralCodeFragment.getAuthRequestContext(VerifyReferralCodeFragment.this);
                    }
                });
            }
            FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding3 = (FragmentVerifyReferralCodeBinding) getBinding();
            if (fragmentVerifyReferralCodeBinding3 != null && (appCompatButton = fragmentVerifyReferralCodeBinding3.PlaceComponentResult) != null) {
                appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VerifyReferralCodeFragment.KClassImpl$Data$declaredNonStaticMembers$2(VerifyReferralCodeFragment.this);
                    }
                });
            }
            FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding4 = (FragmentVerifyReferralCodeBinding) getBinding();
            if (fragmentVerifyReferralCodeBinding4 != null && (appCompatEditText2 = fragmentVerifyReferralCodeBinding4.BuiltInFictitiousFunctionClassFactory) != null) {
                appCompatEditText2.addTextChangedListener(new TextWatcher() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$initListener$$inlined$addTextChangedListener$default$1
                    @Override // android.text.TextWatcher
                    public final void afterTextChanged(Editable p0) {
                    }

                    @Override // android.text.TextWatcher
                    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    }

                    @Override // android.text.TextWatcher
                    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                        VerifyReferralCodeFragment.getErrorConfigVersion(VerifyReferralCodeFragment.this);
                        VerifyReferralCodeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(VerifyReferralCodeFragment.this);
                    }
                });
            }
            FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding5 = (FragmentVerifyReferralCodeBinding) getBinding();
            KeyboardHelper.PlaceComponentResult(fragmentVerifyReferralCodeBinding5 != null ? fragmentVerifyReferralCodeBinding5.lookAheadTest : null, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$setupKeyboardListener$1
                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void MyBillsEntityDataFactory() {
                }

                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    ScrollView scrollView;
                    FragmentVerifyReferralCodeBinding MyBillsEntityDataFactory = VerifyReferralCodeFragment.MyBillsEntityDataFactory(VerifyReferralCodeFragment.this);
                    if (MyBillsEntityDataFactory == null || (scrollView = MyBillsEntityDataFactory.lookAheadTest) == null) {
                        return;
                    }
                    View requireView = VerifyReferralCodeFragment.this.requireView();
                    Intrinsics.checkNotNullExpressionValue(requireView, "");
                    scrollView.smoothScrollTo(0, KeyboardHelper.getAuthRequestContext(requireView) / 3);
                }
            });
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            CustomDialog.Builder builder2 = new CustomDialog.Builder(requireContext);
            builder2.SubSequence = getString(R.string.referral_location_permission_dialog_title);
            builder2.GetContactSyncConfig = getString(R.string.referral_location_permission_dialog_description);
            builder2.DatabaseTableConfigUtil = R.drawable.ic_location_permission_icon;
            builder2.moveToNextValue = 0L;
            builder2.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
            this.GetContactSyncConfig = builder2.BuiltInFictitiousFunctionClassFactory(getString(R.string.referral_location_permission_dialog_allow), new Function1<View, Unit>() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$initializePermissionDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    FragmentPermissionRequest fragmentPermissionRequest;
                    Intrinsics.checkNotNullParameter(view, "");
                    fragmentPermissionRequest = VerifyReferralCodeFragment.this.scheduleImpl;
                    fragmentPermissionRequest.check();
                }
            }).KClassImpl$Data$declaredNonStaticMembers$2(getString(R.string.referral_location_permission_dialog_cancel), new Function1<View, Unit>() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$initializePermissionDialog$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    VerifyReferralCodeFragment.this.dismissProgress();
                    VerifyReferralCodeFragment verifyReferralCodeFragment = VerifyReferralCodeFragment.this;
                    DialogType dialogType = DialogType.WARNING;
                    String string = VerifyReferralCodeFragment.this.getString(R.string.referral_invalid_code);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    verifyReferralCodeFragment.MyBillsEntityDataFactory(dialogType, string, (String) null);
                }
            }).BuiltInFictitiousFunctionClassFactory();
            Context context = getContext();
            if (context != null) {
                LocationPermissionSubject locationPermissionSubject = this.locationPermissionSubject;
                if (locationPermissionSubject == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    locationPermissionSubject = null;
                }
                locationPermissionSubject.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.valueOf(ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, "android.permission.ACCESS_FINE_LOCATION") == 0));
            }
            ReferralContract.Presenter presenter3 = this.verifyReferralCodePresenter;
            if (presenter3 != null) {
                presenter = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter.KClassImpl$Data$declaredNonStaticMembers$2();
            getBaseActivity().clearMenuLeftButtonIcon();
            FragmentVerifyReferralCodeBinding fragmentVerifyReferralCodeBinding6 = (FragmentVerifyReferralCodeBinding) getBinding();
            if (fragmentVerifyReferralCodeBinding6 != null && (appCompatEditText = fragmentVerifyReferralCodeBinding6.BuiltInFictitiousFunctionClassFactory) != null) {
                appCompatEditText.postDelayed(new Runnable() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        VerifyReferralCodeFragment.BuiltInFictitiousFunctionClassFactory(VerifyReferralCodeFragment.this);
                    }
                }, 500L);
            }
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.isLayoutRequested;
                Intrinsics.checkNotNullParameter(getAuthRequestContext, "");
                FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
                FirstDrawListener.Companion.MyBillsEntityDataFactory(getAuthRequestContext, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }
}
