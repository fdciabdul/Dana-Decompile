package id.dana.data.registration;

import android.text.TextUtils;
import id.dana.data.registration.source.network.result.CheckUserRegistrationStatusResult;
import id.dana.domain.registration.CheckUserAction;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class RegistrationProcessManager {
    public static final int REFERRAL_CODE_LENGTH = 6;
    private String clientId;
    private String merchantId;
    private long nextRetryTimestamp;
    private String phoneNumber;
    private String referralCode;
    private CheckUserRegistrationStatusResult registrationStatusResult;
    private String verifyMethod;

    @Inject
    public RegistrationProcessManager() {
    }

    public String getPhoneNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegistrationProcessManager: ");
        sb.append(this);
        sb.append("\tgetPhoneNumber: ");
        sb.append(this.phoneNumber);
        DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(DanaLogConstants.TAG.PHONE_NUMBER_EMPTY_TAG, sb.toString());
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
        StringBuilder sb = new StringBuilder();
        sb.append("RegistrationProcessManager: ");
        sb.append(this);
        sb.append("\tsetPhoneNumber: ");
        sb.append(str);
        DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(DanaLogConstants.TAG.PHONE_NUMBER_EMPTY_TAG, sb.toString());
    }

    public CheckUserRegistrationStatusResult getRegistrationStatusResult() {
        if (this.registrationStatusResult != null && isNotOverRetry()) {
            this.registrationStatusResult.retrySendSeconds = (int) TimeUnit.MILLISECONDS.toSeconds(this.nextRetryTimestamp - System.currentTimeMillis());
        }
        return this.registrationStatusResult;
    }

    public void setRegistrationStatusResult(CheckUserRegistrationStatusResult checkUserRegistrationStatusResult) {
        this.registrationStatusResult = checkUserRegistrationStatusResult;
        if (CheckUserAction.REGISTER.equals(checkUserRegistrationStatusResult.action)) {
            this.nextRetryTimestamp = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(checkUserRegistrationStatusResult.retrySendSeconds);
        }
    }

    public boolean isNotOverRetry() {
        return this.nextRetryTimestamp >= System.currentTimeMillis();
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public void setReferralCode(String str) {
        if (str != null && str.length() >= 6) {
            this.referralCode = str.substring(0, 6);
        } else {
            this.referralCode = "";
        }
    }

    public String getClientId() {
        return !TextUtils.isEmpty(this.clientId) ? this.clientId : "";
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public String getMerchantId() {
        return !TextUtils.isEmpty(this.merchantId) ? this.merchantId : "";
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public void clear() {
        this.registrationStatusResult = null;
        this.nextRetryTimestamp = -1L;
        this.referralCode = null;
        this.clientId = null;
        this.merchantId = null;
    }

    public String getVerifyMethod() {
        return this.verifyMethod;
    }

    public void setVerifyMethod(String str) {
        this.verifyMethod = str;
    }
}
