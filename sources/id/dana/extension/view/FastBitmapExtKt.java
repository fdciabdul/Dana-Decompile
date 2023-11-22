package id.dana.extension.view;

import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.Filters.BrightnessCorrection;
import Catalano.Imaging.Filters.Grayscale;
import Catalano.Imaging.Filters.HistogramEqualization;
import Catalano.Imaging.Filters.LevelsLinear;
import Catalano.Imaging.Filters.Mean;
import Catalano.Imaging.Tools.ImageHistogram;
import Catalano.Imaging.Tools.ImageStatistics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0002\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0002"}, d2 = {"LCatalano/Imaging/FastBitmap;", "MyBillsEntityDataFactory", "(LCatalano/Imaging/FastBitmap;)LCatalano/Imaging/FastBitmap;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FastBitmapExtKt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final FastBitmap KClassImpl$Data$declaredNonStaticMembers$2(FastBitmap fastBitmap) {
        Intrinsics.checkNotNullParameter(fastBitmap, "");
        Grayscale grayscale = new Grayscale(Grayscale.Algorithm.Lightness);
        int i = 0;
        if (!grayscale.MyBillsEntityDataFactory) {
            fastBitmap.getAuthRequestContext = true;
            int[] iArr = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2;
            while (i < iArr.length) {
                int i2 = iArr[i];
                double d = (i2 >> 16) & 255;
                double d2 = (i2 >> 8) & 255;
                double d3 = i2 & 255;
                double d4 = grayscale.getAuthRequestContext;
                double d5 = grayscale.KClassImpl$Data$declaredNonStaticMembers$2;
                int i3 = i;
                double d6 = grayscale.BuiltInFictitiousFunctionClassFactory;
                Double.isNaN(d);
                Double.isNaN(d2);
                Double.isNaN(d3);
                int i4 = (int) ((d * d4) + (d2 * d5) + (d3 * d6));
                iArr[i3] = i4 | (i4 << 16) | (-16777216) | (i4 << 8);
                i = i3 + 1;
            }
        } else {
            fastBitmap.getAuthRequestContext = true;
            Grayscale.Algorithm algorithm = grayscale.PlaceComponentResult;
            int[] iArr2 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2;
            switch (Grayscale.AnonymousClass1.PlaceComponentResult[algorithm.ordinal()]) {
                case 1:
                    while (i < iArr2.length) {
                        int i5 = iArr2[i];
                        double d7 = (i5 >> 16) & 255;
                        double d8 = (i5 >> 8) & 255;
                        double d9 = i5 & 255;
                        int max = (int) ((Math.max(Math.max(d7, d8), d9) + Math.min(Math.min(d7, d8), d9)) / 2.0d);
                        iArr2[i] = max | (max << 16) | (-16777216) | (max << 8);
                        i++;
                    }
                    break;
                case 2:
                    while (i < iArr2.length) {
                        int i6 = iArr2[i];
                        double d10 = (i6 >> 16) & 255;
                        double d11 = (i6 >> 8) & 255;
                        double d12 = i6 & 255;
                        Double.isNaN(d10);
                        Double.isNaN(d11);
                        Double.isNaN(d12);
                        int i7 = (int) (((d10 + d11) + d12) / 3.0d);
                        iArr2[i] = i7 | (i7 << 16) | (-16777216) | (i7 << 8);
                        i++;
                    }
                    break;
                case 3:
                    while (i < iArr2.length) {
                        int i8 = iArr2[i];
                        double d13 = (i8 >> 16) & 255;
                        double d14 = (i8 >> 8) & 255;
                        double d15 = i8 & 255;
                        Double.isNaN(d13);
                        Double.isNaN(d14);
                        Double.isNaN(d15);
                        int pow = (int) Math.pow(d13 * d14 * d15, 0.33d);
                        iArr2[i] = pow | (pow << 16) | (-16777216) | (pow << 8);
                        i++;
                    }
                    break;
                case 4:
                    while (i < iArr2.length) {
                        int i9 = iArr2[i];
                        double d16 = (i9 >> 16) & 255;
                        double d17 = (i9 >> 8) & 255;
                        double d18 = i9 & 255;
                        Double.isNaN(d16);
                        Double.isNaN(d17);
                        Double.isNaN(d18);
                        int i10 = (int) ((d16 * 0.2125d) + (d17 * 0.7154d) + (d18 * 0.0721d));
                        iArr2[i] = i10 | (i10 << 16) | (-16777216) | (i10 << 8);
                        i++;
                    }
                    break;
                case 5:
                    while (i < iArr2.length) {
                        int min = (int) Math.min((int) Math.min((r1 >> 16) & 255, (r1 >> 8) & 255), iArr2[i] & 255);
                        iArr2[i] = min | (min << 16) | (-16777216) | (min << 8);
                        i++;
                    }
                    break;
                case 6:
                    while (i < iArr2.length) {
                        int max2 = (int) Math.max((int) Math.max((r1 >> 16) & 255, (r1 >> 8) & 255), iArr2[i] & 255);
                        iArr2[i] = max2 | (max2 << 16) | (-16777216) | (max2 << 8);
                        i++;
                    }
                    break;
            }
        }
        return fastBitmap;
    }

    public static final FastBitmap getAuthRequestContext(FastBitmap fastBitmap) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(fastBitmap, "");
        new HistogramEqualization();
        ImageStatistics imageStatistics = new ImageStatistics(fastBitmap);
        ArrayList arrayList2 = new ArrayList();
        double width = fastBitmap.BuiltInFictitiousFunctionClassFactory.getWidth() * fastBitmap.BuiltInFictitiousFunctionClassFactory.getHeight();
        Double.isNaN(width);
        float f = (float) (255.0d / width);
        long j = 0;
        int i = 256;
        int i2 = 0;
        if (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2()) {
            ImageHistogram imageHistogram = imageStatistics.getAuthRequestContext;
            if (imageHistogram != null) {
                arrayList2.add(imageHistogram.KClassImpl$Data$declaredNonStaticMembers$2);
                arrayList = new ArrayList();
                int[] iArr = new int[256];
                for (int i3 = 0; i3 < 256; i3++) {
                    iArr[i3] = 0;
                }
                for (int i4 = 0; i4 < 256; i4++) {
                    j += ((int[]) arrayList2.get(0))[i4];
                    int i5 = (int) (((float) j) * f);
                    if (i5 > 255) {
                        iArr[i4] = 255;
                    } else {
                        iArr[i4] = i5;
                    }
                }
                arrayList.add(iArr);
            } else {
                throw new IllegalArgumentException("Histogram gray is null");
            }
        } else {
            ImageHistogram imageHistogram2 = imageStatistics.KClassImpl$Data$declaredNonStaticMembers$2;
            if (imageHistogram2 != null) {
                arrayList2.add(imageHistogram2.KClassImpl$Data$declaredNonStaticMembers$2);
                ImageHistogram imageHistogram3 = imageStatistics.BuiltInFictitiousFunctionClassFactory;
                if (imageHistogram3 != null) {
                    arrayList2.add(imageHistogram3.KClassImpl$Data$declaredNonStaticMembers$2);
                    ImageHistogram imageHistogram4 = imageStatistics.MyBillsEntityDataFactory;
                    if (imageHistogram4 != null) {
                        arrayList2.add(imageHistogram4.KClassImpl$Data$declaredNonStaticMembers$2);
                        arrayList = new ArrayList();
                        int[] iArr2 = new int[256];
                        int[] iArr3 = new int[256];
                        int[] iArr4 = new int[256];
                        for (int i6 = 0; i6 < 256; i6++) {
                            iArr2[i6] = 0;
                            iArr3[i6] = 0;
                            iArr4[i6] = 0;
                        }
                        long j2 = 0;
                        long j3 = 0;
                        int i7 = 0;
                        while (i7 < i) {
                            int[] iArr5 = iArr3;
                            j += ((int[]) arrayList2.get(i2))[i7];
                            int i8 = (int) (((float) j) * f);
                            if (i8 > 255) {
                                iArr2[i7] = 255;
                            } else {
                                iArr2[i7] = i8;
                            }
                            j2 += ((int[]) arrayList2.get(1))[i7];
                            int i9 = (int) (((float) j2) * f);
                            if (i9 > 255) {
                                iArr5[i7] = 255;
                            } else {
                                iArr5[i7] = i9;
                            }
                            long j4 = j3 + ((int[]) arrayList2.get(2))[i7];
                            int i10 = (int) (((float) j4) * f);
                            if (i10 > 255) {
                                iArr4[i7] = 255;
                            } else {
                                iArr4[i7] = i10;
                            }
                            i7++;
                            j3 = j4;
                            iArr3 = iArr5;
                            i = 256;
                            i2 = 0;
                        }
                        arrayList.add(iArr2);
                        arrayList.add(iArr3);
                        arrayList.add(iArr4);
                    } else {
                        throw new IllegalArgumentException("Histogram blue is null");
                    }
                } else {
                    throw new IllegalArgumentException("Histogram green is null");
                }
            } else {
                throw new IllegalArgumentException("Histogram red is null");
            }
        }
        int length = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2.length;
        if (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2()) {
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = ((int[]) arrayList.get(0))[fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i11] & 255];
                fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i11] = i12 | (i12 << 16) | (-16777216) | (i12 << 8);
            }
        } else if (fastBitmap.getAuthRequestContext()) {
            for (int i13 = 0; i13 < length; i13++) {
                int i14 = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i13] >> 16) & 255;
                int i15 = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i13] >> 8) & 255;
                int i16 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i13] & 255;
                fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i13] = (((int[]) arrayList.get(0))[i14] << 16) | (-16777216) | (((int[]) arrayList.get(1))[i15] << 8) | ((int[]) arrayList.get(2))[i16];
            }
        }
        return fastBitmap;
    }

    public static final FastBitmap MyBillsEntityDataFactory(FastBitmap fastBitmap) {
        Intrinsics.checkNotNullParameter(fastBitmap, "");
        LevelsLinear levelsLinear = new BrightnessCorrection().KClassImpl$Data$declaredNonStaticMembers$2;
        int length = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2.length;
        int i = 0;
        if (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2()) {
            LevelsLinear.getAuthRequestContext(levelsLinear.BuiltInFictitiousFunctionClassFactory, levelsLinear.NetworkUserEntityData$$ExternalSyntheticLambda0, levelsLinear.lookAheadTest);
            while (i < length) {
                int i2 = levelsLinear.lookAheadTest[fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i] & 255];
                fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i] = i2 | (i2 << 16) | (-16777216) | (i2 << 8);
                i++;
            }
        } else {
            LevelsLinear.getAuthRequestContext(levelsLinear.KClassImpl$Data$declaredNonStaticMembers$2, levelsLinear.DatabaseTableConfigUtil, levelsLinear.getErrorConfigVersion);
            LevelsLinear.getAuthRequestContext(levelsLinear.MyBillsEntityDataFactory, levelsLinear.NetworkUserEntityData$$ExternalSyntheticLambda1, levelsLinear.moveToNextValue);
            LevelsLinear.getAuthRequestContext(levelsLinear.getAuthRequestContext, levelsLinear.scheduleImpl, levelsLinear.PlaceComponentResult);
            while (i < length) {
                int i3 = levelsLinear.getErrorConfigVersion[(fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i] >> 16) & 255];
                int i4 = levelsLinear.moveToNextValue[(fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i] >> 8) & 255];
                fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i] = (i3 << 16) | (-16777216) | (i4 << 8) | levelsLinear.PlaceComponentResult[fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[i] & 255];
                i++;
            }
        }
        return fastBitmap;
    }

    public static final FastBitmap PlaceComponentResult(FastBitmap fastBitmap) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Mean mean;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        FastBitmap fastBitmap2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Mean mean2;
        Mean mean3;
        int i17;
        Intrinsics.checkNotNullParameter(fastBitmap, "");
        Mean mean4 = new Mean();
        int width = fastBitmap.BuiltInFictitiousFunctionClassFactory.getWidth();
        int height = fastBitmap.BuiltInFictitiousFunctionClassFactory.getHeight();
        int i18 = (mean4.BuiltInFictitiousFunctionClassFactory * 2) + 1;
        FastBitmap fastBitmap3 = new FastBitmap(fastBitmap);
        int i19 = Mean.AnonymousClass1.MyBillsEntityDataFactory[mean4.MyBillsEntityDataFactory.ordinal()];
        if (i19 == 1) {
            Mean mean5 = mean4;
            int i20 = width;
            int i21 = i18;
            if (!fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2()) {
                int i22 = i20;
                int i23 = height;
                int i24 = i21;
                if (fastBitmap.getAuthRequestContext()) {
                    for (int i25 = 0; i25 < i23; i25++) {
                        int i26 = 0;
                        while (i26 < i22) {
                            int i27 = 0;
                            int i28 = 0;
                            int i29 = 0;
                            int i30 = 0;
                            for (int i31 = 0; i31 < i24; i31++) {
                                int i32 = (i31 - mean5.BuiltInFictitiousFunctionClassFactory) + i25;
                                int i33 = 0;
                                while (i33 < i24) {
                                    int i34 = (i33 - mean5.BuiltInFictitiousFunctionClassFactory) + i26;
                                    if (i32 < 0 || i32 >= i23 || i34 < 0 || i34 >= i22) {
                                        i = i23;
                                        i2 = i22;
                                        i3 = i24;
                                    } else {
                                        i = i23;
                                        i2 = i22;
                                        i3 = i24;
                                        i27 += (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i32) + (fastBitmap3.MyBillsEntityDataFactory * i34)] >> 16) & 255;
                                        i29 += (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i32) + (fastBitmap3.MyBillsEntityDataFactory * i34)] >> 8) & 255;
                                        i30 += fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i32) + (i34 * fastBitmap3.MyBillsEntityDataFactory)] & 255;
                                        i28++;
                                    }
                                    i33++;
                                    i24 = i3;
                                    i22 = i2;
                                    i23 = i;
                                }
                            }
                            fastBitmap.MyBillsEntityDataFactory(i25, i26, i27 / i28, i29 / i28, i30 / i28);
                            i26++;
                            i22 = i22;
                            i23 = i23;
                        }
                    }
                    return fastBitmap;
                }
                return fastBitmap;
            }
            int i35 = 0;
            while (i35 < height) {
                int i36 = i20;
                int i37 = 0;
                while (i37 < i36) {
                    int i38 = i21;
                    int i39 = 0;
                    int i40 = 0;
                    int i41 = 0;
                    while (i39 < i38) {
                        Mean mean6 = mean5;
                        int i42 = (i39 - mean6.BuiltInFictitiousFunctionClassFactory) + i35;
                        for (int i43 = 0; i43 < i38; i43++) {
                            int i44 = (i43 - mean6.BuiltInFictitiousFunctionClassFactory) + i37;
                            if (i42 >= 0 && i42 < height && i44 >= 0 && i44 < i36) {
                                i40 += fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i42) + (i44 * fastBitmap3.MyBillsEntityDataFactory)] & 255;
                                i41++;
                            }
                        }
                        i39++;
                        mean5 = mean6;
                    }
                    fastBitmap.MyBillsEntityDataFactory(i35, i37, i40 / i41);
                    i37++;
                    i21 = i38;
                }
                i35++;
                i20 = i36;
            }
        } else if (i19 == 2) {
            int i45 = width;
            int i46 = i18;
            Mean mean7 = mean4;
            if (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2()) {
                int i47 = 0;
                while (i47 < height) {
                    int i48 = i45;
                    int i49 = 0;
                    while (i49 < i48) {
                        double d = 0.0d;
                        int i50 = i46;
                        int i51 = 0;
                        for (int i52 = 0; i52 < i50; i52++) {
                            int i53 = (i52 - mean7.BuiltInFictitiousFunctionClassFactory) + i47;
                            int i54 = 0;
                            while (i54 < i50) {
                                int i55 = (i54 - mean7.BuiltInFictitiousFunctionClassFactory) + i49;
                                if (i53 < 0 || i53 >= height || i55 < 0 || i55 >= i48) {
                                    i6 = i53;
                                } else {
                                    i6 = i53;
                                    double d2 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i53) + (i55 * fastBitmap3.MyBillsEntityDataFactory)] & 255;
                                    Double.isNaN(d2);
                                    d += 1.0d / d2;
                                    i51++;
                                }
                                i54++;
                                i53 = i6;
                            }
                        }
                        double d3 = i51;
                        Double.isNaN(d3);
                        fastBitmap.MyBillsEntityDataFactory(i47, i49, (int) (d3 / d));
                        i49++;
                        i46 = i50;
                    }
                    i47++;
                    i45 = i48;
                }
            } else {
                int i56 = i46;
                int i57 = i45;
                int i58 = height;
                if (fastBitmap.getAuthRequestContext()) {
                    int i59 = 0;
                    while (i59 < i58) {
                        int i60 = 0;
                        while (i60 < i57) {
                            double d4 = 0.0d;
                            double d5 = 0.0d;
                            double d6 = 0.0d;
                            int i61 = 0;
                            int i62 = 0;
                            while (i61 < i56) {
                                int i63 = (i61 - mean7.BuiltInFictitiousFunctionClassFactory) + i59;
                                int i64 = i59;
                                int i65 = 0;
                                while (i65 < i56) {
                                    int i66 = i56;
                                    int i67 = (i65 - mean7.BuiltInFictitiousFunctionClassFactory) + i60;
                                    if (i63 < 0 || i63 >= i58 || i67 < 0 || i67 >= i57) {
                                        i4 = i58;
                                        i5 = i57;
                                        mean = mean7;
                                    } else {
                                        mean = mean7;
                                        i5 = i57;
                                        i4 = i58;
                                        double d7 = (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i63) + (fastBitmap3.MyBillsEntityDataFactory * i67)] >> 16) & 255;
                                        Double.isNaN(d7);
                                        d4 += 1.0d / d7;
                                        double d8 = (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i63) + (fastBitmap3.MyBillsEntityDataFactory * i67)] >> 8) & 255;
                                        Double.isNaN(d8);
                                        d5 += 1.0d / d8;
                                        double d9 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i63) + (i67 * fastBitmap3.MyBillsEntityDataFactory)] & 255;
                                        Double.isNaN(d9);
                                        d6 += 1.0d / d9;
                                        i62++;
                                    }
                                    i65++;
                                    mean7 = mean;
                                    i57 = i5;
                                    i58 = i4;
                                    i56 = i66;
                                }
                                i61++;
                                i59 = i64;
                                mean7 = mean7;
                                i56 = i56;
                            }
                            double d10 = i62;
                            Double.isNaN(d10);
                            Double.isNaN(d10);
                            Double.isNaN(d10);
                            fastBitmap.MyBillsEntityDataFactory(i59, i60, (int) (d10 / d4), (int) (d10 / d5), (int) (d10 / d6));
                            i60++;
                            mean7 = mean7;
                            i56 = i56;
                        }
                        i59++;
                        mean7 = mean7;
                        i56 = i56;
                    }
                }
            }
        } else if (i19 != 3) {
            if (i19 == 4) {
                if (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    for (int i68 = 0; i68 < height; i68++) {
                        for (int i69 = 0; i69 < width; i69++) {
                            int i70 = 0;
                            double d11 = 1.0d;
                            for (int i71 = 0; i71 < i18; i71++) {
                                int i72 = (i71 - mean4.BuiltInFictitiousFunctionClassFactory) + i68;
                                int i73 = 0;
                                while (i73 < i18) {
                                    int i74 = (i73 - mean4.BuiltInFictitiousFunctionClassFactory) + i69;
                                    if (i72 < 0 || i72 >= height || i74 < 0 || i74 >= width) {
                                        mean3 = mean4;
                                        i17 = i72;
                                    } else {
                                        mean3 = mean4;
                                        i17 = i72;
                                        double d12 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i72) + (i74 * fastBitmap3.MyBillsEntityDataFactory)] & 255;
                                        Double.isNaN(d12);
                                        d11 *= d12;
                                        i70++;
                                    }
                                    i73++;
                                    i72 = i17;
                                    mean4 = mean3;
                                }
                            }
                            double d13 = i70;
                            Double.isNaN(d13);
                            fastBitmap.MyBillsEntityDataFactory(i68, i69, (int) Math.pow(d11, 1.0d / d13));
                        }
                    }
                } else {
                    Mean mean8 = mean4;
                    if (fastBitmap.getAuthRequestContext()) {
                        int i75 = 0;
                        while (i75 < height) {
                            int i76 = 0;
                            while (i76 < width) {
                                double d14 = 1.0d;
                                double d15 = 1.0d;
                                double d16 = 1.0d;
                                int i77 = 0;
                                int i78 = 0;
                                while (i77 < i18) {
                                    Mean mean9 = mean8;
                                    int i79 = (i77 - mean9.BuiltInFictitiousFunctionClassFactory) + i75;
                                    int i80 = i75;
                                    int i81 = 0;
                                    while (i81 < i18) {
                                        int i82 = i18;
                                        int i83 = (i81 - mean9.BuiltInFictitiousFunctionClassFactory) + i76;
                                        if (i79 < 0 || i79 >= height || i83 < 0 || i83 >= width) {
                                            i15 = width;
                                            i16 = height;
                                            mean2 = mean9;
                                        } else {
                                            mean2 = mean9;
                                            i15 = width;
                                            i16 = height;
                                            double d17 = (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i79) + (fastBitmap3.MyBillsEntityDataFactory * i83)] >> 16) & 255;
                                            Double.isNaN(d17);
                                            d14 *= d17;
                                            double d18 = (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i79) + (fastBitmap3.MyBillsEntityDataFactory * i83)] >> 8) & 255;
                                            Double.isNaN(d18);
                                            d15 *= d18;
                                            double d19 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i79) + (i83 * fastBitmap3.MyBillsEntityDataFactory)] & 255;
                                            Double.isNaN(d19);
                                            d16 *= d19;
                                            i78++;
                                        }
                                        i81++;
                                        i18 = i82;
                                        mean9 = mean2;
                                        width = i15;
                                        height = i16;
                                    }
                                    i77++;
                                    i75 = i80;
                                    mean8 = mean9;
                                }
                                int i84 = i75;
                                double d20 = i78;
                                Double.isNaN(d20);
                                double d21 = 1.0d / d20;
                                fastBitmap.MyBillsEntityDataFactory(i84, i76, (int) Math.pow(d14, d21), (int) Math.pow(d15, d21), (int) Math.pow(d16, d21));
                                i76++;
                                i75 = i84;
                                mean8 = mean8;
                                width = width;
                                height = height;
                            }
                            i75++;
                            mean8 = mean8;
                        }
                    }
                }
            }
            return fastBitmap;
        } else {
            Mean mean10 = mean4;
            int i85 = width;
            int i86 = i18;
            if (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2()) {
                int i87 = 0;
                while (i87 < height) {
                    int i88 = i85;
                    int i89 = 0;
                    while (i89 < i88) {
                        double d22 = 0.0d;
                        double d23 = 0.0d;
                        int i90 = i86;
                        int i91 = 0;
                        while (i91 < i90) {
                            Mean mean11 = mean10;
                            int i92 = (i91 - mean11.BuiltInFictitiousFunctionClassFactory) + i87;
                            int i93 = 0;
                            while (i93 < i90) {
                                int i94 = (i93 - mean11.BuiltInFictitiousFunctionClassFactory) + i89;
                                if (i92 < 0 || i92 >= height || i94 < 0 || i94 >= i88) {
                                    i11 = i87;
                                    i12 = i89;
                                    i13 = i88;
                                    i14 = i90;
                                } else {
                                    i14 = i90;
                                    i13 = i88;
                                    i11 = i87;
                                    i12 = i89;
                                    d22 += Math.pow(fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i92) + (fastBitmap3.MyBillsEntityDataFactory * i94)] & 255, mean11.getAuthRequestContext + 1);
                                    d23 += Math.pow(fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i92) + (i94 * fastBitmap3.MyBillsEntityDataFactory)] & 255, mean11.getAuthRequestContext);
                                }
                                i93++;
                                i87 = i11;
                                i90 = i14;
                                i89 = i12;
                                i88 = i13;
                            }
                            i91++;
                            mean10 = mean11;
                        }
                        int i95 = i87;
                        i86 = i90;
                        Mean mean12 = mean10;
                        int i96 = i89;
                        fastBitmap.MyBillsEntityDataFactory(i95, i96, (int) (d22 / d23));
                        int i97 = i96 + 1;
                        mean10 = mean12;
                        i88 = i88;
                        i89 = i97;
                        i87 = i95;
                    }
                    i85 = i88;
                    i87++;
                }
            } else {
                int i98 = height;
                if (fastBitmap.getAuthRequestContext()) {
                    int i99 = 0;
                    while (i99 < i98) {
                        int i100 = i85;
                        int i101 = 0;
                        while (i101 < i100) {
                            double d24 = 0.0d;
                            double d25 = 0.0d;
                            double d26 = 0.0d;
                            double d27 = 0.0d;
                            double d28 = 0.0d;
                            int i102 = i86;
                            int i103 = 0;
                            double d29 = 0.0d;
                            while (i103 < i102) {
                                int i104 = (i103 - mean10.BuiltInFictitiousFunctionClassFactory) + i99;
                                int i105 = 0;
                                while (i105 < i102) {
                                    int i106 = i102;
                                    int i107 = (i105 - mean10.BuiltInFictitiousFunctionClassFactory) + i101;
                                    if (i104 < 0 || i104 >= i98 || i107 < 0 || i107 >= i100) {
                                        i7 = i98;
                                        i8 = i105;
                                        i9 = i100;
                                        i10 = i101;
                                        fastBitmap2 = fastBitmap3;
                                    } else {
                                        i9 = i100;
                                        i7 = i98;
                                        i10 = i101;
                                        i8 = i105;
                                        double pow = d24 + Math.pow((fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i104) + (fastBitmap3.MyBillsEntityDataFactory * i107)] >> 16) & 255, mean10.getAuthRequestContext + 1);
                                        d26 += Math.pow((fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i104) + (fastBitmap3.MyBillsEntityDataFactory * i107)] >> 8) & 255, mean10.getAuthRequestContext + 1);
                                        d27 += Math.pow(fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i104) + (fastBitmap3.MyBillsEntityDataFactory * i107)] & 255, mean10.getAuthRequestContext + 1);
                                        fastBitmap2 = fastBitmap3;
                                        d25 += Math.pow((fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i104) + (fastBitmap2.MyBillsEntityDataFactory * i107)] >> 16) & 255, mean10.getAuthRequestContext);
                                        d29 += Math.pow((fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i104) + (fastBitmap2.MyBillsEntityDataFactory * i107)] >> 8) & 255, mean10.getAuthRequestContext);
                                        d28 += Math.pow(fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i104) + (i107 * fastBitmap2.MyBillsEntityDataFactory)] & 255, mean10.getAuthRequestContext);
                                        d24 = pow;
                                    }
                                    i105 = i8 + 1;
                                    fastBitmap3 = fastBitmap2;
                                    i102 = i106;
                                    i100 = i9;
                                    i98 = i7;
                                    i101 = i10;
                                }
                                i103++;
                                i98 = i98;
                            }
                            int i108 = i101;
                            fastBitmap.MyBillsEntityDataFactory(i99, i108, (int) (d24 / d25), (int) (d26 / d29), (int) (d27 / d28));
                            i101 = i108 + 1;
                            i86 = i102;
                            i100 = i100;
                            i98 = i98;
                        }
                        i99++;
                        i85 = i100;
                        i98 = i98;
                    }
                }
            }
        }
        return fastBitmap;
    }
}
