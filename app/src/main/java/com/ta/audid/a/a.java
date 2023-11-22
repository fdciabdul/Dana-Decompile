package com.ta.audid.a;

import android.content.Context;
import android.os.Process;
import com.ta.audid.g.l;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("A1", com.ta.audid.a.a().getAppkey());
        hashMap.put("A2", com.ta.audid.g.a.t(context));
        StringBuilder sb = new StringBuilder();
        sb.append(com.ta.audid.g.a.b(context));
        hashMap.put("A3", sb.toString());
        hashMap.put("A4", com.ta.audid.d.d.h(context) ? "1" : "0");
        hashMap.put("A5", com.ta.audid.d.d.i(context) ? "1" : "0");
        hashMap.put("A6", com.ta.audid.d.d.j(context) ? "1" : "0");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Process.myPid());
        hashMap.put("A7", sb2.toString());
        hashMap.put("A8", com.ta.audid.g.a.getCurProcessName(context));
        hashMap.put("A9", com.ta.audid.g.a.s(context));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(System.currentTimeMillis());
        hashMap.put("A10", sb3.toString());
        hashMap.put("A11", com.ta.audid.a.a().m235a());
        hashMap.put("A13", l.V());
        hashMap.put("A14", l.W());
        hashMap.put("A15", "2.1.2");
        return hashMap;
    }
}
