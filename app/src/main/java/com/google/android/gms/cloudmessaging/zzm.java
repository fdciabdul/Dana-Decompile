package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzm implements ServiceConnection {
    zzn zzc;
    final /* synthetic */ zzs zzf;
    int zza = 0;
    final Messenger zzb = new Messenger(new com.google.android.gms.internal.cloudmessaging.zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.cloudmessaging.zzf
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            zzm zzmVar = zzm.this;
            int i = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Received response to request: ");
                sb.append(i);
                InstrumentInjector.log_d("MessengerIpcClient", sb.toString());
            }
            synchronized (zzmVar) {
                zzp<?> zzpVar = zzmVar.zze.get(i);
                if (zzpVar == null) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("Received response for unknown request: ");
                    sb2.append(i);
                    InstrumentInjector.log_w("MessengerIpcClient", sb2.toString());
                    return true;
                }
                zzmVar.zze.remove(i);
                zzmVar.zzf();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    zzpVar.zzc(new zzq(4, "Not supported by GmsCore", null));
                    return true;
                }
                zzpVar.zza(data);
                return true;
            }
        }
    }));
    final Queue<zzp<?>> zzd = new ArrayDeque();
    final SparseArray<zzp<?>> zze = new SparseArray<>();

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            InstrumentInjector.log_v("MessengerIpcClient", "Service connected");
        }
        scheduledExecutorService = this.zzf.zzc;
        scheduledExecutorService.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzj
            @Override // java.lang.Runnable
            public final void run() {
                zzm zzmVar = zzm.this;
                IBinder iBinder2 = iBinder;
                synchronized (zzmVar) {
                    try {
                        if (iBinder2 == null) {
                            zzmVar.zza(0, "Null service connection");
                            return;
                        }
                        try {
                            zzmVar.zzc = new zzn(iBinder2);
                            zzmVar.zza = 2;
                            zzmVar.zzc();
                        } catch (RemoteException e) {
                            zzmVar.zza(0, e.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            InstrumentInjector.log_v("MessengerIpcClient", "Service disconnected");
        }
        scheduledExecutorService = this.zzf.zzc;
        scheduledExecutorService.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzg
            @Override // java.lang.Runnable
            public final void run() {
                zzm.this.zza(2, "Service disconnected");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, String str) {
        synchronized (this) {
            zzb(i, str, null);
        }
    }

    final void zzb(int i, String str, Throwable th) {
        Context context;
        synchronized (this) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(str);
                InstrumentInjector.log_d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
            }
            int i2 = this.zza;
            if (i2 == 0) {
                throw new IllegalStateException();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.zza = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                InstrumentInjector.log_v("MessengerIpcClient", "Unbinding service");
            }
            this.zza = 4;
            ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
            context = this.zzf.zzb;
            connectionTracker.unbindService(context, this);
            zzq zzqVar = new zzq(i, str, th);
            Iterator<zzp<?>> it = this.zzd.iterator();
            while (it.hasNext()) {
                it.next().zzc(zzqVar);
            }
            this.zzd.clear();
            for (int i3 = 0; i3 < this.zze.size(); i3++) {
                this.zze.valueAt(i3).zzc(zzqVar);
            }
            this.zze.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.zzf.zzc;
        scheduledExecutorService.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzh
            @Override // java.lang.Runnable
            public final void run() {
                final zzp<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final zzm zzmVar = zzm.this;
                while (true) {
                    synchronized (zzmVar) {
                        if (zzmVar.zza != 2) {
                            return;
                        }
                        if (!zzmVar.zzd.isEmpty()) {
                            poll = zzmVar.zzd.poll();
                            zzmVar.zze.put(poll.zza, poll);
                            scheduledExecutorService2 = zzmVar.zzf.zzc;
                            scheduledExecutorService2.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzk
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzm.this.zze(poll.zza);
                                }
                            }, 30L, TimeUnit.SECONDS);
                        } else {
                            zzmVar.zzf();
                            return;
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        InstrumentInjector.log_d("MessengerIpcClient", sb.toString());
                    }
                    context = zzmVar.zzf.zzb;
                    Messenger messenger = zzmVar.zzb;
                    Message obtain = Message.obtain();
                    obtain.what = poll.zzc;
                    obtain.arg1 = poll.zza;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.zzb());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.zzd);
                    obtain.setData(bundle);
                    try {
                        zzmVar.zzc.zza(obtain);
                    } catch (RemoteException e) {
                        zzmVar.zza(2, e.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd() {
        synchronized (this) {
            if (this.zza == 1) {
                zza(1, "Timed out while binding");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(int i) {
        synchronized (this) {
            zzp<?> zzpVar = this.zze.get(i);
            if (zzpVar != null) {
                StringBuilder sb = new StringBuilder(31);
                sb.append("Timing out request: ");
                sb.append(i);
                InstrumentInjector.log_w("MessengerIpcClient", sb.toString());
                this.zze.remove(i);
                zzpVar.zzc(new zzq(3, "Timed out waiting for response", null));
                zzf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf() {
        Context context;
        synchronized (this) {
            if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    InstrumentInjector.log_v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.zza = 3;
                ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                context = this.zzf.zzb;
                connectionTracker.unbindService(context, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzm(zzs zzsVar, zzl zzlVar) {
        this.zzf = zzsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzg(zzp<?> zzpVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        synchronized (this) {
            int i = this.zza;
            if (i != 0) {
                if (i == 1) {
                    this.zzd.add(zzpVar);
                    return true;
                } else if (i != 2) {
                    return false;
                } else {
                    this.zzd.add(zzpVar);
                    zzc();
                    return true;
                }
            }
            this.zzd.add(zzpVar);
            Preconditions.checkState(this.zza == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                InstrumentInjector.log_v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.zza = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                context = this.zzf.zzb;
                if (connectionTracker.bindService(context, intent, this, 1)) {
                    scheduledExecutorService = this.zzf.zzc;
                    scheduledExecutorService.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzi
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzm.this.zzd();
                        }
                    }, 30L, TimeUnit.SECONDS);
                } else {
                    zza(0, "Unable to bind to service");
                }
            } catch (SecurityException e) {
                zzb(0, "Unable to bind to service", e);
            }
            return true;
        }
    }
}
