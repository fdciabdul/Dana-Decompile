package com.alibaba.ariver.resource.runtime;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RefAware;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ResourceContextManager {
    private static final String TAG = "Ariver:ResourceContextManager";
    private static volatile ResourceContextManager instance;
    private final Map<String, RefAware<ResourceContext>> resourceContextMap = new ConcurrentHashMap();

    public static ResourceContextManager getInstance() {
        if (instance == null) {
            synchronized (ResourceContextManager.class) {
                if (instance == null) {
                    instance = new ResourceContextManager();
                }
            }
        }
        return instance;
    }

    private RefAware<ResourceContext> getRef(String str, String str2) {
        RefAware<ResourceContext> refAware;
        synchronized (this) {
            refAware = this.resourceContextMap.get(getContextKey(str, str2));
            if (refAware == null) {
                ResourceContext resourceContext = new ResourceContext();
                resourceContext.setAppId(str);
                RefAware<ResourceContext> refAware2 = new RefAware<>(resourceContext);
                this.resourceContextMap.put(getContextKey(str, str2), refAware2);
                refAware = refAware2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("appId = ");
            sb.append(str);
            sb.append(" startToken = ");
            sb.append(str2);
            RVLogger.d(TAG, sb.toString());
        }
        return refAware;
    }

    private String getContextKey(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        return sb.toString();
    }

    public ResourceContext get(String str, long j) {
        return getRef(str, String.valueOf(j)).get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceContext onAppLoad(String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAppLoad ");
        sb.append(str);
        sb.append(" increment ref");
        RVLogger.d(TAG, sb.toString());
        RefAware<ResourceContext> ref = getRef(str, String.valueOf(j));
        ref.incrementRef();
        return ref.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAppDestroy(String str, long j) {
        RefAware<ResourceContext> refAware = this.resourceContextMap.get(getContextKey(str, String.valueOf(j)));
        if (refAware == null) {
            return;
        }
        boolean decrementRef = refAware.decrementRef();
        StringBuilder sb = new StringBuilder();
        sb.append("onAppDestroy ");
        sb.append(str);
        sb.append(" needDestroy ");
        sb.append(decrementRef);
        sb.append("context ");
        sb.append(getContextKey(str, String.valueOf(j)));
        RVLogger.d(TAG, sb.toString());
        if (decrementRef) {
            this.resourceContextMap.remove(getContextKey(str, String.valueOf(j)));
            refAware.get().releaseResourcePackages();
        }
    }
}
