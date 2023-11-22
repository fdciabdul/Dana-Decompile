package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import android.widget.ExpandableListView;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import o.getCallingPid;

/* loaded from: classes7.dex */
public final class zzkm {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static char[] PlaceComponentResult;
    private static int getAuthRequestContext;
    static final Charset zza;
    static final Charset zzb;
    static final Charset zzc;
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzjh zzf;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 42070;
        PlaceComponentResult = new char[]{37275, 37346, 37367, 37253, 37252, 37257, 37274, 37254, 37255};
    }

    public static int zza(boolean z) {
        try {
            int i = MyBillsEntityDataFactory + 109;
            getAuthRequestContext = i % 128;
            if (!(i % 2 != 0)) {
                if (!(z ? false : true)) {
                    return 1231;
                }
            } else {
                int i2 = 78 / 0;
                if (z) {
                    return 1231;
                }
            }
            int i3 = getAuthRequestContext + 39;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return 1237;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int zzd2 = zzd(length, bArr, 0, length);
        if (!(zzd2 != 0)) {
            int i = getAuthRequestContext + 117;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            zzd2 = 1;
        }
        int i3 = getAuthRequestContext + 109;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return zzd2;
    }

    public static int zzc(long j) {
        int i = MyBillsEntityDataFactory + 17;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        int i3 = (int) (j ^ (j >>> 32));
        int i4 = MyBillsEntityDataFactory + 17;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            try {
                int i5 = getAuthRequestContext + 101;
                MyBillsEntityDataFactory = i5 % 128;
                if ((i5 % 2 == 0 ? (char) 28 : '\n') != '\n') {
                    i = (i % 42) % bArr[i4];
                    i4 += 26;
                } else {
                    i = (i * 31) + bArr[i4];
                    i4++;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i6 = MyBillsEntityDataFactory + 33;
        getAuthRequestContext = i6 % 128;
        if ((i6 % 2 != 0 ? (char) 14 : 'B') != 14) {
            return i;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zze(Object obj) {
        int i = getAuthRequestContext + 53;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        obj.getClass();
        int i3 = MyBillsEntityDataFactory + 101;
        getAuthRequestContext = i3 % 128;
        if (i3 % 2 == 0) {
            return obj;
        }
        int i4 = 48 / 0;
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if ((r2 != null ? '-' : '\'') == '-') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if (r2 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        r3 = com.google.android.gms.internal.measurement.zzkm.MyBillsEntityDataFactory + 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        com.google.android.gms.internal.measurement.zzkm.getAuthRequestContext = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        throw new java.lang.NullPointerException(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object zzf(java.lang.Object r2, java.lang.String r3) {
        /*
            int r0 = com.google.android.gms.internal.measurement.zzkm.getAuthRequestContext
            int r0 = r0 + 55
            int r1 = r0 % 128
            com.google.android.gms.internal.measurement.zzkm.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            if (r0 == r1) goto L1e
            r0 = 45
            if (r2 == 0) goto L19
            r1 = 45
            goto L1b
        L19:
            r1 = 39
        L1b:
            if (r1 != r0) goto L31
            goto L24
        L1e:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L31
        L24:
            int r3 = com.google.android.gms.internal.measurement.zzkm.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L2f
            int r3 = r3 + 5
            int r0 = r3 % 128
            com.google.android.gms.internal.measurement.zzkm.getAuthRequestContext = r0     // Catch: java.lang.Exception -> L2f
            int r3 = r3 % 2
            return r2
        L2f:
            r2 = move-exception
            throw r2
        L31:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            r2.<init>(r3)
            throw r2
        L37:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkm.zzf(java.lang.Object, java.lang.String):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzg(Object obj, Object obj2) {
        int i = getAuthRequestContext + 21;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        zzll zzaG = ((zzll) obj).zzbG().zzay((zzll) obj2).zzaG();
        int i3 = getAuthRequestContext + 73;
        MyBillsEntityDataFactory = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj3 = null;
            obj3.hashCode();
            return zzaG;
        }
        return zzaG;
    }

    public static String zzh(byte[] bArr) {
        try {
            String str = new String(bArr, zzb);
            int i = getAuthRequestContext + 53;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean zzi(byte[] bArr) {
        int i = getAuthRequestContext + 7;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 == 0 ? 'T' : 'Y';
        boolean zze2 = zznc.zze(bArr);
        if (c != 'Y') {
            int i2 = 49 / 0;
        }
        return zze2;
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        zza = Charset.forName("US-ASCII");
        Object[] objArr = new Object[1];
        a(new char[]{0, 3, 4, 2, 13840}, (byte) (ExpandableListView.getPackedPositionGroup(0L) + 110), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 6, objArr);
        zzb = Charset.forName(((String) objArr[0]).intern());
        zzc = Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzjh.zza;
        zzjf zzjfVar = new zzjf(bArr, 0, 0, false, null);
        try {
            zzjfVar.zza(0);
            zzf = zzjfVar;
            int i2 = getAuthRequestContext + 93;
            MyBillsEntityDataFactory = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return;
            }
            Object[] objArr2 = null;
            int length = objArr2.length;
        } catch (zzko e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = PlaceComponentResult;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (true) {
                if (!(i3 < length)) {
                    break;
                }
                try {
                    cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                    i3++;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i4 = $10 + 71;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ KClassImpl$Data$declaredNonStaticMembers$2);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory != getcallingpid.PlaceComponentResult) {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                    } else {
                        if ((getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 ? 'W' : ':') != ':') {
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                        } else {
                            int i10 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i11 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i10];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i11];
                        }
                    }
                } else {
                    int i12 = $11 + 25;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        int i14 = 0;
        while (i14 < i) {
            int i15 = $10 + 27;
            $11 = i15 % 128;
            if (i15 % 2 == 0) {
                cArr4[i14] = (char) (cArr4[i14] & 18501);
                i14 += 98;
            } else {
                cArr4[i14] = (char) (cArr4[i14] ^ 13722);
                i14++;
            }
        }
        objArr[0] = new String(cArr4);
    }
}
