package com.xiaomi.push;

import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.cashier.view.InputCardNumberView;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes8.dex */
public final class c {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    private static char[] PlaceComponentResult = {35502, 35582, 35527, 35547, 35488};
    private static int scheduleImpl = 1;
    private final byte[] BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;
    private final OutputStream getAuthRequestContext;

    /* loaded from: classes8.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.getAuthRequestContext = outputStream;
        this.BuiltInFictitiousFunctionClassFactory = bArr;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.MyBillsEntityDataFactory = bArr.length;
    }

    private c(byte[] bArr, int i, int i2) {
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = bArr;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = i + i2;
    }

    public static int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        int i3 = scheduleImpl + 107;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        char c = i3 % 2 != 0 ? 'O' : '\'';
        int NetworkUserEntityData$$ExternalSyntheticLambda02 = NetworkUserEntityData$$ExternalSyntheticLambda0(i);
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory(i2);
        return c != 'O' ? NetworkUserEntityData$$ExternalSyntheticLambda02 + MyBillsEntityDataFactory : NetworkUserEntityData$$ExternalSyntheticLambda02 * MyBillsEntityDataFactory;
    }

    private static int BuiltInFictitiousFunctionClassFactory(long j) {
        int i = scheduleImpl + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        if ((((-128) & j) == 0 ? 'H' : '^') == 'H') {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 125;
            scheduleImpl = i3 % 128;
            return !(i3 % 2 != 0) ? 0 : 1;
        }
        if (!(((-16384) & j) == 0)) {
            if ((((-2097152) & j) == 0 ? '\\' : InputCardNumberView.DIVIDER) != ' ') {
                return 3;
            }
            if (((-268435456) & j) == 0) {
                return 4;
            }
            if (((-34359738368L) & j) == 0) {
                return 5;
            }
            if (!(((-4398046511104L) & j) != 0)) {
                return 6;
            }
            if (((-562949953421312L) & j) == 0) {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 49;
                scheduleImpl = i4 % 128;
                int i5 = i4 % 2;
                return 7;
            }
            if (((-72057594037927936L) & j) != 0) {
                return (j & Long.MIN_VALUE) != 0 ? 10 : 9;
            }
            int i6 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 73;
            scheduleImpl = i6 % 128;
            int i7 = i6 % 2;
            return 8;
        }
        return 2;
    }

    public static c BuiltInFictitiousFunctionClassFactory(OutputStream outputStream) {
        try {
            int i = scheduleImpl + 69;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 != 0 ? '7' : 'X') != '7') {
                return KClassImpl$Data$declaredNonStaticMembers$2(outputStream);
            }
            try {
                int i2 = 95 / 0;
                return KClassImpl$Data$declaredNonStaticMembers$2(outputStream);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static c BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i, int i2) {
        c cVar = new c(bArr, i, i2);
        int i3 = scheduleImpl + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 18 : 'V') != 'V') {
            Object obj = null;
            obj.hashCode();
            return cVar;
        }
        return cVar;
    }

    private void BuiltInFictitiousFunctionClassFactory(String str) {
        int i = scheduleImpl + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        a(new int[]{0, 5, 12, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr);
        byte[] bytes = str.getBytes(((String) objArr[0]).intern());
        NetworkUserEntityData$$ExternalSyntheticLambda1(bytes.length);
        KClassImpl$Data$declaredNonStaticMembers$2(bytes);
        int i3 = scheduleImpl + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
    }

    private void BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i) {
        int i2;
        int i3 = this.MyBillsEntityDataFactory;
        int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i5 = i3 - i4;
        if (!(i5 < i)) {
            int i6 = scheduleImpl + 49;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
            if (i6 % 2 != 0) {
                System.arraycopy(bArr, 0, this.BuiltInFictitiousFunctionClassFactory, i4, i);
                i2 = this.KClassImpl$Data$declaredNonStaticMembers$2 >> i;
            } else {
                System.arraycopy(bArr, 0, this.BuiltInFictitiousFunctionClassFactory, i4, i);
                i2 = this.KClassImpl$Data$declaredNonStaticMembers$2 + i;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            return;
        }
        System.arraycopy(bArr, 0, this.BuiltInFictitiousFunctionClassFactory, i4, i5);
        int i7 = i5 + 0;
        int i8 = i - i5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory;
        KClassImpl$Data$declaredNonStaticMembers$2();
        if (!(i8 <= this.MyBillsEntityDataFactory)) {
            this.getAuthRequestContext.write(bArr, i7, i8);
            return;
        }
        int i9 = scheduleImpl + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i9 % 128;
        int i10 = i9 % 2;
        System.arraycopy(bArr, i7, this.BuiltInFictitiousFunctionClassFactory, 0, i8);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i8;
        int i11 = scheduleImpl + 91;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i11 % 128;
        int i12 = i11 % 2;
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int i2 = scheduleImpl + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        try {
            int lookAheadTest = lookAheadTest(i);
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 97;
            scheduleImpl = i4 % 128;
            if ((i4 % 2 == 0 ? 'c' : 'b') != 'b') {
                int i5 = 28 / 0;
                return lookAheadTest;
            }
            return lookAheadTest;
        } catch (Exception e) {
            throw e;
        }
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        int i = scheduleImpl + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(j);
            int i3 = scheduleImpl + 93;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return BuiltInFictitiousFunctionClassFactory;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return BuiltInFictitiousFunctionClassFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(com.xiaomi.push.a aVar) {
        int i = scheduleImpl + 49;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        return !(i % 2 != 0) ? NetworkUserEntityData$$ExternalSyntheticLambda0(1) + BuiltInFictitiousFunctionClassFactory(aVar) : NetworkUserEntityData$$ExternalSyntheticLambda0(1) >> BuiltInFictitiousFunctionClassFactory(aVar);
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(e eVar) {
        int i = scheduleImpl + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            int PlaceComponentResult2 = eVar.PlaceComponentResult();
            int lookAheadTest = lookAheadTest(PlaceComponentResult2) + PlaceComponentResult2;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 49;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return lookAheadTest;
        } catch (Exception e) {
            throw e;
        }
    }

    private static c KClassImpl$Data$declaredNonStaticMembers$2(OutputStream outputStream) {
        c cVar = new c(outputStream, new byte[4096]);
        int i = scheduleImpl + 83;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return cVar;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = scheduleImpl + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            OutputStream outputStream = this.getAuthRequestContext;
            if ((outputStream != null ? 'C' : '4') == '4') {
                throw new a();
            }
            try {
                int i3 = scheduleImpl + 101;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                if ((i3 % 2 != 0 ? Typography.amp : 'A') != '&') {
                    outputStream.write(this.BuiltInFictitiousFunctionClassFactory, 0, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                    return;
                }
                outputStream.write(this.BuiltInFictitiousFunctionClassFactory, 0, this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        try {
            int i = scheduleImpl + 33;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                if ((i % 2 != 0 ? 'L' : (char) 27) == 27) {
                    BuiltInFictitiousFunctionClassFactory(bArr, bArr.length);
                    return;
                }
                BuiltInFictitiousFunctionClassFactory(bArr, bArr.length);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static int MyBillsEntityDataFactory(int i) {
        int i2 = scheduleImpl + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if (i2 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            if (i < 0) {
                return 10;
            }
        } else {
            if (i < 0) {
                return 10;
            }
        }
        int lookAheadTest = lookAheadTest(i);
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
            scheduleImpl = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 17 : '1') != '1') {
                int i4 = 48 / 0;
                return lookAheadTest;
            }
            return lookAheadTest;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int MyBillsEntityDataFactory(int i, e eVar) {
        try {
            int i2 = scheduleImpl + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
            int NetworkUserEntityData$$ExternalSyntheticLambda02 = NetworkUserEntityData$$ExternalSyntheticLambda0(i) + KClassImpl$Data$declaredNonStaticMembers$2(eVar);
            int i4 = scheduleImpl + 7;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
            int i5 = i4 % 2;
            return NetworkUserEntityData$$ExternalSyntheticLambda02;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int MyBillsEntityDataFactory(String str) {
        int i = scheduleImpl + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(new int[]{0, 5, 12, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr);
            byte[] bytes = str.getBytes(((String) objArr[0]).intern());
            int lookAheadTest = lookAheadTest(bytes.length) + bytes.length;
            int i3 = scheduleImpl + 93;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 20 : InputCardNumberView.DIVIDER) != 20) {
                return lookAheadTest;
            }
            Object[] objArr2 = null;
            int length = objArr2.length;
            return lookAheadTest;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    private void MyBillsEntityDataFactory(com.xiaomi.push.a aVar) {
        int i = scheduleImpl + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        try {
            if ((i % 2 != 0 ? Typography.greater : 'M') == 'M') {
                byte[] BuiltInFictitiousFunctionClassFactory = aVar.BuiltInFictitiousFunctionClassFactory();
                NetworkUserEntityData$$ExternalSyntheticLambda1(BuiltInFictitiousFunctionClassFactory.length);
                KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                return;
            }
            try {
                byte[] BuiltInFictitiousFunctionClassFactory2 = aVar.BuiltInFictitiousFunctionClassFactory();
                NetworkUserEntityData$$ExternalSyntheticLambda1(BuiltInFictitiousFunctionClassFactory2.length);
                KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static int NetworkUserEntityData$$ExternalSyntheticLambda0(int i) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 41;
        scheduleImpl = i2 % 128;
        if (i2 % 2 == 0) {
        }
        int lookAheadTest = lookAheadTest(f.BuiltInFictitiousFunctionClassFactory(i, 0));
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 75;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return lookAheadTest;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda1(int i) {
        while (true) {
            if (((i & (-128)) == 0 ? 'H' : '4') != '4') {
                try {
                    break;
                } catch (Exception e) {
                    throw e;
                }
            }
            scheduleImpl((i & 127) | 128);
            i >>>= 7;
            try {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
                scheduleImpl = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e2) {
                throw e2;
            }
            throw e2;
        }
        int i4 = scheduleImpl + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        if ((i4 % 2 != 0 ? '!' : JSONLexer.EOI) == 26) {
            scheduleImpl(i);
            return;
        }
        scheduleImpl(i);
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static int PlaceComponentResult(int i) {
        int i2 = scheduleImpl + 25;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        int NetworkUserEntityData$$ExternalSyntheticLambda02 = NetworkUserEntityData$$ExternalSyntheticLambda0(i) + 1;
        try {
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
            scheduleImpl = i4 % 128;
            if ((i4 % 2 == 0 ? '\t' : '7') != '7') {
                Object[] objArr = null;
                int length = objArr.length;
                return NetworkUserEntityData$$ExternalSyntheticLambda02;
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda02;
        } catch (Exception e) {
            throw e;
        }
    }

    private void PlaceComponentResult(int i, int i2) {
        int i3 = scheduleImpl + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda1(f.BuiltInFictitiousFunctionClassFactory(i, i2));
        try {
            int i5 = scheduleImpl + 113;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void PlaceComponentResult(long j) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 87;
            scheduleImpl = i % 128;
            if ((i % 2 == 0 ? 'T' : 'X') == 'T') {
                getErrorConfigVersion(j);
                int i2 = 39 / 0;
                return;
            }
            try {
                getErrorConfigVersion(j);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private int getAuthRequestContext() {
        int i = scheduleImpl + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        if ((this.getAuthRequestContext == null ? 'B' : '\\') == 'B') {
            int i3 = this.MyBillsEntityDataFactory - this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
            scheduleImpl = i4 % 128;
            int i5 = i4 % 2;
            return i3;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public static int getAuthRequestContext(int i) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 17;
        scheduleImpl = i2 % 128;
        int NetworkUserEntityData$$ExternalSyntheticLambda02 = (i2 % 2 == 0 ? 'X' : 'b') != 'b' ? NetworkUserEntityData$$ExternalSyntheticLambda0(0) % KClassImpl$Data$declaredNonStaticMembers$2(i) : NetworkUserEntityData$$ExternalSyntheticLambda0(1) + KClassImpl$Data$declaredNonStaticMembers$2(i);
        try {
            int i3 = scheduleImpl + 109;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return NetworkUserEntityData$$ExternalSyntheticLambda02;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return NetworkUserEntityData$$ExternalSyntheticLambda02;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int getAuthRequestContext(int i, String str) {
        try {
            int i2 = scheduleImpl + 101;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
            try {
                int NetworkUserEntityData$$ExternalSyntheticLambda02 = NetworkUserEntityData$$ExternalSyntheticLambda0(i) + MyBillsEntityDataFactory(str);
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
                scheduleImpl = i4 % 128;
                if ((i4 % 2 == 0 ? 'S' : (char) 5) != 5) {
                    int i5 = 77 / 0;
                    return NetworkUserEntityData$$ExternalSyntheticLambda02;
                }
                return NetworkUserEntityData$$ExternalSyntheticLambda02;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int getAuthRequestContext(long j) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        int NetworkUserEntityData$$ExternalSyntheticLambda02 = NetworkUserEntityData$$ExternalSyntheticLambda0(2) + KClassImpl$Data$declaredNonStaticMembers$2(j);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 69;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return NetworkUserEntityData$$ExternalSyntheticLambda02;
    }

    private void getAuthRequestContext(byte b) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == this.MyBillsEntityDataFactory) {
            int i3 = scheduleImpl + 53;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            KClassImpl$Data$declaredNonStaticMembers$2();
            int i5 = scheduleImpl + 25;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
            int i6 = i5 % 2;
        }
        byte[] bArr = this.BuiltInFictitiousFunctionClassFactory;
        int i7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i7 + 1;
        bArr[i7] = b;
    }

    private void getAuthRequestContext(e eVar) {
        int i = scheduleImpl + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1(eVar.getAuthRequestContext());
                eVar.KClassImpl$Data$declaredNonStaticMembers$2(this);
                int i3 = scheduleImpl + 123;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void getAuthRequestContext(boolean z) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 51;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        scheduleImpl(z ? 1 : 0);
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 121;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void getErrorConfigVersion(int i) {
        int i2 = scheduleImpl + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda1(i);
        try {
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 89;
            scheduleImpl = i4 % 128;
            if (!(i4 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void getErrorConfigVersion(long j) {
        while (true) {
            if (!(((-128) & j) != 0)) {
                break;
            }
            scheduleImpl((((int) j) & 127) | 128);
            j >>>= 7;
        }
        int i = scheduleImpl + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        scheduleImpl((int) j);
        int i3 = scheduleImpl + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 24 : '2') != '2') {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if ((r5 & (-128)) == 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        if ((r5 & (-16384)) != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        r0 = 'T';
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r0 = '/';
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        if (r0 == '/') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r5 = com.xiaomi.push.c.NetworkUserEntityData$$ExternalSyntheticLambda0 + 19;
        com.xiaomi.push.c.scheduleImpl = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if ((r5 % 2) != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        if (((-2097152) & r5) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        if (r4 == true) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        if ((r5 & (-268435456)) != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        r5 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004e, code lost:
    
        r5 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:
    
        if (r5 == 26) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0051, code lost:
    
        return 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        r0 = com.xiaomi.push.c.NetworkUserEntityData$$ExternalSyntheticLambda0 + 29;
        com.xiaomi.push.c.scheduleImpl = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005d, code lost:
    
        return 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005e, code lost:
    
        r0 = com.xiaomi.push.c.scheduleImpl + 45;
        com.xiaomi.push.c.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0068, code lost:
    
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (((r5 ^ 123) == 0 ? '[' : 14) != '[') goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int lookAheadTest(int r5) {
        /*
            int r0 = com.xiaomi.push.c.scheduleImpl
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.xiaomi.push.c.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            if (r0 == 0) goto L1b
            r0 = r5 ^ 123(0x7b, float:1.72E-43)
            r3 = 91
            if (r0 != 0) goto L16
            r0 = 91
            goto L18
        L16:
            r0 = 14
        L18:
            if (r0 == r3) goto L1f
            goto L20
        L1b:
            r0 = r5 & (-128(0xffffffffffffff80, float:NaN))
            if (r0 != 0) goto L20
        L1f:
            return r2
        L20:
            r0 = r5 & (-16384(0xffffffffffffc000, float:NaN))
            r3 = 47
            if (r0 != 0) goto L29
            r0 = 84
            goto L2b
        L29:
            r0 = 47
        L2b:
            r4 = 0
            if (r0 == r3) goto L3c
            int r5 = com.xiaomi.push.c.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r5 = r5 + 19
            int r0 = r5 % 128
            com.xiaomi.push.c.scheduleImpl = r0
            int r5 = r5 % r1
            if (r5 != 0) goto L3a
            goto L3b
        L3a:
            r2 = 0
        L3b:
            return r1
        L3c:
            r0 = -2097152(0xffffffffffe00000, float:NaN)
            r0 = r0 & r5
            if (r0 != 0) goto L42
            r4 = 1
        L42:
            if (r4 == r2) goto L5e
            r0 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r5 = r5 & r0
            r0 = 26
            if (r5 != 0) goto L4e
            r5 = 26
            goto L4f
        L4e:
            r5 = 6
        L4f:
            if (r5 == r0) goto L53
            r5 = 5
            return r5
        L53:
            r5 = 4
            int r0 = com.xiaomi.push.c.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 29
            int r2 = r0 % 128
            com.xiaomi.push.c.scheduleImpl = r2
            int r0 = r0 % r1
            return r5
        L5e:
            r5 = 3
            int r0 = com.xiaomi.push.c.scheduleImpl
            int r0 = r0 + 45
            int r2 = r0 % 128
            com.xiaomi.push.c.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
            int r0 = r0 % r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.c.lookAheadTest(int):int");
    }

    private void moveToNextValue(int i) {
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
            scheduleImpl = i2 % 128;
            int i3 = i2 % 2;
            if (i >= 0) {
                NetworkUserEntityData$$ExternalSyntheticLambda1(i);
                return;
            }
            getErrorConfigVersion(i);
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
            scheduleImpl = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void scheduleImpl(int i) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 101;
        scheduleImpl = i2 % 128;
        char c = i2 % 2 == 0 ? 'W' : '-';
        Object[] objArr = null;
        getAuthRequestContext((byte) i);
        if (c == 'W') {
            objArr.hashCode();
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
        scheduleImpl = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int length = objArr.length;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 23;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        if ((this.getAuthRequestContext != null ? (char) 6 : '7') != '7') {
            KClassImpl$Data$declaredNonStaticMembers$2();
            int i3 = scheduleImpl + 51;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        }
        try {
            int i5 = scheduleImpl + 81;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        try {
            int i2 = scheduleImpl + 105;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                if ((i2 % 2 != 0 ? InputCardNumberView.DIVIDER : '\b') != '\b') {
                    PlaceComponentResult(0, 0);
                } else {
                    PlaceComponentResult(1, 0);
                }
                getErrorConfigVersion(i);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(int i, boolean z) {
        int i2 = scheduleImpl + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        PlaceComponentResult(i, 0);
        getAuthRequestContext(z);
        int i4 = scheduleImpl + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public final void MyBillsEntityDataFactory() {
        int i = scheduleImpl + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        if (getAuthRequestContext() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        int i3 = scheduleImpl + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void MyBillsEntityDataFactory(long j) {
        int i = scheduleImpl + 113;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (i % 2 != 0) {
        }
        PlaceComponentResult(2, 0);
        PlaceComponentResult(j);
    }

    public final void PlaceComponentResult(int i, String str) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 69;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
        PlaceComponentResult(i, 2);
        BuiltInFictitiousFunctionClassFactory(str);
        int i4 = scheduleImpl + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void getAuthRequestContext(int i, int i2) {
        int i3 = scheduleImpl + 125;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        try {
            PlaceComponentResult(i, 0);
            moveToNextValue(i2);
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 31;
            scheduleImpl = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void getAuthRequestContext(int i, e eVar) {
        int i2 = scheduleImpl + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if ((i2 % 2 != 0 ? Typography.amp : 'X') != '&') {
            try {
                PlaceComponentResult(i, 2);
                getAuthRequestContext(eVar);
            } catch (Exception e) {
                throw e;
            }
        } else {
            PlaceComponentResult(i, 2);
            getAuthRequestContext(eVar);
        }
        int i3 = scheduleImpl + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public final void getAuthRequestContext(com.xiaomi.push.a aVar) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
        scheduleImpl = i % 128;
        if ((i % 2 == 0 ? 'N' : (char) 28) != 'N') {
            try {
                PlaceComponentResult(1, 2);
                MyBillsEntityDataFactory(aVar);
            } catch (Exception e) {
                throw e;
            }
        } else {
            PlaceComponentResult(0, 4);
            MyBillsEntityDataFactory(aVar);
        }
        int i2 = scheduleImpl + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private static int BuiltInFictitiousFunctionClassFactory(com.xiaomi.push.a aVar) {
        int i = scheduleImpl + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        int lookAheadTest = lookAheadTest(aVar.MyBillsEntityDataFactory.length) + aVar.MyBillsEntityDataFactory.length;
        int i3 = scheduleImpl + 65;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 != 0 ? '0' : '\\') != '0') {
            return lookAheadTest;
        }
        int i4 = 85 / 0;
        return lookAheadTest;
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = PlaceComponentResult;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = $10 + 123;
                $11 = i6 % 128;
                if ((i6 % 2 == 0 ? 'A' : JSONLexer.EOI) != 26) {
                    cArr2[i5] = (char) (cArr[i5] + 5097613533456403102L);
                    i5 *= 0;
                } else {
                    try {
                        cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                        i5++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (!(bArr == null)) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                if (!(bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] != 1)) {
                    int i7 = $10 + 55;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                try {
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            int i9 = $11 + 25;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i11 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i11, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i11);
        }
        if (z) {
            int i12 = $11 + 113;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if ((i3 > 0 ? ')' : (char) 21) == ')') {
            int i14 = $10 + 109;
            $11 = i14 % 128;
            int i15 = i14 % 2;
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            int i16 = $11 + 85;
            $10 = i16 % 128;
            int i17 = i16 % 2;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
