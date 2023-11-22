package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Filters.Mean;
import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class NiblackThreshold implements IApplyInPlace {
    private FastBitmap PlaceComponentResult;
    private FastBitmap scheduleImpl;
    private Mean.Arithmetic getAuthRequestContext = Mean.Arithmetic.Mean;
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 15;
    private double MyBillsEntityDataFactory = 0.2d;
    private double BuiltInFictitiousFunctionClassFactory = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ NiblackThreshold BuiltInFictitiousFunctionClassFactory;
        private Share MyBillsEntityDataFactory;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory; i < this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory; i++) {
                for (int i2 = 0; i2 < this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i2++) {
                    FastBitmap fastBitmap = this.MyBillsEntityDataFactory.getAuthRequestContext;
                    int i3 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)];
                    int i4 = 255;
                    FastBitmap fastBitmap2 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                    float f = fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i) + (fastBitmap2.MyBillsEntityDataFactory * i2)] & 255;
                    FastBitmap fastBitmap3 = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
                    double d = f;
                    double sqrt = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory * Math.sqrt(fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i) + (fastBitmap3.MyBillsEntityDataFactory * i2)] & 255);
                    Double.isNaN(d);
                    if (r7 <= (d + sqrt) - this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory) {
                        i4 = 0;
                    }
                    this.MyBillsEntityDataFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i4);
                }
            }
        }
    }
}
