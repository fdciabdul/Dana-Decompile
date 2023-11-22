package com.alipay.plus.android.config.sdk.common;

import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.config.ICommonConfigChangeListener;
import com.alipay.iap.android.common.config.IConfigProvider;
import com.alipay.iap.android.common.config.ISectionConfigChangeListener;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.ConfigCenter;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.listener.ConfigChangeType;
import com.alipay.plus.android.config.sdk.listener.commonconfig.ICommonConfigListener;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ChangedDetails;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ISectionConfigListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class AmcsConfigProvider implements IConfigProvider {

    /* renamed from: a */
    private static final String f7364a = e.a("ConfigProvider");
    private Map<ICommonConfigChangeListener, List<ICommonConfigListener>> b = new HashMap();
    private Map<ISectionConfigChangeListener, List<ISectionConfigListener>> c = new HashMap();

    public AmcsConfigProvider() {
        LoggerWrapper.d(f7364a, "** new AmcsConfigProvider");
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void addCommonConfigChangeListener(String str, final ICommonConfigChangeListener iCommonConfigChangeListener) {
        synchronized (this) {
            ICommonConfigListener iCommonConfigListener = new ICommonConfigListener() { // from class: com.alipay.plus.android.config.sdk.common.AmcsConfigProvider.1
                {
                    AmcsConfigProvider.this = this;
                }

                @Override // com.alipay.plus.android.config.sdk.listener.commonconfig.ICommonConfigListener
                public void onCommonConfigChanged(String str2, Object obj, ConfigChangeType configChangeType) {
                    iCommonConfigChangeListener.onConfigChanged(str2, obj != null ? String.valueOf(obj) : null);
                }
            };
            List<ICommonConfigListener> list = this.b.get(iCommonConfigChangeListener);
            if (list == null) {
                list = new ArrayList<>();
                this.b.put(iCommonConfigChangeListener, list);
            }
            list.add(iCommonConfigListener);
            ConfigCenter.getInstance().addCommonConfigListener(str, iCommonConfigListener);
        }
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void addSectionConfigChangeListener(String str, final ISectionConfigChangeListener iSectionConfigChangeListener) {
        synchronized (this) {
            ISectionConfigListener iSectionConfigListener = new ISectionConfigListener() { // from class: com.alipay.plus.android.config.sdk.common.AmcsConfigProvider.2
                {
                    AmcsConfigProvider.this = this;
                }

                @Override // com.alipay.plus.android.config.sdk.listener.sectionconfig.ISectionConfigListener
                public void onConfigChanged(String str2, JSONObject jSONObject, ChangedDetails changedDetails) {
                    iSectionConfigChangeListener.onSectionConfigChange(str2, jSONObject != null ? jSONObject.toJSONString() : null);
                }
            };
            List<ISectionConfigListener> list = this.c.get(iSectionConfigChangeListener);
            if (list == null) {
                list = new ArrayList<>();
                this.c.put(iSectionConfigChangeListener, list);
            }
            list.add(iSectionConfigListener);
            ConfigCenter.getInstance().addSectionConfigListener(str, iSectionConfigListener);
        }
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public String getConfig(String str) {
        return ConfigCenter.getInstance().getStringConfig(str);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public String getSectionConfig(String str) {
        JSONObject sectionConfig = ConfigCenter.getInstance().getSectionConfig(str);
        if (sectionConfig != null) {
            return sectionConfig.toJSONString();
        }
        return null;
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void removeCommonConfigChangeListener(ICommonConfigChangeListener iCommonConfigChangeListener) {
        synchronized (this) {
            List<ICommonConfigListener> list = this.b.get(iCommonConfigChangeListener);
            if (list == null) {
                return;
            }
            ConfigCenter configCenter = ConfigCenter.getInstance();
            Iterator<ICommonConfigListener> it = list.iterator();
            while (it.hasNext()) {
                configCenter.removeCommonConfigListener(it.next());
            }
            list.clear();
        }
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void removeSectionConfigChangeListener(ISectionConfigChangeListener iSectionConfigChangeListener) {
        synchronized (this) {
            List<ISectionConfigListener> list = this.c.get(iSectionConfigChangeListener);
            if (list == null) {
                return;
            }
            ConfigCenter configCenter = ConfigCenter.getInstance();
            Iterator<ISectionConfigListener> it = list.iterator();
            while (it.hasNext()) {
                configCenter.removeSectionConfigListener(it.next());
            }
            list.clear();
        }
    }
}
