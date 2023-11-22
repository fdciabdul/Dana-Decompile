package j$.util.stream;

import j$.util.stream.Sink;

/* loaded from: classes6.dex */
abstract class SortedOps$AbstractLongSortingSink extends Sink.ChainedLong {
    protected boolean MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SortedOps$AbstractLongSortingSink(Sink sink) {
        super(sink);
    }

    @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
    public final boolean cancellationRequested() {
        this.MyBillsEntityDataFactory = true;
        return false;
    }
}
