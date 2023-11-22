package com.alipay.iap.android.common.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class DefaultConfigService implements IConfigProvider {
    private HashMap<String, String> configMap = new HashMap<>(5);
    private HashMap<String, ICommonConfigChangeListener> configChangeListenerHashMap = new HashMap<>(1);
    private HashMap<String, ISectionConfigChangeListener> sectionConfigChangeListenerHashMap = new HashMap<>(1);

    public void addConfig(String str, String str2) {
        this.configMap.put(str, str2);
        ICommonConfigChangeListener iCommonConfigChangeListener = this.configChangeListenerHashMap.get(str);
        if (iCommonConfigChangeListener != null) {
            iCommonConfigChangeListener.onConfigChanged(str, str2);
            return;
        }
        ISectionConfigChangeListener iSectionConfigChangeListener = this.sectionConfigChangeListenerHashMap.get(str);
        if (iSectionConfigChangeListener != null) {
            iSectionConfigChangeListener.onSectionConfigChange(str, str2);
        }
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public String getConfig(String str) {
        return this.configMap.get(str);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public String getSectionConfig(String str) {
        return this.configMap.get(str);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void addCommonConfigChangeListener(String str, ICommonConfigChangeListener iCommonConfigChangeListener) {
        if (this.configChangeListenerHashMap.containsKey(str)) {
            return;
        }
        this.configChangeListenerHashMap.put(str, iCommonConfigChangeListener);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void removeCommonConfigChangeListener(ICommonConfigChangeListener iCommonConfigChangeListener) {
        Iterator<Map.Entry<String, ICommonConfigChangeListener>> it = this.configChangeListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            if (iCommonConfigChangeListener == it.next().getValue()) {
                it.remove();
            }
        }
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void addSectionConfigChangeListener(String str, ISectionConfigChangeListener iSectionConfigChangeListener) {
        if (this.sectionConfigChangeListenerHashMap.containsKey(str)) {
            return;
        }
        this.sectionConfigChangeListenerHashMap.put(str, iSectionConfigChangeListener);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void removeSectionConfigChangeListener(ISectionConfigChangeListener iSectionConfigChangeListener) {
        Iterator<Map.Entry<String, ISectionConfigChangeListener>> it = this.sectionConfigChangeListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            if (iSectionConfigChangeListener == it.next().getValue()) {
                it.remove();
            }
        }
    }
}
