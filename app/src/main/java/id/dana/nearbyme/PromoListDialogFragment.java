package id.dana.nearbyme;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.nearbyme.adapter.NearbyPromoAdapter;
import id.dana.nearbyme.model.PromoInfoModel;
import java.util.List;

/* loaded from: classes5.dex */
public class PromoListDialogFragment extends BaseBottomSheetDialogFragment {
    public List<PromoInfoModel> KClassImpl$Data$declaredNonStaticMembers$2;
    @BindView(R.id.f3981layout_coordinator)
    ViewGroup coordinatorLayout;
    @BindView(R.id.RecurringAnnouncementEntity)
    ImageView ivClose;
    @BindView(R.id.rv_nearby_promo)
    RecyclerView rvNearbyPromo;
    private Context scheduleImpl;

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public /* bridge */ /* synthetic */ View getPlaceComponentResult() {
        return null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public int getLayout() {
        return R.layout.view_coordinator_nearby_promo;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public boolean isFullDialogHeightRequired() {
        return false;
    }

    public PromoListDialogFragment(Context context) {
        this.scheduleImpl = context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        initMatchParentDialog(dialog);
        initTransparentDialogDim(dialog);
        this.ivClose.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.PromoListDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromoListDialogFragment.this.dismiss();
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public void onShow() {
        super.onShow();
        NearbyPromoAdapter nearbyPromoAdapter = new NearbyPromoAdapter();
        this.rvNearbyPromo.setLayoutManager(new LinearLayoutManager(this.scheduleImpl));
        this.rvNearbyPromo.setAdapter(nearbyPromoAdapter);
        this.rvNearbyPromo.setHasFixedSize(true);
        nearbyPromoAdapter.setItems(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
