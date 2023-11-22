package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public abstract class GnssStatusCompat {

    /* loaded from: classes6.dex */
    public static abstract class Callback {
        public void BuiltInFictitiousFunctionClassFactory() {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        }

        public void MyBillsEntityDataFactory() {
        }

        public void PlaceComponentResult(GnssStatusCompat gnssStatusCompat) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ConstellationType {
    }

    public static GnssStatusCompat BuiltInFictitiousFunctionClassFactory(GnssStatus gnssStatus) {
        return new GnssStatusWrapper(gnssStatus);
    }

    public static GnssStatusCompat KClassImpl$Data$declaredNonStaticMembers$2(GpsStatus gpsStatus) {
        return new GpsStatusWrapper(gpsStatus);
    }
}
