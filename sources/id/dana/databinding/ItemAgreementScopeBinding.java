package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemAgreementScopeBinding implements ViewBinding {
    private final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView getAuthRequestContext;

    private ItemAgreementScopeBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatTextView;
    }

    public static ItemAgreementScopeBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.iv_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_icon);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_description);
            if (appCompatTextView != null) {
                return new ItemAgreementScopeBinding((LinearLayout) view, appCompatImageView, appCompatTextView);
            }
            i = R.id.tv_description;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
