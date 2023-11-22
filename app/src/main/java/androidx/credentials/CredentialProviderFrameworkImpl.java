package androidx.credentials;

import android.content.Context;
import android.credentials.ClearCredentialStateException;
import android.credentials.CreateCredentialRequest;
import android.credentials.CredentialOption;
import android.credentials.GetCredentialRequest;
import android.credentials.PrepareGetCredentialResponse;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.Credential;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialUnknownException;
import androidx.credentials.exceptions.ClearCredentialUnsupportedException;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialCustomException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialInterruptedException;
import androidx.credentials.exceptions.CreateCredentialNoCreateOptionException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.CreateCredentialUnsupportedException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialCustomException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialUnsupportedException;
import androidx.credentials.exceptions.NoCredentialException;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialException;
import androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialException;
import androidx.credentials.internal.FrameworkImplHelper;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 K2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bI\u0010JJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010(\u001a\u00020\"2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002¢\u0006\u0004\b(\u0010)J?\u00103\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020-2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000100\u0012\u0004\u0012\u0002010/H\u0016¢\u0006\u0004\b3\u00104JE\u00106\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020-2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00180/H\u0016¢\u0006\u0004\b6\u00107JE\u00108\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020-2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001c0/H\u0016¢\u0006\u0004\b8\u00109JE\u00108\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020-2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001c0/H\u0016¢\u0006\u0004\b8\u0010<J=\u0010=\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020-2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001c0/H\u0016¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bA\u0010BJ\u001f\u0010D\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010@\u001a\u00020CH\u0002¢\u0006\u0004\bD\u0010ER\u0016\u0010G\u001a\u0004\u0018\u00010F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H"}, d2 = {"Landroidx/credentials/CredentialProviderFrameworkImpl;", "Landroidx/credentials/CredentialProvider;", "Landroidx/credentials/CreateCredentialRequest;", "request", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/credentials/CreateCredentialRequest;", "convertCreateRequestToFrameworkClass", "(Landroidx/credentials/CreateCredentialRequest;Landroid/content/Context;)Landroid/credentials/CreateCredentialRequest;", "Landroidx/credentials/GetCredentialRequest;", "Landroid/credentials/GetCredentialRequest;", "convertGetRequestToFrameworkClass", "(Landroidx/credentials/GetCredentialRequest;)Landroid/credentials/GetCredentialRequest;", "Landroid/credentials/GetCredentialResponse;", "response", "Landroidx/credentials/GetCredentialResponse;", "convertGetResponseToJetpackClass$credentials_release", "(Landroid/credentials/GetCredentialResponse;)Landroidx/credentials/GetCredentialResponse;", "Landroid/credentials/PrepareGetCredentialResponse;", "Landroidx/credentials/PrepareGetCredentialResponse;", "convertPrepareGetResponseToJetpackClass$credentials_release", "(Landroid/credentials/PrepareGetCredentialResponse;)Landroidx/credentials/PrepareGetCredentialResponse;", "Landroid/credentials/CreateCredentialException;", "error", "Landroidx/credentials/exceptions/CreateCredentialException;", "convertToJetpackCreateException$credentials_release", "(Landroid/credentials/CreateCredentialException;)Landroidx/credentials/exceptions/CreateCredentialException;", "Landroid/credentials/GetCredentialException;", "Landroidx/credentials/exceptions/GetCredentialException;", "convertToJetpackGetException$credentials_release", "(Landroid/credentials/GetCredentialException;)Landroidx/credentials/exceptions/GetCredentialException;", "Landroid/credentials/ClearCredentialStateRequest;", "createFrameworkClearCredentialRequest", "()Landroid/credentials/ClearCredentialStateRequest;", "", "isAvailableOnDevice", "()Z", "Lkotlin/Function0;", "", "handleNullCredMan", "isCredmanDisabled", "(Lkotlin/jvm/functions/Function0;)Z", "Landroidx/credentials/ClearCredentialStateRequest;", "Landroid/os/CancellationSignal;", "cancellationSignal", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/credentials/CredentialManagerCallback;", "Ljava/lang/Void;", "Landroidx/credentials/exceptions/ClearCredentialException;", "callback", "onClearCredential", "(Landroidx/credentials/ClearCredentialStateRequest;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "Landroidx/credentials/CreateCredentialResponse;", "onCreateCredential", "(Landroid/content/Context;Landroidx/credentials/CreateCredentialRequest;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "onGetCredential", "(Landroid/content/Context;Landroidx/credentials/GetCredentialRequest;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "pendingGetCredentialHandle", "(Landroid/content/Context;Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "onPrepareCredential", "(Landroidx/credentials/GetCredentialRequest;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;)V", "Landroid/credentials/CreateCredentialRequest$Builder;", "builder", "setOriginForCreateRequest", "(Landroidx/credentials/CreateCredentialRequest;Landroid/credentials/CreateCredentialRequest$Builder;)V", "Landroid/credentials/GetCredentialRequest$Builder;", "setOriginForGetRequest", "(Landroidx/credentials/GetCredentialRequest;Landroid/credentials/GetCredentialRequest$Builder;)V", "Landroid/credentials/CredentialManager;", "credentialManager", "Landroid/credentials/CredentialManager;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CredentialProviderFrameworkImpl implements CredentialProvider {
    private static final String CREATE_DOM_EXCEPTION_PREFIX = "androidx.credentials.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION";
    private static final Companion Companion = new Companion(null);
    private static final String GET_DOM_EXCEPTION_PREFIX = "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION";
    private static final String TAG = "CredManProvService";
    private final android.credentials.CredentialManager credentialManager;

    public CredentialProviderFrameworkImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.credentialManager = (android.credentials.CredentialManager) context.getSystemService("credential");
    }

    @Override // androidx.credentials.CredentialProvider
    public final void onPrepareCredential(GetCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, final CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> callback) {
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        if (isCredmanDisabled(new Function0<Unit>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onPrepareCredential$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                callback.onError(new GetCredentialUnsupportedException("Your device doesn't support credential manager"));
            }
        })) {
            return;
        }
        OutcomeReceiver<android.credentials.PrepareGetCredentialResponse, android.credentials.GetCredentialException> outcomeReceiver = new OutcomeReceiver<android.credentials.PrepareGetCredentialResponse, android.credentials.GetCredentialException>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onPrepareCredential$outcome$1
            @Override // android.os.OutcomeReceiver
            public final void onResult(android.credentials.PrepareGetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "");
                callback.onResult(this.convertPrepareGetResponseToJetpackClass$credentials_release(response));
            }

            @Override // android.os.OutcomeReceiver
            public final void onError(android.credentials.GetCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "");
                callback.onError(this.convertToJetpackGetException$credentials_release(error));
            }
        };
        android.credentials.CredentialManager credentialManager = this.credentialManager;
        Intrinsics.checkNotNull(credentialManager);
        credentialManager.prepareGetCredential(convertGetRequestToFrameworkClass(request), cancellationSignal, executor, outcomeReceiver);
    }

    @Override // androidx.credentials.CredentialProvider
    public final void onGetCredential(Context r8, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, final CredentialManagerCallback<GetCredentialResponse, GetCredentialException> callback) {
        Intrinsics.checkNotNullParameter(r8, "");
        Intrinsics.checkNotNullParameter(pendingGetCredentialHandle, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        if (isCredmanDisabled(new Function0<Unit>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onGetCredential$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                callback.onError(new GetCredentialUnsupportedException("Your device doesn't support credential manager"));
            }
        })) {
            return;
        }
        OutcomeReceiver<android.credentials.GetCredentialResponse, android.credentials.GetCredentialException> outcomeReceiver = new OutcomeReceiver<android.credentials.GetCredentialResponse, android.credentials.GetCredentialException>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onGetCredential$outcome$1
            @Override // android.os.OutcomeReceiver
            public final void onResult(android.credentials.GetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "");
                callback.onResult(this.convertGetResponseToJetpackClass$credentials_release(response));
            }

            @Override // android.os.OutcomeReceiver
            public final void onError(android.credentials.GetCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "");
                callback.onError(this.convertToJetpackGetException$credentials_release(error));
            }
        };
        android.credentials.CredentialManager credentialManager = this.credentialManager;
        Intrinsics.checkNotNull(credentialManager);
        PrepareGetCredentialResponse.PendingGetCredentialHandle frameworkHandle = pendingGetCredentialHandle.getFrameworkHandle();
        Intrinsics.checkNotNull(frameworkHandle);
        credentialManager.getCredential(r8, frameworkHandle, cancellationSignal, executor, outcomeReceiver);
    }

    @Override // androidx.credentials.CredentialProvider
    public final void onGetCredential(Context r8, GetCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, final CredentialManagerCallback<GetCredentialResponse, GetCredentialException> callback) {
        Intrinsics.checkNotNullParameter(r8, "");
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        if (isCredmanDisabled(new Function0<Unit>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onGetCredential$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                callback.onError(new GetCredentialUnsupportedException("Your device doesn't support credential manager"));
            }
        })) {
            return;
        }
        OutcomeReceiver<android.credentials.GetCredentialResponse, android.credentials.GetCredentialException> outcomeReceiver = new OutcomeReceiver<android.credentials.GetCredentialResponse, android.credentials.GetCredentialException>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onGetCredential$outcome$2
            @Override // android.os.OutcomeReceiver
            public final void onResult(android.credentials.GetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "");
                InstrumentInjector.log_i("CredManProvService", "GetCredentialResponse returned from framework");
                callback.onResult(this.convertGetResponseToJetpackClass$credentials_release(response));
            }

            @Override // android.os.OutcomeReceiver
            public final void onError(android.credentials.GetCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "");
                InstrumentInjector.log_i("CredManProvService", "GetCredentialResponse error returned from framework");
                callback.onError(this.convertToJetpackGetException$credentials_release(error));
            }
        };
        android.credentials.CredentialManager credentialManager = this.credentialManager;
        Intrinsics.checkNotNull(credentialManager);
        credentialManager.getCredential(r8, convertGetRequestToFrameworkClass(request), cancellationSignal, executor, outcomeReceiver);
    }

    private final boolean isCredmanDisabled(Function0<Unit> handleNullCredMan) {
        if (this.credentialManager == null) {
            handleNullCredMan.invoke();
            return true;
        }
        return false;
    }

    @Override // androidx.credentials.CredentialProvider
    public final void onCreateCredential(Context r8, final CreateCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, final CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> callback) {
        Intrinsics.checkNotNullParameter(r8, "");
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        if (isCredmanDisabled(new Function0<Unit>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onCreateCredential$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                callback.onError(new CreateCredentialUnsupportedException("Your device doesn't support credential manager"));
            }
        })) {
            return;
        }
        OutcomeReceiver<android.credentials.CreateCredentialResponse, android.credentials.CreateCredentialException> outcomeReceiver = new OutcomeReceiver<android.credentials.CreateCredentialResponse, android.credentials.CreateCredentialException>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onCreateCredential$outcome$1
            @Override // android.os.OutcomeReceiver
            public final void onResult(android.credentials.CreateCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "");
                InstrumentInjector.log_i("CredManProvService", "Create Result returned from framework: ");
                CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback = callback;
                CreateCredentialResponse.Companion companion = CreateCredentialResponse.INSTANCE;
                String type = request.getType();
                Bundle data = response.getData();
                Intrinsics.checkNotNullExpressionValue(data, "");
                credentialManagerCallback.onResult(companion.createFrom(type, data));
            }

            @Override // android.os.OutcomeReceiver
            public final void onError(android.credentials.CreateCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "");
                InstrumentInjector.log_i("CredManProvService", "CreateCredentialResponse error returned from framework");
                callback.onError(this.convertToJetpackCreateException$credentials_release(error));
            }
        };
        android.credentials.CredentialManager credentialManager = this.credentialManager;
        Intrinsics.checkNotNull(credentialManager);
        credentialManager.createCredential(r8, convertCreateRequestToFrameworkClass(request, r8), cancellationSignal, executor, outcomeReceiver);
    }

    private final android.credentials.CreateCredentialRequest convertCreateRequestToFrameworkClass(CreateCredentialRequest request, Context r5) {
        CreateCredentialRequest.Builder alwaysSendAppInfoToProvider = new CreateCredentialRequest.Builder(request.getType(), FrameworkImplHelper.INSTANCE.getFinalCreateCredentialData(request, r5), request.getCandidateQueryData()).setIsSystemProviderRequired(request.getIsSystemProviderRequired()).setAlwaysSendAppInfoToProvider(true);
        Intrinsics.checkNotNullExpressionValue(alwaysSendAppInfoToProvider, "");
        setOriginForCreateRequest(request, alwaysSendAppInfoToProvider);
        android.credentials.CreateCredentialRequest build = alwaysSendAppInfoToProvider.build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        return build;
    }

    private final void setOriginForCreateRequest(CreateCredentialRequest request, CreateCredentialRequest.Builder builder) {
        if (request.getOrigin() != null) {
            builder.setOrigin(request.getOrigin());
        }
    }

    private final android.credentials.GetCredentialRequest convertGetRequestToFrameworkClass(GetCredentialRequest request) {
        GetCredentialRequest.Builder builder = new GetCredentialRequest.Builder(GetCredentialRequest.INSTANCE.toRequestDataBundle(request));
        for (CredentialOption credentialOption : request.getCredentialOptions()) {
            builder.addCredentialOption(new CredentialOption.Builder(credentialOption.getType(), credentialOption.getRequestData(), credentialOption.getCandidateQueryData()).setIsSystemProviderRequired(credentialOption.getIsSystemProviderRequired()).setAllowedProviders(credentialOption.getAllowedProviders()).build());
        }
        setOriginForGetRequest(request, builder);
        android.credentials.GetCredentialRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        return build;
    }

    private final void setOriginForGetRequest(GetCredentialRequest request, GetCredentialRequest.Builder builder) {
        if (request.getOrigin() != null) {
            builder.setOrigin(request.getOrigin());
        }
    }

    private final android.credentials.ClearCredentialStateRequest createFrameworkClearCredentialRequest() {
        return new android.credentials.ClearCredentialStateRequest(new Bundle());
    }

    public final GetCredentialException convertToJetpackGetException$credentials_release(android.credentials.GetCredentialException error) {
        Intrinsics.checkNotNullParameter(error, "");
        String type = error.getType();
        switch (type.hashCode()) {
            case -781118336:
                if (type.equals(GetCredentialUnknownException.TYPE_GET_CREDENTIAL_UNKNOWN_EXCEPTION)) {
                    return new GetCredentialUnknownException(error.getMessage());
                }
                break;
            case -45448328:
                if (type.equals(GetCredentialInterruptedException.TYPE_GET_CREDENTIAL_INTERRUPTED_EXCEPTION)) {
                    return new GetCredentialInterruptedException(error.getMessage());
                }
                break;
            case 580557411:
                if (type.equals(GetCredentialCancellationException.TYPE_GET_CREDENTIAL_CANCELLATION_EXCEPTION)) {
                    return new GetCredentialCancellationException(error.getMessage());
                }
                break;
            case 627896683:
                if (type.equals(NoCredentialException.TYPE_FRAMEWORK_TYPE_NO_CREDENTIAL)) {
                    return new NoCredentialException(error.getMessage());
                }
                break;
        }
        String type2 = error.getType();
        Intrinsics.checkNotNullExpressionValue(type2, "");
        if (!StringsKt.startsWith$default(type2, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION", false, 2, (Object) null)) {
            String type3 = error.getType();
            Intrinsics.checkNotNullExpressionValue(type3, "");
            return new GetCredentialCustomException(type3, error.getMessage());
        }
        GetPublicKeyCredentialException.Companion companion = GetPublicKeyCredentialException.INSTANCE;
        String type4 = error.getType();
        Intrinsics.checkNotNullExpressionValue(type4, "");
        return companion.createFrom(type4, error.getMessage());
    }

    public final CreateCredentialException convertToJetpackCreateException$credentials_release(android.credentials.CreateCredentialException error) {
        Intrinsics.checkNotNullParameter(error, "");
        String type = error.getType();
        switch (type.hashCode()) {
            case -2055374133:
                if (type.equals(CreateCredentialCancellationException.TYPE_CREATE_CREDENTIAL_CANCELLATION_EXCEPTION)) {
                    return new CreateCredentialCancellationException(error.getMessage());
                }
                break;
            case 1316905704:
                if (type.equals(CreateCredentialUnknownException.TYPE_CREATE_CREDENTIAL_UNKNOWN_EXCEPTION)) {
                    return new CreateCredentialUnknownException(error.getMessage());
                }
                break;
            case 2092588512:
                if (type.equals(CreateCredentialInterruptedException.TYPE_CREATE_CREDENTIAL_INTERRUPTED_EXCEPTION)) {
                    return new CreateCredentialInterruptedException(error.getMessage());
                }
                break;
            case 2131915191:
                if (type.equals(CreateCredentialNoCreateOptionException.TYPE_CREATE_CREDENTIAL_NO_CREATE_OPTION)) {
                    return new CreateCredentialNoCreateOptionException(error.getMessage());
                }
                break;
        }
        String type2 = error.getType();
        Intrinsics.checkNotNullExpressionValue(type2, "");
        if (!StringsKt.startsWith$default(type2, "androidx.credentials.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION", false, 2, (Object) null)) {
            String type3 = error.getType();
            Intrinsics.checkNotNullExpressionValue(type3, "");
            return new CreateCredentialCustomException(type3, error.getMessage());
        }
        CreatePublicKeyCredentialException.Companion companion = CreatePublicKeyCredentialException.INSTANCE;
        String type4 = error.getType();
        Intrinsics.checkNotNullExpressionValue(type4, "");
        return companion.createFrom(type4, error.getMessage());
    }

    public final GetCredentialResponse convertGetResponseToJetpackClass$credentials_release(android.credentials.GetCredentialResponse response) {
        Intrinsics.checkNotNullParameter(response, "");
        android.credentials.Credential credential = response.getCredential();
        Intrinsics.checkNotNullExpressionValue(credential, "");
        Credential.Companion companion = Credential.INSTANCE;
        String type = credential.getType();
        Intrinsics.checkNotNullExpressionValue(type, "");
        Bundle data = credential.getData();
        Intrinsics.checkNotNullExpressionValue(data, "");
        return new GetCredentialResponse(companion.createFrom(type, data));
    }

    public final PrepareGetCredentialResponse convertPrepareGetResponseToJetpackClass$credentials_release(android.credentials.PrepareGetCredentialResponse response) {
        Intrinsics.checkNotNullParameter(response, "");
        return new PrepareGetCredentialResponse.Builder().setFrameworkResponse(response).setPendingGetCredentialHandle(new PrepareGetCredentialResponse.PendingGetCredentialHandle(response.getPendingGetCredentialHandle())).build();
    }

    @Override // androidx.credentials.CredentialProvider
    public final boolean isAvailableOnDevice() {
        return Build.VERSION.SDK_INT >= 34;
    }

    @Override // androidx.credentials.CredentialProvider
    public final void onClearCredential(ClearCredentialStateRequest request, CancellationSignal cancellationSignal, Executor executor, final CredentialManagerCallback<Void, ClearCredentialException> callback) {
        Intrinsics.checkNotNullParameter(request, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        InstrumentInjector.log_i(TAG, "In CredentialProviderFrameworkImpl onClearCredential");
        if (isCredmanDisabled(new Function0<Unit>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onClearCredential$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                callback.onError(new ClearCredentialUnsupportedException("Your device doesn't support credential manager"));
            }
        })) {
            return;
        }
        OutcomeReceiver<Void, ClearCredentialStateException> outcomeReceiver = new OutcomeReceiver<Void, ClearCredentialStateException>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onClearCredential$outcome$1
            @Override // android.os.OutcomeReceiver
            public final void onResult(Void response) {
                Intrinsics.checkNotNullParameter(response, "");
                InstrumentInjector.log_i("CredManProvService", "Clear result returned from framework: ");
                callback.onResult(response);
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.CharSequence, kotlin.jvm.internal.DefaultConstructorMarker] */
            @Override // android.os.OutcomeReceiver
            public final void onError(ClearCredentialStateException error) {
                Intrinsics.checkNotNullParameter(error, "");
                InstrumentInjector.log_i("CredManProvService", "ClearCredentialStateException error returned from framework");
                ?? r1 = 0;
                callback.onError(new ClearCredentialUnknownException(r1, 1, r1));
            }
        };
        android.credentials.CredentialManager credentialManager = this.credentialManager;
        Intrinsics.checkNotNull(credentialManager);
        credentialManager.clearCredentialState(createFrameworkClearCredentialRequest(), cancellationSignal, executor, outcomeReceiver);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Landroidx/credentials/CredentialProviderFrameworkImpl$Companion;", "", "", "CREATE_DOM_EXCEPTION_PREFIX", "Ljava/lang/String;", "GET_DOM_EXCEPTION_PREFIX", "TAG", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
