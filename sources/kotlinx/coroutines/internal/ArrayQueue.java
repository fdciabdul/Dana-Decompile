package kotlinx.coroutines.internal;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010"}, d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "", "T", LottieParams.KEY_ELEMENT_ID, "", "addLast", "(Ljava/lang/Object;)V", "ensureCapacity", "()V", "removeFirstOrNull", "()Ljava/lang/Object;", "", "elements", "[Ljava/lang/Object;", "", "head", "I", "", "isEmpty", "()Z", "tail", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class ArrayQueue<T> {
    private Object[] elements = new Object[16];
    private int head;
    private int tail;

    @JvmName(name = "isEmpty")
    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final void addLast(T element) {
        Object[] objArr = this.elements;
        int i = this.tail;
        objArr[i] = element;
        int length = (objArr.length - 1) & (i + 1);
        this.tail = length;
        if (length == this.head) {
            ensureCapacity();
        }
    }

    public final T removeFirstOrNull() {
        int i = this.head;
        if (i == this.tail) {
            return null;
        }
        Object[] objArr = this.elements;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.head = (i + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }

    private final void ensureCapacity() {
        Object[] objArr = this.elements;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        ArraysKt.copyInto$default(objArr, objArr2, 0, this.head, 0, 10, (Object) null);
        Object[] objArr3 = this.elements;
        int length2 = objArr3.length;
        int i = this.head;
        ArraysKt.copyInto$default(objArr3, objArr2, length2 - i, 0, i, 4, (Object) null);
        this.elements = objArr2;
        this.head = 0;
        this.tail = length;
    }
}
