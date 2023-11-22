package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.Node;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes.dex */
final class ForEachOps$ForEachTask extends CountedCompleter {
    private final Node.CC helper;
    private final Sink sink;
    private Spliterator spliterator;
    private long targetSize;

    ForEachOps$ForEachTask(ForEachOps$ForEachTask forEachOps$ForEachTask, Spliterator spliterator) {
        super(forEachOps$ForEachTask);
        this.spliterator = spliterator;
        this.sink = forEachOps$ForEachTask.sink;
        this.targetSize = forEachOps$ForEachTask.targetSize;
        this.helper = forEachOps$ForEachTask.helper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ForEachOps$ForEachTask(Node.CC cc, Spliterator spliterator, Sink sink) {
        super(null);
        this.sink = sink;
        this.helper = cc;
        this.spliterator = spliterator;
        this.targetSize = 0L;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator moveToNextValue;
        Spliterator spliterator = this.spliterator;
        long KClassImpl$Data$declaredNonStaticMembers$2 = spliterator.KClassImpl$Data$declaredNonStaticMembers$2();
        long j = this.targetSize;
        if (j == 0) {
            j = AbstractTask.suggestTargetSize(KClassImpl$Data$declaredNonStaticMembers$2);
            this.targetSize = j;
        }
        boolean isKnown = StreamOpFlag.SHORT_CIRCUIT.isKnown(this.helper.getAuthRequestContext());
        boolean z = false;
        Sink sink = this.sink;
        ForEachOps$ForEachTask forEachOps$ForEachTask = this;
        while (true) {
            if (isKnown && sink.cancellationRequested()) {
                break;
            } else if (KClassImpl$Data$declaredNonStaticMembers$2 <= j || (moveToNextValue = spliterator.moveToNextValue()) == null) {
                break;
            } else {
                ForEachOps$ForEachTask forEachOps$ForEachTask2 = new ForEachOps$ForEachTask(forEachOps$ForEachTask, moveToNextValue);
                forEachOps$ForEachTask.addToPendingCount(1);
                if (z) {
                    spliterator = moveToNextValue;
                } else {
                    ForEachOps$ForEachTask forEachOps$ForEachTask3 = forEachOps$ForEachTask;
                    forEachOps$ForEachTask = forEachOps$ForEachTask2;
                    forEachOps$ForEachTask2 = forEachOps$ForEachTask3;
                }
                z = !z;
                forEachOps$ForEachTask.fork();
                forEachOps$ForEachTask = forEachOps$ForEachTask2;
                KClassImpl$Data$declaredNonStaticMembers$2 = spliterator.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
        forEachOps$ForEachTask.helper.KClassImpl$Data$declaredNonStaticMembers$2(spliterator, sink);
        forEachOps$ForEachTask.spliterator = null;
        forEachOps$ForEachTask.propagateCompletion();
    }
}
