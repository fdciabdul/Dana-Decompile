package kotlin.collections;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\t¢\u0006\u0004\b*\u0010\u0018B\u001f\u0012\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019\u0012\u0006\u0010+\u001a\u00020\t¢\u0006\u0004\b*\u0010,J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019\"\u0004\b\u0001\u0010\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001eJ\u001c\u0010\u001f\u001a\u00020\t*\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0082\b¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t8\u0017@RX\u0096\u000e¢\u0006\f\n\u0004\b&\u0010$\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010$"}, d2 = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", LottieParams.KEY_ELEMENT_ID, "", ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD, "(Ljava/lang/Object;)V", "", "maxCapacity", "expanded", "(I)Lkotlin/collections/RingBuffer;", "index", "get", "(I)Ljava/lang/Object;", "", "isFull", "()Z", "", "iterator", "()Ljava/util/Iterator;", "n", "removeFirst", "(I)V", "", "", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "(II)I", "buffer", "[Ljava/lang/Object;", "capacity", "I", "p0", GriverMonitorConstants.KEY_SIZE, "getSize", "()I", "startIndex", "<init>", "filledSize", "([Ljava/lang/Object;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(Object[] objArr, int i) {
        Intrinsics.checkNotNullParameter(objArr, "");
        this.buffer = objArr;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("ring buffer filled size should not be negative but it is ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        if (!(i <= objArr.length)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ring buffer filled size: ");
            sb2.append(i);
            sb2.append(" cannot be larger than the buffer size: ");
            sb2.append(objArr.length);
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        this.capacity = objArr.length;
        this.size = i;
    }

    public RingBuffer(int i) {
        this(new Object[i], 0);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    @JvmName(name = "getSize")
    /* renamed from: getSize  reason: from getter */
    public final int get_size() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final T get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (T) this.buffer[(this.startIndex + index) % this.capacity];
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer$iterator$1
            private int count;
            private int index;
            final /* synthetic */ RingBuffer<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i;
                this.this$0 = this;
                this.count = this.size();
                i = ((RingBuffer) this).startIndex;
                this.index = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected final void computeNext() {
                Object[] objArr;
                if (this.count != 0) {
                    objArr = ((RingBuffer) this.this$0).buffer;
                    setNext(objArr[this.index]);
                    this.index = (this.index + 1) % ((RingBuffer) this.this$0).capacity;
                    this.count--;
                    return;
                }
                done();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            Intrinsics.checkNotNullExpressionValue(array, "");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.startIndex; i2 < size && i3 < this.capacity; i3++) {
            array[i2] = this.buffer[i3];
            i2++;
        }
        while (i2 < size) {
            array[i2] = this.buffer[i];
            i2++;
            i++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> expanded(int maxCapacity) {
        Object[] array;
        int i = this.capacity;
        int coerceAtMost = RangesKt.coerceAtMost(i + (i >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(array, "");
        } else {
            array = toArray(new Object[coerceAtMost]);
        }
        return new RingBuffer<>(array, size());
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T element) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = element;
        this.size = size() + 1;
    }

    public final void removeFirst(int n) {
        if (!(n >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("n shouldn't be negative but it is ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        if (!(n <= size())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("n shouldn't be greater than the buffer size: n = ");
            sb2.append(n);
            sb2.append(", size = ");
            sb2.append(size());
            throw new IllegalArgumentException(sb2.toString().toString());
        } else if (n > 0) {
            int i = this.startIndex;
            int i2 = (i + n) % this.capacity;
            if (i > i2) {
                ArraysKt.fill(this.buffer, (Object) null, i, this.capacity);
                ArraysKt.fill(this.buffer, (Object) null, 0, i2);
            } else {
                ArraysKt.fill(this.buffer, (Object) null, i, i2);
            }
            this.startIndex = i2;
            this.size = size() - n;
        }
    }

    private final int forward(int i, int i2) {
        return (i + i2) % this.capacity;
    }
}
