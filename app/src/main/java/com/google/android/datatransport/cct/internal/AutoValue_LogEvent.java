package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

/* loaded from: classes7.dex */
final class AutoValue_LogEvent extends LogEvent {
    private final Integer eventCode;
    private final long eventTimeMs;
    private final long eventUptimeMs;
    private final NetworkConnectionInfo networkConnectionInfo;
    private final byte[] sourceExtension;
    private final String sourceExtensionJsonProto3;
    private final long timezoneOffsetSeconds;

    private AutoValue_LogEvent(long j, Integer num, long j2, byte[] bArr, String str, long j3, NetworkConnectionInfo networkConnectionInfo) {
        this.eventTimeMs = j;
        this.eventCode = num;
        this.eventUptimeMs = j2;
        this.sourceExtension = bArr;
        this.sourceExtensionJsonProto3 = str;
        this.timezoneOffsetSeconds = j3;
        this.networkConnectionInfo = networkConnectionInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final long getEventTimeMs() {
        return this.eventTimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final Integer getEventCode() {
        return this.eventCode;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final long getEventUptimeMs() {
        return this.eventUptimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final byte[] getSourceExtension() {
        return this.sourceExtension;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final String getSourceExtensionJsonProto3() {
        return this.sourceExtensionJsonProto3;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final long getTimezoneOffsetSeconds() {
        return this.timezoneOffsetSeconds;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.networkConnectionInfo;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LogEvent{eventTimeMs=");
        sb.append(this.eventTimeMs);
        sb.append(", eventCode=");
        sb.append(this.eventCode);
        sb.append(", eventUptimeMs=");
        sb.append(this.eventUptimeMs);
        sb.append(", sourceExtension=");
        sb.append(Arrays.toString(this.sourceExtension));
        sb.append(", sourceExtensionJsonProto3=");
        sb.append(this.sourceExtensionJsonProto3);
        sb.append(", timezoneOffsetSeconds=");
        sb.append(this.timezoneOffsetSeconds);
        sb.append(", networkConnectionInfo=");
        sb.append(this.networkConnectionInfo);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogEvent) {
            LogEvent logEvent = (LogEvent) obj;
            if (this.eventTimeMs == logEvent.getEventTimeMs() && ((num = this.eventCode) != null ? num.equals(logEvent.getEventCode()) : logEvent.getEventCode() == null) && this.eventUptimeMs == logEvent.getEventUptimeMs()) {
                if (Arrays.equals(this.sourceExtension, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).sourceExtension : logEvent.getSourceExtension()) && ((str = this.sourceExtensionJsonProto3) != null ? str.equals(logEvent.getSourceExtensionJsonProto3()) : logEvent.getSourceExtensionJsonProto3() == null) && this.timezoneOffsetSeconds == logEvent.getTimezoneOffsetSeconds()) {
                    NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo;
                    if (networkConnectionInfo == null) {
                        if (logEvent.getNetworkConnectionInfo() == null) {
                            return true;
                        }
                    } else if (networkConnectionInfo.equals(logEvent.getNetworkConnectionInfo())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.eventTimeMs;
        int i = (int) (j ^ (j >>> 32));
        Integer num = this.eventCode;
        int hashCode = num == null ? 0 : num.hashCode();
        long j2 = this.eventUptimeMs;
        int i2 = (int) (j2 ^ (j2 >>> 32));
        int hashCode2 = Arrays.hashCode(this.sourceExtension);
        String str = this.sourceExtensionJsonProto3;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.timezoneOffsetSeconds;
        int i3 = (int) (j3 ^ (j3 >>> 32));
        NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo;
        return ((((((((((hashCode ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ i2) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ i3) * 1000003) ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    /* loaded from: classes7.dex */
    static final class Builder extends LogEvent.Builder {
        private Integer eventCode;
        private Long eventTimeMs;
        private Long eventUptimeMs;
        private NetworkConnectionInfo networkConnectionInfo;
        private byte[] sourceExtension;
        private String sourceExtensionJsonProto3;
        private Long timezoneOffsetSeconds;

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder setEventTimeMs(long j) {
            this.eventTimeMs = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder setEventCode(Integer num) {
            this.eventCode = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder setEventUptimeMs(long j) {
            this.eventUptimeMs = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        final LogEvent.Builder setSourceExtension(byte[] bArr) {
            this.sourceExtension = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        final LogEvent.Builder setSourceExtensionJsonProto3(String str) {
            this.sourceExtensionJsonProto3 = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder setTimezoneOffsetSeconds(long j) {
            this.timezoneOffsetSeconds = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo) {
            this.networkConnectionInfo = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent build() {
            String str;
            if (this.eventTimeMs == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" eventTimeMs");
                str = sb.toString();
            } else {
                str = "";
            }
            if (this.eventUptimeMs == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" eventUptimeMs");
                str = sb2.toString();
            }
            if (this.timezoneOffsetSeconds == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" timezoneOffsetSeconds");
                str = sb3.toString();
            }
            if (!str.isEmpty()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Missing required properties:");
                sb4.append(str);
                throw new IllegalStateException(sb4.toString());
            }
            return new AutoValue_LogEvent(this.eventTimeMs.longValue(), this.eventCode, this.eventUptimeMs.longValue(), this.sourceExtension, this.sourceExtensionJsonProto3, this.timezoneOffsetSeconds.longValue(), this.networkConnectionInfo);
        }
    }
}
