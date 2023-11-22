package com.iap.ac.android.acs.operation.downgrade.utils;

import com.iap.ac.android.acs.operation.downgrade.router.amcs.APDisableJSAPIConfigManager;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DisableJSAPIManager {
    public static DisableJSAPIManager instance;
    public Map<String, Set<String>> disabledJSAPIMap = new ConcurrentHashMap();
    public final Object lock = new Object();

    public static DisableJSAPIManager getInstance() {
        if (instance == null) {
            synchronized (DisableJSAPIManager.class) {
                if (instance == null) {
                    instance = new DisableJSAPIManager();
                }
            }
        }
        return instance;
    }

    public Set<String> getDisableJSAPI(String str) {
        HashSet hashSet;
        synchronized (this.lock) {
            hashSet = new HashSet(this.disabledJSAPIMap.get(str));
        }
        return hashSet;
    }

    public boolean isDisabled(String str, String str2) {
        synchronized (this.lock) {
            if ("apDisableJSAPI".equals(str2)) {
                return !APDisableJSAPIConfigManager.getInstance().toggleAPIDisableJSAPI();
            }
            Set<String> set = this.disabledJSAPIMap.get(str);
            return set != null && set.contains(str2);
        }
    }

    public void putDisableJSAPI(String str, Set<String> set) {
        synchronized (this.lock) {
            this.disabledJSAPIMap.put(str, new HashSet(set));
        }
    }
}
