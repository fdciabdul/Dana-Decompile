package id.dana.feeds.domain.activation.interactor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact", f = "InitFeedWithoutContact.kt", i = {}, l = {28}, m = "buildUseCase", n = {}, s = {})
/* loaded from: classes5.dex */
public final class InitFeedWithoutContact$buildUseCase$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitFeedWithoutContact this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitFeedWithoutContact$buildUseCase$1(InitFeedWithoutContact initFeedWithoutContact, Continuation<? super InitFeedWithoutContact$buildUseCase$1> continuation) {
        super(continuation);
        this.this$0 = initFeedWithoutContact;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAuthRequestContext(this);
    }
}
