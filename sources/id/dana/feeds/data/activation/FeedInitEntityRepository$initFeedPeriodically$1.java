package id.dana.feeds.data.activation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.data.activation.FeedInitEntityRepository", f = "FeedInitEntityRepository.kt", i = {0, 0}, l = {98}, m = "initFeedPeriodically$suspendImpl", n = {"this", "initFeed"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class FeedInitEntityRepository$initFeedPeriodically$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedInitEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedInitEntityRepository$initFeedPeriodically$1(FeedInitEntityRepository feedInitEntityRepository, Continuation<? super FeedInitEntityRepository$initFeedPeriodically$1> continuation) {
        super(continuation);
        this.this$0 = feedInitEntityRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FeedInitEntityRepository.getAuthRequestContext(this.this$0, this);
    }
}
