package com.alipay.biometrics.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import id.dana.lib.drawbitmap.style.Pallette;

/* loaded from: classes6.dex */
public class PromptTextView extends TextView {
    int mAnimationInterval;
    int mProcessColor;
    int mStepIndex;
    ValueAnimator mValueAnimator;

    public PromptTextView(Context context) {
        super(context);
        this.mProcessColor = Color.parseColor(Pallette.BLUE_50);
        this.mAnimationInterval = 1000;
    }

    public PromptTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProcessColor = Color.parseColor(Pallette.BLUE_50);
        this.mAnimationInterval = 1000;
    }

    public PromptTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProcessColor = Color.parseColor(Pallette.BLUE_50);
        this.mAnimationInterval = 1000;
    }

    public void setProcessColor(int i) {
        this.mProcessColor = i;
    }

    public void setAnimationInterval(int i) {
        this.mAnimationInterval = i;
    }

    public void startAnimation(int i) {
        int length = getText().length();
        if (i > length) {
            i = length;
        }
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mStepIndex, i);
        this.mValueAnimator = ofInt;
        ofInt.setDuration(this.mAnimationInterval);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alipay.biometrics.ui.widget.PromptTextView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                Integer num = (Integer) valueAnimator2.getAnimatedValue();
                if (PromptTextView.this.mStepIndex != ((Integer) valueAnimator2.getAnimatedValue()).intValue()) {
                    PromptTextView.this.setTextSpan(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
                PromptTextView.this.mStepIndex = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
            }
        });
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.start();
    }

    public void resetAnimation() {
        this.mStepIndex = 0;
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        setTextSpan(0);
    }

    public void cancelAnimation() {
        this.mValueAnimator.cancel();
    }

    public void setTextSpan(int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText().toString());
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mProcessColor), 0, i, 33);
        setText(spannableStringBuilder);
    }
}
