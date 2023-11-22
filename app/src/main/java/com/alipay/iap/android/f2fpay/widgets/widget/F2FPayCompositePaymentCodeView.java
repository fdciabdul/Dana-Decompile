package com.alipay.iap.android.f2fpay.widgets.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.alipay.iap.android.f2fpay.R;
import com.alipay.iap.android.f2fpay.b.a.a;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import com.alipay.iap.android.f2fpay.widgets.data.IF2FPaymentCodeStateChangedListener;
import com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeState;

/* loaded from: classes6.dex */
public class F2FPayCompositePaymentCodeView extends F2FPayAbstractPaymentCodeView {
    private F2FPayBarcodeView i;
    private F2FPayQRCodeView j;
    private F2FPayRefreshButton k;
    private View l;
    private IF2FPaymentCodeStateChangedListener m;

    public F2FPayCompositePaymentCodeView(Context context) {
        super(context);
        this.m = new IF2FPaymentCodeStateChangedListener() { // from class: com.alipay.iap.android.f2fpay.widgets.widget.F2FPayCompositePaymentCodeView.1
            @Override // com.alipay.iap.android.f2fpay.widgets.data.IF2FPaymentCodeStateChangedListener
            public void onPaymentCodeStateChanged(PaymentCodeState paymentCodeState) {
                F2FPayCompositePaymentCodeView f2FPayCompositePaymentCodeView;
                PaymentCodeState paymentCodeState2;
                F2FPayCompositePaymentCodeView.this.k.setVisibility(paymentCodeState.isLoading() ? 4 : 0);
                PaymentCodeState paymentCodeState3 = F2FPayCompositePaymentCodeView.this.j.getPaymentCodeState();
                PaymentCodeState paymentCodeState4 = F2FPayCompositePaymentCodeView.this.i.getPaymentCodeState();
                if (paymentCodeState3.isSuccess() && paymentCodeState4.isSuccess()) {
                    f2FPayCompositePaymentCodeView = F2FPayCompositePaymentCodeView.this;
                    paymentCodeState2 = PaymentCodeState.Success;
                } else if (paymentCodeState3.isFailure() || paymentCodeState4.isFailure()) {
                    f2FPayCompositePaymentCodeView = F2FPayCompositePaymentCodeView.this;
                    paymentCodeState2 = PaymentCodeState.Failure;
                } else if (!paymentCodeState3.isLoading() && !paymentCodeState4.isLoading()) {
                    return;
                } else {
                    f2FPayCompositePaymentCodeView = F2FPayCompositePaymentCodeView.this;
                    paymentCodeState2 = PaymentCodeState.Loading;
                }
                f2FPayCompositePaymentCodeView.setPaymentCodeState(paymentCodeState2);
            }
        };
        a(context);
    }

