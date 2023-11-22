package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.exthub.bridge.BridgeDispatchCallContext;

@DefaultImpl("com.alibaba.ariver.invoke.DefaultExtensionInvokerFactory")
/* loaded from: classes3.dex */
public interface ExtensionInvokerFactory extends Proxiable {
    ExtensionInvoker createAwareExtensionInvoker(Node node, ExtensionInvoker.InvokeCallback invokeCallback, Class<? extends Extension> cls);

    ExtensionInvoker createPermissionExtensionInvoker(ActionMeta actionMeta, AccessController accessController, ExtensionInvoker extensionInvoker);

    ExtensionInvoker createPermissionExtensionInvoker(BridgeDispatchCallContext bridgeDispatchCallContext, BridgeResponseHelper bridgeResponseHelper, ExtensionManager extensionManager, ActionMeta actionMeta, ExtensionInvoker extensionInvoker);

    ExtensionInvoker createRemoteBridgeExtensionInvoker(SendToNativeCallback sendToNativeCallback, BridgeDispatchCallContext bridgeDispatchCallContext, RemoteController remoteController, ExtensionInvoker extensionInvoker);

    ExtensionInvoker createRemoteBridgeExtensionInvoker(RemoteController remoteController, ExtensionInvoker extensionInvoker);

    ExtensionInvoker createResolveExtensionInvoker(ResultResolver resultResolver, ExtensionInvoker extensionInvoker);

    ExtensionInvoker createScheduleExtensionInvoker(ExtensionInvoker extensionInvoker);
}
