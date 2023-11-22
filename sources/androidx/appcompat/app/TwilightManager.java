package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.PermissionChecker;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.utils.permission.ManifestPermission;
import java.util.Calendar;

/* loaded from: classes.dex */
class TwilightManager {
    private static TwilightManager getAuthRequestContext;
    private final TwilightState BuiltInFictitiousFunctionClassFactory = new TwilightState();
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final LocationManager PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TwilightManager PlaceComponentResult(Context context) {
        if (getAuthRequestContext == null) {
            Context applicationContext = context.getApplicationContext();
            getAuthRequestContext = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return getAuthRequestContext;
    }

    private TwilightManager(Context context, LocationManager locationManager) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory() {
        long j;
        TwilightState twilightState = this.BuiltInFictitiousFunctionClassFactory;
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            return twilightState.getAuthRequestContext;
        }
        Location MyBillsEntityDataFactory = PermissionChecker.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, ManifestPermission.ACCESS_COARSE_LOCATION) == 0 ? MyBillsEntityDataFactory("network") : null;
        Location MyBillsEntityDataFactory2 = PermissionChecker.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, "android.permission.ACCESS_FINE_LOCATION") == 0 ? MyBillsEntityDataFactory("gps") : null;
        if (MyBillsEntityDataFactory2 == null || MyBillsEntityDataFactory == null ? MyBillsEntityDataFactory2 != null : MyBillsEntityDataFactory2.getTime() > MyBillsEntityDataFactory.getTime()) {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory2;
        }
        if (MyBillsEntityDataFactory == null) {
            InstrumentInjector.log_i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
            int i = Calendar.getInstance().get(11);
            return i < 6 || i >= 22;
        }
        TwilightState twilightState2 = this.BuiltInFictitiousFunctionClassFactory;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator MyBillsEntityDataFactory3 = TwilightCalculator.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory3.PlaceComponentResult(currentTimeMillis - 86400000, MyBillsEntityDataFactory.getLatitude(), MyBillsEntityDataFactory.getLongitude());
        long j2 = MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2;
        MyBillsEntityDataFactory3.PlaceComponentResult(currentTimeMillis, MyBillsEntityDataFactory.getLatitude(), MyBillsEntityDataFactory.getLongitude());
        boolean z = MyBillsEntityDataFactory3.PlaceComponentResult == 1;
        long j3 = MyBillsEntityDataFactory3.MyBillsEntityDataFactory;
        long j4 = MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2;
        boolean z2 = z;
        MyBillsEntityDataFactory3.PlaceComponentResult(currentTimeMillis + 86400000, MyBillsEntityDataFactory.getLatitude(), MyBillsEntityDataFactory.getLongitude());
        long j5 = MyBillsEntityDataFactory3.MyBillsEntityDataFactory;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        twilightState2.getAuthRequestContext = z2;
        twilightState2.lookAheadTest = j2;
        twilightState2.BuiltInFictitiousFunctionClassFactory = j3;
        twilightState2.KClassImpl$Data$declaredNonStaticMembers$2 = j4;
        twilightState2.MyBillsEntityDataFactory = j5;
        twilightState2.PlaceComponentResult = j;
        return twilightState.getAuthRequestContext;
    }

    private Location MyBillsEntityDataFactory(String str) {
        try {
            if (this.PlaceComponentResult.isProviderEnabled(str)) {
                return this.PlaceComponentResult.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            InstrumentInjector.log_d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TwilightState {
        long BuiltInFictitiousFunctionClassFactory;
        long KClassImpl$Data$declaredNonStaticMembers$2;
        long MyBillsEntityDataFactory;
        long PlaceComponentResult;
        boolean getAuthRequestContext;
        long lookAheadTest;

        TwilightState() {
        }
    }
}
