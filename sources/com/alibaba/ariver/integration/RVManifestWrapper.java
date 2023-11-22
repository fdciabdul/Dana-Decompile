package com.alibaba.ariver.integration;

import android.util.Log;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class RVManifestWrapper implements RVManifest {

    /* renamed from: a  reason: collision with root package name */
    private List<RVManifest> f6054a;
    private RVProxy.Printer b;
    private AccessController c;
    private RemoteController d;
    private boolean e = false;
    private final List<RVManifest.IProxyManifest> f = new ArrayList();
    private boolean g = false;
    private final List<RVManifest.BridgeExtensionManifest> h = new ArrayList();
    private final List<BridgeDSL> i = new ArrayList();
    private boolean j = false;
    private final Map<String, EmbedViewMetaInfo> k = new HashMap();
    private boolean l = false;
    private final List<ExtensionMetaInfo> m = new ArrayList();
    private boolean n = false;

    /* renamed from: o  reason: collision with root package name */
    private final List<RVManifest.ServiceBeanManifest> f6055o = new ArrayList();
    private boolean p = false;
    private final List<AppUpdaterFactory.Rule> q = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public RVManifestWrapper(List<RVManifest> list, RVProxy.Printer printer) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f6054a = list;
        this.b = printer;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        synchronized (this.f) {
            if (this.e) {
                return this.f;
            }
            this.e = true;
            for (RVManifest rVManifest : this.f6054a) {
                if (rVManifest != null) {
                    try {
                        List<RVManifest.IProxyManifest> proxies = rVManifest.getProxies();
                        if (proxies != null) {
                            this.f.addAll(proxies);
                        }
                    } catch (Throwable th) {
                        RVProxy.Printer printer = this.b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("compose RVManifest ");
                        sb.append(rVManifest);
                        sb.append(" error! ");
                        sb.append(Log.getStackTraceString(th));
                        printer.print(sb.toString());
                    }
                }
            }
            return this.f;
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public AccessController getAccessController() {
        for (RVManifest rVManifest : this.f6054a) {
            if (rVManifest != null) {
                try {
                    AccessController accessController = rVManifest.getAccessController();
                    if (accessController != null) {
                        this.c = accessController;
                    }
                } catch (Throwable th) {
                    RVProxy.Printer printer = this.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("compose RVManifest ");
                    sb.append(rVManifest);
                    sb.append(" error! ");
                    sb.append(Log.getStackTraceString(th));
                    printer.print(sb.toString());
                }
            }
        }
        return this.c;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public RemoteController getRemoteController() {
        for (RVManifest rVManifest : this.f6054a) {
            if (rVManifest != null) {
                try {
                    RemoteController remoteController = rVManifest.getRemoteController();
                    if (remoteController != null) {
                        this.d = remoteController;
                    }
                } catch (Throwable th) {
                    RVProxy.Printer printer = this.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("compose RVManifest ");
                    sb.append(rVManifest);
                    sb.append(" error! ");
                    sb.append(Log.getStackTraceString(th));
                    printer.print(sb.toString());
                }
            }
        }
        return this.d;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        synchronized (this.h) {
            if (this.g) {
                return this.h;
            }
            this.g = true;
            for (RVManifest rVManifest : this.f6054a) {
                if (rVManifest != null) {
                    try {
                        List<RVManifest.BridgeExtensionManifest> bridgeExtensions = rVManifest.getBridgeExtensions();
                        if (bridgeExtensions != null) {
                            this.h.addAll(bridgeExtensions);
                        }
                    } catch (Throwable th) {
                        RVProxy.Printer printer = this.b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("compose RVManifest ");
                        sb.append(rVManifest);
                        sb.append(" error! ");
                        sb.append(Log.getStackTraceString(th));
                        printer.print(sb.toString());
                    }
                }
            }
            return this.h;
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        synchronized (this.m) {
            if (this.l) {
                return this.m;
            }
            this.l = true;
            for (RVManifest rVManifest : this.f6054a) {
                if (rVManifest != null) {
                    try {
                        List<ExtensionMetaInfo> extensions = rVManifest.getExtensions();
                        if (extensions != null) {
                            this.m.addAll(extensions);
                        }
                    } catch (Throwable th) {
                        RVProxy.Printer printer = this.b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("compose RVManifest ");
                        sb.append(rVManifest);
                        sb.append(" error! ");
                        sb.append(Log.getStackTraceString(th));
                        printer.print(sb.toString());
                    }
                }
            }
            return this.m;
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<BridgeDSL> getBridgeDSLs() {
        for (RVManifest rVManifest : this.f6054a) {
            if (rVManifest != null) {
                try {
                    List<BridgeDSL> bridgeDSLs = rVManifest.getBridgeDSLs();
                    if (bridgeDSLs != null) {
                        this.i.addAll(bridgeDSLs);
                    }
                } catch (Throwable th) {
                    RVProxy.Printer printer = this.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("compose RVManifest ");
                    sb.append(rVManifest);
                    sb.append(" error! ");
                    sb.append(Log.getStackTraceString(th));
                    printer.print(sb.toString());
                }
            }
        }
        return this.i;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public Map<String, EmbedViewMetaInfo> getEmbedViews() {
        synchronized (this.k) {
            if (this.j) {
                return this.k;
            }
            this.j = true;
            for (RVManifest rVManifest : this.f6054a) {
                if (rVManifest != null) {
                    try {
                        Map<String, EmbedViewMetaInfo> embedViews = rVManifest.getEmbedViews();
                        if (embedViews != null) {
                            this.k.putAll(embedViews);
                        }
                    } catch (Throwable th) {
                        RVProxy.Printer printer = this.b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("compose RVManifest ");
                        sb.append(rVManifest);
                        sb.append(" error! ");
                        sb.append(Log.getStackTraceString(th));
                        printer.print(sb.toString());
                    }
                }
            }
            return this.k;
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager) {
        synchronized (this.f6055o) {
            if (this.n) {
                return this.f6055o;
            }
            this.n = true;
            for (RVManifest rVManifest : this.f6054a) {
                if (rVManifest != null) {
                    try {
                        List<RVManifest.ServiceBeanManifest> serviceBeans = rVManifest.getServiceBeans(extensionManager);
                        if (serviceBeans != null) {
                            this.f6055o.addAll(serviceBeans);
                        }
                    } catch (Throwable th) {
                        RVProxy.Printer printer = this.b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("compose RVManifest ");
                        sb.append(rVManifest);
                        sb.append(" error! ");
                        sb.append(Log.getStackTraceString(th));
                        printer.print(sb.toString());
                    }
                }
            }
            return this.f6055o;
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<AppUpdaterFactory.Rule> getAppUpdaterRules() {
        synchronized (this.q) {
            if (this.p) {
                return this.q;
            }
            this.p = true;
            for (RVManifest rVManifest : this.f6054a) {
                if (rVManifest != null) {
                    try {
                        List<AppUpdaterFactory.Rule> appUpdaterRules = rVManifest.getAppUpdaterRules();
                        if (appUpdaterRules != null) {
                            this.q.addAll(appUpdaterRules);
                        }
                    } catch (Throwable th) {
                        RVProxy.Printer printer = this.b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("compose RVManifest ");
                        sb.append(rVManifest);
                        sb.append(" error! ");
                        sb.append(Log.getStackTraceString(th));
                        printer.print(sb.toString());
                    }
                }
            }
            return this.q;
        }
    }
}
