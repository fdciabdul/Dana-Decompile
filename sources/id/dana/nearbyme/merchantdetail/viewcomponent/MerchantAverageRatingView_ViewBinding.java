package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class MerchantAverageRatingView_ViewBinding implements Unbinder {
    private MerchantAverageRatingView KClassImpl$Data$declaredNonStaticMembers$2;
    private View getAuthRequestContext;

    public MerchantAverageRatingView_ViewBinding(final MerchantAverageRatingView merchantAverageRatingView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantAverageRatingView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f4500tv_see_all_rating, "method 'onClick'");
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                merchantAverageRatingView.onClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
