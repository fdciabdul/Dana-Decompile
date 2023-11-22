package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0014\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\t\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0005\"\u0014\u0010\n\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0002\"\u0014\u0010\u000b\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\b\"\u0016\u0010\r\u001a\u00020\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lkotlinx/coroutines/scheduling/TaskContext;", "BlockingContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "CORE_POOL_SIZE", "I", "", "IDLE_WORKER_KEEP_ALIVE_NS", "J", "MAX_POOL_SIZE", "NonBlockingContext", "WORK_STEALING_TIME_RESOLUTION_NS", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TasksKt {
    public static final TaskContext BlockingContext;
    public static final int CORE_POOL_SIZE;
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    public static final int MAX_POOL_SIZE;
    public static final TaskContext NonBlockingContext;
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    public static SchedulerTimeSource schedulerTimeSource;

    static {
        long systemProp$default;
        int systemProp$default2;
        int systemProp$default3;
        long systemProp$default4;
        systemProp$default = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object) null);
        WORK_STEALING_TIME_RESOLUTION_NS = systemProp$default;
        systemProp$default2 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, (Object) null);
        CORE_POOL_SIZE = systemProp$default2;
        systemProp$default3 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object) null);
        MAX_POOL_SIZE = systemProp$default3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        systemProp$default4 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, (Object) null);
        IDLE_WORKER_KEEP_ALIVE_NS = timeUnit.toNanos(systemProp$default4);
        schedulerTimeSource = NanoTimeSource.INSTANCE;
        NonBlockingContext = new TaskContextImpl(0);
        BlockingContext = new TaskContextImpl(1);
    }
}
