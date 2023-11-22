package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import androidx.core.content.PermissionChecker;
import com.fullstory.instrumentation.InstrumentInjector;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzhm implements zzhj {
    private static zzhm zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzhm() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzhm(Context context) {
        this.zzb = context;
        zzhl zzhlVar = new zzhl(this, null);
        this.zzc = zzhlVar;
        context.getContentResolver().registerContentObserver(zzgz.zza, true, zzhlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm zza(Context context) {
        zzhm zzhmVar;
        synchronized (zzhm.class) {
            if (zza == null) {
                zza = PermissionChecker.getAuthRequestContext(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzhm(context) : new zzhm();
            }
            zzhmVar = zza;
        }
        return zzhmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zze() {
        Context context;
        synchronized (zzhm.class) {
            zzhm zzhmVar = zza;
            if (zzhmVar != null && (context = zzhmVar.zzb) != null && zzhmVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhj
    @Nullable
    /* renamed from: zzc  reason: merged with bridge method [inline-methods] */
    public final String zzb(final String str) {
        Context context = this.zzb;
        if (context == null || zzha.zza(context)) {
            return null;
        }
        try {
            return (String) zzhh.zza(new zzhi() { // from class: com.google.android.gms.internal.measurement.zzhk
                @Override // com.google.android.gms.internal.measurement.zzhi
                public final Object zza() {
                    return zzhm.this.zzd(str);
                }
            });
        } catch (IllegalStateException | NullPointerException | SecurityException e) {
            InstrumentInjector.log_e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzgz.zza(this.zzb.getContentResolver(), str, null);
    }
}
