package id.dana.data.verifytoken.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;

/* loaded from: classes4.dex */
public class VerifyTokenRequest extends BaseRpcRequest {
    private String phoneNumber;
    private String tokenScene;

    public String getTokenScene() {
        return this.tokenScene;
    }

    public void setTokenScene(String str) {
        this.tokenScene = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }
}
