package id.dana.domain.qrbarcode;

import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.Map;

/* loaded from: classes4.dex */
public class DecodedScan extends BaseRpcResponse {
    private String acDecodeConfig;
    private String avatarUrl;
    private Map<String, String> bizInfo;
    private String bizNo;
    private String bizType;
    private String loginId;
    private String mobileNumber;
    private String nickname;
    private String receiverId;
    private String redirectUrl;

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

    public Map<String, String> getBizInfo() {
        return this.bizInfo;
    }

    public void setBizInfo(Map<String, String> map) {
        this.bizInfo = map;
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

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public String getAcDecodeConfig() {
        return this.acDecodeConfig;
    }

    public void setAcDecodeConfig(String str) {
        this.acDecodeConfig = str;
    }
}
