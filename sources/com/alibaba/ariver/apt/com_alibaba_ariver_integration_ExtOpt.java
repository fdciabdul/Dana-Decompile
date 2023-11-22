package com.alibaba.ariver.apt;

import com.alibaba.ariver.integration.ipc.server.ServerRemoteCallPoint;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public final class com_alibaba_ariver_integration_ExtOpt {
    public static void opt2() {
    }

    public static void opt1() {
        ExtensionOpt.setupMethodInvokeOptimizer(ServerRemoteCallPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_integration_ExtOpt.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("serverCallPoint".equals(str) && objArr.length == 4) {
                    ((ServerRemoteCallPoint) extension).serverCallPoint((RemoteCallArgs) objArr[0], (String) objArr[1], (String) objArr[2], (Node) objArr[3]);
                    return null;
                }
                return null;
            }
        });
    }

    public static void opt3() {
        try {
            final Method declaredMethod = ServerRemoteCallPoint.class.getDeclaredMethod("serverCallPoint", RemoteCallArgs.class, String.class, String.class, Node.class);
            ExtensionPoint.registerProxyGenerator(ServerRemoteCallPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_integration_ExtOpt.2
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new ServerRemoteCallPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_integration_ExtOpt.2.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.integration.ipc.server.ServerRemoteCallPoint
                        public void serverCallPoint(RemoteCallArgs remoteCallArgs, String str, String str2, Node node) {
                            try {
                                invocationHandler.invoke(this, declaredMethod, new Object[]{remoteCallArgs, str, str2, node});
                            } catch (Throwable th) {
                                ExtensionPoint.reportException(th);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.integration.ipc.server.ServerRemoteCallPoint error, ignored", th);
        }
    }
}
