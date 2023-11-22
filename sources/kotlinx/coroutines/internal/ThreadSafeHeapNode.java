package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\"\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028'@'X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8'@'X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "heap", "", "getIndex", "()I", "setIndex", "(I)V", "index"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface ThreadSafeHeapNode {
    @JvmName(name = "getHeap")
    ThreadSafeHeap<?> getHeap();

    @JvmName(name = "getIndex")
    int getIndex();

    @JvmName(name = "setHeap")
    void setHeap(ThreadSafeHeap<?> threadSafeHeap);

    @JvmName(name = "setIndex")
    void setIndex(int i);
}
