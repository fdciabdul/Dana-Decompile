package androidx.credentials.provider;

import android.app.slice.Slice;
import android.app.slice.SliceSpec;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import com.alibaba.ariver.kernel.RVParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/credentials/provider/CredentialEntry;", "", "Landroidx/credentials/provider/BeginGetCredentialOption;", "beginGetCredentialOption", "Landroidx/credentials/provider/BeginGetCredentialOption;", "getBeginGetCredentialOption", "()Landroidx/credentials/provider/BeginGetCredentialOption;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Landroidx/credentials/provider/BeginGetCredentialOption;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class CredentialEntry {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BeginGetCredentialOption beginGetCredentialOption;
    private final String type;

    public CredentialEntry(String str, BeginGetCredentialOption beginGetCredentialOption) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption, "");
        this.type = str;
        this.beginGetCredentialOption = beginGetCredentialOption;
    }

    @JvmName(name = "getType")
    public String getType() {
        return this.type;
    }

    @JvmName(name = "getBeginGetCredentialOption")
    public final BeginGetCredentialOption getBeginGetCredentialOption() {
        return this.beginGetCredentialOption;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/credentials/provider/CredentialEntry$Companion;", "", "Landroid/app/slice/Slice;", "slice", "Landroidx/credentials/provider/CredentialEntry;", "createFrom$credentials_release", "(Landroid/app/slice/Slice;)Landroidx/credentials/provider/CredentialEntry;", RVParams.LONG_URL_WITH_ENTRY_KEY, "toSlice$credentials_release", "(Landroidx/credentials/provider/CredentialEntry;)Landroid/app/slice/Slice;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CredentialEntry createFrom$credentials_release(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "");
            try {
                SliceSpec spec = slice.getSpec();
                String type = spec != null ? spec.getType() : null;
                if (Intrinsics.areEqual(type, PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    PasswordCredentialEntry fromSlice = PasswordCredentialEntry.INSTANCE.fromSlice(slice);
                    Intrinsics.checkNotNull(fromSlice);
                    return fromSlice;
                } else if (Intrinsics.areEqual(type, PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                    PublicKeyCredentialEntry fromSlice2 = PublicKeyCredentialEntry.INSTANCE.fromSlice(slice);
                    Intrinsics.checkNotNull(fromSlice2);
                    return fromSlice2;
                } else {
                    CustomCredentialEntry fromSlice3 = CustomCredentialEntry.INSTANCE.fromSlice(slice);
                    Intrinsics.checkNotNull(fromSlice3);
                    return fromSlice3;
                }
            } catch (Exception unused) {
                return CustomCredentialEntry.INSTANCE.fromSlice(slice);
            }
        }

        @JvmStatic
        public final Slice toSlice$credentials_release(CredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "");
            if (entry instanceof PasswordCredentialEntry) {
                return PasswordCredentialEntry.INSTANCE.toSlice((PasswordCredentialEntry) entry);
            }
            if (entry instanceof PublicKeyCredentialEntry) {
                return PublicKeyCredentialEntry.INSTANCE.toSlice((PublicKeyCredentialEntry) entry);
            }
            if (entry instanceof CustomCredentialEntry) {
                return CustomCredentialEntry.INSTANCE.toSlice((CustomCredentialEntry) entry);
            }
            return null;
        }
    }
}
