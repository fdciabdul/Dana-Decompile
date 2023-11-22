package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.Node;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
abstract class AbstractShortCircuitTask extends AbstractTask {
    protected volatile boolean canceled;
    protected final AtomicReference sharedResult;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractShortCircuitTask(AbstractShortCircuitTask abstractShortCircuitTask, Spliterator spliterator) {
        super(abstractShortCircuitTask, spliterator);
        this.sharedResult = abstractShortCircuitTask.sharedResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractShortCircuitTask(Node.CC cc, Spliterator spliterator) {
        super(cc, spliterator);
        this.sharedResult = new AtomicReference(null);
    }

    protected void cancel() {
        this.canceled = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void cancelLaterNodes() {
        AbstractShortCircuitTask abstractShortCircuitTask = this;
        for (AbstractShortCircuitTask abstractShortCircuitTask2 = (AbstractShortCircuitTask) getParent(); abstractShortCircuitTask2 != null; abstractShortCircuitTask2 = (AbstractShortCircuitTask) abstractShortCircuitTask2.getParent()) {
            if (abstractShortCircuitTask2.leftChild == abstractShortCircuitTask) {
                AbstractShortCircuitTask abstractShortCircuitTask3 = (AbstractShortCircuitTask) abstractShortCircuitTask2.rightChild;
                if (!abstractShortCircuitTask3.canceled) {
                    abstractShortCircuitTask3.cancel();
                }
            }
            abstractShortCircuitTask = abstractShortCircuitTask2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        r8 = r7.doLeaf();
     */
    @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void compute() {
        /*
            r10 = this;
            j$.util.Spliterator r0 = r10.spliterator
            long r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2()
            long r3 = r10.targetSize
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L14
            long r3 = j$.util.stream.AbstractTask.suggestTargetSize(r1)
            r10.targetSize = r3
        L14:
            java.util.concurrent.atomic.AtomicReference r5 = r10.sharedResult
            r6 = 0
            r7 = r10
        L18:
            java.lang.Object r8 = r5.get()
            if (r8 != 0) goto L6d
            boolean r8 = r7.canceled
            if (r8 != 0) goto L33
            j$.util.stream.AbstractTask r9 = r7.getParent()
        L26:
            j$.util.stream.AbstractShortCircuitTask r9 = (j$.util.stream.AbstractShortCircuitTask) r9
            if (r8 != 0) goto L33
            if (r9 == 0) goto L33
            boolean r8 = r9.canceled
            j$.util.stream.AbstractTask r9 = r9.getParent()
            goto L26
        L33:
            if (r8 == 0) goto L3a
            java.lang.Object r8 = r7.getEmptyResult()
            goto L6d
        L3a:
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 <= 0) goto L69
            j$.util.Spliterator r1 = r0.moveToNextValue()
            if (r1 == 0) goto L69
            j$.util.stream.AbstractTask r2 = r7.makeChild(r1)
            j$.util.stream.AbstractShortCircuitTask r2 = (j$.util.stream.AbstractShortCircuitTask) r2
            r7.leftChild = r2
            j$.util.stream.AbstractTask r8 = r7.makeChild(r0)
            j$.util.stream.AbstractShortCircuitTask r8 = (j$.util.stream.AbstractShortCircuitTask) r8
            r7.rightChild = r8
            r9 = 1
            r7.setPendingCount(r9)
            if (r6 == 0) goto L5e
            r0 = r1
            r7 = r2
            r2 = r8
            goto L5f
        L5e:
            r7 = r8
        L5f:
            r6 = r6 ^ 1
            r2.fork()
            long r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2()
            goto L18
        L69:
            java.lang.Object r8 = r7.doLeaf()
        L6d:
            r7.setLocalResult(r8)
            r7.tryComplete()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.AbstractShortCircuitTask.compute():void");
    }

    protected abstract Object getEmptyResult();

    @Override // j$.util.stream.AbstractTask
    public final Object getLocalResult() {
        if (getParent() == null) {
            Object obj = this.sharedResult.get();
            return obj == null ? getEmptyResult() : obj;
        }
        return super.getLocalResult();
    }

    @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public final Object getRawResult() {
        return getLocalResult();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractTask
    public final void setLocalResult(Object obj) {
        if (!(getParent() == null)) {
            super.setLocalResult(obj);
        } else if (obj != null) {
            AtomicReference atomicReference = this.sharedResult;
            while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
            }
        }
    }
}
