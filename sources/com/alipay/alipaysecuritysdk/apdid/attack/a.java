package com.alipay.alipaysecuritysdk.apdid.attack;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private int f6847a;
    private Map<String, List<String>> b = new HashMap();

    public a(int i) {
        this.f6847a = 0;
        this.f6847a = i;
    }

    public final void a(String str, String str2) {
        if (this.b.containsKey(str)) {
            if (this.b.get(str).contains(str2)) {
                return;
            }
            this.b.get(str).add(str2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        this.b.put(str, arrayList);
    }

    public final JSONArray a() {
        if (this.b.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : this.b.keySet()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray2 = new JSONArray((Collection) this.b.get(str));
            try {
                byte[] a2 = com.alipay.alipaysecuritysdk.common.e.a.a(str);
                File file = new File(str);
                long length = file.exists() ? file.length() : 0L;
                File file2 = new File(str);
                long lastModified = file2.exists() ? file2.lastModified() / 1000 : 0L;
                String b = com.alipay.alipaysecuritysdk.common.b.b.b(a2);
                String a3 = com.alipay.alipaysecuritysdk.common.b.b.a(a2);
                jSONObject.put("kind", this.f6847a);
                jSONObject.put("plugin", str);
                jSONObject.put("function", jSONArray2);
                jSONObject.put(LottieParams.KEY_MD5, b);
                jSONObject.put("sha1", a3);
                jSONObject.put(GriverMonitorConstants.KEY_SIZE, length);
                jSONObject.put("mtime", lastModified);
            } catch (JSONException unused) {
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
