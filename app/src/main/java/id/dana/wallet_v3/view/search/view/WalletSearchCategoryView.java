package id.dana.wallet_v3.view.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.flexbox.FlexboxLayoutManager;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewSearchCategoryBinding;
import id.dana.wallet_v3.listener.WalletSearchCategoryViewListener;
import id.dana.wallet_v3.view.search.adapter.ChipSearchCategoryAdapter;
import id.dana.wallet_v3.view.search.model.SearchCategoryModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b#\u0010$B+\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003¢\u0006\u0004\b#\u0010&J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001d"}, d2 = {"Lid/dana/wallet_v3/view/search/view/WalletSearchCategoryView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewSearchCategoryBinding;", "", "getLayout", "()I", "Lkotlin/Function1;", "Lid/dana/wallet_v3/view/search/model/SearchCategoryModel;", "", "getOnCLickListener", "()Lkotlin/jvm/functions/Function1;", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewSearchCategoryBinding;", "", "searchGeneralModel", "setCategoryItem", "(Ljava/util/List;)V", "Lid/dana/wallet_v3/listener/WalletSearchCategoryViewListener;", "walletSearchCategoryViewListener", "setWalletSearchCategoryViewListener", "(Lid/dana/wallet_v3/listener/WalletSearchCategoryViewListener;)V", "setup", "()V", "setupRecyclerView", "Lid/dana/wallet_v3/view/search/adapter/ChipSearchCategoryAdapter;", "chipSearchCategoryAdapter", "Lid/dana/wallet_v3/view/search/adapter/ChipSearchCategoryAdapter;", "Lid/dana/wallet_v3/listener/WalletSearchCategoryViewListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletSearchCategoryView extends ViewBindingRichView<ViewSearchCategoryBinding> {
    public Map<Integer, View> _$_findViewCache;
    private ChipSearchCategoryAdapter chipSearchCategoryAdapter;
    private WalletSearchCategoryViewListener walletSearchCategoryViewListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletSearchCategoryView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletSearchCategoryView(Context context, AttributeSet attributeSet) {
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
    public WalletSearchCategoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ WalletSearchCategoryView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletSearchCategoryView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewSearchCategoryBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewSearchCategoryBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewSearchCategoryBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        setupRecyclerView();
    }

    public final void setWalletSearchCategoryViewListener(WalletSearchCategoryViewListener walletSearchCategoryViewListener) {
        Intrinsics.checkNotNullParameter(walletSearchCategoryViewListener, "");
        this.walletSearchCategoryViewListener = walletSearchCategoryViewListener;
    }

    public final void setCategoryItem(List<SearchCategoryModel> searchGeneralModel) {
        Intrinsics.checkNotNullParameter(searchGeneralModel, "");
        ChipSearchCategoryAdapter chipSearchCategoryAdapter = this.chipSearchCategoryAdapter;
        if (chipSearchCategoryAdapter != null) {
            chipSearchCategoryAdapter.setItems(searchGeneralModel);
        }
        ChipSearchCategoryAdapter chipSearchCategoryAdapter2 = this.chipSearchCategoryAdapter;
        if (chipSearchCategoryAdapter2 != null) {
            chipSearchCategoryAdapter2.notifyDataSetChanged();
        }
    }

    private final void setupRecyclerView() {
        getBinding().PlaceComponentResult.setLayoutManager(new FlexboxLayoutManager(getContext(), 0));
        this.chipSearchCategoryAdapter = new ChipSearchCategoryAdapter(getOnCLickListener());
        getBinding().PlaceComponentResult.setAdapter(this.chipSearchCategoryAdapter);
    }

    private final Function1<SearchCategoryModel, Unit> getOnCLickListener() {
        return new Function1<SearchCategoryModel, Unit>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchCategoryView$getOnCLickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SearchCategoryModel searchCategoryModel) {
                invoke2(searchCategoryModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SearchCategoryModel searchCategoryModel) {
                WalletSearchCategoryViewListener walletSearchCategoryViewListener;
                Intrinsics.checkNotNullParameter(searchCategoryModel, "");
                walletSearchCategoryViewListener = WalletSearchCategoryView.this.walletSearchCategoryViewListener;
                if (walletSearchCategoryViewListener != null) {
                    walletSearchCategoryViewListener.onClickChipCategory(searchCategoryModel);
                }
            }
        };
    }
}
