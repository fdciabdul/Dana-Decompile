package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.Node;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
final class FindOps$FindTask extends AbstractShortCircuitTask {
    private final FindOps$FindOp op;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FindOps$FindTask(FindOps$FindOp findOps$FindOp, Node.CC cc, Spliterator spliterator) {
        super(cc, spliterator);
        this.op = findOps$FindOp;
    }

    FindOps$FindTask(FindOps$FindTask findOps$FindTask, Spliterator spliterator) {
        super(findOps$FindTask, spliterator);
        this.op = findOps$FindTask.op;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractTask
    public final Object doLeaf() {
        boolean z;
        Node.CC cc = this.helper;
        TerminalSink terminalSink = (TerminalSink) this.op.BuiltInFictitiousFunctionClassFactory.get();
        cc.PlaceComponentResult(this.spliterator, terminalSink);
        Object obj = terminalSink.get();
        if (!this.op.MyBillsEntityDataFactory) {
            if (obj != null) {
                AtomicReference atomicReference = this.sharedResult;
                while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
                }
            }
            return null;
        } else if (obj != null) {
            FindOps$FindTask findOps$FindTask = this;
            while (true) {
                if (findOps$FindTask != null) {
                    AbstractTask parent = findOps$FindTask.getParent();
                    if (parent != null && parent.leftChild != findOps$FindTask) {
                        z = false;
                        break;
                    }
                    findOps$FindTask = parent;
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                AtomicReference atomicReference2 = this.sharedResult;
                while (!atomicReference2.compareAndSet(null, obj) && atomicReference2.get() == null) {
                }
            } else {
                cancelLaterNodes();
            }
            return obj;
        } else {
            return null;
        }
    }

    @Override // j$.util.stream.AbstractShortCircuitTask
    protected final Object getEmptyResult() {
        return this.op.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractTask
    public final AbstractTask makeChild(Spliterator spliterator) {
        return new FindOps$FindTask(this, spliterator);
    }

    @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        boolean z;
        if (this.op.MyBillsEntityDataFactory) {
            FindOps$FindTask findOps$FindTask = (FindOps$FindTask) this.leftChild;
            FindOps$FindTask findOps$FindTask2 = null;
            while (true) {
                if (findOps$FindTask == findOps$FindTask2) {
                    break;
                }
                Object localResult = findOps$FindTask.getLocalResult();
                if (localResult == null || !this.op.KClassImpl$Data$declaredNonStaticMembers$2.test(localResult)) {
                    findOps$FindTask2 = findOps$FindTask;
                    findOps$FindTask = (FindOps$FindTask) this.rightChild;
                } else {
                    setLocalResult(localResult);
                    FindOps$FindTask findOps$FindTask3 = this;
                    while (true) {
                        if (findOps$FindTask3 != null) {
                            AbstractTask parent = findOps$FindTask3.getParent();
                            if (parent != null && parent.leftChild != findOps$FindTask3) {
                                z = false;
                                break;
                            }
                            findOps$FindTask3 = parent;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        AtomicReference atomicReference = this.sharedResult;
                        while (!atomicReference.compareAndSet(null, localResult) && atomicReference.get() == null) {
                        }
                    } else {
                        cancelLaterNodes();
                    }
                }
            }
        }
        super.onCompletion(countedCompleter);
    }
}
