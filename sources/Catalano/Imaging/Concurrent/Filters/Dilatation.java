package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Dilatation implements IApplyInPlace {
    private int[][] BuiltInFictitiousFunctionClassFactory;
    private FastBitmap MyBillsEntityDataFactory;
    private int getAuthRequestContext = 1;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ Dilatation MyBillsEntityDataFactory;
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            int i = this.MyBillsEntityDataFactory.getAuthRequestContext;
            if (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                i = 0;
            }
            int i2 = 255;
            if (this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                for (int i3 = this.getAuthRequestContext.MyBillsEntityDataFactory; i3 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i3++) {
                    for (int i4 = 0; i4 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i4++) {
                        int i5 = 0;
                        int i6 = 0;
                        for (int i7 = i3 - this.MyBillsEntityDataFactory.getAuthRequestContext; i7 < this.MyBillsEntityDataFactory.getAuthRequestContext + i3 + 1; i7++) {
                            int i8 = 0;
                            for (int i9 = i4 - this.MyBillsEntityDataFactory.getAuthRequestContext; i9 < this.MyBillsEntityDataFactory.getAuthRequestContext + i4 + 1; i9++) {
                                if (i7 >= 0 && i7 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i && i9 >= 0 && i9 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    FastBitmap fastBitmap = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
                                    int i10 = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i7) + (fastBitmap.MyBillsEntityDataFactory * i9)] & 255) + this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory[i6][i8];
                                    if (i10 > i5) {
                                        i5 = i10;
                                    }
                                }
                                i8++;
                            }
                            i6++;
                        }
                        if (i5 > 255) {
                            i5 = 255;
                        }
                        this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i3, i4, i5);
                    }
                }
            }
            if (this.getAuthRequestContext.getAuthRequestContext.getAuthRequestContext()) {
                int i11 = this.getAuthRequestContext.MyBillsEntityDataFactory;
                while (i11 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                    int i12 = 0;
                    while (i12 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                        int i13 = i11 - this.MyBillsEntityDataFactory.getAuthRequestContext;
                        int i14 = 0;
                        int i15 = 0;
                        int i16 = 0;
                        int i17 = 0;
                        while (i13 < this.MyBillsEntityDataFactory.getAuthRequestContext + i11 + 1) {
                            int i18 = i12 - this.MyBillsEntityDataFactory.getAuthRequestContext;
                            int i19 = 0;
                            while (i18 < this.MyBillsEntityDataFactory.getAuthRequestContext + i12 + 1) {
                                if (i13 >= 0 && i13 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i && i18 >= 0 && i18 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    FastBitmap fastBitmap2 = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
                                    int i20 = ((fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i13) + (fastBitmap2.MyBillsEntityDataFactory * i18)] >> 16) & i2) + this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory[i17][i19];
                                    FastBitmap fastBitmap3 = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
                                    int i21 = ((fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i13) + (fastBitmap3.MyBillsEntityDataFactory * i18)] >> 8) & i2) + this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory[i17][i19];
                                    FastBitmap fastBitmap4 = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
                                    int i22 = (fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i13) + (fastBitmap4.MyBillsEntityDataFactory * i18)] & 255) + this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory[i17][i19];
                                    if (i20 > i14) {
                                        i14 = i20;
                                    }
                                    if (i21 > i16) {
                                        i16 = i21;
                                    }
                                    if (i22 > i15) {
                                        i15 = i22;
                                    }
                                }
                                i19++;
                                i18++;
                                i2 = 255;
                            }
                            i17++;
                            i13++;
                            i2 = 255;
                        }
                        this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i11, i12, i14 > 255 ? 255 : i14, i16 > 255 ? 255 : i16, i15 > 255 ? 255 : i15);
                        i12++;
                        i2 = 255;
                    }
                    i11++;
                    i2 = 255;
                }
            }
        }
    }
}
