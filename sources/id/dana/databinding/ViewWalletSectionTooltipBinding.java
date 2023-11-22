package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewWalletSectionTooltipBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ViewWalletSectionTooltipBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.scheduleImpl = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
    }

    public static ViewWalletSectionTooltipBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.cl_section_tooltip_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_section_tooltip_content);
        if (constraintLayout != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_section_tooltip);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_tooltip_close);
                if (appCompatImageView2 != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_section_tooltip_desc);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_section_tooltip_title);
                        if (appCompatTextView2 != null) {
                            return new ViewWalletSectionTooltipBinding((ConstraintLayout) view, constraintLayout, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2);
                        }
                        i = R.id.tv_section_tooltip_title;
                    } else {
                        i = R.id.tv_section_tooltip_desc;
                    }
                } else {
                    i = R.id.iv_tooltip_close;
                }
            } else {
                i = R.id.iv_section_tooltip;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
