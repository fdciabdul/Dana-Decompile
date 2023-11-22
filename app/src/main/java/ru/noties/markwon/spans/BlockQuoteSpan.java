package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* loaded from: classes6.dex */
public class BlockQuoteSpan implements LeadingMarginSpan {
    private final Rect KClassImpl$Data$declaredNonStaticMembers$2;
    private final SpannableTheme MyBillsEntityDataFactory;
    private final Paint PlaceComponentResult;

    public BlockQuoteSpan(SpannableTheme spannableTheme) {
        Rect rect;
        rect = ObjectsPool.PlaceComponentResult;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = rect;
        this.PlaceComponentResult = ObjectsPool.getAuthRequestContext();
        this.MyBillsEntityDataFactory = spannableTheme;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        this.PlaceComponentResult.set(paint);
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
        int i8 = i2 * KClassImpl$Data$declaredNonStaticMembers$2;
        int i9 = i + i8;
        int i10 = i8 + i9;
        this.KClassImpl$Data$declaredNonStaticMembers$2.set(Math.min(i9, i10), i3, Math.max(i9, i10), i5);
        canvas.drawRect(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
    }
}
