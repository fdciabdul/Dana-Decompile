package com.journeyapps.barcodescanner;

import android.graphics.Rect;

/* loaded from: classes3.dex */
public class SourceData {
    int BuiltInFictitiousFunctionClassFactory;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    RawImageData MyBillsEntityDataFactory;
    Rect PlaceComponentResult;
    int getAuthRequestContext;
    int moveToNextValue = 1;

    public SourceData(byte[] bArr, int i, int i2, int i3, int i4) {
        this.MyBillsEntityDataFactory = new RawImageData(bArr, i, i2);
        this.getAuthRequestContext = i4;
        this.BuiltInFictitiousFunctionClassFactory = i3;
        if (i * i2 <= bArr.length) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Image data does not match the resolution. ");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append(" > ");
        sb.append(bArr.length);
        throw new IllegalArgumentException(sb.toString());
    }
}
