package androidx.credentials;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.credentials.CredentialManager;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialProviderConfigurationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialProviderConfigurationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialProviderConfigurationException;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b%\u0010&J?\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJE\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JE\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJE\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\bH\u0016¢\u0006\u0004\b\u001c\u0010 J=\u0010\"\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001b0\bH\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010$"}, d2 = {"Landroidx/credentials/CredentialManagerImpl;", "Landroidx/credentials/CredentialManager;", "Landroidx/credentials/ClearCredentialStateRequest;", "request", "Landroid/os/CancellationSignal;", "cancellationSignal", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/credentials/CredentialManagerCallback;", "Ljava/lang/Void;", "Landroidx/credentials/exceptions/ClearCredentialException;", "callback", "", "clearCredentialStateAsync", "(Landroidx/credentials/ClearCredentialStateRequest;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroidx/credentials/CreateCredentialRequest;", "Landroidx/credentials/CreateCredentialResponse;", "Landroidx/credentials/exceptions/CreateCredentialException;", "createCredentialAsync", "(Landroid/content/Context;Landroidx/credentials/CreateCredentialRequest;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "Landroid/app/PendingIntent;", "createSettingsPendingIntent", "()Landroid/app/PendingIntent;", "Landroidx/credentials/GetCredentialRequest;", "Landroidx/credentials/GetCredentialResponse;", "Landroidx/credentials/exceptions/GetCredentialException;", "getCredentialAsync", "(Landroid/content/Context;Landroidx/credentials/GetCredentialRequest;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "pendingGetCredentialHandle", "(Landroid/content/Context;Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "Landroidx/credentials/PrepareGetCredentialResponse;", "prepareGetCredentialAsync", "(Landroidx/credentials/GetCredentialRequest;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CredentialManagerImpl implements CredentialManager {
    private static final String INTENT_ACTION_FOR_CREDENTIAL_PROVIDER_SETTINGS = "android.settings.CREDENTIAL_PROVIDER";
    private final Context context;

    @Override // androidx.credentials.CredentialManager
    public final /* synthetic */ Object clearCredentialState(ClearCredentialStateRequest clearCredentialStateRequest, Continuation continuation) {
        Object clearCredentialState$suspendImpl;
        clearCredentialState$suspendImpl = CredentialManager.CC.clearCredentialState$suspendImpl(this, clearCredentialStateRequest, continuation);
        return clearCredentialState$suspendImpl;
    }

    @Override // androidx.credentials.CredentialManager
    public final /* synthetic */ Object createCredential(Context context, CreateCredentialRequest createCredentialRequest, Continuation continuation) {
        Object createCredential$suspendImpl;
        createCredential$suspendImpl = CredentialManager.CC.createCredential$suspendImpl(this, context, createCredentialRequest, continuation);
        return createCredential$suspendImpl;
    }

    @Override // androidx.credentials.CredentialManager
    public final /* synthetic */ Object getCredential(Context context, GetCredentialRequest getCredentialRequest, Continuation continuation) {
        Object credential$suspendImpl;
        credential$suspendImpl = CredentialManager.CC.getCredential$suspendImpl(this, context, getCredentialRequest, continuation);
        return credential$suspendImpl;
    }

    @Override // androidx.credentials.CredentialManager
    public final /* synthetic */ Object getCredential(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, Continuation continuation) {
        Object credential$suspendImpl;
        credential$suspendImpl = CredentialManager.CC.getCredential$suspendImpl(this, context, pendingGetCredentialHandle, continuation);
        return credential$suspendImpl;
    }

    @Override // androidx.credentials.CredentialManager
    public final /* synthetic */ Object prepareGetCredential(GetCredentialRequest getCredentialRequest, Continuation continuation) {
        Object prepareGetCredential$suspendImpl;
        prepareGetCredential$suspendImpl = CredentialManager.CC.prepareGetCredential$suspendImpl(this, getCredentialRequest, continuation);
        return prepareGetCredential$suspendImpl;
    }

    public CredentialManagerImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    @Override // androidx.credentials.CredentialManager
    public final void getCredentialAsync(Context context, GetCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> callback) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        CredentialProvider bestAvailableProvider = CredentialProviderFactory.INSTANCE.getBestAvailableProvider(this.context);
        if (bestAvailableProvider == null) {
            callback.onError(new GetCredentialProviderConfigurationException("getCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            bestAvailableProvider.onGetCredential(context, request, cancellationSignal, executor, callback);
        }
    }

    @Override // androidx.credentials.CredentialManager
    public final void getCredentialAsync(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> callback) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(pendingGetCredentialHandle, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        CredentialProviderFactory.INSTANCE.getUAndAboveProvider(context).onGetCredential(context, pendingGetCredentialHandle, cancellationSignal, executor, callback);
    }

    @Override // androidx.credentials.CredentialManager
    public final void prepareGetCredentialAsync(GetCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> callback) {
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        CredentialProviderFactory.INSTANCE.getUAndAboveProvider(this.context).onPrepareCredential(request, cancellationSignal, executor, callback);
    }

    @Override // androidx.credentials.CredentialManager
    public final void createCredentialAsync(Context context, CreateCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> callback) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        CredentialProvider bestAvailableProvider = CredentialProviderFactory.INSTANCE.getBestAvailableProvider(this.context);
        if (bestAvailableProvider == null) {
            callback.onError(new CreateCredentialProviderConfigurationException("createCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            bestAvailableProvider.onCreateCredential(context, request, cancellationSignal, executor, callback);
        }
    }

    @Override // androidx.credentials.CredentialManager
    public final void clearCredentialStateAsync(ClearCredentialStateRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> callback) {
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        CredentialProvider bestAvailableProvider = CredentialProviderFactory.INSTANCE.getBestAvailableProvider(this.context);
        if (bestAvailableProvider == null) {
            callback.onError(new ClearCredentialProviderConfigurationException("clearCredentialStateAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            bestAvailableProvider.onClearCredential(request, cancellationSignal, executor, callback);
        }
    }

    @Override // androidx.credentials.CredentialManager
    public final PendingIntent createSettingsPendingIntent() {
        Intent intent = new Intent(INTENT_ACTION_FOR_CREDENTIAL_PROVIDER_SETTINGS);
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(this.context.getPackageName());
        intent.setData(Uri.parse(sb.toString()));
        PendingIntent activity = PendingIntent.getActivity(this.context, 0, intent, 67108864);
        Intrinsics.checkNotNullExpressionValue(activity, "");
        return activity;
    }
}
