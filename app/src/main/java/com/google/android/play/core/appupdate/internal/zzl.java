package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class zzl {
    protected final zzm zza;
    private final IntentFilter zzc;
    private final Context zzd;
    protected final Set zzb = new HashSet();
    private zzk zze = null;
    private volatile boolean zzf = false;

    public zzl(zzm zzmVar, IntentFilter intentFilter, Context context) {
        this.zza = zzmVar;
        this.zzc = intentFilter;
        this.zzd = zzz.zza(context);
    }

    private final void zze() {
        zzk zzkVar;
        zzj zzjVar = null;
        if (!this.zzb.isEmpty() && this.zze == null) {
            this.zze = new zzk(this, zzjVar);
            if (Build.VERSION.SDK_INT >= 33) {
                this.zzd.registerReceiver(this.zze, this.zzc, 2);
            }
            this.zzd.registerReceiver(this.zze, this.zzc);
        }
        if (!this.zzb.isEmpty() || (zzkVar = this.zze) == null) {
            return;
        }
        this.zzd.unregisterReceiver(zzkVar);
        this.zze = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zza(Context context, Intent intent);

    public final void zzb(StateUpdatedListener stateUpdatedListener) {
        synchronized (this) {
            this.zza.zzd("registerListener", new Object[0]);
            zzac.zza(stateUpdatedListener, "Registered Play Core listener should not be null.");
            this.zzb.add(stateUpdatedListener);
            zze();
        }
    }

    public final void zzc(StateUpdatedListener stateUpdatedListener) {
        synchronized (this) {
            this.zza.zzd("unregisterListener", new Object[0]);
            zzac.zza(stateUpdatedListener, "Unregistered Play Core listener should not be null.");
            this.zzb.remove(stateUpdatedListener);
            zze();
        }
    }

    public final void zzd(Object obj) {
        synchronized (this) {
            Iterator it = new HashSet(this.zzb).iterator();
            while (it.hasNext()) {
                ((StateUpdatedListener) it.next()).onStateUpdate(obj);
            }
        }
    }
}
