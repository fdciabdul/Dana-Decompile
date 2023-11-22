package id.dana.passkey.model;

import java.util.List;

/* loaded from: classes9.dex */
public class GetPasskeyRequest {
    private final List<AllowCredentials> allowCredentials;
    private final String challenge;
    private final String rpId;
    private final int timeout;
    private final String userVerification;

    public GetPasskeyRequest(String str, List<AllowCredentials> list, int i, String str2, String str3) {
        this.challenge = str;
        this.allowCredentials = list;
        this.timeout = i;
        this.userVerification = str2;
        this.rpId = str3;
    }

    public String getChallenge() {
        return this.challenge;
    }

    public List<AllowCredentials> getAllowCredentials() {
        return this.allowCredentials;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getUserVerification() {
        return this.userVerification;
    }

    public String getRpId() {
        return this.rpId;
    }

    /* loaded from: classes9.dex */
    public static class AllowCredentials {

        /* renamed from: id  reason: collision with root package name */
        private final String f8227id;
        private final List<String> transports;
        private final String type;

        public AllowCredentials(String str, List<String> list, String str2) {
            this.f8227id = str;
            this.transports = list;
            this.type = str2;
        }

        public String getId() {
            return this.f8227id;
        }

        public List<String> getTransports() {
            return this.transports;
        }

        public String getType() {
            return this.type;
        }
    }
}
