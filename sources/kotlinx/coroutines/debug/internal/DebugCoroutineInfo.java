package kotlinx.coroutines.debug.internal;

import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "creationStackBottom", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "", "Ljava/lang/StackTraceElement;", "creationStackTrace", "Ljava/util/List;", "lastObservedFrame", "lastObservedStackTrace", "Ljava/lang/Thread;", "lastObservedThread", "Ljava/lang/Thread;", "", "sequenceNumber", "J", "", "state", "Ljava/lang/String;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "source", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DebugCoroutineInfo {
    public final CoroutineContext context;
    public final CoroutineStackFrame creationStackBottom;
    public final List<StackTraceElement> creationStackTrace;
    public final CoroutineStackFrame lastObservedFrame;
    public final List<StackTraceElement> lastObservedStackTrace;
    public final Thread lastObservedThread;
    public final long sequenceNumber;
    public final String state;

    public DebugCoroutineInfo(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        this.context = coroutineContext;
        this.creationStackBottom = debugCoroutineInfoImpl.getCreationStackBottom();
        this.sequenceNumber = debugCoroutineInfoImpl.sequenceNumber;
        this.creationStackTrace = debugCoroutineInfoImpl.getCreationStackTrace();
        this.state = debugCoroutineInfoImpl.get_state();
        this.lastObservedThread = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedFrame = debugCoroutineInfoImpl.getLastObservedFrame$kotlinx_coroutines_core();
        this.lastObservedStackTrace = debugCoroutineInfoImpl.lastObservedStackTrace();
    }
}
