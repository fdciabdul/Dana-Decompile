package com.alibaba.griver.core.preload.impl.render;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.alibaba.ariver.app.NodeInstance;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.runtime.ContentProviderImpl;
import com.alibaba.griver.base.api.APWebResourceRequest;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.APWebViewClient;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.webview.GriverWebviewSetting;
import com.alibaba.griver.base.preload.annotation.RunningAfterAppxJob;
import com.alibaba.griver.base.preload.core.IPreloadJob;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.base.resource.extensions.GriverAppXNgResourcePackage;
import com.alibaba.griver.core.render.GriverWebViewClient;
import com.alibaba.griver.core.utils.GIOUtils;
import com.alibaba.griver.core.webview.AndroidWebView;
import com.google.common.net.HttpHeaders;
import id.dana.data.here.HereOauthManager;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class GriverRenderNgPreLoadJob implements IPreloadJob<RenderPreloadNgResources> {
    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    public String getJobName() {
        return "GriverRenderNgPreLoadJob";
    }

    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    @RunningAfterAppxJob(true)
    public /* bridge */ /* synthetic */ RenderPreloadNgResources preLoad(Map map, PreloadScheduler.PointType pointType) {
        return preLoad((Map<String, Object>) map, pointType);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    @RunningAfterAppxJob(true)
    public RenderPreloadNgResources preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        RenderPreloadNgResources renderPreloadNgResources = (RenderPreloadNgResources) PreloadScheduler.getInstance().getAndRemoveReadyResult(RenderPreloadNgResources.class);
        if (renderPreloadNgResources != null) {
            return renderPreloadNgResources;
        }
        ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage("68687209");
        RenderPreloadNgResources renderPreloadNgResources2 = null;
        if (resourcePackage instanceof GriverAppXNgResourcePackage) {
            final GriverAppXNgResourcePackage griverAppXNgResourcePackage = (GriverAppXNgResourcePackage) resourcePackage;
            final AndroidWebView[] androidWebViewArr = new AndroidWebView[1];
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            long generateNodeId = NodeInstance.generateNodeId();
            GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.preload.impl.render.GriverRenderNgPreLoadJob.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        androidWebViewArr[0] = new AndroidWebView(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                        androidWebViewArr[0].setPreload(true);
                        androidWebViewArr[0].setWebViewClient(GriverRenderNgPreLoadJob.this.a(griverAppXNgResourcePackage, countDownLatch));
                        androidWebViewArr[0].setJavaScriptEnabled(true);
                        androidWebViewArr[0].loadUrl("https://miniprogram.alipay-eco.com/index.html");
                        StringBuilder sb = new StringBuilder();
                        sb.append(androidWebViewArr[0].getUserAgentString());
                        sb.append(" ");
                        sb.append(EngineUtils.getUserAgentSuffix());
                        sb.append(" ");
                        sb.append(GriverWebviewSetting.getUserAgent());
                        PreloadScheduler.UA = sb.toString();
                    } catch (Throwable th) {
                        countDownLatch.countDown();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Take it easy, just cannot use webView in multiple processes. ");
                        sb2.append(th);
                        GriverLogger.e("GriverRenderNgPreLoadJob", sb2.toString());
                    }
                }
            });
            try {
                countDownLatch.await(10L, TimeUnit.SECONDS);
                AndroidWebView androidWebView = androidWebViewArr[0];
                if (androidWebView != null) {
                    renderPreloadNgResources2 = new RenderPreloadNgResources(androidWebView, generateNodeId);
                }
            } catch (InterruptedException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Take it easy, just render preload timeout. ");
                sb.append(e);
                GriverLogger.w("GriverRenderNgPreLoadJob", sb.toString());
            }
            GriverLogger.d("GriverRenderNgPreLoadJob", "GriverRenderNgPreLoadJob preload end");
        }
        return renderPreloadNgResources2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public APWebViewClient a(final GriverAppXNgResourcePackage griverAppXNgResourcePackage, final CountDownLatch countDownLatch) {
        return new GriverWebViewClient(null) { // from class: com.alibaba.griver.core.preload.impl.render.GriverRenderNgPreLoadJob.2
            @Override // com.alibaba.griver.core.render.GriverWebViewClient, com.alibaba.griver.base.api.APWebViewClient
            public void onPageStarted(APWebView aPWebView, String str, Bitmap bitmap) {
            }

            @Override // com.alibaba.griver.core.render.GriverWebViewClient, com.alibaba.griver.base.api.APWebViewClient
            public void onPageFinished(APWebView aPWebView, String str, long j) {
                countDownLatch.countDown();
            }

            @Override // com.alibaba.griver.core.render.GriverWebViewClient, com.alibaba.griver.base.api.APWebViewClient
            public WebResourceResponse shouldInterceptRequest(APWebView aPWebView, APWebResourceRequest aPWebResourceRequest) {
                if (aPWebResourceRequest != null && aPWebResourceRequest.getUrl() != null && !TextUtils.isEmpty(aPWebResourceRequest.getUrl().toString())) {
                    String obj = aPWebResourceRequest.getUrl().toString();
                    if (obj.contains("index.js")) {
                        return null;
                    }
                    if (obj.equals("https://miniprogram.alipay-eco.com/index.html")) {
                        try {
                            InputStream readAssetForInputStream = GIOUtils.readAssetForInputStream(GriverEnv.getResources(), "index_inline.html");
                            if (readAssetForInputStream == null) {
                                return null;
                            }
                            return new WebResourceResponse("text/html", HereOauthManager.ENC, readAssetForInputStream);
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(th);
                            GriverLogger.e("GriverRenderNgPreLoadJob", sb.toString());
                        }
                    }
                    if (obj.startsWith("https://appx")) {
                        try {
                            ResourceQuery resourceQuery = new ResourceQuery(obj);
                            resourceQuery.setAppxNgRoute(true);
                            resourceQuery.pureUrl = resourceQuery.pureUrl.replace(ContentProviderImpl.TINY_RES_HOST, ContentProviderImpl.APPX_NG_TINY_RES_HOST);
                            Resource resource = griverAppXNgResourcePackage.get(resourceQuery);
                            r6 = resource != null ? new WebResourceResponse(resource.getMimeType(), resource.getEncoding(), resource.getStream()) : null;
                            if (Build.VERSION.SDK_INT >= 21 && r6 != null) {
                                Map<String, String> responseHeaders = r6.getResponseHeaders();
                                if (responseHeaders == null) {
                                    responseHeaders = new HashMap<>();
                                }
                                responseHeaders.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                                responseHeaders.put("Cache-Control", SplitHttpHeadersBuilder.CACHE_CONTROL_NO_CACHE);
                                r6.setResponseHeaders(responseHeaders);
                            }
                        } catch (Exception e) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(e);
                            GriverLogger.e("GriverRenderNgPreLoadJob", sb2.toString());
                        }
                    }
                }
                return r6;
            }
        };
    }

    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    public Class<RenderPreloadNgResources> getResultClazz() {
        return RenderPreloadNgResources.class;
    }
}
