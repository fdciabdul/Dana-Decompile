package id.dana.social.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.social.utils.PartialSyncContactWorker", f = "PartialSyncContactWorker.kt", i = {}, l = {35}, m = "doWork", n = {}, s = {})
/* loaded from: classes2.dex */
final class PartialSyncContactWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PartialSyncContactWorker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartialSyncContactWorker$doWork$1(PartialSyncContactWorker partialSyncContactWorker, Continuation<? super PartialSyncContactWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = partialSyncContactWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }
}
