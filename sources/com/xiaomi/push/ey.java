package com.xiaomi.push;

/* loaded from: classes8.dex */
public abstract class ey {
    public int BuiltInFictitiousFunctionClassFactory() {
        return -1;
    }

    public final int BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            int authRequestContext = getAuthRequestContext(bArr, i2 + 0, i - i2);
            if (authRequestContext <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot read. Remote side has closed. Tried to read ");
                sb.append(i);
                sb.append(" bytes, but only got ");
                sb.append(i2);
                sb.append(" bytes.");
                throw new ez(sb.toString());
            }
            i2 += authRequestContext;
        }
        return i2;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
    }

    public abstract void MyBillsEntityDataFactory(byte[] bArr, int i, int i2);

    public int PlaceComponentResult() {
        return 0;
    }

    public abstract int getAuthRequestContext(byte[] bArr, int i, int i2);

    public byte[] getAuthRequestContext() {
        return null;
    }
}
