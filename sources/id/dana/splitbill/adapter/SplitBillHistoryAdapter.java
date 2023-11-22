package id.dana.splitbill.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.richview.CurrencyTextView;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import java.util.List;

/* loaded from: classes5.dex */
public class SplitBillHistoryAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<SplitBillHistory>, SplitBillHistory> {

    /* loaded from: classes9.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder BuiltInFictitiousFunctionClassFactory;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.BuiltInFictitiousFunctionClassFactory = viewHolder;
            viewHolder.civFirstPayer = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.civ_first_payer, "field 'civFirstPayer'", CircleImageView.class);
            viewHolder.civSecondPayer = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.civ_second_payer, "field 'civSecondPayer'", CircleImageView.class);
            viewHolder.civThirdPayer = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.civ_third_payer, "field 'civThirdPayer'", CircleImageView.class);
            viewHolder.flSumPayer = (FrameLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.fl_sum_payer, "field 'flSumPayer'", FrameLayout.class);
            viewHolder.tvSumPayer = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_sum_payer, "field 'tvSumPayer'", TextView.class);
            viewHolder.tvDescriptionSplitBillHistory = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvDescriptionSplitBillHistory'", TextView.class);
            viewHolder.tvDateSplitBillHistory = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_date_split_bill_history, "field 'tvDateSplitBillHistory'", TextView.class);
            viewHolder.ctvAmount = (CurrencyTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ctv_amount, "field 'ctvAmount'", CurrencyTextView.class);
            viewHolder.ivStatus = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3954iv_status, "field 'ivStatus'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public final void getAuthRequestContext() {
            ViewHolder viewHolder = this.BuiltInFictitiousFunctionClassFactory;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.BuiltInFictitiousFunctionClassFactory = null;
            viewHolder.civFirstPayer = null;
            viewHolder.civSecondPayer = null;
            viewHolder.civThirdPayer = null;
            viewHolder.flSumPayer = null;
            viewHolder.tvSumPayer = null;
            viewHolder.tvDescriptionSplitBillHistory = null;
            viewHolder.tvDateSplitBillHistory = null;
            viewHolder.ctvAmount = null;
            viewHolder.ivStatus = null;
        }
    }

    /* loaded from: classes5.dex */
    public class ViewHolder extends BaseRecyclerViewHolder<SplitBillHistory> {
        @BindView(R.id.civ_first_payer)
        CircleImageView civFirstPayer;
        @BindView(R.id.civ_second_payer)
        CircleImageView civSecondPayer;
        @BindView(R.id.civ_third_payer)
        CircleImageView civThirdPayer;
        @BindView(R.id.ctv_amount)
        CurrencyTextView ctvAmount;
        @BindView(R.id.fl_sum_payer)
        FrameLayout flSumPayer;
        @BindView(R.id.f3954iv_status)
        ImageView ivStatus;
        @BindView(R.id.tv_date_split_bill_history)
        TextView tvDateSplitBillHistory;
        @BindView(R.id.tv_description)
        TextView tvDescriptionSplitBillHistory;
        @BindView(R.id.tv_sum_payer)
        TextView tvSumPayer;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public /* synthetic */ void bindData(SplitBillHistory splitBillHistory) {
            SplitBillHistory splitBillHistory2 = splitBillHistory;
            List<String> avatars = splitBillHistory2.getAvatars();
            if (avatars == null || avatars.isEmpty()) {
                this.civFirstPayer.setVisibility(4);
                this.civSecondPayer.setVisibility(4);
                this.civThirdPayer.setVisibility(4);
                this.flSumPayer.setVisibility(8);
            } else if (avatars.size() == 1) {
                this.civFirstPayer.setVisibility(4);
                this.civSecondPayer.setVisibility(4);
                KClassImpl$Data$declaredNonStaticMembers$2(avatars.get(0), this.civThirdPayer);
                this.flSumPayer.setVisibility(8);
            } else if (avatars.size() == 2) {
                this.civFirstPayer.setVisibility(4);
                KClassImpl$Data$declaredNonStaticMembers$2(avatars.get(0), this.civSecondPayer);
                KClassImpl$Data$declaredNonStaticMembers$2(avatars.get(1), this.civThirdPayer);
                this.flSumPayer.setVisibility(8);
            } else if (avatars.size() == 3) {
                KClassImpl$Data$declaredNonStaticMembers$2(avatars.get(0), this.civFirstPayer);
                KClassImpl$Data$declaredNonStaticMembers$2(avatars.get(1), this.civSecondPayer);
                KClassImpl$Data$declaredNonStaticMembers$2(avatars.get(2), this.civThirdPayer);
                this.flSumPayer.setVisibility(8);
            } else if (avatars.size() > 3) {
                KClassImpl$Data$declaredNonStaticMembers$2(avatars.get(0), this.civFirstPayer);
                KClassImpl$Data$declaredNonStaticMembers$2(avatars.get(1), this.civSecondPayer);
                this.civThirdPayer.setVisibility(4);
                StringBuilder sb = new StringBuilder();
                sb.append("+");
                sb.append(avatars.size() - 2);
                this.tvSumPayer.setText(sb.toString());
                this.flSumPayer.setVisibility(0);
            }
            this.tvDescriptionSplitBillHistory.setText(TextUtils.isEmpty(splitBillHistory2.getComment()) ? "-" : splitBillHistory2.getComment());
            this.tvDateSplitBillHistory.setText(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(this.itemView.getContext().getString(R.string.split_bill_history_date_format), LocaleUtil.getAuthRequestContext(), splitBillHistory2.getCreatedDate()));
            this.ctvAmount.setText(splitBillHistory2.getTotalAmount().getAmount());
            String status = splitBillHistory2.getStatus();
            if (TextUtils.isEmpty(status)) {
                this.ivStatus.setVisibility(4);
                return;
            }
            status.hashCode();
            char c = 65535;
            int hashCode = status.hashCode();
            if (hashCode != -1149187101) {
                if (hashCode != -604548089) {
                    if (hashCode == -591252731 && status.equals("EXPIRED")) {
                        c = 2;
                    }
                } else if (status.equals("IN_PROGRESS")) {
                    c = 1;
                }
            } else if (status.equals("SUCCESS")) {
                c = 0;
            }
            if (c == 0) {
                this.ivStatus.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.success));
                this.ivStatus.setVisibility(0);
            } else if (c == 1) {
                this.ivStatus.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.pending));
                this.ivStatus.setVisibility(0);
            } else if (c != 2) {
                this.ivStatus.setVisibility(4);
            } else {
                this.ivStatus.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1));
                this.ivStatus.setVisibility(0);
            }
        }

        public ViewHolder(Context context, ViewGroup viewGroup) {
            super(context, R.layout.view_item_split_bill_history, viewGroup);
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(String str, CircleImageView circleImageView) {
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_avatar_grey_default).PlaceComponentResult((int) R.drawable.ic_avatar_grey_default).MyBillsEntityDataFactory((ImageView) circleImageView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(viewGroup.getContext(), viewGroup);
    }
}
