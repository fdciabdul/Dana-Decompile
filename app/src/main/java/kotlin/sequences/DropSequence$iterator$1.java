package kotlin.sequences;

import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014"}, d2 = {"Lkotlin/sequences/DropSequence$iterator$1;", "", "", "drop", "()V", "", "hasNext", "()Z", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "iterator", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "", "left", "I", "getLeft", "()I", "setLeft", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DropSequence$iterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {
    private final Iterator<T> iterator;
    private int left;

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
    public DropSequence$iterator$1(DropSequence<T> dropSequence) {
        Sequence sequence;
        int i;
        sequence = ((DropSequence) dropSequence).sequence;
        this.iterator = sequence.iterator();
        i = ((DropSequence) dropSequence).count;
        this.left = i;
    }

    @JvmName(name = "getIterator")
    public final java.util.Iterator<T> getIterator() {
        return this.iterator;
    }

    @JvmName(name = "getLeft")
    public final int getLeft() {
        return this.left;
    }

    @JvmName(name = "setLeft")
    public final void setLeft(int i) {
        this.left = i;
    }

    private final void drop() {
        while (this.left > 0 && this.iterator.hasNext()) {
            this.iterator.next();
            this.left--;
        }
    }

    @Override // java.util.Iterator
    public final T next() {
        drop();
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        drop();
        return this.iterator.hasNext();
    }
}
