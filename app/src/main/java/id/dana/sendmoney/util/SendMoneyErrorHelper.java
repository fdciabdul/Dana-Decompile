package id.dana.sendmoney.util;

import com.alipay.mobile.common.rpc.RpcException;
import id.dana.core.ui.model.UiTextModel;
import id.dana.data.network.exception.NoNetworkException;
import id.dana.network.exception.NetworkException;
import id.dana.sendmoney.R;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0013\u0010\n\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r"}, d2 = {"Lid/dana/sendmoney/util/SendMoneyErrorHelper;", "", "", "Lid/dana/sendmoney/util/SendMoneyErrorState;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Throwable;)Lid/dana/sendmoney/util/SendMoneyErrorState;", "", "MyBillsEntityDataFactory", "(Ljava/lang/Throwable;)Z", "PlaceComponentResult", "getAuthRequestContext", "", "", "Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyErrorHelper {
    public static final SendMoneyErrorHelper INSTANCE = new SendMoneyErrorHelper();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static final List<String> BuiltInFictitiousFunctionClassFactory = CollectionsKt.listOf((Object[]) new String[]{"AE15001858018001", "AE13112148999207", "AE15112158147335", "AE15001858018070"});

    private SendMoneyErrorHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static SendMoneyErrorState BuiltInFictitiousFunctionClassFactory(Throwable th) {
        UiTextModel.StringResource stringResource;
        Intrinsics.checkNotNullParameter(th, "");
        int i = 2;
        if (PlaceComponentResult(th)) {
            return new SendMoneyErrorState("NETWORK_TIMEOUT", new UiTextModel.StringResource(R.string.error_network_by_timout, r3, i, r3), "");
        }
        if (getAuthRequestContext(th)) {
            return new SendMoneyErrorState("UNSTABLE_NETWORK", new UiTextModel.StringResource(R.string.error_network_by_internet_connection_or_vpn, r3, i, r3), "");
        }
        if (MyBillsEntityDataFactory(th)) {
            Throwable cause = th.getCause();
            NetworkException networkException = cause instanceof NetworkException ? (NetworkException) cause : null;
            if (networkException == null) {
                networkException = th instanceof NetworkException ? (NetworkException) th : null;
            }
            if (CollectionsKt.contains(BuiltInFictitiousFunctionClassFactory, networkException != null ? networkException.getErrorCode() : null)) {
                UiTextModel.StringResource stringResource2 = new UiTextModel.StringResource(R.string.error_too_many_transactions, r3, i, r3);
                String errorCode = networkException != null ? networkException.getErrorCode() : null;
                return new SendMoneyErrorState("NETWORK_EXCEPTION", stringResource2, errorCode != null ? errorCode : "");
            }
            String message = networkException != null ? networkException.getMessage() : null;
            if (message == null) {
                message = "";
            }
            UiTextModel.DynamicString dynamicString = new UiTextModel.DynamicString(message);
            r3 = networkException != null ? networkException.getErrorCode() : 0;
            return new SendMoneyErrorState("NETWORK_EXCEPTION", dynamicString, r3 != 0 ? r3 : "");
        }
        Throwable cause2 = th.getCause();
        RpcException rpcException = cause2 instanceof RpcException ? (RpcException) cause2 : null;
        if (rpcException == null) {
            rpcException = th instanceof RpcException ? (RpcException) th : null;
        }
        if (rpcException == null) {
            rpcException = new RpcException("");
        }
        if (rpcException.getCode() == 5) {
            stringResource = new UiTextModel.StringResource(R.string.error_network_by_timout, r3, i, r3);
        } else {
            stringResource = new UiTextModel.StringResource(R.string.uh_oh_no_internet_connection, r3, i, r3);
        }
        return new SendMoneyErrorState("NETWORK_EXCEPTION", stringResource, "");
    }

    private static boolean PlaceComponentResult(Throwable th) {
        return (th.getCause() instanceof SocketTimeoutException) || (th.getCause() instanceof id.dana.data.foundation.RpcException) || (th instanceof SocketTimeoutException) || (th.getCause() instanceof id.dana.data.foundation.RpcException);
    }

    private static boolean getAuthRequestContext(Throwable th) {
        return (th.getCause() instanceof UnknownHostException) || (th.getCause() instanceof NoNetworkException) || (th.getCause() instanceof ConnectException) || (th.getCause() instanceof UnknownServiceException) || (th instanceof SocketTimeoutException) || (th instanceof id.dana.data.foundation.RpcException) || (th instanceof ConnectException) || (th instanceof UnknownServiceException);
    }

    private static boolean MyBillsEntityDataFactory(Throwable th) {
        return (th.getCause() instanceof NetworkException) || (th instanceof NetworkException);
    }
}
