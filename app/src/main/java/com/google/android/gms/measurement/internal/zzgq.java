package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes7.dex */
public final class zzgq extends zzed {
    private final zzkz zza;
    private Boolean zzb;
    private String zzc;

    public zzgq(zzkz zzkzVar, String str) {
        Preconditions.checkNotNull(zzkzVar);
        this.zza = zzkzVar;
        this.zzc = null;
    }

    private final void zzA(zzaw zzawVar, zzq zzqVar) {
        this.zza.zzA();
        this.zza.zzE(zzawVar, zzqVar);
    }

    private final void zzy(zzq zzqVar, boolean z) {
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzz(zzqVar.zza, false);
        this.zza.zzv().zzX(zzqVar.zzb, zzqVar.zzq);
    }

    private final void zzz(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzau(), Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(this.zza.zzau()).isUidGoogleSigned(Binder.getCallingUid())) {
                            z2 = false;
                            this.zzb = Boolean.valueOf(z2);
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzay().zzd().zzb("Measurement Service called with invalid calling package. appId", zzeo.zzn(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzau(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (str.equals(this.zzc)) {
                return;
            }
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
        this.zza.zzay().zzd().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaw zzb(zzaw zzawVar, zzq zzqVar) {
        zzau zzauVar;
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzawVar.zza) && (zzauVar = zzawVar.zzb) != null && zzauVar.zza() != 0) {
            String zzg = zzawVar.zzb.zzg("_cis");
            if ("referrer broadcast".equals(zzg) || "referrer API".equals(zzg)) {
                this.zza.zzay().zzi().zzb("Event has been filtered ", zzawVar.toString());
                return new zzaw("_cmpx", zzawVar.zzb, zzawVar.zzc, zzawVar.zzd);
            }
        }
        return zzawVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final String zzd(zzq zzqVar) {
        zzy(zzqVar, false);
        return this.zza.zzx(zzqVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final List zze(zzq zzqVar, boolean z) {
        zzy(zzqVar, false);
        String str = zzqVar.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzle> list = (List) this.zza.zzaz().zzh(new zzgn(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzle zzleVar : list) {
                if (z || !zzlh.zzah(zzleVar.zzc)) {
                    arrayList.add(new zzlc(zzleVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzc("Failed to get user properties. appId", zzeo.zzn(zzqVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final List zzf(String str, String str2, zzq zzqVar) {
        zzy(zzqVar, false);
        String str3 = zzqVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzaz().zzh(new zzge(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzb("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final List zzg(String str, String str2, String str3) {
        zzz(str, true);
        try {
            return (List) this.zza.zzaz().zzh(new zzgf(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzb("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final List zzh(String str, String str2, boolean z, zzq zzqVar) {
        zzy(zzqVar, false);
        String str3 = zzqVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzle> list = (List) this.zza.zzaz().zzh(new zzgc(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzle zzleVar : list) {
                if (z || !zzlh.zzah(zzleVar.zzc)) {
                    arrayList.add(new zzlc(zzleVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzc("Failed to query user properties. appId", zzeo.zzn(zzqVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final List zzi(String str, String str2, String str3, boolean z) {
        zzz(str, true);
        try {
            List<zzle> list = (List) this.zza.zzaz().zzh(new zzgd(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzle zzleVar : list) {
                if (z || !zzlh.zzah(zzleVar.zzc)) {
                    arrayList.add(new zzlc(zzleVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzc("Failed to get user properties as. appId", zzeo.zzn(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzj(zzq zzqVar) {
        zzy(zzqVar, false);
        zzx(new zzgo(this, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzk(zzaw zzawVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzawVar);
        zzy(zzqVar, false);
        zzx(new zzgj(this, zzawVar, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzl(zzaw zzawVar, String str, String str2) {
        Preconditions.checkNotNull(zzawVar);
        Preconditions.checkNotEmpty(str);
        zzz(str, true);
        zzx(new zzgk(this, zzawVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzm(zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzz(zzqVar.zza, false);
        zzx(new zzgg(this, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzn(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        zzy(zzqVar, false);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.zza = zzqVar.zza;
        zzx(new zzga(this, zzacVar2, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzo(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zza);
        zzz(zzacVar.zza, true);
        zzx(new zzgb(this, new zzac(zzacVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzp(zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        Preconditions.checkNotNull(zzqVar.zzv);
        zzgi zzgiVar = new zzgi(this, zzqVar);
        Preconditions.checkNotNull(zzgiVar);
        if (this.zza.zzaz().zzs()) {
            zzgiVar.run();
        } else {
            this.zza.zzaz().zzq(zzgiVar);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzq(long j, String str, String str2, String str3) {
        zzx(new zzgp(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzr(final Bundle bundle, zzq zzqVar) {
        zzy(zzqVar, false);
        final String str = zzqVar.zza;
        Preconditions.checkNotNull(str);
        zzx(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzfz
            @Override // java.lang.Runnable
            public final void run() {
                zzgq.this.zzw(str, bundle);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzs(zzq zzqVar) {
        zzy(zzqVar, false);
        zzx(new zzgh(this, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final void zzt(zzlc zzlcVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzlcVar);
        zzy(zzqVar, false);
        zzx(new zzgm(this, zzlcVar, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzee
    public final byte[] zzu(zzaw zzawVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzawVar);
        zzz(str, true);
        this.zza.zzay().zzc().zzb("Log and bundle. event", this.zza.zzj().zzd(zzawVar.zza));
        long nanoTime = this.zza.zzav().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzaz().zzi(new zzgl(this, zzawVar, str)).get();
            if (bArr == null) {
                this.zza.zzay().zzd().zzb("Log and bundle returned null. appId", zzeo.zzn(str));
                bArr = new byte[0];
            }
            this.zza.zzay().zzc().zzd("Log and bundle processed. event, size, time_ms", this.zza.zzj().zzd(zzawVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzav().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzd("Failed to log and bundle. appId, event, error", zzeo.zzn(str), this.zza.zzj().zzd(zzawVar.zza), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv(zzaw zzawVar, zzq zzqVar) {
        if (!this.zza.zzo().zzo(zzqVar.zza)) {
            zzA(zzawVar, zzqVar);
            return;
        }
        this.zza.zzay().zzj().zzb("EES config found for", zzqVar.zza);
        zzfp zzo = this.zza.zzo();
        String str = zzqVar.zza;
        com.google.android.gms.internal.measurement.zzc zzcVar = TextUtils.isEmpty(str) ? null : (com.google.android.gms.internal.measurement.zzc) zzo.zzd.get(str);
        if (zzcVar == null) {
            this.zza.zzay().zzj().zzb("EES not loaded for", zzqVar.zza);
            zzA(zzawVar, zzqVar);
            return;
        }
        try {
            Map zzs = this.zza.zzu().zzs(zzawVar.zzb.zzc(), true);
            String zza = zzgv.zza(zzawVar.zza);
            if (zza == null) {
                zza = zzawVar.zza;
            }
            if (zzcVar.zze(new com.google.android.gms.internal.measurement.zzaa(zza, zzawVar.zzd, zzs))) {
                if (zzcVar.zzg()) {
                    this.zza.zzay().zzj().zzb("EES edited event", zzawVar.zza);
                    zzA(this.zza.zzu().zzi(zzcVar.zza().zzb()), zzqVar);
                } else {
                    zzA(zzawVar, zzqVar);
                }
                if (zzcVar.zzf()) {
                    for (com.google.android.gms.internal.measurement.zzaa zzaaVar : zzcVar.zza().zzc()) {
                        this.zza.zzay().zzj().zzb("EES logging created event", zzaaVar.zzd());
                        zzA(this.zza.zzu().zzi(zzaaVar), zzqVar);
                    }
                    return;
                }
                return;
            }
        } catch (com.google.android.gms.internal.measurement.zzd unused) {
            this.zza.zzay().zzd().zzc("EES error. appId, eventName", zzqVar.zzb, zzawVar.zza);
        }
        this.zza.zzay().zzj().zzb("EES was not applied to event", zzawVar.zza);
        zzA(zzawVar, zzqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(String str, Bundle bundle) {
        zzam zzi = this.zza.zzi();
        zzi.zzg();
        zzi.zzW();
        byte[] zzbv = zzi.zzf.zzu().zzj(new zzar(zzi.zzs, "", str, "dep", 0L, 0L, bundle)).zzbv();
        zzi.zzs.zzay().zzj().zzc("Saving default event parameters, appId, data size", zzi.zzs.zzj().zzd(str), Integer.valueOf(zzbv.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbv);
        try {
            if (zzi.zzh().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                zzi.zzs.zzay().zzd().zzb("Failed to insert default event parameters (got -1). appId", zzeo.zzn(str));
            }
        } catch (SQLiteException e) {
            zzi.zzs.zzay().zzd().zzc("Error storing default event parameters. appId", zzeo.zzn(str), e);
        }
    }

    final void zzx(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzaz().zzs()) {
            runnable.run();
        } else {
            this.zza.zzaz().zzp(runnable);
        }
    }
}
