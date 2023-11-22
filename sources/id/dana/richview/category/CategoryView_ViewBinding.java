package id.dana.richview.category;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class CategoryView_ViewBinding implements Unbinder {
    private CategoryView BuiltInFictitiousFunctionClassFactory;

    public CategoryView_ViewBinding(CategoryView categoryView, View view) {
        this.BuiltInFictitiousFunctionClassFactory = categoryView;
        categoryView.llCategory = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4003res_0x7f0a0d8c_pagingdatatransforms_insertseparators_1, "field 'llCategory'", LinearLayout.class);
        categoryView.rvCategory = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4138res_0x7f0a1144_rxconvertkt_ascompletable_1, "field 'rvCategory'", RecyclerView.class);
        categoryView.viewDivider = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_divider, "field 'viewDivider'");
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        CategoryView categoryView = this.BuiltInFictitiousFunctionClassFactory;
        if (categoryView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        categoryView.llCategory = null;
        categoryView.rvCategory = null;
        categoryView.viewDivider = null;
    }
}
