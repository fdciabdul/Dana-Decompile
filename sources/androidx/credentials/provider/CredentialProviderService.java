package androidx.credentials.provider;

import android.content.Context;
import android.content.res.Resources;
import android.credentials.ClearCredentialStateException;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import android.service.credentials.ClearCredentialStateRequest;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import androidx.credentials.provider.utils.ClearCredentialUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b>\u0010?J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0006¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0006H&¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u0006¢\u0006\u0004\b\u001f\u0010 J5\u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\"0\u0006H&¢\u0006\u0004\b#\u0010$R*\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%8G@GX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R.\u0010,\u001a\u0004\u0018\u00010!2\b\u0010&\u001a\u0004\u0018\u00010!8G@GX\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R.\u00102\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r8G@GX\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R.\u00108\u001a\u0004\u0018\u00010\u00172\b\u0010&\u001a\u0004\u0018\u00010\u00178G@GX\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010="}, d2 = {"Landroidx/credentials/provider/CredentialProviderService;", "Landroid/service/credentials/CredentialProviderService;", "Landroid/service/credentials/BeginCreateCredentialRequest;", "request", "Landroid/os/CancellationSignal;", "cancellationSignal", "Landroid/os/OutcomeReceiver;", "Landroid/service/credentials/BeginCreateCredentialResponse;", "Landroid/credentials/CreateCredentialException;", "callback", "", "onBeginCreateCredential", "(Landroid/service/credentials/BeginCreateCredentialRequest;Landroid/os/CancellationSignal;Landroid/os/OutcomeReceiver;)V", "Landroidx/credentials/provider/BeginCreateCredentialRequest;", "Landroidx/credentials/provider/BeginCreateCredentialResponse;", "Landroidx/credentials/exceptions/CreateCredentialException;", "onBeginCreateCredentialRequest", "(Landroidx/credentials/provider/BeginCreateCredentialRequest;Landroid/os/CancellationSignal;Landroid/os/OutcomeReceiver;)V", "Landroid/service/credentials/BeginGetCredentialRequest;", "Landroid/service/credentials/BeginGetCredentialResponse;", "Landroid/credentials/GetCredentialException;", "onBeginGetCredential", "(Landroid/service/credentials/BeginGetCredentialRequest;Landroid/os/CancellationSignal;Landroid/os/OutcomeReceiver;)V", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "Landroidx/credentials/exceptions/GetCredentialException;", "onBeginGetCredentialRequest", "(Landroidx/credentials/provider/BeginGetCredentialRequest;Landroid/os/CancellationSignal;Landroid/os/OutcomeReceiver;)V", "Landroid/service/credentials/ClearCredentialStateRequest;", "Ljava/lang/Void;", "Landroid/credentials/ClearCredentialStateException;", "onClearCredentialState", "(Landroid/service/credentials/ClearCredentialStateRequest;Landroid/os/CancellationSignal;Landroid/os/OutcomeReceiver;)V", "Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "Landroidx/credentials/exceptions/ClearCredentialException;", "onClearCredentialStateRequest", "(Landroidx/credentials/provider/ProviderClearCredentialStateRequest;Landroid/os/CancellationSignal;Landroid/os/OutcomeReceiver;)V", "", "<set-?>", "isTestMode", "Z", "()Z", "setTestMode", "(Z)V", "lastClearRequest", "Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "getLastClearRequest", "()Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "setLastClearRequest", "(Landroidx/credentials/provider/ProviderClearCredentialStateRequest;)V", "lastCreateRequest", "Landroidx/credentials/provider/BeginCreateCredentialRequest;", "getLastCreateRequest", "()Landroidx/credentials/provider/BeginCreateCredentialRequest;", "setLastCreateRequest", "(Landroidx/credentials/provider/BeginCreateCredentialRequest;)V", "lastGetRequest", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "getLastGetRequest", "()Landroidx/credentials/provider/BeginGetCredentialRequest;", "setLastGetRequest", "(Landroidx/credentials/provider/BeginGetCredentialRequest;)V", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class CredentialProviderService extends android.service.credentials.CredentialProviderService {
    private boolean isTestMode;
    private ProviderClearCredentialStateRequest lastClearRequest;
    private BeginCreateCredentialRequest lastCreateRequest;
    private BeginGetCredentialRequest lastGetRequest;

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    public abstract void onBeginCreateCredentialRequest(BeginCreateCredentialRequest request, CancellationSignal cancellationSignal, OutcomeReceiver<BeginCreateCredentialResponse, CreateCredentialException> callback);

    public abstract void onBeginGetCredentialRequest(BeginGetCredentialRequest request, CancellationSignal cancellationSignal, OutcomeReceiver<BeginGetCredentialResponse, GetCredentialException> callback);

    public abstract void onClearCredentialStateRequest(ProviderClearCredentialStateRequest request, CancellationSignal cancellationSignal, OutcomeReceiver<Void, ClearCredentialException> callback);

    @JvmName(name = "isTestMode")
    /* renamed from: isTestMode  reason: from getter */
    public final boolean getIsTestMode() {
        return this.isTestMode;
    }

    @JvmName(name = "setTestMode")
    public final void setTestMode(boolean z) {
        this.isTestMode = z;
    }

    @JvmName(name = "getLastCreateRequest")
    public final BeginCreateCredentialRequest getLastCreateRequest() {
        return this.lastCreateRequest;
    }

    @JvmName(name = "setLastCreateRequest")
    public final void setLastCreateRequest(BeginCreateCredentialRequest beginCreateCredentialRequest) {
        this.lastCreateRequest = beginCreateCredentialRequest;
    }

    @JvmName(name = "getLastGetRequest")
    public final BeginGetCredentialRequest getLastGetRequest() {
        return this.lastGetRequest;
    }

    @JvmName(name = "setLastGetRequest")
    public final void setLastGetRequest(BeginGetCredentialRequest beginGetCredentialRequest) {
        this.lastGetRequest = beginGetCredentialRequest;
    }

    @JvmName(name = "getLastClearRequest")
    public final ProviderClearCredentialStateRequest getLastClearRequest() {
        return this.lastClearRequest;
    }

    @JvmName(name = "setLastClearRequest")
    public final void setLastClearRequest(ProviderClearCredentialStateRequest providerClearCredentialStateRequest) {
        this.lastClearRequest = providerClearCredentialStateRequest;
    }

    @Override // android.service.credentials.CredentialProviderService
    public final void onBeginGetCredential(android.service.credentials.BeginGetCredentialRequest request, CancellationSignal cancellationSignal, final OutcomeReceiver<android.service.credentials.BeginGetCredentialResponse, android.credentials.GetCredentialException> callback) {
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(cancellationSignal, "");
        Intrinsics.checkNotNullParameter(callback, "");
        BeginGetCredentialRequest convertToJetpackRequest$credentials_release = BeginGetCredentialUtil.INSTANCE.convertToJetpackRequest$credentials_release(request);
        OutcomeReceiver<BeginGetCredentialResponse, GetCredentialException> outcomeReceiver = new OutcomeReceiver<BeginGetCredentialResponse, GetCredentialException>() { // from class: androidx.credentials.provider.CredentialProviderService$onBeginGetCredential$outcome$1
            @Override // android.os.OutcomeReceiver
            public final void onResult(BeginGetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "");
                callback.onResult(BeginGetCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
            }

            @Override // android.os.OutcomeReceiver
            public final void onError(GetCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "");
                callback.onError(new android.credentials.GetCredentialException(error.getType(), error.getMessage()));
            }
        };
        if (this.isTestMode) {
            this.lastGetRequest = convertToJetpackRequest$credentials_release;
        }
        onBeginGetCredentialRequest(convertToJetpackRequest$credentials_release, cancellationSignal, outcomeReceiver);
    }

    @Override // android.service.credentials.CredentialProviderService
    public final void onBeginCreateCredential(android.service.credentials.BeginCreateCredentialRequest request, CancellationSignal cancellationSignal, final OutcomeReceiver<android.service.credentials.BeginCreateCredentialResponse, android.credentials.CreateCredentialException> callback) {
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(cancellationSignal, "");
        Intrinsics.checkNotNullParameter(callback, "");
        OutcomeReceiver<BeginCreateCredentialResponse, CreateCredentialException> outcomeReceiver = new OutcomeReceiver<BeginCreateCredentialResponse, CreateCredentialException>() { // from class: androidx.credentials.provider.CredentialProviderService$onBeginCreateCredential$outcome$1
            @Override // android.os.OutcomeReceiver
            public final void onResult(BeginCreateCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "");
                callback.onResult(BeginCreateCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
            }

            @Override // android.os.OutcomeReceiver
            public final void onError(CreateCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "");
                callback.onError(new android.credentials.CreateCredentialException(error.getType(), error.getMessage()));
            }
        };
        BeginCreateCredentialRequest convertToJetpackRequest$credentials_release = BeginCreateCredentialUtil.INSTANCE.convertToJetpackRequest$credentials_release(request);
        if (this.isTestMode) {
            this.lastCreateRequest = convertToJetpackRequest$credentials_release;
        }
        onBeginCreateCredentialRequest(convertToJetpackRequest$credentials_release, cancellationSignal, outcomeReceiver);
    }

    @Override // android.service.credentials.CredentialProviderService
    public final void onClearCredentialState(ClearCredentialStateRequest request, CancellationSignal cancellationSignal, final OutcomeReceiver<Void, ClearCredentialStateException> callback) {
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(cancellationSignal, "");
        Intrinsics.checkNotNullParameter(callback, "");
        OutcomeReceiver<Void, ClearCredentialException> outcomeReceiver = new OutcomeReceiver<Void, ClearCredentialException>() { // from class: androidx.credentials.provider.CredentialProviderService$onClearCredentialState$outcome$1
            @Override // android.os.OutcomeReceiver
            public final void onResult(Void response) {
                callback.onResult(response);
            }

            @Override // android.os.OutcomeReceiver
            public final void onError(ClearCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "");
                callback.onError(new ClearCredentialStateException(error.getType(), error.getMessage()));
            }
        };
        ProviderClearCredentialStateRequest convertToJetpackRequest$credentials_release = ClearCredentialUtil.INSTANCE.convertToJetpackRequest$credentials_release(request);
        if (this.isTestMode) {
            this.lastClearRequest = convertToJetpackRequest$credentials_release;
        }
        onClearCredentialStateRequest(convertToJetpackRequest$credentials_release, cancellationSignal, outcomeReceiver);
    }
}
