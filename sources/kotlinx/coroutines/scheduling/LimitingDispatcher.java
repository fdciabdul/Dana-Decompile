package kotlinx.coroutines.scheduling;

import com.ap.zoloz.hummer.biz.HummerConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u00020\u00042\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\r\u0010\u0011J#\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u001b\u0010\u0014\u001a\u00020\u00042\n\u0010\u0013\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001e8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010&"}, d2 = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "name", "Ljava/lang/String;", "", "parallelism", "I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Ljava/util/concurrent/ConcurrentLinkedQueue;", "taskMode", "getTaskMode", "()I"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements TaskContext, Executor {
    private static final /* synthetic */ AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    private final ExperimentalCoroutineDispatcher dispatcher;
    private volatile /* synthetic */ int inFlightTasks;
    private final String name;
    private final int parallelism;
    private final ConcurrentLinkedQueue<Runnable> queue;
    private final int taskMode;

    @Override // kotlinx.coroutines.scheduling.TaskContext
    @JvmName(name = "getTaskMode")
    public final int getTaskMode() {
        return this.taskMode;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable command) {
        dispatch(command, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public final void mo4661dispatch(CoroutineContext context, Runnable block) {
        dispatch(block, false);
    }

    private final void dispatch(Runnable block, boolean tailDispatch) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = inFlightTasks$FU;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.parallelism) {
                this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(block, this, tailDispatch);
                return;
            }
            this.queue.add(block);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.parallelism) {
                return;
            }
            block = this.queue.poll();
        } while (block != null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext context, Runnable block) {
        dispatch(block, true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        String str = this.name;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("[dispatcher = ");
            sb.append(this.dispatcher);
            sb.append(']');
            return sb.toString();
        }
        return str;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final void afterTask() {
        Runnable poll = this.queue.poll();
        if (poll != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(poll, this, true);
            return;
        }
        inFlightTasks$FU.decrementAndGet(this);
        Runnable poll2 = this.queue.poll();
        if (poll2 == null) {
            return;
        }
        dispatch(poll2, true);
    }
}
