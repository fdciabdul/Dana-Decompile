package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonDisposableHandle;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b.\u0010/B#\b\u0002\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010,\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010*\u001a\u00020\u000e¢\u0006\u0004\b.\u00100J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u00008\u0017X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "cancelOnRejection", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatch", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "isDispatchNeeded", "(Lkotlin/coroutines/CoroutineContext;)Z", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "", "toString", "()Ljava/lang/String;", "_immediate", "Lkotlinx/coroutines/android/HandlerContext;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "invokeImmediately", "Z", "name", "Ljava/lang/String;", "<init>", "(Landroid/os/Handler;Ljava/lang/String;)V", "(Landroid/os/Handler;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class HandlerContext extends HandlerDispatcher implements Delay {
    private volatile HandlerContext _immediate;
    private final Handler handler;
    private final HandlerContext immediate;
    private final boolean invokeImmediately;
    private final String name;
    public static final byte[] getAuthRequestContext = {116, 15, TarHeader.LF_BLK, -20, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 111;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 105
            int r6 = r6 * 15
            int r6 = 18 - r6
            int r8 = r8 * 2
            int r8 = r8 + 16
            byte[] r0 = kotlinx.coroutines.android.HandlerContext.getAuthRequestContext
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
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r6 = r6 + 1
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.android.HandlerContext.a(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r0v3 */
    private HandlerContext(Handler handler, String str, boolean z) {
        super(0);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z;
        this._immediate = z ? this : 0;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.immediate = handlerContext;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    @JvmName(name = "getImmediate")
    public final HandlerContext getImmediate() {
        return this.immediate;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext context) {
        return (this.invokeImmediately && Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public final void mo4661dispatch(CoroutineContext context, Runnable block) {
        if (this.handler.post(block)) {
            return;
        }
        cancelOnRejection(context, block);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long timeMillis, final Runnable block, CoroutineContext context) {
        if (this.handler.postDelayed(block, RangesKt.coerceAtMost(timeMillis, (long) DurationKt.MAX_MILLIS))) {
            return new DisposableHandle() { // from class: kotlinx.coroutines.android.HandlerContext$$ExternalSyntheticLambda0
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    HandlerContext.m4629invokeOnTimeout$lambda3(HandlerContext.this, block);
                }
            };
        }
        cancelOnRejection(context, block);
        return NonDisposableHandle.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeOnTimeout$lambda-3  reason: not valid java name */
    public static final void m4629invokeOnTimeout$lambda3(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.handler.removeCallbacks(runnable);
    }

    private final void cancelOnRejection(CoroutineContext context, Runnable block) {
        StringBuilder sb = new StringBuilder();
        sb.append("The task was rejected, the handler underlying the dispatcher '");
        sb.append(this);
        sb.append("' was closed");
        JobKt.cancel(context, new CancellationException(sb.toString()));
        Dispatchers.getIO().mo4661dispatch(context, block);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl == null) {
            String str = this.name;
            if (str == null) {
                str = this.handler.toString();
            }
            if (this.invokeImmediately) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".immediate");
                return sb.toString();
            }
            return str;
        }
        return stringInternalImpl;
    }

    public final boolean equals(Object other) {
        return (other instanceof HandlerContext) && ((HandlerContext) other).handler == this.handler;
    }

    public final int hashCode() {
        try {
            Object[] objArr = {this.handler};
            byte b = (byte) (getAuthRequestContext[5] - 1);
            byte b2 = getAuthRequestContext[5];
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = getAuthRequestContext[5];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr3 = new Object[1];
            a(b3, b4, b4, objArr3);
            return ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public final void mo4662scheduleResumeAfterDelay(long timeMillis, final CancellableContinuation<? super Unit> continuation) {
        final Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                CancellableContinuation.this.resumeUndispatched(this, Unit.INSTANCE);
            }
        };
        if (this.handler.postDelayed(runnable, RangesKt.coerceAtMost(timeMillis, (long) DurationKt.MAX_MILLIS))) {
            continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Handler handler;
                    handler = HandlerContext.this.handler;
                    handler.removeCallbacks(runnable);
                }
            });
        } else {
            cancelOnRejection(continuation.get$context(), runnable);
        }
    }
}
