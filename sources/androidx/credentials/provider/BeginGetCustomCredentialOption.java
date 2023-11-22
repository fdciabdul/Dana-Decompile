package androidx.credentials.provider;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/credentials/provider/BeginGetCustomCredentialOption;", "Landroidx/credentials/provider/BeginGetCredentialOption;", "", "id", "type", "Landroid/os/Bundle;", "candidateQueryData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public class BeginGetCustomCredentialOption extends BeginGetCredentialOption {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeginGetCustomCredentialOption(String str, String str2, Bundle bundle) {
        super(str, str2, bundle);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("id should not be empty".toString());
        }
        if (!(str2.length() > 0)) {
            throw new IllegalArgumentException("type should not be empty".toString());
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\n\u0010\t"}, d2 = {"Landroidx/credentials/provider/BeginGetCustomCredentialOption$Companion;", "", "Landroid/os/Bundle;", "data", "", "id", "type", "Landroidx/credentials/provider/BeginGetCustomCredentialOption;", "createFrom$credentials_release", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Landroidx/credentials/provider/BeginGetCustomCredentialOption;", "createFromEntrySlice$credentials_release", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BeginGetCustomCredentialOption createFrom$credentials_release(Bundle data, String id2, String type) {
            Intrinsics.checkNotNullParameter(data, "");
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(type, "");
            return new BeginGetCustomCredentialOption(id2, type, data);
        }

        @JvmStatic
        public final BeginGetCustomCredentialOption createFromEntrySlice$credentials_release(Bundle data, String id2, String type) {
            Intrinsics.checkNotNullParameter(data, "");
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(type, "");
            return new BeginGetCustomCredentialOption(id2, type, data);
        }
    }
}
