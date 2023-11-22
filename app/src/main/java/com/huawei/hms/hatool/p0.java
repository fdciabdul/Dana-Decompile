package com.huawei.hms.hatool;

/* loaded from: classes8.dex */
public class p0 {
    public byte[] KClassImpl$Data$declaredNonStaticMembers$2;
    public int getAuthRequestContext = 0;

    public p0() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new byte[1024];
    }

    public final byte[] KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.getAuthRequestContext;
        if (i <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.KClassImpl$Data$declaredNonStaticMembers$2, 0, bArr, 0, i);
        return bArr;
    }
}
