package id.dana.data.otp;

import id.dana.data.otp.mapper.OtpMapper;
import id.dana.data.otp.repository.source.network.result.SendOtpResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class OtpEntityRepository$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ OtpMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((SendOtpResult) obj);
    }
}
