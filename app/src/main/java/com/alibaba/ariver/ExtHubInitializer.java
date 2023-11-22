package com.alibaba.ariver;

import com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher;
import com.alibaba.ariver.kernel.api.extension.registry.DefaultExtensionRegistry;
import com.alibaba.exthub.ExtHubBridgeExtensionManifest;
import com.alibaba.exthub.ExtHubExtensionManager;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.exthub.manifest.ExtHubMainfest;
import com.alibaba.exthub.manifest.base.IExtHubManifest;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class ExtHubInitializer {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5954a;
    private static IExtHubManifest b;

    public static boolean isAlreadyInit() {
        boolean z;
        synchronized (ExtHubInitializer.class) {
            z = f5954a;
        }
        return z;
    }

    public static void init() {
        synchronized (ExtHubInitializer.class) {
            if (f5954a) {
                return;
            }
            a();
            try {
                DefaultExtensionRegistry defaultExtensionRegistry = new DefaultExtensionRegistry(true);
                List<ExtHubBridgeExtensionManifest> bridgeExtensions = b.getBridgeExtensions();
                if (bridgeExtensions != null && bridgeExtensions.size() > 0) {
                    Iterator<ExtHubBridgeExtensionManifest> it = bridgeExtensions.iterator();
                    while (it.hasNext()) {
                        defaultExtensionRegistry.register(it.next().extensionMetaInfo);
                    }
                }
                BridgeDispatcher.getInstance().bindNativeExtensionManager(new ExtHubExtensionManager(defaultExtensionRegistry));
                f5954a = true;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("register error, t= ");
                sb.append(e);
                ExtHubLogger.e("ExtHubInitializer", sb.toString());
            }
        }
    }

    private static void a() {
        try {
            b = (IExtHubManifest) Class.forName("com.alibaba.exthub.config.ExtraExtHubMainfest").newInstance();
        } catch (Throwable unused) {
            ExtHubLogger.d("ExtHubInitializer", "ensureManifestFile error");
        }
        if (b == null) {
            b = new ExtHubMainfest();
        }
    }
}
