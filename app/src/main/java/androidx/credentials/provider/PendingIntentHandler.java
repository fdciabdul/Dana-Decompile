package androidx.credentials.provider;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.SigningInfo;
import android.credentials.Credential;
import android.credentials.CredentialOption;
import android.os.Bundle;
import android.service.credentials.CreateCredentialRequest;
import android.service.credentials.GetCredentialRequest;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.provider.PendingIntentHandler;
import androidx.credentials.provider.ProviderGetCredentialRequest;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.Collection;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PendingIntentHandler {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PendingIntentHandler";

    @JvmStatic
    public static final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
        return INSTANCE.retrieveBeginGetCredentialRequest(intent);
    }

    @JvmStatic
    public static final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
        return INSTANCE.retrieveProviderCreateCredentialRequest(intent);
    }

    @JvmStatic
    public static final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
        return INSTANCE.retrieveProviderGetCredentialRequest(intent);
    }

    @JvmStatic
    public static final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse beginGetCredentialResponse) {
        INSTANCE.setBeginGetCredentialResponse(intent, beginGetCredentialResponse);
    }

    @JvmStatic
    public static final void setCreateCredentialException(Intent intent, CreateCredentialException createCredentialException) {
        INSTANCE.setCreateCredentialException(intent, createCredentialException);
    }

    @JvmStatic
    public static final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse createCredentialResponse) {
        INSTANCE.setCreateCredentialResponse(intent, createCredentialResponse);
    }

    @JvmStatic
    public static final void setGetCredentialException(Intent intent, GetCredentialException getCredentialException) {
        INSTANCE.setGetCredentialException(intent, getCredentialException);
    }

    @JvmStatic
    public static final void setGetCredentialResponse(Intent intent, GetCredentialResponse getCredentialResponse) {
        INSTANCE.setGetCredentialResponse(intent, getCredentialResponse);
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler$Companion;", "", "Landroid/content/Intent;", "intent", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "retrieveBeginGetCredentialRequest", "(Landroid/content/Intent;)Landroidx/credentials/provider/BeginGetCredentialRequest;", "Landroidx/credentials/provider/ProviderCreateCredentialRequest;", "retrieveProviderCreateCredentialRequest", "(Landroid/content/Intent;)Landroidx/credentials/provider/ProviderCreateCredentialRequest;", "Landroidx/credentials/provider/ProviderGetCredentialRequest;", "retrieveProviderGetCredentialRequest", "(Landroid/content/Intent;)Landroidx/credentials/provider/ProviderGetCredentialRequest;", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "response", "", "setBeginGetCredentialResponse", "(Landroid/content/Intent;Landroidx/credentials/provider/BeginGetCredentialResponse;)V", "Landroidx/credentials/exceptions/CreateCredentialException;", "exception", "setCreateCredentialException", "(Landroid/content/Intent;Landroidx/credentials/exceptions/CreateCredentialException;)V", "Landroidx/credentials/CreateCredentialResponse;", "setCreateCredentialResponse", "(Landroid/content/Intent;Landroidx/credentials/CreateCredentialResponse;)V", "Landroidx/credentials/exceptions/GetCredentialException;", "setGetCredentialException", "(Landroid/content/Intent;Landroidx/credentials/exceptions/GetCredentialException;)V", "Landroidx/credentials/GetCredentialResponse;", "setGetCredentialResponse", "(Landroid/content/Intent;Landroidx/credentials/GetCredentialResponse;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "");
            CreateCredentialRequest createCredentialRequest = (CreateCredentialRequest) intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_REQUEST", CreateCredentialRequest.class);
            if (createCredentialRequest == null) {
                InstrumentInjector.log_i(PendingIntentHandler.TAG, "Request not found in pendingIntent");
                return (ProviderCreateCredentialRequest) createCredentialRequest;
            }
            CreateCredentialRequest.Companion companion = androidx.credentials.CreateCredentialRequest.INSTANCE;
            String type = createCredentialRequest.getType();
            Intrinsics.checkNotNullExpressionValue(type, "");
            Bundle data = createCredentialRequest.getData();
            Intrinsics.checkNotNullExpressionValue(data, "");
            Bundle data2 = createCredentialRequest.getData();
            Intrinsics.checkNotNullExpressionValue(data2, "");
            androidx.credentials.CreateCredentialRequest createFrom = companion.createFrom(type, data, data2, false, createCredentialRequest.getCallingAppInfo().getOrigin());
            if (createFrom == null) {
                return null;
            }
            String packageName = createCredentialRequest.getCallingAppInfo().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "");
            SigningInfo signingInfo = createCredentialRequest.getCallingAppInfo().getSigningInfo();
            Intrinsics.checkNotNullExpressionValue(signingInfo, "");
            return new ProviderCreateCredentialRequest(createFrom, new CallingAppInfo(packageName, signingInfo, createCredentialRequest.getCallingAppInfo().getOrigin()));
        }

        @JvmStatic
        public final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "");
            android.service.credentials.BeginGetCredentialRequest beginGetCredentialRequest = (android.service.credentials.BeginGetCredentialRequest) intent.getParcelableExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_REQUEST", android.service.credentials.BeginGetCredentialRequest.class);
            if (beginGetCredentialRequest != null) {
                return BeginGetCredentialUtil.INSTANCE.convertToJetpackRequest$credentials_release(beginGetCredentialRequest);
            }
            return null;
        }

        @JvmStatic
        public final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "");
            Intrinsics.checkNotNullParameter(response, "");
            intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", new android.credentials.CreateCredentialResponse(response.getData()));
        }

        @JvmStatic
        public final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "");
            GetCredentialRequest getCredentialRequest = (GetCredentialRequest) intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_REQUEST", GetCredentialRequest.class);
            if (getCredentialRequest == null) {
                InstrumentInjector.log_i(PendingIntentHandler.TAG, "Get request from framework is null");
                return null;
            }
            ProviderGetCredentialRequest.Companion companion = ProviderGetCredentialRequest.INSTANCE;
            Stream authRequestContext = Collection.EL.getAuthRequestContext(getCredentialRequest.getCredentialOptions());
            final PendingIntentHandler$Companion$retrieveProviderGetCredentialRequest$1 pendingIntentHandler$Companion$retrieveProviderGetCredentialRequest$1 = new Function1<CredentialOption, androidx.credentials.CredentialOption>() { // from class: androidx.credentials.provider.PendingIntentHandler$Companion$retrieveProviderGetCredentialRequest$1
                @Override // kotlin.jvm.functions.Function1
                public final androidx.credentials.CredentialOption invoke(CredentialOption credentialOption) {
                    CredentialOption.Companion companion2 = androidx.credentials.CredentialOption.INSTANCE;
                    String type = credentialOption.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "");
                    Bundle credentialRetrievalData = credentialOption.getCredentialRetrievalData();
                    Intrinsics.checkNotNullExpressionValue(credentialRetrievalData, "");
                    Bundle candidateQueryData = credentialOption.getCandidateQueryData();
                    Intrinsics.checkNotNullExpressionValue(candidateQueryData, "");
                    boolean isSystemProviderRequired = credentialOption.isSystemProviderRequired();
                    Set<ComponentName> allowedProviders = credentialOption.getAllowedProviders();
                    Intrinsics.checkNotNullExpressionValue(allowedProviders, "");
                    return companion2.createFrom(type, credentialRetrievalData, candidateQueryData, isSystemProviderRequired, allowedProviders);
                }
            };
            Object BuiltInFictitiousFunctionClassFactory = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.PendingIntentHandler$Companion$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    androidx.credentials.CredentialOption retrieveProviderGetCredentialRequest$lambda$1;
                    retrieveProviderGetCredentialRequest$lambda$1 = PendingIntentHandler.Companion.retrieveProviderGetCredentialRequest$lambda$1(Function1.this, obj);
                    return retrieveProviderGetCredentialRequest$lambda$1;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory());
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            String packageName = getCredentialRequest.getCallingAppInfo().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "");
            SigningInfo signingInfo = getCredentialRequest.getCallingAppInfo().getSigningInfo();
            Intrinsics.checkNotNullExpressionValue(signingInfo, "");
            return companion.createFrom$credentials_release((List) BuiltInFictitiousFunctionClassFactory, new CallingAppInfo(packageName, signingInfo, getCredentialRequest.getCallingAppInfo().getOrigin()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final androidx.credentials.CredentialOption retrieveProviderGetCredentialRequest$lambda$1(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (androidx.credentials.CredentialOption) function1.invoke(obj);
        }

        @JvmStatic
        public final void setGetCredentialResponse(Intent intent, GetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "");
            Intrinsics.checkNotNullParameter(response, "");
            intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", new android.credentials.GetCredentialResponse(new Credential(response.getCredential().getType(), response.getCredential().getData())));
        }

        @JvmStatic
        public final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "");
            Intrinsics.checkNotNullParameter(response, "");
            intent.putExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE", BeginGetCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
        }

        @JvmStatic
        public final void setGetCredentialException(Intent intent, GetCredentialException exception) {
            Intrinsics.checkNotNullParameter(intent, "");
            Intrinsics.checkNotNullParameter(exception, "");
            intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", new android.credentials.GetCredentialException(exception.getType(), exception.getMessage()));
        }

        @JvmStatic
        public final void setCreateCredentialException(Intent intent, CreateCredentialException exception) {
            Intrinsics.checkNotNullParameter(intent, "");
            Intrinsics.checkNotNullParameter(exception, "");
            intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", new android.credentials.CreateCredentialException(exception.getType(), exception.getMessage()));
        }
    }
}
