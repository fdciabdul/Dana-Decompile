package id.dana.referral.referraltracker.viewholders;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ReferralTrackerEmptyViewHolder_ViewBinding implements Unbinder {
    private ReferralTrackerEmptyViewHolder MyBillsEntityDataFactory;

    public ReferralTrackerEmptyViewHolder_ViewBinding(ReferralTrackerEmptyViewHolder referralTrackerEmptyViewHolder, View view) {
        this.MyBillsEntityDataFactory = referralTrackerEmptyViewHolder;
        referralTrackerEmptyViewHolder.ivReferralTrackerEmpty = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_referral_tracker_empty, "field 'ivReferralTrackerEmpty'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ReferralTrackerEmptyViewHolder referralTrackerEmptyViewHolder = this.MyBillsEntityDataFactory;
        if (referralTrackerEmptyViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        referralTrackerEmptyViewHolder.ivReferralTrackerEmpty = null;
    }
}
