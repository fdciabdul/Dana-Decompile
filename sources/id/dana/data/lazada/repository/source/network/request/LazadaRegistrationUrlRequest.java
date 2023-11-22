package id.dana.data.lazada.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;

/* loaded from: classes4.dex */
public class LazadaRegistrationUrlRequest extends BaseRpcRequest {
    private String bizType;
    private String deviceId;

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }
}
