package id.dana.utils.foundation.logger.log;

import android.text.TextUtils;
import com.alipay.iap.android.common.log.MonitorWrapper;
import java.util.HashMap;
import java.util.Map;
import timber.log.Timber;

/* loaded from: classes.dex */
public class DanaLog {
    private DanaLog() {
    }

    public static void PlaceComponentResult(String str, String str2) {
        Timber.getAuthRequestContext(str).KClassImpl$Data$declaredNonStaticMembers$2(str2, new Object[0]);
    }

    public static void PlaceComponentResult(String str, String str2, Throwable th) {
        Timber.getAuthRequestContext(str).getAuthRequestContext(th, str2, new Object[0]);
    }

    public static void getAuthRequestContext(String str, String str2) {
        Timber.getAuthRequestContext(str).PlaceComponentResult(str2, new Object[0]);
    }

    public static void MyBillsEntityDataFactory(String str, String str2) {
        Timber.getAuthRequestContext(str).BuiltInFictitiousFunctionClassFactory(str2, new Object[0]);
    }

    public static void getAuthRequestContext(String str, String str2, Throwable th) {
        Timber.getAuthRequestContext(str).PlaceComponentResult(th, str2, new Object[0]);
    }

    public static void scheduleImpl(String str, String str2) {
        Timber.getAuthRequestContext(str).getAuthRequestContext(str2, new Object[0]);
    }

    public static void MyBillsEntityDataFactory(String str, Throwable th) {
        Timber.getAuthRequestContext(str).getAuthRequestContext(th);
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        Timber.getAuthRequestContext(str).MyBillsEntityDataFactory(str2, new Object[0]);
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2, Throwable th) {
        Timber.getAuthRequestContext(str).KClassImpl$Data$declaredNonStaticMembers$2(th, str2, new Object[0]);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", str2);
        MonitorWrapper.behaviour(str, hashMap);
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2, Map<String, String> map) {
        MonitorWrapper.behaviour(str, str2, map);
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("exceptionType", str2);
        hashMap.put("message", str3);
        if (!TextUtils.isEmpty("")) {
            hashMap.put("traceId", "");
        }
        MonitorWrapper.exception(str, hashMap);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            sb.append("[");
            sb.append((String) entry.getKey());
            sb.append(": ");
            sb.append((String) entry.getValue());
            sb.append("] ");
        }
        Timber.getAuthRequestContext(str).MyBillsEntityDataFactory(sb.toString(), new Object[0]);
    }
}
