package id.dana.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemGlobalSearchLoadingBinding implements ViewBinding {
    public final RelativeLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatImageView getAuthRequestContext;

    private ItemGlobalSearchLoadingBinding(RelativeLayout relativeLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
        this.BuiltInFictitiousFunctionClassFactory = relativeLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
    }

    public static ItemGlobalSearchLoadingBinding getAuthRequestContext(View view) {
        int i = R.id.ic_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ic_image);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ic_image_fg);
            if (appCompatImageView2 != null) {
                return new ItemGlobalSearchLoadingBinding((RelativeLayout) view, appCompatImageView, appCompatImageView2);
            }
            i = R.id.ic_image_fg;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
