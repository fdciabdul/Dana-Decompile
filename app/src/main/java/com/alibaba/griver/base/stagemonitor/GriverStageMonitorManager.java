package com.alibaba.griver.base.stagemonitor;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.stagemonitor.impl.GriverKeepAliveFullLinkStageMonitor;
import com.alibaba.griver.base.stagemonitor.impl.GriverPVMonitor;
import com.iap.ac.android.biz.common.constants.Constants;
import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class GriverStageMonitorManager {
    private static volatile GriverStageMonitorManager b;

    /* renamed from: a */
    private final ConcurrentHashMap<String, GriverStageMonitor> f6380a = new ConcurrentHashMap<>();

    private GriverStageMonitorManager() {
    }

    public static GriverStageMonitorManager getInstance() {
        if (b == null) {
            synchronized (GriverStageMonitorManager.class) {
                if (b == null) {
                    b = new GriverStageMonitorManager();
                }
            }
        }
        return b;
    }

    public void registerStageMonitor(String str, GriverStageMonitor griverStageMonitor) {
        if (!TextUtils.isEmpty(str) && this.f6380a.get(str) == null) {
            this.f6380a.put(str, griverStageMonitor);
        }
    }

    public void unRegisterStageMonitor(String str) {
        if (TextUtils.isEmpty(str) || this.f6380a.get(str) == null) {
            return;
        }
        this.f6380a.remove(str);
    }

    public <T extends GriverStageMonitor> T getStageMonitor(String str) {
        try {
            T t = (T) this.f6380a.get(str);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getStageMonitor exception: ");
            sb.append(th);
            GriverLogger.e(Constants.TAG, sb.toString());
            return null;
        }
    }

    public GriverFullLinkStageMonitor createFullStageMonitor(App app) {
        if (app == null) {
            return null;
        }
        String monitorToken = GriverFullLinkStageMonitor.getMonitorToken(app);
        if (this.f6380a.get(monitorToken) == null) {
            this.f6380a.put(monitorToken, new GriverFullLinkStageMonitor());
        }
        return (GriverFullLinkStageMonitor) this.f6380a.get(monitorToken);
    }

    public GriverFullLinkStageMonitor createFullStageMonitor(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String monitorToken = GriverFullLinkStageMonitor.getMonitorToken(str, str2);
        if (this.f6380a.get(monitorToken) == null) {
            this.f6380a.put(monitorToken, new GriverFullLinkStageMonitor());
        }
        return (GriverFullLinkStageMonitor) this.f6380a.get(monitorToken);
    }

    public GriverKeepAliveFullLinkStageMonitor createKeepAliveFullStageMonitor(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String monitorToken = GriverKeepAliveFullLinkStageMonitor.getMonitorToken(str, str2);
        if (this.f6380a.get(monitorToken) == null) {
            this.f6380a.put(monitorToken, new GriverKeepAliveFullLinkStageMonitor());
        }
        return (GriverKeepAliveFullLinkStageMonitor) this.f6380a.get(monitorToken);
    }

    public GriverPVMonitor createPVStageMonitor(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String monitorToken = GriverPVMonitor.getMonitorToken(str, str2);
        if (this.f6380a.get(monitorToken) == null) {
            this.f6380a.put(monitorToken, new GriverPVMonitor());
        }
        return (GriverPVMonitor) this.f6380a.get(monitorToken);
    }
}
