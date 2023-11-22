package id.dana.onboarding.splash;

import com.huawei.hms.push.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/onboarding/splash/SslPinningException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", e.PlaceComponentResult, "<init>", "(Ljava/lang/Exception;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SslPinningException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SslPinningException(Exception exc) {
        super(exc);
        Intrinsics.checkNotNullParameter(exc, "");
    }
}
