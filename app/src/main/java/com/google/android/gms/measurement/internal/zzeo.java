package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes7.dex */
public final class zzeo extends zzgs {
    private char zza;
    private long zzb;
    private String zzc;
    private final zzem zzd;
    private final zzem zze;
    private final zzem zzf;
    private final zzem zzg;
    private final zzem zzh;
    private final zzem zzi;
    private final zzem zzj;
    private final zzem zzk;
    private final zzem zzl;
    public static final byte[] getAuthRequestContext = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
    public static final int BuiltInFictitiousFunctionClassFactory = 17;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeo(zzfy zzfyVar) {
        super(zzfyVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzem(this, 6, false, false);
        this.zze = new zzem(this, 6, true, false);
        this.zzf = new zzem(this, 6, false, true);
        this.zzg = new zzem(this, 5, false, false);
        this.zzh = new zzem(this, 5, true, false);
        this.zzi = new zzem(this, 5, false, true);
        this.zzj = new zzem(this, 4, false, false);
        this.zzk = new zzem(this, 3, false, false);
        this.zzl = new zzem(this, 2, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 26
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r7 = r7 + 103
            int r8 = r8 * 15
            int r8 = r8 + 12
            byte[] r0 = com.google.android.gms.measurement.internal.zzeo.getAuthRequestContext
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r7
            r3 = 0
            r7 = r6
            goto L31
        L19:
            r3 = 0
        L1a:
            r5 = r7
            r7 = r6
            r6 = r5
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r5
        L31:
            int r4 = -r4
            int r6 = r6 + 1
            int r7 = r7 + r4
            int r7 = r7 + 2
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeo.a(int, short, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzn(String str) {
        if (str == null) {
            return null;
        }
        return new zzen(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzo(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String zzp = zzp(z, obj);
        String zzp2 = zzp(z, obj2);
        String zzp3 = zzp(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zzp)) {
            sb.append(str2);
            sb.append(zzp);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(zzp2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(zzp2);
        }
        if (!TextUtils.isEmpty(zzp3)) {
            sb.append(str3);
            sb.append(zzp3);
        }
        return sb.toString();
    }

    static String zzp(boolean z, Object obj) {
        String str;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            String str2 = obj.toString().charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            return str2 + Math.round(Math.pow(10.0d, valueOf.length() - 1)) + "..." + str2 + Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
        } else if (obj instanceof Boolean) {
            return obj.toString();
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzy = zzy(zzfy.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod()) {
                        try {
                            byte b = getAuthRequestContext[16];
                            byte b2 = (byte) (b + 1);
                            Object[] objArr = new Object[1];
                            a(b, b2, b2, objArr);
                            Class<?> cls = Class.forName((String) objArr[0]);
                            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory & 7);
                            byte b4 = getAuthRequestContext[16];
                            Object[] objArr2 = new Object[1];
                            a(b3, b4, b4, objArr2);
                            String str3 = (String) cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null);
                            if (str3 != null && zzy(str3).equals(zzy)) {
                                sb.append(": ");
                                sb.append(stackTraceElement);
                                break;
                            }
                        } catch (Throwable th2) {
                            Throwable cause = th2.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th2;
                        }
                    }
                    i++;
                }
                return sb.toString();
            } else if (!(obj instanceof zzen)) {
                return z ? "-" : obj.toString();
            } else {
                str = ((zzen) obj).zza;
                return str;
            }
        }
    }

    private static String zzy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    public final zzem zzc() {
        return this.zzk;
    }

    public final zzem zzd() {
        return this.zzd;
    }

    public final zzem zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    protected final boolean zzf() {
        return false;
    }

    public final zzem zzh() {
        return this.zze;
    }

    public final zzem zzi() {
        return this.zzj;
    }

    public final zzem zzj() {
        return this.zzl;
    }

    public final zzem zzk() {
        return this.zzg;
    }

    public final zzem zzl() {
        return this.zzi;
    }

    public final zzem zzm() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String zzq() {
        String str;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzs.zzy() == null) {
                    this.zzc = this.zzs.zzf().zzn();
                } else {
                    this.zzc = this.zzs.zzy();
                }
            }
            Preconditions.checkNotNull(this.zzc);
            str = this.zzc;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzt(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(zzq(), i)) {
            Log.println(i, zzq(), zzo(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzfv zzo = this.zzs.zzo();
        if (zzo == null) {
            Log.println(6, zzq(), "Scheduler not set. Not logging error/warn");
        } else if (!zzo.zzx()) {
            Log.println(6, zzq(), "Scheduler not initialized. Not logging error/warn");
        } else {
            zzo.zzp(new zzel(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
        }
    }
}
