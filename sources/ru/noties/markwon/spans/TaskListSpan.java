package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* loaded from: classes6.dex */
public class TaskListSpan implements LeadingMarginSpan {
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean PlaceComponentResult;
    private final SpannableTheme getAuthRequestContext;
    private static final int[] MyBillsEntityDataFactory = {16842912};
    private static final int[] BuiltInFictitiousFunctionClassFactory = new int[0];

    public TaskListSpan(SpannableTheme spannableTheme, int i, boolean z) {
        this.getAuthRequestContext = spannableTheme;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = z;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory() * this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Drawable MyBillsEntityDataFactory2;
        int i8;
        int i9;
        int[] iArr;
        if (z && LeadingMarginUtils.PlaceComponentResult(i6, charSequence, this) && (MyBillsEntityDataFactory2 = this.getAuthRequestContext.MyBillsEntityDataFactory()) != null) {
            int save = canvas.save();
            try {
                int BuiltInFictitiousFunctionClassFactory2 = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
                int i10 = (int) ((BuiltInFictitiousFunctionClassFactory2 * 0.75f) + 0.5f);
                MyBillsEntityDataFactory2.setBounds(0, 0, i10, (int) (((i5 - i3) * 0.75f) + 0.5f));
                if (MyBillsEntityDataFactory2.isStateful()) {
                    if (this.PlaceComponentResult) {
                        iArr = MyBillsEntityDataFactory;
                    } else {
                        iArr = BuiltInFictitiousFunctionClassFactory;
                    }
                    MyBillsEntityDataFactory2.setState(iArr);
                }
                if (i2 > 0) {
                    i8 = i + ((this.KClassImpl$Data$declaredNonStaticMembers$2 - 1) * BuiltInFictitiousFunctionClassFactory2);
                    i9 = (BuiltInFictitiousFunctionClassFactory2 - i10) / 2;
                } else {
                    i8 = i - (this.KClassImpl$Data$declaredNonStaticMembers$2 * BuiltInFictitiousFunctionClassFactory2);
                    i9 = (BuiltInFictitiousFunctionClassFactory2 - i10) / 2;
                }
                canvas.translate(i8 + i9, i3 + ((r7 - r10) / 2));
                MyBillsEntityDataFactory2.draw(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }
}
