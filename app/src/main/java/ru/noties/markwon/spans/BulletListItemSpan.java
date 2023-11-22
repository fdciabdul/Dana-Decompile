package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* loaded from: classes6.dex */
public class BulletListItemSpan implements LeadingMarginSpan {
    private SpannableTheme KClassImpl$Data$declaredNonStaticMembers$2;
    private final int PlaceComponentResult;
    private final Rect getAuthRequestContext;
    private final Paint BuiltInFictitiousFunctionClassFactory = ObjectsPool.getAuthRequestContext();
    private final RectF MyBillsEntityDataFactory = ObjectsPool.PlaceComponentResult();

    public BulletListItemSpan(SpannableTheme spannableTheme, int i) {
        Rect rect;
        rect = ObjectsPool.PlaceComponentResult;
        this.getAuthRequestContext = rect;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = spannableTheme;
        this.PlaceComponentResult = i;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (z && LeadingMarginUtils.PlaceComponentResult(i6, charSequence, this)) {
            this.BuiltInFictitiousFunctionClassFactory.set(paint);
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
            int save = canvas.save();
            try {
                int BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                int KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2((int) ((this.BuiltInFictitiousFunctionClassFactory.descent() - this.BuiltInFictitiousFunctionClassFactory.ascent()) + 0.5f));
                int i8 = i + (((BuiltInFictitiousFunctionClassFactory - KClassImpl$Data$declaredNonStaticMembers$2) / 2) * i2);
                int i9 = (i2 * KClassImpl$Data$declaredNonStaticMembers$2) + i8;
                int min = Math.min(i8, i9);
                int max = Math.max(i8, i9);
                int descent = (i4 + ((int) (((this.BuiltInFictitiousFunctionClassFactory.descent() + this.BuiltInFictitiousFunctionClassFactory.ascent()) / 2.0f) + 0.5f))) - (KClassImpl$Data$declaredNonStaticMembers$2 / 2);
                int i10 = KClassImpl$Data$declaredNonStaticMembers$2 + descent;
                int i11 = this.PlaceComponentResult;
                if (i11 == 0 || i11 == 1) {
                    this.MyBillsEntityDataFactory.set(min, descent, max, i10);
                    this.BuiltInFictitiousFunctionClassFactory.setStyle(this.PlaceComponentResult == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                    canvas.drawOval(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
                } else {
                    this.getAuthRequestContext.set(min, descent, max, i10);
                    this.BuiltInFictitiousFunctionClassFactory.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
                }
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }
}
