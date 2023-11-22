package fsimpl;

import android.animation.ValueAnimator;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.view.animation.LinearInterpolator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class S extends PaintDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final LinearGradient f7813a = new LinearGradient(0.0f, 0.0f, 300.0f, 50.0f, new int[]{-61167, -54742, -45747}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.MIRROR);
    private final float b;
    private final ValueAnimator c;
    private long d;

    public S() {
        getPaint().setShader(this.f7813a);
        getPaint().setDither(true);
        this.b = a(300.0f, 50.0f);
        this.c = c();
    }

    private float a(float f, float f2) {
        if (f2 == 0.0f) {
            return f * 2.0f;
        }
        if (f == 0.0f) {
            return Float.NaN;
        }
        double d = f2;
        double tan = Math.tan(1.5707963267948966d - Math.atan(f / f2));
        Double.isNaN(d);
        return (f + ((float) (d * tan))) * 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float width = getBounds().width() / 1000.0f;
        Matrix matrix = new Matrix();
        matrix.preTranslate(floatValue, 0.0f);
        matrix.postScale(width, width);
        this.f7813a.setLocalMatrix(matrix);
        invalidateSelf();
    }

    private ValueAnimator c() {
        if (Float.isNaN(this.b)) {
            return null;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatMode(1);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setDuration(8000L);
        valueAnimator.setFloatValues(0.0f, this.b);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: fsimpl.-$$Lambda$S$xlyCbs_NVz2244z_JLDu1FshT7Y
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                S.this.a(valueAnimator2);
            }
        });
        return valueAnimator;
    }

    public void a() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.d);
            this.c.start();
        }
    }

    public void b() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            this.d = valueAnimator.getCurrentPlayTime();
            this.c.cancel();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(this.c);
    }
}
