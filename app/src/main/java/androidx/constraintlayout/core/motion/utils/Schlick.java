package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class Schlick extends Easing {
    double KClassImpl$Data$declaredNonStaticMembers$2;
    double MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Schlick(String str) {
        this.getAuthRequestContext = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        this.MyBillsEntityDataFactory = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double getAuthRequestContext(double d) {
        double d2 = this.MyBillsEntityDataFactory;
        if (d < d2) {
            return (d2 * d) / (d + (this.KClassImpl$Data$declaredNonStaticMembers$2 * (d2 - d)));
        }
        return ((1.0d - d2) * (d - 1.0d)) / ((1.0d - d) - (this.KClassImpl$Data$declaredNonStaticMembers$2 * (d2 - d)));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double BuiltInFictitiousFunctionClassFactory(double d) {
        double d2 = this.MyBillsEntityDataFactory;
        if (d < d2) {
            double d3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            double d4 = d3 * d2 * d2;
            double d5 = ((d2 - d) * d3) + d;
            return d4 / (d5 * d5);
        }
        double d6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        double d7 = d2 - 1.0d;
        double d8 = d7 * d6 * d7;
        double d9 = (((-d6) * (d2 - d)) - d) + 1.0d;
        return d8 / (d9 * d9);
    }
}
