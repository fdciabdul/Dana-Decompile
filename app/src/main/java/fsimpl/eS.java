package fsimpl;

import com.fullstory.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class eS {
    private static int a(fi fiVar, String str, Object obj) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Skipping null value for key ");
            sb.append(str);
            Log.e(sb.toString());
            return 0;
        }
        eB a2 = eB.a(obj.getClass());
        if (a2 != eB.Unhandled) {
            return eF.a(fiVar, a2, obj);
        }
        if (obj instanceof Map) {
            return b(fiVar, (Map) obj);
        }
        if (obj.getClass().isArray()) {
            return eE.a(fiVar, obj);
        }
        if (obj instanceof Collection) {
            return eE.a(fiVar, (Collection) obj);
        }
        eF.a(obj.getClass());
        return 0;
    }

    public static int a(fi fiVar, Map map) {
        int a2;
        if (map == null || map.isEmpty()) {
            return C0287ck.a(fiVar, 0, 0);
        }
        int size = map.size();
        eJ eJVar = new eJ(size);
        eJ eJVar2 = new eJ(size);
        for (Map.Entry entry : map.entrySet()) {
            String a3 = a(entry);
            if (a3 != null && (a2 = a(fiVar, a3, entry.getValue())) != 0) {
                eJVar.a(fiVar.a(a3));
                eJVar2.a(a2);
            }
        }
        return C0287ck.a(fiVar, C0287ck.a(fiVar, eJVar.c()), C0287ck.a(fiVar, eJVar2.c()));
    }

    private static Object a(String str, Object obj) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Skipping null value for key ");
            sb.append(str);
            Log.e(sb.toString());
            return null;
        }
        eB a2 = eB.a(obj.getClass());
        if (a2 != eB.Unhandled) {
            return eF.a(a2, obj);
        }
        if (obj instanceof Map) {
            return b((Map) obj);
        }
        if (obj.getClass().isArray()) {
            return eE.a(obj);
        }
        if (obj instanceof Collection) {
            return eE.a((Collection) obj);
        }
        eF.a(obj.getClass());
        return null;
    }

    private static String a(Map.Entry entry) {
        String str = (String) entry.getKey();
        String d = fa.d(str);
        if (d == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Skipping invalid key '");
            sb.append(str);
            sb.append("'");
            Log.e(sb.toString());
        }
        return d;
    }

    public static HashMap a(Map map) {
        Object a2;
        if (map == null || map.isEmpty()) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String a3 = a(entry);
            if (a3 != null && (a2 = a((String) entry.getKey(), entry.getValue())) != null) {
                hashMap.put(a3, a2);
            }
        }
        return hashMap;
    }

    private static int b(fi fiVar, Map map) {
        for (Object obj : map.keySet()) {
            if (!(obj instanceof String) && obj != null) {
                Log.e("Skipping Map containing non-String keys.");
                return 0;
            }
        }
        return C0285ci.a(fiVar, (byte) 1, a(fiVar, map));
    }

    private static HashMap b(Map map) {
        for (Object obj : map.keySet()) {
            if (!(obj instanceof String) && obj != null) {
                Log.e("Skipping Map containing non-String keys.");
                return null;
            }
        }
        return a(map);
    }
}
