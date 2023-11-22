package id.dana.drawable.search.searchresult;

import android.location.Location;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseWithToolbarFragment;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNearbyMerchantLocationComponent;
import id.dana.di.modules.NearbyMerchantLocationSearchModule;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.drawable.search.NearbySearchResultListener;
import id.dana.drawable.search.adapter.LocationSearchResultAdapter;
import id.dana.drawable.search.searchresult.NearbySearchResultErrorView;
import id.dana.extension.view.ViewExtKt;
import id.dana.utils.LocationUtil;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.UrlUtil;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0003\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0003\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0012\u0010\"\u001a\u00020!X\u0087\"¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010%"}, d2 = {"Lid/dana/nearbyrevamp/search/searchresult/ChainQueryFragment;", "Lid/dana/base/BaseWithToolbarFragment;", "", "MyBillsEntityDataFactory", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "", "onBackPressed", "()Z", "Landroid/view/View;", "p0", "onClickLeftMenuButton", "(Landroid/view/View;)V", "(Z)V", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/lang/String;", "PlaceComponentResult", "Landroid/location/Location;", "lookAheadTest", "Landroid/location/Location;", "getAuthRequestContext", "Lid/dana/nearbyrevamp/search/adapter/LocationSearchResultAdapter;", "scheduleImpl", "Lkotlin/Lazy;", "Lid/dana/nearbyrevamp/search/NearbySearchResultListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/nearbyrevamp/search/NearbySearchResultListener;", "getErrorConfigVersion", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "searchPresenter", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "moveToNextValue", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChainQueryFragment extends BaseWithToolbarFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private NearbySearchResultListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    ViewSkeletonScreen moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Location getAuthRequestContext;
    @Inject
    public NearbyMerchantLocationSearchContract.Presenter searchPresenter;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<LocationSearchResultAdapter>() { // from class: id.dana.nearbyrevamp.search.searchresult.ChainQueryFragment$locationSearchResultAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LocationSearchResultAdapter invoke() {
            return new LocationSearchResultAdapter();
        }
    });

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    public final View KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
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
        return R.layout.fragment_chain_query;
    }

    public ChainQueryFragment() {
        Location authRequestContext = LocationUtil.getAuthRequestContext();
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        this.getAuthRequestContext = authRequestContext;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory();
        NearbyMerchantLocationSearchContract.Presenter presenter = this.searchPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult(this.PlaceComponentResult, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, "", TrackerDataKey.Source.NEARBY_X);
    }

    @Override // id.dana.base.BaseWithToolbarFragment
    public final void onClickLeftMenuButton(View p0) {
        FragmentManager supportFragmentManager;
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && (supportFragmentManager = baseActivity.getSupportFragmentManager()) != null) {
            supportFragmentManager.popBackStack();
        }
        super.onClickLeftMenuButton(p0);
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        Unit unit;
        RecyclerView recyclerView = (RecyclerView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.AutoValue_EventInternal);
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
        if (nearbySearchResultErrorView != null) {
            nearbySearchResultErrorView.setVisibility(8);
        }
        ViewSkeletonScreen viewSkeletonScreen = this.moveToNextValue;
        if (viewSkeletonScreen != null) {
            viewSkeletonScreen.MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.moveToNextValue = ShimmeringUtil.PlaceComponentResult((RecyclerView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.AutoValue_EventInternal), R.layout.view_shimmer_location_search_result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(boolean p0) {
        RecyclerView recyclerView = (RecyclerView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.AutoValue_EventInternal);
        if (recyclerView != null) {
            recyclerView.setVisibility(p0 ^ true ? 0 : 8);
        }
        NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
        if (nearbySearchResultErrorView != null) {
            nearbySearchResultErrorView.setVisibility(p0 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(ChainQueryFragment chainQueryFragment, int i) {
        Intrinsics.checkNotNullParameter(chainQueryFragment, "");
        if (i == 4) {
            return chainQueryFragment.onBackPressed();
        }
        return false;
    }

    @Override // id.dana.base.BaseFragment
    public final boolean onBackPressed() {
        FragmentManager supportFragmentManager;
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (supportFragmentManager = baseActivity.getSupportFragmentManager()) == null) {
            return true;
        }
        supportFragmentManager.popBackStack();
        return true;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyrevamp/search/searchresult/ChainQueryFragment$Companion;", "", "", "p0", "Landroid/location/Location;", "p1", "Lid/dana/nearbyrevamp/search/NearbySearchResultListener;", "p2", "Lid/dana/nearbyrevamp/search/searchresult/ChainQueryFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Landroid/location/Location;Lid/dana/nearbyrevamp/search/NearbySearchResultListener;)Lid/dana/nearbyrevamp/search/searchresult/ChainQueryFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static ChainQueryFragment KClassImpl$Data$declaredNonStaticMembers$2(String p0, Location p1, NearbySearchResultListener p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            ChainQueryFragment chainQueryFragment = new ChainQueryFragment();
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("chainQueryUrl", p0);
            pairArr[1] = TuplesKt.to("latitude", p1 != null ? Double.valueOf(p1.getLatitude()) : null);
            pairArr[2] = TuplesKt.to("longitude", p1 != null ? Double.valueOf(p1.getLongitude()) : null);
            chainQueryFragment.setArguments(BundleKt.PlaceComponentResult(pairArr));
            if (p2 != null) {
                chainQueryFragment.BuiltInFictitiousFunctionClassFactory = p2;
            }
            return chainQueryFragment;
        }
    }

    public static /* synthetic */ WindowInsetsCompat KClassImpl$Data$declaredNonStaticMembers$2(ChainQueryFragment chainQueryFragment, View view, WindowInsetsCompat windowInsetsCompat) {
        CoordinatorLayout coordinatorLayout;
        Intrinsics.checkNotNullParameter(chainQueryFragment, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "");
        int i = windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(WindowInsetsCompat.Type.KClassImpl$Data$declaredNonStaticMembers$2()).BuiltInFictitiousFunctionClassFactory;
        if (i > 0 && (coordinatorLayout = (CoordinatorLayout) chainQueryFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.PrefetchDownloadStatus_res_0x7f0a0350)) != null) {
            ViewExtKt.BuiltInFictitiousFunctionClassFactory(coordinatorLayout, null, Integer.valueOf(i), null, null, 13);
        }
        return WindowInsetsCompat.getAuthRequestContext;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ChainQueryFragment chainQueryFragment, int i) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(chainQueryFragment, "");
        NearbyLocation nearbyLocation = ((LocationSearchResultAdapter) chainQueryFragment.MyBillsEntityDataFactory.getValue()).getItems().get(i);
        Intrinsics.checkNotNullExpressionValue(nearbyLocation, "");
        NearbyLocation nearbyLocation2 = nearbyLocation;
        NearbySearchResultListener nearbySearchResultListener = chainQueryFragment.BuiltInFictitiousFunctionClassFactory;
        if (nearbySearchResultListener != null) {
            nearbySearchResultListener.PlaceComponentResult(nearbyLocation2);
        }
        BaseActivity baseActivity = chainQueryFragment.getBaseActivity();
        if (baseActivity == null || (supportFragmentManager = baseActivity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.popBackStack();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ChainQueryFragment chainQueryFragment, List list) {
        ViewSkeletonScreen viewSkeletonScreen = chainQueryFragment.moveToNextValue;
        if (viewSkeletonScreen != null) {
            viewSkeletonScreen.PlaceComponentResult();
        }
        if (!list.isEmpty()) {
            chainQueryFragment.MyBillsEntityDataFactory(false);
            ((LocationSearchResultAdapter) chainQueryFragment.MyBillsEntityDataFactory.getValue()).setItems(list);
            return;
        }
        chainQueryFragment.MyBillsEntityDataFactory(true);
        String str = chainQueryFragment.PlaceComponentResult;
        NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) chainQueryFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
        if (nearbySearchResultErrorView != null) {
            Intrinsics.checkNotNullExpressionValue(nearbySearchResultErrorView, "");
            NearbySearchResultErrorView.show$default(nearbySearchResultErrorView, NearbySearchResultErrorView.ErrorType.NO_RESULT_ERROR, str, null, 4, null);
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        ((LocationSearchResultAdapter) this.MyBillsEntityDataFactory.getValue()).setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.nearbyrevamp.search.searchresult.ChainQueryFragment$$ExternalSyntheticLambda2
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ChainQueryFragment.MyBillsEntityDataFactory(ChainQueryFragment.this, i);
            }
        });
        RecyclerView recyclerView = (RecyclerView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.AutoValue_EventInternal);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter((LocationSearchResultAdapter) this.MyBillsEntityDataFactory.getValue());
        }
        View view = getView();
        if (view != null) {
            view.setFocusableInTouchMode(true);
        }
        View view2 = getView();
        if (view2 != null) {
            view2.requestFocus();
        }
        View view3 = getView();
        if (view3 != null) {
            view3.setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.nearbyrevamp.search.searchresult.ChainQueryFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view4, int i, KeyEvent keyEvent) {
                    boolean authRequestContext;
                    authRequestContext = ChainQueryFragment.getAuthRequestContext(ChainQueryFragment.this, i);
                    return authRequestContext;
                }
            });
        }
        ViewCompat.MyBillsEntityDataFactory(getBaseActivity().getWindow().getDecorView(), new OnApplyWindowInsetsListener() { // from class: id.dana.nearbyrevamp.search.searchresult.ChainQueryFragment$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view4, WindowInsetsCompat windowInsetsCompat) {
                return ChainQueryFragment.KClassImpl$Data$declaredNonStaticMembers$2(ChainQueryFragment.this, view4, windowInsetsCompat);
            }
        });
        Bundle arguments = getArguments();
        NearbyMerchantLocationSearchContract.Presenter presenter = null;
        if (arguments != null) {
            Map<String, List<String>> PlaceComponentResult = UrlUtil.PlaceComponentResult(new URL(arguments.getString("chainQueryUrl", "")));
            if (PlaceComponentResult != null) {
                List<String> list = PlaceComponentResult.get(HereUrlConstant.QUERY);
                String str = list != null ? (String) CollectionsKt.first((List) list) : null;
                if (str == null) {
                    str = "";
                }
                this.PlaceComponentResult = str;
                TextView textView = this.toolbarTitle;
                if (textView != null) {
                    textView.setText(str);
                }
                MyBillsEntityDataFactory(R.drawable.btn_arrow_left);
                List<String> list2 = PlaceComponentResult.get(HereUrlConstant.ONTOLOGY);
                String str2 = list2 != null ? (String) CollectionsKt.first((List) list2) : null;
                if (str2 == null) {
                    str2 = "";
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            }
            double d = arguments.getDouble("latitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double d2 = arguments.getDouble("longitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            if (!(d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                if (!(d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                    Location PlaceComponentResult2 = LocationUtil.PlaceComponentResult(d, d2);
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
                    this.getAuthRequestContext = PlaceComponentResult2;
                }
            }
        }
        DaggerNearbyMerchantLocationComponent.Builder PlaceComponentResult3 = DaggerNearbyMerchantLocationComponent.PlaceComponentResult();
        PlaceComponentResult3.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult3.MyBillsEntityDataFactory = (NearbyMerchantLocationSearchModule) Preconditions.getAuthRequestContext(new NearbyMerchantLocationSearchModule(new NearbyMerchantLocationSearchContract.View() { // from class: id.dana.nearbyrevamp.search.searchresult.ChainQueryFragment$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ String getNearbyMerchantListErrorTitle() {
                return NearbyMerchantLocationSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str3) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onErrorGetNearbyMerchantList() {
                NearbyMerchantLocationSearchContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessGetMerchantListPromo(List list3) {
                NearbyMerchantLocationSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(list3);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessGetNearbyMerchantList(List list3) {
                Intrinsics.checkNotNullParameter(list3, "");
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessGetReverseGeocodeByLocation(Address address) {
                NearbyMerchantLocationSearchContract.View.CC.MyBillsEntityDataFactory(address);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessLoadMoreNearbyMerchantList(boolean z, List list3) {
                NearbyMerchantLocationSearchContract.View.CC.PlaceComponentResult(list3);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessSearchNearbyMerchantList(boolean z, List list3) {
                NearbyMerchantLocationSearchContract.View.CC.getAuthRequestContext(list3);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onSuccessGetListLocations(List<NearbyLocation> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ChainQueryFragment.KClassImpl$Data$declaredNonStaticMembers$2(ChainQueryFragment.this, p0);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onErrorGetListLocations() {
                final ChainQueryFragment chainQueryFragment = ChainQueryFragment.this;
                ViewSkeletonScreen viewSkeletonScreen = chainQueryFragment.moveToNextValue;
                if (viewSkeletonScreen != null) {
                    viewSkeletonScreen.PlaceComponentResult();
                }
                chainQueryFragment.MyBillsEntityDataFactory(true);
                NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) chainQueryFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
                if (nearbySearchResultErrorView != null) {
                    NearbySearchResultErrorView.show$default(nearbySearchResultErrorView, NearbySearchResultErrorView.ErrorType.NETWORK_ERROR, null, new Function0<Unit>() { // from class: id.dana.nearbyrevamp.search.searchresult.ChainQueryFragment$showError$1
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
                            ChainQueryFragment.this.MyBillsEntityDataFactory();
                        }
                    }, 2, null);
                }
            }
        }));
        PlaceComponentResult3.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        NearbyMerchantLocationSearchContract.Presenter presenter2 = this.searchPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        abstractPresenterArr[0] = presenter;
        registerPresenter(abstractPresenterArr);
        MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
