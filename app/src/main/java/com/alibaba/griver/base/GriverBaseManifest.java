package com.alibaba.griver.base;

import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.griver.api.common.account.GriverAccountExtension;
import com.alibaba.griver.api.common.network.GriverTransportExtension;
import com.alibaba.griver.base.common.account.DefaultAccoutExtension;
import com.alibaba.griver.base.common.network.GriverURLTransport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverBaseManifest implements RVManifest {

    /* renamed from: a  reason: collision with root package name */
    private static GriverBaseManifest f6276a = new GriverBaseManifest();

    @Override // com.alibaba.ariver.integration.RVManifest
    public AccessController getAccessController() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<AppUpdaterFactory.Rule> getAppUpdaterRules() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public Map<String, EmbedViewMetaInfo> getEmbedViews() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public RemoteController getRemoteController() {
        return null;
    }

    public static GriverBaseManifest getInstance() {
        return f6276a;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.LazyProxyManifest(GriverTransportExtension.class, new RVProxy.LazyGetter<GriverTransportExtension>() { // from class: com.alibaba.griver.base.GriverBaseManifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverTransportExtension get() {
                return new GriverURLTransport();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverAccountExtension.class, new RVProxy.LazyGetter<GriverAccountExtension>() { // from class: com.alibaba.griver.base.GriverBaseManifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverAccountExtension get() {
                return new DefaultAccoutExtension();
            }
        }));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        return new ArrayList();
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        return new ArrayList();
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<BridgeDSL> getBridgeDSLs() {
        return new ArrayList();
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager) {
        return new ArrayList();
    }
}
