package id.dana.explore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.explore.adapter.ExplorePromoAdapter;
import id.dana.explore.model.ExplorePromoWrapper;
import id.dana.explore.view.ExploreDanaFragment;
import id.dana.promocenter.model.PromoActionModel;
import id.dana.promocenter.model.PromoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/explore/view/ExplorePromoView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "refreshPromoItems", "()V", "", "Lid/dana/promocenter/model/PromoModel;", "promoList", "setPromoItems", "(Ljava/util/List;)V", "Lid/dana/explore/view/ExploreDanaFragment$ExplorePromoListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPromoListener", "(Lid/dana/explore/view/ExploreDanaFragment$ExplorePromoListener;)V", "setup", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/view/ExploreDanaFragment$ExplorePromoListener;", "getAuthRequestContext", "Lid/dana/explore/adapter/ExplorePromoAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/explore/adapter/ExplorePromoAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExplorePromoView extends BaseRichView {
    private ExplorePromoAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private ExploreDanaFragment.ExplorePromoListener getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExplorePromoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExplorePromoView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_explore_promo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExplorePromoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ExplorePromoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setPromoItems(List<? extends PromoModel> promoList) {
        Intrinsics.checkNotNullParameter(promoList, "");
        ExplorePromoAdapter explorePromoAdapter = this.BuiltInFictitiousFunctionClassFactory;
        ExplorePromoAdapter explorePromoAdapter2 = null;
        if (explorePromoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            explorePromoAdapter = null;
        }
        List<ExplorePromoWrapper> items = explorePromoAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        CollectionsKt.removeAll((List) items, (Function1) new Function1<ExplorePromoWrapper, Boolean>() { // from class: id.dana.explore.adapter.ExplorePromoAdapter$hideLoadingSkeleton$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ExplorePromoWrapper explorePromoWrapper) {
                return Boolean.valueOf(explorePromoWrapper.getAuthRequestContext == 1);
            }
        });
        explorePromoAdapter.notifyDataSetChanged();
        ExplorePromoAdapter explorePromoAdapter3 = this.BuiltInFictitiousFunctionClassFactory;
        if (explorePromoAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            explorePromoAdapter2 = explorePromoAdapter3;
        }
        List<? extends PromoModel> list = promoList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ExplorePromoWrapper(0, (PromoModel) it.next()));
        }
        explorePromoAdapter2.setItems(arrayList);
    }

    public final void setPromoListener(ExploreDanaFragment.ExplorePromoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.getAuthRequestContext = listener;
    }

    public final void refreshPromoItems() {
        ExplorePromoAdapter explorePromoAdapter = this.BuiltInFictitiousFunctionClassFactory;
        ExplorePromoAdapter explorePromoAdapter2 = null;
        if (explorePromoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            explorePromoAdapter = null;
        }
        explorePromoAdapter.removeAllItems();
        ExplorePromoAdapter explorePromoAdapter3 = this.BuiltInFictitiousFunctionClassFactory;
        if (explorePromoAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            explorePromoAdapter2 = explorePromoAdapter3;
        }
        explorePromoAdapter2.setItems(CollectionsKt.mutableListOf(new ExplorePromoWrapper(1, new PromoModel())));
    }

    /* renamed from: $r8$lambda$o-xRpWqYHYNmiQYQveFNEZdLNM0  reason: not valid java name */
    public static /* synthetic */ void m2582$r8$lambda$oxRpWqYHYNmiQYQveFNEZdLNM0(ExplorePromoAdapter explorePromoAdapter, ExplorePromoView explorePromoView, int i) {
        Intrinsics.checkNotNullParameter(explorePromoAdapter, "");
        Intrinsics.checkNotNullParameter(explorePromoView, "");
        List list = explorePromoAdapter.getItem(i).MyBillsEntityDataFactory.MyBillsEntityDataFactory;
        if (list == null) {
            list = new ArrayList();
        }
        String str = ((PromoActionModel) list.get(0)).PlaceComponentResult;
        ExploreDanaFragment.ExplorePromoListener explorePromoListener = explorePromoView.getAuthRequestContext;
        if (explorePromoListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            explorePromoListener = null;
        }
        Intrinsics.checkNotNullExpressionValue(str, "");
        explorePromoListener.BuiltInFictitiousFunctionClassFactory(str);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        final ExplorePromoAdapter explorePromoAdapter = new ExplorePromoAdapter();
        explorePromoAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.explore.view.ExplorePromoView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ExplorePromoView.m2582$r8$lambda$oxRpWqYHYNmiQYQveFNEZdLNM0(ExplorePromoAdapter.this, this, i);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = explorePromoAdapter;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_explore_promo);
        ExplorePromoAdapter explorePromoAdapter2 = null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            ExplorePromoAdapter explorePromoAdapter3 = this.BuiltInFictitiousFunctionClassFactory;
            if (explorePromoAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                explorePromoAdapter3 = null;
            }
            recyclerView.setAdapter(explorePromoAdapter3);
        }
        ExplorePromoAdapter explorePromoAdapter4 = this.BuiltInFictitiousFunctionClassFactory;
        if (explorePromoAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            explorePromoAdapter2 = explorePromoAdapter4;
        }
        explorePromoAdapter2.setItems(CollectionsKt.mutableListOf(new ExplorePromoWrapper(1, new PromoModel())));
    }
}
