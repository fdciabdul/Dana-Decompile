package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.stream.Node;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes.dex */
final class ForEachOps$ForEachOrderedTask extends CountedCompleter {
    public static final /* synthetic */ int $r8$clinit = 0;
    private final Sink action;
    private final ConcurrentHashMap completionMap;
    private final Node.CC helper;
    private final ForEachOps$ForEachOrderedTask leftPredecessor;
    private Node node;
    private Spliterator spliterator;
    private final long targetSize;

    ForEachOps$ForEachOrderedTask(ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask, Spliterator spliterator, ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask2) {
        super(forEachOps$ForEachOrderedTask);
        this.helper = forEachOps$ForEachOrderedTask.helper;
        this.spliterator = spliterator;
        this.targetSize = forEachOps$ForEachOrderedTask.targetSize;
        this.completionMap = forEachOps$ForEachOrderedTask.completionMap;
        this.action = forEachOps$ForEachOrderedTask.action;
        this.leftPredecessor = forEachOps$ForEachOrderedTask2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ForEachOps$ForEachOrderedTask(Node.CC cc, Spliterator spliterator, Sink sink) {
        super(null);
        this.helper = cc;
        this.spliterator = spliterator;
        this.targetSize = AbstractTask.suggestTargetSize(spliterator.KClassImpl$Data$declaredNonStaticMembers$2());
        this.completionMap = new ConcurrentHashMap(Math.max(16, AbstractTask.LEAF_TARGET << 1));
        this.action = sink;
        this.leftPredecessor = null;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator moveToNextValue;
        Spliterator spliterator = this.spliterator;
        long j = this.targetSize;
        boolean z = false;
        ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask = this;
        while (spliterator.KClassImpl$Data$declaredNonStaticMembers$2() > j && (moveToNextValue = spliterator.moveToNextValue()) != null) {
            ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask2 = new ForEachOps$ForEachOrderedTask(forEachOps$ForEachOrderedTask, moveToNextValue, forEachOps$ForEachOrderedTask.leftPredecessor);
            ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask3 = new ForEachOps$ForEachOrderedTask(forEachOps$ForEachOrderedTask, spliterator, forEachOps$ForEachOrderedTask2);
            forEachOps$ForEachOrderedTask.addToPendingCount(1);
            forEachOps$ForEachOrderedTask3.addToPendingCount(1);
            forEachOps$ForEachOrderedTask.completionMap.put(forEachOps$ForEachOrderedTask2, forEachOps$ForEachOrderedTask3);
            if (forEachOps$ForEachOrderedTask.leftPredecessor != null) {
                forEachOps$ForEachOrderedTask2.addToPendingCount(1);
                if (forEachOps$ForEachOrderedTask.completionMap.replace(forEachOps$ForEachOrderedTask.leftPredecessor, forEachOps$ForEachOrderedTask, forEachOps$ForEachOrderedTask2)) {
                    forEachOps$ForEachOrderedTask.addToPendingCount(-1);
                } else {
                    forEachOps$ForEachOrderedTask2.addToPendingCount(-1);
                }
            }
            if (z) {
                spliterator = moveToNextValue;
                forEachOps$ForEachOrderedTask = forEachOps$ForEachOrderedTask2;
                forEachOps$ForEachOrderedTask2 = forEachOps$ForEachOrderedTask3;
            } else {
                forEachOps$ForEachOrderedTask = forEachOps$ForEachOrderedTask3;
            }
            z = !z;
            forEachOps$ForEachOrderedTask2.fork();
        }
        if (forEachOps$ForEachOrderedTask.getPendingCount() > 0) {
            FindOps$$ExternalSyntheticLambda1 findOps$$ExternalSyntheticLambda1 = new FindOps$$ExternalSyntheticLambda1(18);
            Node.CC cc = forEachOps$ForEachOrderedTask.helper;
            Node.Builder BuiltInFictitiousFunctionClassFactory = cc.BuiltInFictitiousFunctionClassFactory(cc.getAuthRequestContext(spliterator), findOps$$ExternalSyntheticLambda1);
            forEachOps$ForEachOrderedTask.helper.PlaceComponentResult(spliterator, BuiltInFictitiousFunctionClassFactory);
            forEachOps$ForEachOrderedTask.node = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            forEachOps$ForEachOrderedTask.spliterator = null;
        }
        forEachOps$ForEachOrderedTask.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        Node node = this.node;
        if (node != null) {
            node.forEach(this.action);
            this.node = null;
        } else {
            Spliterator spliterator = this.spliterator;
            if (spliterator != null) {
                this.helper.PlaceComponentResult(spliterator, this.action);
                this.spliterator = null;
            }
        }
        ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask = (ForEachOps$ForEachOrderedTask) this.completionMap.remove(this);
        if (forEachOps$ForEachOrderedTask != null) {
            forEachOps$ForEachOrderedTask.tryComplete();
        }
    }
}
