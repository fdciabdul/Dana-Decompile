package com.alibaba.ariver.engine.common.extension;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.PermissionUtil;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.proxy.RVBridgeCallContextHandleProxy;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.exthub.common.ExtHubLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class NativePermissionExtensionInvoker extends ExtensionInvoker {

    /* renamed from: a  reason: collision with root package name */
    private NativeCallContext f6036a;
    private BridgeResponseHelper b;
    private ActionMeta c;
    private Node d;

    /* loaded from: classes6.dex */
    public static class FailedSet {
        final Set<String> actions = new HashSet();

        public void add(String str) {
            this.actions.add(str);
        }

        public boolean contains(String str) {
            if (str == null) {
                return false;
            }
            return this.actions.contains(str);
        }
    }

    public NativePermissionExtensionInvoker(Node node, BridgeResponseHelper bridgeResponseHelper, ExtensionInvoker extensionInvoker, ActionMeta actionMeta) {
        super(extensionInvoker);
        this.d = node;
        this.b = bridgeResponseHelper;
        this.c = actionMeta;
    }

    public NativePermissionExtensionInvoker(NativeCallContext nativeCallContext, Node node, BridgeResponseHelper bridgeResponseHelper, ExtensionInvoker extensionInvoker, ActionMeta actionMeta) {
        super(extensionInvoker);
        this.f6036a = nativeCallContext;
        this.d = node;
        this.b = bridgeResponseHelper;
        this.c = actionMeta;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(final ImmutableList<Extension> immutableList, final Object obj, final Method method, final Object[] objArr) throws Throwable {
        if (this.targetNode == null || this.f6036a == null) {
            return ExtensionInvoker.InvokeResult.proceed();
        }
        Activity activity = (Activity) ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).handleEvent("getActivity", this.targetNode, this.f6036a);
        if (activity == null) {
            return ExtensionInvoker.InvokeResult.proceed();
        }
        final ArrayList arrayList = new ArrayList();
        String[] strArr = this.c.nativePermissions;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(activity, str) != 0) {
                    arrayList.add(str);
                }
            }
            final FailedSet failedSet = (FailedSet) ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).handleEvent("getFailedSet", this.d, this.f6036a);
            if (failedSet.contains(this.c.actionName)) {
                StringBuilder sb = new StringBuilder();
                sb.append("API ");
                sb.append(this.c.actionName);
                sb.append(" already requested but failed!");
                ExtHubLogger.d("AriverEngine:NativePermissionExtensionInvoker", sb.toString());
                this.b.sendError(5, ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).getResourceString("api_error_no_storage_permission"));
                return ExtensionInvoker.InvokeResult.decide(null);
            } else if (!arrayList.isEmpty()) {
                int requestCode = ((RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class)).getRequestCode();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("API ");
                sb2.append(this.c.actionName);
                sb2.append(" need request permission: ");
                sb2.append(arrayList);
                sb2.append(", reqCode: ");
                sb2.append(requestCode);
                ExtHubLogger.d("AriverEngine:NativePermissionExtensionInvoker", sb2.toString());
                PermissionUtil.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), new IPermissionRequestCallback() { // from class: com.alibaba.ariver.engine.common.extension.NativePermissionExtensionInvoker.1
                    @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                    public void onRequestPermissionResult(int i, String[] strArr2, int[] iArr) {
                        if (strArr2 == null || iArr == null || strArr2.length != iArr.length || arrayList.size() != strArr2.length) {
                            return;
                        }
                        boolean z = false;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= strArr2.length) {
                                z = true;
                                break;
                            } else if (iArr[i2] != 0) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (z) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("API ");
                            sb3.append(NativePermissionExtensionInvoker.this.c.actionName);
                            sb3.append(" permission check success!");
                            ExtHubLogger.d("AriverEngine:NativePermissionExtensionInvoker", sb3.toString());
                            NativePermissionExtensionInvoker.this.proceedSafe(immutableList, obj, method, objArr);
                            return;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("API ");
                        sb4.append(NativePermissionExtensionInvoker.this.c.actionName);
                        sb4.append(" permission check fail!");
                        ExtHubLogger.d("AriverEngine:NativePermissionExtensionInvoker", sb4.toString());
                        failedSet.add(NativePermissionExtensionInvoker.this.c.actionName);
                        NativePermissionExtensionInvoker.this.b.sendError(5, ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).getResourceString("api_error_no_storage_permission"));
                    }
                });
                return ExtensionInvoker.InvokeResult.pending();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("API ");
                sb3.append(this.c.actionName);
                sb3.append(" havePermission: ");
                sb3.append(arrayList);
                ExtHubLogger.d("AriverEngine:NativePermissionExtensionInvoker", sb3.toString());
                return ExtensionInvoker.InvokeResult.proceed();
            }
        }
        return ExtensionInvoker.InvokeResult.proceed();
    }
}
