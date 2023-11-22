package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0015X\u0094\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Thread;", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "<init>", "(Ljava/lang/Thread;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BlockingEventLoop extends EventLoopImplBase {
    private final Thread thread;

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    @JvmName(name = "getThread")
    protected final Thread getThread() {
        return this.thread;
    }

    public BlockingEventLoop(Thread thread) {
        this.thread = thread;
    }
}
