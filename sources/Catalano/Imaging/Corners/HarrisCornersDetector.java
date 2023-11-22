package Catalano.Imaging.Corners;

import Catalano.Core.ArraysUtil;
import Catalano.Math.Functions.Gaussian;

/* loaded from: classes6.dex */
public class HarrisCornersDetector implements ICornersDetector {
    private HarrisCornerMeasure BuiltInFictitiousFunctionClassFactory;
    private double KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    private float[] getAuthRequestContext;
    private float lookAheadTest;
    private int moveToNextValue;

    /* loaded from: classes6.dex */
    public enum HarrisCornerMeasure {
        Harris,
        Noble
    }

    public HarrisCornersDetector() {
        this.BuiltInFictitiousFunctionClassFactory = HarrisCornerMeasure.Harris;
        this.MyBillsEntityDataFactory = 0.04f;
        this.lookAheadTest = 20000.0f;
        this.moveToNextValue = 3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1.2d;
        this.PlaceComponentResult = 7;
        HarrisCornerMeasure harrisCornerMeasure = HarrisCornerMeasure.Harris;
        float f = this.MyBillsEntityDataFactory;
        float f2 = this.lookAheadTest;
        double d = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.moveToNextValue;
        int i2 = this.PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory = harrisCornerMeasure;
        this.lookAheadTest = f2;
        this.MyBillsEntityDataFactory = f;
        this.moveToNextValue = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = d;
        this.PlaceComponentResult = i2;
        this.getAuthRequestContext = ArraysUtil.PlaceComponentResult(new Gaussian(d).MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
