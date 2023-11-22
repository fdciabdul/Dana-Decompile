package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class GradientColorParser implements ValueParser<GradientColor> {
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    public GradientColorParser(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final /* synthetic */ GradientColor KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        int i;
        int i2;
        int argb;
        float PlaceComponentResult;
        ArrayList arrayList = new ArrayList();
        char c = 0;
        boolean z = jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.getAuthRequestContext();
        }
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            arrayList.add(Float.valueOf((float) jsonReader.lookAheadTest()));
        }
        int i3 = 3;
        int i4 = 2;
        if (arrayList.size() == 4 && ((Float) arrayList.get(0)).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add((Float) arrayList.get(1));
            arrayList.add((Float) arrayList.get(2));
            arrayList.add((Float) arrayList.get(3));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
        }
        if (z) {
            jsonReader.MyBillsEntityDataFactory();
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList.size() / 4;
        }
        int i5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        float[] fArr = new float[i5];
        int[] iArr = new int[i5];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < this.KClassImpl$Data$declaredNonStaticMembers$2 * 4) {
            int i9 = i6 / 4;
            double floatValue = ((Float) arrayList.get(i6)).floatValue();
            int i10 = i6 % 4;
            if (i10 == 0) {
                if (i9 > 0) {
                    float f2 = (float) floatValue;
                    if (fArr[i9 - 1] >= f2) {
                        fArr[i9] = f2 + 0.01f;
                    }
                }
                fArr[i9] = (float) floatValue;
            } else if (i10 == 1) {
                Double.isNaN(floatValue);
                i7 = (int) (floatValue * 255.0d);
            } else if (i10 == 2) {
                Double.isNaN(floatValue);
                i8 = (int) (floatValue * 255.0d);
            } else if (i10 == i3) {
                Double.isNaN(floatValue);
                iArr[i9] = Color.argb(255, i7, i8, (int) (floatValue * 255.0d));
            }
            i6++;
            i3 = 3;
        }
        GradientColor gradientColor = new GradientColor(fArr, iArr);
        int i11 = this.KClassImpl$Data$declaredNonStaticMembers$2 * 4;
        if (arrayList.size() <= i11) {
            return gradientColor;
        }
        float[] fArr2 = gradientColor.getAuthRequestContext;
        int[] iArr2 = gradientColor.BuiltInFictitiousFunctionClassFactory;
        int size = (arrayList.size() - i11) / 2;
        float[] fArr3 = new float[size];
        float[] fArr4 = new float[size];
        int i12 = 0;
        while (i11 < arrayList.size()) {
            if (i11 % 2 == 0) {
                fArr3[i12] = ((Float) arrayList.get(i11)).floatValue();
            } else {
                fArr4[i12] = ((Float) arrayList.get(i11)).floatValue();
                i12++;
            }
            i11++;
        }
        float[] fArr5 = gradientColor.getAuthRequestContext;
        if (fArr5.length == 0) {
            fArr5 = fArr3;
        } else if (size != 0) {
            int length = fArr5.length + size;
            float[] fArr6 = new float[length];
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                float f3 = i14 < fArr5.length ? fArr5[i14] : Float.NaN;
                float f4 = i15 < size ? fArr3[i15] : Float.NaN;
                if (Float.isNaN(f4) || f3 < f4) {
                    fArr6[i16] = f3;
                    i14++;
                } else if (Float.isNaN(f3) || f4 < f3) {
                    fArr6[i16] = f4;
                    i15++;
                } else {
                    fArr6[i16] = f3;
                    i14++;
                    i15++;
                    i13++;
                }
            }
            fArr5 = i13 == 0 ? fArr6 : Arrays.copyOf(fArr6, length - i13);
        }
        int length2 = fArr5.length;
        int[] iArr3 = new int[length2];
        int i17 = 0;
        while (i17 < length2) {
            float f5 = fArr5[i17];
            int binarySearch = Arrays.binarySearch(fArr2, f5);
            int binarySearch2 = Arrays.binarySearch(fArr3, f5);
            if (binarySearch < 0 || binarySearch2 > 0) {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                float f6 = fArr4[binarySearch2];
                if (iArr2.length < 2 || f5 == fArr2[c]) {
                    i = iArr2[0];
                } else {
                    while (i2 < fArr2.length) {
                        float f7 = fArr2[i2];
                        i2 = (f7 < f5 && i2 != fArr2.length + (-1)) ? i2 + 1 : 1;
                        int i18 = i2 - 1;
                        float f8 = fArr2[i18];
                        float f9 = (f5 - f8) / (f7 - f8);
                        int i19 = iArr2[i2];
                        int i20 = iArr2[i18];
                        i = Color.argb((int) (f6 * 255.0f), MiscUtils.MyBillsEntityDataFactory(Color.red(i20), Color.red(i19), f9), MiscUtils.MyBillsEntityDataFactory(Color.green(i20), Color.green(i19), f9), MiscUtils.MyBillsEntityDataFactory(Color.blue(i20), Color.blue(i19), f9));
                    }
                    throw new IllegalArgumentException("Unreachable code.");
                }
                iArr3[i17] = i;
            } else {
                int i21 = iArr2[binarySearch];
                if (size < i4 || f5 <= fArr3[c]) {
                    argb = Color.argb((int) (fArr4[c] * 255.0f), Color.red(i21), Color.green(i21), Color.blue(i21));
                } else {
                    for (int i22 = 1; i22 < size; i22++) {
                        float f10 = fArr3[i22];
                        if (f10 >= f5 || i22 == size - 1) {
                            if (f10 <= f5) {
                                PlaceComponentResult = fArr4[i22];
                            } else {
                                int i23 = i22 - 1;
                                float f11 = fArr3[i23];
                                PlaceComponentResult = MiscUtils.PlaceComponentResult(fArr4[i23], fArr4[i22], (f5 - f11) / (f10 - f11));
                            }
                            argb = Color.argb((int) (PlaceComponentResult * 255.0f), Color.red(i21), Color.green(i21), Color.blue(i21));
                        }
                    }
                    throw new IllegalArgumentException("Unreachable code.");
                }
                iArr3[i17] = argb;
            }
            i17++;
            c = 0;
            i4 = 2;
        }
        return new GradientColor(fArr5, iArr3);
    }
}
