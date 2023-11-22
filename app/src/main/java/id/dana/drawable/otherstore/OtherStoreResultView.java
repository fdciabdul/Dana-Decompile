package id.dana.drawable.otherstore;

import android.content.Context;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.contract.nearbyme.OtherStoreListContract;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNewOtherStoreComponent;
import id.dana.drawable.merchantfilter.MerchantFilterView;
import id.dana.drawable.merchantlist.adapter.NewMerchantListAdapter;
import id.dana.model.OtherStoreListResultModel;
import id.dana.nearbyme.OnCategoryCheckedListener;
import id.dana.nearbyme.di.module.OtherStoreListModule;
import id.dana.nearbyme.enums.SearchType;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.utils.ShimmeringUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 `2\u00020\u0001:\u0001`B'\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\b\b\u0002\u0010[\u001a\u00020\u0002¢\u0006\u0004\b\\\u0010]B+\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u0012\b\u0010Z\u001a\u0004\u0018\u00010Y\u0012\u0006\u0010[\u001a\u00020\u0002\u0012\u0006\u0010^\u001a\u00020\u0002¢\u0006\u0004\b\\\u0010_J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0013J\r\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u0013R\u0018\u0010 \u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u001e\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010\"\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\b\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010&R\"\u0010,\u001a\u00020\u00168\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010$\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010.\u001a\u00020-8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R:\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001042\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001048\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;RT\u0010F\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010>¢\u0006\u0002\b?\u0012\u0004\u0012\u00020\u0007\u0018\u00010=2\u001b\u00105\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010>¢\u0006\u0002\b?\u0012\u0004\u0012\u00020\u0007\u0018\u00010=8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER=\u0010K\u001a\u001d\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020>\u0018\u00010G¢\u0006\u0002\b?\u0012\u0004\u0012\u00020\u0007\u0018\u00010=8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010A\u001a\u0004\bI\u0010C\"\u0004\bJ\u0010ER\"\u0010M\u001a\u00020L8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0018\u0010@\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bV\u0010$"}, d2 = {"Lid/dana/nearbyrevamp/otherstore/OtherStoreResultView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/nearbyme/enums/SearchType;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/enums/SearchType;)V", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "isInjected", "injected", "(Z)V", "onMerchantOtherStoreClosed", "()V", "Landroid/location/Location;", "currentLocation", "", "merchantId", "searchType", "source", "searchOtherMerchantByMerchantId", "(Landroid/location/Location;Ljava/lang/String;Lid/dana/nearbyme/enums/SearchType;Ljava/lang/String;)V", "setup", "showShimmer", "getAuthRequestContext", "Landroid/location/Location;", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "PlaceComponentResult", "MyBillsEntityDataFactory", "Ljava/lang/String;", "Lid/dana/nearbyrevamp/merchantlist/adapter/NewMerchantListAdapter;", "Lid/dana/nearbyrevamp/merchantlist/adapter/NewMerchantListAdapter;", "getErrorConfigVersion", "getMerchantName", "()Ljava/lang/String;", "setMerchantName", "(Ljava/lang/String;)V", "merchantName", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "getNearbyAnalyticTracker", "()Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "setNearbyAnalyticTracker", "(Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;)V", "Lkotlin/Function0;", "value", "moveToNextValue", "Lkotlin/jvm/functions/Function0;", "getOnMerchantSearchClosed", "()Lkotlin/jvm/functions/Function0;", "setOnMerchantSearchClosed", "(Lkotlin/jvm/functions/Function0;)V", "onMerchantSearchClosed", "Lkotlin/Function1;", "Lid/dana/nearbyme/model/ShopModel;", "Lkotlin/ParameterName;", "lookAheadTest", "Lkotlin/jvm/functions/Function1;", "getOnOtherStoreClickedListener", "()Lkotlin/jvm/functions/Function1;", "setOnOtherStoreClickedListener", "(Lkotlin/jvm/functions/Function1;)V", "onOtherStoreClickedListener", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getOnShopLoaded", "setOnShopLoaded", "onShopLoaded", "Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "otherStorePresenter", "Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "getOtherStorePresenter", "()Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "setOtherStorePresenter", "(Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "scheduleImpl", "Lcom/ethanhua/skeleton/SkeletonScreen;", "DatabaseTableConfigUtil", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtherStoreResultView extends BaseRichView {
    public static final int DEFAULT_NUMBER_OF_ITEM = 20;
    public static final String DEFAULT_TRACKER_NO_RESULT = "No Result";
    private NewMerchantListAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Function1<? super List<? extends ShopModel>, Unit> onShopLoaded;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Location KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String merchantName;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Function1<? super ShopModel, Unit> onOtherStoreClickedListener;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private Function0<Unit> onMerchantSearchClosed;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;
    @Inject
    public OtherStoreListContract.Presenter otherStorePresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private SkeletonScreen lookAheadTest;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OtherStoreResultView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OtherStoreResultView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_merchant_search_result;
    }

    @JvmName(name = "getOnShopLoaded")
    public final Function1<List<? extends ShopModel>, Unit> getOnShopLoaded() {
        return this.onShopLoaded;
    }

    @JvmName(name = "setOnShopLoaded")
    public final void setOnShopLoaded(Function1<? super List<? extends ShopModel>, Unit> function1) {
        this.onShopLoaded = function1;
    }

    @JvmName(name = "getOnMerchantSearchClosed")
    public final Function0<Unit> getOnMerchantSearchClosed() {
        return this.onMerchantSearchClosed;
    }

    @JvmName(name = "setOnMerchantSearchClosed")
    public final void setOnMerchantSearchClosed(Function0<Unit> function0) {
        this.onMerchantSearchClosed = function0;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivCloseSearchResult);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.otherstore.OtherStoreResultView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OtherStoreResultView.$r8$lambda$Tk2xrnwemF10nidkbxXqeBeJjEI(OtherStoreResultView.this, view);
                }
            });
        }
    }

    @JvmName(name = "getOnOtherStoreClickedListener")
    public final Function1<ShopModel, Unit> getOnOtherStoreClickedListener() {
        return this.onOtherStoreClickedListener;
    }

    @JvmName(name = "setOnOtherStoreClickedListener")
    public final void setOnOtherStoreClickedListener(Function1<? super ShopModel, Unit> function1) {
        this.onOtherStoreClickedListener = function1;
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.PlaceComponentResult = this.onOtherStoreClickedListener;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.nearbyrevamp.otherstore.OtherStoreResultView$setOtherStoreClickListener$1$1
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
                OtherStoreResultView.access$loadMoreOtherStore(OtherStoreResultView.this);
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        newMerchantListAdapter.BuiltInFictitiousFunctionClassFactory = function0;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "setMerchantName")
    public final void setMerchantName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantName = str;
    }

    @JvmName(name = "getOtherStorePresenter")
    public final OtherStoreListContract.Presenter getOtherStorePresenter() {
        OtherStoreListContract.Presenter presenter = this.otherStorePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOtherStorePresenter")
    public final void setOtherStorePresenter(OtherStoreListContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.otherStorePresenter = presenter;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtherStoreResultView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.merchantName = "";
        this.MyBillsEntityDataFactory = true;
    }

    public /* synthetic */ OtherStoreResultView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtherStoreResultView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.merchantName = "";
        this.MyBillsEntityDataFactory = true;
    }

    @Override // id.dana.base.BaseRichView
    public final void injected(boolean isInjected) {
        if (isInjected) {
            getOtherStorePresenter().BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        DaggerNewOtherStoreComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerNewOtherStoreComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (OtherStoreListModule) Preconditions.getAuthRequestContext(new OtherStoreListModule(new OtherStoreListContract.View() { // from class: id.dana.nearbyrevamp.otherstore.OtherStoreResultView$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.nearbyme.OtherStoreListContract.View
            public final /* synthetic */ void getAuthRequestContext(OtherStoreListResultModel otherStoreListResultModel) {
                OtherStoreListContract.View.CC.PlaceComponentResult(otherStoreListResultModel);
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

            @Override // id.dana.contract.nearbyme.OtherStoreListContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<? extends ShopModel> p0) {
                NewMerchantListAdapter newMerchantListAdapter;
                boolean z;
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                OtherStoreResultView.this.getAuthRequestContext = false;
                OtherStoreResultView.access$hideShimmer(OtherStoreResultView.this);
                String str2 = null;
                if (p0.isEmpty()) {
                    OtherStoreResultView.access$showEmptyState(OtherStoreResultView.this);
                } else {
                    OtherStoreResultView otherStoreResultView = OtherStoreResultView.this;
                    String str3 = ((ShopModel) CollectionsKt.first((List) p0)).NetworkUserEntityData$$ExternalSyntheticLambda6;
                    Intrinsics.checkNotNullExpressionValue(str3, "");
                    otherStoreResultView.setMerchantName(str3);
                    newMerchantListAdapter = OtherStoreResultView.this.BuiltInFictitiousFunctionClassFactory;
                    if (newMerchantListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        newMerchantListAdapter = null;
                    }
                    newMerchantListAdapter.setItems(p0);
                    TextView textView = (TextView) OtherStoreResultView.this._$_findCachedViewById(R.id.tvMerchantSearchResult);
                    if (textView != null) {
                        textView.setText(OtherStoreResultView.this.getMerchantName());
                    }
                }
                z = OtherStoreResultView.this.MyBillsEntityDataFactory;
                if (z) {
                    OtherStoreResultView otherStoreResultView2 = OtherStoreResultView.this;
                    str = otherStoreResultView2.getErrorConfigVersion;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        str2 = str;
                    }
                    otherStoreResultView2.getNearbyAnalyticTracker().PlaceComponentResult(str2, OtherStoreResultView.this.getMerchantName().length() > 0 ? OtherStoreResultView.this.getMerchantName() : OtherStoreResultView.DEFAULT_TRACKER_NO_RESULT);
                    OtherStoreResultView.this.MyBillsEntityDataFactory = false;
                }
                Function1<List<? extends ShopModel>, Unit> onShopLoaded = OtherStoreResultView.this.getOnShopLoaded();
                if (onShopLoaded != null) {
                    onShopLoaded.invoke(p0);
                }
            }

            @Override // id.dana.contract.nearbyme.OtherStoreListContract.View
            public final void getAuthRequestContext() {
                boolean z;
                String str;
                OtherStoreResultView.this.getAuthRequestContext = false;
                OtherStoreResultView.access$hideShimmer(OtherStoreResultView.this);
                if (OtherStoreResultView.this.getOtherStorePresenter().getMoveToNextValue() == 1) {
                    OtherStoreResultView.access$showEmptyState(OtherStoreResultView.this);
                } else {
                    OtherStoreResultView.access$removeLoading(OtherStoreResultView.this);
                }
                z = OtherStoreResultView.this.MyBillsEntityDataFactory;
                if (z) {
                    OtherStoreResultView otherStoreResultView = OtherStoreResultView.this;
                    str = otherStoreResultView.getErrorConfigVersion;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        str = null;
                    }
                    otherStoreResultView.getNearbyAnalyticTracker().PlaceComponentResult(str, OtherStoreResultView.DEFAULT_TRACKER_NO_RESULT);
                    OtherStoreResultView.this.MyBillsEntityDataFactory = false;
                }
            }

            @Override // id.dana.contract.nearbyme.OtherStoreListContract.View
            public final void getAuthRequestContext(List<? extends ShopModel> p0) {
                NewMerchantListAdapter newMerchantListAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                newMerchantListAdapter = OtherStoreResultView.this.BuiltInFictitiousFunctionClassFactory;
                if (newMerchantListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    newMerchantListAdapter = null;
                }
                newMerchantListAdapter.getAuthRequestContext(p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, OtherStoreListModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, ApplicationComponent.class);
        new DaggerNewOtherStoreComponent.NewOtherStoreComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getOtherStorePresenter());
    }

    private final void BuiltInFictitiousFunctionClassFactory(SearchType p0) {
        String str;
        String str2 = this.PlaceComponentResult;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str2 = null;
        }
        if ((str2.length() == 0) || this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return;
        }
        this.getAuthRequestContext = true;
        OtherStoreListContract.Presenter otherStorePresenter = getOtherStorePresenter();
        String str3 = this.PlaceComponentResult;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        } else {
            str = str3;
        }
        Location location = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNull(location);
        double latitude = location.getLatitude();
        Location location2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNull(location2);
        otherStorePresenter.KClassImpl$Data$declaredNonStaticMembers$2(str, latitude, location2.getLongitude(), "", p0.getValue());
    }

    public final void showShimmer() {
        Unit unit;
        SkeletonScreen skeletonScreen = this.lookAheadTest;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.lookAheadTest = ShimmeringUtil.PlaceComponentResult((RecyclerView) _$_findCachedViewById(R.id.rvMerchantSearchResult), R.layout.view_new_merchant_list_skeleton);
        }
    }

    public static /* synthetic */ void $r8$lambda$Tk2xrnwemF10nidkbxXqeBeJjEI(OtherStoreResultView otherStoreResultView, View view) {
        Intrinsics.checkNotNullParameter(otherStoreResultView, "");
        Function0<Unit> function0 = otherStoreResultView.onMerchantSearchClosed;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final /* synthetic */ void access$hideShimmer(OtherStoreResultView otherStoreResultView) {
        SkeletonScreen skeletonScreen = otherStoreResultView.lookAheadTest;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void access$loadMoreOtherStore(OtherStoreResultView otherStoreResultView) {
        NewMerchantListAdapter newMerchantListAdapter = otherStoreResultView.BuiltInFictitiousFunctionClassFactory;
        NewMerchantListAdapter newMerchantListAdapter2 = null;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.getAuthRequestContext(3);
        NewMerchantListAdapter newMerchantListAdapter3 = otherStoreResultView.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            newMerchantListAdapter2 = newMerchantListAdapter3;
        }
        ShopModel shopModel = new ShopModel();
        shopModel.E = 2;
        newMerchantListAdapter2.appendItem(shopModel);
        otherStoreResultView.BuiltInFictitiousFunctionClassFactory(SearchType.MERCHANTID_SORTED_BY_DISTANCE);
        otherStoreResultView.getAuthRequestContext = true;
    }

    public static final /* synthetic */ void access$onTouchBottom(OtherStoreResultView otherStoreResultView) {
        if (!otherStoreResultView.getOtherStorePresenter().getMyBillsEntityDataFactory() || otherStoreResultView.getAuthRequestContext) {
            return;
        }
        NewMerchantListAdapter newMerchantListAdapter = otherStoreResultView.BuiltInFictitiousFunctionClassFactory;
        NewMerchantListAdapter newMerchantListAdapter2 = null;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        if (newMerchantListAdapter.getAuthRequestContext()) {
            NewMerchantListAdapter newMerchantListAdapter3 = otherStoreResultView.BuiltInFictitiousFunctionClassFactory;
            if (newMerchantListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                newMerchantListAdapter2 = newMerchantListAdapter3;
            }
            ShopModel shopModel = new ShopModel();
            shopModel.E = 3;
            newMerchantListAdapter2.appendItem(shopModel);
        }
    }

    public static final /* synthetic */ void access$removeLoading(OtherStoreResultView otherStoreResultView) {
        NewMerchantListAdapter newMerchantListAdapter = otherStoreResultView.BuiltInFictitiousFunctionClassFactory;
        NewMerchantListAdapter newMerchantListAdapter2 = null;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        List<ShopModel> items = newMerchantListAdapter.getItems();
        if (items == null || items.isEmpty()) {
            return;
        }
        NewMerchantListAdapter newMerchantListAdapter3 = otherStoreResultView.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            newMerchantListAdapter2 = newMerchantListAdapter3;
        }
        newMerchantListAdapter2.getAuthRequestContext(2);
    }

    public static final /* synthetic */ void access$showEmptyState(OtherStoreResultView otherStoreResultView) {
        NewMerchantListAdapter newMerchantListAdapter = otherStoreResultView.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.MyBillsEntityDataFactory();
    }

    public final void onMerchantOtherStoreClosed() {
        getOtherStorePresenter().PlaceComponentResult();
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.removeAllItems();
    }

    public final void searchOtherMerchantByMerchantId(Location currentLocation, String merchantId, SearchType searchType, String source) {
        Intrinsics.checkNotNullParameter(currentLocation, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(searchType, "");
        Intrinsics.checkNotNullParameter(source, "");
        getOtherStorePresenter().PlaceComponentResult();
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.removeAllItems();
        showShimmer();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = currentLocation;
        this.PlaceComponentResult = merchantId;
        this.getErrorConfigVersion = source;
        BuiltInFictitiousFunctionClassFactory(searchType);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        MerchantFilterView merchantFilterView = (MerchantFilterView) _$_findCachedViewById(R.id.ViewMonthlyAutoTopupContainerBinding);
        if (merchantFilterView != null) {
            merchantFilterView.setOnCategoryCheckedListener(new OnCategoryCheckedListener() { // from class: id.dana.nearbyrevamp.otherstore.OtherStoreResultView$setupMerchantCategories$1
                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final /* synthetic */ void onCategoryClick(MerchantCategoryModel merchantCategoryModel) {
                    OnCategoryCheckedListener.CC.BuiltInFictitiousFunctionClassFactory(merchantCategoryModel);
                }

                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final /* synthetic */ void onMulitpleCategorySelected(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final void onMulitpleCategorySelected(List<MerchantCategoryModel> p0, boolean p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    OtherStoreResultView.this.getOtherStorePresenter().PlaceComponentResult(p0);
                }
            });
        }
        this.BuiltInFictitiousFunctionClassFactory = new NewMerchantListAdapter();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvMerchantSearchResult);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyrevamp.otherstore.OtherStoreResultView$getOnScrollListener$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p0.canScrollVertically(130)) {
                        return;
                    }
                    OtherStoreResultView.access$onTouchBottom(OtherStoreResultView.this);
                }
            });
            NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
            if (newMerchantListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                newMerchantListAdapter = null;
            }
            recyclerView.setAdapter(newMerchantListAdapter);
        }
    }
}
