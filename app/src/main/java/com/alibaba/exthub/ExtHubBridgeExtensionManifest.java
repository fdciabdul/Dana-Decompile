package com.alibaba.exthub;

import com.alibaba.ariver.kernel.api.extension.ExtensionType;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import java.util.List;

/* loaded from: classes3.dex */
public class ExtHubBridgeExtensionManifest {
    public ExtensionMetaInfo extensionMetaInfo;
    public boolean isRawType;

    public static ExtHubBridgeExtensionManifest makeRaw(String str, String str2, List<String> list) {
        return makeRaw(str, str2, list, null);
    }

    public static ExtHubBridgeExtensionManifest makeRaw(String str, String str2, List<String> list, Class<? extends Scope> cls) {
        ExtHubBridgeExtensionManifest extHubBridgeExtensionManifest = new ExtHubBridgeExtensionManifest();
        extHubBridgeExtensionManifest.isRawType = true;
        extHubBridgeExtensionManifest.extensionMetaInfo = new ExtensionMetaInfo(str, str2, list, cls, ExtensionType.BRIDGE, true);
        return extHubBridgeExtensionManifest;
    }
}
