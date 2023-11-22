package id.dana.drawable.search.searchresult;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.di.component.ApplicationComponent;
import id.dana.drawable.search.NearbySearchFragment;
import id.dana.drawable.search.NearbySearchResultListener;
import id.dana.drawable.search.adapter.MerchantSearchResultAdapter;
import id.dana.nearbyme.di.component.DaggerNearbyTrackerComponent;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.ShimmeringUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\t\u0010\fJ\r\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0019\u001a\u00020\u0018X\u0087\"¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/nearbyrevamp/search/searchresult/MerchantSearchResultFragment;", "Lid/dana/nearbyrevamp/search/searchresult/BaseNearbySearchResultFragment;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "getAuthRequestContext", "MyBillsEntityDataFactory", "", "p0", "(Z)V", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "scheduleImpl", "Z", "moveToNextValue", "lookAheadTest", "I", "Lid/dana/nearbyrevamp/search/adapter/MerchantSearchResultAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/nearbyrevamp/search/adapter/MerchantSearchResultAdapter;", "PlaceComponentResult", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "GetContactSyncConfig", "Lcom/ethanhua/skeleton/SkeletonScreen;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantSearchResultFragment extends BaseNearbySearchResultFragment {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public SkeletonScreen getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public MerchantSearchResultAdapter PlaceComponentResult;
    public Map<Integer, View> getErrorConfigVersion = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment
    public final void PlaceComponentResult() {
        this.getErrorConfigVersion.clear();
    }

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.getErrorConfigVersion;
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

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment, id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_merchant_search_result;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Unit unit;
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.getAuthRequestContext = ShimmeringUtil.PlaceComponentResult((RecyclerView) getAuthRequestContext(R.id.rvMerchantSearchResult), R.layout.view_new_merchant_list_skeleton);
        }
    }

    public final void getAuthRequestContext(boolean p0) {
        Context context = getContext();
        if (context != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getAuthRequestContext(R.id.getNrCsiRsrp);
            if (constraintLayout != null) {
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                constraintLayout.setEnabled(p0);
                constraintLayout.setVisibility(0);
            }
            if (p0) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) getAuthRequestContext(R.id.announceForAccessibility);
                if (appCompatTextView != null) {
                    appCompatTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.f24002131099997));
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) getAuthRequestContext(R.id.GetLeaderboardEntryBanner);
                if (appCompatImageView != null) {
                    if (appCompatImageView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.ic_location_filled);
                        return;
                    } else {
                        appCompatImageView.setImageResource(R.drawable.ic_location_filled);
                        return;
                    }
                }
                return;
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) getAuthRequestContext(R.id.announceForAccessibility);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.f25492131100161));
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) getAuthRequestContext(R.id.GetLeaderboardEntryBanner);
            if (appCompatImageView2 != null) {
                if (appCompatImageView2 instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(appCompatImageView2, R.drawable.ic_location_grey30);
                } else {
                    appCompatImageView2.setImageResource(R.drawable.ic_location_grey30);
                }
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext(false);
        RecyclerView recyclerView = (RecyclerView) getAuthRequestContext(R.id.rvMerchantSearchResult);
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) getAuthRequestContext(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
        if (nearbySearchResultErrorView != null) {
            nearbySearchResultErrorView.setVisibility(8);
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        if (getParentFragment() instanceof NearbySearchFragment) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            MerchantSearchResultAdapter merchantSearchResultAdapter = this.PlaceComponentResult;
            MerchantSearchResultAdapter merchantSearchResultAdapter2 = null;
            if (merchantSearchResultAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantSearchResultAdapter = null;
            }
            merchantSearchResultAdapter.MyBillsEntityDataFactory();
            MerchantSearchResultAdapter merchantSearchResultAdapter3 = this.PlaceComponentResult;
            if (merchantSearchResultAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                merchantSearchResultAdapter2 = merchantSearchResultAdapter3;
            }
            ShopModel shopModel = new ShopModel();
            shopModel.E = 2;
            merchantSearchResultAdapter2.appendItem(shopModel);
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.nearbyrevamp.search.NearbySearchFragment");
            }
            ((NearbySearchFragment) parentFragment).KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
        }
    }

    public final void MyBillsEntityDataFactory(boolean p0) {
        RecyclerView recyclerView = (RecyclerView) getAuthRequestContext(R.id.rvMerchantSearchResult);
        if (recyclerView != null) {
            recyclerView.setVisibility(p0 ^ true ? 0 : 8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) getAuthRequestContext(R.id.getNrCsiRsrp);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(p0 ^ true ? 0 : 8);
        }
        NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) getAuthRequestContext(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
        if (nearbySearchResultErrorView != null) {
            nearbySearchResultErrorView.setVisibility(p0 ? 0 : 8);
        }
    }

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        getAuthRequestContext(true);
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        MerchantSearchResultAdapter merchantSearchResultAdapter = this.PlaceComponentResult;
        if (merchantSearchResultAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantSearchResultAdapter = null;
        }
        merchantSearchResultAdapter.removeAllItems();
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.MyBillsEntityDataFactory = 0;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MerchantSearchResultFragment merchantSearchResultFragment) {
        Intrinsics.checkNotNullParameter(merchantSearchResultFragment, "");
        NearbySearchResultListener nearbySearchResultListener = merchantSearchResultFragment.BuiltInFictitiousFunctionClassFactory;
        NearbyAnalyticTracker nearbyAnalyticTracker = null;
        if (nearbySearchResultListener != null) {
            MerchantSearchResultAdapter merchantSearchResultAdapter = merchantSearchResultFragment.PlaceComponentResult;
            if (merchantSearchResultAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantSearchResultAdapter = null;
            }
            List<ShopModel> items = merchantSearchResultAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            nearbySearchResultListener.BuiltInFictitiousFunctionClassFactory(CollectionsKt.take(items, 20), merchantSearchResultFragment.BuiltInFictitiousFunctionClassFactory);
        }
        NearbyAnalyticTracker nearbyAnalyticTracker2 = merchantSearchResultFragment.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker2 != null) {
            nearbyAnalyticTracker = nearbyAnalyticTracker2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        nearbyAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void getAuthRequestContext(MerchantSearchResultFragment merchantSearchResultFragment) {
        if (!merchantSearchResultFragment.BuiltInFictitiousFunctionClassFactory || merchantSearchResultFragment.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        MerchantSearchResultAdapter merchantSearchResultAdapter = merchantSearchResultFragment.PlaceComponentResult;
        if (merchantSearchResultAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantSearchResultAdapter = null;
        }
        if (merchantSearchResultAdapter.KClassImpl$Data$declaredNonStaticMembers$2()) {
            merchantSearchResultFragment.getAuthRequestContext();
        }
    }

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment, id.dana.base.BaseFragment
    public final void init() {
        DaggerNearbyTrackerComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerNearbyTrackerComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext().MyBillsEntityDataFactory(this);
        this.PlaceComponentResult = new MerchantSearchResultAdapter(new Function0<Unit>() { // from class: id.dana.nearbyrevamp.search.searchresult.MerchantSearchResultFragment$setupRecyclerView$1
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
                MerchantSearchResultFragment.this.getAuthRequestContext();
            }
        }, new Function1<ShopModel, Unit>() { // from class: id.dana.nearbyrevamp.search.searchresult.MerchantSearchResultFragment$setupRecyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ShopModel shopModel) {
                invoke2(shopModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ShopModel shopModel) {
                MerchantSearchResultAdapter merchantSearchResultAdapter;
                boolean z;
                Intrinsics.checkNotNullParameter(shopModel, "");
                NearbySearchResultListener nearbySearchResultListener = MerchantSearchResultFragment.this.BuiltInFictitiousFunctionClassFactory;
                if (nearbySearchResultListener != null) {
                    merchantSearchResultAdapter = MerchantSearchResultFragment.this.PlaceComponentResult;
                    if (merchantSearchResultAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantSearchResultAdapter = null;
                    }
                    List<ShopModel> items = merchantSearchResultAdapter.getItems();
                    Intrinsics.checkNotNullExpressionValue(items, "");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : items) {
                        if (((ShopModel) obj).E == 0) {
                            arrayList.add(obj);
                        }
                    }
                    z = MerchantSearchResultFragment.this.BuiltInFictitiousFunctionClassFactory;
                    nearbySearchResultListener.BuiltInFictitiousFunctionClassFactory(shopModel, arrayList, z);
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) getAuthRequestContext(R.id.rvMerchantSearchResult);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            MerchantSearchResultAdapter merchantSearchResultAdapter = this.PlaceComponentResult;
            if (merchantSearchResultAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantSearchResultAdapter = null;
            }
            recyclerView.setAdapter(merchantSearchResultAdapter);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyrevamp.search.searchresult.MerchantSearchResultFragment$setupRecyclerView$3$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrollStateChanged(p0, p1);
                    KeyboardHelper.MyBillsEntityDataFactory(MerchantSearchResultFragment.this.getBaseActivity());
                    if (p0.canScrollVertically(130)) {
                        return;
                    }
                    MerchantSearchResultFragment.getAuthRequestContext(MerchantSearchResultFragment.this);
                }
            });
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) getAuthRequestContext(R.id.getNrCsiRsrp);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.search.searchresult.MerchantSearchResultFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantSearchResultFragment.KClassImpl$Data$declaredNonStaticMembers$2(MerchantSearchResultFragment.this);
                }
            });
        }
    }

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.getErrorConfigVersion.clear();
    }
}
