package androidx.credentials.provider;

import androidx.credentials.CreateCredentialRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/credentials/provider/ProviderCreateCredentialRequest;", "", "Landroidx/credentials/provider/CallingAppInfo;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "getCallingAppInfo", "()Landroidx/credentials/provider/CallingAppInfo;", "Landroidx/credentials/CreateCredentialRequest;", "callingRequest", "Landroidx/credentials/CreateCredentialRequest;", "getCallingRequest", "()Landroidx/credentials/CreateCredentialRequest;", "<init>", "(Landroidx/credentials/CreateCredentialRequest;Landroidx/credentials/provider/CallingAppInfo;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ProviderCreateCredentialRequest {
    private final CallingAppInfo callingAppInfo;
    private final CreateCredentialRequest callingRequest;

    public ProviderCreateCredentialRequest(CreateCredentialRequest createCredentialRequest, CallingAppInfo callingAppInfo) {
        Intrinsics.checkNotNullParameter(createCredentialRequest, "");
        Intrinsics.checkNotNullParameter(callingAppInfo, "");
        this.callingRequest = createCredentialRequest;
        this.callingAppInfo = callingAppInfo;
    }

    @JvmName(name = "getCallingRequest")
    public final CreateCredentialRequest getCallingRequest() {
        return this.callingRequest;
    }

    @JvmName(name = "getCallingAppInfo")
    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }
}
