package androidx.credentials;

import androidx.credentials.PrepareGetCredentialResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class PrepareGetCredentialResponse$Builder$setFrameworkResponse$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PrepareGetCredentialResponse$Builder$setFrameworkResponse$2(Object obj) {
        super(0, obj, PrepareGetCredentialResponse.Builder.class, "hasAuthenticationResults", "hasAuthenticationResults()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        boolean hasAuthenticationResults;
        hasAuthenticationResults = ((PrepareGetCredentialResponse.Builder) this.receiver).hasAuthenticationResults();
        return Boolean.valueOf(hasAuthenticationResults);
    }
}
