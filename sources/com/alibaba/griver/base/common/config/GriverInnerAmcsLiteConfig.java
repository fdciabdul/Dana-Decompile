package com.alibaba.griver.base.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigProxy;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverInnerAmcsLiteConfig implements GriverConfigProxy, ISectionConfigListener {

    /* renamed from: a */
    private Map<String, String> f6285a = new ConcurrentHashMap();
    private volatile JSONObject b;

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public void clearProcessCache() {
        this.f6285a.clear();
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public void putConfigCache(String str, String str2) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, do not put", null);
        } else {
            this.f6285a.put(str, str2);
        }
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public String getConfigWithProcessCache(String str, String str2) {
        String string;
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        } else if (this.f6285a.containsKey(str)) {
            return this.f6285a.get(str);
        } else {
            JSONObject griverSectionConfig = getGriverSectionConfig();
            if (griverSectionConfig == null || (string = griverSectionConfig.getString(str)) == null) {
                return str2;
            }
            this.f6285a.put(str, string);
            return string;
        }
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public String getConfig(String str, String str2) {
        String string;
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        JSONObject griverSectionConfig = getGriverSectionConfig();
        if (griverSectionConfig == null || (string = griverSectionConfig.getString(str)) == null) {
            return str2;
        }
        this.f6285a.put(str, string);
        return string;
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public String getConfig(final String str, String str2, final GriverConfigProxy.OnConfigChangeListener onConfigChangeListener) {
        String string;
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        getSectionConfigWithListener("GriverConfig", new GriverConfigProxy.OnSectionConfigChangeListener() { // from class: com.alibaba.griver.base.common.config.GriverInnerAmcsLiteConfig.1
            {
                GriverInnerAmcsLiteConfig.this = this;
            }

            @Override // com.alibaba.griver.api.common.config.GriverConfigProxy.OnSectionConfigChangeListener
            public void onChange(JSONObject jSONObject) {
                GriverConfigProxy.OnConfigChangeListener onConfigChangeListener2;
                if (jSONObject == null || !jSONObject.containsKey(str) || (onConfigChangeListener2 = onConfigChangeListener) == null) {
                    return;
                }
                onConfigChangeListener2.onChange(jSONObject.getString(str));
                Map map = GriverInnerAmcsLiteConfig.this.f6285a;
                String str3 = str;
                map.put(str3, jSONObject.getString(str3));
            }
        });
        JSONObject griverSectionConfig = getGriverSectionConfig();
        if (griverSectionConfig == null || (string = griverSectionConfig.getString(str)) == null) {
            return str2;
        }
        this.f6285a.put(str, string);
        return string;
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public boolean getConfigBoolean(String str, boolean z) {
        Boolean bool;
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return false", null);
            return false;
        }
        JSONObject griverSectionConfig = getGriverSectionConfig();
        return (griverSectionConfig == null || (bool = griverSectionConfig.getBoolean(str)) == null) ? z : bool.booleanValue();
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public JSONObject getConfigJSONObject(String str) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        JSONObject griverSectionConfig = getGriverSectionConfig();
        if (griverSectionConfig == null) {
            return null;
        }
        return griverSectionConfig.getJSONObject(str);
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public JSONArray getConfigJSONArray(String str) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        JSONObject griverSectionConfig = getGriverSectionConfig();
        if (griverSectionConfig == null) {
            return null;
        }
        return griverSectionConfig.getJSONArray(str);
    }

    public JSONObject getGriverSectionConfig() {
        ConfigCenter configCenter;
        org.json.JSONObject sectionConfig;
        if (this.b == null && (sectionConfig = (configCenter = ConfigCenter.getInstance("GriverAppContainer")).getSectionConfig("GriverConfig")) != null) {
            this.b = JSON.parseObject(sectionConfig.toString());
            configCenter.addSectionConfigListener("GriverConfig", this);
        }
        if (this.b != null) {
            return this.b;
        }
        return null;
    }

    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
    public JSONObject getSectionConfig(String str) {
        if (str == null) {
            GriverLogger.w("GriverAmcsLiteConfig", "key should not be null, return null", null);
            return null;
        }
        org.json.JSONObject sectionConfig = ConfigCenter.getInstance("GriverAppContainer").getSectionConfig(str);
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
        org.json.JSONObject sectionConfig = ConfigCenter.getInstance("GriverAppContainer").getSectionConfig(str);
        ConfigCenter.getInstance("GriverAppContainer").addSectionConfigListener(str, new ISectionConfigListener() { // from class: com.alibaba.griver.base.common.config.GriverInnerAmcsLiteConfig.2
            {
                GriverInnerAmcsLiteConfig.this = this;
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

    @Override // com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener
    public void onConfigChanged(String str, org.json.JSONObject jSONObject, ChangedDetails changedDetails) {
        if (jSONObject != null) {
            this.b = JSON.parseObject(jSONObject.toString());
        }
    }
}
