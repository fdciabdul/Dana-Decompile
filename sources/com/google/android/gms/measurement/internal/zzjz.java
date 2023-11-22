package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes7.dex */
public final class zzjz {
    private final Context zza;

    public zzjz(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    private final zzeo zzk() {
        return zzfy.zzp(this.zza, null, null).zzay();
    }

    public final int zza(final Intent intent, int i, final int i2) {
        zzfy zzp = zzfy.zzp(this.zza, null, null);
        final zzeo zzay = zzp.zzay();
        if (intent == null) {
            zzay.zzk().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzp.zzaw();
        zzay.zzj().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzh(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjw
                @Override // java.lang.Runnable
                public final void run() {
                    zzjz.this.zzc(i2, zzay, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder zzb(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgq(zzkz.zzt(this.zza), null);
        }
        zzk().zzk().zzb("onBind received unknown action", action);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(int i, zzeo zzeoVar, Intent intent) {
        if (((zzjy) this.zza).zzc(i)) {
            zzeoVar.zzj().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzk().zzj().zza("Completed wakeful intent.");
            ((zzjy) this.zza).zza(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzeo zzeoVar, JobParameters jobParameters) {
        zzeoVar.zzj().zza("AppMeasurementJobService processed last upload request.");
        ((zzjy) this.zza).zzb(jobParameters, false);
    }

    public final void zze() {
        zzfy zzp = zzfy.zzp(this.zza, null, null);
        zzeo zzay = zzp.zzay();
        zzp.zzaw();
        zzay.zzj().zza("Local AppMeasurementService is starting up");
    }

    public final void zzf() {
        zzfy zzp = zzfy.zzp(this.zza, null, null);
        zzeo zzay = zzp.zzay();
        zzp.zzaw();
        zzay.zzj().zza("Local AppMeasurementService is shutting down");
    }

    public final void zzg(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onRebind called with null intent");
            return;
        }
        zzk().zzj().zzb("onRebind called. action", intent.getAction());
    }

    public final void zzh(Runnable runnable) {
        zzkz zzt = zzkz.zzt(this.zza);
        zzt.zzaz().zzp(new zzjx(this, zzt, runnable));
    }

    public final boolean zzi(final JobParameters jobParameters) {
        zzfy zzp = zzfy.zzp(this.zza, null, null);
        final zzeo zzay = zzp.zzay();
        String string = jobParameters.getExtras().getString("action");
        zzp.zzaw();
        zzay.zzj().zzb("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            zzh(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjv
                @Override // java.lang.Runnable
                public final void run() {
                    zzjz.this.zzd(zzay, jobParameters);
                }
            });
            return true;
        }
        return true;
    }

    public final boolean zzj(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onUnbind called with null intent");
            return true;
        }
        zzk().zzj().zzb("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
