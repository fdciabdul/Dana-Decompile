package id.dana.data.here.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/here/model/HereAuthentication;", "", "", "isExpire", "()Z", "", "aMinute", "I", "", "accessToken", "Ljava/lang/String;", "getAccessToken", "()Ljava/lang/String;", "", "expireIn", "J", "getExpireIn", "()J", "<init>", "(Ljava/lang/String;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HereAuthentication {
    private final int aMinute;
    private final String accessToken;
    private final long expireIn;

    public HereAuthentication() {
        this(null, 0L, 3, null);
    }

    public HereAuthentication(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        this.accessToken = str;
        this.expireIn = j;
        this.aMinute = 60000;
    }

    public /* synthetic */ HereAuthentication(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j);
    }

    @JvmName(name = "getAccessToken")
    public final String getAccessToken() {
        return this.accessToken;
    }

    @JvmName(name = "getExpireIn")
    public final long getExpireIn() {
        return this.expireIn;
    }

    public final boolean isExpire() {
        return StringsKt.isBlank(this.accessToken) || System.currentTimeMillis() + ((long) this.aMinute) >= this.expireIn;
    }
}
