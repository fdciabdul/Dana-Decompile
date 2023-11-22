package id.dana.domain.donation.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f"}, d2 = {"Lid/dana/domain/donation/model/RedirectValue;", "", "", "agreed", "Z", "getAgreed", "()Z", "setAgreed", "(Z)V", "", "cliendId", "Ljava/lang/String;", "getCliendId", "()Ljava/lang/String;", "setCliendId", "(Ljava/lang/String;)V", "scopes", "getScopes", "setScopes", "url", "getUrl", "setUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class RedirectValue {
    private boolean agreed;
    private String cliendId;
    private String scopes;
    private String url;

    public RedirectValue() {
        this(null, null, false, null, 15, null);
    }

    public RedirectValue(String str, String str2, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.cliendId = str;
        this.scopes = str2;
        this.agreed = z;
        this.url = str3;
    }

    public /* synthetic */ RedirectValue(String str, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str3);
    }

    @JvmName(name = "getCliendId")
    public final String getCliendId() {
        return this.cliendId;
    }

    @JvmName(name = "setCliendId")
    public final void setCliendId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cliendId = str;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "setScopes")
    public final void setScopes(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.scopes = str;
    }

    @JvmName(name = "getAgreed")
    public final boolean getAgreed() {
        return this.agreed;
    }

    @JvmName(name = "setAgreed")
    public final void setAgreed(boolean z) {
        this.agreed = z;
    }

    @JvmName(name = "getUrl")
    public final String getUrl() {
        return this.url;
    }

    @JvmName(name = "setUrl")
    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.url = str;
    }
}
