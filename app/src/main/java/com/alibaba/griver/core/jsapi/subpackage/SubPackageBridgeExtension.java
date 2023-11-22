package com.alibaba.griver.core.jsapi.subpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.PatternUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.appxng.AppxNgRuntimeChecker;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.parser.PackageParseUtils;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.ariver.resource.subpackage.DefaultSubPackageDownloader;
import com.alibaba.ariver.resource.subpackage.DownloadQueryPoint;
import com.alibaba.ariver.resource.subpackage.ISubPackageDownloader;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverConfig;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class SubPackageBridgeExtension implements BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f6420a = new HashSet();
    private final Map<String, Future<BridgeResponse>> b = new ConcurrentHashMap();

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    protected JSONObject getSubPackage(AppModel appModel) {
        boolean isAppxNgSoloPackage = AppxNgRuntimeChecker.isAppxNgSoloPackage(appModel);
        StringBuilder sb = new StringBuilder();
        sb.append("requreAppxNgSoloPackage getSubPackage ");
        sb.append(isAppxNgSoloPackage);
        sb.append(" appId:");
        sb.append(appModel.getAppId());
        RVLogger.d("AriverRes:SubPackageBridgeExtension", sb.toString());
        AppInfoModel appInfoModel = appModel.getAppInfoModel();
        return isAppxNgSoloPackage ? appInfoModel.getNewSubPackages() : appInfoModel.getSubPackages();
    }

    @ThreadType(ExecutorType.URGENT_DISPLAY)
    @ActionFilter
    public void loadSubPackage(@BindingNode(App.class) App app, @BindingParam({"preload"}) String str, @BindingParam(required = true, value = {"packages"}) JSONArray jSONArray, @BindingCallback BridgeCallback bridgeCallback) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null) {
            RVLogger.w("AriverRes:SubPackageBridgeExtension", "loadSubPackage...non appModel");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "非分包模式_1"));
        } else if (appModel.getAppInfoModel() == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("loadSubPackage...non getAppInfoModel");
            sb.append(appModel);
            RVLogger.w("AriverRes:SubPackageBridgeExtension", sb.toString());
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "非分包模式_2"));
        } else {
            JSONObject subPackage = getSubPackage(appModel);
            if (subPackage == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("loadSubPackage...non getSubPackages");
                sb2.append(appModel);
                RVLogger.w("AriverRes:SubPackageBridgeExtension", sb2.toString());
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "非分包模式_3"));
            } else if ("wifi".equals(str) && !TextUtils.equals("WIFI", NetworkUtil.getDetailNetworkType(app.getAppContext().getContext()))) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("loadSubPackage...networkType is dismatch:");
                sb3.append(str);
                RVLogger.w("AriverRes:SubPackageBridgeExtension", sb3.toString());
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "networkType is dismatch error"));
            } else {
                ArrayList arrayList = new ArrayList();
                boolean z = true;
                for (int i = 0; i < jSONArray.size(); i++) {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        if (TextUtils.isEmpty(subPackage.getString(string))) {
                            if (string.endsWith("/")) {
                                string = string.substring(0, string.length() - 1);
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(string);
                                sb4.append("/");
                                string = sb4.toString();
                            }
                            if (!TextUtils.isEmpty(subPackage.getString(string))) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("loadSubPackage, root path non-match, adapted here, rootAttrib: ");
                                sb5.append(string);
                                sb5.append(" correct rootPath: ");
                                sb5.append(string);
                                RVLogger.d("AriverRes:SubPackageBridgeExtension", sb5.toString());
                            }
                        }
                        if (!this.f6420a.contains(string)) {
                            arrayList.add(string);
                            z = false;
                        }
                    }
                }
                if (z) {
                    onPrepareDone(true, app, appModel);
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                    RVLogger.d("AriverRes:SubPackageBridgeExtension", "loadSubPackage... all packages has loaded.");
                    return;
                }
                a(app, appModel, subPackage, arrayList, bridgeCallback, jSONArray.size() == 1);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.alibaba.ariver.resource.subpackage.ISubPackageDownloader] */
    private void a(final App app, final AppModel appModel, JSONObject jSONObject, List<String> list, final BridgeCallback bridgeCallback, final boolean z) {
        synchronized (this) {
            if (list != null) {
                if (!list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        final String str = list.get(i);
                        final String string = jSONObject.getString(str);
                        final Future<BridgeResponse> future = this.b.get(string);
                        if (future != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("prepareSubPackage reuse task ");
                            sb.append(string);
                            RVLogger.d("AriverRes:SubPackageBridgeExtension", sb.toString());
                            ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alibaba.griver.core.jsapi.subpackage.SubPackageBridgeExtension.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        BridgeResponse bridgeResponse = (BridgeResponse) future.get();
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("prepareSubPackage ");
                                        sb2.append(string);
                                        sb2.append(" got first task result ");
                                        sb2.append(bridgeResponse);
                                        sb2.append(" needSend ");
                                        sb2.append(z);
                                        RVLogger.d("AriverRes:SubPackageBridgeExtension", sb2.toString());
                                        if (z) {
                                            bridgeCallback.sendBridgeResponse(bridgeResponse);
                                        }
                                    } catch (Throwable th) {
                                        RVLogger.e("AriverRes:SubPackageBridgeExtension", "await first task error!", th);
                                    }
                                }
                            });
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = null;
                        final ResultDispatchFuture resultDispatchFuture = new ResultDispatchFuture();
                        this.b.put(string, resultDispatchFuture);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("prepareSubPackage begin task for ");
                        sb2.append(string);
                        RVLogger.d("AriverRes:SubPackageBridgeExtension", sb2.toString());
                        ISubPackageDownloader.Callback callback = new ISubPackageDownloader.Callback() { // from class: com.alibaba.griver.core.jsapi.subpackage.SubPackageBridgeExtension.2
                            @Override // com.alibaba.ariver.resource.subpackage.ISubPackageDownloader.Callback
                            public void onSuccess(String str2) {
                                BridgeResponse error;
                                BridgeCallback bridgeCallback2;
                                try {
                                    SubPackageBridgeExtension.this.a(app, appModel, str2);
                                    error = BridgeResponse.SUCCESS;
                                    SubPackageBridgeExtension.this.f6420a.add(str);
                                    SubPackageBridgeExtension.this.onPrepareDone(true, app, appModel);
                                } catch (Throwable th) {
                                    if (th instanceof ParseFailedException) {
                                        ParseFailedException parseFailedException = th;
                                        ParseContext parseContext = new ParseContext();
                                        parseContext.appId = app.getAppId();
                                        parseContext.packagePath = str2;
                                        parseFailedException.setParseContext(parseContext);
                                        SubPackageBridgeExtension.this.onVerifyError(parseFailedException);
                                    }
                                    SubPackageBridgeExtension.this.onPrepareDone(false, app, appModel);
                                    RVLogger.e("AriverRes:SubPackageBridgeExtension", "prepareSubPackage error ", th);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("prepareSubPackage error");
                                    sb3.append(str);
                                    error = new BridgeResponse.Error(16, sb3.toString());
                                }
                                resultDispatchFuture.setResult(error);
                                if (z && (bridgeCallback2 = bridgeCallback) != null) {
                                    bridgeCallback2.sendBridgeResponse(error);
                                }
                                SubPackageBridgeExtension.this.b.remove(string);
                            }

                            @Override // com.alibaba.ariver.resource.subpackage.ISubPackageDownloader.Callback
                            public void onFail(String str2) {
                                BridgeCallback bridgeCallback2;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("download error");
                                sb3.append(str);
                                BridgeResponse.Error error = new BridgeResponse.Error(14, sb3.toString());
                                if (z && (bridgeCallback2 = bridgeCallback) != null) {
                                    bridgeCallback2.sendBridgeResponse(error);
                                }
                                resultDispatchFuture.setResult(error);
                                SubPackageBridgeExtension.this.b.remove(string);
                            }
                        };
                        DownloadQueryPoint downloadQueryPoint = (DownloadQueryPoint) ExtensionPoint.as(DownloadQueryPoint.class).nullable().create();
                        if (downloadQueryPoint != null) {
                            RVLogger.d("AriverRes:SubPackageBridgeExtension", "packageQueryPoint");
                            anonymousClass1 = downloadQueryPoint.getSubDownloader(appModel, app.getStartParams());
                        }
                        (anonymousClass1 == null ? new DefaultSubPackageDownloader() : anonymousClass1).prepareSubpackage(app.getStartParams(), app, appModel, jSONObject, str, callback);
                    }
                    if (!z) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                    }
                    return;
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("loadSubPackage...no valid root need load: ");
            sb3.append(app.getAppId());
            RVLogger.w("AriverRes:SubPackageBridgeExtension", sb3.toString());
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, "无有效的分包"));
        }
    }

    protected void onVerifyError(ParseFailedException parseFailedException) {
        ParseContext parseContext = parseFailedException.getParseContext();
        if (parseContext != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onVerifyError, delete sub packagePath: ");
            sb.append(parseContext.packagePath);
            RVLogger.w("AriverRes:SubPackageBridgeExtension", sb.toString());
            FileUtils.delete(parseContext.packagePath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(App app, AppModel appModel, String str) throws ParseFailedException {
        if (TextUtils.isEmpty(appModel.getAppId()) || TextUtils.isEmpty(str)) {
            RVLogger.w("AriverRes:SubPackageBridgeExtension", "parseIntoResourceContext callback...appId downloadUrl is null");
            return;
        }
        ParseContext parseContext = new ParseContext();
        parseContext.appId = appModel.getAppId();
        parseContext.onlineHost = appModel.getAppInfoModel().getVhost();
        parseContext.packagePath = str;
        parseContext.ignorePatterns = Collections.singletonList(PatternUtils.compile(RVConstants.FILE_API_PERMISSION));
        parseContext.needVerify = "yes".equalsIgnoreCase(GriverConfig.getConfig(GriverConfigConstants.KEY_SHOULD_VERIFY_APP, "YES"));
        Map<String, Resource> parsePackage = PackageParseUtils.parsePackage(parseContext);
        ResourceContext resourceContext = ResourceContextManager.getInstance().get(appModel.getAppId(), app.getStartToken());
        if (resourceContext == null || resourceContext.getMainPackage() == null) {
            return;
        }
        for (Resource resource : parsePackage.values()) {
            StringBuilder sb = new StringBuilder();
            sb.append("add subPackage resource: ");
            sb.append(resource);
            RVLogger.d("AriverRes:SubPackageBridgeExtension", sb.toString());
            resourceContext.getMainPackage().add(resource);
        }
    }

    protected void onPrepareDone(boolean z, App app, AppModel appModel) {
        ResourceContext resourceContext = ResourceContextManager.getInstance().get(appModel.getAppId(), app.getStartToken());
        String string = (resourceContext == null || resourceContext.getStartParams() == null) ? "" : BundleUtils.getString(resourceContext.getStartParams(), RVParams.START_APP_SESSION_ID);
        AppLog.Builder builder = new AppLog.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append("load subpackage ");
        sb.append(z ? "success" : "fail");
        sb.append(" : ");
        sb.append(appModel.getAppId());
        sb.append("/");
        sb.append(appModel.getAppVersion());
        AppLogger.log(builder.setState(sb.toString()).setAppId(appModel.getAppId()).setParentId(string).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ResultDispatchFuture implements Future<BridgeResponse> {

        /* renamed from: a  reason: collision with root package name */
        private CountDownLatch f6421a;
        private BridgeResponse b;

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        private ResultDispatchFuture() {
            this.f6421a = new CountDownLatch(1);
            this.b = null;
        }

        public void setResult(BridgeResponse bridgeResponse) {
            synchronized (this) {
                StringBuilder sb = new StringBuilder();
                sb.append("ResultDispatchFuture set result ");
                sb.append(bridgeResponse);
                RVLogger.d("AriverRes:SubPackageBridgeExtension", sb.toString());
                this.b = bridgeResponse;
                this.f6421a.countDown();
            }
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f6421a.getCount() == 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Future
        public BridgeResponse get() throws InterruptedException, ExecutionException {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f6421a.await(30L, TimeUnit.SECONDS);
            StringBuilder sb = new StringBuilder();
            sb.append("ResultDispatchFuture wait task dispatch for ");
            sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
            RVLogger.d("AriverRes:SubPackageBridgeExtension", sb.toString());
            return this.b;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Future
        public BridgeResponse get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f6421a.await(j, timeUnit);
            StringBuilder sb = new StringBuilder();
            sb.append("ResultDispatchFuture wait task dispatch for ");
            sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
            RVLogger.d("AriverRes:SubPackageBridgeExtension", sb.toString());
            return this.b;
        }
    }
}
