package Catalano.Imaging.Filters.Photometric;

import Catalano.Imaging.Tools.Kernel;
import Catalano.Math.Functions.Gaussian;

/* loaded from: classes6.dex */
public class DifferenceOfGaussian implements IPhotometricFilter {
    private double BuiltInFictitiousFunctionClassFactory;
    private double KClassImpl$Data$declaredNonStaticMembers$2;
    private double[][] MyBillsEntityDataFactory;
    private double[][] PlaceComponentResult;

    public DifferenceOfGaussian() {
        this((byte) 0);
    }

    private DifferenceOfGaussian(byte b) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1.0d;
        this.BuiltInFictitiousFunctionClassFactory = 2.0d;
        int ceil = (int) Math.ceil(1.0d * 3.0d);
        Gaussian gaussian = new Gaussian(this.KClassImpl$Data$declaredNonStaticMembers$2);
        double[][] KClassImpl$Data$declaredNonStaticMembers$2 = gaussian.KClassImpl$Data$declaredNonStaticMembers$2((ceil * 2) + 1);
        int ceil2 = (int) Math.ceil(this.BuiltInFictitiousFunctionClassFactory * 3.0d);
        double d = this.BuiltInFictitiousFunctionClassFactory;
        gaussian.PlaceComponentResult = Math.max(1.0E-8d, d);
        gaussian.KClassImpl$Data$declaredNonStaticMembers$2 = d * d;
        double[][] KClassImpl$Data$declaredNonStaticMembers$22 = gaussian.KClassImpl$Data$declaredNonStaticMembers$2((ceil2 * 2) + 1);
        this.MyBillsEntityDataFactory = Kernel.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2);
        this.PlaceComponentResult = Kernel.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$22);
    }
}
