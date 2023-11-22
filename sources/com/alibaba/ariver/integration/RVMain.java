package com.alibaba.ariver.integration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.proxy.RVSinglePageAppProxy;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.integration.ipc.server.ServerSideCallbackHolder;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.integration.resource.PrepareCallbackImpl;
import com.alibaba.ariver.integration.resource.PrepareFragmentCallbackImpl;
import com.alibaba.ariver.integration.resource.PrepareSPACallbackImpl;
import com.alibaba.ariver.integration.resource.PrepareStartPageCallbackImpl;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;

/* loaded from: classes3.dex */
public class RVMain {
    private static final String TAG = "AriverInt:Main";
    private static LongSparseArray<RVAppRecord> appRecords = new LongSparseArray<>();
    private static StartExecutor sStartExecutor;

    /* loaded from: classes6.dex */
    public interface Callback {
        void onFragmentCreate(Fragment fragment);
    }

    /* loaded from: classes3.dex */
    public interface StartExecutor {
        void handleStart(Runnable runnable);
    }

    static {
        IpcChannelManager.getInstance().registerClientListener(new IpcChannelManager.ClientListener() { // from class: com.alibaba.ariver.integration.RVMain.1
            @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ClientListener
            public final void onRegister(long j, IIpcChannel iIpcChannel) {
                StringBuilder sb = new StringBuilder();
                sb.append("onClient register: ");
                sb.append(j);
                RVLogger.d(RVMain.TAG, sb.toString());
            }

            @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ClientListener
            public final void onUnRegister(long j) {
                StringBuilder sb = new StringBuilder();
                sb.append("onClient unRegister: ");
                sb.append(j);
                RVLogger.d(RVMain.TAG, sb.toString());
                ServerSideCallbackHolder.getInstance().unbindStartToken(j);
                RVMain.removeAppRecord(j);
            }
        });
    }

    public static void setNextStartHandler(StartExecutor startExecutor) {
        synchronized (RVMain.class) {
            sStartExecutor = startExecutor;
        }
    }

