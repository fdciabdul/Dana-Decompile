package androidx.credentials;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.credentials.CredentialManager;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import java.util.concurrent.Executor;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public class DanaCredentialManager implements CredentialManager {
    private static final String INTENT_ACTION_FOR_CREDENTIAL_PROVIDER_SETTINGS = "android.settings.CREDENTIAL_PROVIDER";
    private final Context context;

    @Override // androidx.credentials.CredentialManager
    public /* synthetic */ Object clearCredentialState(ClearCredentialStateRequest clearCredentialStateRequest, Continuation continuation) {
        Object clearCredentialState$suspendImpl;
        clearCredentialState$suspendImpl = CredentialManager.CC.clearCredentialState$suspendImpl(this, clearCredentialStateRequest, continuation);
        return clearCredentialState$suspendImpl;
    }

    @Override // androidx.credentials.CredentialManager
    public /* synthetic */ Object createCredential(Context context, CreateCredentialRequest createCredentialRequest, Continuation continuation) {
        Object createCredential$suspendImpl;
        createCredential$suspendImpl = CredentialManager.CC.createCredential$suspendImpl(this, context, createCredentialRequest, continuation);
        return createCredential$suspendImpl;
    }

    @Override // androidx.credentials.CredentialManager
    public /* synthetic */ Object getCredential(Context context, GetCredentialRequest getCredentialRequest, Continuation continuation) {
        Object credential$suspendImpl;
        credential$suspendImpl = CredentialManager.CC.getCredential$suspendImpl(this, context, getCredentialRequest, continuation);
        return credential$suspendImpl;
    }

    @Override // androidx.credentials.CredentialManager
    public /* synthetic */ Object getCredential(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, Continuation continuation) {
        Object credential$suspendImpl;
        credential$suspendImpl = CredentialManager.CC.getCredential$suspendImpl(this, context, pendingGetCredentialHandle, continuation);
        return credential$suspendImpl;
    }

    @Override // androidx.credentials.CredentialManager
    public /* synthetic */ Object prepareGetCredential(GetCredentialRequest getCredentialRequest, Continuation continuation) {
        Object prepareGetCredential$suspendImpl;
        prepareGetCredential$suspendImpl = CredentialManager.CC.prepareGetCredential$suspendImpl(this, getCredentialRequest, continuation);
        return prepareGetCredential$suspendImpl;
    }

    public DanaCredentialManager(Context context) {
        this.context = context;
    }

    @Override // androidx.credentials.CredentialManager
    public void getCredentialAsync(Context context, GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        getProvider(context).onGetCredential(context, getCredentialRequest, cancellationSignal, executor, credentialManagerCallback);
    }

    private CredentialProvider getProvider(Context context) {
        CredentialProvider bestAvailableProvider = CredentialProviderFactory.INSTANCE.getBestAvailableProvider(context);
        return bestAvailableProvider != null ? bestAvailableProvider : DanaCredentialProviderFactory.getBestAvailableProvider(context);
    }

    @Override // androidx.credentials.CredentialManager
    public void getCredentialAsync(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        getProvider(context).onGetCredential(context, pendingGetCredentialHandle, cancellationSignal, executor, credentialManagerCallback);
    }

    @Override // androidx.credentials.CredentialManager
    public void prepareGetCredentialAsync(GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        getProvider(this.context).onPrepareCredential(getCredentialRequest, cancellationSignal, executor, credentialManagerCallback);
    }

    @Override // androidx.credentials.CredentialManager
    public void createCredentialAsync(Context context, CreateCredentialRequest createCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback) {
        getProvider(context).onCreateCredential(context, createCredentialRequest, cancellationSignal, executor, credentialManagerCallback);
    }

    @Override // androidx.credentials.CredentialManager
    public void clearCredentialStateAsync(ClearCredentialStateRequest clearCredentialStateRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback) {
        getProvider(this.context).onClearCredential(clearCredentialStateRequest, cancellationSignal, executor, credentialManagerCallback);
    }

    @Override // androidx.credentials.CredentialManager
    public PendingIntent createSettingsPendingIntent() {
        Intent intent = new Intent(INTENT_ACTION_FOR_CREDENTIAL_PROVIDER_SETTINGS);
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(this.context.getPackageName());
        intent.setData(Uri.parse(sb.toString()));
        return PendingIntent.getActivity(this.context, 0, intent, 67108864);
    }
}
