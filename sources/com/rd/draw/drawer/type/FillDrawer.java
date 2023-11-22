package com.rd.draw.drawer.type;

import android.graphics.Paint;
import com.rd.draw.data.Indicator;

/* loaded from: classes3.dex */
public class FillDrawer extends BaseDrawer {
    public Paint BuiltInFictitiousFunctionClassFactory;

    public FillDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
        Paint paint2 = new Paint();
        this.BuiltInFictitiousFunctionClassFactory = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.BuiltInFictitiousFunctionClassFactory.setAntiAlias(true);
    }
}
