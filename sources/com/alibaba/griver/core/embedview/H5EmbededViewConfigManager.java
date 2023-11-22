package com.alibaba.griver.core.embedview;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class H5EmbededViewConfigManager {
    public static final String TAG = "H5EmbededViewConfigManager";

    /* renamed from: a  reason: collision with root package name */
    private static H5EmbededViewConfigManager f6399a;
    private Map<String, H5EmbedViewConfig> b = new ConcurrentHashMap();

    private H5EmbededViewConfigManager() {
    }

    public static H5EmbededViewConfigManager getInstance() {
        if (f6399a == null) {
            synchronized (H5EmbededViewConfigManager.class) {
                if (f6399a == null) {
                    f6399a = new H5EmbededViewConfigManager();
                }
            }
        }
        return f6399a;
    }

    public void addTypeConfig(H5EmbedViewConfig h5EmbedViewConfig) {
        synchronized (this) {
            if (h5EmbedViewConfig == null) {
                return;
            }
            String type = h5EmbedViewConfig.getType();
            String bundleName = h5EmbedViewConfig.getBundleName();
            String className = h5EmbedViewConfig.getClassName();
            StringBuilder sb = new StringBuilder();
            sb.append("addType ");
            sb.append(bundleName);
            sb.append("/");
            sb.append(className);
            sb.append("/");
            sb.append(type);
            RVLogger.d(TAG, sb.toString());
            if (this.b.containsKey(type)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("addType repeated type ");
                sb2.append(type);
                RVLogger.d(TAG, sb2.toString());
            } else {
                this.b.put(type, h5EmbedViewConfig);
            }
        }
    }

    public void addTypeConfigs(List<H5EmbedViewConfig> list) {
        synchronized (this) {
            if (list != null) {
                if (!list.isEmpty()) {
                    Iterator<H5EmbedViewConfig> it = list.iterator();
                    while (it.hasNext()) {
                        addTypeConfig(it.next());
                    }
                }
            }
        }
    }

    public H5EmbedViewConfig getConfig(String str) {
        return this.b.get(str);
    }
}
