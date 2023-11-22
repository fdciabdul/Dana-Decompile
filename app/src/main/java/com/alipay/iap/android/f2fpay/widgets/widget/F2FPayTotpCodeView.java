package com.alipay.iap.android.f2fpay.widgets.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeState;

/* loaded from: classes6.dex */
public class F2FPayTotpCodeView extends F2FPayAbstractPaymentCodeView {
    private static float m = 0.2f;
    private CharSequence i;
    private float j;
    private float k;
    private TextView l;

    /* loaded from: classes6.dex */
    public class LetterSpacing {
        public static final float BIG = 0.05f;
        public static final float BIGGEST = 0.2f;
        public static final float NORMAL = 0.0f;
        public static final float NORMAL_BIG = 0.025f;

        public LetterSpacing(F2FPayTotpCodeView f2FPayTotpCodeView) {
        }
    }

    public F2FPayTotpCodeView(Context context) {
        super(context);
        this.i = "";
        a(context);
    }

    public F2FPayTotpCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = "";
        a(context);
    }

    public F2FPayTotpCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = "";
        a(context);
    }

    private void a(Context context) {
        TextView textView = new TextView(context);
        this.l = textView;
        textView.setGravity(17);
        addView(this.l, new ViewGroup.LayoutParams(-1, -1));
        float f = this.k;
        if (-1.0f != f) {
            this.l.setTextSize(2, f);
        }
        this.l.setSingleLine();
        this.l.setGravity(17);
        setLetterSpacing(this.j);
    }

    private void g() {
        if (this.i == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.i.length()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.i.charAt(i));
            sb.append(sb2.toString().toLowerCase());
            i++;
            if (i < this.i.length()) {
                sb.append(" ");
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (sb.toString().length() > 1) {
            for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                spannableString.setSpan(new ScaleXSpan((m + 1.0f) / 10.0f), i2, i2 + 1, 33);
            }
        }
        this.l.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void c() {
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void e() {
    }

    public float getLetterSpacing() {
        return Build.VERSION.SDK_INT >= 21 ? this.l.getLetterSpacing() : m;
    }

    public CharSequence getText() {
        return Build.VERSION.SDK_INT >= 21 ? this.l.getText() : this.i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    public void setLetterSpacing(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.l.setLetterSpacing(f);
            return;
        }
        m = f;
        g();
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    protected void setPaymentCodeBitmap(Bitmap bitmap) {
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.l.setText(charSequence, bufferType);
            return;
        }
        this.i = charSequence;
        g();
    }

    public void setTextColor(int i) {
        this.l.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.l.setTextSize(i);
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView
    public void updatePaymentCode(F2FPaymentCodeInfo f2FPaymentCodeInfo) {
        PaymentCodeState paymentCodeState;
        if (f2FPaymentCodeInfo != null) {
            if (!TextUtils.equals(this.c, f2FPaymentCodeInfo.totp)) {
                String str = f2FPaymentCodeInfo.totp;
                this.c = str;
                if (!TextUtils.isEmpty(str) && this.c.length() == 6) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.c.substring(0, 3));
                    sb.append("-");
                    sb.append(this.c.substring(3));
                    this.l.setText(sb.toString());
                    paymentCodeState = PaymentCodeState.Success;
                    setPaymentCodeState(paymentCodeState);
                }
            }
            postInvalidate();
        }
        paymentCodeState = PaymentCodeState.Failure;
        setPaymentCodeState(paymentCodeState);
        postInvalidate();
    }
}
