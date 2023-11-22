package id.dana.referral.referraltracker.viewholders;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.ReferralWidgetModel;
import id.dana.referral.referraltracker.model.ReferralSummaryDTOModel;
import id.dana.referral.referraltracker.viewholders.ReferralDetailHeaderViewHolder;
import java.util.List;

/* loaded from: classes9.dex */
public class ReferralDetailHeaderViewHolder extends BaseRecyclerViewHolder<ReferralSummaryDTOModel> {
    OnHeaderButtonClickListener BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Context MyBillsEntityDataFactory;
    @BindViews({R.id.btn_referral_tracker_first, R.id.btn_referral_tracker_second})
    List<Button> btnReferralTracker;
    @BindView(R.id.tv_referral_title)
    TextView tvReferralTitle;
    @BindView(R.id.tv_see_how_it_works_header)
    TextView tvSeeHowItWorksHeader;

    /* loaded from: classes9.dex */
    public interface OnHeaderButtonClickListener {
    }

    @OnClick({R.id.tv_see_how_it_works_header})
    public void doOpenHowItWorks() {
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ReferralSummaryDTOModel referralSummaryDTOModel) {
        String string;
        ReferralSummaryDTOModel referralSummaryDTOModel2 = referralSummaryDTOModel;
        if (referralSummaryDTOModel2 != null) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.tvSeeHowItWorksHeader.setVisibility(0);
                if (referralSummaryDTOModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 != null && !referralSummaryDTOModel2.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty()) {
                    List<ReferralWidgetModel> list = referralSummaryDTOModel2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    for (int i = 0; i < list.size(); i++) {
                        final ReferralWidgetModel referralWidgetModel = list.get(i);
                        if (referralWidgetModel != null && i < this.btnReferralTracker.size()) {
                            Button button = this.btnReferralTracker.get(i);
                            button.setVisibility(referralWidgetModel.PlaceComponentResult() ? 0 : 8);
                            if (!TextUtils.isEmpty(referralWidgetModel.KClassImpl$Data$declaredNonStaticMembers$2)) {
                                button.setText(referralWidgetModel.KClassImpl$Data$declaredNonStaticMembers$2);
                            }
                            if (!TextUtils.isEmpty(referralWidgetModel.BuiltInFictitiousFunctionClassFactory)) {
                                button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.referral.referraltracker.viewholders.ReferralDetailHeaderViewHolder$$ExternalSyntheticLambda0
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        ReferralDetailHeaderViewHolder referralDetailHeaderViewHolder = ReferralDetailHeaderViewHolder.this;
                                        ReferralWidgetModel referralWidgetModel2 = referralWidgetModel;
                                        ReferralDetailHeaderViewHolder.OnHeaderButtonClickListener onHeaderButtonClickListener = referralDetailHeaderViewHolder.BuiltInFictitiousFunctionClassFactory;
                                        String str = referralWidgetModel2.BuiltInFictitiousFunctionClassFactory;
                                    }
                                });
                            }
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(referralSummaryDTOModel2.KClassImpl$Data$declaredNonStaticMembers$2)) {
                this.tvReferralTitle.setText(referralSummaryDTOModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            } else if (referralSummaryDTOModel2.MyBillsEntityDataFactory()) {
                TextView textView = this.tvReferralTitle;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    string = this.MyBillsEntityDataFactory.getString(R.string.msg_referrer_hidden_description);
                } else {
                    string = this.MyBillsEntityDataFactory.getString(R.string.msg_referrer_description);
                }
                textView.setText(string);
            }
        }
    }
}
