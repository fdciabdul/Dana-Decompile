package com.alibaba.ariver.integration;

import android.util.Log;
import com.alibaba.ariver.kernel.api.classloader.RVClassLoaderFactory;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.exthub.ExtHubBridgeExtensionManifest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface RVManifest {
    AccessController getAccessController();

    List<AppUpdaterFactory.Rule> getAppUpdaterRules();

    List<BridgeDSL> getBridgeDSLs();

    List<BridgeExtensionManifest> getBridgeExtensions();

    Map<String, EmbedViewMetaInfo> getEmbedViews();

    List<ExtensionMetaInfo> getExtensions();

    List<IProxyManifest> getProxies();

    RemoteController getRemoteController();

    List<ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager);

    /* loaded from: classes3.dex */
    public static abstract class IProxyManifest {
        InstanceType instanceType;

        public IProxyManifest instanceType(InstanceType instanceType) {
            this.instanceType = instanceType;
            return this;
        }

        public InstanceType getInstanceType() {
            return this.instanceType;
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public static class ProxyManifest extends IProxyManifest {
        Proxiable implObject;
        Class<? extends Proxiable> proxiableClass;

        public ProxyManifest(Class<? extends Proxiable> cls, Proxiable proxiable) {
            RVProxy.Printer printer = RVProxy.getPrinter();
            StringBuilder sb = new StringBuilder();
            sb.append("new ProxyManifest ");
            sb.append(cls);
            printer.print(sb.toString());
            this.proxiableClass = cls;
            this.implObject = proxiable;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ProxyManifest{proxiableClass=");
            sb.append(this.proxiableClass);
            sb.append(", implObject=");
            sb.append(this.implObject);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class LazyProxyManifest<T extends Proxiable> extends IProxyManifest {
        String implClass;
        String implClassBundle;
        RVProxy.LazyGetter<T> implObject;
        Class<T> proxiableClass;

        public LazyProxyManifest(Class<T> cls, RVProxy.LazyGetter<T> lazyGetter) {
            RVProxy.Printer printer = RVProxy.getPrinter();
            StringBuilder sb = new StringBuilder();
            sb.append("new LazyProxyManifest ");
            sb.append(cls);
            printer.print(sb.toString());
            this.proxiableClass = cls;
            this.implObject = lazyGetter;
        }

        public LazyProxyManifest(final Class<T> cls, final String str, final String str2) {
            RVProxy.Printer printer = RVProxy.getPrinter();
            StringBuilder sb = new StringBuilder();
            sb.append("new LazyProxyManifest ");
            sb.append(cls);
            sb.append(" with class: ");
            sb.append(str2);
            printer.print(sb.toString());
            this.proxiableClass = cls;
            this.implClassBundle = str;
            this.implClass = str2;
            this.implObject = (RVProxy.LazyGetter<T>) new RVProxy.LazyGetter<T>() { // from class: com.alibaba.ariver.integration.RVManifest.LazyProxyManifest.1
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public T get() {
                    try {
                        Class<?> loadClass = ((RVClassLoaderFactory) RVProxy.get(RVClassLoaderFactory.class)).getClassLoader(str).loadClass(str2);
                        if (!cls.isAssignableFrom(loadClass)) {
                            RVProxy.Printer printer2 = RVProxy.getPrinter();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(cls);
                            sb2.append(" with implClassName: ");
                            sb2.append(str2);
                            sb2.append(" type error!!!");
                            printer2.print(sb2.toString());
                            return null;
                        }
                        return (T) loadClass.newInstance();
                    } catch (Throwable th) {
                        RVProxy.Printer printer3 = RVProxy.getPrinter();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(cls);
                        sb3.append(" with implClassName: ");
                        sb3.append(str2);
                        sb3.append(" init failed!!! ");
                        sb3.append(Log.getStackTraceString(th));
                        printer3.print(sb3.toString());
                        return null;
                    }
                }
            };
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LazyProxyManifest{proxiableClass=");
            sb.append(this.proxiableClass);
            sb.append(", implObject=");
            sb.append(this.implObject);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class BridgeExtensionManifest extends ExtHubBridgeExtensionManifest {
        public List<BridgeDSL> bridgeDSLs;
        public InstanceType instanceType;
        public Class<? extends Scope> scope;
        public Class<? extends BridgeExtension> target;

        public static BridgeExtensionManifest makeRaw(String str, String str2, List<String> list) {
            BridgeExtensionManifest bridgeExtensionManifest = new BridgeExtensionManifest();
            bridgeExtensionManifest.isRawType = true;
            bridgeExtensionManifest.extensionMetaInfo = new ExtensionMetaInfo(str, str2, list, (Class<? extends Scope>) null, ExtensionType.BRIDGE, true);
            return bridgeExtensionManifest;
        }

        public static BridgeExtensionManifest makeRaw(String str, String str2, List<String> list, Class<? extends Scope> cls) {
            BridgeExtensionManifest bridgeExtensionManifest = new BridgeExtensionManifest();
            bridgeExtensionManifest.isRawType = true;
            bridgeExtensionManifest.extensionMetaInfo = new ExtensionMetaInfo(str, str2, list, cls, ExtensionType.BRIDGE, true);
            return bridgeExtensionManifest;
        }

        public static BridgeExtensionManifest make(Class<? extends BridgeExtension> cls) {
            return make(cls, null);
        }

        public static BridgeExtensionManifest make(Class<? extends BridgeExtension> cls, Class<? extends Scope> cls2) {
            BridgeExtensionManifest bridgeExtensionManifest = new BridgeExtensionManifest();
            bridgeExtensionManifest.target = cls;
            bridgeExtensionManifest.scope = cls2;
            return bridgeExtensionManifest;
        }

        public BridgeExtensionManifest instanceType(InstanceType instanceType) {
            if (this.isRawType && this.extensionMetaInfo != null) {
                this.extensionMetaInfo.instanceType(instanceType);
            } else {
                this.instanceType = instanceType;
            }
            return this;
        }

        public void addBridgeExtensionDSL(BridgeDSL bridgeDSL) {
            if (this.bridgeDSLs == null) {
                this.bridgeDSLs = new ArrayList();
            }
            this.bridgeDSLs.add(bridgeDSL);
        }

        private BridgeExtensionManifest() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BridgeExtensionManifest{target=");
            sb.append(this.target);
            sb.append(", scope=");
            sb.append(this.scope);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class ServiceBeanManifest<T> {
        Class<T> beanClass;
        RVProxy.LazyGetter<T> beanObject;

        public ServiceBeanManifest(Class<T> cls, RVProxy.LazyGetter<T> lazyGetter) {
            this.beanClass = cls;
            this.beanObject = lazyGetter;
        }
    }
}
