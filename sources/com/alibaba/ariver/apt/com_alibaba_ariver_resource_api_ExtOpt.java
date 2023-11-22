package com.alibaba.ariver.apt;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.AppConfigModelInitPoint;
import com.alibaba.ariver.resource.api.extension.AppModelInitPoint;
import com.alibaba.ariver.resource.api.extension.PackageParsedPoint;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint;
import com.alibaba.ariver.resource.api.extension.ReceivedHeaderPoint;
import com.alibaba.ariver.resource.api.extension.ResourceFinishLoadPoint;
import com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint;
import com.alibaba.ariver.resource.api.extension.ResourceInterceptRequestPoint;
import com.alibaba.ariver.resource.api.extension.ResourcePerceptionRequestPoint;
import com.alibaba.ariver.resource.api.extension.ResourcePerceptionResponsePoint;
import com.alibaba.ariver.resource.api.extension.ResourceProviderPoint;
import com.alibaba.ariver.resource.api.extension.ResourceReceivedResponsePoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.prepare.PrepareAppInfoGetPoint;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public final class com_alibaba_ariver_resource_api_ExtOpt {
    public static void opt2() {
    }

    public static void opt1() {
        ExtensionOpt.setupMethodInvokeOptimizer(PrepareAppInfoGetPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppPrepare".equals(str) && objArr.length == 4) {
                    ((PrepareAppInfoGetPoint) extension).onAppPrepare((App) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2], (AppModel) objArr[3]);
                }
                if ("onAppStart".equals(str) && objArr.length == 3) {
                    ((PrepareAppInfoGetPoint) extension).onAppStart((App) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PluginPackageParsedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPluginParsed".equals(str) && objArr.length == 3) {
                    ((PluginPackageParsedPoint) extension).onPluginParsed((AppModel) objArr[0], (PluginModel) objArr[1], (ResourcePackage) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceFinishLoadPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.3
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onResourceFinishLoad".equals(str) && objArr.length == 4) {
                    ((ResourceFinishLoadPoint) extension).onResourceFinishLoad((Page) objArr[0], (String) objArr[1], ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppModelInitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.4
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onGetAppInfo".equals(str) && objArr.length == 1) {
                    ((AppModelInitPoint) extension).onGetAppInfo((AppModel) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PackageParsedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.5
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onResourceParsed".equals(str) && objArr.length == 2) {
                    ((PackageParsedPoint) extension).onResourceParsed((AppModel) objArr[0], (ResourcePackage) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourcePerceptionResponsePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.6
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onResourceResponse".equals(str) && objArr.length == 6) {
                    ((ResourcePerceptionResponsePoint) extension).onResourceResponse((String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2], (Map) objArr[3], ((Long) objArr[4]).longValue(), ((Long) objArr[5]).longValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceReceivedResponsePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.7
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onResourceResponse".equals(str) && objArr.length == 5) {
                    ((ResourceReceivedResponsePoint) extension).onResourceResponse((Page) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), (Map) objArr[3], ((Long) objArr[4]).longValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppConfigModelInitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.8
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppConfigModelInit".equals(str) && objArr.length == 2) {
                    ((AppConfigModelInitPoint) extension).onAppConfigModelInit((App) objArr[0], (AppConfigModel) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PackageQueryPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.9
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("getMainPackage".equals(str) && objArr.length == 1) {
                    return ((PackageQueryPoint) extension).getMainPackage((ResourceContext) objArr[0]);
                }
                if ("getResourcePackages".equals(str) && objArr.length == 1) {
                    return ((PackageQueryPoint) extension).getResourcePackages((ResourceContext) objArr[0]);
                }
                if ("createPluginPackage".equals(str) && objArr.length == 3) {
                    return ((PackageQueryPoint) extension).createPluginPackage((AppModel) objArr[0], (PluginModel) objArr[1], (ResourceContext) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceProviderPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.10
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("getResource".equals(str) && objArr.length == 1) {
                    return ((ResourceProviderPoint) extension).getResource((ResourceQuery) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourcePerceptionRequestPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.11
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onResourceRequest".equals(str) && objArr.length == 4) {
                    ((ResourcePerceptionRequestPoint) extension).onResourceRequest((String) objArr[0], (String) objArr[1], (Map) objArr[2], ((Long) objArr[3]).longValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceInterceptRequestPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.12
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("shouldInterceptRequest".equals(str) && objArr.length == 5) {
                    ((ResourceInterceptRequestPoint) extension).shouldInterceptRequest((Page) objArr[0], (String) objArr[1], (String) objArr[2], (Map) objArr[3], ((Long) objArr[4]).longValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ReceivedHeaderPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.13
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onReceivedResponseHeader".equals(str) && objArr.length == 3) {
                    ((ReceivedHeaderPoint) extension).onReceivedResponseHeader((Page) objArr[0], (String) objArr[1], (Map) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.14
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("intercept".equals(str) && objArr.length == 1) {
                    return ((ResourceInterceptPoint) extension).intercept((Resource) objArr[0]);
                }
                return null;
            }
        });
    }

    public static void opt3() {
        try {
            final Method declaredMethod = PrepareAppInfoGetPoint.class.getDeclaredMethod("onAppPrepare", App.class, Bundle.class, Bundle.class, AppModel.class);
            final Method declaredMethod2 = PrepareAppInfoGetPoint.class.getDeclaredMethod("onAppStart", App.class, Bundle.class, Bundle.class);
            ExtensionPoint.registerProxyGenerator(PrepareAppInfoGetPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.15
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new PrepareAppInfoGetPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.15.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.prepare.PrepareAppInfoGetPoint
                        public void onAppPrepare(App app, Bundle bundle, Bundle bundle2, AppModel appModel) {
                            try {
                                invocationHandler.invoke(this, declaredMethod, new Object[]{app, bundle, bundle2, appModel});
                            } catch (Throwable th) {
                                ExtensionPoint.reportException(th);
                            }
                        }

                        @Override // com.alibaba.ariver.resource.api.prepare.PrepareAppInfoGetPoint
                        public void onAppStart(App app, Bundle bundle, Bundle bundle2) {
                            try {
                                invocationHandler.invoke(this, declaredMethod2, new Object[]{app, bundle, bundle2});
                            } catch (Throwable th) {
                                ExtensionPoint.reportException(th);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.prepare.PrepareAppInfoGetPoint error, ignored", th);
        }
        try {
            final Method declaredMethod3 = PluginPackageParsedPoint.class.getDeclaredMethod("onPluginParsed", AppModel.class, PluginModel.class, ResourcePackage.class);
            ExtensionPoint.registerProxyGenerator(PluginPackageParsedPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.16
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new PluginPackageParsedPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.16.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint
                        public void onPluginParsed(AppModel appModel, PluginModel pluginModel, ResourcePackage resourcePackage) {
                            try {
                                invocationHandler.invoke(this, declaredMethod3, new Object[]{appModel, pluginModel, resourcePackage});
                            } catch (Throwable th2) {
                                ExtensionPoint.reportException(th2);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th2) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint error, ignored", th2);
        }
        try {
            final Method declaredMethod4 = ResourceFinishLoadPoint.class.getDeclaredMethod("onResourceFinishLoad", Page.class, String.class, Long.TYPE, Long.TYPE);
            ExtensionPoint.registerProxyGenerator(ResourceFinishLoadPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.17
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new ResourceFinishLoadPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.17.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.ResourceFinishLoadPoint
                        public void onResourceFinishLoad(Page page, String str, long j, long j2) {
                            try {
                                invocationHandler.invoke(this, declaredMethod4, new Object[]{page, str, Long.valueOf(j), Long.valueOf(j2)});
                            } catch (Throwable th3) {
                                ExtensionPoint.reportException(th3);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th3) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceFinishLoadPoint error, ignored", th3);
        }
        try {
            final Method declaredMethod5 = AppModelInitPoint.class.getDeclaredMethod("onGetAppInfo", AppModel.class);
            ExtensionPoint.registerProxyGenerator(AppModelInitPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.18
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new AppModelInitPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.18.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.AppModelInitPoint
                        public void onGetAppInfo(AppModel appModel) {
                            try {
                                invocationHandler.invoke(this, declaredMethod5, new Object[]{appModel});
                            } catch (Throwable th4) {
                                ExtensionPoint.reportException(th4);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th4) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.AppModelInitPoint error, ignored", th4);
        }
        try {
            final Method declaredMethod6 = PackageParsedPoint.class.getDeclaredMethod("onResourceParsed", AppModel.class, ResourcePackage.class);
            ExtensionPoint.registerProxyGenerator(PackageParsedPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.19
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new PackageParsedPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.19.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.PackageParsedPoint
                        public void onResourceParsed(AppModel appModel, ResourcePackage resourcePackage) {
                            try {
                                invocationHandler.invoke(this, declaredMethod6, new Object[]{appModel, resourcePackage});
                            } catch (Throwable th5) {
                                ExtensionPoint.reportException(th5);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th5) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.PackageParsedPoint error, ignored", th5);
        }
        try {
            final Method declaredMethod7 = ResourcePerceptionResponsePoint.class.getDeclaredMethod("onResourceResponse", String.class, Integer.TYPE, String.class, Map.class, Long.TYPE, Long.TYPE);
            ExtensionPoint.registerProxyGenerator(ResourcePerceptionResponsePoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.20
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new ResourcePerceptionResponsePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.20.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.ResourcePerceptionResponsePoint
                        public void onResourceResponse(String str, int i, String str2, Map<String, String> map, long j, long j2) {
                            try {
                                invocationHandler.invoke(this, declaredMethod7, new Object[]{str, Integer.valueOf(i), str2, map, Long.valueOf(j), Long.valueOf(j2)});
                            } catch (Throwable th6) {
                                ExtensionPoint.reportException(th6);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th6) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourcePerceptionResponsePoint error, ignored", th6);
        }
        try {
            final Method declaredMethod8 = ResourceReceivedResponsePoint.class.getDeclaredMethod("onResourceResponse", Page.class, String.class, Integer.TYPE, Map.class, Long.TYPE);
            ExtensionPoint.registerProxyGenerator(ResourceReceivedResponsePoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.21
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new ResourceReceivedResponsePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.21.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.ResourceReceivedResponsePoint
                        public void onResourceResponse(Page page, String str, int i, Map<String, String> map, long j) {
                            try {
                                invocationHandler.invoke(this, declaredMethod8, new Object[]{page, str, Integer.valueOf(i), map, Long.valueOf(j)});
                            } catch (Throwable th7) {
                                ExtensionPoint.reportException(th7);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th7) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceReceivedResponsePoint error, ignored", th7);
        }
        try {
            final Method declaredMethod9 = AppConfigModelInitPoint.class.getDeclaredMethod("onAppConfigModelInit", App.class, AppConfigModel.class);
            ExtensionPoint.registerProxyGenerator(AppConfigModelInitPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.22
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new AppConfigModelInitPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.22.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.AppConfigModelInitPoint
                        public void onAppConfigModelInit(App app, AppConfigModel appConfigModel) {
                            try {
                                invocationHandler.invoke(this, declaredMethod9, new Object[]{app, appConfigModel});
                            } catch (Throwable th8) {
                                ExtensionPoint.reportException(th8);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th8) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.AppConfigModelInitPoint error, ignored", th8);
        }
        try {
            final Method declaredMethod10 = PackageQueryPoint.class.getDeclaredMethod("getMainPackage", ResourceContext.class);
            final Method declaredMethod11 = PackageQueryPoint.class.getDeclaredMethod("getResourcePackages", ResourceContext.class);
            final Method declaredMethod12 = PackageQueryPoint.class.getDeclaredMethod("createPluginPackage", AppModel.class, PluginModel.class, ResourceContext.class);
            ExtensionPoint.registerProxyGenerator(PackageQueryPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.23
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new PackageQueryPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.23.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
                        public ResourcePackage getMainPackage(ResourceContext resourceContext) {
                            try {
                                return (ResourcePackage) invocationHandler.invoke(this, declaredMethod10, new Object[]{resourceContext});
                            } catch (Throwable th9) {
                                ExtensionPoint.reportException(th9);
                                return null;
                            }
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
                        public Set<ResourcePackage> getResourcePackages(ResourceContext resourceContext) {
                            try {
                                return (Set) invocationHandler.invoke(this, declaredMethod11, new Object[]{resourceContext});
                            } catch (Throwable th9) {
                                ExtensionPoint.reportException(th9);
                                return null;
                            }
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
                        public ResourcePackage createPluginPackage(AppModel appModel, PluginModel pluginModel, ResourceContext resourceContext) {
                            try {
                                return (ResourcePackage) invocationHandler.invoke(this, declaredMethod12, new Object[]{appModel, pluginModel, resourceContext});
                            } catch (Throwable th9) {
                                ExtensionPoint.reportException(th9);
                                return null;
                            }
                        }
                    };
                }
            });
        } catch (Throwable th9) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.PackageQueryPoint error, ignored", th9);
        }
        try {
            final Method declaredMethod13 = ResourceProviderPoint.class.getDeclaredMethod("getResource", ResourceQuery.class);
            ExtensionPoint.registerProxyGenerator(ResourceProviderPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.24
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new ResourceProviderPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.24.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.ResourceProviderPoint
                        public Resource getResource(ResourceQuery resourceQuery) {
                            try {
                                return (Resource) invocationHandler.invoke(this, declaredMethod13, new Object[]{resourceQuery});
                            } catch (Throwable th10) {
                                ExtensionPoint.reportException(th10);
                                return null;
                            }
                        }
                    };
                }
            });
        } catch (Throwable th10) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceProviderPoint error, ignored", th10);
        }
        try {
            final Method declaredMethod14 = ResourcePerceptionRequestPoint.class.getDeclaredMethod("onResourceRequest", String.class, String.class, Map.class, Long.TYPE);
            ExtensionPoint.registerProxyGenerator(ResourcePerceptionRequestPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.25
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new ResourcePerceptionRequestPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.25.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.ResourcePerceptionRequestPoint
                        public void onResourceRequest(String str, String str2, Map<String, String> map, long j) {
                            try {
                                invocationHandler.invoke(this, declaredMethod14, new Object[]{str, str2, map, Long.valueOf(j)});
                            } catch (Throwable th11) {
                                ExtensionPoint.reportException(th11);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th11) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourcePerceptionRequestPoint error, ignored", th11);
        }
        try {
            final Method declaredMethod15 = ResourceInterceptRequestPoint.class.getDeclaredMethod("shouldInterceptRequest", Page.class, String.class, String.class, Map.class, Long.TYPE);
            ExtensionPoint.registerProxyGenerator(ResourceInterceptRequestPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.26
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new ResourceInterceptRequestPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.26.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.ResourceInterceptRequestPoint
                        public void shouldInterceptRequest(Page page, String str, String str2, Map<String, String> map, long j) {
                            try {
                                invocationHandler.invoke(this, declaredMethod15, new Object[]{page, str, str2, map, Long.valueOf(j)});
                            } catch (Throwable th12) {
                                ExtensionPoint.reportException(th12);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th12) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceInterceptRequestPoint error, ignored", th12);
        }
        try {
            final Method declaredMethod16 = ReceivedHeaderPoint.class.getDeclaredMethod("onReceivedResponseHeader", Page.class, String.class, Map.class);
            ExtensionPoint.registerProxyGenerator(ReceivedHeaderPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.27
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new ReceivedHeaderPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.27.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.ReceivedHeaderPoint
                        public void onReceivedResponseHeader(Page page, String str, Map<String, List<String>> map) {
                            try {
                                invocationHandler.invoke(this, declaredMethod16, new Object[]{page, str, map});
                            } catch (Throwable th13) {
                                ExtensionPoint.reportException(th13);
                            }
                        }
                    };
                }
            });
        } catch (Throwable th13) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ReceivedHeaderPoint error, ignored", th13);
        }
        try {
            final Method declaredMethod17 = ResourceInterceptPoint.class.getDeclaredMethod("intercept", Resource.class);
            ExtensionPoint.registerProxyGenerator(ResourceInterceptPoint.class, new ExtensionPoint.ProxyGenerator() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.28
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
                public final Object createProxyInstance(final InvocationHandler invocationHandler) {
                    return new ResourceInterceptPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt.28.1
                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onFinalized() {
                        }

                        @Override // com.alibaba.ariver.kernel.api.extension.Extension
                        public void onInitialized() {
                        }

                        @Override // com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint
                        public Resource intercept(Resource resource) {
                            try {
                                return (Resource) invocationHandler.invoke(this, declaredMethod17, new Object[]{resource});
                            } catch (Throwable th14) {
                                ExtensionPoint.reportException(th14);
                                return null;
                            }
                        }
                    };
                }
            });
        } catch (Throwable th14) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint error, ignored", th14);
        }
    }
}
