package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.globalsearch.basecategory.CategoryVerticalView;
import id.dana.globalsearch.view.sku.CategorySKUView;
import id.dana.globalsearch.view.widget.GlobalSearchErrorStateView;
import id.dana.richview.globalsearch.ToolbarGlobalSearchView;

/* loaded from: classes4.dex */
public final class FragmentGlobalSearchBinding implements ViewBinding {
    public final CategoryVerticalView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout DatabaseTableConfigUtil;
    public final CategoryVerticalView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CategorySKUView MyBillsEntityDataFactory;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final GlobalSearchErrorStateView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final CategoryVerticalView PlaceComponentResult;
    public final CategoryVerticalView getAuthRequestContext;
    public final ItemGlobalSearchLoadingBinding getErrorConfigVersion;
    public final NestedScrollView lookAheadTest;
    public final ToolbarGlobalSearchView moveToNextValue;
    public final ViewPopularRecentSearchBinding scheduleImpl;

    private FragmentGlobalSearchBinding(ConstraintLayout constraintLayout, CategorySKUView categorySKUView, CategoryVerticalView categoryVerticalView, CategoryVerticalView categoryVerticalView2, CategoryVerticalView categoryVerticalView3, CategoryVerticalView categoryVerticalView4, ViewPopularRecentSearchBinding viewPopularRecentSearchBinding, ItemGlobalSearchLoadingBinding itemGlobalSearchLoadingBinding, NestedScrollView nestedScrollView, RecyclerView recyclerView, ToolbarGlobalSearchView toolbarGlobalSearchView, GlobalSearchErrorStateView globalSearchErrorStateView) {
        this.DatabaseTableConfigUtil = constraintLayout;
        this.MyBillsEntityDataFactory = categorySKUView;
        this.getAuthRequestContext = categoryVerticalView;
        this.BuiltInFictitiousFunctionClassFactory = categoryVerticalView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = categoryVerticalView3;
        this.PlaceComponentResult = categoryVerticalView4;
        this.scheduleImpl = viewPopularRecentSearchBinding;
        this.getErrorConfigVersion = itemGlobalSearchLoadingBinding;
        this.lookAheadTest = nestedScrollView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerView;
        this.moveToNextValue = toolbarGlobalSearchView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = globalSearchErrorStateView;
    }

    public static FragmentGlobalSearchBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.category_dfsku;
        CategorySKUView categorySKUView = (CategorySKUView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.category_dfsku);
        if (categorySKUView != null) {
            CategoryVerticalView categoryVerticalView = (CategoryVerticalView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.category_offline_merchant);
            if (categoryVerticalView != null) {
                CategoryVerticalView categoryVerticalView2 = (CategoryVerticalView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.category_online_merchant);
                if (categoryVerticalView2 != null) {
                    CategoryVerticalView categoryVerticalView3 = (CategoryVerticalView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.category_restaurant);
                    if (categoryVerticalView3 != null) {
                        CategoryVerticalView categoryVerticalView4 = (CategoryVerticalView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.category_service);
                        if (categoryVerticalView4 != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.containerPopularRecent);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                ViewPopularRecentSearchBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewPopularRecentSearchBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.global_search_loading);
                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                    ItemGlobalSearchLoadingBinding authRequestContext = ItemGlobalSearchLoadingBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.nested_category);
                                    if (nestedScrollView != null) {
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_result_auto_complete);
                                        if (recyclerView != null) {
                                            ToolbarGlobalSearchView toolbarGlobalSearchView = (ToolbarGlobalSearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tsv_globalsearch);
                                            if (toolbarGlobalSearchView != null) {
                                                GlobalSearchErrorStateView globalSearchErrorStateView = (GlobalSearchErrorStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewErrorState);
                                                if (globalSearchErrorStateView != null) {
                                                    return new FragmentGlobalSearchBinding((ConstraintLayout) view, categorySKUView, categoryVerticalView, categoryVerticalView2, categoryVerticalView3, categoryVerticalView4, KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext, nestedScrollView, recyclerView, toolbarGlobalSearchView, globalSearchErrorStateView);
                                                }
                                                i = R.id.viewErrorState;
                                            } else {
                                                i = R.id.tsv_globalsearch;
                                            }
                                        } else {
                                            i = R.id.rv_result_auto_complete;
                                        }
                                    } else {
                                        i = R.id.nested_category;
                                    }
                                } else {
                                    i = R.id.global_search_loading;
                                }
                            } else {
                                i = R.id.containerPopularRecent;
                            }
                        } else {
                            i = R.id.category_service;
                        }
                    } else {
                        i = R.id.category_restaurant;
                    }
                } else {
                    i = R.id.category_online_merchant;
                }
            } else {
                i = R.id.category_offline_merchant;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.DatabaseTableConfigUtil;
    }
}
