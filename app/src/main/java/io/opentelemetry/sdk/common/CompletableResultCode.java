package io.opentelemetry.sdk.common;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.splunk.rum.AnrWatcher$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class CompletableResultCode {
    public static final byte[] MyBillsEntityDataFactory = {11, Ascii.GS, 107, 8, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 116;
    private static final CompletableResultCode SUCCESS = new CompletableResultCode().succeed();
    private static final CompletableResultCode FAILURE = new CompletableResultCode().fail();
    @Nullable
    private Boolean succeeded = null;
    private final List<Runnable> completionActions = new ArrayList();
    private final Object lock = new Object();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = io.opentelemetry.sdk.common.CompletableResultCode.MyBillsEntityDataFactory
            int r8 = r8 * 3
            int r8 = r8 + 13
            int r6 = r6 + 4
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.sdk.common.CompletableResultCode.a(int, int, int, java.lang.Object[]):void");
    }

    public static CompletableResultCode ofSuccess() {
        return SUCCESS;
    }

    public static CompletableResultCode ofFailure() {
        return FAILURE;
    }

    public static CompletableResultCode ofAll(Collection<CompletableResultCode> collection) {
        if (collection.isEmpty()) {
            return ofSuccess();
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        final AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (final CompletableResultCode completableResultCode2 : collection) {
            completableResultCode2.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.common.CompletableResultCode$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CompletableResultCode.lambda$ofAll$0(CompletableResultCode.this, atomicBoolean, atomicInteger, completableResultCode);
                }
            });
        }
        return completableResultCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$ofAll$0(CompletableResultCode completableResultCode, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, CompletableResultCode completableResultCode2) {
        if (!completableResultCode.isSuccess()) {
            atomicBoolean.set(true);
        }
        if (atomicInteger.decrementAndGet() == 0) {
            if (atomicBoolean.get()) {
                completableResultCode2.fail();
            } else {
                completableResultCode2.succeed();
            }
        }
    }

    public final CompletableResultCode succeed() {
        synchronized (this.lock) {
            if (this.succeeded == null) {
                this.succeeded = Boolean.TRUE;
                Iterator<Runnable> it = this.completionActions.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
        return this;
    }

    public final CompletableResultCode fail() {
        synchronized (this.lock) {
            if (this.succeeded == null) {
                this.succeeded = Boolean.FALSE;
                Iterator<Runnable> it = this.completionActions.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
        return this;
    }

    public final boolean isSuccess() {
        boolean z;
        synchronized (this.lock) {
            Boolean bool = this.succeeded;
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public final CompletableResultCode whenComplete(Runnable runnable) {
        boolean z;
        synchronized (this.lock) {
            if (this.succeeded != null) {
                z = true;
            } else {
                this.completionActions.add(runnable);
                z = false;
            }
        }
        if (z) {
            runnable.run();
        }
        return this;
    }

    public final boolean isDone() {
        boolean z;
        synchronized (this.lock) {
            z = this.succeeded != null;
        }
        return z;
    }

    public final CompletableResultCode join(long j, TimeUnit timeUnit) {
        if (isDone()) {
            return this;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        whenComplete(new AnrWatcher$$ExternalSyntheticLambda0(countDownLatch));
        try {
            try {
                countDownLatch.await(j, timeUnit);
                return this;
            } catch (InterruptedException unused) {
                byte b = MyBillsEntityDataFactory[0];
                byte b2 = (byte) (-MyBillsEntityDataFactory[15]);
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = MyBillsEntityDataFactory[15];
                byte b4 = (byte) (b3 + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                return this;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
