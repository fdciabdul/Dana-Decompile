package id.dana.requestmoney.util;

import com.alipay.mobile.common.rpc.RpcException;
import id.dana.R;
import id.dana.core.ui.model.UiTextModel;
import id.dana.data.network.exception.NoNetworkException;
import id.dana.network.exception.NetworkException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0013\u0010\n\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\b"}, d2 = {"Lid/dana/requestmoney/util/RequestMoneyErrorHelper;", "", "", "Lid/dana/requestmoney/util/RequestMoneyErrorState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Throwable;)Lid/dana/requestmoney/util/RequestMoneyErrorState;", "", "getAuthRequestContext", "(Ljava/lang/Throwable;)Z", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyErrorHelper {
    public static final RequestMoneyErrorHelper INSTANCE = new RequestMoneyErrorHelper();

    private RequestMoneyErrorHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3 */
    public static RequestMoneyErrorState KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        boolean PlaceComponentResult = PlaceComponentResult(th);
        int i = R.string.error_network_by_timout;
        int i2 = 2;
        if (PlaceComponentResult) {
            return new RequestMoneyErrorState("NETWORK_TIMEOUT", new UiTextModel.StringResource(i, r4, i2, r4), "");
        }
        if (BuiltInFictitiousFunctionClassFactory(th)) {
            return new RequestMoneyErrorState("UNSTABLE_NETWORK", new UiTextModel.StringResource(R.string.error_network_by_internet_connection_or_vpn, r4, i2, r4), "");
        }
        if (getAuthRequestContext(th)) {
            Throwable cause = th.getCause();
            NetworkException networkException = cause instanceof NetworkException ? (NetworkException) cause : null;
            if (networkException == null) {
                networkException = th instanceof NetworkException ? (NetworkException) th : null;
            }
            String message = networkException != null ? networkException.getMessage() : null;
            if (message == null) {
                message = "";
            }
            UiTextModel.DynamicString dynamicString = new UiTextModel.DynamicString(message);
            r4 = networkException != null ? networkException.getErrorCode() : 0;
            return new RequestMoneyErrorState("NETWORK_EXCEPTION", dynamicString, r4 != 0 ? r4 : "");
        }
        Throwable cause2 = th.getCause();
        RpcException rpcException = cause2 instanceof RpcException ? (RpcException) cause2 : null;
        if (rpcException == null) {
            rpcException = th instanceof RpcException ? (RpcException) th : null;
        }
        if (rpcException == null) {
            rpcException = new RpcException("");
        }
        return new RequestMoneyErrorState("NETWORK_EXCEPTION", rpcException.getCode() == 5 ? new UiTextModel.StringResource(i, r4, i2, r4) : new UiTextModel.StringResource(R.string.uh_oh_no_internet_connection, r4, i2, r4), "");
    }

    private static boolean PlaceComponentResult(Throwable th) {
        return (th.getCause() instanceof SocketTimeoutException) || (th.getCause() instanceof id.dana.data.foundation.RpcException) || (th instanceof SocketTimeoutException) || (th instanceof id.dana.data.foundation.RpcException);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Throwable th) {
        return (th.getCause() instanceof UnknownHostException) || (th.getCause() instanceof NoNetworkException) || (th.getCause() instanceof ConnectException) || (th.getCause() instanceof UnknownServiceException) || (th instanceof ConnectException) || (th instanceof UnknownServiceException);
    }

    private static boolean getAuthRequestContext(Throwable th) {
        return (th.getCause() instanceof NetworkException) || (th instanceof NetworkException);
    }
}
