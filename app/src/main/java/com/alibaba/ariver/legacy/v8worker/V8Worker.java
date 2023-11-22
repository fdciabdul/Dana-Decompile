package com.alibaba.ariver.legacy.v8worker;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.extensions.WorkerStartParamInjectPoint;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.bigdata.BigDataChannelManager;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.legacy.v8worker.extension.V8WorkerExtension;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.v8worker.R;
import com.alibaba.ariver.v8worker.V8Proxy;
import com.alibaba.ariver.v8worker.extension.V8ImportScriptErrorPoint;
import com.alibaba.ariver.v8worker.extension.V8JSErrorPoint;
import com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint;
import com.alibaba.exthub.BuildConfig;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.jsengine.Delegate;
import com.alipay.mobile.jsengine.JSEngine2;
import com.alipay.mobile.jsengine.v8.Releasable;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Context;
import com.alipay.mobile.jsengine.v8.V8Function;
import com.alipay.mobile.jsengine.v8.V8Object;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public class V8Worker extends BaseWorkerImpl {
    public static final String APPX_SECURITY_JS_URL = "https://appx/security-patch.min.js";
    public static final String BUGME_END = "/*BUGME_END*/";
    public static final String BUGME_START = "/*BUGME_START*/";
    private static final String RUNTIME_VARS = "{console,performance,setTimeout,setInterval,clearTimeout,clearInterval,navigator}";
    private static int V8_WORKER_INDEX = 1;
    private V8Object mAlipayJSBridge;
    private App mApp;
    private V8Context mAppContext;
    private boolean mAppxLoaded;
    private boolean mEnableArrayBuffer;
    private boolean mEnableInspector;
    private boolean mEnableMessageChannel;
    private boolean mEnableTestNewV8;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private V8Function mImportScripts;
    private ImportScriptsCallback mImportScriptsCallback;
    private CountDownLatch mInitLock;
    private V8Function mInvokeJS;
    private boolean mIsDebugScene;
    protected JsApiHandler mJsApiHandler;
    private JsTimers mJsTimer;
    private boolean mKeepTimer;
    private List<PluginModel> mPluginModelList;
    private V8Object mSandbox;
    private String mTag;
    private String mUserAgent;
    private List<V8Context> mV8Contexts;
    private String mV8Flags;
    private V8Plugins mV8Plugins;
    private V8 mV8Runtime;
    private WorkerJsapiCallback mWorkerJsapiCallback;
    private Delegate sJSDelegate;
    private boolean mUseSandboxContext = false;
    private boolean mAlipayJSBridgeReady = false;
    private boolean mWorkerPushed = false;
    private Set<String> mLoadedPlugins = new HashSet();
    private boolean gotFatalError = false;

    public int enablePromiseReject() {
        return 1;
    }

    public void prepareMessageChannel(Page page) {
    }

    public int shouldCatchOOM() {
        return 1;
    }

    public void setUseSandboxContext(boolean z) {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("setUseSandboxContext: ");
        sb.append(z);
        RVLogger.d(logTag, sb.toString());
        this.mUseSandboxContext = z;
    }

    public boolean isAppxLoaded() {
        return this.mAppxLoaded;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public boolean tryPostMessageByMessageChannel(V8Array v8Array) {
        if (this.mEnableMessageChannel) {
            boolean z = this.mRenderReady;
            return false;
        }
        return false;
    }

    public V8Worker(App app, String str, List<PluginModel> list, HandlerThread handlerThread, CountDownLatch countDownLatch) {
        this.mInitLock = null;
        this.mIsDebugScene = false;
        this.mApp = null;
        this.sJSDelegate = null;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (handlerThread == null) {
            this.mHandlerThread = prepareWorkerThread();
        } else {
            this.mHandlerThread = handlerThread;
        }
        this.mApp = app;
        this.mInitLock = countDownLatch;
        V8WorkerExtension v8WorkerExtension = new V8WorkerExtension(this);
        ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
        extensionManager.registerExtensionByPoint(this.mApp, AppPausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, AppResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PagePausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageEnterPoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageExitPoint.class, v8WorkerExtension);
        this.mIsDebugScene = AppInfoScene.DEBUG == AppInfoScene.extractScene(app.getStartParams());
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        StringBuilder sb = new StringBuilder();
        sb.append("V8Worker_");
        int i = V8_WORKER_INDEX;
        V8_WORKER_INDEX = i + 1;
        sb.append(i);
        this.mTag = sb.toString();
        this.mUserAgent = str;
        this.mAppId = this.mApp.getAppId();
        this.mPluginModelList = list;
        this.mV8Contexts = new ArrayList();
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (ExecutorUtils.isMainThread()) {
            RVLogger.e(getLogTag(), "*** ANR WARNING *** DO NOT instantiate V8Worker on main thread");
        }
        RVConfigService configService = V8Utils.getConfigService();
        if (configService != null) {
            try {
                String config = configService.getConfig("ta_v8WorkerMC", "");
                this.mEnableMessageChannel = config != null && "1".equals(config.trim());
            } catch (Exception e) {
                RVLogger.e(this.mTag, "getConfig exception", e);
            }
            try {
                String config2 = configService.getConfig("ta_v8WorkerAB", "");
                this.mEnableArrayBuffer = config2 != null && "1".equals(config2.trim());
            } catch (Exception e2) {
                RVLogger.e(this.mTag, "getConfig exception", e2);
            }
            try {
                String config3 = configService.getConfig("ta_test_new_v8", "");
                this.mEnableTestNewV8 = config3 != null && "1".equals(config3.trim());
            } catch (Exception e3) {
                RVLogger.e(this.mTag, "getConfig exception", e3);
            }
            try {
                this.mV8Flags = configService.getConfig("ta_v8_flags", "");
            } catch (Exception e4) {
                RVLogger.e(this.mTag, "getConfig exception", e4);
            }
        }
        this.mKeepTimer = V8Utils.getBooleanConfig(this.mApp.getStartParams(), "keepTimer", "ta_keepTimerAppWhiteList", this.mAppId, false);
        String str2 = this.mTag;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mKeepTimer = ");
        sb2.append(this.mKeepTimer);
        RVLogger.e(str2, sb2.toString());
        long currentTimeMillis = System.currentTimeMillis();
        if (this.sJSDelegate == null) {
            this.sJSDelegate = ((V8Proxy) RVProxy.get(V8Proxy.class)).generateDelegate();
        }
        boolean Initialize = JSEngine2.Initialize(this.sJSDelegate);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!Initialize) {
            if (RVKernelUtils.isDebug()) {
                Toast.makeText(applicationContext, "JSEngine initialize failed", 1).show();
            }
            throw new IllegalStateException("Failed to initialize JSEngine.");
        }
        if (!TextUtils.isEmpty(this.mV8Flags)) {
            String logTag = getLogTag();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("V8 Flags: ");
            sb3.append(this.mV8Flags);
            RVLogger.e(logTag, sb3.toString());
            V8.setFlags(this.mV8Flags);
        }
        String logTag2 = getLogTag();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Initialize JSEngine cost = ");
        long j = currentTimeMillis2 - currentTimeMillis;
        sb4.append(j);
        RVLogger.e(logTag2, sb4.toString());
        if (RVKernelUtils.isDebug()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("V8Worker: ");
            sb5.append(j);
            sb5.append("ms");
            Toast.makeText(applicationContext, sb5.toString(), 0).show();
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.1
            @Override // java.lang.Runnable
            public void run() {
                V8Worker.this.doInit();
            }
        });
    }

    public static HandlerThread prepareWorkerThread() {
        StringBuilder sb = new StringBuilder();
        sb.append("worker-jsapi-");
        sb.append(V8_WORKER_INDEX);
        HandlerThread handlerThread = new HandlerThread(sb.toString());
        handlerThread.start();
        return handlerThread;
    }

    protected void doInit() {
        long currentTimeMillis = System.currentTimeMillis();
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        this.mJsApiHandler = createJsApiHandler(this.mApp);
        this.mV8Runtime = V8.createV8Runtime("self", this);
        if (RVKernelUtils.isDebug()) {
            this.mEnableInspector = this.mV8Runtime.enableDebugAgent(TextUtils.isEmpty(this.mWorkerId) ? "Loading..." : this.mWorkerId);
        }
        if (!this.mEnableInspector) {
            JSConsole.setup(this.mV8Runtime);
        }
        this.mJsTimer = new JsTimers(this.mV8Runtime, this.mHandler);
        this.mImportScriptsCallback = createImportScriptCallback();
        this.mWorkerJsapiCallback = new WorkerJsapiCallback(this);
        this.mV8Runtime.registerJavaMethod(this.mImportScriptsCallback, "importScripts").registerJavaMethod(this.mWorkerJsapiCallback, "__nativeCreateWorker__").registerJavaMethod(new AsyncJsapiCallback(this), "__nativeFlushQueue__");
        RVLogger.e(getLogTag(), "start loading worker js bridge");
        doExecuteScript(V8Utils.readRawFile(applicationContext, R.raw.workerjs_v8), "https://appx/v8.worker.js", 0);
        try {
            this.mImportScripts = (V8Function) this.mV8Runtime.getObject("importScripts");
            V8Object object = this.mV8Runtime.getObject("AlipayJSBridge");
            this.mAlipayJSBridge = object;
            this.mInvokeJS = (V8Function) object.getObject("_invokeJS");
        } catch (Exception e) {
            String logTag = getLogTag();
            StringBuilder sb = new StringBuilder();
            sb.append("doInitWorker exception = ");
            sb.append(e.getMessage());
            RVLogger.e(logTag, sb.toString());
        }
        String logTag2 = getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("doInitWorker cost = ");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.e(logTag2, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("var navigator=");
        sb3.append(getNavigator());
        sb3.append(", __appxStartupParams={enablePolyfillWorker: true, apiMessageChannel:'console', isV8Worker:'true'};");
        doExecuteScript(sb3.toString(), null, 0);
        long currentTimeMillis2 = System.currentTimeMillis();
        String loadResource = this.mImportScriptsCallback.loadResource("https://appx/af-appx.worker.min.js");
        if (!TextUtils.isEmpty(loadResource)) {
            this.mAppxLoaded = true;
            try {
                setAppxVersionInWorker(loadResource.substring(0, 100).split("\\r?\\n")[2].substring(3));
            } catch (Throwable unused) {
            }
            beforeAppXExecute();
            doExecuteScript(loadResource, "https://appx/af-appx.worker.min.js", 0);
            String logTag3 = getLogTag();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("*** Successfully pre-execute https://appx/af-appx.worker.min.js, cost = ");
            sb4.append(System.currentTimeMillis() - currentTimeMillis2);
            RVLogger.e(logTag3, sb4.toString());
        } else {
            RVLogger.e(getLogTag(), "*** Failed to pre-execute https://appx/af-appx.worker.min.js");
        }
        onAlipayJSBridgeReady();
    }

    protected String getNavigator() {
        StringBuilder sb = new StringBuilder();
        sb.append("{userAgent:'");
        sb.append(getUserAgent());
        sb.append("'}");
        return sb.toString();
    }

    public ImportScriptsCallback createImportScriptCallback() {
        return new ImportScriptsCallback(this.mApp, this);
    }

    public JsApiHandler createJsApiHandler(App app) {
        return new JsApiHandler(app, this);
    }

    public JsApiHandler getJsApiHandler() {
        return this.mJsApiHandler;
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public void onAlipayJSBridgeReady() {
        RVLogger.e(getLogTag(), "onAlipayJSBridgeReady");
        this.mAlipayJSBridgeReady = true;
        setStartupParams(this.mApp.getStartParams());
        tryToInjectStartupParamsAndPushWorker();
    }

    protected void beforeAppXExecute() {
        String clientExtendConfig = EngineUtils.getClientExtendConfig();
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("v8 extend config: ");
        sb.append(clientExtendConfig);
        RVLogger.d(logTag, sb.toString());
        doExecuteScript(clientExtendConfig, "CLIENT_EXTEND_CONFIG", 0);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public String getLogTag() {
        return this.mTag;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void tryToInjectStartupParamsAndPushWorker() {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("tryToInjectStartupParamsAndPushWorker, ");
        sb.append(this.mWorkerPushed);
        sb.append(", mStartupParams != null? ");
        sb.append(this.mStartupParams != null);
        sb.append(", mAlipayJSBridgeReady? ");
        sb.append(this.mAlipayJSBridgeReady);
        sb.append(", mWorkerId: ");
        sb.append(this.mWorkerId);
        RVLogger.d(logTag, sb.toString());
        if (this.mWorkerPushed || this.mStartupParams == null || !this.mAlipayJSBridgeReady || this.mWorkerId == null) {
            return;
        }
        this.mWorkerPushed = true;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            doInjectStartupParamsAndPushWorker();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.2
                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.doInjectStartupParamsAndPushWorker();
                }
            });
        }
    }

    public void setPluginModelList(List<PluginModel> list) {
        this.mPluginModelList = list;
    }

    protected void doInjectStartupParamsAndPushWorker() {
        RVLogger.e(getLogTag(), "doInjectStartupParamsAndPushWorker");
        AppConfigModel appConfigModel = (AppConfigModel) this.mApp.getData(AppConfigModel.class);
        if (appConfigModel != null && SummaryActivity.CHECKED.equalsIgnoreCase(appConfigModel.getUseDynamicPlugins())) {
            setUseSandboxContext(true);
        }
        AppModel appModel = (AppModel) this.mApp.getData(AppModel.class);
        List<PluginModel> plugins = appModel != null ? appModel.getAppInfoModel().getPlugins() : null;
        if (plugins != null) {
            setPluginModelList(plugins);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (RVKernelUtils.isDebug()) {
            this.mStartupParams.putString(BuildConfig.BUILD_TYPE, "framework");
        }
        WorkerStartParamInjectPoint workerStartParamInjectPoint = (WorkerStartParamInjectPoint) ExtensionPoint.as(WorkerStartParamInjectPoint.class).node(this.mApp).nullable().create();
        if (workerStartParamInjectPoint != null) {
            workerStartParamInjectPoint.injectStartParam(this.mStartupParams);
        }
        if (this.mEnableInspector) {
            this.mV8Runtime.enableDebugAgent(this.mWorkerId);
        }
        V8Plugins v8Plugins = new V8Plugins(this, this.mApp.getStartParams());
        this.mV8Plugins = v8Plugins;
        if (!v8Plugins.empty()) {
            RVLogger.e(getLogTag(), "V8_LoadV8Plugins");
            this.mV8Plugins.load();
        }
        this.mEnableMessageChannel |= "1".equals(BundleUtils.getString(this.mStartupParams, "v8MC", null));
        int i = 0;
        if (this.mUseSandboxContext || useSandbox()) {
            if (!this.mAppxLoaded) {
                this.mAppxLoaded = true;
                beforeAppXExecute();
                doImportScripts("https://appx/af-appx.worker.min.js");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("var navigator=");
            sb.append(getNavigator());
            sb.append("; Object.assign(__appxStartupParams, ");
            sb.append(BundleUtils.toJSONObject(this.mStartupParams).toJSONString());
            sb.append(");");
            String obj = sb.toString();
            RVLogger.e(getLogTag(), obj);
            doExecuteScript(obj, null, 0);
            while (true) {
                List<PluginModel> list = this.mPluginModelList;
                if (list != null && i < list.size()) {
                    doCreatePluginContext(this.mPluginModelList.get(i).getAppId());
                    i++;
                } else {
                    try {
                        String logTag = getLogTag();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Prepare JSContext for App: ");
                        sb2.append(this.mAppId);
                        RVLogger.e(logTag, sb2.toString());
                        V8Object executeObjectScript = this.mV8Runtime.executeObjectScript("Object.assign({}, AFAppX.getAppContext(),{console,performance,setTimeout,setInterval,clearTimeout,clearInterval,navigator})");
                        this.mAppContext = new V8Context(this.mV8Runtime, executeObjectScript, "App Context");
                        executeObjectScript.release();
                        this.mAppContext.enter();
                        this.mV8Contexts.add(this.mAppContext);
                        this.mAppContext.add("importScripts", this.mImportScripts);
                    } catch (Throwable th) {
                        ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.mApp).create()).onSendMessageException(th);
                    }
                    doImportScripts(APPX_SECURITY_JS_URL);
                    doImportScripts(this.mWorkerId);
                    break;
                }
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Object.assign(__appxStartupParams, ");
            sb3.append(BundleUtils.toJSONObject(this.mStartupParams).toJSONString());
            sb3.append(");");
            String obj2 = sb3.toString();
            RVLogger.e(getLogTag(), obj2);
            doExecuteScript(obj2, null, 0);
            doImportScripts(this.mWorkerId);
        }
        String logTag2 = getLogTag();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("doInjectStartupParamsAndPushWorker cost = ");
        sb4.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.e(logTag2, sb4.toString());
        setWorkerReady();
        this.mV8Plugins.OnSessionResume();
        BigDataChannelManager.getInstance().registerReceiveDataCallback(this.mWorkerId, new BigDataChannelClient(this));
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.3
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (!V8Worker.this.isReleased()) {
                    V8Worker.this.mV8Runtime.pumpMessageLoop(true);
                }
                return true;
            }
        });
    }

    public void doCreatePluginContext(final String str) {
        try {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                if (this.mLoadedPlugins.contains(str)) {
                    String logTag = getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Prepare JSContext but already loaded !!! ");
                    sb.append(str);
                    RVLogger.e(logTag, sb.toString());
                    return;
                }
                String logTag2 = getLogTag();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Prepare JSContext for plugin: ");
                sb2.append(str);
                RVLogger.e(logTag2, sb2.toString());
                V8Context v8Context = this.mAppContext;
                if (v8Context != null) {
                    v8Context.exit();
                }
                V8 v8 = this.mV8Runtime;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Object.assign({}, AFAppX.getPluginContext({pluginId: '");
                sb3.append(str);
                sb3.append("'}),");
                sb3.append(RUNTIME_VARS);
                sb3.append(")");
                V8Object executeObjectScript = v8.executeObjectScript(sb3.toString());
                V8 v82 = this.mV8Runtime;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Plugin: ");
                sb4.append(str);
                V8Context v8Context2 = new V8Context(v82, executeObjectScript, sb4.toString());
                executeObjectScript.release();
                v8Context2.enter();
                this.mV8Contexts.add(v8Context2);
                doImportScripts(APPX_SECURITY_JS_URL);
                String string = BundleUtils.getString(this.mStartupParams, "onlineHost");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("__plugins__/");
                sb5.append(str);
                sb5.append("/index.worker.js");
                doImportScripts(FileUtils.combinePath(string, sb5.toString()));
                v8Context2.exit();
                V8Context v8Context3 = this.mAppContext;
                if (v8Context3 != null) {
                    v8Context3.enter();
                }
                this.mLoadedPlugins.add(str);
                try {
                    RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
                    if (rVMonitor != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("stage", "worker");
                        hashMap.put("stageAction", "didWorker");
                        hashMap.put("pluginId", str);
                        rVMonitor.logNebulaTech(RVConstants.PLUGIN_LOG_SEED_ID, hashMap, null, null, null);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("add worker log error: ");
                    sb6.append(th.getMessage());
                    RVLogger.d("V8Worker", sb6.toString());
                    return;
                }
            }
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.4
                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.doCreatePluginContext(str);
                }
            });
        } catch (Throwable th2) {
            ((V8JSErrorPoint) ExtensionPoint.as(V8JSErrorPoint.class).node(this.mApp).create()).onException(th2.getMessage());
            try {
                RVMonitor rVMonitor2 = (RVMonitor) RVProxy.get(RVMonitor.class);
                if (rVMonitor2 != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("stage", "worker");
                    hashMap2.put("stageAction", "errorWorker");
                    hashMap2.put("pluginId", str);
                    rVMonitor2.logNebulaTech(RVConstants.PLUGIN_LOG_SEED_ID, hashMap2, null, null, null);
                }
            } catch (Throwable th3) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("add error worker log error: ");
                sb7.append(th3.getMessage());
                RVLogger.d("V8Worker", sb7.toString());
            }
        }
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void loadPlugin(String str) {
        super.loadPlugin(str);
        doCreatePluginContext(str);
    }

    protected void onFrontendMessage(final long j, final String str) {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.5
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.isReleased()) {
                    return;
                }
                V8Worker.this.mV8Runtime.dispatchFrontendMessage(j, str);
            }
        });
    }

    protected void onDispatchTaskOnJsThread() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.6
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.isReleased()) {
                    return;
                }
                V8Worker.this.mV8Runtime.dispatchPluginEvent(-1, "", 0);
            }
        });
    }

    private boolean useSandbox() {
        List<PluginModel> list = this.mPluginModelList;
        return list != null && list.size() > 0;
    }

    public void doImportScripts(String str) {
        if (isReleased()) {
            return;
        }
        try {
            this.mImportScriptsCallback.handleResourceRequest(str);
        } catch (Exception e) {
            ((V8ImportScriptErrorPoint) ExtensionPoint.as(V8ImportScriptErrorPoint.class).node(this.mApp).create()).onLoadScriptError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String loadResource(String str) {
        return this.mImportScriptsCallback.loadResource(str);
    }

    public boolean isReleased() {
        V8 v8 = this.mV8Runtime;
        return v8 == null || v8.isReleased();
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendMessageToWorker(String str, String str2, String str3, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(str3, sendToWorkerCallback);
    }

    public void sendMessageToWorker(final Object obj, final SendToWorkerCallback sendToWorkerCallback) {
        if (isReleased()) {
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(new JSONObject());
            }
        } else if (Looper.myLooper() == this.mHandler.getLooper()) {
            doSendMessageToWorker(null, obj, null, null, sendToWorkerCallback);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.7
                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.doSendMessageToWorker(null, obj, null, null, sendToWorkerCallback);
                }
            });
        }
    }

    void doSendMessageToWorker(JSONObject jSONObject, Object obj, String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        Throwable th;
        boolean z;
        if (isReleased()) {
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(new JSONObject());
                return;
            }
            return;
        }
        V8Array v8Array = new V8Array(this.mV8Runtime);
        v8Array.push(obj);
        if (str != null) {
            v8Array.push(str);
        }
        if (str2 != null) {
            v8Array.push(str2);
        }
        try {
            Object call = this.mInvokeJS.call(this.mAlipayJSBridge, v8Array);
            z = call instanceof Boolean ? ((Boolean) call).booleanValue() : false;
            if (call instanceof Releasable) {
                try {
                    ((Releasable) call).release();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.mApp).create()).onSendMessageException(th);
                        v8Array.release();
                        if (sendToWorkerCallback != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(RVConstants.EXTRA_PREVENTED, (Object) Boolean.valueOf(z));
                            sendToWorkerCallback.onCallBack(jSONObject2);
                            return;
                        }
                        return;
                    } finally {
                        v8Array.release();
                        if (sendToWorkerCallback != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(RVConstants.EXTRA_PREVENTED, (Object) Boolean.valueOf(z));
                            sendToWorkerCallback.onCallBack(jSONObject3);
                        }
                    }
                }
            }
            this.mV8Runtime.pumpMessageLoop(false);
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendJsonToWorker(final JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback) {
        if (isReleased()) {
            return;
        }
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            doSendJsonToWorker(jSONObject, sendToWorkerCallback);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.8
                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.doSendJsonToWorker(jSONObject, sendToWorkerCallback);
                }
            });
        }
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void postMessage(String str, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(str, sendToWorkerCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.alipay.mobile.jsengine.v8.V8Value] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.alipay.mobile.jsengine.v8.V8Value] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.alipay.mobile.jsengine.v8.V8Value] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public void doSendJsonToWorker(JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback) {
        if (isReleased()) {
            return;
        }
        String str = this.mAppId;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        try {
            if (this.mEnableArrayBuffer) {
                try {
                    r0 = V8Utils.toV8(this.mV8Runtime, jSONObject);
                    r0 = r0;
                } catch (Throwable th) {
                    RVLogger.e(getLogTag(), "serialize error!", th);
                }
            }
            doSendMessageToWorker(jSONObject, r0 == 0 ? jSONObject.toJSONString() : r0, null, null, sendToWorkerCallback);
        } catch (Throwable th2) {
            try {
                ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.mApp).create()).onSendMessageException(th2);
                if (r0 != 0) {
                    r0.release();
                }
            } finally {
                if (r0 != 0) {
                    r0.release();
                }
            }
        }
    }

    public void executeScript(String str) {
        executeScript((Object) str, (String) null, 0);
    }

    public void executeScript(String str, String str2, int i) {
        executeScript((Object) str, str2, i);
    }

    public void executeScript(Object obj) {
        executeScript(obj, (String) null, 0);
    }

    public void executeScript(final Object obj, final String str, final int i) {
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            doExecuteScript(obj, str, i);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.9
                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.doExecuteScript(obj, str, i);
                }
            });
        }
    }

    protected void doExecuteScript(Object obj, String str, int i) {
        if (isReleased()) {
            return;
        }
        if (this.mAppContext != null && this.mIsDebugScene && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(this.mWorkerId)) {
            RVLogger.d(getLogTag(), "doExecuteScript main js, handle debug scene!");
            String str2 = null;
            if (obj instanceof byte[]) {
                str2 = new String((byte[]) obj);
            } else if (obj instanceof String) {
                str2 = (String) obj;
            }
            if (str2 != null) {
                int indexOf = str2.indexOf(BUGME_START);
                int indexOf2 = str2.indexOf(BUGME_END);
                if (indexOf >= 0 && indexOf2 >= 0) {
                    String substring = str2.substring(0, indexOf);
                    String substring2 = str2.substring(indexOf2 + 13);
                    StringBuilder sb = new StringBuilder();
                    sb.append(substring);
                    sb.append(substring2);
                    obj = sb.toString();
                }
            }
        }
        try {
            boolean z = this.mAppContext != null && str != null && str.startsWith("/") && str.endsWith("/index.worker.js");
            if (obj instanceof String) {
                if (z) {
                    this.mV8Runtime.executeVoidScriptInContext(this.mAppContext, (String) obj, str, i);
                } else {
                    this.mV8Runtime.executeVoidScript((String) obj, str, i);
                }
            } else if (obj instanceof byte[]) {
                if (z) {
                    this.mV8Runtime.executeVoidScriptInContext(this.mAppContext, (byte[]) obj, str, i);
                } else {
                    this.mV8Runtime.executeVoidScript((byte[]) obj, str, i);
                }
            }
            this.mV8Runtime.pumpMessageLoop(false);
        } catch (Throwable th) {
            ((V8JSErrorPoint) ExtensionPoint.as(V8JSErrorPoint.class).node(this.mApp).create()).onException(th.getMessage());
        }
    }

    public void flushCodeCache() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.10
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.isReleased()) {
                    return;
                }
                V8Worker.this.mV8Runtime.flushCodeCache();
            }
        });
    }

    public void onPageCreate(Page page) {
        this.mV8Plugins.onPageCreate(page);
    }

    public void onPageResume(Page page) {
        this.mV8Plugins.onPageResume(page);
    }

    public void onPagePause(Page page) {
        this.mV8Plugins.onPagePause(page);
    }

    public void onPageClose(Page page) {
        this.mV8Plugins.onPageClose(page);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchPageEvent(final int i, final int i2) {
        if (!this.mV8Plugins.empty() || isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.11
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.isReleased()) {
                    return;
                }
                String logTag = V8Worker.this.getLogTag();
                StringBuilder sb = new StringBuilder();
                sb.append("dispatchPageEvent event: ");
                sb.append(i);
                sb.append(", appId: ");
                sb.append(V8Worker.this.mAppId);
                sb.append(", pageId: ");
                sb.append(i2);
                RVLogger.d(logTag, sb.toString());
                V8Worker.this.mV8Runtime.dispatchPluginEvent(i, V8Worker.this.mAppId, i2);
                String logTag2 = V8Worker.this.getLogTag();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("PageEvent event handled, ");
                sb2.append(i);
                sb2.append(", appId: ");
                sb2.append(V8Worker.this.mAppId);
                sb2.append(", pageId: ");
                sb2.append(i2);
                RVLogger.d(logTag2, sb2.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V8 getV8Runtime() {
        return this.mV8Runtime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler getHandler() {
        return this.mHandler;
    }

    public void onSessionPause() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.12
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.mV8Runtime.isReleased()) {
                    return;
                }
                if (!V8Worker.this.mKeepTimer) {
                    V8Worker.this.mJsTimer.pause();
                }
                V8Worker.this.mV8Plugins.OnSessionPause();
            }
        });
    }

    public void onSessionResume() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.13
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.isReleased()) {
                    return;
                }
                if (!V8Worker.this.mKeepTimer) {
                    V8Worker.this.mJsTimer.resume();
                }
                V8Worker.this.mV8Plugins.OnSessionResume();
            }
        });
    }

    public void appLog(int i, String str) {
        if (i == 1) {
            RVLogger.w(getLogTag(), str);
        } else if (i == 2) {
            RVLogger.e(getLogTag(), str);
            if (this.gotFatalError) {
                return;
            }
            this.gotFatalError = true;
            ExecutorUtils.postMain(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Toast.makeText(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), R.string.fatal_msg, 1).show();
                    } catch (Throwable th) {
                        RVLogger.e(V8Worker.this.getLogTag(), "toast exception ", th);
                    }
                }
            });
        } else {
            RVLogger.d(getLogTag(), str);
        }
    }

    public void terminate() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.V8Worker.15
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00cd, code lost:
            
                if (android.os.Build.VERSION.SDK_INT >= 18) goto L45;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00e9, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00f3, code lost:
            
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 271
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.legacy.v8worker.V8Worker.AnonymousClass15.run():void");
            }
        });
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void destroy() {
        super.destroy();
        terminate();
    }
}
