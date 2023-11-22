package id.dana.richview.promoclaim;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class PromoClaimView_ViewBinding implements Unbinder {
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private PromoClaimView MyBillsEntityDataFactory;

    public PromoClaimView_ViewBinding(final PromoClaimView promoClaimView, View view) {
        this.MyBillsEntityDataFactory = promoClaimView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_container_leaderboard_entry, "field 'clContainer' and method 'onClick'");
        promoClaimView.clContainer = (ConstraintLayout) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.cl_container_leaderboard_entry, "field 'clContainer'", ConstraintLayout.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.promoclaim.PromoClaimView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                promoClaimView.onClick();
            }
        });
        promoClaimView.imageView = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_leaderboard_entry, "field 'imageView'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PromoClaimView promoClaimView = this.MyBillsEntityDataFactory;
        if (promoClaimView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        promoClaimView.clContainer = null;
        promoClaimView.imageView = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
