package id.dana.pay.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class BasePayView_ViewBinding implements Unbinder {
    private BasePayView getAuthRequestContext;

    public BasePayView_ViewBinding(BasePayView basePayView, View view) {
        this.getAuthRequestContext = basePayView;
        basePayView.qrView = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pay_qr, "field 'qrView'", ImageView.class);
        basePayView.refreshLabel = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pay_mid_refresh_label, "field 'refreshLabel'", TextView.class);
        basePayView.llOfflineQr = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_offline_qr, "field 'llOfflineQr'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void getAuthRequestContext() {
        BasePayView basePayView = this.getAuthRequestContext;
        if (basePayView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        basePayView.qrView = null;
        basePayView.refreshLabel = null;
        basePayView.llOfflineQr = null;
    }
}
