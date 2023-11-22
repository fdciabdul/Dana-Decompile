package kotlin.sequences;

import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00018\u00008\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lkotlin/sequences/GeneratorSequence$iterator$1;", "", "", "calcNext", "()V", "", "hasNext", "()Z", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "nextItem", "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V", "", "nextState", "I", "getNextState", "()I", "setNextState", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GeneratorSequence$iterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {
    private T nextItem;
    private int nextState = -2;
    final /* synthetic */ GeneratorSequence<T> this$0;

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
    public GeneratorSequence$iterator$1(GeneratorSequence<T> generatorSequence) {
        this.this$0 = generatorSequence;
    }

    @JvmName(name = "getNextItem")
    public final T getNextItem() {
        return this.nextItem;
    }

    @JvmName(name = "setNextItem")
    public final void setNextItem(T t) {
        this.nextItem = t;
    }

    @JvmName(name = "getNextState")
    public final int getNextState() {
        return this.nextState;
    }

    @JvmName(name = "setNextState")
    public final void setNextState(int i) {
        this.nextState = i;
    }

    private final void calcNext() {
        Function1 function1;
        T t;
        Function0 function0;
        if (this.nextState == -2) {
            function0 = ((GeneratorSequence) this.this$0).getInitialValue;
            t = (T) function0.invoke();
        } else {
            function1 = ((GeneratorSequence) this.this$0).getNextValue;
            T t2 = this.nextItem;
            Intrinsics.checkNotNull(t2);
            t = (T) function1.invoke(t2);
        }
        this.nextItem = t;
        this.nextState = t == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.nextState < 0) {
            calcNext();
        }
        if (this.nextState == 0) {
            throw new NoSuchElementException();
        }
        T t = this.nextItem;
        if (t == null) {
            throw new NullPointerException("null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        }
        this.nextState = -1;
        return t;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextState < 0) {
            calcNext();
        }
        return this.nextState == 1;
    }
}
