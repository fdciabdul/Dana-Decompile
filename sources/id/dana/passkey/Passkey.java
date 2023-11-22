package id.dana.passkey;

import android.app.Activity;
import android.content.Context;
import android.os.CancellationSignal;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.CreatePublicKeyCredentialResponse;
import androidx.credentials.CredentialManager;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.DanaCredentialManager;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.GetPublicKeyCredentialOption;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException;
import id.dana.passkey.challenge.ChallengeGenerator;
import id.dana.passkey.challenge.FidoChallengerGenerator;
import id.dana.passkey.exception.PasskeyException;
import id.dana.passkey.exception.ServerConfigInvalidException;
import id.dana.passkey.exception.UserCancellationException;
import id.dana.passkey.json.GsonAdapter;
import id.dana.passkey.json.JsonAdapter;
import id.dana.passkey.model.CreatePasskeyResponse;
import id.dana.passkey.model.GetPasskeyRequest;
import id.dana.passkey.model.GetPasskeyResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class Passkey {
    public static final String REQUIRED = "required";
    private final ChallengeGenerator challengeGenerator;
    private final CredentialManager credentialManager;
    private final String domain;
    private final JsonAdapter jsonAdapter;

    private Passkey(Context context, String str, JsonAdapter jsonAdapter, ChallengeGenerator challengeGenerator) {
        this.domain = str;
        this.jsonAdapter = jsonAdapter;
        this.challengeGenerator = challengeGenerator;
        this.credentialManager = new DanaCredentialManager(context);
    }

    public void register(String str, Activity activity, Executor executor, final CreatePasskeyCallback createPasskeyCallback) {
        this.credentialManager.createCredentialAsync(activity, new CreatePublicKeyCredentialRequest(str), null, executor, new CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException>() { // from class: id.dana.passkey.Passkey.1
            {
                Passkey.this = this;
            }

            @Override // androidx.credentials.CredentialManagerCallback
            public void onResult(CreateCredentialResponse createCredentialResponse) {
                createPasskeyCallback.onResult((CreatePasskeyResponse) Passkey.this.jsonAdapter.fromJson(((CreatePublicKeyCredentialResponse) createCredentialResponse).getRegistrationResponseJson(), CreatePasskeyResponse.class));
            }

            @Override // androidx.credentials.CredentialManagerCallback
            public void onError(CreateCredentialException createCredentialException) {
                PasskeyException passkeyException;
                if (createCredentialException instanceof CreatePublicKeyCredentialDomException) {
                    if (createCredentialException.getMessage() != null && createCredentialException.getMessage().contains("Unable to get sync account")) {
                        passkeyException = new UserCancellationException(createCredentialException);
                    } else {
                        passkeyException = new ServerConfigInvalidException(createCredentialException);
                    }
                } else {
                    passkeyException = new PasskeyException(createCredentialException.getMessage(), createCredentialException);
                }
                createPasskeyCallback.onError(passkeyException);
            }
        });
    }

    public void login(String str, Activity activity, Executor executor, final GetPasskeyCallback getPasskeyCallback) {
        this.credentialManager.getCredentialAsync(activity, new GetCredentialRequest(Collections.singletonList(new GetPublicKeyCredentialOption(str))), (CancellationSignal) null, executor, new CredentialManagerCallback<GetCredentialResponse, GetCredentialException>() { // from class: id.dana.passkey.Passkey.2
            {
                Passkey.this = this;
            }

            @Override // androidx.credentials.CredentialManagerCallback
            public void onResult(GetCredentialResponse getCredentialResponse) {
                getPasskeyCallback.onResult((GetPasskeyResponse) Passkey.this.jsonAdapter.fromJson(((PublicKeyCredential) getCredentialResponse.getCredential()).getAuthenticationResponseJson(), GetPasskeyResponse.class));
            }

            @Override // androidx.credentials.CredentialManagerCallback
            public void onError(GetCredentialException getCredentialException) {
                PasskeyException passkeyException;
                if (getCredentialException instanceof GetCredentialCancellationException) {
                    passkeyException = new UserCancellationException(getCredentialException);
                } else {
                    passkeyException = new PasskeyException(getCredentialException.getMessage(), getCredentialException);
                }
                getPasskeyCallback.onError(passkeyException);
            }
        });
    }

    private List<GetPasskeyRequest.AllowCredentials> mapToAllowCredentials(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GetPasskeyRequest.AllowCredentials(it.next(), Collections.emptyList(), "public-key"));
        }
        return arrayList;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private ChallengeGenerator challengeGenerator;
        private final Context context;
        private String domain;
        private JsonAdapter jsonAdapter;

        private Builder(Context context) {
            this.context = context;
        }

        public Builder withDomain(String str) {
            this.domain = str;
            return this;
        }

        public Builder withJsonAdapter(JsonAdapter jsonAdapter) {
            this.jsonAdapter = jsonAdapter;
            return this;
        }

        public Builder withChallengeGenerator(ChallengeGenerator challengeGenerator) {
            this.challengeGenerator = challengeGenerator;
            return this;
        }

        public Passkey build() {
            JsonAdapter jsonAdapter = this.jsonAdapter;
            if (jsonAdapter == null) {
                jsonAdapter = new GsonAdapter();
            }
            JsonAdapter jsonAdapter2 = jsonAdapter;
            ChallengeGenerator challengeGenerator = this.challengeGenerator;
            if (challengeGenerator == null) {
                challengeGenerator = new FidoChallengerGenerator();
            }
            return new Passkey(this.context, this.domain, jsonAdapter2, challengeGenerator);
        }
    }
}
