package id.dana.sendmoney.voucher.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class VoucherViewHolder_ViewBinding implements Unbinder {
    private VoucherViewHolder MyBillsEntityDataFactory;

    public VoucherViewHolder_ViewBinding(VoucherViewHolder voucherViewHolder, View view) {
        this.MyBillsEntityDataFactory = voucherViewHolder;
        voucherViewHolder.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        voucherViewHolder.tvBalance = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_balance, "field 'tvBalance'", TextView.class);
        voucherViewHolder.tvDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvDescription'", TextView.class);
        voucherViewHolder.tvExpireTime = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4396tv_expire_time, "field 'tvExpireTime'", TextView.class);
        voucherViewHolder.tvShowDetail = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_show_detail, "field 'tvShowDetail'", TextView.class);
        voucherViewHolder.ivCheck = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.StatementViewType, "field 'ivCheck'", ImageView.class);
        voucherViewHolder.clVoucher = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_voucher, "field 'clVoucher'", ConstraintLayout.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        VoucherViewHolder voucherViewHolder = this.MyBillsEntityDataFactory;
        if (voucherViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        voucherViewHolder.tvTitle = null;
        voucherViewHolder.tvBalance = null;
        voucherViewHolder.tvDescription = null;
        voucherViewHolder.tvExpireTime = null;
        voucherViewHolder.tvShowDetail = null;
        voucherViewHolder.ivCheck = null;
        voucherViewHolder.clVoucher = null;
    }
}
