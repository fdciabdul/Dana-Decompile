package id.dana.cashier.utils;

import id.dana.utils.DateTimeUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\u0007R\u0012\u0010\u0006\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0012\u0010\f\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\r"}, d2 = {"Lid/dana/cashier/utils/PaymentExecutionTimeUtil;", "", "", "MyBillsEntityDataFactory", "()J", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "getAuthRequestContext", "()Z", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "J", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaymentExecutionTimeUtil {
    public static final PaymentExecutionTimeUtil INSTANCE = new PaymentExecutionTimeUtil();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public static long KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public static long PlaceComponentResult;

    private PaymentExecutionTimeUtil() {
    }

    public static void PlaceComponentResult() {
        PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
    }

    public static boolean getAuthRequestContext() {
        return PlaceComponentResult != 0;
    }

    public static long MyBillsEntityDataFactory() {
        long j = PlaceComponentResult;
        if (j > 0) {
            long j2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (j2 > 0) {
                return j2 - j;
            }
            return 0L;
        }
        return 0L;
    }

    public static void BuiltInFictitiousFunctionClassFactory() {
        PlaceComponentResult = 0L;
        KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
    }
}
