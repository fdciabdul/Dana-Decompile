package id.dana.network.response.login;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class VerifyOtpResult extends BaseRpcResult {
    @SerializedName("failedCount")
    @JSONField(name = "failedCount")
    public int failedCount = 0;
    @SerializedName("identFailedCount")
    @JSONField(name = "identFailedCount")
    public int identFailedCount = 0;
    @SerializedName("maxFailedCount")
    @JSONField(name = "maxFailedCount")
    public int maxFailedCount = 0;
}
