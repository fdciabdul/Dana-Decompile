package id.dana.referral.referraltracker.viewholders;

import android.text.TextUtils;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.referral.referraltracker.model.ReferralSummaryDTOModel;

/* loaded from: classes9.dex */
public class ReferralTrackerEmptyViewHolder extends BaseRecyclerViewHolder<ReferralSummaryDTOModel> {
    @BindView(R.id.iv_referral_tracker_empty)
    ImageView ivReferralTrackerEmpty;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ReferralSummaryDTOModel referralSummaryDTOModel) {
        ReferralSummaryDTOModel referralSummaryDTOModel2 = referralSummaryDTOModel;
        if (TextUtils.isEmpty(referralSummaryDTOModel2.getAuthRequestContext)) {
            return;
        }
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(referralSummaryDTOModel2.getAuthRequestContext).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory(this.ivReferralTrackerEmpty);
    }
}
