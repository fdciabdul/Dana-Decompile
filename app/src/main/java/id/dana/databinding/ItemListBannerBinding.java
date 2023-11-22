package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemListBannerBinding implements ViewBinding {
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;

    private ItemListBannerBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.MyBillsEntityDataFactory = imageView;
    }

    public static ItemListBannerBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.promotion_image);
        if (imageView != null) {
            return new ItemListBannerBinding(constraintLayout, constraintLayout, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.promotion_image)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
