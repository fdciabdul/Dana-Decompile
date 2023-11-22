package com.alibaba.ariver.integration.ipc.server;

import android.os.SystemClock;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.IRemoteCaller;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.remote.RemoteCallResult;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import com.alibaba.ariver.kernel.ipc.ShadowNodePool;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class ServerSideRemoteExtensionCaller extends IRemoteCaller.Stub {
    private static final String TAG = "AriverKernel:ServerSideRemoteApiCaller";
    private final ExtensionManager mExtensionManager;
    private long mRemoteCallCounter = SystemClock.elapsedRealtime();

    public ServerSideRemoteExtensionCaller(ExtensionManager extensionManager) {
        this.mExtensionManager = extensionManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.ariver.kernel.api.remote.IRemoteCaller
    public RemoteCallResult remoteCall(RemoteCallArgs remoteCallArgs) {
        RemoteCallResult remoteCallResult;
        StringBuilder sb;
        ExtensionInvoker createScheduleExtensionInvoker;
        Method findMethod;
        long j = this.mRemoteCallCounter;
        this.mRemoteCallCounter = 1 + j;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("begin remoteCall id: ");
            sb2.append(j);
            sb2.append(" args: ");
            sb2.append(remoteCallArgs);
            RVLogger.d(TAG, sb2.toString());
            long nodeId = remoteCallArgs.getNodeId();
            Node createOrGetNode = ShadowNodePool.getInstance().createOrGetNode(remoteCallArgs.getNode(), nodeId);
            Class<?> cls = Class.forName(remoteCallArgs.getClassName());
            ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) RVProxy.get(ExtensionInvokerFactory.class);
            createScheduleExtensionInvoker = extensionInvokerFactory.createScheduleExtensionInvoker(extensionInvokerFactory.createAwareExtensionInvoker(createOrGetNode, null, cls));
            findMethod = ReflectUtils.findMethod(cls, remoteCallArgs.getMethodName(), remoteCallArgs.getArgTypes());
            Extension extensionByName = this.mExtensionManager.getExtensionByName(createOrGetNode, remoteCallArgs.getClassName());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("remoteCall found targetExtension: ");
            sb3.append(extensionByName);
            RVLogger.d(TAG, sb3.toString());
            createScheduleExtensionInvoker.attacheTargetExtensions(extensionByName);
        } catch (Throwable th) {
            try {
                RVLogger.e(TAG, "remoteCall exception!", th);
                remoteCallResult = new RemoteCallResult(th);
                sb = new StringBuilder();
            } finally {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("end remoteCall id: ");
                sb4.append(j);
                RVLogger.d(TAG, sb4.toString());
            }
        }
        if (findMethod == null) {
            RVLogger.e(TAG, "action method not found");
            return new RemoteCallResult((Object) null);
        }
        remoteCallResult = new RemoteCallResult(createScheduleExtensionInvoker.invoke(null, findMethod, remoteCallArgs.getArgs()));
        sb = new StringBuilder();
        sb.append("end remoteCall id: ");
        sb.append(j);
        RVLogger.d(TAG, sb.toString());
        return remoteCallResult;
    }
}
