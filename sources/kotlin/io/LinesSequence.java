package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "", "iterator", "()Ljava/util/Iterator;", "Ljava/io/BufferedReader;", "reader", "Ljava/io/BufferedReader;", "<init>", "(Ljava/io/BufferedReader;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final class LinesSequence implements Sequence<String> {
    private final BufferedReader reader;

    public LinesSequence(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "");
        this.reader = bufferedReader;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<String> iterator() {
        return new LinesSequence$iterator$1(this);
    }
}
