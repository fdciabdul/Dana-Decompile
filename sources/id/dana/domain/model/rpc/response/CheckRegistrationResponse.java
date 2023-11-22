package id.dana.domain.model.rpc.response;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.transferaccount.StatusTransferAccount;
import id.dana.domain.user.CurrencyAmount;
import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b`\u0010\u000eJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0014R\"\u0010\u001e\u001a\u00020\u001d8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u001d8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\"\u0010.\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0016\u001a\u0004\b.\u0010\b\"\u0004\b/\u0010\u0019R\"\u00100\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0016\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\u0019R$\u00102\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0011\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010\u0014R*\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0011\u001a\u0004\b>\u0010\u0004\"\u0004\b?\u0010\u0014R\"\u0010@\u001a\u00020\u001d8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u001f\u001a\u0004\bA\u0010!\"\u0004\bB\u0010#R\"\u0010C\u001a\u00020\u001d8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u001f\u001a\u0004\bD\u0010!\"\u0004\bE\u0010#R$\u0010G\u001a\u0004\u0018\u00010F8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010\u0011\u001a\u0004\bN\u0010\u0004\"\u0004\bO\u0010\u0014R\"\u0010P\u001a\u00020\u001d8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u001f\u001a\u0004\bQ\u0010!\"\u0004\bR\u0010#R$\u0010S\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010\u0011\u001a\u0004\bT\u0010\u0004\"\u0004\bU\u0010\u0014R$\u0010W\u001a\u0004\u0018\u00010V8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010]\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0011\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010\u0014"}, d2 = {"Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;", "Lid/dana/utils/rpc/response/BaseRpcResponse;", "", "getRegistrationSource", "()Ljava/lang/String;", "getVerificationMethod", "", "isVerificationMethodCarrierIdentification", "()Z", "isVerificationMethodCitCall", "isVerificationMethodFaceOnly", "isVerificationMethodWhatsApp", "", "removeFirstVerificationMethod", "()V", "removeFirstVerificationMethodFromExtendInfo", "action", "Ljava/lang/String;", "getAction", "setAction", "(Ljava/lang/String;)V", "campaignEnabled", "Z", "getCampaignEnabled", "setCampaignEnabled", "(Z)V", "challengeContext", "getChallengeContext", "setChallengeContext", "", "expirySeconds", "I", "getExpirySeconds", "()I", "setExpirySeconds", "(I)V", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "setExtendInfo", "(Ljava/util/Map;)V", "faceLoginAuthMethodIndex", "getFaceLoginAuthMethodIndex", "setFaceLoginAuthMethodIndex", "isErrorResend", "setErrorResend", "isFreezeVerifyOtp", "setFreezeVerifyOtp", "localPhoneNumber", "getLocalPhoneNumber", "setLocalPhoneNumber", "", "Lid/dana/domain/model/rpc/response/LoginAuthenticationOptionResponse;", "loginAuthenticationOptionResponses", "Ljava/util/List;", "getLoginAuthenticationOptionResponses", "()Ljava/util/List;", "setLoginAuthenticationOptionResponses", "(Ljava/util/List;)V", "otpChannel", "getOtpChannel", "setOtpChannel", "otpCodeLength", "getOtpCodeLength", "setOtpCodeLength", "passwordAuthMethodIndex", "getPasswordAuthMethodIndex", "setPasswordAuthMethodIndex", "Lid/dana/domain/user/CurrencyAmount;", "prizeAmount", "Lid/dana/domain/user/CurrencyAmount;", "getPrizeAmount", "()Lid/dana/domain/user/CurrencyAmount;", "setPrizeAmount", "(Lid/dana/domain/user/CurrencyAmount;)V", "prizeName", "getPrizeName", "setPrizeName", "retrySendSeconds", "getRetrySendSeconds", "setRetrySendSeconds", BioUtilityBridge.SECURITY_ID, "getSecurityId", "setSecurityId", "Lid/dana/domain/transferaccount/StatusTransferAccount;", "transferAccountStatus", "Lid/dana/domain/transferaccount/StatusTransferAccount;", "getTransferAccountStatus", "()Lid/dana/domain/transferaccount/StatusTransferAccount;", "setTransferAccountStatus", "(Lid/dana/domain/transferaccount/StatusTransferAccount;)V", "userName", "getUserName", "setUserName", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckRegistrationResponse extends BaseRpcResponse {
    private static final String CARRIER_IDENTIFICATION = "CARRIER_IDENTIFICATION";
    private static final String MIC_FACE = "MIC_FACE";
    private static final String REGISTRATION_SOURCE = "registrationSource";
    private static final String VERIFICATION_METHOD = "verificationMethod";
    private static final String VERIFY_CITCALL = "MISSED_CALL_OTP";
    private static final String VERIFY_WHATSAPP = "WHATSAPP_OTP";
    private String action;
    private boolean campaignEnabled;
    private String challengeContext;
    private int expirySeconds;
    private Map<String, String> extendInfo;
    private int faceLoginAuthMethodIndex;
    private boolean isErrorResend;
    private boolean isFreezeVerifyOtp;
    private String localPhoneNumber;
    private List<? extends LoginAuthenticationOptionResponse> loginAuthenticationOptionResponses;
    private String otpChannel;
    private int otpCodeLength;
    private int passwordAuthMethodIndex;
    private CurrencyAmount prizeAmount;
    private String prizeName;
    private int retrySendSeconds;
    private String securityId;
    private StatusTransferAccount transferAccountStatus;
    private String userName;

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "setAction")
    public final void setAction(String str) {
        this.action = str;
    }

    @JvmName(name = "getCampaignEnabled")
    public final boolean getCampaignEnabled() {
        return this.campaignEnabled;
    }

    @JvmName(name = "setCampaignEnabled")
    public final void setCampaignEnabled(boolean z) {
        this.campaignEnabled = z;
    }

    @JvmName(name = "getExpirySeconds")
    public final int getExpirySeconds() {
        return this.expirySeconds;
    }

    @JvmName(name = "setExpirySeconds")
    public final void setExpirySeconds(int i) {
        this.expirySeconds = i;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(Map<String, String> map) {
        this.extendInfo = map;
    }

    @JvmName(name = "getLocalPhoneNumber")
    public final String getLocalPhoneNumber() {
        return this.localPhoneNumber;
    }

    @JvmName(name = "setLocalPhoneNumber")
    public final void setLocalPhoneNumber(String str) {
        this.localPhoneNumber = str;
    }

    @JvmName(name = "getOtpChannel")
    public final String getOtpChannel() {
        return this.otpChannel;
    }

    @JvmName(name = "setOtpChannel")
    public final void setOtpChannel(String str) {
        this.otpChannel = str;
    }

    @JvmName(name = "getOtpCodeLength")
    public final int getOtpCodeLength() {
        return this.otpCodeLength;
    }

    @JvmName(name = "setOtpCodeLength")
    public final void setOtpCodeLength(int i) {
        this.otpCodeLength = i;
    }

    @JvmName(name = "getPrizeAmount")
    public final CurrencyAmount getPrizeAmount() {
        return this.prizeAmount;
    }

    @JvmName(name = "setPrizeAmount")
    public final void setPrizeAmount(CurrencyAmount currencyAmount) {
        this.prizeAmount = currencyAmount;
    }

    @JvmName(name = "getPrizeName")
    public final String getPrizeName() {
        return this.prizeName;
    }

    @JvmName(name = "setPrizeName")
    public final void setPrizeName(String str) {
        this.prizeName = str;
    }

    @JvmName(name = "getRetrySendSeconds")
    public final int getRetrySendSeconds() {
        return this.retrySendSeconds;
    }

    @JvmName(name = "setRetrySendSeconds")
    public final void setRetrySendSeconds(int i) {
        this.retrySendSeconds = i;
    }

    @JvmName(name = "getUserName")
    public final String getUserName() {
        return this.userName;
    }

    @JvmName(name = "setUserName")
    public final void setUserName(String str) {
        this.userName = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getLoginAuthenticationOptionResponses")
    public final List<LoginAuthenticationOptionResponse> getLoginAuthenticationOptionResponses() {
        return this.loginAuthenticationOptionResponses;
    }

    @JvmName(name = "setLoginAuthenticationOptionResponses")
    public final void setLoginAuthenticationOptionResponses(List<? extends LoginAuthenticationOptionResponse> list) {
        this.loginAuthenticationOptionResponses = list;
    }

    @JvmName(name = "getFaceLoginAuthMethodIndex")
    public final int getFaceLoginAuthMethodIndex() {
        return this.faceLoginAuthMethodIndex;
    }

    @JvmName(name = "setFaceLoginAuthMethodIndex")
    public final void setFaceLoginAuthMethodIndex(int i) {
        this.faceLoginAuthMethodIndex = i;
    }

    @JvmName(name = "getPasswordAuthMethodIndex")
    public final int getPasswordAuthMethodIndex() {
        return this.passwordAuthMethodIndex;
    }

    @JvmName(name = "setPasswordAuthMethodIndex")
    public final void setPasswordAuthMethodIndex(int i) {
        this.passwordAuthMethodIndex = i;
    }

    @JvmName(name = "getChallengeContext")
    public final String getChallengeContext() {
        return this.challengeContext;
    }

    @JvmName(name = "setChallengeContext")
    public final void setChallengeContext(String str) {
        this.challengeContext = str;
    }

    @JvmName(name = "getTransferAccountStatus")
    public final StatusTransferAccount getTransferAccountStatus() {
        return this.transferAccountStatus;
    }

    @JvmName(name = "setTransferAccountStatus")
    public final void setTransferAccountStatus(StatusTransferAccount statusTransferAccount) {
        this.transferAccountStatus = statusTransferAccount;
    }

    @JvmName(name = "isFreezeVerifyOtp")
    /* renamed from: isFreezeVerifyOtp  reason: from getter */
    public final boolean getIsFreezeVerifyOtp() {
        return this.isFreezeVerifyOtp;
    }

    @JvmName(name = "setFreezeVerifyOtp")
    public final void setFreezeVerifyOtp(boolean z) {
        this.isFreezeVerifyOtp = z;
    }

    @JvmName(name = "isErrorResend")
    /* renamed from: isErrorResend  reason: from getter */
    public final boolean getIsErrorResend() {
        return this.isErrorResend;
    }

    @JvmName(name = "setErrorResend")
    public final void setErrorResend(boolean z) {
        this.isErrorResend = z;
    }

    public final String getRegistrationSource() {
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (map.get(REGISTRATION_SOURCE) != null) {
                Map<String, String> map2 = this.extendInfo;
                Intrinsics.checkNotNull(map2);
                return map2.get(REGISTRATION_SOURCE);
            }
        }
        return "";
    }

    public final boolean isVerificationMethodCarrierIdentification() {
        return Intrinsics.areEqual(getVerificationMethod(), "CARRIER_IDENTIFICATION");
    }

    public final boolean isVerificationMethodCitCall() {
        return Intrinsics.areEqual(getVerificationMethod(), "MISSED_CALL_OTP");
    }

    public final boolean isVerificationMethodWhatsApp() {
        return Intrinsics.areEqual(getVerificationMethod(), "WHATSAPP_OTP");
    }

    public final void removeFirstVerificationMethod() {
        List<? extends LoginAuthenticationOptionResponse> list = this.loginAuthenticationOptionResponses;
        List<? extends LoginAuthenticationOptionResponse> mutableList = list != null ? CollectionsKt.toMutableList((Collection) list) : null;
        if (mutableList != null) {
            mutableList.remove(0);
        }
        this.loginAuthenticationOptionResponses = mutableList;
    }

    public final void removeFirstVerificationMethodFromExtendInfo() {
        LoginAuthenticationOptionResponse loginAuthenticationOptionResponse;
        List<? extends LoginAuthenticationOptionResponse> list = this.loginAuthenticationOptionResponses;
        String str = null;
        List<? extends LoginAuthenticationOptionResponse> mutableList = list != null ? CollectionsKt.toMutableList((Collection) list) : null;
        if (mutableList != null) {
            LoginAuthenticationOptionResponse loginAuthenticationOptionResponse2 = (LoginAuthenticationOptionResponse) CollectionsKt.firstOrNull((List) mutableList);
        }
        this.loginAuthenticationOptionResponses = mutableList;
        Map<String, String> map = this.extendInfo;
        Map<String, String> mutableMap = map != null ? MapsKt.toMutableMap(map) : null;
        if (mutableMap != null) {
            if (mutableList != null && (loginAuthenticationOptionResponse = (LoginAuthenticationOptionResponse) CollectionsKt.firstOrNull((List) mutableList)) != null) {
                str = loginAuthenticationOptionResponse.getAuthenticationMethod();
            }
            if (str == null) {
                str = "";
            }
            mutableMap.put("verificationMethod", str);
        }
        this.extendInfo = mutableMap;
    }

    public final String getVerificationMethod() {
        LoginAuthenticationOptionResponse loginAuthenticationOptionResponse;
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            if ((map != null ? map.get("verificationMethod") : null) != null) {
                Map<String, String> map2 = this.extendInfo;
                r1 = map2 != null ? map2.get("verificationMethod") : null;
                return r1 == null ? "" : r1;
            }
        }
        boolean z = false;
        if (this.loginAuthenticationOptionResponses != null && (!r0.isEmpty()) == true) {
            z = true;
        }
        if (z) {
            List<? extends LoginAuthenticationOptionResponse> list = this.loginAuthenticationOptionResponses;
            if (list != null && (loginAuthenticationOptionResponse = (LoginAuthenticationOptionResponse) CollectionsKt.first((List) list)) != null) {
                r1 = loginAuthenticationOptionResponse.getAuthenticationMethod();
            }
            if (r1 != null) {
                return r1;
            }
        }
    }

    public final boolean isVerificationMethodFaceOnly() {
        LoginAuthenticationOptionResponse loginAuthenticationOptionResponse;
        List<? extends LoginAuthenticationOptionResponse> list = this.loginAuthenticationOptionResponses;
        if (list != null && list.size() == 1) {
            List<? extends LoginAuthenticationOptionResponse> list2 = this.loginAuthenticationOptionResponses;
            String authenticationMethod = (list2 == null || (loginAuthenticationOptionResponse = (LoginAuthenticationOptionResponse) CollectionsKt.first((List) list2)) == null) ? null : loginAuthenticationOptionResponse.getAuthenticationMethod();
            if (authenticationMethod == null) {
                authenticationMethod = "";
            }
            return Intrinsics.areEqual(authenticationMethod, "MIC_FACE");
        }
        return false;
    }
}
