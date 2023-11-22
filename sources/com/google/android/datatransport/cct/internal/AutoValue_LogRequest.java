package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* loaded from: classes7.dex */
final class AutoValue_LogRequest extends LogRequest {
    private final ClientInfo clientInfo;
    private final List<LogEvent> logEvents;
    private final Integer logSource;
    private final String logSourceName;
    private final QosTier qosTier;
    private final long requestTimeMs;
    private final long requestUptimeMs;

    private AutoValue_LogRequest(long j, long j2, ClientInfo clientInfo, Integer num, String str, List<LogEvent> list, QosTier qosTier) {
        this.requestTimeMs = j;
        this.requestUptimeMs = j2;
        this.clientInfo = clientInfo;
        this.logSource = num;
        this.logSourceName = str;
        this.logEvents = list;
        this.qosTier = qosTier;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final long getRequestTimeMs() {
        return this.requestTimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final long getRequestUptimeMs() {
        return this.requestUptimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final Integer getLogSource() {
        return this.logSource;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final String getLogSourceName() {
        return this.logSourceName;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Encodable.Field(name = "logEvent")
    public final List<LogEvent> getLogEvents() {
        return this.logEvents;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final QosTier getQosTier() {
        return this.qosTier;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LogRequest{requestTimeMs=");
        sb.append(this.requestTimeMs);
        sb.append(", requestUptimeMs=");
        sb.append(this.requestUptimeMs);
        sb.append(", clientInfo=");
        sb.append(this.clientInfo);
        sb.append(", logSource=");
        sb.append(this.logSource);
        sb.append(", logSourceName=");
        sb.append(this.logSourceName);
        sb.append(", logEvents=");
        sb.append(this.logEvents);
        sb.append(", qosTier=");
        sb.append(this.qosTier);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogRequest) {
            LogRequest logRequest = (LogRequest) obj;
            if (this.requestTimeMs == logRequest.getRequestTimeMs() && this.requestUptimeMs == logRequest.getRequestUptimeMs() && ((clientInfo = this.clientInfo) != null ? clientInfo.equals(logRequest.getClientInfo()) : logRequest.getClientInfo() == null) && ((num = this.logSource) != null ? num.equals(logRequest.getLogSource()) : logRequest.getLogSource() == null) && ((str = this.logSourceName) != null ? str.equals(logRequest.getLogSourceName()) : logRequest.getLogSourceName() == null) && ((list = this.logEvents) != null ? list.equals(logRequest.getLogEvents()) : logRequest.getLogEvents() == null)) {
                QosTier qosTier = this.qosTier;
                if (qosTier == null) {
                    if (logRequest.getQosTier() == null) {
                        return true;
                    }
                } else if (qosTier.equals(logRequest.getQosTier())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.requestTimeMs;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.requestUptimeMs;
        int i2 = (int) (j2 ^ (j2 >>> 32));
        ClientInfo clientInfo = this.clientInfo;
        int hashCode = clientInfo == null ? 0 : clientInfo.hashCode();
        Integer num = this.logSource;
        int hashCode2 = num == null ? 0 : num.hashCode();
        String str = this.logSourceName;
        int hashCode3 = str == null ? 0 : str.hashCode();
        List<LogEvent> list = this.logEvents;
        int hashCode4 = list == null ? 0 : list.hashCode();
        QosTier qosTier = this.qosTier;
        return ((((((((((i2 ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ hashCode) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    /* loaded from: classes7.dex */
    static final class Builder extends LogRequest.Builder {
        private ClientInfo clientInfo;
        private List<LogEvent> logEvents;
        private Integer logSource;
        private String logSourceName;
        private QosTier qosTier;
        private Long requestTimeMs;
        private Long requestUptimeMs;

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder setRequestTimeMs(long j) {
            this.requestTimeMs = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder setRequestUptimeMs(long j) {
            this.requestUptimeMs = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder setClientInfo(ClientInfo clientInfo) {
            this.clientInfo = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        final LogRequest.Builder setLogSource(Integer num) {
            this.logSource = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        final LogRequest.Builder setLogSourceName(String str) {
            this.logSourceName = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder setLogEvents(List<LogEvent> list) {
            this.logEvents = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder setQosTier(QosTier qosTier) {
            this.qosTier = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest build() {
            String str;
            if (this.requestTimeMs == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" requestTimeMs");
                str = sb.toString();
            } else {
                str = "";
            }
            if (this.requestUptimeMs == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" requestUptimeMs");
                str = sb2.toString();
            }
            if (!str.isEmpty()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Missing required properties:");
                sb3.append(str);
                throw new IllegalStateException(sb3.toString());
            }
            return new AutoValue_LogRequest(this.requestTimeMs.longValue(), this.requestUptimeMs.longValue(), this.clientInfo, this.logSource, this.logSourceName, this.logEvents, this.qosTier);
        }
    }
}
