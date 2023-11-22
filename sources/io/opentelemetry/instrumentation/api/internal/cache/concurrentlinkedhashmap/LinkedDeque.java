package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

import io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.Linked;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes9.dex */
final class LinkedDeque<E extends Linked<E>> extends AbstractCollection<E> implements Deque<E> {
    E first;
    E last;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface Linked<T extends Linked<T>> {
        T getNext();

        T getPrevious();

        void setNext(T t);

        void setPrevious(T t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((LinkedDeque<E>) ((Linked) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Deque
    public final /* bridge */ /* synthetic */ void addFirst(Object obj) {
        addFirst((LinkedDeque<E>) ((Linked) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Deque
    public final /* bridge */ /* synthetic */ void addLast(Object obj) {
        addLast((LinkedDeque<E>) ((Linked) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Deque, java.util.Queue
    public final /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return offer((LinkedDeque<E>) ((Linked) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Deque
    public final /* bridge */ /* synthetic */ boolean offerFirst(Object obj) {
        return offerFirst((LinkedDeque<E>) ((Linked) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Deque
    public final /* bridge */ /* synthetic */ boolean offerLast(Object obj) {
        return offerLast((LinkedDeque<E>) ((Linked) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Deque
    public final /* bridge */ /* synthetic */ void push(Object obj) {
        push((LinkedDeque<E>) ((Linked) obj));
    }

    final void linkFirst(E e) {
        E e2 = this.first;
        this.first = e;
        if (e2 == null) {
            this.last = e;
            return;
        }
        e2.setPrevious(e);
        e.setNext(e2);
    }

    final void linkLast(E e) {
        E e2 = this.last;
        this.last = e;
        if (e2 == null) {
            this.first = e;
            return;
        }
        e2.setNext(e);
        e.setPrevious(e2);
    }

    final E unlinkFirst() {
        E e = this.first;
        E e2 = (E) e.getNext();
        e.setNext(null);
        this.first = e2;
        if (e2 == null) {
            this.last = null;
        } else {
            e2.setPrevious(null);
        }
        return e;
    }

    final E unlinkLast() {
        E e = this.last;
        E e2 = (E) e.getPrevious();
        e.setPrevious(null);
        this.last = e2;
        if (e2 == null) {
            this.first = null;
        } else {
            e2.setNext(null);
        }
        return e;
    }

    final void unlink(E e) {
        E e2 = (E) e.getPrevious();
        E e3 = (E) e.getNext();
        if (e2 == null) {
            this.first = e3;
        } else {
            e2.setNext(e3);
            e.setPrevious(null);
        }
        if (e3 == null) {
            this.last = e2;
            return;
        }
        e3.setPrevious(e2);
        e.setNext(null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.first == null;
    }

    final void checkNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final int size() {
        int i = 0;
        for (Linked linked = this.first; linked != null; linked = linked.getNext()) {
            i++;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque$Linked] */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        E e = this.first;
        while (e != null) {
            ?? next = e.getNext();
            e.setPrevious(null);
            e.setNext(null);
            e = next;
        }
        this.last = null;
        this.first = null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final boolean contains(Object obj) {
        return (obj instanceof Linked) && contains((Linked) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean contains(Linked<?> linked) {
        return (linked.getPrevious() == null && linked.getNext() == null && linked != this.first) ? false : true;
    }

    public final void moveToFront(E e) {
        if (e != this.first) {
            unlink(e);
            linkFirst(e);
        }
    }

    public final void moveToBack(E e) {
        if (e != this.last) {
            unlink(e);
            linkLast(e);
        }
    }

    @Override // java.util.Deque, java.util.Queue
    public final E peek() {
        return peekFirst();
    }

    @Override // java.util.Deque
    public final E peekFirst() {
        return this.first;
    }

    @Override // java.util.Deque
    public final E peekLast() {
        return this.last;
    }

    @Override // java.util.Deque
    public final E getFirst() {
        checkNotEmpty();
        return peekFirst();
    }

    @Override // java.util.Deque
    public final E getLast() {
        checkNotEmpty();
        return peekLast();
    }

    @Override // java.util.Deque, java.util.Queue
    public final E element() {
        return getFirst();
    }

    public final boolean offer(E e) {
        return offerLast((LinkedDeque<E>) e);
    }

    public final boolean offerFirst(E e) {
        if (contains((Linked<?>) e)) {
            return false;
        }
        linkFirst(e);
        return true;
    }

    public final boolean offerLast(E e) {
        if (contains((Linked<?>) e)) {
            return false;
        }
        linkLast(e);
        return true;
    }

    public final boolean add(E e) {
        return offerLast((LinkedDeque<E>) e);
    }

    public final void addFirst(E e) {
        if (!offerFirst((LinkedDeque<E>) e)) {
            throw new IllegalArgumentException();
        }
    }

    public final void addLast(E e) {
        if (!offerLast((LinkedDeque<E>) e)) {
            throw new IllegalArgumentException();
        }
    }

    @Override // java.util.Deque, java.util.Queue
    public final E poll() {
        return pollFirst();
    }

    @Override // java.util.Deque
    public final E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        return unlinkFirst();
    }

    @Override // java.util.Deque
    public final E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return unlinkLast();
    }

    @Override // java.util.Deque, java.util.Queue
    public final E remove() {
        return removeFirst();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final boolean remove(Object obj) {
        return (obj instanceof Linked) && remove((LinkedDeque<E>) ((Linked) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean remove(E e) {
        if (contains((Linked<?>) e)) {
            unlink(e);
            return true;
        }
        return false;
    }

    @Override // java.util.Deque
    public final E removeFirst() {
        checkNotEmpty();
        return pollFirst();
    }

    @Override // java.util.Deque
    public final boolean removeFirstOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.Deque
    public final E removeLast() {
        checkNotEmpty();
        return pollLast();
    }

    @Override // java.util.Deque
    public final boolean removeLastOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    public final void push(E e) {
        addFirst((LinkedDeque<E>) e);
    }

    @Override // java.util.Deque
    public final E pop() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Deque
    public final Iterator<E> iterator() {
        return new AbstractLinkedIterator(this.first) { // from class: io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.1
            @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.AbstractLinkedIterator
            E computeNext() {
                return (E) this.cursor.getNext();
            }
        };
    }

    @Override // java.util.Deque
    public final Iterator<E> descendingIterator() {
        return new AbstractLinkedIterator(this.last) { // from class: io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.2
            @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.AbstractLinkedIterator
            E computeNext() {
                return (E) this.cursor.getPrevious();
            }
        };
    }

    /* loaded from: classes9.dex */
    abstract class AbstractLinkedIterator implements Iterator<E>, j$.util.Iterator {
        E cursor;

        abstract E computeNext();

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        AbstractLinkedIterator(E e) {
            this.cursor = e;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != null;
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E e = this.cursor;
            this.cursor = (E) computeNext();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
