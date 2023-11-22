package id.dana.network.exception;

import android.text.TextUtils;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.network.base.BaseRpcResultWithHeader;
import id.dana.network.response.authface.FaceAuthenticationEntityResult;
import id.dana.network.response.autoroute.UserAutoRouteConfigSwitchResult;
import id.dana.network.response.citcall.MiscallResult;
import id.dana.network.response.expresspurchase.ValidateProductGoldResponse;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.network.response.login.VerifyOtpResult;
import id.dana.network.response.login.VerifyPasswordRpcResult;
import id.dana.network.response.profilemenu.PaymentSecuritySwitchResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class NetworkException extends Exception {
    private static final String EP_NEW_PRICE = "newPrice";
    private static final String EP_THIRD_REF_ID = "thirdRefId";
    private int citcallCurrentAttempts;
    private String citcallPrefix;
    private int citcallRemainingAttempts;
    private Map<String, Object> epValidationInfo;
    private List<String> epValidationTypes;
    private Map<String, String> errorActions;
    private String errorCode;
    private String errorMessage;
    private Map<String, String> extendInfo;
    private int identFailedCount;
    private String interaction;
    private Integer leftTimes;
    private int lockedExpireSeconds;
    private int timeUntilNextAttempt;
    private String traceId;

    public NetworkException(BaseRpcResultAphome baseRpcResultAphome) {
        this((BaseRpcResult) baseRpcResultAphome);
        if (TextUtils.isEmpty(this.errorMessage)) {
            this.errorMessage = baseRpcResultAphome.getErrorMsg();
        }
    }

    public NetworkException(BaseRpcResult baseRpcResult) {
        this.errorCode = baseRpcResult.errorCode;
        this.errorMessage = baseRpcResult.errorMessage;
        this.interaction = baseRpcResult.interaction;
        this.traceId = baseRpcResult.traceId;
        this.extendInfo = baseRpcResult.extendInfo;
        this.errorActions = baseRpcResult.errorActions;
        if (TextUtils.isEmpty(this.errorMessage) && (baseRpcResult instanceof BaseRpcResultAphome)) {
            this.errorMessage = ((BaseRpcResultAphome) baseRpcResult).getErrorMsg();
        }
        if (TextUtils.isEmpty(this.errorMessage) && (baseRpcResult instanceof BaseRpcResultWithHeader)) {
            this.errorMessage = ((BaseRpcResultWithHeader) baseRpcResult).getErrorMsg();
        }
        if (baseRpcResult instanceof LoginRpcResult) {
            handleLoginResultError((LoginRpcResult) baseRpcResult);
        } else if (baseRpcResult instanceof FaceAuthenticationEntityResult) {
            handleFaceAuthWrongPin((FaceAuthenticationEntityResult) baseRpcResult);
        } else if (baseRpcResult instanceof UserAutoRouteConfigSwitchResult) {
            handleAutoRouteWrongPin((UserAutoRouteConfigSwitchResult) baseRpcResult);
        } else if (baseRpcResult instanceof PaymentSecuritySwitchResult) {
            handlePaymentSecurityWrongPin((PaymentSecuritySwitchResult) baseRpcResult);
        } else if (baseRpcResult instanceof ValidateProductGoldResponse) {
            handleExpressPurchaseValidateGoldPriceChange((ValidateProductGoldResponse) baseRpcResult);
        } else if (baseRpcResult instanceof MiscallResult) {
            handleMiscallResultError((MiscallResult) baseRpcResult);
        } else if (baseRpcResult instanceof VerifyOtpResult) {
            handleVerifyOtpResultError((VerifyOtpResult) baseRpcResult);
        } else if (baseRpcResult instanceof VerifyPasswordRpcResult) {
            handleVerifyPasswordRpcResultError((VerifyPasswordRpcResult) baseRpcResult);
        }
    }

    private void handleVerifyPasswordRpcResultError(VerifyPasswordRpcResult verifyPasswordRpcResult) {
        this.leftTimes = Integer.valueOf(verifyPasswordRpcResult.getMaxFailedCount() - verifyPasswordRpcResult.getFailedCount());
        this.lockedExpireSeconds = verifyPasswordRpcResult.getLockedExpireSeconds();
    }

    private void handleVerifyOtpResultError(VerifyOtpResult verifyOtpResult) {
        this.identFailedCount = verifyOtpResult.identFailedCount;
    }

    private void handleMiscallResultError(MiscallResult miscallResult) {
        this.timeUntilNextAttempt = miscallResult.getTimeUntilNextAttempt() == null ? 0 : miscallResult.getTimeUntilNextAttempt().intValue();
        this.citcallCurrentAttempts = miscallResult.getCurrentAttempts() == null ? 0 : miscallResult.getCurrentAttempts().intValue();
        this.citcallRemainingAttempts = miscallResult.getRemainingAttempts() != null ? miscallResult.getRemainingAttempts().intValue() : 0;
        this.citcallPrefix = miscallResult.getPrefix();
    }

    private void handleLoginResultError(LoginRpcResult loginRpcResult) {
        try {
            this.leftTimes = Integer.valueOf(loginRpcResult.failedCount % loginRpcResult.maxFailedCount);
        } catch (ArithmeticException unused) {
            this.leftTimes = 0;
        }
        this.lockedExpireSeconds = loginRpcResult.lockedExpireSeconds;
    }

    private void handleFaceAuthWrongPin(FaceAuthenticationEntityResult faceAuthenticationEntityResult) {
        if ("AE15002058020050".equals(this.errorCode)) {
            this.leftTimes = Integer.valueOf((faceAuthenticationEntityResult.getMaxFailedLimit() != null ? faceAuthenticationEntityResult.getMaxFailedLimit().intValue() : 0) - (faceAuthenticationEntityResult.getIdentFailedCount() == null ? 0 : faceAuthenticationEntityResult.getIdentFailedCount().intValue()));
        }
    }

    private void handleAutoRouteWrongPin(UserAutoRouteConfigSwitchResult userAutoRouteConfigSwitchResult) {
        if (!"AE15002058020050".equals(this.errorCode) || userAutoRouteConfigSwitchResult.getAttributes() == null) {
            return;
        }
        this.leftTimes = Integer.valueOf((userAutoRouteConfigSwitchResult.getAttributes().getMaxFailedLimit() != null ? userAutoRouteConfigSwitchResult.getAttributes().getMaxFailedLimit().intValue() : 0) - (userAutoRouteConfigSwitchResult.getAttributes().getIdentFailedCount() == null ? 0 : userAutoRouteConfigSwitchResult.getAttributes().getIdentFailedCount().intValue()));
    }

    private void handlePaymentSecurityWrongPin(PaymentSecuritySwitchResult paymentSecuritySwitchResult) {
        if ("AE15002058020050".equals(this.errorCode)) {
            this.leftTimes = Integer.valueOf(paymentSecuritySwitchResult.maxFailedLimit - paymentSecuritySwitchResult.identFailedCount);
        }
    }

    private void handleExpressPurchaseValidateGoldPriceChange(ValidateProductGoldResponse validateProductGoldResponse) {
        if (this.errorCode.equals("AE15101858018058")) {
            HashMap hashMap = new HashMap();
            this.errorActions = hashMap;
            hashMap.put(EP_NEW_PRICE, validateProductGoldResponse.getProductValidateStatusInfo().getNewPrice().getAmount());
            this.errorActions.put(EP_THIRD_REF_ID, validateProductGoldResponse.getProductValidateStatusInfo().getThirdRefId());
            this.epValidationInfo = validateProductGoldResponse.getValidationInfo();
            this.epValidationTypes = validateProductGoldResponse.getValidationTypes();
        }
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getInteraction() {
        return this.interaction;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    public Map<String, String> getErrorActions() {
        return this.errorActions;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        Throwable th;
        synchronized (this) {
            th = new Throwable(this.errorMessage);
        }
        return th;
    }

    public Integer getLeftTimes() {
        Integer num = this.leftTimes;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public void setLeftTimes(Integer num) {
        this.leftTimes = num;
    }

    public List<String> getEpValidationTypes() {
        return this.epValidationTypes;
    }

    public void setEpValidationTypes(List<String> list) {
        this.epValidationTypes = list;
    }

    public Map<String, Object> getEpValidationInfo() {
        return this.epValidationInfo;
    }

    public void setEpValidationInfo(Map<String, Object> map) {
        this.epValidationInfo = map;
    }

    public void setLockedExpireSeconds(int i) {
        this.lockedExpireSeconds = i;
    }

    public int getTimeUntilNextAttempt() {
        return this.timeUntilNextAttempt;
    }

    public int getCitcallCurrentAttempts() {
        return this.citcallCurrentAttempts;
    }

    public int getCitcallRemainingAttempts() {
        return this.citcallRemainingAttempts;
    }

    public String getCitcallPrefix() {
        return this.citcallPrefix;
    }

    public int getIdentFailedCount() {
        return this.identFailedCount;
    }

    public int getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }
}
