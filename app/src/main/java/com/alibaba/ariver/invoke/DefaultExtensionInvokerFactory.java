package com.alibaba.ariver.invoke;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.remote.RemoteBridgeExtensionInvoker;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.invoke.AwareExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.invoke.RemoteNormalExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ResolveExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ScheduleExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.SecurityExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.api.security.internal.DefaultAccessController;
import com.alibaba.ariver.permission.DefaultAccessControlManagement;
import com.alibaba.exthub.bridge.BridgeDispatchCallContext;

/* loaded from: classes6.dex */
public class DefaultExtensionInvokerFactory implements ExtensionInvokerFactory {
    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory
    public ExtensionInvoker createAwareExtensionInvoker(Node node, ExtensionInvoker.InvokeCallback invokeCallback, Class<? extends Extension> cls) {
        return new AwareExtensionInvoker(node, invokeCallback, cls);
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory
    public ExtensionInvoker createPermissionExtensionInvoker(ActionMeta actionMeta, AccessController accessController, ExtensionInvoker extensionInvoker) {
        return new SecurityExtensionInvoker(actionMeta, accessController, extensionInvoker);
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory
    public ExtensionInvoker createPermissionExtensionInvoker(BridgeDispatchCallContext bridgeDispatchCallContext, BridgeResponseHelper bridgeResponseHelper, ExtensionManager extensionManager, ActionMeta actionMeta, ExtensionInvoker extensionInvoker) {
        DefaultAccessControlManagement defaultAccessControlManagement = new DefaultAccessControlManagement((NativeCallContext) bridgeDispatchCallContext, bridgeResponseHelper, extensionManager);
        DefaultAccessController defaultAccessController = new DefaultAccessController();
        defaultAccessController.setAccessControlManagement(defaultAccessControlManagement);
        return createPermissionExtensionInvoker(actionMeta, defaultAccessController, extensionInvoker);
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory
    public ExtensionInvoker createRemoteBridgeExtensionInvoker(SendToNativeCallback sendToNativeCallback, BridgeDispatchCallContext bridgeDispatchCallContext, RemoteController remoteController, ExtensionInvoker extensionInvoker) {
        return new RemoteBridgeExtensionInvoker(sendToNativeCallback, (NativeCallContext) bridgeDispatchCallContext, remoteController, extensionInvoker);
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory
    public ExtensionInvoker createRemoteBridgeExtensionInvoker(RemoteController remoteController, ExtensionInvoker extensionInvoker) {
        return new RemoteNormalExtensionInvoker(remoteController, extensionInvoker);
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory
    public ExtensionInvoker createResolveExtensionInvoker(ResultResolver resultResolver, ExtensionInvoker extensionInvoker) {
        return new ResolveExtensionInvoker(resultResolver, extensionInvoker);
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory
    public ExtensionInvoker createScheduleExtensionInvoker(ExtensionInvoker extensionInvoker) {
        return new ScheduleExtensionInvoker(extensionInvoker);
    }
}
