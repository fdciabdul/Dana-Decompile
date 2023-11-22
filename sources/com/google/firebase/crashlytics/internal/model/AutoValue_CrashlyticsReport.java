package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport extends CrashlyticsReport {
    private final String buildVersion;
    private final String displayVersion;
    private final String gmpAppId;
    private final String installationUuid;
    private final CrashlyticsReport.FilesPayload ndkPayload;
    private final int platform;
    private final String sdkVersion;
    private final CrashlyticsReport.Session session;

    private AutoValue_CrashlyticsReport(String str, String str2, int i, String str3, String str4, String str5, CrashlyticsReport.Session session, CrashlyticsReport.FilesPayload filesPayload) {
        this.sdkVersion = str;
        this.gmpAppId = str2;
        this.platform = i;
        this.installationUuid = str3;
        this.buildVersion = str4;
        this.displayVersion = str5;
        this.session = session;
        this.ndkPayload = filesPayload;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getGmpAppId() {
        return this.gmpAppId;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final int getPlatform() {
        return this.platform;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getInstallationUuid() {
        return this.installationUuid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getBuildVersion() {
        return this.buildVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getDisplayVersion() {
        return this.displayVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final CrashlyticsReport.Session getSession() {
        return this.session;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final CrashlyticsReport.FilesPayload getNdkPayload() {
        return this.ndkPayload;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CrashlyticsReport{sdkVersion=");
        sb.append(this.sdkVersion);
        sb.append(", gmpAppId=");
        sb.append(this.gmpAppId);
        sb.append(", platform=");
        sb.append(this.platform);
        sb.append(", installationUuid=");
        sb.append(this.installationUuid);
        sb.append(", buildVersion=");
        sb.append(this.buildVersion);
        sb.append(", displayVersion=");
        sb.append(this.displayVersion);
        sb.append(", session=");
        sb.append(this.session);
        sb.append(", ndkPayload=");
        sb.append(this.ndkPayload);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        CrashlyticsReport.Session session;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport) {
            CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
            if (this.sdkVersion.equals(crashlyticsReport.getSdkVersion()) && this.gmpAppId.equals(crashlyticsReport.getGmpAppId()) && this.platform == crashlyticsReport.getPlatform() && this.installationUuid.equals(crashlyticsReport.getInstallationUuid()) && this.buildVersion.equals(crashlyticsReport.getBuildVersion()) && this.displayVersion.equals(crashlyticsReport.getDisplayVersion()) && ((session = this.session) != null ? session.equals(crashlyticsReport.getSession()) : crashlyticsReport.getSession() == null)) {
                CrashlyticsReport.FilesPayload filesPayload = this.ndkPayload;
                if (filesPayload == null) {
                    if (crashlyticsReport.getNdkPayload() == null) {
                        return true;
                    }
                } else if (filesPayload.equals(crashlyticsReport.getNdkPayload())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.sdkVersion.hashCode();
        int hashCode2 = this.gmpAppId.hashCode();
        int i = this.platform;
        int hashCode3 = this.installationUuid.hashCode();
        int hashCode4 = this.buildVersion.hashCode();
        int hashCode5 = this.displayVersion.hashCode();
        CrashlyticsReport.Session session = this.session;
        int hashCode6 = session == null ? 0 : session.hashCode();
        CrashlyticsReport.FilesPayload filesPayload = this.ndkPayload;
        return ((((((((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ i) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ hashCode5) * 1000003) ^ hashCode6) * 1000003) ^ (filesPayload != null ? filesPayload.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    protected final CrashlyticsReport.Builder toBuilder() {
        return new Builder(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends CrashlyticsReport.Builder {
        private String buildVersion;
        private String displayVersion;
        private String gmpAppId;
        private String installationUuid;
        private CrashlyticsReport.FilesPayload ndkPayload;
        private Integer platform;
        private String sdkVersion;
        private CrashlyticsReport.Session session;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport crashlyticsReport) {
            this.sdkVersion = crashlyticsReport.getSdkVersion();
            this.gmpAppId = crashlyticsReport.getGmpAppId();
            this.platform = Integer.valueOf(crashlyticsReport.getPlatform());
            this.installationUuid = crashlyticsReport.getInstallationUuid();
            this.buildVersion = crashlyticsReport.getBuildVersion();
            this.displayVersion = crashlyticsReport.getDisplayVersion();
            this.session = crashlyticsReport.getSession();
            this.ndkPayload = crashlyticsReport.getNdkPayload();
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder setSdkVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.sdkVersion = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder setGmpAppId(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.gmpAppId = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder setPlatform(int i) {
            this.platform = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder setInstallationUuid(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.installationUuid = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder setBuildVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.buildVersion = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder setDisplayVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.displayVersion = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder setSession(CrashlyticsReport.Session session) {
            this.session = session;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder setNdkPayload(CrashlyticsReport.FilesPayload filesPayload) {
            this.ndkPayload = filesPayload;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport build() {
            String str;
            if (this.sdkVersion == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" sdkVersion");
                str = sb.toString();
            } else {
                str = "";
            }
            if (this.gmpAppId == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" gmpAppId");
                str = sb2.toString();
            }
            if (this.platform == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" platform");
                str = sb3.toString();
            }
            if (this.installationUuid == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(" installationUuid");
                str = sb4.toString();
            }
            if (this.buildVersion == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(" buildVersion");
                str = sb5.toString();
            }
            if (this.displayVersion == null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append(" displayVersion");
                str = sb6.toString();
            }
            if (!str.isEmpty()) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Missing required properties:");
                sb7.append(str);
                throw new IllegalStateException(sb7.toString());
            }
            return new AutoValue_CrashlyticsReport(this.sdkVersion, this.gmpAppId, this.platform.intValue(), this.installationUuid, this.buildVersion, this.displayVersion, this.session, this.ndkPayload);
        }
    }
}
