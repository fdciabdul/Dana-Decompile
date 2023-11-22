package com.ta.audid.a;

import android.content.Context;
import android.text.TextUtils;
import com.ta.audid.g.k;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> c(Context context) {
        HashMap hashMap = new HashMap();
        String m237a = c.m237a(context);
        String b = c.b(context);
        if (TextUtils.isEmpty(m237a)) {
            m237a = com.ta.audid.e.a.F();
        }
        if (TextUtils.isEmpty(b)) {
            b = com.ta.audid.e.a.G();
        }
        a(hashMap, "D1", m237a);
        a(hashMap, "D2", b);
        a(hashMap, "D3", c.c(context));
        a(hashMap, "D4", c.d());
        a(hashMap, "D5", c.e(context));
        a(hashMap, "D6", c.e());
        a(hashMap, "D7", c.f(context));
        a(hashMap, "D8", c.f());
        a(hashMap, "D9", c.g());
        a(hashMap, "D10", c.g(context));
        hashMap.put("D11", c.h());
        hashMap.put("D12", c.i());
        hashMap.put("D13", c.j());
        hashMap.put("D14", c.i(context));
        hashMap.put("D15", c.j(context));
        hashMap.put("D16", c.k(context));
        hashMap.put("D17", k.u(context));
        hashMap.put("D18", c.m238a(context) ? "1" : "0");
        hashMap.put("D19", c.a(context, 9) ? "1" : "0");
        hashMap.put("D20", c.m242e(context) ? "1" : "0");
        hashMap.put("D21", c.a(context, 4) ? "1" : "0");
        hashMap.put("D22", c.m241d(context) ? "1" : "0");
        return hashMap;
    }

    private static void a(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }
}
