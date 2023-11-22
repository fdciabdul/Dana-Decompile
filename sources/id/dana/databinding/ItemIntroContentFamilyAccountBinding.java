package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemIntroContentFamilyAccountBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView PlaceComponentResult;
    public final LottieAnimationView getAuthRequestContext;

    private ItemIntroContentFamilyAccountBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.getAuthRequestContext = lottieAnimationView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.PlaceComponentResult = textView2;
    }

    public static ItemIntroContentFamilyAccountBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_intro_content_family_account, viewGroup, false);
        int i = R.id.lvContent;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.lvContent);
        if (lottieAnimationView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDescContent);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitleContent);
                if (textView2 != null) {
                    return new ItemIntroContentFamilyAccountBinding((ConstraintLayout) inflate, lottieAnimationView, textView, textView2);
                }
                i = R.id.tvTitleContent;
            } else {
                i = R.id.tvDescContent;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
