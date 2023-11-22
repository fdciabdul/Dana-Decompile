package androidx.credentials;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eBK\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0012\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0019\u001a\u00020\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017"}, d2 = {"Landroidx/credentials/CreateCredentialRequest;", "", "Landroid/os/Bundle;", "candidateQueryData", "Landroid/os/Bundle;", "getCandidateQueryData", "()Landroid/os/Bundle;", "credentialData", "getCredentialData", "Landroidx/credentials/CreateCredentialRequest$DisplayInfo;", "displayInfo", "Landroidx/credentials/CreateCredentialRequest$DisplayInfo;", "getDisplayInfo", "()Landroidx/credentials/CreateCredentialRequest$DisplayInfo;", "", "isAutoSelectAllowed", "Z", "()Z", "isSystemProviderRequired", "", "origin", "Ljava/lang/String;", "getOrigin", "()Ljava/lang/String;", "preferImmediatelyAvailableCredentials", "type", "getType", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;ZZLandroidx/credentials/CreateCredentialRequest$DisplayInfo;Ljava/lang/String;Z)V", "Companion", "DisplayInfo"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CreateCredentialRequest {
    public static final String BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED = "androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED";
    public static final String BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS = "androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Bundle candidateQueryData;
    private final Bundle credentialData;
    private final DisplayInfo displayInfo;
    private final boolean isAutoSelectAllowed;
    private final boolean isSystemProviderRequired;
    private final String origin;
    private final boolean preferImmediatelyAvailableCredentials;
    private final String type;

    @JvmStatic
    public static final CreateCredentialRequest createFrom(String str, Bundle bundle, Bundle bundle2, boolean z, String str2) {
        return INSTANCE.createFrom(str, bundle, bundle2, z, str2);
    }

    public CreateCredentialRequest(String str, Bundle bundle, Bundle bundle2, boolean z, boolean z2, DisplayInfo displayInfo, String str2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(bundle2, "");
        Intrinsics.checkNotNullParameter(displayInfo, "");
        this.type = str;
        this.credentialData = bundle;
        this.candidateQueryData = bundle2;
        this.isSystemProviderRequired = z;
        this.isAutoSelectAllowed = z2;
        this.displayInfo = displayInfo;
        this.origin = str2;
        this.preferImmediatelyAvailableCredentials = z3;
        bundle.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z2);
        bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", z3);
        bundle2.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z2);
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getCredentialData")
    public final Bundle getCredentialData() {
        return this.credentialData;
    }

    @JvmName(name = "getCandidateQueryData")
    public final Bundle getCandidateQueryData() {
        return this.candidateQueryData;
    }

    @JvmName(name = "isSystemProviderRequired")
    /* renamed from: isSystemProviderRequired  reason: from getter */
    public final boolean getIsSystemProviderRequired() {
        return this.isSystemProviderRequired;
    }

    @JvmName(name = "isAutoSelectAllowed")
    /* renamed from: isAutoSelectAllowed  reason: from getter */
    public final boolean getIsAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    @JvmName(name = "getDisplayInfo")
    public final DisplayInfo getDisplayInfo() {
        return this.displayInfo;
    }

    @JvmName(name = "getOrigin")
    public final String getOrigin() {
        return this.origin;
    }

    @JvmName(name = "preferImmediatelyAvailableCredentials")
    /* renamed from: preferImmediatelyAvailableCredentials  reason: from getter */
    public final boolean getPreferImmediatelyAvailableCredentials() {
        return this.preferImmediatelyAvailableCredentials;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0016\u0010\u0017B%\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0016\u0010\u0018B/\b\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0016\u0010\u0019J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013"}, d2 = {"Landroidx/credentials/CreateCredentialRequest$DisplayInfo;", "", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "Landroid/graphics/drawable/Icon;", "credentialTypeIcon", "Landroid/graphics/drawable/Icon;", "getCredentialTypeIcon", "()Landroid/graphics/drawable/Icon;", "", "preferDefaultProvider", "Ljava/lang/String;", "getPreferDefaultProvider", "()Ljava/lang/String;", "", "userDisplayName", "Ljava/lang/CharSequence;", "getUserDisplayName", "()Ljava/lang/CharSequence;", "userId", "getUserId", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;)V", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/graphics/drawable/Icon;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DisplayInfo {
        public static final String BUNDLE_KEY_CREDENTIAL_TYPE_ICON = "androidx.credentials.BUNDLE_KEY_CREDENTIAL_TYPE_ICON";
        public static final String BUNDLE_KEY_DEFAULT_PROVIDER = "androidx.credentials.BUNDLE_KEY_DEFAULT_PROVIDER";
        public static final String BUNDLE_KEY_REQUEST_DISPLAY_INFO = "androidx.credentials.BUNDLE_KEY_REQUEST_DISPLAY_INFO";
        public static final String BUNDLE_KEY_USER_DISPLAY_NAME = "androidx.credentials.BUNDLE_KEY_USER_DISPLAY_NAME";
        public static final String BUNDLE_KEY_USER_ID = "androidx.credentials.BUNDLE_KEY_USER_ID";

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Icon credentialTypeIcon;
        private final String preferDefaultProvider;
        private final CharSequence userDisplayName;
        private final CharSequence userId;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.CharSequence, kotlin.jvm.internal.DefaultConstructorMarker] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DisplayInfo(java.lang.CharSequence r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r0 = 0
                r1 = 2
                r2.<init>(r3, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.CreateCredentialRequest.DisplayInfo.<init>(java.lang.CharSequence):void");
        }

        @JvmStatic
        public static final DisplayInfo parseFromCredentialDataBundle(Bundle bundle) {
            return INSTANCE.parseFromCredentialDataBundle(bundle);
        }

        public DisplayInfo(CharSequence charSequence, CharSequence charSequence2, Icon icon, String str) {
            Intrinsics.checkNotNullParameter(charSequence, "");
            this.userId = charSequence;
            this.userDisplayName = charSequence2;
            this.credentialTypeIcon = icon;
            this.preferDefaultProvider = str;
            if (!(charSequence.length() > 0)) {
                throw new IllegalArgumentException("userId should not be empty".toString());
            }
        }

        @JvmName(name = "getUserId")
        public final CharSequence getUserId() {
            return this.userId;
        }

        @JvmName(name = "getUserDisplayName")
        public final CharSequence getUserDisplayName() {
            return this.userDisplayName;
        }

        @JvmName(name = "getCredentialTypeIcon")
        public final Icon getCredentialTypeIcon() {
            return this.credentialTypeIcon;
        }

        @JvmName(name = "getPreferDefaultProvider")
        public final String getPreferDefaultProvider() {
            return this.preferDefaultProvider;
        }

        public /* synthetic */ DisplayInfo(CharSequence charSequence, CharSequence charSequence2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? null : charSequence2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DisplayInfo(CharSequence charSequence, CharSequence charSequence2) {
            this(charSequence, charSequence2, (Icon) null, (String) null);
            Intrinsics.checkNotNullParameter(charSequence, "");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DisplayInfo(CharSequence charSequence, CharSequence charSequence2, String str) {
            this(charSequence, charSequence2, (Icon) null, str);
            Intrinsics.checkNotNullParameter(charSequence, "");
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putCharSequence(BUNDLE_KEY_USER_ID, this.userId);
            if (!TextUtils.isEmpty(this.userDisplayName)) {
                bundle.putCharSequence(BUNDLE_KEY_USER_DISPLAY_NAME, this.userDisplayName);
            }
            if (!TextUtils.isEmpty(this.preferDefaultProvider)) {
                bundle.putString(BUNDLE_KEY_DEFAULT_PROVIDER, this.preferDefaultProvider);
            }
            return bundle;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\t"}, d2 = {"Landroidx/credentials/CreateCredentialRequest$DisplayInfo$Companion;", "", "Landroid/os/Bundle;", "from", "Landroidx/credentials/CreateCredentialRequest$DisplayInfo;", "parseFromCredentialDataBundle", "(Landroid/os/Bundle;)Landroidx/credentials/CreateCredentialRequest$DisplayInfo;", "", "BUNDLE_KEY_CREDENTIAL_TYPE_ICON", "Ljava/lang/String;", "BUNDLE_KEY_DEFAULT_PROVIDER", "BUNDLE_KEY_REQUEST_DISPLAY_INFO", "BUNDLE_KEY_USER_DISPLAY_NAME", "BUNDLE_KEY_USER_ID", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final DisplayInfo parseFromCredentialDataBundle(Bundle from) {
                Intrinsics.checkNotNullParameter(from, "");
                try {
                    Bundle bundle = from.getBundle(DisplayInfo.BUNDLE_KEY_REQUEST_DISPLAY_INFO);
                    Intrinsics.checkNotNull(bundle);
                    CharSequence charSequence = bundle.getCharSequence(DisplayInfo.BUNDLE_KEY_USER_ID);
                    CharSequence charSequence2 = bundle.getCharSequence(DisplayInfo.BUNDLE_KEY_USER_DISPLAY_NAME);
                    Icon icon = (Icon) bundle.getParcelable(DisplayInfo.BUNDLE_KEY_CREDENTIAL_TYPE_ICON);
                    String string = bundle.getString(DisplayInfo.BUNDLE_KEY_DEFAULT_PROVIDER);
                    Intrinsics.checkNotNull(charSequence);
                    return new DisplayInfo(charSequence, charSequence2, icon, string);
                } catch (Exception unused) {
                    return null;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J=\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e"}, d2 = {"Landroidx/credentials/CreateCredentialRequest$Companion;", "", "", "type", "Landroid/os/Bundle;", "credentialData", "candidateQueryData", "", "requireSystemProvider", "origin", "Landroidx/credentials/CreateCredentialRequest;", "createFrom", "(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;ZLjava/lang/String;)Landroidx/credentials/CreateCredentialRequest;", "BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", "Ljava/lang/String;", "BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CreateCredentialRequest createFrom$default(Companion companion, String str, Bundle bundle, Bundle bundle2, boolean z, String str2, int i, Object obj) {
            if ((i & 16) != 0) {
                str2 = null;
            }
            return companion.createFrom(str, bundle, bundle2, z, str2);
        }

        @JvmStatic
        public final CreateCredentialRequest createFrom(String type, Bundle credentialData, Bundle candidateQueryData, boolean requireSystemProvider, String origin) {
            Intrinsics.checkNotNullParameter(type, "");
            Intrinsics.checkNotNullParameter(credentialData, "");
            Intrinsics.checkNotNullParameter(candidateQueryData, "");
            try {
                if (Intrinsics.areEqual(type, PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    return CreatePasswordRequest.INSTANCE.createFrom$credentials_release(credentialData, origin, candidateQueryData);
                }
                if (Intrinsics.areEqual(type, PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                    String string = credentialData.getString(PublicKeyCredential.BUNDLE_KEY_SUBTYPE);
                    if (string != null && string.hashCode() == 589054771 && string.equals(CreatePublicKeyCredentialRequest.BUNDLE_VALUE_SUBTYPE_CREATE_PUBLIC_KEY_CREDENTIAL_REQUEST)) {
                        return CreatePublicKeyCredentialRequest.INSTANCE.createFrom$credentials_release(credentialData, origin, candidateQueryData);
                    }
                    throw new FrameworkClassParsingException();
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                DisplayInfo parseFromCredentialDataBundle = DisplayInfo.INSTANCE.parseFromCredentialDataBundle(credentialData);
                if (parseFromCredentialDataBundle == null) {
                    return null;
                }
                return new CreateCustomCredentialRequest(type, credentialData, candidateQueryData, requireSystemProvider, parseFromCredentialDataBundle, credentialData.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), origin, credentialData.getBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", false));
            }
        }
    }
}
