package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.Node;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes.dex */
public final class ReduceOps$ReduceTask extends AbstractTask {
    private final Nodes op;

    public ReduceOps$ReduceTask(Nodes nodes, Node.CC cc, Spliterator spliterator) {
        super(cc, spliterator);
        this.op = nodes;
    }

    ReduceOps$ReduceTask(ReduceOps$ReduceTask reduceOps$ReduceTask, Spliterator spliterator) {
        super(reduceOps$ReduceTask, spliterator);
        this.op = reduceOps$ReduceTask.op;
    }

    @Override // j$.util.stream.AbstractTask
    public final Object doLeaf() {
        Node.CC cc = this.helper;
        ReduceOps$AccumulatingSink KClassImpl$Data$declaredNonStaticMembers$2 = this.op.KClassImpl$Data$declaredNonStaticMembers$2();
        cc.PlaceComponentResult(this.spliterator, KClassImpl$Data$declaredNonStaticMembers$2);
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // j$.util.stream.AbstractTask
    public final AbstractTask makeChild(Spliterator spliterator) {
        return new ReduceOps$ReduceTask(this, spliterator);
    }

    @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        AbstractTask abstractTask = this.leftChild;
        if (!(abstractTask == null)) {
            ReduceOps$AccumulatingSink reduceOps$AccumulatingSink = (ReduceOps$AccumulatingSink) ((ReduceOps$ReduceTask) abstractTask).getLocalResult();
            reduceOps$AccumulatingSink.MyBillsEntityDataFactory((ReduceOps$AccumulatingSink) ((ReduceOps$ReduceTask) this.rightChild).getLocalResult());
            setLocalResult(reduceOps$AccumulatingSink);
        }
        super.onCompletion(countedCompleter);
    }
}
