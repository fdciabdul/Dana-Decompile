package androidx.credentials;

import android.content.ComponentName;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B3\b\u0016\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002¢\u0006\u0004\b\f\u0010\rB=\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/credentials/GetPasswordOption;", "Landroidx/credentials/CredentialOption;", "", "", "allowedUserIds", "Ljava/util/Set;", "getAllowedUserIds", "()Ljava/util/Set;", "", "isAutoSelectAllowed", "Landroid/content/ComponentName;", "allowedProviders", "<init>", "(Ljava/util/Set;ZLjava/util/Set;)V", "Landroid/os/Bundle;", "requestData", "candidateQueryData", "(Ljava/util/Set;ZLjava/util/Set;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetPasswordOption extends CredentialOption {
    public static final String BUNDLE_KEY_ALLOWED_USER_IDS = "androidx.credentials.BUNDLE_KEY_ALLOWED_USER_IDS";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Set<String> allowedUserIds;

    public GetPasswordOption() {
        this((Set) null, false, (Set) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetPasswordOption(Set<String> set) {
        this((Set) set, false, (Set) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(set, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetPasswordOption(Set<String> set, boolean z) {
        this(set, z, (Set) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(set, "");
    }

    public /* synthetic */ GetPasswordOption(Set set, boolean z, Set set2, Bundle bundle, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, z, set2, bundle, bundle2);
    }

    @JvmName(name = "getAllowedUserIds")
    public final Set<String> getAllowedUserIds() {
        return this.allowedUserIds;
    }

    private GetPasswordOption(Set<String> set, boolean z, Set<ComponentName> set2, Bundle bundle, Bundle bundle2) {
        super(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, bundle, bundle2, false, z, set2);
        this.allowedUserIds = set;
    }

    public /* synthetic */ GetPasswordOption(Set set, boolean z, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? false : z, (i & 4) != 0 ? SetsKt.emptySet() : set2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetPasswordOption(java.util.Set<java.lang.String> r8, boolean r9, java.util.Set<android.content.ComponentName> r10) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.credentials.GetPasswordOption$Companion r0 = androidx.credentials.GetPasswordOption.INSTANCE
            android.os.Bundle r5 = r0.toBundle$credentials_release(r8)
            android.os.Bundle r6 = r0.toBundle$credentials_release(r8)
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.GetPasswordOption.<init>(java.util.Set, boolean, java.util.Set):void");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u000b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Landroidx/credentials/GetPasswordOption$Companion;", "", "Landroid/os/Bundle;", "data", "", "Landroid/content/ComponentName;", "allowedProviders", "candidateQueryData", "Landroidx/credentials/GetPasswordOption;", "createFrom$credentials_release", "(Landroid/os/Bundle;Ljava/util/Set;Landroid/os/Bundle;)Landroidx/credentials/GetPasswordOption;", "", "allowUserIds", "toBundle$credentials_release", "(Ljava/util/Set;)Landroid/os/Bundle;", "BUNDLE_KEY_ALLOWED_USER_IDS", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GetPasswordOption createFrom$credentials_release(Bundle data, Set<ComponentName> allowedProviders, Bundle candidateQueryData) {
            Set emptySet;
            Intrinsics.checkNotNullParameter(data, "");
            Intrinsics.checkNotNullParameter(allowedProviders, "");
            Intrinsics.checkNotNullParameter(candidateQueryData, "");
            ArrayList<String> stringArrayList = data.getStringArrayList(GetPasswordOption.BUNDLE_KEY_ALLOWED_USER_IDS);
            if (stringArrayList == null || (emptySet = CollectionsKt.toSet(stringArrayList)) == null) {
                emptySet = SetsKt.emptySet();
            }
            return new GetPasswordOption(emptySet, data.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), allowedProviders, data, candidateQueryData, null);
        }

        @JvmStatic
        public final Bundle toBundle$credentials_release(Set<String> allowUserIds) {
            Intrinsics.checkNotNullParameter(allowUserIds, "");
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(GetPasswordOption.BUNDLE_KEY_ALLOWED_USER_IDS, new ArrayList<>(allowUserIds));
            return bundle;
        }
    }
}
