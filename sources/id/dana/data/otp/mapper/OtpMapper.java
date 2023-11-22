package id.dana.data.otp.mapper;

import id.dana.data.BaseMapper;
import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.data.otp.repository.source.network.result.SendOtpResult;
import id.dana.domain.otp.model.SendOtpResponse;
import id.dana.domain.otp.model.VerifyOtpResponse;
import id.dana.network.response.login.VerifyOtpResult;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000b"}, d2 = {"Lid/dana/data/otp/mapper/OtpMapper;", "", "Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "result", "Lid/dana/domain/otp/model/VerifyOtpResponse;", "transform", "(Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;)Lid/dana/domain/otp/model/VerifyOtpResponse;", "Lid/dana/data/otp/repository/source/network/result/SendOtpResult;", "Lid/dana/domain/otp/model/SendOtpResponse;", "(Lid/dana/data/otp/repository/source/network/result/SendOtpResult;)Lid/dana/domain/otp/model/SendOtpResponse;", "Lid/dana/network/response/login/VerifyOtpResult;", "(Lid/dana/network/response/login/VerifyOtpResult;)Lid/dana/domain/otp/model/VerifyOtpResponse;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OtpMapper {
    @Inject
    public OtpMapper() {
    }

    public final VerifyOtpResponse transform(VerifyOtpResult result) {
        if (result == null) {
            return null;
        }
        VerifyOtpResponse verifyOtpResponse = new VerifyOtpResponse(0, 0, null, 7, null);
        verifyOtpResponse.setFailedCount(result.failedCount);
        verifyOtpResponse.setMaxFailedCount(result.maxFailedCount);
        BaseMapper.transform(verifyOtpResponse, result);
        return verifyOtpResponse;
    }

    public final VerifyOtpResponse transform(VerifySecurityProductResult result) {
        if (result == null) {
            return null;
        }
        VerifyOtpResponse verifyOtpResponse = new VerifyOtpResponse(0, 0, null, 7, null);
        verifyOtpResponse.setFailedCount(result.getIdentFailedCount());
        verifyOtpResponse.setMaxFailedCount(result.getMaxFailedLimit());
        BaseMapper.transform(verifyOtpResponse, result);
        return verifyOtpResponse;
    }

    public final SendOtpResponse transform(SendOtpResult result) {
        if (result == null) {
            return null;
        }
        SendOtpResponse sendOtpResponse = new SendOtpResponse();
        sendOtpResponse.setExpirySeconds(result.expirySeconds);
        sendOtpResponse.setOtpCodeLength(result.otpCodeLength);
        sendOtpResponse.setRetrySendSeconds(result.retrySendSeconds);
        BaseMapper.transform(sendOtpResponse, result);
        return sendOtpResponse;
    }
}
