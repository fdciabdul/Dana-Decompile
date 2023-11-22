package id.dana.data.splitbill.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.griver.core.GriverParams;
import id.dana.data.account.repository.AccountEntityRepository;

/* loaded from: classes2.dex */
public class SplitBillPayerResult {
    @JSONField(alternateNames = {AccountEntityRepository.UpdateType.AVATAR}, name = GriverParams.ShareParams.IMAGE_URL)
    private String avatarUrl;
    private String fundAmount;
    private String loginId;
    private String name;
    private String status;
    private String userId;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getFundAmount() {
        return this.fundAmount;
    }

    public void setFundAmount(String str) {
        this.fundAmount = str;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String str) {
        this.loginId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }
}
