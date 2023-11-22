package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.kernel.api.annotation.UsePermission;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeGuard;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.exthub.common.ExtHubLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class SecurityExtensionInvoker extends ExtensionInvoker {

    /* renamed from: a  reason: collision with root package name */
    private AccessController f6098a;
    private ActionMeta b;

    public SecurityExtensionInvoker(ActionMeta actionMeta, AccessController accessController, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.b = actionMeta;
        this.f6098a = accessController;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    protected ExtensionInvoker.InvokeResult onInvoke(final ImmutableList<Extension> immutableList, final Object obj, final Method method, final Object[] objArr) throws Throwable {
        final long currentTimeMillis = System.currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        Iterator it = immutableList.iterator();
        while (it.hasNext()) {
            Extension extension = (Extension) it.next();
            if (extension instanceof Guard) {
                arrayList.add((Guard) extension);
            }
            UsePermission usePermission = this.b.usePermission;
            if (usePermission != null && usePermission.value().length() > 0) {
                arrayList.add(new BridgeGuard(new BridgePermission(usePermission.value(), usePermission.desc())));
            } else if (extension instanceof BridgeExtension) {
                String str = this.b.actionName;
                arrayList.add(new BridgeGuard(new BridgePermission(str, str)));
            }
        }
        AccessController.ApplyCallback applyCallback = new AccessController.ApplyCallback() { // from class: com.alibaba.ariver.kernel.api.invoke.SecurityExtensionInvoker.1
            @Override // com.alibaba.ariver.kernel.api.security.AccessController.ApplyCallback
            public void onSuccess() {
                StringBuilder sb = new StringBuilder();
                sb.append("method ");
                sb.append(method);
                sb.append(" cost ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                ExtHubLogger.d("AriverKernel:ExtensionInvoker:Security", sb.toString());
                SecurityExtensionInvoker.this.proceedSafe(immutableList, obj, method, objArr);
            }

            @Override // com.alibaba.ariver.kernel.api.security.AccessController.ApplyCallback
            public void onFailure(List<? extends Permission> list) {
                List mutable = immutableList.mutable();
                for (Permission permission : list) {
                    for (Guard guard : arrayList) {
                        if (guard.permit().authority().equalsIgnoreCase(permission.authority())) {
                            mutable.remove(guard);
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("method ");
                sb.append(method);
                sb.append(" cost ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                ExtHubLogger.d("AriverKernel:ExtensionInvoker:Security", sb.toString());
                SecurityExtensionInvoker.this.proceedSafe(new ImmutableList<>(mutable), obj, method, objArr);
            }
        };
        AccessController accessController = this.f6098a;
        if (accessController != null && accessController.check(this.targetNode, arrayList, applyCallback)) {
            return ExtensionInvoker.InvokeResult.pending();
        }
        return ExtensionInvoker.InvokeResult.proceed();
    }
}
