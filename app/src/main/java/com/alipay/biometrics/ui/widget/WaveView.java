package com.alipay.biometrics.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes6.dex */
public class WaveView extends View {
    private static final float DEFAULT_AMPLITUDE_RATIO = 0.05f;
    private static final float DEFAULT_WATER_LEVEL_RATIO = 0.5f;
    private static final float DEFAULT_WAVE_LENGTH_RATIO = 1.0f;
    private static final float DEFAULT_WAVE_SHIFT_RATIO = 0.0f;
    private float mAmplitudeRatio;
    private int mBehindWaveColor;
    private Paint mBorderPaint;
    private float mDefaultAmplitude;
    private double mDefaultAngularFrequency;
    private float mDefaultWaterLevel;
    private float mDefaultWaveLength;
    private int mFrontWaveColor;
    private Matrix mShaderMatrix;
    private ShapeType mShapeType;
    private boolean mShowWave;
    private Paint mViewPaint;
    private float mWaterLevelRatio;
    private float mWaveLengthRatio;
    private BitmapShader mWaveShader;
    private float mWaveShiftRatio;
    public static final int DEFAULT_BEHIND_WAVE_COLOR = Color.parseColor("#28FFFFFF");
    public static final int DEFAULT_FRONT_WAVE_COLOR = Color.parseColor("#3CFFFFFF");
    public static final ShapeType DEFAULT_WAVE_SHAPE = ShapeType.CIRCLE;

    /* loaded from: classes6.dex */
    public enum ShapeType {
        CIRCLE,
        SQUARE
    }

    public WaveView(Context context) {
        super(context);
        this.mAmplitudeRatio = 0.05f;
        this.mWaveLengthRatio = 1.0f;
        this.mWaterLevelRatio = DEFAULT_WATER_LEVEL_RATIO;
        this.mWaveShiftRatio = 0.0f;
        this.mBehindWaveColor = DEFAULT_BEHIND_WAVE_COLOR;
        this.mFrontWaveColor = DEFAULT_FRONT_WAVE_COLOR;
        this.mShapeType = DEFAULT_WAVE_SHAPE;
        init();
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAmplitudeRatio = 0.05f;
        this.mWaveLengthRatio = 1.0f;
        this.mWaterLevelRatio = DEFAULT_WATER_LEVEL_RATIO;
        this.mWaveShiftRatio = 0.0f;
        this.mBehindWaveColor = DEFAULT_BEHIND_WAVE_COLOR;
        this.mFrontWaveColor = DEFAULT_FRONT_WAVE_COLOR;
        this.mShapeType = DEFAULT_WAVE_SHAPE;
        init();
    }

