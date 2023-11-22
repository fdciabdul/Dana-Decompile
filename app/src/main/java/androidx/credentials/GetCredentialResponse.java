package androidx.credentials;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/credentials/GetCredentialResponse;", "", "Landroidx/credentials/Credential;", "credential", "Landroidx/credentials/Credential;", "getCredential", "()Landroidx/credentials/Credential;", "<init>", "(Landroidx/credentials/Credential;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetCredentialResponse {
    private final Credential credential;

    public GetCredentialResponse(Credential credential) {
        Intrinsics.checkNotNullParameter(credential, "");
        this.credential = credential;
    }

    @JvmName(name = "getCredential")
    public final Credential getCredential() {
        return this.credential;
    }
}
