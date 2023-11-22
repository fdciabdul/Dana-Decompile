package com.alibaba.ariver.integration;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.alibaba.ariver.app.NodeInstance;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.ipc.ServerMsgReceiver;
import com.alibaba.ariver.engine.api.common.log.IgnoreLogUtils;
import com.alibaba.ariver.engine.api.proxy.RVEFilterCenterProxy;
import com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.integration.ipc.server.MainAppBizHandler;
import com.alibaba.ariver.integration.ipc.server.ServerApiBizHandler;
import com.alibaba.ariver.ipc.RemoteCallClient;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.api.extension.DefaultExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.registry.BridgeDSLRegistry;
import com.alibaba.ariver.kernel.api.extension.registry.DefaultExtensionRegistry;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionBlackListStore;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class RVInitializer {
    private static final String MANIFEST_CLZ = "com.alibaba.ariver.AriverManifest";
    private static final String MANIFEST_COMMONABILITY_CLZ = "com.alibaba.ariver.commonability.integration.ManifestManager";
    private static final String MANIFEST_META_KEY = "ariver_manifest";
    private static boolean alreadyInited;
    private static boolean alreadySetupProxy;
    private static ExtensionManager sExtensionManager;
    private static RVProxy.Printer sPrinter;
    private static RVManifest sProjectManifest;
    private static String[] optPackages = {com.alibaba.ariver.kernel.BuildConfig.APPLICATION_ID, com.alibaba.ariver.kernel.api.BuildConfig.APPLICATION_ID, com.alibaba.ariver.app.BuildConfig.APPLICATION_ID, com.alibaba.ariver.app.api.BuildConfig.APPLICATION_ID, com.alibaba.ariver.resource.BuildConfig.APPLICATION_ID, com.alibaba.ariver.resource.api.BuildConfig.APPLICATION_ID, com.alibaba.ariver.engine.BuildConfig.APPLICATION_ID, com.alibaba.ariver.engine.api.BuildConfig.APPLICATION_ID, "com.alibaba.ariver.jsapi", BuildConfig.APPLICATION_ID, com.alibaba.ariver.permission.BuildConfig.APPLICATION_ID, "com.alibaba.ariver.permission.api", "com.alibaba.ariver.commonability.file", "com.alibaba.ariver.commonability.device", "com.alipay.mobile.aompfilemanager", "com.alipay.mobile.nebulax.resource.biz", "com.alipay.mobile.nebulax.integration.base", "com.alipay.mobile.nebulax.integration.wallet"};
    private static AtomicBoolean sOptOptimizeInited = new AtomicBoolean(false);

    public static void setPrinter(RVProxy.Printer printer) {
        sPrinter = printer;
    }

    private static RVProxy.Printer getPrinter() {
        RVProxy.Printer printer;
        synchronized (RVInitializer.class) {
            if (sPrinter == null) {
                sPrinter = new RVProxy.EmptyPrinter();
            }
            printer = sPrinter;
        }
        return printer;
    }

    public static RVManifest getProjectManifest() {
        return sProjectManifest;
    }

    public static void reset() {
        synchronized (RVInitializer.class) {
            alreadyInited = false;
            alreadySetupProxy = false;
        }
    }

    public static void init(Context context) {
        synchronized (RVInitializer.class) {
            init(context, null);
        }
    }

    public static void init(Context context, ExtensionManager extensionManager) {
        ExtensionRegistry defaultExtensionRegistry;
        BridgeDSLRegistry bridgeDSLRegistry;
        synchronized (RVInitializer.class) {
            if (alreadyInited) {
                return;
            }
            getPrinter().print("begin RVInitializer.init");
            alreadyInited = true;
            ensureManifestFile(context);
            setupProxy(context);
            try {
                getPrinter().print("RVInitializer.init step 1");
                if (extensionManager != null) {
                    defaultExtensionRegistry = extensionManager.getExtensionRegistry();
                } else {
                    defaultExtensionRegistry = new DefaultExtensionRegistry();
                }
                if (extensionManager != null) {
                    bridgeDSLRegistry = extensionManager.getBridgeDSLRegistry();
                } else {
                    bridgeDSLRegistry = new BridgeDSLRegistry();
                }
                getPrinter().print("RVInitializer.init step 2");
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int i = 0;
                List<RVManifest.BridgeExtensionManifest> bridgeExtensions = sProjectManifest.getBridgeExtensions();
                if (bridgeExtensions != null) {
                    i = bridgeExtensions.size();
                    for (RVManifest.BridgeExtensionManifest bridgeExtensionManifest : bridgeExtensions) {
                        if (bridgeExtensionManifest.isRawType) {
                            defaultExtensionRegistry.register(bridgeExtensionManifest.extensionMetaInfo);
                        } else {
                            defaultExtensionRegistry.register(bridgeExtensionManifest.target, bridgeExtensionManifest.scope, bridgeExtensionManifest.instanceType);
                        }
                        if (bridgeExtensionManifest.bridgeDSLs != null && !bridgeExtensionManifest.bridgeDSLs.isEmpty()) {
                            bridgeDSLRegistry.register(bridgeExtensionManifest.bridgeDSLs);
                        }
                    }
                }
                RVProxy.Printer printer = getPrinter();
                StringBuilder sb = new StringBuilder();
                sb.append("register bridge done with size: ");
                sb.append(i);
                sb.append(", cost: ");
                sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                printer.print(sb.toString());
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                List<ExtensionMetaInfo> extensions = sProjectManifest.getExtensions();
                registerExtensionsForFinalExecute(extensions);
                if (extensions != null) {
                    i = extensions.size();
                    for (ExtensionMetaInfo extensionMetaInfo : extensions) {
                        ExtensionBlackListStore.setupExtensionBlackList(extensionMetaInfo);
                        defaultExtensionRegistry.register(extensionMetaInfo);
                    }
                }
                RVProxy.Printer printer2 = getPrinter();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("register extension done with size: ");
                sb2.append(i);
                sb2.append(", cost: ");
                sb2.append(SystemClock.elapsedRealtime() - elapsedRealtime2);
                printer2.print(sb2.toString());
                if (extensionManager == null) {
                    extensionManager = new DefaultExtensionManager(sProjectManifest.getAccessController(), sProjectManifest.getRemoteController(), defaultExtensionRegistry, bridgeDSLRegistry);
                }
                RVProxy.Printer printer3 = getPrinter();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("register bridge done with jsapi count: ");
                sb3.append(defaultExtensionRegistry.getActionCount());
                printer3.print(sb3.toString());
                BridgeDispatcher.getInstance().bindExtensionManager(extensionManager);
                ExtensionPoint.bind(extensionManager);
                NodeInstance.bindExtensionManager(extensionManager);
                sExtensionManager = extensionManager;
                List<AppUpdaterFactory.Rule> appUpdaterRules = sProjectManifest.getAppUpdaterRules();
                if (appUpdaterRules != null) {
                    Iterator<AppUpdaterFactory.Rule> it = appUpdaterRules.iterator();
                    while (it.hasNext()) {
                        AppUpdaterFactory.registerRule(it.next());
                    }
                }
                if (ProcessUtils.isMainProcess()) {
                    ServerMsgReceiver.getInstance().registerBizHandler(IpcMessageConstants.BIZ_APP, new MainAppBizHandler());
                    ServerMsgReceiver.getInstance().registerBizHandler(IpcMessageConstants.BIZ_APP, new ServerApiBizHandler(extensionManager));
                    IpcChannelManager.getInstance().registerServerChannel(new IIpcChannel.Stub() { // from class: com.alibaba.ariver.integration.RVInitializer.1
                        @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                        public final boolean isFinishing() throws RemoteException {
                            return false;
                        }

                        @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                        public final void sendMessage(IpcMessage ipcMessage) throws RemoteException {
                            ServerMsgReceiver.getInstance().handleMessage(ipcMessage);
                        }
                    });
                    List<RVManifest.ServiceBeanManifest> serviceBeans = sProjectManifest.getServiceBeans(extensionManager);
                    if (serviceBeans != null) {
                        for (RVManifest.ServiceBeanManifest serviceBeanManifest : serviceBeans) {
                            ((RVRemoteCallerProxy) RVProxy.get(RVRemoteCallerProxy.class)).registerServiceBean(serviceBeanManifest.beanClass, serviceBeanManifest.beanObject.get());
                        }
                    }
                } else {
                    RemoteCallClient.prepare();
                }
                setupOptimize();
                ((RVEFilterCenterProxy) RVProxy.get(RVEFilterCenterProxy.class)).initFilters();
                getPrinter().print("end RVInitializer.init");
            } catch (Throwable th) {
                RVProxy.Printer printer4 = getPrinter();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("setup ExtensionManager exception!");
                sb4.append(Log.getStackTraceString(th));
                printer4.print(sb4.toString());
                throw new IllegalStateException("setup ExtensionManager exception!", th);
            }
        }
    }

    private static void registerExtensionsForFinalExecute(List<ExtensionMetaInfo> list) {
        list.add(new ExtensionMetaInfo("ariver-build", "com.alibaba.ariver.jsapi.logging.RVPerfLogLifeCycleExtension", Arrays.asList("com.alibaba.ariver.app.api.point.page.PageInitPoint", "com.alibaba.ariver.app.api.point.page.PageExitPoint", "com.alibaba.ariver.app.api.point.app.AppExitPoint"), App.class));
    }

    public static ExtensionManager getExtensionManager() {
        return sExtensionManager;
    }

    public static void setupProxy(Context context) {
        synchronized (RVInitializer.class) {
            if (alreadySetupProxy) {
                return;
            }
            getPrinter().print("begin setupProxy");
            alreadySetupProxy = true;
            ensureManifestFile(context);
            try {
                RVProxy.setPrinter(getPrinter());
                List<RVManifest.IProxyManifest> proxies = sProjectManifest.getProxies();
                int size = proxies == null ? 0 : proxies.size();
                RVProxy.Printer printer = getPrinter();
                StringBuilder sb = new StringBuilder();
                sb.append("setupProxy size ");
                sb.append(size);
                printer.print(sb.toString());
                if (proxies != null) {
                    for (RVManifest.IProxyManifest iProxyManifest : proxies) {
                        try {
                            InstanceType instanceType = iProxyManifest.getInstanceType();
                            if (iProxyManifest instanceof RVManifest.ProxyManifest) {
                                RVProxy.set(instanceType, ((RVManifest.ProxyManifest) iProxyManifest).proxiableClass, ((RVManifest.ProxyManifest) iProxyManifest).implObject);
                            } else if (iProxyManifest instanceof RVManifest.LazyProxyManifest) {
                                RVProxy.setLazy(instanceType, ((RVManifest.LazyProxyManifest) iProxyManifest).proxiableClass, ((RVManifest.LazyProxyManifest) iProxyManifest).implObject);
                            }
                        } catch (Throwable th) {
                            RVProxy.Printer printer2 = getPrinter();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("setupProxy item exception!");
                            sb2.append(Log.getStackTraceString(th));
                            printer2.print(sb2.toString());
                        }
                    }
                }
                RVProxy.sHasSetupProxy = true;
            } catch (Throwable th2) {
                RVProxy.Printer printer3 = getPrinter();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("setupProxy error!");
                sb3.append(Log.getStackTraceString(th2));
                printer3.print(sb3.toString());
                throw new IllegalStateException("setupProxy error!", th2);
            }
        }
    }

    public static void setProjectManifest(RVManifest rVManifest) {
        sProjectManifest = rVManifest;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void ensureManifestFile(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.integration.RVInitializer.ensureManifestFile(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setupOptimize() {
        if (!((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_apt", true)) {
            ExtensionPoint.clearProxyGenerator();
            ExtensionOpt.clearAllMethodInvokeOptimizer();
            sOptOptimizeInited.getAndSet(false);
        } else if (!sOptOptimizeInited.getAndSet(true)) {
            for (String str : optPackages) {
                try {
                    String initClassNameFromPkgName = initClassNameFromPkgName(str);
                    RVProxy.Printer printer = getPrinter();
                    StringBuilder sb = new StringBuilder();
                    sb.append("RVInitializer.setupOptimize get final class name: ");
                    sb.append(initClassNameFromPkgName);
                    sb.append(" for packageName: ");
                    sb.append(str);
                    printer.print(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("com.alibaba.ariver.apt.");
                    sb2.append(initClassNameFromPkgName);
                    Class<?> cls = Class.forName(sb2.toString());
                    if (cls != null) {
                        ReflectUtils.invokeMethod((Class) cls, "opt1");
                        ReflectUtils.invokeMethod((Class) cls, "opt2");
                        ReflectUtils.invokeMethod((Class) cls, "opt3");
                    }
                } catch (Throwable th) {
                    RVProxy.Printer printer2 = getPrinter();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("RVInitializer.setupOptimize error: ");
                    sb3.append(th.getMessage());
                    printer2.print(sb3.toString());
                }
            }
        }
    }

    private static String initClassNameFromPkgName(String str) {
        String[] strArr = {"com.alipay.mobile.nebulax.integration.wallet", "com.alibaba.ariver.commonability.device", "com.alibaba.ariver.commonability.file"};
        for (int i = 0; i < 3; i++) {
            String str2 = strArr[i];
            if (str.startsWith(str2)) {
                str = str2;
            }
        }
        String[] split = str.split("\\.");
        int i2 = 4;
        if (str.startsWith("com.alipay.mobile.nebulax")) {
            i2 = 6;
        } else if (str.startsWith("com.alibaba.ariver.commonability")) {
            i2 = 5;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (String str3 : split) {
            if (i3 > i2 || (i3 > i2 - 1 && !IgnoreLogUtils.TYPE_API.equalsIgnoreCase(str3))) {
                break;
            }
            if (i3 > 0) {
                sb.append("_");
            }
            sb.append(str3);
            i3++;
        }
        sb.append("_ExtOpt");
        String obj = sb.toString();
        PrintStream printStream = System.out;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("get final class name: ");
        sb2.append(obj);
        printStream.println(sb2.toString());
        return obj;
    }
}
