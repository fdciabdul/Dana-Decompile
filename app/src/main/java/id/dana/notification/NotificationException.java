package id.dana.notification;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/notification/NotificationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class NotificationException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationException(Throwable th) {
        super(th);
        Intrinsics.checkNotNullParameter(th, "");
    }
}
