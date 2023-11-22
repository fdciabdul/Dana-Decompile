package kotlinx.coroutines.internal;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.huawei.hms.opendevice.i;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0016\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0017\u0010\u000bJ\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0013H\u0082\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0013H\u0082\u0010¢\u0006\u0004\b\u001b\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b!\u0010\"R$\u0010'\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00138G@CX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\u001a"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", i.MyBillsEntityDataFactory, "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", GriverMonitorConstants.KEY_SIZE, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;
    private T[] a;

    @JvmName(name = "getSize")
    /* renamed from: getSize  reason: from getter */
    public final int get_size() {
        return this._size;
    }

    @JvmName(name = "setSize")
    private final void setSize(int i) {
        this._size = i;
    }

    @JvmName(name = "isEmpty")
    public final boolean isEmpty() {
        return get_size() == 0;
    }

    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final T removeAtImpl(int index) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(get_size() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        setSize(get_size() - 1);
        if (index < get_size()) {
            swap(index, get_size());
            int i = (index - 1) / 2;
            if (index > 0) {
                T t = tArr[index];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    swap(index, i);
                    siftUpFrom(i);
                }
            }
            siftDownFrom(index);
        }
        T t3 = tArr[get_size()];
        Intrinsics.checkNotNull(t3);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(t3.getHeap() == this)) {
                throw new AssertionError();
            }
        }
        t3.setHeap(null);
        t3.setIndex(-1);
        tArr[get_size()] = null;
        return t3;
    }

    public final void addImpl(T node) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(node.getHeap() == null)) {
                throw new AssertionError();
            }
        }
        node.setHeap(this);
        T[] realloc = realloc();
        int i = get_size();
        setSize(i + 1);
        realloc[i] = node;
        node.setIndex(i);
        siftUpFrom(i);
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    private final void siftDownFrom(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= get_size()) {
                return;
            }
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i3 = i2 + 1;
            if (i3 < get_size()) {
                T t = tArr[i3];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i2];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            Intrinsics.checkNotNull(t3);
            T t4 = tArr[i2];
            Intrinsics.checkNotNull(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    private final T[] realloc() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        } else if (get_size() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, get_size() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "");
            T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    private final void swap(int i, int j) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[j];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics.checkNotNull(t2);
        tArr[i] = t;
        tArr[j] = t2;
        t.setIndex(i);
        t2.setIndex(j);
    }

    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final T removeFirstOrNull() {
        T removeAtImpl;
        synchronized (this) {
            removeAtImpl = get_size() > 0 ? removeAtImpl(0) : null;
        }
        return removeAtImpl;
    }

    public final boolean remove(T node) {
        boolean z;
        synchronized (this) {
            if (node.getHeap() != null) {
                int index = node.getIndex();
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(index >= 0)) {
                        throw new AssertionError();
                    }
                }
                removeAtImpl(index);
                z = true;
            }
        }
        return z;
    }
}
