package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewHomeToolbarDanaBalanceBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final LinearLayout PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewHomeToolbarDanaBalanceBinding(LinearLayout linearLayout, ImageView imageView, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.PlaceComponentResult = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.MyBillsEntityDataFactory = textView;
        this.getAuthRequestContext = textView2;
    }

    public static ViewHomeToolbarDanaBalanceBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.iv_dana_menu;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_dana_menu);
        if (imageView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_eye_button);
            if (appCompatImageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_balance);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_rp);
                    if (textView2 != null) {
                        return new ViewHomeToolbarDanaBalanceBinding((LinearLayout) view, imageView, appCompatImageView, textView, textView2);
                    }
                    i = R.id.tv_title_rp;
                } else {
                    i = R.id.tv_balance;
                }
            } else {
                i = R.id.iv_eye_button;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
