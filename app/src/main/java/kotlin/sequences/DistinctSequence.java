package kotlin.sequences;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlin/sequences/DistinctSequence;", "T", DiskFormatter.KB, "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function1;", "keySelector", "Lkotlin/jvm/functions/Function1;", "source", "Lkotlin/sequences/Sequence;", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DistinctSequence<T, K> implements Sequence<T> {
    private final Function1<T, K> keySelector;
    private final Sequence<T> source;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.source = sequence;
        this.keySelector = function1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<T> iterator() {
        return new DistinctIterator(this.source.iterator(), this.keySelector);
    }
}
