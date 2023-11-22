package id.dana.feeds.data.config;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.data.config.FeedsConfigEntityRepository", f = "FeedsConfigEntityRepository.kt", i = {}, l = {67}, m = "isSocialContactSyncEnabled", n = {}, s = {})
/* loaded from: classes2.dex */
public final class FeedsConfigEntityRepository$isSocialContactSyncEnabled$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedsConfigEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsConfigEntityRepository$isSocialContactSyncEnabled$1(FeedsConfigEntityRepository feedsConfigEntityRepository, Continuation<? super FeedsConfigEntityRepository$isSocialContactSyncEnabled$1> continuation) {
        super(continuation);
        this.this$0 = feedsConfigEntityRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.PlaceComponentResult(this);
    }
}
