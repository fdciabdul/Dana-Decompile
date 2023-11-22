package com.alipay.plus.android.config.sdk.a;

import com.alibaba.fastjson.JSONObject;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ChangedDetails;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ISectionConfigListener;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class f extends c<ISectionConfigListener> {
    private static final String b = e.a("SectionConfigListener");

    @Override // com.alipay.plus.android.config.sdk.a.c
    public void a(String str, JSONObject jSONObject, ChangedDetails changedDetails) {
        synchronized (this) {
            List list = (List) this.f7361a.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((ISectionConfigListener) it.next()).onConfigChanged(str, jSONObject, changedDetails);
                }
            }
        }
    }
}
