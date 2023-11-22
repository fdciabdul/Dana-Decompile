package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class ActivityInterstitialBannerBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final LogoProgressView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ImageView PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;

    private ActivityInterstitialBannerBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout2, LogoProgressView logoProgressView, TextView textView) {
        this.lookAheadTest = constraintLayout;
        this.PlaceComponentResult = imageView;
        this.getAuthRequestContext = imageView2;
        this.MyBillsEntityDataFactory = imageView3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView4;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = logoProgressView;
        this.getErrorConfigVersion = textView;
    }

    public static ActivityInterstitialBannerBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_interstitial_banner, (ViewGroup) null, false);
        int i = R.id.banner_image;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.banner_image);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.banner_outline);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.bgClose);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.forEach);
                    if (imageView4 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                        LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4081progress_view);
                        if (logoProgressView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_loading_banner);
                            if (textView != null) {
                                return new ActivityInterstitialBannerBinding(constraintLayout, imageView, imageView2, imageView3, imageView4, constraintLayout, logoProgressView, textView);
                            }
                            i = R.id.tv_loading_banner;
                        } else {
                            i = R.id.f4081progress_view;
                        }
                    } else {
                        i = R.id.forEach;
                    }
                } else {
                    i = R.id.bgClose;
                }
            } else {
                i = R.id.banner_outline;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
