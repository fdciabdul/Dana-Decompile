package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;
import j$.util.stream.Node;
import j$.util.stream.Nodes;

/* loaded from: classes.dex */
final class SliceOps$SliceTask extends AbstractShortCircuitTask {
    private volatile boolean completed;
    private final IntFunction generator;
    private final AbstractPipeline op;
    private final long targetOffset;
    private final long targetSize;
    private long thisNodeSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SliceOps$SliceTask(AbstractPipeline abstractPipeline, AbstractPipeline abstractPipeline2, Spliterator spliterator, IntFunction intFunction, long j, long j2) {
        super(abstractPipeline2, spliterator);
        this.op = abstractPipeline;
        this.generator = intFunction;
        this.targetOffset = j;
        this.targetSize = j2;
    }

    SliceOps$SliceTask(SliceOps$SliceTask sliceOps$SliceTask, Spliterator spliterator) {
        super(sliceOps$SliceTask, spliterator);
        this.op = sliceOps$SliceTask.op;
        this.generator = sliceOps$SliceTask.generator;
        this.targetOffset = sliceOps$SliceTask.targetOffset;
        this.targetSize = sliceOps$SliceTask.targetSize;
    }

    private long completedSize(long j) {
        if (this.completed) {
            return this.thisNodeSize;
        }
        SliceOps$SliceTask sliceOps$SliceTask = (SliceOps$SliceTask) this.leftChild;
        SliceOps$SliceTask sliceOps$SliceTask2 = (SliceOps$SliceTask) this.rightChild;
        if (sliceOps$SliceTask == null || sliceOps$SliceTask2 == null) {
            return this.thisNodeSize;
        }
        long completedSize = sliceOps$SliceTask.completedSize(j);
        return completedSize >= j ? completedSize : completedSize + sliceOps$SliceTask2.completedSize(j);
    }

    @Override // j$.util.stream.AbstractShortCircuitTask
    protected final void cancel() {
        this.canceled = true;
        if (this.completed) {
            setLocalResult(getEmptyResult());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractTask
    public final Object doLeaf() {
        if (getParent() == null) {
            Node.Builder BuiltInFictitiousFunctionClassFactory = this.op.BuiltInFictitiousFunctionClassFactory(StreamOpFlag.SIZED.isPreserved(this.op.MyBillsEntityDataFactory) ? this.op.getAuthRequestContext(this.spliterator) : -1L, this.generator);
            Sink authRequestContext = this.op.getAuthRequestContext(this.helper.getAuthRequestContext(), BuiltInFictitiousFunctionClassFactory);
            Node.CC cc = this.helper;
            cc.MyBillsEntityDataFactory(this.spliterator, cc.getAuthRequestContext(authRequestContext));
            return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        }
        Node.CC cc2 = this.helper;
        Node.Builder BuiltInFictitiousFunctionClassFactory2 = cc2.BuiltInFictitiousFunctionClassFactory(-1L, this.generator);
        cc2.PlaceComponentResult(this.spliterator, BuiltInFictitiousFunctionClassFactory2);
        Node PlaceComponentResult = BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult();
        this.thisNodeSize = PlaceComponentResult.s_();
        this.completed = true;
        this.spliterator = null;
        return PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractShortCircuitTask
    public final Nodes.EmptyNode getEmptyResult() {
        return Nodes.getAuthRequestContext(this.op.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractTask
    public final AbstractTask makeChild(Spliterator spliterator) {
        return new SliceOps$SliceTask(this, spliterator);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e0, code lost:
    
        if (r5 >= r3) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5  */
    @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCompletion(java.util.concurrent.CountedCompleter r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.SliceOps$SliceTask.onCompletion(java.util.concurrent.CountedCompleter):void");
    }
}
