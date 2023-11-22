package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class AppUpdateInfo {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final Integer zze;
    private final int zzf;
    private final long zzg;
    private final long zzh;
    private final long zzi;
    private final long zzj;
    private final PendingIntent zzk;
    private final PendingIntent zzl;
    private final PendingIntent zzm;
    private final PendingIntent zzn;
    private final Map zzo;
    private boolean zzp = false;

    private AppUpdateInfo(String str, int i, int i2, int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = num;
        this.zzf = i4;
        this.zzg = j;
        this.zzh = j2;
        this.zzi = j3;
        this.zzj = j4;
        this.zzk = pendingIntent;
        this.zzl = pendingIntent2;
        this.zzm = pendingIntent3;
        this.zzn = pendingIntent4;
        this.zzo = map;
    }

    public static AppUpdateInfo zzb(String str, int i, int i2, int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        return new AppUpdateInfo(str, i, i2, i3, num, i4, j, j2, j3, j4, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    private static Set zze(Set set) {
        return set == null ? new HashSet() : set;
    }

    private final boolean zzf(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() && this.zzi <= this.zzj;
    }

    public int availableVersionCode() {
        return this.zzb;
    }

    public long bytesDownloaded() {
        return this.zzg;
    }

    public Integer clientVersionStalenessDays() {
        return this.zze;
    }

    public Set<Integer> getFailedUpdatePreconditions(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.allowAssetPackDeletion()) {
            if (appUpdateOptions.appUpdateType() == 0) {
                return zze((Set) this.zzo.get("nonblocking.destructive.intent"));
            }
            return zze((Set) this.zzo.get("blocking.destructive.intent"));
        } else if (appUpdateOptions.appUpdateType() == 0) {
            return zze((Set) this.zzo.get("nonblocking.intent"));
        } else {
            return zze((Set) this.zzo.get("blocking.intent"));
        }
    }

    public int installStatus() {
        return this.zzd;
    }

    public boolean isUpdateTypeAllowed(int i) {
        return zza(AppUpdateOptions.defaultOptions(i)) != null;
    }

    public String packageName() {
        return this.zza;
    }

    public long totalBytesToDownload() {
        return this.zzh;
    }

    public int updateAvailability() {
        return this.zzc;
    }

    public int updatePriority() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingIntent zza(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() == 0) {
            PendingIntent pendingIntent = this.zzl;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (zzf(appUpdateOptions)) {
                return this.zzn;
            }
            return null;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            PendingIntent pendingIntent2 = this.zzk;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (zzf(appUpdateOptions)) {
                return this.zzm;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        this.zzp = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd() {
        return this.zzp;
    }

    public boolean isUpdateTypeAllowed(AppUpdateOptions appUpdateOptions) {
        return zza(appUpdateOptions) != null;
    }
}
