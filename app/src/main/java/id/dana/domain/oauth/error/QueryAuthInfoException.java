package id.dana.domain.oauth.error;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\u0007R\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/oauth/error/QueryAuthInfoException;", "", "throwable", "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "setThrowable", "(Ljava/lang/Throwable;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryAuthInfoException extends Throwable {
    private Throwable throwable;

    public QueryAuthInfoException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        this.throwable = th;
    }

    @JvmName(name = "getThrowable")
    public final Throwable getThrowable() {
        return this.throwable;
    }

    @JvmName(name = "setThrowable")
    public final void setThrowable(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        this.throwable = th;
    }
}
