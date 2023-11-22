package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class GpsStatusWrapper extends GnssStatusCompat {
    private GpsSatellite BuiltInFictitiousFunctionClassFactory;
    private final GpsStatus KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    private Iterator<GpsSatellite> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(gpsStatus);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gpsStatus2;
        this.PlaceComponentResult = -1;
        this.getAuthRequestContext = gpsStatus2.getSatellites().iterator();
        this.MyBillsEntityDataFactory = -1;
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GpsStatusWrapper) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(((GpsStatusWrapper) obj).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public int hashCode() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }
}
