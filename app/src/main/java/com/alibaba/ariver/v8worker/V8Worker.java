package com.alibaba.ariver.v8worker;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.system.Os;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.collection.ArrayMap;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.JsErrorAssist;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.point.app.AppLeaveHintPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.extensions.WorkerStartParamInjectPoint;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.model.AppxVersionStore;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.EventTrackStore;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.bigdata.BigDataChannelManager;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.log.WorkerLog;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.ariver.resource.runtime.ContentProviderImpl;
import com.alibaba.ariver.v8worker.extension.V8ImportScriptErrorPoint;
import com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint;
import com.alibaba.ariver.v8worker.extension.V8WorkerExtension;
import com.alibaba.ariver.v8worker.extension.V8WorkerInitFinishedListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.griver.core.GriverParam;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alibaba.jsi.standard.Events;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.JSEngine;
import com.alibaba.jsi.standard.js.Arguments;
import com.alibaba.jsi.standard.js.EngineScope;
import com.alibaba.jsi.standard.js.JSArray;
import com.alibaba.jsi.standard.js.JSBoolean;
import com.alibaba.jsi.standard.js.JSCallback;
import com.alibaba.jsi.standard.js.JSException;
import com.alibaba.jsi.standard.js.JSFunction;
import com.alibaba.jsi.standard.js.JSNumber;
import com.alibaba.jsi.standard.js.JSObject;
import com.alibaba.jsi.standard.js.JSString;
import com.alibaba.jsi.standard.js.JSValue;
import com.alibaba.jsi.standard.js.JSVoid;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class V8Worker extends BaseWorkerImpl {
    private static final String APPX_JS_CONTEXT = "APPX-JSContext";
    private static final String APPX_SECURITY_JS_URL = "https://appx/security-patch.min.js";
    private static final String APP_BIZ_JS_CONTEXT = "APP-Biz-JSContext";
    private static final String APP_ID = "appId";
    private static final String APP_PLUGIN_CONTEXT = "APP-Plugin-JSContext-";
    private static final String LIB_JSI_SO = "libjsi.so";
    private static final String LIB_WEBVIEW_UC_SO = "libwebviewuc.so";
    private static final String ONLINE_HOST = "onlineHost";
    private static final String PARAM_SANDBOXED = "Sandboxed";
    private static final String RUNTIME_VARS = "{console,performance,setTimeout,setInterval,clearTimeout,clearInterval,navigator,bootstrapSubPackage}";
    private static final String TAG = "V8Worker_JSI";
    private static int V8_WORKER_INDEX = 1;
    public static final String WORKER_POOL = "poolWorker ";
    private static long sJSEngineInitCost;
    private static String sV8Type;
    private JSObject mAlipayJSBridgeObj;
    private boolean mAlipayJSBridgeReady;
    private App mApp;
    private final Object mAppxContextInitLock;
    private String mAppxJSEngineName;
    protected List<Worker.JsContextReadyListener> mAppxJsContextInitListeners;
    protected volatile boolean mAppxJsContextReady;
    boolean mAppxLoaded;
    private long mAppxResCost;
    long mAppxWorkerJsCost;
    long mBeginWaitH5Page;
    protected List<Worker.JsContextReadyListener> mBizContextInitListeners;
    private final Object mBizContextInitLock;
    private JSContext mBizJSContext;
    protected volatile boolean mBizJsContextReady;
    private long mBizWorkerJsCost;
    private boolean mCleanupOnInitTimeout;
    private long mClientBackgroundSleepDelay;
    private boolean mEnableArrayBuffer;
    private boolean mEnableClientBackgroundSleep;
    private boolean mEnableKeepAliveSleep;
    private boolean mEnableMessageChannel;
    private boolean mEnableTinyBackgroundSleep;
    long mEndWaitH5Page;
    private EngineScope mEngineScope;
    private volatile boolean mExiting;
    public boolean mFullLogMsg;
    private boolean mGotMsgFromRender;
    private boolean mGotMsgFromWorker;
    protected Handler mHandler;
    private HandlerThread mHandlerThread;
    private ImportScriptsCallback mImportScriptsCallback;
    private JSFunction mImportScriptsFunc;
    private CountDownLatch mInitLock;
    final Runnable mInitWatchDog;
    private volatile boolean mInvalid;
    private JSFunction mInvokeJSFunc;
    private boolean mIscompletePreload;
    private JSContext mJSContext;
    private List<JSContext> mJSContextList;
    private JSEngine mJSEngine;
    private int mJSIThreadTid;
    private Handler mJSIWatchDogHandler;
    private HandlerThread mJSIWatchDogHandlerThread;
    private JsApiHandler mJsApiHandler;
    private JsTimers mJsTimer;
    private long mKeepAliveSleepDelay;
    private boolean mKeepTimer;
    private String mLastTrackId;
    private boolean mLeaveHintStatus;
    private Set<String> mLoadedPlugins;
    private MultiThreadWorkerCallback mMultiThreadWorkerCallback;
    private String mParentId;
    private Runnable mPauseTimer;
    private int mPauseTimerDelay;
    private volatile boolean mPaused;
    private List<PluginModel> mPluginModelList;
    private long mRenderReadyTs;
    private boolean mSyncLoadPlugin;
    private String mTag;
    private Runnable mTimeoutRunnable;
    private long mTinyBackgroundSleepDelay;
    private boolean mTitleBarClose;
    private boolean mUseSandboxContext;
    private String mUserAgent;
    private long mV8CallingId;
    private long mV8InstanceCost;
    private V8NativePlugin mV8NativePlugin;
    private volatile boolean mWorkerPoolPreInitSuccess;
    private boolean mWorkerPushed;
    private long mWorkerReadyTs;
    public static final byte[] getAuthRequestContext = {123, 85, -72, 69, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int BuiltInFictitiousFunctionClassFactory = 15;
    private static Map<String, HandlerThread> jsi2handlerThread = new ArrayMap();
    private static final AtomicBoolean sJSEngineInitialized = new AtomicBoolean(false);
    private static volatile boolean sJSEngineInitResult = false;
    private static CopyOnWriteArrayList<V8WorkerInitFinishedListener> sV8WorkerInitFinishedListener = new CopyOnWriteArrayList<>();

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 22
            int r8 = 25 - r8
            byte[] r0 = com.alibaba.ariver.v8worker.V8Worker.getAuthRequestContext
            int r7 = r7 * 6
            int r7 = r7 + 97
            int r6 = r6 * 5
            int r6 = r6 + 18
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r7
            r4 = 0
            r7 = r6
            goto L30
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            int r8 = r8 + 1
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L30:
            int r6 = r6 + r3
            int r6 = r6 + (-8)
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.V8Worker.j(int, int, short, java.lang.Object[]):void");
    }

    public native void _dispatchPluginEvent(String str, int i, String str2, int i2);

    public native boolean _loadV8Plugin(String str, String str2, String str3, String str4, int i);

    public native void _loadV8Plugins(String str, String str2, String[] strArr);

    public String getAppxWorkerJsUrl() {
        return "https://appx/af-appx.worker.min.js";
    }

    protected String getBizContextJs() {
        return "Object.assign({}, AFAppX.getAppContext(),{console,performance,setTimeout,setInterval,clearTimeout,clearInterval,navigator,bootstrapSubPackage})";
    }

    protected JSConsoleCallback getJSConsoleCallback() {
        return null;
    }

    protected void handleJsApiCacheInitialParams(JSONObject jSONObject) {
    }

    protected void initJsApiCache() {
    }

    protected void packageJsApiCacheStartParams(JSONObject jSONObject) {
    }

    public void prepareMessageChannel(Page page) {
    }

    public boolean tryPostMessageByMessageChannel(int i, String str) {
        return false;
    }

    public static V8Worker reBindJsi(V8Worker v8Worker, App app, List<PluginModel> list, CountDownLatch countDownLatch, String str) {
        if (v8Worker.mAlipayJSBridgeReady && v8Worker.isAppxJsContextReady() && v8Worker.isReleased()) {
            v8Worker.bindApp2Jsi(app, list, countDownLatch, str);
            return v8Worker;
        }
        return new V8Worker(app, str, list, null, countDownLatch);
    }

    public void bindApp2Jsi(App app, List<PluginModel> list, CountDownLatch countDownLatch, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("V8Worker_JSI_");
        sb.append(V8_WORKER_INDEX);
        this.mTag = sb.toString();
        this.mApp = app;
        this.mInitLock = countDownLatch;
        this.mUserAgent = str;
        this.mAppId = app.getAppId();
        this.mPluginModelList = list;
        if (app != null) {
            String string = BundleUtils.getString(getStartupParams(), RVParams.START_APP_SESSION_ID);
            this.mParentId = string;
            if (TextUtils.isEmpty(string)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mAppId);
                sb2.append("_V8Worker_");
                sb2.append(app.getNodeId());
                sb2.append("_");
                sb2.append(System.currentTimeMillis());
                this.mParentId = sb2.toString();
            }
        }
        final int intConfig = V8Utils.getIntConfig("ta_v8WorkerInitExpires", 15);
        if (!RVKernelUtils.isDebug() && intConfig > 0) {
            this.mTimeoutRunnable = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.1
                {
                    V8Worker.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (V8Worker.this.mApp != null && (V8Worker.this.mApp.isDestroyed() || V8Worker.this.mApp.isExited())) {
                        RVLogger.e(V8Worker.this.mTag, "mApp isDestroyed");
                    } else if (V8Worker.this.isWorkerTimeOut()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", IAPSyncCommand.COMMAND_INIT);
                        hashMap.put("message", "V8Worker initializing timeout");
                        hashMap.put("expires", String.valueOf(intConfig));
                        hashMap.put("lastTrack", V8Worker.this.mLastTrackId);
                        hashMap.put("workerReady", String.valueOf(V8Worker.this.isWorkerReady()));
                        hashMap.put("renderReady", String.valueOf(V8Worker.this.isRenderReady()));
                        hashMap.put("workerMsg", String.valueOf(V8Worker.this.mGotMsgFromWorker));
                        hashMap.put("renderMsg", String.valueOf(V8Worker.this.mGotMsgFromRender));
                        ((EventTracker) RVProxy.get(EventTracker.class)).whiteScreen(TrackId.ERROR_WHITE_SCREEN, "N21629", hashMap);
                        String logTag = V8Worker.this.getLogTag();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Failed to initialize V8Worker, lastTrack=");
                        sb3.append(V8Worker.this.mLastTrackId);
                        sb3.append(", workerReady=");
                        sb3.append(String.valueOf(V8Worker.this.isWorkerReady()));
                        sb3.append(", renderReady=");
                        sb3.append(String.valueOf(V8Worker.this.isRenderReady()));
                        sb3.append(", workerMsg=");
                        sb3.append(String.valueOf(V8Worker.this.mGotMsgFromWorker));
                        sb3.append(", renderMsg=");
                        sb3.append(String.valueOf(V8Worker.this.mGotMsgFromRender));
                        RVLogger.e(logTag, sb3.toString());
                        V8Worker.this.trackStub("V8_StartupFailed", true);
                        String logTag2 = V8Worker.this.getLogTag();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("mCleanupOnInitTimeout=");
                        sb4.append(V8Worker.this.mCleanupOnInitTimeout);
                        RVLogger.e(logTag2, sb4.toString());
                        if (V8Worker.this.mCleanupOnInitTimeout) {
                            V8Worker.this.terminate();
                        }
                    }
                }
            };
            trackStub("V8_Preparing");
            ExecutorUtils.runOnMain(this.mTimeoutRunnable, intConfig * 1000);
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        HandlerThread prepareWorkerThread = prepareWorkerThread();
        Map<String, HandlerThread> map = jsi2handlerThread;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(app.getAppId());
        sb3.append(app.getStartToken());
        map.put(sb3.toString(), prepareWorkerThread);
        this.mHandlerThread = prepareWorkerThread;
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        if (v8Proxy != null) {
            v8Proxy.addAssociatedThread(this.mHandlerThread.getName());
        } else {
            String str2 = this.mTag;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("v8Proxy is null, V8Worker Thread will be controlled: ");
            sb4.append(this.mHandlerThread.getName());
            RVLogger.e(str2, sb4.toString());
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            RVLogger.e(getLogTag(), "*** ANR WARNING *** DO NOT instantiate V8Worker on main thread");
        }
        V8WorkerExtension v8WorkerExtension = new V8WorkerExtension(this);
        ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
        extensionManager.registerExtensionByPoint(this.mApp, AppPausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, AppResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PagePausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageEnterPoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageExitPoint.class, v8WorkerExtension);
        readConfigServiceSwitch();
        initJsApiCache();
        long currentTimeMillis = System.currentTimeMillis();
        trackStub("V8_InitJSEngine");
        boolean staticInit = staticInit();
        sV8Type = "UC";
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!staticInit) {
            trackStub("V8_InitJSEngineFailed", true);
            throw new IllegalStateException("Failed to initialize JSEngine.");
        }
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Initialize JSEngine cost = ");
        sb5.append(currentTimeMillis2 - currentTimeMillis);
        RVLogger.d(logTag, sb5.toString());
        trackStub("V8_createJsiInstance");
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.2
            {
                V8Worker.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                V8Worker v8Worker = V8Worker.this;
                v8Worker.createJsiInstance(v8Worker.mAppId, V8Worker.this.mHandlerThread.getThreadId());
            }
        });
        if (isMessageChannelEnabled()) {
            registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.ariver.v8worker.V8Worker.3
                {
                    V8Worker.this = this;
                }

                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    Render renderById = V8Worker.this.mApp.getEngineProxy().getEngineRouter().getRenderById(null);
                    if (renderById != null) {
                        V8Worker.this.prepareMessageChannel((Page) renderById.getPage());
                    }
                }
            });
        }
    }

    public boolean isInvalid() {
        return this.mInvalid;
    }

    public boolean isWorkerPoolPreInitSuccess() {
        return this.mWorkerPoolPreInitSuccess;
    }

    public static void clearHandlerThread(App app) {
        StringBuilder sb = new StringBuilder();
        sb.append(app.getAppId());
        sb.append(app.getStartToken());
        HandlerThread remove = jsi2handlerThread.remove(sb.toString());
        if (Build.VERSION.SDK_INT >= 18) {
            remove.quitSafely();
        } else {
            remove.quit();
        }
    }

    public V8Worker(App app, String str, List<PluginModel> list, HandlerThread handlerThread, CountDownLatch countDownLatch) {
        this.mAlipayJSBridgeReady = false;
        this.mWorkerPushed = false;
        this.mUseSandboxContext = false;
        this.mAppxContextInitLock = new Object();
        this.mBizContextInitLock = new Object();
        this.mAppxJsContextReady = false;
        this.mBizJsContextReady = false;
        this.mIscompletePreload = false;
        this.mExiting = false;
        this.mLoadedPlugins = new HashSet();
        this.mPaused = false;
        this.mPauseTimer = null;
        this.mTitleBarClose = false;
        this.mLeaveHintStatus = false;
        this.mGotMsgFromRender = false;
        this.mGotMsgFromWorker = false;
        this.mV8CallingId = 1L;
        this.mJSIThreadTid = 0;
        this.mJSIWatchDogHandler = null;
        this.mJSIWatchDogHandlerThread = null;
        this.mInitWatchDog = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.25
            {
                V8Worker.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.mJSIThreadTid != 0) {
                    String logTag = V8Worker.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("******** WARNING ******** JSI init timeout in tid: ");
                    sb.append(V8Worker.this.mJSIThreadTid);
                    RVLogger.e(logTag, sb.toString());
                    V8Worker v8Worker = V8Worker.this;
                    String generateStack = v8Worker.generateStack(v8Worker.mJSIThreadTid);
                    if (generateStack == null || !generateStack.startsWith("/")) {
                        return;
                    }
                    String readSmallFile = V8Worker.this.readSmallFile(generateStack);
                    String logTag2 = V8Worker.this.getLogTag();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("JSI thread stack is: ");
                    sb2.append(readSmallFile);
                    RVLogger.e(logTag2, sb2.toString());
                }
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append("V8Worker_JSI_");
        sb.append(V8_WORKER_INDEX);
        this.mTag = sb.toString();
        this.mApp = app;
        this.mInitLock = countDownLatch;
        this.mUserAgent = str;
        this.mAppId = app.getAppId();
        this.mPluginModelList = list;
        if (app != null) {
            this.mParentId = BundleUtils.getString(getStartupParams(), RVParams.START_APP_SESSION_ID);
            this.mIscompletePreload = "yes".equals(BundleUtils.getString(this.mApp.getStartParams(), "CompletePreload", ""));
            if (TextUtils.isEmpty(this.mParentId)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mAppId);
                sb2.append("_V8Worker_");
                sb2.append(app.getNodeId());
                sb2.append("_");
                sb2.append(System.currentTimeMillis());
                this.mParentId = sb2.toString();
            }
        }
        final int intConfig = V8Utils.getIntConfig("ta_v8WorkerInitExpires", 15);
        if (!RVKernelUtils.isDebug() && intConfig > 0) {
            this.mTimeoutRunnable = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.4
                {
                    V8Worker.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (V8Worker.this.mApp != null && (V8Worker.this.mApp.isDestroyed() || V8Worker.this.mApp.isExited())) {
                        RVLogger.e(V8Worker.this.mTag, "mApp isDestroyed");
                    } else if (V8Worker.this.isWorkerTimeOut()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", IAPSyncCommand.COMMAND_INIT);
                        hashMap.put("message", "V8Worker initializing timeout");
                        hashMap.put("expires", String.valueOf(intConfig));
                        hashMap.put("lastTrack", V8Worker.this.mLastTrackId);
                        hashMap.put("workerReady", String.valueOf(V8Worker.this.isWorkerReady()));
                        hashMap.put("renderReady", String.valueOf(V8Worker.this.isRenderReady()));
                        hashMap.put("workerMsg", String.valueOf(V8Worker.this.mGotMsgFromWorker));
                        hashMap.put("renderMsg", String.valueOf(V8Worker.this.mGotMsgFromRender));
                        ((EventTracker) RVProxy.get(EventTracker.class)).whiteScreen(TrackId.ERROR_WHITE_SCREEN, "N21629", hashMap);
                        String logTag = V8Worker.this.getLogTag();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Failed to initialize V8Worker, lastTrack=");
                        sb3.append(V8Worker.this.mLastTrackId);
                        sb3.append(", workerReady=");
                        sb3.append(String.valueOf(V8Worker.this.isWorkerReady()));
                        sb3.append(", renderReady=");
                        sb3.append(String.valueOf(V8Worker.this.isRenderReady()));
                        sb3.append(", workerMsg=");
                        sb3.append(String.valueOf(V8Worker.this.mGotMsgFromWorker));
                        sb3.append(", renderMsg=");
                        sb3.append(String.valueOf(V8Worker.this.mGotMsgFromRender));
                        RVLogger.e(logTag, sb3.toString());
                        V8Worker.this.trackStub("V8_StartupFailed", true);
                        String logTag2 = V8Worker.this.getLogTag();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("mCleanupOnInitTimeout=");
                        sb4.append(V8Worker.this.mCleanupOnInitTimeout);
                        RVLogger.e(logTag2, sb4.toString());
                        if (V8Worker.this.mCleanupOnInitTimeout) {
                            V8Worker.this.terminate();
                        }
                    }
                }
            };
            trackStub("V8_Preparing");
            ExecutorUtils.runOnMain(this.mTimeoutRunnable, intConfig * 1000);
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (handlerThread == null) {
            HandlerThread prepareWorkerThread = prepareWorkerThread();
            Map<String, HandlerThread> map = jsi2handlerThread;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(app.getAppId());
            sb3.append(app.getStartToken());
            map.put(sb3.toString(), prepareWorkerThread);
            this.mHandlerThread = prepareWorkerThread;
        } else {
            this.mHandlerThread = handlerThread;
        }
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        if (v8Proxy != null) {
            v8Proxy.addAssociatedThread(this.mHandlerThread.getName());
        } else {
            String str2 = this.mTag;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("v8Proxy is null, V8Worker Thread will be controlled: ");
            sb4.append(this.mHandlerThread.getName());
            RVLogger.e(str2, sb4.toString());
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            RVLogger.e(getLogTag(), "*** ANR WARNING *** DO NOT instantiate V8Worker on main thread");
        }
        V8WorkerExtension v8WorkerExtension = new V8WorkerExtension(this);
        ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
        extensionManager.registerExtensionByPoint(this.mApp, AppPausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, AppResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PagePausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageEnterPoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageExitPoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, AppLeaveHintPoint.class, v8WorkerExtension);
        readConfigServiceSwitch();
        initJsApiCache();
        long currentTimeMillis = System.currentTimeMillis();
        trackStub("V8_InitJSEngine");
        RVTraceUtils.traceBeginSection("V8_InitJSEngine");
        boolean staticInit = staticInit();
        RVTraceUtils.traceEndSection("V8_InitJSEngine");
        sV8Type = "UC";
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!staticInit) {
            trackStub("V8_InitJSEngineFailed", true);
            throw new IllegalStateException("Failed to initialize JSEngine.");
        }
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Initialize JSEngine cost = ");
        sb5.append(currentTimeMillis2 - currentTimeMillis);
        RVLogger.d(logTag, sb5.toString());
        trackStub("V8_createJsiInstance");
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.5
            {
                V8Worker.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                RVTraceUtils.traceBeginSection("createJsiInstance");
                V8Worker v8Worker = V8Worker.this;
                v8Worker.createJsiInstance(v8Worker.mAppId, V8Worker.this.mHandlerThread.getThreadId());
                RVTraceUtils.traceEndSection("createJsiInstance");
            }
        });
        if (isMessageChannelEnabled()) {
            registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.ariver.v8worker.V8Worker.6
                {
                    V8Worker.this = this;
                }

                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    Render renderById = V8Worker.this.mApp.getEngineProxy().getEngineRouter().getRenderById(null);
                    if (renderById != null) {
                        V8Worker.this.prepareMessageChannel((Page) renderById.getPage());
                    }
                }
            });
        }
    }

    public V8Worker(String str, HandlerThread handlerThread) {
        this.mAlipayJSBridgeReady = false;
        this.mWorkerPushed = false;
        this.mUseSandboxContext = false;
        this.mAppxContextInitLock = new Object();
        this.mBizContextInitLock = new Object();
        this.mAppxJsContextReady = false;
        this.mBizJsContextReady = false;
        this.mIscompletePreload = false;
        this.mExiting = false;
        this.mLoadedPlugins = new HashSet();
        this.mPaused = false;
        this.mPauseTimer = null;
        this.mTitleBarClose = false;
        this.mLeaveHintStatus = false;
        this.mGotMsgFromRender = false;
        this.mGotMsgFromWorker = false;
        this.mV8CallingId = 1L;
        this.mJSIThreadTid = 0;
        this.mJSIWatchDogHandler = null;
        this.mJSIWatchDogHandlerThread = null;
        this.mInitWatchDog = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.25
            {
                V8Worker.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.mJSIThreadTid != 0) {
                    String logTag = V8Worker.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("******** WARNING ******** JSI init timeout in tid: ");
                    sb.append(V8Worker.this.mJSIThreadTid);
                    RVLogger.e(logTag, sb.toString());
                    V8Worker v8Worker = V8Worker.this;
                    String generateStack = v8Worker.generateStack(v8Worker.mJSIThreadTid);
                    if (generateStack == null || !generateStack.startsWith("/")) {
                        return;
                    }
                    String readSmallFile = V8Worker.this.readSmallFile(generateStack);
                    String logTag2 = V8Worker.this.getLogTag();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("JSI thread stack is: ");
                    sb2.append(readSmallFile);
                    RVLogger.e(logTag2, sb2.toString());
                }
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append("V8Worker_JSI_");
        sb.append(V8_WORKER_INDEX);
        String obj = sb.toString();
        this.mTag = obj;
        RVLogger.d(obj, "poolWorker V8Worker create");
        this.mUserAgent = str;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (handlerThread == null) {
            this.mHandlerThread = prepareWorkerThread();
        } else {
            this.mHandlerThread = handlerThread;
        }
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        if (v8Proxy != null) {
            v8Proxy.addAssociatedThread(this.mHandlerThread.getName());
        } else {
            String str2 = this.mTag;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("poolWorker v8Proxy is null, V8Worker Thread will be controlled: ");
            sb2.append(this.mHandlerThread.getName());
            RVLogger.e(str2, sb2.toString());
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            RVLogger.e(getLogTag(), "poolWorker *** ANR WARNING *** DO NOT instantiate V8Worker on main thread");
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean staticInit = staticInit();
        sV8Type = "UC";
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!staticInit) {
            throw new IllegalStateException("poolWorker Failed to initialize JSEngine.");
        }
        String logTag = getLogTag();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("poolWorker Initialize JSEngine cost = ");
        sb3.append(currentTimeMillis2 - currentTimeMillis);
        RVLogger.d(logTag, sb3.toString());
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.7
            {
                V8Worker.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                V8Worker v8Worker = V8Worker.this;
                v8Worker.createJsiInstance(v8Worker.mHandlerThread.getThreadId());
            }
        });
    }

    public void createJsiInstance(int i) {
        RVLogger.d(TAG, "poolWorker createJsiInstance");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        startWatchDog();
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        Bundle bundle = new Bundle();
        String config = V8Utils.getConfig("jsiFlags", "");
        if (!TextUtils.isEmpty(config)) {
            bundle.putString("flags", config);
            V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
            String packageName = v8Proxy != null ? v8Proxy.getPackageName() : "Alipay";
            int myPid = Process.myPid();
            StringBuilder sb = new StringBuilder();
            sb.append(packageName);
            sb.append("-JSEngine-");
            sb.append(Calendar.getInstance().getTimeInMillis());
            sb.append("-");
            sb.append(myPid);
            sb.append("-");
            sb.append(i);
            String obj = sb.toString();
            this.mAppxJSEngineName = obj;
            bundle.putString("name", obj);
            bundle.putString("version", "1.0");
            this.mJSEngine = JSEngine.createInstance(applicationContext, bundle, this.mHandler);
            if (RVKernelUtils.isDebug()) {
                this.mJSEngine.setEnableStats(true);
            }
            this.mJSContext = this.mJSEngine.createContext(APPX_JS_CONTEXT);
            this.mEngineScope = new EngineScope(this.mJSEngine);
            removeObj(this.mJSContext);
            stopWatchDog();
            if (this.mExiting) {
                terminate();
                return;
            }
            registerJSExceptionListener();
            this.mJsTimer = new JsTimers(this.mJSContext, this.mHandler, this);
            this.mImportScriptsCallback = new ImportScriptsCallback(this);
            JSObject globalObject = this.mJSContext.globalObject();
            JSFunction jSFunction = new JSFunction(this.mJSContext, new AsyncJSCallback(this), "__nativeFlushQueue__");
            globalObject.set(this.mJSContext, "__nativeFlushQueue__", jSFunction);
            jSFunction.delete();
            JSFunction jSFunction2 = new JSFunction(this.mJSContext, this.mImportScriptsCallback, "importScripts");
            globalObject.set(this.mJSContext, "importScripts", jSFunction2);
            jSFunction2.delete();
            if (V8Utils.getBooleanConfig("ta_v8DynamicNativePlugins", true)) {
                JSFunction jSFunction3 = new JSFunction(this.mJSContext, new JSCallback() { // from class: com.alibaba.ariver.v8worker.V8Worker.8
                    {
                        V8Worker.this = this;
                    }

                    @Override // com.alibaba.jsi.standard.js.JSCallback
                    public JSValue onCallFunction(Arguments arguments) {
                        try {
                            return new JSBoolean(V8Worker.this.loadNativePlugins(arguments));
                        } catch (Throwable th) {
                            RVLogger.e(V8Worker.this.getLogTag(), "poolWorker onCallFunction error: ", th);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(V8Worker.WORKER_POOL);
                            sb2.append("onCallFunction error: ");
                            sb2.append(JsErrorAssist.getStackTraceString(th));
                            JsErrorAssist.postJsErrorMessage(V8Worker.this.mApp, sb2.toString());
                            return null;
                        }
                    }
                }, "__nativeLoadPlugins__");
                globalObject.set(this.mJSContext, "__nativeLoadPlugins__", jSFunction3);
                jSFunction3.delete();
            }
            MultiThreadWorkerCallback multiThreadWorkerCallback = new MultiThreadWorkerCallback(this);
            this.mMultiThreadWorkerCallback = multiThreadWorkerCallback;
            JSFunction jSFunction4 = new JSFunction(this.mJSContext, multiThreadWorkerCallback, "__nativeCreateWorker__");
            globalObject.set(this.mJSContext, "__nativeCreateWorker__", jSFunction4);
            jSFunction4.delete();
            globalObject.set(this.mJSContext, "self", globalObject);
            RVLogger.e(getLogTag(), "poolWorker createJsiInstance start loading worker js bridge");
            doExecuteScript(V8Utils.readRawFile(applicationContext, R.raw.workerjs_v8), "https://appx/v8.worker.js", this.mJSContext);
            try {
                this.mImportScriptsFunc = (JSFunction) globalObject.get(this.mJSContext, "importScripts");
                JSObject jSObject = (JSObject) globalObject.get(this.mJSContext, "AlipayJSBridge");
                this.mAlipayJSBridgeObj = jSObject;
                this.mInvokeJSFunc = (JSFunction) jSObject.get(this.mJSContext, "_invokeJS");
            } catch (Throwable th) {
                String logTag = getLogTag();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("poolWorker createJsiInstance doInitWorker exception: ");
                sb2.append(th);
                RVLogger.e(logTag, sb2.toString());
            }
            globalObject.delete();
            this.mV8InstanceCost = SystemClock.elapsedRealtime() - elapsedRealtime;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enablePolyfillWorker", (Object) Boolean.TRUE);
            jSONObject.put("apiMessageChannel", (Object) "console");
            jSONObject.put(GriverParam.IS_V8_WORKER, (Object) SummaryActivity.CHECKED);
            WorkerInitInjector.getInitInjectAppXStartParams(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("userAgent", (Object) getUserAgent());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("var navigator=");
            sb3.append(jSONObject2.toJSONString());
            sb3.append(";");
            String obj2 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj2);
            sb4.append("var __appxStartupParams=");
            sb4.append(jSONObject.toJSONString());
            sb4.append(";");
            String obj3 = sb4.toString();
            if (RVKernelUtils.isDebug()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(obj3);
                sb5.append(V8Utils.getConfig("ta_preExecJs", ""));
                sb5.append(";");
                obj3 = sb5.toString();
            }
            String logTag2 = getLogTag();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("poolWorker v8 init inject string: ");
            sb6.append(obj3);
            RVLogger.d(logTag2, sb6.toString());
            doExecuteScript(obj3, null, this.mJSContext);
            setAppxJsContextReady();
            long currentTimeMillis = System.currentTimeMillis();
            String appxWorkerJSbyPool = getAppxWorkerJSbyPool();
            this.mAppxResCost = System.currentTimeMillis() - currentTimeMillis;
            if (!TextUtils.isEmpty(appxWorkerJSbyPool)) {
                this.mAppxLoaded = true;
                try {
                    setAppxVersionInWorker(appxWorkerJSbyPool.substring(0, 100).split("\\r?\\n")[2].substring(3));
                    RVLogger.d(getLogTag(), "poolWorker getAppxWorkerJSbyPool and setAppxVersionInWorker");
                } catch (Throwable unused) {
                    String logTag3 = getLogTag();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("poolWorker Catch");
                    sb7.append(getAppxWorkerJsUrl());
                    sb7.append("Exception");
                    RVLogger.d(logTag3, sb7.toString());
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                if (this.mIscompletePreload) {
                    RVLogger.e(getLogTag(), "poolWorker jsi worker is mIscompletePreload do not doExecuteScript return and terminate");
                    terminate();
                    return;
                }
                doExecuteScript(appxWorkerJSbyPool, getAppxWorkerJsUrl(), this.mJSContext);
                this.mAppxWorkerJsCost = SystemClock.elapsedRealtime() - elapsedRealtime2;
                String logTag4 = getLogTag();
                StringBuilder sb8 = new StringBuilder();
                sb8.append("poolWorker createJsiInstance Successfully pre-execute ");
                sb8.append(getAppxWorkerJsUrl());
                sb8.append(", cost = ");
                sb8.append(this.mAppxWorkerJsCost);
                RVLogger.d(logTag4, sb8.toString());
            } else {
                String logTag5 = getLogTag();
                StringBuilder sb9 = new StringBuilder();
                sb9.append("poolWorker createJsiInstance Failed to pre-execute ");
                sb9.append(getAppxWorkerJsUrl());
                RVLogger.e(logTag5, sb9.toString());
                RVLogger.d(TAG, "poolWorker poolWorker createJsiInstance isInvalid");
                destroy();
                this.mInvalid = true;
            }
            JSContext tryPreCreateBizJsContext = tryPreCreateBizJsContext(APP_BIZ_JS_CONTEXT);
            this.mBizJSContext = tryPreCreateBizJsContext;
            if (tryPreCreateBizJsContext != null) {
                RVLogger.d(getLogTag(), "poolWorker setBizContextReady");
                setBizJsContextReady();
            }
            this.mWorkerPoolPreInitSuccess = true;
            RVLogger.d(TAG, "poolWorker poolWorker createJsiInstance finish");
            return;
        }
        stopWatchDog();
    }

    protected String getAppxWorkerJSbyPool() {
        byte[] bytes;
        RVLogger.d(getLogTag(), "poolWorker start getAppxWorkerJSbyPool");
        String clientExtendConfig = EngineUtils.getClientExtendConfig();
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("poolWorker v8 extend config: ");
        sb.append(clientExtendConfig);
        RVLogger.d(logTag, sb.toString());
        doExecuteScript(clientExtendConfig, "CLIENT_EXTEND_CONFIG", this.mJSContext);
        ResourceLoadContext build = ResourceLoadContext.newBuilder().canUseFallback(true).originUrl(getAppxWorkerJsUrl()).build();
        ResourceQuery canUseFallback = ResourceQuery.asUrl(build.originUrl).setCanUseFallback(build.canUseFallback);
        canUseFallback.setAppxNgRoute(true);
        canUseFallback.setMainDoc(build.isMainDoc);
        canUseFallback.pureUrl = canUseFallback.pureUrl.replace(ContentProviderImpl.TINY_RES_HOST, ContentProviderImpl.APPX_NG_TINY_RES_HOST);
        Resource resource = GlobalPackagePool.getInstance().get(canUseFallback);
        if (resource != null && (bytes = resource.getBytes()) != null && bytes.length != 0) {
            RVLogger.d(getLogTag(), "poolWorker get getAppxWorkerJS success");
            return new String(bytes);
        }
        RVLogger.d(getLogTag(), "poolWorker get getAppxWorkerJS is null");
        return null;
    }

    public void setAppToWorker(App app, String str, String str2, CountDownLatch countDownLatch) {
        RVLogger.d(TAG, "poolWorker enter setAppInfoToWorker");
        this.mApp = app;
        this.mAppId = app.getAppId();
        this.mWorkerId = str;
        this.mImportScriptsCallback.setApp(app);
        this.mInitLock = countDownLatch;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mTag);
        sb.append("_");
        sb.append(this.mApp.getAppId());
        this.mTag = sb.toString();
        this.mApp.putBooleanValue("appxRouteWorker", true);
        initAfterApp(app);
    }

    public void initAfterApp(App app) {
        RVLogger.d(getLogTag(), "poolWorker enter initAfterApp");
        if (app != null) {
            this.mParentId = BundleUtils.getString(getStartupParams(), RVParams.START_APP_SESSION_ID);
            this.mIscompletePreload = "yes".equals(BundleUtils.getString(this.mApp.getStartParams(), "CompletePreload", ""));
            if (TextUtils.isEmpty(this.mParentId)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.mAppId);
                sb.append("_V8Worker_");
                sb.append(app.getNodeId());
                sb.append("_");
                sb.append(System.currentTimeMillis());
                this.mParentId = sb.toString();
            }
        }
        final int intConfig = V8Utils.getIntConfig("ta_v8WorkerInitExpires", 15);
        if (!RVKernelUtils.isDebug() && intConfig > 0) {
            this.mTimeoutRunnable = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.9
                {
                    V8Worker.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (V8Worker.this.mApp != null && (V8Worker.this.mApp.isDestroyed() || V8Worker.this.mApp.isExited())) {
                        RVLogger.e(V8Worker.this.mTag, "mApp isDestroyed");
                    } else if (V8Worker.this.isWorkerTimeOut()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", IAPSyncCommand.COMMAND_INIT);
                        hashMap.put("message", "V8Worker initializing timeout");
                        hashMap.put("expires", String.valueOf(intConfig));
                        hashMap.put("lastTrack", V8Worker.this.mLastTrackId);
                        hashMap.put("workerReady", String.valueOf(V8Worker.this.isWorkerReady()));
                        hashMap.put("renderReady", String.valueOf(V8Worker.this.isRenderReady()));
                        hashMap.put("workerMsg", String.valueOf(V8Worker.this.mGotMsgFromWorker));
                        hashMap.put("renderMsg", String.valueOf(V8Worker.this.mGotMsgFromRender));
                        ((EventTracker) RVProxy.get(EventTracker.class)).whiteScreen(TrackId.ERROR_WHITE_SCREEN, "N21629", hashMap);
                        String logTag = V8Worker.this.getLogTag();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("poolWorker Failed to initialize V8Worker, lastTrack=");
                        sb2.append(V8Worker.this.mLastTrackId);
                        sb2.append(", workerReady=");
                        sb2.append(String.valueOf(V8Worker.this.isWorkerReady()));
                        sb2.append(", renderReady=");
                        sb2.append(String.valueOf(V8Worker.this.isRenderReady()));
                        sb2.append(", workerMsg=");
                        sb2.append(String.valueOf(V8Worker.this.mGotMsgFromWorker));
                        sb2.append(", renderMsg=");
                        sb2.append(String.valueOf(V8Worker.this.mGotMsgFromRender));
                        RVLogger.e(logTag, sb2.toString());
                        V8Worker.this.trackStub("V8_StartupFailed", true);
                        String logTag2 = V8Worker.this.getLogTag();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("poolWorker mCleanupOnInitTimeout=");
                        sb3.append(V8Worker.this.mCleanupOnInitTimeout);
                        RVLogger.e(logTag2, sb3.toString());
                        if (V8Worker.this.mCleanupOnInitTimeout) {
                            V8Worker.this.terminate();
                        }
                    }
                }
            };
            trackStub("V8_Preparing");
            ExecutorUtils.runOnMain(this.mTimeoutRunnable, intConfig * 1000);
        }
        V8WorkerExtension v8WorkerExtension = new V8WorkerExtension(this);
        ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
        extensionManager.registerExtensionByPoint(this.mApp, AppPausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, AppResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PagePausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageEnterPoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageExitPoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, AppLeaveHintPoint.class, v8WorkerExtension);
        readConfigServiceSwitch();
        initJsApiCache();
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.10
            {
                V8Worker.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                RVTraceUtils.traceBeginSection("createJsiInstanceAfterApp");
                V8Worker.this.createJsiInstanceAfterApp();
                RVTraceUtils.traceEndSection("createJsiInstanceAfterApp");
            }
        });
        if (isMessageChannelEnabled()) {
            registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.ariver.v8worker.V8Worker.11
                {
                    V8Worker.this = this;
                }

                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    Render renderById = V8Worker.this.mApp.getEngineProxy().getEngineRouter().getRenderById(null);
                    if (renderById != null) {
                        V8Worker.this.prepareMessageChannel((Page) renderById.getPage());
                    }
                }
            });
        }
    }

    public void createJsiInstanceAfterApp() {
        RVLogger.d(getLogTag(), "poolWorker enter createJsiInstanceAfterApp");
        RVTraceUtils.traceBeginSection("createJsiInstanceAfterApp_beforeWaitOnInitSuccess");
        String version = JSEngine.getVersion();
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("poolWorker jsi version: ");
        sb.append(version);
        RVLogger.d(logTag, sb.toString());
        EventTrackStore eventTrackStore = (EventTrackStore) this.mApp.getData(EventTrackStore.class, true);
        if (eventTrackStore != null && eventTrackStore.fullLinkAttrMap != null) {
            eventTrackStore.fullLinkAttrMap.put("jsiVersion", version);
        }
        if (!RVKernelUtils.isDebug()) {
            JSConsole.setup(this.mJSContext, getJSConsoleCallback(), getAppId());
        }
        this.mJsApiHandler = new JsApiHandler(this.mApp, this);
        RVTraceUtils.traceEndSection("createJsiInstanceAfterApp_beforeWaitOnInitSuccess");
        onAlipayJSBridgeReady();
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public String getLogTag() {
        return this.mTag;
    }

    public boolean isAppxLoaded() {
        return this.mAppxLoaded;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public App getApp() {
        return this.mApp;
    }

    public String getAppxJSEngineName() {
        return this.mAppxJSEngineName;
    }

    private void readConfigServiceSwitch() {
        this.mEnableMessageChannel = V8Utils.getBooleanConfig("ta_v8WorkerMC", true) && !V8Utils.isAppIdInList("ta_v8WorkerMCBlackList", this.mAppId, false);
        this.mFullLogMsg = V8Utils.isAppIdInList("ta_fullLogMsgWhiteList", this.mAppId, false);
        this.mEnableArrayBuffer = V8Utils.getBooleanConfig("ta_v8WorkerAB", true);
        this.mSyncLoadPlugin = V8Utils.getBooleanConfig("ta_v8WorkerSyncLoadPlugin", true);
        if (V8Utils.isAppIdInList("ta_PwrConAppIdList", this.mAppId, false)) {
            this.mPauseTimerDelay = 0;
            this.mKeepTimer = false;
        } else {
            this.mPauseTimerDelay = V8Utils.getIntConfig("ta_pauseTimerDelay", 8);
            this.mKeepTimer = shouldKeepTimer();
        }
        this.mCleanupOnInitTimeout = V8Utils.getBooleanConfig("ta_v8WorkerCleanupOnInitTimeout", false);
        JSONObject configJSONObject = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("h5_jscWorkerSleepConfig");
        this.mEnableTinyBackgroundSleep = "yes".equalsIgnoreCase(JSONUtils.getString(configJSONObject, "enableTinyBackgroundSleep", "yes"));
        this.mTinyBackgroundSleepDelay = JSONUtils.getLong(configJSONObject, "tinyBackgroundSleepDelay", 8L);
        this.mEnableKeepAliveSleep = "yes".equalsIgnoreCase(JSONUtils.getString(configJSONObject, "enableKeepAliveSleep", "yes"));
        this.mKeepAliveSleepDelay = JSONUtils.getLong(configJSONObject, "keepAliveSleepDelay", 8L);
        this.mEnableClientBackgroundSleep = "yes".equalsIgnoreCase(JSONUtils.getString(configJSONObject, "enableClientBackgroundSleep", "yes"));
        this.mClientBackgroundSleepDelay = JSONUtils.getLong(configJSONObject, "clientBackgroundSleepDelay", 8L);
        String str = this.mTag;
        StringBuilder sb = new StringBuilder();
        sb.append("mKeepTimer = ");
        sb.append(this.mKeepTimer);
        sb.append(", mPauseTimerDelay = ");
        sb.append(this.mPauseTimerDelay);
        sb.append(", mCleanupOnInitTimeout: ");
        sb.append(this.mCleanupOnInitTimeout);
        RVLogger.d(str, sb.toString());
    }

    private boolean shouldKeepTimer() {
        if (V8Utils.isAppIdInList("ta_keepTimerAppBlackList", this.mAppId, false)) {
            String logTag = getLogTag();
            StringBuilder sb = new StringBuilder();
            sb.append(this.mAppId);
            sb.append(" in ta_keepTimerAppBlackList");
            RVLogger.w(logTag, sb.toString());
            return false;
        }
        boolean isAppIdInList = V8Utils.isAppIdInList("ta_keepTimerAppWhiteList", this.mAppId, false);
        if (isAppIdInList) {
            String logTag2 = getLogTag();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mAppId);
            sb2.append(" in ta_keepTimerAppWhiteList");
            RVLogger.w(logTag2, sb2.toString());
        }
        return isAppIdInList;
    }

    static String getUCSoPath(V8Proxy v8Proxy) {
        String webViewCoreSoPath = v8Proxy.getWebViewCoreSoPath();
        if (TextUtils.isEmpty(webViewCoreSoPath) || webViewCoreSoPath.contains(LIB_WEBVIEW_UC_SO)) {
            return webViewCoreSoPath;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(webViewCoreSoPath);
        sb.append("/libwebviewuc.so");
        return sb.toString();
    }

    public static void createSymLink(String str, File file) {
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append("symlink ");
        sb.append(str);
        sb.append(" => ");
        sb.append(absolutePath);
        RVLogger.e(TAG, sb.toString());
        try {
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Os.symlink(str, absolutePath);
                return;
            }
            Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField(H5GetLogInfoBridge.RESULT_OS);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            obj.getClass().getMethod("symlink", String.class, String.class).invoke(obj, str, absolutePath);
        } catch (Exception unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("failed to symlink ");
            sb2.append(str);
            sb2.append(" => ");
            sb2.append(absolutePath);
            throw new IllegalStateException(sb2.toString());
        }
    }

    private static File createLoadingFlagIfNeeded(Context context) {
        if (V8Utils.getIntConfig("ta_jsi_verify_webviewcore", 1) != 1) {
            return null;
        }
        File file = new File(context.getFilesDir(), "jsi_loading_libwebviewuc_so");
        try {
            file.createNewFile();
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            sb.append(" creating success");
            RVLogger.d(TAG, sb.toString());
            return file;
        } catch (Throwable th) {
            RVLogger.e(TAG, "createLoadingFlagIfNeeded", th);
            return null;
        }
    }

    private static void removeLoadingFlagIfExists(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            file.delete();
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            sb.append(" deleting success");
            RVLogger.d(TAG, sb.toString());
        } catch (Throwable th) {
            RVLogger.e(TAG, "removeLoadingFlagIfExists", th);
        }
    }

    public static HandlerThread prepareWorkerThread() {
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("jsi-worker-jsapi-");
        sb.append(myPid);
        sb.append("-");
        int i = V8_WORKER_INDEX;
        V8_WORKER_INDEX = i + 1;
        sb.append(i);
        HandlerThread handlerThread = new HandlerThread(sb.toString());
        handlerThread.start();
        return handlerThread;
    }

    public static boolean staticInit() {
        boolean z;
        try {
            AtomicBoolean atomicBoolean = sJSEngineInitialized;
            synchronized (atomicBoolean) {
                Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Bundle bundle = new Bundle();
                try {
                    byte b = (byte) (BuiltInFictitiousFunctionClassFactory & 1);
                    byte b2 = getAuthRequestContext[41];
                    Object[] objArr = new Object[1];
                    j(b, b2, (byte) (b2 + 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = getAuthRequestContext[41];
                    Object[] objArr2 = new Object[1];
                    j(b3, (byte) (b3 + 1), getAuthRequestContext[41], objArr2);
                    bundle.putString("jsiSoPath", new File(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(applicationContext, null)).nativeLibraryDir, "libjsi-qjs-6.so").getAbsolutePath());
                    bundle.putString("jsEngineSoPath", null);
                    bundle.putString("engineType", "qjs");
                    File createLoadingFlagIfNeeded = createLoadingFlagIfNeeded(applicationContext);
                    sJSEngineInitResult = JSEngine.loadSo(applicationContext, bundle);
                    removeLoadingFlagIfExists(createLoadingFlagIfNeeded);
                    System.loadLibrary("ea7221");
                    sJSEngineInitCost = SystemClock.elapsedRealtime() - elapsedRealtime;
                    StringBuilder sb = new StringBuilder();
                    sb.append("staticInit JSEngine.loadSo result: ");
                    sb.append(atomicBoolean);
                    sb.append(" cost: ");
                    sb.append(sJSEngineInitCost);
                    RVLogger.d(TAG, sb.toString());
                    z = sJSEngineInitResult;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            return z;
        } catch (Throwable th2) {
            RVLogger.e(TAG, "staticInit failed: ", th2);
            return false;
        }
    }

    public static void addV8WorkerInitFinished(final V8WorkerInitFinishedListener v8WorkerInitFinishedListener) {
        synchronized (V8Worker.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("add V8Worker init finished listener,");
            sb.append(v8WorkerInitFinishedListener);
            RVLogger.d(TAG, sb.toString());
            if (sJSEngineInitResult) {
                ExecutorUtils.runNotOnMain(ExecutorType.IDLE, new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        v8WorkerInitFinishedListener.afterV8WorkerInit(true);
                    }
                });
            } else {
                sV8WorkerInitFinishedListener.add(v8WorkerInitFinishedListener);
            }
        }
    }

    public static boolean isStaticInited() {
        return sJSEngineInitialized.get() && sJSEngineInitResult;
    }

    protected boolean isWorkerTimeOut() {
        return (isWorkerReady() && isRenderReady() && this.mGotMsgFromRender && this.mGotMsgFromWorker) ? false : true;
    }

    public boolean isAppxJsContextReady() {
        return this.mAppxJsContextReady;
    }

    public boolean isBizContextReady() {
        return this.mBizJsContextReady;
    }

    public void registerAppxContextInitListener(Worker.JsContextReadyListener jsContextReadyListener) {
        boolean z;
        synchronized (this.mAppxContextInitLock) {
            if (this.mAppxJsContextReady) {
                z = true;
            } else {
                if (this.mAppxJsContextInitListeners == null) {
                    this.mAppxJsContextInitListeners = new ArrayList();
                }
                if (jsContextReadyListener != null && !this.mAppxJsContextInitListeners.contains(jsContextReadyListener)) {
                    this.mAppxJsContextInitListeners.add(jsContextReadyListener);
                }
                z = false;
            }
        }
        if (z) {
            jsContextReadyListener.onJsContextReady();
        }
    }

    public void registerBizJsContextInitListener(Worker.JsContextReadyListener jsContextReadyListener) {
        boolean z;
        synchronized (this.mBizContextInitLock) {
            if (this.mBizJsContextReady) {
                z = true;
            } else {
                if (this.mBizContextInitListeners == null) {
                    this.mBizContextInitListeners = new ArrayList();
                }
                if (jsContextReadyListener != null && !this.mBizContextInitListeners.contains(jsContextReadyListener)) {
                    this.mBizContextInitListeners.add(jsContextReadyListener);
                }
                z = false;
            }
        }
        if (z) {
            jsContextReadyListener.onJsContextReady();
        }
    }

    protected String getAppxWorkerJS() {
        String clientExtendConfig = EngineUtils.getClientExtendConfig();
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("v8 extend config: ");
        sb.append(clientExtendConfig);
        RVLogger.d(logTag, sb.toString());
        doExecuteScript(clientExtendConfig, "CLIENT_EXTEND_CONFIG", this.mJSContext);
        return this.mImportScriptsCallback.loadResource(getAppxWorkerJsUrl());
    }

    private void removeObj(JSContext jSContext) {
        JSObject globalObject = jSContext.globalObject();
        globalObject.remove(jSContext, "nativeLog");
        globalObject.delete();
    }

    public void createJsiInstance(String str, int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        startWatchDog();
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        Bundle bundle = new Bundle();
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        String packageName = v8Proxy != null ? v8Proxy.getPackageName() : "Alipay";
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append("-JSEngine-");
        sb.append(str);
        sb.append("-");
        sb.append(myPid);
        sb.append("-");
        sb.append(i);
        String obj = sb.toString();
        this.mAppxJSEngineName = obj;
        bundle.putString("name", obj);
        bundle.putString("version", "qjs-1.0");
        bundle.putInt("engine", 3);
        trackStub("V8_CreateIsolate");
        this.mJSEngine = JSEngine.createInstance(applicationContext, bundle, this.mHandler);
        if (RVKernelUtils.isDebug()) {
            this.mJSEngine.setEnableStats(true);
        }
        trackStub("V8_CreateJSContext");
        this.mJSContext = this.mJSEngine.createContext(APPX_JS_CONTEXT);
        this.mEngineScope = new EngineScope(this.mJSEngine);
        removeObj(this.mJSContext);
        stopWatchDog();
        if (!RVKernelUtils.isDebug()) {
            JSConsole.setup(this.mJSContext, getJSConsoleCallback(), str);
        }
        trackStub("V8_SetupWebAPI");
        this.mJsApiHandler = new JsApiHandler(this.mApp, this);
        this.mJsTimer = new JsTimers(this.mJSContext, this.mHandler, this);
        this.mImportScriptsCallback = new ImportScriptsCallback(this.mApp, this);
        JSObject globalObject = this.mJSContext.globalObject();
        JSFunction jSFunction = new JSFunction(this.mJSContext, new AsyncJSCallback(this), "__nativeFlushQueue__");
        globalObject.set(this.mJSContext, "__nativeFlushQueue__", jSFunction);
        jSFunction.delete();
        JSFunction jSFunction2 = new JSFunction(this.mJSContext, this.mImportScriptsCallback, "importScripts");
        globalObject.set(this.mJSContext, "importScripts", jSFunction2);
        jSFunction2.delete();
        if (V8Utils.getBooleanConfig("ta_v8DynamicNativePlugins", true)) {
            JSFunction jSFunction3 = new JSFunction(this.mJSContext, new JSCallback() { // from class: com.alibaba.ariver.v8worker.V8Worker.13
                {
                    V8Worker.this = this;
                }

                @Override // com.alibaba.jsi.standard.js.JSCallback
                public JSValue onCallFunction(Arguments arguments) {
                    try {
                        return new JSBoolean(V8Worker.this.loadNativePlugins(arguments));
                    } catch (Throwable th) {
                        RVLogger.e(V8Worker.TAG, "onCallFunction error: ", th);
                        return null;
                    }
                }
            }, "__nativeLoadPlugins__");
            globalObject.set(this.mJSContext, "__nativeLoadPlugins__", jSFunction3);
            jSFunction3.delete();
        }
        MultiThreadWorkerCallback multiThreadWorkerCallback = new MultiThreadWorkerCallback(this);
        this.mMultiThreadWorkerCallback = multiThreadWorkerCallback;
        JSFunction jSFunction4 = new JSFunction(this.mJSContext, multiThreadWorkerCallback, "__nativeCreateWorker__");
        globalObject.set(this.mJSContext, "__nativeCreateWorker__", jSFunction4);
        jSFunction4.delete();
        globalObject.set(this.mJSContext, "self", globalObject);
        RVLogger.e(getLogTag(), "createJsiInstance start loading worker js bridge");
        trackStub("V8_ReadJSBridge");
        String readRawFile = V8Utils.readRawFile(applicationContext, R.raw.workerjs_v8);
        trackStub("V8_ExecuteJSBridge");
        doExecuteScript(readRawFile, "https://appx/v8.worker.js", this.mJSContext);
        try {
            this.mImportScriptsFunc = (JSFunction) globalObject.get(this.mJSContext, "importScripts");
            JSObject jSObject = (JSObject) globalObject.get(this.mJSContext, "AlipayJSBridge");
            this.mAlipayJSBridgeObj = jSObject;
            this.mInvokeJSFunc = (JSFunction) jSObject.get(this.mJSContext, "_invokeJS");
        } catch (Throwable th) {
            trackStub("V8_InitJSBridgeFailed", true);
            String logTag = getLogTag();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("createJsiInstance doInitWorker exception: ");
            sb2.append(th);
            RVLogger.e(logTag, sb2.toString());
        }
        globalObject.delete();
        this.mV8InstanceCost = SystemClock.elapsedRealtime() - elapsedRealtime;
        trackStub("V8_InjectInitialParams");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enablePolyfillWorker", (Object) Boolean.TRUE);
        jSONObject.put("apiMessageChannel", "console");
        jSONObject.put(GriverParam.IS_V8_WORKER, SummaryActivity.CHECKED);
        handleJsApiCacheInitialParams(jSONObject);
        WorkerInitInjector.getInitInjectAppXStartParams(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userAgent", (Object) getUserAgent());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("var navigator=");
        sb3.append(jSONObject2.toJSONString());
        sb3.append(";");
        String obj2 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(obj2);
        sb4.append("var __appxStartupParams=");
        sb4.append(jSONObject.toJSONString());
        sb4.append(";");
        String obj3 = sb4.toString();
        String logTag2 = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("v8 init inject string: ");
        sb5.append(obj3);
        RVLogger.d(logTag2, sb5.toString());
        doExecuteScript(obj3, null, this.mJSContext);
        setAppxJsContextReady();
        long currentTimeMillis = System.currentTimeMillis();
        trackStub("V8_LoadAppxWorkerJS");
        String appxWorkerJS = getAppxWorkerJS();
        this.mAppxResCost = SystemClock.elapsedRealtime() - currentTimeMillis;
        if (!TextUtils.isEmpty(appxWorkerJS)) {
            this.mAppxLoaded = true;
            try {
                setAppxVersionInWorker(appxWorkerJS.substring(0, 100).split("\\r?\\n")[2].substring(3));
            } catch (Throwable unused) {
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            trackStub("V8_ExecuteAppxWorkerJS");
            if (this.mIscompletePreload) {
                RVLogger.e(getLogTag(), "jsi worker is mIscompletePreload do not doExecuteScript return and terminate");
                terminate();
                return;
            }
            doExecuteScript(appxWorkerJS, getAppxWorkerJsUrl(), this.mJSContext);
            this.mAppxWorkerJsCost = SystemClock.elapsedRealtime() - elapsedRealtime2;
            String logTag3 = getLogTag();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("createJsiInstance Successfully pre-execute ");
            sb6.append(getAppxWorkerJsUrl());
            sb6.append(", cost = ");
            sb6.append(this.mAppxWorkerJsCost);
            RVLogger.d(logTag3, sb6.toString());
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("createJsiInstance Failed to pre-execute ");
            sb7.append(getAppxWorkerJsUrl());
            String obj4 = sb7.toString();
            RVLogger.e(getLogTag(), obj4);
            JsErrorAssist.postJsErrorMessage(this.mApp, obj4);
        }
        JSContext tryPreCreateBizJsContext = tryPreCreateBizJsContext(APP_BIZ_JS_CONTEXT);
        this.mBizJSContext = tryPreCreateBizJsContext;
        if (tryPreCreateBizJsContext != null) {
            RVLogger.d(TAG, "setBizContextReady");
            setBizJsContextReady();
        }
        trackStub("V8_JSBridgeReady");
        RVTraceUtils.traceEndSection("createJsiInstance1");
        onAlipayJSBridgeReady();
    }

    private void registerJSExceptionListener() {
        if ("yes".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_onunhandledrejection", "yes"))) {
            this.mJSContext.setEventListener(new Events() { // from class: com.alibaba.ariver.v8worker.V8Worker.14
                {
                    V8Worker.this = this;
                }

                @Override // com.alibaba.jsi.standard.Events
                public boolean onUncaughtJSException(JSContext jSContext, JSException jSException, int i) {
                    if (i == 5) {
                        JSONObject jSONObject = new JSONObject();
                        if (!TextUtils.isEmpty(jSException.getStack(jSContext))) {
                            jSONObject.put(ZdocRecordService.REASON, (Object) jSException.getStack(jSContext));
                        } else {
                            JSValue value = jSException.getValue(jSContext);
                            if (value != null) {
                                if (value.isJSObject()) {
                                    jSONObject.put(ZdocRecordService.REASON, (Object) V8Utils.fromV8Object(value, jSContext));
                                } else {
                                    jSONObject.put(ZdocRecordService.REASON, (Object) value.toString(jSContext));
                                }
                            }
                        }
                        String logTag = V8Worker.this.getLogTag();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onunhandledrejection = ");
                        sb.append(jSONObject.toJSONString());
                        RVLogger.d(logTag, sb.toString());
                        JSFunction jSFunction = (JSFunction) jSContext.getGlobal("onunhandledrejection");
                        if (jSFunction != null) {
                            jSFunction.call(jSContext, null, new JSValue[]{V8Utils.toV8(jSContext, jSONObject)});
                        }
                    }
                    return super.onUncaughtJSException(jSContext, jSException, i);
                }
            });
        }
    }

    protected JSContext tryPreCreateBizJsContext(String str) {
        RVLogger.d(TAG, "jsiworker not pre create bizContext");
        return null;
    }

    public void setAppxJsContextReady() {
        List<Worker.JsContextReadyListener> list;
        RVLogger.e(getLogTag(), "setJsContext Ready");
        synchronized (this.mAppxContextInitLock) {
            this.mAppxJsContextReady = true;
            list = this.mAppxJsContextInitListeners;
            this.mAppxJsContextInitListeners = null;
        }
        if (list != null) {
            Iterator<Worker.JsContextReadyListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onJsContextReady();
            }
            list.clear();
        }
    }

    public void setBizJsContextReady() {
        List<Worker.JsContextReadyListener> list;
        RVLogger.e(getLogTag(), "setBizContext Ready");
        synchronized (this.mBizContextInitLock) {
            list = this.mBizContextInitListeners;
            this.mBizContextInitListeners = null;
            this.mBizJsContextReady = true;
        }
        if (list != null) {
            Iterator<Worker.JsContextReadyListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onJsContextReady();
            }
            list.clear();
        }
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public void onAlipayJSBridgeReady() {
        RVLogger.e(getLogTag(), "onAlipayJSBridgeReady");
        this.mAlipayJSBridgeReady = true;
        App app = this.mApp;
        if (app == null || app.isDestroyed()) {
            RVLogger.e(getLogTag(), "onAlipayJSBridgeReady app is null || app is destroyed.");
            return;
        }
        if (((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("isInitLock", true)) {
            try {
                CountDownLatch countDownLatch = this.mInitLock;
                if (countDownLatch != null) {
                    countDownLatch.await(3000L, TimeUnit.SECONDS);
                }
            } catch (InterruptedException e) {
                RVLogger.e(getLogTag(), "onAlipayJSBridgeReady wait exception!", e);
            }
        }
        if (this.mDestroyed) {
            RVLogger.w(TAG, "mInitlock  await but worker has destroyed");
            return;
        }
        RVTraceUtils.traceBeginSection("onAlipayJSBridgeReady");
        AppConfigModel appConfigModel = (AppConfigModel) this.mApp.getData(AppConfigModel.class);
        if (appConfigModel != null && SummaryActivity.CHECKED.equalsIgnoreCase(appConfigModel.getUseDynamicPlugins())) {
            setUseSandboxContext(true);
        }
        setStartupParams(this.mApp.getStartParams());
        String appxVersionInWorker = getAppxVersionInWorker();
        if (appxVersionInWorker == null) {
            appxVersionInWorker = "";
        }
        AppxVersionStore appxVersionStore = (AppxVersionStore) this.mApp.getData(AppxVersionStore.class, true);
        appxVersionStore.workerVersion = appxVersionInWorker;
        this.mApp.putStringValue("appxWorkerVersion", appxVersionInWorker);
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("detect appx worker version is: ");
        sb.append(appxVersionInWorker);
        sb.append(", versionStore: ");
        sb.append(appxVersionStore);
        RVLogger.e(logTag, sb.toString());
        EventTrackStore eventTrackStore = (EventTrackStore) this.mApp.getData(EventTrackStore.class, true);
        if ("YES".equalsIgnoreCase(BundleUtils.getString(getStartupParams(), "appxRouteFramework"))) {
            eventTrackStore.fullLinkAttrMap.put("appxRouteFramework", "YES");
        }
        AppModel appModel = (AppModel) this.mApp.getData(AppModel.class);
        List<PluginModel> plugins = appModel != null ? appModel.getAppInfoModel().getPlugins() : null;
        if (plugins != null) {
            setPluginModelList(plugins);
        }
        tryToInjectStartupParamsAndPushWorker();
        RVTraceUtils.traceEndSection("onAlipayJSBridgeReady");
    }

    public JsApiHandler getJsApiHandler() {
        return this.mJsApiHandler;
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
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.15
                {
                    V8Worker.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.doInjectStartupParamsAndPushWorker();
                }
            });
        }
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void loadPlugin(String str) {
        super.loadPlugin(str);
        if (isReleased()) {
            return;
        }
        createPluginJSContext(str);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public void setWorkerReady() {
        this.mWorkerReadyTs = SystemClock.elapsedRealtime();
        trackStub("V8_WorkerReady");
        super.setWorkerReady();
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void setRenderReady() {
        this.mRenderReadyTs = SystemClock.elapsedRealtime();
        trackStub("V8_RenderReady");
        super.setRenderReady();
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void setStartupParams(Bundle bundle) {
        trackStub("V8_SetStartupParams");
        super.setStartupParams(bundle);
    }

    protected void doInjectStartupParamsAndPushWorker() {
        RVTraceUtils.traceBeginSection("doInjectStartupParamsAndPushWorker");
        RVLogger.d(getLogTag(), "doInjectStartupParamsAndPushWorker");
        trackStub("V8_PushWorker");
        long currentTimeMillis = System.currentTimeMillis();
        if (RVKernelUtils.isDebug()) {
            this.mStartupParams.putString(com.alibaba.exthub.BuildConfig.BUILD_TYPE, "framework");
        }
        WorkerStartParamInjectPoint workerStartParamInjectPoint = (WorkerStartParamInjectPoint) ExtensionPoint.as(WorkerStartParamInjectPoint.class).node(this.mApp).nullable().create();
        if (workerStartParamInjectPoint != null) {
            workerStartParamInjectPoint.injectStartParam(this.mStartupParams);
        }
        V8NativePlugin v8NativePlugin = new V8NativePlugin(this, this.mStartupParams);
        this.mV8NativePlugin = v8NativePlugin;
        if (!v8NativePlugin.isEmpty()) {
            trackStub("V8_LoadV8Plugins");
            this.mV8NativePlugin.loadPlugins();
        }
        this.mEnableMessageChannel |= "1".equals(BundleUtils.getString(this.mStartupParams, "v8MC", null));
        if (this.mUseSandboxContext || useSandbox()) {
            if (!this.mAppxLoaded) {
                this.mAppxLoaded = true;
                trackStub("V8_ImportScript_AppxWorkerJS");
                doImportScripts(getAppxWorkerJS(), this.mJSContext);
            }
            JSONObject jSONObject = BundleUtils.toJSONObject(this.mStartupParams);
            trackStub("V8_MergeJsApiCacheParams");
            packageJsApiCacheStartParams(jSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append("var navigator={userAgent:'");
            sb.append(getUserAgent());
            sb.append("'}; Object.assign(__appxStartupParams, ");
            sb.append(jSONObject.toJSONString());
            sb.append(");");
            String obj = sb.toString();
            String logTag = getLogTag();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("use Sandbox multiple JSContext injectParams: ");
            sb2.append(obj);
            RVLogger.d(logTag, sb2.toString());
            trackStub("V8_InjectFullParams");
            doExecuteScript(obj, null, this.mJSContext);
            try {
                this.mJSContextList = new ArrayList();
                int i = 0;
                while (true) {
                    List<PluginModel> list = this.mPluginModelList;
                    if (list == null || i >= list.size()) {
                        break;
                    }
                    String appId = this.mPluginModelList.get(i).getAppId();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("createPluginJSContext_");
                    sb3.append(appId);
                    RVTraceUtils.traceBeginSection(sb3.toString());
                    createPluginJSContext(appId);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("createPluginJSContext_");
                    sb4.append(appId);
                    RVTraceUtils.traceEndSection(sb4.toString());
                    i++;
                }
                if (!this.mBizJsContextReady && V8Utils.isSupportNonIsolatedMode(this.mApp)) {
                    if (!runBizInAppxJSContext()) {
                        createBizJSContext();
                    }
                }
                createBizJSContext();
            } catch (Throwable th) {
                String logTag2 = getLogTag();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("createPluginJSContext or createBizJSContext error: ");
                sb5.append(th);
                RVLogger.e(logTag2, sb5.toString());
            }
        } else {
            JSONObject jSONObject2 = BundleUtils.toJSONObject(this.mStartupParams);
            trackStub("V8_MergeJsApiCacheParams");
            packageJsApiCacheStartParams(jSONObject2);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Object.assign(__appxStartupParams, ");
            sb6.append(jSONObject2.toJSONString());
            sb6.append(");");
            String obj2 = sb6.toString();
            String logTag3 = getLogTag();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("injectParams: ");
            sb7.append(obj2);
            RVLogger.d(logTag3, sb7.toString());
            trackStub("V8_InjectFullParams");
            doExecuteScript(obj2, null, this.mJSContext);
            trackStub("V8_ImportScripts_BizJS");
            doImportScripts(this.mWorkerId, this.mJSContext);
        }
        this.mBizWorkerJsCost = System.currentTimeMillis() - currentTimeMillis;
        String logTag4 = getLogTag();
        StringBuilder sb8 = new StringBuilder();
        sb8.append("doInjectStartupParamsAndPushWorker cost = ");
        sb8.append(this.mBizWorkerJsCost);
        RVLogger.e(logTag4, sb8.toString());
        setWorkerReady();
        V8NativePlugin v8NativePlugin2 = this.mV8NativePlugin;
        if (v8NativePlugin2 != null) {
            v8NativePlugin2.OnSessionResume();
            Page activePage = getApp().getActivePage();
            if (activePage != null) {
                this.mV8NativePlugin.redispatchPageCreate(activePage);
            }
        }
        BigDataChannelManager.getInstance().registerReceiveDataCallback(this.mWorkerId, new BigDataChannelClient(this));
        RVTraceUtils.traceEndSection("doInjectStartupParamsAndPushWorker");
    }

    private boolean runBizInAppxJSContext() {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("runBizInAppxJSContext for App: ");
        sb.append(this.mAppId);
        RVLogger.d(logTag, sb.toString());
        JSValue executeJS = this.mJSContext.executeJS("AFAppX.disableAppContext();", null);
        if (this.mJSContext.hasException() || executeJS == null) {
            String jSException = this.mJSContext.getException().toString(this.mJSContext);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("runBizInAppxJSContext error, executeJS js: ");
            sb2.append("AFAppX.disableAppContext();");
            sb2.append(" error: ");
            sb2.append(jSException);
            String obj = sb2.toString();
            RVLogger.e(getLogTag(), obj);
            JsErrorAssist.postJsErrorMessage(this.mApp, obj);
            if (RVKernelUtils.isDebug()) {
                try {
                    Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("debug包警告: executeJS js: ");
                    sb3.append("AFAppX.disableAppContext();");
                    sb3.append(" error: ");
                    sb3.append(jSException);
                    Toast.makeText(applicationContext, sb3.toString(), 1).show();
                    return false;
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        }
        executeJS.delete();
        trackStub("V8_ImportScripts_BizJS");
        RVTraceUtils.traceBeginSection("V8_ImportScripts_BizJS");
        doImportScripts(this.mWorkerId, this.mJSContext);
        RVTraceUtils.traceEndSection("V8_ImportScripts_BizJS");
        return true;
    }

    public void createPluginJSContext(final String str) {
        if (this.mJSContextList == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("createPluginJSContext w/o sandboxed mode: ");
            sb.append(str);
            String obj = sb.toString();
            RVLogger.e(getLogTag(), obj);
            JsErrorAssist.postJsErrorMessage(this.mApp, obj);
            throw new IllegalStateException(obj);
        } else if (!isReleased()) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                if (this.mLoadedPlugins.contains(str)) {
                    String logTag = getLogTag();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("createPluginJSContext but already loaded: ");
                    sb2.append(str);
                    RVLogger.w(logTag, sb2.toString());
                    return;
                }
                String logTag2 = getLogTag();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("createPluginJSContext for plugin: ");
                sb3.append(str);
                RVLogger.d(logTag2, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("V8_PrepareJSContext_");
                sb4.append(str);
                trackStub(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Object.assign({}, AFAppX.getPluginContext({pluginId: '");
                sb5.append(str);
                sb5.append("'}),");
                sb5.append(RUNTIME_VARS);
                sb5.append(")");
                String obj2 = sb5.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("app-plugin-");
                sb6.append(str);
                sb6.append(".js");
                JSObject jSObject = (JSObject) this.mJSContext.executeJS(obj2, sb6.toString());
                if (this.mJSContext.hasException()) {
                    if (jSObject != null) {
                        jSObject.delete();
                    }
                    String jSException = this.mJSContext.getException().toString(this.mJSContext);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("createPluginJSContext executeJS js: ");
                    sb7.append(obj2);
                    sb7.append(" error: ");
                    sb7.append(jSException);
                    String obj3 = sb7.toString();
                    RVLogger.e(getLogTag(), obj3);
                    JsErrorAssist.postJsErrorMessage(this.mApp, obj3);
                    throw new IllegalStateException(jSException);
                }
                JSEngine jSEngine = this.mJSEngine;
                StringBuilder sb8 = new StringBuilder();
                sb8.append(APP_PLUGIN_CONTEXT);
                sb8.append(str);
                JSContext createContext = jSEngine.createContext(sb8.toString());
                JSObject globalObject = createContext.globalObject();
                removeObj(createContext);
                JSArray ownPropertyNames = jSObject.getOwnPropertyNames(this.mJSContext);
                int length = ownPropertyNames.length(this.mJSContext);
                for (int i = 0; i < length; i++) {
                    JSValue jSValue = ownPropertyNames.get(this.mJSContext, i);
                    JSValue jSValue2 = jSObject.get(this.mJSContext, jSValue);
                    globalObject.set(createContext, jSValue, jSValue2);
                    if (jSValue2 != null) {
                        jSValue2.delete();
                    }
                    if (jSValue != null) {
                        jSValue.delete();
                    }
                }
                globalObject.set(createContext, "self", globalObject);
                globalObject.set(createContext, "AlipayTimersExecution", new JSVoid());
                if (ownPropertyNames != null) {
                    ownPropertyNames.delete();
                }
                if (globalObject != 0) {
                    globalObject.delete();
                }
                if (jSObject != null) {
                    jSObject.delete();
                }
                this.mJSContextList.add(createContext);
                StringBuilder sb9 = new StringBuilder();
                sb9.append("V8_ImportScripts_SecurityJS_");
                sb9.append(str);
                trackStub(sb9.toString());
                doImportScripts("https://appx/security-patch.min.js", createContext);
                String string = BundleUtils.getString(this.mStartupParams, "onlineHost");
                StringBuilder sb10 = new StringBuilder();
                sb10.append("__plugins__/");
                sb10.append(str);
                sb10.append("/index.worker.js");
                String combinePath = FileUtils.combinePath(string, sb10.toString());
                StringBuilder sb11 = new StringBuilder();
                sb11.append("V8_ImportScripts_PluginJS_");
                sb11.append(str);
                trackStub(sb11.toString());
                doImportScripts(combinePath, createContext);
                this.mLoadedPlugins.add(str);
                return;
            }
            final StringBuilder sb12 = this.mSyncLoadPlugin ? new StringBuilder() : null;
            final ConditionVariable conditionVariable = this.mSyncLoadPlugin ? new ConditionVariable() : null;
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.16
                {
                    V8Worker.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        V8Worker.this.createPluginJSContext(str);
                    } catch (Throwable th) {
                        RVLogger.e(V8Worker.this.getLogTag(), "createBizJSContext error", th);
                        App app = V8Worker.this.mApp;
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append("PluginID ");
                        sb13.append(str);
                        sb13.append("createBizJSContext error");
                        sb13.append(JsErrorAssist.getStackTraceString(th));
                        JsErrorAssist.postJsErrorMessage(app, sb13.toString());
                        if (sb12 != null) {
                            String message = th.getMessage();
                            sb12.append(message != null ? message : "createBizJSContext error");
                        }
                    }
                    ConditionVariable conditionVariable2 = conditionVariable;
                    if (conditionVariable2 != null) {
                        conditionVariable2.open();
                    }
                }
            });
            if (conditionVariable != null) {
                conditionVariable.block();
                if (sb12.length() > 0) {
                    throw new IllegalStateException(sb12.toString());
                }
            }
        }
    }

    protected void createBizJSContext() {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("createBizJSContext JSContext for App: ");
        sb.append(this.mAppId);
        RVLogger.d(logTag, sb.toString());
        String bizContextJs = getBizContextJs();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("app-biz-");
        sb2.append(this.mAppId);
        sb2.append(".js");
        JSObject jSObject = (JSObject) this.mJSContext.executeJS(bizContextJs, sb2.toString());
        if (this.mJSContext.hasException() || jSObject == null) {
            String jSException = this.mJSContext.getException().toString(this.mJSContext);
            String logTag2 = getLogTag();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("createBizJSContext error, executeJS js: ");
            sb3.append(bizContextJs);
            sb3.append(" error: ");
            sb3.append(jSException);
            RVLogger.e(logTag2, sb3.toString());
            this.mBizJSContext = null;
            return;
        }
        if (this.mBizJSContext == null) {
            this.mBizJSContext = this.mJSEngine.createContext(APP_BIZ_JS_CONTEXT);
            RVLogger.d(TAG, "setBizJsContext Ready in createBizContext");
            setBizJsContextReady();
        }
        JSObject globalObject = this.mBizJSContext.globalObject();
        removeObj(this.mBizJSContext);
        JSArray ownPropertyNames = jSObject.getOwnPropertyNames(this.mJSContext);
        int length = ownPropertyNames.length(this.mJSContext);
        for (int i = 0; i < length; i++) {
            JSValue jSValue = ownPropertyNames.get(this.mJSContext, i);
            JSValue jSValue2 = jSObject.get(this.mJSContext, jSValue);
            globalObject.set(this.mBizJSContext, jSValue, jSValue2);
            if (jSValue2 != null) {
                jSValue2.delete();
            }
            if (jSValue != null) {
                jSValue.delete();
            }
        }
        this.mJSContextList.add(this.mBizJSContext);
        globalObject.set(this.mBizJSContext, "importScripts", this.mImportScriptsFunc);
        globalObject.set(this.mBizJSContext, "self", globalObject);
        globalObject.set(this.mBizJSContext, "AlipayTimersExecution", new JSVoid());
        if (jSObject != null) {
            jSObject.delete();
        }
        if (globalObject != 0) {
            globalObject.delete();
        }
        if (ownPropertyNames != null) {
            ownPropertyNames.delete();
        }
        trackStub("V8_ImportScripts_SecurityJS");
        doImportScripts("https://appx/security-patch.min.js", this.mBizJSContext);
        trackStub("V8_ImportScripts_BizJS");
        doImportScripts(this.mWorkerId, this.mBizJSContext);
    }

    public void setUseSandboxContext(boolean z) {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("setUseSandboxContext: ");
        sb.append(z);
        RVLogger.d(logTag, sb.toString());
        this.mUseSandboxContext = z;
    }

    protected boolean useSandbox() {
        List<PluginModel> list;
        try {
            list = this.mPluginModelList;
        } catch (Throwable th) {
            RVLogger.e(this.mTag, "useSandbox exception", th);
        }
        if ((list == null || list.size() <= 0) && !"YES".equals(BundleUtils.getString(this.mStartupParams, PARAM_SANDBOXED, null))) {
            if (V8Utils.isAppInList("ta_SandboxedBlackList", getApp(), false)) {
                return false;
            }
            return V8Utils.isAppInList("ta_SandboxedWhiteList", getApp(), false);
        }
        return true;
    }

    public void setPluginModelList(List<PluginModel> list) {
        this.mPluginModelList = list;
    }

    public void doImportScripts(String str, JSContext jSContext) {
        if (isReleased()) {
            return;
        }
        try {
            this.mImportScriptsCallback.handleResourceRequest(str, jSContext);
        } catch (Throwable th) {
            ((V8ImportScriptErrorPoint) ExtensionPoint.as(V8ImportScriptErrorPoint.class).node(this.mApp).create()).onLoadScriptError(th);
            trackStub("V8_ImportScriptFailed", true);
            App app = this.mApp;
            StringBuilder sb = new StringBuilder();
            sb.append("V8_ImportScriptFailed，url = ");
            sb.append(str);
            JsErrorAssist.postJsErrorMessage(app, sb.toString());
        }
    }

    public boolean isReleased() {
        JSContext jSContext = this.mJSContext;
        return jSContext == null || jSContext.isDisposed() || this.mJSEngine == null;
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendMessageToWorker(String str, String str2, String str3, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(str3, sendToWorkerCallback);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendJsonToWorker(JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback) {
        if (isReleased()) {
            return;
        }
        if ("message".equals(JSONUtils.getString(jSONObject, "handlerName"))) {
            markRenderPostMsg();
        }
        try {
            if (V8Utils.isSerializableObject(jSONObject)) {
                sendMessageToWorker(JSON.toJSONString(jSONObject, SerializerFeature.DisableCircularReferenceDetect), sendToWorkerCallback);
                return;
            }
        } catch (Throwable th) {
            RVLogger.e(getLogTag(), "sendJsonToWorker failed to use fastjson", th);
        }
        final JSONObject copyJSONObject = V8Utils.copyJSONObject(jSONObject);
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            doSendJsonToWorker(copyJSONObject, sendToWorkerCallback);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.17
                {
                    V8Worker.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.doSendJsonToWorker(copyJSONObject, sendToWorkerCallback);
                }
            });
        }
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void postMessage(String str, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(str, sendToWorkerCallback);
    }

    public void sendMessageToWorker(final String str, final SendToWorkerCallback sendToWorkerCallback) {
        if (isReleased()) {
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(new JSONObject());
            }
        } else if (Looper.myLooper() == this.mHandler.getLooper()) {
            doSendMessageToWorker(str, null, null, sendToWorkerCallback);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.18
                {
                    V8Worker.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.doSendMessageToWorker(str, null, null, sendToWorkerCallback);
                }
            });
        }
    }

    public void doSendMessageToWorker(Object obj, String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        String valueOf;
        JSValue[] jSValueArr;
        boolean z;
        JSONObject jSONObject;
        if (isReleased()) {
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(new JSONObject());
                return;
            }
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.mV8CallingId;
        this.mV8CallingId = 1 + j;
        boolean z2 = obj instanceof String;
        if (z2) {
            valueOf = V8Utils.makeLogMsg((String) obj);
        } else {
            valueOf = String.valueOf(obj.hashCode());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("invokeJS callId: ");
        sb.append(j);
        sb.append(" ");
        sb.append(valueOf);
        String obj2 = sb.toString();
        RVLogger.d(getLogTag(), obj2);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            jSValueArr = new JSValue[1];
            if (z2) {
                jSValueArr[0] = new JSString((String) obj);
            } else if (obj instanceof JSValue) {
                jSValueArr[0] = (JSValue) obj;
            }
        } else {
            jSValueArr = new JSValue[3];
            if (z2) {
                jSValueArr[0] = new JSString((String) obj);
            } else if (obj instanceof JSValue) {
                jSValueArr[0] = (JSValue) obj;
            }
            jSValueArr[1] = new JSString(str);
            jSValueArr[2] = new JSString(str2);
        }
        try {
            JSValue call = this.mInvokeJSFunc.call(this.mJSContext, this.mAlipayJSBridgeObj, jSValueArr);
            z = call instanceof JSBoolean ? ((JSBoolean) call).valueOf() : false;
            if (call != null) {
                try {
                    call.delete();
                } catch (Throwable th) {
                    th = th;
                    try {
                        ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.mApp).create()).onSendMessageException(th);
                        trackStub("V8_doSendMessageToWorker_error", true);
                        App app = this.mApp;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("V8_doSendMessageToWorker_error：");
                        sb2.append(obj2);
                        JsErrorAssist.postJsErrorMessage(app, sb2.toString());
                        for (JSValue jSValue : jSValueArr) {
                            jSValue.delete();
                        }
                        String logTag = getLogTag();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("end invokeJS callId: ");
                        sb3.append(j);
                        sb3.append(", cost: ");
                        sb3.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                        RVLogger.d(logTag, sb3.toString());
                        if (sendToWorkerCallback != null) {
                            jSONObject = new JSONObject();
                            jSONObject.put(RVConstants.EXTRA_PREVENTED, (Object) Boolean.valueOf(z));
                            sendToWorkerCallback.onCallBack(jSONObject);
                        }
                        return;
                    } catch (Throwable th2) {
                        for (JSValue jSValue2 : jSValueArr) {
                            jSValue2.delete();
                        }
                        String logTag2 = getLogTag();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("end invokeJS callId: ");
                        sb4.append(j);
                        sb4.append(", cost: ");
                        sb4.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                        RVLogger.d(logTag2, sb4.toString());
                        if (sendToWorkerCallback != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(RVConstants.EXTRA_PREVENTED, (Object) Boolean.valueOf(z));
                            sendToWorkerCallback.onCallBack(jSONObject2);
                        }
                        throw th2;
                    }
                }
            }
            for (JSValue jSValue3 : jSValueArr) {
                jSValue3.delete();
            }
            String logTag3 = getLogTag();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("end invokeJS callId: ");
            sb5.append(j);
            sb5.append(", cost: ");
            sb5.append(SystemClock.elapsedRealtime() - elapsedRealtime);
            RVLogger.d(logTag3, sb5.toString());
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
        if (sendToWorkerCallback != null) {
            jSONObject = new JSONObject();
            jSONObject.put(RVConstants.EXTRA_PREVENTED, (Object) Boolean.valueOf(z));
            sendToWorkerCallback.onCallBack(jSONObject);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x002b A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doSendJsonToWorker(com.alibaba.fastjson.JSONObject r5, com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback r6) {
        /*
            r4 = this;
            boolean r0 = r4.isReleased()
            if (r0 == 0) goto L7
            return
        L7:
            r0 = 0
            boolean r1 = r4.mEnableArrayBuffer     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L1d
            com.alibaba.jsi.standard.JSContext r1 = r4.mJSContext     // Catch: java.lang.Throwable -> L13
            com.alibaba.jsi.standard.js.JSValue r1 = com.alibaba.ariver.v8worker.V8Utils.toV8(r1, r5)     // Catch: java.lang.Throwable -> L13
            goto L1e
        L13:
            r1 = move-exception
            java.lang.String r2 = r4.getLogTag()     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "serialize error!"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L32
        L1d:
            r1 = r0
        L1e:
            if (r1 != 0) goto L25
            java.lang.String r2 = r5.toJSONString()     // Catch: java.lang.Throwable -> L2f
            goto L26
        L25:
            r2 = r1
        L26:
            r4.doSendMessageToWorker(r2, r0, r0, r6)     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L8e
            r1.delete()
            return
        L2f:
            r6 = move-exception
            r0 = r1
            goto L33
        L32:
            r6 = move-exception
        L33:
            java.lang.Class<com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint> r1 = com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint.class
            com.alibaba.ariver.kernel.api.extension.ExtensionPoint r1 = com.alibaba.ariver.kernel.api.extension.ExtensionPoint.as(r1)     // Catch: java.lang.Throwable -> L8f
            com.alibaba.ariver.app.api.App r2 = r4.mApp     // Catch: java.lang.Throwable -> L8f
            com.alibaba.ariver.kernel.api.extension.ExtensionPoint r1 = r1.node(r2)     // Catch: java.lang.Throwable -> L8f
            com.alibaba.ariver.kernel.api.extension.Extension r1 = r1.create()     // Catch: java.lang.Throwable -> L8f
            com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint r1 = (com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint) r1     // Catch: java.lang.Throwable -> L8f
            r1.onSendMessageException(r6)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r1 = "V8_doSendJsonToWorker_error"
            r2 = 1
            r4.trackStub(r1, r2)     // Catch: java.lang.Throwable -> L8f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r1.<init>()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r2 = "Caught exception when doSendJsonToWorker: \n"
            r1.append(r2)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r6 = com.alibaba.ariver.app.api.JsErrorAssist.getStackTraceString(r6)     // Catch: java.lang.Throwable -> L8f
            r1.append(r6)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r1 = r4.getLogTag()     // Catch: java.lang.Throwable -> L8f
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r6)     // Catch: java.lang.Throwable -> L8f
            com.alibaba.ariver.app.api.App r1 = r4.mApp     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L8f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L8f
            r2.<init>()     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L8f
            r2.append(r6)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L8f
            java.lang.String r6 = ",message:"
            r2.append(r6)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L8f
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L8f
            r2.append(r5)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L8f
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L8f
            com.alibaba.ariver.app.api.JsErrorAssist.postJsErrorMessage(r1, r5)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L8f
            goto L89
        L88:
        L89:
            if (r0 == 0) goto L8e
            r0.delete()
        L8e:
            return
        L8f:
            r5 = move-exception
            if (r0 == 0) goto L95
            r0.delete()
        L95:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.V8Worker.doSendJsonToWorker(com.alibaba.fastjson.JSONObject, com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback):void");
    }

    public void executeScript(final String str, final String str2, final JSContext jSContext) {
        if (isReleased()) {
            return;
        }
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            doExecuteScript(str, str2, jSContext);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.19
                {
                    V8Worker.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.doExecuteScript(str, str2, jSContext);
                }
            });
        }
    }

    protected boolean isRunInBizContext(String str) {
        return this.mBizJSContext != null && !TextUtils.isEmpty(str) && str.startsWith("/") && str.endsWith("/index.worker.js");
    }

    public void doExecuteScript(String str, String str2, JSContext jSContext) {
        String logTag;
        StringBuilder sb;
        if (isReleased() || TextUtils.isEmpty(str)) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.mV8CallingId;
        this.mV8CallingId = 1 + j;
        try {
            String logTag2 = getLogTag();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("begin V8 executeScript callId: ");
            sb2.append(j);
            sb2.append(" ");
            sb2.append(str2);
            sb2.append(" ");
            sb2.append(str instanceof String ? V8Utils.makeLogMsg(str) : "byte[]");
            RVLogger.d(logTag2, sb2.toString());
            if (isRunInBizContext(str2)) {
                jSContext = this.mBizJSContext;
            }
        } catch (Throwable th) {
            try {
                ((V8ImportScriptErrorPoint) ExtensionPoint.as(V8ImportScriptErrorPoint.class).node(this.mApp).create()).onLoadScriptError(th);
                trackStub("V8_doExecuteScript_error", true);
                App app = this.mApp;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("V8_doExecuteScript_error，jsString：");
                sb3.append(str);
                sb3.append("scriptName:");
                sb3.append(str2);
                JsErrorAssist.postJsErrorMessage(app, sb3.toString());
                logTag = getLogTag();
                sb = new StringBuilder();
            } catch (Throwable th2) {
                String logTag3 = getLogTag();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("end V8 executeScript callId: ");
                sb4.append(j);
                sb4.append(", cost: ");
                sb4.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                RVLogger.d(logTag3, sb4.toString());
                throw th2;
            }
        }
        if (jSContext != null && !jSContext.isDisposed()) {
            JSValue executeJS = jSContext.executeJS(str, str2);
            if (jSContext.hasException()) {
                String jSException = jSContext.getException().toString(jSContext);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("doExecuteScript: ");
                sb5.append(str2);
                sb5.append("jsString:");
                sb5.append(str);
                sb5.append(" error: ");
                sb5.append(jSException);
                String obj = sb5.toString();
                RVLogger.e(getLogTag(), obj);
                JsErrorAssist.postJsErrorMessage(this.mApp, obj);
            }
            if (executeJS != null) {
                executeJS.delete();
            }
            logTag = getLogTag();
            sb = new StringBuilder();
            sb.append("end V8 executeScript callId: ");
            sb.append(j);
            sb.append(", cost: ");
            sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
            RVLogger.d(logTag, sb.toString());
        }
        String logTag4 = getLogTag();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("doExecuteScript: ");
        sb6.append(str2);
        sb6.append(" jsContext == null");
        RVLogger.e(logTag4, sb6.toString());
        logTag = getLogTag();
        sb = new StringBuilder();
        sb.append("end V8 executeScript callId: ");
        sb.append(j);
        sb.append(", cost: ");
        sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
        RVLogger.d(logTag, sb.toString());
    }

    public void onPageCreate(Page page) {
        V8NativePlugin v8NativePlugin;
        if (isReleased() || (v8NativePlugin = this.mV8NativePlugin) == null) {
            return;
        }
        v8NativePlugin.onPageCreate(page);
    }

    public void onPageResume(Page page) {
        V8NativePlugin v8NativePlugin;
        if (isReleased() || (v8NativePlugin = this.mV8NativePlugin) == null) {
            return;
        }
        v8NativePlugin.onPageResume(page);
    }

    public void onPagePause(Page page) {
        V8NativePlugin v8NativePlugin;
        if (isReleased() || (v8NativePlugin = this.mV8NativePlugin) == null) {
            return;
        }
        v8NativePlugin.onPagePause(page);
    }

    public void onPageClose(Page page) {
        V8NativePlugin v8NativePlugin;
        if (isReleased() || (v8NativePlugin = this.mV8NativePlugin) == null) {
            return;
        }
        v8NativePlugin.onPageClose(page);
    }

    public void dispatchPageEvent(final int i, final int i2) {
        V8NativePlugin v8NativePlugin = this.mV8NativePlugin;
        if (v8NativePlugin == null || v8NativePlugin.isEmpty() || isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.20
            {
                V8Worker.this = this;
            }

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
                V8Worker v8Worker = V8Worker.this;
                v8Worker._dispatchPluginEvent(v8Worker.getAppxJSEngineName(), i, V8Worker.this.mAppId, i2);
            }
        });
    }

    public JSEngine getJSEngine() {
        return this.mJSEngine;
    }

    public JSContext getAppxJSContext() {
        return this.mJSContext;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public HandlerThread getWorkerHandlerThread() {
        return this.mHandlerThread;
    }

    public String loadResource(String str) {
        return this.mImportScriptsCallback.loadResource(str);
    }

    public void onSessionPause() {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("JsTimers, onSessionPause mAppId: ");
        sb.append(this.mAppId);
        RVLogger.d(logTag, sb.toString());
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.21
            {
                V8Worker.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.isReleased()) {
                    return;
                }
                if (V8Worker.this.mLeaveHintStatus) {
                    if (V8Worker.this.mTitleBarClose) {
                        if (V8Worker.this.mEnableKeepAliveSleep) {
                            String logTag2 = V8Worker.this.getLogTag();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("JsTimers, stop JsTimers KeepAlive, delay: ");
                            sb2.append(V8Worker.this.mKeepAliveSleepDelay);
                            RVLogger.w(logTag2, sb2.toString());
                            V8Worker v8Worker = V8Worker.this;
                            v8Worker.pause(v8Worker.mKeepAliveSleepDelay);
                        }
                    } else if (V8Worker.this.mEnableClientBackgroundSleep) {
                        String logTag3 = V8Worker.this.getLogTag();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("JsTimers, stop JsTimers ClientBackground, delay: ");
                        sb3.append(V8Worker.this.mClientBackgroundSleepDelay);
                        RVLogger.w(logTag3, sb3.toString());
                        V8Worker v8Worker2 = V8Worker.this;
                        v8Worker2.pause(v8Worker2.mClientBackgroundSleepDelay);
                    }
                } else if (V8Worker.this.mEnableTinyBackgroundSleep) {
                    String logTag4 = V8Worker.this.getLogTag();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("JsTimers, stop JsTimers TinyBackground, delay: ");
                    sb4.append(V8Worker.this.mTinyBackgroundSleepDelay);
                    RVLogger.w(logTag4, sb4.toString());
                    V8Worker v8Worker3 = V8Worker.this;
                    v8Worker3.pause(v8Worker3.mTinyBackgroundSleepDelay);
                }
                if (V8Worker.this.mV8NativePlugin != null) {
                    V8Worker.this.mV8NativePlugin.OnSessionPause();
                }
            }
        });
    }

    public void pause(long j) {
        if (this.mJsTimer == null || this.mKeepTimer) {
            return;
        }
        if (j <= 0) {
            String logTag = getLogTag();
            StringBuilder sb = new StringBuilder();
            sb.append("JsTimers, stop JsTimers mAppId: ");
            sb.append(this.mAppId);
            RVLogger.w(logTag, sb.toString());
            this.mJsTimer.pause();
            this.mPaused = true;
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.22
            {
                V8Worker.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                V8Worker.this.mPauseTimer = null;
                if (V8Worker.this.isReleased()) {
                    return;
                }
                String logTag2 = V8Worker.this.getLogTag();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("JsTimers, stop JsTimers mAppId: ");
                sb2.append(V8Worker.this.mAppId);
                RVLogger.w(logTag2, sb2.toString());
                V8Worker.this.mJsTimer.pause();
                V8Worker.this.mPaused = true;
            }
        };
        this.mPauseTimer = runnable;
        this.mHandler.postDelayed(runnable, j * 1000);
    }

    public void onSessionLeaveHint() {
        this.mLeaveHintStatus = true;
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("onSessionLeaveHint mAppId: ");
        sb.append(this.mAppId);
        RVLogger.d(logTag, sb.toString());
    }

    public void onSessionTitleBarClose() {
        this.mTitleBarClose = true;
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("onSessionTitleBarClose mAppId: ");
        sb.append(this.mAppId);
        RVLogger.d(logTag, sb.toString());
    }

    public void waitIfAppPaused() {
        if (this.mPaused) {
            String logTag = getLogTag();
            StringBuilder sb = new StringBuilder();
            sb.append("JsTimers, enter waitIfAppPaused mAppId: ");
            sb.append(this.mAppId);
            RVLogger.d(logTag, sb.toString());
            while (this.mPaused && !isReleased()) {
                synchronized (this) {
                    try {
                        if (this.mPaused) {
                            wait();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            String logTag2 = getLogTag();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("JsTimers, exit waitIfAppPaused mAppId: ");
            sb2.append(this.mAppId);
            RVLogger.d(logTag2, sb2.toString());
        }
    }

    public void onSessionResume() {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("JsTimers, onSessionResume mAppId: ");
        sb.append(this.mAppId);
        RVLogger.d(logTag, sb.toString());
        if (isReleased()) {
            return;
        }
        this.mTitleBarClose = false;
        this.mLeaveHintStatus = false;
        if (this.mPaused) {
            synchronized (this) {
                this.mPaused = false;
                notify();
            }
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.23
            {
                V8Worker.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.isReleased()) {
                    return;
                }
                if (V8Worker.this.mJsTimer != null && !V8Worker.this.mKeepTimer) {
                    if (V8Worker.this.mPauseTimer != null) {
                        V8Worker.this.mHandler.removeCallbacks(V8Worker.this.mPauseTimer);
                        V8Worker.this.mPauseTimer = null;
                    }
                    RVLogger.w(V8Worker.this.getLogTag(), "JsTimers, resume JsTimers");
                    V8Worker.this.mJsTimer.resume();
                }
                if (V8Worker.this.mV8NativePlugin != null) {
                    V8Worker.this.mV8NativePlugin.OnSessionResume();
                }
            }
        });
    }

    public void terminate() {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("V8Worker destroy(), mAppId: ");
        sb.append(this.mAppId);
        RVLogger.d(logTag, sb.toString());
        this.mExiting = true;
        if (isReleased()) {
            String logTag2 = getLogTag();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("!!! V8Worker isReleased(), mAppId: ");
            sb2.append(this.mAppId);
            RVLogger.e(logTag2, sb2.toString());
            return;
        }
        if (this.mPaused) {
            synchronized (this) {
                this.mPaused = false;
                notify();
            }
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.24
            {
                V8Worker.this = this;
            }

            /* JADX WARN: Code restructure failed: missing block: B:121:0x0140, code lost:
            
                if (android.os.Build.VERSION.SDK_INT >= 18) goto L127;
             */
            /* JADX WARN: Code restructure failed: missing block: B:128:0x015c, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:130:0x0166, code lost:
            
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 386
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.V8Worker.AnonymousClass24.run():void");
            }
        });
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void destroy() {
        super.destroy();
        terminate();
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public Handler getWorkerHandler() {
        return this.mHandler;
    }

    public void markRenderPostMsg() {
        this.mGotMsgFromRender = true;
    }

    public void markWorkerPostMsg() {
        this.mGotMsgFromWorker = true;
    }

    public void trackStub(String str) {
        trackStub(str, false);
    }

    public static String getV8Version() {
        try {
            return JSEngine.getVersion();
        } catch (Throwable unused) {
            return "-";
        }
    }

    public void trackStub(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("V8Worker_JSI_");
        sb.append(str);
        String obj = sb.toString();
        this.mLastTrackId = obj;
        if (this.mApp != null) {
            try {
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, obj);
                AppLogger.log(new WorkerLog.Builder().setAppId(this.mAppId).setTag(obj).setParentId(this.mParentId).setState(z ? "error" : "start").build());
            } catch (Throwable th) {
                String logTag = getLogTag();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("trackStub got exception for ");
                sb2.append(obj);
                RVLogger.e(logTag, sb2.toString(), th);
            }
        }
    }

    public Map<String, String> getPerfLogData() {
        HashMap hashMap = new HashMap();
        long j = sJSEngineInitCost;
        if (j != 0) {
            hashMap.put("v8_engine_cost", String.valueOf(j));
        }
        long j2 = this.mV8InstanceCost;
        if (j2 != 0) {
            hashMap.put("v8_instance_cost", String.valueOf(j2));
        }
        long j3 = this.mAppxResCost;
        if (j3 != 0) {
            hashMap.put("v8_appx_res_cost", String.valueOf(j3));
        }
        long j4 = this.mAppxWorkerJsCost;
        if (j4 != 0) {
            hashMap.put("v8_appx_js_cost", String.valueOf(j4));
        }
        long j5 = this.mBizWorkerJsCost;
        if (j5 != 0) {
            hashMap.put("v8_biz_js_cost", String.valueOf(j5));
        }
        long j6 = this.mBeginWaitH5Page;
        if (j6 != 0) {
            long j7 = this.mEndWaitH5Page;
            if (j7 != 0) {
                hashMap.put("v8_page_wait", V8Utils.deltaString(j6, j7));
            }
        }
        long j8 = this.mWorkerReadyTs;
        if (j8 != 0) {
            long j9 = this.mRenderReadyTs;
            if (j9 != 0) {
                hashMap.put("v8_render_wait", V8Utils.deltaString(j8, j9));
            }
        }
        hashMap.put("v8_type", sV8Type);
        hashMap.put("v8_version", getV8Version());
        hashMap.put("v8_mc", String.valueOf(this.mEnableMessageChannel));
        return hashMap;
    }

    public boolean isMessageChannelEnabled() {
        return this.mEnableMessageChannel;
    }

    public boolean postMessageByMessageChannel(Arguments arguments) {
        if (isMessageChannelEnabled() && isRenderReady()) {
            try {
                JSString jSString = (JSString) arguments.get(0);
                String jSValue = jSString.toString(arguments.getContext());
                jSString.delete();
                if (NXEmbedWebView.POST_MESSAGE_ACTION_TYPE.equals(jSValue)) {
                    JSNumber jSNumber = (JSNumber) arguments.get(1);
                    int asInteger = jSNumber.asInteger();
                    jSNumber.delete();
                    JSValue jSValue2 = arguments.get(2);
                    String jSValue3 = jSValue2.toString(arguments.getContext());
                    jSValue2.delete();
                    return tryPostMessageByMessageChannel(asInteger, jSValue3);
                }
                return false;
            } catch (Throwable th) {
                String logTag = getLogTag();
                StringBuilder sb = new StringBuilder();
                sb.append("postMessageByMessageChannel exception: ");
                sb.append(th);
                RVLogger.e(logTag, sb.toString());
            }
        }
        return false;
    }

    public String generateStack(int i) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.uc.crashsdk.JNIBridge");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("nativeDumpThreads", String.class, Long.TYPE)) == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, String.valueOf(i), 0);
        } catch (Throwable th) {
            RVLogger.e(getLogTag(), "readSmallFile error ", th);
            return "";
        }
    }

    public String readSmallFile(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            try {
                byte[] bArr = new byte[2048];
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    String str2 = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return str2;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    RVLogger.e(getLogTag(), "readSmallFile error ", th);
                    if (fileInputStream == null) {
                        return "";
                    }
                    fileInputStream.close();
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th3;
                }
            }
            fileInputStream.close();
        } catch (IOException unused3) {
            return "";
        }
    }

    private boolean initWatchDogEnable() {
        return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ta_jsi_init_watch_dog_enable", false);
    }

    private void startWatchDog() {
        if (initWatchDogEnable()) {
            if (this.mJSIWatchDogHandler == null) {
                HandlerThread handlerThread = new HandlerThread("JsiInitWatchdog");
                this.mJSIWatchDogHandlerThread = handlerThread;
                handlerThread.start();
                this.mJSIWatchDogHandler = new Handler(this.mJSIWatchDogHandlerThread.getLooper());
            }
            this.mJSIThreadTid = Process.myTid();
            String logTag = getLogTag();
            StringBuilder sb = new StringBuilder();
            sb.append("start jsi watch dog for tid: ");
            sb.append(this.mJSIThreadTid);
            RVLogger.d(logTag, sb.toString());
            this.mJSIWatchDogHandler.postDelayed(this.mInitWatchDog, 3000L);
        }
    }

    public JSContext getBizJSContext() {
        return this.mBizJSContext;
    }

    private void stopWatchDog() {
        if (initWatchDogEnable()) {
            RVLogger.d(getLogTag(), "stop jsi watch dog");
            Handler handler = this.mJSIWatchDogHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mInitWatchDog);
            }
            if (this.mJSIWatchDogHandlerThread != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.mJSIWatchDogHandlerThread.quitSafely();
                } else {
                    this.mJSIWatchDogHandlerThread.quit();
                }
            }
            this.mJSIThreadTid = 0;
        }
    }

    public boolean loadNativePlugins(Arguments arguments) {
        JSValue jSValue;
        if (arguments == null || arguments.count() != 1 || (jSValue = arguments.get(0)) == null) {
            return false;
        }
        if (!jSValue.isArray()) {
            jSValue.delete();
            return false;
        }
        JSArray jSArray = (JSArray) jSValue;
        for (int i = 0; i < jSArray.length(arguments.getContext()); i++) {
            JSValue jSValue2 = jSArray.get(arguments.getContext(), i);
            if (jSValue2 == null) {
                jSArray.delete();
                return false;
            } else if (!jSValue2.isString()) {
                jSArray.delete();
                jSValue2.delete();
                return false;
            } else {
                String jSValue3 = jSValue2.toString(arguments.getContext());
                jSValue2.delete();
                if (!this.mV8NativePlugin.load(jSValue3)) {
                    jSArray.delete();
                    return false;
                }
            }
        }
        jSArray.delete();
        return true;
    }
}
