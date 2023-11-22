package com.alipay.zoloz.zface.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.zoloz.toyger.R;

/* loaded from: classes7.dex */
public class UploadProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    final int ANGLE_STEP;
    private float backColorWidth;
    private int backgroundColor;
    private int endAngle;
    private Handler mMainHandle;
    private Matrix mMatrix;
    int mProgressAngle;
    public SweepGradient mSweepGradient;
    private int mWidth;
    private int max;
    protected Paint paint;
    private int progress;
    private int radius;
    protected int roundColor;
    protected int roundProgressColor;
    private boolean roundShader;
    private float roundWidth;
    private int secondProgressColor;
    protected int startAngle;
    private int style;
    private int textColor;
    private boolean textIsDisplayable;
    private float textSize;

    public int getRadius() {
        return this.radius;
    }

    public UploadProgressBar(Context context) {
        this(context, null);
    }

    public UploadProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UploadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.style = 0;
        this.radius = 0;
        this.mProgressAngle = 0;
        this.ANGLE_STEP = 120;
        this.paint = new Paint();
        this.mMainHandle = new Handler(Looper.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.zface_round_progressBar);
        this.roundColor = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_round_color, -65536);
        this.roundProgressColor = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_round_progress_color, -16711936);
        this.secondProgressColor = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_round_progress_color, -16711936);
        this.textColor = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_text_color, -16711936);
        this.textSize = obtainStyledAttributes.getDimension(R.styleable.zface_round_progressBar_zface_text_size, 15.0f);
        this.roundWidth = obtainStyledAttributes.getDimension(R.styleable.zface_round_progressBar_zface_round_width, 5.0f);
        this.max = obtainStyledAttributes.getInteger(R.styleable.zface_round_progressBar_zface_max, 100);
        this.textIsDisplayable = obtainStyledAttributes.getBoolean(R.styleable.zface_round_progressBar_zface_text_is_displayable, true);
        this.style = obtainStyledAttributes.getInt(R.styleable.zface_round_progressBar_zface_style, 0);
        this.roundShader = obtainStyledAttributes.getBoolean(R.styleable.zface_round_progressBar_zface_progress_shader, false);
        this.backColorWidth = obtainStyledAttributes.getDimension(R.styleable.zface_round_progressBar_zface_color_bg_width, 0.0f);
        this.startAngle = obtainStyledAttributes.getInt(R.styleable.zface_round_progressBar_zface_start_angle, 0);
        this.endAngle = obtainStyledAttributes.getInt(R.styleable.zface_round_progressBar_zface_end_angle, AUScreenAdaptTool.WIDTH_BASE);
        this.backgroundColor = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_background_color, -1);
        if (this.backColorWidth > 0.0f && this.roundShader) {
            int color = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_round_progress_start_color, -16711936);
            int color2 = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_round_progress_end_color, -16711936);
            float f = this.backColorWidth / 2.0f;
            this.mSweepGradient = new SweepGradient(f, f, color, color2);
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, f, f);
            this.mSweepGradient.setLocalMatrix(matrix);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = width;
        this.radius = (int) (f - (this.roundWidth / 2.0f));
        this.paint.setColor(this.roundColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setColor(this.backgroundColor);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setTypeface(Typeface.DEFAULT_BOLD);
        int i = (int) ((this.progress / this.max) * 100.0f);
        Paint paint = this.paint;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("%");
        float measureText = paint.measureText(sb.toString());
        this.paint.setShader(null);
        if (this.textIsDisplayable && i != 0 && this.style == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append("%");
            canvas.drawText(sb2.toString(), f - (measureText / 2.0f), f + (this.textSize / 2.0f), this.paint);
        }
        this.paint.setStrokeWidth(this.roundWidth);
        int i2 = this.radius;
        float f2 = width - i2;
        float f3 = width + i2;
        RectF rectF = new RectF(f2, f2, f3, f3);
        this.paint.setColor(this.roundColor);
        int i3 = this.style;
        if (i3 == 0) {
            paintStroke(canvas, rectF);
        } else if (i3 == 1) {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.progress != 0) {
                int i4 = this.startAngle;
                canvas.drawArc(rectF, i4 + 90, ((this.endAngle - i4) * r0) / this.max, true, this.paint);
            }
        }
    }

    protected void paintStroke(Canvas canvas, RectF rectF) {
        int i;
        int i2;
        this.paint.setStyle(Paint.Style.STROKE);
        SweepGradient sweepGradient = this.mSweepGradient;
        if (sweepGradient != null) {
            this.paint.setShader(sweepGradient);
        }
        int i3 = this.startAngle;
        int i4 = i3 + 180;
        int i5 = 180 - (i3 * 2);
        canvas.drawArc(rectF, i4, i5, false, this.paint);
        int i6 = this.mProgressAngle % AUScreenAdaptTool.WIDTH_BASE;
        int i7 = 0;
        if (i6 < i4) {
            int i8 = i6 + 120;
            if (i8 > i4) {
                i = i8 - i4;
            }
            i = 0;
        } else {
            i4 += i5;
            if (i6 <= i4) {
                if (i6 + 120 < i4) {
                    i4 = i6;
                    i = 120;
                } else {
                    int i9 = i4 - i6;
                    i4 = i6;
                    i = i9;
                }
            }
            i = 0;
        }
        if (i > 0) {
            this.paint.setColor(this.roundProgressColor);
            canvas.drawArc(rectF, i4, i, false, this.paint);
        }
        int i10 = this.mProgressAngle % AUScreenAdaptTool.WIDTH_BASE;
        int i11 = this.startAngle;
        int i12 = 180 - (i11 * 2);
        this.paint.setColor(this.roundColor);
        float f = i11;
        canvas.drawArc(rectF, f, i12, false, this.paint);
        if (i10 < i11) {
            int i13 = i10 + 120;
            if (i13 > i11) {
                i7 = i13 - i11;
                i10 = i11;
            }
        } else {
            int i14 = i12 + i11;
            if (i10 <= i14) {
                i7 = i10 + 120 < i14 ? 120 : i14 - i10;
            }
        }
        if (i7 > 0) {
            this.paint.setColor(this.roundProgressColor);
            canvas.drawArc(rectF, i10, i7, false, this.paint);
        } else if (i10 > 270 && (i2 = (this.mProgressAngle + 120) % AUScreenAdaptTool.WIDTH_BASE) < 180 && i2 > i11) {
            this.paint.setColor(this.roundProgressColor);
            canvas.drawArc(rectF, f, i2 - i11, false, this.paint);
        }
        this.paint.setShader(null);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
        postInvalidate();
    }

    public void setRoundColor(int i) {
        this.roundColor = i;
        postInvalidate();
    }

    public int getMax() {
        int i;
        synchronized (this) {
            i = this.max;
        }
        return i;
    }

    public void setMax(int i) {
        synchronized (this) {
            if (i < 0) {
                throw new IllegalArgumentException("max not less than 0");
            }
            this.max = i;
        }
    }

    public int getProgress() {
        int i;
        synchronized (this) {
            i = this.progress;
        }
        return i;
    }

    public void setProgress(int i) {
        synchronized (this) {
            if (i < 0) {
                throw new IllegalArgumentException("progress not less than 0");
            }
            int i2 = this.max;
            if (i > i2) {
                i = i2;
            }
            if (i <= i2) {
                this.progress = i;
                postInvalidate();
            }
        }
    }

    public void setProgressAngle(int i) {
        synchronized (this) {
            this.mProgressAngle = i;
            postInvalidate();
        }
    }

    public int getCricleColor() {
        return this.roundColor;
    }

    public void setCricleColor(int i) {
        this.roundColor = i;
    }

    public int getCricleProgressColor() {
        return this.roundProgressColor;
    }

    public void setCricleProgressColor(int i) {
        this.roundProgressColor = i;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public float getRoundWidth() {
        return this.roundWidth;
    }

    public void setRoundWidth(float f) {
        this.roundWidth = f;
    }

    public void setRoundProgressColor(int i) {
        this.roundProgressColor = i;
    }
}
