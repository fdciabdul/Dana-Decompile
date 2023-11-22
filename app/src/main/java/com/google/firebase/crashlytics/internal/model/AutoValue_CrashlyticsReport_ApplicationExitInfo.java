package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {
    private final int importance;
    private final int pid;
    private final String processName;
    private final long pss;
    private final int reasonCode;
    private final long rss;
    private final long timestamp;
    private final String traceFile;

    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i, String str, int i2, int i3, long j, long j2, long j3, String str2) {
        this.pid = i;
        this.processName = str;
        this.reasonCode = i2;
        this.importance = i3;
        this.pss = j;
        this.rss = j2;
        this.timestamp = j3;
        this.traceFile = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final int getPid() {
        return this.pid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final String getProcessName() {
        return this.processName;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final int getReasonCode() {
        return this.reasonCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final int getImportance() {
        return this.importance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final long getPss() {
        return this.pss;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final long getRss() {
        return this.rss;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final String getTraceFile() {
        return this.traceFile;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApplicationExitInfo{pid=");
        sb.append(this.pid);
        sb.append(", processName=");
        sb.append(this.processName);
        sb.append(", reasonCode=");
        sb.append(this.reasonCode);
        sb.append(", importance=");
        sb.append(this.importance);
        sb.append(", pss=");
        sb.append(this.pss);
        sb.append(", rss=");
        sb.append(this.rss);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", traceFile=");
        sb.append(this.traceFile);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.ApplicationExitInfo) {
            CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
            if (this.pid == applicationExitInfo.getPid() && this.processName.equals(applicationExitInfo.getProcessName()) && this.reasonCode == applicationExitInfo.getReasonCode() && this.importance == applicationExitInfo.getImportance() && this.pss == applicationExitInfo.getPss() && this.rss == applicationExitInfo.getRss() && this.timestamp == applicationExitInfo.getTimestamp()) {
                String str = this.traceFile;
                if (str == null) {
                    if (applicationExitInfo.getTraceFile() == null) {
                        return true;
                    }
                } else if (str.equals(applicationExitInfo.getTraceFile())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.pid;
        int hashCode = this.processName.hashCode();
        int i2 = this.reasonCode;
        int i3 = this.importance;
        long j = this.pss;
        int i4 = (int) (j ^ (j >>> 32));
        long j2 = this.rss;
        int i5 = (int) (j2 ^ (j2 >>> 32));
        long j3 = this.timestamp;
        int i6 = (int) (j3 ^ (j3 >>> 32));
        String str = this.traceFile;
        return ((((((((((((((i ^ 1000003) * 1000003) ^ hashCode) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ i4) * 1000003) ^ i5) * 1000003) ^ i6) * 1000003) ^ (str == null ? 0 : str.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {
        private Integer importance;
        private Integer pid;
        private String processName;
        private Long pss;
        private Integer reasonCode;
        private Long rss;
        private Long timestamp;
        private String traceFile;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder setPid(int i) {
            this.pid = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder setProcessName(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.processName = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder setReasonCode(int i) {
            this.reasonCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder setPss(long j) {
            this.pss = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder setRss(long j) {
            this.rss = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder setTimestamp(long j) {
            this.timestamp = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder setTraceFile(String str) {
            this.traceFile = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo build() {
            String str;
            if (this.pid == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" pid");
                str = sb.toString();
            } else {
                str = "";
            }
            if (this.processName == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" processName");
                str = sb2.toString();
            }
            if (this.reasonCode == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" reasonCode");
                str = sb3.toString();
            }
            if (this.importance == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(" importance");
                str = sb4.toString();
            }
            if (this.pss == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(" pss");
                str = sb5.toString();
            }
            if (this.rss == null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append(" rss");
                str = sb6.toString();
            }
            if (this.timestamp == null) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append(" timestamp");
                str = sb7.toString();
            }
            if (!str.isEmpty()) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("Missing required properties:");
                sb8.append(str);
                throw new IllegalStateException(sb8.toString());
            }
            return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.pid.intValue(), this.processName, this.reasonCode.intValue(), this.importance.intValue(), this.pss.longValue(), this.rss.longValue(), this.timestamp.longValue(), this.traceFile);
        }
    }
}
