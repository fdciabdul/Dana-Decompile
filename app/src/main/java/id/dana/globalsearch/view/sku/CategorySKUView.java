package id.dana.globalsearch.view.sku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView;
import id.dana.globalsearch.basecategory.SearchResultVerticalView;
import id.dana.globalsearch.mapper.ConvertMapToPojoKt;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.SearchResultModel;
import id.dana.globalsearch.view.sku.model.SKUModel;
import id.dana.globalsearch.view.widget.CategoryHeaderView;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.extension.JSONExtKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eB+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010 J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\n"}, d2 = {"Lid/dana/globalsearch/view/sku/CategorySKUView;", "Lid/dana/globalsearch/basecategory/BaseCategoryGlobalSearchView;", "Lid/dana/globalsearch/view/widget/CategoryHeaderView;", "getCategoryHeaderView", "()Lid/dana/globalsearch/view/widget/CategoryHeaderView;", "", "getLayout", "()I", "", "hideSearchResult", "()V", "Lkotlin/Function1;", "onItemClickCallback", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "onLoadMore", "setLoadMoreCallback", "(Lkotlin/jvm/functions/Function0;)V", "Lid/dana/globalsearch/model/SearchResultModel;", "searchResult", "showSearchResult", "(Lid/dana/globalsearch/model/SearchResultModel;)V", "showSection", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategorySKUView extends BaseCategoryGlobalSearchView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CategorySKUView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CategorySKUView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
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
        return R.layout.view_category_sku;
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void setLoadMoreCallback(Function0<Unit> onLoadMore) {
        Intrinsics.checkNotNullParameter(onLoadMore, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategorySKUView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ CategorySKUView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategorySKUView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void showSearchResult(SearchResultModel searchResult) {
        SKUModel.MerchantState merchantState;
        String obj;
        Intrinsics.checkNotNullParameter(searchResult, "");
        showSection();
        View _$_findCachedViewById = _$_findCachedViewById(R.id.requestPermissionLocationPrompt);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(8);
        }
        SearchResultVerticalView searchResultVerticalView = (SearchResultVerticalView) _$_findCachedViewById(R.id.filterExhaustedFatigue);
        if (searchResultVerticalView != null) {
            searchResultVerticalView.setVisibility(0);
        }
        SKUItemView sKUItemView = (SKUItemView) _$_findCachedViewById(R.id.res_0x7f0a1232_pendingresultscreator_discardedpendingresult);
        if (sKUItemView != null) {
            sKUItemView.setVisibility(0);
        }
        List<PaySearchInfoModel> limitedItems = getLimitedItems(searchResult);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(limitedItems, 10));
        for (PaySearchInfoModel paySearchInfoModel : limitedItems) {
            String str = paySearchInfoModel.moveToNextValue;
            String str2 = ConvertMapToPojoKt.getAuthRequestContext(paySearchInfoModel.getErrorConfigVersion).PlaceComponentResult;
            String str3 = paySearchInfoModel.GetContactSyncConfig;
            String str4 = paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7.get("DETAIL");
            String str5 = str4 == null ? "" : str4;
            Object obj2 = paySearchInfoModel.getErrorConfigVersion.get("openHours");
            Map map = null;
            if (obj2 != null && (obj = obj2.toString()) != null) {
                map = JSONExtKt.BuiltInFictitiousFunctionClassFactory(obj);
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(7);
            StringBuilder sb = new StringBuilder();
            sb.append("CLOSE_");
            sb.append(i - 1);
            String str6 = (String) map.get(sb.toString());
            if (str6 != null) {
                calendar.set(11, Integer.parseInt(StringsKt.take(str6, 2)));
                calendar.set(12, Integer.parseInt(StringsKt.takeLast(str6, 2)));
                if (new Date().after(calendar.getTime())) {
                    merchantState = SKUModel.MerchantState.CLOSED;
                    arrayList.add(new SKUModel(str, str2, "", str3, str5, merchantState));
                }
            }
            if (Intrinsics.areEqual(paySearchInfoModel.getErrorConfigVersion.get("isStockAvailable"), SummaryActivity.CHECKED)) {
                merchantState = SKUModel.MerchantState.OPEN;
            } else {
                merchantState = SKUModel.MerchantState.OUT_OF_STOCK;
            }
            arrayList.add(new SKUModel(str, str2, "", str3, str5, merchantState));
        }
        ArrayList arrayList2 = arrayList;
        SKUItemView sKUItemView2 = (SKUItemView) _$_findCachedViewById(R.id.res_0x7f0a1232_pendingresultscreator_discardedpendingresult);
        if (sKUItemView2 != null) {
            sKUItemView2.setData(arrayList2);
        }
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void showSection() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.FlowableConcatMapEagerPublisher_res_0x7f0a02a2);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void hideSearchResult() {
        SKUItemView sKUItemView = (SKUItemView) _$_findCachedViewById(R.id.res_0x7f0a1232_pendingresultscreator_discardedpendingresult);
        if (sKUItemView != null) {
            sKUItemView.setVisibility(8);
        }
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final CategoryHeaderView getCategoryHeaderView() {
        return (CategoryHeaderView) _$_findCachedViewById(R.id.categoryHeaderSKU);
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void setItemClickCallback(Function1<? super Integer, Unit> onItemClickCallback) {
        Intrinsics.checkNotNullParameter(onItemClickCallback, "");
        ((SKUItemView) _$_findCachedViewById(R.id.res_0x7f0a1232_pendingresultscreator_discardedpendingresult)).setItemClickCallback(onItemClickCallback);
    }
}
