package ru.noties.markwon.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes6.dex */
public class SubScriptSpan extends MetricAffectingSpan {
    private final SpannableTheme BuiltInFictitiousFunctionClassFactory;

    public SubScriptSpan(SpannableTheme spannableTheme) {
        this.BuiltInFictitiousFunctionClassFactory = spannableTheme;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(textPaint);
    }
}
