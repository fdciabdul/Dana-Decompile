package id.dana.data.otp.repository.source.smsreceiver;

import android.os.Bundle;
import id.dana.data.otp.repository.source.OtpEntityData;
import id.dana.data.otp.repository.source.network.request.SendBankOtpEntityRequest;
import id.dana.data.otp.repository.source.network.request.SendCashierOneKlikOtpRequest;
import id.dana.data.otp.repository.source.network.result.SendCashierOneKlikOtpResult;
import id.dana.data.otp.repository.source.network.result.SendOtpResult;
import id.dana.network.response.login.VerifyOtpResult;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public class SmsReceiverEntityData implements OtpEntityData {
    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<VerifyOtpResult> verifyOtp(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<SendOtpResult> sendOtp(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<SendOtpResult> sendBankOtp(SendBankOtpEntityRequest sendBankOtpEntityRequest) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<SendOtpResult> verifyBankPhoneOtp(SendBankOtpEntityRequest sendBankOtpEntityRequest) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<SendCashierOneKlikOtpResult> verifyCashierOneklikOtp(SendCashierOneKlikOtpRequest sendCashierOneKlikOtpRequest) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<String> receiveOtp() {
        return OtpReceiver.publishSubjectOtp;
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<Bundle> receiveSms() {
        return OtpReceiver.publishSubjectSmsReceived;
    }
}
