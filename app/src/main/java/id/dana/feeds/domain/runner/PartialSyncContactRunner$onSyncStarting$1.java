package id.dana.feeds.domain.runner;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.domain.runner.PartialSyncContactRunner", f = "PartialSyncContactRunner.kt", i = {0, 1}, l = {34, 35, 36}, m = "onSyncStarting$suspendImpl", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes2.dex */
public final class PartialSyncContactRunner$onSyncStarting$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PartialSyncContactRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartialSyncContactRunner$onSyncStarting$1(PartialSyncContactRunner partialSyncContactRunner, Continuation<? super PartialSyncContactRunner$onSyncStarting$1> continuation) {
        super(continuation);
        this.this$0 = partialSyncContactRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PartialSyncContactRunner.PlaceComponentResult(this.this$0, (Continuation) this);
    }
}
