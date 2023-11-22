package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "", "n", "drop", "(I)Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "take", "count", "I", "sequence", "Lkotlin/sequences/Sequence;", "<init>", "(Lkotlin/sequences/Sequence;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int count;
    private final Sequence<T> sequence;

    /* JADX WARN: Multi-variable type inference failed */
    public DropSequence(Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "");
        this.sequence = sequence;
        this.count = i;
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("count must be non-negative, but was ");
        sb.append(i);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence<T> drop(int n) {
        int i = this.count + n;
        return i < 0 ? new DropSequence(this, n) : new DropSequence(this.sequence, i);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence<T> take(int n) {
        int i = this.count;
        int i2 = i + n;
        return i2 < 0 ? new TakeSequence(this, n) : new SubSequence(this.sequence, i, i2);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<T> iterator() {
        return new DropSequence$iterator$1(this);
    }
}
