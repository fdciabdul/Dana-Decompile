package com.alibaba.griver.base.common.config;

import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigProxy;

/* loaded from: classes6.dex */
public class GriverRVConfigServiceImpl implements RVConfigService {
    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public void clearProcessCache() {
        GriverConfig.clearProcessCache();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public void putConfigCache(String str, String str2) {
        GriverConfig.putConfigCache(str, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public String getConfigWithProcessCache(String str, String str2) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -950091132:
                if (str.equals("ta_appxStartupConfigItem4NG")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -891621777:
                if (str.equals("ta_appxStartupConfigItem4Snapshot")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -690127702:
                if (str.equals("ta_appxStartupConfigKeys")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 611933839:
                if (str.equals("ta_appxStartupConfigItem4API")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1790292110:
                if (str.equals("ta_appxStartupConfigItem4Gray")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        return c != 0 ? c != 1 ? c != 2 ? c != 3 ? c != 4 ? GriverConfig.getConfigWithProcessCache(str, str2) : "{\"profileT2\":[{\"version\":[\"2.7.16\",\"2.999\"],\"value\":3}],\"profileEnable\":[{\"version\":[\"2.7.16\",\"2.999\"],\"value\":true}]}" : "{\"profileT2\":[{\"version\":[\"2.7.16\",\"2.999\"],\"value\":3}]}" : "[\"ta_appxStartupConfigItem4Snapshot\",\"ta_appxStartupConfigItem4NG\",\"ta_appxStartupConfigItem4API\", \"ta_appxStartupConfigItem4Gray\"]" : "{\"appxngSnapshot\":[{\"version\":[\"2.7.4\",\"2.999\"],\"value\":true}]}" : "{\"enableAuditLogUpload\":[{\"version\":[\"2.7.4\",\"2.999\"],\"value\":true}]}";
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public String getConfig(String str, String str2) {
        return "ta_JsiQjsConfig".equals(str) ? "1.0" : GriverConfig.getConfig(str, str2);
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public String getConfig(String str, String str2, final RVConfigService.OnConfigChangeListener onConfigChangeListener) {
        return GriverConfig.getConfig(str, str2, new GriverConfigProxy.OnConfigChangeListener() { // from class: com.alibaba.griver.base.common.config.GriverRVConfigServiceImpl.1
            @Override // com.alibaba.griver.api.common.config.GriverConfigProxy.OnConfigChangeListener
            public void onChange(String str3) {
                RVConfigService.OnConfigChangeListener onConfigChangeListener2 = onConfigChangeListener;
                if (onConfigChangeListener2 != null) {
                    onConfigChangeListener2.onChange(str3);
                }
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public boolean getConfigBoolean(String str, boolean z) {
        return GriverConfig.getConfigBoolean(str, z);
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public JSONObject getConfigJSONObject(String str) {
        return GriverConfig.getConfigJSONObject(str);
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public JSONArray getConfigJSONArray(String str) {
        return GriverConfig.getConfigJSONArray(str);
    }
}
