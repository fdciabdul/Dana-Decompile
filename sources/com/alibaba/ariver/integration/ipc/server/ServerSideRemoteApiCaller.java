package com.alibaba.ariver.integration.ipc.server;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.common.extension.BindBridgeExtensionInvoker;
import com.alibaba.ariver.engine.rve.RVEApiExtensionInvoker;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.ShadowNodePool;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ServerSideRemoteApiCaller {

    /* renamed from: a  reason: collision with root package name */
    private final ExtensionManager f6061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerSideRemoteApiCaller(ExtensionManager extensionManager) {
        this.f6061a = extensionManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remoteRVECall(RemoteCallArgs remoteCallArgs) {
        long j;
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("begin remoteCall for ");
            sb.append(remoteCallArgs);
            RVLogger.d("AriverKernel:ServerSideRemoteApiCaller", sb.toString());
            long nodeId = remoteCallArgs.getNodeId();
            String action = remoteCallArgs.getAction();
            Node createOrGetNode = ShadowNodePool.getInstance().createOrGetNode(remoteCallArgs.getNode(), nodeId);
            if (createOrGetNode instanceof Page) {
                App app = ((Page) createOrGetNode).getApp();
                String appId = app.getAppId();
                j = app.getStartToken();
                ((Page) createOrGetNode).getStartParams();
                str = appId;
            } else if (createOrGetNode instanceof App) {
                str = ((App) createOrGetNode).getAppId();
                long startToken = ((App) createOrGetNode).getStartToken();
                ((App) createOrGetNode).getStartParams();
                j = startToken;
            } else {
                j = -1;
                str = null;
            }
            if (TextUtils.isEmpty(action)) {
                return;
            }
            Parcelable data = remoteCallArgs.getData();
            if (data instanceof NativeCallContext) {
                NativeCallContext nativeCallContext = (NativeCallContext) data;
                new RVEApiExtensionInvoker(a(str, nativeCallContext.getId(), j, nodeId), nativeCallContext).invoke(null, null, remoteCallArgs.getArgs());
                return;
            }
            throw new IllegalStateException("Remote call of BridgeExtension not transact NativeCallContext!");
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:ServerSideRemoteApiCaller", "remoteCall exception!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remoteCall(RemoteCallArgs remoteCallArgs) {
        long j;
        Render render;
        String str;
        Bundle bundle;
        Object obj;
        ExtensionInvoker extensionInvoker;
        Method method;
        ActionMeta findActionMeta;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("begin remoteCall for ");
            sb.append(remoteCallArgs);
            RVLogger.d("AriverKernel:ServerSideRemoteApiCaller", sb.toString());
            long nodeId = remoteCallArgs.getNodeId();
            String action = remoteCallArgs.getAction();
            Node createOrGetNode = ShadowNodePool.getInstance().createOrGetNode(remoteCallArgs.getNode(), nodeId);
            if (createOrGetNode instanceof Page) {
                App app = ((Page) createOrGetNode).getApp();
                String appId = app.getAppId();
                long startToken = app.getStartToken();
                Bundle startParams = ((Page) createOrGetNode).getStartParams();
                ServerSideNodeUtils.setupApp(app);
                ServerSideNodeUtils.setupPage((Page) createOrGetNode);
                render = ((Page) createOrGetNode).getRender();
                str = appId;
                j = startToken;
                bundle = startParams;
            } else if (createOrGetNode instanceof App) {
                String appId2 = ((App) createOrGetNode).getAppId();
                long startToken2 = ((App) createOrGetNode).getStartToken();
                Bundle startParams2 = ((App) createOrGetNode).getStartParams();
                ServerSideNodeUtils.setupApp((App) createOrGetNode);
                str = appId2;
                j = startToken2;
                bundle = startParams2;
                render = null;
            } else {
                j = -1;
                render = null;
                str = null;
                bundle = null;
            }
            ((ServerRemoteCallPoint) ExtensionPoint.as(ServerRemoteCallPoint.class).node(createOrGetNode).create()).serverCallPoint(remoteCallArgs, remoteCallArgs.getClassName(), remoteCallArgs.getMethodName(), createOrGetNode);
            if (TextUtils.isEmpty(action)) {
                obj = null;
                extensionInvoker = null;
                method = null;
            } else {
                Parcelable data = remoteCallArgs.getData();
                if (data instanceof NativeCallContext) {
                    NativeCallContext nativeCallContext = (NativeCallContext) data;
                    SendToNativeCallback a2 = a(str, nativeCallContext.getId(), j, nodeId);
                    ServerSideApiContext serverSideApiContext = new ServerSideApiContext(render, j, str, bundle, remoteCallArgs.getSourceProcessName(), nativeCallContext.getPluginId(), nativeCallContext.getSource());
                    InstanceType instanceTypeFromParam = MultiInstanceUtils.getInstanceTypeFromParam(nativeCallContext.getParams());
                    if (instanceTypeFromParam != null) {
                        findActionMeta = this.f6061a.findActionMeta(instanceTypeFromParam, createOrGetNode, action);
                    } else {
                        findActionMeta = this.f6061a.findActionMeta(createOrGetNode, action);
                    }
                    ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) RVProxy.get(ExtensionInvokerFactory.class);
                    BridgeResponseHelper bridgeResponseHelper = new BridgeResponseHelper(a2);
                    obj = null;
                    ExtensionInvoker createScheduleExtensionInvoker = extensionInvokerFactory.createScheduleExtensionInvoker(new BindBridgeExtensionInvoker(createOrGetNode, nativeCallContext, bridgeResponseHelper, findActionMeta, serverSideApiContext, null));
                    Method method2 = findActionMeta.actionMethod;
                    createScheduleExtensionInvoker.attacheTargetExtensions(this.f6061a.getBridgeExtensionByActionMeta(createOrGetNode, findActionMeta));
                    method = method2;
                    extensionInvoker = createScheduleExtensionInvoker;
                } else {
                    throw new IllegalStateException("Remote call of BridgeExtension not transact NativeCallContext!");
                }
            }
            if (method == null) {
                RVLogger.e("AriverKernel:ServerSideRemoteApiCaller", "action method not found");
            } else {
                extensionInvoker.invoke(obj, method, remoteCallArgs.getArgs());
            }
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:ServerSideRemoteApiCaller", "remoteCall exception!", th);
        }
    }

    private SendToNativeCallback a(String str, String str2, long j, long j2) {
        return (SendToNativeCallback) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{SendToNativeCallback.class}, new RemoteReplyHandler(str, str2, j, j2));
    }
}
