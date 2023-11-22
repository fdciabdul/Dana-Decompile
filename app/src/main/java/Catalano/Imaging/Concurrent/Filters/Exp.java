package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import Catalano.Math.Approximation;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Exp implements IApplyInPlace {

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        private Share MyBillsEntityDataFactory;

        @Override // java.lang.Runnable
        public void run() {
            double log = 255.0d / Math.log(255.0d);
            if (this.MyBillsEntityDataFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                for (int i = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory; i < this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory; i++) {
                    for (int i2 = 0; i2 < this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i2++) {
                        FastBitmap fastBitmap = this.MyBillsEntityDataFactory.getAuthRequestContext;
                        double d = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] & 255;
                        Double.isNaN(d);
                        double PlaceComponentResult = Approximation.PlaceComponentResult(d / log);
                        if (PlaceComponentResult < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            PlaceComponentResult = 0.0d;
                        }
                        if (PlaceComponentResult > 255.0d) {
                            PlaceComponentResult = 255.0d;
                        }
                        this.MyBillsEntityDataFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, (int) PlaceComponentResult);
                    }
                }
            }
            if (this.MyBillsEntityDataFactory.getAuthRequestContext.getAuthRequestContext()) {
                for (int i3 = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory; i3 < this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory; i3++) {
                    for (int i4 = 0; i4 < this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i4++) {
                        FastBitmap fastBitmap2 = this.MyBillsEntityDataFactory.getAuthRequestContext;
                        double d2 = (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i3) + (fastBitmap2.MyBillsEntityDataFactory * i4)] >> 16) & 255;
                        FastBitmap fastBitmap3 = this.MyBillsEntityDataFactory.getAuthRequestContext;
                        double d3 = (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i3) + (fastBitmap3.MyBillsEntityDataFactory * i4)] >> 8) & 255;
                        FastBitmap fastBitmap4 = this.MyBillsEntityDataFactory.getAuthRequestContext;
                        double d4 = fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i3) + (fastBitmap4.MyBillsEntityDataFactory * i4)] & 255;
                        Double.isNaN(d2);
                        double PlaceComponentResult2 = Approximation.PlaceComponentResult(d2 / log);
                        Double.isNaN(d3);
                        double PlaceComponentResult3 = Approximation.PlaceComponentResult(d3 / log);
                        Double.isNaN(d4);
                        double PlaceComponentResult4 = Approximation.PlaceComponentResult(d4 / log);
                        if (PlaceComponentResult2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            PlaceComponentResult2 = 0.0d;
                        }
                        if (PlaceComponentResult2 > 255.0d) {
                            PlaceComponentResult2 = 255.0d;
                        }
                        if (PlaceComponentResult3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            PlaceComponentResult3 = 0.0d;
                        }
                        if (PlaceComponentResult3 > 255.0d) {
                            PlaceComponentResult3 = 255.0d;
                        }
                        if (PlaceComponentResult4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            PlaceComponentResult4 = 0.0d;
                        }
                        if (PlaceComponentResult4 > 255.0d) {
                            PlaceComponentResult4 = 255.0d;
                        }
                        this.MyBillsEntityDataFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i3, i4, (int) PlaceComponentResult2);
                        this.MyBillsEntityDataFactory.getAuthRequestContext.getAuthRequestContext(i3, i4, (int) PlaceComponentResult3);
                        this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i3, i4, (int) PlaceComponentResult4);
                    }
                }
            }
        }
    }
}
