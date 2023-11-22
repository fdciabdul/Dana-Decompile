package com.alibaba.ariver.kernel.api.extension;

import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.extension.registry.BridgeDSLRegistry;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionBlackListStore;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteControlManagement;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessControlManagement;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.exthub.common.ExtHubLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class DefaultExtensionManager implements ExtensionManager {

    /* renamed from: a */
    private static ExtensionCreator f6080a;
    private BridgeDSLRegistry b;
    private AccessController c;
    private RemoteController d;
    protected ExtensionRegistry mExtensionRegistry;
    private final Map<Class<? extends Extension>, ExtensionFilter> e = new ConcurrentHashMap();
    private final Map<Class<? extends Extension>, Comparator> f = new ConcurrentHashMap();
    protected final Map<String, Extension> mSingletonExtensionMap = new HashMap();
    protected final Map<Node, Map<String, Extension>> mNodeExtensionMap = new HashMap();
    private final Map<Node, Map<Class<? extends Extension>, List<Extension>>> g = new HashMap();

    /* loaded from: classes3.dex */
    public interface ExtensionCreator {
        Extension createExtensionInstance(Class<? extends Extension> cls);
    }

    public DefaultExtensionManager(AccessController accessController, RemoteController remoteController, ExtensionRegistry extensionRegistry) {
        this.c = accessController;
        this.d = remoteController;
        remoteController.bindExtensionManager(this);
        this.mExtensionRegistry = extensionRegistry;
    }

    public DefaultExtensionManager(AccessController accessController, RemoteController remoteController, ExtensionRegistry extensionRegistry, BridgeDSLRegistry bridgeDSLRegistry) {
        this.c = accessController;
        this.d = remoteController;
        remoteController.bindExtensionManager(this);
        this.mExtensionRegistry = extensionRegistry;
        this.b = bridgeDSLRegistry;
    }

    public DefaultExtensionManager(ExtensionRegistry extensionRegistry) {
        this.mExtensionRegistry = extensionRegistry;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public List<Extension> getExtensionByPoint(Class<? extends Extension> cls) {
        return getExtensionByPoint(null, cls);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public ExtensionRegistry getExtensionRegistry() {
        return this.mExtensionRegistry;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public List<BridgeDSL> getBridgeDSLs() {
        BridgeDSLRegistry bridgeDSLRegistry = this.b;
        if (bridgeDSLRegistry != null) {
            return bridgeDSLRegistry.getBridgeDSLs();
        }
        return new ArrayList();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public BridgeDSLRegistry getBridgeDSLRegistry() {
        return this.b;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public <T extends Extension> void registerExtensionByPoint(Node node, Class<T> cls, T t) {
        if (node != null) {
            Map<Class<? extends Extension>, List<Extension>> map = this.g.get(node);
            if (map == null) {
                map = new ConcurrentHashMap<>();
                this.g.put(node, map);
            }
            List<Extension> list = map.get(cls);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                map.put(cls, list);
            }
            list.add(t);
            ExtensionPoint.invalidateExtensionCache(node, cls);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public List<Extension> getExtensionByPoint(Node node, Class<? extends Extension> cls) {
        if (this.mExtensionRegistry == null) {
            throw new RuntimeException("ExtensionRegistry not setup");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getExtensionsByPoint ");
        sb.append(cls.getName());
        ExtHubLogger.d("AriverKernel:ExtensionManager", sb.toString());
        List<Extension> arrayList = new ArrayList<>();
        List<? extends Extension> b = b(node, cls);
        if (b != null) {
            arrayList.addAll(b);
        }
        List<Extension> a2 = a(node, cls);
        if (a2 != null) {
            arrayList.addAll(a2);
        }
        if (arrayList.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cannot find extension by point: ");
            sb2.append(cls);
            ExtHubLogger.w("AriverKernel:ExtensionManager", sb2.toString());
            return null;
        }
        if (RVKernelUtils.isDebug()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("findExtension for ");
            sb3.append(cls);
            sb3.append(" result: \n static: ");
            sb3.append(b);
            sb3.append("\n dynamic: ");
            sb3.append(a2);
            ExtHubLogger.d("AriverKernel:ExtensionManager", sb3.toString());
        }
        ExtensionFilter extensionFilter = this.e.get(cls);
        if (extensionFilter != null) {
            arrayList = extensionFilter.filter(arrayList);
        }
        Comparator comparator = this.f.get(cls);
        if (comparator != null) {
            Collections.sort(arrayList, comparator);
        } else if (SimpleSorter.class.isAssignableFrom(cls)) {
            Collections.sort(arrayList, new Comparator<Extension>() { // from class: com.alibaba.ariver.kernel.api.extension.DefaultExtensionManager.1
                {
                    DefaultExtensionManager.this = this;
                }

                @Override // java.util.Comparator
                public int compare(Extension extension, Extension extension2) {
                    return (SimpleSortable.class.isAssignableFrom(extension2.getClass()) ? ((SimpleSortable) extension2).priority() : 0) - (SimpleSortable.class.isAssignableFrom(extension.getClass()) ? ((SimpleSortable) extension).priority() : 0);
                }
            });
        }
        return arrayList;
    }

    private List<Extension> a(Node node, Class<? extends Extension> cls) {
        List<Extension> list;
        ArrayList arrayList = new ArrayList();
        while (node != null) {
            try {
                if (this.g.get(node) != null && (list = this.g.get(node).get(cls)) != null) {
                    arrayList.addAll(list);
                }
                node = node.getParentNode();
            } catch (Exception e) {
                ExtHubLogger.e("AriverKernel:ExtensionManager", "getDynamicExtensionByPoint error", e);
            }
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public Extension getExtensionByName(Node node, String str) {
        Extension a2;
        ExtensionRegistry extensionRegistry = this.mExtensionRegistry;
        if (extensionRegistry == null) {
            throw new RuntimeException("ExtensionRegistry not setup");
        }
        try {
            Class<? extends Extension> extensionClass = extensionRegistry.getExtensionClass(str);
            Class<? extends Scope> scope = this.mExtensionRegistry.getScope(str);
            if (scope == null) {
                a2 = a(this.mSingletonExtensionMap, extensionClass);
            } else {
                Node node2 = node;
                while (node2 != null && !scope.isAssignableFrom(node2.getClass())) {
                    node2 = node2.getParentNode();
                }
                a2 = node2 != null ? a(this.mNodeExtensionMap.get(node2), extensionClass) : null;
            }
            if (a2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("getExtensionByName found null for extensionName: ");
                sb.append(str);
                sb.append(", node: ");
                sb.append(node);
                sb.append(", clazz: ");
                sb.append(extensionClass);
                sb.append(", scope: ");
                sb.append(scope);
                ExtHubLogger.w("AriverKernel:ExtensionManager", sb.toString());
            }
            return a2;
        } catch (Throwable th) {
            ExtHubLogger.w("AriverKernel:ExtensionManager", "getExtensionByName", th);
            return null;
        }
    }

    private BridgeExtension a(String str, ActionMeta actionMeta) {
        BridgeExtension bridgeExtension;
        Throwable th;
        synchronized (this) {
            if (actionMeta == null) {
                actionMeta = this.mExtensionRegistry.findActionMeta(MultiInstanceUtils.getDefaultInstanceType(), str);
            }
            if (actionMeta == null) {
                return null;
            }
            BridgeExtension bridgeExtension2 = (BridgeExtension) this.mSingletonExtensionMap.get(actionMeta.bridgeExtensionClazz.getName());
            if (bridgeExtension2 != null) {
                return bridgeExtension2;
            }
            try {
                bridgeExtension = (BridgeExtension) a(actionMeta.bridgeExtensionClazz);
            } catch (Throwable th2) {
                bridgeExtension = bridgeExtension2;
                th = th2;
            }
            try {
                this.mSingletonExtensionMap.put(actionMeta.bridgeExtensionClazz.getName(), bridgeExtension);
            } catch (Throwable th3) {
                th = th3;
                ExtHubLogger.e("AriverKernel:ExtensionManager", th);
                return bridgeExtension;
            }
            return bridgeExtension;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public BridgeExtension getBridgeExtensionByActionMeta(Node node, ActionMeta actionMeta) throws IllegalAccessException, InstantiationException {
        Class<? extends Scope> scope = this.mExtensionRegistry.getScope(actionMeta.bridgeExtensionClazz);
        if (scope == null || node == null) {
            return a(actionMeta.actionName, actionMeta);
        }
        if (!scope.isAssignableFrom(node.getClass())) {
            return getBridgeExtensionByActionMeta(node.getParentNode(), actionMeta);
        }
        Map<String, Extension> map = this.mNodeExtensionMap.get(node);
        if (map != null) {
            if (map.get(actionMeta.bridgeExtensionClazz.getName()) != null) {
                return (BridgeExtension) map.get(actionMeta.bridgeExtensionClazz.getName());
            }
            BridgeExtension bridgeExtension = (BridgeExtension) a(actionMeta.bridgeExtensionClazz);
            map.put(actionMeta.bridgeExtensionClazz.getName(), bridgeExtension);
            return bridgeExtension;
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public ActionMeta findActionMeta(Node node, String str) {
        InstanceType defaultInstanceType;
        InstanceType defaultInstanceType2 = node == null ? MultiInstanceUtils.getDefaultInstanceType() : node.getInstanceType();
        if (defaultInstanceType2 != null && defaultInstanceType2 != (defaultInstanceType = MultiInstanceUtils.getDefaultInstanceType())) {
            ActionMeta findActionMeta = this.mExtensionRegistry.findActionMeta(defaultInstanceType2, str);
            if (findActionMeta != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("findActionMeta with instanceType: ");
                sb.append(defaultInstanceType2);
                sb.append(" result: ");
                sb.append(findActionMeta);
                ExtHubLogger.d("AriverKernel:ExtensionManager", sb.toString());
                return findActionMeta;
            }
            return this.mExtensionRegistry.findActionMeta(defaultInstanceType, str);
        }
        return this.mExtensionRegistry.findActionMeta(defaultInstanceType2, str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public ActionMeta findActionMeta(InstanceType instanceType, Node node, String str) {
        return this.mExtensionRegistry.findActionMeta(instanceType, str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public void setExtensionFilter(Class<? extends Extension> cls, ExtensionFilter extensionFilter) {
        this.e.put(cls, extensionFilter);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public <T extends Extension> void setExtensionSorter(Class<T> cls, Comparator<? super T> comparator) {
        this.f.put(cls, comparator);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public void setAccessControlManagement(AccessControlManagement accessControlManagement) {
        AccessController accessController = this.c;
        if (accessController != null) {
            accessController.setAccessControlManagement(accessControlManagement);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public AccessController getAccessController() {
        return this.c;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public void setRemoteControlManagement(RemoteControlManagement remoteControlManagement) {
        RemoteController remoteController = this.d;
        if (remoteController != null) {
            remoteController.setRemoteControlManagement(remoteControlManagement);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public RemoteController getRemoteController() {
        return this.d;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public void enterNode(Node node) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("enterNode ");
            sb.append(node);
            ExtHubLogger.d("AriverKernel:ExtensionManager", sb.toString());
            this.mNodeExtensionMap.put(node, new HashMap());
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public void exitNode(Node node) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("exitNode ");
            sb.append(node);
            ExtHubLogger.d("AriverKernel:ExtensionManager", sb.toString());
            ExtensionPoint.exitNode(node);
            Map<String, Extension> remove = this.mNodeExtensionMap.remove(node);
            if (remove != null) {
                for (Extension extension : remove.values()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("finalize ");
                    sb2.append(extension);
                    sb2.append(" from exitNode");
                    ExtHubLogger.d("AriverKernel:ExtensionManager", sb2.toString());
                    extension.onFinalized();
                }
                remove.clear();
            }
            Map<Class<? extends Extension>, List<Extension>> remove2 = this.g.remove(node);
            if (remove2 != null) {
                for (List<Extension> list : remove2.values()) {
                    HashSet hashSet = new HashSet();
                    for (Extension extension2 : list) {
                        if (!hashSet.contains(extension2)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("exitNode finalize");
                            sb3.append(extension2);
                            ExtHubLogger.d("AriverKernel:ExtensionManager", sb3.toString());
                            extension2.onFinalized();
                            hashSet.add(extension2);
                        }
                    }
                }
                remove2.clear();
            }
        }
    }

    public Map<String, Extension> getSingletonExtensionMap() {
        return this.mSingletonExtensionMap;
    }

    protected Map<Node, Map<String, Extension>> getNodeExtensionMap() {
        return this.mNodeExtensionMap;
    }

    private List<? extends Extension> b(Node node, Class<? extends Extension> cls) {
        synchronized (this) {
            Collection<Class<? extends Extension>> findExtensions = this.mExtensionRegistry.findExtensions(node == null ? MultiInstanceUtils.getDefaultInstanceType() : node.getInstanceType(), cls.getName());
            if (findExtensions == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (Class<? extends Extension> cls2 : findExtensions) {
                Class<? extends Scope> scope = this.mExtensionRegistry.getScope(cls2);
                if (scope == null) {
                    Extension a2 = a(this.mSingletonExtensionMap, cls2);
                    if (a2 != null) {
                        linkedList.add(a2);
                    }
                } else {
                    Node node2 = node;
                    while (node2 != null && !scope.isAssignableFrom(node2.getClass())) {
                        node2 = node2.getParentNode();
                    }
                    if (node2 != null) {
                        if (ExtensionBlackListStore.isInExtensionBlackList(cls2.getName(), node2.getClass().getName())) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("isInExtensionBlackList skip ");
                            sb.append(cls2.getName());
                            sb.append(" node: ");
                            sb.append(node2);
                            ExtHubLogger.w("AriverKernel:ExtensionManager", sb.toString());
                        } else {
                            Extension a3 = a(this.mNodeExtensionMap.get(node2), cls2);
                            if (a3 != null) {
                                linkedList.add(a3);
                            }
                        }
                    }
                }
            }
            return linkedList;
        }
    }

    private static Extension a(Map<String, Extension> map, Class<? extends Extension> cls) {
        if (map == null || cls == null) {
            return null;
        }
        Extension extension = map.get(cls.getName());
        if (extension == null) {
            try {
                extension = a(cls);
                map.put(cls.getName(), extension);
                return extension;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(cls);
                sb.append(" failed to initialize");
                ExtHubLogger.e("AriverKernel:ExtensionManager", sb.toString(), th);
                return extension;
            }
        }
        return extension;
    }

    public static void setExtensionCreator(ExtensionCreator extensionCreator) {
        f6080a = extensionCreator;
    }

    private static Extension a(Class<? extends Extension> cls) throws IllegalAccessException, InstantiationException {
        Extension newInstance;
        StringBuilder sb = new StringBuilder();
        sb.append("createExtensionInstance ");
        sb.append(cls.getName());
        ExtHubLogger.d("AriverKernel:ExtensionManager", sb.toString());
        ExtensionCreator extensionCreator = f6080a;
        if (extensionCreator != null) {
            newInstance = extensionCreator.createExtensionInstance(cls);
        } else {
            newInstance = cls.newInstance();
        }
        newInstance.onInitialized();
        return newInstance;
    }
}
