package id.dana.passkey.model;

import com.google.gson.JsonObject;
import id.dana.passkey.model.CreatePasskeyRequest;
import java.util.Collections;
import java.util.List;

@Deprecated
/* loaded from: classes9.dex */
public class CreatePasskeyRequestBuilder {
    private JsonObject extensions;
    private List<CreatePasskeyRequest.PubKeyCredParams> pubKeyCredParams;
    private CreatePasskeyRequest.Rp rp;
    private CreatePasskeyRequest.User user;
    private long timeoutInMs = 1800000;
    private List<Object> excludeCredentials = Collections.emptyList();
    private String attestation = "none";
    private CreatePasskeyRequest.AuthenticatorSelection authenticatorSelection = CreatePasskeyRequest.AuthenticatorSelection.defaultInstance();

    public CreatePasskeyRequestBuilder withRp(CreatePasskeyRequest.Rp rp) {
        this.rp = rp;
        return this;
    }

    public CreatePasskeyRequestBuilder withUser(CreatePasskeyRequest.User user) {
        this.user = user;
        return this;
    }

    public CreatePasskeyRequestBuilder withPubKeyCredParams(List<CreatePasskeyRequest.PubKeyCredParams> list) {
        this.pubKeyCredParams = list;
        return this;
    }

    public CreatePasskeyRequestBuilder withTimeout(long j) {
        this.timeoutInMs = j;
        return this;
    }

    public CreatePasskeyRequestBuilder withExcludeCredentials(List<Object> list) {
        this.excludeCredentials = list;
        return this;
    }

    public CreatePasskeyRequestBuilder withAttestation(String str) {
        this.attestation = str;
        return this;
    }

    public CreatePasskeyRequestBuilder withAuthenticatorSelection(CreatePasskeyRequest.AuthenticatorSelection authenticatorSelection) {
        this.authenticatorSelection = authenticatorSelection;
        return this;
    }

    public CreatePasskeyRequestBuilder withExtension(JsonObject jsonObject) {
        this.extensions = jsonObject;
        return this;
    }

    public CreatePasskeyRequest build() {
        return new CreatePasskeyRequest(this.rp, this.user, this.pubKeyCredParams, this.timeoutInMs, this.attestation, this.excludeCredentials, this.authenticatorSelection, this.extensions);
    }
}
