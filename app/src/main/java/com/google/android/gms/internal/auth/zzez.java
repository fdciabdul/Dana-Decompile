package com.google.android.gms.internal.auth;

import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import o.C;

/* loaded from: classes7.dex */
public final class zzez {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 0;
    private static int getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;
    static final Charset zza;
    static final Charset zzb;
    static final Charset zzc;
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzei zzf;

    static {
        BuiltInFictitiousFunctionClassFactory();
        zza = Charset.forName("US-ASCII");
        Object[] objArr = new Object[1];
        a(4 - TextUtils.lastIndexOf("", '0'), new char[]{42402, 35333, 4759, 41956, 36731, 12001}, objArr);
        zzb = Charset.forName(((String) objArr[0]).intern());
        zzc = Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzei.zza;
        zzeg zzegVar = new zzeg(bArr, 0, 0, false, null);
        try {
            zzegVar.zza(0);
            zzf = zzegVar;
            int i2 = getAuthRequestContext + 9;
            getErrorConfigVersion = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 20 : (char) 29) != 20) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (zzfa e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory = (char) 46017;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 40384;
        BuiltInFictitiousFunctionClassFactory = (char) 35406;
        PlaceComponentResult = (char) 31282;
    }

    public static int zza(boolean z) {
        try {
            int i = getErrorConfigVersion + 55;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            if ((z ? (char) 3 : '5') != 3) {
                return 1237;
            }
            int i3 = getAuthRequestContext + 117;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return 1231;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int zzc(long j) {
        try {
            int i = getAuthRequestContext + 103;
            getErrorConfigVersion = i % 128;
            int i2 = (int) (!(i % 2 == 0) ? j ^ (j >>> 32) : j / (j >>> 14));
            int i3 = getAuthRequestContext + 47;
            getErrorConfigVersion = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 30 : (char) 18) != 18) {
                Object obj = null;
                obj.hashCode();
                return i2;
            }
            return i2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, byte[] bArr, int i2, int i3) {
        try {
            int i4 = getErrorConfigVersion + 31;
            getAuthRequestContext = i4 % 128;
            if (i4 % 2 != 0) {
            }
            int i5 = 0;
            while (true) {
                if (!(i5 < i3)) {
                    int i6 = getErrorConfigVersion + 105;
                    getAuthRequestContext = i6 % 128;
                    int i7 = i6 % 2;
                    return i;
                }
                i = (i * 31) + bArr[i5];
                i5++;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zze(Object obj) {
        int i = getAuthRequestContext + 25;
        getErrorConfigVersion = i % 128;
        char c = i % 2 == 0 ? 'K' : 'R';
        obj.getClass();
        if (c != 'R') {
            int i2 = 4 / 0;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzf(Object obj, String str) {
        int i = getErrorConfigVersion + 65;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if ((obj != null ? (char) 16 : (char) 19) != 19) {
            int i3 = getAuthRequestContext + 9;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return obj;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzg(Object obj, Object obj2) {
        zzfw zzg;
        int i = getErrorConfigVersion + 9;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '4' : '.') != '4') {
            zzg = ((zzfw) obj).zzd().zzc((zzfw) obj2).zzg();
        } else {
            zzg = ((zzfw) obj).zzd().zzc((zzfw) obj2).zzg();
            int i2 = 35 / 0;
        }
        int i3 = getErrorConfigVersion + 45;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return zzg;
    }

    public static String zzh(byte[] bArr) {
        String str = new String(bArr, zzb);
        int i = getErrorConfigVersion + 29;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return str;
    }

    public static boolean zzi(byte[] bArr) {
        int i = getErrorConfigVersion + 13;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        boolean zzc2 = zzhm.zzc(bArr);
        int i3 = getErrorConfigVersion + 7;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return zzc2;
    }

    public static int zzb(byte[] bArr) {
        int i = getAuthRequestContext + 13;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? (char) 11 : 'C') != 'C') {
            int length = bArr.length;
            int zzd2 = zzd(length, bArr, 0, length);
            if ((zzd2 != 0 ? '-' : '^') == '-') {
                return zzd2;
            }
        } else {
            int length2 = bArr.length;
            int zzd3 = zzd(length2, bArr, 0, length2);
            if ((zzd3 != 0 ? Typography.amp : '^') == '&') {
                return zzd3;
            }
        }
        try {
            int i2 = getAuthRequestContext + 5;
            getErrorConfigVersion = i2 % 128;
            int i3 = i2 % 2;
            return 1;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if (c.BuiltInFictitiousFunctionClassFactory >= cArr.length) {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            int i2 = $10 + 117;
            $11 = i2 % 128;
            int i3 = 58224;
            if (i2 % 2 == 0) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory >>> 1];
            } else {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            }
            int i4 = 0;
            while (true) {
                if ((i4 < 16 ? 'P' : 'M') != 'P') {
                    break;
                }
                int i5 = $10 + 71;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i3) ^ ((cArr3[0] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i3) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                i3 -= 40503;
                i4++;
                int i7 = $11 + 117;
                $10 = i7 % 128;
                int i8 = i7 % 2;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
    }
}
