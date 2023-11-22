package id.dana.riskChallenges.ui.util;

import id.dana.data.foundation.RpcException;
import id.dana.network.exception.NetworkException;
import id.dana.utils.StringWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0019\u0010\t\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Throwable;)Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Lid/dana/network/exception/NetworkException;", "Lid/dana/utils/StringWrapper;", "p0", "getAuthRequestContext", "(Lid/dana/network/exception/NetworkException;Lid/dana/utils/StringWrapper;)Lid/dana/utils/StringWrapper;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StringWrapperExtKt {
    public static final StringWrapper getAuthRequestContext(NetworkException networkException, StringWrapper stringWrapper) {
        Intrinsics.checkNotNullParameter(networkException, "");
        Intrinsics.checkNotNullParameter(stringWrapper, "");
        String message = networkException.getMessage();
        return !(message == null || StringsKt.isBlank(message)) ? new StringWrapper.StringValue(networkException.getMessage()) : stringWrapper;
    }

    public static final String MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        if (th instanceof RpcException) {
            String str = ((RpcException) th).msg;
            return str == null ? KClassImpl$Data$declaredNonStaticMembers$2(th) : str;
        } else if (th instanceof NetworkException) {
            String message = th.getMessage();
            if (message == null) {
                message = ((NetworkException) th).getLocalizedMessage();
            }
            return message == null ? KClassImpl$Data$declaredNonStaticMembers$2(th) : message;
        } else {
            String message2 = th.getMessage();
            if (message2 == null) {
                message2 = th.getLocalizedMessage();
            }
            return message2 == null ? KClassImpl$Data$declaredNonStaticMembers$2(th) : message2;
        }
    }

    private static final String KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Throwable cause;
        Throwable cause2;
        String message;
        Throwable cause3 = th.getCause();
        if (cause3 == null || (message = cause3.getMessage()) == null) {
            Throwable cause4 = th.getCause();
            String localizedMessage = cause4 != null ? cause4.getLocalizedMessage() : null;
            if (localizedMessage == null) {
                Throwable cause5 = th.getCause();
                String message2 = (cause5 == null || (cause2 = cause5.getCause()) == null) ? null : cause2.getMessage();
                if (message2 == null) {
                    Throwable cause6 = th.getCause();
                    String localizedMessage2 = (cause6 == null || (cause = cause6.getCause()) == null) ? null : cause.getLocalizedMessage();
                    return localizedMessage2 == null ? "" : localizedMessage2;
                }
                return message2;
            }
            return localizedMessage;
        }
        return message;
    }

    public static final String PlaceComponentResult(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        if (th instanceof RpcException) {
            return ((RpcException) th).code;
        }
        if (th instanceof NetworkException) {
            return ((NetworkException) th).getErrorCode();
        }
        return null;
    }
}
