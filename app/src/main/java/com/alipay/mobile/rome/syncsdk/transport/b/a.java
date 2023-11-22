package com.alipay.mobile.rome.syncsdk.transport.b;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.util.k;
import java.io.UnsupportedEncodingException;
import o.getOnBoardingScenario;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class a {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static long MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 1;
    private static final String h = "a";

    /* renamed from: a  reason: collision with root package name */
    protected byte f7240a;
    protected byte b;
    protected byte c;
    protected int d;
    protected byte e = 0;
    protected byte[] f;
    protected byte[] g;

    static {
        try {
            MyBillsEntityDataFactory();
            int i = PlaceComponentResult + 21;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = -8794018569410108728L;
    }

    public abstract void c(byte[] bArr);

    public abstract byte[] g();

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        if ((r4.f7240a != com.alipay.mobile.rome.syncsdk.transport.b.b.b) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        r4 = com.alipay.mobile.rome.syncsdk.transport.b.a.BuiltInFictitiousFunctionClassFactory + 57;
        com.alipay.mobile.rome.syncsdk.transport.b.a.PlaceComponentResult = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r4 = com.alipay.mobile.rome.syncsdk.transport.b.a.BuiltInFictitiousFunctionClassFactory + 73;
        com.alipay.mobile.rome.syncsdk.transport.b.a.PlaceComponentResult = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (r4 == r0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.alipay.mobile.rome.syncsdk.transport.b.a r4) {
        /*
            int r0 = com.alipay.mobile.rome.syncsdk.transport.b.a.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.alipay.mobile.rome.syncsdk.transport.b.a.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L1d
            byte r4 = r4.f7240a     // Catch: java.lang.Exception -> L1b
            int r0 = com.alipay.mobile.rome.syncsdk.transport.b.b.b     // Catch: java.lang.Exception -> L1b
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L19
            if (r4 != r0) goto L28
            goto L33
        L19:
            r4 = move-exception
            throw r4
        L1b:
            r4 = move-exception
            throw r4
        L1d:
            byte r4 = r4.f7240a
            int r0 = com.alipay.mobile.rome.syncsdk.transport.b.b.b
            if (r4 != r0) goto L25
            r4 = 0
            goto L26
        L25:
            r4 = 1
        L26:
            if (r4 == 0) goto L33
        L28:
            int r4 = com.alipay.mobile.rome.syncsdk.transport.b.a.BuiltInFictitiousFunctionClassFactory
            int r4 = r4 + 57
            int r0 = r4 % 128
            com.alipay.mobile.rome.syncsdk.transport.b.a.PlaceComponentResult = r0
            int r4 = r4 % 2
            return r1
        L33:
            int r4 = com.alipay.mobile.rome.syncsdk.transport.b.a.BuiltInFictitiousFunctionClassFactory
            int r4 = r4 + 73
            int r0 = r4 % 128
            com.alipay.mobile.rome.syncsdk.transport.b.a.PlaceComponentResult = r0
            int r4 = r4 % 2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncsdk.transport.b.a.a(com.alipay.mobile.rome.syncsdk.transport.b.a):boolean");
    }

    public final int a() {
        try {
            int i = PlaceComponentResult + 17;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 != 0)) {
                return this.b;
            }
            int i2 = 46 / 0;
            return this.b;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void a(int i) {
        int i2 = PlaceComponentResult + 113;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        this.b = (byte) i;
        int i4 = BuiltInFictitiousFunctionClassFactory + 105;
        PlaceComponentResult = i4 % 128;
        int i5 = i4 % 2;
    }

    public final int b() {
        byte b;
        try {
            int i = PlaceComponentResult + 109;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if ((i % 2 != 0 ? '\n' : 'a') != '\n') {
                b = this.c;
            } else {
                b = this.c;
                Object obj = null;
                obj.hashCode();
            }
            int i2 = PlaceComponentResult + 3;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return b;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void b(int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 7;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 == 0 ? 'F' : (char) 31) != 'F') {
            this.c = (byte) i;
            return;
        }
        this.c = (byte) i;
        Object[] objArr = null;
        int length = objArr.length;
    }

    public final int c() {
        int i = BuiltInFictitiousFunctionClassFactory + 125;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = this.d;
            Object obj = null;
            obj.hashCode();
            return i2;
        }
        return this.d;
    }

    public final int d() {
        int i = BuiltInFictitiousFunctionClassFactory + 119;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? '4' : ';') != ';') {
            byte b = this.e;
            Object obj = null;
            obj.hashCode();
            return b;
        }
        return this.e;
    }

    public final byte[] e() {
        int i = BuiltInFictitiousFunctionClassFactory + 51;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            byte[] bArr = this.g;
            Object[] objArr = null;
            int length = objArr.length;
            return bArr;
        }
        return this.g;
    }

    public final void a(byte[] bArr) {
        try {
            int i = PlaceComponentResult + 45;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if (!(i % 2 == 0)) {
                    this.g = bArr;
                    this.d = bArr.length;
                    int i2 = 14 / 0;
                } else {
                    this.g = bArr;
                    this.d = bArr.length;
                }
                int i3 = PlaceComponentResult + 45;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void b(byte[] bArr) {
        int i = PlaceComponentResult + 63;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 != 0) {
            this.g = k.b(bArr);
            this.d = bArr.length;
            this.e = (byte) 0;
            return;
        }
        try {
            this.g = k.b(bArr);
            this.d = bArr.length;
            this.e = (byte) 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r0 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        if ((r0 != null) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        if (r0.length > 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r2 > 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String f() {
        /*
            r10 = this;
            int r0 = com.alipay.mobile.rome.syncsdk.transport.b.a.PlaceComponentResult
            int r0 = r0 + 65
            int r1 = r0 % 128
            com.alipay.mobile.rome.syncsdk.transport.b.a.BuiltInFictitiousFunctionClassFactory = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 96
            if (r0 == 0) goto L11
            r0 = 32
            goto L13
        L11:
            r0 = 96
        L13:
            r3 = 0
            r4 = 1
            r5 = 0
            if (r0 == r2) goto L22
            byte[] r0 = r10.g
            r3.hashCode()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L9e
            goto L2b
        L20:
            r0 = move-exception
            throw r0
        L22:
            byte[] r0 = r10.g
            if (r0 == 0) goto L28
            r2 = 1
            goto L29
        L28:
            r2 = 0
        L29:
            if (r2 == 0) goto L9e
        L2b:
            int r2 = com.alipay.mobile.rome.syncsdk.transport.b.a.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 119
            int r6 = r2 % 128
            com.alipay.mobile.rome.syncsdk.transport.b.a.PlaceComponentResult = r6
            int r2 = r2 % r1
            r6 = 71
            if (r2 != 0) goto L3b
            r2 = 71
            goto L3d
        L3b:
            r2 = 80
        L3d:
            if (r2 == r6) goto L43
            int r2 = r0.length
            if (r2 <= 0) goto L9e
            goto L49
        L43:
            int r2 = r0.length
            r3.hashCode()     // Catch: java.lang.Throwable -> L9c
            if (r2 <= 0) goto L9e
        L49:
            java.lang.String r2 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L82
            long r6 = android.view.ViewConfiguration.getZoomControlsTimeout()     // Catch: java.io.UnsupportedEncodingException -> L82
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            int r3 = r3 + 20980
            r6 = 5
            char[] r6 = new char[r6]     // Catch: java.io.UnsupportedEncodingException -> L82
            r7 = 62430(0xf3de, float:8.7483E-41)
            r6[r5] = r7     // Catch: java.io.UnsupportedEncodingException -> L82
            r7 = 41514(0xa22a, float:5.8174E-41)
            r6[r4] = r7     // Catch: java.io.UnsupportedEncodingException -> L82
            r7 = 20519(0x5027, float:2.8753E-41)
            r6[r1] = r7     // Catch: java.io.UnsupportedEncodingException -> L82
            r7 = 3
            r8 = 1657(0x679, float:2.322E-42)
            r6[r7] = r8     // Catch: java.io.UnsupportedEncodingException -> L82
            r7 = 4
            r8 = 46183(0xb467, float:6.4716E-41)
            r6[r7] = r8     // Catch: java.io.UnsupportedEncodingException -> L82
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.io.UnsupportedEncodingException -> L82
            i(r3, r6, r4)     // Catch: java.io.UnsupportedEncodingException -> L82
            r3 = r4[r5]     // Catch: java.io.UnsupportedEncodingException -> L82
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.io.UnsupportedEncodingException -> L82
            java.lang.String r3 = r3.intern()     // Catch: java.io.UnsupportedEncodingException -> L82
            r2.<init>(r0, r3)     // Catch: java.io.UnsupportedEncodingException -> L82
            goto La0
        L82:
            r0 = move-exception
            java.lang.String r2 = com.alipay.mobile.rome.syncsdk.transport.b.a.h
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getDataStr: [ Exception "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = " ]"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r2, r0)
            goto L9e
        L9c:
            r0 = move-exception
            throw r0
        L9e:
            java.lang.String r2 = ""
        La0:
            int r0 = com.alipay.mobile.rome.syncsdk.transport.b.a.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 9
            int r3 = r0 % 128
            com.alipay.mobile.rome.syncsdk.transport.b.a.PlaceComponentResult = r3
            int r0 = r0 % r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncsdk.transport.b.a.f():java.lang.String");
    }

    public final void a(String str) {
        int i = PlaceComponentResult + 115;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if ((str != null ? 'S' : '\'') == 'S') {
            int i3 = BuiltInFictitiousFunctionClassFactory + 13;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            if ((str.length() > 0 ? 'a' : 'b') == 'a') {
                int i5 = PlaceComponentResult + 87;
                BuiltInFictitiousFunctionClassFactory = i5 % 128;
                int i6 = i5 % 2;
                try {
                    Object[] objArr = new Object[1];
                    i(TextUtils.getOffsetBefore("", 0) + 20981, new char[]{62430, 41514, 20519, 1657, 46183}, objArr);
                    a(str.getBytes(((String) objArr[0]).intern()));
                    return;
                } catch (UnsupportedEncodingException e) {
                    String str2 = h;
                    StringBuilder sb = new StringBuilder("setDataStr: [ Exception ");
                    sb.append(e);
                    sb.append(" ]");
                    com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
                    return;
                }
            }
        }
        this.g = null;
        this.d = 0;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", (int) this.f7240a);
            jSONObject.put("packetType", (int) this.b);
            jSONObject.put("packetReqOrRep", (int) this.c);
            jSONObject.put("dataLen", this.d);
            jSONObject.put("isDataGziped", (int) this.e);
            jSONObject.put("extField", this.f);
            jSONObject.put("dataStr", f());
            String jSONObject2 = jSONObject.toString();
            int i = PlaceComponentResult + 61;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            return jSONObject2;
        } catch (JSONException e) {
            String str = h;
            StringBuilder sb = new StringBuilder("toString: [ Exception ");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            return "Pakcet toString failed";
        }
    }

    private static void i(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 11 : ']') == ']') {
                break;
            }
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (MyBillsEntityDataFactory ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i2 = $10 + 27;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                objArr[0] = new String(cArr2);
                return;
            }
            try {
                int i4 = $11 + 71;
                $10 = i4 % 128;
                if (i4 % 2 != 0) {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext >>= 0;
                } else {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext++;
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
