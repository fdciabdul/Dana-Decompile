package id.dana.domain.notificationcenter.model;

import id.dana.utils.rpc.response.BaseRpcResponse;

/* loaded from: classes8.dex */
public class UnBindAppResponse extends BaseRpcResponse {
    private String code;
    private String message;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
