package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* loaded from: classes6.dex */
public class ThematicBreakSpan implements LeadingMarginSpan {
    private final Paint BuiltInFictitiousFunctionClassFactory;
    private final Rect MyBillsEntityDataFactory;
    private final SpannableTheme PlaceComponentResult;

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 0;
    }

    public ThematicBreakSpan(SpannableTheme spannableTheme) {
        Rect rect;
        rect = ObjectsPool.PlaceComponentResult;
        this.MyBillsEntityDataFactory = rect;
        this.BuiltInFictitiousFunctionClassFactory = ObjectsPool.getAuthRequestContext();
        this.PlaceComponentResult = spannableTheme;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        int i9 = i3 + ((i5 - i3) / 2);
        this.BuiltInFictitiousFunctionClassFactory.set(paint);
        this.PlaceComponentResult.getErrorConfigVersion(this.BuiltInFictitiousFunctionClassFactory);
        int strokeWidth = (int) ((((int) (this.BuiltInFictitiousFunctionClassFactory.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
        if (i2 > 0) {
            i8 = canvas.getWidth();
        } else {
            i8 = i;
            i -= canvas.getWidth();
        }
        this.MyBillsEntityDataFactory.set(i, i9 - strokeWidth, i8, i9 + strokeWidth);
        canvas.drawRect(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
    }
}
