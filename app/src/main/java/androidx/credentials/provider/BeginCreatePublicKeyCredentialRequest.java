package androidx.credentials.provider;

import android.os.Bundle;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.provider.utils.RequestValidationUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B-\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Landroidx/credentials/provider/BeginCreatePublicKeyCredentialRequest;", "Landroidx/credentials/provider/BeginCreateCredentialRequest;", "Landroid/os/Bundle;", "candidateQueryData", "", "requestJson", "", "initiateBundle", "(Landroid/os/Bundle;Ljava/lang/String;)V", "", "clientDataHash", "[B", "getClientDataHash", "()[B", "Ljava/lang/String;", "getRequestJson", "()Ljava/lang/String;", "Landroidx/credentials/provider/CallingAppInfo;", "callingAppInfo", "<init>", "(Ljava/lang/String;Landroidx/credentials/provider/CallingAppInfo;Landroid/os/Bundle;[B)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BeginCreatePublicKeyCredentialRequest extends BeginCreateCredentialRequest {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final byte[] clientDataHash;
    private final String requestJson;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeginCreatePublicKeyCredentialRequest(String str, CallingAppInfo callingAppInfo, Bundle bundle) {
        this(str, callingAppInfo, bundle, null, 8, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
    }

    @JvmStatic
    public static final BeginCreatePublicKeyCredentialRequest createForTest(Bundle bundle, CallingAppInfo callingAppInfo) {
        return INSTANCE.createForTest(bundle, callingAppInfo);
    }

    public /* synthetic */ BeginCreatePublicKeyCredentialRequest(String str, CallingAppInfo callingAppInfo, Bundle bundle, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, callingAppInfo, bundle, (i & 8) != 0 ? null : bArr);
    }

    @JvmName(name = "getRequestJson")
    public final String getRequestJson() {
        return this.requestJson;
    }

    @JvmName(name = "getClientDataHash")
    public final byte[] getClientDataHash() {
        return this.clientDataHash;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeginCreatePublicKeyCredentialRequest(String str, CallingAppInfo callingAppInfo, Bundle bundle, byte[] bArr) {
        super(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, bundle, callingAppInfo);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        this.requestJson = str;
        this.clientDataHash = bArr;
        if (!RequestValidationUtil.INSTANCE.isValidJSON(str)) {
            throw new IllegalArgumentException("requestJson must not be empty, and must be a valid JSON".toString());
        }
        initiateBundle(bundle, str);
    }

    private final void initiateBundle(Bundle candidateQueryData, String requestJson) {
        candidateQueryData.putString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON", requestJson);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\t\u0010\b"}, d2 = {"Landroidx/credentials/provider/BeginCreatePublicKeyCredentialRequest$Companion;", "", "Landroid/os/Bundle;", "data", "Landroidx/credentials/provider/CallingAppInfo;", "callingAppInfo", "Landroidx/credentials/provider/BeginCreatePublicKeyCredentialRequest;", "createForTest", "(Landroid/os/Bundle;Landroidx/credentials/provider/CallingAppInfo;)Landroidx/credentials/provider/BeginCreatePublicKeyCredentialRequest;", "createFrom$credentials_release", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BeginCreatePublicKeyCredentialRequest createForTest(Bundle data, CallingAppInfo callingAppInfo) {
            Intrinsics.checkNotNullParameter(data, "");
            return createFrom$credentials_release(data, callingAppInfo);
        }

        public final BeginCreatePublicKeyCredentialRequest createFrom$credentials_release(Bundle data, CallingAppInfo callingAppInfo) {
            Intrinsics.checkNotNullParameter(data, "");
            try {
                String string = data.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                byte[] byteArray = data.getByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH");
                Intrinsics.checkNotNull(string);
                return new BeginCreatePublicKeyCredentialRequest(string, callingAppInfo, data, byteArray);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }
    }
}
