package com.ta.audid.filesync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ta.audid.e.e;
import com.ta.audid.g.j;
import com.ta.audid.g.m;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UtdidBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        String str;
        m.d();
        try {
            str = intent.getAction();
        } catch (Exception unused) {
            str = "";
        }
        if ("com.action.utdid".equalsIgnoreCase(str)) {
            j.a().submit(new Runnable() { // from class: com.ta.audid.filesync.UtdidBroadcastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String stringExtra = intent.getStringExtra("data");
                        String stringExtra2 = intent.getStringExtra("sign");
                        String d = e.d(stringExtra);
                        JSONObject jSONObject = new JSONObject(d);
                        String string = jSONObject.has("utdid") ? jSONObject.getString("utdid") : "";
                        if (jSONObject.has("appkey")) {
                            jSONObject.getString("appkey");
                        }
                        String string2 = jSONObject.has("appName") ? jSONObject.getString("appName") : "";
                        String E = com.ta.audid.c.a.a().E();
                        StringBuilder sb = new StringBuilder();
                        sb.append("currentAppUtdid:");
                        sb.append(E);
                        sb.append(",intentUtdid:");
                        sb.append(string);
                        m.m249a("", sb.toString());
                        if (TextUtils.isEmpty(E) || TextUtils.isEmpty(string) || E.equals(string)) {
                            return;
                        }
                        String packageName = context.getPackageName();
                        if (TextUtils.isEmpty(packageName) || !packageName.equals(string2)) {
                            return;
                        }
                        String h = com.ta.audid.g.e.h(d);
                        if (TextUtils.isEmpty(h) || !h.equalsIgnoreCase(stringExtra2)) {
                            return;
                        }
                        com.ta.audid.c.a.a().b(string);
                    } catch (Exception e) {
                        m.d("", e);
                    }
                }
            });
        }
    }
}
