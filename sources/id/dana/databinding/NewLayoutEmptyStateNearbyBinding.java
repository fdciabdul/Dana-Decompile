package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class NewLayoutEmptyStateNearbyBinding implements ViewBinding {
    public final TextView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;

    private NewLayoutEmptyStateNearbyBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView) {
        this.getAuthRequestContext = linearLayout;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = textView;
    }

    public static NewLayoutEmptyStateNearbyBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.iv_error_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_error_image);
        if (appCompatImageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4393tv_error_description);
            if (textView != null) {
                return new NewLayoutEmptyStateNearbyBinding((LinearLayout) view, appCompatImageView, textView);
            }
            i = R.id.f4393tv_error_description;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
