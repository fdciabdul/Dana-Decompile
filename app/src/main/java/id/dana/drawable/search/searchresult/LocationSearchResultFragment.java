package id.dana.drawable.search.searchresult;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.drawable.search.NearbySearchFragment;
import id.dana.drawable.search.NearbySearchResultListener;
import id.dana.drawable.search.adapter.LocationSearchResultAdapter;
import id.dana.drawable.search.searchresult.ChainQueryFragment;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.ShimmeringUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0007R\u0013\u0010\r\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/nearbyrevamp/search/searchresult/LocationSearchResultFragment;", "Lid/dana/nearbyrevamp/search/searchresult/BaseNearbySearchResultFragment;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "MyBillsEntityDataFactory", "", "p0", "PlaceComponentResult", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyrevamp/search/adapter/LocationSearchResultAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "lookAheadTest", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "getAuthRequestContext", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationSearchResultFragment extends BaseNearbySearchResultFragment {

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public ViewSkeletonScreen getAuthRequestContext;
    public Map<Integer, View> scheduleImpl = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<LocationSearchResultAdapter>() { // from class: id.dana.nearbyrevamp.search.searchresult.LocationSearchResultFragment$locationSearchResultAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LocationSearchResultAdapter invoke() {
            return new LocationSearchResultAdapter();
        }
    });

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment
    public final void PlaceComponentResult() {
        this.scheduleImpl.clear();
    }

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.scheduleImpl;
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
        return R.layout.fragment_location_search_result;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Unit unit;
        RecyclerView recyclerView = (RecyclerView) getAuthRequestContext(R.id.rvLocationSearchResult);
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) getAuthRequestContext(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
        if (nearbySearchResultErrorView != null) {
            nearbySearchResultErrorView.setVisibility(8);
        }
        ViewSkeletonScreen viewSkeletonScreen = this.getAuthRequestContext;
        if (viewSkeletonScreen != null) {
            viewSkeletonScreen.MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.getAuthRequestContext = ShimmeringUtil.PlaceComponentResult((RecyclerView) getAuthRequestContext(R.id.rvLocationSearchResult), R.layout.view_shimmer_location_search_result);
        }
    }

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        ViewSkeletonScreen viewSkeletonScreen = this.getAuthRequestContext;
        if (viewSkeletonScreen != null) {
            viewSkeletonScreen.PlaceComponentResult();
        }
        ((LocationSearchResultAdapter) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).removeAllItems();
    }

    public final void PlaceComponentResult(boolean p0) {
        RecyclerView recyclerView = (RecyclerView) getAuthRequestContext(R.id.rvLocationSearchResult);
        if (recyclerView != null) {
            recyclerView.setVisibility(p0 ^ true ? 0 : 8);
        }
        NearbySearchResultErrorView nearbySearchResultErrorView = (NearbySearchResultErrorView) getAuthRequestContext(R.id.res_0x7f0a19b9_usermanagercompat_api24impl);
        if (nearbySearchResultErrorView != null) {
            nearbySearchResultErrorView.setVisibility(p0 ? 0 : 8);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(LocationSearchResultFragment locationSearchResultFragment, int i) {
        Intrinsics.checkNotNullParameter(locationSearchResultFragment, "");
        if (((LocationSearchResultAdapter) locationSearchResultFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext(i)) {
            String chainQueryUrl = ((LocationSearchResultAdapter) locationSearchResultFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getItem(i).getChainQueryUrl();
            if (chainQueryUrl != null) {
                FragmentTransaction beginTransaction = locationSearchResultFragment.getBaseActivity().getSupportFragmentManager().beginTransaction();
                ChainQueryFragment.Companion companion = ChainQueryFragment.INSTANCE;
                Fragment parentFragment = locationSearchResultFragment.getParentFragment();
                NearbySearchFragment nearbySearchFragment = parentFragment instanceof NearbySearchFragment ? (NearbySearchFragment) parentFragment : null;
                beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(16908290, ChainQueryFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(chainQueryUrl, nearbySearchFragment != null ? nearbySearchFragment.getAuthRequestContext : null, locationSearchResultFragment.BuiltInFictitiousFunctionClassFactory), "ChainQueryFragment", 1);
                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = R.anim.f4722130772014;
                beginTransaction.GetContactSyncConfig = R.anim.f4732130772016;
                beginTransaction.newProxyInstance = R.anim.f4722130772014;
                beginTransaction.PrepareContext = R.anim.f4732130772016;
                if (!beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                }
                beginTransaction.scheduleImpl = true;
                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8 = "ChainQueryFragment";
                beginTransaction.getAuthRequestContext();
                return;
            }
            return;
        }
        NearbyLocation nearbyLocation = ((LocationSearchResultAdapter) locationSearchResultFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getItems().get(i);
        Intrinsics.checkNotNullExpressionValue(nearbyLocation, "");
        NearbyLocation nearbyLocation2 = nearbyLocation;
        NearbySearchResultListener nearbySearchResultListener = locationSearchResultFragment.BuiltInFictitiousFunctionClassFactory;
        if (nearbySearchResultListener != null) {
            nearbySearchResultListener.PlaceComponentResult(nearbyLocation2);
        }
    }

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment, id.dana.base.BaseFragment
    public final void init() {
        ((LocationSearchResultAdapter) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.nearbyrevamp.search.searchresult.LocationSearchResultFragment$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                LocationSearchResultFragment.PlaceComponentResult(LocationSearchResultFragment.this, i);
            }
        });
        RecyclerView recyclerView = (RecyclerView) getAuthRequestContext(R.id.rvLocationSearchResult);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter((LocationSearchResultAdapter) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyrevamp.search.searchresult.LocationSearchResultFragment$setupAdapter$2$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrollStateChanged(p0, p1);
                    KeyboardHelper.MyBillsEntityDataFactory(LocationSearchResultFragment.this.getBaseActivity());
                }
            });
        }
    }

    @Override // id.dana.drawable.search.searchresult.BaseNearbySearchResultFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.scheduleImpl.clear();
    }
}
