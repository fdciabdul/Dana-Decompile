package com.alibaba.griver.base.resource.appcenter.storage;

import android.text.TextUtils;
import android.util.LruCache;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.resource.appcenter.storage.AppInfoDao;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverAppInfoModelMemoryCache {

    /* renamed from: a  reason: collision with root package name */
    private final String f6351a = "GriverAppInfoModelMemoryCache";
    private LruCache<String, List<AppInfoDao>> b;
    private long c;
    private long d;
    private long e;

    private void a() {
        if (this.b != null) {
            return;
        }
        synchronized (this) {
            if (this.b != null) {
                return;
            }
            String str = "";
            try {
                str = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_DEFAULT_APPINFO_MEMORY_CONFIG, GriverConfigConstants.DEFAULT_APPINFO_MEMORY_CONFIG_VALUE);
                if (!TextUtils.isEmpty(str)) {
                    JSONObject parseObject = JSONUtils.parseObject(str);
                    if (parseObject.getBoolean("enable").booleanValue()) {
                        this.b = new LruCache<>(parseObject.getInteger("memory_count").intValue());
                    }
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append(" cache init error : config ==  ");
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                sb.append(str);
                GriverLogger.e("GriverAppInfoModelMemoryCache", sb.toString(), e);
                this.b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeAppInfo(AppInfoDao appInfoDao) {
        a();
        if (appInfoDao == null || this.b == null) {
            return;
        }
        removeAppInfo(appInfoDao.getAppId(), appInfoDao.getVersion());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeAppInfo(String str, String str2) {
        List<AppInfoDao> list;
        AppInfoDao appInfoDao;
        a();
        if (this.b == null || TextUtils.isEmpty(str) || (list = this.b.get(str)) == null || list.size() <= 0) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            list.clear();
        } else {
            int i = 0;
            while (true) {
                appInfoDao = null;
                if (i >= list.size()) {
                    break;
                } else if (isVersionEquals(list.get(i), str2)) {
                    appInfoDao = list.get(i);
                    break;
                } else {
                    i++;
                }
            }
            if (appInfoDao != null) {
                list.remove(appInfoDao);
            }
        }
        this.e++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAppInfo(AppInfoDao appInfoDao) {
        a();
        if (appInfoDao == null || this.b == null) {
            return;
        }
        removeAppInfo(appInfoDao);
        List<AppInfoDao> list = this.b.get(appInfoDao.getAppId());
        if (list == null) {
            list = Collections.synchronizedList(new ArrayList());
        }
        list.add(appInfoDao);
        this.b.put(appInfoDao.getAppId(), list);
        this.d++;
    }

    public boolean isVersionEquals(AppInfoDao appInfoDao, String str) {
        if (appInfoDao == null || TextUtils.isEmpty(appInfoDao.getVersion())) {
            return false;
        }
        return appInfoDao.getVersion().equals(str);
    }

    public AppInfoDao getAppInfo(String str) {
        return getAppInfo(str, "");
    }

    public AppInfoDao getAppInfo(String str, String str2) {
        List<AppInfoDao> list;
        a();
        if (this.b != null && !TextUtils.isEmpty(str) && (list = this.b.get(str)) != null && list.size() > 0) {
            this.c++;
            if (TextUtils.isEmpty(str2)) {
                Collections.sort(list, AppInfoUtils.getAppInfoDaoDescComparator());
                return list.get(0);
            }
            for (int i = 0; i < list.size(); i++) {
                if (isVersionEquals(list.get(i), str2)) {
                    return list.get(i);
                }
            }
        }
        return null;
    }

    public List<AppInfoDao> getAppInfoList(String str) {
        a();
        if (this.b == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.b.get(str);
    }

    public Map getEventContent() {
        HashMap hashMap = new HashMap();
        if (this.b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.b.size());
            hashMap.put("lruCacheSize", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.c);
            hashMap.put("getMemorytCount", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.d);
            hashMap.put("setMemoryCount", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.e);
            hashMap.put("removeMemoryCount", sb4.toString());
        }
        return hashMap;
    }

    public boolean canCache() {
        return this.b != null;
    }
}
