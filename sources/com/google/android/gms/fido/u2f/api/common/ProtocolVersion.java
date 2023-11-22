package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import java.io.UnsupportedEncodingException;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Deprecated
/* loaded from: classes7.dex */
public enum ProtocolVersion implements Parcelable {
    UNKNOWN("UNKNOWN"),
    V1("U2F_V1"),
    V2("U2F_V2");

    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final Parcelable.Creator<ProtocolVersion> CREATOR;
    private static int MyBillsEntityDataFactory = 1;
    private static int[] PlaceComponentResult;
    private final String zzb;

    /* loaded from: classes7.dex */
    public static class UnsupportedProtocolException extends Exception {
        public UnsupportedProtocolException(String str) {
            super(String.format("Protocol version %s not supported", str));
        }
    }

    static {
        PlaceComponentResult();
        CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.u2f.api.common.zzf
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                try {
                    return ProtocolVersion.fromString(parcel.readString());
                } catch (ProtocolVersion.UnsupportedProtocolException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object[] newArray(int i) {
                return new ProtocolVersion[i];
            }
        };
        int i = MyBillsEntityDataFactory + 37;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
    }

    ProtocolVersion(String str) {
        this.zzb = str;
    }

    static void PlaceComponentResult() {
        PlaceComponentResult = new int[]{929956267, 877568440, -2033513789, 1500023557, -375764972, 1440804457, -500688412, -2114806208, 1224901393, 1461416724, 777346789, -1734350384, 460990725, 1485522808, -1018726122, -386667171, -1300455297, 1974874161};
    }

