package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class LayoutAddBankBannerBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final MaterialCardView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    private final MaterialCardView PlaceComponentResult;

    private LayoutAddBankBannerBinding(MaterialCardView materialCardView, ConstraintLayout constraintLayout, MaterialCardView materialCardView2, AppCompatImageView appCompatImageView) {
        this.PlaceComponentResult = materialCardView;
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = materialCardView2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
    }

    public static LayoutAddBankBannerBinding getAuthRequestContext(View view) {
        int i = R.id.cv_add_bank_account_banner;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cv_add_bank_account_banner);
        if (constraintLayout != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivBg);
            if (appCompatImageView != null) {
                return new LayoutAddBankBannerBinding(materialCardView, constraintLayout, materialCardView, appCompatImageView);
            }
            i = R.id.ivBg;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
