package com.iap.ac.config.lite.utils;

import com.iap.ac.android.common.config.ConfigRefreshCallback;
import com.iap.ac.android.common.config.IACConfig;
import com.iap.ac.android.common.config.IConfigChangeListener;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.fetcher.ConfigNotifyCallback;
import com.iap.ac.config.lite.listener.ConfigChangeType;
import com.iap.ac.config.lite.listener.commonconfig.ICommonConfigListener;
import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigProxy implements IACConfig {

    /* renamed from: a */
    private Map<IConfigChangeListener, List<ICommonConfigListener>> f7653a = new HashMap();
    private Map<IConfigChangeListener, List<ISectionConfigListener>> b = new HashMap();
    private ConfigCenter c;

    /* loaded from: classes3.dex */
    class a implements ConfigNotifyCallback {

        /* renamed from: a */
        final /* synthetic */ ConfigRefreshCallback f7654a;

        a(ConfigProxy configProxy, ConfigRefreshCallback configRefreshCallback) {
            this.f7654a = configRefreshCallback;
        }

        @Override // com.iap.ac.config.lite.fetcher.ConfigNotifyCallback
        public void onFetchFailed(String str, String str2) {
            ConfigRefreshCallback configRefreshCallback = this.f7654a;
            if (configRefreshCallback != null) {
                configRefreshCallback.onFetchFailed(str, str2);
            }
        }

        @Override // com.iap.ac.config.lite.fetcher.ConfigNotifyCallback
        public void onFetchSuccess(JSONObject jSONObject) {
            ConfigRefreshCallback configRefreshCallback = this.f7654a;
            if (configRefreshCallback != null) {
                configRefreshCallback.onFetchSuccess(jSONObject);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements ConfigNotifyCallback {

        /* renamed from: a */
        final /* synthetic */ ConfigRefreshCallback f7655a;

        b(ConfigProxy configProxy, ConfigRefreshCallback configRefreshCallback) {
            this.f7655a = configRefreshCallback;
        }

        @Override // com.iap.ac.config.lite.fetcher.ConfigNotifyCallback
        public void onFetchFailed(String str, String str2) {
            ConfigRefreshCallback configRefreshCallback = this.f7655a;
            if (configRefreshCallback != null) {
                configRefreshCallback.onFetchFailed(str, str2);
            }
        }

        @Override // com.iap.ac.config.lite.fetcher.ConfigNotifyCallback
        public void onFetchSuccess(JSONObject jSONObject) {
            ConfigRefreshCallback configRefreshCallback = this.f7655a;
            if (configRefreshCallback != null) {
                configRefreshCallback.onFetchSuccess(jSONObject);
            }
        }
    }

    /* loaded from: classes3.dex */
    class c implements ICommonConfigListener {

        /* renamed from: a */
        final /* synthetic */ IConfigChangeListener f7656a;

        c(ConfigProxy configProxy, IConfigChangeListener iConfigChangeListener) {
            this.f7656a = iConfigChangeListener;
        }

        @Override // com.iap.ac.config.lite.listener.commonconfig.ICommonConfigListener
        public void onCommonConfigChanged(String str, Object obj, ConfigChangeType configChangeType) {
            this.f7656a.onConfigChanged(str, obj);
        }
    }

    /* loaded from: classes3.dex */
    class d implements ISectionConfigListener {

        /* renamed from: a */
        final /* synthetic */ IConfigChangeListener f7657a;

        d(ConfigProxy configProxy, IConfigChangeListener iConfigChangeListener) {
            this.f7657a = iConfigChangeListener;
        }

        @Override // com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener
        public void onConfigChanged(String str, JSONObject jSONObject, ChangedDetails changedDetails) {
            this.f7657a.onSectionConfigChanged(str, jSONObject);
        }
    }

    static {
        e.b("ConfigProvider");
    }

    private ConfigProxy(String str) {
        this.c = ConfigCenter.getInstance(str);
    }

    private void a(List<ICommonConfigListener> list) {
        if (list != null) {
            Iterator<ICommonConfigListener> it = list.iterator();
            while (it.hasNext()) {
                this.c.removeCommonConfigListener(it.next());
            }
            list.clear();
        }
    }

    private void b(List<ISectionConfigListener> list) {
        if (list != null) {
            Iterator<ISectionConfigListener> it = list.iterator();
            while (it.hasNext()) {
                this.c.removeSectionConfigListener(it.next());
            }
            list.clear();
        }
    }

    public static ConfigProxy newInstance(String str) {
        return new ConfigProxy(str);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public void addCommonConfigChangeListener(String str, IConfigChangeListener iConfigChangeListener) {
        synchronized (this) {
            c cVar = new c(this, iConfigChangeListener);
            List<ICommonConfigListener> list = this.f7653a.get(iConfigChangeListener);
            if (list == null) {
                list = new ArrayList<>();
                this.f7653a.put(iConfigChangeListener, list);
            }
            list.add(cVar);
            this.c.addCommonConfigListener(str, cVar);
        }
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public void addSectionConfigChangeListener(String str, IConfigChangeListener iConfigChangeListener) {
        synchronized (this) {
            d dVar = new d(this, iConfigChangeListener);
            List<ISectionConfigListener> list = this.b.get(iConfigChangeListener);
            if (list == null) {
                list = new ArrayList<>();
                this.b.put(iConfigChangeListener, list);
            }
            list.add(dVar);
            this.c.addSectionConfigListener(str, dVar);
        }
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public boolean getBoolean(String str, boolean z) {
        return this.c.getBoolConfig(str, z);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public double getDouble(String str, double d2) {
        return this.c.getDoubleConfig(str, d2);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public int getInt(String str, int i) {
        return this.c.getIntConfig(str, i);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public JSONArray getJSONArrayConfig(String str) {
        return this.c.getJSONArrayConfig(str);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public JSONObject getJSONConfig(String str) {
        return this.c.getJSONConfig(str);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public long getLong(String str, long j) {
        return this.c.getLongConfig(str, j);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public JSONObject getSectionConfig(String str) {
        return this.c.getSectionConfig(str);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public String getString(String str) {
        return this.c.getStringConfig(str);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public void refreshByKeys(List<String> list, Map<String, Object> map, ConfigRefreshCallback configRefreshCallback) {
        this.c.refreshByKeys(list, map, new a(this, configRefreshCallback), true);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public void refreshConfig(Map<String, Object> map, boolean z) {
        if (z) {
            this.c.refreshConfigWithFrequenceLimit(map);
        } else {
            this.c.refreshConfig(map);
        }
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public void removeAllConfigChangeListener() {
        Iterator<List<ICommonConfigListener>> it = this.f7653a.values().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        Iterator<List<ISectionConfigListener>> it2 = this.b.values().iterator();
        while (it2.hasNext()) {
            b(it2.next());
        }
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public void removeConfiChangeListener(IConfigChangeListener iConfigChangeListener) {
        b(this.b.get(iConfigChangeListener));
        a(this.f7653a.get(iConfigChangeListener));
    }

    public static ConfigProxy newInstance() {
        return newInstance(null);
    }

    @Override // com.iap.ac.android.common.config.IACConfig
    public void refreshByKeys(String str, List<String> list, Map<String, Object> map, ConfigRefreshCallback configRefreshCallback) {
        this.c.refreshByKeys(str, list, map, new b(this, configRefreshCallback), true);
    }
}
