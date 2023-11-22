package Catalano.Imaging.Concurrent.Filters;

import Catalano.Core.FloatRange;
import Catalano.Core.IntRange;
import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import Catalano.Imaging.Tools.ColorConverter;

/* loaded from: classes6.dex */
public class HSLFiltering implements IApplyInPlace {
    private IntRange getAuthRequestContext = new IntRange(0, 359);
    private FloatRange moveToNextValue = new FloatRange(0.0f, 1.0f);
    private FloatRange scheduleImpl = new FloatRange(0.0f, 1.0f);
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private float BuiltInFictitiousFunctionClassFactory = 0.0f;
    private float PlaceComponentResult = 0.0f;
    private boolean MyBillsEntityDataFactory = true;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    private boolean getErrorConfigVersion = true;
    private boolean lookAheadTest = true;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ HSLFiltering MyBillsEntityDataFactory;
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            for (int i = this.getAuthRequestContext.MyBillsEntityDataFactory; i < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i++) {
                for (int i2 = 0; i2 < this.getAuthRequestContext.PlaceComponentResult; i2++) {
                    FastBitmap fastBitmap = this.getAuthRequestContext.getAuthRequestContext;
                    int i3 = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] >> 16) & 255;
                    FastBitmap fastBitmap2 = this.getAuthRequestContext.getAuthRequestContext;
                    int i4 = (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i) + (fastBitmap2.MyBillsEntityDataFactory * i2)] >> 8) & 255;
                    FastBitmap fastBitmap3 = this.getAuthRequestContext.getAuthRequestContext;
                    double[] PlaceComponentResult = ColorConverter.PlaceComponentResult(i3, i4, fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i) + (fastBitmap3.MyBillsEntityDataFactory * i2)] & 255);
                    if (PlaceComponentResult[1] < this.MyBillsEntityDataFactory.moveToNextValue.getMin() || PlaceComponentResult[1] > this.MyBillsEntityDataFactory.moveToNextValue.getMax() || PlaceComponentResult[2] < this.MyBillsEntityDataFactory.scheduleImpl.getMin() || PlaceComponentResult[2] > this.MyBillsEntityDataFactory.scheduleImpl.getMax() || ((this.MyBillsEntityDataFactory.getAuthRequestContext.getMin() >= this.MyBillsEntityDataFactory.getAuthRequestContext.getMax() || PlaceComponentResult[0] < this.MyBillsEntityDataFactory.getAuthRequestContext.getMin() || PlaceComponentResult[0] > this.MyBillsEntityDataFactory.getAuthRequestContext.getMax()) && (this.MyBillsEntityDataFactory.getAuthRequestContext.getMin() <= this.MyBillsEntityDataFactory.getAuthRequestContext.getMax() || (PlaceComponentResult[0] < this.MyBillsEntityDataFactory.getAuthRequestContext.getMin() && PlaceComponentResult[0] > this.MyBillsEntityDataFactory.getAuthRequestContext.getMax())))) {
                        if (this.MyBillsEntityDataFactory.MyBillsEntityDataFactory) {
                            if (this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                                PlaceComponentResult[0] = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                            }
                            if (this.MyBillsEntityDataFactory.getErrorConfigVersion) {
                                PlaceComponentResult[1] = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                            }
                            if (this.MyBillsEntityDataFactory.lookAheadTest) {
                                PlaceComponentResult[2] = this.MyBillsEntityDataFactory.PlaceComponentResult;
                            }
                            z = true;
                        }
                        z = false;
                    } else {
                        if (!this.MyBillsEntityDataFactory.MyBillsEntityDataFactory) {
                            if (this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                                PlaceComponentResult[0] = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                            }
                            if (this.MyBillsEntityDataFactory.getErrorConfigVersion) {
                                PlaceComponentResult[1] = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                            }
                            if (this.MyBillsEntityDataFactory.lookAheadTest) {
                                PlaceComponentResult[2] = this.MyBillsEntityDataFactory.PlaceComponentResult;
                            }
                            z = true;
                        }
                        z = false;
                    }
                    if (z) {
                        this.getAuthRequestContext.getAuthRequestContext.getAuthRequestContext(i, i2, ColorConverter.MyBillsEntityDataFactory(PlaceComponentResult[0], PlaceComponentResult[1], PlaceComponentResult[2]));
                    }
                }
            }
        }
    }
}
