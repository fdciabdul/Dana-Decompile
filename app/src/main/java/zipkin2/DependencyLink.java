package zipkin2;

import android.view.KeyEvent;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.nio.charset.Charset;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import zipkin2.codec.DependencyLinkBytesDecoder;
import zipkin2.codec.DependencyLinkBytesEncoder;

/* loaded from: classes9.dex */
public final class DependencyLink implements Serializable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static int[] PlaceComponentResult;
    static final Charset UTF_8;
    private static final long serialVersionUID = 0;
    final long callCount;
    final String child;
    final long errorCount;
    final String parent;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult = new int[]{-1317621594, -1625587034, 561446655, 588181094, 839240155, 215909167, -1815591613, 181973595, -1886040862, 32355093, -1242288296, 2051187177, 1923665956, 992559891, 297287742, -1322903886, -916419006, -2128001897};
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = new Object[1];
        a(KeyEvent.keyCodeFromString("") + 5, new int[]{-1152296454, 1390842764, 1766177811, -989021099}, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        int i = BuiltInFictitiousFunctionClassFactory + 7;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? (char) 17 : (char) 30) != 17) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static Builder newBuilder() {
        Builder builder = new Builder();
        int i = BuiltInFictitiousFunctionClassFactory + 79;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return builder;
        }
        return builder;
    }

    public final String parent() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 125;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            String str = this.parent;
            int i3 = MyBillsEntityDataFactory + 59;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String child() {
        int i = BuiltInFictitiousFunctionClassFactory + 83;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? '\r' : '6') == '\r') {
            int i2 = 28 / 0;
            return this.child;
        }
        try {
            return this.child;
        } catch (Exception e) {
            throw e;
        }
    }

    public final long callCount() {
        int i = MyBillsEntityDataFactory + 51;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 != 0)) {
            return this.callCount;
        }
        long j = this.callCount;
        Object obj = null;
        obj.hashCode();
        return j;
    }

    public final long errorCount() {
        int i = BuiltInFictitiousFunctionClassFactory + 21;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            return this.errorCount;
        }
        try {
            long j = this.errorCount;
            Object obj = null;
            obj.hashCode();
            return j;
        } catch (Exception e) {
            throw e;
        }
    }

    public final Builder toBuilder() {
        Builder builder = new Builder(this);
        int i = MyBillsEntityDataFactory + 85;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 == 0) {
            return builder;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return builder;
    }

    /* loaded from: classes9.dex */
    public static final class Builder {
        public long BuiltInFictitiousFunctionClassFactory;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;
        public long getAuthRequestContext;

        Builder() {
        }

        Builder(DependencyLink dependencyLink) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = dependencyLink.parent;
            this.MyBillsEntityDataFactory = dependencyLink.child;
            this.BuiltInFictitiousFunctionClassFactory = dependencyLink.callCount;
            this.getAuthRequestContext = dependencyLink.errorCount;
        }
    }

    public final String toString() {
        String str = new String(DependencyLinkBytesEncoder.JSON_V1.encode(this), UTF_8);
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 103;
            MyBillsEntityDataFactory = i % 128;
            if (!(i % 2 == 0)) {
                return str;
            }
            int i2 = 13 / 0;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public DependencyLink(Builder builder) {
        try {
            try {
                this.parent = builder.KClassImpl$Data$declaredNonStaticMembers$2;
                this.child = builder.MyBillsEntityDataFactory;
                this.callCount = builder.BuiltInFictitiousFunctionClassFactory;
                this.errorCount = builder.getAuthRequestContext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        if (r7.child.equals(r8.child) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r2 != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        if (r7.callCount != r8.callCount) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
    
        if (r7.errorCount == r8.errorCount) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
    
        if (r8 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            if (r8 != r7) goto L6
            r2 = 1
            goto L7
        L6:
            r2 = 0
        L7:
            if (r2 == 0) goto La
            return r1
        La:
            boolean r2 = r8 instanceof zipkin2.DependencyLink
            if (r2 != 0) goto L23
            int r8 = zipkin2.DependencyLink.MyBillsEntityDataFactory
            int r8 = r8 + 23
            int r1 = r8 % 128
            zipkin2.DependencyLink.BuiltInFictitiousFunctionClassFactory = r1
            int r8 = r8 % 2
            int r8 = zipkin2.DependencyLink.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 + 35
            int r1 = r8 % 128
            zipkin2.DependencyLink.MyBillsEntityDataFactory = r1
            int r8 = r8 % 2
            return r0
        L23:
            zipkin2.DependencyLink r8 = (zipkin2.DependencyLink) r8
            java.lang.String r2 = r7.parent
            java.lang.String r3 = r8.parent
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L7b
            int r2 = zipkin2.DependencyLink.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L79
            int r2 = r2 + 43
            int r3 = r2 % 128
            zipkin2.DependencyLink.MyBillsEntityDataFactory = r3     // Catch: java.lang.Exception -> L79
            int r2 = r2 % 2
            r3 = 11
            if (r2 != 0) goto L40
            r2 = 11
            goto L42
        L40:
            r2 = 73
        L42:
            if (r2 == r3) goto L51
            java.lang.String r2 = r7.child     // Catch: java.lang.Exception -> L4f
            java.lang.String r3 = r8.child     // Catch: java.lang.Exception -> L4f
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L4f
            if (r2 == 0) goto L7b
            goto L5f
        L4f:
            r8 = move-exception
            throw r8
        L51:
            java.lang.String r2 = r7.child
            java.lang.String r3 = r8.child
            boolean r2 = r2.equals(r3)
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L77
            if (r2 == 0) goto L7b
        L5f:
            long r2 = r7.callCount
            long r4 = r8.callCount
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L7b
            long r2 = r7.errorCount
            long r4 = r8.errorCount
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L71
            r8 = 1
            goto L72
        L71:
            r8 = 0
        L72:
            if (r8 == 0) goto L75
            goto L7b
        L75:
            r0 = 1
            goto L85
        L77:
            r8 = move-exception
            throw r8
        L79:
            r8 = move-exception
            throw r8
        L7b:
            int r8 = zipkin2.DependencyLink.MyBillsEntityDataFactory
            int r8 = r8 + 23
            int r1 = r8 % 128
            zipkin2.DependencyLink.BuiltInFictitiousFunctionClassFactory = r1
            int r8 = r8 % 2
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.DependencyLink.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = BuiltInFictitiousFunctionClassFactory + 15;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        int hashCode = this.parent.hashCode();
        int hashCode2 = this.child.hashCode();
        long j = this.callCount;
        long j2 = this.errorCount;
        int i3 = ((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
        int i4 = BuiltInFictitiousFunctionClassFactory + 1;
        MyBillsEntityDataFactory = i4 % 128;
        if ((i4 % 2 == 0 ? '6' : 'G') != '6') {
            return i3;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return i3;
    }

    final Object writeReplace() throws ObjectStreamException {
        try {
            SerializedForm serializedForm = new SerializedForm(DependencyLinkBytesEncoder.JSON_V1.encode(this));
            int i = MyBillsEntityDataFactory + 97;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 != 0)) {
                return serializedForm;
            }
            Object obj = null;
            obj.hashCode();
            return serializedForm;
        } catch (Exception e) {
            throw e;
        }
    }

    /* loaded from: classes9.dex */
    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        SerializedForm(byte[] bArr) {
            this.bytes = bArr;
        }

        final Object readResolve() throws ObjectStreamException {
            try {
                return DependencyLinkBytesDecoder.JSON_V1.decodeOne(this.bytes);
            } catch (IllegalArgumentException e) {
                throw new StreamCorruptedException(e.getMessage());
            }
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        int length;
        int[] iArr2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = PlaceComponentResult;
        if (iArr3 != null) {
            int i4 = $10 + 53;
            $11 = i4 % 128;
            if (i4 % 2 == 0) {
                length = iArr3.length;
                iArr2 = new int[length];
                i3 = 1;
            } else {
                length = iArr3.length;
                iArr2 = new int[length];
                i3 = 0;
            }
            while (true) {
                if ((i3 < length ? 'W' : '3') != 'W') {
                    break;
                }
                iArr2[i3] = (int) (iArr3[i3] ^ (-3152031022165484798L));
                i3++;
            }
            iArr3 = iArr2;
        }
        int length2 = iArr3.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = PlaceComponentResult;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i5 = 0;
            while (true) {
                if (i5 >= length3) {
                    break;
                }
                iArr6[i5] = (int) (iArr5[i5] ^ (-3152031022165484798L));
                i5++;
                length2 = length2;
            }
            i2 = length2;
            iArr5 = iArr6;
        } else {
            i2 = length2;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        int i6 = $10 + 19;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        while (true) {
            if (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory >= iArr.length) {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            int i8 = 0;
            while (true) {
                if (i8 >= 16) {
                    try {
                        break;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i9 = $11 + 83;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i8];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i11;
                i8++;
            }
            int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i14 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
    }
}
