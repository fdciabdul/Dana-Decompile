package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.fullstory.instrumentation.FSDraw;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;
import java.util.ArrayList;

/* loaded from: classes9.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable, FSDraw {
    private static final int ANIMATION_DURATION = 1333;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    public static final int DEFAULT = 1;
    private static final Interpolator END_CURVE_INTERPOLATOR;
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    public static final int LARGE = 0;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5.0f;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final Interpolator START_CURVE_INTERPOLATOR;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private final int[] COLORS;
    private Animation mAnimation;
    private final ArrayList<Animation> mAnimators = new ArrayList<>();
    private int mBackgroundColor;
    private final Drawable.Callback mCallback;
    private Animation mFinishAnimation;
    private double mHeight;
    private View mParent;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    private float mRotationCount;
    private ShapeDrawable mShadow;
    private double mWidth;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator EASE_INTERPOLATOR = new AccelerateDecelerateInterpolator();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    static {
        END_CURVE_INTERPOLATOR = new EndCurveInterpolator();
        START_CURVE_INTERPOLATOR = new StartCurveInterpolator();
    }

    public MaterialProgressDrawable(Context context, View view) {
        int[] iArr = {-3591113, -13149199, -536002, -13327536};
        this.COLORS = iArr;
        Drawable.Callback callback = new Drawable.Callback() { // from class: in.srain.cube.views.ptr.header.MaterialProgressDrawable.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                MaterialProgressDrawable.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                MaterialProgressDrawable.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                MaterialProgressDrawable.this.unscheduleSelf(runnable);
            }
        };
        this.mCallback = callback;
        this.mParent = view;
        this.mResources = context.getResources();
        Ring ring = new Ring(callback);
        this.mRing = ring;
        ring.setColors(iArr);
        updateSizes(1);
        setupAnimators();
    }

    private void setSizeParameters(double d, double d2, double d3, double d4, float f, float f2) {
        Ring ring = this.mRing;
        float f3 = this.mResources.getDisplayMetrics().density;
        double d5 = f3;
        Double.isNaN(d5);
        this.mWidth = d * d5;
        Double.isNaN(d5);
        this.mHeight = d2 * d5;
        ring.setStrokeWidth(((float) d4) * f3);
        Double.isNaN(d5);
        ring.setCenterRadius(d3 * d5);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f * f3, f2 * f3);
        ring.setInsets((int) this.mWidth, (int) this.mHeight);
        setUp(this.mWidth);
    }

    private void setUp(double d) {
        PtrLocalDisplay.init(this.mParent.getContext());
        int dp2px = PtrLocalDisplay.dp2px(Y_OFFSET);
        int dp2px2 = PtrLocalDisplay.dp2px(0.0f);
        int dp2px3 = PtrLocalDisplay.dp2px(SHADOW_RADIUS);
        this.mShadow = new ShapeDrawable(new OvalShadow(dp2px3, (int) d));
        if (Build.VERSION.SDK_INT >= 11) {
            this.mParent.setLayerType(1, this.mShadow.getPaint());
        }
        this.mShadow.getPaint().setShadowLayer(dp2px3, dp2px2, dp2px, KEY_SHADOW_COLOR);
    }

    public void updateSizes(int i) {
        if (i == 0) {
            setSizeParameters(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            setSizeParameters(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void showArrow(boolean z) {
        this.mRing.setShowArrow(z);
    }

    public void setArrowScale(float f) {
        this.mRing.setArrowScale(f);
    }

    public void setStartEndTrim(float f, float f2) {
        this.mRing.setStartTrim(f);
        this.mRing.setEndTrim(f2);
    }

    public void setProgressRotation(float f) {
        this.mRing.setRotation(f);
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        this.mRing.setBackgroundColor(i);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ShapeDrawable shapeDrawable = this.mShadow;
        if (shapeDrawable != null) {
            shapeDrawable.getPaint().setColor(this.mBackgroundColor);
            this.mShadow.draw(canvas);
        }
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mRing.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
    }

    private float getRotation() {
        return this.mRotation;
    }

    void setRotation(float f) {
        this.mRotation = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mParent.startAnimation(this.mFinishAnimation);
            return;
        }
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mParent.startAnimation(this.mAnimation);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mParent.clearAnimation();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        Animation animation = new Animation() { // from class: in.srain.cube.views.ptr.header.MaterialProgressDrawable.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float floor = (float) (Math.floor(ring.getStartingRotation() / MaterialProgressDrawable.MAX_PROGRESS_ARC) + 1.0d);
                ring.setStartTrim(ring.getStartingStartTrim() + ((ring.getStartingEndTrim() - ring.getStartingStartTrim()) * f));
                ring.setRotation(ring.getStartingRotation() + ((floor - ring.getStartingRotation()) * f));
                ring.setArrowScale(1.0f - f);
            }
        };
        animation.setInterpolator(EASE_INTERPOLATOR);
        animation.setDuration(666L);
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: in.srain.cube.views.ptr.header.MaterialProgressDrawable.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                ring.goToNextColor();
                ring.storeOriginals();
                ring.setShowArrow(false);
                MaterialProgressDrawable.this.mParent.startAnimation(MaterialProgressDrawable.this.mAnimation);
            }
        });
        Animation animation2 = new Animation() { // from class: in.srain.cube.views.ptr.header.MaterialProgressDrawable.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                double strokeWidth = ring.getStrokeWidth();
                double centerRadius = ring.getCenterRadius() * 6.283185307179586d;
                Double.isNaN(strokeWidth);
                float radians = (float) Math.toRadians(strokeWidth / centerRadius);
                float startingEndTrim = ring.getStartingEndTrim();
                float startingStartTrim = ring.getStartingStartTrim();
                float startingRotation = ring.getStartingRotation();
                ring.setEndTrim(startingEndTrim + ((MaterialProgressDrawable.MAX_PROGRESS_ARC - radians) * MaterialProgressDrawable.START_CURVE_INTERPOLATOR.getInterpolation(f)));
                ring.setStartTrim(startingStartTrim + (MaterialProgressDrawable.END_CURVE_INTERPOLATOR.getInterpolation(f) * MaterialProgressDrawable.MAX_PROGRESS_ARC));
                ring.setRotation(startingRotation + (0.25f * f));
                MaterialProgressDrawable.this.setRotation((f * 144.0f) + ((MaterialProgressDrawable.this.mRotationCount / 5.0f) * 720.0f));
            }
        };
        animation2.setRepeatCount(-1);
        animation2.setRepeatMode(1);
        animation2.setInterpolator(LINEAR_INTERPOLATOR);
        animation2.setDuration(1333L);
        animation2.setAnimationListener(new Animation.AnimationListener() { // from class: in.srain.cube.views.ptr.header.MaterialProgressDrawable.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation3) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation3) {
                MaterialProgressDrawable.this.mRotationCount = 0.0f;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation3) {
                ring.storeOriginals();
                ring.goToNextColor();
                Ring ring2 = ring;
                ring2.setStartTrim(ring2.getEndTrim());
                MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
                materialProgressDrawable.mRotationCount = (materialProgressDrawable.mRotationCount + 1.0f) % 5.0f;
            }
        });
        this.mFinishAnimation = animation;
        this.mAnimation = animation2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class Ring {
        private int mAlpha;
        private final Paint mArcPaint;
        private Path mArrow;
        private int mArrowHeight;
        private final Paint mArrowPaint;
        private float mArrowScale;
        private int mArrowWidth;
        private int mBackgroundColor;
        private final Paint mCirclePaint;
        private int mColorIndex;
        private int[] mColors;
        private float mEndTrim;
        private final Drawable.Callback mRingCallback;
        private double mRingCenterRadius;
        private float mRotation;
        private boolean mShowArrow;
        private float mStartTrim;
        private float mStartingEndTrim;
        private float mStartingRotation;
        private float mStartingStartTrim;
        private float mStrokeInset;
        private float mStrokeWidth;
        private final RectF mTempBounds = new RectF();

        public Ring(Drawable.Callback callback) {
            Paint paint = new Paint();
            this.mArcPaint = paint;
            Paint paint2 = new Paint();
            this.mArrowPaint = paint2;
            Paint paint3 = new Paint();
            this.mCirclePaint = paint3;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mStrokeInset = MaterialProgressDrawable.STROKE_WIDTH;
            this.mRingCallback = callback;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setAntiAlias(true);
        }

        public void setBackgroundColor(int i) {
            this.mBackgroundColor = i;
        }

        public void setArrowDimensions(float f, float f2) {
            this.mArrowWidth = (int) f;
            this.mArrowHeight = (int) f2;
        }

        public void draw(Canvas canvas, Rect rect) {
            this.mCirclePaint.setColor(this.mBackgroundColor);
            this.mCirclePaint.setAlpha(this.mAlpha);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.mCirclePaint);
            RectF rectF = this.mTempBounds;
            rectF.set(rect);
            float f = this.mStrokeInset;
            rectF.inset(f, f);
            float f2 = this.mStartTrim;
            float f3 = this.mRotation;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.mEndTrim + f3) * 360.0f) - f4;
            this.mArcPaint.setColor(this.mColors[this.mColorIndex]);
            this.mArcPaint.setAlpha(this.mAlpha);
            canvas.drawArc(rectF, f4, f5, false, this.mArcPaint);
            drawTriangle(canvas, f4, f5, rect);
        }

        private void drawTriangle(Canvas canvas, float f, float f2, Rect rect) {
            if (this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = ((int) this.mStrokeInset) / 2;
                float f4 = this.mArrowScale;
                double d = this.mRingCenterRadius;
                double cos = Math.cos(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                double exactCenterX = rect.exactCenterX();
                Double.isNaN(exactCenterX);
                float f5 = (float) ((d * cos) + exactCenterX);
                double d2 = this.mRingCenterRadius;
                double sin = Math.sin(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                double exactCenterY = rect.exactCenterY();
                Double.isNaN(exactCenterY);
                float f6 = (float) ((d2 * sin) + exactCenterY);
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f7 = this.mArrowWidth;
                float f8 = this.mArrowScale;
                path3.lineTo((f7 * f8) / 2.0f, this.mArrowHeight * f8);
                this.mArrow.offset(f5 - (f3 * f4), f6);
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mColors[this.mColorIndex]);
                this.mArrowPaint.setAlpha(this.mAlpha);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        public void setColors(int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        public void setColorIndex(int i) {
            this.mColorIndex = i;
        }

        public void goToNextColor() {
            this.mColorIndex = (this.mColorIndex + 1) % this.mColors.length;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mArcPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public void setAlpha(int i) {
            this.mAlpha = i;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
            this.mArcPaint.setStrokeWidth(f);
            invalidateSelf();
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public void setStartTrim(float f) {
            this.mStartTrim = f;
            invalidateSelf();
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public void setEndTrim(float f) {
            this.mEndTrim = f;
            invalidateSelf();
        }

        public float getRotation() {
            return this.mRotation;
        }

        public void setRotation(float f) {
            this.mRotation = f;
            invalidateSelf();
        }

        public void setInsets(int i, int i2) {
            double ceil;
            float min = Math.min(i, i2);
            double d = this.mRingCenterRadius;
            if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || min < 0.0f) {
                ceil = Math.ceil(this.mStrokeWidth / 2.0f);
            } else {
                double d2 = min / 2.0f;
                Double.isNaN(d2);
                ceil = d2 - d;
            }
            this.mStrokeInset = (float) ceil;
        }

        public float getInsets() {
            return this.mStrokeInset;
        }

        public double getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public void setCenterRadius(double d) {
            this.mRingCenterRadius = d;
        }

        public void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
                invalidateSelf();
            }
        }

        public void setArrowScale(float f) {
            if (f != this.mArrowScale) {
                this.mArrowScale = f;
                invalidateSelf();
            }
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        private void invalidateSelf() {
            this.mRingCallback.invalidateDrawable(null);
        }
    }

    /* loaded from: classes9.dex */
    static class EndCurveInterpolator extends AccelerateDecelerateInterpolator {
        private EndCurveInterpolator() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.max(0.0f, (f - 0.5f) * 2.0f));
        }
    }

    /* loaded from: classes9.dex */
    static class StartCurveInterpolator extends AccelerateDecelerateInterpolator {
        private StartCurveInterpolator() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.min(1.0f, f * 2.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class OvalShadow extends OvalShape {
        private int mCircleDiameter;
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();
        private int mShadowRadius;

        public OvalShadow(int i, int i2) {
            this.mShadowRadius = i;
            this.mCircleDiameter = i2;
            float f = i2 / 2;
            RadialGradient radialGradient = new RadialGradient(f, f, i, new int[]{MaterialProgressDrawable.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mRadialGradient = radialGradient;
            this.mShadowPaint.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = MaterialProgressDrawable.this.getBounds().width() / 2;
            float height = MaterialProgressDrawable.this.getBounds().height() / 2;
            canvas.drawCircle(width, height, (this.mCircleDiameter / 2) + this.mShadowRadius, this.mShadowPaint);
            canvas.drawCircle(width, height, this.mCircleDiameter / 2, paint);
        }
    }
}
