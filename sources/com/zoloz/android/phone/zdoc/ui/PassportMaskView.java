package com.zoloz.android.phone.zdoc.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.zoloz.android.phone.zdoc.R;
import com.zoloz.android.phone.zdoc.ui.BaseMaskView;
import java.util.List;

/* loaded from: classes8.dex */
public class PassportMaskView extends BaseMaskView {
    public PassportMaskView(Context context) {
        super(context);
    }

    public PassportMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PassportMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected List<BaseMaskView.AbsMaskDrawer> getCoverDrawer(int i, int i2) {
        return toList(new BaseMaskView.CoverMaskDrawer(createCoverPath()));
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected List<BaseMaskView.AbsMaskDrawer> getFrameDrawer(int i, int i2) {
        return toList(new BaseMaskView.FrameMaskDrawer(createFramePath()));
    }

    private Path createCoverPath() {
        Path path = new Path();
        path.addRoundRect(this.mCaptureRect, 30.0f, 30.0f, Path.Direction.CCW);
        return path;
    }

    private Path createFramePath() {
        Path path = new Path();
        path.addRoundRect(this.mCaptureRect, 30.0f, 30.0f, Path.Direction.CCW);
        float height = this.mCaptureRect.top + (this.mCaptureRect.height() / 2.0f);
        path.moveTo(this.mCaptureRect.left, height);
        path.lineTo(this.mCaptureRect.right, height);
        float height2 = this.mCaptureRect.top + ((this.mCaptureRect.height() * 388.0f) / 448.0f);
        path.moveTo(this.mCaptureRect.left, height2);
        path.lineTo(this.mCaptureRect.right, height2);
        return path;
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected RectF calcCaptureRect(int i, int i2) {
        double d = i;
        Double.isNaN(d);
        int i3 = (int) (0.1d * d);
        Double.isNaN(d);
        int i4 = (int) (0.9d * d);
        double d2 = i2;
        Double.isNaN(d2);
        int i5 = (int) (0.15d * d2);
        double d3 = i5;
        Double.isNaN(d);
        Double.isNaN(d3);
        int i6 = (int) (d3 + (((d * 0.8d) * 448.0d) / 315.0d));
        if (getInvisibleHeight() + i6 > getHeight()) {
            double height = getHeight() - getInvisibleHeight();
            Double.isNaN(d2);
            Double.isNaN(height);
            i6 = (int) (height - (d2 * 0.05d));
            int width = (int) ((getWidth() - r10) / 2.0f);
            i4 = width + ((int) (((i6 - i5) * 315) / 448.0f));
            i3 = width;
        }
        return new RectF(i3, i5, i4, i6);
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    public int getTipsBottomMargin() {
        double height = getHeight();
        Double.isNaN(height);
        return (int) (height * 0.85d);
    }

    /* loaded from: classes8.dex */
    class MRZMarkDrawer extends BaseMaskView.AbsMaskDrawer {
        public MRZMarkDrawer(Path path) {
            super(path);
        }

        @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView.AbsMaskDrawer
        public void draw(Canvas canvas, Paint paint) {
            canvas.save();
            canvas.clipPath(this.mPath, Region.Op.INTERSECT);
            canvas.drawColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(PassportMaskView.this.getContext(), R.color.z_white_50));
            canvas.restore();
        }
    }
}
