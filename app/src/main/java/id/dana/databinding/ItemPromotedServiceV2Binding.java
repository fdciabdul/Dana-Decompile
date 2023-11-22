package id.dana.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.richview.EllipseTextView;

/* loaded from: classes4.dex */
public final class ItemPromotedServiceV2Binding implements ViewBinding {
    public final Button BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final EllipseTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LinearLayout PlaceComponentResult;
    public final LottieAnimationView getAuthRequestContext;
    public final ImageView getErrorConfigVersion;
    public final TextView lookAheadTest;
    private final LinearLayout moveToNextValue;

    private ItemPromotedServiceV2Binding(LinearLayout linearLayout, Button button, ImageView imageView, LinearLayout linearLayout2, ImageView imageView2, LottieAnimationView lottieAnimationView, TextView textView, EllipseTextView ellipseTextView, ImageView imageView3) {
        this.moveToNextValue = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = button;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.PlaceComponentResult = linearLayout2;
        this.MyBillsEntityDataFactory = imageView2;
        this.getAuthRequestContext = lottieAnimationView;
        this.lookAheadTest = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ellipseTextView;
        this.getErrorConfigVersion = imageView3;
    }

    public static ItemPromotedServiceV2Binding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.btn_service_action;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_service_action);
        if (button != null) {
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_shimmer_view);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_promoted_service);
                if (imageView2 != null) {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.lottie_promoted_service);
                    if (lottieAnimationView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_promoted_service_header);
                        if (textView != null) {
                            EllipseTextView ellipseTextView = (EllipseTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_promoted_service_sub_header);
                            if (ellipseTextView != null) {
                                ImageView imageView3 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_promoted_service_sub_header_shimmer_view);
                                if (imageView3 != null) {
                                    return new ItemPromotedServiceV2Binding(linearLayout, button, imageView, linearLayout, imageView2, lottieAnimationView, textView, ellipseTextView, imageView3);
                                }
                                i = R.id.tv_promoted_service_sub_header_shimmer_view;
                            } else {
                                i = R.id.tv_promoted_service_sub_header;
                            }
                        } else {
                            i = R.id.tv_promoted_service_header;
                        }
                    } else {
                        i = R.id.lottie_promoted_service;
                    }
                } else {
                    i = R.id.iv_promoted_service;
                }
            } else {
                i = R.id.btn_shimmer_view;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
