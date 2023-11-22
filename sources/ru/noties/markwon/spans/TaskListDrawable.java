package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes6.dex */
public class TaskListDrawable extends Drawable implements FSDraw {
    private final Paint KClassImpl$Data$declaredNonStaticMembers$2;
    private final Path MyBillsEntityDataFactory;
    private final Paint NetworkUserEntityData$$ExternalSyntheticLambda0 = new Paint(1);
    private final RectF getErrorConfigVersion = new RectF();
    private final int lookAheadTest;
    private boolean moveToNextValue;
    private final int scheduleImpl;
    private static final Point BuiltInFictitiousFunctionClassFactory = new Point(0.15277778f, 0.45833334f);
    private static final Point getAuthRequestContext = new Point(0.3888889f, 0.6944444f);
    private static final Point PlaceComponentResult = new Point(0.8472222f, 0.2638889f);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public TaskListDrawable(int i, int i2, int i3) {
        Paint paint = new Paint(1);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = paint;
        this.MyBillsEntityDataFactory = new Path();
        this.scheduleImpl = i;
        this.lookAheadTest = i2;
        paint.setColor(i3);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        float min = Math.min(rect.width(), rect.height());
        float f = min / 8.0f;
        float f2 = min - f;
        this.getErrorConfigVersion.set(0.0f, 0.0f, f2, f2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStrokeWidth(f);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setStrokeWidth(f);
        this.MyBillsEntityDataFactory.reset();
        Point point = BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory.moveTo(point.KClassImpl$Data$declaredNonStaticMembers$2 * f2, point.MyBillsEntityDataFactory * f2);
        Point point2 = getAuthRequestContext;
        this.MyBillsEntityDataFactory.lineTo(point2.KClassImpl$Data$declaredNonStaticMembers$2 * f2, point2.MyBillsEntityDataFactory * f2);
        Point point3 = PlaceComponentResult;
        this.MyBillsEntityDataFactory.lineTo(point3.KClassImpl$Data$declaredNonStaticMembers$2 * f2, f2 * point3.MyBillsEntityDataFactory);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint.Style style;
        int i;
        if (this.moveToNextValue) {
            style = Paint.Style.FILL_AND_STROKE;
            i = this.scheduleImpl;
        } else {
            style = Paint.Style.STROKE;
            i = this.lookAheadTest;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStyle(style);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColor(i);
        Rect bounds = getBounds();
        float width = (bounds.width() - this.getErrorConfigVersion.width()) / 2.0f;
        float height = (bounds.height() - this.getErrorConfigVersion.height()) / 2.0f;
        float width2 = this.getErrorConfigVersion.width() / 8.0f;
        int save = canvas.save();
        try {
            canvas.translate(width, height);
            canvas.drawRoundRect(this.getErrorConfigVersion, width2, width2, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            if (this.moveToNextValue) {
                canvas.drawPath(this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z;
        int length = iArr != null ? iArr.length : 0;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (16842912 == iArr[i]) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z2 = z != this.moveToNextValue;
        if (z2) {
            invalidateSelf();
            this.moveToNextValue = z;
        }
        return z2;
    }

    /* loaded from: classes6.dex */
    static class Point {
        final float KClassImpl$Data$declaredNonStaticMembers$2;
        final float MyBillsEntityDataFactory;

        Point(float f, float f2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
            this.MyBillsEntityDataFactory = f2;
        }
    }
}
