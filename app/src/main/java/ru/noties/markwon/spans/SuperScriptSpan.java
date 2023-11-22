package ru.noties.markwon.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes6.dex */
public class SuperScriptSpan extends MetricAffectingSpan {
    private final SpannableTheme MyBillsEntityDataFactory;

    public SuperScriptSpan(SpannableTheme spannableTheme) {
        this.MyBillsEntityDataFactory = spannableTheme;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(textPaint);
    }
}
