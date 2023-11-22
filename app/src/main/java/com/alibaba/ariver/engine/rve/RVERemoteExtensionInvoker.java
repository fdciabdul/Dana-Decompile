package com.alibaba.ariver.engine.rve;

import android.os.Bundle;
import android.os.RemoteException;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.remote.RemoteCallbackPool;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class RVERemoteExtensionInvoker extends ExtensionInvoker {

    /* renamed from: a  reason: collision with root package name */
    private RemoteController f6052a;
    private SendToNativeCallback b;
    private NativeCallContext c;

    public RVERemoteExtensionInvoker(SendToNativeCallback sendToNativeCallback, NativeCallContext nativeCallContext, RemoteController remoteController, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.b = sendToNativeCallback;
        this.f6052a = remoteController;
        this.c = nativeCallContext;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws Throwable {
        Node node = this.c.getNode();
        if (node == null) {
            RVLogger.w("AriverKernel:RVERemoteExtensionInvoker:RVEApi", "RVERemoteExtensionInvoker can only call with a node!!!");
            return ExtensionInvoker.InvokeResult.proceed();
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        sb.append(this.c.getName());
        sb.append(" method: ");
        sb.append(method);
        sb.append(" isRemote!");
        RVLogger.d("AriverKernel:RVERemoteExtensionInvoker:RVEApi", sb.toString());
        RemoteCallbackPool.getInstance().registerCallback(this.c, this.b);
        try {
            RemoteCallArgs remoteCallArgs = new RemoteCallArgs(node, this.c.getName(), this.c);
            Bundle bundle = new Bundle();
            bundle.putParcelable(IpcMessageConstants.EXTRA_REMOTE_CALL_ARGS, remoteCallArgs);
            IpcClientKernelUtils.sendMsgToServerUnSafe(IpcMessageConstants.BIZ_APP, 9, bundle);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("name: ");
            sb2.append(this.c.getName());
            sb2.append(" method: ");
            sb2.append(method);
            sb2.append(" call remote cost ");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            RVLogger.debug("AriverKernel:RVERemoteExtensionInvoker:RVEApi", sb2.toString());
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
                RVLogger.e("AriverKernel:RVERemoteExtensionInvoker:RVEApi", sb4.toString(), e);
            }
        }
        return ExtensionInvoker.InvokeResult.decide(null);
    }
}
