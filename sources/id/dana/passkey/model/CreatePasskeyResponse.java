package id.dana.passkey.model;

import java.util.List;

/* loaded from: classes5.dex */
public class CreatePasskeyResponse {
    private final String authenticatorAttachment;

    /* renamed from: id  reason: collision with root package name */
    private final String f8226id;
    private final String rawId;
    private final Response response;
    private final String type;

    public CreatePasskeyResponse(Response response, String str, String str2, String str3, String str4) {
        this.response = response;
        this.authenticatorAttachment = str;
        this.f8226id = str2;
        this.rawId = str3;
        this.type = str4;
    }

    public Response getResponse() {
        return this.response;
    }

    public String getAuthenticatorAttachment() {
        return this.authenticatorAttachment;
    }

    public String getId() {
        return this.f8226id;
    }

    public String getRawId() {
        return this.rawId;
    }

    public String getType() {
        return this.type;
    }

    /* loaded from: classes9.dex */
    public static class Response {
        private final String attestationObject;
        private final String clientDataJSON;
        private final List<String> transports;

        public Response(String str, String str2, List<String> list) {
            this.clientDataJSON = str;
            this.attestationObject = str2;
            this.transports = list;
        }

        public String getClientDataJSON() {
            return this.clientDataJSON;
        }

        public String getAttestationObject() {
            return this.attestationObject;
        }

        public List<String> getTransports() {
            return this.transports;
        }
    }
}
