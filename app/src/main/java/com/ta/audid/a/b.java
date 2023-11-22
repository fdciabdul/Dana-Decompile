package com.ta.audid.a;

import android.content.Context;
import com.ta.audid.g.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    private static Map<String, String> b(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("V", "1.0");
        hashMap.putAll(d.c(context));
        hashMap.putAll(g.d(context));
        hashMap.putAll(a.a(context));
        return hashMap;
    }

    public static JSONObject a(Context context) {
        if (m.isDebug()) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject(com.ta.utdid2.a.a.e.a(b(context)));
            m.m249a(jSONObject.toString(), new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("getFPInfo time:");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            m.m249a(sb.toString(), new Object[0]);
            return jSONObject;
        }
        return new JSONObject(b(context));
    }
}
