package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewHomeToolbarMenuBinding implements ViewBinding {
    public final ViewHomeToolbarDanaBalanceBinding BuiltInFictitiousFunctionClassFactory;
    public final ViewHomeToolbarDanaPlusActiveBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final RelativeLayout PlaceComponentResult;
    public final RelativeLayout getAuthRequestContext;
    public final ViewHomeToolbarDanaPlusUnactiveBinding getErrorConfigVersion;

    private ViewHomeToolbarMenuBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, ViewHomeToolbarDanaBalanceBinding viewHomeToolbarDanaBalanceBinding, ViewHomeToolbarDanaPlusActiveBinding viewHomeToolbarDanaPlusActiveBinding, ViewHomeToolbarDanaPlusUnactiveBinding viewHomeToolbarDanaPlusUnactiveBinding) {
        this.PlaceComponentResult = relativeLayout;
        this.getAuthRequestContext = relativeLayout2;
        this.MyBillsEntityDataFactory = imageView;
        this.BuiltInFictitiousFunctionClassFactory = viewHomeToolbarDanaBalanceBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewHomeToolbarDanaPlusActiveBinding;
        this.getErrorConfigVersion = viewHomeToolbarDanaPlusUnactiveBinding;
    }

    public static ViewHomeToolbarMenuBinding MyBillsEntityDataFactory(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.menubar_inbox;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.menubar_inbox);
        if (imageView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_dana_balance);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                ViewHomeToolbarDanaBalanceBinding BuiltInFictitiousFunctionClassFactory2 = ViewHomeToolbarDanaBalanceBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_dana_plus_active);
                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                    ViewHomeToolbarDanaPlusActiveBinding PlaceComponentResult = ViewHomeToolbarDanaPlusActiveBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory3);
                    View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_dana_plus_unactive);
                    if (BuiltInFictitiousFunctionClassFactory4 != null) {
                        return new ViewHomeToolbarMenuBinding(relativeLayout, relativeLayout, imageView, BuiltInFictitiousFunctionClassFactory2, PlaceComponentResult, ViewHomeToolbarDanaPlusUnactiveBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory4));
                    }
                    i = R.id.view_dana_plus_unactive;
                } else {
                    i = R.id.view_dana_plus_active;
                }
            } else {
                i = R.id.view_dana_balance;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
