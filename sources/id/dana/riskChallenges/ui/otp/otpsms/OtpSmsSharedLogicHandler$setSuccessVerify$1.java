package id.dana.riskChallenges.ui.otp.otpsms;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.riskChallenges.ui.otp.otpsms.OtpSmsSharedLogicHandler", f = "OtpSmsSharedLogicHandler.kt", i = {0, 0}, l = {418}, m = "setSuccessVerify", n = {"this", "riskToken"}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
public final class OtpSmsSharedLogicHandler$setSuccessVerify$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OtpSmsSharedLogicHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtpSmsSharedLogicHandler$setSuccessVerify$1(OtpSmsSharedLogicHandler otpSmsSharedLogicHandler, Continuation<? super OtpSmsSharedLogicHandler$setSuccessVerify$1> continuation) {
        super(continuation);
        this.this$0 = otpSmsSharedLogicHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OtpSmsSharedLogicHandler.PlaceComponentResult(this.this$0, null, this);
    }
}
