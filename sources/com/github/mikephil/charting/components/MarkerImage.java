package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class MarkerImage implements IMarker {
    private FSize BuiltInFictitiousFunctionClassFactory;
    private Rect KClassImpl$Data$declaredNonStaticMembers$2;
    private MPPointF MyBillsEntityDataFactory;
    private MPPointF PlaceComponentResult;
    private Drawable getAuthRequestContext;
    private WeakReference<Chart> moveToNextValue;

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas canvas, float f, float f2) {
        Drawable drawable;
        Drawable drawable2;
        if (this.getAuthRequestContext == null) {
            return;
        }
        MPPointF mPPointF = this.PlaceComponentResult;
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = mPPointF.KClassImpl$Data$declaredNonStaticMembers$2;
        this.MyBillsEntityDataFactory.PlaceComponentResult = mPPointF.PlaceComponentResult;
        WeakReference<Chart> weakReference = this.moveToNextValue;
        Chart chart = weakReference == null ? null : weakReference.get();
        float f3 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        float f4 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
        if (f3 == 0.0f && (drawable2 = this.getAuthRequestContext) != null) {
            f3 = drawable2.getIntrinsicWidth();
        }
        if (f4 == 0.0f && (drawable = this.getAuthRequestContext) != null) {
            f4 = drawable.getIntrinsicHeight();
        }
        if (this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 + f < 0.0f) {
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = -f;
        } else if (chart != null && f + f3 + this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 > chart.getWidth()) {
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (chart.getWidth() - f) - f3;
        }
        if (this.MyBillsEntityDataFactory.PlaceComponentResult + f2 < 0.0f) {
            this.MyBillsEntityDataFactory.PlaceComponentResult = -f2;
        } else if (chart != null && f2 + f4 + this.MyBillsEntityDataFactory.PlaceComponentResult > chart.getHeight()) {
            this.MyBillsEntityDataFactory.PlaceComponentResult = (chart.getHeight() - f2) - f4;
        }
        MPPointF mPPointF2 = this.MyBillsEntityDataFactory;
        float f5 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        float f6 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
        if (f5 == 0.0f) {
            f5 = this.getAuthRequestContext.getIntrinsicWidth();
        }
        if (f6 == 0.0f) {
            f6 = this.getAuthRequestContext.getIntrinsicHeight();
        }
        this.getAuthRequestContext.copyBounds(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.getAuthRequestContext.setBounds(this.KClassImpl$Data$declaredNonStaticMembers$2.left, this.KClassImpl$Data$declaredNonStaticMembers$2.top, this.KClassImpl$Data$declaredNonStaticMembers$2.left + ((int) f5), this.KClassImpl$Data$declaredNonStaticMembers$2.top + ((int) f6));
        int save = canvas.save();
        canvas.translate(f + mPPointF2.KClassImpl$Data$declaredNonStaticMembers$2, f2 + mPPointF2.PlaceComponentResult);
        this.getAuthRequestContext.draw(canvas);
        canvas.restoreToCount(save);
        this.getAuthRequestContext.setBounds(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
