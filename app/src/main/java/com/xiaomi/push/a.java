package com.xiaomi.push;

/* loaded from: classes8.dex */
public final class a {
    public static final a PlaceComponentResult = new a(new byte[0]);
    private volatile int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    final byte[] MyBillsEntityDataFactory;

    private a(byte[] bArr) {
        this.MyBillsEntityDataFactory = bArr;
    }

    public static a KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new a(bArr2);
    }

    public final byte[] BuiltInFictitiousFunctionClassFactory() {
        byte[] bArr = this.MyBillsEntityDataFactory;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            byte[] bArr = this.MyBillsEntityDataFactory;
            int length = bArr.length;
            byte[] bArr2 = ((a) obj).MyBillsEntityDataFactory;
            if (length != bArr2.length) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 0) {
            byte[] bArr = this.MyBillsEntityDataFactory;
            int length = bArr.length;
            for (byte b : bArr) {
                length = (length * 31) + b;
            }
            i = length == 0 ? 1 : length;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
        return i;
    }

    public static a getAuthRequestContext(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return new a(bArr2);
    }
}
