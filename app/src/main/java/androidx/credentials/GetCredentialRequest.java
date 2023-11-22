package androidx.credentials;

import android.content.ComponentName;
import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001aBA\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017"}, d2 = {"Landroidx/credentials/GetCredentialRequest;", "", "", "Landroidx/credentials/CredentialOption;", "credentialOptions", "Ljava/util/List;", "getCredentialOptions", "()Ljava/util/List;", "", "origin", "Ljava/lang/String;", "getOrigin", "()Ljava/lang/String;", "", "preferIdentityDocUi", "Z", "getPreferIdentityDocUi", "()Z", "preferImmediatelyAvailableCredentials", "Landroid/content/ComponentName;", "preferUiBrandingComponentName", "Landroid/content/ComponentName;", "getPreferUiBrandingComponentName", "()Landroid/content/ComponentName;", "<init>", "(Ljava/util/List;Ljava/lang/String;ZLandroid/content/ComponentName;Z)V", "Companion", "Builder"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetCredentialRequest {
    private static final String BUNDLE_KEY_PREFER_IDENTITY_DOC_UI = "androidx.credentials.BUNDLE_KEY_PREFER_IDENTITY_DOC_UI";
    public static final String BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS = "androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS";
    private static final String BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME = "androidx.credentials.BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<CredentialOption> credentialOptions;
    private final String origin;
    private final boolean preferIdentityDocUi;
    private final boolean preferImmediatelyAvailableCredentials;
    private final ComponentName preferUiBrandingComponentName;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetCredentialRequest(List<? extends CredentialOption> list) {
        this(list, null, false, null, false, 30, null);
        Intrinsics.checkNotNullParameter(list, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetCredentialRequest(List<? extends CredentialOption> list, String str) {
        this(list, str, false, null, false, 28, null);
        Intrinsics.checkNotNullParameter(list, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetCredentialRequest(List<? extends CredentialOption> list, String str, boolean z) {
        this(list, str, z, null, false, 24, null);
        Intrinsics.checkNotNullParameter(list, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetCredentialRequest(List<? extends CredentialOption> list, String str, boolean z, ComponentName componentName) {
        this(list, str, z, componentName, false, 16, null);
        Intrinsics.checkNotNullParameter(list, "");
    }

    @JvmStatic
    public static final GetCredentialRequest createFrom(List<? extends CredentialOption> list, String str, Bundle bundle) {
        return INSTANCE.createFrom(list, str, bundle);
    }

    @JvmStatic
    public static final Bundle toRequestDataBundle(GetCredentialRequest getCredentialRequest) {
        return INSTANCE.toRequestDataBundle(getCredentialRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetCredentialRequest(List<? extends CredentialOption> list, String str, boolean z, ComponentName componentName, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "");
        this.credentialOptions = list;
        this.origin = str;
        this.preferIdentityDocUi = z;
        this.preferUiBrandingComponentName = componentName;
        this.preferImmediatelyAvailableCredentials = z2;
        if ((!list.isEmpty()) != true) {
            throw new IllegalArgumentException("credentialOptions should not be empty".toString());
        }
    }

    public /* synthetic */ GetCredentialRequest(List list, String str, boolean z, ComponentName componentName, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : componentName, (i & 16) != 0 ? false : z2);
    }

    @JvmName(name = "getCredentialOptions")
    public final List<CredentialOption> getCredentialOptions() {
        return this.credentialOptions;
    }

    @JvmName(name = "getOrigin")
    public final String getOrigin() {
        return this.origin;
    }

    @JvmName(name = "getPreferIdentityDocUi")
    public final boolean getPreferIdentityDocUi() {
        return this.preferIdentityDocUi;
    }

    @JvmName(name = "getPreferUiBrandingComponentName")
    public final ComponentName getPreferUiBrandingComponentName() {
        return this.preferUiBrandingComponentName;
    }

    @JvmName(name = "preferImmediatelyAvailableCredentials")
    /* renamed from: preferImmediatelyAvailableCredentials  reason: from getter */
    public final boolean getPreferImmediatelyAvailableCredentials() {
        return this.preferImmediatelyAvailableCredentials;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Landroidx/credentials/GetCredentialRequest$Builder;", "", "Landroidx/credentials/CredentialOption;", "credentialOption", "addCredentialOption", "(Landroidx/credentials/CredentialOption;)Landroidx/credentials/GetCredentialRequest$Builder;", "Landroidx/credentials/GetCredentialRequest;", "build", "()Landroidx/credentials/GetCredentialRequest;", "", "credentialOptions", "setCredentialOptions", "(Ljava/util/List;)Landroidx/credentials/GetCredentialRequest$Builder;", "", "origin", "setOrigin", "(Ljava/lang/String;)Landroidx/credentials/GetCredentialRequest$Builder;", "", "preferIdentityDocUi", "setPreferIdentityDocUi", "(Z)Landroidx/credentials/GetCredentialRequest$Builder;", "preferImmediatelyAvailableCredentials", "setPreferImmediatelyAvailableCredentials", "Landroid/content/ComponentName;", "component", "setPreferUiBrandingComponentName", "(Landroid/content/ComponentName;)Landroidx/credentials/GetCredentialRequest$Builder;", "", "Ljava/util/List;", "Ljava/lang/String;", "Z", "preferUiBrandingComponentName", "Landroid/content/ComponentName;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private List<CredentialOption> credentialOptions = new ArrayList();
        private String origin;
        private boolean preferIdentityDocUi;
        private boolean preferImmediatelyAvailableCredentials;
        private ComponentName preferUiBrandingComponentName;

        public final Builder addCredentialOption(CredentialOption credentialOption) {
            Intrinsics.checkNotNullParameter(credentialOption, "");
            this.credentialOptions.add(credentialOption);
            return this;
        }

        public final Builder setCredentialOptions(List<? extends CredentialOption> credentialOptions) {
            Intrinsics.checkNotNullParameter(credentialOptions, "");
            this.credentialOptions = CollectionsKt.toMutableList((Collection) credentialOptions);
            return this;
        }

        public final Builder setOrigin(String origin) {
            Intrinsics.checkNotNullParameter(origin, "");
            this.origin = origin;
            return this;
        }

        public final Builder setPreferImmediatelyAvailableCredentials(boolean preferImmediatelyAvailableCredentials) {
            this.preferImmediatelyAvailableCredentials = preferImmediatelyAvailableCredentials;
            return this;
        }

        public final Builder setPreferUiBrandingComponentName(ComponentName component) {
            this.preferUiBrandingComponentName = component;
            return this;
        }

        public final Builder setPreferIdentityDocUi(boolean preferIdentityDocUi) {
            this.preferIdentityDocUi = preferIdentityDocUi;
            return this;
        }

        public final GetCredentialRequest build() {
            return new GetCredentialRequest(CollectionsKt.toList(this.credentialOptions), this.origin, this.preferIdentityDocUi, this.preferUiBrandingComponentName, this.preferImmediatelyAvailableCredentials);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010"}, d2 = {"Landroidx/credentials/GetCredentialRequest$Companion;", "", "", "Landroidx/credentials/CredentialOption;", "credentialOptions", "", "origin", "Landroid/os/Bundle;", "data", "Landroidx/credentials/GetCredentialRequest;", "createFrom", "(Ljava/util/List;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/credentials/GetCredentialRequest;", "request", "toRequestDataBundle", "(Landroidx/credentials/GetCredentialRequest;)Landroid/os/Bundle;", "BUNDLE_KEY_PREFER_IDENTITY_DOC_UI", "Ljava/lang/String;", "BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", "BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Bundle toRequestDataBundle(GetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "");
            Bundle bundle = new Bundle();
            bundle.putBoolean(GetCredentialRequest.BUNDLE_KEY_PREFER_IDENTITY_DOC_UI, request.getPreferIdentityDocUi());
            bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", request.getPreferImmediatelyAvailableCredentials());
            bundle.putParcelable(GetCredentialRequest.BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME, request.getPreferUiBrandingComponentName());
            return bundle;
        }

        @JvmStatic
        public final GetCredentialRequest createFrom(List<? extends CredentialOption> credentialOptions, String origin, Bundle data) {
            Intrinsics.checkNotNullParameter(credentialOptions, "");
            Intrinsics.checkNotNullParameter(data, "");
            try {
                boolean z = data.getBoolean(GetCredentialRequest.BUNDLE_KEY_PREFER_IDENTITY_DOC_UI);
                Builder preferImmediatelyAvailableCredentials = new Builder().setCredentialOptions(credentialOptions).setPreferIdentityDocUi(z).setPreferUiBrandingComponentName((ComponentName) data.getParcelable(GetCredentialRequest.BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME)).setPreferImmediatelyAvailableCredentials(data.getBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS"));
                if (origin != null) {
                    preferImmediatelyAvailableCredentials.setOrigin(origin);
                }
                return preferImmediatelyAvailableCredentials.build();
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }
    }
}
