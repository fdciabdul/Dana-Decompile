package com.alipay.alipaysecuritysdk.rds.v2.b.a;

import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.core.jsapi.actionsheet.ActionSheetItem;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e extends com.alipay.alipaysecuritysdk.rds.v2.b.b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f6880a = {"type", "pn", "cn", "et", "ad", SecurityConstants.KEY_TEXT, "seq", ActionSheetItem.BadgeInfo.TYPE_NUM};
    private Map<String, Object> b = new HashMap();
    private List<Map<String, String>> c = new ArrayList();

    public e(String str, String str2, int i) {
        this.b.put("type", str2);
        this.b.put("pn", com.alipay.alipaysecuritysdk.common.e.e.c(str) ? "-" : str);
        this.b.put("cn", "-");
        this.b.put("et", RVParams.SAFEPAY_ENABLE);
        this.b.put("ad", this.c);
        this.b.put("seq", String.valueOf(i));
        this.b.put(ActionSheetItem.BadgeInfo.TYPE_NUM, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alipay.alipaysecuritysdk.rds.v2.b.b
    /* renamed from: b  reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        Map<String, Object> map = this.b;
        map.put(ActionSheetItem.BadgeInfo.TYPE_NUM, String.valueOf(map.get(ActionSheetItem.BadgeInfo.TYPE_NUM)));
        for (String str : f6880a) {
            Object obj = this.b.get(str);
            if (obj != null && (obj instanceof String)) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException unused) {
                }
            } else if (obj != null && (obj instanceof com.alipay.alipaysecuritysdk.rds.v2.b.b)) {
                jSONObject.put(str, ((com.alipay.alipaysecuritysdk.rds.v2.b.b) obj).a());
            } else if (obj != null && (obj instanceof Map)) {
                JSONObject jSONObject2 = new JSONObject();
                Map map2 = (Map) obj;
                for (String str2 : map2.keySet()) {
                    jSONObject2.put(str2, map2.get(str2));
                }
                jSONObject.put(str, jSONObject2);
            } else if (obj != null && (obj instanceof List)) {
                List list = (List) obj;
                if (list.size() > 20) {
                    list = list.subList(list.size() - 20, list.size());
                }
                jSONObject.put(str, com.alipay.alipaysecuritysdk.common.e.b.a(list));
            }
        }
        return jSONObject;
    }

    public final void a(String str) {
        synchronized (this) {
            HashMap hashMap = new HashMap();
            hashMap.put(RVParams.PULL_REFRESH, str);
            hashMap.put(SecurityConstants.KEY_TEXT, String.valueOf(System.currentTimeMillis()));
            this.c.add(hashMap);
        }
    }
}
