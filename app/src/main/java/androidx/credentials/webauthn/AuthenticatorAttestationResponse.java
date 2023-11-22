package androidx.credentials.webauthn;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\"\u0010\u0013\u001a\u00020\u00068\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\nR\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0010"}, d2 = {"Landroidx/credentials/webauthn/AuthenticatorAttestationResponse;", "Landroidx/credentials/webauthn/AuthenticatorResponse;", "", "authData", "()[B", "defaultAttestationObject$credentials_release", "Lorg/json/JSONObject;", "json", "()Lorg/json/JSONObject;", "attestationObject", "[B", "getAttestationObject", "setAttestationObject", "([B)V", "", "be", "Z", "bs", "clientDataHash", "clientJson", "Lorg/json/JSONObject;", "getClientJson", "setClientJson", "(Lorg/json/JSONObject;)V", "credentialId", "credentialPublicKey", "", "origin", "Ljava/lang/String;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "Landroidx/credentials/webauthn/PublicKeyCredentialCreationOptions;", "requestOptions", "Landroidx/credentials/webauthn/PublicKeyCredentialCreationOptions;", "up", "uv", "<init>", "(Landroidx/credentials/webauthn/PublicKeyCredentialCreationOptions;[B[BLjava/lang/String;ZZZZLjava/lang/String;[B)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AuthenticatorAttestationResponse implements AuthenticatorResponse {
    private byte[] attestationObject;
    private final boolean be;
    private final boolean bs;
    private final byte[] clientDataHash;
    private JSONObject clientJson;
    private final byte[] credentialId;
    private final byte[] credentialPublicKey;
    private final String origin;
    private final String packageName;
    private final PublicKeyCredentialCreationOptions requestOptions;
    private final boolean up;
    private final boolean uv;

    public AuthenticatorAttestationResponse(PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions, byte[] bArr, byte[] bArr2, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, byte[] bArr3) {
        Intrinsics.checkNotNullParameter(publicKeyCredentialCreationOptions, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(bArr2, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.requestOptions = publicKeyCredentialCreationOptions;
        this.credentialId = bArr;
        this.credentialPublicKey = bArr2;
        this.origin = str;
        this.up = z;
        this.uv = z2;
        this.be = z3;
        this.bs = z4;
        this.packageName = str2;
        this.clientDataHash = bArr3;
        this.clientJson = new JSONObject();
        getClientJson().put("type", "webauthn.create");
        getClientJson().put(ClientData.KEY_CHALLENGE, WebAuthnUtils.INSTANCE.b64Encode(publicKeyCredentialCreationOptions.getChallenge()));
        getClientJson().put("origin", str);
        if (str2 != null) {
            getClientJson().put("androidPackageName", str2);
        }
        this.attestationObject = defaultAttestationObject$credentials_release();
    }

    public /* synthetic */ AuthenticatorAttestationResponse(PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions, byte[] bArr, byte[] bArr2, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, byte[] bArr3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(publicKeyCredentialCreationOptions, bArr, bArr2, str, z, z2, z3, z4, (i & 256) != 0 ? null : str2, (i & 512) != 0 ? null : bArr3);
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

    @JvmName(name = "getAttestationObject")
    public final byte[] getAttestationObject() {
        return this.attestationObject;
    }

    @JvmName(name = "setAttestationObject")
    public final void setAttestationObject(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        this.attestationObject = bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final byte[] authData() {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = this.requestOptions.getRp().getId().getBytes(Charsets.UTF_8);
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
        boolean z4 = z3;
        if (this.bs) {
            z4 = (z3 ? 1 : 0) | true;
        }
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = 0;
        }
        byte[] bArr2 = this.credentialId;
        byte[] bArr3 = {(byte) (bArr2.length >> 8), (byte) bArr2.length};
        Intrinsics.checkNotNullExpressionValue(digest, "");
        return ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(digest, new byte[]{(byte) (z4 | 64)}), new byte[]{0, 0, 0, 0}), bArr), bArr3), this.credentialId), this.credentialPublicKey);
    }

    public final byte[] defaultAttestationObject$credentials_release() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("fmt", "none");
        linkedHashMap.put("attStmt", MapsKt.emptyMap());
        linkedHashMap.put("authData", authData());
        return new Cbor().encode(linkedHashMap);
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
        jSONObject2.put("attestationObject", WebAuthnUtils.INSTANCE.b64Encode(this.attestationObject));
        jSONObject2.put("transports", new JSONArray((Collection) CollectionsKt.listOf((Object[]) new String[]{"internal", "hybrid"})));
        return jSONObject2;
    }
}
