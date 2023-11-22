package id.dana.onboarding.welcome;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.firebase.perf.FirebasePerformance;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContract;
import id.dana.base.KeyBaseFragment;
import id.dana.databinding.FragmentWelcomeBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerWelcomeComponent;
import id.dana.di.modules.WelcomeModule;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.onboarding.welcome.WelcomeContract;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000fX\u0087\"¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/onboarding/welcome/WelcomeFragment;", "Lid/dana/base/KeyBaseFragment;", "Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/onboarding/welcome/WelcomeKey;", "Lid/dana/databinding/FragmentWelcomeBinding;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "MyBillsEntityDataFactory", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/onboarding/welcome/WelcomeContract$Presenter;", "presenter", "Lid/dana/onboarding/welcome/WelcomeContract$Presenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WelcomeFragment extends KeyBaseFragment<OnboardingActivity, WelcomeKey, FragmentWelcomeBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MeasureLoadAndRenderingScreen KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    @Inject
    public WelcomeContract.Presenter presenter;

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
        return R.layout.fragment_welcome;
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public WelcomeFragment() {
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = new MeasureLoadAndRenderingScreen();
        Intrinsics.checkNotNullParameter("register_welcome_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("register_welcome_screen_render");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = measureLoadAndRenderingScreen;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentWelcomeBinding authRequestContext = FragmentWelcomeBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/onboarding/welcome/WelcomeFragment$Companion;", "", "Lid/dana/onboarding/welcome/WelcomeFragment;", "MyBillsEntityDataFactory", "()Lid/dana/onboarding/welcome/WelcomeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static WelcomeFragment MyBillsEntityDataFactory() {
            return new WelcomeFragment();
        }
    }

    public static /* synthetic */ void getAuthRequestContext(WelcomeFragment welcomeFragment) {
        Intrinsics.checkNotNullParameter(welcomeFragment, "");
        Intent intent = new Intent(welcomeFragment.getBaseActivity(), HomeTabActivity.class);
        intent.putExtra(HomeTabActivity.NEW_REGISTERED_USER, true);
        welcomeFragment.startActivity(intent);
        FragmentActivity activity = welcomeFragment.getActivity();
        if (activity != null) {
            activity.overridePendingTransition(R.anim.MyBillsEntityDataFactory_res_0x7f010057, R.anim.PlaceComponentResult_res_0x7f01005d);
        }
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter(TrackerKey.Event.APP_TOTAL_LOGIN_TIME, "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, TrackerKey.Event.APP_TOTAL_LOGIN_TIME);
        FragmentActivity activity2 = welcomeFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DaggerWelcomeComponent.Builder PlaceComponentResult = DaggerWelcomeComponent.PlaceComponentResult();
        PlaceComponentResult.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (WelcomeModule) Preconditions.getAuthRequestContext(new WelcomeModule());
        if (PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = new WelcomeModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, ApplicationComponent.class);
        new DaggerWelcomeComponent.WelcomeComponentImpl(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.getAuthRequestContext, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        WelcomeContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        registerPresenter(abstractPresenterArr);
        WelcomeContract.Presenter presenter2 = this.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        presenter2.PlaceComponentResult();
        ((Toolbar) getBaseActivity().findViewById(R.id.setDefaultTab)).setVisibility(8);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.onboarding.welcome.WelcomeFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WelcomeFragment.getAuthRequestContext(WelcomeFragment.this);
            }
        }, 1000L);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "");
        Intrinsics.checkNotNullParameter(requireView, "");
        FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
        FirstDrawListener.Companion.MyBillsEntityDataFactory(requireView, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter(TrackerKey.Event.APP_TOTAL_REGISTRATION_TIME, "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, TrackerKey.Event.APP_TOTAL_REGISTRATION_TIME);
    }
}
