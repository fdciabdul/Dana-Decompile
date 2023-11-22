package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Log implements IApplyInPlace {

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
                        if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d = Math.log(d) * log;
                        }
                        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d = 0.0d;
                        }
                        if (d > 255.0d) {
                            d = 255.0d;
                        }
                        this.MyBillsEntityDataFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, (int) d);
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
                        if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d2 = Math.log(d2) * log;
                        }
                        if (d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d3 = Math.log(d3) * log;
                        }
                        if (d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d4 = Math.log(d4) * log;
                        }
                        if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d2 = 0.0d;
                        }
                        if (d2 > 255.0d) {
                            d2 = 255.0d;
                        }
                        if (d3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d3 = 0.0d;
                        }
                        if (d3 > 255.0d) {
                            d3 = 255.0d;
                        }
                        if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d4 = 0.0d;
                        }
                        if (d4 > 255.0d) {
                            d4 = 255.0d;
                        }
                        this.MyBillsEntityDataFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i3, i4, (int) d2);
                        this.MyBillsEntityDataFactory.getAuthRequestContext.getAuthRequestContext(i3, i4, (int) d3);
                        this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i3, i4, (int) d4);
                    }
                }
            }
        }
    }
}
