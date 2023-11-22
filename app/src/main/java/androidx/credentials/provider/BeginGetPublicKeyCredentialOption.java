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

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B+\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/credentials/provider/BeginGetPublicKeyCredentialOption;", "Landroidx/credentials/provider/BeginGetCredentialOption;", "", "clientDataHash", "[B", "getClientDataHash", "()[B", "", "requestJson", "Ljava/lang/String;", "getRequestJson", "()Ljava/lang/String;", "Landroid/os/Bundle;", "candidateQueryData", "id", "<init>", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;[B)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BeginGetPublicKeyCredentialOption extends BeginGetCredentialOption {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final byte[] clientDataHash;
    private final String requestJson;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeginGetPublicKeyCredentialOption(Bundle bundle, String str, String str2) {
        this(bundle, str, str2, null, 8, null);
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
    }

    public /* synthetic */ BeginGetPublicKeyCredentialOption(Bundle bundle, String str, String str2, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle, str, str2, (i & 8) != 0 ? null : bArr);
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
    public BeginGetPublicKeyCredentialOption(Bundle bundle, String str, String str2, byte[] bArr) {
        super(str, PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, bundle);
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.requestJson = str2;
        this.clientDataHash = bArr;
        if (!RequestValidationUtil.INSTANCE.isValidJSON(str2)) {
            throw new IllegalArgumentException("requestJson must not be empty, and must be a valid JSON".toString());
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\t\u0010\b"}, d2 = {"Landroidx/credentials/provider/BeginGetPublicKeyCredentialOption$Companion;", "", "Landroid/os/Bundle;", "data", "", "id", "Landroidx/credentials/provider/BeginGetPublicKeyCredentialOption;", "createFrom$credentials_release", "(Landroid/os/Bundle;Ljava/lang/String;)Landroidx/credentials/provider/BeginGetPublicKeyCredentialOption;", "createFromEntrySlice$credentials_release", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BeginGetPublicKeyCredentialOption createFrom$credentials_release(Bundle data, String id2) {
            Intrinsics.checkNotNullParameter(data, "");
            Intrinsics.checkNotNullParameter(id2, "");
            try {
                String string = data.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                byte[] byteArray = data.getByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH");
                Intrinsics.checkNotNull(string);
                return new BeginGetPublicKeyCredentialOption(data, id2, string, byteArray);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        @JvmStatic
        public final BeginGetPublicKeyCredentialOption createFromEntrySlice$credentials_release(Bundle data, String id2) {
            Intrinsics.checkNotNullParameter(data, "");
            Intrinsics.checkNotNullParameter(id2, "");
            return new BeginGetPublicKeyCredentialOption(data, id2, "{\"dummy_key\":\"dummy_value\"}", null, 8, null);
        }
    }
}
