package com.alipay.iap.android.f2fpay.widgets.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.widgets.activity.F2FPayFullscreenDisplayActivity;
import com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeState;
import com.alipay.iap.android.f2fpay.widgets.data.QRCodeConfiguration;
import com.alipay.imobile.magenerator.api.IAPMaGenerator;

/* loaded from: classes6.dex */
public class F2FPayQRCodeView extends F2FPayAbstractPaymentCodeView {
    public static final int DEFAULT_SIZE = 300;
    private int i;
    private Bitmap j;
    private ImageView k;
    private QRCodeConfiguration l;

    public F2FPayQRCodeView(Context context) {
        super(context);
        this.l = new QRCodeConfiguration();
        a(context);
    }

    public F2FPayQRCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new QRCodeConfiguration();
        a(context);
    }

    public F2FPayQRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new QRCodeConfiguration();
        a(context);
    }

    private void a(Context context) {
        ImageView imageView = new ImageView(context);
        this.k = imageView;
        addView(imageView);
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void c() {
        a(F2FPayFullscreenDisplayActivity.c.QRCode, this.c, this.j, this.l);
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void e() {
        if (TextUtils.isEmpty(this.c) || this.i <= 0) {
            return;
        }
        LoggerWrapper.i(F2FPayConstants.TAG, "refreshPaymentCodeBitmap");
        IAPAsyncTask.asyncTask(new F2FPayAsyncTask.F2FPayRunner<Bitmap>() { // from class: com.alipay.iap.android.f2fpay.widgets.widget.F2FPayQRCodeView.1
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public Bitmap execute() throws Exception {
                LoggerWrapper.i(F2FPayConstants.TAG, "generate qr code in work thread.");
                int min = Math.min(300, F2FPayQRCodeView.this.i);
                if (F2FPayQRCodeView.this.l.logo != null) {
                    IAPMaGenerator iAPMaGenerator = IAPMaGenerator.getInstance();
                    F2FPayQRCodeView f2FPayQRCodeView = F2FPayQRCodeView.this;
                    return iAPMaGenerator.encodeQRAsBitmap(f2FPayQRCodeView.c, f2FPayQRCodeView.l.logo, min, F2FPayQRCodeView.this.l.paymentCodeColor, F2FPayQRCodeView.this.l.backgroundColor);
                }
                IAPMaGenerator iAPMaGenerator2 = IAPMaGenerator.getInstance();
                F2FPayQRCodeView f2FPayQRCodeView2 = F2FPayQRCodeView.this;
                return iAPMaGenerator2.encodeQRAsBitmap(f2FPayQRCodeView2.c, min, f2FPayQRCodeView2.l.paymentCodeColor, F2FPayQRCodeView.this.l.backgroundColor);
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask.F2FPayRunner, com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onFailure(IAPError iAPError) {
                super.onFailure(iAPError);
                LoggerWrapper.e(F2FPayConstants.TAG, String.format("encode BarCode FAILED! message = %s", iAPError.errorMessage));
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask.F2FPayRunner, com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onSuccess(Bitmap bitmap) {
                super.onSuccess((AnonymousClass1) bitmap);
                if (bitmap != null) {
                    F2FPayQRCodeView.this.setPaymentCodeBitmap(bitmap);
                }
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingLeft = getPaddingLeft() + 300 + getPaddingRight();
        int paddingTop = getPaddingTop() + 300 + getPaddingBottom();
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            paddingLeft = size;
        }
        if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
            paddingTop = size2;
        }
        int min = Math.min((paddingLeft - getPaddingLeft()) - getPaddingRight(), (paddingTop - getPaddingTop()) - getPaddingBottom());
        this.i = min;
        if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(size, min) + getPaddingLeft() + getPaddingRight();
        }
        if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(size2, this.i) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(paddingLeft, paddingTop);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.width = (paddingLeft - getPaddingLeft()) - getPaddingRight();
        layoutParams.height = (paddingTop - getPaddingTop()) - getPaddingBottom();
        layoutParams.gravity = 17;
        this.k.setLayoutParams(layoutParams);
    }

    public void setConfiguration(QRCodeConfiguration qRCodeConfiguration) {
        if (qRCodeConfiguration != null) {
            this.l = qRCodeConfiguration;
            e();
        }
    }

    public void setLogo(Bitmap bitmap) {
        this.l.logo = bitmap;
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    public void setPaymentCodeBitmap(Bitmap bitmap) {
        LoggerWrapper.i(F2FPayConstants.TAG, "setPaymentCodeBitmap");
        this.j = bitmap;
        setPaymentCodeState(PaymentCodeState.Success);
        this.k.setImageBitmap(bitmap);
        postInvalidate();
    }

    public void setQrCodeBackgroundColor(int i) {
        this.l.backgroundColor = i;
        e();
    }

    public void setQrCodeColor(int i) {
        this.l.paymentCodeColor = i;
        e();
    }
}
