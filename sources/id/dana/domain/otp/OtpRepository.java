package id.dana.domain.otp;

import android.os.Bundle;
import id.dana.domain.otp.model.SendBankOtpRequest;
import id.dana.domain.otp.model.SendOtpResponse;
import id.dana.domain.otp.model.VerifyOtpResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface OtpRepository {
    Observable<Boolean> clearOtpRetryManager();

    Observable<String> receiveOtp();

    Observable<Bundle> receiveSms();

    Observable<SendOtpResponse> sendBankOtp(SendBankOtpRequest sendBankOtpRequest);

    Observable<SendOtpResponse> sendOtp(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6);

    Observable<SendOtpResponse> sendOtpWithoutCache(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6);

    Observable<VerifyOtpResponse> verifyOtp(String str);

    Observable<Boolean> verifyOtpOneKlik(String str, String str2, String str3);
}
