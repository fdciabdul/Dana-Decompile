package id.dana.data.otp.repository.source;

import android.os.Bundle;
import id.dana.data.otp.repository.source.network.request.SendBankOtpEntityRequest;
import id.dana.data.otp.repository.source.network.request.SendCashierOneKlikOtpRequest;
import id.dana.data.otp.repository.source.network.result.SendCashierOneKlikOtpResult;
import id.dana.data.otp.repository.source.network.result.SendOtpResult;
import id.dana.network.response.login.VerifyOtpResult;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface OtpEntityData {
    Observable<String> receiveOtp();

    Observable<Bundle> receiveSms();

    Observable<SendOtpResult> sendBankOtp(SendBankOtpEntityRequest sendBankOtpEntityRequest);

    Observable<SendOtpResult> sendOtp(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6);

    Observable<SendOtpResult> verifyBankPhoneOtp(SendBankOtpEntityRequest sendBankOtpEntityRequest);

    Observable<SendCashierOneKlikOtpResult> verifyCashierOneklikOtp(SendCashierOneKlikOtpRequest sendCashierOneKlikOtpRequest);

    Observable<VerifyOtpResult> verifyOtp(String str, String str2);
}
