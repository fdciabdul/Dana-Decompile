package com.alibaba.ariver.kernel.common.log;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.log.BaseAppLog;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class ConnectionLog extends BaseAppLog {
    public static final String CONN_LOG_STATE_CANCEL = "cancel";
    public static final String CONN_LOG_STATE_FAIL = "fail";
    public static final String CONN_LOG_STATE_FINISH = "finish";
    public static final String CONN_LOG_STATE_REDIRECT = "redirect";
    public static final String CONN_LOG_STATE_RESPONSE = "response";
    public static final String CONN_LOG_STATE_START = "start";

    /* renamed from: a  reason: collision with root package name */
    private final Long f6134a;
    private final String b;
    private final Map<String, String> c;
    private final String d;
    private final Integer e;
    private final String f;
    private final String g;
    private final String h;

    private ConnectionLog(Builder builder) {
        super(builder);
        this.b = builder.f6135a;
        this.f6134a = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.type;
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        StringBuilder sb = new StringBuilder(baseInfo());
        if (!TextUtils.isEmpty(this.f)) {
            sb.append(" ");
            sb.append(this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            sb.append(" ");
            sb.append(this.g);
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" { URL: ");
            sb.append(this.b);
            sb.append(" }");
        }
        if (!TextUtils.isEmpty(this.h)) {
            sb.append(" type:");
            sb.append(this.h);
        }
        if (this.f6134a != null) {
            sb.append(" size:");
            sb.append(this.f6134a);
        }
        if (!TextUtils.isEmpty(this.d)) {
            sb.append(" headers:{");
            sb.append(this.d);
            sb.append("}");
        }
        Map<String, String> map = this.c;
        if (map != null) {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            sb.append(" headers:{ ");
            for (Map.Entry<String, String> entry : entrySet) {
                if (entry != null) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(",");
                }
            }
            sb.append("}");
        }
        if (this.e != null) {
            sb.append(" Status Code: ");
            sb.append(this.e);
        }
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* renamed from: a  reason: collision with root package name */
        private String f6135a;
        private Long b;
        private Map<String, String> c;
        private String d;
        private Integer e;
        private String f;
        private String g;
        public String type;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super(LogType.CONNECTION);
            this.f6135a = "";
            this.f = "";
            this.g = "";
        }

        public Builder setUrl(String str) {
            this.f6135a = str;
            return getThis();
        }

        public Builder setSize(Long l) {
            this.b = l;
            return getThis();
        }

        public Builder setHeaderString(String str) {
            this.d = str;
            return getThis();
        }

        public Builder setHeaders(Map<String, String> map) {
            this.c = map;
            return getThis();
        }

        public Builder setStatusCode(int i) {
            this.e = Integer.valueOf(i);
            return getThis();
        }

        public Builder setMethod(String str) {
            this.f = str;
            return getThis();
        }

        public Builder setErrMsg(String str) {
            this.g = str;
            return getThis();
        }

        public Builder setType(String str) {
            this.type = str;
            return getThis();
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder setGroupId(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_Connection");
            return (Builder) super.setGroupId(sb.toString());
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new ConnectionLog(this);
        }
    }
}
