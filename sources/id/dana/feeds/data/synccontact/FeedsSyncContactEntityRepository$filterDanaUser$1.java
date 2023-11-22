package id.dana.feeds.data.synccontact;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository", f = "FeedsSyncContactEntityRepository.kt", i = {0, 0}, l = {90}, m = "filterDanaUser$suspendImpl", n = {"this", "contactForSync"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class FeedsSyncContactEntityRepository$filterDanaUser$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedsSyncContactEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsSyncContactEntityRepository$filterDanaUser$1(FeedsSyncContactEntityRepository feedsSyncContactEntityRepository, Continuation<? super FeedsSyncContactEntityRepository$filterDanaUser$1> continuation) {
        super(continuation);
        this.this$0 = feedsSyncContactEntityRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FeedsSyncContactEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, null, this);
    }
}
