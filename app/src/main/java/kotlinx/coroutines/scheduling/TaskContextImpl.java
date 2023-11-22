package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00058\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/scheduling/TaskContextImpl;", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "afterTask", "()V", "", "taskMode", "I", "getTaskMode", "()I", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final class TaskContextImpl implements TaskContext {
    private final int taskMode;

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final void afterTask() {
    }

    public TaskContextImpl(int i) {
        this.taskMode = i;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    @JvmName(name = "getTaskMode")
    public final int getTaskMode() {
        return this.taskMode;
    }
}
