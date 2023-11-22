package id.dana.geofence;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/geofence/GeofenceConstant;", "", "", "PlaceComponentResult", "J", "()J", "BuiltInFictitiousFunctionClassFactory", "", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GeofenceConstant {
    public static final GeofenceConstant INSTANCE = new GeofenceConstant();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static final int PlaceComponentResult = (int) TimeUnit.MINUTES.toMillis(2);

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final long BuiltInFictitiousFunctionClassFactory = TimeUnit.DAYS.toMillis(7);

    private GeofenceConstant() {
    }

    @JvmName(name = "PlaceComponentResult")
    public static long PlaceComponentResult() {
        return BuiltInFictitiousFunctionClassFactory;
    }
}
