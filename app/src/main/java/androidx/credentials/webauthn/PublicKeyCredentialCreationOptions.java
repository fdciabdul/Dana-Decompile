package androidx.credentials.webauthn;

import androidx.credentials.webauthn.WebAuthnUtils;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.passkey.Passkey;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00106\u001a\u00020\u0002¢\u0006\u0004\b7\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R \u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00158\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR\u001a\u0010&\u001a\u00020%8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00102\u001a\u0002018\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105"}, d2 = {"Landroidx/credentials/webauthn/PublicKeyCredentialCreationOptions;", "", "", "attestation", "Ljava/lang/String;", "getAttestation", "()Ljava/lang/String;", "setAttestation", "(Ljava/lang/String;)V", "Landroidx/credentials/webauthn/AuthenticatorSelectionCriteria;", "authenticatorSelection", "Landroidx/credentials/webauthn/AuthenticatorSelectionCriteria;", "getAuthenticatorSelection", "()Landroidx/credentials/webauthn/AuthenticatorSelectionCriteria;", "setAuthenticatorSelection", "(Landroidx/credentials/webauthn/AuthenticatorSelectionCriteria;)V", "", ClientData.KEY_CHALLENGE, "[B", "getChallenge", "()[B", "", "Landroidx/credentials/webauthn/PublicKeyCredentialDescriptor;", "excludeCredentials", "Ljava/util/List;", "getExcludeCredentials", "()Ljava/util/List;", "setExcludeCredentials", "(Ljava/util/List;)V", "Lorg/json/JSONObject;", "json", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "Landroidx/credentials/webauthn/PublicKeyCredentialParameters;", "pubKeyCredParams", "getPubKeyCredParams", "Landroidx/credentials/webauthn/PublicKeyCredentialRpEntity;", "rp", "Landroidx/credentials/webauthn/PublicKeyCredentialRpEntity;", "getRp", "()Landroidx/credentials/webauthn/PublicKeyCredentialRpEntity;", "", TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, "J", "getTimeout", "()J", "setTimeout", "(J)V", "Landroidx/credentials/webauthn/PublicKeyCredentialUserEntity;", "user", "Landroidx/credentials/webauthn/PublicKeyCredentialUserEntity;", "getUser", "()Landroidx/credentials/webauthn/PublicKeyCredentialUserEntity;", "requestJson", "<init>"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PublicKeyCredentialCreationOptions {
    private String attestation;
    private AuthenticatorSelectionCriteria authenticatorSelection;
    private final byte[] challenge;
    private List<PublicKeyCredentialDescriptor> excludeCredentials;
    private final JSONObject json;
    private final List<PublicKeyCredentialParameters> pubKeyCredParams;
    private final PublicKeyCredentialRpEntity rp;
    private long timeout;
    private final PublicKeyCredentialUserEntity user;

    public PublicKeyCredentialCreationOptions(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        JSONObject jSONObject = new JSONObject(str);
        this.json = jSONObject;
        String string = jSONObject.getString(ClientData.KEY_CHALLENGE);
        WebAuthnUtils.Companion companion = WebAuthnUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(string, "");
        this.challenge = companion.b64Decode(string);
        JSONObject jSONObject2 = jSONObject.getJSONObject("rp");
        String string2 = jSONObject2.getString("name");
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = jSONObject2.getString("id");
        Intrinsics.checkNotNullExpressionValue(string3, "");
        this.rp = new PublicKeyCredentialRpEntity(string2, string3);
        JSONObject jSONObject3 = jSONObject.getJSONObject("user");
        WebAuthnUtils.Companion companion2 = WebAuthnUtils.INSTANCE;
        String string4 = jSONObject3.getString("id");
        Intrinsics.checkNotNullExpressionValue(string4, "");
        byte[] b64Decode = companion2.b64Decode(string4);
        String string5 = jSONObject3.getString("name");
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = jSONObject3.getString(ExtendInfoUtilKt.DISPLAY_NAME_KEY);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        this.user = new PublicKeyCredentialUserEntity(string5, b64Decode, string6);
        JSONArray jSONArray = jSONObject.getJSONArray("pubKeyCredParams");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i);
            String string7 = jSONObject4.getString("type");
            Intrinsics.checkNotNullExpressionValue(string7, "");
            arrayList.add(new PublicKeyCredentialParameters(string7, jSONObject4.getLong("alg")));
        }
        List<PublicKeyCredentialParameters> list = CollectionsKt.toList(arrayList);
        this.pubKeyCredParams = list;
        this.timeout = this.json.optLong(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, 0L);
        this.excludeCredentials = CollectionsKt.emptyList();
        this.authenticatorSelection = new AuthenticatorSelectionCriteria(TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, Passkey.REQUIRED, false, null, 12, null);
        String optString = this.json.optString("attestation", "none");
        Intrinsics.checkNotNullExpressionValue(optString, "");
        this.attestation = optString;
        StringBuilder sb = new StringBuilder();
        sb.append("Challenge ");
        sb.append(this.challenge);
        sb.append("()");
        InstrumentInjector.log_i("WebAuthn", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rp ");
        sb2.append(this.rp);
        InstrumentInjector.log_i("WebAuthn", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("user ");
        sb3.append(this.user);
        InstrumentInjector.log_i("WebAuthn", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("pubKeyCredParams ");
        sb4.append(list);
        InstrumentInjector.log_i("WebAuthn", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("timeout ");
        sb5.append(this.timeout);
        InstrumentInjector.log_i("WebAuthn", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("excludeCredentials ");
        sb6.append(this.excludeCredentials);
        InstrumentInjector.log_i("WebAuthn", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("authenticatorSelection ");
        sb7.append(this.authenticatorSelection);
        InstrumentInjector.log_i("WebAuthn", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("attestation ");
        sb8.append(this.attestation);
        InstrumentInjector.log_i("WebAuthn", sb8.toString());
    }

    @JvmName(name = "getJson")
    public final JSONObject getJson() {
        return this.json;
    }

    @JvmName(name = "getRp")
    public final PublicKeyCredentialRpEntity getRp() {
        return this.rp;
    }

    @JvmName(name = "getUser")
    public final PublicKeyCredentialUserEntity getUser() {
        return this.user;
    }

    @JvmName(name = "getChallenge")
    public final byte[] getChallenge() {
        return this.challenge;
    }

    @JvmName(name = "getPubKeyCredParams")
    public final List<PublicKeyCredentialParameters> getPubKeyCredParams() {
        return this.pubKeyCredParams;
    }

    @JvmName(name = "getTimeout")
    public final long getTimeout() {
        return this.timeout;
    }

    @JvmName(name = "setTimeout")
    public final void setTimeout(long j) {
        this.timeout = j;
    }

    @JvmName(name = "getExcludeCredentials")
    public final List<PublicKeyCredentialDescriptor> getExcludeCredentials() {
        return this.excludeCredentials;
    }

    @JvmName(name = "setExcludeCredentials")
    public final void setExcludeCredentials(List<PublicKeyCredentialDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.excludeCredentials = list;
    }

    @JvmName(name = "getAuthenticatorSelection")
    public final AuthenticatorSelectionCriteria getAuthenticatorSelection() {
        return this.authenticatorSelection;
    }

    @JvmName(name = "setAuthenticatorSelection")
    public final void setAuthenticatorSelection(AuthenticatorSelectionCriteria authenticatorSelectionCriteria) {
        Intrinsics.checkNotNullParameter(authenticatorSelectionCriteria, "");
        this.authenticatorSelection = authenticatorSelectionCriteria;
    }

    @JvmName(name = "getAttestation")
    public final String getAttestation() {
        return this.attestation;
    }

    @JvmName(name = "setAttestation")
    public final void setAttestation(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.attestation = str;
    }
}
