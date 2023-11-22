package id.dana.data.otp.repository.source.network;

import id.dana.data.otp.repository.source.network.result.SendCashierOtpResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class NetworkOtpEntityData$$ExternalSyntheticLambda0 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return (SendCashierOtpResult) ((ResultResponse) obj).getResult();
    }
}
