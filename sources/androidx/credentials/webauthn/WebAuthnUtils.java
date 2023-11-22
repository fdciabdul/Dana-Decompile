package androidx.credentials.webauthn;

import android.os.Build;
import android.util.Base64;
import androidx.credentials.provider.CallingAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/webauthn/WebAuthnUtils;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WebAuthnUtils {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Landroidx/credentials/webauthn/WebAuthnUtils$Companion;", "", "Landroidx/credentials/provider/CallingAppInfo;", "info", "", "appInfoToOrigin", "(Landroidx/credentials/provider/CallingAppInfo;)Ljava/lang/String;", "str", "", "b64Decode", "(Ljava/lang/String;)[B", "data", "b64Encode", "([B)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] b64Decode(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            byte[] decode = Base64.decode(str, 11);
            Intrinsics.checkNotNullExpressionValue(decode, "");
            return decode;
        }

        public final String b64Encode(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "");
            String encodeToString = Base64.encodeToString(data, 11);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "");
            return encodeToString;
        }

        public final String appInfoToOrigin(CallingAppInfo info) {
            Intrinsics.checkNotNullParameter(info, "");
            return Build.VERSION.SDK_INT >= 28 ? WebAuthnUtilsApi28.INSTANCE.appInfoToOrigin(info) : "";
        }
    }
}
