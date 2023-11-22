package com.alibaba.griver.v8;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.v8worker.V8Proxy;
import com.alibaba.ariver.v8worker.extension.V8ImportScriptErrorPoint;
import com.alibaba.ariver.v8worker.extension.V8JSErrorPoint;
import com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint;
import com.alibaba.griver.base.common.worker.GriverV8WorkerExtension;
import com.alibaba.griver.v8.extension.GriverV8ImportJSErrorExtension;
import com.alibaba.griver.v8.extension.GriverV8JSErrorExtension;
import com.alibaba.griver.v8.extension.GriverV8SendMessageErrorExtension;
import com.alibaba.griver.v8.proxy.GriverV8Proxy;
import com.alibaba.griver.v8.proxy.GriverV8WorkerProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class V8Manifest implements RVManifest {

    /* renamed from: a  reason: collision with root package name */
    private static final V8Manifest f6775a = new V8Manifest();

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

    public static V8Manifest getInstance() {
        return f6775a;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.LazyProxyManifest(V8Proxy.class, new RVProxy.LazyGetter<V8Proxy>() { // from class: com.alibaba.griver.v8.V8Manifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public V8Proxy get() {
                return new GriverV8Proxy();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverV8WorkerExtension.class, new RVProxy.LazyGetter<GriverV8WorkerExtension>() { // from class: com.alibaba.griver.v8.V8Manifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverV8WorkerExtension get() {
                return new GriverV8WorkerProxy();
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
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtensionMetaInfo("griver_h5", GriverV8ImportJSErrorExtension.class.getName(), Collections.singletonList(V8ImportScriptErrorPoint.class.getName()), App.class));
        arrayList.add(new ExtensionMetaInfo("griver_h5", GriverV8JSErrorExtension.class.getName(), Collections.singletonList(V8JSErrorPoint.class.getName()), App.class));
        arrayList.add(new ExtensionMetaInfo("griver_h5", GriverV8SendMessageErrorExtension.class.getName(), Collections.singletonList(V8SendMessageErrorPoint.class.getName()), App.class));
        return arrayList;
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
