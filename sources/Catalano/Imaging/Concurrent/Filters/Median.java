package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class Median implements IApplyInPlace {
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private FastBitmap getAuthRequestContext;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        private Share MyBillsEntityDataFactory;
        final /* synthetic */ Median PlaceComponentResult;

        @Override // java.lang.Runnable
        public void run() {
            int i = (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 * 2) + 1;
            int i2 = i * i;
            int i3 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            int i4 = 0;
            if (this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                Share share = this.MyBillsEntityDataFactory;
                share.BuiltInFictitiousFunctionClassFactory = share.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getHeight();
                i3 = 0;
            }
            if (this.MyBillsEntityDataFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                int[] iArr = new int[i2];
                for (int i5 = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory; i5 < this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory; i5++) {
                    for (int i6 = 0; i6 < this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i6++) {
                        int i7 = 0;
                        for (int i8 = 0; i8 < i; i8++) {
                            int i9 = (i8 - this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) + i5;
                            for (int i10 = 0; i10 < i; i10++) {
                                int i11 = (i10 - this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) + i6;
                                if (i9 >= 0 && i9 < this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory + i3 && i11 >= 0 && i11 < this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    FastBitmap fastBitmap = this.PlaceComponentResult.getAuthRequestContext;
                                    iArr[i7] = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i9) + (i11 * fastBitmap.MyBillsEntityDataFactory)] & 255;
                                    i7++;
                                }
                            }
                        }
                        Arrays.sort(iArr, 0, i7);
                        this.MyBillsEntityDataFactory.getAuthRequestContext.MyBillsEntityDataFactory(i5, i6, iArr[i7 / 2]);
                    }
                }
                return;
            }
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            int[] iArr4 = new int[i2];
            for (int i12 = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory; i12 < this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory; i12++) {
                for (int i13 = 0; i13 < this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i13++) {
                    int i14 = 0;
                    int i15 = 0;
                    while (i14 < i) {
                        int i16 = (i14 - this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) + i12;
                        for (int i17 = 0; i17 < i; i17++) {
                            int i18 = (i17 - this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) + i13;
                            if (i16 >= 0 && i16 < this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory + i3 && i18 >= 0 && i18 < this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                FastBitmap fastBitmap2 = this.PlaceComponentResult.getAuthRequestContext;
                                iArr2[i15] = (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i16) + (fastBitmap2.MyBillsEntityDataFactory * i18)] >> 16) & 255;
                                FastBitmap fastBitmap3 = this.PlaceComponentResult.getAuthRequestContext;
                                iArr3[i15] = (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i16) + (fastBitmap3.MyBillsEntityDataFactory * i18)] >> 8) & 255;
                                FastBitmap fastBitmap4 = this.PlaceComponentResult.getAuthRequestContext;
                                iArr4[i15] = fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i16) + (i18 * fastBitmap4.MyBillsEntityDataFactory)] & 255;
                                i15++;
                            }
                        }
                        i14++;
                        i4 = 0;
                    }
                    Arrays.sort(iArr2, i4, i15);
                    Arrays.sort(iArr3, i4, i15);
                    Arrays.sort(iArr4, i4, i15);
                    int i19 = i15 / 2;
                    this.MyBillsEntityDataFactory.getAuthRequestContext.MyBillsEntityDataFactory(i12, i13, iArr2[i19], iArr3[i19], iArr4[i19]);
                }
            }
        }
    }
}
