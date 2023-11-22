package id.dana.model;

import id.dana.base.BaseResponse;
import id.dana.sendmoney.model.PayOptionDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes5.dex */
public class ScanModel extends BaseResponse implements Serializable {
    private String acDecodeConfig;
    private String avatarUrl;
    private BizInfoModel bizInfo;
    private String bizNo;
    private String bizType;
    private String kycLevel;
    private String loginId;
    private String mobileNumber;
    private HashMap<String, String> nativelyDecodedQr;
    private String nickname;
    private List<PayOptionDTO> payOptions;
    private boolean precreateOrder;
    private String qrCode;
    private String receiverId;
    private String redirectUrl;
    private String requestId;
    private String source;

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public String getKycLevel() {
        return this.kycLevel;
    }

    public void setKycLevel(String str) {
        this.kycLevel = str;
    }

    public List<PayOptionDTO> getPayOptions() {
        return this.payOptions;
    }

    public void setPayOptions(List<PayOptionDTO> list) {
        this.payOptions = list;
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public String getBizNo() {
        return this.bizNo;
    }

    public void setBizNo(String str) {
        this.bizNo = str;
    }

    public String getReceiverId() {
        return this.receiverId;
    }

    public void setReceiverId(String str) {
        this.receiverId = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String str) {
        this.loginId = str;
    }

    public BizInfoModel getBizInfo() {
        return this.bizInfo;
    }

    public void setBizInfo(BizInfoModel bizInfoModel) {
        this.bizInfo = bizInfoModel;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public String getAcDecodeConfig() {
        return this.acDecodeConfig;
    }

    public void setAcDecodeConfig(String str) {
        this.acDecodeConfig = str;
    }

    public HashMap<String, String> getNativelyDecodedQr() {
        return this.nativelyDecodedQr;
    }

    public void setNativelyDecodedQr(HashMap<String, String> hashMap) {
        this.nativelyDecodedQr = hashMap;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setQrCode(String str) {
        this.qrCode = str;
    }

    public String getQrCode() {
        return this.qrCode;
    }

    public void setPrecreateOrder(boolean z) {
        this.precreateOrder = z;
    }

    public boolean isPrecreateOrder() {
        return this.precreateOrder;
    }
}
