package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B9\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eB=\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u0010BQ\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\r\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Landroidx/credentials/CreatePasswordRequest;", "Landroidx/credentials/CreateCredentialRequest;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "password", "getPassword", "origin", "", "preferImmediatelyAvailableCredentials", "isAutoSelectAllowed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "preferDefaultProvider", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "Landroidx/credentials/CreateCredentialRequest$DisplayInfo;", "displayInfo", "Landroid/os/Bundle;", "credentialData", "candidateQueryData", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/credentials/CreateCredentialRequest$DisplayInfo;Ljava/lang/String;ZLandroid/os/Bundle;Landroid/os/Bundle;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CreatePasswordRequest extends CreateCredentialRequest {
    public static final String BUNDLE_KEY_ID = "androidx.credentials.BUNDLE_KEY_ID";
    public static final String BUNDLE_KEY_PASSWORD = "androidx.credentials.BUNDLE_KEY_PASSWORD";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final String password;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2) {
        this(str, str2, null, false, false, 28, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2, String str3) {
        this(str, str2, str3, false, false, 24, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2, String str3, boolean z) {
        this(str, str2, str3, z, false, 16, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
    }

    public /* synthetic */ CreatePasswordRequest(String str, String str2, boolean z, CreateCredentialRequest.DisplayInfo displayInfo, String str3, boolean z2, Bundle bundle, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, displayInfo, str3, z2, bundle, bundle2);
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getPassword")
    public final String getPassword() {
        return this.password;
    }

    /* synthetic */ CreatePasswordRequest(String str, String str2, boolean z, CreateCredentialRequest.DisplayInfo displayInfo, String str3, boolean z2, Bundle bundle, Bundle bundle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, displayInfo, (i & 16) != 0 ? null : str3, z2, (i & 64) != 0 ? INSTANCE.toCredentialDataBundle$credentials_release(str, str2) : bundle, (i & 128) != 0 ? INSTANCE.toCandidateDataBundle$credentials_release() : bundle2);
    }

    private CreatePasswordRequest(String str, String str2, boolean z, CreateCredentialRequest.DisplayInfo displayInfo, String str3, boolean z2, Bundle bundle, Bundle bundle2) {
        super(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, bundle, bundle2, false, z, displayInfo, str3, z2);
        this.id = str;
        this.password = str2;
        if (!(str2.length() > 0)) {
            throw new IllegalArgumentException("password should not be empty".toString());
        }
    }

    public /* synthetic */ CreatePasswordRequest(String str, String str2, String str3, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2, String str3, boolean z, boolean z2) {
        this(str, str2, z2, new CreateCredentialRequest.DisplayInfo(str, null), str3, z, null, null, 192, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this(str, str2, z2, new CreateCredentialRequest.DisplayInfo(str, null, str4), str3, z, null, null, 192, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011"}, d2 = {"Landroidx/credentials/CreatePasswordRequest$Companion;", "", "Landroid/os/Bundle;", "data", "", "origin", "candidateQueryData", "Landroidx/credentials/CreatePasswordRequest;", "createFrom$credentials_release", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/credentials/CreatePasswordRequest;", "toCandidateDataBundle$credentials_release", "()Landroid/os/Bundle;", "id", "password", "toCredentialDataBundle$credentials_release", "(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;", "BUNDLE_KEY_ID", "Ljava/lang/String;", "BUNDLE_KEY_PASSWORD", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Bundle toCredentialDataBundle$credentials_release(String id2, String password) {
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(password, "");
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_ID", id2);
            bundle.putString("androidx.credentials.BUNDLE_KEY_PASSWORD", password);
            return bundle;
        }

        @JvmStatic
        public final Bundle toCandidateDataBundle$credentials_release() {
            return new Bundle();
        }

        @JvmStatic
        public final CreatePasswordRequest createFrom$credentials_release(Bundle data, String origin, Bundle candidateQueryData) {
            Intrinsics.checkNotNullParameter(data, "");
            Intrinsics.checkNotNullParameter(candidateQueryData, "");
            try {
                String string = data.getString("androidx.credentials.BUNDLE_KEY_ID");
                Intrinsics.checkNotNull(string);
                String string2 = data.getString("androidx.credentials.BUNDLE_KEY_PASSWORD");
                Intrinsics.checkNotNull(string2);
                CreateCredentialRequest.DisplayInfo parseFromCredentialDataBundle = CreateCredentialRequest.DisplayInfo.INSTANCE.parseFromCredentialDataBundle(data);
                if (parseFromCredentialDataBundle == null) {
                    parseFromCredentialDataBundle = new CreateCredentialRequest.DisplayInfo(string, null);
                }
                boolean z = data.getBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", false);
                return new CreatePasswordRequest(string, string2, data.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), parseFromCredentialDataBundle, origin, z, data, candidateQueryData, null);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }
    }
}
