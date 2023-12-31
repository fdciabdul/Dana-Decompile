package com.zoloz.android.phone.zdoc.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.zoloz.android.phone.zdoc.R2;
import com.zoloz.android.phone.zdoc.ui.BaseMaskView;
import java.util.List;

/* loaded from: classes8.dex */
public class DefaultMaskView extends BaseMaskView {
    private Paint mCornerPaint;

    public DefaultMaskView(Context context) {
        super(context);
    }

    public DefaultMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DefaultMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected List<BaseMaskView.AbsMaskDrawer> getCoverDrawer(int i, int i2) {
        return toList(new BaseMaskView.CoverMaskDrawer(createPath(i, i2)));
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected List<BaseMaskView.AbsMaskDrawer> getFrameDrawer(int i, int i2) {
        return toList(new BaseMaskView.FrameMaskDrawer(createPath(i, i2)), new CornerFrameDrawer(createCornersPath()));
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected RectF calcCaptureRect(int i, int i2) {
        float f = i;
        int i3 = (int) (0.05f * f);
        float f2 = f * 0.95f;
        return new RectF(i3, (int) (i2 * 0.2f), (int) f2, (int) (((f2 * 436.0f) / 682.0f) + r5));
    }

    private Path createPath(int i, int i2) {
        Path path = new Path();
        path.addRoundRect(this.mCaptureRect, 0.0f, 0.0f, Path.Direction.CCW);
        return path;
    }

    private Path createCornersPath() {
        float f = this.mCaptureRect.left;
        float f2 = this.mCaptureRect.top;
        float f3 = this.mCaptureRect.right;
        float f4 = this.mCaptureRect.bottom;
        int i = (int) (getContext().getResources().getDisplayMetrics().density * 20.0f);
        Path path = new Path();
        float f5 = i;
        float f6 = f2 + f5;
        path.moveTo(f, f6);
        path.lineTo(f, f2);
        float f7 = f + f5;
        path.lineTo(f7, f2);
        float f8 = f3 - f5;
        path.moveTo(f8, f2);
        path.lineTo(f3, f2);
        path.lineTo(f3, f6);
        float f9 = f4 - f5;
        path.moveTo(f, f9);
        path.lineTo(f, f4);
        path.lineTo(f7, f4);
        path.moveTo(f8, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3, f9);
        return path;
    }

    /* loaded from: classes8.dex */
    class CornerFrameDrawer extends BaseMaskView.AbsMaskDrawer {
        public CornerFrameDrawer(Path path) {
            super(path);
        }

        @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView.AbsMaskDrawer
        public void draw(Canvas canvas, Paint paint) {
            if (R2.bool.zdoc_frame_corner()) {
                if (DefaultMaskView.this.mCornerPaint == null) {
                    DefaultMaskView.this.createPaint();
                }
                canvas.save();
                canvas.drawPath(this.mPath, DefaultMaskView.this.mCornerPaint);
                canvas.restore();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPaint() {
        CornerPathEffect cornerPathEffect = new CornerPathEffect((int) (getContext().getResources().getDisplayMetrics().density * 5.0f));
        int zdoc_line_cornor_color = R2.color.zdoc_line_cornor_color();
        Paint paint = new Paint(4);
        this.mCornerPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mCornerPaint.setColor(zdoc_line_cornor_color);
        this.mCornerPaint.setAntiAlias(true);
        this.mCornerPaint.setStrokeWidth(((int) (getStokeWidth() * getContext().getResources().getDisplayMetrics().density)) * 3);
        this.mCornerPaint.setPathEffect(cornerPathEffect);
    }
}