    public F2FPayCompositePaymentCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new IF2FPaymentCodeStateChangedListener() { // from class: com.alipay.iap.android.f2fpay.widgets.widget.F2FPayCompositePaymentCodeView.1
            @Override // com.alipay.iap.android.f2fpay.widgets.data.IF2FPaymentCodeStateChangedListener
            public void onPaymentCodeStateChanged(PaymentCodeState paymentCodeState) {
                F2FPayCompositePaymentCodeView f2FPayCompositePaymentCodeView;
                PaymentCodeState paymentCodeState2;
                F2FPayCompositePaymentCodeView.this.k.setVisibility(paymentCodeState.isLoading() ? 4 : 0);
                PaymentCodeState paymentCodeState3 = F2FPayCompositePaymentCodeView.this.j.getPaymentCodeState();
                PaymentCodeState paymentCodeState4 = F2FPayCompositePaymentCodeView.this.i.getPaymentCodeState();
                if (paymentCodeState3.isSuccess() && paymentCodeState4.isSuccess()) {
                    f2FPayCompositePaymentCodeView = F2FPayCompositePaymentCodeView.this;
                    paymentCodeState2 = PaymentCodeState.Success;
                } else if (paymentCodeState3.isFailure() || paymentCodeState4.isFailure()) {
                    f2FPayCompositePaymentCodeView = F2FPayCompositePaymentCodeView.this;
                    paymentCodeState2 = PaymentCodeState.Failure;
                } else if (!paymentCodeState3.isLoading() && !paymentCodeState4.isLoading()) {
                    return;
                } else {
                    f2FPayCompositePaymentCodeView = F2FPayCompositePaymentCodeView.this;
                    paymentCodeState2 = PaymentCodeState.Loading;
                }
                f2FPayCompositePaymentCodeView.setPaymentCodeState(paymentCodeState2);
            }
        };
        a(context);
    }

    public F2FPayCompositePaymentCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new IF2FPaymentCodeStateChangedListener() { // from class: com.alipay.iap.android.f2fpay.widgets.widget.F2FPayCompositePaymentCodeView.1
            @Override // com.alipay.iap.android.f2fpay.widgets.data.IF2FPaymentCodeStateChangedListener
            public void onPaymentCodeStateChanged(PaymentCodeState paymentCodeState) {
                F2FPayCompositePaymentCodeView f2FPayCompositePaymentCodeView;
                PaymentCodeState paymentCodeState2;
                F2FPayCompositePaymentCodeView.this.k.setVisibility(paymentCodeState.isLoading() ? 4 : 0);
                PaymentCodeState paymentCodeState3 = F2FPayCompositePaymentCodeView.this.j.getPaymentCodeState();
                PaymentCodeState paymentCodeState4 = F2FPayCompositePaymentCodeView.this.i.getPaymentCodeState();
                if (paymentCodeState3.isSuccess() && paymentCodeState4.isSuccess()) {
                    f2FPayCompositePaymentCodeView = F2FPayCompositePaymentCodeView.this;
                    paymentCodeState2 = PaymentCodeState.Success;
                } else if (paymentCodeState3.isFailure() || paymentCodeState4.isFailure()) {
                    f2FPayCompositePaymentCodeView = F2FPayCompositePaymentCodeView.this;
                    paymentCodeState2 = PaymentCodeState.Failure;
                } else if (!paymentCodeState3.isLoading() && !paymentCodeState4.isLoading()) {
                    return;
                } else {
                    f2FPayCompositePaymentCodeView = F2FPayCompositePaymentCodeView.this;
                    paymentCodeState2 = PaymentCodeState.Loading;
                }
                f2FPayCompositePaymentCodeView.setPaymentCodeState(paymentCodeState2);
            }
        };
        a(context);
    }

    private void a(Context context) {
        Resources resources = getResources();
        this.d.setLoadingBkgRadius(a.a(resources, 10.0f));
        setBackgroundResource(R.drawable.iap_f2fpay_gray_background);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
        F2FPayBarcodeView f2FPayBarcodeView = new F2FPayBarcodeView(context);
        this.i = f2FPayBarcodeView;
        f2FPayBarcodeView.setNeedShowLoading(false);
        this.i.setOnStateChangedListener(this.m);
        this.i.setBackgroundResource(R.drawable.iap_f2fpay_half_white_background);
        this.i.setPadding(0, a.a(resources, 15.0f), 0, a.a(resources, 15.0f));
        linearLayout.addView(this.i, new LinearLayout.LayoutParams(-1, -2));
        int color = resources.getColor(R.color.iap_f2fpay_default_background_color);
        F2FPayQRCodeView f2FPayQRCodeView = new F2FPayQRCodeView(context);
        this.j = f2FPayQRCodeView;
        f2FPayQRCodeView.setNeedShowLoading(false);
        this.j.setOnStateChangedListener(this.m);
        this.j.setBackgroundColor(color);
        this.j.setQrCodeBackgroundColor(color);
        this.j.setPadding(0, a.a(resources, 18.0f), 0, 0);
        linearLayout.addView(this.j, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        F2FPayRefreshButton f2FPayRefreshButton = new F2FPayRefreshButton(context);
        this.k = f2FPayRefreshButton;
        linearLayout.addView(f2FPayRefreshButton, new FrameLayout.LayoutParams(-1, -2));
    }

    public void addRefreshView(View view) {
        this.l = view;
        addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void c() {
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void e() {
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    public void generatePaymentCodeFailed() {
        super.generatePaymentCodeFailed();
        this.i.generatePaymentCodeFailed();
        this.j.generatePaymentCodeFailed();
        this.k.changeToFailureState();
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        View view = this.l;
        if (view == null) {
            c(canvas);
        } else {
            view.setVisibility(isSuccess() ? 8 : 0);
        }
    }

    public void setAutoRefreshSeconds(int i) {
        this.k.setAutoRefreshSeconds(i);
    }

    public void setLogo(Bitmap bitmap) {
        this.j.setLogo(bitmap);
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void setPaymentCodeBitmap(Bitmap bitmap) {
        this.i.setPaymentCodeBitmap(bitmap);
        this.j.setPaymentCodeBitmap(bitmap);
    }

    public void setRefreshButtonTextSizeInDip(int i) {
        this.k.setTextSizeInDip(i);
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    public void updatePaymentCode(F2FPaymentCodeInfo f2FPaymentCodeInfo) {
        super.updatePaymentCode(f2FPaymentCodeInfo);
        this.i.updatePaymentCode(f2FPaymentCodeInfo);
        this.j.updatePaymentCode(f2FPaymentCodeInfo);
        this.k.changeToCompleteState();
        postInvalidate();
    }
}
