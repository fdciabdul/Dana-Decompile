package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b*\u001e\b\u0002\u0010\f\u001a\u0004\b\u0000\u0010\n\"\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0012\u0004\u0012\u00028\u00000\u000b"}, d2 = {"", "timeNanos", "delayNanosToMillis", "(J)J", "timeMillis", "delayToNanos", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "DISPOSED_TASK", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EventLoop_commonKt {
    private static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
    private static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");

    public static final long delayToNanos(long j) {
        if (j <= 0) {
            return 0L;
        }
        return j >= 9223372036854L ? LongCompanionObject.MAX_VALUE : 1000000 * j;
    }

    public static final long delayNanosToMillis(long j) {
        return j / 1000000;
    }
}
