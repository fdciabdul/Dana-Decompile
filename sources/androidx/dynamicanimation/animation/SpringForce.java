package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public final class SpringForce implements Force {
    double BuiltInFictitiousFunctionClassFactory;
    double KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    double NetworkUserEntityData$$ExternalSyntheticLambda0;
    public double PlaceComponentResult;
    public double getAuthRequestContext;
    private double getErrorConfigVersion;
    private double lookAheadTest;
    private final DynamicAnimation.MassState moveToNextValue;
    private double scheduleImpl;

    public SpringForce() {
        this.BuiltInFictitiousFunctionClassFactory = Math.sqrt(1500.0d);
        this.getAuthRequestContext = 0.5d;
        this.MyBillsEntityDataFactory = false;
        this.PlaceComponentResult = Double.MAX_VALUE;
        this.moveToNextValue = new DynamicAnimation.MassState();
    }

    public SpringForce(float f) {
        this.BuiltInFictitiousFunctionClassFactory = Math.sqrt(1500.0d);
        this.getAuthRequestContext = 0.5d;
        this.MyBillsEntityDataFactory = false;
        this.PlaceComponentResult = Double.MAX_VALUE;
        this.moveToNextValue = new DynamicAnimation.MassState();
        this.PlaceComponentResult = f;
    }

    public final SpringForce KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.BuiltInFictitiousFunctionClassFactory = Math.sqrt(f);
        this.MyBillsEntityDataFactory = false;
        return this;
    }

    public final boolean getAuthRequestContext(float f, float f2) {
        return ((double) Math.abs(f2)) < this.NetworkUserEntityData$$ExternalSyntheticLambda0 && ((double) Math.abs(f - ((float) this.PlaceComponentResult))) < this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        if (this.PlaceComponentResult == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d = this.getAuthRequestContext;
        if (d > 1.0d) {
            double d2 = this.BuiltInFictitiousFunctionClassFactory;
            this.getErrorConfigVersion = ((-d) * d2) + (d2 * Math.sqrt((d * d) - 1.0d));
            double d3 = this.getAuthRequestContext;
            double d4 = this.BuiltInFictitiousFunctionClassFactory;
            this.scheduleImpl = ((-d3) * d4) - (d4 * Math.sqrt((d3 * d3) - 1.0d));
        } else if (d >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d < 1.0d) {
            this.lookAheadTest = this.BuiltInFictitiousFunctionClassFactory * Math.sqrt(1.0d - (d * d));
        }
        this.MyBillsEntityDataFactory = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DynamicAnimation.MassState getAuthRequestContext(double d, double d2, long j) {
        double pow;
        double cos;
        KClassImpl$Data$declaredNonStaticMembers$2();
        double d3 = j;
        Double.isNaN(d3);
        double d4 = d3 / 1000.0d;
        double d5 = d - this.PlaceComponentResult;
        double d6 = this.getAuthRequestContext;
        if (d6 > 1.0d) {
            double d7 = this.scheduleImpl;
            double d8 = ((d7 * d5) - d2) / (d7 - this.getErrorConfigVersion);
            double d9 = d5 - d8;
            pow = (Math.pow(2.718281828459045d, d7 * d4) * d9) + (Math.pow(2.718281828459045d, this.getErrorConfigVersion * d4) * d8);
            double d10 = this.scheduleImpl;
            double pow2 = Math.pow(2.718281828459045d, d10 * d4);
            double d11 = this.getErrorConfigVersion;
            cos = (d9 * d10 * pow2) + (d8 * d11 * Math.pow(2.718281828459045d, d11 * d4));
        } else if (d6 == 1.0d) {
            double d12 = this.BuiltInFictitiousFunctionClassFactory;
            double d13 = d2 + (d12 * d5);
            double d14 = d5 + (d13 * d4);
            pow = Math.pow(2.718281828459045d, (-d12) * d4) * d14;
            double pow3 = Math.pow(2.718281828459045d, (-this.BuiltInFictitiousFunctionClassFactory) * d4);
            double d15 = -this.BuiltInFictitiousFunctionClassFactory;
            cos = (d14 * pow3 * d15) + (d13 * Math.pow(2.718281828459045d, d4 * d15));
        } else {
            double d16 = 1.0d / this.lookAheadTest;
            double d17 = this.BuiltInFictitiousFunctionClassFactory;
            double d18 = d16 * ((d6 * d17 * d5) + d2);
            pow = Math.pow(2.718281828459045d, (-d6) * d17 * d4) * ((Math.cos(this.lookAheadTest * d4) * d5) + (Math.sin(this.lookAheadTest * d4) * d18));
            double d19 = this.BuiltInFictitiousFunctionClassFactory;
            double d20 = -d19;
            double d21 = this.getAuthRequestContext;
            double pow4 = Math.pow(2.718281828459045d, (-d21) * d19 * d4);
            double d22 = this.lookAheadTest;
            double d23 = -d22;
            double sin = Math.sin(d22 * d4);
            double d24 = this.lookAheadTest;
            cos = (d20 * pow * d21) + (((d23 * d5 * sin) + (d18 * d24 * Math.cos(d24 * d4))) * pow4);
        }
        this.moveToNextValue.PlaceComponentResult = (float) (pow + this.PlaceComponentResult);
        this.moveToNextValue.getAuthRequestContext = (float) cos;
        return this.moveToNextValue;
    }
}
