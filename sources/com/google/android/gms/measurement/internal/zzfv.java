package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class zzfv extends zzgs {
    private zzfu zzb;
    private zzfu zzc;
    private final PriorityBlockingQueue zzd;
    private final BlockingQueue zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Thread.UncaughtExceptionHandler zzg;
    private final Object zzh;
    private final Semaphore zzi;
    private volatile boolean zzj;
    public static final byte[] getAuthRequestContext = {36, -18, 4, 125, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 6;
    private static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfv(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzh = new Object();
        this.zzi = new Semaphore(2);
        this.zzd = new PriorityBlockingQueue();
        this.zze = new LinkedBlockingQueue();
        this.zzf = new zzfs(this, "Thread death: Uncaught exception on worker thread");
        this.zzg = new zzfs(this, "Thread death: Uncaught exception on network thread");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.gms.measurement.internal.zzfv.getAuthRequestContext
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r8 = r8 * 7
            int r8 = 106 - r8
            int r7 = r7 * 12
            int r7 = 15 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L32
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L32:
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfv.a(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzr(zzfv zzfvVar) {
        boolean z = zzfvVar.zzj;
        return false;
    }

    private final void zzt(zzft zzftVar) {
        synchronized (this.zzh) {
            this.zzd.add(zzftVar);
            zzfu zzfuVar = this.zzb;
            if (zzfuVar != null) {
                zzfuVar.zza();
            } else {
                zzfu zzfuVar2 = new zzfu(this, "Measurement Worker", this.zzd);
                this.zzb = zzfuVar2;
                zzfuVar2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final void zzax() {
        try {
            byte b = (byte) (getAuthRequestContext[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = getAuthRequestContext[15];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != this.zzc) {
                throw new IllegalStateException("Call expected from network thread");
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzd(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.zzs.zzaz().zzp(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                this.zzs.zzay().zzk().zza("Interrupted waiting for " + str);
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.zzs.zzay().zzk().zza("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    protected final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final void zzg() {
        try {
            byte b = (byte) (getAuthRequestContext[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = getAuthRequestContext[15];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != this.zzb) {
                throw new IllegalStateException("Call expected from worker thread");
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public final Future zzh(Callable callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        zzft zzftVar = new zzft(this, callable, false, "Task exception on worker thread");
        try {
            byte b = (byte) (getAuthRequestContext[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = getAuthRequestContext[15];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) == this.zzb) {
                if (!this.zzd.isEmpty()) {
                    this.zzs.zzay().zzk().zza("Callable skipped the worker queue.");
                }
                zzftVar.run();
            } else {
                zzt(zzftVar);
            }
            return zzftVar;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final Future zzi(Callable callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        zzft zzftVar = new zzft(this, callable, true, "Task exception on worker thread");
        try {
            byte b = (byte) (getAuthRequestContext[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = getAuthRequestContext[15];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) == this.zzb) {
                zzftVar.run();
            } else {
                zzt(zzftVar);
            }
            return zzftVar;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final void zzo(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzft zzftVar = new zzft(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            this.zze.add(zzftVar);
            zzfu zzfuVar = this.zzc;
            if (zzfuVar != null) {
                zzfuVar.zza();
            } else {
                zzfu zzfuVar2 = new zzfu(this, "Measurement Network", this.zze);
                this.zzc = zzfuVar2;
                zzfuVar2.setUncaughtExceptionHandler(this.zzg);
                this.zzc.start();
            }
        }
    }

    public final void zzp(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzft(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzq(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzft(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzs() {
        try {
            byte b = (byte) (getAuthRequestContext[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = getAuthRequestContext[15];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            return cls.getMethod((String) objArr2[0], null).invoke(null, null) == this.zzb;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
