package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes2.dex */
public final class ViewOneklikBcaBinding implements ViewBinding {
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ViewOneklikBcaBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ImageView imageView, TextView textView) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ViewOneklikBcaBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.DeviceLimitErrorKey;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.DeviceLimitErrorKey);
        if (appCompatImageView != null) {
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivPoweredBy);
            if (imageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvOneKlikHeader);
                if (textView != null) {
                    return new ViewOneklikBcaBinding((ConstraintLayout) view, appCompatImageView, imageView, textView);
                }
                i = R.id.tvOneKlikHeader;
            } else {
                i = R.id.ivPoweredBy;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
