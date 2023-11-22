package com.alibaba.ariver.apt;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.common.bridge.NativeCallTimeoutHandlerPoint;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public final class com_alibaba_ariver_engine_ExtOpt {
    public static void opt2() {
    }

    public static void opt1() {
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallTimeoutHandlerPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_ExtOpt.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("monitorTimeout".equals(str) && objArr.length == 2) {
                    ((NativeCallTimeoutHandlerPoint) extension).monitorTimeout((NativeCallContext) objArr[0], (BridgeResponseHelper) objArr[1]);
                }
                if ("removeMonitor".equals(str) && objArr.length == 1) {
                    ((NativeCallTimeoutHandlerPoint) extension).removeMonitor((NativeCallContext) objArr[0]);
                    return null;
                }
                return null;
            }
        });
    }

    public static void opt3() {
        try {
            final Method declaredMethod = NativeCallTimeoutHandlerPoint.class.getDeclaredMethod("monitorTimeout", NativeCallContext.class, BridgeResponseHelper.class);
            final Method declaredMethod2 = NativeCallTimeoutHandlerPoint.class.getDeclaredMethod("removeMonitor", NativeCallContext.class);
            ExtensionPoint.registerProxyGenerator(NativeCallTimeoutHandlerPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_ExtOpt.2
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new NativeCallTimeoutHandlerPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_ExtOpt.2.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.engine.common.bridge.NativeCallTimeoutHandlerPoint
                        public void monitorTimeout(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
                            try {
                                invocationHandler.invoke(this, declaredMethod, new Object[]{nativeCallContext, bridgeResponseHelper});
                            } catch (Throwable th) {
                                ExtensionPoint.reportException(th);
                            }
                        }

                        @Override // com.alibaba.ariver.engine.common.bridge.NativeCallTimeoutHandlerPoint
                        public void removeMonitor(NativeCallContext nativeCallContext) {
                            try {
                                invocationHandler.invoke(this, declaredMethod2, new Object[]{nativeCallContext});
                            } catch (Throwable th) {
                                ExtensionPoint.reportException(th);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.common.bridge.NativeCallTimeoutHandlerPoint error, ignored", th);
        }
    }
}
