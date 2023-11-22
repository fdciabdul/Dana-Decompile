package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: classes3.dex */
class PointToExtensionStore {

    /* renamed from: a  reason: collision with root package name */
    private final Map<InstanceType, Map<String, LinkedHashSet<Class<? extends Extension>>>> f6091a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerExtension(InstanceType instanceType, Class<? extends Extension> cls) {
        synchronized (this) {
            Map<String, LinkedHashSet<Class<? extends Extension>>> map = this.f6091a.get(instanceType);
            if (map == null) {
                map = new HashMap<>();
                this.f6091a.put(instanceType, map);
            }
            for (Class<? extends Extension> cls2 : ReflectUtils.collectExtensionPoint(cls, null)) {
                LinkedHashSet<Class<? extends Extension>> linkedHashSet = map.get(cls2.getName());
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet<>();
                    map.put(cls2.getName(), linkedHashSet);
                }
                linkedHashSet.add(cls);
                ExtensionPoint.invalidateExtensionCache(cls2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Class<? extends Extension>> getExtensionsByPoint(InstanceType instanceType, String str) {
        synchronized (this) {
            Map<String, LinkedHashSet<Class<? extends Extension>>> map = this.f6091a.get(instanceType);
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
    }
}
