package com.alibaba.griver.file;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.permission.PermissionConstant;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.griver.api.file.GriverFileExtension;
import com.alibaba.griver.file.extension.ChooseFileActivityResultExtensionImpl;
import com.alibaba.griver.file.extension.GriverFileExtensionImpl;
import com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class FileManifest implements RVManifest {

    /* renamed from: a  reason: collision with root package name */
    private static final FileManifest f6534a = new FileManifest();

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
        return f6534a;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.LazyProxyManifest(GriverFileExtension.class, new RVProxy.LazyGetter<GriverFileExtension>() { // from class: com.alibaba.griver.file.FileManifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverFileExtension get() {
                return new GriverFileExtensionImpl();
            }
        }));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-griver-file", "com.alibaba.griver.file.jsapi.FileBridgeExtension", (List<String>) Arrays.asList("getFileInfo", "getSavedFileInfo", "getSavedFileList", "removeSavedFile", "saveFile"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-griver-file", "com.alibaba.griver.file.jsapi.FileMangerBridgeExtension", (List<String>) Arrays.asList("downloadFile", PermissionConstant.UPLOAD_FILE)));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-griver-file", "com.alibaba.griver.file.jsapi.OpenDocumentBridgeExtension", (List<String>) Arrays.asList("openDocument")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-griver-file", ChooseFileBridgeExtension.class.getName(), (List<String>) Arrays.asList("chooseFileFromDisk")));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtensionMetaInfo("com-griver-file", ChooseFileActivityResultExtensionImpl.class.getName(), Arrays.asList(ActivityResultPoint.class.getName())));
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
