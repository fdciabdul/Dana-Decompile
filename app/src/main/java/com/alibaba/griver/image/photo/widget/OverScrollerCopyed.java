package com.alibaba.griver.image.photo.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class OverScrollerCopyed {
    static float sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
    static float sViscousFluidScale = 8.0f;

    /* renamed from: a  reason: collision with root package name */
    private int f6623a;
    private final SplineOverScroller b;
    private final SplineOverScroller c;
    private Interpolator d;
    private final boolean e;

    public OverScrollerCopyed(Context context) {
        this(context, null);
    }

    public OverScrollerCopyed(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public OverScrollerCopyed(Context context, Interpolator interpolator, boolean z) {
        this.d = interpolator;
        this.e = z;
        this.b = new SplineOverScroller(context);
        this.c = new SplineOverScroller(context);
    }

    void setInterpolator(Interpolator interpolator) {
        this.d = interpolator;
    }

    public final void setFriction(float f) {
        this.b.setFriction(f);
        this.c.setFriction(f);
    }

    public final boolean isFinished() {
        return this.b.k && this.c.k;
    }

    public final void forceFinished(boolean z) {
        this.b.k = this.c.k = z;
    }

    public final int getCurrX() {
        return this.b.b;
    }

    public final int getCurrY() {
        return this.c.b;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.b.e * this.b.e) + (this.c.e * this.c.e));
    }

    public final int getStartX() {
        return this.b.f6624a;
    }

    public final int getStartY() {
        return this.c.f6624a;
    }

    public final int getFinalX() {
        return this.b.c;
    }

    public final int getFinalY() {
        return this.c.c;
    }

    @Deprecated
    public final int getDuration() {
        return Math.max(this.b.h, this.c.h);
    }

    @Deprecated
    public void extendDuration(int i) {
        this.b.extendDuration(i);
        this.c.extendDuration(i);
    }

    @Deprecated
    public void setFinalX(int i) {
        this.b.setFinalPosition(i);
    }

    @Deprecated
    public void setFinalY(int i) {
        this.c.setFinalPosition(i);
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        int i = this.f6623a;
        if (i == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.b.g;
            int i2 = this.b.h;
            if (currentAnimationTimeMillis < i2) {
                float f = ((float) currentAnimationTimeMillis) / i2;
                Interpolator interpolator = this.d;
                if (interpolator == null) {
                    interpolation = viscousFluid(f);
                } else {
                    interpolation = interpolator.getInterpolation(f);
                }
                this.b.updateScroll(interpolation);
                this.c.updateScroll(interpolation);
            } else {
                abortAnimation();
            }
        } else if (i == 1) {
            if (!this.b.k && !this.b.update() && !this.b.continueWhenFinished()) {
                this.b.finish();
            }
            if (!this.c.k && !this.c.update() && !this.c.continueWhenFinished()) {
                this.c.finish();
            }
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, 250);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.f6623a = 0;
        this.b.startScroll(i, i3, i5);
        this.c.startScroll(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f6623a = 1;
        return this.b.springback(i, i3, i4) || this.c.springback(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (!this.e || isFinished()) {
            i11 = i3;
        } else {
            float f = this.b.e;
            float f2 = this.c.e;
            i11 = i3;
            float f3 = i11;
            if (Math.signum(f3) == Math.signum(f)) {
                i12 = i4;
                float f4 = i12;
                if (Math.signum(f4) == Math.signum(f2)) {
                    i13 = (int) (f4 + f2);
                    i14 = (int) (f3 + f);
                    this.f6623a = 1;
                    this.b.fling(i, i14, i5, i6, i9);
                    this.c.fling(i2, i13, i7, i8, i10);
                }
                i13 = i12;
                i14 = i11;
                this.f6623a = 1;
                this.b.fling(i, i14, i5, i6, i9);
                this.c.fling(i2, i13, i7, i8, i10);
            }
        }
        i12 = i4;
        i13 = i12;
        i14 = i11;
        this.f6623a = 1;
        this.b.fling(i, i14, i5, i6, i9);
        this.c.fling(i2, i13, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.b.notifyEdgeReached(i, i2, i3);
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.c.notifyEdgeReached(i, i2, i3);
    }

    public boolean isOverScrolled() {
        return ((this.b.k || this.b.n == 0) && (this.c.k || this.c.n == 0)) ? false : true;
    }

    public void abortAnimation() {
        this.b.finish();
        this.c.finish();
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - Math.min(this.b.g, this.c.g));
    }

    public boolean isScrollingInDirection(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.b.c - this.b.f6624a)) && Math.signum(f2) == Math.signum((float) (this.c.c - this.c.f6624a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SplineOverScroller {
        private static float p = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] q = new float[101];
        private static final float[] r = new float[101];

        /* renamed from: a  reason: collision with root package name */
        private int f6624a;
        private int b;
        private int c;
        private int d;
        private float e;
        private float f;
        private long g;
        private int h;
        private int i;
        private int j;
        private int l;

        /* renamed from: o  reason: collision with root package name */
        private float f6625o;
        private float m = ViewConfiguration.getScrollFriction();
        private int n = 0;
        private boolean k = true;

        private static float a(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        static {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9 = 0.0f;
            float f10 = 0.0f;
            for (int i = 0; i < 100; i++) {
                float f11 = i / 100.0f;
                float f12 = 1.0f;
                while (true) {
                    f = ((f12 - f9) / 2.0f) + f9;
                    f2 = 1.0f - f;
                    f3 = f * 3.0f * f2;
                    f4 = f * f * f;
                    float f13 = (((f2 * 0.175f) + (f * 0.35000002f)) * f3) + f4;
                    if (Math.abs(f13 - f11) < 1.0E-5d) {
                        break;
                    } else if (f13 > f11) {
                        f12 = f;
                    } else {
                        f9 = f;
                    }
                }
                float f14 = 0.5f;
                q[i] = (f3 * ((f2 * 0.5f) + f)) + f4;
                float f15 = 1.0f;
                while (true) {
                    f5 = ((f15 - f10) / 2.0f) + f10;
                    f6 = 1.0f - f5;
                    f7 = f5 * 3.0f * f6;
                    f8 = f5 * f5 * f5;
                    float f16 = (((f6 * f14) + f5) * f7) + f8;
                    if (Math.abs(f16 - f11) < 1.0E-5d) {
                        break;
                    }
                    if (f16 > f11) {
                        f15 = f5;
                    } else {
                        f10 = f5;
                    }
                    f14 = 0.5f;
                }
                r[i] = (f7 * ((f6 * 0.175f) + (f5 * 0.35000002f))) + f8;
            }
            float[] fArr = q;
            r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.m = f;
        }

        SplineOverScroller(Context context) {
            this.f6625o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void updateScroll(float f) {
            this.b = this.f6624a + Math.round(f * (this.c - r0));
        }

        private void a(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (abs * 100.0f);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                int i5 = i4 + 1;
                float[] fArr = r;
                float f2 = fArr[i4];
                this.h = (int) (this.h * (f2 + (((abs - f) / ((i5 / 100.0f) - f)) * (fArr[i5] - f2))));
            }
        }

        void startScroll(int i, int i2, int i3) {
            this.k = false;
            this.f6624a = i;
            this.c = i + i2;
            this.g = AnimationUtils.currentAnimationTimeMillis();
            this.h = i3;
            this.f = 0.0f;
            this.d = 0;
        }

        void finish() {
            this.b = this.c;
            this.k = true;
        }

        void setFinalPosition(int i) {
            this.c = i;
            this.k = false;
        }

        void extendDuration(int i) {
            this.h = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.g)) + i;
            this.k = false;
        }

        boolean springback(int i, int i2, int i3) {
            this.k = true;
            this.c = i;
            this.f6624a = i;
            this.d = 0;
            this.g = AnimationUtils.currentAnimationTimeMillis();
            this.h = 0;
            if (i < i2) {
                b(i, i2, 0);
            } else if (i > i3) {
                b(i, i3, 0);
            }
            return !this.k;
        }

        private void b(int i, int i2, int i3) {
            this.k = false;
            this.n = 1;
            this.f6624a = i;
            this.c = i2;
            int i4 = i - i2;
            this.f = a(i4);
            this.d = -i4;
            this.l = Math.abs(i4);
            double d = i4;
            double d2 = this.f;
            Double.isNaN(d);
            Double.isNaN(d2);
            this.h = (int) (Math.sqrt((d * (-2.0d)) / d2) * 1000.0d);
        }

        void fling(int i, int i2, int i3, int i4, int i5) {
            this.l = i5;
            this.k = false;
            this.d = i2;
            float f = i2;
            this.e = f;
            this.i = 0;
            this.h = 0;
            this.g = AnimationUtils.currentAnimationTimeMillis();
            this.f6624a = i;
            this.b = i;
            if (i > i4 || i < i3) {
                a(i, i3, i4, i2);
                return;
            }
            this.n = 0;
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (i2 != 0) {
                int d2 = d(i2);
                this.i = d2;
                this.h = d2;
                d = c(i2);
            }
            double signum = Math.signum(f);
            Double.isNaN(signum);
            int i6 = (int) (d * signum);
            this.j = i6;
            int i7 = i + i6;
            this.c = i7;
            if (i7 < i3) {
                a(this.f6624a, i7, i3);
                this.c = i3;
            }
            int i8 = this.c;
            if (i8 > i4) {
                a(this.f6624a, i8, i4);
                this.c = i4;
            }
        }

        private double b(int i) {
            return Math.log((Math.abs(i) * 0.35f) / (this.m * this.f6625o));
        }

        private double c(int i) {
            double b = b(i);
            double d = p;
            double d2 = this.m * this.f6625o;
            Double.isNaN(d);
            Double.isNaN(d);
            double exp = Math.exp((d / (d - 1.0d)) * b);
            Double.isNaN(d2);
            return d2 * exp;
        }

        private int d(int i) {
            double b = b(i);
            double d = p;
            Double.isNaN(d);
            return (int) (Math.exp(b / (d - 1.0d)) * 1000.0d);
        }

        private void c(int i, int i2, int i3) {
            float f = this.f;
            float f2 = (-i3) / f;
            double abs = (((i3 * i3) / 2.0f) / Math.abs(f)) + Math.abs(i2 - i);
            double abs2 = Math.abs(this.f);
            Double.isNaN(abs);
            Double.isNaN(abs2);
            float sqrt = (float) Math.sqrt((abs * 2.0d) / abs2);
            this.g -= (int) ((sqrt - f2) * 1000.0f);
            this.f6624a = i2;
            this.d = (int) ((-this.f) * sqrt);
        }

        private void d(int i, int i2, int i3) {
            this.f = a(i3 == 0 ? i - i2 : i3);
            c(i, i2, i3);
            a();
        }

        private void a(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                InstrumentInjector.log_e("OverScroller", "startAfterEdge called from a valid position");
                this.k = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            if ((i - i5) * i4 >= 0) {
                d(i, i5, i4);
            } else if (c(i4) > Math.abs(r9)) {
                fling(i, i4, !z ? i : i2, z ? i : i3, this.l);
            } else {
                b(i, i5, i4);
            }
        }

        void notifyEdgeReached(int i, int i2, int i3) {
            if (this.n == 0) {
                this.l = i3;
                this.g = AnimationUtils.currentAnimationTimeMillis();
                a(i, i2, i2, (int) this.e);
            }
        }

        private void a() {
            int i = this.d;
            float abs = (i * i) / (Math.abs(this.f) * 2.0f);
            float signum = Math.signum(this.d);
            float f = this.l;
            if (abs > f) {
                float f2 = -signum;
                float f3 = this.d;
                this.f = ((f2 * f3) * f3) / (2.0f * f);
                abs = f;
            }
            this.l = (int) abs;
            this.n = 2;
            int i2 = this.f6624a;
            int i3 = this.d;
            if (i3 <= 0) {
                abs = -abs;
            }
            this.c = i2 + ((int) abs);
            this.h = -((int) ((i3 * 1000.0f) / this.f));
        }

        boolean continueWhenFinished() {
            int i = this.n;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                if (i == 2) {
                    this.g += this.h;
                    b(this.c, this.f6624a, 0);
                }
            } else if (this.h >= this.i) {
                return false;
            } else {
                this.f6624a = this.c;
                int i2 = (int) this.e;
                this.d = i2;
                this.f = a(i2);
                this.g += this.h;
                a();
            }
            update();
            return true;
        }

        boolean update() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.g;
            int i = this.h;
            if (currentAnimationTimeMillis > i) {
                return false;
            }
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            int i2 = this.n;
            if (i2 == 0) {
                float f = this.i;
                float f2 = ((float) currentAnimationTimeMillis) / f;
                int i3 = (int) (f2 * 100.0f);
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (i3 < 100) {
                    float f5 = i3 / 100.0f;
                    int i4 = i3 + 1;
                    float[] fArr = q;
                    float f6 = fArr[i3];
                    f4 = (fArr[i4] - f6) / ((i4 / 100.0f) - f5);
                    f3 = f6 + ((f2 - f5) * f4);
                }
                float f7 = this.j;
                d = f3 * f7;
                this.e = ((f4 * f7) / f) * 1000.0f;
            } else if (i2 == 1) {
                float f8 = ((float) currentAnimationTimeMillis) / i;
                float f9 = f8 * f8;
                float signum = this.l * Math.signum(this.d);
                this.e = signum * 6.0f * ((-f8) + f9);
                d = ((3.0f * f9) - ((2.0f * f8) * f9)) * signum;
            } else if (i2 == 2) {
                float f10 = ((float) currentAnimationTimeMillis) / 1000.0f;
                float f11 = this.d;
                float f12 = this.f * f10;
                this.e = f11 + f12;
                d = (f11 * f10) + ((f12 * f10) / 2.0f);
            }
            this.b = this.f6624a + ((int) Math.round(d));
            return true;
        }
    }

    static float viscousFluid(float f) {
        float exp;
        float f2 = f * sViscousFluidScale;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f);
        }
        return exp * sViscousFluidNormalize;
    }
}
