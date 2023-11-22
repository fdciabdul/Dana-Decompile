package id.dana.wallet_v3.view.sort.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.flexbox.FlexboxLayoutManager;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewSortCategoryBinding;
import id.dana.wallet_v3.view.sort.adapter.ChipSortCategoryAdapter;
import id.dana.wallet_v3.view.sort.model.SortCategoryModel;
import id.dana.wallet_v3.view.sort.view.WalletSortCategoryView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B'\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0003¢\u0006\u0004\b'\u0010(B+\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003¢\u0006\u0004\b'\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u0017R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010!"}, d2 = {"Lid/dana/wallet_v3/view/sort/view/WalletSortCategoryView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewSortCategoryBinding;", "", "getLayout", "()I", "Lkotlin/Function2;", "Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "", "getOnCLickListener", "()Lkotlin/jvm/functions/Function2;", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewSortCategoryBinding;", "", "searchGeneralModel", "setCategoryItem", "(Ljava/util/List;)V", "position", "setLastSelectedCategory", "(I)V", "setSelectedCategoryToDefault", "()V", "Lid/dana/wallet_v3/view/sort/view/WalletSortCategoryView$WalletSortCategoryViewListener;", "walletSortCategoryViewListener", "setWalletSortCategoryViewListener", "(Lid/dana/wallet_v3/view/sort/view/WalletSortCategoryView$WalletSortCategoryViewListener;)V", "setup", "setupRecyclerView", "Lid/dana/wallet_v3/view/sort/adapter/ChipSortCategoryAdapter;", "chipSortCategoryAdapter", "Lid/dana/wallet_v3/view/sort/adapter/ChipSortCategoryAdapter;", "Lid/dana/wallet_v3/view/sort/view/WalletSortCategoryView$WalletSortCategoryViewListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "WalletSortCategoryViewListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletSortCategoryView extends ViewBindingRichView<ViewSortCategoryBinding> {
    public Map<Integer, View> _$_findViewCache;
    private ChipSortCategoryAdapter chipSortCategoryAdapter;
    private WalletSortCategoryViewListener walletSortCategoryViewListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/sort/view/WalletSortCategoryView$WalletSortCategoryViewListener;", "", "Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "sortCategoryModel", "", "position", "", "onClickChipCategory", "(Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface WalletSortCategoryViewListener {
        void onClickChipCategory(SortCategoryModel sortCategoryModel, int position);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletSortCategoryView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletSortCategoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_search_category;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletSortCategoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ WalletSortCategoryView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletSortCategoryView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewSortCategoryBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewSortCategoryBinding PlaceComponentResult = ViewSortCategoryBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        setupRecyclerView();
    }

    public final void setWalletSortCategoryViewListener(WalletSortCategoryViewListener walletSortCategoryViewListener) {
        Intrinsics.checkNotNullParameter(walletSortCategoryViewListener, "");
        this.walletSortCategoryViewListener = walletSortCategoryViewListener;
    }

    public final void setCategoryItem(List<SortCategoryModel> searchGeneralModel) {
        Intrinsics.checkNotNullParameter(searchGeneralModel, "");
        ChipSortCategoryAdapter chipSortCategoryAdapter = this.chipSortCategoryAdapter;
        if (chipSortCategoryAdapter != null) {
            chipSortCategoryAdapter.setItems(searchGeneralModel);
        }
        ChipSortCategoryAdapter chipSortCategoryAdapter2 = this.chipSortCategoryAdapter;
        if (chipSortCategoryAdapter2 != null) {
            chipSortCategoryAdapter2.notifyDataSetChanged();
        }
    }

    public final void setSelectedCategoryToDefault() {
        ChipSortCategoryAdapter chipSortCategoryAdapter = this.chipSortCategoryAdapter;
        if (chipSortCategoryAdapter != null) {
            chipSortCategoryAdapter.setSelected(0);
        }
    }

    public final void setLastSelectedCategory(int position) {
        ChipSortCategoryAdapter chipSortCategoryAdapter = this.chipSortCategoryAdapter;
        if (chipSortCategoryAdapter != null) {
            chipSortCategoryAdapter.setSelected(position);
        }
    }

    private final void setupRecyclerView() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setLayoutManager(new FlexboxLayoutManager(getContext(), 0));
        this.chipSortCategoryAdapter = new ChipSortCategoryAdapter(getOnCLickListener());
        getBinding().BuiltInFictitiousFunctionClassFactory.setAdapter(this.chipSortCategoryAdapter);
    }

    private final Function2<SortCategoryModel, Integer, Unit> getOnCLickListener() {
        return new Function2<SortCategoryModel, Integer, Unit>() { // from class: id.dana.wallet_v3.view.sort.view.WalletSortCategoryView$getOnCLickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(SortCategoryModel sortCategoryModel, Integer num) {
                invoke(sortCategoryModel, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SortCategoryModel sortCategoryModel, int i) {
                WalletSortCategoryView.WalletSortCategoryViewListener walletSortCategoryViewListener;
                ChipSortCategoryAdapter chipSortCategoryAdapter;
                Intrinsics.checkNotNullParameter(sortCategoryModel, "");
                walletSortCategoryViewListener = WalletSortCategoryView.this.walletSortCategoryViewListener;
                if (walletSortCategoryViewListener != null) {
                    walletSortCategoryViewListener.onClickChipCategory(sortCategoryModel, i);
                }
                chipSortCategoryAdapter = WalletSortCategoryView.this.chipSortCategoryAdapter;
                if (chipSortCategoryAdapter != null) {
                    chipSortCategoryAdapter.setSelected(i);
                }
            }
        };
    }
}
