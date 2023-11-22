package androidx.credentials.provider.utils;

import android.content.pm.SigningInfo;
import android.service.credentials.ClearCredentialStateRequest;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.ProviderClearCredentialStateRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/provider/utils/ClearCredentialUtil;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ClearCredentialUtil {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/credentials/provider/utils/ClearCredentialUtil$Companion;", "", "Landroid/service/credentials/ClearCredentialStateRequest;", "request", "Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "convertToJetpackRequest$credentials_release", "(Landroid/service/credentials/ClearCredentialStateRequest;)Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ProviderClearCredentialStateRequest convertToJetpackRequest$credentials_release(ClearCredentialStateRequest request) {
            Intrinsics.checkNotNullParameter(request, "");
            String packageName = request.getCallingAppInfo().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "");
            SigningInfo signingInfo = request.getCallingAppInfo().getSigningInfo();
            Intrinsics.checkNotNullExpressionValue(signingInfo, "");
            return new ProviderClearCredentialStateRequest(new CallingAppInfo(packageName, signingInfo, request.getCallingAppInfo().getOrigin()));
        }
    }
}
