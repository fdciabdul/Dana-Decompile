package id.dana.performancetracker;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\u0007J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\u000b\u0010\u0004"}, d2 = {"Lid/dana/performancetracker/IdleTimeUtil;", "", "", "PlaceComponentResult", "()J", "", "getAuthRequestContext", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "J", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IdleTimeUtil {
    private static long BuiltInFictitiousFunctionClassFactory;
    public static final IdleTimeUtil INSTANCE = new IdleTimeUtil();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static long PlaceComponentResult;

    private IdleTimeUtil() {
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static final long MyBillsEntityDataFactory() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static void getAuthRequestContext() {
        if (PlaceComponentResult == 0) {
            PlaceComponentResult = System.currentTimeMillis();
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (BuiltInFictitiousFunctionClassFactory == 0) {
            BuiltInFictitiousFunctionClassFactory = System.currentTimeMillis();
        }
    }

    public static long PlaceComponentResult() {
        long j = PlaceComponentResult;
        if (j != 0) {
            long j2 = BuiltInFictitiousFunctionClassFactory;
            if (j2 != 0) {
                return j2 - j;
            }
        }
        return 0L;
    }
}
