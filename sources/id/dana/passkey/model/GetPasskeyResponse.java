package id.dana.passkey.model;

/* loaded from: classes5.dex */
public class GetPasskeyResponse {
    public String authenticatorAttachment;

    /* renamed from: id  reason: collision with root package name */
    public String f8228id;
    public String rawId;
    public Response response;
    public String type;

    public /* synthetic */ GetPasskeyResponse() {
    }

    public GetPasskeyResponse(Response response, String str, String str2, String str3, String str4) {
        this.response = response;
        this.authenticatorAttachment = str;
        this.f8228id = str2;
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
        return this.f8228id;
    }

    public String getRawId() {
        return this.rawId;
    }

    public String getType() {
        return this.type;
    }

    /* loaded from: classes5.dex */
    public static class Response {
        public String authenticatorData;
        public String clientDataJSON;
        public String signature;
        public String userHandle;

        public /* synthetic */ Response() {
        }

        public Response(String str, String str2, String str3, String str4) {
            this.clientDataJSON = str;
            this.authenticatorData = str2;
            this.signature = str3;
            this.userHandle = str4;
        }

        public String getClientDataJSON() {
            return this.clientDataJSON;
        }

        public String getAuthenticatorData() {
            return this.authenticatorData;
        }

        public String getSignature() {
            return this.signature;
        }

        public String getUserHandle() {
            return this.userHandle;
        }
    }
}