    public WaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAmplitudeRatio = 0.05f;
        this.mWaveLengthRatio = 1.0f;
        this.mWaterLevelRatio = DEFAULT_WATER_LEVEL_RATIO;
        this.mWaveShiftRatio = 0.0f;
        this.mBehindWaveColor = DEFAULT_BEHIND_WAVE_COLOR;
        this.mFrontWaveColor = DEFAULT_FRONT_WAVE_COLOR;
        this.mShapeType = DEFAULT_WAVE_SHAPE;
        init();
    }

    private void init() {
        this.mShaderMatrix = new Matrix();
        Paint paint = new Paint();
        this.mViewPaint = paint;
        paint.setAntiAlias(true);
    }

    public float getWaveShiftRatio() {
        return this.mWaveShiftRatio;
    }

    public void setWaveShiftRatio(float f) {
        if (this.mWaveShiftRatio != f) {
            this.mWaveShiftRatio = f;
            invalidate();
        }
    }

    public float getWaterLevelRatio() {
        return this.mWaterLevelRatio;
    }

    public void setWaterLevelRatio(float f) {
        if (this.mWaterLevelRatio != f) {
            this.mWaterLevelRatio = f;
            invalidate();
        }
    }

    public float getAmplitudeRatio() {
        return this.mAmplitudeRatio;
    }

    public void setAmplitudeRatio(float f) {
        if (this.mAmplitudeRatio != f) {
            this.mAmplitudeRatio = f;
            invalidate();
        }
    }

    public float getWaveLengthRatio() {
        return this.mWaveLengthRatio;
    }

    public void setWaveLengthRatio(float f) {
        this.mWaveLengthRatio = f;
    }

    public boolean isShowWave() {
        return this.mShowWave;
    }

    public void setShowWave(boolean z) {
        this.mShowWave = z;
    }

    public void setBorder(int i, int i2) {
        if (this.mBorderPaint == null) {
            Paint paint = new Paint();
            this.mBorderPaint = paint;
            paint.setAntiAlias(true);
            this.mBorderPaint.setStyle(Paint.Style.STROKE);
        }
        this.mBorderPaint.setColor(i2);
        this.mBorderPaint.setStrokeWidth(i);
        invalidate();
    }

    public void setWaveColor(int i, int i2) {
        this.mBehindWaveColor = i;
        this.mFrontWaveColor = i2;
        this.mWaveShader = null;
        createShader();
        invalidate();
    }

    public void setShapeType(ShapeType shapeType) {
        this.mShapeType = shapeType;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        createShader();
    }

    private void createShader() {
        double width = getWidth();
        Double.isNaN(width);
        this.mDefaultAngularFrequency = 6.283185307179586d / width;
        this.mDefaultAmplitude = getHeight() * 0.05f;
        this.mDefaultWaterLevel = getHeight() * DEFAULT_WATER_LEVEL_RATIO;
        this.mDefaultWaveLength = getWidth();
        try {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setStrokeWidth(2.0f);
            paint.setAntiAlias(true);
            int width2 = getWidth() + 1;
            int height = getHeight() + 1;
            float[] fArr = new float[width2];
            paint.setColor(this.mBehindWaveColor);
            int i = 0;
            while (i < width2) {
                double d = i;
                double d2 = this.mDefaultAngularFrequency;
                double d3 = this.mDefaultWaterLevel;
                int i2 = i;
                double d4 = this.mDefaultAmplitude;
                Double.isNaN(d);
                double sin = Math.sin(d * d2);
                Double.isNaN(d4);
                Double.isNaN(d3);
                float f = (float) (d3 + (d4 * sin));
                float f2 = i2;
                canvas.drawLine(f2, f, f2, height, paint);
                fArr[i2] = f;
                i = i2 + 1;
            }
            paint.setColor(this.mFrontWaveColor);
            int i3 = (int) (this.mDefaultWaveLength / 4.0f);
            for (int i4 = 0; i4 < width2; i4++) {
                float f3 = i4;
                canvas.drawLine(f3, fArr[(i4 + i3) % width2], f3, height, paint);
            }
            BitmapShader bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            this.mWaveShader = bitmapShader;
            this.mViewPaint.setShader(bitmapShader);
        } catch (OutOfMemoryError unused) {
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mShowWave && this.mWaveShader != null) {
            if (this.mViewPaint.getShader() == null) {
                this.mViewPaint.setShader(this.mWaveShader);
            }
            this.mShaderMatrix.setScale(this.mWaveLengthRatio / 1.0f, this.mAmplitudeRatio / 0.05f, 0.0f, this.mDefaultWaterLevel);
            this.mShaderMatrix.postTranslate(this.mWaveShiftRatio * getWidth(), (DEFAULT_WATER_LEVEL_RATIO - this.mWaterLevelRatio) * getHeight());
            this.mWaveShader.setLocalMatrix(this.mShaderMatrix);
            Paint paint = this.mBorderPaint;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            int i = AnonymousClass1.$SwitchMap$com$alipay$biometrics$ui$widget$WaveView$ShapeType[this.mShapeType.ordinal()];
            if (i == 1) {
                paintCircleShape(canvas, strokeWidth);
                return;
            } else if (i == 2) {
                paintSquare(canvas, strokeWidth);
                return;
            } else {
                return;
            }
        }
        this.mViewPaint.setShader(null);
    }

    /* renamed from: com.alipay.biometrics.ui.widget.WaveView$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alipay$biometrics$ui$widget$WaveView$ShapeType;

        static {
            int[] iArr = new int[ShapeType.values().length];
            $SwitchMap$com$alipay$biometrics$ui$widget$WaveView$ShapeType = iArr;
            try {
                iArr[ShapeType.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alipay$biometrics$ui$widget$WaveView$ShapeType[ShapeType.SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void paintSquare(Canvas canvas, float f) {
        if (f > 0.0f) {
            float f2 = f / 2.0f;
            canvas.drawRect(f2, f2, (getWidth() - f2) - DEFAULT_WATER_LEVEL_RATIO, (getHeight() - f2) - DEFAULT_WATER_LEVEL_RATIO, this.mBorderPaint);
        }
        canvas.drawRect(f, f, getWidth() - f, getHeight() - f, this.mViewPaint);
    }

    private void paintCircleShape(Canvas canvas, float f) {
        if (f > 0.0f) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() - f) / 2.0f) - 1.0f, this.mBorderPaint);
        }
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (getWidth() / 2.0f) - f, this.mViewPaint);
    }
}
