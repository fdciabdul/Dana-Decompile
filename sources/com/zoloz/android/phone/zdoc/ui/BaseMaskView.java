package com.zoloz.android.phone.zdoc.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zoloz.android.phone.zdoc.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class BaseMaskView extends View {
    private int mBackgroundColor;
    private float mBottomMargin;
    protected RectF mCaptureRect;
    protected Paint mCoverPaint;
    protected Paint mFramePaint;
    private float mInvisibleHeight;
    protected boolean mIsDrawn;
    protected int mLineColor;

    private boolean isCanRefresh() {
        return false;
    }

    protected abstract RectF calcCaptureRect(int i, int i2);

    protected abstract List<AbsMaskDrawer> getCoverDrawer(int i, int i2);

    protected abstract List<AbsMaskDrawer> getFrameDrawer(int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getStokeWidth() {
        return 2;
    }

    protected void initCustomAttributes(Context context, AttributeSet attributeSet) {
    }

    public RectF getCaptureRect() {
        return this.mCaptureRect;
    }

    public BaseMaskView(Context context) {
        super(context);
        this.mInvisibleHeight = 0.2f;
        this.mBottomMargin = 0.8f;
        this.mIsDrawn = false;
        init(context, null);
    }

    public BaseMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInvisibleHeight = 0.2f;
        this.mBottomMargin = 0.8f;
        this.mIsDrawn = false;
        init(context, attributeSet);
    }

    public BaseMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInvisibleHeight = 0.2f;
        this.mBottomMargin = 0.8f;
        this.mIsDrawn = false;
        init(context, attributeSet);
    }

    protected void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DefaultMaskView);
        this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.DefaultMaskView_z_mask_background, getColor(R.color.z_black_60));
        this.mLineColor = obtainStyledAttributes.getColor(R.styleable.DefaultMaskView_z_line_color, getColor(R.color.z_white));
        this.mInvisibleHeight = obtainStyledAttributes.getFloat(R.styleable.DefaultMaskView_z_mask_invisible_height, this.mInvisibleHeight);
        this.mBottomMargin = obtainStyledAttributes.getFloat(R.styleable.DefaultMaskView_z_mask_bottom_margin, this.mBottomMargin);
        initCustomAttributes(context, attributeSet);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mCoverPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCoverPaint.setColor(this.mBackgroundColor);
        this.mCoverPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mFramePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mFramePaint.setColor(this.mLineColor);
        this.mFramePaint.setAntiAlias(true);
        this.mFramePaint.setStrokeWidth((int) (getStokeWidth() * getContext().getResources().getDisplayMetrics().density));
    }

    public void setLineColor(int i) {
        this.mLineColor = i;
        this.mFramePaint.setColor(i);
    }

    public void setMaskColor(int i) {
        this.mBackgroundColor = i;
        this.mCoverPaint.setColor(i);
    }

    private int getColor(int i) {
        return getResources().getColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mIsDrawn || isCanRefresh()) {
            this.mCaptureRect = calcCaptureRect(canvas.getWidth(), canvas.getHeight());
            List<AbsMaskDrawer> coverDrawer = getCoverDrawer(canvas.getWidth(), canvas.getHeight());
            if (coverDrawer != null) {
                Iterator<AbsMaskDrawer> it = coverDrawer.iterator();
                while (it.hasNext()) {
                    it.next().draw(canvas, this.mCoverPaint);
                }
            }
            List<AbsMaskDrawer> frameDrawer = getFrameDrawer(canvas.getWidth(), canvas.getHeight());
            if (frameDrawer != null) {
                Iterator<AbsMaskDrawer> it2 = frameDrawer.iterator();
                while (it2.hasNext()) {
                    it2.next().draw(canvas, this.mFramePaint);
                }
            }
        }
    }

    public Rect getDocFrame() {
        if (this.mCaptureRect != null) {
            return new Rect((int) this.mCaptureRect.left, (int) this.mCaptureRect.top, (int) this.mCaptureRect.right, (int) this.mCaptureRect.bottom);
        }
        return new Rect(0, 0, getWidth(), getHeight());
    }

    public int getInvisibleHeight() {
        return (int) (getHeight() * this.mInvisibleHeight);
    }

    public int getTipsBottomMargin() {
        return (int) (getHeight() * this.mBottomMargin);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<AbsMaskDrawer> toList(AbsMaskDrawer... absMaskDrawerArr) {
        if (absMaskDrawerArr != null) {
            return Arrays.asList(absMaskDrawerArr);
        }
        return null;
    }

    @Override // android.view.View
    public void invalidate() {
        this.mIsDrawn = false;
        super.invalidate();
    }

    public int getCenterPositionY() {
        RectF rectF = this.mCaptureRect;
        if (rectF == null) {
            return 0;
        }
        return (int) (rectF.top + (this.mCaptureRect.height() / 2.0f));
    }

    /* loaded from: classes8.dex */
    protected abstract class AbsMaskDrawer {
        protected Path mPath;

        public abstract void draw(Canvas canvas, Paint paint);

        public AbsMaskDrawer(Path path) {
            this.mPath = path;
        }
    }

    /* loaded from: classes8.dex */
    protected class CoverMaskDrawer extends AbsMaskDrawer {
        public CoverMaskDrawer(Path path) {
            super(path);
        }

        @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView.AbsMaskDrawer
        public void draw(Canvas canvas, Paint paint) {
            canvas.save();
            canvas.clipPath(this.mPath, Region.Op.DIFFERENCE);
            canvas.drawColor(paint.getColor());
            canvas.restore();
        }
    }

    /* loaded from: classes8.dex */
    protected class FrameMaskDrawer extends AbsMaskDrawer {
        public FrameMaskDrawer(Path path) {
            super(path);
        }

        @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView.AbsMaskDrawer
        public void draw(Canvas canvas, Paint paint) {
            canvas.save();
            canvas.drawPath(this.mPath, paint);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mCaptureRect == null) {
            return super.onTouchEvent(motionEvent);
        }
        return !this.mCaptureRect.contains(motionEvent.getX(), motionEvent.getY());
    }
}
