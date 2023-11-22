package androidx.credentials.webauthn;

import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.webauthn.WebAuthnUtils;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/webauthn/WebAuthnUtilsApi28;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WebAuthnUtilsApi28 {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/credentials/webauthn/WebAuthnUtilsApi28$Companion;", "", "Landroidx/credentials/provider/CallingAppInfo;", "info", "", "appInfoToOrigin", "(Landroidx/credentials/provider/CallingAppInfo;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String appInfoToOrigin(CallingAppInfo info) {
            Intrinsics.checkNotNullParameter(info, "");
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(info.getSigningInfo().getApkContentsSigners()[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            sb.append("android:apk-key-hash:");
            WebAuthnUtils.Companion companion = WebAuthnUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(digest, "");
            sb.append(companion.b64Encode(digest));
            return sb.toString();
        }
    }
}
