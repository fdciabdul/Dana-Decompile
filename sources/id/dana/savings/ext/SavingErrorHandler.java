package id.dana.savings.ext;

import com.alipay.imobile.network.quake.exception.ClientException;
import id.dana.network.base.ConnectionExceptionParserKt;
import id.dana.network.exception.NetworkException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/savings/ext/SavingErrorHandler;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Throwable;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingErrorHandler {
    public static final SavingErrorHandler INSTANCE = new SavingErrorHandler();

    private SavingErrorHandler() {
    }

    public static String BuiltInFictitiousFunctionClassFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof NetworkException) {
            String errorCode = ((NetworkException) p0).getErrorCode();
            Intrinsics.checkNotNullExpressionValue(errorCode, "");
            return errorCode;
        }
        if (p0 instanceof ClientException) {
            String message = p0.getMessage();
            boolean z = false;
            if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) ConnectionExceptionParserKt.NETWORK_IS_NOT_AVAILABLE, false, 2, (Object) null)) {
                z = true;
            }
            if (z) {
                return "NETWORK_ERROR";
            }
        }
        return "";
    }
}
