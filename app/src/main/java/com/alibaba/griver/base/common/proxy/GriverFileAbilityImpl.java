package com.alibaba.griver.base.common.proxy;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverFileAbilityImpl implements RVFileAbilityProxy {
    @Override // com.alibaba.griver.base.common.proxy.RVFileAbilityProxy
    public boolean hasFolderPermission(String str) {
        return true;
    }

    @Override // com.alibaba.griver.base.common.proxy.RVFileAbilityProxy
    public boolean saveIdWithPath(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("save id with path, id: ");
            sb.append(str);
            sb.append(", path: ");
            sb.append(str2);
            GriverLogger.d("GriverFileAbilityImpl", sb.toString());
            SharedPreferences a2 = a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            if (a2 != null) {
                a2.edit().putString(str, str2).commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            GriverLogger.e("GriverFileAbilityImpl", "savePathAndLocalId exception:", e);
            return false;
        }
    }

    @Override // com.alibaba.griver.base.common.proxy.RVFileAbilityProxy
    public String queryPathByLocalId(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("query path by id: ");
            sb.append(str);
            GriverLogger.d("GriverFileAbilityImpl", sb.toString());
            SharedPreferences a2 = a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            if (a2 != null) {
                return a2.getString(str, "");
            }
        } catch (Exception e) {
            GriverLogger.e("GriverFileAbilityImpl", "queryPathByLocalId exception:", e);
        }
        return "";
    }

    @Override // com.alibaba.griver.base.common.proxy.RVFileAbilityProxy
    public String queryLocalIdByPath(String str) {
        try {
            Map<String, ?> all = a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()).getAll();
            if (all != null) {
                for (String str2 : all.keySet()) {
                    if (((String) all.get(str2)).equals(str)) {
                        return str2;
                    }
                }
                return "";
            }
            return "";
        } catch (Exception e) {
            GriverLogger.e("GriverFileAbilityImpl", "queryLocalIdByPath exception:", e);
            return "";
        }
    }

    @Override // com.alibaba.griver.base.common.proxy.RVFileAbilityProxy
    public String getUserId() {
        return GriverAccount.getUserId();
    }

    private SharedPreferences a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("griver_local_storage_GriverFileAbilityImpl", 0);
        }
        return null;
    }
}
