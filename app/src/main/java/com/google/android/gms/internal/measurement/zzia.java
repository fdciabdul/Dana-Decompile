package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* loaded from: classes7.dex */
public abstract class zzia {
    public static final /* synthetic */ int zzc = 0;
    @Nullable
    private static volatile zzhy zze;
    private static volatile boolean zzf;
    final zzhx zza;
    final String zzb;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private final boolean zzm;
    private static final Object zzd = new Object();
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzic zzh = new zzic(new Object() { // from class: com.google.android.gms.internal.measurement.zzhs
    }, null);
    private static final AtomicInteger zzi = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzia(zzhx zzhxVar, String str, Object obj, boolean z, zzhz zzhzVar) {
        if (zzhxVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzhxVar;
        this.zzb = str;
        this.zzj = obj;
        this.zzm = true;
    }

    public static void zzd() {
        zzi.incrementAndGet();
    }

    public static void zze(final Context context) {
        if (zze == null) {
            Object obj = zzd;
            synchronized (obj) {
                if (zze == null) {
                    synchronized (obj) {
                        zzhy zzhyVar = zze;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzhyVar == null || zzhyVar.zza() != context) {
                            zzhe.zze();
                            zzib.zzc();
                            zzhm.zze();
                            zze = new zzhb(context, zzil.zza(new zzih() { // from class: com.google.android.gms.internal.measurement.zzhr
                                @Override // com.google.android.gms.internal.measurement.zzih
                                public final Object zza() {
                                    Context context2 = context;
                                    int i = zzia.zzc;
                                    return zzhn.zza(context2);
                                }
                            }));
                            zzi.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    abstract Object zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a1 A[Catch: all -> 0x00df, TryCatch #0 {, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0024, B:18:0x002d, B:20:0x003b, B:24:0x0064, B:26:0x006e, B:42:0x00a3, B:44:0x00b3, B:46:0x00c9, B:47:0x00cc, B:48:0x00d0, B:30:0x0077, B:32:0x007d, B:36:0x0093, B:38:0x0099, B:41:0x00a1, B:35:0x008f, B:22:0x0054, B:49:0x00d5, B:50:0x00dc, B:51:0x00dd), top: B:58:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzb() {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzia.zzb():java.lang.Object");
    }

    public final String zzc() {
        String str = this.zza.zzd;
        return this.zzb;
    }
}
