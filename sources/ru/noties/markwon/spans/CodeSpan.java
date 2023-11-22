package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes6.dex */
public class CodeSpan extends MetricAffectingSpan implements LeadingMarginSpan {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final Paint KClassImpl$Data$declaredNonStaticMembers$2;
    private final SpannableTheme MyBillsEntityDataFactory;
    private final Rect PlaceComponentResult;

    public CodeSpan(SpannableTheme spannableTheme, boolean z) {
        Rect rect;
        rect = ObjectsPool.PlaceComponentResult;
        this.PlaceComponentResult = rect;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ObjectsPool.getAuthRequestContext();
        this.MyBillsEntityDataFactory = spannableTheme;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return this.MyBillsEntityDataFactory.PlaceComponentResult();
        }
        return 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        if (this.BuiltInFictitiousFunctionClassFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setStyle(Paint.Style.FILL);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setColor(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(paint, true));
            if (i2 > 0) {
                i8 = canvas.getWidth();
            } else {
                i -= canvas.getWidth();
                i8 = i;
            }
            this.PlaceComponentResult.set(i, i3, i8, i5);
            canvas.drawRect(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(textPaint, this.BuiltInFictitiousFunctionClassFactory);
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        textPaint.bgColor = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory((Paint) textPaint, false);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(textPaint, this.BuiltInFictitiousFunctionClassFactory);
    }
}
