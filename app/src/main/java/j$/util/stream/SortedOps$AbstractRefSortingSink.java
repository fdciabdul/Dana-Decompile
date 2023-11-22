package j$.util.stream;

import j$.util.stream.Sink;
import java.util.Comparator;

/* loaded from: classes6.dex */
abstract class SortedOps$AbstractRefSortingSink extends Sink.ChainedReference {
    protected final Comparator KClassImpl$Data$declaredNonStaticMembers$2;
    protected boolean PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SortedOps$AbstractRefSortingSink(Sink sink, Comparator comparator) {
        super(sink);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = comparator;
    }

    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
    public final boolean cancellationRequested() {
        this.PlaceComponentResult = true;
        return false;
    }
}
