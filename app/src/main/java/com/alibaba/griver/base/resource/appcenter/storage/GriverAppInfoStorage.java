package com.alibaba.griver.base.resource.appcenter.storage;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.resource.appcenter.storage.AppInfoDao;
import com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverAppInfoStorage {

    /* renamed from: a  reason: collision with root package name */
    private static GriverAppStorageProxy f6352a = new GriverAppSQLiteStorage(new GriverAppInfoDBHelper(GriverEnv.getApplicationContext()));

    public static void saveAppInfo(AppModel appModel) {
        boolean z;
        if (appModel == null || TextUtils.isEmpty(appModel.getAppVersion()) || TextUtils.isEmpty(appModel.getAppId())) {
            GriverLogger.w("GriverAppInfoStorage", "app is not valid, return directly");
            return;
        }
        try {
            List<AppInfoDao> selectAllAppInfo = f6352a.selectAllAppInfo(appModel.getAppId());
            String config = GriverConfig.getConfig(GriverConfigConstants.KEY_APP_POOL_SIZE, "3");
            if (selectAllAppInfo != null && selectAllAppInfo.size() > 0) {
                int intValue = Integer.valueOf("3").intValue();
                try {
                    if (Integer.valueOf(config).intValue() > 0) {
                        intValue = Integer.valueOf(config).intValue();
                    }
                } catch (Exception e) {
                    GriverLogger.e("GriverAppInfoStorage", "parse pool size failed", e);
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
                        GriverLogger.w("GriverAppInfoStorage", sb.toString());
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
                    GriverLogger.d("GriverAppInfoStorage", sb2.toString());
                    Collections.sort(selectAllAppInfo, AppInfoUtils.getAppInfoDaoDescComparator());
                    for (AppInfoDao appInfoDao : selectAllAppInfo.subList(intValue - 1, selectAllAppInfo.size())) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("delete app info that exceeds pool limit, appId: ");
                        sb3.append(appInfoDao.getAppId());
                        sb3.append(", version: ");
                        sb3.append(appInfoDao.getVersion());
                        GriverLogger.d("GriverAppInfoStorage", sb3.toString());
                        f6352a.deleteAppInfo(appInfoDao);
                        String installPath = AppInfoUtils.getInstallPath(appInfoDao.getAppInfo());
                        if (FileUtils.exists(installPath)) {
                            FileUtils.delete(installPath);
                        }
                    }
                }
            }
            AppInfoDao appInfoDao2 = new AppInfoDao();
            appInfoDao2.setAppId(appModel.getAppId());
            appInfoDao2.setVersion(appModel.getAppVersion());
            appInfoDao2.setAppInfo(appModel);
            if (appModel.getExtendInfos().getLong("lastRefreshTimestamp") != null) {
                long longValue = appModel.getExtendInfos().getLong("lastRefreshTimestamp").longValue();
                appInfoDao2.setLastRefreshTimestamp(longValue);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("use pre download timestamp app id is = ");
                sb4.append(appModel.getAppId());
                sb4.append(" time is = ");
                sb4.append(longValue);
                GriverLogger.d("GriverAppInfoStorage", sb4.toString());
            } else {
                appInfoDao2.setLastRefreshTimestamp(System.currentTimeMillis());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("not use pre download timestamp app id is = ");
                sb5.append(appModel.getAppId());
                sb5.append(" time is = ");
                sb5.append(appInfoDao2.getLastRefreshTimestamp());
                GriverLogger.d("GriverAppInfoStorage", sb5.toString());
            }
            f6352a.insertOrUpdateInfo(appInfoDao2);
        } catch (Exception e2) {
            GriverLogger.e("GriverAppInfoStorage", "insert error", e2);
        }
    }

    public static void saveAppInfos(List<AppModel> list) {
        if (list == null || list.size() == 0) {
            GriverLogger.w("GriverAppInfoStorage", "save app infos is empty, return directly");
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
            List<AppInfoDao> selectAllAppInfo = f6352a.selectAllAppInfo(str);
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
            GriverLogger.e("GriverAppInfoStorage", sb.toString(), e);
        }
        return arrayList;
    }

    public static AppModel queryHighestAppInfo(String str) {
        try {
            AppInfoDao selectAppInfoWithHighestVersion = f6352a.selectAppInfoWithHighestVersion(str);
            if (selectAppInfoWithHighestVersion != null) {
                return selectAppInfoWithHighestVersion.getAppInfo();
            }
            return null;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("query highest app for ");
            sb.append(str);
            sb.append(" failed");
            GriverLogger.e("GriverAppInfoStorage", sb.toString(), e);
            return null;
        }
    }

    public static AppModel queryAppInfo(String str, String str2) {
        try {
            AppInfoDao selectAppInfo = f6352a.selectAppInfo(str, str2);
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
            GriverLogger.e("GriverAppInfoStorage", sb.toString(), e);
            return null;
        }
    }

    public static List<AppInfoDao> queryAllAppInfo(String str) {
        try {
            return f6352a.selectAllAppInfo(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("query highest app for ");
            sb.append(str);
            sb.append(" failed");
            GriverLogger.e("GriverAppInfoStorage", sb.toString(), e);
            return null;
        }
    }

    public static void updateAppInfo(AppModel appModel) {
        if (appModel == null) {
            return;
        }
        try {
            AppInfoDao selectAppInfo = f6352a.selectAppInfo(appModel.getAppId(), appModel.getAppVersion());
            if (selectAppInfo != null) {
                selectAppInfo.setAppId(appModel.getAppId());
                selectAppInfo.setVersion(appModel.getAppVersion());
                selectAppInfo.setAppInfo(appModel);
                f6352a.updateInfo(selectAppInfo);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("update app for ");
            sb.append(appModel.getAppId());
            sb.append(" with version: ");
            sb.append(appModel.getAppVersion());
            sb.append(" failed");
            GriverLogger.e("GriverAppInfoStorage", sb.toString(), e);
        }
    }

    public static long queryLastRefreshTimestamp(String str) {
        AppInfoDao appInfoDao;
        try {
            appInfoDao = f6352a.selectAppInfoWithHighestVersion(str);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("query last refresh timestamp for ");
            sb.append(str);
            sb.append(" failed");
            GriverLogger.e("GriverAppInfoStorage", sb.toString());
            appInfoDao = null;
        }
        if (appInfoDao != null) {
            return appInfoDao.getLastRefreshTimestamp();
        }
        return 0L;
    }

    public static void refreshUpdateTime(String str, long j) {
        GriverLogger.w("GriverAppInfoStorage", "refresh update time, do nothing temporarily");
    }

    public static void refreshOpenTime(String str, String str2, long j) {
        try {
            AppInfoDao selectAppInfo = f6352a.selectAppInfo(str, str2);
            if (selectAppInfo != null) {
                selectAppInfo.setAppId(selectAppInfo.getAppId());
                selectAppInfo.setVersion(selectAppInfo.getVersion());
                selectAppInfo.setLastOpenTimestamp(j);
                f6352a.updateInfo(selectAppInfo);
            }
        } catch (Exception e) {
            GriverLogger.w("GriverAppInfoStorage", "update app open time error", e);
        }
    }

    public static List<String> queryLastOpenAppIds(long j, int i) {
        try {
            return f6352a.queryLastOpenAppIds(j, i);
        } catch (Exception e) {
            GriverLogger.w("GriverAppInfoStorage", "update app open time error", e);
            return null;
        }
    }

    public static void setGriverAppStorageProxy(GriverAppStorageProxy griverAppStorageProxy) {
        if (griverAppStorageProxy != null) {
            f6352a = griverAppStorageProxy;
        } else {
            GriverLogger.e("GriverAppInfoStorage", "should not set null GriverAppStorageProxy");
        }
    }

    public static List<AppModel> queryAppAppInfos() {
        List<AppInfoDao> list;
        ArrayList arrayList = null;
        try {
            list = f6352a.selectAllAppInfos();
        } catch (Exception e) {
            GriverLogger.e("GriverAppInfoStorage", "query all app info failed", e);
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

    public static Map getEvent() {
        HashMap hashMap = new HashMap();
        GriverAppStorageProxy griverAppStorageProxy = f6352a;
        return (griverAppStorageProxy == null || !(griverAppStorageProxy instanceof GriverAppSQLiteStorage)) ? hashMap : ((GriverAppSQLiteStorage) griverAppStorageProxy).getEventContent();
    }
}
