package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;

/* loaded from: classes3.dex */
public class Easing {
    public static final EasingFunction readMicros = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.1
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return f;
        }
    };
    public static final EasingFunction NetworkUserEntityData$$ExternalSyntheticLambda8 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.2
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return f * f;
        }
    };
    public static final EasingFunction NetworkUserEntityData$$ExternalSyntheticLambda4 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.3
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return (-f) * (f - 2.0f);
        }
    };
    public static final EasingFunction initRecordTimeStamp = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.4
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                return 0.5f * f2 * f2;
            }
            float f3 = f2 - 1.0f;
            return ((f3 * (f3 - 2.0f)) - 1.0f) * (-0.5f);
        }
    };
    public static final EasingFunction MyBillsEntityDataFactory = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.5
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return (float) Math.pow(f, 3.0d);
        }
    };
    public static final EasingFunction NetworkUserEntityData$$ExternalSyntheticLambda5 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.6
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return ((float) Math.pow(f - 1.0f, 3.0d)) + 1.0f;
        }
    };
    public static final EasingFunction getErrorConfigVersion = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.7
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float pow;
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                pow = (float) Math.pow(f2, 3.0d);
            } else {
                pow = ((float) Math.pow(f2 - 2.0f, 3.0d)) + 2.0f;
            }
            return pow * 0.5f;
        }
    };
    public static final EasingFunction NetworkUserEntityData$$ExternalSyntheticLambda7 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.8
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return (float) Math.pow(f, 4.0d);
        }
    };
    public static final EasingFunction getSupportButtonTintMode = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.9
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return -(((float) Math.pow(f - 1.0f, 4.0d)) - 1.0f);
        }
    };
    public static final EasingFunction NetworkUserEntityData$$ExternalSyntheticLambda2 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.10
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float pow;
            float f2;
            float f3 = f * 2.0f;
            if (f3 < 1.0f) {
                pow = (float) Math.pow(f3, 4.0d);
                f2 = 0.5f;
            } else {
                pow = ((float) Math.pow(f3 - 2.0f, 4.0d)) - 2.0f;
                f2 = -0.5f;
            }
            return pow * f2;
        }
    };
    public static final EasingFunction PrepareContext = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.11
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            double d = f;
            Double.isNaN(d);
            return (-((float) Math.cos(d * 1.5707963267948966d))) + 1.0f;
        }
    };
    public static final EasingFunction whenAvailable = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.12
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            double d = f;
            Double.isNaN(d);
            return (float) Math.sin(d * 1.5707963267948966d);
        }
    };
    public static final EasingFunction NetworkUserEntityData$$ExternalSyntheticLambda1 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.13
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            double d = f;
            Double.isNaN(d);
            return (((float) Math.cos(d * 3.141592653589793d)) - 1.0f) * (-0.5f);
        }
    };
    public static final EasingFunction lookAheadTest = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.14
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (f - 1.0f) * 10.0f);
        }
    };
    public static final EasingFunction NetworkUserEntityData$$ExternalSyntheticLambda6 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.15
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (f == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (f + 1.0f) * (-10.0f)));
        }
    };
    public static final EasingFunction GetContactSyncConfig = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.16
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2;
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            if (f * 2.0f < 1.0f) {
                f2 = (float) Math.pow(2.0d, (r7 - 1.0f) * 10.0f);
            } else {
                f2 = (-((float) Math.pow(2.0d, (r7 - 1.0f) * (-10.0f)))) + 2.0f;
            }
            return f2 * 0.5f;
        }
    };
    public static final EasingFunction getAuthRequestContext = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.17
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return -(((float) Math.sqrt(1.0f - (f * f))) - 1.0f);
        }
    };
    public static final EasingFunction FragmentBottomSheetPaymentSettingBinding = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.18
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (float) Math.sqrt(1.0f - (f2 * f2));
        }
    };
    public static final EasingFunction scheduleImpl = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.19
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float sqrt;
            float f2;
            float f3 = f * 2.0f;
            if (f3 < 1.0f) {
                sqrt = ((float) Math.sqrt(1.0f - (f3 * f3))) - 1.0f;
                f2 = -0.5f;
            } else {
                float f4 = f3 - 2.0f;
                sqrt = ((float) Math.sqrt(1.0f - (f4 * f4))) + 1.0f;
                f2 = 0.5f;
            }
            return sqrt * f2;
        }
    };
    public static final EasingFunction KClassImpl$Data$declaredNonStaticMembers$2 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.20
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            float f2 = f - 1.0f;
            return -(((float) Math.pow(2.0d, 10.0f * f2)) * ((float) Math.sin(((f2 - (((float) Math.asin(1.0d)) * 0.047746483f)) * 6.2831855f) / 0.3f)));
        }
    };
    public static final EasingFunction NetworkUserEntityData$$ExternalSyntheticLambda3 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.21
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (-10.0f) * f)) * ((float) Math.sin(((f - (((float) Math.asin(1.0d)) * 0.047746483f)) * 6.2831855f) / 0.3f))) + 1.0f;
        }
    };
    public static final EasingFunction DatabaseTableConfigUtil = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.22
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            float f2 = f * 2.0f;
            if (f2 == 2.0f) {
                return 1.0f;
            }
            float asin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f2 < 1.0f) {
                float f3 = f2 - 1.0f;
                return ((float) Math.pow(2.0d, 10.0f * f3)) * ((float) Math.sin(((f3 * 1.0f) - asin) * 6.2831855f * 2.2222223f)) * (-0.5f);
            }
            float f4 = f2 - 1.0f;
            return (((float) Math.pow(2.0d, (-10.0f) * f4)) * 0.5f * ((float) Math.sin(((f4 * 1.0f) - asin) * 6.2831855f * 2.2222223f))) + 1.0f;
        }
    };
    public static final EasingFunction BuiltInFictitiousFunctionClassFactory = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.23
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return f * f * ((f * 2.70158f) - 1.70158f);
        }
    };
    public static final EasingFunction newProxyInstance = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.24
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * ((f2 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    };
    public static final EasingFunction moveToNextValue = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.25
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                return f2 * f2 * ((f2 * 3.5949094f) - 2.5949094f) * 0.5f;
            }
            float f3 = f2 - 2.0f;
            return ((f3 * f3 * ((f3 * 3.5949094f) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction PlaceComponentResult = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.26
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return 1.0f - Easing.isLayoutRequested.getInterpolation(1.0f - f);
        }
    };
    public static final EasingFunction isLayoutRequested = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.27
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (f < 0.36363637f) {
                return 7.5625f * f * f;
            }
            if (f < 0.72727275f) {
                float f2 = f - 0.54545456f;
                return (7.5625f * f2 * f2) + 0.75f;
            } else if (f < 0.90909094f) {
                float f3 = f - 0.8181818f;
                return (7.5625f * f3 * f3) + 0.9375f;
            } else {
                float f4 = f - 0.95454544f;
                return (7.5625f * f4 * f4) + 0.984375f;
            }
        }
    };
    public static final EasingFunction NetworkUserEntityData$$ExternalSyntheticLambda0 = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.28
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (f < 0.5f) {
                return Easing.PlaceComponentResult.getInterpolation(f * 2.0f) * 0.5f;
            }
            return (Easing.isLayoutRequested.getInterpolation((f * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    };

    /* loaded from: classes3.dex */
    public interface EasingFunction extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float f);
    }
}
