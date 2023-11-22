package com.google.android.gms.measurement.internal;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzft extends FutureTask implements Comparable {
    final boolean zza;
    final /* synthetic */ zzfv zzb;
    private final long zzc;
    private final String zzd;
    public static final byte[] PlaceComponentResult = {105, Ascii.NAK, -43, 101, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 255;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzft(zzfv zzfvVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        this.zzb = zzfvVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzfv.zza;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == LongCompanionObject.MAX_VALUE) {
            zzfvVar.zzs.zzay().zzd().zza("Tasks index overflow");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.google.android.gms.measurement.internal.zzft.PlaceComponentResult
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r8 = r8 * 3
            int r8 = r8 + 13
            int r9 = r9 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1a:
            r3 = 0
        L1b:
            int r9 = r9 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r4 = r0[r9]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzft.a(int, int, short, java.lang.Object[]):void");
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzft zzftVar = (zzft) obj;
        boolean z = this.zza;
        if (z == zzftVar.zza) {
            long j = this.zzc;
            long j2 = zzftVar.zzc;
            if (j < j2) {
                return -1;
            }
            if (j <= j2) {
                this.zzb.zzs.zzay().zzh().zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
                return 0;
            }
        } else if (z) {
            return -1;
        }
        return 1;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzs.zzay().zzd().zzb(this.zzd, th);
        if ((th instanceof zzfr) && (defaultUncaughtExceptionHandler = InstrumentInjector.getDefaultUncaughtExceptionHandler()) != null) {
            try {
                Object[] objArr = new Object[1];
                a((byte) (PlaceComponentResult[15] + 1), (byte) (-PlaceComponentResult[15]), PlaceComponentResult[16], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = (byte) (-PlaceComponentResult[15]);
                Object[] objArr2 = new Object[1];
                a(b, (byte) (b - 1), PlaceComponentResult[15], objArr2);
                defaultUncaughtExceptionHandler.uncaughtException((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null), th);
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        }
        super.setException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzft(zzfv zzfvVar, Callable callable, boolean z, String str) {
        super(callable);
        AtomicLong atomicLong;
        this.zzb = zzfvVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        atomicLong = zzfv.zza;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == LongCompanionObject.MAX_VALUE) {
            zzfvVar.zzs.zzay().zzd().zza("Tasks index overflow");
        }
    }
}
