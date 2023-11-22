package id.dana.riskChallenges.ui.otp.otpwhatsapp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler", f = "OtpWhatsappSharedLogicHandler.kt", i = {0, 0}, l = {490}, m = "setSuccessVerify", n = {"this", "riskToken"}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
public final class OtpWhatsappSharedLogicHandler$setSuccessVerify$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OtpWhatsappSharedLogicHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtpWhatsappSharedLogicHandler$setSuccessVerify$1(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler, Continuation<? super OtpWhatsappSharedLogicHandler$setSuccessVerify$1> continuation) {
        super(continuation);
        this.this$0 = otpWhatsappSharedLogicHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OtpWhatsappSharedLogicHandler.getAuthRequestContext(this.this$0, null, this);
    }
}
