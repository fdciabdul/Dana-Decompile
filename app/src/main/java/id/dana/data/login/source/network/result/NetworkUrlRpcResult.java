package id.dana.data.login.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;

/* loaded from: classes8.dex */
public class NetworkUrlRpcResult extends BaseRpcResult {
    private String correlationId;
    private String evUrl;
    private String referenceId;

    /* loaded from: classes8.dex */
    public static class ParamsName {
        public static final String CORRELATION_ID = "correlationId";
        public static final String REFERENCE_ID = "referenceId";
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public void setCorrelationId(String str) {
        this.correlationId = str;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(String str) {
        this.referenceId = str;
    }

    public String getEvUrl() {
        return this.evUrl;
    }

    public void setEvUrl(String str) {
        this.evUrl = str;
    }
}
