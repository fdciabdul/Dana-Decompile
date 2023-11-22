package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* loaded from: classes7.dex */
public final class zzjr implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzjs zza;
    private volatile boolean zzb;
    private volatile zzek zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjr(zzjs zzjsVar) {
        this.zza = zzjsVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzs.zzaz().zzp(new zzjo(this, (zzee) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzeo zzl = this.zza.zzs.zzl();
        if (zzl != null) {
            zzl.zzk().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzs.zzaz().zzp(new zzjq(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzs.zzay().zzc().zza("Service connection suspended");
        this.zza.zzs.zzaz().zzp(new zzjp(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzjr zzjrVar;
        zzee zzecVar;
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder != null) {
                zzee zzeeVar = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        if (queryLocalInterface instanceof zzee) {
                            zzecVar = (zzee) queryLocalInterface;
                        } else {
                            zzecVar = new zzec(iBinder);
                        }
                        zzeeVar = zzecVar;
                        this.zza.zzs.zzay().zzj().zza("Bound to IMeasurementService interface");
                    } else {
                        this.zza.zzs.zzay().zzd().zzb("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.zza.zzs.zzay().zzd().zza("Service connect failed to get IMeasurementService");
                }
                if (zzeeVar == null) {
                    this.zzb = false;
                    try {
                        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                        Context zzau = this.zza.zzs.zzau();
                        zzjrVar = this.zza.zza;
                        connectionTracker.unbindService(zzau, zzjrVar);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else {
                    this.zza.zzs.zzaz().zzp(new zzjm(this, zzeeVar));
                }
                return;
            }
            this.zzb = false;
            this.zza.zzs.zzay().zzd().zza("Service connected with null binder");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzs.zzay().zzc().zza("Service disconnected");
        this.zza.zzs.zzaz().zzp(new zzjn(this, componentName));
    }

    public final void zzb(Intent intent) {
        zzjr zzjrVar;
        this.zza.zzg();
        Context zzau = this.zza.zzs.zzau();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzs.zzay().zzj().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzs.zzay().zzj().zza("Using local app measurement service");
            this.zzb = true;
            zzjrVar = this.zza.zza;
            connectionTracker.bindService(zzau, intent, zzjrVar, 129);
        }
    }

    public final void zzc() {
        this.zza.zzg();
        Context zzau = this.zza.zzs.zzau();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzs.zzay().zzj().zza("Connection attempt already in progress");
            } else if (this.zzc == null || (!this.zzc.isConnecting() && !this.zzc.isConnected())) {
                this.zzc = new zzek(zzau, Looper.getMainLooper(), this, this);
                this.zza.zzs.zzay().zzj().zza("Connecting to remote service");
                this.zzb = true;
                Preconditions.checkNotNull(this.zzc);
                this.zzc.checkAvailabilityAndConnect();
            } else {
                this.zza.zzs.zzay().zzj().zza("Already awaiting connection attempt");
            }
        }
    }

    public final void zzd() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }
}
