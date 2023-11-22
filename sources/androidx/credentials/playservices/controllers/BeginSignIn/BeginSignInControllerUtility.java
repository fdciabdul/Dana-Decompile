package androidx.credentials.playservices.controllers.BeginSignIn;

import android.content.Context;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetPasswordOption;
import androidx.credentials.GetPublicKeyCredentialOption;
import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/playservices/controllers/BeginSignIn/BeginSignInControllerUtility;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BeginSignInControllerUtility {
    private static final long AUTH_MIN_VERSION_JSON_PARSING = 231815000;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "BeginSignInUtility";

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Landroidx/credentials/playservices/controllers/BeginSignIn/BeginSignInControllerUtility$Companion;", "", "Landroidx/credentials/GetCredentialRequest;", "request", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest;", "constructBeginSignInRequest$credentials_play_services_auth_release", "(Landroidx/credentials/GetCredentialRequest;Landroid/content/Context;)Lcom/google/android/gms/auth/api/identity/BeginSignInRequest;", "Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption;", "option", "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest$GoogleIdTokenRequestOptions;", "convertToGoogleIdTokenOption", "(Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption;)Lcom/google/android/gms/auth/api/identity/BeginSignInRequest$GoogleIdTokenRequestOptions;", "", "determineDeviceGMSVersionCode", "(Landroid/content/Context;)J", "curAuthVersion", "", "needsBackwardsCompatibleRequest", "(J)Z", "AUTH_MIN_VERSION_JSON_PARSING", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean needsBackwardsCompatibleRequest(long curAuthVersion) {
            return curAuthVersion < BeginSignInControllerUtility.AUTH_MIN_VERSION_JSON_PARSING;
        }

        private Companion() {
        }

        public final BeginSignInRequest constructBeginSignInRequest$credentials_play_services_auth_release(GetCredentialRequest request, Context r11) {
            Intrinsics.checkNotNullParameter(request, "");
            Intrinsics.checkNotNullParameter(r11, "");
            BeginSignInRequest.Builder builder = new BeginSignInRequest.Builder();
            boolean z = false;
            boolean z2 = false;
            for (CredentialOption credentialOption : request.getCredentialOptions()) {
                if (credentialOption instanceof GetPasswordOption) {
                    builder.setPasswordRequestOptions(new BeginSignInRequest.PasswordRequestOptions.Builder().setSupported(true).build());
                    if (!z && !credentialOption.getIsAutoSelectAllowed()) {
                        z = false;
                    }
                    z = true;
                } else if ((credentialOption instanceof GetPublicKeyCredentialOption) && !z2) {
                    if (needsBackwardsCompatibleRequest(determineDeviceGMSVersionCode(r11))) {
                        builder.setPasskeysSignInRequestOptions(PublicKeyCredentialControllerUtility.INSTANCE.convertToPlayAuthPasskeyRequest((GetPublicKeyCredentialOption) credentialOption));
                    } else {
                        builder.setPasskeyJsonSignInRequestOptions(PublicKeyCredentialControllerUtility.INSTANCE.convertToPlayAuthPasskeyJsonRequest((GetPublicKeyCredentialOption) credentialOption));
                    }
                    z2 = true;
                } else if (credentialOption instanceof GetGoogleIdOption) {
                    GetGoogleIdOption getGoogleIdOption = (GetGoogleIdOption) credentialOption;
                    builder.setGoogleIdTokenRequestOptions(convertToGoogleIdTokenOption(getGoogleIdOption));
                    if (!z && !getGoogleIdOption.getZzg()) {
                        z = false;
                    }
                    z = true;
                }
            }
            BeginSignInRequest build = builder.setAutoSelectEnabled(z).build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        private final long determineDeviceGMSVersionCode(Context r3) {
            Intrinsics.checkNotNullExpressionValue(r3.getPackageManager(), "");
            return r3.getPackageInfo("com.google.android.gms", 0).versionCode;
        }

        private final BeginSignInRequest.GoogleIdTokenRequestOptions convertToGoogleIdTokenOption(GetGoogleIdOption option) {
            BeginSignInRequest.GoogleIdTokenRequestOptions.Builder supported = BeginSignInRequest.GoogleIdTokenRequestOptions.builder().setFilterByAuthorizedAccounts(option.getZzc()).setNonce(option.getZzb()).setRequestVerifiedPhoneNumber(option.getZzf()).setServerClientId(option.getZza()).setSupported(true);
            Intrinsics.checkNotNullExpressionValue(supported, "");
            if (option.getZzd() != null) {
                String zzd = option.getZzd();
                Intrinsics.checkNotNull(zzd);
                supported.associateLinkedAccounts(zzd, option.getIdTokenDepositionScopes());
            }
            BeginSignInRequest.GoogleIdTokenRequestOptions build = supported.build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }
    }
}
