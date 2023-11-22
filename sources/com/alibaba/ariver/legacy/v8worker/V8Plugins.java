package com.alibaba.ariver.legacy.v8worker;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class V8Plugins {
    private static final String CLOSED = "closed";
    private static final String CREATED = "created";
    private static final String PAUSED = "paused";
    private static final String RESUMED = "resumed";
    private static final String TAG = "V8Worker";
    boolean mSessionActived;
    V8Worker mWorker;
    String mNativeLibraryDir = null;
    String[] mV8PluginNameList = null;

    /* loaded from: classes6.dex */
    public static class PageStateStore {
        String state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V8Plugins(V8Worker v8Worker, Bundle bundle) {
        this.mWorker = v8Worker;
        synchronized (V8Plugins.class) {
            setup(v8Worker, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean empty() {
        String[] strArr = this.mV8PluginNameList;
        return strArr == null || strArr.length == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void load() {
        synchronized (V8Plugins.class) {
            this.mWorker.getV8Runtime().loadNativePlugins(this.mNativeLibraryDir, this.mV8PluginNameList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        if (r0 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setup(com.alibaba.ariver.legacy.v8worker.V8Worker r2, android.os.Bundle r3) {
        /*
            r1 = this;
            java.lang.String r2 = r2.getAppId()
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L40
            java.lang.Class<com.alibaba.ariver.v8worker.V8Proxy> r0 = com.alibaba.ariver.v8worker.V8Proxy.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            if (r0 == 0) goto L22
            java.lang.Class<com.alibaba.ariver.v8worker.V8Proxy> r0 = com.alibaba.ariver.v8worker.V8Proxy.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            com.alibaba.ariver.v8worker.V8Proxy r0 = (com.alibaba.ariver.v8worker.V8Proxy) r0
            java.lang.String[] r0 = r0.getV8PluginNameList(r2, r3)
            r1.mV8PluginNameList = r0
            if (r0 != 0) goto L28
        L22:
            java.lang.String[] r2 = r1.initV8PluginList(r2, r3)
            r1.mV8PluginNameList = r2
        L28:
            java.lang.String[] r2 = r1.mV8PluginNameList
            if (r2 == 0) goto L40
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVEnvironmentService> r2 = com.alibaba.ariver.kernel.common.service.RVEnvironmentService.class
            java.lang.Object r2 = com.alibaba.ariver.kernel.common.RVProxy.get(r2)
            com.alibaba.ariver.kernel.common.service.RVEnvironmentService r2 = (com.alibaba.ariver.kernel.common.service.RVEnvironmentService) r2
            android.app.Application r2 = r2.getApplicationContext()
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()
            java.lang.String r2 = r2.nativeLibraryDir
            r1.mNativeLibraryDir = r2
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.legacy.v8worker.V8Plugins.setup(com.alibaba.ariver.legacy.v8worker.V8Worker, android.os.Bundle):void");
    }

    private String[] initV8PluginList(String str, Bundle bundle) {
        try {
            HashSet hashSet = new HashSet();
            String string = BundleUtils.getString(bundle, "v8WorkerPlugins", null);
            if (!TextUtils.isEmpty(string)) {
                StringBuilder sb = new StringBuilder();
                sb.append("init plugins from startup params: ");
                sb.append(string);
                RVLogger.e(TAG, sb.toString());
                for (String str2 : string.split(",")) {
                    V8Utils.addStringToSet(hashSet, str2);
                }
            }
            JSONObject parseObject = JSONUtils.parseObject(V8Utils.getConfigService().getConfig("ta_v8WorkerPluginConfig", ""));
            if (parseObject != null && !parseObject.isEmpty()) {
                V8Utils.mergeJSONArrayToSet(hashSet, JSONUtils.getJSONArray(parseObject, str, null));
                V8Utils.mergeJSONArrayToSet(hashSet, JSONUtils.getJSONArray(parseObject, "default", null));
            }
            if (!hashSet.isEmpty()) {
                return (String[]) hashSet.toArray(new String[0]);
            }
        } catch (Exception e) {
            RVLogger.e(TAG, "getConfig exception", e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageCreate(Page page) {
        if (empty()) {
            return;
        }
        PageStateStore pageStateStore = (PageStateStore) page.getData(PageStateStore.class, true);
        if (pageStateStore.state != null) {
            return;
        }
        this.mWorker.dispatchPageEvent(4, page.getPageId());
        pageStateStore.state = CREATED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageResume(Page page) {
        if (empty()) {
            return;
        }
        PageStateStore pageStateStore = (PageStateStore) page.getData(PageStateStore.class, true);
        if (pageStateStore.state == null || RESUMED.equals(pageStateStore.state)) {
            return;
        }
        this.mWorker.dispatchPageEvent(5, page.getPageId());
        pageStateStore.state = RESUMED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPagePause(Page page) {
        if (empty()) {
            return;
        }
        PageStateStore pageStateStore = (PageStateStore) page.getData(PageStateStore.class, true);
        if (pageStateStore.state == null || PAUSED.equals(pageStateStore.state)) {
            return;
        }
        this.mWorker.dispatchPageEvent(6, page.getPageId());
        pageStateStore.state = PAUSED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageClose(Page page) {
        if (empty()) {
            return;
        }
        PageStateStore pageStateStore = (PageStateStore) page.getData(PageStateStore.class, true);
        if (pageStateStore.state == null || CLOSED.equals(pageStateStore.state)) {
            return;
        }
        this.mWorker.dispatchPageEvent(7, page.getPageId());
        pageStateStore.state = CLOSED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OnSessionResume() {
        if (empty() || this.mSessionActived) {
            return;
        }
        this.mSessionActived = true;
        this.mWorker.getV8Runtime().dispatchPluginEvent(1, this.mWorker.getAppId(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OnSessionPause() {
        if (!empty() && this.mSessionActived) {
            this.mSessionActived = false;
            this.mWorker.getV8Runtime().dispatchPluginEvent(2, this.mWorker.getAppId(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OnSessionClose() {
        if (empty()) {
            return;
        }
        this.mSessionActived = false;
        this.mWorker.getV8Runtime().dispatchPluginEvent(3, this.mWorker.getAppId(), 0);
    }
}
