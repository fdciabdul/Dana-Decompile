package com.alibaba.griver.base.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigProxy;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.listener.ConfigChangeType;
import com.iap.ac.config.lite.listener.commonconfig.ICommonConfigListener;
import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverAmcsLiteConfig implements GriverConfigProxy {

    /* renamed from: a */
    private Map<String, String> f6283a = new ConcurrentHashMap();

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public void clearProcessCache() {
        this.f6283a.clear();
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public void putConfigCache(String str, String str2) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, do not put", null);
        } else {
            this.f6283a.put(str, str2);
        }
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public String getConfigWithProcessCache(String str, String str2) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        } else if (this.f6283a.containsKey(str)) {
            return this.f6283a.get(str);
        } else {
            String stringConfig = ConfigCenter.getInstance().getStringConfig(str);
            if (stringConfig == null) {
                return str2;
            }
            this.f6283a.put(str, stringConfig);
            return stringConfig;
        }
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public String getConfig(String str, String str2) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        String stringConfig = ConfigCenter.getInstance().getStringConfig(str);
        if (stringConfig == null) {
            return str2;
        }
        this.f6283a.put(str, stringConfig);
        return stringConfig;
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public String getConfig(final String str, String str2, final GriverConfigProxy.OnConfigChangeListener onConfigChangeListener) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        ConfigCenter.getInstance().addCommonConfigListener(str, new ICommonConfigListener() { // from class: com.alibaba.griver.base.common.config.GriverAmcsLiteConfig.1
            {
                GriverAmcsLiteConfig.this = this;
            }

            @Override // com.iap.ac.config.lite.listener.commonconfig.ICommonConfigListener
            public void onCommonConfigChanged(String str3, Object obj, ConfigChangeType configChangeType) {
                GriverConfigProxy.OnConfigChangeListener onConfigChangeListener2 = onConfigChangeListener;
                if (onConfigChangeListener2 == null || !(obj instanceof String)) {
                    return;
                }
                String str4 = (String) obj;
                onConfigChangeListener2.onChange(str4);
                GriverAmcsLiteConfig.this.f6283a.put(str, str4);
            }
        });
        String stringConfig = ConfigCenter.getInstance().getStringConfig(str);
        if (stringConfig == null) {
            return str2;
        }
        this.f6283a.put(str, stringConfig);
        return stringConfig;
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public boolean getConfigBoolean(String str, boolean z) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return false", null);
            return false;
        }
        return ConfigCenter.getInstance().getBoolConfig(str, z);
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public JSONObject getConfigJSONObject(String str) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        org.json.JSONObject jSONConfig = ConfigCenter.getInstance().getJSONConfig(str);
        if (jSONConfig == null) {
            return null;
        }
        try {
            return JSON.parseObject(jSONConfig.toString());
        } catch (Exception e) {
            GriverLogger.e("GriverAmcsLiteConfig", "parse original json object failed", e);
            return null;
        }
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public JSONArray getConfigJSONArray(String str) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        org.json.JSONArray jSONArrayConfig = ConfigCenter.getInstance().getJSONArrayConfig(str);
        if (jSONArrayConfig == null) {
            return null;
        }
        try {
            return JSON.parseArray(jSONArrayConfig.toString());
        } catch (Exception e) {
            GriverLogger.e("GriverAmcsLiteConfig", "parse original json array failed", e);
            return null;
        }
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public JSONObject getSectionConfig(String str) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        org.json.JSONObject sectionConfig = ConfigCenter.getInstance().getSectionConfig(str);
        if (sectionConfig == null) {
            return null;
        }
        try {
            return JSON.parseObject(sectionConfig.toString());
        } catch (Exception e) {
            GriverLogger.e("GriverAmcsLiteConfig", "parse original json object failed", e);
            return null;
        }
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public JSONObject getSectionConfigWithListener(String str, final GriverConfigProxy.OnSectionConfigChangeListener onSectionConfigChangeListener) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        org.json.JSONObject sectionConfig = ConfigCenter.getInstance().getSectionConfig(str);
        ConfigCenter.getInstance().addSectionConfigListener(str, new ISectionConfigListener() { // from class: com.alibaba.griver.base.common.config.GriverAmcsLiteConfig.2
            {
                GriverAmcsLiteConfig.this = this;
            }

            @Override // com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener
            public void onConfigChanged(String str2, org.json.JSONObject jSONObject, ChangedDetails changedDetails) {
                GriverConfigProxy.OnSectionConfigChangeListener onSectionConfigChangeListener2 = onSectionConfigChangeListener;
                if (onSectionConfigChangeListener2 != null) {
                    if (jSONObject != null) {
                        try {
                            onSectionConfigChangeListener2.onChange(JSON.parseObject(jSONObject.toString()));
                            return;
                        } catch (Exception e) {
                            GriverLogger.e("GriverAmcsLiteConfig", "parse original json object failed", e);
                            onSectionConfigChangeListener.onChange(null);
                            return;
                        }
                    }
                    onSectionConfigChangeListener2.onChange(null);
                }
            }
        });
        if (sectionConfig == null) {
            return null;
        }
        try {
            return JSON.parseObject(sectionConfig.toString());
        } catch (Exception e) {
            GriverLogger.e("GriverAmcsLiteConfig", "parse original json object failed", e);
            return null;
        }
    }
}
