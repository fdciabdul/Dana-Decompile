package id.dana.drawable.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.animation.HorizontalEvenlyItemDecoration;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.drawable.merchantdetail.adapter.MerchantDealsAdapter;
import id.dana.drawable.merchantdetail.adapter.MerchantPromoAdapter;
import id.dana.drawable.view.PromoDetailDialogFragment;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b!\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0014\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/nearbyrevamp/view/MerchantPromoDealsView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "Lid/dana/nearbyme/model/PromoInfoModel;", "promoInfoModels", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "dealsInfoModels", "", "populatePromoAndDeals", "(Ljava/util/List;Ljava/util/List;)V", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "setShopModel", "(Lid/dana/nearbyme/model/ShopModel;)V", "setup", "()V", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDealsAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDealsAdapter;", "getAuthRequestContext", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantPromoAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantPromoAdapter;", "PlaceComponentResult", "Lid/dana/nearbyme/model/ShopModel;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPromoDealsView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private MerchantPromoAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private MerchantDealsAdapter getAuthRequestContext;
    private ShopModel PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantPromoDealsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantPromoDealsView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_merchant_promo_deals;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantPromoDealsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantPromoDealsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantPromoDealsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void populatePromoAndDeals(List<? extends PromoInfoModel> promoInfoModels, List<MerchantProductInfoModel> dealsInfoModels) {
        MerchantPromoAdapter merchantPromoAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        MerchantDealsAdapter merchantDealsAdapter = null;
        if (merchantPromoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantPromoAdapter = null;
        }
        if (promoInfoModels == null) {
            promoInfoModels = CollectionsKt.emptyList();
        }
        merchantPromoAdapter.setItems(promoInfoModels);
        MerchantDealsAdapter merchantDealsAdapter2 = this.getAuthRequestContext;
        if (merchantDealsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantDealsAdapter = merchantDealsAdapter2;
        }
        if (dealsInfoModels == null) {
            dealsInfoModels = CollectionsKt.emptyList();
        }
        merchantDealsAdapter.setItems(dealsInfoModels);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvPromoDeals);
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    public final void setShopModel(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        this.PlaceComponentResult = shopModel;
    }

    public static final /* synthetic */ void access$onDealsClicked(MerchantPromoDealsView merchantPromoDealsView, MerchantProductInfoModel merchantProductInfoModel) {
        Uri parse = Uri.parse(DanaUrl.DANA_DEALS_DETAIL);
        Intrinsics.checkNotNullExpressionValue(parse, "");
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.appendQueryParameter("goodsId", merchantProductInfoModel.KClassImpl$Data$declaredNonStaticMembers$2);
        buildUpon.appendQueryParameter("voucherV2", SummaryActivity.CHECKED);
        String obj = buildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        DanaH5.startContainerFullUrl(obj);
    }

    public static final /* synthetic */ void access$onPromoClicked(MerchantPromoDealsView merchantPromoDealsView, PromoInfoModel promoInfoModel) {
        BaseActivity baseActivity = merchantPromoDealsView.getBaseActivity();
        if (baseActivity != null) {
            PromoDetailDialogFragment.Companion companion = PromoDetailDialogFragment.INSTANCE;
            PromoDetailDialogFragment.Companion.MyBillsEntityDataFactory(promoInfoModel).show(baseActivity.getSupportFragmentManager(), "PromoDetailDialogFragment");
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantPromoAdapter(new Function1<PromoInfoModel, Unit>() { // from class: id.dana.nearbyrevamp.view.MerchantPromoDealsView$initAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PromoInfoModel promoInfoModel) {
                invoke2(promoInfoModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PromoInfoModel promoInfoModel) {
                Intrinsics.checkNotNullParameter(promoInfoModel, "");
                MerchantPromoDealsView.access$onPromoClicked(MerchantPromoDealsView.this, promoInfoModel);
            }
        });
        this.getAuthRequestContext = new MerchantDealsAdapter(new Function1<MerchantProductInfoModel, Unit>() { // from class: id.dana.nearbyrevamp.view.MerchantPromoDealsView$initAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantProductInfoModel merchantProductInfoModel) {
                invoke2(merchantProductInfoModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantProductInfoModel merchantProductInfoModel) {
                Intrinsics.checkNotNullParameter(merchantProductInfoModel, "");
                MerchantPromoDealsView.access$onDealsClicked(MerchantPromoDealsView.this, merchantProductInfoModel);
            }
        });
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        MerchantPromoAdapter merchantPromoAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        MerchantDealsAdapter merchantDealsAdapter = null;
        if (merchantPromoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantPromoAdapter = null;
        }
        adapterArr[0] = merchantPromoAdapter;
        MerchantDealsAdapter merchantDealsAdapter2 = this.getAuthRequestContext;
        if (merchantDealsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantDealsAdapter = merchantDealsAdapter2;
        }
        adapterArr[1] = merchantDealsAdapter;
        ConcatAdapter concatAdapter = new ConcatAdapter(adapterArr);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvPromoDeals);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new HorizontalEvenlyItemDecoration());
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(concatAdapter);
        }
    }
}
