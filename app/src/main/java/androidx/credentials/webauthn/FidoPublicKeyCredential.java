package androidx.credentials.webauthn;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Landroidx/credentials/webauthn/FidoPublicKeyCredential;", "", "", "json", "()Ljava/lang/String;", "authenticatorAttachment", "Ljava/lang/String;", "getAuthenticatorAttachment", "", "rawId", "[B", "getRawId", "()[B", "Landroidx/credentials/webauthn/AuthenticatorResponse;", "response", "Landroidx/credentials/webauthn/AuthenticatorResponse;", "getResponse", "()Landroidx/credentials/webauthn/AuthenticatorResponse;", "<init>", "([BLandroidx/credentials/webauthn/AuthenticatorResponse;Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FidoPublicKeyCredential {
    private final String authenticatorAttachment;
    private final byte[] rawId;
    private final AuthenticatorResponse response;

    public FidoPublicKeyCredential(byte[] bArr, AuthenticatorResponse authenticatorResponse, String str) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(authenticatorResponse, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.rawId = bArr;
        this.response = authenticatorResponse;
        this.authenticatorAttachment = str;
    }

    @JvmName(name = "getRawId")
    public final byte[] getRawId() {
        return this.rawId;
    }

    @JvmName(name = "getResponse")
    public final AuthenticatorResponse getResponse() {
        return this.response;
    }

    @JvmName(name = "getAuthenticatorAttachment")
    public final String getAuthenticatorAttachment() {
        return this.authenticatorAttachment;
    }

    public final String json() {
        String b64Encode = WebAuthnUtils.INSTANCE.b64Encode(this.rawId);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", b64Encode);
        jSONObject.put("rawId", b64Encode);
        jSONObject.put("type", "public-key");
        jSONObject.put("authenticatorAttachment", this.authenticatorAttachment);
        jSONObject.put("response", this.response.json());
        jSONObject.put("clientExtensionResults", new JSONObject());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "");
        return jSONObject2;
    }
}
