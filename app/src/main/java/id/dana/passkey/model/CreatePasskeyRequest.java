package id.dana.passkey.model;

import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.google.gson.JsonObject;
import id.dana.passkey.Passkey;
import java.util.List;

@Deprecated
/* loaded from: classes9.dex */
public class CreatePasskeyRequest {
    private final String attestation;
    private final AuthenticatorSelection authenticatorSelection;
    private String challenge;
    private final List<Object> excludeCredentials;
    private final JsonObject extensions;
    private final List<PubKeyCredParams> pubKeyCredParams;
    private final Rp rp;
    private final long timeout;
    private final User user;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreatePasskeyRequest(Rp rp, User user, List<PubKeyCredParams> list, long j, String str, List<Object> list2, AuthenticatorSelection authenticatorSelection, JsonObject jsonObject) {
        this.rp = rp;
        this.user = user;
        this.pubKeyCredParams = list;
        this.timeout = j;
        this.attestation = str;
        this.excludeCredentials = list2;
        this.authenticatorSelection = authenticatorSelection;
        this.extensions = jsonObject;
    }

    public static CreatePasskeyRequestBuilder newBuilder() {
        return new CreatePasskeyRequestBuilder();
    }

    public void setChallenge(String str) {
        this.challenge = str;
    }

    public String getChallenge() {
        return this.challenge;
    }

    public Rp getRp() {
        return this.rp;
    }

    public User getUser() {
        return this.user;
    }

    public List<PubKeyCredParams> getPubKeyCredParams() {
        return this.pubKeyCredParams;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public String getAttestation() {
        return this.attestation;
    }

    public List<Object> getExcludeCredentials() {
        return this.excludeCredentials;
    }

    public AuthenticatorSelection getAuthenticatorSelection() {
        return this.authenticatorSelection;
    }

    /* loaded from: classes9.dex */
    public static class Rp {

        /* renamed from: id  reason: collision with root package name */
        private final String f8224id;
        private final String name;

        public Rp(String str, String str2) {
            this.name = str;
            this.f8224id = str2;
        }

        public String getName() {
            return this.name;
        }

        public String getId() {
            return this.f8224id;
        }
    }

    /* loaded from: classes9.dex */
    public static class User {
        private final String displayName;

        /* renamed from: id  reason: collision with root package name */
        private final String f8225id;
        private final String name;

        public User(String str, String str2, String str3) {
            this.f8225id = str;
            this.name = str2;
            this.displayName = str3;
        }

        public String getId() {
            return this.f8225id;
        }

        public String getName() {
            return this.name;
        }

        public String getDisplayName() {
            return this.displayName;
        }
    }

    /* loaded from: classes9.dex */
    public static class PubKeyCredParams {
        private final int alg;
        private final String type;

        public PubKeyCredParams(String str, int i) {
            this.type = str;
            this.alg = i;
        }

        public static PubKeyCredParams publicKey(int i) {
            return new PubKeyCredParams("public-key", i);
        }

        public String getType() {
            return this.type;
        }

        public int getAlg() {
            return this.alg;
        }
    }

    /* loaded from: classes9.dex */
    public static class AuthenticatorSelection {
        private final String authenticatorAttachment;
        private final boolean requireResidentKey;
        private final String residentKey;
        private final String userVerification;

        public AuthenticatorSelection(String str, boolean z, String str2, String str3) {
            this.authenticatorAttachment = str;
            this.requireResidentKey = z;
            this.residentKey = str2;
            this.userVerification = str3;
        }

        public static AuthenticatorSelection defaultInstance() {
            return new AuthenticatorSelection(TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, true, Passkey.REQUIRED, Passkey.REQUIRED);
        }

        public String getAuthenticatorAttachment() {
            return this.authenticatorAttachment;
        }

        public boolean getRequireResidentKey() {
            return this.requireResidentKey;
        }

        public String getResidentKey() {
            return this.residentKey;
        }

        public String getUserVerification() {
            return this.userVerification;
        }
    }
}
