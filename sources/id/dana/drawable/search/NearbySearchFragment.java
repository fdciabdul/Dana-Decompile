package id.dana.drawable.search;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.Transformations;
import androidx.viewpager.widget.ViewPager;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseWithToolbarFragment;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNearbySearchComponent;
import id.dana.di.modules.NearbyMerchantLocationSearchModule;
import id.dana.di.modules.NearbySearchModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.drawable.merchantdetail.bottomsheet.MerchantDetailBottomsheetView;
import id.dana.drawable.search.NearbySearchContract;
import id.dana.drawable.search.NearbySearchResultListener;
import id.dana.drawable.search.adapter.LocationSearchResultAdapter;
import id.dana.drawable.search.adapter.MerchantSearchResultAdapter;
import id.dana.drawable.search.adapter.NearbySearchResultTabAdapter;
import id.dana.drawable.search.adapter.NearbySearchSectionAdapter;
import id.dana.drawable.search.model.NearbySearchItemModel;
import id.dana.drawable.search.model.NearbySearchSectionModel;
import id.dana.drawable.search.searchresult.LocationSearchResultFragment;
import id.dana.drawable.search.searchresult.MerchantSearchResultFragment;
import id.dana.drawable.search.searchresult.NearbySearchResultErrorView;
import id.dana.drawable.view.NearbySearchToolbar;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.di.module.PhotoGalleryModule;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0007¢\u0006\u0004\b=\u0010\u0010J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\f\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u0006\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010\u0010J%\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u000e\u0010#J-\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\"2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u000e\u0010%J\u000f\u0010&\u001a\u00020\u000bH\u0016¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u0010J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b'\u0010\rJ\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b(\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u000e\u0010)J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010)R\u0016\u0010\f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010*R\u0013\u0010\u0013\u001a\u00020+X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b'\u0010,R\u0012\u0010.\u001a\u00020-X\u0087\"¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u00100R\u0016\u0010\u000e\u001a\u0002018\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b2\u00103R\u0012\u00105\u001a\u000204X\u0087\"¢\u0006\u0006\n\u0004\b5\u00106R\u0012\u00108\u001a\u000207X\u0087\"¢\u0006\u0006\n\u0004\b8\u00109R\u0012\u0010;\u001a\u00020:X\u0087\"¢\u0006\u0006\n\u0004\b;\u0010<"}, d2 = {"Lid/dana/nearbyrevamp/search/NearbySearchFragment;", "Lid/dana/base/BaseWithToolbarFragment;", "Lid/dana/nearbyrevamp/search/NearbySearchResultListener;", "", "p0", "Landroidx/fragment/app/Fragment;", "PlaceComponentResult", "(Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "", "getLayout", "()I", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "()V", IAPSyncCommand.COMMAND_INIT, "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "p1", "(Ljava/lang/String;I)V", "onBackPressed", "()Z", "Landroid/view/View;", "onClickLeftMenuButton", "(Landroid/view/View;)V", "Landroid/location/Location;", "(Landroid/location/Location;)V", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "(Lid/dana/domain/nearbyplaces/model/NearbyLocation;)V", "onResume", "", "Lid/dana/nearbyme/model/ShopModel;", "(Ljava/util/List;Z)V", "p2", "(Lid/dana/nearbyme/model/ShopModel;Ljava/util/List;Z)V", "onStop", "moveToNextValue", "lookAheadTest", "(Z)V", "Landroid/location/Location;", "Lid/dana/dialog/DanaLoadingDialog;", "Lkotlin/Lazy;", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "Lid/dana/nearbyrevamp/search/NearbySearchResultListener;", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter;", "scheduleImpl", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "photoPreviewPresenter", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "Lid/dana/nearbyrevamp/search/NearbySearchContract$Presenter;", "presenter", "Lid/dana/nearbyrevamp/search/NearbySearchContract$Presenter;", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "searchPresenter", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbySearchFragment extends BaseWithToolbarFragment implements NearbySearchResultListener {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    NearbySearchResultListener MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Location getAuthRequestContext;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;
    @Inject
    public PhotoGalleryContract.Presenter photoPreviewPresenter;
    @Inject
    public NearbySearchContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private NearbySearchSectionAdapter BuiltInFictitiousFunctionClassFactory;
    @Inject
    public NearbyMerchantLocationSearchContract.Presenter searchPresenter;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(NearbySearchFragment.this.getBaseActivity());
        }
    });

    public final View KClassImpl$Data$declaredNonStaticMembers$2(int i) {
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

    @Override // id.dana.drawable.search.NearbySearchResultListener
    public final /* synthetic */ void PlaceComponentResult() {
        NearbySearchResultListener.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_explore_nearby;
    }

    public NearbySearchFragment() {
        Location authRequestContext = LocationUtil.getAuthRequestContext();
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        this.getAuthRequestContext = authRequestContext;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ViewCompat.MyBillsEntityDataFactory(getBaseActivity().getWindow().getDecorView(), new OnApplyWindowInsetsListener() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return NearbySearchFragment.BuiltInFictitiousFunctionClassFactory(NearbySearchFragment.this, view, windowInsetsCompat);
            }
        });
        MyBillsEntityDataFactory(R.drawable.ic_close_white);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) KClassImpl$Data$declaredNonStaticMembers$2(R.id.toolbar_layout);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(p0 ? 0 : 8);
        }
        AppBarLayout appBarLayout = (AppBarLayout) KClassImpl$Data$declaredNonStaticMembers$2(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a0012);
        if (appBarLayout != null) {
            appBarLayout.setVisibility(p0 ? 0 : 4);
        }
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return p0.length() >= 3;
    }

    public final void MyBillsEntityDataFactory() {
        NearbySearchToolbar nearbySearchToolbar = (NearbySearchToolbar) KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(nearbySearchToolbar != null ? (EditText) nearbySearchToolbar._$_findCachedViewById(R.id.parseLineAndAppendValue) : null);
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) KClassImpl$Data$declaredNonStaticMembers$2(R.id.clNearbySearchResult);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(p0 ? 0 : 8);
        }
        RecyclerView recyclerView = (RecyclerView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.rvNearbyExplore);
        if (recyclerView != null) {
            recyclerView.setVisibility(p0 ^ true ? 0 : 8);
        }
    }

    public final Fragment PlaceComponentResult(String p0) {
        Object obj;
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "");
        Iterator<T> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Bundle arguments = ((Fragment) next).getArguments();
            if (Intrinsics.areEqual(arguments != null ? arguments.getString("key") : null, p0)) {
                obj = next;
                break;
            }
        }
        return (Fragment) obj;
    }

    @Override // id.dana.drawable.search.NearbySearchResultListener
    public final void PlaceComponentResult(NearbyLocation p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        NearbySearchResultListener nearbySearchResultListener = this.MyBillsEntityDataFactory;
        if (nearbySearchResultListener != null) {
            nearbySearchResultListener.getAuthRequestContext(p0.getLocation());
        }
        MyBillsEntityDataFactory();
    }

    @Override // id.dana.drawable.search.NearbySearchResultListener
    public final void getAuthRequestContext(Location p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        NearbySearchResultListener nearbySearchResultListener = this.MyBillsEntityDataFactory;
        if (nearbySearchResultListener != null) {
            nearbySearchResultListener.getAuthRequestContext(p0);
        }
    }

    @Override // id.dana.drawable.search.NearbySearchResultListener
    public final void BuiltInFictitiousFunctionClassFactory(List<? extends ShopModel> p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        NearbySearchResultListener nearbySearchResultListener = this.MyBillsEntityDataFactory;
        if (nearbySearchResultListener != null) {
            nearbySearchResultListener.BuiltInFictitiousFunctionClassFactory(p0, p1);
        }
    }

    @Override // id.dana.drawable.search.NearbySearchResultListener
    public final void BuiltInFictitiousFunctionClassFactory(ShopModel p0, List<? extends ShopModel> p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        NearbySearchResultListener nearbySearchResultListener = this.MyBillsEntityDataFactory;
        if (nearbySearchResultListener != null) {
            nearbySearchResultListener.BuiltInFictitiousFunctionClassFactory(p0, p1, p2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x003a, code lost:
    
        if ((r0.getVisibility() == 0) == true) goto L51;
     */
    @Override // id.dana.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onBackPressed() {
        /*
            r3 = this;
            int r0 = id.dana.R.id.res_0x7f0a11d4_daggercommonrichviewcomponent_1
            android.view.View r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            id.dana.nearbyrevamp.merchantdetail.bottomsheet.MerchantDetailBottomsheetView r0 = (id.dana.drawable.merchantdetail.bottomsheet.MerchantDetailBottomsheetView) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L14
            boolean r0 = r0.isShowing()
            if (r0 != r2) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L25
            int r0 = id.dana.R.id.res_0x7f0a11d4_daggercommonrichviewcomponent_1
            android.view.View r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            id.dana.nearbyrevamp.merchantdetail.bottomsheet.MerchantDetailBottomsheetView r0 = (id.dana.drawable.merchantdetail.bottomsheet.MerchantDetailBottomsheetView) r0
            if (r0 == 0) goto L53
            r0.collapseBottomsheet()
            goto L53
        L25:
            int r0 = id.dana.R.id.clNearbySearchResult
            android.view.View r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            if (r0 == 0) goto L3d
            android.view.View r0 = (android.view.View) r0
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L39
            r0 = 1
            goto L3a
        L39:
            r0 = 0
        L3a:
            if (r0 != r2) goto L3d
            goto L3e
        L3d:
            r2 = 0
        L3e:
            if (r2 == 0) goto L44
            r3.BuiltInFictitiousFunctionClassFactory(r1)
            goto L53
        L44:
            id.dana.base.BaseActivity r0 = r3.getBaseActivity()
            if (r0 == 0) goto L53
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            if (r0 == 0) goto L53
            r0.popBackStack()
        L53:
            boolean r0 = super.onBackPressed()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.search.NearbySearchFragment.onBackPressed():boolean");
    }

    @Override // id.dana.base.BaseWithToolbarFragment
    public final void onClickLeftMenuButton(View p0) {
        KClassImpl$Data$declaredNonStaticMembers$2(false);
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a11d4_daggercommonrichviewcomponent_1);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.hideMerchantDetailBottomsheet();
            merchantDetailBottomsheetView.reset();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        EditText editText;
        NearbySearchToolbar nearbySearchToolbar = (NearbySearchToolbar) KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
        if (nearbySearchToolbar != null && (editText = (EditText) nearbySearchToolbar._$_findCachedViewById(R.id.parseLineAndAppendValue)) != null) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(editText);
        }
        super.onStop();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyrevamp/search/NearbySearchFragment$Companion;", "", "Landroid/location/Location;", "p0", "Lid/dana/nearbyrevamp/search/NearbySearchResultListener;", "p1", "Lid/dana/nearbyrevamp/search/NearbySearchFragment;", "PlaceComponentResult", "(Landroid/location/Location;Lid/dana/nearbyrevamp/search/NearbySearchResultListener;)Lid/dana/nearbyrevamp/search/NearbySearchFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static NearbySearchFragment PlaceComponentResult(Location p0, NearbySearchResultListener p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            NearbySearchFragment nearbySearchFragment = new NearbySearchFragment();
            nearbySearchFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("latitude", Double.valueOf(p0.getLatitude())), TuplesKt.to("longitude", Double.valueOf(p0.getLongitude()))));
            Intrinsics.checkNotNullParameter(p1, "");
            nearbySearchFragment.MyBillsEntityDataFactory = p1;
            return nearbySearchFragment;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(MerchantDetailBottomsheetView merchantDetailBottomsheetView, NearbySearchFragment nearbySearchFragment, ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(merchantDetailBottomsheetView, "");
        Intrinsics.checkNotNullParameter(nearbySearchFragment, "");
        if (shopModel == null) {
            merchantDetailBottomsheetView.resetMerchantDetailContent();
            return;
        }
        String str = shopModel.newProxyInstance;
        String str2 = str != null ? str : "";
        TextView textView = nearbySearchFragment.toolbarTitle;
        if (textView != null) {
            textView.setText(str2);
        }
    }

    public static /* synthetic */ WindowInsetsCompat BuiltInFictitiousFunctionClassFactory(NearbySearchFragment nearbySearchFragment, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(nearbySearchFragment, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "");
        if (windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(WindowInsetsCompat.Type.KClassImpl$Data$declaredNonStaticMembers$2()).BuiltInFictitiousFunctionClassFactory > 0) {
            NearbySearchToolbar nearbySearchToolbar = (NearbySearchToolbar) nearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
            if (nearbySearchToolbar != null) {
                nearbySearchToolbar.setTopPadding(windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(WindowInsetsCompat.Type.KClassImpl$Data$declaredNonStaticMembers$2()).BuiltInFictitiousFunctionClassFactory);
            }
            AppBarLayout appBarLayout = (AppBarLayout) nearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a0012);
            if (appBarLayout != null) {
                ViewExtKt.BuiltInFictitiousFunctionClassFactory(appBarLayout, null, Integer.valueOf(windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(WindowInsetsCompat.Type.KClassImpl$Data$declaredNonStaticMembers$2()).BuiltInFictitiousFunctionClassFactory), null, null, 13);
            }
        }
        return WindowInsetsCompat.getAuthRequestContext;
    }

    public static final /* synthetic */ void getAuthRequestContext(NearbySearchFragment nearbySearchFragment, String str) {
        Fragment PlaceComponentResult = nearbySearchFragment.PlaceComponentResult("location");
        NearbyMerchantLocationSearchContract.Presenter presenter = null;
        LocationSearchResultFragment locationSearchResultFragment = PlaceComponentResult instanceof LocationSearchResultFragment ? (LocationSearchResultFragment) PlaceComponentResult : null;
        if (locationSearchResultFragment != null) {
            locationSearchResultFragment.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        NearbyMerchantLocationSearchContract.Presenter presenter2 = nearbySearchFragment.searchPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.MyBillsEntityDataFactory(str, nearbySearchFragment.getAuthRequestContext, TrackerDataKey.Source.NEARBY_X);
    }

    public static final /* synthetic */ LocationSearchResultFragment KClassImpl$Data$declaredNonStaticMembers$2(NearbySearchFragment nearbySearchFragment) {
        Fragment PlaceComponentResult = nearbySearchFragment.PlaceComponentResult("location");
        if (PlaceComponentResult instanceof LocationSearchResultFragment) {
            return (LocationSearchResultFragment) PlaceComponentResult;
        }
        return null;
    }

    public static final /* synthetic */ MerchantSearchResultFragment BuiltInFictitiousFunctionClassFactory(NearbySearchFragment nearbySearchFragment) {
        Fragment PlaceComponentResult = nearbySearchFragment.PlaceComponentResult("merchant");
        if (PlaceComponentResult instanceof MerchantSearchResultFragment) {
            return (MerchantSearchResultFragment) PlaceComponentResult;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0017, code lost:
    
        if ((r0.getVisibility() == 0) == true) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(id.dana.drawable.search.NearbySearchFragment r3) {
        /*
            int r0 = id.dana.R.id.clNearbySearchResult
            android.view.View r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            android.view.View r0 = (android.view.View) r0
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L16
            r0 = 1
            goto L17
        L16:
            r0 = 0
        L17:
            if (r0 != r1) goto L1a
            goto L1b
        L1a:
            r1 = 0
        L1b:
            if (r1 == 0) goto L23
            r3.BuiltInFictitiousFunctionClassFactory(r2)
            r3.BuiltInFictitiousFunctionClassFactory()
        L23:
            int r0 = id.dana.R.id.tsvSearchBox
            android.view.View r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            id.dana.nearbyrevamp.view.NearbySearchToolbar r3 = (id.dana.drawable.view.NearbySearchToolbar) r3
            if (r3 == 0) goto L30
            r3.clearText()
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.search.NearbySearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(id.dana.nearbyrevamp.search.NearbySearchFragment):void");
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(NearbySearchFragment nearbySearchFragment, String str) {
        nearbySearchFragment.BuiltInFictitiousFunctionClassFactory(true);
        ViewPager viewPager = (ViewPager) nearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a1bbc_com_alibaba_ariver_engine_api_extopt_1);
        if (viewPager != null && viewPager.getCurrentItem() == 1) {
            nearbySearchFragment.moveToNextValue(str);
        } else {
            nearbySearchFragment.lookAheadTest(str);
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(NearbySearchFragment nearbySearchFragment, String str) {
        NearbySearchToolbar nearbySearchToolbar = (NearbySearchToolbar) nearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
        String keyword = nearbySearchToolbar != null ? nearbySearchToolbar.getKeyword() : null;
        if (keyword == null) {
            keyword = "";
        }
        nearbySearchFragment.BuiltInFictitiousFunctionClassFactory(true);
        if (StringsKt.equals(str, "Location", true)) {
            ViewPager viewPager = (ViewPager) nearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a1bbc_com_alibaba_ariver_engine_api_extopt_1);
            if (viewPager != null) {
                viewPager.setCurrentItem(1);
            }
            nearbySearchFragment.moveToNextValue(keyword);
            return;
        }
        ViewPager viewPager2 = (ViewPager) nearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a1bbc_com_alibaba_ariver_engine_api_extopt_1);
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(0);
        }
        nearbySearchFragment.lookAheadTest(keyword);
    }

    private final void getAuthRequestContext(String p0) {
        Fragment PlaceComponentResult = PlaceComponentResult("location");
        NearbyMerchantLocationSearchContract.Presenter presenter = null;
        LocationSearchResultFragment locationSearchResultFragment = PlaceComponentResult instanceof LocationSearchResultFragment ? (LocationSearchResultFragment) PlaceComponentResult : null;
        if (locationSearchResultFragment != null) {
            locationSearchResultFragment.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        NearbyMerchantLocationSearchContract.Presenter presenter2 = this.searchPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.MyBillsEntityDataFactory(p0, this.getAuthRequestContext, TrackerDataKey.Source.NEARBY_X);
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Fragment PlaceComponentResult = PlaceComponentResult("merchant");
        NearbyMerchantLocationSearchContract.Presenter presenter = null;
        MerchantSearchResultFragment merchantSearchResultFragment = PlaceComponentResult instanceof MerchantSearchResultFragment ? (MerchantSearchResultFragment) PlaceComponentResult : null;
        if (merchantSearchResultFragment != null) {
            merchantSearchResultFragment.BuiltInFictitiousFunctionClassFactory();
        }
        NearbyMerchantLocationSearchContract.Presenter presenter2 = this.searchPresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        presenter2.KClassImpl$Data$declaredNonStaticMembers$2();
        NearbyMerchantLocationSearchContract.Presenter presenter3 = this.searchPresenter;
        if (presenter3 != null) {
            presenter = presenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.PlaceComponentResult(p0, this.getAuthRequestContext, 0);
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        Fragment PlaceComponentResult = PlaceComponentResult("location");
        NearbyMerchantLocationSearchContract.Presenter presenter = null;
        LocationSearchResultFragment locationSearchResultFragment = PlaceComponentResult instanceof LocationSearchResultFragment ? (LocationSearchResultFragment) PlaceComponentResult : null;
        if (locationSearchResultFragment != null) {
            locationSearchResultFragment.MyBillsEntityDataFactory();
        }
        Fragment PlaceComponentResult2 = PlaceComponentResult("merchant");
        MerchantSearchResultFragment merchantSearchResultFragment = PlaceComponentResult2 instanceof MerchantSearchResultFragment ? (MerchantSearchResultFragment) PlaceComponentResult2 : null;
        if (merchantSearchResultFragment != null) {
            merchantSearchResultFragment.MyBillsEntityDataFactory();
        }
        NearbyMerchantLocationSearchContract.Presenter presenter2 = this.searchPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final void moveToNextValue(String p0) {
        NearbyAnalyticTracker nearbyAnalyticTracker = this.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nearbyAnalyticTracker = null;
        }
        nearbyAnalyticTracker.getAuthRequestContext(p0, "Location");
        if (p0.length() > 0) {
            Fragment PlaceComponentResult = PlaceComponentResult("location");
            LocationSearchResultFragment locationSearchResultFragment = PlaceComponentResult instanceof LocationSearchResultFragment ? (LocationSearchResultFragment) PlaceComponentResult : null;
            if (Intrinsics.areEqual(p0, locationSearchResultFragment != null ? locationSearchResultFragment.KClassImpl$Data$declaredNonStaticMembers$2 : null)) {
                return;
            }
            Fragment PlaceComponentResult2 = PlaceComponentResult("location");
            LocationSearchResultFragment locationSearchResultFragment2 = PlaceComponentResult2 instanceof LocationSearchResultFragment ? (LocationSearchResultFragment) PlaceComponentResult2 : null;
            if (locationSearchResultFragment2 != null) {
                Intrinsics.checkNotNullParameter(p0, "");
                locationSearchResultFragment2.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
            }
            getAuthRequestContext(p0);
        }
    }

    public final void lookAheadTest(String p0) {
        NearbyAnalyticTracker nearbyAnalyticTracker = this.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nearbyAnalyticTracker = null;
        }
        nearbyAnalyticTracker.getAuthRequestContext(p0, "Merchant");
        if (p0.length() > 0) {
            Fragment PlaceComponentResult = PlaceComponentResult("merchant");
            MerchantSearchResultFragment merchantSearchResultFragment = PlaceComponentResult instanceof MerchantSearchResultFragment ? (MerchantSearchResultFragment) PlaceComponentResult : null;
            if (Intrinsics.areEqual(p0, merchantSearchResultFragment != null ? merchantSearchResultFragment.KClassImpl$Data$declaredNonStaticMembers$2 : null)) {
                return;
            }
            Fragment PlaceComponentResult2 = PlaceComponentResult("merchant");
            MerchantSearchResultFragment merchantSearchResultFragment2 = PlaceComponentResult2 instanceof MerchantSearchResultFragment ? (MerchantSearchResultFragment) PlaceComponentResult2 : null;
            if (merchantSearchResultFragment2 != null) {
                Intrinsics.checkNotNullParameter(p0, "");
                merchantSearchResultFragment2.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
            }
            BuiltInFictitiousFunctionClassFactory(p0);
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        final NearbySearchToolbar nearbySearchToolbar = (NearbySearchToolbar) KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
        if (nearbySearchToolbar != null) {
            nearbySearchToolbar.focusEditText();
            nearbySearchToolbar.setListener(new NearbySearchToolbar.Listener() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$setupToolbar$1$1
                @Override // id.dana.nearbyrevamp.view.NearbySearchToolbar.Listener
                public final void MyBillsEntityDataFactory() {
                    NearbySearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(NearbySearchFragment.this);
                }

                @Override // id.dana.nearbyrevamp.view.NearbySearchToolbar.Listener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    KeyboardHelper.BuiltInFictitiousFunctionClassFactory((EditText) nearbySearchToolbar._$_findCachedViewById(R.id.parseLineAndAppendValue));
                    FragmentActivity activity = NearbySearchFragment.this.getActivity();
                    if (activity != null) {
                        activity.onBackPressed();
                    }
                }

                @Override // id.dana.nearbyrevamp.view.NearbySearchToolbar.Listener
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NearbySearchToolbar nearbySearchToolbar2 = (NearbySearchToolbar) NearbySearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
                    if (nearbySearchToolbar2 != null) {
                        nearbySearchToolbar2.clearFocusFromSearchBox();
                    }
                    NearbySearchFragment.BuiltInFictitiousFunctionClassFactory(NearbySearchFragment.this, p0);
                }

                @Override // id.dana.nearbyrevamp.view.NearbySearchToolbar.Listener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    NearbySearchResultListener nearbySearchResultListener;
                    NearbySearchFragment.this.BuiltInFictitiousFunctionClassFactory();
                    NearbySearchFragment.this.BuiltInFictitiousFunctionClassFactory(false);
                    NearbySearchToolbar nearbySearchToolbar2 = (NearbySearchToolbar) NearbySearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
                    if (nearbySearchToolbar2 != null) {
                        nearbySearchToolbar2.focusEditText();
                    }
                    nearbySearchResultListener = NearbySearchFragment.this.MyBillsEntityDataFactory;
                    if (nearbySearchResultListener != null) {
                        nearbySearchResultListener.PlaceComponentResult();
                    }
                }

                @Override // id.dana.nearbyrevamp.view.NearbySearchToolbar.Listener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                    boolean KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    String obj = StringsKt.trim((CharSequence) p0).toString();
                    KClassImpl$Data$declaredNonStaticMembers$2 = NearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(obj);
                    if (KClassImpl$Data$declaredNonStaticMembers$2) {
                        NearbySearchFragment.BuiltInFictitiousFunctionClassFactory(NearbySearchFragment.this, obj);
                        return;
                    }
                    if (obj.length() == 0) {
                        NearbySearchFragment.this.BuiltInFictitiousFunctionClassFactory(false);
                    }
                }
            });
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "");
        NearbySearchResultTabAdapter nearbySearchResultTabAdapter = new NearbySearchResultTabAdapter(childFragmentManager);
        nearbySearchResultTabAdapter.BuiltInFictitiousFunctionClassFactory(new MerchantSearchResultFragment(), "merchant", getString(R.string.nearby_search_merchant_page_title));
        nearbySearchResultTabAdapter.BuiltInFictitiousFunctionClassFactory(new LocationSearchResultFragment(), "location", getString(R.string.nearby_search_location_page_title));
        ViewPager viewPager = (ViewPager) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a1bbc_com_alibaba_ariver_engine_api_extopt_1);
        if (viewPager != null) {
            viewPager.setAdapter(nearbySearchResultTabAdapter);
        }
        ViewPager viewPager2 = (ViewPager) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a1bbc_com_alibaba_ariver_engine_api_extopt_1);
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(2);
        }
        ViewPager viewPager3 = (ViewPager) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a1bbc_com_alibaba_ariver_engine_api_extopt_1);
        if (viewPager3 != null) {
            viewPager3.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$setupViewPager$1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public final void onPageScrollStateChanged(int p0) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public final void onPageScrolled(int p0, float p1, int p2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public final void onPageSelected(int p0) {
                    NearbySearchFragment.this.BuiltInFictitiousFunctionClassFactory(true);
                    NearbySearchToolbar nearbySearchToolbar2 = (NearbySearchToolbar) NearbySearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
                    String keyword = nearbySearchToolbar2 != null ? nearbySearchToolbar2.getKeyword() : null;
                    if (keyword == null) {
                        keyword = "";
                    }
                    if (p0 == 1) {
                        NearbySearchFragment.this.moveToNextValue(keyword);
                    } else {
                        NearbySearchFragment.this.lookAheadTest(keyword);
                    }
                }
            });
        }
        TabLayout tabLayout = (TabLayout) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a134d_getjvmfieldsignature_default);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager((ViewPager) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a1bbc_com_alibaba_ariver_engine_api_extopt_1));
        }
        List listOf = CollectionsKt.listOf((Object[]) new String[]{getString(R.string.tabMerchant), getString(R.string.tabLocation)});
        NearbyAnalyticTracker nearbyAnalyticTracker = null;
        if (listOf.size() == nearbySearchResultTabAdapter.getCount()) {
            int count = nearbySearchResultTabAdapter.getCount();
            for (int i = 0; i < count; i++) {
                TabLayout tabLayout2 = (TabLayout) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a134d_getjvmfieldsignature_default);
                TabLayout.Tab tabAt = tabLayout2 != null ? tabLayout2.getTabAt(i) : null;
                if (tabAt != null) {
                    tabAt.setContentDescription((CharSequence) listOf.get(i));
                }
            }
        }
        Fragment PlaceComponentResult = PlaceComponentResult("location");
        LocationSearchResultFragment locationSearchResultFragment = PlaceComponentResult instanceof LocationSearchResultFragment ? (LocationSearchResultFragment) PlaceComponentResult : null;
        if (locationSearchResultFragment != null) {
            locationSearchResultFragment.BuiltInFictitiousFunctionClassFactory = this;
        }
        Fragment PlaceComponentResult2 = PlaceComponentResult("merchant");
        MerchantSearchResultFragment merchantSearchResultFragment = PlaceComponentResult2 instanceof MerchantSearchResultFragment ? (MerchantSearchResultFragment) PlaceComponentResult2 : null;
        if (merchantSearchResultFragment != null) {
            merchantSearchResultFragment.BuiltInFictitiousFunctionClassFactory = this;
        }
        NearbySearchSectionAdapter nearbySearchSectionAdapter = new NearbySearchSectionAdapter();
        nearbySearchSectionAdapter.BuiltInFictitiousFunctionClassFactory = new NearbySearchSectionAdapter.NearbySectionListener() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$getNearbySectionListener$1
            @Override // id.dana.nearbyrevamp.search.adapter.NearbySearchSectionAdapter.NearbySectionListener
            public final void getAuthRequestContext(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                NearbySearchToolbar nearbySearchToolbar2 = (NearbySearchToolbar) NearbySearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
                if (nearbySearchToolbar2 != null) {
                    nearbySearchToolbar2.setText(p0);
                }
                NearbySearchToolbar nearbySearchToolbar3 = (NearbySearchToolbar) NearbySearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.tsvSearchBox);
                if (nearbySearchToolbar3 != null) {
                    nearbySearchToolbar3.clearFocusFromSearchBox();
                }
                NearbySearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(NearbySearchFragment.this, p1);
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = nearbySearchSectionAdapter;
        RecyclerView recyclerView = (RecyclerView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.rvNearbyExplore);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setNestedScrollingEnabled(false);
            NearbySearchSectionAdapter nearbySearchSectionAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
            if (nearbySearchSectionAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                nearbySearchSectionAdapter2 = null;
            }
            recyclerView.setAdapter(nearbySearchSectionAdapter2);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$setupExploreContent$2$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrollStateChanged(p0, p1);
                    NearbySearchFragment.this.MyBillsEntityDataFactory();
                }
            });
        }
        BottomSheetBehavior<MerchantDetailBottomsheetView> from = BottomSheetBehavior.from((MerchantDetailBottomsheetView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a11d4_daggercommonrichviewcomponent_1));
        Intrinsics.checkNotNullExpressionValue(from, "");
        final MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a11d4_daggercommonrichviewcomponent_1);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.setBottomsheetBehavior(from);
            merchantDetailBottomsheetView.setDimBackground(KClassImpl$Data$declaredNonStaticMembers$2(R.id.vDimBackgroundSearchMerchantDetail));
            merchantDetailBottomsheetView.setInitialState(5);
            merchantDetailBottomsheetView.setOnScrollListener(new Function1<Boolean, Unit>() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$setupMerchantDetailBottomSheet$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    NearbySearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(z);
                }
            });
            LiveData KClassImpl$Data$declaredNonStaticMembers$2 = Transformations.KClassImpl$Data$declaredNonStaticMembers$2(merchantDetailBottomsheetView.getShopModelLiveData());
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this, new Observer() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$$ExternalSyntheticLambda0
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    NearbySearchFragment.PlaceComponentResult(MerchantDetailBottomsheetView.this, this, (ShopModel) obj);
                }
            });
        }
        DaggerNearbySearchComponent.Builder PlaceComponentResult3 = DaggerNearbySearchComponent.PlaceComponentResult();
        PlaceComponentResult3.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult3.getAuthRequestContext = (NearbySearchModule) Preconditions.getAuthRequestContext(new NearbySearchModule(new NearbySearchContract.View() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$getNearbySearchView$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.nearbyrevamp.search.NearbySearchContract.View
            public final void getAuthRequestContext(List<NearbySearchItemModel> p0) {
                NearbySearchSectionAdapter nearbySearchSectionAdapter3;
                Intrinsics.checkNotNullParameter(p0, "");
                nearbySearchSectionAdapter3 = NearbySearchFragment.this.BuiltInFictitiousFunctionClassFactory;
                if (nearbySearchSectionAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    nearbySearchSectionAdapter3 = null;
                }
                Intrinsics.checkNotNullParameter(p0, "");
                nearbySearchSectionAdapter3.appendItem(new NearbySearchSectionModel(ExploreSectionType.TRENDING_SEARCH, p0));
            }

            @Override // id.dana.nearbyrevamp.search.NearbySearchContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                NearbySearchSectionAdapter nearbySearchSectionAdapter3;
                nearbySearchSectionAdapter3 = NearbySearchFragment.this.BuiltInFictitiousFunctionClassFactory;
                if (nearbySearchSectionAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    nearbySearchSectionAdapter3 = null;
                }
                List<NearbySearchSectionModel> items = nearbySearchSectionAdapter3.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "");
                Iterator<NearbySearchSectionModel> it = items.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (it.next().getAuthRequestContext == ExploreSectionType.TRENDING_SEARCH) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    nearbySearchSectionAdapter3.removeItem(i2);
                }
            }
        }));
        PlaceComponentResult3.PlaceComponentResult = (NearbyMerchantLocationSearchModule) Preconditions.getAuthRequestContext(new NearbyMerchantLocationSearchModule(new NearbyMerchantLocationSearchContract.View() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$getNearbyMerchantLocationView$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final String getErrorSource() {
                return "Nearby Search";
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessGetNearbyMerchantList(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessGetReverseGeocodeByLocation(Address address) {
                NearbyMerchantLocationSearchContract.View.CC.MyBillsEntityDataFactory(address);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onSuccessGetListLocations(List<NearbyLocation> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                LocationSearchResultFragment KClassImpl$Data$declaredNonStaticMembers$22 = NearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(NearbySearchFragment.this);
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ViewSkeletonScreen viewSkeletonScreen = KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext;
                    if (viewSkeletonScreen != null) {
                        viewSkeletonScreen.PlaceComponentResult();
                    }
                    if (p0.isEmpty()) {
                        ((LocationSearchResultAdapter) KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).removeAllItems();
                        KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult(true);
                        NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
                        if (nearbySearchResultErrorView != null) {
                            NearbySearchResultErrorView.show$default(nearbySearchResultErrorView, NearbySearchResultErrorView.ErrorType.NO_RESULT_ERROR, KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2, null, 4, null);
                            return;
                        }
                        return;
                    }
                    KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult(false);
                    ((LocationSearchResultAdapter) KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).setItems(p0);
                }
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onErrorGetListLocations() {
                final LocationSearchResultFragment KClassImpl$Data$declaredNonStaticMembers$22 = NearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(NearbySearchFragment.this);
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                    final NearbySearchFragment nearbySearchFragment = NearbySearchFragment.this;
                    final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$getNearbyMerchantLocationView$1$onErrorGetListLocations$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(String str) {
                            Intrinsics.checkNotNullParameter(str, "");
                            NearbySearchFragment.getAuthRequestContext(NearbySearchFragment.this, str);
                        }
                    };
                    Intrinsics.checkNotNullParameter(function1, "");
                    ViewSkeletonScreen viewSkeletonScreen = KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext;
                    if (viewSkeletonScreen != null) {
                        viewSkeletonScreen.PlaceComponentResult();
                    }
                    KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult(true);
                    NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
                    if (nearbySearchResultErrorView != null) {
                        NearbySearchResultErrorView.show$default(nearbySearchResultErrorView, NearbySearchResultErrorView.ErrorType.NETWORK_ERROR, null, new Function0<Unit>() { // from class: id.dana.nearbyrevamp.search.searchresult.LocationSearchResultFragment$showError$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                function1.invoke(KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2);
                            }
                        }, 2, null);
                    }
                }
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onSuccessSearchNearbyMerchantList(boolean p0, List<? extends ShopModel> p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                MerchantSearchResultFragment BuiltInFictitiousFunctionClassFactory = NearbySearchFragment.BuiltInFictitiousFunctionClassFactory(NearbySearchFragment.this);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    Intrinsics.checkNotNullParameter(p1, "");
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(true);
                    SkeletonScreen skeletonScreen = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    if (skeletonScreen != null) {
                        skeletonScreen.PlaceComponentResult();
                    }
                    BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = p0;
                    BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    MerchantSearchResultAdapter merchantSearchResultAdapter = null;
                    if ((!p1.isEmpty()) != false) {
                        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(false);
                        List take = CollectionsKt.take(p1, 3);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
                        Iterator it = take.iterator();
                        while (it.hasNext()) {
                            ((ShopModel) it.next()).initRecordTimeStamp = true;
                            arrayList.add(Unit.INSTANCE);
                        }
                        MerchantSearchResultAdapter merchantSearchResultAdapter2 = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                        if (merchantSearchResultAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            merchantSearchResultAdapter = merchantSearchResultAdapter2;
                        }
                        merchantSearchResultAdapter.setItems(p1);
                        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ((ShopModel) CollectionsKt.last((List) p1)).whenAvailable;
                        return;
                    }
                    BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(true);
                    MerchantSearchResultAdapter merchantSearchResultAdapter3 = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                    if (merchantSearchResultAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        merchantSearchResultAdapter = merchantSearchResultAdapter3;
                    }
                    merchantSearchResultAdapter.removeAllItems();
                    NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
                    if (nearbySearchResultErrorView != null) {
                        NearbySearchResultErrorView.show$default(nearbySearchResultErrorView, NearbySearchResultErrorView.ErrorType.NO_RESULT_ERROR, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, null, 4, null);
                    }
                }
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onSuccessLoadMoreNearbyMerchantList(boolean p0, List<? extends ShopModel> p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                MerchantSearchResultFragment BuiltInFictitiousFunctionClassFactory = NearbySearchFragment.BuiltInFictitiousFunctionClassFactory(NearbySearchFragment.this);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    Intrinsics.checkNotNullParameter(p1, "");
                    BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = p0;
                    BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    if ((!p1.isEmpty()) == true) {
                        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ((ShopModel) CollectionsKt.last((List) p1)).whenAvailable;
                        MerchantSearchResultAdapter merchantSearchResultAdapter = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                        MerchantSearchResultAdapter merchantSearchResultAdapter2 = null;
                        if (merchantSearchResultAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            merchantSearchResultAdapter = null;
                        }
                        merchantSearchResultAdapter.BuiltInFictitiousFunctionClassFactory();
                        MerchantSearchResultAdapter merchantSearchResultAdapter3 = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                        if (merchantSearchResultAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            merchantSearchResultAdapter2 = merchantSearchResultAdapter3;
                        }
                        merchantSearchResultAdapter2.appendItems(p1);
                    }
                }
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onSuccessGetMerchantListPromo(List<? extends ShopModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantSearchResultFragment BuiltInFictitiousFunctionClassFactory = NearbySearchFragment.BuiltInFictitiousFunctionClassFactory(NearbySearchFragment.this);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    MerchantSearchResultAdapter merchantSearchResultAdapter = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                    if (merchantSearchResultAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantSearchResultAdapter = null;
                    }
                    Intrinsics.checkNotNullParameter(p0, "");
                    List<ShopModel> items = merchantSearchResultAdapter.getItems();
                    if (items == null || items.isEmpty()) {
                        return;
                    }
                    for (ShopModel shopModel : p0) {
                        List<ShopModel> items2 = merchantSearchResultAdapter.getItems();
                        Intrinsics.checkNotNullExpressionValue(items2, "");
                        Iterator<ShopModel> it = items2.iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            } else if (Intrinsics.areEqual(it.next().BottomSheetCardBindingView$watcherCardNumberView$1, shopModel.BottomSheetCardBindingView$watcherCardNumberView$1)) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i2 != -1) {
                            merchantSearchResultAdapter.getItems().get(i2).MyBillsEntityDataFactory(shopModel.getCallingPid);
                            merchantSearchResultAdapter.notifyItemChanged(i2);
                        }
                    }
                }
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onErrorGetNearbyMerchantList() {
                NearbyMerchantLocationSearchContract.Presenter presenter = NearbySearchFragment.this.searchPresenter;
                MerchantSearchResultAdapter merchantSearchResultAdapter = null;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                if (presenter.getKClassImpl$Data$declaredNonStaticMembers$2() == 1) {
                    final MerchantSearchResultFragment BuiltInFictitiousFunctionClassFactory = NearbySearchFragment.BuiltInFictitiousFunctionClassFactory(NearbySearchFragment.this);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        final NearbySearchFragment nearbySearchFragment = NearbySearchFragment.this;
                        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$getNearbyMerchantLocationView$1$onErrorGetNearbyMerchantList$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(String str) {
                                Intrinsics.checkNotNullParameter(str, "");
                                NearbySearchFragment.this.BuiltInFictitiousFunctionClassFactory(str);
                            }
                        };
                        Intrinsics.checkNotNullParameter(function1, "");
                        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(true);
                        SkeletonScreen skeletonScreen = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                        if (skeletonScreen != null) {
                            skeletonScreen.PlaceComponentResult();
                        }
                        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(true);
                        MerchantSearchResultAdapter merchantSearchResultAdapter2 = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                        if (merchantSearchResultAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            merchantSearchResultAdapter = merchantSearchResultAdapter2;
                        }
                        merchantSearchResultAdapter.removeAllItems();
                        NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
                        if (nearbySearchResultErrorView != null) {
                            NearbySearchResultErrorView.show$default(nearbySearchResultErrorView, NearbySearchResultErrorView.ErrorType.NETWORK_ERROR, null, new Function0<Unit>() { // from class: id.dana.nearbyrevamp.search.searchresult.MerchantSearchResultFragment$showErrorState$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                    function1.invoke(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                                }
                            }, 2, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                MerchantSearchResultFragment BuiltInFictitiousFunctionClassFactory2 = NearbySearchFragment.BuiltInFictitiousFunctionClassFactory(NearbySearchFragment.this);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    MerchantSearchResultAdapter merchantSearchResultAdapter3 = BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult;
                    if (merchantSearchResultAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantSearchResultAdapter3 = null;
                    }
                    merchantSearchResultAdapter3.BuiltInFictitiousFunctionClassFactory();
                    MerchantSearchResultAdapter merchantSearchResultAdapter4 = BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult;
                    if (merchantSearchResultAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        merchantSearchResultAdapter = merchantSearchResultAdapter4;
                    }
                    ShopModel shopModel = new ShopModel();
                    shopModel.E = 3;
                    merchantSearchResultAdapter.appendItem(shopModel);
                }
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final String getNearbyMerchantListErrorTitle() {
                NearbySearchResultErrorView nearbySearchResultErrorView;
                MerchantSearchResultFragment BuiltInFictitiousFunctionClassFactory = NearbySearchFragment.BuiltInFictitiousFunctionClassFactory(NearbySearchFragment.this);
                String str = null;
                if (BuiltInFictitiousFunctionClassFactory != null && (nearbySearchResultErrorView = (NearbySearchResultErrorView) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(R.id.res_0x7f0a19b9_usermanagercompat_api24impl)) != null) {
                    str = nearbySearchResultErrorView.getErrorTitle();
                }
                return str == null ? "" : str;
            }
        }));
        PlaceComponentResult3.BuiltInFictitiousFunctionClassFactory = (PhotoGalleryModule) Preconditions.getAuthRequestContext(new PhotoGalleryModule("", "", new PhotoGalleryContract.View() { // from class: id.dana.nearbyrevamp.search.NearbySearchFragment$getPhotoGalleryModule$1
            @Override // id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<MerchantImageModel> p0, ShopModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                MerchantDetailBottomsheetView merchantDetailBottomsheetView2 = (MerchantDetailBottomsheetView) NearbySearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a11d4_daggercommonrichviewcomponent_1);
                if (merchantDetailBottomsheetView2 != null) {
                    merchantDetailBottomsheetView2.updateImage(p0, p1);
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3.getAuthRequestContext, NearbySearchModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3.PlaceComponentResult, NearbyMerchantLocationSearchModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3.BuiltInFictitiousFunctionClassFactory, PhotoGalleryModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerNearbySearchComponent.NearbySearchComponentImpl(PlaceComponentResult3.getAuthRequestContext, PlaceComponentResult3.PlaceComponentResult, PlaceComponentResult3.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult3.MyBillsEntityDataFactory, (byte) 0).getAuthRequestContext(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[3];
        NearbySearchContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        NearbyMerchantLocationSearchContract.Presenter presenter2 = this.searchPresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        abstractPresenterArr[1] = presenter2;
        PhotoGalleryContract.Presenter presenter3 = this.photoPreviewPresenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        abstractPresenterArr[2] = presenter3;
        registerPresenter(abstractPresenterArr);
        Bundle arguments = getArguments();
        if (arguments != null) {
            double d = arguments.getDouble("latitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double d2 = arguments.getDouble("longitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            if (!(d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                if (!(d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                    Location PlaceComponentResult4 = LocationUtil.PlaceComponentResult(d, d2);
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
                    this.getAuthRequestContext = PlaceComponentResult4;
                }
            }
        }
        NearbySearchContract.Presenter presenter4 = this.presenter;
        if (presenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter4 = null;
        }
        presenter4.MyBillsEntityDataFactory();
        NearbyMerchantLocationSearchContract.Presenter presenter5 = this.searchPresenter;
        if (presenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter5 = null;
        }
        presenter5.getAuthRequestContext();
        NearbyAnalyticTracker nearbyAnalyticTracker2 = this.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker2 != null) {
            nearbyAnalyticTracker = nearbyAnalyticTracker2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        nearbyAnalyticTracker.MyBillsEntityDataFactory();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        NearbyMerchantLocationSearchContract.Presenter presenter = this.searchPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult(p0, this.getAuthRequestContext, p1);
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