    public static ProtocolVersion fromBytes(byte[] bArr) throws UnsupportedProtocolException {
        try {
            Object[] objArr = new Object[1];
            a(4 - TextUtils.lastIndexOf("", '0', 0, 0), new int[]{-1321170273, -1752434308, 1712839652, -468453759}, objArr);
            ProtocolVersion fromString = fromString(new String(bArr, ((String) objArr[0]).intern()));
            int i = BuiltInFictitiousFunctionClassFactory + 87;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return fromString;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
    
        if ((r5 != null) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        r0 = values();
        r2 = r0.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if (r1 >= r2) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        r3 = r0[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        if (r5.equals(r3.zzb) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        r5 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory + 27;
        com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        r1 = r1 + 1;
        r3 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory + 53;
        com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
    
        throw new com.google.android.gms.fido.u2f.api.common.ProtocolVersion.UnsupportedProtocolException(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        r5 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory + 25;
        com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if ((r5 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r1 == 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r5 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.UNKNOWN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        return com.google.android.gms.fido.u2f.api.common.ProtocolVersion.UNKNOWN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (r5 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.fido.u2f.api.common.ProtocolVersion fromString(java.lang.String r5) throws com.google.android.gms.fido.u2f.api.common.ProtocolVersion.UnsupportedProtocolException {
        /*
            int r0 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 11
            int r1 = r0 % 128
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L17
            if (r5 != 0) goto L21
            goto L50
        L17:
            r3.hashCode()     // Catch: java.lang.Throwable -> L6a
            if (r5 != 0) goto L1e
            r0 = 0
            goto L1f
        L1e:
            r0 = 1
        L1f:
            if (r0 == 0) goto L50
        L21:
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion[] r0 = valuesCustom()
            int r2 = r0.length
        L26:
            if (r1 >= r2) goto L4a
            r3 = r0[r1]
            java.lang.String r4 = r3.zzb
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L3d
            int r5 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory
            int r5 = r5 + 27
            int r0 = r5 % 128
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory = r0
            int r5 = r5 % 2
            return r3
        L3d:
            int r1 = r1 + 1
            int r3 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory
            int r3 = r3 + 53
            int r4 = r3 % 128
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory = r4
            int r3 = r3 % 2
            goto L26
        L4a:
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion$UnsupportedProtocolException r0 = new com.google.android.gms.fido.u2f.api.common.ProtocolVersion$UnsupportedProtocolException
            r0.<init>(r5)
            throw r0
        L50:
            int r5 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 25
            int r0 = r5 % 128
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory = r0
            int r5 = r5 % 2
            if (r5 != 0) goto L5d
            r1 = 1
        L5d:
            if (r1 == 0) goto L65
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion r5 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.UNKNOWN
            int r0 = r3.length     // Catch: java.lang.Throwable -> L63
            goto L67
        L63:
            r5 = move-exception
            throw r5
        L65:
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion r5 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.UNKNOWN     // Catch: java.lang.Exception -> L68
        L67:
            return r5
        L68:
            r5 = move-exception
            throw r5
        L6a:
            r5 = move-exception
            goto L6d
        L6c:
            throw r5
        L6d:
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.u2f.api.common.ProtocolVersion.fromString(java.lang.String):com.google.android.gms.fido.u2f.api.common.ProtocolVersion");
    }

    public static ProtocolVersion valueOf(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 105;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 == 0 ? '@' : (char) 21;
        ProtocolVersion protocolVersion = (ProtocolVersion) Enum.valueOf(ProtocolVersion.class, str);
        if (c != 21) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return protocolVersion;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ProtocolVersion[] valuesCustom() {
        int i = BuiltInFictitiousFunctionClassFactory + 77;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        ProtocolVersion[] protocolVersionArr = (ProtocolVersion[]) values().clone();
        int i3 = BuiltInFictitiousFunctionClassFactory + 51;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return protocolVersionArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        int i = BuiltInFictitiousFunctionClassFactory + 89;
        MyBillsEntityDataFactory = i % 128;
        int i2 = (i % 2 == 0 ? 'W' : 'V') != 'W' ? 0 : 1;
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 63;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return i2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        if ((!r5.equals(r0) ? 'I' : 'N') != 'N') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
    
        if ((r5.equals(r0)) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
    
        r5 = equals(r5);
        r0 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory + 21;
        com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isCompatible(com.google.android.gms.fido.u2f.api.common.ProtocolVersion r5) {
        /*
            r4 = this;
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion r0 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.UNKNOWN
            boolean r1 = r4.equals(r0)
            r2 = 69
            if (r1 != 0) goto Ld
            r1 = 69
            goto Lf
        Ld:
            r1 = 79
        Lf:
            r3 = 1
            if (r1 == r2) goto L13
            goto L44
        L13:
            int r1 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory
            int r1 = r1 + 5
            int r2 = r1 % 128
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory = r2
            int r1 = r1 % 2
            r2 = 0
            if (r1 == 0) goto L22
            r1 = 1
            goto L23
        L22:
            r1 = 0
        L23:
            if (r1 == 0) goto L3a
            boolean r0 = r5.equals(r0)
            r1 = 47
            int r1 = r1 / r2
            r1 = 78
            if (r0 != 0) goto L33
            r0 = 73
            goto L35
        L33:
            r0 = 78
        L35:
            if (r0 == r1) goto L44
            goto L4f
        L38:
            r5 = move-exception
            throw r5
        L3a:
            boolean r0 = r5.equals(r0)     // Catch: java.lang.Exception -> L5e
            if (r0 != 0) goto L41
            goto L42
        L41:
            r2 = 1
        L42:
            if (r2 == 0) goto L4f
        L44:
            int r5 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 37
            int r0 = r5 % 128
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory = r0
            int r5 = r5 % 2
            return r3
        L4f:
            boolean r5 = r4.equals(r5)
            int r0 = com.google.android.gms.fido.u2f.api.common.ProtocolVersion.MyBillsEntityDataFactory
            int r0 = r0 + 21
            int r1 = r0 % 128
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            return r5
        L5e:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.u2f.api.common.ProtocolVersion.isCompatible(com.google.android.gms.fido.u2f.api.common.ProtocolVersion):boolean");
    }

    @Override // java.lang.Enum
    public final String toString() {
        int i = BuiltInFictitiousFunctionClassFactory + 27;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            String str = this.zzb;
            int i3 = BuiltInFictitiousFunctionClassFactory + 39;
            MyBillsEntityDataFactory = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        try {
            int i2 = MyBillsEntityDataFactory + 99;
            try {
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                int i3 = i2 % 2;
                parcel.writeString(this.zzb);
                int i4 = MyBillsEntityDataFactory + 31;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                if (i4 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
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
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int i4 = 0;
            while (true) {
                if ((i4 < length2 ? '`' : '=') == '=') {
                    break;
                }
                int i5 = $10 + 15;
                $11 = i5 % 128;
                if (!(i5 % 2 != 0)) {
                    iArr4[i4] = (int) (iArr3[i4] % (-3152031022165484798L));
                    i4 %= 1;
                } else {
                    try {
                        iArr4[i4] = (int) (iArr3[i4] ^ (-3152031022165484798L));
                        i4++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i6 = $11 + 31;
                $10 = i6 % 128;
                int i7 = i6 % 2;
            }
            iArr3 = iArr4;
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = PlaceComponentResult;
        if (iArr6 != null) {
            int i8 = $10 + 105;
            $11 = i8 % 128;
            if (i8 % 2 == 0) {
                length = iArr6.length;
                iArr2 = new int[length];
                i3 = 1;
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
                i3 = 0;
            }
            while (i3 < length) {
                iArr2[i3] = (int) (iArr6[i3] ^ (-3152031022165484798L));
                i3++;
                length3 = length3;
            }
            iArr6 = iArr2;
            i2 = length3;
        } else {
            i2 = length3;
        }
        System.arraycopy(iArr6, 0, iArr5, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
            int i9 = 0;
            while (true) {
                if ((i9 < 16 ? '7' : (char) 17) != '7') {
                    break;
                }
                int i10 = $10 + 71;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[i9];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                i9++;
                int i13 = $10 + 83;
                $11 = i13 % 128;
                int i14 = i13 % 2;
            }
            int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr5[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[17];
            int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i17 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
