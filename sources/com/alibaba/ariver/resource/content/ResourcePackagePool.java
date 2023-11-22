package com.alibaba.ariver.resource.content;

import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class ResourcePackagePool {

    /* renamed from: a */
    private static final ResourcePackagePool f6229a = new ResourcePackagePool();
    private final Map<String, ResourcePackage> b = new ConcurrentHashMap();
    private final Map<String, Integer> c = new ConcurrentHashMap();

    public static ResourcePackagePool getInstance() {
        return f6229a;
    }

    private void a(String str) {
        if (this.c.containsKey(str)) {
            Map<String, Integer> map = this.c;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
            return;
        }
        this.c.put(str, 1);
    }

    private boolean b(String str) {
        if (this.c.containsKey(str)) {
            int intValue = this.c.get(str).intValue() - 1;
            this.c.put(str, Integer.valueOf(intValue));
            boolean z = intValue == 0;
            if (z) {
                this.c.remove(str);
            }
            return z;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cannot detach ");
        sb.append(str);
        sb.append(" because it not attached!");
        RVLogger.w("AriverRes:PackagePool", sb.toString());
        return true;
    }

    public void attach(ResourcePackage resourcePackage) {
        synchronized (this) {
            String appId = resourcePackage.appId();
            if (!this.b.containsKey(appId)) {
                StringBuilder sb = new StringBuilder();
                sb.append("attach resource package: ");
                sb.append(appId);
                RVLogger.d("AriverRes:PackagePool", sb.toString());
                resourcePackage.setup(false);
                this.b.put(appId, resourcePackage);
            }
            a(appId);
        }
    }

    public ResourcePackage attach(String str, ResourceContext resourceContext) {
        ResourcePackage resourcePackage;
        synchronized (this) {
            if (GlobalPackagePool.getInstance().contains(str)) {
                return GlobalPackagePool.getInstance().getPackage(str);
            }
            if (!this.b.containsKey(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("attach resource package: ");
                sb.append(str);
                RVLogger.d("AriverRes:PackagePool", sb.toString());
                if ("66666692".equalsIgnoreCase(str)) {
                    resourcePackage = new AppxResourcePackage(resourceContext);
                } else {
                    resourcePackage = new NormalResourcePackage(str, resourceContext);
                }
                resourcePackage.setup(false);
                this.b.put(str, resourcePackage);
            } else {
                resourcePackage = this.b.get(str);
            }
            a(str);
            return resourcePackage;
        }
    }

    public void detach(String str) {
        synchronized (this) {
            if (b(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("detach resource package: ");
                sb.append(str);
                RVLogger.d("AriverRes:PackagePool", sb.toString());
                ResourcePackage remove = this.b.remove(str);
                if (remove != null) {
                    remove.teardown();
                }
            }
        }
    }

    public boolean contains(String str) {
        return this.b.containsKey(str);
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

    public ResourcePackage getPackage(String str) {
        return this.b.get(str);
    }

    public void removeAll() {
        synchronized (this) {
            Set<String> keySet = this.b.keySet();
            if (keySet != null && !keySet.isEmpty()) {
                for (String str : keySet) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("remove appId = ");
                    sb.append(str);
                    RVLogger.d("AriverRes:PackagePool", sb.toString());
                    ResourcePackage remove = this.b.remove(str);
                    if (remove != null) {
                        remove.teardown();
                    }
                }
            }
            RVLogger.d("AriverRes:PackagePool", "removeAll");
        }
    }
}
