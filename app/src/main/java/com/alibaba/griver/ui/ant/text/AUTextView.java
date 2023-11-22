package com.alibaba.griver.ui.ant.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.api.AUAttrsConstant;
import com.alibaba.griver.ui.ant.api.AUViewInterface;
import com.alibaba.griver.ui.ant.api.OnParseEmotionListener;
import com.alibaba.griver.ui.ant.helper.AUViewEventHelper;
import com.alibaba.griver.ui.ant.utils.AUAttrsUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.griver.ui.ant.utils.AUScreenUtils;

/* loaded from: classes6.dex */
public class AUTextView extends TextView implements AUViewInterface {

    /* renamed from: a  reason: collision with root package name */
    private static OnParseEmotionListener f6695a;
    private boolean b;
    private boolean c;
    private int d;
    private boolean e;
    private float f;
    private int g;
    private boolean h;
    private int i;
    private String j;
    private AttributeSet k;
    private float l;
    private int m;
    private int n;

    /* renamed from: o  reason: collision with root package name */
    private int f6696o;
    private int p;
    private OnTextViewTextChangeListener q;
    private OnVisibilityChangeListener r;
    private Boolean s;

    /* loaded from: classes6.dex */
    public interface OnTextViewTextChangeListener {
        void onTextViewTextChange(TextView textView, String str);
    }

    /* loaded from: classes6.dex */
    public interface OnVisibilityChangeListener {
        void onChange(int i);
    }

    private void a() {
    }

    public AUTextView(Context context) {
        super(context);
        this.d = 0;
        this.e = false;
        this.i = 9999;
        this.l = 1.0f;
        this.f = getTextSize();
        a();
    }

