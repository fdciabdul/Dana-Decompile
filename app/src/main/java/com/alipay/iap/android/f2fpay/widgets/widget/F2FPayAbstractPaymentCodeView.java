package com.alipay.iap.android.f2fpay.widgets.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.f2fpay.b.a.b;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import com.alipay.iap.android.f2fpay.widgets.activity.F2FPayFullscreenDisplayActivity;
import com.alipay.iap.android.f2fpay.widgets.data.IF2FPaymentCodeStateChangedListener;
import com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeConfiguration;
import com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeState;

/* loaded from: classes6.dex */
public abstract class F2FPayAbstractPaymentCodeView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected Context f6981a;
    protected boolean b;
    protected String c;
    protected RefreshLoadingDrawHelper d;
    protected IF2FPaymentCodeStateChangedListener e;
    protected PaymentCodeState f;
    protected Mediator g;
    private boolean h;

    /* loaded from: classes6.dex */
    public interface Mediator {
        void refreshPaymentCode(int i);
    }

    public F2FPayAbstractPaymentCodeView(Context context) {
        super(context);
        this.b = true;
        this.f = PaymentCodeState.Failure;
        this.h = false;
        a(context);
    }

    public F2FPayAbstractPaymentCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = true;
        this.f = PaymentCodeState.Failure;
        this.h = false;
        a(context);
    }

    public F2FPayAbstractPaymentCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = true;
        this.f = PaymentCodeState.Failure;
        this.h = false;
        a(context);
    }

    private void a(Context context) {
        this.f6981a = context;
        this.d = new RefreshLoadingDrawHelper(this);
        setWillNotDraw(false);
        b();
        setOnClickListener(new View.OnClickListener() { // from class: com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (F2FPayAbstractPaymentCodeView.this.isSuccess()) {
                    F2FPayAbstractPaymentCodeView.this.c();
                } else if (F2FPayAbstractPaymentCodeView.this.isFailure()) {
                    F2FPayAbstractPaymentCodeView f2FPayAbstractPaymentCodeView = F2FPayAbstractPaymentCodeView.this;
                    f2FPayAbstractPaymentCodeView.requestRefresh(f2FPayAbstractPaymentCodeView.b);
                }
            }
        });
    }

    protected void a() {
        this.d.cancelLoading();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Canvas canvas) {
        this.d.drawLoading(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(F2FPayFullscreenDisplayActivity.c cVar, String str, Bitmap bitmap, PaymentCodeConfiguration paymentCodeConfiguration) {
        Intent intent = new Intent(this.f6981a, F2FPayFullscreenDisplayActivity.class);
        intent.putExtra("DISPLAY_PATTERN", cVar);
        intent.putExtra("PAYMENT_CODE", str);
        intent.putExtra(cVar == F2FPayFullscreenDisplayActivity.c.QRCode ? "QR_CODE_CONFIGURATION" : "BARCODE_CONFIGURATION", paymentCodeConfiguration);
        this.f6981a.startActivity(intent);
        Context context = this.f6981a;
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    protected void b() {
        Context context = this.f6981a;
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            b.a(window, 0.8f);
            b.a(window);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Canvas canvas) {
        this.d.drawRefresh(canvas);
    }

    protected abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Canvas canvas) {
        if (!isSuccess() && this.b) {
            if (isLoading()) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    protected void d() {
        this.d.calculatePosition();
    }

    protected abstract void e();

    protected void f() {
        this.d.startLoading();
    }

    public void generatePaymentCodeFailed() {
        setPaymentCodeState(PaymentCodeState.Failure);
        if (this.b) {
            a();
        }
        postInvalidate();
    }

    public PaymentCodeState getPaymentCodeState() {
        return this.f;
    }

    public boolean isFailure() {
        return this.f == PaymentCodeState.Failure;
    }

    public boolean isLoading() {
        return this.f == PaymentCodeState.Loading;
    }

    public boolean isNeedShowLoading() {
        return this.b;
    }

    public boolean isSuccess() {
        return this.f == PaymentCodeState.Success;
    }

    public boolean isViewAttachedToWindow() {
        return this.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = true;
        if (isLoading() && this.b) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h = false;
        if (this.b) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.b) {
                d();
            }
            e();
        }
    }

    public void requestRefresh(boolean z) {
        setPaymentCodeState(PaymentCodeState.Loading);
        if (z) {
            this.d.startLoading();
        }
        Mediator mediator = this.g;
        if (mediator != null) {
            mediator.refreshPaymentCode(0);
        }
    }

    public void setMediator(Mediator mediator) {
        this.g = mediator;
    }

    public void setNeedShowLoading(boolean z) {
        this.b = z;
        if (z) {
            d();
        } else {
            a();
        }
    }

    public void setOnStateChangedListener(IF2FPaymentCodeStateChangedListener iF2FPaymentCodeStateChangedListener) {
        this.e = iF2FPaymentCodeStateChangedListener;
    }

    public void setPaymentCodeAndBitmap(String str, Bitmap bitmap) {
        PaymentCodeState paymentCodeState;
        if (TextUtils.equals(this.c, str)) {
            return;
        }
        this.c = str;
        if (bitmap != null) {
            setPaymentCodeBitmap(bitmap);
            paymentCodeState = PaymentCodeState.Success;
        } else {
            e();
            paymentCodeState = PaymentCodeState.Loading;
        }
        setPaymentCodeState(paymentCodeState);
    }

    protected abstract void setPaymentCodeBitmap(Bitmap bitmap);

    public void setPaymentCodeState(PaymentCodeState paymentCodeState) {
        if (paymentCodeState == this.f) {
            return;
        }
        this.f = paymentCodeState;
        if (isSuccess()) {
            a();
        }
        IF2FPaymentCodeStateChangedListener iF2FPaymentCodeStateChangedListener = this.e;
        if (iF2FPaymentCodeStateChangedListener != null) {
            iF2FPaymentCodeStateChangedListener.onPaymentCodeStateChanged(this.f);
        }
    }

    public void updatePaymentCode(F2FPaymentCodeInfo f2FPaymentCodeInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("updatePaymentCode: ");
        sb.append(System.currentTimeMillis());
        LoggerWrapper.i(F2FPayConstants.TAG, sb.toString());
        if (f2FPaymentCodeInfo == null || TextUtils.equals(this.c, f2FPaymentCodeInfo.paymentCode)) {
            return;
        }
        this.c = f2FPaymentCodeInfo.paymentCode;
        e();
    }
}
