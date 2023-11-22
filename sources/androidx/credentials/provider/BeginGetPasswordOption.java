package androidx.credentials.provider;

import android.os.Bundle;
import androidx.credentials.GetPasswordOption;
import androidx.credentials.PasswordCredential;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/credentials/provider/BeginGetPasswordOption;", "Landroidx/credentials/provider/BeginGetCredentialOption;", "", "", "allowedUserIds", "Ljava/util/Set;", "getAllowedUserIds", "()Ljava/util/Set;", "Landroid/os/Bundle;", "candidateQueryData", "id", "<init>", "(Ljava/util/Set;Landroid/os/Bundle;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BeginGetPasswordOption extends BeginGetCredentialOption {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Set<String> allowedUserIds;

    @JvmStatic
    public static final BeginGetPasswordOption createForTest(Bundle bundle, String str) {
        return INSTANCE.createForTest(bundle, str);
    }

    @JvmName(name = "getAllowedUserIds")
    public final Set<String> getAllowedUserIds() {
        return this.allowedUserIds;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeginGetPasswordOption(Set<String> set, Bundle bundle, String str) {
        super(str, PasswordCredential.TYPE_PASSWORD_CREDENTIAL, bundle);
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.allowedUserIds = set;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\b"}, d2 = {"Landroidx/credentials/provider/BeginGetPasswordOption$Companion;", "", "Landroid/os/Bundle;", "data", "", "id", "Landroidx/credentials/provider/BeginGetPasswordOption;", "createForTest", "(Landroid/os/Bundle;Ljava/lang/String;)Landroidx/credentials/provider/BeginGetPasswordOption;", "createFrom$credentials_release", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BeginGetPasswordOption createForTest(Bundle data, String id2) {
            Intrinsics.checkNotNullParameter(data, "");
            Intrinsics.checkNotNullParameter(id2, "");
            return createFrom$credentials_release(data, id2);
        }

        public final BeginGetPasswordOption createFrom$credentials_release(Bundle data, String id2) {
            Set emptySet;
            Intrinsics.checkNotNullParameter(data, "");
            Intrinsics.checkNotNullParameter(id2, "");
            ArrayList<String> stringArrayList = data.getStringArrayList(GetPasswordOption.BUNDLE_KEY_ALLOWED_USER_IDS);
            if (stringArrayList == null || (emptySet = CollectionsKt.toSet(stringArrayList)) == null) {
                emptySet = SetsKt.emptySet();
            }
            return new BeginGetPasswordOption(emptySet, data, id2);
        }
    }
}
