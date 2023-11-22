package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;

/* loaded from: classes6.dex */
public class AsyncDrawableSpan extends ReplacementSpan {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    public final AsyncDrawable KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory = 0;
    private final SpannableTheme getAuthRequestContext;

    public AsyncDrawableSpan(SpannableTheme spannableTheme, AsyncDrawable asyncDrawable, boolean z) {
        this.getAuthRequestContext = spannableTheme;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = asyncDrawable;
        this.BuiltInFictitiousFunctionClassFactory = z;
        if (asyncDrawable.getBounds().isEmpty()) {
            asyncDrawable.setBounds(0, 0, asyncDrawable.getIntrinsicWidth(), asyncDrawable.getIntrinsicHeight());
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2()) {
            Rect bounds = this.KClassImpl$Data$declaredNonStaticMembers$2.getBounds();
            if (fontMetricsInt != null) {
                fontMetricsInt.ascent = -bounds.bottom;
                fontMetricsInt.descent = 0;
                fontMetricsInt.top = fontMetricsInt.ascent;
                fontMetricsInt.bottom = 0;
            }
            return bounds.right;
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            this.getAuthRequestContext.MyBillsEntityDataFactory(paint);
        }
        return (int) (paint.measureText(charSequence, i, i2) + 0.5f);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        AsyncDrawable asyncDrawable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int width = canvas.getWidth();
        float textSize = paint.getTextSize();
        asyncDrawable.KClassImpl$Data$declaredNonStaticMembers$2 = width;
        asyncDrawable.getAuthRequestContext = textSize;
        AsyncDrawable asyncDrawable2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (asyncDrawable2.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int i7 = i5 - asyncDrawable2.getBounds().bottom;
            int save = canvas.save();
            try {
                int i8 = this.MyBillsEntityDataFactory;
                if (2 == i8) {
                    i6 = ((i5 - i3) - asyncDrawable2.getBounds().height()) / 2;
                } else {
                    if (1 == i8) {
                        i6 = paint.getFontMetricsInt().descent;
                    }
                    canvas.translate(f, i7);
                    asyncDrawable2.draw(canvas);
                    return;
                }
                i7 -= i6;
                canvas.translate(f, i7);
                asyncDrawable2.draw(canvas);
                return;
            } finally {
                canvas.restoreToCount(save);
            }
        }
        float authRequestContext = CanvasUtils.getAuthRequestContext(i3, i5, paint);
        if (this.BuiltInFictitiousFunctionClassFactory) {
            this.getAuthRequestContext.MyBillsEntityDataFactory(paint);
        }
        canvas.drawText(charSequence, i, i2, f, authRequestContext, paint);
    }
}
