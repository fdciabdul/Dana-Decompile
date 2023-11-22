package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.remote.RemoteCallResult;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class RemoteNormalExtensionInvoker extends ExtensionInvoker {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6095a;
    private RemoteController b;

    public RemoteNormalExtensionInvoker(RemoteController remoteController, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.f6095a = ProcessUtils.isMainProcess();
        this.b = remoteController;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    protected ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws Throwable {
        Extension extension;
        boolean isRemoteCallExtension;
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f6095a && this.b != null && (isRemoteCallExtension = this.b.isRemoteCallExtension((extension = immutableList.get(0)), method))) {
            StringBuilder sb = new StringBuilder();
            sb.append("extension: ");
            sb.append(extension.getClass());
            sb.append(" method: ");
            sb.append(method);
            sb.append(" isRemote: ");
            sb.append(isRemoteCallExtension);
            RVLogger.d("AriverKernel:ExtensionInvoker:Remote", sb.toString());
            RemoteCallResult remoteCall = this.b.remoteCall(new RemoteCallArgs(this.targetNode, extension, method, objArr, null));
            Object value = remoteCall.getValue();
            if (remoteCall.isError() && (value instanceof Throwable)) {
                throw ((Throwable) value);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("extension ");
            sb2.append(extension);
            sb2.append(" method: ");
            sb2.append(method);
            sb2.append(" cost ");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            RVLogger.debug("AriverKernel:ExtensionInvoker:Remote", sb2.toString());
            return ExtensionInvoker.InvokeResult.decide(remoteCall.getValue());
        }
        return ExtensionInvoker.InvokeResult.proceed();
    }
}
