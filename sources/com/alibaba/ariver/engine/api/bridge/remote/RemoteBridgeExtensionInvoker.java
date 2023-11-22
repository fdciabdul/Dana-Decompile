package com.alibaba.ariver.engine.api.bridge.remote;

import android.os.Bundle;
import android.os.RemoteException;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class RemoteBridgeExtensionInvoker extends ExtensionInvoker {

    /* renamed from: a  reason: collision with root package name */
    private RemoteController f6024a;
    private SendToNativeCallback b;
    private NativeCallContext c;

    public RemoteBridgeExtensionInvoker(SendToNativeCallback sendToNativeCallback, NativeCallContext nativeCallContext, RemoteController remoteController, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.b = sendToNativeCallback;
        this.f6024a = remoteController;
        this.c = nativeCallContext;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws Throwable {
        Node node = this.c.getNode();
        if (node == null) {
            RVLogger.w("AriverKernel:ExtensionInvoker:Remote", "RemoteBridgeExtensionInvoker can only call with a node!!!");
            return ExtensionInvoker.InvokeResult.proceed();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f6024a != null) {
            Extension extension = immutableList.get(0);
            boolean isRemoteCallExtension = this.f6024a.isRemoteCallExtension(extension, method);
            if (a()) {
                isRemoteCallExtension = isRemoteCallExtension && JSONUtils.getBoolean(this.c.getParams(), "jsapiEnableRemote", true);
            }
            if (isRemoteCallExtension) {
                StringBuilder sb = new StringBuilder();
                sb.append("extension: ");
                sb.append(extension.getClass());
                sb.append(" method: ");
                sb.append(method);
                sb.append(" isRemote!");
                RVLogger.d("AriverKernel:ExtensionInvoker:Remote", sb.toString());
                RemoteCallbackPool.getInstance().registerCallback(this.c, this.b);
                try {
                    RemoteCallArgs remoteCallArgs = new RemoteCallArgs(node, extension, method, objArr, this.c);
                    ((ClientRemoteCallPoint) ExtensionPoint.as(ClientRemoteCallPoint.class).node(node).create()).addClientRemoteCallArgs(extension.getClass(), method, remoteCallArgs);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(IpcMessageConstants.EXTRA_REMOTE_CALL_ARGS, remoteCallArgs);
                    IpcClientKernelUtils.sendMsgToServerUnSafe(IpcMessageConstants.BIZ_APP, 6, bundle);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("extension ");
                    sb2.append(extension);
                    sb2.append(" method: ");
                    sb2.append(method);
                    sb2.append(" call remote cost ");
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    RVLogger.debug("AriverKernel:ExtensionInvoker:Remote", sb2.toString());
                } catch (RemoteException e) {
                    if (IpcClientKernelUtils.enableBridgeCatchIpcException()) {
                        RemoteCallbackPool.getInstance().getCallback(node.getNodeId(), this.c.getId(), true);
                        SendToNativeCallback sendToNativeCallback = this.b;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("IPC Exception ");
                        sb3.append(e.getClass().getSimpleName());
                        sendToNativeCallback.onCallback(BridgeResponse.newError(5, sb3.toString()).get(), false);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("remote call ");
                        sb4.append(this.c.getName());
                        sb4.append(" exception!");
                        RVLogger.e("AriverKernel:ExtensionInvoker:Remote", sb4.toString(), e);
                    }
                }
                return ExtensionInvoker.InvokeResult.decide(null);
            }
        }
        return ExtensionInvoker.InvokeResult.proceed();
    }

    private boolean a() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ariver_apiEnableRemoteParams", "yes"));
    }
}
