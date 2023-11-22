package com.alipay.zoloz.zface.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.zoloz.toyger.R;

/* loaded from: classes7.dex */
public class AlgorithmScheduleProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private final int DEFAULT_INTERVAL;
    private final boolean DEFAULT_USE_ACCELERATE;
    private float backColorWidth;
    private int backgroundColor;
    private int endAngle;
    private int mAnimateValue;
    private Handler mHandler;
    private boolean mIsShowingProgress;
    private Matrix mMatrix;
    private Shader mProgressShader;
    public ValueAnimator mValueAnimator;
    private int mWidth;
    private int max;
    private Paint paint;
    private int progress;
    private int radius;
    private int roundColor;
    private int roundProgressColor;
    private int roundProgressEndColor;
    private int roundProgressStartColor;
    private boolean roundShader;
    private float roundWidth;
    private int startAngle;
    private int style;
    private int textColor;
    private boolean textIsDisplayable;
    private float textSize;

    public int getRadius() {
        return this.radius;
    }

    public AlgorithmScheduleProgressBar(Context context) {
        this(context, null);
    }

    public AlgorithmScheduleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlgorithmScheduleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DEFAULT_INTERVAL = 500;
        this.DEFAULT_USE_ACCELERATE = false;
        this.mHandler = new Handler();
        this.mIsShowingProgress = false;
        this.style = 0;
        this.radius = 0;
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.zface_round_progressBar);
        this.roundColor = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_round_color, -65536);
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
        this.roundProgressColor = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_round_progress_color, -16711936);
        this.roundProgressStartColor = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_round_progress_start_color, -16711936);
        this.roundProgressEndColor = obtainStyledAttributes.getColor(R.styleable.zface_round_progressBar_zface_round_progress_end_color, -16711936);
        float f = this.backColorWidth;
        if (f > 0.0f && this.roundShader) {
            float f2 = f / 2.0f;
            this.mProgressShader = new SweepGradient(f2, f2, this.roundProgressStartColor, this.roundProgressEndColor);
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, f2, f2);
            this.mProgressShader.setLocalMatrix(matrix);
        }
        obtainStyledAttributes.recycle();
    }

    public void setProgressColor(int i, int i2, int i3) {
        if (this.mProgressShader != null) {
            float f = this.backColorWidth / 2.0f;
            this.mProgressShader = new SweepGradient(f, f, i2, i3);
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, f, f);
            this.mProgressShader.setLocalMatrix(matrix);
        }
        this.roundColor = i;
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
        canvas.drawCircle(f, f, this.radius, this.paint);
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
        int i3 = this.startAngle;
        canvas.drawArc(rectF, i3 + 90, this.endAngle - i3, false, this.paint);
        this.paint.setColor(this.roundProgressColor);
        int i4 = this.style;
        if (i4 == 0) {
            paintArc(canvas, rectF, Paint.Style.STROKE, true);
        } else if (i4 == 1) {
            paintArc(canvas, rectF, Paint.Style.FILL_AND_STROKE, false);
        }
    }

    private void paintArc(Canvas canvas, RectF rectF, Paint.Style style, boolean z) {
        this.paint.setStyle(style);
        Shader shader = this.mProgressShader;
        if (shader != null && z) {
            this.paint.setShader(shader);
        }
        int i = this.progress;
        if (i != 0) {
            int i2 = this.endAngle;
            int i3 = this.startAngle;
            canvas.drawArc(rectF, i3 + 90, (((i2 - i3) * 1.0f) * i) / this.max, false, this.paint);
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

    public int getCricleColor() {
        return this.roundColor;
    }

    public void setCricleColor(int i) {
        this.roundColor = i;
    }

    public int getCricleProgressColor() {
        return this.roundProgressStartColor;
    }

    public void setCricleProgressColor(int i) {
        this.roundProgressStartColor = i;
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

    public void showProgress(float f) {
        showProgress(f, 500, false);
    }

    public void showProgress(float f, int i) {
        showProgress(f, i, false);
    }

    public void showProgress(float f, int i, boolean z) {
        showAnimator((int) (f * getMax()), i, z);
    }

    private void showAnimator(final int i, int i2, boolean z) {
        if (this.mIsShowingProgress) {
            return;
        }
        this.mIsShowingProgress = true;
        long j = i2;
        this.mHandler.postDelayed(new Runnable() { // from class: com.alipay.zoloz.zface.ui.widget.AlgorithmScheduleProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                AlgorithmScheduleProgressBar.this.mIsShowingProgress = false;
            }
        }, j);
        int progress = getProgress();
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(progress, i);
        this.mValueAnimator = ofInt;
        ofInt.setDuration(j);
        if (z) {
            this.mValueAnimator.setInterpolator(new LinearInterpolator());
        } else {
            this.mValueAnimator.setInterpolator(new AccelerateInterpolator());
        }
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alipay.zoloz.zface.ui.widget.AlgorithmScheduleProgressBar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                if (AlgorithmScheduleProgressBar.this.mValueAnimator == null || !AlgorithmScheduleProgressBar.this.mValueAnimator.isRunning()) {
                    return;
                }
                AlgorithmScheduleProgressBar algorithmScheduleProgressBar = AlgorithmScheduleProgressBar.this;
                StringBuilder sb = new StringBuilder();
                sb.append(AlgorithmScheduleProgressBar.this.mValueAnimator.getAnimatedValue());
                algorithmScheduleProgressBar.mAnimateValue = Integer.parseInt(sb.toString());
                AlgorithmScheduleProgressBar algorithmScheduleProgressBar2 = AlgorithmScheduleProgressBar.this;
                algorithmScheduleProgressBar2.setProgress(algorithmScheduleProgressBar2.mAnimateValue);
                if (i == AlgorithmScheduleProgressBar.this.mAnimateValue) {
                    AlgorithmScheduleProgressBar.this.mIsShowingProgress = false;
                    AlgorithmScheduleProgressBar.this.mValueAnimator.cancel();
                    AlgorithmScheduleProgressBar.this.mValueAnimator = null;
                }
            }
        });
        this.mValueAnimator.start();
    }
}
