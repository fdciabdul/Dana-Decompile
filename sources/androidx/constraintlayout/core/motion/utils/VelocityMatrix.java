package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes6.dex */
public class VelocityMatrix {
    public float BuiltInFictitiousFunctionClassFactory;
    public float KClassImpl$Data$declaredNonStaticMembers$2;
    public float MyBillsEntityDataFactory;
    public float PlaceComponentResult;
    public float getAuthRequestContext;
    public float lookAheadTest;

    public final void MyBillsEntityDataFactory(float f, float f2, int i, int i2, float[] fArr) {
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = (f - 0.5f) * 2.0f;
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = this.MyBillsEntityDataFactory;
        float f8 = this.getAuthRequestContext;
        float f9 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        float f10 = this.PlaceComponentResult;
        float radians = (float) Math.toRadians(this.lookAheadTest);
        float radians2 = (float) Math.toRadians(this.BuiltInFictitiousFunctionClassFactory);
        double d = (-i) * f5;
        double d2 = radians;
        double sin = Math.sin(d2);
        double d3 = i2 * f6;
        double cos = Math.cos(d2);
        Double.isNaN(d);
        Double.isNaN(d3);
        float f11 = (float) ((d * sin) - (cos * d3));
        double d4 = i * f5;
        double cos2 = Math.cos(d2);
        double sin2 = Math.sin(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        fArr[0] = f3 + f7 + (f9 * f5) + (f11 * radians2);
        fArr[1] = f4 + f8 + (f10 * f6) + (radians2 * ((float) ((d4 * cos2) - (d3 * sin2))));
    }
}
