package kotlinx.coroutines.rx2;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\"\u0010#J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0011\u0010 \u001a\u00020\u001fX\u0006¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lkotlinx/coroutines/rx2/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "", "toString", "()Ljava/lang/String;", "Lio/reactivex/Scheduler;", "scheduler", "Lio/reactivex/Scheduler;", "<init>", "(Lio/reactivex/Scheduler;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SchedulerCoroutineDispatcher extends CoroutineDispatcher implements Delay {
    public final Scheduler scheduler;
    public static final byte[] getAuthRequestContext = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 19;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r8, byte r9, short r10, java.lang.Object[] r11) {
        /*
            byte[] r0 = kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher.getAuthRequestContext
            int r10 = r10 * 2
            int r10 = 16 - r10
            int r9 = 106 - r9
            int r8 = r8 * 15
            int r8 = 18 - r8
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L18
            r9 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L35
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            int r8 = r8 + 1
            if (r5 != r10) goto L2a
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L35:
            int r8 = r8 + r10
            int r8 = r8 + 2
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher.a(short, byte, short, java.lang.Object[]):void");
    }

    public SchedulerCoroutineDispatcher(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public final void mo4661dispatch(CoroutineContext r1, Runnable block) {
        this.scheduler.scheduleDirect(block);
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public final void mo4662scheduleResumeAfterDelay(long timeMillis, final CancellableContinuation<? super Unit> continuation) {
        RxAwaitKt.disposeOnCancellation(continuation, this.scheduler.scheduleDirect(new Runnable() { // from class: kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SchedulerCoroutineDispatcher.m4681scheduleResumeAfterDelay$lambda1(CancellableContinuation.this, this);
            }
        }, timeMillis, TimeUnit.MILLISECONDS));
    }

    /* renamed from: scheduleResumeAfterDelay$lambda-1 */
    public static final void m4681scheduleResumeAfterDelay$lambda1(CancellableContinuation cancellableContinuation, SchedulerCoroutineDispatcher schedulerCoroutineDispatcher) {
        cancellableContinuation.resumeUndispatched(schedulerCoroutineDispatcher, Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext r5) {
        final Disposable scheduleDirect = this.scheduler.scheduleDirect(block, timeMillis, TimeUnit.MILLISECONDS);
        return new DisposableHandle() { // from class: kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher$$ExternalSyntheticLambda0
            @Override // kotlinx.coroutines.DisposableHandle
            public final void dispose() {
                Disposable.this.dispose();
            }
        };
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return this.scheduler.toString();
    }

    public final boolean equals(Object other) {
        return (other instanceof SchedulerCoroutineDispatcher) && ((SchedulerCoroutineDispatcher) other).scheduler == this.scheduler;
    }

    public final int hashCode() {
        try {
            Object[] objArr = {this.scheduler};
            byte b = (byte) (getAuthRequestContext[5] + 1);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (-getAuthRequestContext[5]);
            byte b4 = b3;
            Object[] objArr3 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr3);
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
