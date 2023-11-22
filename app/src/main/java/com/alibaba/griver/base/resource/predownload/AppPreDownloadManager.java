package com.alibaba.griver.base.resource.predownload;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.config.GriverConfigProxy;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.resource.appcenter.storage.AppInfoDao;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.AbstractPriorityRunnable;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.resource.appcenter.predownloadstorage.GriverAppInfoPreDownloadStorage;
import com.alibaba.griver.base.resource.appcenter.storage.GriverAppInfoStorage;
import com.alibaba.griver.base.resource.predownload.AppPreDownloadConfig;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class AppPreDownloadManager {
    public static final String PRE_DOWNLOAD_FIRE_MOMENT_INIT = "griverInit";
    public static final String PRE_DOWNLOAD_FIRE_MOMENT_IN_BACKGROUND = "appInBackground";
    public static final String TAG = "AppPreDownloadManager";

    /* renamed from: a  reason: collision with root package name */
    private static AppPreDownloadConfig f6373a;
    private static volatile boolean b;
    private static final Object c = new Object();
    private static int d;

    static /* synthetic */ int access$208() {
        int i = d;
        d = i + 1;
        return i;
    }

    static /* synthetic */ int access$210() {
        int i = d;
        d = i - 1;
        return i;
    }

    public static boolean appConfigIsEnable() {
        AppPreDownloadConfig appPreDownloadConfig = f6373a;
        if (appPreDownloadConfig == null) {
            return false;
        }
        return appPreDownloadConfig.enabled;
    }

    public static void start(final Application application) {
        GriverInnerConfig.getConfig(GriverConfigConstants.APP_PREDOWNLOAD_CONFIG, "", new GriverConfigProxy.OnConfigChangeListener() { // from class: com.alibaba.griver.base.resource.predownload.AppPreDownloadManager.1
            @Override // com.alibaba.griver.api.common.config.GriverConfigProxy.OnConfigChangeListener
            public final void onChange(String str) {
                if (str != null) {
                    try {
                        AppPreDownloadConfig unused = AppPreDownloadManager.f6373a = (AppPreDownloadConfig) JSON.parseObject(str, AppPreDownloadConfig.class);
                        if (AppPreDownloadManager.f6373a.disableUpdateOnAMCS) {
                            return;
                        }
                        AppPreDownloadManager.a(false);
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("AppPreDownloadManager#getSectionConfigWithListener error ");
                        sb.append(th);
                        GriverLogger.e(AppPreDownloadManager.TAG, sb.toString());
                    }
                }
            }
        });
        a(true);
        d = getRunningActivityCount(application);
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.alibaba.griver.base.resource.predownload.AppPreDownloadManager.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStarted(Activity activity) {
                AppPreDownloadManager.access$208();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStopped(Activity activity) {
                AppPreDownloadManager.access$210();
                if (AppPreDownloadManager.d != 0 || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                try {
                    ((JobScheduler) application.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(0, new ComponentName(application, AppPreDownloadJobSchedulerService.class)).setMinimumLatency(0L).setRequiredNetworkType(1).build());
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("e =");
                    sb.append(th);
                    GriverLogger.e(AppPreDownloadManager.TAG, sb.toString());
                }
            }
        });
    }

    public static int getRunningActivityCount(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        int i = 0;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null && runningTaskInfo.baseActivity != null && runningTaskInfo.baseActivity.getPackageName() != null && runningTaskInfo.baseActivity.getPackageName().equals(context.getPackageName())) {
                        i = runningTaskInfo.numActivities;
                    }
                }
            }
        } catch (Exception unused) {
            GriverLogger.e(TAG, "preDownload fail");
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final boolean z) {
        if (b) {
            return;
        }
        GriverExecutors.getExecutor(ExecutorType.NORMAL).execute(new AbstractPriorityRunnable(5) { // from class: com.alibaba.griver.base.resource.predownload.AppPreDownloadManager.3
            @Override // com.alibaba.griver.base.common.executor.AbstractPriorityRunnable
            public final void runTask() {
                AppPreDownloadConfig.ConfigUnitsBean configUnitsBean;
                synchronized (AppPreDownloadManager.c) {
                    boolean unused = AppPreDownloadManager.b = true;
                    if (z) {
                        AppPreDownloadManager.a();
                    }
                    if (AppPreDownloadManager.f6373a != null && AppPreDownloadManager.f6373a.isEnabled()) {
                        Iterator<AppPreDownloadConfig.ConfigUnitsBean> it = AppPreDownloadManager.f6373a.getConfigUnits().iterator();
                        do {
                            configUnitsBean = null;
                            if (!it.hasNext()) {
                                break;
                            }
                            configUnitsBean = it.next();
                        } while (!AppPreDownloadManager.PRE_DOWNLOAD_FIRE_MOMENT_INIT.equals(configUnitsBean.getFireMoment()));
                        if (configUnitsBean != null) {
                            AppPreDownloadManager.a(configUnitsBean);
                        }
                    }
                    boolean unused2 = AppPreDownloadManager.b = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void backgroundRunTask() {
        AppPreDownloadConfig.ConfigUnitsBean configUnitsBean;
        if (b) {
            return;
        }
        synchronized (c) {
            b = true;
            a();
            AppPreDownloadConfig appPreDownloadConfig = f6373a;
            if (appPreDownloadConfig != null && appPreDownloadConfig.isEnabled()) {
                Iterator<AppPreDownloadConfig.ConfigUnitsBean> it = f6373a.getConfigUnits().iterator();
                do {
                    configUnitsBean = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    configUnitsBean = it.next();
                } while (!PRE_DOWNLOAD_FIRE_MOMENT_IN_BACKGROUND.equals(configUnitsBean.getFireMoment()));
                if (configUnitsBean != null) {
                    a(configUnitsBean);
                }
            }
            b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a() {
        try {
            f6373a = (AppPreDownloadConfig) JSON.parseObject(GriverInnerConfig.getConfig(GriverConfigConstants.APP_PREDOWNLOAD_CONFIG), AppPreDownloadConfig.class);
        } catch (Throwable th) {
            GriverLogger.e(TAG, "AppPreDownloadManager#refreshAppPreDownloadConfig", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AppPreDownloadConfig.ConfigUnitsBean configUnitsBean) {
        GriverLogger.d(TAG, "pre download try to download app info and package");
        try {
            boolean z = configUnitsBean.getDownloadType() == 0;
            if ((1 == configUnitsBean.getDownloadType()) || (z && "wifi".equalsIgnoreCase(NetworkUtil.getSimpleNetworkType(GriverEnv.getApplicationContext())))) {
                if (configUnitsBean.getDelay() >= 0) {
                    Thread.sleep(configUnitsBean.getDelay());
                }
                List<String> appIds = configUnitsBean.getAppIds();
                for (String str : b()) {
                    if (!appIds.contains(str)) {
                        appIds.add(str);
                    }
                }
                AppPreDownloadPackageManager.downloadPackageWithURLString(AppPreDownloadCacheManager.requestAppWithAppId(appIds, f6373a.getUpdateAppInfoInterval()));
            }
        } catch (Throwable th) {
            GriverLogger.e(TAG, "AppPreDownloadManager#toPreDownload", th);
            GriverMonitor.event(GriverMonitorConstants.APP_PRE_DOWNLOAD_EVENT_START_ERROR, "GriverAppContainer", null);
        }
    }

    public static boolean isPreDownloadFileAvailable(AppModel appModel) {
        AppPreDownloadConfig appPreDownloadConfig = f6373a;
        if (appPreDownloadConfig == null || !appPreDownloadConfig.isEnabled()) {
            return false;
        }
        GriverLogger.d(TAG, "isPreDownloadFileAvailable is execute, pre download is enable true");
        return AppInfoUtils.getPreDownloadFile(appModel) != null && AppInfoUtils.getPreDownloadFile(appModel).exists();
    }

    public static AppModel availableAppForAppId(String str, AppModel appModel, String str2, Bundle bundle) {
        AppPreDownloadConfig appPreDownloadConfig;
        AppInfoDao queryAppInfoDao;
        AppModel appInfo;
        if (TextUtils.isEmpty(str) || (appPreDownloadConfig = f6373a) == null || !appPreDownloadConfig.isEnabled() || !AppInfoScene.ONLINE.toString().equalsIgnoreCase(BundleUtils.getString(bundle, AppInfoScene.PARAM_SCENE, AppInfoScene.ONLINE.toString()))) {
            return null;
        }
        if ((!TextUtils.isEmpty(GriverEnv.getEnvironment()) && !"prod".equalsIgnoreCase(GriverEnv.getEnvironment().trim())) || (queryAppInfoDao = GriverAppInfoPreDownloadStorage.queryAppInfoDao(str, str2)) == null || (appInfo = queryAppInfoDao.getAppInfo()) == null) {
            return null;
        }
        long lastRefreshTimestamp = queryAppInfoDao.getLastRefreshTimestamp();
        if ((System.currentTimeMillis() - lastRefreshTimestamp) / 1000 > f6373a.getAppInfoAvailableTime()) {
            return null;
        }
        if (TextUtils.isEmpty(str2) || appInfo.getAppVersion().equalsIgnoreCase(str2)) {
            if ((appModel == null || RVResourceUtils.compareVersion(appModel.getAppVersion(), appInfo.getAppVersion()) != 1) && GriverAppInfoStorage.queryLastRefreshTimestamp(str) <= lastRefreshTimestamp) {
                return appInfo;
            }
            return null;
        }
        return null;
    }

    public static void updateTopApp(App app) {
        AppPreDownloadConfig appPreDownloadConfig;
        if (app == null || (appPreDownloadConfig = f6373a) == null || !appPreDownloadConfig.isEnabled() || !AppInfoScene.ONLINE.toString().equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), AppInfoScene.PARAM_SCENE, AppInfoScene.ONLINE.toString()))) {
            return;
        }
        if (TextUtils.isEmpty(GriverEnv.getEnvironment()) || "prod".equalsIgnoreCase(GriverEnv.getEnvironment().trim())) {
            GriverAppInfoStorage.refreshOpenTime(app.getAppId(), app.getAppVersion(), System.currentTimeMillis());
        }
    }

    private static List<String> b() {
        AppPreDownloadConfig appPreDownloadConfig = f6373a;
        if (appPreDownloadConfig == null || !appPreDownloadConfig.isEnabled() || f6373a.getTopAppOpenTime() <= 0 || f6373a.getMaxTopAppPreCount() <= 0) {
            return new ArrayList();
        }
        return GriverAppInfoStorage.queryLastOpenAppIds(System.currentTimeMillis() - (f6373a.getTopAppOpenTime() * 1000), f6373a.getMaxTopAppPreCount());
    }
}
