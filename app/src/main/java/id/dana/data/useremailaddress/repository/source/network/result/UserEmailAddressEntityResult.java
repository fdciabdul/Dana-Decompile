package id.dana.data.useremailaddress.repository.source.network.result;

import com.appsflyer.AppsFlyerProperties;
import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;

/* loaded from: classes4.dex */
public class UserEmailAddressEntityResult extends BaseRpcResultAphome {
    @SerializedName(AppsFlyerProperties.USER_EMAIL)
    private String userEmail;
    private String verifyStatus;

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getVerifyStatus() {
        return this.verifyStatus;
    }
}
