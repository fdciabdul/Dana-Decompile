package com.akamai.botman;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class z {
    private static final z getAuthRequestContext = new z();
    public WeakReference<Context> BuiltInFictitiousFunctionClassFactory = null;
    String PlaceComponentResult = null;

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(z zVar) {
        synchronized (zVar) {
            Context context = zVar.BuiltInFictitiousFunctionClassFactory.get();
            if (context == null) {
                ah.MyBillsEntityDataFactory("SensorDataCache", "saveData: Context is null", new Throwable[0]);
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("com.akamai.botman.preferences", 0).edit();
            edit.putString("sensor_data", zVar.PlaceComponentResult);
            edit.commit();
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(z zVar) {
        ah.PlaceComponentResult("SensorDataCache", "Initializing cache", new Throwable[0]);
        synchronized (zVar) {
            Context context = zVar.BuiltInFictitiousFunctionClassFactory.get();
            if (context == null) {
                ah.MyBillsEntityDataFactory("SensorDataCache", "loadData: Context is null", new Throwable[0]);
            } else {
                zVar.PlaceComponentResult = context.getSharedPreferences("com.akamai.botman.preferences", 0).getString("sensor_data", null);
            }
        }
    }
}
