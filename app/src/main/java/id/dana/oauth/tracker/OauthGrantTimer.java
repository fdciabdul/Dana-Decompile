package id.dana.oauth.tracker;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\bR\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\r"}, d2 = {"Lid/dana/oauth/tracker/OauthGrantTimer;", "", "", "BuiltInFictitiousFunctionClassFactory", "()J", "KClassImpl$Data$declaredNonStaticMembers$2", "", "PlaceComponentResult", "()V", "MyBillsEntityDataFactory", "getAuthRequestContext", "getErrorConfigVersion", "moveToNextValue", "J", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OauthGrantTimer {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static long getAuthRequestContext;
    public static final OauthGrantTimer INSTANCE = new OauthGrantTimer();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static long PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static long KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static long MyBillsEntityDataFactory;

    private OauthGrantTimer() {
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = 0L;
        MyBillsEntityDataFactory = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final void getErrorConfigVersion() {
        PlaceComponentResult = 0L;
        PlaceComponentResult = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final long BuiltInFictitiousFunctionClassFactory() {
        return RangesKt.coerceAtLeast(PlaceComponentResult - MyBillsEntityDataFactory, 0L);
    }

    @JvmStatic
    public static final void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2 = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final void moveToNextValue() {
        getAuthRequestContext = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final void PlaceComponentResult() {
        MyBillsEntityDataFactory = 0L;
        PlaceComponentResult = 0L;
        KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
        getAuthRequestContext = 0L;
    }
}
