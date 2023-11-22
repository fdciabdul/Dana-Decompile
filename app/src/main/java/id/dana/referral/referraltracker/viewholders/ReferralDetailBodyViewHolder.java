package id.dana.referral.referraltracker.viewholders;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.referral.model.MyReferralConsult;
import id.dana.referral.referraltracker.model.ReferralSummaryDTOModel;
import id.dana.utils.TagFormat;

/* loaded from: classes9.dex */
public class ReferralDetailBodyViewHolder extends BaseRecyclerViewHolder<ReferralSummaryDTOModel> {
    private MyReferralConsult KClassImpl$Data$declaredNonStaticMembers$2;
    private Context PlaceComponentResult;
    private OnAdapterButtonClickListener getAuthRequestContext;
    @BindView(R.id.f4488tv_referral_code)
    TextView tvReferralCode;
    @BindView(R.id.tv_referral_share_code)
    TextView tvReferralShareCode;

    /* loaded from: classes9.dex */
    public interface OnAdapterButtonClickListener {
    }

    @OnClick({R.id.btn_copy_referral_code})
    public void doCopyReferral() {
    }

    @OnClick({R.id.iv_referral_box})
    public void doCopyReferralBox() {
    }

    @OnClick({R.id.tv_how_it_works})
    public void doOpenHowItWorks() {
    }

    @OnClick({R.id.btn_share_referral_code})
    public void doShareReferralCode(View view) {
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ReferralSummaryDTOModel referralSummaryDTOModel) {
        String str;
        this.tvReferralCode.setText(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
        TextView textView = this.tvReferralShareCode;
        TagFormat MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory(this.PlaceComponentResult.getString(R.string.msg_referred_description));
        String str2 = "";
        if (TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory)) {
            str = "";
        } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 != null && this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
            sb.append(" ");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            str = sb.toString();
        } else {
            str = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        }
        TagFormat MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory("referrer", str);
        if (!TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory)) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 != null && this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.MyBillsEntityDataFactory);
                sb2.append(" ");
                sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
                str2 = sb2.toString();
            } else {
                str2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.MyBillsEntityDataFactory;
            }
        }
        textView.setText(MyBillsEntityDataFactory2.MyBillsEntityDataFactory("referred", str2).MyBillsEntityDataFactory());
    }
}
