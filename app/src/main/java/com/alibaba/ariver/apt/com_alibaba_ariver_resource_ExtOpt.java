package com.alibaba.ariver.apt;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.subpackage.DownloadQueryPoint;
import com.alibaba.ariver.resource.subpackage.ISubPackageDownloader;
import com.alibaba.ariver.resource.subpackage.SubPackageBridgeExtension;
import com.alibaba.ariver.resource.template.TemplateBridgeExtension;
import com.alibaba.fastjson.JSONArray;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public final class com_alibaba_ariver_resource_ExtOpt {
    public static void opt1() {
        ExtensionOpt.setupMethodInvokeOptimizer(DownloadQueryPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_ExtOpt.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("getSubDownloader".equals(str) && objArr.length == 2) {
                    return ((DownloadQueryPoint) extension).getSubDownloader((AppModel) objArr[0], (Bundle) objArr[1]);
                }
                return null;
            }
        });
    }

    public static void opt2() {
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(TemplateBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_ExtOpt.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("getExtConfig".equals(str) && objArr.length == 1) {
                    return ((TemplateBridgeExtension) extension).getExtConfig((App) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(SubPackageBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_ExtOpt.3
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("loadSubPackage".equals(str) && objArr.length == 4) {
                    ((SubPackageBridgeExtension) extension).loadSubPackage((App) objArr[0], (String) objArr[1], (JSONArray) objArr[2], (BridgeCallback) objArr[3]);
                    return null;
                }
                return null;
            }
        });
    }

    public static void opt3() {
        try {
            final Method declaredMethod = DownloadQueryPoint.class.getDeclaredMethod("getSubDownloader", AppModel.class, Bundle.class);
            ExtensionPoint.registerProxyGenerator(DownloadQueryPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_ExtOpt.4
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new DownloadQueryPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_ExtOpt.4.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.subpackage.DownloadQueryPoint
                        public ISubPackageDownloader getSubDownloader(AppModel appModel, Bundle bundle) {
                            try {
                                return (ISubPackageDownloader) invocationHandler.invoke(this, declaredMethod, new Object[]{appModel, bundle});
                            } catch (Throwable th) {
                                ExtensionPoint.reportException(th);
                                return null;
                            }
                        }
                    };
                }
            });
        } catch (Throwable th) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.subpackage.DownloadQueryPoint error, ignored", th);
        }
    }
}
