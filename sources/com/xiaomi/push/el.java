package com.xiaomi.push;

import com.alibaba.fastjson.parser.JSONLexer;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes8.dex */
public class el extends ep {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
    private static int isLayoutRequested = 1;
    private static int newProxyInstance;
    private static final eu scheduleImpl;
    protected boolean BuiltInFictitiousFunctionClassFactory;
    private byte[] DatabaseTableConfigUtil;
    private byte[] GetContactSyncConfig;
    protected int KClassImpl$Data$declaredNonStaticMembers$2;
    protected boolean MyBillsEntityDataFactory;
    private byte[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private byte[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected boolean getAuthRequestContext;
    private byte[] getErrorConfigVersion;
    private byte[] initRecordTimeStamp;
    private byte[] lookAheadTest;
    private byte[] moveToNextValue;

    /* loaded from: classes8.dex */
    public static class a implements er {

        /* renamed from: a  reason: collision with root package name */
        protected int f7787a;

        /* renamed from: a  reason: collision with other field name */
        protected boolean f391a;
        protected boolean b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f391a = z;
            this.b = z2;
            this.f7787a = i;
        }

        @Override // com.xiaomi.push.er
        public ep a(ey eyVar) {
            el elVar = new el(eyVar, this.f391a, this.b);
            int i = this.f7787a;
            if (i != 0) {
                elVar.PlaceComponentResult(i);
            }
            return elVar;
        }
    }

    static {
        try {
            initRecordTimeStamp();
            scheduleImpl = new eu();
            int i = isLayoutRequested + 29;
            newProxyInstance = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public el(ey eyVar, boolean z, boolean z2) {
        super(eyVar);
        try {
            this.BuiltInFictitiousFunctionClassFactory = false;
            try {
                this.lookAheadTest = new byte[1];
                this.getErrorConfigVersion = new byte[2];
                this.moveToNextValue = new byte[4];
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new byte[8];
                this.initRecordTimeStamp = new byte[1];
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new byte[2];
                this.DatabaseTableConfigUtil = new byte[4];
                this.GetContactSyncConfig = new byte[8];
                this.getAuthRequestContext = z;
                this.MyBillsEntityDataFactory = z2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private int PlaceComponentResult(byte[] bArr, int i) {
        try {
            int i2 = isLayoutRequested + 19;
            newProxyInstance = i2 % 128;
            char c = i2 % 2 != 0 ? 'M' : (char) 17;
            getAuthRequestContext(i);
            if (c != 'M') {
                return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(bArr, i);
            }
            int BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(bArr, i);
            int i3 = 41 / 0;
            return BuiltInFictitiousFunctionClassFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    private void PlaceComponentResult(byte b) {
        int i = isLayoutRequested + 99;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        this.lookAheadTest[0] = b;
        this.PlaceComponentResult.MyBillsEntityDataFactory(this.lookAheadTest, 0, 1);
        int i3 = isLayoutRequested + 45;
        newProxyInstance = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 24 : 'L') != 24) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    static void initRecordTimeStamp() {
        NetworkUserEntityData$$ExternalSyntheticLambda1 = new char[]{35517, 35495, 35500, 35544, 35530};
    }

    @Override // com.xiaomi.push.ep
    public final byte BuiltInFictitiousFunctionClassFactory() {
        int i = isLayoutRequested + 109;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        if ((this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() > 0 ? '1' : 'P') != '1') {
            PlaceComponentResult(this.initRecordTimeStamp, 1);
            return this.initRecordTimeStamp[0];
        }
        int i3 = isLayoutRequested + 117;
        newProxyInstance = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 20 : 'N') != 20) {
            byte b = this.PlaceComponentResult.getAuthRequestContext()[this.PlaceComponentResult.PlaceComponentResult()];
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1);
            return b;
        }
        try {
            try {
                byte b2 = this.PlaceComponentResult.getAuthRequestContext()[this.PlaceComponentResult.PlaceComponentResult()];
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(0);
                return b2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.xiaomi.push.ep
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        int i = newProxyInstance + 49;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(new int[]{0, 5, 0, 3}, false, new byte[]{0, 1, 1, 1, 1}, objArr);
            byte[] bytes = str.getBytes(((String) objArr[0]).intern());
            MyBillsEntityDataFactory(bytes.length);
            this.PlaceComponentResult.MyBillsEntityDataFactory(bytes, 0, bytes.length);
            int i3 = newProxyInstance + 59;
            isLayoutRequested = i3 % 128;
            if ((i3 % 2 != 0 ? '(' : ';') != '(') {
                Object[] objArr2 = null;
                int length = objArr2.length;
            }
        } catch (UnsupportedEncodingException unused) {
            throw new ej("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ep
    public final void BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer) {
        int i = isLayoutRequested + 59;
        newProxyInstance = i % 128;
        if (i % 2 == 0) {
            int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
            MyBillsEntityDataFactory(limit);
            this.PlaceComponentResult.MyBillsEntityDataFactory(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
        } else {
            int limit2 = (byteBuffer.limit() << byteBuffer.position()) >> byteBuffer.arrayOffset();
            MyBillsEntityDataFactory(limit2);
            this.PlaceComponentResult.MyBillsEntityDataFactory(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit2);
        }
        int i2 = newProxyInstance + 81;
        isLayoutRequested = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 19 : '\b') != '\b') {
            Object obj = null;
            obj.hashCode();
        }
    }

    @Override // com.xiaomi.push.ep
    public final void BuiltInFictitiousFunctionClassFactory(short s) {
        int i = newProxyInstance + 47;
        isLayoutRequested = i % 128;
        if (i % 2 == 0) {
            byte[] bArr = this.getErrorConfigVersion;
            bArr[0] = (byte) ((s / 29) | 30952);
            bArr[1] = (byte) (s ^ 21359);
            this.PlaceComponentResult.MyBillsEntityDataFactory(this.getErrorConfigVersion, 1, 2);
        } else {
            try {
                byte[] bArr2 = this.getErrorConfigVersion;
                bArr2[0] = (byte) ((s >> 8) & 255);
                bArr2[1] = (byte) (s & 255);
                this.PlaceComponentResult.MyBillsEntityDataFactory(this.getErrorConfigVersion, 0, 2);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = isLayoutRequested + 67;
        newProxyInstance = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        int i3 = 74 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if ((r6.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() >= 2 ? '(' : '0') != '0') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        if ((r6.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() < 2) != true) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        r0 = r6.PlaceComponentResult.getAuthRequestContext();
        r2 = r6.PlaceComponentResult.PlaceComponentResult();
        r6.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        PlaceComponentResult(r6.NetworkUserEntityData$$ExternalSyntheticLambda2, 2);
        r2 = 0;
     */
    @Override // com.xiaomi.push.ep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final short DatabaseTableConfigUtil() {
        /*
            r6 = this;
            int r0 = com.xiaomi.push.el.isLayoutRequested     // Catch: java.lang.Exception -> L7a
            int r0 = r0 + 53
            int r1 = r0 % 128
            com.xiaomi.push.el.newProxyInstance = r1     // Catch: java.lang.Exception -> L7a
            r1 = 2
            int r0 = r0 % r1
            r2 = 12
            if (r0 == 0) goto L11
            r0 = 12
            goto L13
        L11:
            r0 = 10
        L13:
            r3 = 1
            r4 = 0
            if (r0 == r2) goto L2b
            byte[] r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2
            com.xiaomi.push.ey r2 = r6.PlaceComponentResult
            int r2 = r2.BuiltInFictitiousFunctionClassFactory()
            r5 = 48
            if (r2 < r1) goto L26
            r2 = 40
            goto L28
        L26:
            r2 = 48
        L28:
            if (r2 == r5) goto L4c
            goto L3a
        L2b:
            byte[] r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L7a
            com.xiaomi.push.ey r2 = r6.PlaceComponentResult     // Catch: java.lang.Exception -> L7a
            int r2 = r2.BuiltInFictitiousFunctionClassFactory()     // Catch: java.lang.Exception -> L7a
            if (r2 < r1) goto L37
            r2 = 0
            goto L38
        L37:
            r2 = 1
        L38:
            if (r2 == r3) goto L4c
        L3a:
            com.xiaomi.push.ey r0 = r6.PlaceComponentResult
            byte[] r0 = r0.getAuthRequestContext()
            com.xiaomi.push.ey r2 = r6.PlaceComponentResult
            int r2 = r2.PlaceComponentResult()
            com.xiaomi.push.ey r5 = r6.PlaceComponentResult
            r5.KClassImpl$Data$declaredNonStaticMembers$2(r1)
            goto L52
        L4c:
            byte[] r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2
            r6.PlaceComponentResult(r2, r1)
            r2 = 0
        L52:
            r5 = r0[r2]
            int r2 = r2 + r3
            r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r2 = r5 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r0 = r0 | r2
            short r0 = (short) r0
            int r2 = com.xiaomi.push.el.isLayoutRequested
            int r2 = r2 + 61
            int r3 = r2 % 128
            com.xiaomi.push.el.newProxyInstance = r3
            int r2 = r2 % r1
            r1 = 25
            if (r2 == 0) goto L6f
            r2 = 25
            goto L71
        L6f:
            r2 = 58
        L71:
            if (r2 == r1) goto L74
            return r0
        L74:
            r1 = 95
            int r1 = r1 / r4
            return r0
        L78:
            r0 = move-exception
            throw r0
        L7a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.el.DatabaseTableConfigUtil():short");
    }

    @Override // com.xiaomi.push.ep
    public final boolean GetContactSyncConfig() {
        int i = isLayoutRequested + 125;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        if ((BuiltInFictitiousFunctionClassFactory() != 1 ? (char) 1 : ',') != 1) {
            return true;
        }
        try {
            int i3 = isLayoutRequested + 7;
            newProxyInstance = i3 % 128;
            return !(i3 % 2 == 0);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.xiaomi.push.ep
    public final double KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            int i = newProxyInstance + 113;
            try {
                isLayoutRequested = i % 128;
                int i2 = i % 2;
                double longBitsToDouble = Double.longBitsToDouble(MyBillsEntityDataFactory());
                int i3 = newProxyInstance + 65;
                isLayoutRequested = i3 % 128;
                if ((i3 % 2 == 0 ? '2' : (char) 23) != '2') {
                    return longBitsToDouble;
                }
                Object obj = null;
                obj.hashCode();
                return longBitsToDouble;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        try {
            getAuthRequestContext(i);
            byte[] bArr = new byte[i];
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(bArr, i);
            Object[] objArr = new Object[1];
            a(new int[]{0, 5, 0, 3}, false, new byte[]{0, 1, 1, 1, 1}, objArr);
            String str = new String(bArr, ((String) objArr[0]).intern());
            int i2 = isLayoutRequested + 73;
            newProxyInstance = i2 % 128;
            int i3 = i2 % 2;
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new ej("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ep
    public final void KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        int i = newProxyInstance + 23;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        byte[] bArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.PlaceComponentResult.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 8);
        int i3 = newProxyInstance + 123;
        isLayoutRequested = i3 % 128;
        if ((i3 % 2 == 0 ? ',' : (char) 0) != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @Override // com.xiaomi.push.ep
    public final void KClassImpl$Data$declaredNonStaticMembers$2(en enVar) {
        int i = newProxyInstance + 17;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        PlaceComponentResult(enVar.PlaceComponentResult);
        MyBillsEntityDataFactory(enVar.KClassImpl$Data$declaredNonStaticMembers$2);
        try {
            int i3 = isLayoutRequested + 59;
            newProxyInstance = i3 % 128;
            if ((i3 % 2 != 0 ? 'J' : '\n') != 'J') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.xiaomi.push.ep
    public final long MyBillsEntityDataFactory() {
        try {
            int i = isLayoutRequested + 103;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            byte[] bArr = this.GetContactSyncConfig;
            int i3 = 0;
            if ((this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() >= 8 ? (char) 25 : 'c') != 'c') {
                int i4 = isLayoutRequested + 23;
                newProxyInstance = i4 % 128;
                int i5 = i4 % 2;
                bArr = this.PlaceComponentResult.getAuthRequestContext();
                i3 = this.PlaceComponentResult.PlaceComponentResult();
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(8);
                int i6 = newProxyInstance + 89;
                isLayoutRequested = i6 % 128;
                int i7 = i6 % 2;
            } else {
                PlaceComponentResult(this.GetContactSyncConfig, 8);
            }
            return (bArr[i3 + 7] & 255) | ((bArr[i3 + 6] & 255) << 8) | ((bArr[i3] & 255) << 56) | ((bArr[i3 + 1] & 255) << 48) | ((bArr[i3 + 2] & 255) << 40) | ((bArr[i3 + 3] & 255) << 32) | ((bArr[i3 + 4] & 255) << 24) | ((bArr[i3 + 5] & 255) << 16);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.xiaomi.push.ep
    public final void MyBillsEntityDataFactory(int i) {
        int i2 = isLayoutRequested + 55;
        newProxyInstance = i2 % 128;
        int i3 = i2 % 2;
        try {
            byte[] bArr = this.moveToNextValue;
            bArr[0] = (byte) ((i >> 24) & 255);
            bArr[1] = (byte) ((i >> 16) & 255);
            bArr[2] = (byte) ((i >> 8) & 255);
            bArr[3] = (byte) (i & 255);
            try {
                this.PlaceComponentResult.MyBillsEntityDataFactory(this.moveToNextValue, 0, 4);
                int i4 = isLayoutRequested + 73;
                newProxyInstance = i4 % 128;
                if (i4 % 2 != 0) {
                    int i5 = 45 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.xiaomi.push.ep
    public en NetworkUserEntityData$$ExternalSyntheticLambda0() {
        en enVar = new en(BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext());
        try {
            int i = isLayoutRequested + 83;
            try {
                newProxyInstance = i % 128;
                if (i % 2 == 0) {
                    return enVar;
                }
                int i2 = 99 / 0;
                return enVar;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.xiaomi.push.ep
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        int i = isLayoutRequested + 97;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        PlaceComponentResult((byte) 0);
        int i3 = isLayoutRequested + 79;
        newProxyInstance = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    @Override // com.xiaomi.push.ep
    public final em PlaceComponentResult() {
        try {
            byte BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
            short s = 0;
            if ((BuiltInFictitiousFunctionClassFactory == 0 ? '.' : 'M') != '.') {
                s = DatabaseTableConfigUtil();
                int i = isLayoutRequested + 53;
                newProxyInstance = i % 128;
                int i2 = i % 2;
            } else {
                int i3 = newProxyInstance + 21;
                isLayoutRequested = i3 % 128;
                if (i3 % 2 == 0) {
                }
            }
            return new em("", BuiltInFictitiousFunctionClassFactory, s);
        } catch (Exception e) {
            throw e;
        }
    }

    public final void PlaceComponentResult(int i) {
        int i2 = newProxyInstance + 79;
        isLayoutRequested = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 25 : JSONLexer.EOI) != 26) {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                this.BuiltInFictitiousFunctionClassFactory = true;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.BuiltInFictitiousFunctionClassFactory = true;
        }
        int i3 = newProxyInstance + 45;
        isLayoutRequested = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.xiaomi.push.ep
    public final void PlaceComponentResult(em emVar) {
        try {
            int i = isLayoutRequested + 55;
            try {
                newProxyInstance = i % 128;
                if (!(i % 2 != 0)) {
                    PlaceComponentResult(emVar.BuiltInFictitiousFunctionClassFactory);
                    BuiltInFictitiousFunctionClassFactory(emVar.MyBillsEntityDataFactory);
                    return;
                }
                PlaceComponentResult(emVar.BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory(emVar.MyBillsEntityDataFactory);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if ((r5.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() >= 4 ? 'V' : '^') != 'V') goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        PlaceComponentResult(r5.DatabaseTableConfigUtil, 4);
        r2 = com.xiaomi.push.el.newProxyInstance + 105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        r0 = r5.PlaceComponentResult.getAuthRequestContext();
        r1 = r5.PlaceComponentResult.PlaceComponentResult();
        r5.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(4);
        r2 = com.xiaomi.push.el.newProxyInstance + 69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if ((r5.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() >= 4) != true) goto L16;
     */
    @Override // com.xiaomi.push.ep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getAuthRequestContext() {
        /*
            r5 = this;
            int r0 = com.xiaomi.push.el.isLayoutRequested     // Catch: java.lang.Exception -> L78
            int r0 = r0 + 77
            int r1 = r0 % 128
            com.xiaomi.push.el.newProxyInstance = r1     // Catch: java.lang.Exception -> L78
            int r0 = r0 % 2
            r1 = 0
            r2 = 4
            if (r0 == 0) goto L1f
            byte[] r0 = r5.DatabaseTableConfigUtil
            com.xiaomi.push.ey r3 = r5.PlaceComponentResult
            int r3 = r3.BuiltInFictitiousFunctionClassFactory()
            r4 = 1
            if (r3 < r2) goto L1b
            r3 = 1
            goto L1c
        L1b:
            r3 = 0
        L1c:
            if (r3 == r4) goto L42
            goto L32
        L1f:
            byte[] r0 = r5.DatabaseTableConfigUtil
            com.xiaomi.push.ey r3 = r5.PlaceComponentResult
            int r3 = r3.BuiltInFictitiousFunctionClassFactory()
            r4 = 86
            if (r3 < r2) goto L2e
            r3 = 86
            goto L30
        L2e:
            r3 = 94
        L30:
            if (r3 == r4) goto L42
        L32:
            byte[] r3 = r5.DatabaseTableConfigUtil
            r5.PlaceComponentResult(r3, r2)
            int r2 = com.xiaomi.push.el.newProxyInstance
            int r2 = r2 + 105
        L3b:
            int r3 = r2 % 128
            com.xiaomi.push.el.isLayoutRequested = r3
            int r2 = r2 % 2
            goto L58
        L42:
            com.xiaomi.push.ey r0 = r5.PlaceComponentResult
            byte[] r0 = r0.getAuthRequestContext()
            com.xiaomi.push.ey r1 = r5.PlaceComponentResult
            int r1 = r1.PlaceComponentResult()
            com.xiaomi.push.ey r3 = r5.PlaceComponentResult
            r3.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            int r2 = com.xiaomi.push.el.newProxyInstance
            int r2 = r2 + 69
            goto L3b
        L58:
            r2 = r0[r1]
            int r3 = r1 + 1
            r3 = r0[r3]
            int r4 = r1 + 2
            r4 = r0[r4]
            int r1 = r1 + 3
            r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = r2 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 24
            r2 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 16
            r1 = r1 | r2
            r2 = r4 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r1 = r1 | r2
            r0 = r0 | r1
            return r0
        L78:
            r0 = move-exception
            goto L7b
        L7a:
            throw r0
        L7b:
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.el.getAuthRequestContext():int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r3.BuiltInFictitiousFunctionClassFactory != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if ((!r3.BuiltInFictitiousFunctionClassFactory) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2 - r4;
        r3.KClassImpl$Data$declaredNonStaticMembers$2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (r0 < 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Message length exceeded: ");
        r0.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
    
        throw new com.xiaomi.push.ej(r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(int r4) {
        /*
            r3 = this;
            int r0 = com.xiaomi.push.el.newProxyInstance
            int r0 = r0 + 97
            int r1 = r0 % 128
            com.xiaomi.push.el.isLayoutRequested = r1
            int r0 = r0 % 2
            r0 = 80
            if (r4 < 0) goto L11
            r1 = 80
            goto L13
        L11:
            r1 = 69
        L13:
            if (r1 != r0) goto L70
            int r0 = com.xiaomi.push.el.isLayoutRequested
            int r0 = r0 + 7
            int r1 = r0 % 128
            com.xiaomi.push.el.newProxyInstance = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L2c
            boolean r0 = r3.BuiltInFictitiousFunctionClassFactory
            r2 = 51
            int r2 = r2 / r1
            if (r0 == 0) goto L3d
            goto L36
        L2a:
            r4 = move-exception
            throw r4
        L2c:
            boolean r0 = r3.BuiltInFictitiousFunctionClassFactory
            if (r0 == 0) goto L32
            r0 = 0
            goto L33
        L32:
            r0 = 1
        L33:
            if (r0 == 0) goto L36
            goto L3d
        L36:
            int r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 - r4
            r3.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            if (r0 < 0) goto L59
        L3d:
            int r4 = com.xiaomi.push.el.isLayoutRequested     // Catch: java.lang.Exception -> L87
            int r4 = r4 + 23
            int r0 = r4 % 128
            com.xiaomi.push.el.newProxyInstance = r0
            int r4 = r4 % 2
            r0 = 33
            if (r4 == 0) goto L4e
            r4 = 96
            goto L50
        L4e:
            r4 = 33
        L50:
            if (r4 == r0) goto L58
            r4 = 68
            int r4 = r4 / r1
            return
        L56:
            r4 = move-exception
            throw r4
        L58:
            return
        L59:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Message length exceeded: "
            r0.append(r1)
            r0.append(r4)
            com.xiaomi.push.ej r4 = new com.xiaomi.push.ej
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L70:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Negative length: "
            r0.append(r1)     // Catch: java.lang.Exception -> L87
            r0.append(r4)     // Catch: java.lang.Exception -> L87
            com.xiaomi.push.ej r4 = new com.xiaomi.push.ej     // Catch: java.lang.Exception -> L87
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L87
            r4.<init>(r0)     // Catch: java.lang.Exception -> L87
            throw r4     // Catch: java.lang.Exception -> L87
        L87:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.el.getAuthRequestContext(int):void");
    }

    @Override // com.xiaomi.push.ep
    public final void getAuthRequestContext(eo eoVar) {
        int i = isLayoutRequested + 83;
        newProxyInstance = i % 128;
        if (i % 2 == 0) {
            PlaceComponentResult(eoVar.MyBillsEntityDataFactory);
            PlaceComponentResult(eoVar.BuiltInFictitiousFunctionClassFactory);
            MyBillsEntityDataFactory(eoVar.PlaceComponentResult);
            return;
        }
        PlaceComponentResult(eoVar.MyBillsEntityDataFactory);
        PlaceComponentResult(eoVar.BuiltInFictitiousFunctionClassFactory);
        MyBillsEntityDataFactory(eoVar.PlaceComponentResult);
        int i2 = 81 / 0;
    }

    @Override // com.xiaomi.push.ep
    public final void getAuthRequestContext(boolean z) {
        int i = newProxyInstance + 7;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        PlaceComponentResult(z ? (byte) 1 : (byte) 0);
        int i3 = newProxyInstance + 33;
        isLayoutRequested = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r11.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() >= r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        r4 = r11.PlaceComponentResult.getAuthRequestContext();
        r5 = r11.PlaceComponentResult.PlaceComponentResult();
        r1 = new java.lang.Object[1];
        a(new int[]{0, 5, 0, 3}, false, new byte[]{0, 1, 1, 1, 1}, r1);
        r2 = new java.lang.String(r4, r5, r0, ((java.lang.String) r1[0]).intern());
        r11.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0077, code lost:
    
        throw new com.xiaomi.push.ej("JVM DOES NOT SUPPORT UTF-8");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0078, code lost:
    
        r0 = KClassImpl$Data$declaredNonStaticMembers$2(r0);
        r2 = com.xiaomi.push.el.isLayoutRequested + 93;
        com.xiaomi.push.el.newProxyInstance = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0085, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (r11.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() >= r0) goto L24;
     */
    @Override // com.xiaomi.push.ep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getErrorConfigVersion() {
        /*
            r11 = this;
            int r0 = com.xiaomi.push.el.isLayoutRequested
            int r0 = r0 + 121
            int r1 = r0 % 128
            com.xiaomi.push.el.newProxyInstance = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 82
            if (r0 == 0) goto L11
            r0 = 82
            goto L13
        L11:
            r0 = 86
        L13:
            r3 = 0
            if (r0 == r2) goto L23
            int r0 = r11.getAuthRequestContext()
            com.xiaomi.push.ey r2 = r11.PlaceComponentResult
            int r2 = r2.BuiltInFictitiousFunctionClassFactory()
            if (r2 < r0) goto L78
            goto L32
        L23:
            int r0 = r11.getAuthRequestContext()
            com.xiaomi.push.ey r2 = r11.PlaceComponentResult
            int r2 = r2.BuiltInFictitiousFunctionClassFactory()
            r4 = 53
            int r4 = r4 / r3
            if (r2 < r0) goto L78
        L32:
            java.lang.String r2 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L70
            com.xiaomi.push.ey r4 = r11.PlaceComponentResult     // Catch: java.io.UnsupportedEncodingException -> L70
            byte[] r4 = r4.getAuthRequestContext()     // Catch: java.io.UnsupportedEncodingException -> L70
            com.xiaomi.push.ey r5 = r11.PlaceComponentResult     // Catch: java.io.UnsupportedEncodingException -> L70
            int r5 = r5.PlaceComponentResult()     // Catch: java.io.UnsupportedEncodingException -> L70
            r6 = 4
            int[] r7 = new int[r6]     // Catch: java.io.UnsupportedEncodingException -> L70
            r7[r3] = r3     // Catch: java.io.UnsupportedEncodingException -> L70
            r8 = 5
            r9 = 1
            r7[r9] = r8     // Catch: java.io.UnsupportedEncodingException -> L70
            r7[r1] = r3     // Catch: java.io.UnsupportedEncodingException -> L70
            r10 = 3
            r7[r10] = r10     // Catch: java.io.UnsupportedEncodingException -> L70
            byte[] r8 = new byte[r8]     // Catch: java.io.UnsupportedEncodingException -> L70
            r8[r3] = r3     // Catch: java.io.UnsupportedEncodingException -> L70
            r8[r9] = r9     // Catch: java.io.UnsupportedEncodingException -> L70
            r8[r1] = r9     // Catch: java.io.UnsupportedEncodingException -> L70
            r8[r10] = r9     // Catch: java.io.UnsupportedEncodingException -> L70
            r8[r6] = r9     // Catch: java.io.UnsupportedEncodingException -> L70
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch: java.io.UnsupportedEncodingException -> L70
            a(r7, r3, r8, r1)     // Catch: java.io.UnsupportedEncodingException -> L70
            r1 = r1[r3]     // Catch: java.io.UnsupportedEncodingException -> L70
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.io.UnsupportedEncodingException -> L70
            java.lang.String r1 = r1.intern()     // Catch: java.io.UnsupportedEncodingException -> L70
            r2.<init>(r4, r5, r0, r1)     // Catch: java.io.UnsupportedEncodingException -> L70
            com.xiaomi.push.ey r1 = r11.PlaceComponentResult     // Catch: java.io.UnsupportedEncodingException -> L70
            r1.KClassImpl$Data$declaredNonStaticMembers$2(r0)     // Catch: java.io.UnsupportedEncodingException -> L70
            return r2
        L70:
            com.xiaomi.push.ej r0 = new com.xiaomi.push.ej
            java.lang.String r1 = "JVM DOES NOT SUPPORT UTF-8"
            r0.<init>(r1)
            throw r0
        L78:
            java.lang.String r0 = r11.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            int r2 = com.xiaomi.push.el.isLayoutRequested
            int r2 = r2 + 93
            int r3 = r2 % 128
            com.xiaomi.push.el.newProxyInstance = r3
            int r2 = r2 % r1
            return r0
        L86:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.el.getErrorConfigVersion():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if ((r3.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() >= r0 ? '-' : '1') != '-') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r3.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() >= r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r1 = java.nio.ByteBuffer.wrap(r3.PlaceComponentResult.getAuthRequestContext(), r3.PlaceComponentResult.PlaceComponentResult(), r0);
        r3.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(r0);
        r0 = com.xiaomi.push.el.isLayoutRequested + 15;
        com.xiaomi.push.el.newProxyInstance = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        r1 = new byte[r0];
        r3.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(r1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        return java.nio.ByteBuffer.wrap(r1);
     */
    @Override // com.xiaomi.push.ep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.nio.ByteBuffer lookAheadTest() {
        /*
            r3 = this;
            int r0 = com.xiaomi.push.el.isLayoutRequested
            int r0 = r0 + 61
            int r1 = r0 % 128
            com.xiaomi.push.el.newProxyInstance = r1
            int r0 = r0 % 2
            r1 = 81
            if (r0 == 0) goto L11
            r0 = 81
            goto L13
        L11:
            r0 = 39
        L13:
            if (r0 == r1) goto L30
            int r0 = r3.getAuthRequestContext()     // Catch: java.lang.Exception -> L2e
            r3.getAuthRequestContext(r0)     // Catch: java.lang.Exception -> L2e
            com.xiaomi.push.ey r1 = r3.PlaceComponentResult     // Catch: java.lang.Exception -> L2e
            int r1 = r1.BuiltInFictitiousFunctionClassFactory()     // Catch: java.lang.Exception -> L2e
            r2 = 45
            if (r1 < r0) goto L29
            r1 = 45
            goto L2b
        L29:
            r1 = 49
        L2b:
            if (r1 == r2) goto L43
            goto L63
        L2e:
            r0 = move-exception
            throw r0
        L30:
            int r0 = r3.getAuthRequestContext()
            r3.getAuthRequestContext(r0)
            com.xiaomi.push.ey r1 = r3.PlaceComponentResult
            int r1 = r1.BuiltInFictitiousFunctionClassFactory()
            r2 = 37
            int r2 = r2 / 0
            if (r1 < r0) goto L63
        L43:
            com.xiaomi.push.ey r1 = r3.PlaceComponentResult
            byte[] r1 = r1.getAuthRequestContext()
            com.xiaomi.push.ey r2 = r3.PlaceComponentResult
            int r2 = r2.PlaceComponentResult()
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1, r2, r0)
            com.xiaomi.push.ey r2 = r3.PlaceComponentResult
            r2.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            int r0 = com.xiaomi.push.el.isLayoutRequested
            int r0 = r0 + 15
            int r2 = r0 % 128
            com.xiaomi.push.el.newProxyInstance = r2
            int r0 = r0 % 2
            return r1
        L63:
            byte[] r1 = new byte[r0]
            com.xiaomi.push.ey r2 = r3.PlaceComponentResult
            r2.BuiltInFictitiousFunctionClassFactory(r1, r0)
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r1)
            return r0
        L6f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.el.lookAheadTest():java.nio.ByteBuffer");
    }

    @Override // com.xiaomi.push.ep
    public eo moveToNextValue() {
        eo eoVar = new eo(BuiltInFictitiousFunctionClassFactory(), BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext());
        int i = newProxyInstance + 27;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        return eoVar;
    }

    @Override // com.xiaomi.push.ep
    public et scheduleImpl() {
        et etVar = new et(BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext());
        try {
            int i = isLayoutRequested + 91;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            return etVar;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        try {
            char[] cArr = NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (cArr != null) {
                int i5 = $10 + 31;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                int length = cArr.length;
                char[] cArr2 = new char[length];
                for (int i7 = 0; i7 < length; i7++) {
                    cArr2[i7] = (char) (cArr[i7] ^ 5097613533456403102L);
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr, i, cArr3, 0, i2);
            if (bArr != null) {
                char[] cArr4 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (true) {
                    if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2 ? (char) 28 : (char) 18) != 28) {
                        break;
                    }
                    if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? 'V' : 'E') != 'E') {
                        int i8 = $10 + 93;
                        $11 = i8 % 128;
                        if ((i8 % 2 == 0 ? (char) 18 : (char) 31) != 18) {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                        } else {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] << 2) % 0) * c);
                        }
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            }
            if (i4 > 0) {
                char[] cArr5 = new char[i2];
                System.arraycopy(cArr3, 0, cArr5, 0, i2);
                int i9 = i2 - i4;
                System.arraycopy(cArr5, 0, cArr3, i9, i4);
                System.arraycopy(cArr5, i4, cArr3, 0, i9);
            }
            if ((z ? 'S' : ':') == 'S') {
                char[] cArr6 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if (!(i3 <= 0)) {
                int i10 = $10 + 119;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    try {
                        int i12 = $10 + 19;
                        $11 = i12 % 128;
                        int i13 = i12 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            objArr[0] = new String(cArr3);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
