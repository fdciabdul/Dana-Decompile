package io.supercharge.shimmerlayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class ShimmerLayout extends FrameLayout implements FSDispatchDraw {
    private Canvas BuiltInFictitiousFunctionClassFactory;
    private int DatabaseTableConfigUtil;
    private Rect GetContactSyncConfig;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private float PlaceComponentResult;
    private Paint getAuthRequestContext;
    private Bitmap getErrorConfigVersion;
    private int initRecordTimeStamp;
    private ValueAnimator lookAheadTest;
    private int moveToNextValue;
    private ViewTreeObserver.OnPreDrawListener newProxyInstance;
    private Bitmap scheduleImpl;

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_38bd9c83c20dcb3e61cbecd1c93ecc22(canvas, view, j);
    }

    public void fsSuperDispatchDraw_38bd9c83c20dcb3e61cbecd1c93ecc22(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_38bd9c83c20dcb3e61cbecd1c93ecc22(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public ShimmerLayout(Context context) {
        this(context, null);
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int color;
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, 0, 0);
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getInteger(R.styleable.getAuthRequestContext, 20);
            this.DatabaseTableConfigUtil = obtainStyledAttributes.getInteger(R.styleable.PlaceComponentResult, 1500);
            int i2 = R.styleable.MyBillsEntityDataFactory;
            int i3 = R.color.MyBillsEntityDataFactory;
            if (Build.VERSION.SDK_INT >= 23) {
                color = getContext().getColor(i3);
            } else {
                color = getResources().getColor(i3);
            }
            this.initRecordTimeStamp = obtainStyledAttributes.getColor(i2, color);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(R.styleable.BuiltInFictitiousFunctionClassFactory, false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getFloat(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, 0.5f);
            this.PlaceComponentResult = obtainStyledAttributes.getFloat(R.styleable.getErrorConfigVersion, 0.1f);
            this.MyBillsEntityDataFactory = obtainStyledAttributes.getBoolean(R.styleable.moveToNextValue, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            setGradientCenterColorWidth(this.PlaceComponentResult);
            setShimmerAngle(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 && getVisibility() == 0) {
                startShimmerAnimation();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        getAuthRequestContext();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 || getWidth() <= 0 || getHeight() <= 0) {
            fsSuperDispatchDraw_38bd9c83c20dcb3e61cbecd1c93ecc22(canvas);
            return;
        }
        fsSuperDispatchDraw_38bd9c83c20dcb3e61cbecd1c93ecc22(canvas);
        if (this.scheduleImpl == null) {
            this.scheduleImpl = PlaceComponentResult(this.GetContactSyncConfig.width(), getHeight());
        }
        Bitmap bitmap = this.scheduleImpl;
        this.getErrorConfigVersion = bitmap;
        if (bitmap != null) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new Canvas(this.getErrorConfigVersion);
            }
            this.BuiltInFictitiousFunctionClassFactory.drawColor(0, PorterDuff.Mode.CLEAR);
            this.BuiltInFictitiousFunctionClassFactory.save();
            this.BuiltInFictitiousFunctionClassFactory.translate(-this.moveToNextValue, 0.0f);
            fsSuperDispatchDraw_38bd9c83c20dcb3e61cbecd1c93ecc22(this.BuiltInFictitiousFunctionClassFactory);
            this.BuiltInFictitiousFunctionClassFactory.restore();
            if (this.getAuthRequestContext == null) {
                int i = this.initRecordTimeStamp;
                int argb = Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
                float width = (getWidth() / 2) * this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                float height = this.NetworkUserEntityData$$ExternalSyntheticLambda2 >= 0 ? getHeight() : 0.0f;
                float cos = (float) Math.cos(Math.toRadians(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
                float sin = (float) Math.sin(Math.toRadians(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
                int i2 = this.initRecordTimeStamp;
                float[] fArr = {0.0f, 0.5f - r3, r3 + 0.5f, 1.0f};
                float f = this.PlaceComponentResult / 2.0f;
                LinearGradient linearGradient = new LinearGradient(0.0f, height, cos * width, height + (sin * width), new int[]{argb, i2, i2, argb}, fArr, Shader.TileMode.CLAMP);
                Bitmap bitmap2 = this.getErrorConfigVersion;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                ComposeShader composeShader = new ComposeShader(linearGradient, new BitmapShader(bitmap2, tileMode, tileMode), PorterDuff.Mode.DST_IN);
                Paint paint = new Paint();
                this.getAuthRequestContext = paint;
                paint.setAntiAlias(true);
                this.getAuthRequestContext.setDither(true);
                this.getAuthRequestContext.setFilterBitmap(true);
                this.getAuthRequestContext.setShader(composeShader);
            }
            canvas.save();
            canvas.translate(this.moveToNextValue, 0.0f);
            canvas.drawRect(this.GetContactSyncConfig.left, 0.0f, this.GetContactSyncConfig.width(), this.GetContactSyncConfig.height(), this.getAuthRequestContext);
            canvas.restore();
            this.getErrorConfigVersion = null;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                startShimmerAnimation();
                return;
            }
            return;
        }
        stopShimmerAnimation();
    }

    public void startShimmerAnimation() {
        ValueAnimator ofInt;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        if (getWidth() == 0) {
            this.newProxyInstance = new ViewTreeObserver.OnPreDrawListener() { // from class: io.supercharge.shimmerlayout.ShimmerLayout.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    ShimmerLayout.this.startShimmerAnimation();
                    return true;
                }
            };
            getViewTreeObserver().addOnPreDrawListener(this.newProxyInstance);
            return;
        }
        ValueAnimator valueAnimator = this.lookAheadTest;
        if (valueAnimator == null) {
            if (this.GetContactSyncConfig == null) {
                double width = (getWidth() / 2) * this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                double cos = Math.cos(Math.toRadians(Math.abs(this.NetworkUserEntityData$$ExternalSyntheticLambda2)));
                Double.isNaN(width);
                double d = width / cos;
                double height = getHeight();
                double tan = Math.tan(Math.toRadians(Math.abs(this.NetworkUserEntityData$$ExternalSyntheticLambda2)));
                Double.isNaN(height);
                this.GetContactSyncConfig = new Rect(0, 0, (int) (d + (height * tan)), getHeight());
            }
            int width2 = getWidth();
            final int i = getWidth() > this.GetContactSyncConfig.width() ? -width2 : -this.GetContactSyncConfig.width();
            final int width3 = this.GetContactSyncConfig.width();
            int i2 = width2 - i;
            int[] iArr = new int[2];
            if (this.MyBillsEntityDataFactory) {
                iArr[0] = i2;
                iArr[1] = 0;
                ofInt = ValueAnimator.ofInt(iArr);
            } else {
                iArr[0] = 0;
                iArr[1] = i2;
                ofInt = ValueAnimator.ofInt(iArr);
            }
            this.lookAheadTest = ofInt;
            ofInt.setDuration(this.DatabaseTableConfigUtil);
            this.lookAheadTest.setRepeatCount(-1);
            this.lookAheadTest.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: io.supercharge.shimmerlayout.ShimmerLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ShimmerLayout.this.moveToNextValue = i + ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    if (ShimmerLayout.this.moveToNextValue + width3 >= 0) {
                        ShimmerLayout.this.invalidate();
                    }
                }
            });
            valueAnimator = this.lookAheadTest;
        }
        valueAnimator.start();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    }

    public void stopShimmerAnimation() {
        if (this.newProxyInstance != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.newProxyInstance);
        }
        getAuthRequestContext();
    }

    public void setShimmerColor(int i) {
        this.initRecordTimeStamp = i;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            getAuthRequestContext();
            startShimmerAnimation();
        }
    }

    public void setShimmerAnimationDuration(int i) {
        this.DatabaseTableConfigUtil = i;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            getAuthRequestContext();
            startShimmerAnimation();
        }
    }

    public void setAnimationReversed(boolean z) {
        this.MyBillsEntityDataFactory = z;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            getAuthRequestContext();
            startShimmerAnimation();
        }
    }

    public void setShimmerAngle(int i) {
        if (i < -45 || 45 < i) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", (byte) -45, (byte) 45));
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            getAuthRequestContext();
            startShimmerAnimation();
        }
    }

    public void setMaskWidth(float f) {
        if (f <= 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", (byte) 0, (byte) 1));
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            getAuthRequestContext();
            startShimmerAnimation();
        }
    }

    public void setGradientCenterColorWidth(float f) {
        if (f <= 0.0f || 1.0f <= f) {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", (byte) 0, (byte) 1));
        }
        this.PlaceComponentResult = f;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            getAuthRequestContext();
            startShimmerAnimation();
        }
    }

    private void getAuthRequestContext() {
        ValueAnimator valueAnimator = this.lookAheadTest;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.lookAheadTest.removeAllUpdateListeners();
        }
        this.lookAheadTest = null;
        this.getAuthRequestContext = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.BuiltInFictitiousFunctionClassFactory = null;
        Bitmap bitmap = this.scheduleImpl;
        if (bitmap != null) {
            bitmap.recycle();
            this.scheduleImpl = null;
        }
    }

    private static Bitmap PlaceComponentResult(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }
}
