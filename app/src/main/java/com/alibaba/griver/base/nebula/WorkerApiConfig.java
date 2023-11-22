package com.alibaba.griver.base.nebula;

import com.alibaba.ariver.permission.PermissionConstant;
import com.alibaba.griver.core.worker.JSApiCachePoint;
import com.alipay.iap.android.aplog.api.LogCategory;
import com.iap.ac.android.acs.plugin.utils.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class WorkerApiConfig {

    /* renamed from: a  reason: collision with root package name */
    private static Set<String> f6325a;
    private static List<String> b;

    public static Set<String> getDefaultSyncJsApiSet() {
        Set<String> set;
        synchronized (WorkerApiConfig.class) {
            if (f6325a == null) {
                HashSet hashSet = new HashSet();
                f6325a = hashSet;
                hashSet.add(JSApiCachePoint.GET_SYSTEM_INFO);
                f6325a.add("setAPDataStorage");
                f6325a.add("getAPDataStorage");
                f6325a.add("removeAPDataStorage");
                f6325a.add("clearAPDataStorage");
                f6325a.add("setTinyLocalStorage");
                f6325a.add(JSApiCachePoint.GET_LOCAL_STORAGE);
                f6325a.add("removeTinyLocalStorage");
                f6325a.add("clearTinyLocalStorage");
                f6325a.add("getTinyLocalStorageInfo");
                f6325a.add("getStartupParams");
                f6325a.add("internalAPI");
                f6325a.add("measureText");
                f6325a.add("getBackgroundAudioOption");
                f6325a.add("getForegroundAudioOption");
                f6325a.add("NBComponent.sendMessage");
                f6325a.add("getBatteryInfo");
                f6325a.add("tyroRequest");
                f6325a.add("bindUDPSocket");
            }
            set = f6325a;
        }
        return set;
    }

    public static List<String> getDefaultAsyncJsApiList() {
        List<String> list;
        synchronized (WorkerApiConfig.class) {
            if (b == null) {
                ArrayList arrayList = new ArrayList();
                b = arrayList;
                arrayList.add(JSApiCachePoint.GET_SYSTEM_INFO);
                b.add("remoteLog");
                b.add(PermissionConstant.HTTPREQUET);
                b.add("request");
                b.add(LogCategory.LOG_SPM);
                b.add("reportData");
                b.add(Constants.JS_API_GET_AUTH_CODE);
                b.add("setTinyLocalStorage");
                b.add(JSApiCachePoint.GET_LOCAL_STORAGE);
                b.add("removeTinyLocalStorage");
                b.add("trackerConfig");
                b.add("configService.getConfig");
                b.add("getAuthUserInfo");
                b.add("localLog");
            }
            list = b;
        }
        return list;
    }
}
