package com.alibaba.griver.base.resource.appcenter.predownloadstorage;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.resource.appcenter.storage.AppInfoDao;
import com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class GriverAppInfoPreDownloadStorage {

    /* loaded from: classes3.dex */
    public static final class AppStorageProxyHolder {
        static final GriverAppStorageProxy appStorageProxy = new GriverAppPreDownloadSQLiteStorage(new GriverAppInfoPreDownLoadDBHelper(GriverEnv.getApplicationContext()));

        private AppStorageProxyHolder() {
        }
    }

    public static GriverAppStorageProxy getAppStorageProxy() {
        return AppStorageProxyHolder.appStorageProxy;
    }

    public static void saveAppInfo(AppModel appModel) {
        boolean z;
        if (appModel == null || TextUtils.isEmpty(appModel.getAppVersion()) || TextUtils.isEmpty(appModel.getAppId())) {
            GriverLogger.w("GriverAppInfoPreDownloadStorage", "app is not valid, return directly");
            return;
        }
        try {
            List<AppInfoDao> selectAllAppInfo = getAppStorageProxy().selectAllAppInfo(appModel.getAppId());
            String config = GriverConfig.getConfig(GriverConfigConstants.KEY_APP_POOL_SIZE, "3");
            if (selectAllAppInfo != null && selectAllAppInfo.size() > 0) {
                int intValue = Integer.valueOf("3").intValue();
                try {
                    if (Integer.valueOf(config).intValue() > 0) {
                        intValue = Integer.valueOf(config).intValue();
                    }
                } catch (Exception e) {
                    GriverLogger.e("GriverAppInfoPreDownloadStorage", "parse pool size failed", e);
                }
                Iterator<AppInfoDao> it = selectAllAppInfo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    AppInfoDao next = it.next();
                    if (RVResourceUtils.compareVersion(next.getVersion(), appModel.getAppVersion()) > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("app is lower than local, do not save, appId: ");
                        sb.append(appModel.getAppId());
                        sb.append(", version: ");
                        sb.append(appModel.getAppVersion());
                        GriverLogger.w("GriverAppInfoPreDownloadStorage", sb.toString());
                        return;
                    } else if (TextUtils.equals(next.getVersion(), appModel.getAppVersion())) {
                        z = false;
                        break;
                    }
                }
                if (z && selectAllAppInfo.size() >= intValue) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("app in pool exceeds limit size: ");
                    sb2.append(intValue);
                    GriverLogger.d("GriverAppInfoPreDownloadStorage", sb2.toString());
                    Collections.sort(selectAllAppInfo, AppInfoUtils.getAppInfoDaoDescComparator());
                    for (AppInfoDao appInfoDao : selectAllAppInfo.subList(intValue - 1, selectAllAppInfo.size())) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("delete app info that exceeds pool limit, appId: ");
                        sb3.append(appInfoDao.getAppId());
                        sb3.append(", version: ");
                        sb3.append(appInfoDao.getVersion());
                        GriverLogger.d("GriverAppInfoPreDownloadStorage", sb3.toString());
                        getAppStorageProxy().deleteAppInfo(appInfoDao);
                        String installPath = AppInfoUtils.getInstallPath(appInfoDao.getAppInfo());
                        if (FileUtils.exists(installPath)) {
                            FileUtils.delete(installPath);
                        }
                    }
                }
            }
            appModel.getExtendInfos().remove("appxVersion");
            if (GriverAppxNgRuntimeChecker.isUseAppxNg(appModel)) {
                appModel.getExtendInfos().put("appxVersion", "2");
            } else {
                appModel.getExtendInfos().put("appxVersion", "1");
            }
            AppInfoDao appInfoDao2 = new AppInfoDao();
            appInfoDao2.setAppId(appModel.getAppId());
            appInfoDao2.setVersion(appModel.getAppVersion());
            appInfoDao2.setAppInfo(appModel);
            appInfoDao2.setLastRefreshTimestamp(System.currentTimeMillis());
            getAppStorageProxy().insertOrUpdateInfo(appInfoDao2);
        } catch (Exception e2) {
            GriverLogger.e("GriverAppInfoPreDownloadStorage", "insert error", e2);
        }
    }

    public static void deleteAppInfo(AppModel appModel) {
        if (appModel == null || TextUtils.isEmpty(appModel.getAppVersion()) || TextUtils.isEmpty(appModel.getAppId())) {
            GriverLogger.w("GriverAppInfoPreDownloadStorage", "app is not valid, return directly");
            return;
        }
        getAppStorageProxy().deleteAppInfo(getAppStorageProxy().selectAppInfo(appModel.getAppId(), appModel.getAppVersion()));
    }

    public static void saveAppInfos(List<AppModel> list) {
        if (list == null || list.size() == 0) {
            GriverLogger.w("GriverAppInfoPreDownloadStorage", "save app infos is empty, return directly");
            return;
        }
        Iterator<AppModel> it = list.iterator();
        while (it.hasNext()) {
            saveAppInfo(it.next());
        }
    }

    public static List<AppModel> queryAppInfo(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<AppInfoDao> selectAllAppInfo = getAppStorageProxy().selectAllAppInfo(str);
            if (selectAllAppInfo != null && selectAllAppInfo.size() > 0) {
                Iterator<AppInfoDao> it = selectAllAppInfo.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getAppInfo());
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("query app for ");
            sb.append(str);
            sb.append(" failed");
            GriverLogger.e("GriverAppInfoPreDownloadStorage", sb.toString(), e);
        }
        return arrayList;
    }

    public static AppModel queryHighestAppInfo(String str) {
        try {
            AppInfoDao selectAppInfoWithHighestVersion = getAppStorageProxy().selectAppInfoWithHighestVersion(str);
            if (selectAppInfoWithHighestVersion != null) {
                return selectAppInfoWithHighestVersion.getAppInfo();
            }
            return null;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("query highest app for ");
            sb.append(str);
            sb.append(" failed");
            GriverLogger.e("GriverAppInfoPreDownloadStorage", sb.toString(), e);
            return null;
        }
    }

    public static AppModel queryAppInfo(String str, String str2) {
        try {
            AppInfoDao selectAppInfo = getAppStorageProxy().selectAppInfo(str, str2);
            if (selectAppInfo != null) {
                return selectAppInfo.getAppInfo();
            }
            return null;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("query app for ");
            sb.append(str);
            sb.append(" with version: ");
            sb.append(str2);
            sb.append(" failed");
            GriverLogger.e("GriverAppInfoPreDownloadStorage", sb.toString(), e);
            return null;
        }
    }

    public static AppInfoDao queryAppInfoDao(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2 == null) {
            return getAppStorageProxy().selectAppInfoWithHighestVersion(str);
        }
        return getAppStorageProxy().selectAppInfo(str, str2);
    }

    public static long queryLastRefreshTimestamp(String str) {
        AppInfoDao appInfoDao;
        try {
            appInfoDao = getAppStorageProxy().selectAppInfoWithHighestVersion(str);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("query last refresh timestamp for ");
            sb.append(str);
            sb.append(" failed");
            GriverLogger.e("GriverAppInfoPreDownloadStorage", sb.toString());
            appInfoDao = null;
        }
        if (appInfoDao != null) {
            return appInfoDao.getLastRefreshTimestamp();
        }
        return 0L;
    }

    public static AppInfoDao queryAppInfoDao(String str) {
        try {
            return getAppStorageProxy().selectAppInfoWithHighestVersion(str);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("query last refresh timestamp for ");
            sb.append(str);
            sb.append(" failed");
            GriverLogger.e("GriverAppInfoPreDownloadStorage", sb.toString());
            return null;
        }
    }

    public static void refreshUpdateTime(String str, long j) {
        GriverLogger.w("GriverAppInfoPreDownloadStorage", "refresh update time, do nothing temporarily");
    }

    public static List<AppModel> queryAppAppInfos() {
        List<AppInfoDao> list;
        ArrayList arrayList = null;
        try {
            list = getAppStorageProxy().selectAllAppInfos();
        } catch (Exception e) {
            GriverLogger.e("GriverAppInfoPreDownloadStorage", "query all app info failed", e);
            list = null;
        }
        if (list != null && list.size() != 0) {
            arrayList = new ArrayList();
            Iterator<AppInfoDao> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getAppInfo());
            }
        }
        return arrayList;
    }

    public static AppModel queryLastInstall(String str) {
        List<AppModel> queryAppInfo = queryAppInfo(str);
        if (queryAppInfo == null || queryAppInfo.size() == 0) {
            return null;
        }
        for (AppModel appModel : queryAppInfo) {
            if (AppInfoUtils.isInstalled(appModel)) {
                return appModel;
            }
        }
        return null;
    }
}
