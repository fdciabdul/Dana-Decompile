package id.dana.kyb.tracker;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000f"}, d2 = {"Lid/dana/kyb/tracker/KybRenderQrTracker;", "", "", "getAuthRequestContext", "()J", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "p0", "", "MyBillsEntityDataFactory", "()V", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Ljava/lang/Boolean;", "J", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybRenderQrTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static Boolean PlaceComponentResult;
    public static final KybRenderQrTracker INSTANCE = new KybRenderQrTracker();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static long KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static long BuiltInFictitiousFunctionClassFactory;

    private KybRenderQrTracker() {
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory() {
        PlaceComponentResult = Boolean.TRUE;
    }

    @JvmStatic
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Boolean bool = PlaceComponentResult;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
        KClassImpl$Data$declaredNonStaticMembers$2 = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory = 0L;
        BuiltInFictitiousFunctionClassFactory = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final long getAuthRequestContext() {
        return BuiltInFictitiousFunctionClassFactory - KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
