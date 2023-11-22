package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemSocialLinkBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;

    private ItemSocialLinkBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView2;
    }

    public static ItemSocialLinkBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.ivIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIcon);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvSubtitle);
            if (appCompatTextView != null) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                if (appCompatTextView2 != null) {
                    return new ItemSocialLinkBinding((ConstraintLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2);
                }
                i = R.id.tvTitle;
            } else {
                i = R.id.tvSubtitle;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
