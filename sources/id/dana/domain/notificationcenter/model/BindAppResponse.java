package id.dana.domain.notificationcenter.model;

import id.dana.utils.rpc.response.BaseRpcResponse;

/* loaded from: classes4.dex */
public class BindAppResponse extends BaseRpcResponse {
    private String code;
    private String message;

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
