package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.animation.view.SavedCardIndicatorLottieAnimationView;

/* loaded from: classes4.dex */
public final class ViewHomeToolbarDanaPlusUnactiveBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final SavedCardIndicatorLottieAnimationView MyBillsEntityDataFactory;
    public final LinearLayout PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;

    private ViewHomeToolbarDanaPlusUnactiveBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, SavedCardIndicatorLottieAnimationView savedCardIndicatorLottieAnimationView, TextView textView) {
        this.getAuthRequestContext = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.PlaceComponentResult = linearLayout2;
        this.MyBillsEntityDataFactory = savedCardIndicatorLottieAnimationView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    public static ViewHomeToolbarDanaPlusUnactiveBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.iv_dana_plus_menu;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_dana_plus_menu);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_dana_plus_area_unactive);
            if (linearLayout != null) {
                SavedCardIndicatorLottieAnimationView savedCardIndicatorLottieAnimationView = (SavedCardIndicatorLottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.sci_dana_plus_unactive);
                if (savedCardIndicatorLottieAnimationView != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_dana_plus_message);
                    if (textView != null) {
                        return new ViewHomeToolbarDanaPlusUnactiveBinding((LinearLayout) view, imageView, linearLayout, savedCardIndicatorLottieAnimationView, textView);
                    }
                    i = R.id.tv_dana_plus_message;
                } else {
                    i = R.id.sci_dana_plus_unactive;
                }
            } else {
                i = R.id.ll_dana_plus_area_unactive;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
