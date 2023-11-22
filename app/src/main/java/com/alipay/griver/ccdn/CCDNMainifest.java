package com.alipay.griver.ccdn;

import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.griver.api.cache.H5WebViewCacheExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class CCDNMainifest implements RVManifest {
    private static final String BUNDLE_NAME = "com-alibaba-griver-cdn";
    private static final CCDNMainifest INSTANCE = new CCDNMainifest();

    @Override // com.alibaba.ariver.integration.RVManifest
    public AccessController getAccessController() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<AppUpdaterFactory.Rule> getAppUpdaterRules() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<BridgeDSL> getBridgeDSLs() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public Map<String, EmbedViewMetaInfo> getEmbedViews() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public RemoteController getRemoteController() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager) {
        return null;
    }

    public static RVManifest getInstance() {
        return INSTANCE;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.LazyProxyManifest(H5WebViewCacheExtension.class, new RVProxy.LazyGetter<H5WebViewCacheExtension>() { // from class: com.alipay.griver.ccdn.CCDNMainifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public H5WebViewCacheExtension get() {
                return new CCDNH5WebViewCacheExtensionImpl();
            }
        }));
        return arrayList;
    }
}
