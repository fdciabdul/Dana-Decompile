package com.alibaba.ariver.kernel.api.extension.registry;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.NativeActionFilter;
import com.alibaba.ariver.kernel.api.annotation.NativePermissionRequire;
import com.alibaba.ariver.kernel.api.annotation.ParamRequired;
import com.alibaba.ariver.kernel.api.annotation.UsePermission;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.fastjson.JSONArray;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class BridgeExtensionStore {

    /* renamed from: a  reason: collision with root package name */
    private final Map<InstanceType, Map<String, ActionMeta>> f6087a;
    private final Set<Class<? extends BridgeExtension>> b;
    private final Map<InstanceType, Map<String, ExtensionMetaInfo>> c;
    private Set<String> d;
    private PointToExtensionStore e;
    private boolean f;

    public BridgeExtensionStore() {
        this.f6087a = new ConcurrentHashMap();
        this.b = new HashSet();
        this.c = new ConcurrentHashMap();
        this.d = null;
        this.e = null;
        this.f = false;
    }

    public BridgeExtensionStore(boolean z) {
        this.f6087a = new ConcurrentHashMap();
        this.b = new HashSet();
        this.c = new ConcurrentHashMap();
        this.d = null;
        this.e = null;
        this.f = z;
    }

    public void setPointToExtensionStore(PointToExtensionStore pointToExtensionStore) {
        this.e = pointToExtensionStore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void register(ExtensionMetaInfo extensionMetaInfo) {
        Map<String, ExtensionMetaInfo> map;
        InstanceType instanceType = extensionMetaInfo.getInstanceType();
        Map<String, ExtensionMetaInfo> map2 = this.c.get(instanceType);
        if (map2 == null) {
            synchronized (this.c) {
                map = this.c.get(instanceType);
                if (map == null) {
                    map = new ConcurrentHashMap<>();
                    this.c.put(instanceType, map);
                }
            }
            map2 = map;
        }
        for (String str : extensionMetaInfo.filter) {
            if (map2.containsKey(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("register ");
                sb.append(str);
                sb.append(" override by ");
                sb.append(extensionMetaInfo);
                sb.append(" with instanceType: ");
                sb.append(instanceType);
                ExtHubLogger.w("AriverKernel:BridgeExtensionStore", sb.toString());
            } else if (RVKernelUtils.isDebug()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("register ");
                sb2.append(str);
                sb2.append(" with meta ");
                sb2.append(extensionMetaInfo);
                ExtHubLogger.w("AriverKernel:BridgeExtensionStore", sb2.toString());
            }
            map2.put(str, extensionMetaInfo);
        }
    }

    public void unRegister(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            StringBuilder sb = new StringBuilder();
            sb.append("unRegister \t");
            sb.append(str);
            ExtHubLogger.d("AriverKernel:BridgeExtensionStore", sb.toString());
            Iterator<Map<String, ActionMeta>> it = this.f6087a.values().iterator();
            while (it.hasNext()) {
                it.next().remove(str);
            }
        }
    }

    protected void register(Class<? extends BridgeExtension> cls) {
        a(cls, false);
    }

    private void a(Class<? extends BridgeExtension> cls, boolean z) {
        register(cls, z, MultiInstanceUtils.getDefaultInstanceType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void register(Class<? extends BridgeExtension> cls, boolean z, InstanceType instanceType) {
        PointToExtensionStore pointToExtensionStore;
        a(cls);
        List<ActionMeta> a2 = a(instanceType, cls);
        if (a2.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("action method not found in bridgeExtension: ");
            sb.append(cls);
            ExtHubLogger.w("AriverKernel:BridgeExtensionStore", sb.toString());
            return;
        }
        for (ActionMeta actionMeta : a2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("register ");
            sb2.append(actionMeta);
            sb2.append(" with instanceType: ");
            sb2.append(instanceType);
            ExtHubLogger.d("AriverKernel:BridgeExtensionStore", sb2.toString());
            getRegisteredActionMethodMap(instanceType).put(actionMeta.actionName, actionMeta);
        }
        this.b.add(cls);
        if (!z || (pointToExtensionStore = this.e) == null) {
            return;
        }
        pointToExtensionStore.registerExtension(instanceType, cls);
    }

    Map<String, ActionMeta> getRegisteredActionMethodMap(InstanceType instanceType) {
        Map<String, ActionMeta> map;
        Map<String, ActionMeta> map2 = this.f6087a.get(instanceType);
        if (map2 == null) {
            synchronized (this.f6087a) {
                map = this.f6087a.get(instanceType);
                if (map == null) {
                    map = new ConcurrentHashMap<>();
                    this.f6087a.put(instanceType, map);
                }
            }
            return map;
        }
        return map2;
    }

    ActionMeta findActionMeta(String str) {
        return findActionMeta(MultiInstanceUtils.getDefaultInstanceType(), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ActionMeta findActionMeta(InstanceType instanceType, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, ActionMeta> registeredActionMethodMap = getRegisteredActionMethodMap(instanceType);
        if (registeredActionMethodMap.get(str) == null) {
            synchronized (this.f6087a) {
                if (registeredActionMethodMap.get(str) == null) {
                    Map<String, ExtensionMetaInfo> map = this.c.get(instanceType);
                    if (map == null) {
                        return null;
                    }
                    ExtensionMetaInfo remove = map.remove(str);
                    if (remove == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("findActionMeta failed for ");
                        sb.append(str);
                        sb.append(" instanceType: ");
                        sb.append(instanceType);
                        ExtHubLogger.w("AriverKernel:BridgeExtensionStore", sb.toString());
                        return null;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("findActionMeta lazy init ");
                    sb2.append(str);
                    sb2.append(" instanceType: ");
                    sb2.append(instanceType);
                    ExtHubLogger.d("AriverKernel:BridgeExtensionStore", sb2.toString());
                    Class<? extends Extension> loadClass = ClassLoaderUtils.loadClass(remove.bundleName, remove.extensionClass);
                    if (loadClass == null) {
                        return null;
                    }
                    register(loadClass, true, instanceType);
                }
            }
        }
        return registeredActionMethodMap.get(str);
    }

    private List<ActionMeta> a(InstanceType instanceType, Class<? extends BridgeExtension> cls) {
        Method[] declaredMethods;
        ArrayList arrayList = new ArrayList();
        if (cls != null && cls.getDeclaredMethods() != null) {
            if (cls.getSuperclass() != null && BridgeExtension.class.isAssignableFrom(cls.getSuperclass())) {
                declaredMethods = cls.getMethods();
            } else {
                declaredMethods = cls.getDeclaredMethods();
            }
            if (RVKernelUtils.isDebug()) {
                ArrayList arrayList2 = new ArrayList(declaredMethods.length);
                for (Method method : declaredMethods) {
                    arrayList2.add(method.getName());
                }
                StringBuilder sb = new StringBuilder();
                sb.append("initActionMeta ");
                sb.append(cls);
                sb.append(" getAllMethods: ");
                sb.append(arrayList2);
                ExtHubLogger.d("AriverKernel:BridgeExtensionStore", sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("initActionMeta ");
                sb2.append(cls);
                ExtHubLogger.d("AriverKernel:BridgeExtensionStore", sb2.toString());
            }
            Set<String> a2 = a();
            for (Method method2 : declaredMethods) {
                try {
                    if (!method2.isAccessible()) {
                        method2.setAccessible(true);
                    }
                    ActionFilter actionFilter = (ActionFilter) method2.getAnnotation(ActionFilter.class);
                    NativeActionFilter nativeActionFilter = (NativeActionFilter) method2.getAnnotation(NativeActionFilter.class);
                    if (this.f) {
                        if (nativeActionFilter != null) {
                            String value = nativeActionFilter.value();
                            if (value.length() <= 0) {
                                value = method2.getName();
                            }
                            arrayList.add(a(method2, cls, value));
                        }
                    } else if (actionFilter != null) {
                        String value2 = actionFilter.value();
                        if (value2.length() <= 0) {
                            value2 = method2.getName();
                        }
                        if (a2 != null && a2.contains(value2)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("ignore action:\t");
                            sb3.append(value2);
                            ExtHubLogger.d("AriverKernel:BridgeExtensionStore", sb3.toString());
                        } else {
                            ActionMeta a3 = a(method2, cls, value2);
                            if (getRegisteredActionMethodMap(instanceType).containsKey(value2)) {
                                if (!actionFilter.canOverride()) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("BridgeExtension action [");
                                    sb4.append(value2);
                                    sb4.append("] is not allow duplicate register");
                                    ExtHubLogger.w("AriverKernel:BridgeExtensionStore", sb4.toString());
                                } else {
                                    getRegisteredActionMethodMap(instanceType).remove(value2);
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("initActionMeta BridgeExtension action [");
                                    sb5.append(value2);
                                    sb5.append("] override by ");
                                    sb5.append(cls.getName());
                                    ExtHubLogger.w("AriverKernel:BridgeExtensionStore", sb5.toString());
                                    RVProxy.Printer printer = RVProxy.getPrinter();
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("BridgeExtension action duplicate [");
                                    sb6.append(value2);
                                    sb6.append("]");
                                    printer.print(sb6.toString());
                                }
                            }
                            arrayList.add(a3);
                        }
                    }
                } catch (Throwable th) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("initActionMeta ");
                    sb7.append(method2);
                    sb7.append(" exception!");
                    ExtHubLogger.w("AriverKernel:BridgeExtensionStore", sb7.toString(), th);
                }
            }
        }
        return arrayList;
    }

    private ActionMeta a(Method method, Class<? extends BridgeExtension> cls, String str) {
        ActionMeta actionMeta = new ActionMeta();
        actionMeta.actionMethod = method;
        actionMeta.paramRequired = method.getAnnotation(ParamRequired.class) != null;
        actionMeta.bridgeExtensionClazz = cls;
        actionMeta.autoCallback = method.getAnnotation(AutoCallback.class) != null;
        actionMeta.usePermission = (UsePermission) method.getAnnotation(UsePermission.class);
        actionMeta.actionName = str;
        actionMeta.paramTypes = method.getParameterTypes();
        actionMeta.paramAnnotationArray = method.getParameterAnnotations();
        NativePermissionRequire nativePermissionRequire = (NativePermissionRequire) method.getAnnotation(NativePermissionRequire.class);
        if (nativePermissionRequire != null) {
            actionMeta.nativePermissions = nativePermissionRequire.value();
        }
        return actionMeta;
    }

    private Set<String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d != null) {
                    RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
                    JSONArray jSONArray = rVConfigService != null ? JSONUtils.getJSONArray(rVConfigService.getConfigJSONObject("h5_jsapiandPluginsConfig"), "extensions", null) : null;
                    if (jSONArray != null && jSONArray.size() != 0) {
                        this.d = new HashSet();
                        int size = jSONArray.size();
                        for (int i = 0; i < size; i++) {
                            this.d.add(jSONArray.getString(i));
                        }
                    }
                    this.d = Collections.emptySet();
                }
            }
        }
        return this.d;
    }

    public int getRegisteredActionCount() {
        return this.f6087a.size() + this.c.size();
    }

    private void a(Class<? extends BridgeExtension> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("extension is null");
        }
        if (this.b.contains(cls)) {
            throw new IllegalArgumentException("extension has registered");
        }
    }
}
