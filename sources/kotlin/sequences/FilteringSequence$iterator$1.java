package kotlin.sequences;

import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00018\u00008\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019"}, d2 = {"Lkotlin/sequences/FilteringSequence$iterator$1;", "", "", "calcNext", "()V", "", "hasNext", "()Z", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "iterator", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "nextItem", "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V", "", "nextState", "I", "getNextState", "()I", "setNextState", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FilteringSequence$iterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {
    private final Iterator<T> iterator;
    private T nextItem;
    private int nextState;
    final /* synthetic */ FilteringSequence<T> this$0;

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilteringSequence$iterator$1(FilteringSequence<T> filteringSequence) {
        Sequence sequence;
        this.this$0 = filteringSequence;
        sequence = ((FilteringSequence) filteringSequence).sequence;
        this.iterator = sequence.iterator();
        this.nextState = -1;
    }

    @JvmName(name = "getIterator")
    public final java.util.Iterator<T> getIterator() {
        return this.iterator;
    }

    @JvmName(name = "getNextState")
    public final int getNextState() {
        return this.nextState;
    }

    @JvmName(name = "setNextState")
    public final void setNextState(int i) {
        this.nextState = i;
    }

    @JvmName(name = "getNextItem")
    public final T getNextItem() {
        return this.nextItem;
    }

    @JvmName(name = "setNextItem")
    public final void setNextItem(T t) {
        this.nextItem = t;
    }

    private final void calcNext() {
        Function1 function1;
        boolean z;
        while (this.iterator.hasNext()) {
            T next = this.iterator.next();
            function1 = ((FilteringSequence) this.this$0).predicate;
            boolean booleanValue = ((Boolean) function1.invoke(next)).booleanValue();
            z = ((FilteringSequence) this.this$0).sendWhen;
            if (booleanValue == z) {
                this.nextItem = next;
                this.nextState = 1;
                return;
            }
        }
        this.nextState = 0;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState == 0) {
            throw new NoSuchElementException();
        }
        T t = this.nextItem;
        this.nextItem = null;
        this.nextState = -1;
        return t;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        return this.nextState == 1;
    }
}
