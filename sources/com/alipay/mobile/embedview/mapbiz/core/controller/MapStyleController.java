package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.FileCache;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.map.style.CustomMapStyle;
import com.alipay.mobile.zebra.ZebraLoader;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class MapStyleController extends H5MapController {
    protected static Map<String, Object> mCustomMapStylePathTags = new ConcurrentHashMap();
    protected volatile FileCache mFileCache;
    protected boolean mHasCustomMapStyleSource;
    protected boolean mHasReceiveCustomStyleSource;
    protected boolean mMapCustomEnabled;
    protected AtomicLong mMapStyleSourceToken;
    protected AtomicLong mMapTextureSourceToken;

    public MapStyleController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.mMapStyleSourceToken = new AtomicLong();
        this.mMapTextureSourceToken = new AtomicLong();
    }

    public void setCustomMapStyle(AdapterAMap adapterAMap, String str) {
        if (adapterAMap != null && !adapterAMap.is2dMapSdk()) {
            if (this.mMapContainer.configController.isCustomMapStyleEnabled()) {
                if (!TextUtils.isEmpty(str) && !"default".equals(str)) {
                    if (!CustomMapStyle.INSTANCE.isResourcesReady()) {
                        GriverLogger.w(H5MapContainer.TAG, "customMapStyle for resources not ready !!!");
                    }
                    String stylePath = CustomMapStyle.INSTANCE.getStylePath(str);
                    if (!TextUtils.isEmpty(stylePath)) {
                        this.mMapContainer.reportController.reportMapStyle(true);
                    } else {
                        this.mMapContainer.reportController.reportMapStyle(false);
                    }
                    this.mMapCustomEnabled = true;
                    this.mMapStyleSourceToken.incrementAndGet();
                    this.mMapTextureSourceToken.incrementAndGet();
                    a(adapterAMap, stylePath, this.mMapStyleSourceToken.get());
                    StringBuilder sb = new StringBuilder();
                    sb.append("set customMapStyle done: ");
                    sb.append(str);
                    GriverLogger.d(H5MapContainer.TAG, sb.toString());
                    return;
                }
                adapterAMap.setMapCustomEnable(false);
                this.mMapStyleSourceToken.incrementAndGet();
                this.mMapTextureSourceToken.incrementAndGet();
                adapterAMap.setCustomMapStylePath("404");
                adapterAMap.setCustomTextureResourcePath("404");
                this.mMapCustomEnabled = false;
                this.mHasCustomMapStyleSource = false;
                return;
            }
            GriverLogger.d(H5MapContainer.TAG, "custom map style is not enabled");
            return;
        }
        GriverLogger.d(H5MapContainer.TAG, "custom map style is not enabled for 2d");
    }

    public void a(final AdapterAMap adapterAMap, final String str, final long j) {
        if (adapterAMap == null || str == null) {
            return;
        }
        if (mCustomMapStylePathTags.containsKey(str)) {
            if (!TextUtils.isEmpty(str)) {
                adapterAMap.setCustomMapStylePath(str);
            } else {
                adapterAMap.setCustomMapStylePath("404");
            }
            adapterAMap.setMapCustomEnable(true);
            return;
        }
        ExecutorUtils.runNotOnMain(ExecutorType.URGENT, new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MapStyleController.1
            {
                MapStyleController.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (MapStyleController.this) {
                    if (MapStyleController.this.mMapStyleSourceToken.get() != j) {
                        return;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        adapterAMap.setCustomMapStylePath(str);
                    } else {
                        adapterAMap.setCustomMapStylePath("404");
                    }
                    adapterAMap.setMapCustomEnable(true);
                    MapStyleController.mCustomMapStylePathTags.put(str, new Object());
                }
            }
        });
    }

    public void setCustomMapStyleSource(String str) {
        if (TextUtils.isEmpty(str) || !this.mMapContainer.configController.isCustomMapStyleEnabled()) {
            this.mHasCustomMapStyleSource = false;
            return;
        }
        this.mHasCustomMapStyleSource = true;
        AdapterAMap map = this.mMapContainer.getMap();
        if (map == null || map.is2dMapSdk()) {
            return;
        }
        this.mHasReceiveCustomStyleSource = true;
        Context context = this.mMapContainer.getContext();
        if (context == null) {
            GriverLogger.e(H5MapContainer.TAG, HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return;
        }
        File a2 = a(context, str);
        if (a2 == null) {
            GriverLogger.e(H5MapContainer.TAG, "cache file is null");
            return;
        }
        long incrementAndGet = this.mMapStyleSourceToken.incrementAndGet();
        if (a2.exists()) {
            this.mMapCustomEnabled = true;
            a(map, a2.getPath(), incrementAndGet);
            StringBuilder sb = new StringBuilder();
            sb.append("set customMapStyleSource done: ");
            sb.append(str);
            GriverLogger.d(H5MapContainer.TAG, sb.toString());
            this.mMapContainer.reportController.reportMapStyle(true);
            return;
        }
        ExecutorUtils.runNotOnMain(ExecutorType.IO, new AnonymousClass2(incrementAndGet, str, a2, map));
    }

    /* renamed from: com.alipay.mobile.embedview.mapbiz.core.controller.MapStyleController$2 */
    /* loaded from: classes6.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ AdapterAMap val$aMap;
        final /* synthetic */ File val$cacheFile;
        final /* synthetic */ String val$source;
        final /* synthetic */ long val$token;

        AnonymousClass2(long j, String str, File file, AdapterAMap adapterAMap) {
            MapStyleController.this = r1;
            this.val$token = j;
            this.val$source = str;
            this.val$cacheFile = file;
            this.val$aMap = adapterAMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$token != MapStyleController.this.mMapStyleSourceToken.get()) {
                return;
            }
            MapStyleController.this.mMapContainer.resourceLoader.load(this.val$source, new ZebraLoader.OnLoadResourceCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MapStyleController.2.1
                {
                    AnonymousClass2.this = this;
                }

                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadResourceCallback
                public void onComplete(final WebResourceResponse webResourceResponse) {
                    ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MapStyleController.2.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (webResourceResponse == null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("load data error: ");
                                sb.append(AnonymousClass2.this.val$source);
                                GriverLogger.e(H5MapContainer.TAG, sb.toString());
                                MapStyleController.this.mMapContainer.reportController.reportMapStyle(false);
                                return;
                            }
                            MapStyleController.this.mMapContainer.reportController.reportMapStyle(true);
                            if (AnonymousClass2.this.val$token != MapStyleController.this.mMapStyleSourceToken.get()) {
                                return;
                            }
                            MapStyleController.this.a(webResourceResponse, AnonymousClass2.this.val$cacheFile);
                            if (!AnonymousClass2.this.val$cacheFile.exists()) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("write data error: ");
                                sb2.append(AnonymousClass2.this.val$source);
                                GriverLogger.e(H5MapContainer.TAG, sb2.toString());
                            } else if (AnonymousClass2.this.val$token != MapStyleController.this.mMapStyleSourceToken.get()) {
                            } else {
                                MapStyleController.this.a(AnonymousClass2.this.val$aMap, AnonymousClass2.this.val$cacheFile.getPath(), AnonymousClass2.this.val$token);
                                MapStyleController.this.mMapCustomEnabled = true;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("set customMapStyleSource done: ");
                                sb3.append(AnonymousClass2.this.val$source);
                                GriverLogger.d(H5MapContainer.TAG, sb3.toString());
                            }
                        }
                    });
                }
            });
        }
    }

    public void setCustomTextureSource(String str) {
        if (TextUtils.isEmpty(str) || !this.mMapContainer.configController.isCustomMapStyleEnabled()) {
            return;
        }
        if (!this.mMapCustomEnabled && !this.mHasCustomMapStyleSource) {
            GriverLogger.e(H5MapContainer.TAG, "Please set style source, only texture source is not allowed");
            return;
        }
        AdapterAMap map = this.mMapContainer.getMap();
        if (map == null || map.is2dMapSdk()) {
            return;
        }
        this.mHasReceiveCustomStyleSource = true;
        Context context = this.mMapContainer.getContext();
        if (context == null) {
            GriverLogger.e(H5MapContainer.TAG, HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return;
        }
        File a2 = a(context, str);
        if (a2 == null) {
            GriverLogger.e(H5MapContainer.TAG, "cache file is null");
        } else if (a2.exists()) {
            if (this.mHasCustomMapStyleSource) {
                map.setMapCustomEnable(false);
            }
            map.setCustomTextureResourcePath(a2.getPath());
            map.setMapCustomEnable(true);
            StringBuilder sb = new StringBuilder();
            sb.append("set customTextureSource done: ");
            sb.append(str);
            GriverLogger.d(H5MapContainer.TAG, sb.toString());
        } else {
            ExecutorUtils.runNotOnMain(ExecutorType.IO, new AnonymousClass3(this.mMapTextureSourceToken.incrementAndGet(), str, a2, map));
        }
    }

    /* renamed from: com.alipay.mobile.embedview.mapbiz.core.controller.MapStyleController$3 */
    /* loaded from: classes6.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ AdapterAMap val$aMap;
        final /* synthetic */ File val$cacheFile;
        final /* synthetic */ String val$source;
        final /* synthetic */ long val$token;

        AnonymousClass3(long j, String str, File file, AdapterAMap adapterAMap) {
            MapStyleController.this = r1;
            this.val$token = j;
            this.val$source = str;
            this.val$cacheFile = file;
            this.val$aMap = adapterAMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$token != MapStyleController.this.mMapTextureSourceToken.get()) {
                return;
            }
            MapStyleController.this.mMapContainer.resourceLoader.load(this.val$source, new ZebraLoader.OnLoadResourceCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MapStyleController.3.1
                {
                    AnonymousClass3.this = this;
                }

                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadResourceCallback
                public void onComplete(final WebResourceResponse webResourceResponse) {
                    ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MapStyleController.3.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (webResourceResponse == null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("load data error: ");
                                sb.append(AnonymousClass3.this.val$source);
                                GriverLogger.e(H5MapContainer.TAG, sb.toString());
                            } else if (AnonymousClass3.this.val$token != MapStyleController.this.mMapTextureSourceToken.get()) {
                            } else {
                                MapStyleController.this.a(webResourceResponse, AnonymousClass3.this.val$cacheFile);
                                if (!AnonymousClass3.this.val$cacheFile.exists()) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("write data error: ");
                                    sb2.append(AnonymousClass3.this.val$source);
                                    GriverLogger.e(H5MapContainer.TAG, sb2.toString());
                                } else if (AnonymousClass3.this.val$token != MapStyleController.this.mMapTextureSourceToken.get()) {
                                } else {
                                    if (MapStyleController.this.mHasCustomMapStyleSource) {
                                        AnonymousClass3.this.val$aMap.setMapCustomEnable(false);
                                    }
                                    AnonymousClass3.this.val$aMap.setCustomTextureResourcePath(AnonymousClass3.this.val$cacheFile.getPath());
                                    AnonymousClass3.this.val$aMap.setMapCustomEnable(true);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("set customTextureSource done: ");
                                    sb3.append(AnonymousClass3.this.val$source);
                                    GriverLogger.d(H5MapContainer.TAG, sb3.toString());
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x006a, code lost:
    
        if (r0.exists() != false) goto L132;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.webkit.WebResourceResponse r6, java.io.File r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto Laf
            if (r7 == 0) goto Laf
            java.io.File r0 = r7.getParentFile()     // Catch: java.lang.Throwable -> Lac
            if (r0 != 0) goto Ld
            goto Laf
        Ld:
            java.io.File r0 = r7.getParentFile()     // Catch: java.lang.Throwable -> Lac
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> Lac
            if (r0 != 0) goto L1e
            java.io.File r0 = r7.getParentFile()     // Catch: java.lang.Throwable -> Lac
            r0.mkdirs()     // Catch: java.lang.Throwable -> Lac
        L1e:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> Lac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r1.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = r7.getPath()     // Catch: java.lang.Throwable -> Lac
            r1.append(r2)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "."
            r1.append(r2)     // Catch: java.lang.Throwable -> Lac
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lac
            r1.append(r2)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = ".tmp"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lac
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lac
            java.io.InputStream r6 = r6.getData()     // Catch: java.lang.Throwable -> L6f
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6f
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L6f
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L6d
        L51:
            int r3 = r6.read(r2)     // Catch: java.lang.Throwable -> L6d
            r4 = -1
            if (r3 == r4) goto L5d
            r4 = 0
            r1.write(r2, r4, r3)     // Catch: java.lang.Throwable -> L6d
            goto L51
        L5d:
            r1.close()     // Catch: java.lang.Throwable -> L6d
            r0.renameTo(r7)     // Catch: java.lang.Throwable -> L6d
            com.alibaba.ariver.kernel.common.utils.IOUtils.closeQuietly(r1)     // Catch: java.lang.Throwable -> Lac
            boolean r6 = r0.exists()     // Catch: java.lang.Throwable -> Lac
            if (r6 == 0) goto L9c
            goto L99
        L6d:
            r6 = move-exception
            goto L71
        L6f:
            r6 = move-exception
            r1 = 0
        L71:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r7.<init>()     // Catch: java.lang.Throwable -> L9e
            r7.append(r6)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r2 = "H5EmbedMapView"
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L9e
            com.alibaba.griver.base.common.logger.GriverLogger.e(r2, r7)     // Catch: java.lang.Throwable -> L9e
            com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r7 = r5.mMapContainer     // Catch: java.lang.Throwable -> L9e
            com.alipay.mobile.embedview.mapbiz.core.controller.ReportController r7 = r7.reportController     // Catch: java.lang.Throwable -> L9e
            java.lang.String r2 = "MapStyleController#writeWebResourceToCache"
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L9e
            r7.reportException(r2, r6)     // Catch: java.lang.Throwable -> L9e
            com.alibaba.ariver.kernel.common.utils.IOUtils.closeQuietly(r1)     // Catch: java.lang.Throwable -> Lac
            boolean r6 = r0.exists()     // Catch: java.lang.Throwable -> Lac
            if (r6 != 0) goto L99
            goto L9c
        L99:
            r0.delete()     // Catch: java.lang.Throwable -> Lac
        L9c:
            monitor-exit(r5)
            return
        L9e:
            r6 = move-exception
            com.alibaba.ariver.kernel.common.utils.IOUtils.closeQuietly(r1)     // Catch: java.lang.Throwable -> Lac
            boolean r7 = r0.exists()     // Catch: java.lang.Throwable -> Lac
            if (r7 == 0) goto Lab
            r0.delete()     // Catch: java.lang.Throwable -> Lac
        Lab:
            throw r6     // Catch: java.lang.Throwable -> Lac
        Lac:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        Laf:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.MapStyleController.a(android.webkit.WebResourceResponse, java.io.File):void");
    }

    private File a(Context context, String str) {
        if (this.mFileCache == null) {
            String appId = this.mMapContainer.getAppId();
            if (TextUtils.isEmpty(appId)) {
                return null;
            }
            synchronized (this) {
                if (this.mFileCache == null) {
                    this.mFileCache = new FileCache(context, appId, "");
                }
            }
        }
        String cachePath = this.mFileCache.getCachePath(context, str);
        if (TextUtils.isEmpty(cachePath)) {
            return null;
        }
        return new File(cachePath);
    }
}
