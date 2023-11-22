package id.dana.sendmoney.voucher;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class VoucherDetailActivity_ViewBinding implements Unbinder {
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private VoucherDetailActivity getAuthRequestContext;

    public VoucherDetailActivity_ViewBinding(final VoucherDetailActivity voucherDetailActivity, View view) {
        this.getAuthRequestContext = voucherDetailActivity;
        voucherDetailActivity.rvVoucher = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_voucher, "field 'rvVoucher'", RecyclerView.class);
        voucherDetailActivity.tvAllVoucher = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_all_voucher, "field 'tvAllVoucher'", TextView.class);
        voucherDetailActivity.tvWordingVoucherList = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_wording_voucher_list, "field 'tvWordingVoucherList'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_without_voucher, "method 'onWithoutVoucherClick'");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.voucher.VoucherDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                voucherDetailActivity.onWithoutVoucherClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        VoucherDetailActivity voucherDetailActivity = this.getAuthRequestContext;
        if (voucherDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        voucherDetailActivity.rvVoucher = null;
        voucherDetailActivity.tvAllVoucher = null;
        voucherDetailActivity.tvWordingVoucherList = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