    public AUTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.e = false;
        this.i = 9999;
        this.l = 1.0f;
        a(context, attributeSet);
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            AUAttrsUtils.adptApPadding(this, context);
        }
    }

    public AUTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = false;
        this.i = 9999;
        this.l = 1.0f;
        a(context, attributeSet);
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            AUAttrsUtils.adptApPadding(this, context);
        }
    }

    public void setOnVisibilityChangeListener(OnVisibilityChangeListener onVisibilityChangeListener) {
        this.r = onVisibilityChangeListener;
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (AUScreenUtils.checkApFlag(getContext(), this.k, this) && i == 1) {
            f = AUScreenAdaptTool.getApFromDp(getContext(), f);
            i = 0;
        }
        if (this.e) {
            super.setTextSize(i, f);
            this.f = getTextSize();
            a();
            return;
        }
        float applyDimension = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
        this.f = applyDimension;
        super.setTextSize(0, this.l * applyDimension);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.k = attributeSet;
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.griveremojiAttr);
        this.j = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", AUAttrsConstant.VIEW_HEIGHT);
        this.b = obtainStyledAttributes.getBoolean(R.styleable.griveremojiAttr_supportEmoji, false);
        this.c = obtainStyledAttributes.getBoolean(R.styleable.griveremojiAttr_supportEmotion, false);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.griveremojiAttr_emojiSize, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.griverTextAttr);
        this.e = obtainStyledAttributes2.getBoolean(R.styleable.griverTextAttr_dynamicTextSize, false);
        obtainStyledAttributes2.recycle();
        setApTextSize(attributeSet);
        this.f = getTextSize();
        a();
        this.n = getPaddingTop();
        this.m = getPaddingBottom();
        this.f6696o = getPaddingLeft();
        this.p = getPaddingRight();
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            AUAttrsUtils.adptApPadding(this, context);
        }
    }

    private void setApTextSize(AttributeSet attributeSet) {
        int apFromAttrsStr;
        if (AUScreenUtils.checkApFlag(getContext(), attributeSet, this)) {
            String str = (String) AUAttrsUtils.handleAttrs(attributeSet).get(AUAttrsConstant.TV_TEXTSIZE);
            if (TextUtils.isEmpty(str)) {
                apFromAttrsStr = AUScreenAdaptTool.getApFromPx(getContext(), getTextSize());
            } else {
                apFromAttrsStr = AUScreenAdaptTool.getApFromAttrsStr(getContext(), str);
            }
            super.setTextSize(0, apFromAttrsStr);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(AUViewEventHelper.wrapClickListener(onClickListener));
    }

    private void a(int i) {
        if (i < 0) {
            return;
        }
        CharSequence text = getText();
        CharSequence ellipsize = TextUtils.ellipsize(text, getPaint(), i, getEllipsize());
        if (TextUtils.equals(ellipsize, text)) {
            return;
        }
        if (text.length() > ellipsize.length()) {
            b(i);
        }
        setText(ellipsize);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        if ((this.b || this.c) && isSingleLine() && AUAttrsConstant.WRAP_CONTENT.equals(this.j)) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(((int) (getTextSize() + DensityUtil.getTextSize(AUScreenAdaptTool.getApFromDp(getContext(), 6.0f), 1))) + getPaddingTop() + getPaddingBottom(), 1073741824));
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a();
        if (((!this.b || this.g <= 0) && !(this.c && this.h)) || getEllipsize() == null || !isSingleLine()) {
            return;
        }
        int leftPaddingOffset = ((i3 - i) - getLeftPaddingOffset()) - getRightPaddingOffset();
        int i5 = this.i;
        if (i5 != 9999) {
            leftPaddingOffset = Math.max(leftPaddingOffset, i5);
        }
        a(leftPaddingOffset);
    }

    private void b(int i) {
        int i2 = this.i;
        if (i2 == 9999) {
            this.i = i;
        } else {
            this.i = Math.max(i, i2);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        SpannableStringBuilder spannableStringBuilder;
        OnParseEmotionListener onParseEmotionListener;
        boolean z = this.b;
        if ((z || this.c) && charSequence != null) {
            if (z) {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
            } else {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
            }
            if (this.c && (onParseEmotionListener = f6695a) != null) {
                this.h = onParseEmotionListener.parser(getContext(), spannableStringBuilder, charSequence, getEmojiSize());
            }
            if ((this.g > 0 || this.h) && getEllipsize() != null) {
                if (isSingleLine()) {
                    a(spannableStringBuilder, bufferType);
                } else {
                    super.setText(spannableStringBuilder, bufferType);
                }
            } else {
                super.setText(spannableStringBuilder, bufferType);
            }
            OnTextViewTextChangeListener onTextViewTextChangeListener = this.q;
            if (onTextViewTextChangeListener == null || charSequence == null) {
                return;
            }
            onTextViewTextChangeListener.onTextViewTextChange(this, spannableStringBuilder.toString());
            return;
        }
        super.setText(charSequence, bufferType);
        OnTextViewTextChangeListener onTextViewTextChangeListener2 = this.q;
        if (onTextViewTextChangeListener2 == null || charSequence == null) {
            return;
        }
        onTextViewTextChangeListener2.onTextViewTextChange(this, charSequence.toString());
    }

    private void a(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(TextUtils.ellipsize(charSequence, getPaint(), this.i, getEllipsize()), bufferType);
    }

    @Override // android.widget.TextView
    public boolean isSingleLine() {
        return getMaxLines() == 1;
    }

    public void setAutoSplitText(String str) {
        setText(str);
        getViewTreeObserver().addOnGlobalLayoutListener(new OnTvGlobalLayoutListener());
    }

    public void setBoldAutoSplitText(String str) {
        if (str == null) {
            str = "";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 0);
        setText(spannableString);
        getViewTreeObserver().addOnGlobalLayoutListener(new OnTvGlobalLayoutListener());
    }

    public int getEmojiSize() {
        int i = this.d;
        return i <= 0 ? ((int) getTextSize()) + AUScreenAdaptTool.getApFromDp(getContext(), 2.0f) : i;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        OnVisibilityChangeListener onVisibilityChangeListener = this.r;
        if (onVisibilityChangeListener != null) {
            onVisibilityChangeListener.onChange(i);
        }
    }

    @Override // com.alibaba.griver.ui.ant.api.AUViewInterface
    public Boolean isAP() {
        return this.s;
    }

    @Override // com.alibaba.griver.ui.ant.api.AUViewInterface
    public void setAP(Boolean bool) {
        this.s = bool;
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        if (this.e) {
            super.setTextSize(f);
            return;
        }
        this.f = TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
        super.setTextSize(f * this.l);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f6696o = i;
        this.n = i2;
        this.p = i3;
        this.m = i4;
        if (!this.e) {
            float f = this.l;
            super.setPadding((int) (i * f), (int) (i2 * f), (int) (i3 * f), (int) (i4 * f));
            return;
        }
        super.setPadding(i, i2, i3, i4);
    }

    /* loaded from: classes6.dex */
    class OnTvGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private OnTvGlobalLayoutListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                AUTextView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } catch (Throwable th) {
                GriverLogger.e("commonui", th.toString());
            }
        }
    }
}
