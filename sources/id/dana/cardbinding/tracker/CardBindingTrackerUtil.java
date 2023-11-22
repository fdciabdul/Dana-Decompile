package id.dana.cardbinding.tracker;

import id.dana.utils.DateTimeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004J\u001d\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0007\u0010\u0011J\u001d\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0012¢\u0006\u0004\b\n\u0010\u0013J\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0014¢\u0006\u0004\b\u0003\u0010\u0015J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0016¢\u0006\u0004\b\t\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0018"}, d2 = {"Lid/dana/cardbinding/tracker/CardBindingTrackerUtil;", "", "", "PlaceComponentResult", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Long;)Ljava/lang/Long;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "getErrorConfigVersion", "moveToNextValue", "Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;", "Lid/dana/cardbinding/tracker/AddCardExecutionProperties;", "p1", "(Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;Lid/dana/cardbinding/tracker/AddCardExecutionProperties;)V", "Lid/dana/cardbinding/tracker/AddCardOpenProperties;", "(Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;Lid/dana/cardbinding/tracker/AddCardOpenProperties;)V", "Lid/dana/cardbinding/tracker/AddCardResultProperties;", "(Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;Lid/dana/cardbinding/tracker/AddCardResultProperties;)V", "Lid/dana/cardbinding/tracker/ThirdPartyRiskChallengeProperties;", "(Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;Lid/dana/cardbinding/tracker/ThirdPartyRiskChallengeProperties;)V", "Ljava/lang/Long;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "J", "scheduleImpl", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CardBindingTrackerUtil {
    public static final CardBindingTrackerUtil INSTANCE = new CardBindingTrackerUtil();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public static Long PlaceComponentResult;
    public static Long MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private static long scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public static Long getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public static Long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public static Long NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private static Long KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private static Long getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public static Long moveToNextValue;

    private CardBindingTrackerUtil() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(CardBindingAnalyticTracker p0, AddCardOpenProperties p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p1.getAuthRequestContext = NetworkUserEntityData$$ExternalSyntheticLambda0;
        p1.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        p0.BuiltInFictitiousFunctionClassFactory(p1);
        moveToNextValue = null;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        BuiltInFictitiousFunctionClassFactory = null;
        MyBillsEntityDataFactory = null;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(CardBindingAnalyticTracker p0, AddCardExecutionProperties p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p0.PlaceComponentResult(p1);
    }

    public static void getAuthRequestContext(CardBindingAnalyticTracker p0, ThirdPartyRiskChallengeProperties p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p0.getAuthRequestContext(p1);
    }

    public static void getAuthRequestContext() {
        moveToNextValue = null;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        BuiltInFictitiousFunctionClassFactory = null;
        MyBillsEntityDataFactory = null;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult = null;
        getAuthRequestContext = null;
        KClassImpl$Data$declaredNonStaticMembers$2 = null;
        scheduleImpl = 0L;
        getErrorConfigVersion = null;
    }

    public static Long KClassImpl$Data$declaredNonStaticMembers$2(Long p0) {
        if (p0 != null) {
            long longValue = p0.longValue();
            long BuiltInFictitiousFunctionClassFactory2 = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory2 >= longValue) {
                return Long.valueOf(BuiltInFictitiousFunctionClassFactory2 - longValue);
            }
            return null;
        }
        return null;
    }

    public static void moveToNextValue() {
        moveToNextValue = Long.valueOf(DateTimeUtil.BuiltInFictitiousFunctionClassFactory());
    }

    public static void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory = Long.valueOf(DateTimeUtil.BuiltInFictitiousFunctionClassFactory());
    }

    public static void MyBillsEntityDataFactory() {
        PlaceComponentResult = Long.valueOf(DateTimeUtil.BuiltInFictitiousFunctionClassFactory());
    }

    public static void getErrorConfigVersion() {
        KClassImpl$Data$declaredNonStaticMembers$2 = Long.valueOf(DateTimeUtil.BuiltInFictitiousFunctionClassFactory());
    }

    public static void PlaceComponentResult() {
        long j = scheduleImpl;
        Long KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
        scheduleImpl = j + (KClassImpl$Data$declaredNonStaticMembers$22 != null ? KClassImpl$Data$declaredNonStaticMembers$22.longValue() : 0L);
    }

    public static void PlaceComponentResult(CardBindingAnalyticTracker p0, AddCardResultProperties p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Long l = getAuthRequestContext;
        if (l != null) {
            getErrorConfigVersion = Long.valueOf(l.longValue() - scheduleImpl);
        }
        p1.MyBillsEntityDataFactory = getAuthRequestContext;
        p1.moveToNextValue = getErrorConfigVersion;
        p0.KClassImpl$Data$declaredNonStaticMembers$2(p1);
        PlaceComponentResult = null;
        getAuthRequestContext = null;
        KClassImpl$Data$declaredNonStaticMembers$2 = null;
        scheduleImpl = 0L;
        getErrorConfigVersion = null;
    }
}
