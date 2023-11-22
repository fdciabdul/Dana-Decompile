package androidx.credentials.webauthn;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.data.constant.BranchLinkConstant;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\"\u0010\u0013\u001a\u00020\u00068\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\nR\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010\rR\u0014\u0010#\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0010R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010\nR\u0014\u0010%\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0010"}, d2 = {"Landroidx/credentials/webauthn/AuthenticatorAssertionResponse;", "Landroidx/credentials/webauthn/AuthenticatorResponse;", "", "dataToSign", "()[B", "defaultAuthenticatorData", "Lorg/json/JSONObject;", "json", "()Lorg/json/JSONObject;", "authenticatorData", "[B", "getAuthenticatorData", "setAuthenticatorData", "([B)V", "", "be", "Z", "bs", "clientDataHash", "clientJson", "Lorg/json/JSONObject;", "getClientJson", "setClientJson", "(Lorg/json/JSONObject;)V", "credentialId", "", "origin", "Ljava/lang/String;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;", "requestOptions", "Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;", BranchLinkConstant.OauthParams.SIGNATURE, "getSignature", "setSignature", "up", "userHandle", "uv", "<init>", "(Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;[BLjava/lang/String;ZZZZ[BLjava/lang/String;[B)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AuthenticatorAssertionResponse implements AuthenticatorResponse {
    private byte[] authenticatorData;
    private final boolean be;
    private final boolean bs;
    private final byte[] clientDataHash;
    private JSONObject clientJson;
    private final byte[] credentialId;
    private final String origin;
    private final String packageName;
    private final PublicKeyCredentialRequestOptions requestOptions;
    private byte[] signature;
    private final boolean up;
    private byte[] userHandle;
    private final boolean uv;

    public AuthenticatorAssertionResponse(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, byte[] bArr, String str, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr2, String str2, byte[] bArr3) {
        Intrinsics.checkNotNullParameter(publicKeyCredentialRequestOptions, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bArr2, "");
        this.requestOptions = publicKeyCredentialRequestOptions;
        this.credentialId = bArr;
        this.origin = str;
        this.up = z;
        this.uv = z2;
        this.be = z3;
        this.bs = z4;
        this.userHandle = bArr2;
        this.packageName = str2;
        this.clientDataHash = bArr3;
        this.clientJson = new JSONObject();
        this.signature = new byte[0];
        getClientJson().put("type", "webauthn.get");
        getClientJson().put(ClientData.KEY_CHALLENGE, WebAuthnUtils.INSTANCE.b64Encode(publicKeyCredentialRequestOptions.getChallenge()));
        getClientJson().put("origin", str);
        if (str2 != null) {
            getClientJson().put("androidPackageName", str2);
        }
        this.authenticatorData = defaultAuthenticatorData();
    }

    public /* synthetic */ AuthenticatorAssertionResponse(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, byte[] bArr, String str, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr2, String str2, byte[] bArr3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(publicKeyCredentialRequestOptions, bArr, str, z, z2, z3, z4, bArr2, (i & 256) != 0 ? null : str2, (i & 512) != 0 ? null : bArr3);
    }

    @Override // androidx.credentials.webauthn.AuthenticatorResponse
    @JvmName(name = "getClientJson")
    public final JSONObject getClientJson() {
        return this.clientJson;
    }

    @Override // androidx.credentials.webauthn.AuthenticatorResponse
    @JvmName(name = "setClientJson")
    public final void setClientJson(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        this.clientJson = jSONObject;
    }

    @JvmName(name = "getAuthenticatorData")
    public final byte[] getAuthenticatorData() {
        return this.authenticatorData;
    }

    @JvmName(name = "setAuthenticatorData")
    public final void setAuthenticatorData(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        this.authenticatorData = bArr;
    }

    @JvmName(name = "getSignature")
    public final byte[] getSignature() {
        return this.signature;
    }

    @JvmName(name = "setSignature")
    public final void setSignature(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        this.signature = bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final byte[] defaultAuthenticatorData() {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = this.requestOptions.getRpId().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] digest = messageDigest.digest(bytes);
        boolean z = this.up;
        boolean z2 = z;
        if (this.uv) {
            z2 = (z ? 1 : 0) | true;
        }
        boolean z3 = z2;
        if (this.be) {
            z3 = (z2 ? 1 : 0) | true;
        }
        int i = z3;
        if (this.bs) {
            i = (z3 ? 1 : 0) | true;
        }
        Intrinsics.checkNotNullExpressionValue(digest, "");
        return ArraysKt.plus(ArraysKt.plus(digest, new byte[]{(byte) i}), new byte[]{0, 0, 0, 0});
    }

    public final byte[] dataToSign() {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bArr = this.clientDataHash;
        if (bArr == null) {
            String jSONObject = getClientJson().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "");
            byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            bArr = messageDigest.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(bArr, "");
        }
        return ArraysKt.plus(this.authenticatorData, bArr);
    }

    @Override // androidx.credentials.webauthn.AuthenticatorResponse
    public final JSONObject json() {
        String jSONObject = getClientJson().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "");
        byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        JSONObject jSONObject2 = new JSONObject();
        if (this.clientDataHash == null) {
            jSONObject2.put("clientDataJSON", WebAuthnUtils.INSTANCE.b64Encode(bytes));
        }
        jSONObject2.put("authenticatorData", WebAuthnUtils.INSTANCE.b64Encode(this.authenticatorData));
        jSONObject2.put(BranchLinkConstant.OauthParams.SIGNATURE, WebAuthnUtils.INSTANCE.b64Encode(this.signature));
        jSONObject2.put("userHandle", WebAuthnUtils.INSTANCE.b64Encode(this.userHandle));
        return jSONObject2;
    }
}
