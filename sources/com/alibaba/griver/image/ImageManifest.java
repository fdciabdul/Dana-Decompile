package com.alibaba.griver.image;

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
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.OuterFileUtils;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.image.framework.api.GriverImageLoadExtension;
import com.alibaba.griver.image.impl.GriverGlideExtensionImpl;
import com.alibaba.griver.image.impl.GriverPicassoExtensionImpl;
import com.alibaba.griver.image.photo.utils.PhotoUtil;
import com.alipay.multimedia.adjuster.api.APMSandboxProcessor;
import com.alipay.multimedia.adjuster.api.data.ICache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class ImageManifest implements RVManifest {

    /* renamed from: a  reason: collision with root package name */
    private static final ImageManifest f6550a = new ImageManifest();

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
        if (PhotoUtil.isQCompact()) {
            APMSandboxProcessor.setApplicationContext(GriverEnv.getApplicationContext());
            APMSandboxProcessor.registerICache(new ICache() { // from class: com.alibaba.griver.image.ImageManifest.1
                @Override // com.alipay.multimedia.adjuster.api.data.ICache
                public final String getCacheRootDir() {
                    return OuterFileUtils.getOuterRootFileDir(GriverEnv.getApplicationContext());
                }
            });
        }
        return f6550a;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        if (ReflectUtils.classExist(GriverGlideExtensionImpl.GLIDE_CLASS_STR)) {
            arrayList.add(new RVManifest.LazyProxyManifest(GriverImageLoadExtension.class, new RVProxy.LazyGetter<GriverImageLoadExtension>() { // from class: com.alibaba.griver.image.ImageManifest.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public GriverImageLoadExtension get() {
                    return new GriverGlideExtensionImpl();
                }
            }));
        } else if (ReflectUtils.classExist(GriverPicassoExtensionImpl.PICASSO_CLASS_STR)) {
            arrayList.add(new RVManifest.LazyProxyManifest(GriverImageLoadExtension.class, new RVProxy.LazyGetter<GriverImageLoadExtension>() { // from class: com.alibaba.griver.image.ImageManifest.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public GriverImageLoadExtension get() {
                    return new GriverPicassoExtensionImpl();
                }
            }));
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-image", "com.alibaba.griver.image.jsapi.ChooseImageBridgeExtension", (List<String>) Arrays.asList("chooseImage"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-image", "com.alibaba.griver.image.jsapi.ChooseVideoBridgeExtension", (List<String>) Arrays.asList("chooseVideo"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-image", "com.alibaba.griver.image.jsapi.ImageInfoBridgeExtension", (List<String>) Arrays.asList("getImageInfo"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-image", "com.alibaba.griver.image.jsapi.CompressImageBridgeExtension", (List<String>) Arrays.asList("compressImage"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-image", "com.alibaba.griver.image.jsapi.PreviewImageBridgeExtension", (List<String>) Arrays.asList("imageViewer", "mediaBrowser"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-image", "com.alibaba.griver.image.jsapi.SaveImageToAlbumBridgeExtension", (List<String>) Arrays.asList("saveImage"), (Class<? extends Scope>) App.class));
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
