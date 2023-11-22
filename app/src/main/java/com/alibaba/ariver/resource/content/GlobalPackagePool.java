package com.alibaba.ariver.resource.content;

import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class GlobalPackagePool {

    /* renamed from: a */
    private static final GlobalPackagePool f6224a = new GlobalPackagePool();
    private Map<String, ResourcePackage> b = new ConcurrentHashMap();

    public static GlobalPackagePool getInstance() {
        return f6224a;
    }

    public void add(ResourcePackage resourcePackage) {
        synchronized (GlobalPackagePool.class) {
            ResourcePackage resourcePackage2 = this.b.get(resourcePackage.appId());
            if (resourcePackage2 != null) {
                resourcePackage2.teardown();
                this.b.remove(resourcePackage2.appId());
                StringBuilder sb = new StringBuilder();
                sb.append("attach global resource package: ");
                sb.append(resourcePackage2);
                RVLogger.d("AriverRes:GlobalPackagePool", sb.toString());
            }
            this.b.put(resourcePackage.appId(), resourcePackage);
        }
        resourcePackage.setup(false);
    }

    public ResourcePackage add(String str) {
        ResourcePackage resourcePackage;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(RVTraceKey.RV_Package_globalAdd_);
            sb.append(str);
            RVTraceUtils.traceBeginSection(sb.toString());
            synchronized (GlobalPackagePool.class) {
                resourcePackage = this.b.get(str);
                if (resourcePackage == null) {
                    if ("66666692".equalsIgnoreCase(str)) {
                        resourcePackage = new AppxResourcePackage(null);
                    } else if ("68687209".equalsIgnoreCase(str)) {
                        resourcePackage = new AppxNgResourcePackage(null);
                    } else {
                        resourcePackage = new GlobalResourcePackage(str);
                    }
                    this.b.put(resourcePackage.appId(), resourcePackage);
                }
            }
            resourcePackage.setup(false);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("attach global resource package: ");
            sb2.append(resourcePackage);
            RVLogger.d("AriverRes:GlobalPackagePool", sb2.toString());
            return resourcePackage;
        } finally {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(RVTraceKey.RV_Package_globalAdd_);
            sb3.append(str);
            RVTraceUtils.traceEndSection(sb3.toString());
        }
    }

    public boolean contains(String str) {
        boolean containsKey;
        synchronized (GlobalPackagePool.class) {
            containsKey = this.b.containsKey(str);
        }
        return containsKey;
    }

    public void remove(String str) {
        synchronized (GlobalPackagePool.class) {
            this.b.remove(str);
        }
    }

    public ResourcePackage getPackage(String str) {
        ResourcePackage resourcePackage;
        synchronized (GlobalPackagePool.class) {
            resourcePackage = this.b.get(str);
        }
        return resourcePackage;
    }

    public Collection<ResourcePackage> getPackages() {
        HashSet hashSet;
        synchronized (GlobalPackagePool.class) {
            hashSet = new HashSet(this.b.values());
        }
        return hashSet;
    }

    public Resource get(ResourceQuery resourceQuery) {
        Iterator<ResourcePackage> it = this.b.values().iterator();
        while (it.hasNext()) {
            Resource resource = it.next().get(resourceQuery);
            if (resource != null) {
                return resource;
            }
        }
        return null;
    }

    public void waitForSetup(String str) {
        synchronized (GlobalPackagePool.class) {
            if (this.b.containsKey(str)) {
                this.b.get(str).waitForSetup();
            }
        }
    }

    public void removeAll() {
        synchronized (GlobalPackagePool.class) {
            Set<String> keySet = this.b.keySet();
            if (keySet != null && !keySet.isEmpty()) {
                for (String str : keySet) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("remove appId = ");
                    sb.append(str);
                    RVLogger.d("AriverRes:GlobalPackagePool", sb.toString());
                    ResourcePackage remove = this.b.remove(str);
                    if (remove != null) {
                        remove.teardown();
                    }
                }
            }
        }
        RVLogger.d("AriverRes:GlobalPackagePool", "removeAll");
    }
}
