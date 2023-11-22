package id.dana.social.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.social.utils.FullSyncContactWorker", f = "FullSyncContactWorker.kt", i = {0}, l = {48, 50, 51}, m = "doSync", n = {"this"}, s = {"L$0"})
/* loaded from: classes2.dex */
final class FullSyncContactWorker$doSync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullSyncContactWorker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullSyncContactWorker$doSync$1(FullSyncContactWorker fullSyncContactWorker, Continuation<? super FullSyncContactWorker$doSync$1> continuation) {
        super(continuation);
        this.this$0 = fullSyncContactWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.BuiltInFictitiousFunctionClassFactory(this);
    }
}
