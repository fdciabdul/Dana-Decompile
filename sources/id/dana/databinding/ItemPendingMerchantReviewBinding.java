package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.nearbyme.merchantreview.ViewRatingStarBar;

/* loaded from: classes4.dex */
public final class ItemPendingMerchantReviewBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final ViewRatingStarBar PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final View getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;

    private ItemPendingMerchantReviewBinding(ConstraintLayout constraintLayout, ImageView imageView, ViewRatingStarBar viewRatingStarBar, TextView textView, TextView textView2, TextView textView3, View view) {
        this.lookAheadTest = constraintLayout;
        this.MyBillsEntityDataFactory = imageView;
        this.PlaceComponentResult = viewRatingStarBar;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.getAuthRequestContext = textView2;
        this.BuiltInFictitiousFunctionClassFactory = textView3;
        this.getErrorConfigVersion = view;
    }

    public static ItemPendingMerchantReviewBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.ivShopLogo;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivShopLogo);
        if (imageView != null) {
            ViewRatingStarBar viewRatingStarBar = (ViewRatingStarBar) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4084res_0x7f0a1017_access_createsegment);
            if (viewRatingStarBar != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvDate);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.isHelperTextDisplayed);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.RecentRecipientEntityRepository);
                        if (textView3 != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4551res_0x7f0a19ae_tomillis_feature_cashier_productionrelease);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                return new ItemPendingMerchantReviewBinding((ConstraintLayout) view, imageView, viewRatingStarBar, textView, textView2, textView3, BuiltInFictitiousFunctionClassFactory);
                            }
                            i = R.id.f4551res_0x7f0a19ae_tomillis_feature_cashier_productionrelease;
                        } else {
                            i = R.id.RecentRecipientEntityRepository;
                        }
                    } else {
                        i = R.id.isHelperTextDisplayed;
                    }
                } else {
                    i = R.id.tvDate;
                }
            } else {
                i = R.id.f4084res_0x7f0a1017_access_createsegment;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
