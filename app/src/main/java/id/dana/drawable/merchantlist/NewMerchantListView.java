package id.dana.drawable.merchantlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.drawable.merchantlist.adapter.NewMerchantListAdapter;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.SizeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B'\b\u0016\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\f¢\u0006\u0004\b<\u0010=B+\b\u0016\u0012\u0006\u00108\u001a\u000207\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010;\u001a\u00020\f\u0012\u0006\u0010>\u001a\u00020\f¢\u0006\u0004\b<\u0010?J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\tJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0018\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\b\b\u0002\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ(\u0010!\u001a\u00020\u00052\u0019\u0010 \u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u001f\u0012\u0004\u0012\u00020\u00050\u001e¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\tJ\r\u0010$\u001a\u00020\u0005¢\u0006\u0004\b$\u0010\tJ\r\u0010%\u001a\u00020\u0005¢\u0006\u0004\b%\u0010\tJ\r\u0010&\u001a\u00020\u0005¢\u0006\u0004\b&\u0010\tJ\r\u0010'\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\tJ#\u0010+\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00022\u0006\u0010*\u001a\u00020\u0003¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b-\u0010\u0007R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028G¢\u0006\u0006\u001a\u0004\b.\u0010\u000bR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u00106"}, d2 = {"Lid/dana/nearbyrevamp/merchantlist/NewMerchantListView;", "Lid/dana/base/BaseRichView;", "", "Lid/dana/nearbyme/model/ShopModel;", "shopModels", "", "appendItem", "(Ljava/util/List;)V", "clearMerchantList", "()V", "getItemCount", "()Ljava/util/List;", "", "getLayout", "()I", "removeLoadMore", "removeLoading", "", "isBottomSheetExpanded", "setCenterRecyclerView", "(Z)V", "", "shops", "currentPageNum", "setMerchantList", "(Ljava/util/List;I)V", "Lkotlin/Function0;", "onLoadMoreClick", "setOnLoadMoreClicked", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "onMerchantItemClick", "setOnMerchantListClicked", "(Lkotlin/jvm/functions/Function1;)V", "setup", "showEmptyState", "showLoadMore", "showLoading", "showShimmerMerchantList", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "merchantImages", "shopModel", "updateImage", "(Ljava/util/List;Lid/dana/nearbyme/model/ShopModel;)V", "updateShops", "getMerchantList", "merchantList", "Lid/dana/nearbyrevamp/merchantlist/adapter/NewMerchantListAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyrevamp/merchantlist/adapter/NewMerchantListAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "MyBillsEntityDataFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewMerchantListView extends BaseRichView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private NewMerchantListAdapter BuiltInFictitiousFunctionClassFactory;
    private SkeletonScreen MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewMerchantListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewMerchantListView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_new_merchant_list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMerchantListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ NewMerchantListView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMerchantListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public static /* synthetic */ void setMerchantList$default(NewMerchantListView newMerchantListView, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        newMerchantListView.setMerchantList(list, i);
    }

    public final void clearMerchantList() {
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.removeAllItems();
    }

    public final void updateShops(List<? extends ShopModel> shops) {
        Intrinsics.checkNotNullParameter(shops, "");
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.getAuthRequestContext(shops);
    }

    @JvmName(name = "getMerchantList")
    public final List<ShopModel> getMerchantList() {
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            return CollectionsKt.emptyList();
        }
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        if (newMerchantListAdapter.getGetAuthRequestContext() == 1 && newMerchantListAdapter.PlaceComponentResult()) {
            return new ArrayList();
        }
        List<ShopModel> items = newMerchantListAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        return items;
    }

    public final void showShimmerMerchantList() {
        Unit unit;
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.MyBillsEntityDataFactory = ShimmeringUtil.PlaceComponentResult((RecyclerView) _$_findCachedViewById(R.id.contentEqualsIgnoreCaseImpl), R.layout.view_new_merchant_list_skeleton);
        }
    }

    public final void setOnMerchantListClicked(Function1<? super ShopModel, Unit> onMerchantItemClick) {
        Intrinsics.checkNotNullParameter(onMerchantItemClick, "");
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.PlaceComponentResult = onMerchantItemClick;
    }

    public final void setOnLoadMoreClicked(Function0<Unit> onLoadMoreClick) {
        Intrinsics.checkNotNullParameter(onLoadMoreClick, "");
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        Intrinsics.checkNotNullParameter(onLoadMoreClick, "");
        newMerchantListAdapter.BuiltInFictitiousFunctionClassFactory = onLoadMoreClick;
    }

    public final void updateImage(List<MerchantImageModel> merchantImages, ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(merchantImages, "");
        Intrinsics.checkNotNullParameter(shopModel, "");
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        NewMerchantListAdapter newMerchantListAdapter2 = null;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        List<ShopModel> items = newMerchantListAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        int i = 0;
        Iterator<ShopModel> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next(), shopModel)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            NewMerchantListAdapter newMerchantListAdapter3 = this.BuiltInFictitiousFunctionClassFactory;
            if (newMerchantListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                newMerchantListAdapter3 = null;
            }
            ShopModel shopModel2 = newMerchantListAdapter3.getItems().get(i);
            shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda4 = merchantImages;
            NewMerchantListAdapter newMerchantListAdapter4 = this.BuiltInFictitiousFunctionClassFactory;
            if (newMerchantListAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                newMerchantListAdapter2 = newMerchantListAdapter4;
            }
            newMerchantListAdapter2.notifyItemChanged(i);
        }
    }

    public final void showLoading() {
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        ShopModel shopModel = new ShopModel();
        shopModel.E = 2;
        newMerchantListAdapter.appendItem(shopModel);
    }

    public final void showLoadMore() {
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        ShopModel shopModel = new ShopModel();
        shopModel.E = 3;
        newMerchantListAdapter.appendItem(shopModel);
    }

    public final void removeLoading() {
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.getAuthRequestContext(2);
    }

    public final void removeLoadMore() {
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.getAuthRequestContext(3);
    }

    public final void appendItem(List<? extends ShopModel> shopModels) {
        Intrinsics.checkNotNullParameter(shopModels, "");
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.appendItems(shopModels);
    }

    public final List<ShopModel> getItemCount() {
        return getMerchantList();
    }

    public static /* synthetic */ void setCenterRecyclerView$default(NewMerchantListView newMerchantListView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        newMerchantListView.setCenterRecyclerView(z);
    }

    public final void setCenterRecyclerView(boolean isBottomSheetExpanded) {
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        if (newMerchantListAdapter.PlaceComponentResult() && isBottomSheetExpanded) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.contentEqualsIgnoreCaseImpl);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            RecyclerView recyclerView2 = recyclerView;
            recyclerView2.setPadding(recyclerView2.getPaddingLeft(), SizeUtil.getAuthRequestContext(100), recyclerView2.getPaddingRight(), recyclerView2.getPaddingBottom());
            return;
        }
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(R.id.contentEqualsIgnoreCaseImpl);
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "");
        RecyclerView recyclerView4 = recyclerView3;
        recyclerView4.setPadding(recyclerView4.getPaddingLeft(), 0, recyclerView4.getPaddingRight(), recyclerView4.getPaddingBottom());
    }

    public final void setMerchantList(List<ShopModel> shops, int currentPageNum) {
        Intrinsics.checkNotNullParameter(shops, "");
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        NewMerchantListAdapter newMerchantListAdapter = null;
        if (shops.isEmpty()) {
            NewMerchantListAdapter newMerchantListAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
            if (newMerchantListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                newMerchantListAdapter2 = null;
            }
            if (newMerchantListAdapter2.getItems().isEmpty()) {
                NewMerchantListAdapter newMerchantListAdapter3 = this.BuiltInFictitiousFunctionClassFactory;
                if (newMerchantListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    newMerchantListAdapter = newMerchantListAdapter3;
                }
                newMerchantListAdapter.MyBillsEntityDataFactory();
                return;
            }
        }
        NewMerchantListAdapter newMerchantListAdapter4 = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter4 = null;
        }
        newMerchantListAdapter4.getAuthRequestContext(1);
        setCenterRecyclerView(false);
        if (currentPageNum > 1) {
            removeLoading();
            NewMerchantListAdapter newMerchantListAdapter5 = this.BuiltInFictitiousFunctionClassFactory;
            if (newMerchantListAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                newMerchantListAdapter = newMerchantListAdapter5;
            }
            newMerchantListAdapter.getItems().addAll(shops);
            return;
        }
        List take = CollectionsKt.take(shops, 3);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
        Iterator it = take.iterator();
        while (it.hasNext()) {
            ((ShopModel) it.next()).initRecordTimeStamp = true;
            arrayList.add(Unit.INSTANCE);
        }
        NewMerchantListAdapter newMerchantListAdapter6 = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            newMerchantListAdapter = newMerchantListAdapter6;
        }
        newMerchantListAdapter.setItems(shops);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.contentEqualsIgnoreCaseImpl);
        if (recyclerView != null) {
            this.BuiltInFictitiousFunctionClassFactory = new NewMerchantListAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
            if (newMerchantListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                newMerchantListAdapter = null;
            }
            recyclerView.setAdapter(newMerchantListAdapter);
        }
    }

    public final void showEmptyState() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        NewMerchantListAdapter newMerchantListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (newMerchantListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantListAdapter = null;
        }
        newMerchantListAdapter.MyBillsEntityDataFactory();
        removeLoadMore();
    }
}
