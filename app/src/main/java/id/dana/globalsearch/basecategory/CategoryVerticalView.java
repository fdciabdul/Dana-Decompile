package id.dana.globalsearch.basecategory;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.globalsearch.model.SearchResultModel;
import id.dana.globalsearch.view.widget.CategoryHeaderView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 B+\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\"J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ#\u0010\u000e\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\n"}, d2 = {"Lid/dana/globalsearch/basecategory/CategoryVerticalView;", "Lid/dana/globalsearch/basecategory/BaseCategoryGlobalSearchView;", "Lid/dana/globalsearch/view/widget/CategoryHeaderView;", "getCategoryHeaderView", "()Lid/dana/globalsearch/view/widget/CategoryHeaderView;", "", "getLayout", "()I", "", "hideLoadMoreShimmer", "()V", "hideSearchResult", "Lkotlin/Function1;", "onItemClickCallback", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "onLoadMore", "setLoadMoreCallback", "(Lkotlin/jvm/functions/Function0;)V", "showLoadMoreShimmer", "Lid/dana/globalsearch/model/SearchResultModel;", "searchResult", "showSearchResult", "(Lid/dana/globalsearch/model/SearchResultModel;)V", "showSection", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryVerticalView extends BaseCategoryGlobalSearchView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CategoryVerticalView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CategoryVerticalView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_category_vertical;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryVerticalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ CategoryVerticalView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryVerticalView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void showSearchResult(SearchResultModel searchResult) {
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
        SearchResultVerticalView searchResultVerticalView2 = (SearchResultVerticalView) _$_findCachedViewById(R.id.filterExhaustedFatigue);
        if (searchResultVerticalView2 != null) {
            searchResultVerticalView2.setData(getLimitedItems(searchResult), searchResult.getNetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        SearchResultVerticalView searchResultVerticalView3 = (SearchResultVerticalView) _$_findCachedViewById(R.id.filterExhaustedFatigue);
        if (searchResultVerticalView3 != null) {
            searchResultVerticalView3.setOverScrollMode(searchResult.getNetworkUserEntityData$$ExternalSyntheticLambda0());
        }
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void showSection() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.viewCategory);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void setLoadMoreCallback(Function0<Unit> onLoadMore) {
        Intrinsics.checkNotNullParameter(onLoadMore, "");
        SearchResultVerticalView searchResultVerticalView = (SearchResultVerticalView) _$_findCachedViewById(R.id.filterExhaustedFatigue);
        if (searchResultVerticalView != null) {
            searchResultVerticalView.setLoadMoreCallback(onLoadMore);
        }
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void setItemClickCallback(Function1<? super Integer, Unit> onItemClickCallback) {
        Intrinsics.checkNotNullParameter(onItemClickCallback, "");
        SearchResultVerticalView searchResultVerticalView = (SearchResultVerticalView) _$_findCachedViewById(R.id.filterExhaustedFatigue);
        if (searchResultVerticalView != null) {
            searchResultVerticalView.setItemClickCallback(onItemClickCallback);
        }
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final void hideSearchResult() {
        SearchResultVerticalView searchResultVerticalView = (SearchResultVerticalView) _$_findCachedViewById(R.id.filterExhaustedFatigue);
        if (searchResultVerticalView != null) {
            searchResultVerticalView.setVisibility(8);
        }
    }

    @Override // id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView
    public final CategoryHeaderView getCategoryHeaderView() {
        return (CategoryHeaderView) _$_findCachedViewById(R.id.categoryVerticalHeader);
    }

    public final void showLoadMoreShimmer() {
        SearchResultVerticalView searchResultVerticalView = (SearchResultVerticalView) _$_findCachedViewById(R.id.filterExhaustedFatigue);
        if (searchResultVerticalView != null) {
            searchResultVerticalView.showShimmer();
        }
    }

    public final void hideLoadMoreShimmer() {
        SearchResultVerticalView searchResultVerticalView = (SearchResultVerticalView) _$_findCachedViewById(R.id.filterExhaustedFatigue);
        if (searchResultVerticalView != null) {
            searchResultVerticalView.hideShimmer();
        }
    }
}
