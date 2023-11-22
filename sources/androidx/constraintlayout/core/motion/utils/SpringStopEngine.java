package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class SpringStopEngine implements StopEngine {
    public double MyBillsEntityDataFactory;
    public float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float NetworkUserEntityData$$ExternalSyntheticLambda2;
    public float getAuthRequestContext;
    public float getErrorConfigVersion;
    public double lookAheadTest;
    public float moveToNextValue;
    public double scheduleImpl;
    public double KClassImpl$Data$declaredNonStaticMembers$2 = 0.5d;
    public boolean PlaceComponentResult = false;
    public int BuiltInFictitiousFunctionClassFactory = 0;

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final float BuiltInFictitiousFunctionClassFactory(float f) {
        SpringStopEngine springStopEngine = this;
        float f2 = f;
        double d = f2 - springStopEngine.getAuthRequestContext;
        double d2 = springStopEngine.scheduleImpl;
        double d3 = springStopEngine.KClassImpl$Data$declaredNonStaticMembers$2;
        double d4 = springStopEngine.getErrorConfigVersion;
        Double.isNaN(d4);
        double sqrt = Math.sqrt(d2 / d4);
        Double.isNaN(d);
        int i = (int) ((9.0d / ((sqrt * d) * 4.0d)) + 1.0d);
        double d5 = i;
        Double.isNaN(d);
        Double.isNaN(d5);
        double d6 = d / d5;
        int i2 = 0;
        while (i2 < i) {
            double d7 = springStopEngine.moveToNextValue;
            double d8 = springStopEngine.lookAheadTest;
            int i3 = i;
            int i4 = i2;
            double d9 = springStopEngine.NetworkUserEntityData$$ExternalSyntheticLambda2;
            double d10 = springStopEngine.getErrorConfigVersion;
            Double.isNaN(d7);
            Double.isNaN(d9);
            Double.isNaN(d10);
            Double.isNaN(d9);
            double d11 = ((((((-d2) * (d7 - d8)) - (d9 * d3)) / d10) * d6) / 2.0d) + d9;
            Double.isNaN(d7);
            Double.isNaN(d10);
            double d12 = ((((-((d7 + ((d6 * d11) / 2.0d)) - d8)) * d2) - (d11 * d3)) / d10) * d6;
            double d13 = d12 / 2.0d;
            Double.isNaN(d9);
            float f3 = (float) (d12 + d9);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f3;
            Double.isNaN(d9);
            Double.isNaN(d7);
            float f4 = (float) (d7 + ((d9 + d13) * d6));
            this.moveToNextValue = f4;
            int i5 = this.BuiltInFictitiousFunctionClassFactory;
            if (i5 > 0) {
                if (f4 < 0.0f && (i5 & 1) == 1) {
                    this.moveToNextValue = -f4;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -f3;
                }
                float f5 = this.moveToNextValue;
                if (f5 > 1.0f && (i5 & 2) == 2) {
                    this.moveToNextValue = 2.0f - f5;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                }
            }
            i2 = i4 + 1;
            f2 = f;
            springStopEngine = this;
            i = i3;
        }
        SpringStopEngine springStopEngine2 = springStopEngine;
        springStopEngine2.getAuthRequestContext = f2;
        return springStopEngine2.moveToNextValue;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final boolean getAuthRequestContext() {
        double d = this.moveToNextValue;
        double d2 = this.lookAheadTest;
        Double.isNaN(d);
        double d3 = d - d2;
        double d4 = this.scheduleImpl;
        double d5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        double d6 = this.getErrorConfigVersion;
        Double.isNaN(d5);
        Double.isNaN(d5);
        Double.isNaN(d6);
        return Math.sqrt((((d5 * d5) * d6) + ((d4 * d3) * d3)) / d4) <= ((double) this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }
}
