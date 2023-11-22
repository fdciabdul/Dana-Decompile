package androidx.credentials.provider;

import android.os.Build;
import android.os.Bundle;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import com.alibaba.ariver.kernel.RVParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0003\u0016\u0017\u0015BC\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Landroidx/credentials/provider/BeginGetCredentialResponse;", "", "", "Landroidx/credentials/provider/Action;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "Landroidx/credentials/provider/AuthenticationAction;", "authenticationActions", "getAuthenticationActions", "Landroidx/credentials/provider/CredentialEntry;", "credentialEntries", "getCredentialEntries", "Landroidx/credentials/provider/RemoteEntry;", "remoteEntry", "Landroidx/credentials/provider/RemoteEntry;", "getRemoteEntry", "()Landroidx/credentials/provider/RemoteEntry;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/credentials/provider/RemoteEntry;)V", "Companion", "Api34Impl", "Builder"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BeginGetCredentialResponse {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Action> actions;
    private final List<AuthenticationAction> authenticationActions;
    private final List<CredentialEntry> credentialEntries;
    private final RemoteEntry remoteEntry;

    public BeginGetCredentialResponse() {
        this(null, null, null, null, 15, null);
    }

    @JvmStatic
    public static final Bundle asBundle(BeginGetCredentialResponse beginGetCredentialResponse) {
        return INSTANCE.asBundle(beginGetCredentialResponse);
    }

    @JvmStatic
    public static final BeginGetCredentialResponse fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeginGetCredentialResponse(List<? extends CredentialEntry> list, List<Action> list2, List<AuthenticationAction> list3, RemoteEntry remoteEntry) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        this.credentialEntries = list;
        this.actions = list2;
        this.authenticationActions = list3;
        this.remoteEntry = remoteEntry;
    }

    public /* synthetic */ BeginGetCredentialResponse(List list, List list2, List list3, RemoteEntry remoteEntry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? null : remoteEntry);
    }

    @JvmName(name = "getCredentialEntries")
    public final List<CredentialEntry> getCredentialEntries() {
        return this.credentialEntries;
    }

    @JvmName(name = "getActions")
    public final List<Action> getActions() {
        return this.actions;
    }

    @JvmName(name = "getAuthenticationActions")
    public final List<AuthenticationAction> getAuthenticationActions() {
        return this.authenticationActions;
    }

    @JvmName(name = "getRemoteEntry")
    public final RemoteEntry getRemoteEntry() {
        return this.remoteEntry;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0011¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010!"}, d2 = {"Landroidx/credentials/provider/BeginGetCredentialResponse$Builder;", "", "Landroidx/credentials/provider/Action;", "action", "addAction", "(Landroidx/credentials/provider/Action;)Landroidx/credentials/provider/BeginGetCredentialResponse$Builder;", "Landroidx/credentials/provider/AuthenticationAction;", "authenticationAction", "addAuthenticationAction", "(Landroidx/credentials/provider/AuthenticationAction;)Landroidx/credentials/provider/BeginGetCredentialResponse$Builder;", "Landroidx/credentials/provider/CredentialEntry;", RVParams.LONG_URL_WITH_ENTRY_KEY, "addCredentialEntry", "(Landroidx/credentials/provider/CredentialEntry;)Landroidx/credentials/provider/BeginGetCredentialResponse$Builder;", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "build", "()Landroidx/credentials/provider/BeginGetCredentialResponse;", "", "actions", "setActions", "(Ljava/util/List;)Landroidx/credentials/provider/BeginGetCredentialResponse$Builder;", "authenticationEntries", "setAuthenticationActions", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "setCredentialEntries", "Landroidx/credentials/provider/RemoteEntry;", "remoteEntry", "setRemoteEntry", "(Landroidx/credentials/provider/RemoteEntry;)Landroidx/credentials/provider/BeginGetCredentialResponse$Builder;", "", "Ljava/util/List;", "authenticationActions", "credentialEntries", "Landroidx/credentials/provider/RemoteEntry;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private RemoteEntry remoteEntry;
        private List<CredentialEntry> credentialEntries = new ArrayList();
        private List<Action> actions = new ArrayList();
        private List<AuthenticationAction> authenticationActions = new ArrayList();

        public final Builder setRemoteEntry(RemoteEntry remoteEntry) {
            this.remoteEntry = remoteEntry;
            return this;
        }

        public final Builder addCredentialEntry(CredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "");
            this.credentialEntries.add(entry);
            return this;
        }

        public final Builder setCredentialEntries(List<? extends CredentialEntry> entries) {
            Intrinsics.checkNotNullParameter(entries, "");
            this.credentialEntries = CollectionsKt.toMutableList((Collection) entries);
            return this;
        }

        public final Builder addAction(Action action) {
            Intrinsics.checkNotNullParameter(action, "");
            this.actions.add(action);
            return this;
        }

        public final Builder setActions(List<Action> actions) {
            Intrinsics.checkNotNullParameter(actions, "");
            this.actions = CollectionsKt.toMutableList((Collection) actions);
            return this;
        }

        public final Builder addAuthenticationAction(AuthenticationAction authenticationAction) {
            Intrinsics.checkNotNullParameter(authenticationAction, "");
            this.authenticationActions.add(authenticationAction);
            return this;
        }

        public final Builder setAuthenticationActions(List<AuthenticationAction> authenticationEntries) {
            Intrinsics.checkNotNullParameter(authenticationEntries, "");
            this.authenticationActions = CollectionsKt.toMutableList((Collection) authenticationEntries);
            return this;
        }

        public final BeginGetCredentialResponse build() {
            return new BeginGetCredentialResponse(CollectionsKt.toList(this.credentialEntries), CollectionsKt.toList(this.actions), CollectionsKt.toList(this.authenticationActions), this.remoteEntry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Landroidx/credentials/provider/BeginGetCredentialResponse$Api34Impl;", "", "Landroid/os/Bundle;", HummerConstants.BUNDLE, "Landroidx/credentials/provider/BeginGetCredentialResponse;", "response", "", "asBundle", "(Landroid/os/Bundle;Landroidx/credentials/provider/BeginGetCredentialResponse;)V", "fromBundle", "(Landroid/os/Bundle;)Landroidx/credentials/provider/BeginGetCredentialResponse;", "", "REQUEST_KEY", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();
        private static final String REQUEST_KEY = "androidx.credentials.provider.BeginGetCredentialResponse";

        private Api34Impl() {
        }

        @JvmStatic
        public static final void asBundle(Bundle bundle, BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(response, "");
            bundle.putParcelable(REQUEST_KEY, BeginGetCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
        }

        @JvmStatic
        public static final BeginGetCredentialResponse fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "");
            android.service.credentials.BeginGetCredentialResponse beginGetCredentialResponse = (android.service.credentials.BeginGetCredentialResponse) bundle.getParcelable(REQUEST_KEY, android.service.credentials.BeginGetCredentialResponse.class);
            if (beginGetCredentialResponse != null) {
                return BeginGetCredentialUtil.INSTANCE.convertToJetpackResponse(beginGetCredentialResponse);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/credentials/provider/BeginGetCredentialResponse$Companion;", "", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "response", "Landroid/os/Bundle;", "asBundle", "(Landroidx/credentials/provider/BeginGetCredentialResponse;)Landroid/os/Bundle;", HummerConstants.BUNDLE, "fromBundle", "(Landroid/os/Bundle;)Landroidx/credentials/provider/BeginGetCredentialResponse;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Bundle asBundle(BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "");
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 34) {
                Api34Impl.asBundle(bundle, response);
            }
            return bundle;
        }

        @JvmStatic
        public final BeginGetCredentialResponse fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.fromBundle(bundle);
            }
            return null;
        }
    }
}
