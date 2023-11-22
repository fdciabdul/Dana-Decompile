package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.wallet_v3.view.search.view.DoneSearchWalletView;
import id.dana.wallet_v3.view.search.view.WalletSearchCategoryView;
import id.dana.wallet_v3.view.search.view.WalletV3SearchView;

/* loaded from: classes4.dex */
public final class FragmentWalletSearchBinding implements ViewBinding {
    public final DoneSearchWalletView BuiltInFictitiousFunctionClassFactory;
    public final WalletSearchCategoryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final ViewInitialSearchWalletV3Binding NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final RecyclerView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    private final FrameLayout getErrorConfigVersion;
    public final WalletV3SearchView lookAheadTest;

    private FragmentWalletSearchBinding(FrameLayout frameLayout, AppCompatTextView appCompatTextView, DoneSearchWalletView doneSearchWalletView, RecyclerView recyclerView, WalletSearchCategoryView walletSearchCategoryView, AppCompatImageView appCompatImageView, ViewInitialSearchWalletV3Binding viewInitialSearchWalletV3Binding, WalletV3SearchView walletV3SearchView) {
        this.getErrorConfigVersion = frameLayout;
        this.getAuthRequestContext = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = doneSearchWalletView;
        this.PlaceComponentResult = recyclerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = walletSearchCategoryView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewInitialSearchWalletV3Binding;
        this.lookAheadTest = walletV3SearchView;
    }

    public static FragmentWalletSearchBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.btn_cancel;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_cancel);
        if (appCompatTextView != null) {
            DoneSearchWalletView doneSearchWalletView = (DoneSearchWalletView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_done);
            if (doneSearchWalletView != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_search_result);
                if (recyclerView != null) {
                    WalletSearchCategoryView walletSearchCategoryView = (WalletSearchCategoryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4181scv_categories);
                    if (walletSearchCategoryView != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tab_icon);
                        if (appCompatImageView != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_init_search);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                ViewInitialSearchWalletV3Binding authRequestContext = ViewInitialSearchWalletV3Binding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                                WalletV3SearchView walletV3SearchView = (WalletV3SearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.wallet_search_view);
                                if (walletV3SearchView != null) {
                                    return new FragmentWalletSearchBinding((FrameLayout) view, appCompatTextView, doneSearchWalletView, recyclerView, walletSearchCategoryView, appCompatImageView, authRequestContext, walletV3SearchView);
                                }
                                i = R.id.wallet_search_view;
                            } else {
                                i = R.id.view_init_search;
                            }
                        } else {
                            i = R.id.tab_icon;
                        }
                    } else {
                        i = R.id.f4181scv_categories;
                    }
                } else {
                    i = R.id.rv_search_result;
                }
            } else {
                i = R.id.btn_done;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
