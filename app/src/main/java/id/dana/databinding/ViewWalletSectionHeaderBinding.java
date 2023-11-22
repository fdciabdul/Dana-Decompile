package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewWalletSectionHeaderBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView getAuthRequestContext;

    private ViewWalletSectionHeaderBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.getAuthRequestContext = appCompatTextView2;
    }

    public static ViewWalletSectionHeaderBinding PlaceComponentResult(View view) {
        int i = R.id.res_0x7f0a0c00_bottomsheetcardbindingview_watchercardnumberview_1;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0c00_bottomsheetcardbindingview_watchercardnumberview_1);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_section_title);
            if (appCompatTextView != null) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_section_total_asset);
                if (appCompatTextView2 != null) {
                    return new ViewWalletSectionHeaderBinding((ConstraintLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2);
                }
                i = R.id.tv_section_total_asset;
            } else {
                i = R.id.tv_section_title;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
