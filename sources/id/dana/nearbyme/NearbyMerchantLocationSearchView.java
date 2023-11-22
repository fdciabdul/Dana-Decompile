package id.dana.nearbyme;

import android.content.Context;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNearbyMerchantLocationComponent;
import id.dana.di.modules.NearbyMerchantLocationSearchModule;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.nearbyme.NearbyMerchantLocationSearchView;
import id.dana.nearbyme.adapter.MerchantListAdapter;
import id.dana.nearbyme.adapter.NearbyDividerItemDecoration;
import id.dana.nearbyme.adapter.NearbyLocationResultAdapter;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.richview.SearchView;
import id.dana.utils.KeyboardHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002QRB'\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u0012\b\b\u0002\u0010L\u001a\u00020\u000b¢\u0006\u0004\bM\u0010NB+\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u0012\u0006\u0010L\u001a\u00020\u000b\u0012\u0006\u0010O\u001a\u00020\u000b¢\u0006\u0004\bM\u0010PJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\tJ\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020+¢\u0006\u0004\b,\u0010-J\u001b\u00100\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0.¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u0010\tR\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u0005\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u00107R\u0018\u00109\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u00108R\"\u0010;\u001a\u00020:8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G"}, d2 = {"Lid/dana/nearbyme/NearbyMerchantLocationSearchView;", "Lid/dana/base/BaseRichView;", "Lid/dana/nearbyme/NearbyMerchantLocationSearchView$State;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/NearbyMerchantLocationSearchView$State;)V", "getAuthRequestContext", "displayInitialLocationState", "()V", "displayInitialMerchantState", "", "getLayout", "()I", "position", "Lid/dana/nearbyme/model/ShopModel;", "getSearchedMerchantByPosition", "(I)Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "resetState", "Landroid/location/Location;", "location", "setLocation", "(Landroid/location/Location;)V", "Lid/dana/nearbyme/NearbyMerchantLocationSearchView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setLocationListener", "(Lid/dana/nearbyme/NearbyMerchantLocationSearchView$Listener;)V", "Lid/dana/nearbyme/adapter/MerchantListAdapter$OnMerchantListClickListener;", "setMerchantListener", "(Lid/dana/nearbyme/adapter/MerchantListAdapter$OnMerchantListClickListener;)V", "Lid/dana/nearbyme/adapter/MerchantListAdapter$OnHomeShoppingClickListener;", "setOnHomeShoppingClickListener", "(Lid/dana/nearbyme/adapter/MerchantListAdapter$OnHomeShoppingClickListener;)V", "Lid/dana/nearbyme/adapter/MerchantListAdapter$OnOtherStoreButtonClickListener;", "setOnOtherStoreButtonClickListener", "(Lid/dana/nearbyme/adapter/MerchantListAdapter$OnOtherStoreButtonClickListener;)V", "Lid/dana/nearbyme/adapter/MerchantListAdapter$OnPromoRibbonClickListener;", "setOnPromoRibbonClickListener", "(Lid/dana/nearbyme/adapter/MerchantListAdapter$OnPromoRibbonClickListener;)V", "Lid/dana/nearbyme/adapter/MerchantListAdapter$OnTopUpButtonClickListener;", "setOnTopUpButtonClickListener", "(Lid/dana/nearbyme/adapter/MerchantListAdapter$OnTopUpButtonClickListener;)V", "", "shopModels", "setShopModels", "(Ljava/util/List;)V", "setup", "", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "Landroid/location/Location;", "Lid/dana/nearbyme/NearbyMerchantLocationSearchView$Listener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "getNearbyAnalyticTracker", "()Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "setNearbyAnalyticTracker", "(Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;)V", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "presenter", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "getPresenter", "()Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "setPresenter", "(Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Listener", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class NearbyMerchantLocationSearchView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Listener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Location BuiltInFictitiousFunctionClassFactory;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;
    @Inject
    public NearbyMerchantLocationSearchContract.Presenter presenter;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/NearbyMerchantLocationSearchView$Listener;", "", "Landroid/location/Location;", "p0", "", "PlaceComponentResult", "(Landroid/location/Location;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface Listener {
        void PlaceComponentResult(Location p0);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b"}, d2 = {"Lid/dana/nearbyme/NearbyMerchantLocationSearchView$State;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY_MERCHANT_VIEW", "EMPTY_LOCATION_VIEW", "INITIAL_MERCHANT_VIEW", "INITIAL_LOCATION_VIEW", "MERCHANT_EMPTY", "MERCHANT_EXIST", "LOCATION_EMPTY", "LOCATION_EXIST"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public enum State {
        EMPTY_MERCHANT_VIEW,
        EMPTY_LOCATION_VIEW,
        INITIAL_MERCHANT_VIEW,
        INITIAL_LOCATION_VIEW,
        MERCHANT_EMPTY,
        MERCHANT_EXIST,
        LOCATION_EMPTY,
        LOCATION_EXIST
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.INITIAL_MERCHANT_VIEW.ordinal()] = 1;
            iArr[State.EMPTY_MERCHANT_VIEW.ordinal()] = 2;
            iArr[State.INITIAL_LOCATION_VIEW.ordinal()] = 3;
            iArr[State.EMPTY_LOCATION_VIEW.ordinal()] = 4;
            iArr[State.LOCATION_EMPTY.ordinal()] = 5;
            iArr[State.LOCATION_EXIST.ordinal()] = 6;
            iArr[State.MERCHANT_EMPTY.ordinal()] = 7;
            iArr[State.MERCHANT_EXIST.ordinal()] = 8;
            getAuthRequestContext = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbyMerchantLocationSearchView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbyMerchantLocationSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_nearby_location_merchant_search;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyMerchantLocationSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ NearbyMerchantLocationSearchView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyMerchantLocationSearchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getPresenter")
    public final NearbyMerchantLocationSearchContract.Presenter getPresenter() {
        NearbyMerchantLocationSearchContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(NearbyMerchantLocationSearchContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getNearbyAnalyticTracker")
    public final NearbyAnalyticTracker getNearbyAnalyticTracker() {
        NearbyAnalyticTracker nearbyAnalyticTracker = this.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker != null) {
            return nearbyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setNearbyAnalyticTracker")
    public final void setNearbyAnalyticTracker(NearbyAnalyticTracker nearbyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(nearbyAnalyticTracker, "");
        this.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        getPresenter().BuiltInFictitiousFunctionClassFactory();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_location_list_merchant_location);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        recyclerView.addItemDecoration(new NearbyDividerItemDecoration(context, false));
        recyclerView.setAdapter(new NearbyLocationResultAdapter(new NearbyLocationResultAdapter.OnClickListener() { // from class: id.dana.nearbyme.NearbyMerchantLocationSearchView$setup$1$1
            @Override // id.dana.nearbyme.adapter.NearbyLocationResultAdapter.OnClickListener
            public final void onLocationClicked(String p0, String p1, String p2, Location p3) {
                NearbyMerchantLocationSearchView.Listener listener;
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                Intrinsics.checkNotNullParameter(p3, "");
                listener = NearbyMerchantLocationSearchView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (listener != null) {
                    listener.PlaceComponentResult(p3);
                }
            }
        }));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 1, false));
        Context context2 = recyclerView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        recyclerView2.addItemDecoration(new NearbyDividerItemDecoration(context2, true));
        recyclerView2.setAdapter(new MerchantListAdapter());
        ((SearchView) _$_findCachedViewById(R.id.sv_merchant_location_search)).setSearchHint("");
        addDisposable(((SearchView) _$_findCachedViewById(R.id.sv_merchant_location_search)).getKeyword().debounce(500L, TimeUnit.MILLISECONDS).map(new Function() { // from class: id.dana.nearbyme.NearbyMerchantLocationSearchView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMerchantLocationSearchView.$r8$lambda$xIfYRHyVOS_gXnEqPz3H2ZB8ljo(NearbyMerchantLocationSearchView.this, (String) obj);
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.nearbyme.NearbyMerchantLocationSearchView$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NearbyMerchantLocationSearchView.m2717$r8$lambda$wsrvSKB_Yga4CgJOdXPTU4YDxg(NearbyMerchantLocationSearchView.this, (String) obj);
            }
        }));
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerNearbyMerchantLocationComponent.Builder PlaceComponentResult = DaggerNearbyMerchantLocationComponent.PlaceComponentResult();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        PlaceComponentResult.MyBillsEntityDataFactory = (NearbyMerchantLocationSearchModule) Preconditions.getAuthRequestContext(new NearbyMerchantLocationSearchModule(new NearbyMerchantLocationSearchContract.View() { // from class: id.dana.nearbyme.NearbyMerchantLocationSearchView$injectComponent$1
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
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onErrorGetNearbyMerchantList() {
                NearbyMerchantLocationSearchContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessGetMerchantListPromo(List list) {
                NearbyMerchantLocationSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessGetReverseGeocodeByLocation(Address address) {
                NearbyMerchantLocationSearchContract.View.CC.MyBillsEntityDataFactory(address);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessLoadMoreNearbyMerchantList(boolean z, List list) {
                NearbyMerchantLocationSearchContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessSearchNearbyMerchantList(boolean z, List list) {
                NearbyMerchantLocationSearchContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onSuccessGetNearbyMerchantList(List<? extends ShopModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ((SearchView) NearbyMerchantLocationSearchView.this._$_findCachedViewById(R.id.sv_merchant_location_search)).showLoading(false);
                NearbyMerchantLocationSearchView.access$updateMerchantData(NearbyMerchantLocationSearchView.this, p0);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onSuccessGetListLocations(List<NearbyLocation> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ((SearchView) NearbyMerchantLocationSearchView.this._$_findCachedViewById(R.id.sv_merchant_location_search)).showLoading(false);
                NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView = NearbyMerchantLocationSearchView.this;
                ArrayList arrayList = new ArrayList();
                for (Object obj : p0) {
                    if (((NearbyLocation) obj).getViewHolderType() == 0) {
                        arrayList.add(obj);
                    }
                }
                NearbyMerchantLocationSearchView.access$updateLocationData(nearbyMerchantLocationSearchView, arrayList);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onErrorGetListLocations() {
                NearbyMerchantLocationSearchView.this.BuiltInFictitiousFunctionClassFactory(NearbyMerchantLocationSearchView.State.LOCATION_EMPTY);
            }
        }));
        PlaceComponentResult.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getPresenter());
    }

    public final ShopModel getSearchedMerchantByPosition(int position) {
        RecyclerView.Adapter adapter = ((RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location)).getAdapter();
        if (adapter != null) {
            ShopModel item = ((MerchantListAdapter) adapter).getItem(position);
            Intrinsics.checkNotNullExpressionValue(item, "");
            return item;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.nearbyme.adapter.MerchantListAdapter");
    }

    public final void setLocation(Location location) {
        Intrinsics.checkNotNullParameter(location, "");
        this.BuiltInFictitiousFunctionClassFactory = location;
    }

    public final void displayInitialMerchantState() {
        ((SearchView) _$_findCachedViewById(R.id.sv_merchant_location_search)).focusEtSearchContact();
        BuiltInFictitiousFunctionClassFactory(State.INITIAL_MERCHANT_VIEW);
        this.MyBillsEntityDataFactory = true;
    }

    public final void displayInitialLocationState() {
        ((SearchView) _$_findCachedViewById(R.id.sv_merchant_location_search)).focusEtSearchContact();
        BuiltInFictitiousFunctionClassFactory(State.INITIAL_LOCATION_VIEW);
        this.MyBillsEntityDataFactory = false;
    }

    public final void setLocationListener(Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = listener;
    }

    public final void setShopModels(List<? extends ShopModel> shopModels) {
        Intrinsics.checkNotNullParameter(shopModels, "");
        getPresenter().PlaceComponentResult(shopModels);
    }

    public final void setMerchantListener(MerchantListAdapter.OnMerchantListClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MerchantListAdapter merchantListAdapter = adapter instanceof MerchantListAdapter ? (MerchantListAdapter) adapter : null;
        if (merchantListAdapter == null) {
            return;
        }
        merchantListAdapter.PlaceComponentResult = listener;
    }

    public final void setOnOtherStoreButtonClickListener(MerchantListAdapter.OnOtherStoreButtonClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MerchantListAdapter merchantListAdapter = adapter instanceof MerchantListAdapter ? (MerchantListAdapter) adapter : null;
        if (merchantListAdapter == null) {
            return;
        }
        merchantListAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = listener;
    }

    public final void setOnTopUpButtonClickListener(MerchantListAdapter.OnTopUpButtonClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MerchantListAdapter merchantListAdapter = adapter instanceof MerchantListAdapter ? (MerchantListAdapter) adapter : null;
        if (merchantListAdapter == null) {
            return;
        }
        merchantListAdapter.BuiltInFictitiousFunctionClassFactory = listener;
    }

    public final void setOnPromoRibbonClickListener(MerchantListAdapter.OnPromoRibbonClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MerchantListAdapter merchantListAdapter = adapter instanceof MerchantListAdapter ? (MerchantListAdapter) adapter : null;
        if (merchantListAdapter == null) {
            return;
        }
        merchantListAdapter.MyBillsEntityDataFactory = listener;
    }

    public final void setOnHomeShoppingClickListener(MerchantListAdapter.OnHomeShoppingClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MerchantListAdapter merchantListAdapter = adapter instanceof MerchantListAdapter ? (MerchantListAdapter) adapter : null;
        if (merchantListAdapter == null) {
            return;
        }
        merchantListAdapter.getAuthRequestContext = listener;
    }

    private final void getAuthRequestContext(State p0) {
        RecyclerView.Adapter adapter = ((RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location)).getAdapter();
        MerchantListAdapter merchantListAdapter = adapter instanceof MerchantListAdapter ? (MerchantListAdapter) adapter : null;
        if (merchantListAdapter == null) {
            return;
        }
        RecyclerView.Adapter adapter2 = ((RecyclerView) _$_findCachedViewById(R.id.rv_location_list_merchant_location)).getAdapter();
        NearbyLocationResultAdapter nearbyLocationResultAdapter = adapter2 instanceof NearbyLocationResultAdapter ? (NearbyLocationResultAdapter) adapter2 : null;
        if (nearbyLocationResultAdapter == null) {
            return;
        }
        if (merchantListAdapter.getItems().isEmpty() && nearbyLocationResultAdapter.getItems().isEmpty()) {
            p0 = State.EMPTY_MERCHANT_VIEW;
        }
        BuiltInFictitiousFunctionClassFactory(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(State p0) {
        switch (WhenMappings.getAuthRequestContext[p0.ordinal()]) {
            case 1:
                getPresenter().getAuthRequestContext();
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_merchant_location)).setVisibility(0);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_merchant_location)).setVisibility(8);
                ((TextView) _$_findCachedViewById(R.id.tv_merchant_title_merchant_location)).setVisibility(8);
                ((TextView) _$_findCachedViewById(R.id.tv_location_title_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_location_list_merchant_location)).setVisibility(8);
                return;
            case 2:
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_merchant_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_merchant_location)).setVisibility(0);
                ((TextView) _$_findCachedViewById(R.id.tv_merchant_title_merchant_location)).setVisibility(8);
                ((TextView) _$_findCachedViewById(R.id.tv_location_title_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_location_list_merchant_location)).setVisibility(8);
                return;
            case 3:
                getPresenter().getAuthRequestContext();
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_location)).setVisibility(0);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_merchant_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_merchant_location)).setVisibility(8);
                ((TextView) _$_findCachedViewById(R.id.tv_merchant_title_merchant_location)).setVisibility(8);
                ((TextView) _$_findCachedViewById(R.id.tv_location_title_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_location_list_merchant_location)).setVisibility(8);
                return;
            case 4:
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_location)).setVisibility(0);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_merchant_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_merchant_location)).setVisibility(8);
                ((TextView) _$_findCachedViewById(R.id.tv_merchant_title_merchant_location)).setVisibility(8);
                ((TextView) _$_findCachedViewById(R.id.tv_location_title_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_location_list_merchant_location)).setVisibility(8);
                return;
            case 5:
                ((TextView) _$_findCachedViewById(R.id.tv_location_title_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_location_list_merchant_location)).setVisibility(8);
                return;
            case 6:
                ((TextView) _$_findCachedViewById(R.id.tv_location_title_merchant_location)).setVisibility(0);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_location_list_merchant_location)).setVisibility(0);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_merchant_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_merchant_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_location)).setVisibility(8);
                return;
            case 7:
                ((TextView) _$_findCachedViewById(R.id.tv_merchant_title_merchant_location)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location)).setVisibility(8);
                return;
            case 8:
                ((TextView) _$_findCachedViewById(R.id.tv_merchant_title_merchant_location)).setVisibility(0);
                ((RecyclerView) _$_findCachedViewById(R.id.rv_merchant_list_merchant_location)).setVisibility(0);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_merchant_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_merchant_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_initial_search_state_location)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.ll_empty_result_location)).setVisibility(8);
                return;
            default:
                return;
        }
    }

    /* renamed from: $r8$lambda$wsrvSKB_Yga4C-gJOdXPTU4YDxg  reason: not valid java name */
    public static /* synthetic */ void m2717$r8$lambda$wsrvSKB_Yga4CgJOdXPTU4YDxg(NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView, String str) {
        Intrinsics.checkNotNullParameter(nearbyMerchantLocationSearchView, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        if (StringsKt.trim((CharSequence) str).toString().length() == 0) {
            nearbyMerchantLocationSearchView.BuiltInFictitiousFunctionClassFactory(nearbyMerchantLocationSearchView.MyBillsEntityDataFactory ? State.INITIAL_MERCHANT_VIEW : State.INITIAL_LOCATION_VIEW);
            return;
        }
        ((SearchView) nearbyMerchantLocationSearchView._$_findCachedViewById(R.id.sv_merchant_location_search)).showLoading(true);
        NearbyMerchantLocationSearchContract.Presenter presenter = nearbyMerchantLocationSearchView.getPresenter();
        Location location = nearbyMerchantLocationSearchView.BuiltInFictitiousFunctionClassFactory;
        if (location == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            location = null;
        }
        presenter.MyBillsEntityDataFactory(str, location, TrackerDataKey.Source.NEARBY_2);
        nearbyMerchantLocationSearchView.getPresenter().BuiltInFictitiousFunctionClassFactory(str);
    }

    public static /* synthetic */ String $r8$lambda$xIfYRHyVOS_gXnEqPz3H2ZB8ljo(NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView, String str) {
        nearbyMerchantLocationSearchView.getNearbyAnalyticTracker().getAuthRequestContext(str, "");
        return str;
    }

    public static final /* synthetic */ void access$updateLocationData(NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView, List list) {
        RecyclerView recyclerView = (RecyclerView) nearbyMerchantLocationSearchView._$_findCachedViewById(R.id.rv_location_list_merchant_location);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        NearbyLocationResultAdapter nearbyLocationResultAdapter = adapter instanceof NearbyLocationResultAdapter ? (NearbyLocationResultAdapter) adapter : null;
        if (nearbyLocationResultAdapter != null) {
            nearbyLocationResultAdapter.setItems(list);
            if (nearbyMerchantLocationSearchView.MyBillsEntityDataFactory) {
                nearbyMerchantLocationSearchView.getAuthRequestContext(list.isEmpty() ? State.LOCATION_EMPTY : State.LOCATION_EXIST);
            } else {
                nearbyMerchantLocationSearchView.BuiltInFictitiousFunctionClassFactory(list.isEmpty() ? State.EMPTY_LOCATION_VIEW : State.LOCATION_EXIST);
            }
        }
    }

    public static final /* synthetic */ void access$updateMerchantData(NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView, List list) {
        RecyclerView recyclerView = (RecyclerView) nearbyMerchantLocationSearchView._$_findCachedViewById(R.id.rv_merchant_list_merchant_location);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MerchantListAdapter merchantListAdapter = adapter instanceof MerchantListAdapter ? (MerchantListAdapter) adapter : null;
        if (merchantListAdapter != null) {
            merchantListAdapter.setItems(list);
            if (nearbyMerchantLocationSearchView.MyBillsEntityDataFactory) {
                nearbyMerchantLocationSearchView.getAuthRequestContext(list.isEmpty() ? State.MERCHANT_EMPTY : State.MERCHANT_EXIST);
            } else {
                nearbyMerchantLocationSearchView.BuiltInFictitiousFunctionClassFactory(State.MERCHANT_EMPTY);
            }
        }
    }

    public final void resetState() {
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this);
        ((SearchView) _$_findCachedViewById(R.id.sv_merchant_location_search)).clearSearchFocus();
        ((SearchView) _$_findCachedViewById(R.id.sv_merchant_location_search)).clearKeyword();
        BuiltInFictitiousFunctionClassFactory(State.INITIAL_MERCHANT_VIEW);
    }
}
