package kotlin.sequences;

import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00018\u00008\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u0019"}, d2 = {"Lkotlin/sequences/DropWhileSequence$iterator$1;", "", "", "drop", "()V", "", "hasNext", "()Z", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "", "dropState", "I", "getDropState", "()I", "setDropState", "(I)V", "iterator", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "nextItem", "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DropWhileSequence$iterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {
    private int dropState;
    private final Iterator<T> iterator;
    private T nextItem;
    final /* synthetic */ DropWhileSequence<T> this$0;

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
    public DropWhileSequence$iterator$1(DropWhileSequence<T> dropWhileSequence) {
        Sequence sequence;
        this.this$0 = dropWhileSequence;
        sequence = ((DropWhileSequence) dropWhileSequence).sequence;
        this.iterator = sequence.iterator();
        this.dropState = -1;
    }

    @JvmName(name = "getIterator")
    public final java.util.Iterator<T> getIterator() {
        return this.iterator;
    }

    @JvmName(name = "getDropState")
    public final int getDropState() {
        return this.dropState;
    }

    @JvmName(name = "setDropState")
    public final void setDropState(int i) {
        this.dropState = i;
    }

    @JvmName(name = "getNextItem")
    public final T getNextItem() {
        return this.nextItem;
    }

    @JvmName(name = "setNextItem")
    public final void setNextItem(T t) {
        this.nextItem = t;
    }

    private final void drop() {
        Function1 function1;
        while (this.iterator.hasNext()) {
            T next = this.iterator.next();
            function1 = ((DropWhileSequence) this.this$0).predicate;
            if (!((Boolean) function1.invoke(next)).booleanValue()) {
                this.nextItem = next;
                this.dropState = 1;
                return;
            }
        }
        this.dropState = 0;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.dropState == -1) {
            drop();
        }
        if (this.dropState == 1) {
            T t = this.nextItem;
            this.nextItem = null;
            this.dropState = 0;
            return t;
        }
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.dropState == -1) {
            drop();
        }
        return this.dropState == 1 || this.iterator.hasNext();
    }
}
