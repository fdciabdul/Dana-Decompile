package id.dana.pay.view;

import android.content.Context;
import android.util.AttributeSet;
import id.dana.R;

/* loaded from: classes9.dex */
public class QrisPayView extends BasePayView {
    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_pay_qris;
    }

    @Override // id.dana.pay.view.BasePayView
    protected void onDisableCode() {
    }

    @Override // id.dana.pay.view.BasePayView
    protected void onSetCode(String str) {
    }

    @Override // id.dana.pay.view.BasePayView
    protected void setBarcodeOverlayViewVisibility(int i) {
    }

    public QrisPayView(Context context) {
        super(context);
    }

    public QrisPayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QrisPayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
