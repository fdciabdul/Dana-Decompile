package id.dana.feeds.data.activation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.data.activation.FeedInitEntityRepository", f = "FeedInitEntityRepository.kt", i = {0}, l = {120}, m = "initFeedWithPublishErrorFallback$suspendImpl", n = {"this"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class FeedInitEntityRepository$initFeedWithPublishErrorFallback$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedInitEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedInitEntityRepository$initFeedWithPublishErrorFallback$1(FeedInitEntityRepository feedInitEntityRepository, Continuation<? super FeedInitEntityRepository$initFeedWithPublishErrorFallback$1> continuation) {
        super(continuation);
        this.this$0 = feedInitEntityRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FeedInitEntityRepository.MyBillsEntityDataFactory(this.this$0, this);
    }
}
