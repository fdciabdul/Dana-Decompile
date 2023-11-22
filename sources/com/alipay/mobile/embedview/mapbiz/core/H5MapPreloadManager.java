package com.alipay.mobile.embedview.mapbiz.core;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.utils.TinyUtils;
import com.alipay.mobile.apmap.AdapterMapsInitializer;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.SimpleSDKContext;
import com.alipay.mobile.apmap.util.SimpleSDKErrorLogger;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.RuntimeConstants;
import com.alipay.mobile.map.style.CustomMapStyle;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class H5MapPreloadManager {
    public static final H5MapPreloadManager INSTANCE = new H5MapPreloadManager();

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7143a;
    private static boolean b;
    private final Set<String> c = new CopyOnWriteArraySet();
    private final Map<String, AtomicBoolean> d = new ConcurrentHashMap();
    private final Map<String, Queue<Reference<AdapterTextureMapView>>> e = new ConcurrentHashMap();
    private volatile JSONArray f = null;
    private volatile int g = -1;
    private boolean h;
    private JSONArray i;
    private boolean j;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
    }

    private boolean b(String str) {
        return false;
    }

    static /* synthetic */ boolean access$600() {
        return a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.g == -1) {
            try {
                this.g = "1".equals(GriverConfig.getConfigWithProcessCache("ta_map_preload_mode", "")) ? 1 : 0;
                this.f = GriverConfig.getConfigJSONArray("ta_map_preload");
                this.h = "1".equals(GriverConfig.getConfigWithProcessCache("ta_map_preheat_strict", ""));
                this.i = GriverConfig.getConfigJSONArray("ta_map_preheat_strict_apps");
                this.j = !"0".equals(GriverConfig.getConfigWithProcessCache("ta_map_download_convert_lib", ""));
            } catch (Exception e) {
                RVLogger.e(H5MapContainer.TAG, e);
            }
        }
        return this.f != null && this.f.contains(str);
    }

    private static boolean a() {
        return TextUtils.equals(GriverConfig.getConfigWithProcessCache("ta_map_log_sdk_error", ""), "1");
    }

    private void a(final Context context, final String str, final boolean z) {
        if (this.g == 0) {
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(z);
        if (!z) {
            atomicBoolean.set(b(str));
            if (this.g == 1) {
                if (atomicBoolean.get()) {
                    if (RuntimeConstants.INSTANCE.isDebug()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("map component tag is found in scene params: ");
                        sb.append(str);
                        RVLogger.d(H5MapContainer.TAG, sb.toString());
                    }
                } else if ((this.f == null || !this.f.contains(str)) && !this.c.contains(str)) {
                    return;
                }
            }
        }
        Runnable runnable = new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5MapPreloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!H5MapPreloadManager.this.a(str)) {
                        if (RuntimeConstants.INSTANCE.isDebug()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("this is not preload by config service: ");
                            sb2.append(str);
                            RVLogger.d(H5MapContainer.TAG, sb2.toString());
                        }
                        if (H5MapPreloadManager.this.g == 0) {
                            return;
                        }
                        if (!z) {
                            if (atomicBoolean.get()) {
                                if (RuntimeConstants.INSTANCE.isDebug()) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("this is a map application, but not in config service: ");
                                    sb3.append(str);
                                    RVLogger.d(H5MapContainer.TAG, sb3.toString());
                                }
                            } else if (RuntimeConstants.INSTANCE.isMainProcess()) {
                                if (RuntimeConstants.INSTANCE.isDebug()) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("this is not a map application: ");
                                    sb4.append(str);
                                    RVLogger.d(H5MapContainer.TAG, sb4.toString());
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    boolean add = H5MapPreloadManager.this.c.add(str);
                    if (z && add && ((H5MapPreloadManager.this.f == null || !H5MapPreloadManager.this.f.contains(str)) && RuntimeConstants.INSTANCE.isMainProcess() && RuntimeConstants.INSTANCE.isDebug())) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("this is a map application, something is wrong: ");
                        sb5.append(str);
                        RVLogger.d(H5MapContainer.TAG, sb5.toString());
                    }
                    if (!z) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("this is a map application: ");
                        sb6.append(str);
                        RVLogger.d(H5MapContainer.TAG, sb6.toString());
                    }
                    boolean is2dMapSdk = AdapterUtil.is2dMapSdk();
                    if (is2dMapSdk) {
                        if (RuntimeConstants.INSTANCE.isDebug()) {
                            RVLogger.d(H5MapContainer.TAG, "map sdk is 2d");
                            return;
                        }
                        return;
                    }
                    if (!z && !H5MapPreloadManager.b) {
                        boolean unused = H5MapPreloadManager.b = true;
                        AdapterMapsInitializer.setDownloadCoordinateConvertLibrary(new SimpleSDKContext(is2dMapSdk), H5MapPreloadManager.this.j);
                    }
                    if (!z && H5MapPreloadManager.access$600()) {
                        SimpleSDKErrorLogger.setEnabled(true);
                    }
                    AtomicBoolean atomicBoolean2 = (AtomicBoolean) H5MapPreloadManager.this.d.get(str);
                    if (atomicBoolean2 != null && atomicBoolean2.get()) {
                        synchronized (atomicBoolean2) {
                            int i = 0;
                            Iterator it = H5MapPreloadManager.this.e.entrySet().iterator();
                            while (it.hasNext()) {
                                Iterator it2 = ((Queue) ((Map.Entry) it.next()).getValue()).iterator();
                                while (it2.hasNext()) {
                                    if (((Reference) it2.next()).get() != null) {
                                        i++;
                                    }
                                }
                            }
                            if (i < 6) {
                                Queue queue = (Queue) H5MapPreloadManager.this.e.get(str);
                                if (queue == null) {
                                    queue = new ConcurrentLinkedQueue();
                                    H5MapPreloadManager.this.e.put(str, queue);
                                } else if (queue.size() >= 2) {
                                    return;
                                }
                                AdapterTextureMapView adapterTextureMapView = new AdapterTextureMapView(context);
                                adapterTextureMapView.setCreateMapTracked(true);
                                adapterTextureMapView.getMap();
                                queue.offer(new SoftReference(adapterTextureMapView));
                                if (!z && !H5MapPreloadManager.f7143a && H5MapPreloadManager.this.h && H5MapPreloadManager.this.i != null && (H5MapPreloadManager.this.i.contains(str) || H5MapPreloadManager.this.i.contains("all"))) {
                                    boolean unused2 = H5MapPreloadManager.f7143a = true;
                                    H5MapPreloadManager.this.a(context);
                                    RVLogger.d(H5MapContainer.TAG, "Preload map success");
                                }
                                if (z) {
                                    return;
                                }
                                CustomMapStyle.INSTANCE.prepareResources();
                                return;
                            }
                            RVLogger.d(H5MapContainer.TAG, "preload list size overflow");
                            return;
                        }
                    }
                    RVLogger.d(H5MapContainer.TAG, "application is destroyed ???");
                } catch (Exception e) {
                    RVLogger.e(H5MapContainer.TAG, e);
                }
            }
        };
        if (z || TinyUtils.isMain()) {
            ExecutorUtils.runNotOnMain(ExecutorType.URGENT, runnable);
        } else {
            runnable.run();
        }
    }

    public void onH5ApplicationCreated(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onH5ApplicationCreated: ");
        sb.append(str);
        RVLogger.d(H5MapContainer.TAG, sb.toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AtomicBoolean atomicBoolean = this.d.get(str);
        if (atomicBoolean == null) {
            this.d.put(str, new AtomicBoolean(true));
        } else {
            atomicBoolean.set(true);
        }
        a(context, str, false);
    }

    public void onH5ApplicationDestroyed(Context context, final String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onH5ApplicationDestroyed: ");
        sb.append(str);
        RVLogger.d(H5MapContainer.TAG, sb.toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AtomicBoolean atomicBoolean = this.d.get(str);
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        ExecutorUtils.runNotOnMain(ExecutorType.NORMAL, new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5MapPreloadManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AtomicBoolean atomicBoolean2 = (AtomicBoolean) H5MapPreloadManager.this.d.get(str);
                    if (atomicBoolean2 == null) {
                        RVLogger.d(H5MapContainer.TAG, "application is not created ???");
                        return;
                    }
                    synchronized (atomicBoolean2) {
                        Queue queue = TextUtils.isEmpty(str) ? null : (Queue) H5MapPreloadManager.this.e.get(str);
                        if (queue != null) {
                            queue.clear();
                        }
                        H5MapPreloadManager.this.d.remove(str);
                    }
                } catch (Exception e) {
                    RVLogger.e(H5MapContainer.TAG, e);
                }
            }
        });
    }

    public AdapterTextureMapView requestMapView(Context context, String str) {
        CustomMapStyle.INSTANCE.prepareResources();
        if (AdapterUtil.is2dMapSdk() || TextUtils.isEmpty(str)) {
            return new AdapterTextureMapView(context);
        }
        Queue<Reference<AdapterTextureMapView>> queue = this.e.get(str);
        Reference<AdapterTextureMapView> poll = queue != null ? queue.poll() : null;
        AdapterTextureMapView adapterTextureMapView = poll != null ? poll.get() : null;
        if (adapterTextureMapView == null) {
            RVLogger.d(H5MapContainer.TAG, "requestMapView from new instance");
            adapterTextureMapView = new AdapterTextureMapView(context);
        } else {
            RVLogger.d(H5MapContainer.TAG, "requestMapView from preload cache");
        }
        a(context, str, true);
        return adapterTextureMapView;
    }
}
