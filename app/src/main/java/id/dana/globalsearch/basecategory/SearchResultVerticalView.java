package id.dana.globalsearch.basecategory;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.common.DividerItemDecoration;
import id.dana.globalsearch.basecategory.adapter.SearchResultItemAdapter;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.utils.SizeUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B'\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/B+\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\b.\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0007J\u001f\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\u0007R\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R$\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010%R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010'R\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010!"}, d2 = {"Lid/dana/globalsearch/basecategory/SearchResultVerticalView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideShimmer", "()V", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", FirebaseAnalytics.Param.ITEMS, "", "shouldLoadMore", "setData", "(Ljava/util/List;Z)V", "Lkotlin/Function1;", "onItemClickCallback", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "onLoadMore", "setLoadMoreCallback", "(Lkotlin/jvm/functions/Function0;)V", "isScrollable", "setOverScrollMode", "(Z)V", "setup", "p0", "p1", "BuiltInFictitiousFunctionClassFactory", "(II)Z", "showShimmer", "MyBillsEntityDataFactory", "Z", "PlaceComponentResult", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function0;", "Lid/dana/globalsearch/basecategory/adapter/SearchResultItemAdapter;", "Lid/dana/globalsearch/basecategory/adapter/SearchResultItemAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchResultVerticalView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private SearchResultItemAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function0<Unit> MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;
    private Function1<? super Integer, Unit> getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchResultVerticalView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchResultVerticalView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_service;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultVerticalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SearchResultVerticalView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultVerticalView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int p0, int p1) {
        return !this.PlaceComponentResult && (p0 <= p1 + 3);
    }

    public final void setData(List<PaySearchInfoModel> r4, boolean shouldLoadMore) {
        Intrinsics.checkNotNullParameter(r4, "");
        this.BuiltInFictitiousFunctionClassFactory = shouldLoadMore;
        SearchResultItemAdapter searchResultItemAdapter = null;
        if (shouldLoadMore) {
            SearchResultItemAdapter searchResultItemAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (searchResultItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                searchResultItemAdapter2 = null;
            }
            SearchResultItemAdapter searchResultItemAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (searchResultItemAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                searchResultItemAdapter = searchResultItemAdapter3;
            }
            searchResultItemAdapter2.addItemsAt(searchResultItemAdapter.getPlaceComponentResult(), r4);
        } else {
            SearchResultItemAdapter searchResultItemAdapter4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (searchResultItemAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                searchResultItemAdapter = searchResultItemAdapter4;
            }
            searchResultItemAdapter.setItems(r4);
        }
        this.PlaceComponentResult = false;
    }

    public final void setLoadMoreCallback(Function0<Unit> onLoadMore) {
        Intrinsics.checkNotNullParameter(onLoadMore, "");
        this.MyBillsEntityDataFactory = onLoadMore;
    }

    public final void setItemClickCallback(Function1<? super Integer, Unit> onItemClickCallback) {
        Intrinsics.checkNotNullParameter(onItemClickCallback, "");
        this.getAuthRequestContext = onItemClickCallback;
    }

    public final void setOverScrollMode(boolean isScrollable) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a10fe_descriptorvisibilities_8);
        if (recyclerView != null) {
            recyclerView.setOverScrollMode(isScrollable ? 0 : 2);
        }
    }

    public final void showShimmer() {
        if (!this.BuiltInFictitiousFunctionClassFactory || this.PlaceComponentResult) {
            return;
        }
        SearchResultItemAdapter searchResultItemAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (searchResultItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            searchResultItemAdapter = null;
        }
        searchResultItemAdapter.addItemsAt(searchResultItemAdapter.getPlaceComponentResult(), CollectionsKt.mutableListOf(SearchResultItemAdapter.PlaceComponentResult(), SearchResultItemAdapter.PlaceComponentResult()));
    }

    public final void hideShimmer() {
        if (this.BuiltInFictitiousFunctionClassFactory && this.PlaceComponentResult) {
            SearchResultItemAdapter searchResultItemAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (searchResultItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                searchResultItemAdapter = null;
            }
            searchResultItemAdapter.removeItem(searchResultItemAdapter.getPlaceComponentResult() - 1);
            searchResultItemAdapter.removeItem(searchResultItemAdapter.getPlaceComponentResult() - 1);
        }
    }

    /* renamed from: $r8$lambda$soRTi_cCsqxhqk-ss_tMCX6IDSE */
    public static /* synthetic */ void m2609$r8$lambda$soRTi_cCsqxhqkss_tMCX6IDSE(SearchResultVerticalView searchResultVerticalView, int i) {
        Intrinsics.checkNotNullParameter(searchResultVerticalView, "");
        Function1<? super Integer, Unit> function1 = searchResultVerticalView.getAuthRequestContext;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        SearchResultItemAdapter searchResultItemAdapter = new SearchResultItemAdapter();
        searchResultItemAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.globalsearch.basecategory.SearchResultVerticalView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                SearchResultVerticalView.m2609$r8$lambda$soRTi_cCsqxhqkss_tMCX6IDSE(SearchResultVerticalView.this, i);
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = searchResultItemAdapter;
        final RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a10fe_descriptorvisibilities_8);
        if (recyclerView != null) {
            SearchResultItemAdapter searchResultItemAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (searchResultItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                searchResultItemAdapter2 = null;
            }
            recyclerView.setAdapter(searchResultItemAdapter2);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), ContextCompat.BuiltInFictitiousFunctionClassFactory(recyclerView.getContext(), R.color.MyBillsEntityDataFactory_res_0x7f060157), SizeUtil.getAuthRequestContext(16), (char) 0));
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.globalsearch.basecategory.SearchResultVerticalView$setupAdapter$2$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                    boolean BuiltInFictitiousFunctionClassFactory;
                    Function0 function0;
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrolled(p0, p1, p2);
                    RecyclerView.LayoutManager layoutManager = RecyclerView.this.getLayoutManager();
                    if (layoutManager == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    }
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory(linearLayoutManager.getItemCount(), linearLayoutManager.findLastVisibleItemPosition());
                    if (BuiltInFictitiousFunctionClassFactory) {
                        function0 = this.MyBillsEntityDataFactory;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        this.PlaceComponentResult = true;
                    }
                }
            });
        }
    }
}
