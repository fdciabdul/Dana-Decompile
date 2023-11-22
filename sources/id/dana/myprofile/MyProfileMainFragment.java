package id.dana.myprofile;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.view.result.ActivityResultCaller;
import androidx.viewpager2.widget.ViewPager2;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.databinding.FragmentMyprofileMainBinding;
import id.dana.kyb.model.KybPageInfo;
import id.dana.kyb.view.MyBusinessFragment;
import id.dana.myprofile.NewMyProfileFragment;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher;
import id.dana.social.adapter.BaseTabFragmentAdapter;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b \u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\rR\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0013\u0010\u0014\u001a\u00020\u001aX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001b\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/myprofile/MyProfileMainFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentMyprofileMainBinding;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onDestroy", "", "p0", "onHiddenChanged", "(Z)V", "MyBillsEntityDataFactory", "(I)V", "getAuthRequestContext", "moveToNextValue", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "getErrorConfigVersion", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/model/KybPageInfo;", "lookAheadTest", "Lid/dana/kyb/model/KybPageInfo;", "PlaceComponentResult", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "scheduleImpl", "Lkotlin/Lazy;", "Lid/dana/social/adapter/BaseTabFragmentAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/adapter/BaseTabFragmentAdapter;", "<init>", "Companion", "SettingsListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyProfileMainFragment extends ViewBindingFragment<FragmentMyprofileMainBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private BaseTabFragmentAdapter scheduleImpl;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean getAuthRequestContext = true;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private KybPageInfo PlaceComponentResult = new KybPageInfo(false, false, null, false, 15, null);

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<EnrollPasskeyLauncher>() { // from class: id.dana.myprofile.MyProfileMainFragment$passkeyEnrollmentLauncher$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EnrollPasskeyLauncher invoke() {
            return EnrollPasskeyLauncher.Builder.BuiltInFictitiousFunctionClassFactory(new EnrollPasskeyLauncher.Builder(MyProfileMainFragment.this), true, false, null, null, 14).KClassImpl$Data$declaredNonStaticMembers$2();
        }
    });

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/MyProfileMainFragment$SettingsListener;", "", "Lkotlin/Function0;", "", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface SettingsListener {
        void PlaceComponentResult(Function0<Unit> p0);
    }

    @JvmStatic
    public static final Bundle getAuthRequestContext(boolean z, boolean z2, KybPageInfo kybPageInfo) {
        return Companion.BuiltInFictitiousFunctionClassFactory(z, z2, kybPageInfo);
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
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
        return R.layout.fragment_myprofile_main;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ FragmentMyprofileMainBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentMyprofileMainBinding BuiltInFictitiousFunctionClassFactory = FragmentMyprofileMainBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((EnrollPasskeyLauncher) this.getErrorConfigVersion.getValue());
    }

    public final void getAuthRequestContext(boolean p0) {
        FragmentMyprofileMainBinding binding = getBinding();
        AppCompatImageView appCompatImageView = binding != null ? binding.PlaceComponentResult : null;
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(p0 ? 0 : 8);
        }
    }

    public final void MyBillsEntityDataFactory(int p0) {
        FragmentMyprofileMainBinding binding = getBinding();
        if (binding != null) {
            TabLayout.Tab tabAt = binding.getAuthRequestContext.getTabAt(p0);
            if (tabAt != null) {
                tabAt.select();
            }
            binding.MyBillsEntityDataFactory.setCurrentItem(p0, false);
            RecyclerView.Adapter adapter = binding.MyBillsEntityDataFactory.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/myprofile/MyProfileMainFragment$Companion;", "", "", "p0", "p1", "Lid/dana/kyb/model/KybPageInfo;", "p2", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "(ZZLid/dana/kyb/model/KybPageInfo;)Landroid/os/Bundle;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Bundle BuiltInFictitiousFunctionClassFactory(boolean p0, boolean p1, KybPageInfo p2) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("IS_ME_PAGE_REVAMP", p0);
            bundle.putBoolean("IS_KYB_REVAMP", p1);
            if (p2 != null) {
                bundle.putParcelable("KYB_PAGE_INFO", p2);
            }
            return bundle;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(MyProfileMainFragment myProfileMainFragment, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(myProfileMainFragment, "");
        Intrinsics.checkNotNullParameter(tab, "");
        BaseTabFragmentAdapter baseTabFragmentAdapter = myProfileMainFragment.scheduleImpl;
        BaseTabFragmentAdapter baseTabFragmentAdapter2 = null;
        if (baseTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseTabFragmentAdapter = null;
        }
        tab.setText(baseTabFragmentAdapter.moveToNextValue.get(i));
        BaseTabFragmentAdapter baseTabFragmentAdapter3 = myProfileMainFragment.scheduleImpl;
        if (baseTabFragmentAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            baseTabFragmentAdapter2 = baseTabFragmentAdapter3;
        }
        String str = baseTabFragmentAdapter2.getAuthRequestContext.get(i);
        if (str.length() > 0) {
            tab.setContentDescription(str);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(MyProfileMainFragment myProfileMainFragment) {
        if (!myProfileMainFragment.KClassImpl$Data$declaredNonStaticMembers$2) {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(myProfileMainFragment.getContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_TAB_CLICK;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", "User");
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, r1));
        }
        myProfileMainFragment.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        if (myProfileMainFragment.MyBillsEntityDataFactory) {
            myProfileMainFragment.MyBillsEntityDataFactory = false;
            BaseTabFragmentAdapter baseTabFragmentAdapter = myProfileMainFragment.scheduleImpl;
            if (baseTabFragmentAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseTabFragmentAdapter = null;
            }
            ActivityResultCaller activityResultCaller = (1 < baseTabFragmentAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0.size() ? (byte) 1 : (byte) 0) != 0 ? (Fragment) baseTabFragmentAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0.get(1) : null;
            MyBusinessFragment myBusinessFragment = activityResultCaller instanceof MyBusinessFragment ? (MyBusinessFragment) activityResultCaller : null;
            if (myBusinessFragment != null) {
                myBusinessFragment.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        Fragment scheduleImpl;
        ViewPager2 viewPager2;
        HomeTabActivity homeTabActivity;
        if ((getActivity() instanceof HomeTabActivity) && (homeTabActivity = (HomeTabActivity) getActivity()) != null) {
            homeTabActivity.setSwipeable(false);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.BuiltInFictitiousFunctionClassFactory = arguments.getBoolean("IS_ME_PAGE_REVAMP", false);
            this.getAuthRequestContext = arguments.getBoolean("IS_KYB_REVAMP", true);
            KybPageInfo kybPageInfo = (KybPageInfo) arguments.getParcelable("KYB_PAGE_INFO");
            if (kybPageInfo == null) {
                kybPageInfo = new KybPageInfo(false, false, null, false, 15, null);
            } else {
                Intrinsics.checkNotNullExpressionValue(kybPageInfo, "");
            }
            this.PlaceComponentResult = kybPageInfo;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "");
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        BaseTabFragmentAdapter baseTabFragmentAdapter = new BaseTabFragmentAdapter(childFragmentManager, lifecycle);
        if (this.BuiltInFictitiousFunctionClassFactory) {
            NewMyProfileFragment.Companion companion = NewMyProfileFragment.INSTANCE;
            scheduleImpl = NewMyProfileFragment.Companion.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            scheduleImpl = MyProfileFragment.scheduleImpl();
        }
        Intrinsics.checkNotNullExpressionValue(scheduleImpl, "");
        String string = getString(R.string.profile_tab_personal);
        Intrinsics.checkNotNullExpressionValue(string, "");
        baseTabFragmentAdapter.PlaceComponentResult(scheduleImpl, string, "");
        if (this.getAuthRequestContext) {
            MyBusinessFragment.Companion companion2 = MyBusinessFragment.PlaceComponentResult;
            MyBusinessFragment MyBillsEntityDataFactory = MyBusinessFragment.Companion.MyBillsEntityDataFactory(this.PlaceComponentResult, new MyProfileMainFragment$getSettingsListener$1(this));
            String string2 = getString(R.string.profile_tab_business);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String string3 = getString(R.string.btn_kyb_settings);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            baseTabFragmentAdapter.PlaceComponentResult(MyBillsEntityDataFactory, string2, string3);
        }
        this.scheduleImpl = baseTabFragmentAdapter;
        FragmentMyprofileMainBinding binding = getBinding();
        if (binding != null) {
            ViewPager2 viewPager22 = binding.MyBillsEntityDataFactory;
            BaseTabFragmentAdapter baseTabFragmentAdapter2 = this.scheduleImpl;
            if (baseTabFragmentAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseTabFragmentAdapter2 = null;
            }
            viewPager22.setAdapter(baseTabFragmentAdapter2);
            viewPager22.setOffscreenPageLimit(1);
            new TabLayoutMediator(binding.getAuthRequestContext, binding.MyBillsEntityDataFactory, new TabLayoutMediator.TabConfigurationStrategy() { // from class: id.dana.myprofile.MyProfileMainFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
                public final void onConfigureTab(TabLayout.Tab tab, int i) {
                    MyProfileMainFragment.PlaceComponentResult(MyProfileMainFragment.this, tab, i);
                }
            }).attach();
        }
        if (this.PlaceComponentResult.getPlaceComponentResult()) {
            this.MyBillsEntityDataFactory = false;
            if (this.getAuthRequestContext) {
                MyBillsEntityDataFactory(1);
            }
        }
        FragmentMyprofileMainBinding binding2 = getBinding();
        if (binding2 != null && (viewPager2 = binding2.MyBillsEntityDataFactory) != null) {
            viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: id.dana.myprofile.MyProfileMainFragment$addOnPagerChangeListener$1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public final void onPageSelected(int p0) {
                    if (p0 == 1) {
                        MyProfileMainFragment.PlaceComponentResult(MyProfileMainFragment.this);
                    } else {
                        MyProfileMainFragment.this.getAuthRequestContext(false);
                    }
                }
            });
        }
        getAuthRequestContext(false);
        getLifecycle().BuiltInFictitiousFunctionClassFactory((EnrollPasskeyLauncher) this.getErrorConfigVersion.getValue());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean p0) {
        HomeTabActivity homeTabActivity;
        if ((getActivity() instanceof HomeTabActivity) && (homeTabActivity = (HomeTabActivity) getActivity()) != null) {
            homeTabActivity.setSwipeable(p0);
        }
        super.onHiddenChanged(p0);
    }
}
