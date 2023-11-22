package com.alibaba.griver.core.worker;

import android.os.Build;
import android.os.Looper;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.exthub.BuildConfig;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.H5CallBack;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.webview.GriverWebviewSetting;
import com.alibaba.griver.core.webview.AndroidWebView;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class WebWorker extends H5Worker {
    public static String JAVASCRIPT_SCHEME = "javascript:";
    private APWebView b;
    private String d;
    private String e;
    protected H5WorkerControllerProvider mWorkerControllerProvider;

    /* renamed from: a  reason: collision with root package name */
    private final String f6496a = "WebWorker";
    private boolean c = false;

    @Override // com.alibaba.griver.core.worker.H5Worker
    protected String getLogTag() {
        return "WebWorker";
    }

    public WebWorker() {
        a();
    }

    private void a() {
        d();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.worker.WebWorker.1
                @Override // java.lang.Runnable
                public void run() {
                    WebWorker.this.doInit();
                }
            });
        } else {
            doInit();
        }
    }

    protected void doInit() {
        long currentTimeMillis = System.currentTimeMillis();
        b();
        this.mWorkerControllerProvider = generateH5WorkerControllerProvider();
        this.b.setWebViewClient(new WorkerWebViewClient(this));
        this.b.setWebChromeClient(new WorkerWebChromeClient(this));
        this.b.getSettings().setUserAgentString(this.e);
        RVLogger.d("WebWorker", "start loading worker js bridge");
        this.b.loadUrl("https://alipay.worker.com/worker");
        StringBuilder sb = new StringBuilder();
        sb.append("doInitWorker cost = ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.d("WebWorker", sb.toString());
    }

    public H5WorkerControllerProvider generateH5WorkerControllerProvider() {
        return new H5WorkerControllerProvider(this, null);
    }

    public H5WorkerControllerProvider getWorkerControllerProvider() {
        return this.mWorkerControllerProvider;
    }

    public APWebView getWebView() {
        return this.b;
    }

    @Override // com.alibaba.griver.core.worker.H5Worker
    public void tryToInjectStartupParamsAndPushWorker() {
        if (!this.c && this.mStartupParams != null && this.mAlipayJSBridgeReady && this.mWorkerId != null) {
            this.c = true;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                doInjectStartupParamsAndPushWorker();
                return;
            } else {
                ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.worker.WebWorker.2
                    @Override // java.lang.Runnable
                    public void run() {
                        WebWorker.this.doInjectStartupParamsAndPushWorker();
                    }
                });
                return;
            }
        }
        boolean z = this.mAlipayJSBridgeReady;
    }

    protected String getInjectStartupParams() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userAgent", (Object) GriverWebviewSetting.getUserAgent());
        JSONObject jSONObject2 = BundleUtils.toJSONObject(this.mStartupParams);
        WebWorkerInitInjector.getInitInjectAppXStartParams(jSONObject2);
        String jSONString = jSONObject2.toJSONString();
        StringBuilder sb = new StringBuilder();
        sb.append("var navigator=");
        sb.append(jSONObject.toJSONString());
        sb.append(";var __appxStartupParams=");
        sb.append(jSONString);
        sb.append(";var __workerjs=\"self.__appxStartupParams=\" + JSON.stringify(__appxStartupParams) + \";importScripts('");
        sb.append(this.mWorkerId);
        sb.append("');\";worker.postMessage({action:'exec',data:__workerjs});");
        return sb.toString();
    }

    protected void doInjectStartupParamsAndPushWorker() {
        long currentTimeMillis = System.currentTimeMillis();
        if (GriverEnv.isDebuggable()) {
            this.mStartupParams.putString(BuildConfig.BUILD_TYPE, "framework");
        }
        try {
            eval(getInjectStartupParams());
        } catch (Throwable th) {
            RVLogger.e("WebWorker", "tryToInjectStartupParams error!", th);
            MonitorMap.Builder builder = new MonitorMap.Builder();
            H5WorkerControllerProvider h5WorkerControllerProvider = this.mWorkerControllerProvider;
            if (h5WorkerControllerProvider != null && h5WorkerControllerProvider.app != null) {
                builder.appId(this.mWorkerControllerProvider.app.getAppId()).version(this.mWorkerControllerProvider.app).needAsynAppType(true);
            }
            builder.exception(th).workerType(GriverMonitorConstants.WORKER_TYPE_WEB).message(GriverMonitorConstants.MESSAGE_WORKER_LOAD_SCRIPT_EXCEPTION);
            GriverMonitor.error(GriverMonitorConstants.ERROR_JS_EXECUTE_EXCEPTION, "GriverAppContainer", builder.build());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("doInjectStartupParamsAndPushWorker cost = ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.d("WebWorker", sb.toString());
        setWorkerReady();
    }

    protected void eval(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.evaluateJavascript(str, null);
            return;
        }
        APWebView aPWebView = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append(JAVASCRIPT_SCHEME);
        sb.append(str);
        aPWebView.loadUrl(sb.toString());
    }

    @Override // com.alibaba.griver.core.worker.H5Worker
    public void sendMessageToWorker(String str, String str2, String str3, H5CallBack h5CallBack) {
        sendToWorker(str, str2, RDConstant.ACTION_CALL_BRIDGE, str3, h5CallBack);
    }

    public void sendToWorker(final String str, final String str2, final String str3, final String str4, final H5CallBack h5CallBack) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a(str, str2, str3, str4, h5CallBack);
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.worker.WebWorker.3
                @Override // java.lang.Runnable
                public void run() {
                    WebWorker.this.a(str, str2, str3, str4, h5CallBack);
                }
            });
        }
    }

    protected String getMessageToWorker(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.worker.postMessage({\"action\":\"");
        sb.append(str);
        sb.append("\",\"data\":");
        sb.append(str2);
        sb.append("})");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, H5CallBack h5CallBack) {
        try {
            eval(getMessageToWorker(str3, str4));
            sendPushCallBack(str, str2, h5CallBack);
        } catch (Throwable th) {
            MonitorMap.Builder builder = new MonitorMap.Builder();
            H5WorkerControllerProvider h5WorkerControllerProvider = this.mWorkerControllerProvider;
            if (h5WorkerControllerProvider != null) {
                builder.version(h5WorkerControllerProvider.app);
            }
            builder.appId(str);
            builder.exception(th).workerType(GriverMonitorConstants.WORKER_TYPE_WEB).message(GriverMonitorConstants.MESSAGE_WORKER_SEND_MESSAGE_EXCEPTION);
            GriverMonitor.error(GriverMonitorConstants.ERROR_JS_EXECUTE_EXCEPTION, "GriverAppContainer", builder.build());
            RVLogger.e("WebWorker", "sendToWorker error:", th);
        }
    }

    private void b() {
        AndroidWebView androidWebView = new AndroidWebView(GriverEnv.getApplicationContext());
        this.b = androidWebView;
        androidWebView.setWebContentsDebuggingEnabled(GriverEnv.isDebuggable());
        this.b.getSettings().setJavaScriptEnabled(true);
    }

    public void setUserAgent(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("set ua for worker: ");
        sb.append(str);
        GriverLogger.d("WebWorker", sb.toString());
        this.e = str;
    }

    @Override // com.alibaba.griver.core.worker.H5Worker
    public void destroy() {
        H5WorkerControllerProvider h5WorkerControllerProvider = this.mWorkerControllerProvider;
        if (h5WorkerControllerProvider != null) {
            h5WorkerControllerProvider.destroy();
        }
        super.destroy();
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.worker.WebWorker.4
            @Override // java.lang.Runnable
            public void run() {
                WebWorker.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        APWebView aPWebView = this.b;
        if (aPWebView != null) {
            try {
                aPWebView.destroy();
            } catch (Throwable th) {
                InstrumentInjector.log_e("WebWorker", "destroyWorker error!", th);
            }
        }
    }

    private void d() {
        this.d = "";
    }

    public String getBridgeToken() {
        return this.d;
    }
}
