package id.dana.feeds.domain.runner;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.domain.runner.BaseSyncContactRunner", f = "BaseSyncContactRunner.kt", i = {0, 1, 2, 3, 4}, l = {29, 32, 33, 33, 33, 35}, m = "sync$suspendImpl", n = {"this", "this", "this", "this", "this"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes2.dex */
public final class BaseSyncContactRunner$sync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseSyncContactRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSyncContactRunner$sync$1(BaseSyncContactRunner baseSyncContactRunner, Continuation<? super BaseSyncContactRunner$sync$1> continuation) {
        super(continuation);
        this.this$0 = baseSyncContactRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BaseSyncContactRunner.BuiltInFictitiousFunctionClassFactory(this.this$0, this);
    }
}
