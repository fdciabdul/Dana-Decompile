package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* loaded from: classes8.dex */
public class bm {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {80, 85, 83, 72};
    private byte[] BuiltInFictitiousFunctionClassFactory;
    private int MyBillsEntityDataFactory;
    private byte PlaceComponentResult;
    private short getAuthRequestContext;

    /* loaded from: classes8.dex */
    public static class a {
        public static final c BuiltInFictitiousFunctionClassFactory = new c();
        public static final d PlaceComponentResult = new d();

        public static byte[] PlaceComponentResult(byte[] bArr) {
            return PlaceComponentResult(bArr, PlaceComponentResult);
        }

        private static byte[] PlaceComponentResult(byte[] bArr, b bVar) {
            if (bm.PlaceComponentResult(bArr)) {
                bm BuiltInFictitiousFunctionClassFactory2 = bm.BuiltInFictitiousFunctionClassFactory(bArr);
                return (BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult == 0 || BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult != bVar.BuiltInFictitiousFunctionClassFactory()) ? BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory : bVar.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory);
            }
            return bArr;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        byte BuiltInFictitiousFunctionClassFactory();

        byte[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i);
    }

    /* loaded from: classes8.dex */
    public static final class c {
    }

    /* loaded from: classes8.dex */
    public static final class d implements b {
        @Override // com.xiaomi.push.bm.b
        public final byte BuiltInFictitiousFunctionClassFactory() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.bm.b
        public final byte[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i) {
            GZIPInputStream gZIPInputStream;
            GZIPInputStream gZIPInputStream2 = null;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[i];
                gZIPInputStream.read(bArr2);
                try {
                    gZIPInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            } catch (IOException unused3) {
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    private bm(int i, byte[] bArr) {
        this((short) 1, (byte) 0, i, bArr);
    }

    private bm(short s, byte b2, int i, byte[] bArr) {
        this.getAuthRequestContext = s;
        this.PlaceComponentResult = b2;
        this.MyBillsEntityDataFactory = i;
        this.BuiltInFictitiousFunctionClassFactory = bArr;
    }

    private static boolean MyBillsEntityDataFactory(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean PlaceComponentResult(byte[] bArr) {
        byte[] bArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        return MyBillsEntityDataFactory(bArr2, bArr, bArr2.length);
    }

    public static bm BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
        if (PlaceComponentResult(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b2 = order.get();
            int i = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return new bm(s, b2, i, bArr2);
        }
        return new bm(bArr.length, bArr);
    }
}
