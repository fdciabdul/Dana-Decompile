package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* loaded from: classes7.dex */
public final class zzef extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;
    public static final byte[] getAuthRequestContext = {40, 6, -7, -65, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 49;

    public zzef(zzfy zzfyVar, long j) {
        super(zzfyVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0025 -> B:23:0x002b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r6 = com.google.android.gms.measurement.internal.zzef.getAuthRequestContext
            r7 = 23
            byte[] r7 = new byte[r7]
            r8 = 22
            r0 = 97
            r1 = 0
            r2 = 3
            if (r6 != 0) goto L13
            r2 = 22
            r3 = 3
            r4 = 0
            goto L2b
        L13:
            r3 = 0
        L14:
            int r2 = r2 + 1
            byte r4 = (byte) r0
            r7[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r7, r1)
            r9[r1] = r6
            return
        L25:
            r3 = r6[r2]
            r5 = r2
            r2 = r0
            r0 = r3
            r3 = r5
        L2b:
            int r0 = -r0
            int r2 = r2 + r0
            int r0 = r2 + (-8)
            r2 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzef.a(short, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(1:3)(6:65|66|(1:68)(2:83|(1:85))|69|70|(20:72|(1:74)(1:81)|76|77|5|(1:64)(1:9)|10|11|13|(1:15)|16|17|(1:19)|20|(3:22|(1:24)(1:26)|25)|(3:28|(1:30)(1:33)|31)|34|(3:36|(1:38)(3:45|(3:48|(1:50)(1:51)|46)|52)|(2:40|41)(2:43|44))|53|(0)(0)))|4|5|(1:7)|64|10|11|13|(0)|16|17|(0)|20|(0)|(0)|34|(0)|53|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01db, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x01dc, code lost:
    
        r11.zzs.zzay().zzd().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzeo.zzn(r0), r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0194 A[Catch: IllegalStateException -> 0x01db, TryCatch #2 {IllegalStateException -> 0x01db, blocks: (B:140:0x0173, B:143:0x018c, B:145:0x0194, B:149:0x01b2, B:148:0x01ae, B:151:0x01bc, B:153:0x01d0, B:155:0x01d5, B:154:0x01d3), top: B:181:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bc A[Catch: IllegalStateException -> 0x01db, TryCatch #2 {IllegalStateException -> 0x01db, blocks: (B:140:0x0173, B:143:0x018c, B:145:0x0194, B:149:0x01b2, B:148:0x01ae, B:151:0x01bc, B:153:0x01d0, B:155:0x01d5, B:154:0x01d3), top: B:181:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x024c  */
    @Override // com.google.android.gms.measurement.internal.zzf
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzd() {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzef.zzd():void");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return true;
    }

    public final int zzh() {
        zza();
        return this.zzj;
    }

    public final int zzi() {
        zza();
        return this.zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzq zzj(java.lang.String r38) {
        /*
            Method dump skipped, instructions count: 691
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzef.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzq");
    }

    public final String zzk() {
        zza();
        return this.zzl;
    }

    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    public final List zzn() {
        return this.zzh;
    }

    public final void zzo() {
        String format;
        zzg();
        if (!this.zzs.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
            this.zzs.zzay().zzc().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            this.zzs.zzv().zzG().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzem zzc = this.zzs.zzay().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = format == null ? "null" : "not null";
        zzc.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = format;
        this.zzn = this.zzs.zzav().currentTimeMillis();
    }

    public final boolean zzp(String str) {
        String str2 = this.zzo;
        boolean z = (str2 == null || str2.equals(str)) ? false : true;
        this.zzo = str;
        return z;
    }
}
