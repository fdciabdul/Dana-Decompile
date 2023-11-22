package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewSendToLinkBannerBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    private final MaterialCardView PlaceComponentResult;

    private ViewSendToLinkBannerBinding(MaterialCardView materialCardView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.PlaceComponentResult = materialCardView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView2;
    }

    public static ViewSendToLinkBannerBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.ivBannerIllustration;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivBannerIllustration);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvBannerDesc);
            if (appCompatTextView != null) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvBannerTitle);
                if (appCompatTextView2 != null) {
                    return new ViewSendToLinkBannerBinding((MaterialCardView) view, appCompatImageView, appCompatTextView, appCompatTextView2);
                }
                i = R.id.tvBannerTitle;
            } else {
                i = R.id.tvBannerDesc;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
