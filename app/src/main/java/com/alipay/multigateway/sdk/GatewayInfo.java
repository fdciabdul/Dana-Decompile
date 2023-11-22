package com.alipay.multigateway.sdk;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class GatewayInfo implements Cloneable {
    public Map<String, String> headers = new HashMap();

    /* renamed from: id  reason: collision with root package name */
    public String f7323id;
    public SignInfo signInfo;
    public String targetUrl;

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public void addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        this.headers.put(str, str2);
    }

    /* loaded from: classes3.dex */
    public static final class SignInfo {
        public Map<String, String> extra = new HashMap();
        public String headerName;
        public String type;

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[type:");
            sb.append(this.type);
            sb.append(",headerName:");
            sb.append(this.headerName);
            sb.append("extras:");
            sb.append(this.extra);
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public GatewayInfo m86clone() {
        GatewayInfo gatewayInfo = new GatewayInfo();
        gatewayInfo.f7323id = this.f7323id;
        gatewayInfo.targetUrl = this.targetUrl;
        gatewayInfo.signInfo = this.signInfo;
        gatewayInfo.headers = new HashMap();
        if (!this.headers.isEmpty()) {
            gatewayInfo.headers.putAll(this.headers);
        }
        return gatewayInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[id:");
        sb.append(this.f7323id);
        sb.append(",targetUrl:");
        sb.append(this.targetUrl);
        sb.append(",headers:");
        sb.append(this.headers);
        sb.append(",signInfo:");
        sb.append(this.signInfo);
        sb.append("]");
        return sb.toString();
    }
}
