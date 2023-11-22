package Catalano.Imaging.Concurrent.Filters;

import Catalano.Core.FloatRange;
import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import Catalano.Imaging.Tools.ColorConverter;

/* loaded from: classes6.dex */
public class YCbCrFiltering implements IApplyInPlace {
    private FloatRange NetworkUserEntityData$$ExternalSyntheticLambda0 = new FloatRange(0.0f, 1.0f);
    private FloatRange MyBillsEntityDataFactory = new FloatRange(-0.5f, 0.5f);
    private FloatRange KClassImpl$Data$declaredNonStaticMembers$2 = new FloatRange(-0.5f, 0.5f);
    private float getErrorConfigVersion = 0.0f;
    private float PlaceComponentResult = 0.0f;
    private float BuiltInFictitiousFunctionClassFactory = 0.0f;
    private boolean getAuthRequestContext = true;
    private boolean lookAheadTest = true;
    private boolean scheduleImpl = true;
    private boolean moveToNextValue = true;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ YCbCrFiltering KClassImpl$Data$declaredNonStaticMembers$2;
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
                    double[] MyBillsEntityDataFactory = ColorConverter.MyBillsEntityDataFactory(i3, i4, fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i) + (fastBitmap3.MyBillsEntityDataFactory * i2)] & 255, ColorConverter.YCbCrColorSpace.ITU_BT_601);
                    if (MyBillsEntityDataFactory[0] < this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getMin() || MyBillsEntityDataFactory[0] > this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getMax() || MyBillsEntityDataFactory[1] < this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.getMin() || MyBillsEntityDataFactory[1] > this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.getMax() || MyBillsEntityDataFactory[2] < this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.getMin() || MyBillsEntityDataFactory[2] > this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.getMax()) {
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) {
                            if (this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest) {
                                MyBillsEntityDataFactory[0] = this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
                            }
                            if (this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) {
                                MyBillsEntityDataFactory[1] = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                            }
                            if (this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue) {
                                MyBillsEntityDataFactory[2] = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                            }
                            z = true;
                        }
                        z = false;
                    } else {
                        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) {
                            if (this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest) {
                                MyBillsEntityDataFactory[0] = this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
                            }
                            if (this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) {
                                MyBillsEntityDataFactory[1] = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                            }
                            if (this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue) {
                                MyBillsEntityDataFactory[2] = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                            }
                            z = true;
                        }
                        z = false;
                    }
                    if (z) {
                        this.getAuthRequestContext.getAuthRequestContext.getAuthRequestContext(i, i2, ColorConverter.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory[0], MyBillsEntityDataFactory[1], MyBillsEntityDataFactory[2], ColorConverter.YCbCrColorSpace.ITU_BT_601));
                    }
                }
            }
        }
    }
}
