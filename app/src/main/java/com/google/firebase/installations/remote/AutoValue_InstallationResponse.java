package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

/* loaded from: classes3.dex */
final class AutoValue_InstallationResponse extends InstallationResponse {
    private final TokenResult authToken;
    private final String fid;
    private final String refreshToken;
    private final InstallationResponse.ResponseCode responseCode;
    private final String uri;

    private AutoValue_InstallationResponse(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode) {
        this.uri = str;
        this.fid = str2;
        this.refreshToken = str3;
        this.authToken = tokenResult;
        this.responseCode = responseCode;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String getUri() {
        return this.uri;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String getFid() {
        return this.fid;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final TokenResult getAuthToken() {
        return this.authToken;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final InstallationResponse.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InstallationResponse{uri=");
        sb.append(this.uri);
        sb.append(", fid=");
        sb.append(this.fid);
        sb.append(", refreshToken=");
        sb.append(this.refreshToken);
        sb.append(", authToken=");
        sb.append(this.authToken);
        sb.append(", responseCode=");
        sb.append(this.responseCode);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallationResponse) {
            InstallationResponse installationResponse = (InstallationResponse) obj;
            String str = this.uri;
            if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
                String str2 = this.fid;
                if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                    String str3 = this.refreshToken;
                    if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                        TokenResult tokenResult = this.authToken;
                        if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                            InstallationResponse.ResponseCode responseCode = this.responseCode;
                            if (responseCode == null) {
                                if (installationResponse.getResponseCode() == null) {
                                    return true;
                                }
                            } else if (responseCode.equals(installationResponse.getResponseCode())) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.uri;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.fid;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.refreshToken;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        TokenResult tokenResult = this.authToken;
        int hashCode4 = tokenResult == null ? 0 : tokenResult.hashCode();
        InstallationResponse.ResponseCode responseCode = this.responseCode;
        return ((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final InstallationResponse.Builder toBuilder() {
        return new Builder(this);
    }

    /* loaded from: classes3.dex */
    static final class Builder extends InstallationResponse.Builder {
        private TokenResult authToken;
        private String fid;
        private String refreshToken;
        private InstallationResponse.ResponseCode responseCode;
        private String uri;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(InstallationResponse installationResponse) {
            this.uri = installationResponse.getUri();
            this.fid = installationResponse.getFid();
            this.refreshToken = installationResponse.getRefreshToken();
            this.authToken = installationResponse.getAuthToken();
            this.responseCode = installationResponse.getResponseCode();
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setUri(String str) {
            this.uri = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setFid(String str) {
            this.fid = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setRefreshToken(String str) {
            this.refreshToken = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setAuthToken(TokenResult tokenResult) {
            this.authToken = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse build() {
            return new AutoValue_InstallationResponse(this.uri, this.fid, this.refreshToken, this.authToken, this.responseCode);
        }
    }
}
