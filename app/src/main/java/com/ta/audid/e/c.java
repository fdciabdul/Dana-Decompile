package com.ta.audid.e;

import android.content.Context;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    public static String b(String str) {
        Context context = com.ta.audid.a.a().getContext();
        return context == null ? "" : com.ta.utdid2.a.a.e.l(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", "audid", com.ta.audid.a.a().b(), a(str, com.ta.audid.f.e.J(), com.ta.audid.a.a().getAppkey(), context.getPackageName())));
    }

    private static String a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("audid", str2);
        hashMap.put("utdid", str);
        hashMap.put("appkey", str3);
        hashMap.put("appName", str4);
        return new JSONObject(com.ta.utdid2.a.a.e.a(hashMap)).toString();
    }

    public static String c(String str) {
        Context context = com.ta.audid.a.a().getContext();
        return context == null ? "" : com.ta.utdid2.a.a.e.l(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", Personalization.ANALYTICS_ORIGIN_PERSONALIZATION, com.ta.audid.a.a().b(), a(str, com.ta.audid.a.a().getAppkey(), context.getPackageName())));
    }

    private static String a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("utdid", str);
        hashMap.put("appkey", str2);
        hashMap.put("appName", str3);
        hashMap.put("fp_info", com.ta.audid.a.b.a(com.ta.audid.a.a().getContext()));
        return new JSONObject(hashMap).toString();
    }
}
