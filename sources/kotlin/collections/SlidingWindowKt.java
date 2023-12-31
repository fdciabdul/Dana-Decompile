package kotlin.collections;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aO\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0007\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aK\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000f\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"", GriverMonitorConstants.KEY_SIZE, "step", "", "checkWindowSizeStep", "(II)V", "T", "", "iterator", "", "partialWindows", "reuseBuffer", "", "windowedIterator", "(Ljava/util/Iterator;IIZZ)Ljava/util/Iterator;", "Lkotlin/sequences/Sequence;", "windowedSequence", "(Lkotlin/sequences/Sequence;IIZZ)Lkotlin/sequences/Sequence;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int i, int i2) {
        String obj;
        if (i > 0 && i2 > 0) {
            return;
        }
        if (i != i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Both size ");
            sb.append(i);
            sb.append(" and step ");
            sb.append(i2);
            sb.append(" must be greater than zero.");
            obj = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("size ");
            sb2.append(i);
            sb2.append(" must be greater than zero.");
            obj = sb2.toString();
        }
        throw new IllegalArgumentException(obj.toString());
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> sequence, final int i, final int i2, final boolean z, final boolean z2) {
        Intrinsics.checkNotNullParameter(sequence, "");
        checkWindowSizeStep(i, i2);
        return (Sequence) ((Sequence<List<? extends T>>) new Sequence<List<? extends T>>() { // from class: kotlin.collections.SlidingWindowKt$windowedSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public final Iterator<List<? extends T>> iterator() {
                return SlidingWindowKt.windowedIterator(Sequence.this.iterator(), i, i2, z, z2);
            }
        });
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> it, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(it, "");
        return !it.hasNext() ? EmptyIterator.INSTANCE : SequencesKt.iterator(new SlidingWindowKt$windowedIterator$1(i, i2, it, z2, z, null));
    }
}
