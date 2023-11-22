package id.dana.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.globalsearch.basecategory.CategoryVerticalView;
import id.dana.globalsearch.view.widget.GlobalSearchErrorStateView;
import id.dana.richview.globalsearch.ToolbarGlobalSearchView;

/* loaded from: classes4.dex */
public final class FragmentSeeAllBinding implements ViewBinding {
    public final GlobalSearchErrorStateView BuiltInFictitiousFunctionClassFactory;
    public final ToolbarGlobalSearchView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CategoryVerticalView MyBillsEntityDataFactory;
    private final RelativeLayout getAuthRequestContext;

    private FragmentSeeAllBinding(RelativeLayout relativeLayout, CategoryVerticalView categoryVerticalView, ToolbarGlobalSearchView toolbarGlobalSearchView, GlobalSearchErrorStateView globalSearchErrorStateView) {
        this.getAuthRequestContext = relativeLayout;
        this.MyBillsEntityDataFactory = categoryVerticalView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = toolbarGlobalSearchView;
        this.BuiltInFictitiousFunctionClassFactory = globalSearchErrorStateView;
    }

    public static FragmentSeeAllBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.all_list;
        CategoryVerticalView categoryVerticalView = (CategoryVerticalView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.all_list);
        if (categoryVerticalView != null) {
            ToolbarGlobalSearchView toolbarGlobalSearchView = (ToolbarGlobalSearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tsvSeeAll);
            if (toolbarGlobalSearchView != null) {
                GlobalSearchErrorStateView globalSearchErrorStateView = (GlobalSearchErrorStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewErrorState);
                if (globalSearchErrorStateView != null) {
                    return new FragmentSeeAllBinding((RelativeLayout) view, categoryVerticalView, toolbarGlobalSearchView, globalSearchErrorStateView);
                }
                i = R.id.viewErrorState;
            } else {
                i = R.id.tsvSeeAll;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
