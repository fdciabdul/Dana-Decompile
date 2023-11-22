package kotlin.collections;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b%\u0018\u0000 W*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001WB\u0011\b\u0016\u0012\u0006\u0010T\u001a\u00020\u0007¢\u0006\u0004\bU\u0010\u001bB\t\b\u0016¢\u0006\u0004\bU\u0010\u0014B\u0017\b\u0016\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\bU\u0010VJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\nJ%\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0006J%\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ$\u0010\"\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040 H\u0082\b¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00028\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b&\u0010%J\u0018\u0010'\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u001dJ\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0007H\u0082\b¢\u0006\u0004\b,\u0010(J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082\b¢\u0006\u0004\b\u0016\u0010\u001dJS\u00104\u001a\u00020\t2B\u00103\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u001d\u0012\u001b\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0-H\u0000¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00028\u0000¢\u0006\u0004\b8\u0010%J\u0017\u00109\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b9\u0010+J\u000f\u0010:\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b:\u0010%J\u0017\u0010;\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b;\u0010\u001dJ\u0017\u0010<\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b<\u0010\u001dJ\u0017\u0010=\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b=\u0010\u0006J\u001d\u0010>\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b>\u0010\u000fJ\u0017\u0010?\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b?\u0010(J\r\u0010@\u001a\u00028\u0000¢\u0006\u0004\b@\u0010%J\u000f\u0010A\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bA\u0010%J\r\u0010B\u001a\u00028\u0000¢\u0006\u0004\bB\u0010%J\u000f\u0010C\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bC\u0010%J\u001d\u0010D\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\bD\u0010\u000fJ \u0010E\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010201H\u0000¢\u0006\u0004\bG\u0010HJ)\u0010G\u001a\b\u0012\u0004\u0012\u00028\u000101\"\u0004\b\u0001\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u000101H\u0000¢\u0006\u0004\bG\u0010KJ\u0017\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010201H\u0016¢\u0006\u0004\bL\u0010HJ)\u0010L\u001a\b\u0012\u0004\u0012\u00028\u000101\"\u0004\b\u0001\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u000101H\u0016¢\u0006\u0004\bL\u0010KR\u001e\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u000102018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010OR$\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00078\u0017@RX\u0096\u000e¢\u0006\f\n\u0004\bQ\u0010O\u001a\u0004\bR\u0010S"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", LottieParams.KEY_ELEMENT_ID, "", ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD, "(Ljava/lang/Object;)Z", "", "index", "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(ILjava/util/Collection;)Z", "(Ljava/util/Collection;)Z", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "()V", "contains", "internalIndex", "copyCollectionElements", "(ILjava/util/Collection;)V", "newCapacity", "copyElements", "(I)V", "decremented", "(I)I", "minCapacity", "ensureCapacity", "Lkotlin/Function1;", "predicate", "filterInPlace", "(Lkotlin/jvm/functions/Function1;)Z", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "", "", "structure", "internalStructure$kotlin_stdlib", "(Lkotlin/jvm/functions/Function2;)V", "isEmpty", "()Z", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "elementData", "[Ljava/lang/Object;", "I", "p0", GriverMonitorConstants.KEY_SIZE, "getSize", "()I", "initialCapacity", "<init>", "(Ljava/util/Collection;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    private static final int defaultMinCapacity = 10;
    private static final int maxArraySize = 2147483639;
    private Object[] elementData;
    private int head;
    private int size;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object[] emptyElementData = new Object[0];

    @Override // kotlin.collections.AbstractMutableList
    @JvmName(name = "getSize")
    public final int getSize() {
        return this.size;
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = emptyElementData;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal Capacity: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        this.elementData = objArr;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            this.elementData = array;
            this.size = array.length;
            if (array.length == 0) {
                this.elementData = emptyElementData;
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (minCapacity <= objArr.length) {
            return;
        }
        if (objArr == emptyElementData) {
            this.elementData = new Object[RangesKt.coerceAtLeast(minCapacity, 10)];
        } else {
            copyElements(INSTANCE.newCapacity$kotlin_stdlib(objArr.length, minCapacity));
        }
    }

    private final void copyElements(int newCapacity) {
        Object[] objArr = new Object[newCapacity];
        Object[] objArr2 = this.elementData;
        ArraysKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i = this.head;
        ArraysKt.copyInto(objArr3, objArr, length - i, 0, i);
        this.head = 0;
        this.elementData = objArr;
    }

    private final E internalGet(int internalIndex) {
        return (E) this.elementData[internalIndex];
    }

    private final int positiveMod(int index) {
        Object[] objArr = this.elementData;
        return index >= objArr.length ? index - objArr.length : index;
    }

    private final int negativeMod(int index) {
        return index < 0 ? index + this.elementData.length : index;
    }

    private final int internalIndex(int index) {
        return positiveMod(this.head + index);
    }

    private final int incremented(int index) {
        if (index == ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    private final int decremented(int index) {
        return index == 0 ? ArraysKt.getLastIndex(this.elementData) : index - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[this.head];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    public final void addFirst(E element) {
        ensureCapacity(size() + 1);
        int decremented = decremented(this.head);
        this.head = decremented;
        this.elementData[decremented] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = element;
        this.size = size() + 1;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.elementData;
        int i = this.head;
        E e = (E) objArr[i];
        objArr[i] = null;
        this.head = incremented(i);
        this.size = size() - 1;
        return e;
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int positiveMod = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        Object[] objArr = this.elementData;
        E e = (E) objArr[positiveMod];
        objArr[positiveMod] = null;
        this.size = size() - 1;
        return e;
    }

    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public final void add(int index, E element) {
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            ensureCapacity(size() + 1);
            int positiveMod = positiveMod(this.head + index);
            if (index < ((size() + 1) >> 1)) {
                int decremented = decremented(positiveMod);
                int decremented2 = decremented(this.head);
                int i = this.head;
                if (decremented >= i) {
                    Object[] objArr = this.elementData;
                    objArr[decremented2] = objArr[i];
                    ArraysKt.copyInto(objArr, objArr, i, i + 1, decremented + 1);
                } else {
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto(objArr2, objArr2, i - 1, i, objArr2.length);
                    Object[] objArr3 = this.elementData;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt.copyInto(objArr3, objArr3, 0, 1, decremented + 1);
                }
                this.elementData[decremented] = element;
                this.head = decremented2;
            } else {
                int positiveMod2 = positiveMod(this.head + size());
                if (positiveMod < positiveMod2) {
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto(objArr4, objArr4, positiveMod + 1, positiveMod, positiveMod2);
                } else {
                    Object[] objArr5 = this.elementData;
                    ArraysKt.copyInto(objArr5, objArr5, 1, 0, positiveMod2);
                    Object[] objArr6 = this.elementData;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    ArraysKt.copyInto(objArr6, objArr6, positiveMod + 1, positiveMod, objArr6.length - 1);
                }
                this.elementData[positiveMod] = element;
            }
            this.size = size() + 1;
        }
    }

    private final void copyCollectionElements(int internalIndex, Collection<? extends E> elements) {
        Iterator<? extends E> it = elements.iterator();
        int length = this.elementData.length;
        while (internalIndex < length && it.hasNext()) {
            this.elementData[internalIndex] = it.next();
            internalIndex++;
        }
        int i = this.head;
        for (int i2 = 0; i2 < i && it.hasNext(); i2++) {
            this.elementData[i2] = it.next();
        }
        this.size = size() + elements.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + elements.size());
        copyCollectionElements(positiveMod(this.head + size()), elements);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "");
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        ensureCapacity(size() + elements.size());
        int positiveMod = positiveMod(this.head + size());
        int positiveMod2 = positiveMod(this.head + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i = this.head;
            int i2 = i - size;
            if (positiveMod2 < i) {
                Object[] objArr = this.elementData;
                ArraysKt.copyInto(objArr, objArr, i2, i, objArr.length);
                if (size >= positiveMod2) {
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, positiveMod2);
                } else {
                    Object[] objArr3 = this.elementData;
                    ArraysKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto(objArr4, objArr4, 0, size, positiveMod2);
                }
            } else if (i2 >= 0) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, i2, i, positiveMod2);
            } else {
                Object[] objArr6 = this.elementData;
                i2 += objArr6.length;
                int length = objArr6.length - i2;
                if (length >= positiveMod2 - i) {
                    ArraysKt.copyInto(objArr6, objArr6, i2, i, positiveMod2);
                } else {
                    ArraysKt.copyInto(objArr6, objArr6, i2, i, i + length);
                    Object[] objArr7 = this.elementData;
                    ArraysKt.copyInto(objArr7, objArr7, 0, this.head + length, positiveMod2);
                }
            }
            this.head = i2;
            copyCollectionElements(negativeMod(positiveMod2 - size), elements);
        } else {
            int i3 = positiveMod2 + size;
            if (positiveMod2 < positiveMod) {
                int i4 = size + positiveMod;
                Object[] objArr8 = this.elementData;
                if (i4 <= objArr8.length) {
                    ArraysKt.copyInto(objArr8, objArr8, i3, positiveMod2, positiveMod);
                } else if (i3 >= objArr8.length) {
                    ArraysKt.copyInto(objArr8, objArr8, i3 - objArr8.length, positiveMod2, positiveMod);
                } else {
                    int length2 = positiveMod - (i4 - objArr8.length);
                    ArraysKt.copyInto(objArr8, objArr8, 0, length2, positiveMod);
                    Object[] objArr9 = this.elementData;
                    ArraysKt.copyInto(objArr9, objArr9, i3, positiveMod2, length2);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt.copyInto(objArr10, objArr10, size, 0, positiveMod);
                Object[] objArr11 = this.elementData;
                if (i3 >= objArr11.length) {
                    ArraysKt.copyInto(objArr11, objArr11, i3 - objArr11.length, positiveMod2, objArr11.length);
                } else {
                    ArraysKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt.copyInto(objArr12, objArr12, i3, positiveMod2, objArr12.length - size);
                }
            }
            copyCollectionElements(positiveMod2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (E) this.elementData[positiveMod(this.head + index)];
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public final E set(int index, E element) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        int positiveMod = positiveMod(this.head + index);
        Object[] objArr = this.elementData;
        E e = (E) objArr[positiveMod];
        objArr[positiveMod] = element;
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object element) {
        int i;
        int positiveMod = positiveMod(this.head + size());
        int i2 = this.head;
        if (i2 < positiveMod) {
            while (i2 < positiveMod) {
                if (Intrinsics.areEqual(element, this.elementData[i2])) {
                    i = this.head;
                } else {
                    i2++;
                }
            }
            return -1;
        } else if (i2 < positiveMod) {
            return -1;
        } else {
            int length = this.elementData.length;
            while (true) {
                if (i2 >= length) {
                    for (int i3 = 0; i3 < positiveMod; i3++) {
                        if (Intrinsics.areEqual(element, this.elementData[i3])) {
                            i2 = i3 + this.elementData.length;
                            i = this.head;
                        }
                    }
                    return -1;
                } else if (Intrinsics.areEqual(element, this.elementData[i2])) {
                    i = this.head;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object element) {
        int lastIndex;
        int i;
        int positiveMod = positiveMod(this.head + size());
        int i2 = this.head;
        if (i2 < positiveMod) {
            lastIndex = positiveMod - 1;
            if (i2 <= lastIndex) {
                while (!Intrinsics.areEqual(element, this.elementData[lastIndex])) {
                    if (lastIndex != i2) {
                        lastIndex--;
                    }
                }
                i = this.head;
                return lastIndex - i;
            }
            return -1;
        }
        if (i2 > positiveMod) {
            int i3 = positiveMod - 1;
            while (true) {
                if (i3 >= 0) {
                    if (Intrinsics.areEqual(element, this.elementData[i3])) {
                        lastIndex = i3 + this.elementData.length;
                        i = this.head;
                        break;
                    }
                    i3--;
                } else {
                    lastIndex = ArraysKt.getLastIndex(this.elementData);
                    int i4 = this.head;
                    if (i4 <= lastIndex) {
                        while (!Intrinsics.areEqual(element, this.elementData[lastIndex])) {
                            if (lastIndex != i4) {
                                lastIndex--;
                            }
                        }
                        i = this.head;
                    }
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object element) {
        int indexOf = indexOf(element);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final E removeAt(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        ArrayDeque<E> arrayDeque = this;
        if (index == CollectionsKt.getLastIndex(arrayDeque)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        int positiveMod = positiveMod(this.head + index);
        E e = (E) this.elementData[positiveMod];
        if (index < (size() >> 1)) {
            int i = this.head;
            if (positiveMod >= i) {
                Object[] objArr = this.elementData;
                ArraysKt.copyInto(objArr, objArr, i + 1, i, positiveMod);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt.copyInto(objArr2, objArr2, 1, 0, positiveMod);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i2 = this.head;
                ArraysKt.copyInto(objArr3, objArr3, i2 + 1, i2, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i3 = this.head;
            objArr4[i3] = null;
            this.head = incremented(i3);
        } else {
            int positiveMod2 = positiveMod(this.head + CollectionsKt.getLastIndex(arrayDeque));
            if (positiveMod <= positiveMod2) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, positiveMod, positiveMod + 1, positiveMod2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                ArraysKt.copyInto(objArr6, objArr6, positiveMod, positiveMod + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt.copyInto(objArr7, objArr7, 0, 1, positiveMod2 + 1);
            }
            this.elementData[positiveMod2] = null;
        }
        this.size = size() - 1;
        return e;
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> predicate) {
        int positiveMod;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int positiveMod2 = positiveMod(this.head + size());
                int i = this.head;
                if (i < positiveMod2) {
                    positiveMod = i;
                    while (i < positiveMod2) {
                        Object obj = this.elementData[i];
                        if (predicate.invoke(obj).booleanValue()) {
                            this.elementData[positiveMod] = obj;
                            positiveMod++;
                        } else {
                            z = true;
                        }
                        i++;
                    }
                    ArraysKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
                } else {
                    int length = this.elementData.length;
                    int i2 = i;
                    boolean z2 = false;
                    while (i < length) {
                        Object[] objArr = this.elementData;
                        Object obj2 = objArr[i];
                        objArr[i] = null;
                        if (predicate.invoke(obj2).booleanValue()) {
                            this.elementData[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                        i++;
                    }
                    positiveMod = positiveMod(i2);
                    for (int i3 = 0; i3 < positiveMod2; i3++) {
                        Object[] objArr2 = this.elementData;
                        Object obj3 = objArr2[i3];
                        objArr2[i3] = null;
                        if (predicate.invoke(obj3).booleanValue()) {
                            this.elementData[positiveMod] = obj3;
                            positiveMod = incremented(positiveMod);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.size = negativeMod(positiveMod - this.head);
                }
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int positiveMod = positiveMod(this.head + size());
        int i = this.head;
        if (i < positiveMod) {
            ArraysKt.fill(this.elementData, (Object) null, i, positiveMod);
        } else if ((!isEmpty()) != false) {
            Object[] objArr = this.elementData;
            ArraysKt.fill(objArr, (Object) null, this.head, objArr.length);
            ArraysKt.fill(this.elementData, (Object) null, 0, positiveMod);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "");
        if (array.length < size()) {
            array = (T[]) ArraysKt.arrayOfNulls(array, size());
        }
        int positiveMod = positiveMod(this.head + size());
        int i = this.head;
        if (i < positiveMod) {
            ArraysKt.copyInto$default(this.elementData, array, 0, i, positiveMod, 2, (Object) null);
        } else if ((!isEmpty()) != false) {
            Object[] objArr = this.elementData;
            ArraysKt.copyInto(objArr, array, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto(objArr2, array, objArr2.length - this.head, 0, positiveMod);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] array) {
        Intrinsics.checkNotNullParameter(array, "");
        return (T[]) toArray(array);
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\b"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "(II)I", "defaultMinCapacity", "I", "", "emptyElementData", "[Ljava/lang/Object;", "maxArraySize", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int newCapacity$kotlin_stdlib(int oldCapacity, int minCapacity) {
            int i = oldCapacity + (oldCapacity >> 1);
            if (i - minCapacity < 0) {
                i = minCapacity;
            }
            if (i - ArrayDeque.maxArraySize > 0) {
                if (minCapacity > ArrayDeque.maxArraySize) {
                    return Integer.MAX_VALUE;
                }
                return ArrayDeque.maxArraySize;
            }
            return i;
        }

        private Companion() {
        }
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> structure) {
        int i;
        Intrinsics.checkNotNullParameter(structure, "");
        structure.invoke(Integer.valueOf((isEmpty() || (i = this.head) < positiveMod(this.head + size())) ? this.head : i - this.elementData.length), toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> elements) {
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int positiveMod2 = positiveMod(this.head + size());
                int i = this.head;
                if (i < positiveMod2) {
                    positiveMod = i;
                    while (i < positiveMod2) {
                        Object obj = this.elementData[i];
                        if ((!elements.contains(obj)) == true) {
                            this.elementData[positiveMod] = obj;
                            positiveMod++;
                        } else {
                            z = true;
                        }
                        i++;
                    }
                    ArraysKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
                } else {
                    int length = this.elementData.length;
                    int i2 = i;
                    boolean z2 = false;
                    while (i < length) {
                        Object[] objArr = this.elementData;
                        Object obj2 = objArr[i];
                        objArr[i] = null;
                        if ((!elements.contains(obj2)) == true) {
                            this.elementData[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                        i++;
                    }
                    positiveMod = positiveMod(i2);
                    for (int i3 = 0; i3 < positiveMod2; i3++) {
                        Object[] objArr2 = this.elementData;
                        Object obj3 = objArr2[i3];
                        objArr2[i3] = null;
                        if ((!elements.contains(obj3)) == true) {
                            this.elementData[positiveMod] = obj3;
                            positiveMod = incremented(positiveMod);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.size = negativeMod(positiveMod - this.head);
                }
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> elements) {
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int positiveMod2 = positiveMod(this.head + size());
                int i = this.head;
                if (i < positiveMod2) {
                    positiveMod = i;
                    while (i < positiveMod2) {
                        Object obj = this.elementData[i];
                        if (elements.contains(obj)) {
                            this.elementData[positiveMod] = obj;
                            positiveMod++;
                        } else {
                            z = true;
                        }
                        i++;
                    }
                    ArraysKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
                } else {
                    int length = this.elementData.length;
                    int i2 = i;
                    boolean z2 = false;
                    while (i < length) {
                        Object[] objArr = this.elementData;
                        Object obj2 = objArr[i];
                        objArr[i] = null;
                        if (elements.contains(obj2)) {
                            this.elementData[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                        i++;
                    }
                    positiveMod = positiveMod(i2);
                    for (int i3 = 0; i3 < positiveMod2; i3++) {
                        Object[] objArr2 = this.elementData;
                        Object obj3 = objArr2[i3];
                        objArr2[i3] = null;
                        if (elements.contains(obj3)) {
                            this.elementData[positiveMod] = obj3;
                            positiveMod = incremented(positiveMod);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.size = negativeMod(positiveMod - this.head);
                }
            }
        }
        return z;
    }
}
