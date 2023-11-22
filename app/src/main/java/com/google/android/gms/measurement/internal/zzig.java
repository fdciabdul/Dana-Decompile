package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* loaded from: classes7.dex */
public final class zzig implements Runnable {
    final /* synthetic */ zzih zza;
    private final URL zzb;
    private final String zzc;
    private final zzfw zzd;

    public zzig(zzih zzihVar, String str, URL url, byte[] bArr, Map map, zzfw zzfwVar, byte[] bArr2) {
        this.zza = zzihVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfwVar);
        this.zzb = url;
        this.zzd = zzfwVar;
        this.zzc = str;
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map map) {
        this.zza.zzs.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzif
            @Override // java.lang.Runnable
            public final void run() {
                zzig.this.zza(i, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00a1  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzih r0 = r10.zza
            r0.zzax()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzih r2 = r10.zza     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            java.net.URL r3 = r10.zzb     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            java.net.URLConnection r3 = com.fullstory.instrumentation.InstrumentInjector.urlconnection_wrapInstance(r3)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            boolean r4 = r3 instanceof java.net.HttpURLConnection     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            if (r4 == 0) goto L88
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            r3.setDefaultUseCaches(r0)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            com.google.android.gms.measurement.internal.zzfy r4 = r2.zzs     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            r4.zzf()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            r4 = 60000(0xea60, float:8.4078E-41)
            r3.setConnectTimeout(r4)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            r2.zzf()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            r2 = 61000(0xee48, float:8.5479E-41)
            r3.setReadTimeout(r2)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            r3.setInstanceFollowRedirects(r0)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            r2 = 1
            r3.setDoInput(r2)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            int r2 = r3.getResponseCode()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86
            java.util.Map r4 = r3.getHeaderFields()     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7e
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L6c
            r5.<init>()     // Catch: java.lang.Throwable -> L6c
            java.io.InputStream r6 = r3.getInputStream()     // Catch: java.lang.Throwable -> L6c
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L6a
        L4e:
            int r8 = r6.read(r7)     // Catch: java.lang.Throwable -> L6a
            if (r8 <= 0) goto L58
            r5.write(r7, r0, r8)     // Catch: java.lang.Throwable -> L6a
            goto L4e
        L58:
            byte[] r0 = r5.toByteArray()     // Catch: java.lang.Throwable -> L6a
            if (r6 == 0) goto L61
            r6.close()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
        L61:
            if (r3 == 0) goto L66
            r3.disconnect()
        L66:
            r10.zzb(r2, r1, r0, r4)
            return
        L6a:
            r0 = move-exception
            goto L6e
        L6c:
            r0 = move-exception
            r6 = r1
        L6e:
            if (r6 == 0) goto L73
            r6.close()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
        L73:
            throw r0     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
        L74:
            r0 = move-exception
            goto L7a
        L76:
            r0 = move-exception
            goto L80
        L78:
            r0 = move-exception
            r4 = r1
        L7a:
            r9 = r2
            r2 = r0
            r0 = r9
            goto L93
        L7e:
            r0 = move-exception
            r4 = r1
        L80:
            r9 = r2
            r2 = r0
            r0 = r9
            goto L9f
        L84:
            r2 = move-exception
            goto L92
        L86:
            r2 = move-exception
            goto L9e
        L88:
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            java.lang.String r3 = "Failed to obtain HTTP connection"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
            throw r2     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9c
        L90:
            r2 = move-exception
            r3 = r1
        L92:
            r4 = r1
        L93:
            if (r3 == 0) goto L98
            r3.disconnect()
        L98:
            r10.zzb(r0, r1, r1, r4)
            throw r2
        L9c:
            r2 = move-exception
            r3 = r1
        L9e:
            r4 = r1
        L9f:
            if (r3 == 0) goto La4
            r3.disconnect()
        La4:
            r10.zzb(r0, r2, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzig.run():void");
    }

    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        zzfw zzfwVar = this.zzd;
        zzfwVar.zza.zzC(this.zzc, i, exc, bArr, map);
    }
}
