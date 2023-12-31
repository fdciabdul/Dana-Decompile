package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlin/sequences/DropWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function1;", "", "predicate", "Lkotlin/jvm/functions/Function1;", "sequence", "Lkotlin/sequences/Sequence;", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DropWhileSequence<T> implements Sequence<T> {
    private final Function1<T, Boolean> predicate;
    private final Sequence<T> sequence;

    /* JADX WARN: Multi-variable type inference failed */
    public DropWhileSequence(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.sequence = sequence;
        this.predicate = function1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<T> iterator() {
        return new DropWhileSequence$iterator$1(this);
    }
}
