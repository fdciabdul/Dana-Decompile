package com.alipay.iap.android.f2fpay.widgets.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.iap.android.f2fpay.b.a.a;
import com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.widgets.activity.F2FPayFullscreenDisplayActivity;
import com.alipay.iap.android.f2fpay.widgets.data.BarCodeConfiguration;
import com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeState;
import com.alipay.imobile.magenerator.api.IAPMaGenerator;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class F2FPayBarcodeView extends F2FPayAbstractPaymentCodeView {
    private BarCodeConfiguration i;
    private int j;
    private Paint k;
    private Rect l;
    private Rect m;
    private Rect n;

    /* renamed from: o  reason: collision with root package name */
    private Rect f6983o;
    private Bitmap p;
    private int[] q;
    private int r;
    private int s;

    public F2FPayBarcodeView(Context context) {
        super(context);
        this.i = new BarCodeConfiguration();
        this.k = new Paint();
        this.l = new Rect();
        this.m = new Rect();
        this.n = new Rect();
        this.f6983o = new Rect();
        h();
    }

    public F2FPayBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new BarCodeConfiguration();
        this.k = new Paint();
        this.l = new Rect();
        this.m = new Rect();
        this.n = new Rect();
        this.f6983o = new Rect();
        h();
    }

    public F2FPayBarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new BarCodeConfiguration();
        this.k = new Paint();
        this.l = new Rect();
        this.m = new Rect();
        this.n = new Rect();
        this.f6983o = new Rect();
        h();
    }

    private int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        return mode != 0 ? (mode == 1073741824 || mode == Integer.MIN_VALUE) ? View.MeasureSpec.getSize(i2) : i : i;
    }

    private void d(Canvas canvas) {
        LoggerWrapper.i(F2FPayConstants.TAG, "drawBarCode");
        if (this.p == null) {
            return;
        }
        this.k.setTypeface(this.i.textTypeface);
        this.k.setTextSize(this.i.textSize);
        this.k.setColor(this.i.textColor);
        canvas.translate(getPaddingLeft(), getPaddingTop());
        canvas.drawBitmap(this.p, this.m, this.l, (Paint) null);
        if (this.q == null) {
            return;
        }
        LoggerWrapper.i(F2FPayConstants.TAG, "onDraw draw number text");
        int ascent = (int) ((this.l.bottom - this.k.ascent()) + this.i.gapBetweenBarcodeAndNumber);
        int i = 0;
        while (true) {
            int[] iArr = this.q;
            if (i >= iArr.length) {
                return;
            }
            int i2 = iArr[i];
            int i3 = this.i.perGroupLengthOfText;
            int i4 = i * i3;
            if (i == iArr.length - 1) {
                i3 = this.c.length() - (this.i.perGroupLengthOfText * (this.q.length - 1));
            }
            canvas.drawText(this.c, i4, i4 + i3, i2, ascent, this.k);
            i++;
        }
    }

    private void e(Canvas canvas) {
        this.k.setColor(this.i.hintColor);
        canvas.translate(getPaddingLeft(), getPaddingTop());
        canvas.drawRect(this.n, this.k);
        canvas.drawRect(this.f6983o, this.k);
    }

    private void g() {
        StringBuilder sb = new StringBuilder();
        sb.append("calculateSizeOfPaymentCode:");
        sb.append(this.c);
        sb.append(",mBarCodeBitmap");
        sb.append(this.p);
        LoggerWrapper.i(F2FPayConstants.TAG, sb.toString());
        if (TextUtils.isEmpty(this.c) || this.l.width() <= 0) {
            return;
        }
        int length = this.c.length();
        BarCodeConfiguration barCodeConfiguration = this.i;
        if (barCodeConfiguration.perGroupLengthOfText <= 0) {
            barCodeConfiguration.perGroupLengthOfText = length;
        }
        int length2 = this.c.length();
        BarCodeConfiguration barCodeConfiguration2 = this.i;
        int i = length2 / barCodeConfiguration2.perGroupLengthOfText;
        this.q = new int[i];
        int i2 = barCodeConfiguration2.groupGap;
        this.k.setTypeface(barCodeConfiguration2.textTypeface);
        this.k.setTextSize(this.i.textSize);
        int width = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - ((i2 * (i - 1)) + ((int) this.k.measureText(this.c)))) / 2;
        float f = this.i.groupGap;
        float measureText = this.k.measureText(this.c) / i;
        int i3 = 0;
        while (true) {
            int[] iArr = this.q;
            if (i3 >= iArr.length) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("calculateSizeOfPaymentCode result:");
                sb2.append(Arrays.toString(this.q));
                LoggerWrapper.i(F2FPayConstants.TAG, sb2.toString());
                return;
            }
            iArr[i3] = (int) (width + (i3 * (f + measureText)));
            i3++;
        }
    }

    private void h() {
        Resources resources = getResources();
        this.j = a.a(resources, 20.0f);
        this.i.groupGap = a.a(resources, 10.0f);
        this.i.textSize = a.a(resources, 16.0f);
        this.i.gapBetweenBarcodeAndNumber = a.a(resources, 3.0f);
        if (getResources().getDisplayMetrics().densityDpi < 320) {
            this.i.textSize = a.a(resources, 14.0f);
        }
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void c() {
        a(F2FPayFullscreenDisplayActivity.c.Barcode, this.c, this.p, this.i);
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void e() {
        int width = getWidth();
        int height = getHeight();
        if (TextUtils.isEmpty(this.c) || width <= 0 || height <= 0) {
            return;
        }
        IAPAsyncTask.asyncTask(new F2FPayAsyncTask.F2FPayRunner<Bitmap>() { // from class: com.alipay.iap.android.f2fpay.widgets.widget.F2FPayBarcodeView.1
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public Bitmap execute() throws Exception {
                LoggerWrapper.i(F2FPayConstants.TAG, "generate bar code in work thread.");
                int i = F2FPayBarcodeView.this.r;
                int i2 = F2FPayBarcodeView.this.s;
                IAPMaGenerator iAPMaGenerator = IAPMaGenerator.getInstance();
                F2FPayBarcodeView f2FPayBarcodeView = F2FPayBarcodeView.this;
                return iAPMaGenerator.encodeAsBarCode(f2FPayBarcodeView.c, i, i2, f2FPayBarcodeView.i.paymentCodeColor, F2FPayBarcodeView.this.i.backgroundColor);
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
                    F2FPayBarcodeView.this.setPaymentCodeBitmap(bitmap);
                }
            }
        });
    }

    public BarCodeConfiguration getConfiguration() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.p;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSuccess()) {
            d(canvas);
        } else if (!this.b) {
            e(canvas);
        } else if (isLoading()) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            return;
        }
        g();
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingTop;
        super.onMeasure(i, i2);
        int a2 = a(375, i);
        int paddingLeft = (a2 - getPaddingLeft()) - getPaddingRight();
        float f = getResources().getDisplayMetrics().densityDpi;
        float f2 = 2.559055f * f;
        float f3 = f * 0.39370078f;
        float f4 = paddingLeft;
        if (f2 > f4) {
            f2 = f4;
        }
        int round = Math.round(f2 - (((f2 / 187.0f) * 10.0f) * 2.0f));
        this.r = round;
        float f5 = round * 0.25f;
        int round2 = f3 < f5 ? Math.round(f5) : Math.round(f3);
        this.s = round2;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            paddingTop = View.MeasureSpec.getSize(i2);
            int paddingTop2 = (paddingTop - getPaddingTop()) - getPaddingBottom();
            this.s = paddingTop2;
            BarCodeConfiguration barCodeConfiguration = this.i;
            if (barCodeConfiguration.isDisplayTextOfPaymentCode) {
                int i3 = paddingTop2 - barCodeConfiguration.textSize;
                this.s = i3;
                this.s = i3 - barCodeConfiguration.gapBetweenBarcodeAndNumber;
            }
        } else {
            BarCodeConfiguration barCodeConfiguration2 = this.i;
            if (barCodeConfiguration2.isDisplayTextOfPaymentCode) {
                round2 = round2 + barCodeConfiguration2.textSize + barCodeConfiguration2.gapBetweenBarcodeAndNumber;
            }
            paddingTop = getPaddingTop() + getPaddingBottom() + round2;
        }
        int i4 = this.r;
        int i5 = (paddingLeft - i4) / 2;
        int i6 = i4 + i5;
        this.l.set(i5, 0, i6, this.s);
        Rect rect = this.n;
        int i7 = this.j;
        rect.set(i7 + i5, 0, i6 - i7, this.s);
        int i8 = this.l.bottom;
        BarCodeConfiguration barCodeConfiguration3 = this.i;
        int i9 = i8 + barCodeConfiguration3.gapBetweenBarcodeAndNumber;
        this.k.setTypeface(barCodeConfiguration3.textTypeface);
        this.k.setTextSize(this.i.textSize);
        this.k.setAntiAlias(true);
        Rect rect2 = this.f6983o;
        int i10 = this.j;
        rect2.set(i5 + i10, i9, i6 - i10, (int) (i9 + this.k.getTextSize()));
        setMeasuredDimension(a2, paddingTop);
    }

    public void setBarcodeBackgroundColor(int i) {
        this.i.backgroundColor = i;
    }

    public void setBarcodeColor(int i) {
        this.i.paymentCodeColor = i;
    }

    public void setConfiguration(BarCodeConfiguration barCodeConfiguration) {
        if (barCodeConfiguration != null) {
            this.i = barCodeConfiguration;
            g();
        }
    }

    public void setDisplayNumberOfPaymentCode(boolean z) {
        this.i.isDisplayTextOfPaymentCode = z;
        requestLayout();
    }

    public void setGapBetweenBarcodeAndNumberInDip(int i) {
        this.i.gapBetweenBarcodeAndNumber = a.a(getResources(), i);
        requestLayout();
    }

    public void setGroupGapInDip(int i) {
        this.i.groupGap = a.a(getResources(), i);
        g();
    }

    public void setNumberTextColor(int i) {
        this.i.textColor = i;
    }

    public void setNumberTextSizeInDip(int i) {
        this.i.textSize = a.a(getResources(), i);
        g();
    }

    public void setNumberTextTypeface(Typeface typeface) {
        this.i.textTypeface = typeface;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    public void setPaymentCodeBitmap(Bitmap bitmap) {
        this.p = bitmap;
        if (bitmap != null) {
            this.m.set(0, 0, bitmap.getWidth(), this.p.getHeight());
        }
        g();
        setPaymentCodeState(PaymentCodeState.Success);
        invalidate();
    }

    public void setPerGroupLengthOfNumber(int i) {
        this.i.perGroupLengthOfText = i;
        g();
    }
}
