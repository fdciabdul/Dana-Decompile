package id.dana.network.base;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class BaseRpcResultAphome extends BaseRpcResult {
    @SerializedName("errorMsg")
    private String errorMsg;

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }
}
