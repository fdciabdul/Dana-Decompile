package com.iap.android.iaptinylog;

import com.iap.android.iaptinylog.data.IAPTinyLog;
import com.iap.android.iaptinylog.data.IAPTinyLogType;
import com.iap.android.iaptinylog.observer.ILogObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class IAPTinyLogger {
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String getAuthRequestContext;
    public static List<ILogObserver> BuiltInFictitiousFunctionClassFactory = new ArrayList();
    public static Map<String, Boolean> PlaceComponentResult = new HashMap();
    public static Map<String, String> MyBillsEntityDataFactory = new HashMap();

    public IAPTinyLogger() {
    }

    public static List<ILogObserver> KClassImpl$Data$declaredNonStaticMembers$2() {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new ArrayList();
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    private static boolean MyBillsEntityDataFactory(IAPTinyLogType iAPTinyLogType) {
        Map<String, Boolean> map;
        Boolean bool;
        if (iAPTinyLogType == null || (map = PlaceComponentResult) == null || (bool = map.get(iAPTinyLogType.name())) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void PlaceComponentResult(IAPTinyLogType iAPTinyLogType) {
        if (iAPTinyLogType == null) {
            return;
        }
        if (PlaceComponentResult == null) {
            PlaceComponentResult = new HashMap();
        }
        PlaceComponentResult.put(iAPTinyLogType.name(), Boolean.TRUE);
    }

    public IAPTinyLogger(String str, String str2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = str2;
    }

    public static void PlaceComponentResult(IAPTinyLog iAPTinyLog) {
        if (iAPTinyLog == null) {
            return;
        }
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new ArrayList();
        }
        List<ILogObserver> list = BuiltInFictitiousFunctionClassFactory;
        if (list == null || list.size() == 0 || !MyBillsEntityDataFactory(iAPTinyLog.type)) {
            return;
        }
        if (iAPTinyLog.parameters == null) {
            iAPTinyLog.parameters = new HashMap();
        }
        Map<String, String> map = MyBillsEntityDataFactory;
        if (map != null) {
            iAPTinyLog.parameters.putAll(map);
        }
        Iterator it = new CopyOnWriteArrayList(list).iterator();
        while (it.hasNext()) {
            ILogObserver iLogObserver = (ILogObserver) it.next();
        }
    }
}
