package androidx.credentials;

import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/FederatedCredential;", "Landroidx/credentials/Credential;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FederatedCredential extends Credential {
    public static final String TYPE_FEDERATED_CREDENTIAL = "type.federated_credential";

    private FederatedCredential() {
        super(TYPE_FEDERATED_CREDENTIAL, new Bundle());
    }
}
