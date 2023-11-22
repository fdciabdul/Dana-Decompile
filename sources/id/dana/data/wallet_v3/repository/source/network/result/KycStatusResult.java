package id.dana.data.wallet_v3.repository.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class KycStatusResult extends BaseRpcResult {
    @SerializedName("errorContext")
    @JSONField(name = "errorContext")
    private Map<String, String> errorContext = Collections.emptyMap();

    public void setErrorContext(Map<String, String> map) {
        this.errorContext = map;
    }

    public Map<String, String> getErrorContext() {
        return this.errorContext;
    }
}
