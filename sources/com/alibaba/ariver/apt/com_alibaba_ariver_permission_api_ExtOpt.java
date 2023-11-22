package com.alibaba.ariver.apt;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint;
import com.alibaba.ariver.permission.extension.auth.GetAuthCodeInterceptPoint;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public final class com_alibaba_ariver_permission_api_ExtOpt {
    public static void opt2() {
    }

    public static void opt1() {
        ExtensionOpt.setupMethodInvokeOptimizer(IgnorePermissionPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_permission_api_ExtOpt.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("ignoreAppPermission".equals(str) && objArr.length == 1) {
                    return Boolean.valueOf(((IgnorePermissionPoint) extension).ignoreAppPermission((String) objArr[0]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(GetAuthCodeInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_permission_api_ExtOpt.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("interceptGetAuthCode".equals(str) && objArr.length == 4) {
                    return Boolean.valueOf(((GetAuthCodeInterceptPoint) extension).interceptGetAuthCode((Page) objArr[0], (ApiContext) objArr[1], (JSONObject) objArr[2], (BridgeCallback) objArr[3]));
                }
                return null;
            }
        });
    }

    public static void opt3() {
        try {
            final Method declaredMethod = IgnorePermissionPoint.class.getDeclaredMethod("ignoreAppPermission", String.class);
            ExtensionPoint.registerProxyGenerator(IgnorePermissionPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_permission_api_ExtOpt.3
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new IgnorePermissionPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_permission_api_ExtOpt.3.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint
                        public boolean ignoreAppPermission(String str) {
                            try {
                                return ((Boolean) invocationHandler.invoke(this, declaredMethod, new Object[]{str})).booleanValue();
                            } catch (Throwable th) {
                                ExtensionPoint.reportException(th);
                                return false;
                            }
                        }
                    };
                }
            });
        } catch (Throwable th) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint error, ignored", th);
        }
        try {
            final Method declaredMethod2 = GetAuthCodeInterceptPoint.class.getDeclaredMethod("interceptGetAuthCode", Page.class, ApiContext.class, JSONObject.class, BridgeCallback.class);
            ExtensionPoint.registerProxyGenerator(GetAuthCodeInterceptPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_permission_api_ExtOpt.4
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new GetAuthCodeInterceptPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_permission_api_ExtOpt.4.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.permission.extension.auth.GetAuthCodeInterceptPoint
                        public boolean interceptGetAuthCode(Page page, ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
                            try {
                                return ((Boolean) invocationHandler.invoke(this, declaredMethod2, new Object[]{page, apiContext, jSONObject, bridgeCallback})).booleanValue();
                            } catch (Throwable th2) {
                                ExtensionPoint.reportException(th2);
                                return false;
                            }
                        }
                    };
                }
            });
        } catch (Throwable th2) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.permission.extension.auth.GetAuthCodeInterceptPoint error, ignored", th2);
        }
    }
}
