package id.dana.referral.referraltracker.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ReferralTrackerItemsViewHolder_ViewBinding implements Unbinder {
    private ReferralTrackerItemsViewHolder getAuthRequestContext;

    public ReferralTrackerItemsViewHolder_ViewBinding(ReferralTrackerItemsViewHolder referralTrackerItemsViewHolder, View view) {
        this.getAuthRequestContext = referralTrackerItemsViewHolder;
        referralTrackerItemsViewHolder.ivReferralTrackerActive = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_referral_tracker_active, "field 'ivReferralTrackerActive'", ImageView.class);
        referralTrackerItemsViewHolder.ivReferralTrackerRegister = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_referral_tracker_register, "field 'ivReferralTrackerRegister'", ImageView.class);
        referralTrackerItemsViewHolder.ivReferralTrackerReward = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_referral_tracker_reward, "field 'ivReferralTrackerReward'", ImageView.class);
        referralTrackerItemsViewHolder.tvReferralTrackerActive = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_referral_tracker_active, "field 'tvReferralTrackerActive'", TextView.class);
        referralTrackerItemsViewHolder.tvReferralTrackerNickname = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_referral_tracker_nickname, "field 'tvReferralTrackerNickname'", TextView.class);
        referralTrackerItemsViewHolder.tvReferralTrackerPhoneNumber = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_referral_tracker_phone_number, "field 'tvReferralTrackerPhoneNumber'", TextView.class);
        referralTrackerItemsViewHolder.tvReferralTrackerRegister = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_referral_tracker_register, "field 'tvReferralTrackerRegister'", TextView.class);
        referralTrackerItemsViewHolder.tvReferralTrackerReward = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_referral_tracker_reward, "field 'tvReferralTrackerReward'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ReferralTrackerItemsViewHolder referralTrackerItemsViewHolder = this.getAuthRequestContext;
        if (referralTrackerItemsViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        referralTrackerItemsViewHolder.ivReferralTrackerActive = null;
        referralTrackerItemsViewHolder.ivReferralTrackerRegister = null;
        referralTrackerItemsViewHolder.ivReferralTrackerReward = null;
        referralTrackerItemsViewHolder.tvReferralTrackerActive = null;
        referralTrackerItemsViewHolder.tvReferralTrackerNickname = null;
        referralTrackerItemsViewHolder.tvReferralTrackerPhoneNumber = null;
        referralTrackerItemsViewHolder.tvReferralTrackerRegister = null;
        referralTrackerItemsViewHolder.tvReferralTrackerReward = null;
    }
}
