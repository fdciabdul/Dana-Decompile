package id.dana.nearbyme;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class PromoListDialogFragment_ViewBinding implements Unbinder {
    private PromoListDialogFragment KClassImpl$Data$declaredNonStaticMembers$2;

    public PromoListDialogFragment_ViewBinding(PromoListDialogFragment promoListDialogFragment, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoListDialogFragment;
        promoListDialogFragment.coordinatorLayout = (ViewGroup) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3981layout_coordinator, "field 'coordinatorLayout'", ViewGroup.class);
        promoListDialogFragment.rvNearbyPromo = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_nearby_promo, "field 'rvNearbyPromo'", RecyclerView.class);
        promoListDialogFragment.ivClose = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.RecurringAnnouncementEntity, "field 'ivClose'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PromoListDialogFragment promoListDialogFragment = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (promoListDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        promoListDialogFragment.coordinatorLayout = null;
        promoListDialogFragment.rvNearbyPromo = null;
        promoListDialogFragment.ivClose = null;
    }
}
