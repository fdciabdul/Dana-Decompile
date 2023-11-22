package com.alibaba.griver.core.keepalive;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.base.resource.GriverPrepareController;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.stagemonitor.impl.GriverKeepAliveFullLinkStageMonitor;
import com.alibaba.griver.base.utils.RemoteDebugCompatUtils;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.liteprocess.LiteProcessManager;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import com.alibaba.griver.core.ui.activity.GriverTransActivity;
import com.alibaba.griver.core.utils.DeviceUtils;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public class KeepAliveAppManager {
    public static final int MAX_LITE_ACTIVITY_NUM = 5;
    public static final String SHOW_FINISH_ANIM = "show_finish_anim";

    /* renamed from: a */
    private final LinkedList<AliveActivityInfo> f6426a;
    private final SparseArray<Class<? extends Activity>> b;
    private final SparseArray<Class<? extends Activity>> c;
    private final Handler d;
    private String e;
    private KeepAliveConfig f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface SingletonHolder {
        public static final KeepAliveAppManager INSTANCE = new KeepAliveAppManager();
    }

    public static KeepAliveAppManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public boolean needSupportKeepAlive(String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 24 && PermissionUtils.hasPermission("android.permission.REORDER_TASKS") && DeviceUtils.getAliveMemory(GriverEnv.getApplicationContext()) > 536870912) {
            if ((!bundle.containsKey(RVStartParams.KEY_ENABLE_KEEP_ALIVE) || "YES".equalsIgnoreCase(BundleUtils.getString(bundle, RVStartParams.KEY_ENABLE_KEEP_ALIVE, "YES"))) && AppInfoScene.ONLINE.toString().equalsIgnoreCase(BundleUtils.getString(bundle, AppInfoScene.PARAM_SCENE, AppInfoScene.ONLINE.toString())) && !RemoteDebugCompatUtils.isInDebugMode(str, bundle)) {
                return this.f.needSupportKeepAlive(str);
            }
            return false;
        }
        return false;
    }

    public boolean enableKeepAlive() {
        return this.f.isEnable();
    }

    public long getStartToken(String str) {
        synchronized (this) {
            AliveActivityInfo findAliveActivityByAppId = findAliveActivityByAppId(str);
            if (findAliveActivityByAppId != null) {
                return findAliveActivityByAppId.getStartToken();
            }
            return 0L;
        }
    }

    public void addContainerToken(long j, GriverProxyActivity griverProxyActivity) {
        synchronized (this) {
            if (j == -1 || griverProxyActivity == null) {
                return;
            }
            Iterator<AliveActivityInfo> it = this.f6426a.iterator();
            while (it.hasNext()) {
                AliveActivityInfo next = it.next();
                if (j == next.getToken()) {
                    next.setProxyActivity(griverProxyActivity);
                    return;
                }
            }
        }
    }

    public long getStartTokenByToken(long j) {
        synchronized (this) {
            if (j == -1) {
                return -1L;
            }
            Iterator<AliveActivityInfo> it = this.f6426a.iterator();
            while (it.hasNext()) {
                AliveActivityInfo next = it.next();
                if (j == next.getToken()) {
                    return next.getStartToken();
                }
            }
            return -1L;
        }
    }

    private KeepAliveAppManager() {
        this.f6426a = new LinkedList<>();
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
        this.d = new Handler(Looper.getMainLooper());
        try {
            this.f = new KeepAliveConfig(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_MINI_APP_KEEP_ALIVE));
        } catch (Exception e) {
            GriverLogger.e("KeepAliveAppManager", "KeepAliveAppManager", e);
        }
        if (this.f.isEnable()) {
            a();
            GriverEnv.getApplicationContext().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.alibaba.griver.core.keepalive.KeepAliveAppManager.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }

                {
                    KeepAliveAppManager.this = this;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    KeepAliveAppManager.this.resetAliveActivityByAppId(activity);
                }
            });
        }
    }

    private void a() {
        synchronized (this) {
            for (int i = 0; i <= 5; i++) {
                AliveActivityInfo aliveActivityInfo = new AliveActivityInfo();
                aliveActivityInfo.setAliveId(i);
                this.f6426a.add(aliveActivityInfo);
                this.b.put(i, GriverBaseActivity.ACTIVITY_BACK_CLASSES[i]);
                this.c.put(i, GriverTransActivity.ACTIVITY_BACK_CLASSES[i]);
            }
        }
    }

    public Class<? extends Activity> startApp(Context context, RVAppRecord rVAppRecord, Intent intent) {
        Activity activity;
        synchronized (this) {
            String userId = GriverAccount.getUserId();
            if (!TextUtils.isEmpty(this.e) && !this.e.equalsIgnoreCase(userId)) {
                b();
            }
            this.e = userId;
            if (context == null) {
                context = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            }
            if (!(context instanceof Activity)) {
                WeakReference<Activity> topActivity = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity();
                if (topActivity == null) {
                    return null;
                }
                activity = topActivity.get();
            } else {
                activity = (Activity) context;
            }
            if (activity == null) {
                return null;
            }
            boolean z = BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVStartParams.KEY_TRANSPARENT, false);
            final AliveActivityInfo a2 = a(rVAppRecord.getAppId(), rVAppRecord.getStartParams());
            if (a2 != null && a2.getState() == 1) {
                return a(a2.getAliveId(), z);
            } else if (a2 != null && (a2.getState() == 3 || a2.getState() == 2)) {
                GriverKeepAliveFullLinkStageMonitor createKeepAliveFullStageMonitor = GriverStageMonitorManager.getInstance().createKeepAliveFullStageMonitor(rVAppRecord.getAppId(), String.valueOf(a2.getStartToken()));
                GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(rVAppRecord.getAppId(), String.valueOf(a2.getStartToken())));
                if (createKeepAliveFullStageMonitor != null) {
                    createKeepAliveFullStageMonitor.initData(stageMonitor);
                }
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("isTransparent", z);
                intent.putExtras(rVAppRecord.getStartParams());
                intent.setClass(activity, a(a2.getAliveId(), z));
                ContainerAnimModel containerAnimModel = new ContainerAnimModel();
                containerAnimModel.frontEnterAnim = R.anim.griver_core_app_enter_up_in;
                containerAnimModel.frontExitAnim = R.anim.griver_core_app_exit_scale;
                containerAnimModel.backgroundEnterAnim = R.anim.griver_core_app_enter_scale;
                containerAnimModel.backgroundExitAnim = R.anim.griver_core_app_exit_scale;
                intent.putExtra(KeepAliveConstants.KEY_CONTAINER_ANIM, containerAnimModel);
                a2.setFromTaskId(activity.getTaskId());
                a2.setFromActivity(a(activity));
                a2.setState(2);
                a2.setToken(SystemClock.elapsedRealtime());
                startTargetWithProxy(activity, a2.getToken(), intent, containerAnimModel);
                return a(a2.getAliveId(), z);
            } else {
                if (a2 == null) {
                    a2 = c();
                }
                if (a2 == null) {
                    RVLogger.d("KeepAliveAppManager", "all back activity are busy.");
                    return null;
                }
                GriverFullLinkStageMonitor griverFullLinkStageMonitor = (GriverFullLinkStageMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(rVAppRecord.getAppId(), String.valueOf(rVAppRecord.getStartToken())));
                if (griverFullLinkStageMonitor != null) {
                    griverFullLinkStageMonitor.transitToNext(PerfId.startActivity);
                }
                a2.setState(1);
                a2.setAppId(rVAppRecord.getAppId());
                a2.setFromTaskId(activity.getTaskId());
                a2.setFromActivity(a(activity));
                a2.setAliveTime(this.f.getAliveTime());
                a2.setStartParams(new Bundle(rVAppRecord.getStartParams()));
                a2.setRunnable(new Runnable() { // from class: com.alibaba.griver.core.keepalive.KeepAliveAppManager.2
                    {
                        KeepAliveAppManager.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        KeepAliveAppManager.this.closeAliveApp(a2);
                    }
                });
                if (this.f.isInHighALiveWhiteList(rVAppRecord.getAppId())) {
                    a2.setHighAlive(true);
                }
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("isTransparent", z);
                intent.putExtras(rVAppRecord.getStartParams());
                intent.setClass(activity, a(a2.getAliveId(), z));
                ContainerAnimModel containerAnimModel2 = new ContainerAnimModel();
                containerAnimModel2.frontEnterAnim = R.anim.griver_core_app_enter_up_in;
                containerAnimModel2.frontExitAnim = R.anim.griver_core_app_exit_scale;
                containerAnimModel2.backgroundEnterAnim = R.anim.griver_core_app_enter_scale;
                containerAnimModel2.backgroundExitAnim = R.anim.griver_core_app_exit_scale;
                intent.putExtra(KeepAliveConstants.KEY_CONTAINER_ANIM, containerAnimModel2);
                a2.setToken(SystemClock.elapsedRealtime());
                startTargetWithProxy(activity, a2.getToken(), intent, containerAnimModel2);
                return a(a2.getAliveId(), z);
            }
        }
    }

    private String a(Activity activity) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) activity.getApplication().getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getRunningTasks(Integer.MAX_VALUE)) {
            if (activity.getTaskId() == runningTaskInfo.id) {
                return runningTaskInfo.baseActivity.getClassName();
            }
        }
        return null;
    }

    public Class<? extends Activity> startMainTaskApp(Context context, RVAppRecord rVAppRecord, final Intent intent, boolean z) {
        final Activity activity;
        if (context == null) {
            context = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        }
        if (!(context instanceof Activity)) {
            WeakReference<Activity> topActivity = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity();
            if (topActivity == null) {
                return null;
            }
            activity = topActivity.get();
        } else {
            activity = (Activity) context;
        }
        if (activity == null) {
            return null;
        }
        GriverFullLinkStageMonitor griverFullLinkStageMonitor = (GriverFullLinkStageMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(rVAppRecord.getAppId(), String.valueOf(rVAppRecord.getStartToken())));
        if (griverFullLinkStageMonitor != null) {
            griverFullLinkStageMonitor.transitToNext(PerfId.startActivity);
        }
        Class cls = z ? GriverTransActivity.Main.class : GriverBaseActivity.Main.class;
        intent.putExtra("isTransparent", z);
        intent.putExtras(rVAppRecord.getStartParams());
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClass(activity, cls);
        ExecutorUtils.postMain(new Runnable() { // from class: com.alibaba.griver.core.keepalive.KeepAliveAppManager.3
            {
                KeepAliveAppManager.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                activity.startActivity(intent);
            }
        });
        LiteProcessManager.getInstance().getMainProcess().setAppId(rVAppRecord.getAppId());
        LiteProcessManager.getInstance().getMainProcess().setState(1);
        return cls;
    }

    public GriverPrepareController createPrepareController(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        synchronized (this) {
            String userId = GriverAccount.getUserId();
            if (!TextUtils.isEmpty(this.e) && !this.e.equalsIgnoreCase(userId)) {
                return new GriverPrepareController(prepareContext, prepareCallback);
            } else if (prepareContext == null) {
                return null;
            } else {
                if (a(prepareContext.getAppId(), prepareContext.getStartParams()) != null) {
                    return null;
                }
                return new GriverPrepareController(prepareContext, prepareCallback);
            }
        }
    }

    private void b() {
        Iterator<AliveActivityInfo> it = this.f6426a.iterator();
        while (it.hasNext()) {
            AliveActivityInfo next = it.next();
            if (next != null && next.getState() != 0) {
                Runnable runnable = next.getRunnable();
                if (runnable != null) {
                    this.d.removeCallbacks(runnable);
                }
                App findAppByAppId = ((AppManager) RVProxy.get(AppManager.class)).findAppByAppId(next.getAppId());
                if (findAppByAppId != null) {
                    if (next.getState() == 3) {
                        findAppByAppId.getSceneParams().putBoolean(SHOW_FINISH_ANIM, false);
                    }
                    findAppByAppId.exit();
                }
                next.reset();
            }
        }
    }

    public void closeAliveApp(AliveActivityInfo aliveActivityInfo) {
        if (aliveActivityInfo == null || aliveActivityInfo.getState() == 0) {
            return;
        }
        Runnable runnable = aliveActivityInfo.getRunnable();
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
        }
        App findAppByAppId = ((AppManager) RVProxy.get(AppManager.class)).findAppByAppId(aliveActivityInfo.getAppId());
        if (findAppByAppId != null) {
            if (aliveActivityInfo.getState() == 3) {
                findAppByAppId.getSceneParams().putBoolean(SHOW_FINISH_ANIM, false);
            }
            findAppByAppId.exit();
        }
        aliveActivityInfo.reset();
    }

    private AliveActivityInfo c() {
        Iterator<AliveActivityInfo> it = this.f6426a.iterator();
        AliveActivityInfo aliveActivityInfo = null;
        AliveActivityInfo aliveActivityInfo2 = null;
        int i = 0;
        while (it.hasNext()) {
            AliveActivityInfo next = it.next();
            if (next != null) {
                if (next.getState() == 0 && SystemClock.elapsedRealtime() - next.getResetTime() > RangedBeacon.DEFAULT_MAX_TRACKING_AGE && aliveActivityInfo2 == null) {
                    i++;
                    aliveActivityInfo2 = next;
                } else if (next.getState() != 0) {
                    i++;
                }
                if (next.getState() == 3 && !next.isHighAlive() && (aliveActivityInfo == null || aliveActivityInfo.getBackgroundTime() > next.getBackgroundTime())) {
                    aliveActivityInfo = next;
                }
            }
        }
        if (i > 5 && aliveActivityInfo != null) {
            closeAliveApp(aliveActivityInfo);
        }
        return aliveActivityInfo2;
    }

    public AliveActivityInfo findAliveActivityByAppId(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<AliveActivityInfo> it = this.f6426a.iterator();
            while (it.hasNext()) {
                AliveActivityInfo next = it.next();
                if (str.equals(next.getAppId())) {
                    return next;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00c6 A[Catch: all -> 0x0102, TryCatch #0 {, blocks: (B:104:0x0001, B:112:0x000e, B:113:0x0014, B:115:0x001a, B:117:0x002a, B:119:0x0032, B:124:0x0040, B:126:0x0049, B:130:0x0055, B:132:0x005e, B:134:0x0072, B:136:0x0078, B:138:0x0080, B:140:0x0088, B:143:0x0099, B:145:0x009c, B:147:0x00a7, B:153:0x00be, B:150:0x00b3, B:157:0x00c6, B:158:0x00ce, B:160:0x00d4, B:163:0x00e5, B:165:0x00eb, B:172:0x00fb), top: B:181:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00fb A[Catch: all -> 0x0102, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:104:0x0001, B:112:0x000e, B:113:0x0014, B:115:0x001a, B:117:0x002a, B:119:0x0032, B:124:0x0040, B:126:0x0049, B:130:0x0055, B:132:0x005e, B:134:0x0072, B:136:0x0078, B:138:0x0080, B:140:0x0088, B:143:0x0099, B:145:0x009c, B:147:0x00a7, B:153:0x00be, B:150:0x00b3, B:157:0x00c6, B:158:0x00ce, B:160:0x00d4, B:163:0x00e5, B:165:0x00eb, B:172:0x00fb), top: B:181:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x00f9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.griver.core.keepalive.AliveActivityInfo a(java.lang.String r13, android.os.Bundle r14) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.keepalive.KeepAliveAppManager.a(java.lang.String, android.os.Bundle):com.alibaba.griver.core.keepalive.AliveActivityInfo");
    }

    public void setAliveActivityRunningByAppId(String str, long j) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Iterator<AliveActivityInfo> it = this.f6426a.iterator();
            while (it.hasNext()) {
                AliveActivityInfo next = it.next();
                if (str.equals(next.getAppId())) {
                    next.setStartToken(j);
                    next.setState(2);
                }
            }
        }
    }

    public void resetAliveActivityByAppId(String str, long j) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Iterator<AliveActivityInfo> it = this.f6426a.iterator();
            while (it.hasNext()) {
                AliveActivityInfo next = it.next();
                if (str.equals(next.getAppId()) && j == next.getStartToken()) {
                    Runnable runnable = next.getRunnable();
                    if (runnable != null) {
                        this.d.removeCallbacks(runnable);
                    }
                    next.reset();
                }
            }
        }
    }

    public void resetAliveActivityByAppId(Activity activity) {
        synchronized (this) {
            if (activity != null) {
                if (!TextUtils.isEmpty(activity.getPackageName())) {
                    Iterator<AliveActivityInfo> it = this.f6426a.iterator();
                    while (it.hasNext()) {
                        AliveActivityInfo next = it.next();
                        if (activity.getClass().getName().equals(next.getFromActivity())) {
                            closeAliveApp(next);
                        }
                    }
                }
            }
        }
    }

    public void moveBackTaskAliveActivityByAppId(String str, long j, boolean z) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Iterator<AliveActivityInfo> it = this.f6426a.iterator();
            while (it.hasNext()) {
                AliveActivityInfo next = it.next();
                if (str.equals(next.getAppId()) && j == next.getStartToken()) {
                    Runnable runnable = next.getRunnable();
                    if (next.getState() == 3) {
                        return;
                    }
                    if (z) {
                        if (runnable != null && !next.isHighAlive()) {
                            this.d.postDelayed(runnable, next.getAliveTime());
                        }
                        next.setBackgroundTime(SystemClock.elapsedRealtime());
                        next.setState(3);
                        next.clearProxyActivity();
                    } else {
                        if (runnable != null) {
                            this.d.removeCallbacks(runnable);
                        }
                        next.reset();
                    }
                }
            }
        }
    }

    public void moveFromTaskToFrontAliveActivityByAppId(String str, long j) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Iterator<AliveActivityInfo> it = this.f6426a.iterator();
            while (it.hasNext()) {
                AliveActivityInfo next = it.next();
                if (str.equals(next.getAppId()) && j == next.getStartToken()) {
                    Runnable runnable = next.getRunnable();
                    if (runnable != null) {
                        this.d.removeCallbacks(runnable);
                    }
                    next.setState(2);
                }
            }
        }
    }

    private Class<? extends Activity> a(int i, boolean z) {
        return (z ? this.c : this.b).get(i);
    }

    static void startTargetWithProxy(final Activity activity, final long j, final Intent intent, final ContainerAnimModel containerAnimModel) {
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.keepalive.KeepAliveAppManager.4
            @Override // java.lang.Runnable
            public final void run() {
                Intent intent2 = new Intent(activity, GriverProxyActivity.class);
                intent2.addFlags(65536);
                intent2.putExtra(KeepAliveConstants.KEY_CONTAINER_TOKEN, j);
                intent2.putExtra("targetIntent", intent);
                intent2.putExtra(KeepAliveConstants.KEY_CONTAINER_ANIM, containerAnimModel);
                activity.startActivity(intent2);
            }
        });
    }
}
