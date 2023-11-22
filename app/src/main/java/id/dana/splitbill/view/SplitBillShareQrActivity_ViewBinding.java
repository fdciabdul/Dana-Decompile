package id.dana.splitbill.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.QRView;

/* loaded from: classes9.dex */
public class SplitBillShareQrActivity_ViewBinding implements Unbinder {
    private SplitBillShareQrActivity BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;

    public SplitBillShareQrActivity_ViewBinding(final SplitBillShareQrActivity splitBillShareQrActivity, View view) {
        this.BuiltInFictitiousFunctionClassFactory = splitBillShareQrActivity;
        splitBillShareQrActivity.tvRemarks = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_remarks, "field 'tvRemarks'", TextView.class);
        splitBillShareQrActivity.qrView = (QRView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.qrv_qr, "field 'qrView'", QRView.class);
        splitBillShareQrActivity.tvNickname = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_name, "field 'tvNickname'", TextView.class);
        splitBillShareQrActivity.tvPhoneNumber = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_phone_number, "field 'tvPhoneNumber'", TextView.class);
        splitBillShareQrActivity.ivDanaLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_dana_logo, "field 'ivDanaLogo'", ImageView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_page_container, "method 'onClose'");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.splitbill.view.SplitBillShareQrActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                splitBillShareQrActivity.onClose();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SplitBillShareQrActivity splitBillShareQrActivity = this.BuiltInFictitiousFunctionClassFactory;
        if (splitBillShareQrActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        splitBillShareQrActivity.tvRemarks = null;
        splitBillShareQrActivity.qrView = null;
        splitBillShareQrActivity.tvNickname = null;
        splitBillShareQrActivity.tvPhoneNumber = null;
        splitBillShareQrActivity.ivDanaLogo = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
