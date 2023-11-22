package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.fullstory.instrumentation.FSDraw;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class CircularProgressDrawable extends Drawable implements Animatable, FSDraw {
    float BuiltInFictitiousFunctionClassFactory;
    final Ring MyBillsEntityDataFactory;
    private Animator NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean getAuthRequestContext;
    private Resources getErrorConfigVersion;
    private float moveToNextValue;
    private static final Interpolator KClassImpl$Data$declaredNonStaticMembers$2 = new LinearInterpolator();
    private static final Interpolator lookAheadTest = new FastOutSlowInInterpolator();
    private static final int[] PlaceComponentResult = {-16777216};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ProgressDrawableSize {
    }

    private static int MyBillsEntityDataFactory(float f, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f))) << 16) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r2) * f))) << 8) | ((i & 255) + ((int) (f * ((i2 & 255) - r5))));
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CircularProgressDrawable(Context context) {
        this.getErrorConfigVersion = ((Context) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(context)).getResources();
        Ring ring = new Ring();
        this.MyBillsEntityDataFactory = ring;
        ring.getErrorConfigVersion = PlaceComponentResult;
        ring.lookAheadTest = 0;
        ring.NetworkUserEntityData$$ExternalSyntheticLambda0 = ring.getErrorConfigVersion[0];
        Ring ring2 = this.MyBillsEntityDataFactory;
        ring2.NetworkUserEntityData$$ExternalSyntheticLambda8 = 2.5f;
        ring2.NetworkUserEntityData$$ExternalSyntheticLambda1.setStrokeWidth(2.5f);
        invalidateSelf();
        final Ring ring3 = this.MyBillsEntityDataFactory;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.BuiltInFictitiousFunctionClassFactory(floatValue, ring3);
                CircularProgressDrawable.this.KClassImpl$Data$declaredNonStaticMembers$2(floatValue, ring3, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(KClassImpl$Data$declaredNonStaticMembers$2);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.BuiltInFictitiousFunctionClassFactory = 0.0f;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.KClassImpl$Data$declaredNonStaticMembers$2(1.0f, ring3, true);
                Ring ring4 = ring3;
                ring4.isLayoutRequested = ring4.NetworkUserEntityData$$ExternalSyntheticLambda7;
                ring4.newProxyInstance = ring4.NetworkUserEntityData$$ExternalSyntheticLambda2;
                ring4.PrepareContext = ring4.initRecordTimeStamp;
                Ring ring5 = ring3;
                int length = (ring5.lookAheadTest + 1) % ring5.getErrorConfigVersion.length;
                ring5.lookAheadTest = length;
                ring5.NetworkUserEntityData$$ExternalSyntheticLambda0 = ring5.getErrorConfigVersion[length];
                if (CircularProgressDrawable.this.getAuthRequestContext) {
                    CircularProgressDrawable.this.getAuthRequestContext = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    Ring ring6 = ring3;
                    if (ring6.DatabaseTableConfigUtil) {
                        ring6.DatabaseTableConfigUtil = false;
                        return;
                    }
                    return;
                }
                CircularProgressDrawable.this.BuiltInFictitiousFunctionClassFactory += 1.0f;
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ofFloat;
    }

    private void getAuthRequestContext(float f, float f2, float f3, float f4) {
        Ring ring = this.MyBillsEntityDataFactory;
        float f5 = this.getErrorConfigVersion.getDisplayMetrics().density;
        float f6 = f2 * f5;
        ring.NetworkUserEntityData$$ExternalSyntheticLambda8 = f6;
        ring.NetworkUserEntityData$$ExternalSyntheticLambda1.setStrokeWidth(f6);
        ring.GetContactSyncConfig = f * f5;
        ring.lookAheadTest = 0;
        ring.NetworkUserEntityData$$ExternalSyntheticLambda0 = ring.getErrorConfigVersion[0];
        ring.scheduleImpl = (int) (f3 * f5);
        ring.KClassImpl$Data$declaredNonStaticMembers$2 = (int) (f4 * f5);
    }

    public final void MyBillsEntityDataFactory(int i) {
        if (i == 0) {
            getAuthRequestContext(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            getAuthRequestContext(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.moveToNextValue, bounds.exactCenterX(), bounds.exactCenterY());
        Ring ring = this.MyBillsEntityDataFactory;
        RectF rectF = ring.NetworkUserEntityData$$ExternalSyntheticLambda5;
        float f = ring.GetContactSyncConfig;
        float f2 = (ring.NetworkUserEntityData$$ExternalSyntheticLambda8 / 2.0f) + f;
        if (f <= 0.0f) {
            f2 = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((ring.scheduleImpl * ring.PlaceComponentResult) / 2.0f, ring.NetworkUserEntityData$$ExternalSyntheticLambda8 / 2.0f);
        }
        rectF.set(bounds.centerX() - f2, bounds.centerY() - f2, bounds.centerX() + f2, bounds.centerY() + f2);
        float f3 = ring.NetworkUserEntityData$$ExternalSyntheticLambda7;
        float f4 = ring.initRecordTimeStamp;
        float f5 = (f3 + f4) * 360.0f;
        float f6 = ((ring.NetworkUserEntityData$$ExternalSyntheticLambda2 + f4) * 360.0f) - f5;
        ring.NetworkUserEntityData$$ExternalSyntheticLambda1.setColor(ring.NetworkUserEntityData$$ExternalSyntheticLambda0);
        ring.NetworkUserEntityData$$ExternalSyntheticLambda1.setAlpha(ring.MyBillsEntityDataFactory);
        float f7 = ring.NetworkUserEntityData$$ExternalSyntheticLambda8 / 2.0f;
        rectF.inset(f7, f7);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, ring.moveToNextValue);
        float f8 = -f7;
        rectF.inset(f8, f8);
        canvas.drawArc(rectF, f5, f6, false, ring.NetworkUserEntityData$$ExternalSyntheticLambda1);
        if (ring.DatabaseTableConfigUtil) {
            Path path = ring.getAuthRequestContext;
            if (path == null) {
                Path path2 = new Path();
                ring.getAuthRequestContext = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f9 = (ring.scheduleImpl * ring.PlaceComponentResult) / 2.0f;
            ring.getAuthRequestContext.moveTo(0.0f, 0.0f);
            ring.getAuthRequestContext.lineTo(ring.scheduleImpl * ring.PlaceComponentResult, 0.0f);
            Path path3 = ring.getAuthRequestContext;
            float f10 = ring.scheduleImpl;
            float f11 = ring.PlaceComponentResult;
            path3.lineTo((f10 * f11) / 2.0f, ring.KClassImpl$Data$declaredNonStaticMembers$2 * f11);
            ring.getAuthRequestContext.offset((min + rectF.centerX()) - f9, rectF.centerY() + (ring.NetworkUserEntityData$$ExternalSyntheticLambda8 / 2.0f));
            ring.getAuthRequestContext.close();
            ring.BuiltInFictitiousFunctionClassFactory.setColor(ring.NetworkUserEntityData$$ExternalSyntheticLambda0);
            ring.BuiltInFictitiousFunctionClassFactory.setAlpha(ring.MyBillsEntityDataFactory);
            canvas.save();
            canvas.rotate(f5 + f6, rectF.centerX(), rectF.centerY());
            canvas.drawPath(ring.getAuthRequestContext, ring.BuiltInFictitiousFunctionClassFactory);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.cancel();
        Ring ring = this.MyBillsEntityDataFactory;
        ring.isLayoutRequested = ring.NetworkUserEntityData$$ExternalSyntheticLambda7;
        ring.newProxyInstance = ring.NetworkUserEntityData$$ExternalSyntheticLambda2;
        ring.PrepareContext = ring.initRecordTimeStamp;
        if (this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 != this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            this.getAuthRequestContext = true;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setDuration(666L);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.start();
            return;
        }
        Ring ring2 = this.MyBillsEntityDataFactory;
        ring2.lookAheadTest = 0;
        ring2.NetworkUserEntityData$$ExternalSyntheticLambda0 = ring2.getErrorConfigVersion[0];
        Ring ring3 = this.MyBillsEntityDataFactory;
        ring3.isLayoutRequested = 0.0f;
        ring3.newProxyInstance = 0.0f;
        ring3.PrepareContext = 0.0f;
        ring3.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
        ring3.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
        ring3.initRecordTimeStamp = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setDuration(1332L);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.cancel();
        this.moveToNextValue = 0.0f;
        Ring ring = this.MyBillsEntityDataFactory;
        if (ring.DatabaseTableConfigUtil) {
            ring.DatabaseTableConfigUtil = false;
        }
        Ring ring2 = this.MyBillsEntityDataFactory;
        ring2.lookAheadTest = 0;
        ring2.NetworkUserEntityData$$ExternalSyntheticLambda0 = ring2.getErrorConfigVersion[0];
        Ring ring3 = this.MyBillsEntityDataFactory;
        ring3.isLayoutRequested = 0.0f;
        ring3.newProxyInstance = 0.0f;
        ring3.PrepareContext = 0.0f;
        ring3.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
        ring3.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
        ring3.initRecordTimeStamp = 0.0f;
        invalidateSelf();
    }

    final void KClassImpl$Data$declaredNonStaticMembers$2(float f, Ring ring, boolean z) {
        float interpolation;
        float f2;
        if (this.getAuthRequestContext) {
            BuiltInFictitiousFunctionClassFactory(f, ring);
            float floor = (float) (Math.floor(ring.PrepareContext / 0.8f) + 1.0d);
            ring.NetworkUserEntityData$$ExternalSyntheticLambda7 = ring.isLayoutRequested + (((ring.newProxyInstance - 0.01f) - ring.isLayoutRequested) * f);
            ring.NetworkUserEntityData$$ExternalSyntheticLambda2 = ring.newProxyInstance;
            ring.initRecordTimeStamp = ring.PrepareContext + ((floor - ring.PrepareContext) * f);
        } else if (f != 1.0f || z) {
            float f3 = ring.PrepareContext;
            if (f < 0.5f) {
                interpolation = ring.isLayoutRequested;
                f2 = (lookAheadTest.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f4 = ring.isLayoutRequested + 0.79f;
                interpolation = f4 - (((1.0f - lookAheadTest.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f2 = f4;
            }
            float f5 = this.BuiltInFictitiousFunctionClassFactory;
            ring.NetworkUserEntityData$$ExternalSyntheticLambda7 = interpolation;
            ring.NetworkUserEntityData$$ExternalSyntheticLambda2 = f2;
            ring.initRecordTimeStamp = f3 + (0.20999998f * f);
            this.moveToNextValue = (f + f5) * 216.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Ring {
        final Paint BuiltInFictitiousFunctionClassFactory;
        boolean DatabaseTableConfigUtil;
        float GetContactSyncConfig;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Paint NetworkUserEntityData$$ExternalSyntheticLambda1;
        float NetworkUserEntityData$$ExternalSyntheticLambda2;
        final RectF NetworkUserEntityData$$ExternalSyntheticLambda5 = new RectF();
        float NetworkUserEntityData$$ExternalSyntheticLambda7;
        float NetworkUserEntityData$$ExternalSyntheticLambda8;
        float PlaceComponentResult;
        float PrepareContext;
        Path getAuthRequestContext;
        int[] getErrorConfigVersion;
        float initRecordTimeStamp;
        float isLayoutRequested;
        int lookAheadTest;
        final Paint moveToNextValue;
        float newProxyInstance;
        int scheduleImpl;

        Ring() {
            Paint paint = new Paint();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = paint;
            Paint paint2 = new Paint();
            this.BuiltInFictitiousFunctionClassFactory = paint2;
            Paint paint3 = new Paint();
            this.moveToNextValue = paint3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
            this.initRecordTimeStamp = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = 5.0f;
            this.PlaceComponentResult = 1.0f;
            this.MyBillsEntityDataFactory = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }
    }

    static void BuiltInFictitiousFunctionClassFactory(float f, Ring ring) {
        if (f > 0.75f) {
            ring.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory((f - 0.75f) / 0.25f, ring.getErrorConfigVersion[ring.lookAheadTest], ring.getErrorConfigVersion[(ring.lookAheadTest + 1) % ring.getErrorConfigVersion.length]);
        } else {
            ring.NetworkUserEntityData$$ExternalSyntheticLambda0 = ring.getErrorConfigVersion[ring.lookAheadTest];
        }
    }
}
