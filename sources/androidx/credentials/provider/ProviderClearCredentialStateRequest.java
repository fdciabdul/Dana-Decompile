package androidx.credentials.provider;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "", "Landroidx/credentials/provider/CallingAppInfo;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "getCallingAppInfo", "()Landroidx/credentials/provider/CallingAppInfo;", "<init>", "(Landroidx/credentials/provider/CallingAppInfo;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ProviderClearCredentialStateRequest {
    private final CallingAppInfo callingAppInfo;

    public ProviderClearCredentialStateRequest(CallingAppInfo callingAppInfo) {
        Intrinsics.checkNotNullParameter(callingAppInfo, "");
        this.callingAppInfo = callingAppInfo;
    }

    @JvmName(name = "getCallingAppInfo")
    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }
}
