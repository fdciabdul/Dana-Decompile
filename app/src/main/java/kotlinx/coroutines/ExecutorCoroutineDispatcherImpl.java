package kotlinx.coroutines;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.internal.ConcurrentKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b.\u0010/J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00192\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J5\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010&*\u00020%2\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020)8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Ljava/util/concurrent/RejectedExecutionException;", "exception", "", "cancelJobOnRejection", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/RejectedExecutionException;)V", "close", "()V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "", "toString", "()Ljava/lang/String;", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledFuture;", "scheduleBlock", "(Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;J)Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "<init>", "(Ljava/util/concurrent/Executor;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {79, Ascii.DC4, Ascii.EM, -22, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int MyBillsEntityDataFactory = 17;
    private final Executor executor;

    private static void a(int i, int i2, short s, Object[] objArr) {
        int i3 = s + 4;
        int i4 = i + 105;
        int i5 = 16 - (i2 * 4);
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        byte[] bArr2 = new byte[i5];
        int i6 = -1;
        int i7 = i5 - 1;
        if (bArr == null) {
            i4 = i4 + (-i3) + 2;
            i3 = i3;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
        }
        while (true) {
            int i8 = i3 + 1;
            int i9 = i6 + 1;
            bArr2[i9] = (byte) i4;
            if (i9 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            Object[] objArr2 = objArr;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            i4 = i4 + (-bArr[i8]) + 2;
            i3 = i8;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i6 = i9;
        }
    }

    public ExecutorCoroutineDispatcherImpl(Executor executor) {
        this.executor = executor;
        ConcurrentKt.removeFutureOnCancel(getExecutor());
    }

    @JvmName(name = "getExecutor")
    public final Executor getExecutor() {
        return this.executor;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public final void mo4661dispatch(CoroutineContext context, Runnable block) {
        Runnable runnable;
        try {
            Executor executor = getExecutor();
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource == null || (runnable = timeSource.wrapTask(block)) == null) {
                runnable = block;
            }
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource2 != null) {
                timeSource2.unTrackTask();
            }
            cancelJobOnRejection(context, e);
            Dispatchers.getIO().mo4661dispatch(context, block);
        }
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public final void mo4662scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super Unit> continuation) {
        Executor executor = getExecutor();
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        ScheduledFuture<?> scheduleBlock = scheduledExecutorService != null ? scheduleBlock(scheduledExecutorService, new ResumeUndispatchedRunnable(this, continuation), continuation.get$context(), timeMillis) : null;
        if (scheduleBlock != null) {
            JobKt.cancelFutureOnCancellation(continuation, scheduleBlock);
        } else {
            DefaultExecutor.INSTANCE.mo4662scheduleResumeAfterDelay(timeMillis, continuation);
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        Executor executor = getExecutor();
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        ScheduledFuture<?> scheduleBlock = scheduledExecutorService != null ? scheduleBlock(scheduledExecutorService, block, context, timeMillis) : null;
        if (scheduleBlock != null) {
            return new DisposableFutureHandle(scheduleBlock);
        }
        return DefaultExecutor.INSTANCE.invokeOnTimeout(timeMillis, block, context);
    }

    private final ScheduledFuture<?> scheduleBlock(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            cancelJobOnRejection(coroutineContext, e);
            return null;
        }
    }

    private final void cancelJobOnRejection(CoroutineContext context, RejectedExecutionException exception) {
        JobKt.cancel(context, ExceptionsKt.CancellationException("The task was rejected", exception));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = getExecutor();
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return getExecutor().toString();
    }

    public final boolean equals(Object other) {
        return (other instanceof ExecutorCoroutineDispatcherImpl) && ((ExecutorCoroutineDispatcherImpl) other).getExecutor() == getExecutor();
    }

    public final int hashCode() {
        try {
            Object[] objArr = {getExecutor()};
            byte b = BuiltInFictitiousFunctionClassFactory[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 | 14), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
            Object[] objArr3 = new Object[1];
            a(b3, b3, (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr3);
            return ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
