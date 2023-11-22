package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

/* loaded from: classes3.dex */
final class AutoValue_TokenResult extends TokenResult {
    private final TokenResult.ResponseCode responseCode;
    private final String token;
    private final long tokenExpirationTimestamp;

    private AutoValue_TokenResult(String str, long j, TokenResult.ResponseCode responseCode) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.responseCode = responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final TokenResult.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TokenResult{token=");
        sb.append(this.token);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.tokenExpirationTimestamp);
        sb.append(", responseCode=");
        sb.append(this.responseCode);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TokenResult) {
            TokenResult tokenResult = (TokenResult) obj;
            String str = this.token;
            if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
                if (this.tokenExpirationTimestamp == tokenResult.getTokenExpirationTimestamp()) {
                    TokenResult.ResponseCode responseCode = this.responseCode;
                    if (responseCode == null) {
                        if (tokenResult.getResponseCode() == null) {
                            return true;
                        }
                    } else if (responseCode.equals(tokenResult.getResponseCode())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.token;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.tokenExpirationTimestamp;
        int i = (int) (j ^ (j >>> 32));
        TokenResult.ResponseCode responseCode = this.responseCode;
        return ((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final TokenResult.Builder toBuilder() {
        return new Builder(this);
    }

    /* loaded from: classes3.dex */
    static final class Builder extends TokenResult.Builder {
        private TokenResult.ResponseCode responseCode;
        private String token;
        private Long tokenExpirationTimestamp;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(TokenResult tokenResult) {
            this.token = tokenResult.getToken();
            this.tokenExpirationTimestamp = Long.valueOf(tokenResult.getTokenExpirationTimestamp());
            this.responseCode = tokenResult.getResponseCode();
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public final TokenResult.Builder setToken(String str) {
            this.token = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public final TokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.tokenExpirationTimestamp = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public final TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public final TokenResult build() {
            String str;
            if (this.tokenExpirationTimestamp == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" tokenExpirationTimestamp");
                str = sb.toString();
            } else {
                str = "";
            }
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Missing required properties:");
                sb2.append(str);
                throw new IllegalStateException(sb2.toString());
            }
            return new AutoValue_TokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.responseCode);
        }
    }
}
