package com.alibaba.griver.h5;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.griver.api.h5.file.GriverChooseFileExtension;
import com.alibaba.griver.api.h5.permission.GriverH5JSAPIPermissionExtension;
import com.alibaba.griver.api.h5.permission.GriverJSAPIPermissionProxy;
import com.alibaba.griver.api.h5.point.GriverOptionMenuClickPoint;
import com.alibaba.griver.base.api.PageProcessPoint;
import com.alibaba.griver.base.resource.point.BeforeGetMainPackageResourcePoint;
import com.alibaba.griver.h5.api.GriverDataCacheExtension;
import com.alibaba.griver.h5.extension.GriverChooseFileExtensionImpl;
import com.alibaba.griver.h5.extension.GriverDataCacheExtensionImpl;
import com.alibaba.griver.h5.extension.GriverOptionMenuClickExtension;
import com.alibaba.griver.h5.extension.GriverUpdateProgressExtension;
import com.alibaba.griver.h5.extension.PageStartedExtension;
import com.alibaba.griver.h5.extension.UrlMapExtension;
import com.alibaba.griver.h5.jsapi.DisplayBridgeExtension;
import com.alibaba.griver.h5.jsapi.ImageBridgeExtension;
import com.alibaba.griver.h5.jsapi.NotificationBridgeExtension;
import com.alibaba.griver.h5.jsapi.OpenInBrowserBridgeExtension;
import com.alibaba.griver.h5.jsapi.SessionBridgeExtension;
import com.alibaba.griver.h5.jsapi.SharedDataBridgeExtension;
import com.alibaba.griver.h5.jsapi.StartupParamsBridgeExtension;
import com.alibaba.griver.h5.jsapi.TitleBarBridgeExtension;
import com.alibaba.griver.h5.permission.GriverDefaultH5JSAPIPermission;
import com.alibaba.griver.h5.permission.GriverJSAPIPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverH5Manifest implements RVManifest {

    /* renamed from: a  reason: collision with root package name */
    private static final GriverH5Manifest f6543a = new GriverH5Manifest();

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

    public static GriverH5Manifest getInstance() {
        return f6543a;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.LazyProxyManifest(GriverJSAPIPermissionProxy.class, new RVProxy.LazyGetter<GriverJSAPIPermissionProxy>() { // from class: com.alibaba.griver.h5.GriverH5Manifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverJSAPIPermissionProxy get() {
                return new GriverJSAPIPermission();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverH5JSAPIPermissionExtension.class, new RVProxy.LazyGetter<GriverH5JSAPIPermissionExtension>() { // from class: com.alibaba.griver.h5.GriverH5Manifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverH5JSAPIPermissionExtension get() {
                return new GriverDefaultH5JSAPIPermission();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverChooseFileExtension.class, new RVProxy.LazyGetter<GriverChooseFileExtension>() { // from class: com.alibaba.griver.h5.GriverH5Manifest.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverChooseFileExtension get() {
                return new GriverChooseFileExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverDataCacheExtension.class, new RVProxy.LazyGetter<GriverDataCacheExtension>() { // from class: com.alibaba.griver.h5.GriverH5Manifest.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverDataCacheExtension get() {
                return new GriverDataCacheExtensionImpl();
            }
        }));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("griver_h5", DisplayBridgeExtension.class.getName(), (List<String>) Arrays.asList("setLandscape", "setPortrait")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("griver_h5", ImageBridgeExtension.class.getName(), (List<String>) Arrays.asList("loadLocalImage")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("griver_h5", NotificationBridgeExtension.class.getName(), (List<String>) Arrays.asList("postNotification", "addNotifyListener", "removeNotifyListener")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("griver_h5", OpenInBrowserBridgeExtension.class.getName(), (List<String>) Arrays.asList("openInBrowser")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("griver_h5", SessionBridgeExtension.class.getName(), (List<String>) Arrays.asList("exitSession", "getSessionData", "setSessionData", "exitTinyApp")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("griver_h5", SharedDataBridgeExtension.class.getName(), (List<String>) Arrays.asList("getSharedData", "setSharedData", "removeSharedData")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("griver_h5", StartupParamsBridgeExtension.class.getName(), (List<String>) Arrays.asList("getStartupParams")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("griver_h5", TitleBarBridgeExtension.class.getName(), (List<String>) Arrays.asList("setBackButton", "setCloseButton", "setToolbarMenu")));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtensionMetaInfo("griver_h5", GriverUpdateProgressExtension.class.getName(), Arrays.asList(PageProcessPoint.class.getName()), Page.class));
        arrayList.add(new ExtensionMetaInfo("griver_h5", PageStartedExtension.class.getName(), Arrays.asList(PageStartedPoint.class.getName()), Page.class));
        arrayList.add(new ExtensionMetaInfo("griver_h5", UrlMapExtension.class.getName(), Arrays.asList(BeforeGetMainPackageResourcePoint.class.getName()), App.class));
        arrayList.add(new ExtensionMetaInfo("griver_h5", GriverOptionMenuClickExtension.class.getName(), Arrays.asList(GriverOptionMenuClickPoint.class.getName()), Page.class));
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
