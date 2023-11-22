package id.dana.referral.referraltracker.viewholders;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.referral.referraltracker.model.ReferralSummaryDTOModel;

/* loaded from: classes9.dex */
public class ReferralTrackerItemsViewHolder extends BaseRecyclerViewHolder<ReferralSummaryDTOModel> {
    private Context KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    @BindView(R.id.iv_referral_tracker_active)
    ImageView ivReferralTrackerActive;
    @BindView(R.id.iv_referral_tracker_register)
    ImageView ivReferralTrackerRegister;
    @BindView(R.id.iv_referral_tracker_reward)
    ImageView ivReferralTrackerReward;
    @BindView(R.id.tv_referral_tracker_active)
    TextView tvReferralTrackerActive;
    @BindView(R.id.tv_referral_tracker_nickname)
    TextView tvReferralTrackerNickname;
    @BindView(R.id.tv_referral_tracker_phone_number)
    TextView tvReferralTrackerPhoneNumber;
    @BindView(R.id.tv_referral_tracker_register)
    TextView tvReferralTrackerRegister;
    @BindView(R.id.tv_referral_tracker_reward)
    TextView tvReferralTrackerReward;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ReferralSummaryDTOModel referralSummaryDTOModel) {
        ReferralSummaryDTOModel referralSummaryDTOModel2 = referralSummaryDTOModel;
        this.MyBillsEntityDataFactory = "";
        if (referralSummaryDTOModel2 != null) {
            if (TextUtils.isEmpty(referralSummaryDTOModel2.MyBillsEntityDataFactory)) {
                this.tvReferralTrackerNickname.setText(referralSummaryDTOModel2.BuiltInFictitiousFunctionClassFactory);
                this.tvReferralTrackerPhoneNumber.setText("");
            } else {
                this.tvReferralTrackerNickname.setText(referralSummaryDTOModel2.MyBillsEntityDataFactory);
                this.tvReferralTrackerPhoneNumber.setText(String.format("(%s)", referralSummaryDTOModel2.BuiltInFictitiousFunctionClassFactory));
            }
            if (referralSummaryDTOModel2.PlaceComponentResult != null) {
                TextView textView = this.tvReferralTrackerRegister;
                String str = referralSummaryDTOModel2.PlaceComponentResult.MyBillsEntityDataFactory;
                String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.referral_tracker_register);
                if (!TextUtils.isEmpty(str)) {
                    textView.setText(str);
                } else {
                    textView.setText(string);
                }
                KClassImpl$Data$declaredNonStaticMembers$2(this.tvReferralTrackerRegister, this.ivReferralTrackerRegister, referralSummaryDTOModel2.PlaceComponentResult.getAuthRequestContext(), R.drawable.ic_referral_tracker_success, R.drawable.ic_referral_tracker_success_grey);
                String str2 = referralSummaryDTOModel2.PlaceComponentResult.PlaceComponentResult;
                if (!TextUtils.isEmpty(str2)) {
                    this.MyBillsEntityDataFactory = str2;
                }
            }
            if (referralSummaryDTOModel2.lookAheadTest != null) {
                TextView textView2 = this.tvReferralTrackerActive;
                String str3 = referralSummaryDTOModel2.lookAheadTest.MyBillsEntityDataFactory;
                String string2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.referral_tracker_active);
                if (!TextUtils.isEmpty(str3)) {
                    textView2.setText(str3);
                } else {
                    textView2.setText(string2);
                }
                KClassImpl$Data$declaredNonStaticMembers$2(this.tvReferralTrackerActive, this.ivReferralTrackerActive, referralSummaryDTOModel2.lookAheadTest.getAuthRequestContext(), R.drawable.ic_referral_tracker_success, R.drawable.ic_referral_tracker_success_grey);
                String str4 = referralSummaryDTOModel2.lookAheadTest.PlaceComponentResult;
                if (!TextUtils.isEmpty(str4)) {
                    this.MyBillsEntityDataFactory = str4;
                }
            }
            if (referralSummaryDTOModel2.getErrorConfigVersion != null) {
                TextView textView3 = this.tvReferralTrackerReward;
                String str5 = referralSummaryDTOModel2.getErrorConfigVersion.MyBillsEntityDataFactory;
                String string3 = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.referral_tracker_reward);
                if (!TextUtils.isEmpty(str5)) {
                    textView3.setText(str5);
                } else {
                    textView3.setText(string3);
                }
                KClassImpl$Data$declaredNonStaticMembers$2(this.tvReferralTrackerReward, this.ivReferralTrackerReward, referralSummaryDTOModel2.getErrorConfigVersion.getAuthRequestContext(), R.drawable.ic_referral_tracker_reward, R.drawable.ic_referral_tracker_reward_grey);
                String str6 = referralSummaryDTOModel2.getErrorConfigVersion.PlaceComponentResult;
                if (!TextUtils.isEmpty(str6)) {
                    this.MyBillsEntityDataFactory = str6;
                }
            }
            if (TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
                return;
            }
            this.tvReferralTrackerReward.setText(this.MyBillsEntityDataFactory);
            this.tvReferralTrackerReward.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, R.color.f23032131099778));
            InstrumentInjector.Resources_setImageResource(this.ivReferralTrackerReward, R.drawable.ic_referral_tracker_no_reward);
            this.MyBillsEntityDataFactory = null;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(TextView textView, ImageView imageView, boolean z, int i, int i2) {
        if (z) {
            textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, R.color.f23032131099778));
            InstrumentInjector.Resources_setImageResource(imageView, i);
            return;
        }
        textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, R.color.f24012131099998));
        InstrumentInjector.Resources_setImageResource(imageView, i2);
    }
}
