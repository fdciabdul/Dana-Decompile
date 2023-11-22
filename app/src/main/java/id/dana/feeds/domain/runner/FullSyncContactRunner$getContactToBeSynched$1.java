package id.dana.feeds.domain.runner;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.domain.runner.FullSyncContactRunner", f = "FullSyncContactRunner.kt", i = {0, 0, 1, 1, 2, 2}, l = {53, 54, 54}, m = "getContactToBeSynched$suspendImpl", n = {"this", "$this$getContactToBeSynched_u24lambda_u2d1", "this", "syncContactOffset", "this", "syncContactOffset"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes2.dex */
public final class FullSyncContactRunner$getContactToBeSynched$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullSyncContactRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullSyncContactRunner$getContactToBeSynched$1(FullSyncContactRunner fullSyncContactRunner, Continuation<? super FullSyncContactRunner$getContactToBeSynched$1> continuation) {
        super(continuation);
        this.this$0 = fullSyncContactRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FullSyncContactRunner.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, (Continuation) this);
    }
}
