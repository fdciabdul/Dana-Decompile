package androidx.credentials.provider;

import androidx.credentials.CredentialOption;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/credentials/provider/ProviderGetCredentialRequest;", "", "Landroidx/credentials/provider/CallingAppInfo;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "getCallingAppInfo", "()Landroidx/credentials/provider/CallingAppInfo;", "", "Landroidx/credentials/CredentialOption;", "credentialOptions", "Ljava/util/List;", "getCredentialOptions", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Landroidx/credentials/provider/CallingAppInfo;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ProviderGetCredentialRequest {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CallingAppInfo callingAppInfo;
    private final List<CredentialOption> credentialOptions;

    /* JADX WARN: Multi-variable type inference failed */
    public ProviderGetCredentialRequest(List<? extends CredentialOption> list, CallingAppInfo callingAppInfo) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(callingAppInfo, "");
        this.credentialOptions = list;
        this.callingAppInfo = callingAppInfo;
    }

    @JvmName(name = "getCredentialOptions")
    public final List<CredentialOption> getCredentialOptions() {
        return this.credentialOptions;
    }

    @JvmName(name = "getCallingAppInfo")
    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/credentials/provider/ProviderGetCredentialRequest$Companion;", "", "", "Landroidx/credentials/CredentialOption;", SecurityConstants.KEY_OPTIONS, "Landroidx/credentials/provider/CallingAppInfo;", "callingAppInfo", "Landroidx/credentials/provider/ProviderGetCredentialRequest;", "createFrom$credentials_release", "(Ljava/util/List;Landroidx/credentials/provider/CallingAppInfo;)Landroidx/credentials/provider/ProviderGetCredentialRequest;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ProviderGetCredentialRequest createFrom$credentials_release(List<? extends CredentialOption> options, CallingAppInfo callingAppInfo) {
            Intrinsics.checkNotNullParameter(options, "");
            Intrinsics.checkNotNullParameter(callingAppInfo, "");
            return new ProviderGetCredentialRequest(options, callingAppInfo);
        }
    }
}
