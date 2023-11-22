package kotlin.sequences;

import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014"}, d2 = {"Lkotlin/sequences/SubSequence$iterator$1;", "", "", "drop", "()V", "", "hasNext", "()Z", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "iterator", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "", "position", "I", "getPosition", "()I", "setPosition", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SubSequence$iterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {
    private final Iterator<T> iterator;
    private int position;
    final /* synthetic */ SubSequence<T> this$0;

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
    public SubSequence$iterator$1(SubSequence<T> subSequence) {
        Sequence sequence;
        this.this$0 = subSequence;
        sequence = ((SubSequence) subSequence).sequence;
        this.iterator = sequence.iterator();
    }

    @JvmName(name = "getIterator")
    public final java.util.Iterator<T> getIterator() {
        return this.iterator;
    }

    @JvmName(name = "getPosition")
    public final int getPosition() {
        return this.position;
    }

    @JvmName(name = "setPosition")
    public final void setPosition(int i) {
        this.position = i;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void drop() {
        /*
            r2 = this;
        L0:
            int r0 = r2.position
            kotlin.sequences.SubSequence<T> r1 = r2.this$0
            int r1 = kotlin.sequences.SubSequence.access$getStartIndex$p(r1)
            if (r0 >= r1) goto L1e
            java.util.Iterator<T> r0 = r2.iterator
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L1e
            java.util.Iterator<T> r0 = r2.iterator
            r0.next()
            int r0 = r2.position
            int r0 = r0 + 1
            r2.position = r0
            goto L0
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SubSequence$iterator$1.drop():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        drop();
        int i2 = this.position;
        i = ((SubSequence) this.this$0).endIndex;
        return i2 < i && this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        int i;
        drop();
        int i2 = this.position;
        i = ((SubSequence) this.this$0).endIndex;
        if (i2 >= i) {
            throw new NoSuchElementException();
        }
        this.position++;
        return this.iterator.next();
    }
}
