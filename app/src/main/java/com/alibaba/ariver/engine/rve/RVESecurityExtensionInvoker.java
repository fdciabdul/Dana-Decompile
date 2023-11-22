package com.alibaba.ariver.engine.rve;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeGuard;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.security.AccessControlException;
import com.alibaba.ariver.kernel.api.security.internal.DefaultAccessController;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.DefaultAccessControlManagement;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class RVESecurityExtensionInvoker extends ExtensionInvoker {

    /* renamed from: a  reason: collision with root package name */
    private NativeCallContext f6053a;
    private BridgeResponseHelper b;

    public RVESecurityExtensionInvoker(SendToNativeCallback sendToNativeCallback, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.f6053a = nativeCallContext;
        this.b = bridgeResponseHelper;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws Throwable {
        String name = this.f6053a.getName();
        try {
            DefaultAccessControlManagement defaultAccessControlManagement = new DefaultAccessControlManagement(this.f6053a, this.b, BridgeDispatcher.getInstance().getExtensionManager());
            DefaultAccessController defaultAccessController = new DefaultAccessController();
            defaultAccessController.setAccessControlManagement(defaultAccessControlManagement);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BridgeGuard(new BridgePermission(name, name)));
            if (defaultAccessController.check(this.f6053a.getNode(), arrayList, null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("executeNative check pending! ");
                sb.append(name);
                RVLogger.d("AriverKernel:RVESecurityExtensionInvoker:RVEApi", sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("executeNative check success! ");
                sb2.append(name);
                RVLogger.d("AriverKernel:RVESecurityExtensionInvoker:RVEApi", sb2.toString());
            }
            return ExtensionInvoker.InvokeResult.proceed();
        } catch (AccessControlException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("executeNative check failed for legacy call! ");
            sb3.append(name);
            RVLogger.d("AriverKernel:RVESecurityExtensionInvoker:RVEApi", sb3.toString());
            String message = e.getMessage();
            if (message.startsWith("N22")) {
                this.b.sendNoRigHtToInvoke(message);
            } else {
                this.b.sendNoRigHtToInvoke();
            }
            return ExtensionInvoker.InvokeResult.decide(null);
        }
    }
}
