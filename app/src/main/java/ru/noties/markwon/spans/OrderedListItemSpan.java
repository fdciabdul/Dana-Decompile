package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* loaded from: classes6.dex */
public class OrderedListItemSpan implements LeadingMarginSpan {
    private final SpannableTheme BuiltInFictitiousFunctionClassFactory;
    private final Paint KClassImpl$Data$declaredNonStaticMembers$2 = ObjectsPool.getAuthRequestContext();
    private int MyBillsEntityDataFactory;
    private final String PlaceComponentResult;

    public OrderedListItemSpan(SpannableTheme spannableTheme, String str) {
        this.BuiltInFictitiousFunctionClassFactory = spannableTheme;
        this.PlaceComponentResult = str;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        int i = this.MyBillsEntityDataFactory;
        return i <= 0 ? this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory() : i;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (z && LeadingMarginUtils.PlaceComponentResult(i6, charSequence, this)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.set(paint);
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
            int measureText = (int) (paint.measureText(this.PlaceComponentResult) + 0.5f);
            int BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            if (measureText > BuiltInFictitiousFunctionClassFactory) {
                this.MyBillsEntityDataFactory = measureText;
                BuiltInFictitiousFunctionClassFactory = measureText;
            } else {
                this.MyBillsEntityDataFactory = 0;
            }
            canvas.drawText(this.PlaceComponentResult, i2 > 0 ? (i + (BuiltInFictitiousFunctionClassFactory * i2)) - measureText : i + (i2 * BuiltInFictitiousFunctionClassFactory) + (BuiltInFictitiousFunctionClassFactory - measureText), i4, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}
