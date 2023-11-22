package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzfu extends Thread {
    final /* synthetic */ zzfv zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    private boolean zzd = false;

    public zzfu(zzfv zzfvVar, String str, BlockingQueue blockingQueue) {
        this.zza = zzfvVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        zzfu zzfuVar;
        zzfu zzfuVar2;
        obj = this.zza.zzh;
        synchronized (obj) {
            if (!this.zzd) {
                semaphore = this.zza.zzi;
                semaphore.release();
                obj2 = this.zza.zzh;
                obj2.notifyAll();
                zzfv zzfvVar = this.zza;
                zzfuVar = zzfvVar.zzb;
                if (this == zzfuVar) {
                    zzfvVar.zzb = null;
                } else {
                    zzfuVar2 = zzfvVar.zzc;
                    if (this != zzfuVar2) {
                        zzfvVar.zzs.zzay().zzd().zza("Current scheduler thread is neither worker nor network");
                    } else {
                        zzfvVar.zzc = null;
                    }
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzs.zzay().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Semaphore semaphore;
        Object obj;
        boolean z = false;
        while (!z) {
            try {
                semaphore = this.zza.zzi;
                semaphore.acquire();
                z = true;
            } catch (InterruptedException e) {
                zzc(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzft zzftVar = (zzft) this.zzc.poll();
                if (zzftVar != null) {
                    Process.setThreadPriority(true != zzftVar.zza ? 10 : threadPriority);
                    zzftVar.run();
                } else {
                    synchronized (this.zzb) {
                        if (this.zzc.peek() == null) {
                            zzfv.zzr(this.zza);
                            try {
                                this.zzb.wait(30000L);
                            } catch (InterruptedException e2) {
                                zzc(e2);
                            }
                        }
                    }
                    obj = this.zza.zzh;
                    synchronized (obj) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            return;
                        }
                    }
                }
            }
        } finally {
            zzb();
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzb.notifyAll();
        }
    }
}
