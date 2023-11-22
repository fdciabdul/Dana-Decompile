package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class Erosion implements IApplyInPlace {
    private int[][] BuiltInFictitiousFunctionClassFactory;
    FastBitmap PlaceComponentResult;
    private int getAuthRequestContext = 1;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ Erosion PlaceComponentResult;
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            int i = 255;
            if (this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                if (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                    Erosion erosion = this.PlaceComponentResult;
                    Erosion.MyBillsEntityDataFactory(erosion, erosion.getAuthRequestContext);
                }
                int i2 = this.PlaceComponentResult.getAuthRequestContext;
                if (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                    i2 = 0;
                }
                for (int i3 = this.getAuthRequestContext.MyBillsEntityDataFactory; i3 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i3++) {
                    for (int i4 = 0; i4 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i4++) {
                        int i5 = 255;
                        int i6 = 0;
                        for (int i7 = i3 - this.PlaceComponentResult.getAuthRequestContext; i7 < this.PlaceComponentResult.getAuthRequestContext + i3 + 1; i7++) {
                            int i8 = 0;
                            for (int i9 = i4 - this.PlaceComponentResult.getAuthRequestContext; i9 < this.PlaceComponentResult.getAuthRequestContext + i4 + 1; i9++) {
                                if (i7 >= 0 && i7 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i2 && i9 >= 0 && i9 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    FastBitmap fastBitmap = this.PlaceComponentResult.PlaceComponentResult;
                                    int i10 = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i7) + (fastBitmap.MyBillsEntityDataFactory * i9)] & 255) - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory[i6][i8];
                                    if (i10 < i5) {
                                        i5 = i10;
                                    }
                                }
                                i8++;
                            }
                            i6++;
                        }
                        if (i5 < 0) {
                            i5 = 0;
                        }
                        this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i3, i4, i5);
                    }
                }
            }
            if (this.getAuthRequestContext.getAuthRequestContext.getAuthRequestContext()) {
                if (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                    Erosion erosion2 = this.PlaceComponentResult;
                    Erosion.MyBillsEntityDataFactory(erosion2, erosion2.getAuthRequestContext);
                }
                int i11 = this.PlaceComponentResult.getAuthRequestContext;
                if (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                    i11 = 0;
                }
                int i12 = this.getAuthRequestContext.MyBillsEntityDataFactory;
                while (i12 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                    int i13 = 0;
                    while (i13 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                        int i14 = i12 - this.PlaceComponentResult.getAuthRequestContext;
                        int i15 = 255;
                        int i16 = 255;
                        int i17 = 255;
                        int i18 = 0;
                        while (i14 < this.PlaceComponentResult.getAuthRequestContext + i12 + 1) {
                            int i19 = i13 - this.PlaceComponentResult.getAuthRequestContext;
                            int i20 = 0;
                            while (i19 < this.PlaceComponentResult.getAuthRequestContext + i13 + 1) {
                                if (i14 >= 0 && i14 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i11 && i19 >= 0 && i19 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    FastBitmap fastBitmap2 = this.PlaceComponentResult.PlaceComponentResult;
                                    int i21 = ((fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i14) + (fastBitmap2.MyBillsEntityDataFactory * i19)] >> 16) & i) - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory[i18][i20];
                                    FastBitmap fastBitmap3 = this.PlaceComponentResult.PlaceComponentResult;
                                    int i22 = ((fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i14) + (fastBitmap3.MyBillsEntityDataFactory * i19)] >> 8) & i) - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory[i18][i20];
                                    FastBitmap fastBitmap4 = this.PlaceComponentResult.PlaceComponentResult;
                                    int i23 = (fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i14) + (fastBitmap4.MyBillsEntityDataFactory * i19)] & 255) - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory[i18][i20];
                                    if (i21 < i15) {
                                        i15 = i21;
                                    }
                                    if (i22 < i17) {
                                        i17 = i22;
                                    }
                                    if (i23 < i16) {
                                        i16 = i23;
                                    }
                                }
                                i20++;
                                i19++;
                                i = 255;
                            }
                            i18++;
                            i14++;
                            i = 255;
                        }
                        this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i12, i13, i15 < 0 ? 0 : i15, i17 < 0 ? 0 : i17, i16 < 0 ? 0 : i16);
                        i13++;
                        i = 255;
                    }
                    i12++;
                    i = 255;
                }
            }
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(Erosion erosion, int i) {
        int i2 = (i * 2) + 1;
        erosion.BuiltInFictitiousFunctionClassFactory = (int[][]) Array.newInstance(Integer.TYPE, i2, i2);
        for (int i3 = 0; i3 < erosion.BuiltInFictitiousFunctionClassFactory.length; i3++) {
            int i4 = 0;
            while (true) {
                int[][] iArr = erosion.BuiltInFictitiousFunctionClassFactory;
                if (i4 < iArr[0].length) {
                    iArr[i3][i4] = 1;
                    i4++;
                }
            }
        }
    }
}
