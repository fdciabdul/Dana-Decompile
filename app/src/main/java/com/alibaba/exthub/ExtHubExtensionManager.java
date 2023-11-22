package com.alibaba.exthub;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.DefaultExtensionManager;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.exthub.lifecycler.LifecycleManager;
import java.util.Map;

/* loaded from: classes3.dex */
public class ExtHubExtensionManager extends DefaultExtensionManager {
    public ExtHubExtensionManager(ExtensionRegistry extensionRegistry) {
        super(extensionRegistry);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.DefaultExtensionManager, com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public BridgeExtension getBridgeExtensionByActionMeta(Node node, ActionMeta actionMeta) throws IllegalAccessException, InstantiationException {
        BridgeExtension bridgeExtensionByActionMeta;
        Class<? extends Scope> scope = this.mExtensionRegistry.getScope(actionMeta.bridgeExtensionClazz);
        if (scope == Page.class) {
            bridgeExtensionByActionMeta = super.getBridgeExtensionByActionMeta(node, actionMeta);
        } else {
            bridgeExtensionByActionMeta = super.getBridgeExtensionByActionMeta(null, actionMeta);
        }
        LifecycleManager.getInstance().bindExtHubLifecycle((Page) node, scope, bridgeExtensionByActionMeta);
        return bridgeExtensionByActionMeta;
    }

    public Extension findExtension(Node node, String str) {
        Map<String, Extension> map;
        if (node == null || TextUtils.isEmpty(str) || (map = this.mNodeExtensionMap.get(node)) == null) {
            return null;
        }
        return map.get(str);
    }

    public Extension findExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mSingletonExtensionMap.get(str);
    }
}
