package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.flexbox.FlexItem;

/* loaded from: classes3.dex */
public abstract class LineRadarRenderer extends LineScatterCandleRadarRenderer {
    public LineRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas, Path path, Drawable drawable) {
        if (MyBillsEntityDataFactory()) {
            int save = canvas.save();
            canvas.clipPath(path);
            drawable.setBounds((int) this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), (int) this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue(), (int) this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), (int) this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fill-drawables not (yet) supported below API level 18, this code was run on API level ");
        sb.append(Utils.getAuthRequestContext());
        sb.append(".");
        throw new RuntimeException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(Canvas canvas, Path path, int i, int i2) {
        int i3 = (i & FlexItem.MAX_SIZE) | (i2 << 24);
        if (MyBillsEntityDataFactory()) {
            int save = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i3);
            canvas.restoreToCount(save);
            return;
        }
        Paint.Style style = this.lookAheadTest.getStyle();
        int color = this.lookAheadTest.getColor();
        this.lookAheadTest.setStyle(Paint.Style.FILL);
        this.lookAheadTest.setColor(i3);
        canvas.drawPath(path, this.lookAheadTest);
        this.lookAheadTest.setColor(color);
        this.lookAheadTest.setStyle(style);
    }

    private static boolean MyBillsEntityDataFactory() {
        return Utils.getAuthRequestContext() >= 18;
    }
}
