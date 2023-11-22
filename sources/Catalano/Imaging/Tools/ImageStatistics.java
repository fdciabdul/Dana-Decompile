package Catalano.Imaging.Tools;

import Catalano.Imaging.FastBitmap;

/* loaded from: classes6.dex */
public class ImageStatistics {
    public ImageHistogram BuiltInFictitiousFunctionClassFactory;
    public ImageHistogram KClassImpl$Data$declaredNonStaticMembers$2;
    public ImageHistogram MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    public ImageHistogram getAuthRequestContext;

    public ImageStatistics(FastBitmap fastBitmap) {
        this(fastBitmap, (byte) 0);
    }

    private ImageStatistics(FastBitmap fastBitmap, byte b) {
        int width = fastBitmap.BuiltInFictitiousFunctionClassFactory.getWidth();
        int height = fastBitmap.BuiltInFictitiousFunctionClassFactory.getHeight();
        this.PlaceComponentResult = 0;
        this.getAuthRequestContext = null;
        this.MyBillsEntityDataFactory = null;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        if (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int[] iArr = new int[256];
            for (int i = 0; i < height; i++) {
                for (int i2 = 0; i2 < width; i2++) {
                    int i3 = ((fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] & 255) * 256) / 256;
                    iArr[i3] = iArr[i3] + 1;
                    this.PlaceComponentResult++;
                }
            }
            this.getAuthRequestContext = new ImageHistogram(iArr);
        } else if (fastBitmap.getAuthRequestContext()) {
            int[] iArr2 = new int[256];
            int[] iArr3 = new int[256];
            int[] iArr4 = new int[256];
            for (int i4 = 0; i4 < height; i4++) {
                for (int i5 = 0; i5 < width; i5++) {
                    int i6 = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i4) + (fastBitmap.MyBillsEntityDataFactory * i5)] >> 16) & 255;
                    int i7 = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i4) + (fastBitmap.MyBillsEntityDataFactory * i5)] >> 8) & 255;
                    int i8 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i4) + (fastBitmap.MyBillsEntityDataFactory * i5)] & 255;
                    int i9 = (i6 * 256) / 256;
                    iArr2[i9] = iArr2[i9] + 1;
                    int i10 = (i7 * 256) / 256;
                    iArr3[i10] = iArr3[i10] + 1;
                    int i11 = (i8 * 256) / 256;
                    iArr4[i11] = iArr4[i11] + 1;
                    this.PlaceComponentResult++;
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ImageHistogram(iArr2);
            this.BuiltInFictitiousFunctionClassFactory = new ImageHistogram(iArr3);
            this.MyBillsEntityDataFactory = new ImageHistogram(iArr4);
        }
    }
}
