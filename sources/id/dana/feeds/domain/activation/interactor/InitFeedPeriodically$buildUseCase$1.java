package id.dana.feeds.domain.activation.interactor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.domain.activation.interactor.InitFeedPeriodically", f = "InitFeedPeriodically.kt", i = {}, l = {39}, m = "buildUseCase", n = {}, s = {})
/* loaded from: classes8.dex */
public final class InitFeedPeriodically$buildUseCase$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitFeedPeriodically this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitFeedPeriodically$buildUseCase$1(InitFeedPeriodically initFeedPeriodically, Continuation<? super InitFeedPeriodically$buildUseCase$1> continuation) {
        super(continuation);
        this.this$0 = initFeedPeriodically;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }
}
