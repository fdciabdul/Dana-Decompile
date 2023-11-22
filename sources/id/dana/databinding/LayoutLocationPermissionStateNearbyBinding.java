package id.dana.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class LayoutLocationPermissionStateNearbyBinding implements ViewBinding {
    public final RelativeLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final Button getAuthRequestContext;

    private LayoutLocationPermissionStateNearbyBinding(RelativeLayout relativeLayout, Button button, AppCompatImageView appCompatImageView, TextView textView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = relativeLayout;
        this.getAuthRequestContext = button;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = textView;
    }

    public static LayoutLocationPermissionStateNearbyBinding getAuthRequestContext(View view) {
        int i = R.id.btn_action_emptystate;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_action_emptystate);
        if (button != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_error_image);
            if (appCompatImageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4393tv_error_description);
                if (textView != null) {
                    return new LayoutLocationPermissionStateNearbyBinding((RelativeLayout) view, button, appCompatImageView, textView);
                }
                i = R.id.f4393tv_error_description;
            } else {
                i = R.id.iv_error_image;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
