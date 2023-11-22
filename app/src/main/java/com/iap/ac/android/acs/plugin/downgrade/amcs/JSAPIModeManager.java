package com.iap.ac.android.acs.plugin.downgrade.amcs;

import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class JSAPIModeManager extends BaseDowngradeConfigManager {
    public static JSAPIModeManager sInstance;

    public static JSAPIModeManager getInstance() {
        if (sInstance == null) {
            synchronized (JSAPIModeManager.class) {
                if (sInstance == null) {
                    sInstance = new JSAPIModeManager();
                }
            }
        }
        return sInstance;
    }

    private List<String> getListOrDefault(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = (JSONArray) getKeyOrDefault(str, null);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("JSAPIModeManager#getListOrDefault, parse ");
            sb.append(str);
            sb.append(" error: ");
            sb.append(th);
            ACLog.e("IAPConnectPlugin", sb.toString());
            arrayList.clear();
        }
        return arrayList;
    }

    public List<String> getBlackList() {
        return getListOrDefault("blackList");
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.amcs.BaseDowngradeConfigManager
    public String getSectionName() {
        return "ACJSAPIMode";
    }

    public List<String> getWhiteList() {
        return getListOrDefault("whiteList");
    }
}
