package androidx.credentials.provider;

import android.os.Build;
import android.os.Bundle;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0003\u0010\u0011\u000fB#\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/credentials/provider/BeginCreateCredentialResponse;", "", "", "Landroidx/credentials/provider/CreateEntry;", "createEntries", "Ljava/util/List;", "getCreateEntries", "()Ljava/util/List;", "Landroidx/credentials/provider/RemoteEntry;", "remoteEntry", "Landroidx/credentials/provider/RemoteEntry;", "getRemoteEntry", "()Landroidx/credentials/provider/RemoteEntry;", "<init>", "(Ljava/util/List;Landroidx/credentials/provider/RemoteEntry;)V", "Companion", "Api34Impl", "Builder"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BeginCreateCredentialResponse {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<CreateEntry> createEntries;
    private final RemoteEntry remoteEntry;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, androidx.credentials.provider.RemoteEntry, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BeginCreateCredentialResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.BeginCreateCredentialResponse.<init>():void");
    }

    @JvmStatic
    public static final Bundle asBundle(BeginCreateCredentialResponse beginCreateCredentialResponse) {
        return INSTANCE.asBundle(beginCreateCredentialResponse);
    }

    @JvmStatic
    public static final BeginCreateCredentialResponse fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    public BeginCreateCredentialResponse(List<CreateEntry> list, RemoteEntry remoteEntry) {
        Intrinsics.checkNotNullParameter(list, "");
        this.createEntries = list;
        this.remoteEntry = remoteEntry;
    }

    public /* synthetic */ BeginCreateCredentialResponse(List list, RemoteEntry remoteEntry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : remoteEntry);
    }

    @JvmName(name = "getCreateEntries")
    public final List<CreateEntry> getCreateEntries() {
        return this.createEntries;
    }

    @JvmName(name = "getRemoteEntry")
    public final RemoteEntry getRemoteEntry() {
        return this.remoteEntry;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013"}, d2 = {"Landroidx/credentials/provider/BeginCreateCredentialResponse$Builder;", "", "Landroidx/credentials/provider/CreateEntry;", "createEntry", "addCreateEntry", "(Landroidx/credentials/provider/CreateEntry;)Landroidx/credentials/provider/BeginCreateCredentialResponse$Builder;", "Landroidx/credentials/provider/BeginCreateCredentialResponse;", "build", "()Landroidx/credentials/provider/BeginCreateCredentialResponse;", "", "createEntries", "setCreateEntries", "(Ljava/util/List;)Landroidx/credentials/provider/BeginCreateCredentialResponse$Builder;", "Landroidx/credentials/provider/RemoteEntry;", "remoteEntry", "setRemoteEntry", "(Landroidx/credentials/provider/RemoteEntry;)Landroidx/credentials/provider/BeginCreateCredentialResponse$Builder;", "", "Ljava/util/List;", "Landroidx/credentials/provider/RemoteEntry;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private List<CreateEntry> createEntries = new ArrayList();
        private RemoteEntry remoteEntry;

        public final Builder setCreateEntries(List<CreateEntry> createEntries) {
            Intrinsics.checkNotNullParameter(createEntries, "");
            this.createEntries = CollectionsKt.toMutableList((Collection) createEntries);
            return this;
        }

        public final Builder addCreateEntry(CreateEntry createEntry) {
            Intrinsics.checkNotNullParameter(createEntry, "");
            this.createEntries.add(createEntry);
            return this;
        }

        public final Builder setRemoteEntry(RemoteEntry remoteEntry) {
            this.remoteEntry = remoteEntry;
            return this;
        }

        public final BeginCreateCredentialResponse build() {
            return new BeginCreateCredentialResponse(CollectionsKt.toList(this.createEntries), this.remoteEntry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Landroidx/credentials/provider/BeginCreateCredentialResponse$Api34Impl;", "", "Landroid/os/Bundle;", HummerConstants.BUNDLE, "Landroidx/credentials/provider/BeginCreateCredentialResponse;", "response", "", "asBundle", "(Landroid/os/Bundle;Landroidx/credentials/provider/BeginCreateCredentialResponse;)V", "fromBundle", "(Landroid/os/Bundle;)Landroidx/credentials/provider/BeginCreateCredentialResponse;", "", "REQUEST_KEY", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();
        private static final String REQUEST_KEY = "androidx.credentials.provider.BeginCreateCredentialResponse";

        private Api34Impl() {
        }

        @JvmStatic
        public static final void asBundle(Bundle bundle, BeginCreateCredentialResponse response) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(response, "");
            bundle.putParcelable(REQUEST_KEY, BeginCreateCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
        }

        @JvmStatic
        public static final BeginCreateCredentialResponse fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "");
            android.service.credentials.BeginCreateCredentialResponse beginCreateCredentialResponse = (android.service.credentials.BeginCreateCredentialResponse) bundle.getParcelable(REQUEST_KEY, android.service.credentials.BeginCreateCredentialResponse.class);
            if (beginCreateCredentialResponse != null) {
                return BeginCreateCredentialUtil.INSTANCE.convertToJetpackResponse(beginCreateCredentialResponse);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/credentials/provider/BeginCreateCredentialResponse$Companion;", "", "Landroidx/credentials/provider/BeginCreateCredentialResponse;", "response", "Landroid/os/Bundle;", "asBundle", "(Landroidx/credentials/provider/BeginCreateCredentialResponse;)Landroid/os/Bundle;", HummerConstants.BUNDLE, "fromBundle", "(Landroid/os/Bundle;)Landroidx/credentials/provider/BeginCreateCredentialResponse;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Bundle asBundle(BeginCreateCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "");
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 34) {
                Api34Impl.asBundle(bundle, response);
            }
            return bundle;
        }

        @JvmStatic
        public final BeginCreateCredentialResponse fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.fromBundle(bundle);
            }
            return null;
        }
    }
}
