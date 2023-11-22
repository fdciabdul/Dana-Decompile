package com.alipay.plus.android.config.sdk.a;

import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.ConfigMerger;
import com.alipay.plus.android.config.sdk.listener.ConfigChangeType;
import com.alipay.plus.android.config.sdk.listener.commonconfig.ICommonConfigListener;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ChangedDetails;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes7.dex */
public class b extends c<ICommonConfigListener> {
    private static final String b = e.a("CommonConfigListener");

    private void a(ConfigChangeType configChangeType, Set<String> set, JSONObject jSONObject) {
        if (set.isEmpty()) {
            return;
        }
        for (String str : set) {
            List list = (List) this.f7361a.get(str);
            if (list != null) {
                Object obj = jSONObject != null ? jSONObject.get(str) : null;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((ICommonConfigListener) it.next()).onCommonConfigChanged(str, obj, configChangeType);
                }
            }
        }
    }

    @Override // com.alipay.plus.android.config.sdk.a.c
    public void a(String str, JSONObject jSONObject, ChangedDetails changedDetails) {
        synchronized (this) {
            if (ConfigMerger.isCommonConfigSection(str)) {
                a(ConfigChangeType.Added, changedDetails.addedKeys, jSONObject);
                a(ConfigChangeType.Modified, changedDetails.modifiedKeys, jSONObject);
                a(ConfigChangeType.Deleted, changedDetails.deletedKeys, jSONObject);
                return;
            }
            String str2 = b;
            StringBuilder sb = new StringBuilder();
            sb.append("*** section is not Common-Config!!! section = ");
            sb.append(str);
            LoggerWrapper.e(str2, sb.toString());
        }
    }
}
