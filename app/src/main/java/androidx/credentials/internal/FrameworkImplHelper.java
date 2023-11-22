package androidx.credentials.internal;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.CreatePasswordRequest;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.R;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/internal/FrameworkImplHelper;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FrameworkImplHelper {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final Bundle getFinalCreateCredentialData(CreateCredentialRequest createCredentialRequest, Context context) {
        return INSTANCE.getFinalCreateCredentialData(createCredentialRequest, context);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/credentials/internal/FrameworkImplHelper$Companion;", "", "Landroidx/credentials/CreateCredentialRequest;", "request", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/os/Bundle;", "getFinalCreateCredentialData", "(Landroidx/credentials/CreateCredentialRequest;Landroid/content/Context;)Landroid/os/Bundle;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Bundle getFinalCreateCredentialData(CreateCredentialRequest request, Context context) {
            int i;
            Intrinsics.checkNotNullParameter(request, "");
            Intrinsics.checkNotNullParameter(context, "");
            Bundle credentialData = request.getCredentialData();
            Bundle bundle = request.getDisplayInfo().toBundle();
            if (request instanceof CreatePasswordRequest) {
                i = R.drawable.ic_password;
            } else {
                i = request instanceof CreatePublicKeyCredentialRequest ? R.drawable.ic_passkey : R.drawable.ic_other_sign_in;
            }
            bundle.putParcelable(CreateCredentialRequest.DisplayInfo.BUNDLE_KEY_CREDENTIAL_TYPE_ICON, Icon.createWithResource(context, i));
            credentialData.putBundle(CreateCredentialRequest.DisplayInfo.BUNDLE_KEY_REQUEST_DISPLAY_INFO, bundle);
            return credentialData;
        }
    }
}
