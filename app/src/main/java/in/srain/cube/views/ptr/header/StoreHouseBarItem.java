package in.srain.cube.views.ptr.header;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.fullstory.instrumentation.FSDraw;
import java.util.Random;

/* loaded from: classes9.dex */
public class StoreHouseBarItem extends Animation implements FSDraw {
    public int index;
    private PointF mCEndPoint;
    private PointF mCStartPoint;
    private float mFromAlpha;
    private final Paint mPaint;
    private float mToAlpha;
    public PointF midPoint;
    public float translationX;

    public StoreHouseBarItem(int i, PointF pointF, PointF pointF2, int i2, int i3) {
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mFromAlpha = 1.0f;
        this.mToAlpha = 0.4f;
        this.index = i;
        this.midPoint = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        this.mCStartPoint = new PointF(pointF.x - this.midPoint.x, pointF.y - this.midPoint.y);
        this.mCEndPoint = new PointF(pointF2.x - this.midPoint.x, pointF2.y - this.midPoint.y);
        setColor(i2);
        setLineWidth(i3);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void setLineWidth(int i) {
        this.mPaint.setStrokeWidth(i);
    }

    public void setColor(int i) {
        this.mPaint.setColor(i);
    }

    public void resetPosition(int i) {
        this.translationX = (-new Random().nextInt(i)) + i;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mFromAlpha;
        setAlpha(f2 + ((this.mToAlpha - f2) * f));
    }

    public void start(float f, float f2) {
        this.mFromAlpha = f;
        this.mToAlpha = f2;
        super.start();
    }

    public void setAlpha(float f) {
        this.mPaint.setAlpha((int) (f * 255.0f));
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(this.mCStartPoint.x, this.mCStartPoint.y, this.mCEndPoint.x, this.mCEndPoint.y, this.mPaint);
    }
}
