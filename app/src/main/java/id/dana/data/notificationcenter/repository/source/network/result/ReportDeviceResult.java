package id.dana.data.notificationcenter.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;

/* loaded from: classes4.dex */
public class ReportDeviceResult extends BaseRpcResult {
    private String code;
    private String message;
    private boolean success;

    public boolean isSuccess() {
        return this.success;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
