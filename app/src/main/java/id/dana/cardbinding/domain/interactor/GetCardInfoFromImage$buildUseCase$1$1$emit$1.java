package id.dana.cardbinding.domain.interactor;

import id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1$1", f = "GetCardInfoFromImage.kt", i = {}, l = {37}, m = "emit", n = {}, s = {})
/* loaded from: classes4.dex */
public final class GetCardInfoFromImage$buildUseCase$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetCardInfoFromImage$buildUseCase$1.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GetCardInfoFromImage$buildUseCase$1$1$emit$1(GetCardInfoFromImage$buildUseCase$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super GetCardInfoFromImage$buildUseCase$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
