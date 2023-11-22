package com.iap.ac.config.lite.d;

import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.ConfigMerger;
import com.iap.ac.config.lite.listener.ConfigChangeType;
import com.iap.ac.config.lite.listener.commonconfig.ICommonConfigListener;
import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b extends c<ICommonConfigListener> {
    private static final String b = e.b("CommonConfigListener");

    @Override // com.iap.ac.config.lite.d.c
    public void a(String str, JSONObject jSONObject, ChangedDetails changedDetails) {
        synchronized (this) {
            if (!ConfigMerger.isCommonConfigSection(str)) {
                String str2 = b;
                StringBuilder sb = new StringBuilder();
                sb.append("*** section is not Common-Config!!! section = ");
                sb.append(str);
                ACLog.e(str2, sb.toString());
                return;
            }
            a(ConfigChangeType.ADDED, changedDetails.addedKeys, jSONObject);
            a(ConfigChangeType.MODIFIED, changedDetails.modifiedKeys, jSONObject);
            a(ConfigChangeType.DELETED, changedDetails.deletedKeys, jSONObject);
        }
    }

    private void a(ConfigChangeType configChangeType, Set<String> set, JSONObject jSONObject) {
        if (set.isEmpty()) {
            return;
        }
        for (String str : set) {
            List list = (List) this.f7630a.get(str);
            if (list != null) {
                Object opt = jSONObject != null ? jSONObject.opt(str) : null;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((ICommonConfigListener) it.next()).onCommonConfigChanged(str, opt, configChangeType);
                }
            }
        }
    }
}