    public static void startApp(Context context, RVAppRecord rVAppRecord) {
        synchronized (RVMain.class) {
            RVInitializer.init(context);
            RVInitializer.setupOptimize();
            StringBuilder sb = new StringBuilder();
            sb.append("startApp: ");
            sb.append(rVAppRecord.getAppId());
            RVLogger.d(TAG, sb.toString());
            rVAppRecord.getStartParams().putString(RVStartParams.KEY_START_SCENE, "startApp");
            rVAppRecord.getStartParams().putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(rVAppRecord.getStartParams(), "url"));
            rVAppRecord.getSceneParams().putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
            RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_preparePhase_before);
            RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_preparePhase_setup);
            appRecords.getAuthRequestContext(rVAppRecord.getStartToken(), rVAppRecord);
            RVClientStarter rVClientStarter = (RVClientStarter) RVProxy.get(RVClientStarter.class);
            PrepareContext prepareContext = new PrepareContext(context, rVAppRecord.getAppId(), rVAppRecord.getStartParams(), rVAppRecord.getSceneParams());
            PrepareCallbackImpl prepareCallbackImpl = new PrepareCallbackImpl(rVAppRecord, prepareContext);
            final PrepareController createPrepareController = rVClientStarter.createPrepareController(prepareContext, prepareCallbackImpl);
            if (createPrepareController == null) {
                prepareCallbackImpl.startApp(new PrepareCallbackParam(prepareContext));
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.alibaba.ariver.integration.RVMain.2
                @Override // java.lang.Runnable
                public final void run() {
                    RVTraceUtils.traceBeginSection(RVTraceKey.RV_Prepare);
                    createPrepareController.start();
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare);
                }
            };
            StartExecutor startExecutor = sStartExecutor;
            if (startExecutor != null) {
                startExecutor.handleStart(runnable);
                sStartExecutor = null;
            } else {
                ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, runnable);
            }
        }
    }

    public static void startApp(Context context, String str, Bundle bundle, Bundle bundle2) {
        synchronized (RVMain.class) {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_Main_startApp);
            StringBuilder sb = new StringBuilder();
            sb.append("startApp: ");
            sb.append(str);
            RVLogger.d(TAG, sb.toString());
            startApp(context, RVAppRecord.generate(str, BundleUtils.clone(bundle), BundleUtils.clone(bundle2)));
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Main_startApp);
        }
    }

    public static void createFragment(Context context, String str, Bundle bundle, Bundle bundle2, Callback callback) {
        synchronized (RVMain.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("createFragment: ");
            sb.append(str);
            RVLogger.d(TAG, sb.toString());
            RVInitializer.init(context);
            RVInitializer.setupOptimize();
            Bundle clone = BundleUtils.clone(bundle);
            RVAppRecord generate = RVAppRecord.generate(str, clone, BundleUtils.clone(bundle2));
            generate.getStartParams().putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(clone, "url"));
            generate.getSceneParams().putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
            appRecords.getAuthRequestContext(generate.getStartToken(), generate);
            RVClientStarter rVClientStarter = (RVClientStarter) RVProxy.get(RVClientStarter.class);
            PrepareContext prepareContext = new PrepareContext(context, generate.getAppId(), generate.getStartParams(), generate.getSceneParams());
            PrepareFragmentCallbackImpl prepareFragmentCallbackImpl = new PrepareFragmentCallbackImpl(generate, prepareContext, callback);
            final PrepareController createPrepareController = rVClientStarter.createPrepareController(prepareContext, prepareFragmentCallbackImpl);
            if (createPrepareController == null) {
                prepareFragmentCallbackImpl.startApp(new PrepareCallbackParam(prepareContext));
            } else {
                ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.integration.RVMain.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        createPrepareController.start();
                    }
                });
            }
        }
    }

    public static void startPage(Context context, RVAppRecord rVAppRecord, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("startPage: ");
        sb.append(rVAppRecord.getAppId());
        RVLogger.d(TAG, sb.toString());
        RVInitializer.init(context.getApplicationContext());
        RVInitializer.setupOptimize();
        rVAppRecord.getStartParams().putString(RVStartParams.KEY_START_SCENE, RVStartParams.START_SCENE_START_PAGE);
        rVAppRecord.getStartParams().putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(rVAppRecord.getStartParams(), "url"));
        rVAppRecord.getSceneParams().putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        appRecords.getAuthRequestContext(rVAppRecord.getStartToken(), rVAppRecord);
        PrepareContext prepareContext = new PrepareContext(context, rVAppRecord.getAppId(), rVAppRecord.getStartParams(), rVAppRecord.getSceneParams());
        PrepareStartPageCallbackImpl prepareStartPageCallbackImpl = new PrepareStartPageCallbackImpl(rVAppRecord, prepareContext);
        final PrepareController createPrepareController = ((RVClientStarter) RVProxy.get(RVClientStarter.class)).createPrepareController(prepareContext, prepareStartPageCallbackImpl);
        if (z && createPrepareController != null) {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.integration.RVMain.4
                @Override // java.lang.Runnable
                public final void run() {
                    createPrepareController.start();
                }
            });
        } else {
            prepareStartPageCallbackImpl.startApp(new PrepareCallbackParam(prepareContext));
        }
    }

    public static void createPage(Activity activity, String str, boolean z, Bundle bundle, Bundle bundle2, CreatePageCallback createPageCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("createPage: ");
        sb.append(str);
        RVLogger.d(TAG, sb.toString());
        bundle.putString("appId", str);
        RVAppRecord generate = RVAppRecord.generate(str, BundleUtils.clone(bundle), BundleUtils.clone(bundle2));
        RVInitializer.init(activity.getApplicationContext());
        RVInitializer.setupOptimize();
        generate.getStartParams().putString(RVStartParams.KEY_START_SCENE, RVStartParams.START_SCENE_CREATE_PAGE);
        generate.getStartParams().putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(generate.getStartParams(), "url"));
        generate.getSceneParams().putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        appRecords.getAuthRequestContext(generate.getStartToken(), generate);
        PrepareContext prepareContext = new PrepareContext(activity, str, generate.getStartParams(), generate.getSceneParams());
        PrepareSPACallbackImpl prepareSPACallbackImpl = new PrepareSPACallbackImpl(activity, generate, prepareContext, createPageCallback);
        final PrepareController createPrepareController = ((RVClientStarter) RVProxy.get(RVClientStarter.class)).createPrepareController(prepareContext, prepareSPACallbackImpl);
        if (z && createPrepareController != null) {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.integration.RVMain.5
                @Override // java.lang.Runnable
                public final void run() {
                    createPrepareController.start();
                }
            });
        } else {
            prepareSPACallbackImpl.startApp(new PrepareCallbackParam(prepareContext));
        }
    }

    public static Page createPageSync(Activity activity, String str, boolean z, Bundle bundle, Bundle bundle2) {
        Bundle clone = BundleUtils.clone(bundle);
        Bundle clone2 = BundleUtils.clone(bundle2);
        RVInitializer.init(activity.getApplicationContext());
        RVAppRecord generate = RVAppRecord.generate(str, clone, clone2);
        Bundle startParams = generate.getStartParams();
        Bundle sceneParams = generate.getSceneParams();
        startParams.putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(startParams, "url"));
        startParams.putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        startParams.putString(RVStartParams.KEY_START_SCENE, RVStartParams.START_SCENE_CREATE_PAGE);
        appRecords.getAuthRequestContext(generate.getStartToken(), generate);
        PrepareContext prepareContext = new PrepareContext(activity, str, startParams, sceneParams);
        if (z) {
            AppInfoQuery appInfoQuery = new AppInfoQuery(str);
            String string = BundleUtils.getString(prepareContext.getStartParams(), "appVersion");
            if (!TextUtils.isEmpty(string)) {
                appInfoQuery.version(string);
            }
            if (AppInfoScene.isDevSource(prepareContext.getStartParams())) {
                appInfoQuery.scene(AppInfoScene.extractScene(prepareContext.getStartParams()));
                appInfoQuery.version(AppInfoScene.extractSceneVersion(prepareContext.getStartParams()));
            }
            prepareContext.setAppInfoQuery(appInfoQuery);
            AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(appInfoQuery);
            if (!(appModel != null)) {
                return null;
            }
            prepareContext.setOriginHasAppInfo(true);
            prepareContext.setupAppInfo(appModel);
        }
        App startApp = ((AppManager) RVProxy.get(AppManager.class)).startApp(str, prepareContext.getStartParams(), prepareContext.getSceneParams());
        RVSinglePageAppProxy rVSinglePageAppProxy = (RVSinglePageAppProxy) RVProxy.get(RVSinglePageAppProxy.class);
        startApp.bindContext(rVSinglePageAppProxy.createAppContext(startApp, activity));
        Page preCreatePage = startApp.preCreatePage();
        preCreatePage.bindContext(rVSinglePageAppProxy.createPageContext(startApp, activity));
        startApp.start();
        return preCreatePage;
    }

    public static RVAppRecord getAppRecord(long j) {
        RVAppRecord MyBillsEntityDataFactory;
        synchronized (RVMain.class) {
            MyBillsEntityDataFactory = appRecords.MyBillsEntityDataFactory(j, null);
        }
        return MyBillsEntityDataFactory;
    }

    public static void removeAppRecord(long j) {
        synchronized (RVMain.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeAppRecord: ");
            sb.append(j);
            RVLogger.d(TAG, sb.toString());
            appRecords.PlaceComponentResult(j);
        }
    }
}
