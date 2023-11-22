package kotlin.collections.builders;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.opendevice.i;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0010+\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0001gB\t\b\u0016¢\u0006\u0004\bd\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010e\u001a\u00020\f¢\u0006\u0004\bd\u0010%BO\b\u0002\u0012\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000L\u0012\u0006\u0010`\u001a\u00020\f\u0012\u0006\u0010^\u001a\u00020\f\u0012\u0006\u0010\\\u001a\u00020\t\u0012\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\bd\u0010fJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000fJ%\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0012\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0014J-\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u000fJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u001b\u0010!\u001a\u00020\t2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010%J\u001a\u0010(\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010'H\u0096\u0002¢\u0006\u0004\b(\u0010\u000bJ\u0018\u0010)\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH\u0096\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u00102J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u000003H\u0096\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b6\u0010.J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0016¢\u0006\u0004\b8\u00109J\u001d\u00108\u001a\b\u0012\u0004\u0012\u00028\u0000072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b8\u0010:J\u0017\u0010;\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b;\u0010\u000bJ\u001d\u0010<\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b<\u0010\u0014J\u0017\u0010=\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b=\u0010*J\u0017\u0010>\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b>\u0010*J\u001f\u0010A\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\fH\u0002¢\u0006\u0004\bA\u00100J\u001d\u0010B\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\bB\u0010\u0014J5\u0010D\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010C\u001a\u00020\tH\u0002¢\u0006\u0004\bD\u0010EJ \u0010F\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\bF\u0010GJ%\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fH\u0016¢\u0006\u0004\bJ\u0010KJ\u0017\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0LH\u0016¢\u0006\u0004\bM\u0010NJ)\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00010L\"\u0004\b\u0001\u0010O2\f\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00010LH\u0016¢\u0006\u0004\bM\u0010QJ\u000f\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020'H\u0002¢\u0006\u0004\bU\u0010VR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u001c\u0010Y\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\t8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u00102R\u0016\u0010\\\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u0010_R\u001c\u0010a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\ba\u0010ZR\u0014\u0010c\u001a\u00020\f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010,"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", LottieParams.KEY_ELEMENT_ID, "", ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD, "(Ljava/lang/Object;)Z", "", "index", "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(ILjava/util/Collection;)Z", "(Ljava/util/Collection;)Z", i.MyBillsEntityDataFactory, "n", "addAllInternal", "(ILjava/util/Collection;I)V", "addAtInternal", "", "build", "()Ljava/util/List;", "checkIsMutable", "()V", "clear", "other", "contentEquals", "(Ljava/util/List;)Z", "minCapacity", "ensureCapacity", "(I)V", "ensureExtraCapacity", "", "equals", "get", "(I)Ljava/lang/Object;", "hashCode", "()I", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "(II)V", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "remove", "removeAll", "removeAt", "removeAtInternal", "rangeOffset", "rangeLength", "removeRangeInternal", "retainAll", "retain", "retainOrRemoveAllInternal", "(IILjava/util/Collection;Z)I", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "", "toArray", "()[Ljava/lang/Object;", "T", FirebaseAnalytics.Param.DESTINATION, "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "writeReplace", "()Ljava/lang/Object;", "array", "[Ljava/lang/Object;", "backing", "Lkotlin/collections/builders/ListBuilder;", "isEffectivelyReadOnly", "isReadOnly", "Z", "length", "I", "offset", "root", "getSize", GriverMonitorConstants.KEY_SIZE, "<init>", "initialCapacity", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "Itr"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    private E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    private final ListBuilder<E> root;

    private ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i;
        this.length = i2;
        this.isReadOnly = z;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), 0, 0, false, null, null);
    }

    public final List<E> build() {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        checkIsMutable();
        this.isReadOnly = true;
        return this;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.AbstractMutableList
    @JvmName(name = "getSize")
    public final int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.array[this.offset + index];
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public final E set(int index, E element) {
        checkIsMutable();
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        E[] eArr = this.array;
        int i = this.offset + index;
        E e = eArr[i];
        eArr[i] = element;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object element) {
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual(this.array[this.offset + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object element) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.array[this.offset + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator(int index) {
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        return new Itr(this, index);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E element) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, element);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public final void add(int index, E element) {
        checkIsMutable();
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        addAtInternal(this.offset + index, element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "");
        checkIsMutable();
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        int size = elements.size();
        addAllInternal(this.offset + index, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // kotlin.collections.AbstractMutableList
    public final E removeAt(int index) {
        checkIsMutable();
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        return removeAtInternal(this.offset + index);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object element) {
        checkIsMutable();
        int indexOf = indexOf(element);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List<E> subList(int fromIndex, int toIndex) {
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
        E[] eArr = this.array;
        int i = this.offset;
        boolean z = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i + fromIndex, toIndex - fromIndex, z, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] destination) {
        Intrinsics.checkNotNullParameter(destination, "");
        int length = destination.length;
        int i = this.length;
        if (length < i) {
            E[] eArr = this.array;
            int i2 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i2, i + i2, destination.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, "");
            return tArr;
        }
        E[] eArr2 = this.array;
        int i3 = this.offset;
        ArraysKt.copyInto(eArr2, destination, 0, i3, i + i3);
        int length2 = destination.length;
        int i4 = this.length;
        if (length2 > i4) {
            destination[i4] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        E[] eArr = this.array;
        int i = this.offset;
        return ArraysKt.copyOfRange(eArr, i, this.length + i);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object other) {
        return other == this || ((other instanceof List) && contentEquals((List) other));
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int subarrayContentHashCode;
        subarrayContentHashCode = ListBuilderKt.subarrayContentHashCode(this.array, this.offset, this.length);
        return subarrayContentHashCode;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String subarrayContentToString;
        subarrayContentToString = ListBuilderKt.subarrayContentToString(this.array, this.offset, this.length);
        return subarrayContentToString;
    }

    private final void ensureCapacity(int minCapacity) {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity > this.array.length) {
            this.array = (E[]) ListBuilderKt.copyOfUninitializedElements(this.array, ArrayDeque.INSTANCE.newCapacity$kotlin_stdlib(this.array.length, minCapacity));
        }
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    @JvmName(name = "isEffectivelyReadOnly")
    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        return this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly);
    }

    private final void ensureExtraCapacity(int n) {
        ensureCapacity(this.length + n);
    }

    private final boolean contentEquals(List<?> other) {
        boolean subarrayContentEquals;
        subarrayContentEquals = ListBuilderKt.subarrayContentEquals(this.array, this.offset, this.length, other);
        return subarrayContentEquals;
    }

    private final void insertAtInternal(int i, int n) {
        ensureExtraCapacity(n);
        E[] eArr = this.array;
        ArraysKt.copyInto(eArr, eArr, i + n, i, this.offset + this.length);
        this.length += n;
    }

    private final void addAtInternal(int i, E element) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i, element);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i, 1);
        this.array[i] = element;
    }

    private final void addAllInternal(int i, Collection<? extends E> elements, int n) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i, elements, n);
            this.array = this.backing.array;
            this.length += n;
            return;
        }
        insertAtInternal(i, n);
        Iterator<? extends E> it = elements.iterator();
        for (int i2 = 0; i2 < n; i2++) {
            this.array[i + i2] = it.next();
        }
    }

    private final E removeAtInternal(int i) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i);
        }
        E[] eArr = this.array;
        E e = eArr[i];
        ArraysKt.copyInto(eArr, eArr, i, i + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e;
    }

    private final void removeRangeInternal(int rangeOffset, int rangeLength) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(rangeOffset, rangeLength);
        } else {
            E[] eArr = this.array;
            ArraysKt.copyInto(eArr, eArr, rangeOffset, rangeOffset + rangeLength, this.length);
            E[] eArr2 = this.array;
            int i = this.length;
            ListBuilderKt.resetRange(eArr2, i - rangeLength, i);
        }
        this.length -= rangeLength;
    }

    private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i = 0;
        int i2 = 0;
        while (i < rangeLength) {
            int i3 = rangeOffset + i;
            if (elements.contains(this.array[i3]) == retain) {
                E[] eArr = this.array;
                i++;
                eArr[i2 + rangeOffset] = eArr[i3];
                i2++;
            } else {
                i++;
            }
        }
        int i4 = rangeLength - i2;
        E[] eArr2 = this.array;
        ArraysKt.copyInto(eArr2, eArr2, i2 + rangeOffset, rangeLength + rangeOffset, this.length);
        E[] eArr3 = this.array;
        int i5 = this.length;
        ListBuilderKt.resetRange(eArr3, i5 - i4, i5);
        this.length -= i4;
        return i4;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\b\u0016\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018\u0012\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", LottieParams.KEY_ELEMENT_ID, "", ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD, "(Ljava/lang/Object;)V", "", "hasNext", "()Z", "hasPrevious", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "", "nextIndex", "()I", "previous", "previousIndex", "remove", "()V", "set", "index", "I", "lastIndex", "Lkotlin/collections/builders/ListBuilder;", "list", "Lkotlin/collections/builders/ListBuilder;", "<init>", "(Lkotlin/collections/builders/ListBuilder;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    static final class Itr<E> implements ListIterator<E>, KMutableListIterator, j$.util.Iterator {
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        public Itr(ListBuilder<E> listBuilder, int i) {
            Intrinsics.checkNotNullParameter(listBuilder, "");
            this.list = listBuilder;
            this.index = i;
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.index < ((ListBuilder) this.list).length;
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public final E previous() {
            int i = this.index;
            if (i <= 0) {
                throw new NoSuchElementException();
            }
            int i2 = i - 1;
            this.index = i2;
            this.lastIndex = i2;
            return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final E next() {
            if (this.index >= ((ListBuilder) this.list).length) {
                throw new NoSuchElementException();
            }
            int i = this.index;
            this.index = i + 1;
            this.lastIndex = i;
            return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
        }

        @Override // java.util.ListIterator
        public final void set(E element) {
            int i = this.lastIndex;
            if (!(i != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.list.set(i, element);
        }

        @Override // java.util.ListIterator
        public final void add(E element) {
            ListBuilder<E> listBuilder = this.list;
            int i = this.index;
            this.index = i + 1;
            listBuilder.add(i, element);
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            int i = this.lastIndex;
            if (!(i != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.list.remove(i);
            this.index = this.lastIndex;
            this.lastIndex = -1;
        }
    }
}
