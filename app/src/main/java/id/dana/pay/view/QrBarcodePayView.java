package id.dana.pay.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.utils.BarcodeUtil;
import id.dana.utils.TextUtil;
import io.reactivex.functions.Consumer;

/* loaded from: classes5.dex */
public class QrBarcodePayView extends BasePayView {
    View barcodeOverlayView;
    @BindView(R.id.pay_barcode)
    ImageView barcodeView;
    @BindView(R.id.pay_code)
    TextView paycodeView;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_pay_qr_barcode;
    }

    public QrBarcodePayView(Context context) {
        super(context);
    }

    public QrBarcodePayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QrBarcodePayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public QrBarcodePayView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.pay.view.BasePayView, id.dana.base.BaseRichView
    public void onInjectedView(View view) {
        super.onInjectedView(view);
        this.barcodeOverlayView = view.findViewById(R.id.pay_barcode_overlay);
    }

    @Override // id.dana.pay.view.BasePayView, id.dana.base.BaseRichView
    public void setup() {
        super.setup();
        this.barcodeView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pay.view.QrBarcodePayView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrBarcodePayView.this.m2779lambda$setup$0$iddanapayviewQrBarcodePayView(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setup$0$id-dana-pay-view-QrBarcodePayView  reason: not valid java name */
    public /* synthetic */ void m2779lambda$setup$0$iddanapayviewQrBarcodePayView(View view) {
        if (this.onClickListener == null || !this.valid) {
            return;
        }
        this.onClickListener.PlaceComponentResult();
    }

    @Override // id.dana.pay.view.BasePayView
    public void fetchCode() {
        super.fetchCode();
        this.barcodeOverlayView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.pay.view.BasePayView
    public void showQR(boolean z) {
        super.showQR(z);
        TextView textView = this.paycodeView;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
        ImageView imageView = this.barcodeView;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // id.dana.pay.view.BasePayView
    protected void setBarcodeOverlayViewVisibility(int i) {
        View view = this.barcodeOverlayView;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    @Override // id.dana.pay.view.BasePayView
    protected void onDisableCode() {
        TextView textView = this.paycodeView;
        if (textView != null) {
            textView.setVisibility(0);
            this.paycodeView.setText(R.string.cant_use_qr);
        }
    }

    @Override // id.dana.pay.view.BasePayView
    protected void onSetCode(String str) {
        TextView textView = this.paycodeView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : TextUtil.BuiltInFictitiousFunctionClassFactory(TextUtil.NetworkUserEntityData$$ExternalSyntheticLambda0(str), 12));
        }
        addDisposable(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(str, 1).subscribe(new Consumer() { // from class: id.dana.pay.view.QrBarcodePayView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QrBarcodePayView.this.m2778lambda$onSetCode$1$iddanapayviewQrBarcodePayView((Bitmap) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSetCode$1$id-dana-pay-view-QrBarcodePayView  reason: not valid java name */
    public /* synthetic */ void m2778lambda$onSetCode$1$iddanapayviewQrBarcodePayView(Bitmap bitmap) throws Exception {
        this.barcodeView.setImageBitmap(bitmap);
    }
}
