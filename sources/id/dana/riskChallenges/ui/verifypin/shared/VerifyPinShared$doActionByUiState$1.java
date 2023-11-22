package id.dana.riskChallenges.ui.verifypin.shared;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared", f = "VerifyPinShared.kt", i = {0, 0}, l = {165}, m = "doActionByUiState", n = {"this", "uiState"}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
public final class VerifyPinShared$doActionByUiState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VerifyPinShared this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyPinShared$doActionByUiState$1(VerifyPinShared verifyPinShared, Continuation<? super VerifyPinShared$doActionByUiState$1> continuation) {
        super(continuation);
        this.this$0 = verifyPinShared;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VerifyPinShared.getAuthRequestContext(this.this$0, null, this);
    }
}
