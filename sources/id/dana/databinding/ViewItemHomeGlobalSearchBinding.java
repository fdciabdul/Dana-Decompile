package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.richview.globalsearch.ToolbarGlobalSearchView;

/* loaded from: classes2.dex */
public final class ViewItemHomeGlobalSearchBinding implements ViewBinding {
    public final ToolbarGlobalSearchView MyBillsEntityDataFactory;
    public final ToolbarGlobalSearchView getAuthRequestContext;

    private ViewItemHomeGlobalSearchBinding(ToolbarGlobalSearchView toolbarGlobalSearchView, ToolbarGlobalSearchView toolbarGlobalSearchView2) {
        this.MyBillsEntityDataFactory = toolbarGlobalSearchView;
        this.getAuthRequestContext = toolbarGlobalSearchView2;
    }

    public static ViewItemHomeGlobalSearchBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_home_global_search, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        ToolbarGlobalSearchView toolbarGlobalSearchView = (ToolbarGlobalSearchView) inflate;
        return new ViewItemHomeGlobalSearchBinding(toolbarGlobalSearchView, toolbarGlobalSearchView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
