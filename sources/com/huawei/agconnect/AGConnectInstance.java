package com.huawei.agconnect;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.agconnect.core.a.b;

/* loaded from: classes7.dex */
public abstract class AGConnectInstance {
    public static AGConnectInstance KClassImpl$Data$declaredNonStaticMembers$2() {
        return b.getAuthRequestContext();
    }

    public static void MyBillsEntityDataFactory(Context context) {
        synchronized (AGConnectInstance.class) {
            InstrumentInjector.log_i("AGConnectInstance", "AGConnectInstance#initialize");
            b.BuiltInFictitiousFunctionClassFactory(context);
        }
    }

    public static AGConnectInstance getAuthRequestContext(AGConnectOptions aGConnectOptions) {
        AGConnectInstance BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory = b.BuiltInFictitiousFunctionClassFactory(aGConnectOptions, false);
        return BuiltInFictitiousFunctionClassFactory;
    }

    public abstract Context MyBillsEntityDataFactory();

    public abstract AGConnectOptions PlaceComponentResult();
}
