package id.dana.cashier.helper;

import id.dana.constants.ErrorCode;
import id.dana.data.foundation.RpcException;
import id.dana.data.network.exception.NoNetworkException;
import id.dana.network.exception.NetworkException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u0004*\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\bH\u0002¢\u0006\u0004\b\u0005\u0010\rJ\u0013\u0010\u0007\u001a\u00020\u0004*\u00020\bH\u0002¢\u0006\u0004\b\u0007\u0010\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000f"}, d2 = {"Lid/dana/cashier/helper/CashierErrorHelper;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/cashier/helper/CashierErrorState;", "MyBillsEntityDataFactory", "(Ljava/lang/Throwable;)Lid/dana/cashier/helper/CashierErrorState;", "getAuthRequestContext", "(Ljava/lang/Throwable;)Z", "", "Ljava/util/List;", "PlaceComponentResult", "scheduleImpl", "lookAheadTest", "moveToNextValue", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierErrorHelper {
    public static final CashierErrorHelper INSTANCE = new CashierErrorHelper();
    private static final List<String> getErrorConfigVersion = CollectionsKt.listOf((Object[]) new String[]{"AE15101858018939", "AE15101858018937", "AE15101858018102", "AE15101858018114", "AE15112168003044", "AE15112168003038", "AE15112168003074", "AE15112168003064", "AE15112168003065", "AE15112168003063", "AE15112168003060", "AE15112168003039", "AE15112168003042", "AE15112168003027", "AE15112168003037", "AE15112168003017", "AE15112168003070", "AE15112168003052", "AE15112168003071", "AE15112168003053", "AE13112168000900", "AE13112168000901", "AE13112168000902", "AE13112168000904", "AE13112168000905", "AE13112168000907", "AE13112168000903", "AE13112168000952", "AE13112168000958", "AE13112168000960", "AE13112168000961", "AE15112168009110", "AE13112128007202", "AE15112168003114", "AE15112168005038", ErrorCode.ERROR_CODE_DANA_PIN_OR_OTP_TEMPORARY_LOCK, "AE15001858018116", "AE15001858018117", "AE15001858018118", "AE15001858018119", "AE15001858018120", "AE15012168003003", "AE15112128007001", "AE15012168009025", "AE15012158001102", "AE15012168009032", "AE15012168005001", "AE15012168005002", "AE15012168005013", "AE15112168005074", "AE15112168005041", "AE15112168005060", "AE15112168005021", "AE15112168005022", "AE15012168005012", "AE15112168005027", "AE15012168005303", "AE15012168005035", "AE15012168005015", "AE15112168005016", "AE15112168005073", "AE15112168005072", "AE13112168000906", "AE13112168000962", "AE15112168003040", "AE15112168003043", "AE15112168003045", "AE15112168003046", "AE15112168003047", "AE15112168003048", "AE15112168003049", "AE15112168003050", "AE15112168003051", "AE15112168003054", "AE15112168003055", "AE15112168003056", "AE15112168003057", "AE15112168003058", "AE15112168003059", "AE15112168003061", "AE15112168003062", "AE15112168003305", "AE15112168003010", "AE15012168009001", "AE15012168009002", "AE15112168009110", "AE15012158101001", "AE15012158065001", "AE15101858018113", "AE11112060030121", "AE15112168006027", "AE15101858018950", "BALANCE_OVER_LIMIT", "BALANCE_NOT_ENOUGH", "BALANCE_ACCOUNT_NOT_EXIST", "BALANCE_ACCOUNT_STATUS_DISABLED", "CHANNEL_NOT_IN_SERVICE_TIME", "CHANNEL_NOT_AVAILABLE", "EXCEED_CHANNEL_AMOUNT_LIMIT", "BALANCE_ACCOUNT_FREEZED", "PROCESS_FAIL", "ACCOUNT_NOT_MATCH_VALID_DATA", "OUT_OF_BALANCE", "SYSTEM_EXCEPTION", "UNSUPPORTED_BUSINESS", "BUSINESS_CANCELED", "3D_AUTHENTICATION_FAILED", "ACCOUNT_NOT_MATCH_CVV2", "3D_NOT_ENROLLED", "UNKNOWN_PROCESS_STATUS", "PASSWORD_WRONG_OVER_LIMIT", "AVS_FAILED", "CVV_FAILED", "TRANSACTION_FAILED", "TRANSACTION_DECLINED", "BCA_NET_BANKING_INVALID_OTP"});

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private static final List<String> scheduleImpl = CollectionsKt.listOf((Object[]) new String[]{"AE15002058020033", "AE15002058020032", "AE15002058020031", ErrorCode.DANA_PIN_UNMATCHED, "AE15102058020051", ErrorCode.DANA_PIN_NOT_EXIST, "AE15002058020050", "AE11112060000509"});
    private static final List<String> BuiltInFictitiousFunctionClassFactory = CollectionsKt.listOf((Object[]) new String[]{"NET_BANKING_LIMIT_DAILY", "BCA_NET_BANKING_LIMIT_EXCEED", "BCA_NET_BANKING_DEVICEID", "NET_BANKING_CARD_HAS_BEEN_REGISTERED"});

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private static final List<String> moveToNextValue = CollectionsKt.listOf((Object[]) new String[]{"AE13112168000996", "AE13112168000997"});

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static final List<String> MyBillsEntityDataFactory = CollectionsKt.listOf((Object[]) new String[]{"AE13112168000984", "AE15112168003052", "AE15112168003053"});
    private static final List<String> NetworkUserEntityData$$ExternalSyntheticLambda0 = CollectionsKt.listOf((Object[]) new String[]{"AE15012168003003", "AE15112168003064", "AE15112168005038", "AE15101858018950", "INVALID_VALIDATE_DATA"});

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private static final List<String> initRecordTimeStamp = CollectionsKt.listOf((Object[]) new String[]{"AE15012158000002", "AE13112068001901", "AE15102058020805"});

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static final List<String> KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.listOf((Object[]) new String[]{ErrorCode.ERROR_CODE_DANA_ACCOUNT_FROZEN_TEMPORARY, "AE15112158065208"});

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private static final List<String> PlaceComponentResult = CollectionsKt.listOf("AE13112168000982");

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final List<String> getAuthRequestContext = CollectionsKt.listOf((Object[]) new String[]{ErrorCode.API_IS_LIMITED, "AE15001858018002", "AE15001858018001"});

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private static final List<String> lookAheadTest = CollectionsKt.listOf("AE15112158100410");

    private CashierErrorHelper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0200  */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static id.dana.cashier.helper.CashierErrorState MyBillsEntityDataFactory(java.lang.Throwable r9) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.helper.CashierErrorHelper.MyBillsEntityDataFactory(java.lang.Throwable):id.dana.cashier.helper.CashierErrorState");
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Throwable th) {
        return (th.getCause() instanceof SocketTimeoutException) || (th.getCause() instanceof RpcException) || (th instanceof SocketTimeoutException) || (th instanceof com.alipay.mobile.common.rpc.RpcException);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        return (th.getCause() instanceof UnknownHostException) || (th.getCause() instanceof NoNetworkException) || (th.getCause() instanceof ConnectException) || (th.getCause() instanceof UnknownServiceException) || (th instanceof SocketTimeoutException) || (th instanceof RpcException) || (th instanceof ConnectException) || (th instanceof UnknownServiceException);
    }

    private static boolean getAuthRequestContext(Throwable th) {
        return (th.getCause() instanceof NetworkException) || (th instanceof NetworkException);
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return NetworkUserEntityData$$ExternalSyntheticLambda0.contains(p0);
    }
}
