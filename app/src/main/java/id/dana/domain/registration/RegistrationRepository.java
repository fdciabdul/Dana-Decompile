package id.dana.domain.registration;

import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.registration.model.HelpButtonOtpLimitDeviceModel;
import id.dana.domain.registration.model.OtpWhatsAppConfigModel;
import io.reactivex.Observable;
import java.io.File;
import kotlin.Unit;

/* loaded from: classes2.dex */
public interface RegistrationRepository {
    Observable<CheckRegistrationResponse> checkRegistration(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2);

    Observable<Long> getChatBotTimestamp(String str);

    Observable<HelpButtonOtpLimitDeviceModel> getHelpButtonOtpLimitDevice();

    Observable<Boolean> getIsFreezeVerifyOtp(String str);

    Observable<String> getLastOtpChannel(String str);

    Observable<Integer> getNumberOfRequestOtp(String str);

    Observable<OtpWhatsAppConfigModel> getOtpWhatsAppConfig();

    Observable<String> getPhoneNumber();

    Observable<Long> getResendOtpTimeLimit(String str);

    Observable<Boolean> register(String str, String str2, String str3, File file, String str4);

    Observable<Unit> removeNumberOfRequestOtp(String str);

    Observable<CheckRegistrationResponse> resendOtp(String str);

    Observable<CheckRegistrationResponse> resendOtpRegister(String str);

    Observable<Unit> saveIsFreezeVerifyOtp(String str, boolean z);

    Observable<Unit> saveNumberOfRequestOtp(String str, int i);
}
