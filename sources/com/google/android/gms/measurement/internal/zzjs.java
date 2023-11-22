package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class zzjs extends zzf {
    private final zzjr zza;
    private zzee zzb;
    private volatile Boolean zzc;
    private final zzap zzd;
    private final zzkj zze;
    private final List zzf;
    private final zzap zzg;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjs(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzf = new ArrayList();
        this.zze = new zzkj(zzfyVar.zzav());
        this.zza = new zzjr(this);
        this.zzd = new zzjc(this, zzfyVar);
        this.zzg = new zzje(this, zzfyVar);
    }

    private final zzq zzO(boolean z) {
        String str;
        Pair zza;
        this.zzs.zzaw();
        zzef zzh = this.zzs.zzh();
        if (z) {
            zzeo zzay = this.zzs.zzay();
            if (zzay.zzs.zzm().zzb != null && (zza = zzay.zzs.zzm().zzb.zza()) != null && zza != zzfd.zza) {
                str = String.valueOf(zza.second) + ":" + ((String) zza.first);
                return zzh.zzj(str);
            }
        }
        str = null;
        return zzh.zzj(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzP() {
        zzg();
        this.zzs.zzay().zzj().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                this.zzs.zzay().zzd().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzQ() {
        zzg();
        this.zze.zzb();
        zzap zzapVar = this.zzd;
        this.zzs.zzf();
        zzapVar.zzd(((Long) zzeb.zzI.zza(null)).longValue());
    }

    private final void zzR(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        int size = this.zzf.size();
        this.zzs.zzf();
        if (size >= 1000) {
            this.zzs.zzay().zzd().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzd(60000L);
        zzr();
    }

    private final boolean zzS() {
        this.zzs.zzaw();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzo(zzjs zzjsVar, ComponentName componentName) {
        zzjsVar.zzg();
        if (zzjsVar.zzb != null) {
            zzjsVar.zzb = null;
            zzjsVar.zzs.zzay().zzj().zzb("Disconnected from device MeasurementService", componentName);
            zzjsVar.zzg();
            zzjsVar.zzr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzA(zzaw zzawVar, String str) {
        Preconditions.checkNotNull(zzawVar);
        zzg();
        zza();
        zzS();
        zzR(new zzjh(this, true, zzO(true), this.zzs.zzi().zzo(zzawVar), zzawVar, str));
    }

    public final void zzB(com.google.android.gms.internal.measurement.zzcf zzcfVar, zzaw zzawVar, String str) {
        zzg();
        zza();
        if (this.zzs.zzv().zzo(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            this.zzs.zzay().zzk().zza("Not bundling data. Service unavailable or out of date");
            this.zzs.zzv().zzS(zzcfVar, new byte[0]);
            return;
        }
        zzR(new zzjd(this, zzawVar, str, zzcfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzC() {
        zzg();
        zza();
        zzq zzO = zzO(false);
        zzS();
        this.zzs.zzi().zzj();
        zzR(new zziw(this, zzO));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD(zzee zzeeVar, AbstractSafeParcelable abstractSafeParcelable, zzq zzqVar) {
        int i;
        zzg();
        zza();
        zzS();
        this.zzs.zzf();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List zzi = this.zzs.zzi().zzi(100);
            if (zzi != null) {
                arrayList.addAll(zzi);
                i = zzi.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i4);
                if (abstractSafeParcelable2 instanceof zzaw) {
                    try {
                        zzeeVar.zzk((zzaw) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e) {
                        this.zzs.zzay().zzd().zzb("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzlc) {
                    try {
                        zzeeVar.zzt((zzlc) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e2) {
                        this.zzs.zzay().zzd().zzb("Failed to send user property to the service", e2);
                    }
                } else if (!(abstractSafeParcelable2 instanceof zzac)) {
                    this.zzs.zzay().zzd().zza("Discarding data. Unrecognized parcel type.");
                } else {
                    try {
                        zzeeVar.zzn((zzac) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e3) {
                        this.zzs.zzay().zzd().zzb("Failed to send conditional user property to the service", e3);
                    }
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzE(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzg();
        zza();
        this.zzs.zzaw();
        zzR(new zzji(this, true, zzO(true), this.zzs.zzi().zzn(zzacVar), new zzac(zzacVar), zzacVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzF(boolean z) {
        zzg();
        zza();
        if (z) {
            zzS();
            this.zzs.zzi().zzj();
        }
        if (zzM()) {
            zzR(new zzjg(this, zzO(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzG(zzik zzikVar) {
        zzg();
        zza();
        zzR(new zzja(this, zzikVar));
    }

    public final void zzH(Bundle bundle) {
        zzg();
        zza();
        zzR(new zzjb(this, zzO(false), bundle));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzI() {
        zzg();
        zza();
        zzR(new zzjf(this, zzO(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzJ(zzee zzeeVar) {
        zzg();
        Preconditions.checkNotNull(zzeeVar);
        this.zzb = zzeeVar;
        zzQ();
        zzP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzK(zzlc zzlcVar) {
        zzg();
        zza();
        zzS();
        zzR(new zziu(this, zzO(true), this.zzs.zzi().zzp(zzlcVar), zzlcVar));
    }

    public final boolean zzL() {
        zzg();
        zza();
        return this.zzb != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzM() {
        zzg();
        zza();
        return !zzN() || this.zzs.zzv().zzm() >= ((Integer) zzeb.zzaf.zza(null)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e3, code lost:
    
        if (r0 == null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzN() {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjs.zzN():boolean");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzj() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzq() {
        zzg();
        zza();
        zzq zzO = zzO(true);
        this.zzs.zzi().zzk();
        zzR(new zziz(this, zzO));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzr() {
        zzg();
        zza();
        if (zzL()) {
            return;
        }
        if (!zzN()) {
            if (this.zzs.zzf().zzx()) {
                return;
            }
            this.zzs.zzaw();
            List<ResolveInfo> queryIntentServices = this.zzs.zzau().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzs.zzau(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                this.zzs.zzay().zzd().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                return;
            }
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            Context zzau = this.zzs.zzau();
            this.zzs.zzaw();
            intent.setComponent(new ComponentName(zzau, "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zzb(intent);
            return;
        }
        this.zza.zzc();
    }

    public final void zzs() {
        zzg();
        zza();
        this.zza.zzd();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzs.zzau(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzt(com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        zzg();
        zza();
        zzR(new zziy(this, zzO(false), zzcfVar));
    }

    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        zzR(new zzix(this, atomicReference, zzO(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzv(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2) {
        zzg();
        zza();
        zzR(new zzjk(this, str, str2, zzO(false), zzcfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zza();
        zzR(new zzjj(this, atomicReference, null, str2, str3, zzO(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzx(AtomicReference atomicReference, boolean z) {
        zzg();
        zza();
        zzR(new zziv(this, atomicReference, zzO(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzy(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2, boolean z) {
        zzg();
        zza();
        zzR(new zzit(this, str, str2, zzO(false), z, zzcfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzz(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zza();
        zzR(new zzjl(this, atomicReference, null, str2, str3, zzO(false), z));
    }
}
