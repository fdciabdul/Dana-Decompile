package kotlin.sequences;

import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\r\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00018\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b"}, d2 = {"Lkotlin/sequences/FlatteningSequence$iterator$1;", "", "", "ensureItemIterator", "()Z", "hasNext", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "itemIterator", "Ljava/util/Iterator;", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlatteningSequence$iterator$1<E> implements Iterator<E>, KMappedMarker, j$.util.Iterator {
    private Iterator<? extends E> itemIterator;
    private final Iterator<T> iterator;
    final /* synthetic */ FlatteningSequence<T, R, E> this$0;

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
    public FlatteningSequence$iterator$1(FlatteningSequence<T, R, E> flatteningSequence) {
        Sequence sequence;
        this.this$0 = flatteningSequence;
        sequence = ((FlatteningSequence) flatteningSequence).sequence;
        this.iterator = sequence.iterator();
    }

    @JvmName(name = "getIterator")
    public final java.util.Iterator<T> getIterator() {
        return this.iterator;
    }

    @JvmName(name = "getItemIterator")
    public final java.util.Iterator<E> getItemIterator() {
        return (java.util.Iterator<? extends E>) this.itemIterator;
    }

    @JvmName(name = "setItemIterator")
    public final void setItemIterator(java.util.Iterator<? extends E> it) {
        this.itemIterator = it;
    }

    @Override // java.util.Iterator
    public final E next() {
        if (!ensureItemIterator()) {
            throw new NoSuchElementException();
        }
        java.util.Iterator<? extends E> it = this.itemIterator;
        Intrinsics.checkNotNull(it);
        return it.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return ensureItemIterator();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean ensureItemIterator() {
        /*
            r5 = this;
            java.util.Iterator<? extends E> r0 = r5.itemIterator
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Le
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L14
            r0 = 0
            r5.itemIterator = r0
        L14:
            java.util.Iterator<? extends E> r0 = r5.itemIterator
            if (r0 != 0) goto L45
            java.util.Iterator<T> r0 = r5.iterator
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L21
            return r2
        L21:
            java.util.Iterator<T> r0 = r5.iterator
            java.lang.Object r0 = r0.next()
            kotlin.sequences.FlatteningSequence<T, R, E> r3 = r5.this$0
            kotlin.jvm.functions.Function1 r3 = kotlin.sequences.FlatteningSequence.access$getIterator$p(r3)
            kotlin.sequences.FlatteningSequence<T, R, E> r4 = r5.this$0
            kotlin.jvm.functions.Function1 r4 = kotlin.sequences.FlatteningSequence.access$getTransformer$p(r4)
            java.lang.Object r0 = r4.invoke(r0)
            java.lang.Object r0 = r3.invoke(r0)
            java.util.Iterator r0 = (java.util.Iterator) r0
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L14
            r5.itemIterator = r0
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.FlatteningSequence$iterator$1.ensureItemIterator():boolean");
    }
}
