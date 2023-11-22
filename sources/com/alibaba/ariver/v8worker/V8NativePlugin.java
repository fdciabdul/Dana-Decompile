package com.alibaba.ariver.v8worker;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class V8NativePlugin {
    private static final String CLOSED = "closed";
    private static final String CREATED = "created";
    private static final String PAUSED = "paused";
    private static final String RESUMED = "resumed";
    private static final String TAG = "V8Worker";
    public static final int sEventOnPageClose = 7;
    public static final int sEventOnPageCreate = 4;
    public static final int sEventOnPagePause = 6;
    public static final int sEventOnPageResume = 5;
    public static final int sEventOnSessionClose = 3;
    public static final int sEventOnSessionCreate = 0;
    public static final int sEventOnSessionPause = 2;
    public static final int sEventOnSessionResume = 1;
    public static final int sEventSetSessionId = -2;
    public static final int sEventTerminate = -1;
    private int currentPageId = -1;
    private String mNativeLibraryDir;
    private boolean mSessionActivated;
    private String[] mV8PluginNameList;
    private V8Worker mWorker;

    /* loaded from: classes6.dex */
    public static class PageStateStore {
        String state;
        V8Worker worker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V8NativePlugin(V8Worker v8Worker, Bundle bundle) {
        this.mNativeLibraryDir = null;
        this.mV8PluginNameList = null;
        this.mWorker = v8Worker;
        this.mNativeLibraryDir = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getApplicationInfo().nativeLibraryDir;
        String appId = v8Worker.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        String string = BundleUtils.getString(bundle, "sessionId");
        if (!TextUtils.isEmpty(string)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Set SessionId : ");
            sb.append(string);
            sb.append(", JSEngineName: ");
            sb.append(this.mWorker.getAppxJSEngineName());
            RVLogger.d(TAG, sb.toString());
            V8Worker v8Worker2 = this.mWorker;
            v8Worker2._dispatchPluginEvent(v8Worker2.getAppxJSEngineName(), -2, string, 0);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No SessionId for appId: ");
            sb2.append(appId);
            RVLogger.e(TAG, sb2.toString());
        }
        String[] initV8PluginList = initV8PluginList(appId, bundle);
        if (initV8PluginList != null) {
            HashSet hashSet = new HashSet();
            for (String str : initV8PluginList) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("_jsi");
                String obj = sb3.toString();
                try {
                    System.loadLibrary(obj);
                    V8Utils.addStringToSet(hashSet, obj);
                } catch (Throwable th) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("loadLibrary ");
                    sb4.append(obj);
                    RVLogger.e(TAG, sb4.toString(), th);
                }
            }
            if (hashSet.isEmpty()) {
                return;
            }
            this.mV8PluginNameList = (String[]) hashSet.toArray(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEmpty() {
        String[] strArr = this.mV8PluginNameList;
        return strArr == null || strArr.length == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadPlugins() {
        synchronized (V8NativePlugin.class) {
            V8Worker v8Worker = this.mWorker;
            v8Worker._loadV8Plugins(v8Worker.getAppxJSEngineName(), this.mNativeLibraryDir, this.mV8PluginNameList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean load(String str) {
        boolean _loadV8Plugin;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_jsi");
        String obj = sb.toString();
        synchronized (V8NativePlugin.class) {
            try {
                if (this.mV8PluginNameList == null) {
                    this.mV8PluginNameList = new String[]{obj};
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" Loading V8 Plugin: ");
                sb2.append(obj);
                RVLogger.d(TAG, sb2.toString());
                System.loadLibrary(obj);
                V8Worker v8Worker = this.mWorker;
                _loadV8Plugin = v8Worker._loadV8Plugin(v8Worker.getAppxJSEngineName(), this.mNativeLibraryDir, obj, this.mWorker.getAppId(), this.currentPageId);
            } catch (Throwable th) {
                RVLogger.e(TAG, "failed to get loadNativePlugins", th);
                return false;
            }
        }
        return _loadV8Plugin;
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
    public void redispatchPageCreate(Page page) {
        PageStateStore pageStateStore = (PageStateStore) page.getData(PageStateStore.class, true);
        if (pageStateStore.worker == this.mWorker) {
            return;
        }
        pageStateStore.state = null;
        onPageCreate(page);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageCreate(Page page) {
        this.currentPageId = page.getPageId();
        if (isEmpty()) {
            return;
        }
        PageStateStore pageStateStore = (PageStateStore) page.getData(PageStateStore.class, true);
        if (pageStateStore.state != null) {
            return;
        }
        pageStateStore.worker = this.mWorker;
        this.mWorker.dispatchPageEvent(4, page.getPageId());
        pageStateStore.state = CREATED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageResume(Page page) {
        this.currentPageId = page.getPageId();
        if (isEmpty()) {
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
        if (isEmpty()) {
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
        if (isEmpty()) {
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
        if (isEmpty() || this.mSessionActivated) {
            return;
        }
        this.mSessionActivated = true;
        V8Worker v8Worker = this.mWorker;
        v8Worker._dispatchPluginEvent(v8Worker.getAppxJSEngineName(), 1, this.mWorker.getAppId(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OnSessionPause() {
        if (!isEmpty() && this.mSessionActivated) {
            this.mSessionActivated = false;
            V8Worker v8Worker = this.mWorker;
            v8Worker._dispatchPluginEvent(v8Worker.getAppxJSEngineName(), 2, this.mWorker.getAppId(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OnSessionClose() {
        if (isEmpty()) {
            return;
        }
        this.mSessionActivated = false;
        V8Worker v8Worker = this.mWorker;
        v8Worker._dispatchPluginEvent(v8Worker.getAppxJSEngineName(), 3, this.mWorker.getAppId(), 0);
    }
}
