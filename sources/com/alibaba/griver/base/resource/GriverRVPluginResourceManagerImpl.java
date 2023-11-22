package com.alibaba.griver.base.resource;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.api.common.network.DownloadRequest;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.alibaba.griver.base.common.utils.GriverConfigUtils;
import com.alibaba.griver.base.common.utils.PluginInfoUtil;
import com.alibaba.griver.base.common.utils.ZipUtils;
import com.alibaba.griver.base.resource.plugin.cache.GriverPluginCacheManager;
import com.alibaba.griver.base.resource.plugin.storage.GriverPluginInfoStorage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public class GriverRVPluginResourceManagerImpl implements RVPluginResourceManager {
    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public void clearPluginUpdateTime(String str) {
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public String getPluginLastUpdateTime(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public void refreshPluginUpdateTime(String str, String str2) {
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public void savePluginModelList(final List<PluginModel> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (PluginModel pluginModel : list) {
            GriverPluginCacheManager.getInstance().savePluginModel(pluginModel.getAppId(), pluginModel.getVersion(), pluginModel);
        }
        GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.base.resource.GriverRVPluginResourceManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    GriverPluginInfoStorage.savePluginInfo((PluginModel) it.next());
                }
            }
        });
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public PluginModel getRequiredPlugin(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.contains("*")) {
            PluginModel highestPlugin = GriverPluginCacheManager.getInstance().getHighestPlugin(str);
            return highestPlugin == null ? GriverPluginInfoStorage.queryHighestPluginInfo(str) : highestPlugin;
        }
        PluginModel selectPluginModel = GriverPluginCacheManager.getInstance().selectPluginModel(str, str2);
        return selectPluginModel == null ? GriverPluginInfoStorage.queryPluginInfo(str, str2) : selectPluginModel;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public boolean isAvailable(AppModel appModel, List<PluginModel> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<PluginModel> it = list.iterator();
        while (it.hasNext()) {
            if (!PluginInfoUtil.installPathExits(a(appModel, it.next()))) {
                return false;
            }
        }
        return true;
    }

    private PluginModel a(AppModel appModel, PluginModel pluginModel) {
        if ("*".equals(pluginModel.getRequireVersion())) {
            PluginModel highestPlugin = GriverPluginCacheManager.INSTANCE.getHighestPlugin(pluginModel.getAppId());
            return highestPlugin != null ? highestPlugin : GriverPluginInfoStorage.queryHighestPluginInfo(pluginModel.getAppId());
        }
        return pluginModel;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public void downloadPlugins(AppModel appModel, List<PluginModel> list, PluginDownloadCallback pluginDownloadCallback) {
        if (appModel == null || list == null || list.isEmpty() || pluginDownloadCallback == null) {
            return;
        }
        Iterator<PluginModel> it = list.iterator();
        while (it.hasNext()) {
            a(appModel, true, it.next(), pluginDownloadCallback);
        }
    }

    private void a(AppModel appModel, boolean z, PluginModel pluginModel, final PluginDownloadCallback pluginDownloadCallback) {
        int transferStringConfigToInt = GriverConfigUtils.transferStringConfigToInt(GriverConfigConstants.KEY_DOWNLOAD_APP_RETRY_TIME, 2);
        DownloadRequest downloadRequest = new DownloadRequest();
        downloadRequest.downloadUrl = pluginModel.getPackageUrl();
        downloadRequest.downloadFilePath = PluginInfoUtil.getDownloadFile(pluginModel).getAbsolutePath();
        downloadRequest.retryTime = transferStringConfigToInt;
        downloadRequest.appId = pluginModel.getAppId();
        downloadRequest.deployVersion = pluginModel.getVersion();
        downloadRequest.version = pluginModel.getDeveloperVersion();
        downloadRequest.urgent = z;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        GriverTransport.download(downloadRequest, new DownloadCallback() { // from class: com.alibaba.griver.base.resource.GriverRVPluginResourceManagerImpl.2
            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onPrepare(String str) {
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onProgress(String str, int i) {
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onCancel(String str) {
                countDownLatch.countDown();
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onFinish(String str) {
                countDownLatch.countDown();
                pluginDownloadCallback.onSuccess();
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onFailed(String str, int i, String str2) {
                countDownLatch.countDown();
                pluginDownloadCallback.onFailed(i, str2);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            GriverLogger.d("RVPluginResourceManager", "download countdown latch release");
        }
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public void installPlugins(AppModel appModel, List<PluginModel> list, PluginInstallCallback pluginInstallCallback) {
        Iterator<PluginModel> it = list.iterator();
        while (it.hasNext()) {
            PluginModel a2 = a(appModel, it.next());
            if (!b(appModel, a2)) {
                if (pluginInstallCallback != null) {
                    pluginInstallCallback.onSingleFailed(a2, 0, "install plugin failed");
                    pluginInstallCallback.onFailed(0, "install plugin failed");
                    return;
                }
                return;
            }
        }
        if (pluginInstallCallback != null) {
            pluginInstallCallback.onSuccess(null);
        }
    }

    private boolean b(AppModel appModel, PluginModel pluginModel) {
        if (pluginModel == null) {
            return false;
        }
        try {
        } catch (Exception unused) {
            FileUtils.delete(PluginInfoUtil.getInstallPath(pluginModel));
            FileUtils.delete(PluginInfoUtil.getDownloadFile(pluginModel));
        }
        if (PluginInfoUtil.installPathExist(pluginModel)) {
            return true;
        }
        File downloadFile = PluginInfoUtil.getDownloadFile(pluginModel);
        String installPath = PluginInfoUtil.getInstallPath(pluginModel);
        if (FileUtils.exists(downloadFile)) {
            if (FileUtils.exists(installPath)) {
                FileUtils.delete(installPath);
            }
            boolean unZip = ZipUtils.unZip(downloadFile.getAbsolutePath(), installPath);
            StringBuilder sb = new StringBuilder();
            sb.append("install Plugin ");
            sb.append(pluginModel.getAppId());
            sb.append(" unzip (");
            sb.append(unZip);
            sb.append(") ");
            sb.append(installPath);
            sb.append(" spend ");
            sb.append(System.currentTimeMillis());
            GriverLogger.d("RVPluginResourceManager", sb.toString());
            if (unZip && PluginInfoUtil.installPathExist(pluginModel)) {
                FileUtils.delete(downloadFile);
                for (String str : PluginInfoUtil.getAllInstallFIles(pluginModel.getAppId())) {
                    if (!TextUtils.equals(str, installPath)) {
                        FileUtils.delete(str);
                    }
                }
                return true;
            }
            FileUtils.delete(installPath);
            FileUtils.delete(downloadFile);
            return false;
        }
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public String getInstallPath(AppModel appModel, PluginModel pluginModel) {
        if (appModel == null || pluginModel == null) {
            return null;
        }
        return PluginInfoUtil.getInstallPath(pluginModel);
    }
}
