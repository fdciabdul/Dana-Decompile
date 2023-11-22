package com.xiaomi.push;

/* loaded from: classes8.dex */
public final class ex extends ey {
    int BuiltInFictitiousFunctionClassFactory;
    byte[] MyBillsEntityDataFactory;
    int getAuthRequestContext;

    @Override // com.xiaomi.push.ey
    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext - this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.xiaomi.push.ey
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.BuiltInFictitiousFunctionClassFactory += i;
    }

    @Override // com.xiaomi.push.ey
    public final void MyBillsEntityDataFactory(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.ey
    public final int PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.xiaomi.push.ey
    public final byte[] getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.xiaomi.push.ey
    public final int getAuthRequestContext(byte[] bArr, int i, int i2) {
        int i3 = this.getAuthRequestContext - this.BuiltInFictitiousFunctionClassFactory;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i2 > 0) {
            System.arraycopy(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, bArr, i, i2);
            this.BuiltInFictitiousFunctionClassFactory += i2;
        }
        return i2;
    }
}
