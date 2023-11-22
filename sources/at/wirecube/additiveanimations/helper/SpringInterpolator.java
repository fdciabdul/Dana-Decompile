package at.wirecube.additiveanimations.helper;

import android.view.animation.Interpolator;

/* loaded from: classes6.dex */
public class SpringInterpolator implements Interpolator {
    double PlaceComponentResult = 0.13d;
    double BuiltInFictitiousFunctionClassFactory = 13.5d;

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        double d = -f;
        double d2 = this.PlaceComponentResult;
        Double.isNaN(d);
        double pow = Math.pow(2.718281828459045d, d / d2);
        double d3 = this.BuiltInFictitiousFunctionClassFactory;
        double d4 = f;
        Double.isNaN(d4);
        return (float) ((pow * (-1.0d) * Math.cos(d3 * d4)) + 1.0d);
    }
}
