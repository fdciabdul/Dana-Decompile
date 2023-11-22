package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionType;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.exthub.common.ExtHubLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultExtensionRegistry implements ExtensionRegistry {

    /* renamed from: a  reason: collision with root package name */
    private BridgeExtensionStore f6088a;
    private final Set<Class<? extends Extension>> b = new HashSet();
    private final Map<String, List<ExtensionMetaInfo>> c = new HashMap();
    private final Map<String, Class<? extends Scope>> d = new HashMap();
    private final PointToExtensionStore e;
    private final List<ExtensionMetaInfo> f;
    private boolean g;

    public DefaultExtensionRegistry() {
        PointToExtensionStore pointToExtensionStore = new PointToExtensionStore();
        this.e = pointToExtensionStore;
        this.f = new LinkedList();
        this.g = false;
        BridgeExtensionStore bridgeExtensionStore = new BridgeExtensionStore();
        this.f6088a = bridgeExtensionStore;
        bridgeExtensionStore.setPointToExtensionStore(pointToExtensionStore);
    }

    public DefaultExtensionRegistry(boolean z) {
        PointToExtensionStore pointToExtensionStore = new PointToExtensionStore();
        this.e = pointToExtensionStore;
        this.f = new LinkedList();
        this.g = z;
        BridgeExtensionStore bridgeExtensionStore = new BridgeExtensionStore(z);
        this.f6088a = bridgeExtensionStore;
        bridgeExtensionStore.setPointToExtensionStore(pointToExtensionStore);
    }

    public PointToExtensionStore getPointToExtensionStore() {
        return this.e;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public void register(Class<? extends Extension> cls) {
        synchronized (this) {
            register(cls, null);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public void register(Class<? extends Extension> cls, Class<? extends Scope> cls2) {
        synchronized (this) {
            register(cls, cls2, null);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public void register(Class<? extends Extension> cls, Class<? extends Scope> cls2, InstanceType instanceType) {
        synchronized (this) {
            if (instanceType == null) {
                instanceType = MultiInstanceUtils.getDefaultInstanceType();
            }
            if (BridgeExtension.class.isAssignableFrom(cls)) {
                try {
                    this.f6088a.register(cls, true, instanceType);
                    a(cls, cls2);
                    return;
                } catch (Throwable th) {
                    ExtHubLogger.w("AriverKernel:DefaultExtensionRegistry", cls.getSimpleName(), th);
                }
            }
            if (!Extension.class.isAssignableFrom(cls)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Class ");
                sb.append(cls);
                sb.append(" is not valid extension");
                ExtHubLogger.e("AriverKernel:DefaultExtensionRegistry", sb.toString());
                return;
            }
            synchronized (this.b) {
                if (this.b.contains(cls)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Extension ");
                    sb2.append(cls);
                    sb2.append(" is already registered");
                    ExtHubLogger.e("AriverKernel:DefaultExtensionRegistry", sb2.toString());
                    return;
                }
                this.b.add(cls);
                a(cls, cls2);
                this.e.registerExtension(instanceType, cls);
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public Collection<Class<? extends Extension>> findExtensions(String str) {
        return findExtensions(null, str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public Collection<Class<? extends Extension>> findExtensions(InstanceType instanceType, String str) {
        Collection<Class<? extends Extension>> extensionsByPoint;
        List<ExtensionMetaInfo> list = this.c.get(str);
        if (list != null) {
            for (ExtensionMetaInfo extensionMetaInfo : list) {
                Class<? extends Extension> loadClass = ClassLoaderUtils.loadClass(extensionMetaInfo.bundleName, extensionMetaInfo.extensionClass);
                if (loadClass == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("load meta ");
                    sb.append(extensionMetaInfo.extensionClass);
                    sb.append(" error!");
                    ExtHubLogger.e("AriverKernel:DefaultExtensionRegistry", sb.toString());
                } else {
                    synchronized (this.b) {
                        if (!this.b.contains(loadClass)) {
                            register(loadClass, extensionMetaInfo.scope, extensionMetaInfo.getInstanceType());
                        }
                    }
                }
            }
            this.c.remove(str);
        }
        ArrayList arrayList = new ArrayList();
        if (instanceType != null && instanceType != MultiInstanceUtils.getDefaultInstanceType() && (extensionsByPoint = this.e.getExtensionsByPoint(instanceType, str)) != null) {
            arrayList.addAll(extensionsByPoint);
        }
        Collection<Class<? extends Extension>> extensionsByPoint2 = this.e.getExtensionsByPoint(MultiInstanceUtils.getDefaultInstanceType(), str);
        if (extensionsByPoint2 != null) {
            arrayList.addAll(extensionsByPoint2);
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public ActionMeta findActionMeta(InstanceType instanceType, String str) {
        if (instanceType != null) {
            return this.f6088a.findActionMeta(instanceType, str);
        }
        return this.f6088a.findActionMeta(MultiInstanceUtils.getDefaultInstanceType(), str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public int getActionCount() {
        return this.f6088a.getRegisteredActionCount();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public void register(ExtensionMetaInfo extensionMetaInfo) {
        synchronized (this) {
            if (extensionMetaInfo.type == ExtensionType.BRIDGE) {
                StringBuilder sb = new StringBuilder();
                sb.append("register meta(bridge): ");
                sb.append(extensionMetaInfo.extensionClass);
                ExtHubLogger.d("AriverKernel:DefaultExtensionRegistry", sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("register meta(normal): ");
                sb2.append(extensionMetaInfo.extensionClass);
                ExtHubLogger.d("AriverKernel:DefaultExtensionRegistry", sb2.toString());
            }
            if (!extensionMetaInfo.isLazy) {
                ClassLoaderUtils.loadClass(extensionMetaInfo.bundleName, extensionMetaInfo.extensionClass);
            }
            if (ExtensionType.NORMAL == extensionMetaInfo.type) {
                if (extensionMetaInfo.filter != null && extensionMetaInfo.filter.size() > 0) {
                    for (String str : extensionMetaInfo.filter) {
                        List<ExtensionMetaInfo> list = this.c.get(str);
                        if (list == null) {
                            list = new LinkedList<>();
                        }
                        list.add(extensionMetaInfo);
                        this.c.put(str, list);
                    }
                }
            } else if (ExtensionType.BRIDGE == extensionMetaInfo.type) {
                this.f6088a.register(extensionMetaInfo);
            }
            a(extensionMetaInfo.extensionClass, extensionMetaInfo.scope);
            this.f.add(extensionMetaInfo);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public void unRegister(List<String> list) {
        this.f6088a.unRegister(list);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public Class<? extends Scope> getScope(String str) {
        return this.d.get(str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public Class<? extends Scope> getScope(Class<? extends Extension> cls) {
        return getScope(cls.getName());
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public Class<? extends Extension> getExtensionClass(String str) {
        for (Class<? extends Extension> cls : this.b) {
            if (cls.getName().equals(str)) {
                return cls;
            }
        }
        for (ExtensionMetaInfo extensionMetaInfo : this.f) {
            if (str.equals(extensionMetaInfo.extensionClass)) {
                return ClassLoaderUtils.loadClass(extensionMetaInfo.bundleName, extensionMetaInfo.extensionClass);
            }
        }
        return null;
    }

    private void a(String str, Class<? extends Scope> cls) {
        if (this.d.containsKey(str)) {
            return;
        }
        this.d.put(str, cls);
    }

    private void a(Class<? extends Extension> cls, Class<? extends Scope> cls2) {
        a(cls.getName(), cls2);
    }

    protected Extension createExtensionInstance(Class<? extends Extension> cls) throws IllegalAccessException, InstantiationException {
        return cls.newInstance();
    }
}
