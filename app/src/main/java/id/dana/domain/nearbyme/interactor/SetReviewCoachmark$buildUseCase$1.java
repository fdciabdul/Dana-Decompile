package id.dana.domain.nearbyme.interactor;

import id.dana.domain.nearbyme.interactor.SetReviewCoachmark;
import id.dana.domain.social.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.domain.nearbyme.interactor.SetReviewCoachmark", f = "SetReviewCoachmark.kt", i = {}, l = {25}, m = "buildUseCase", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SetReviewCoachmark$buildUseCase$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SetReviewCoachmark this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetReviewCoachmark$buildUseCase$1(SetReviewCoachmark setReviewCoachmark, Continuation<? super SetReviewCoachmark$buildUseCase$1> continuation) {
        super(continuation);
        this.this$0 = setReviewCoachmark;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.buildUseCase((SetReviewCoachmark.Params) null, (Continuation<? super Result<Unit>>) this);
    }
}
