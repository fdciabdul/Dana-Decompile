package com.xiaomi.push.service;

/* loaded from: classes8.dex */
public class bh {
    private int MyBillsEntityDataFactory = -666;
    private byte[] KClassImpl$Data$declaredNonStaticMembers$2 = new byte[256];
    private int BuiltInFictitiousFunctionClassFactory = 0;
    private int PlaceComponentResult = 0;

    public static byte[] getAuthRequestContext(String str, String str2) {
        byte[] BuiltInFictitiousFunctionClassFactory = com.xiaomi.push.aa.BuiltInFictitiousFunctionClassFactory(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[BuiltInFictitiousFunctionClassFactory.length + 1 + bytes.length];
        for (int i = 0; i < BuiltInFictitiousFunctionClassFactory.length; i++) {
            bArr[i] = BuiltInFictitiousFunctionClassFactory[i];
        }
        bArr[BuiltInFictitiousFunctionClassFactory.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[BuiltInFictitiousFunctionClassFactory.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < 256; i++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2[i] = (byte) i;
        }
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.PlaceComponentResult = 0;
        while (true) {
            int i2 = this.PlaceComponentResult;
            if (i2 >= 256) {
                return;
            }
            int i3 = this.BuiltInFictitiousFunctionClassFactory;
            int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2[i2];
            if (i4 < 0) {
                i4 += 256;
            }
            int i5 = i3 + i4;
            int i6 = bArr[this.PlaceComponentResult % length];
            if (i6 < 0) {
                i6 += 256;
            }
            int i7 = (i5 + i6) % 256;
            this.BuiltInFictitiousFunctionClassFactory = i7;
            byte[] bArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i8 = this.PlaceComponentResult;
            byte b = bArr2[i8];
            bArr2[i8] = bArr2[i7];
            bArr2[i7] = b;
            this.PlaceComponentResult = i8 + 1;
        }
    }

    public static byte[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        bh bhVar = new bh();
        bhVar.KClassImpl$Data$declaredNonStaticMembers$2(bArr);
        bhVar.BuiltInFictitiousFunctionClassFactory = 0;
        bhVar.PlaceComponentResult = 0;
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ bhVar.PlaceComponentResult());
        }
        return bArr3;
    }

    public static byte[] PlaceComponentResult(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("start = ");
            sb.append(i);
            sb.append(" len = ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        bh bhVar = new bh();
        bhVar.KClassImpl$Data$declaredNonStaticMembers$2(bArr);
        bhVar.BuiltInFictitiousFunctionClassFactory = 0;
        bhVar.PlaceComponentResult = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            bArr2[i4] = (byte) (bArr2[i4] ^ bhVar.PlaceComponentResult());
        }
        return bArr2;
    }

    private byte PlaceComponentResult() {
        int i = (this.PlaceComponentResult + 1) % 256;
        this.PlaceComponentResult = i;
        int i2 = this.BuiltInFictitiousFunctionClassFactory;
        int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2[i];
        if (i3 < 0) {
            i3 += 256;
        }
        int i4 = (i2 + i3) % 256;
        this.BuiltInFictitiousFunctionClassFactory = i4;
        byte[] bArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i5 = this.PlaceComponentResult;
        byte b = bArr[i5];
        bArr[i5] = bArr[i4];
        bArr[i4] = b;
        int i6 = bArr[i5];
        if (i6 < 0) {
            i6 += 256;
        }
        int i7 = this.KClassImpl$Data$declaredNonStaticMembers$2[this.BuiltInFictitiousFunctionClassFactory];
        if (i7 < 0) {
            i7 += 256;
        }
        return bArr[(i6 + i7) % 256];
    }
}
