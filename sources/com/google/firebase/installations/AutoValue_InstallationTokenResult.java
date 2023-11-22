package com.google.firebase.installations;

import com.google.firebase.installations.InstallationTokenResult;

/* loaded from: classes3.dex */
final class AutoValue_InstallationTokenResult extends InstallationTokenResult {
    private final String token;
    private final long tokenCreationTimestamp;
    private final long tokenExpirationTimestamp;

    private AutoValue_InstallationTokenResult(String str, long j, long j2) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.tokenCreationTimestamp = j2;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final long getTokenCreationTimestamp() {
        return this.tokenCreationTimestamp;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InstallationTokenResult{token=");
        sb.append(this.token);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.tokenExpirationTimestamp);
        sb.append(", tokenCreationTimestamp=");
        sb.append(this.tokenCreationTimestamp);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallationTokenResult) {
            InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
            return this.token.equals(installationTokenResult.getToken()) && this.tokenExpirationTimestamp == installationTokenResult.getTokenExpirationTimestamp() && this.tokenCreationTimestamp == installationTokenResult.getTokenCreationTimestamp();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.token.hashCode();
        long j = this.tokenExpirationTimestamp;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.tokenCreationTimestamp;
        return ((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final InstallationTokenResult.Builder toBuilder() {
        return new Builder(this);
    }

    /* loaded from: classes.dex */
    static final class Builder extends InstallationTokenResult.Builder {
        private String token;
        private Long tokenCreationTimestamp;
        private Long tokenExpirationTimestamp;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(InstallationTokenResult installationTokenResult) {
            this.token = installationTokenResult.getToken();
            this.tokenExpirationTimestamp = Long.valueOf(installationTokenResult.getTokenExpirationTimestamp());
            this.tokenCreationTimestamp = Long.valueOf(installationTokenResult.getTokenCreationTimestamp());
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public final InstallationTokenResult.Builder setToken(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.token = str;
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public final InstallationTokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.tokenExpirationTimestamp = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public final InstallationTokenResult.Builder setTokenCreationTimestamp(long j) {
            this.tokenCreationTimestamp = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public final InstallationTokenResult build() {
            String str;
            if (this.token == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" token");
                str = sb.toString();
            } else {
                str = "";
            }
            if (this.tokenExpirationTimestamp == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" tokenExpirationTimestamp");
                str = sb2.toString();
            }
            if (this.tokenCreationTimestamp == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" tokenCreationTimestamp");
                str = sb3.toString();
            }
            if (!str.isEmpty()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Missing required properties:");
                sb4.append(str);
                throw new IllegalStateException(sb4.toString());
            }
            return new AutoValue_InstallationTokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.tokenCreationTimestamp.longValue());
        }
    }
}
