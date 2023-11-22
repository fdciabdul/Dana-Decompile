package com.xiaomi.push;

import java.io.IOException;

/* loaded from: classes8.dex */
public abstract class e {
    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean BuiltInFictitiousFunctionClassFactory(b bVar, int i) {
        return bVar.getAuthRequestContext(i);
    }

    public final e BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i, int i2) {
        try {
            b authRequestContext = b.getAuthRequestContext(bArr, i, i2);
            KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(0);
            return this;
        } catch (d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract e KClassImpl$Data$declaredNonStaticMembers$2(b bVar);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(c cVar);

    public abstract int PlaceComponentResult();

    public abstract int getAuthRequestContext();

    public final byte[] moveToNextValue() {
        int PlaceComponentResult = PlaceComponentResult();
        byte[] bArr = new byte[PlaceComponentResult];
        try {
            c BuiltInFictitiousFunctionClassFactory = c.BuiltInFictitiousFunctionClassFactory(bArr, 0, PlaceComponentResult);
            KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            return bArr;
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }
}
