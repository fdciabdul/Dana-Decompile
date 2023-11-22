package j$.util.stream;

import j$.util.stream.Sink;

/* loaded from: classes6.dex */
abstract class SortedOps$AbstractIntSortingSink extends Sink.ChainedInt {
    protected boolean MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SortedOps$AbstractIntSortingSink(Sink sink) {
        super(sink);
    }

    @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
    public final boolean cancellationRequested() {
        this.MyBillsEntityDataFactory = true;
        return false;
    }
}
