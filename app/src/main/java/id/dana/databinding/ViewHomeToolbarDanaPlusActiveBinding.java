package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.animation.view.SavedCardIndicatorLottieAnimationView;

/* loaded from: classes4.dex */
public final class ViewHomeToolbarDanaPlusActiveBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LinearLayout PlaceComponentResult;
    public final FrameLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final SavedCardIndicatorLottieAnimationView scheduleImpl;

    private ViewHomeToolbarDanaPlusActiveBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, SavedCardIndicatorLottieAnimationView savedCardIndicatorLottieAnimationView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.MyBillsEntityDataFactory = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.PlaceComponentResult = linearLayout2;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.getAuthRequestContext = frameLayout2;
        this.scheduleImpl = savedCardIndicatorLottieAnimationView;
        this.getErrorConfigVersion = textView;
        this.lookAheadTest = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView3;
        this.moveToNextValue = textView4;
    }

    public static ViewHomeToolbarDanaPlusActiveBinding PlaceComponentResult(View view) {
        int i = R.id.iv_dana_plus_menu;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_dana_plus_menu);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_dana_plus_area_active);
            if (linearLayout != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_dana_plus_balance_content);
                if (frameLayout != null) {
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_dana_plus_gain_content);
                    if (frameLayout2 != null) {
                        SavedCardIndicatorLottieAnimationView savedCardIndicatorLottieAnimationView = (SavedCardIndicatorLottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.sci_dana_plus_active);
                        if (savedCardIndicatorLottieAnimationView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_dana_plus_balance);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_dana_plus_gain);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_dana_plus_hidden_pay_content);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_dana_plus_title_rp);
                                        if (textView4 != null) {
                                            return new ViewHomeToolbarDanaPlusActiveBinding((LinearLayout) view, imageView, linearLayout, frameLayout, frameLayout2, savedCardIndicatorLottieAnimationView, textView, textView2, textView3, textView4);
                                        }
                                        i = R.id.tv_dana_plus_title_rp;
                                    } else {
                                        i = R.id.tv_dana_plus_hidden_pay_content;
                                    }
                                } else {
                                    i = R.id.tv_dana_plus_gain;
                                }
                            } else {
                                i = R.id.tv_dana_plus_balance;
                            }
                        } else {
                            i = R.id.sci_dana_plus_active;
                        }
                    } else {
                        i = R.id.ll_dana_plus_gain_content;
                    }
                } else {
                    i = R.id.ll_dana_plus_balance_content;
                }
            } else {
                i = R.id.ll_dana_plus_area_active;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
