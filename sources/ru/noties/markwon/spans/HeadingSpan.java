package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes6.dex */
public class HeadingSpan extends MetricAffectingSpan implements LeadingMarginSpan {
    private final SpannableTheme BuiltInFictitiousFunctionClassFactory;
    private final Rect MyBillsEntityDataFactory;
    private final int PlaceComponentResult;
    private final Paint getAuthRequestContext;

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 0;
    }

    public HeadingSpan(SpannableTheme spannableTheme, int i) {
        Rect rect;
        rect = ObjectsPool.PlaceComponentResult;
        this.MyBillsEntityDataFactory = rect;
        this.getAuthRequestContext = ObjectsPool.getAuthRequestContext();
        this.BuiltInFictitiousFunctionClassFactory = spannableTheme;
        this.PlaceComponentResult = i;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        int i9 = this.PlaceComponentResult;
        if ((i9 == 1 || i9 == 2) && LeadingMarginUtils.getAuthRequestContext(i7, charSequence, this)) {
            this.getAuthRequestContext.set(paint);
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.getAuthRequestContext);
            float strokeWidth = this.getAuthRequestContext.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i10 = (int) ((i5 - strokeWidth) + 0.5f);
                if (i2 > 0) {
                    i8 = canvas.getWidth();
                } else {
                    i8 = i;
                    i -= canvas.getWidth();
                }
                this.MyBillsEntityDataFactory.set(i, i10, i8, i5);
                canvas.drawRect(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
            }
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(textPaint, this.PlaceComponentResult);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(textPaint, this.PlaceComponentResult);
    }
}
