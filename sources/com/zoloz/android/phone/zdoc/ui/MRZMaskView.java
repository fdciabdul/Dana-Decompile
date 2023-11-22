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
public class MRZMaskView extends BaseMaskView {
    public static final float[] BOTTOM_RADII = {0.0f, 0.0f, 0.0f, 0.0f, 30.0f, 30.0f, 30.0f, 30.0f};
    public static final float ROUND_CORNER = 30.0f;

    public MRZMaskView(Context context) {
        super(context);
    }

    public MRZMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MRZMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected List<BaseMaskView.AbsMaskDrawer> getCoverDrawer(int i, int i2) {
        return toList(new BaseMaskView.CoverMaskDrawer(createPath()), new MRZMarkDrawer(createWriteCoverPath()));
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected List<BaseMaskView.AbsMaskDrawer> getFrameDrawer(int i, int i2) {
        return toList(new BaseMaskView.FrameMaskDrawer(createFramePath()));
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected RectF calcCaptureRect(int i, int i2) {
        float f = i;
        int i3 = (int) (0.05f * f);
        float f2 = f * 0.95f;
        return new RectF(i3, (int) (i2 * 0.2f), (int) f2, (int) (((f2 * 500.0f) / 712.0f) + r5));
    }

    private Path createWriteCoverPath() {
        RectF rectF = new RectF(this.mCaptureRect);
        rectF.top = this.mCaptureRect.top + (this.mCaptureRect.height() * 0.75f);
        Path path = new Path();
        path.addRoundRect(rectF, BOTTOM_RADII, Path.Direction.CCW);
        return path;
    }

    private Path createFramePath() {
        Path path = new Path();
        float height = this.mCaptureRect.top + (this.mCaptureRect.height() * 0.75f);
        path.moveTo(this.mCaptureRect.left, height);
        path.lineTo(this.mCaptureRect.right, height);
        path.addRoundRect(this.mCaptureRect, BOTTOM_RADII, Path.Direction.CCW);
        return path;
    }

    private Path createPath() {
        Path path = new Path();
        path.addRoundRect(this.mCaptureRect, BOTTOM_RADII, Path.Direction.CCW);
        return path;
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
            canvas.drawColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(MRZMaskView.this.getContext(), R.color.z_white_50));
            canvas.restore();
        }
    }
}
