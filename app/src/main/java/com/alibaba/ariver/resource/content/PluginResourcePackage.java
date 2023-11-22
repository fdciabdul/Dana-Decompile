package com.alibaba.ariver.resource.content;

import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.model.PluginParamModel;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.LowMemoryUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.parser.ParseContext;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class PluginResourcePackage extends BaseStoragePackage {
    protected String LOG_TAG;

    /* renamed from: a  reason: collision with root package name */
    private RVPluginResourceManager f6227a = (RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class);
    protected boolean mAlreadySetup;
    protected AppModel mAppModel;
    protected String mOnlineHost;
    protected PluginModel mPluginModel;
    protected ResourceContext mResourceContext;

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        return false;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    protected boolean needWaitSetupWhenGet() {
        return true;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void reload() {
    }

    public PluginResourcePackage(AppModel appModel, PluginModel pluginModel, ResourceContext resourceContext) {
        this.mAppModel = appModel;
        this.mPluginModel = pluginModel;
        this.mResourceContext = resourceContext;
        StringBuilder sb = new StringBuilder();
        sb.append("AriverRes:PluginPackage_");
        sb.append(pluginModel.getAppId());
        sb.append("_");
        sb.append(pluginModel.getVersion());
        this.LOG_TAG = sb.toString();
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public String getLogTag() {
        return this.LOG_TAG;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void setup(boolean z) {
        ResourceContext resourceContext = this.mResourceContext;
        if (resourceContext == null) {
            throw new IllegalStateException("plugin resource cannot setup without app context");
        }
        if (resourceContext.getApp().isExited()) {
            RVLogger.w(this.LOG_TAG, "app isExited!");
        } else if (this.mResourceContext.getMainPackageInfo() == null) {
            throw new IllegalStateException("plugin resource cannot setup without app main packageInfo");
        } else {
            if (this.mAlreadySetup) {
                RVLogger.w(this.LOG_TAG, "already setupted!");
                return;
            }
            String vhost = this.mResourceContext.getMainPackageInfo().getAppInfoModel().getVhost();
            StringBuilder sb = new StringBuilder();
            sb.append("__plugins__/");
            sb.append(this.mPluginModel.getAppId());
            this.mOnlineHost = FileUtils.combinePath(vhost, sb.toString());
            this.mAlreadySetup = true;
            String str = this.LOG_TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("begin setup with lock: ");
            sb2.append(z);
            RVLogger.d(str, sb2.toString());
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                RVLogger.w(this.LOG_TAG, "prepareContent with lock!");
            }
            List<PluginModel> singletonList = Collections.singletonList(this.mPluginModel);
            boolean isAvailable = this.f6227a.isAvailable(this.mAppModel, singletonList);
            String str2 = this.LOG_TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("prepareContent appId:");
            sb3.append(this.mPluginModel.getAppId());
            sb3.append(" appVersion ");
            sb3.append(this.mPluginModel.getVersion());
            sb3.append(" installed:");
            sb3.append(isAvailable);
            RVLogger.d(str2, sb3.toString());
            if (isAvailable) {
                parseContent(this.mPluginModel.getAppId(), this.f6227a.getInstallPath(this.mAppModel, this.mPluginModel));
            } else {
                RVPluginResourceManager rVPluginResourceManager = this.f6227a;
                AppModel appModel = this.mAppModel;
                rVPluginResourceManager.downloadPlugins(appModel, singletonList, new MyPluginDownloadCallback(appModel, this.mPluginModel));
            }
            if (z) {
                try {
                    getSetupLock().await(5L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    RVLogger.w(this.LOG_TAG, "prepareContent block error", e);
                }
                String str3 = this.LOG_TAG;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("prepareContent block ");
                sb4.append(System.currentTimeMillis() - currentTimeMillis);
                sb4.append(" ms");
                RVLogger.d(str3, sb4.toString());
            }
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.onlineHost = this.mOnlineHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void afterParsePackage(ParseContext parseContext) {
        App app;
        AppConfigModel parseFromJSON;
        super.afterParsePackage(parseContext);
        ResourceContext resourceContext = this.mResourceContext;
        if (resourceContext == null || (app = resourceContext.getApp()) == null) {
            return;
        }
        Resource resource = get(ResourceQuery.asUrl(RVConstants.FILE_APP_CONFIG).setNeedAutoCompleteHost());
        if (resource != null && (parseFromJSON = AppConfigModel.parseFromJSON(resource.getBytes())) != null && parseFromJSON.getPageLaunchParams() != null) {
            ((PluginParamModel) app.getData(PluginParamModel.class, true)).putPluginConfig(this.mPluginModel.getAppId(), parseFromJSON);
        }
        ((PluginPackageParsedPoint) ExtensionPoint.as(PluginPackageParsedPoint.class).node(app).create()).onPluginParsed(this.mResourceContext.getMainPackageInfo(), this.mPluginModel, this);
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(ResourceQuery resourceQuery) {
        String str = resourceQuery.pureUrl;
        if (resourceQuery.isNeedAutoCompleteHost() && !TextUtils.isEmpty(this.mOnlineHost)) {
            str = FileUtils.combinePath(this.mOnlineHost, resourceQuery.pureUrl);
        }
        try {
            return super.getFromStorage(str);
        } finally {
            if (LowMemoryUtils.onLowMemoryMode && LowMemoryUtils.removePluginIndexWorkerJs && str.endsWith("index.worker.js")) {
                String logTag = getLogTag();
                StringBuilder sb = new StringBuilder();
                sb.append("onLowMemoryMode, remove from pkg: ");
                sb.append(str);
                RVLogger.w(logTag, sb.toString());
                this.mStorage.remove(str);
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public String appId() {
        return this.mPluginModel.getAppId();
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public String version() {
        return this.mPluginModel.getDeveloperVersion();
    }

    public PluginModel getPluginModel() {
        return this.mPluginModel;
    }

    /* loaded from: classes6.dex */
    class MyPluginDownloadCallback implements PluginDownloadCallback {

        /* renamed from: a  reason: collision with root package name */
        private final PluginModel f6228a;
        private final AppModel b;

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onSingleFailed(PluginModel pluginModel, int i, String str) {
        }

        MyPluginDownloadCallback(AppModel appModel, PluginModel pluginModel) {
            this.b = appModel;
            this.f6228a = pluginModel;
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onSuccess() {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.resource.content.PluginResourcePackage.MyPluginDownloadCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    ((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)).installPlugins(MyPluginDownloadCallback.this.b, Collections.singletonList(MyPluginDownloadCallback.this.f6228a), new PluginInstallCallback() { // from class: com.alibaba.ariver.resource.content.PluginResourcePackage.MyPluginDownloadCallback.1.1
                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSingleFailed(PluginModel pluginModel, int i, String str) {
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSuccess(List<Pair<PluginModel, String>> list) {
                            RVLogger.d(PluginResourcePackage.this.LOG_TAG, "installPlugins onSuccess");
                            PluginResourcePackage.this.parseContent(MyPluginDownloadCallback.this.f6228a.getAppId(), PluginResourcePackage.this.f6227a.getInstallPath(MyPluginDownloadCallback.this.b, MyPluginDownloadCallback.this.f6228a));
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onFailed(int i, String str) {
                            String str2 = PluginResourcePackage.this.LOG_TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("installPlugins onFailed ");
                            sb.append(i);
                            sb.append(", ");
                            sb.append(str);
                            RVLogger.w(str2, sb.toString());
                            PluginResourcePackage.this.onPrepareDone(false);
                            PluginResourcePackage.this.onParseDone();
                        }
                    });
                }
            });
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onFailed(int i, String str) {
            String str2 = PluginResourcePackage.this.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onFailed ");
            sb.append(i);
            sb.append(" ");
            sb.append(str);
            RVLogger.w(str2, sb.toString());
            PluginResourcePackage.this.onPrepareDone(false);
            PluginResourcePackage.this.onParseDone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onPrepareDone(boolean z) {
        String str;
        super.onPrepareDone(z);
        ResourceContext resourceContext = this.mResourceContext;
        String str2 = "";
        String string = (resourceContext == null || resourceContext.getStartParams() == null) ? "" : BundleUtils.getString(this.mResourceContext.getStartParams(), RVParams.START_APP_SESSION_ID);
        PluginModel pluginModel = this.mPluginModel;
        if (pluginModel != null) {
            str2 = pluginModel.getAppId();
            str = this.mPluginModel.getVersion();
        } else {
            str = "";
        }
        AppLog.Builder builder = new AppLog.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append("load plugin ");
        sb.append(z ? "success" : "fail");
        sb.append(" : ");
        sb.append(str2);
        sb.append("/");
        sb.append(str);
        AppLogger.log(builder.setState(sb.toString()).setAppId(str2).setParentId(string).build());
    }
}
