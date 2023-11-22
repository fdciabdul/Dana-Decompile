package com.alibaba.griver.base.resource;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ProcessLock;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.resource.api.PackageDownloadCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.api.common.network.DownloadRequest;
import com.alibaba.griver.api.resource.ResourceConstants;
import com.alibaba.griver.api.ui.GriverAppExtension;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.executor.AbstractPriorityRunnable;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.GriverConfigUtils;
import com.alibaba.griver.base.common.utils.ZipUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.resource.predownload.AppPreDownloadManager;
import com.alibaba.griver.base.resource.preset.GriverMiniAppPreset;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public class GriverRVResourceManagerImpl implements RVResourceManager {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentMap<String, PackageDownloadCallback> f6345a = new ConcurrentHashMap();

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public boolean isAvailable(AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null) {
            GriverLogger.w("RVResourceManager", "query app install but app model is null, return false");
            return false;
        }
        boolean installPathValid = AppInfoUtils.installPathValid(getInstallPath(appModel));
        StringBuilder sb = new StringBuilder();
        sb.append("isAvailable appid = ");
        sb.append(appModel.getAppId());
        sb.append(" appversion = ");
        sb.append(appModel.getAppVersion());
        sb.append(" installed = ");
        sb.append(installPathValid);
        GriverLogger.d("UsePackage", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isInstalled appId: ");
        sb2.append(appModel.getAppId());
        sb2.append(", version: ");
        sb2.append(appModel.getAppVersion());
        sb2.append(", installed: ");
        sb2.append(installPathValid);
        sb2.append(", path: ");
        sb2.append(getInstallPath(appModel));
        GriverLogger.d("RVResourceManager", sb2.toString());
        return installPathValid;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public boolean isDownloaded(AppModel appModel) {
        File downloadFile;
        if (appModel == null || appModel.getAppInfoModel() == null) {
            GriverLogger.w("RVResourceManager", "query app isDownload but app model is null, return false");
            return false;
        }
        if (AppPreDownloadManager.appConfigIsEnable()) {
            downloadFile = AppInfoUtils.getPreDownloadFile(appModel);
            StringBuilder sb = new StringBuilder();
            sb.append("isDownloaded use pre appid = ");
            sb.append(appModel.getAppId());
            sb.append(" appversion = ");
            sb.append(appModel.getAppVersion());
            GriverLogger.d("UsePackage", sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isDownloaded use before appid = ");
            sb2.append(appModel.getAppId());
            sb2.append(" appversion = ");
            sb2.append(appModel.getAppVersion());
            GriverLogger.d("UsePackage", sb2.toString());
            downloadFile = AppInfoUtils.getDownloadFile(appModel);
        }
        boolean exists = FileUtils.exists(downloadFile);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("isDownloaded appId: ");
        sb3.append(appModel.getAppId());
        sb3.append(", version: ");
        sb3.append(appModel.getAppVersion());
        sb3.append(", downloaded: ");
        sb3.append(exists);
        sb3.append(", path: ");
        sb3.append(downloadFile.getAbsolutePath());
        GriverLogger.d("RVResourceManager", sb3.toString());
        return exists;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public void downloadApp(final AppModel appModel, final boolean z, final PackageDownloadCallback packageDownloadCallback) {
        if (appModel == null || appModel.getAppInfoModel() == null) {
            GriverLogger.w("RVResourceManager", "download app but app model is null, callback fail");
            if (packageDownloadCallback != null) {
                packageDownloadCallback.onFailed(null, 0, "app model is null");
                return;
            }
            return;
        }
        GriverExecutors.getSingleOrderThreadExecutorByName(AppInfoUtils.getInstallThreadName(appModel.getAppId())).execute(new AbstractPriorityRunnable(5) { // from class: com.alibaba.griver.base.resource.GriverRVResourceManagerImpl.1
            @Override // com.alibaba.griver.base.common.executor.AbstractPriorityRunnable
            public void runTask() {
                GriverStageMonitor stageMonitor;
                if (GriverRVResourceManagerImpl.this.isAvailable(appModel)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("already installed, callback finish, appId: ");
                    sb.append(appModel.getAppId());
                    GriverLogger.d("RVResourceManager", sb.toString());
                    PackageDownloadCallback packageDownloadCallback2 = packageDownloadCallback;
                    if (packageDownloadCallback2 != null) {
                        packageDownloadCallback2.onFinish(null);
                    }
                    PackageDownloadCallback packageDownloadCallback3 = (PackageDownloadCallback) GriverRVResourceManagerImpl.this.f6345a.get(appModel.getAppId());
                    if (packageDownloadCallback3 != null) {
                        packageDownloadCallback3.onFinish(null);
                    }
                } else if (GriverRVResourceManagerImpl.this.isDownloaded(appModel)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("download app: ");
                    sb2.append(appModel.getAppId());
                    sb2.append(", but is downloaded, just callback finish");
                    GriverLogger.d("RVResourceManager", sb2.toString());
                    if (packageDownloadCallback != null) {
                        if (AppPreDownloadManager.isPreDownloadFileAvailable(appModel)) {
                            packageDownloadCallback.onFinish(AppInfoUtils.getPreDownloadFile(appModel).getAbsolutePath());
                        } else {
                            packageDownloadCallback.onFinish(AppInfoUtils.getDownloadFile(appModel).getAbsolutePath());
                        }
                    }
                    PackageDownloadCallback packageDownloadCallback4 = (PackageDownloadCallback) GriverRVResourceManagerImpl.this.f6345a.get(appModel.getAppId());
                    if (packageDownloadCallback4 != null) {
                        packageDownloadCallback4.onFinish(AppInfoUtils.getDownloadFile(appModel).getAbsolutePath());
                    }
                } else if (GriverMiniAppPreset.installPresetPackage(appModel)) {
                    App appByAppId = ((GriverAppExtension) RVProxy.get(GriverAppExtension.class)).getAppByAppId(appModel.getAppId());
                    if (appByAppId != null && (stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(appByAppId))) != null) {
                        stageMonitor.addParam(GriverMonitorConstants.KEY_AMR_PRESET, Boolean.TRUE);
                    }
                    PackageDownloadCallback packageDownloadCallback5 = packageDownloadCallback;
                    if (packageDownloadCallback5 != null) {
                        packageDownloadCallback5.onFinish(null);
                    }
                    PackageDownloadCallback packageDownloadCallback6 = (PackageDownloadCallback) GriverRVResourceManagerImpl.this.f6345a.get(appModel.getAppId());
                    if (packageDownloadCallback6 != null) {
                        packageDownloadCallback6.onFinish(null);
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("start download app: ");
                    sb3.append(appModel.getAppId());
                    GriverLogger.d("RVResourceManager", sb3.toString());
                    GriverRVResourceManagerImpl.this.a(appModel, z, packageDownloadCallback, null);
                }
            }
        });
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public void downloadApp(AppModel appModel, boolean z, PackageDownloadCallback packageDownloadCallback, Bundle bundle) {
        if (!isDownloaded(appModel)) {
            a(appModel, z, packageDownloadCallback, bundle);
        } else if (packageDownloadCallback != null) {
            packageDownloadCallback.onFinish(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AppModel appModel, boolean z, final PackageDownloadCallback packageDownloadCallback, Bundle bundle) {
        if (appModel == null || packageDownloadCallback == null) {
            return;
        }
        int transferStringConfigToInt = GriverConfigUtils.transferStringConfigToInt(GriverConfigConstants.KEY_DOWNLOAD_APP_RETRY_TIME, 2);
        DownloadRequest downloadRequest = new DownloadRequest();
        downloadRequest.downloadUrl = GriverAppxNgRuntimeChecker.getPackageUrl(appModel);
        downloadRequest.downloadFilePath = AppInfoUtils.getDownloadFile(appModel).getAbsolutePath();
        downloadRequest.retryTime = transferStringConfigToInt;
        downloadRequest.appId = appModel.getAppId();
        downloadRequest.version = AppInfoUtils.getDeveloperVersion(appModel);
        downloadRequest.deployVersion = appModel.getAppVersion();
        downloadRequest.urgent = z;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        GriverTransport.download(downloadRequest, new DownloadCallback() { // from class: com.alibaba.griver.base.resource.GriverRVResourceManagerImpl.2
            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onPrepare(String str) {
                packageDownloadCallback.onPrepare(str);
                PackageDownloadCallback packageDownloadCallback2 = (PackageDownloadCallback) GriverRVResourceManagerImpl.this.f6345a.get(appModel.getAppId());
                if (packageDownloadCallback2 != null) {
                    packageDownloadCallback2.onPrepare(str);
                }
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onProgress(String str, int i) {
                packageDownloadCallback.onProgress(str, i);
                PackageDownloadCallback packageDownloadCallback2 = (PackageDownloadCallback) GriverRVResourceManagerImpl.this.f6345a.get(appModel.getAppId());
                if (packageDownloadCallback2 != null) {
                    packageDownloadCallback2.onProgress(str, i);
                }
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onCancel(String str) {
                countDownLatch.countDown();
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onFinish(String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("download finished, release countdown, path: ");
                sb.append(str);
                GriverLogger.d("RVResourceManager", sb.toString());
                countDownLatch.countDown();
                packageDownloadCallback.onFinish(str);
                GriverRVResourceManagerImpl.resourceTypeMonitor(appModel.getAppId());
                PackageDownloadCallback packageDownloadCallback2 = (PackageDownloadCallback) GriverRVResourceManagerImpl.this.f6345a.get(appModel.getAppId());
                if (packageDownloadCallback2 != null) {
                    packageDownloadCallback2.onFinish(str);
                }
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onFailed(String str, int i, String str2) {
                countDownLatch.countDown();
                packageDownloadCallback.onFailed(str, i, str2);
                PackageDownloadCallback packageDownloadCallback2 = (PackageDownloadCallback) GriverRVResourceManagerImpl.this.f6345a.get(appModel.getAppId());
                if (packageDownloadCallback2 != null) {
                    packageDownloadCallback2.onFailed(str, i, str2);
                }
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            GriverLogger.e("RVResourceManager", "download countdown latch release");
        }
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public void deleteDownloadPackage(AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null) {
            GriverLogger.w("RVResourceManager", "delete download file but app model is null, do nothing");
            return;
        }
        File downloadFile = AppInfoUtils.getDownloadFile(appModel);
        if (FileUtils.exists(downloadFile)) {
            StringBuilder sb = new StringBuilder();
            sb.append("delete download file for appId: ");
            sb.append(appModel.getAppId());
            sb.append(", version: ");
            sb.append(appModel.getAppVersion());
            GriverLogger.d("RVResourceManager", sb.toString());
            FileUtils.delete(downloadFile);
        }
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public void installApp(final AppModel appModel, final PackageInstallCallback packageInstallCallback) {
        if (appModel == null || appModel.getAppInfoModel() == null) {
            if (packageInstallCallback != null) {
                packageInstallCallback.onResult(false, "app model is null");
            }
            GriverLogger.e("RVResourceManager", "app model is null, install app failed");
            return;
        }
        GriverExecutors.getSingleOrderThreadExecutorByName(AppInfoUtils.getInstallThreadName(appModel.getAppId())).execute(new AbstractPriorityRunnable(5) { // from class: com.alibaba.griver.base.resource.GriverRVResourceManagerImpl.3
            @Override // com.alibaba.griver.base.common.executor.AbstractPriorityRunnable
            public void runTask() {
                if (!GriverRVResourceManagerImpl.this.isAvailable(appModel)) {
                    boolean a2 = GriverRVResourceManagerImpl.this.a(appModel);
                    if (packageInstallCallback != null) {
                        packageInstallCallback.onResult(a2, AppInfoUtils.getInstallPath(appModel));
                    }
                } else if (packageInstallCallback != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("app has been installed, do not install again, appId: ");
                    sb.append(appModel.getAppId());
                    sb.append(", version: ");
                    sb.append(appModel.getAppVersion());
                    GriverLogger.d("RVResourceManager", sb.toString());
                    packageInstallCallback.onResult(true, AppInfoUtils.getInstallPath(appModel));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AppModel appModel) {
        File file;
        File downloadFile;
        if (appModel == null || appModel.getAppInfoModel() == null) {
            GriverLogger.w("RVResourceManager", "install app but app model is null");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            e = e;
            file = null;
        }
        try {
            if (AppPreDownloadManager.appConfigIsEnable() && AppPreDownloadManager.isPreDownloadFileAvailable(appModel)) {
                downloadFile = AppInfoUtils.getPreDownloadFile(appModel);
                StringBuilder sb = new StringBuilder();
                sb.append("griver use pre download file to install ,file path is = ");
                sb.append(downloadFile.getAbsolutePath());
                GriverLogger.d("RVResourceManager", sb.toString());
                HashMap hashMap = new HashMap();
                hashMap.put("appId", appModel.getAppId());
                GriverMonitor.event(GriverMonitorConstants.USE_PRE_DOWNLOAD_PACKAGE, "GriverAppContainer", hashMap);
            } else {
                downloadFile = AppInfoUtils.getDownloadFile(appModel);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("griver use original download file to install ,file path is = ");
                sb2.append(downloadFile.getAbsolutePath());
                GriverLogger.d("RVResourceManager", sb2.toString());
            }
            String installPath = AppInfoUtils.getInstallPath(appModel);
            if (FileUtils.exists(downloadFile)) {
                ProcessLock processLock = AppInfoUtils.isCommonRes(appModel.getAppId()) ? new ProcessLock(downloadFile) : null;
                if (processLock != null) {
                    processLock.lock();
                    GriverLogger.d("RVResourceManager", "common resource locked!");
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (FileUtils.exists(installPath)) {
                    FileUtils.delete(installPath);
                }
                boolean unZip = ZipUtils.unZip(downloadFile.getAbsolutePath(), installPath);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("installApp ");
                sb3.append(appModel.getAppId());
                sb3.append(" unzip (");
                sb3.append(unZip);
                sb3.append(") ");
                sb3.append(installPath);
                sb3.append(" spend ");
                sb3.append(System.currentTimeMillis() - currentTimeMillis2);
                GriverLogger.d("RVResourceManager", sb3.toString());
                if (unZip && AppInfoUtils.installPathExist(appModel)) {
                    FileUtils.delete(downloadFile);
                    for (String str : AppInfoUtils.getAllInstallFiles(appModel.getAppId())) {
                        if (!TextUtils.equals(str, installPath)) {
                            FileUtils.delete(str);
                        }
                    }
                    if (processLock != null) {
                        processLock.unlock();
                        GriverLogger.d("RVResourceManager", "common resource unlocked!");
                    }
                    GriverMonitor.event(GriverMonitorConstants.EVENT_UNZIP_SUCCESS, "GriverAppContainer", new MonitorMap.Builder().appId(appModel.getAppId()).version(appModel).cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis)).needAsynAppType(true).build());
                    return true;
                }
                FileUtils.delete(installPath);
                FileUtils.delete(downloadFile);
                GriverMonitor.error(GriverMonitorConstants.ERROR_UNZIP_FAIL, "GriverAppContainer", new MonitorMap.Builder().appId(appModel.getAppId()).version(appModel).cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis)).installPath(installPath).message(GriverMonitorConstants.MESSAGE_UNZIP_DOWNLOADED_RESULT_ERROR).needAsynAppType(true).build());
                return false;
            }
        } catch (Exception e2) {
            e = e2;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("install app failed, appId: ");
            sb4.append(appModel.getAppId());
            sb4.append(", version: ");
            sb4.append(appModel.getAppVersion());
            GriverLogger.e("RVResourceManager", sb4.toString(), e);
            GriverMonitor.error(GriverMonitorConstants.ERROR_UNZIP_FAIL, "GriverAppContainer", new MonitorMap.Builder().appId(appModel.getAppId()).version(appModel).cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis)).installPath(AppInfoUtils.getInstallPath(appModel)).exception(e).message(GriverMonitorConstants.MESSAGE_UNZIP_DOWNLOADED_ERROR).needAsynAppType(true).downloadPath(0 != 0 ? file.getAbsolutePath() : null).build());
            FileUtils.delete(AppInfoUtils.getInstallPath(appModel));
            FileUtils.delete(AppInfoUtils.getDownloadFile(appModel));
            return false;
        }
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public String getInstallPath(AppModel appModel) {
        String installPath;
        if (appModel == null || appModel.getAppInfoModel() == null) {
            GriverLogger.w("RVResourceManager", "app model is null, return null install path");
            return null;
        }
        if (AppInfoUtils.isEmbeddedApp(appModel)) {
            AppModel appModel2 = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(ResourceConstants.TINY_WEB_EMBEDDED_APPID));
            installPath = appModel2 != null ? AppInfoUtils.getInstallPath(appModel2) : "";
        } else {
            installPath = AppInfoUtils.getInstallPath(appModel);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("get install path, appId: ");
        sb.append(appModel.getAppId());
        sb.append(", version: ");
        sb.append(appModel.getAppVersion());
        sb.append(", path: ");
        sb.append(installPath);
        GriverLogger.d("RVResourceManager", sb.toString());
        return installPath;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public String getInstalledAppVersion(String str) {
        AppModel queryHighestAppInfo = GriverAppCenter.queryHighestAppInfo(str);
        if (queryHighestAppInfo != null) {
            return queryHighestAppInfo.getAppVersion();
        }
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public void deleteInstallStatus(String str) {
        List<AppModel> queryAppInfo = GriverAppCenter.queryAppInfo(str);
        if (queryAppInfo == null || queryAppInfo.size() <= 0) {
            return;
        }
        for (AppModel appModel : queryAppInfo) {
            StringBuilder sb = new StringBuilder();
            sb.append("delete install files for appId: ");
            sb.append(appModel.getAppId());
            sb.append(", version: ");
            sb.append(appModel.getAppVersion());
            GriverLogger.d("RVResourceManager", sb.toString());
            FileUtils.delete(getInstallPath(appModel));
        }
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public String getRootInstallPath(String str) {
        AppModel queryHighestAppInfo = GriverAppCenter.queryHighestAppInfo(str);
        if (queryHighestAppInfo == null) {
            return null;
        }
        return AppInfoUtils.getInstallPath(queryHighestAppInfo);
    }

    public static void resourceTypeMonitor(String str) {
        GriverStageMonitor stageMonitor;
        StringBuilder sb = new StringBuilder();
        sb.append("resourceTypeMonitor, appId: ");
        sb.append(str);
        GriverLogger.d("RVResourceManager", sb.toString());
        App appByAppId = ((GriverAppExtension) RVProxy.get(GriverAppExtension.class)).getAppByAppId(str);
        if (appByAppId == null || (stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(appByAppId))) == null) {
            return;
        }
        stageMonitor.addParam(GriverMonitorConstants.KEY_APP_SOURCE_TYPE, GriverMonitorConstants.MINI_PROGRAM_APP_SOURCE_TYPE_REMOTE);
    }

    public void addDownloadCallback(String str, PackageDownloadCallback packageDownloadCallback) {
        this.f6345a.put(str, packageDownloadCallback);
    }

    public void removeDownloadCallback(String str) {
        this.f6345a.remove(str);
    }
}
