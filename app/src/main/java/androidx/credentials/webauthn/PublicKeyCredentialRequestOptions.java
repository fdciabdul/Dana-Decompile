package androidx.credentials.webauthn;

import androidx.credentials.webauthn.WebAuthnUtils;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010"}, d2 = {"Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;", "", "", ClientData.KEY_CHALLENGE, "[B", "getChallenge", "()[B", "Lorg/json/JSONObject;", "json", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "", "rpId", "Ljava/lang/String;", "getRpId", "()Ljava/lang/String;", "", TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, "J", "getTimeout", "()J", "userVerification", "getUserVerification", "requestJson", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PublicKeyCredentialRequestOptions {
    private final byte[] challenge;
    private final JSONObject json;
    private final String rpId;
    private final long timeout;
    private final String userVerification;

    public PublicKeyCredentialRequestOptions(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        JSONObject jSONObject = new JSONObject(str);
        this.json = jSONObject;
        String string = jSONObject.getString(ClientData.KEY_CHALLENGE);
        WebAuthnUtils.Companion companion = WebAuthnUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(string, "");
        this.challenge = companion.b64Decode(string);
        this.timeout = jSONObject.optLong(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, 0L);
        String optString = jSONObject.optString("rpId", "");
        Intrinsics.checkNotNullExpressionValue(optString, "");
        this.rpId = optString;
        String optString2 = jSONObject.optString("userVerification", "preferred");
        Intrinsics.checkNotNullExpressionValue(optString2, "");
        this.userVerification = optString2;
    }

    @JvmName(name = "getJson")
    public final JSONObject getJson() {
        return this.json;
    }

    @JvmName(name = "getChallenge")
    public final byte[] getChallenge() {
        return this.challenge;
    }

    @JvmName(name = "getTimeout")
    public final long getTimeout() {
        return this.timeout;
    }

    @JvmName(name = "getRpId")
    public final String getRpId() {
        return this.rpId;
    }

    @JvmName(name = "getUserVerification")
    public final String getUserVerification() {
        return this.userVerification;
    }
}
