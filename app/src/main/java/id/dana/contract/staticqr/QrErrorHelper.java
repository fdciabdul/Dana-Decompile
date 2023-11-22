package id.dana.contract.staticqr;

import android.content.Context;
import com.alipay.imobile.network.quake.exception.TimeoutException;
import com.alipay.mobile.common.rpc.RpcException;
import id.dana.R;
import id.dana.data.network.exception.NoNetworkException;
import id.dana.network.exception.NetworkException;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.utils.ErrorUtil;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\f\u001a\u00020\b*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u0006\u001a\u00020\b*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\n"}, d2 = {"Lid/dana/contract/staticqr/QrErrorHelper;", "", "", "Landroid/content/Context;", "p0", "", "PlaceComponentResult", "(Ljava/lang/Throwable;Landroid/content/Context;)Ljava/lang/String;", "", "getAuthRequestContext", "(Ljava/lang/Throwable;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrErrorHelper {
    public static final QrErrorHelper INSTANCE = new QrErrorHelper();

    private QrErrorHelper() {
    }

    public static String PlaceComponentResult(Throwable th, Context context) {
        String string;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (th instanceof NoInternetConnectionException) {
            string = th.getMessage();
            if (string == null) {
                return "";
            }
        } else if (getAuthRequestContext(th) || getAuthRequestContext(th.getCause())) {
            string = context.getString(R.string.error_network_by_timout);
            Intrinsics.checkNotNullExpressionValue(string, "");
        } else if (PlaceComponentResult(th) || PlaceComponentResult(th.getCause())) {
            string = context.getString(R.string.error_network_by_internet_connection_or_vpn);
            Intrinsics.checkNotNullExpressionValue(string, "");
        } else {
            boolean z = th instanceof NetworkException;
            if (z || (th.getCause() instanceof NetworkException)) {
                Throwable cause = th.getCause();
                NetworkException networkException = cause instanceof NetworkException ? (NetworkException) cause : null;
                if (networkException == null) {
                    networkException = z ? (NetworkException) th : null;
                }
                String message = networkException != null ? networkException.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                return new Regex("(\\w+\\.)+\\w+:").replace(message, "");
            }
            string = ErrorUtil.PlaceComponentResult(th, context);
            Intrinsics.checkNotNullExpressionValue(string, "");
        }
        return string;
    }

    private static boolean getAuthRequestContext(Throwable th) {
        return (th instanceof SocketTimeoutException) || (th instanceof UnknownHostException) || KClassImpl$Data$declaredNonStaticMembers$2(th) || MyBillsEntityDataFactory(th);
    }

    private static boolean MyBillsEntityDataFactory(Throwable th) {
        return (th instanceof RpcException) && CollectionsKt.listOf((Object[]) new Integer[]{2, 5, 4001}).contains(Integer.valueOf(((RpcException) th).getCode()));
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        return (th instanceof id.dana.data.foundation.RpcException) && CollectionsKt.listOf((Object[]) new String[]{"012", "002", "006", "005"}).contains(((id.dana.data.foundation.RpcException) th).code);
    }

    private static boolean PlaceComponentResult(Throwable th) {
        return (th instanceof NoNetworkException) || (th instanceof ConnectException) || (th instanceof UnknownServiceException) || (th instanceof TimeoutException);
    }
}
