package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemWalletNoResultBinding implements ViewBinding {
    private final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;

    private ItemWalletNoResultBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = appCompatTextView;
        this.getAuthRequestContext = appCompatTextView2;
    }

    public static ItemWalletNoResultBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.getCustomAttributesOrThrow;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.getCustomAttributesOrThrow);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_desc_empty_state);
            if (appCompatTextView != null) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4519xde312118);
                if (appCompatTextView2 != null) {
                    return new ItemWalletNoResultBinding((LinearLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2);
                }
                i = R.id.f4519xde312118;
            } else {
                i = R.id.tv_desc_empty_state;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
