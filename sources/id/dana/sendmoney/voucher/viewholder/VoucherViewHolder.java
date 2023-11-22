package id.dana.sendmoney.voucher.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.sendmoney.model.VoucherModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;

/* loaded from: classes5.dex */
public class VoucherViewHolder extends BaseRecyclerViewHolder<VoucherModel> {
    final DynamicUrlWrapper MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    @BindView(R.id.cl_voucher)
    ConstraintLayout clVoucher;
    @BindView(R.id.StatementViewType)
    ImageView ivCheck;
    @BindView(R.id.tv_balance)
    TextView tvBalance;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.f4396tv_expire_time)
    TextView tvExpireTime;
    @BindView(R.id.tv_show_detail)
    TextView tvShowDetail;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(VoucherModel voucherModel) {
        final VoucherModel voucherModel2 = voucherModel;
        this.PlaceComponentResult = voucherModel2.BuiltInFictitiousFunctionClassFactory();
        this.tvShowDetail.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.voucher.viewholder.VoucherViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaH5.startContainerFullUrl(String.format(VoucherViewHolder.this.MyBillsEntityDataFactory.getVoucherDetail(), voucherModel2.MyBillsEntityDataFactory));
            }
        });
        boolean z = this.PlaceComponentResult;
        this.tvTitle.setText(voucherModel2.lookAheadTest);
        this.tvBalance.setText(String.format(getContext().getString(R.string.voucher_value), voucherModel2.DatabaseTableConfigUtil.MyBillsEntityDataFactory));
        this.tvDescription.setText(voucherModel2.moveToNextValue);
        this.tvExpireTime.setText(String.format(getContext().getString(R.string.expired_voucher), DateTimeUtil.BuiltInFictitiousFunctionClassFactory(this.itemView.getContext().getString(R.string.complete_time), LocaleUtil.getAuthRequestContext(), voucherModel2.getErrorConfigVersion)));
        this.ivCheck.setVisibility((voucherModel2.PlaceComponentResult() && z) ? 0 : 8);
        this.clVoucher.setBackgroundResource((z && voucherModel2.PlaceComponentResult()) ? R.drawable.bg_active_voucher : R.drawable.bg_idle_voucher);
        if (z) {
            return;
        }
        this.tvTitle.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f24012131099998));
        this.tvDescription.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f26702131100367));
        this.tvExpireTime.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f24012131099998));
        this.tvBalance.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f24012131099998));
    }

    public VoucherViewHolder(ViewGroup viewGroup, DynamicUrlWrapper dynamicUrlWrapper) {
        super(viewGroup.getContext(), R.layout.view_voucher, viewGroup);
        this.MyBillsEntityDataFactory = dynamicUrlWrapper;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        if (this.PlaceComponentResult) {
            super.setOnItemClickListener(onItemClickListener);
        }
    }
}
