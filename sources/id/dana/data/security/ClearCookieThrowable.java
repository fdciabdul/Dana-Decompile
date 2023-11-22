package id.dana.data.security;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/security/ClearCookieThrowable;", "", "throwable", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClearCookieThrowable extends Throwable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearCookieThrowable(Throwable th) {
        super(th);
        Intrinsics.checkNotNullParameter(th, "");
    }
}
