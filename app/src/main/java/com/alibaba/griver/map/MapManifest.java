package com.alibaba.griver.map;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.griver.api.common.map.GriverGoogleLocationService;
import com.alibaba.griver.map.jsapi.CalculateRouteExtension;
import com.alipay.mobile.beehive.poiselect.service.PoiSelectService;
import com.alipay.mobile.beehive.poiselect.service.impl.PoiSelectServiceImpl;
import com.alipay.mobile.framework.service.GeocodeService;
import com.alipay.mobile.framework.service.LBSLocationManagerService;
import com.alipay.mobile.framework.service.impl.GeocodeServiceImpl;
import com.alipay.mobile.framework.service.impl.LBSLocationManagerServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class MapManifest implements RVManifest {

    /* renamed from: a  reason: collision with root package name */
    private static final MapManifest f6648a = new MapManifest();

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

    public static RVManifest getInstance() {
        return f6648a;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.LazyProxyManifest(GeocodeService.class, new RVProxy.LazyGetter<GeocodeService>() { // from class: com.alibaba.griver.map.MapManifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GeocodeService get() {
                return new GeocodeServiceImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(PoiSelectService.class, new RVProxy.LazyGetter<PoiSelectService>() { // from class: com.alibaba.griver.map.MapManifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public PoiSelectService get() {
                return new PoiSelectServiceImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(LBSLocationManagerService.class, new RVProxy.LazyGetter<LBSLocationManagerService>() { // from class: com.alibaba.griver.map.MapManifest.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public LBSLocationManagerService get() {
                return new LBSLocationManagerServiceImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverGoogleLocationService.class, new RVProxy.LazyGetter<GriverGoogleLocationService>() { // from class: com.alibaba.griver.map.MapManifest.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverGoogleLocationService get() {
                return new GriverGoogleLocationServiceProvider();
            }
        }));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-griver-file", "com.alibaba.griver.map.jsapi.MapBridgeExtension", (List<String>) Arrays.asList("openLocation", "beehiveGetPOI"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-griver-file", "com.alibaba.griver.map.jsapi.CalculateRouteExtension", (List<String>) Arrays.asList(CalculateRouteExtension.ACTION_CALCULATE_ROUTE), (Class<? extends Scope>) App.class));
        return arrayList;
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
