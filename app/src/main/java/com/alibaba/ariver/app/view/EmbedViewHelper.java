package com.alibaba.ariver.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.activity.StartAction;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareData;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;

/* loaded from: classes6.dex */
public abstract class EmbedViewHelper implements PrepareCallback {

    /* renamed from: a  reason: collision with root package name */
    private FragmentActivity f5991a;
    private AppNode b;
    private AppUIContext c;
    private boolean d;
    private PrepareContext e;
    private StartClientBundle f;
    private boolean g = false;

    protected abstract AppContext createAppContext(App app, FragmentActivity fragmentActivity);

    protected abstract PrepareController createPrepareController(PrepareContext prepareContext, PrepareCallback prepareCallback);

    public EmbedViewHelper(FragmentActivity fragmentActivity) {
        this.f5991a = fragmentActivity;
    }

    public void renderView(String str, Bundle bundle, Bundle bundle2) {
        Bundle clone = BundleUtils.clone(bundle);
        Bundle clone2 = BundleUtils.clone(bundle2);
        clone.putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(clone, "url"));
        clone.putString("appId", str);
        clone2.putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        clone2.putLong(RVConstants.EXTRA_START_TOKEN, System.currentTimeMillis());
        PrepareContext prepareContext = new PrepareContext(this.f5991a, str, clone, clone2);
        this.e = prepareContext;
        createPrepareController(prepareContext, this).moveToNext();
    }

    public StartClientBundle getStartClientBundle() {
        return this.f;
    }

    public void onResume() {
        RVLogger.d("AriverApp:ActivityHelper", "onResume");
        AppNode appNode = this.b;
        if (appNode != null) {
            appNode.resume();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.b != null) {
            ((ActivityResultPoint) ExtensionPoint.as(ActivityResultPoint.class).node(this.b).create()).onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        AppNode appNode = this.b;
        if (appNode != null && !appNode.isDestroyed()) {
            int childCount = this.b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Page pageByIndex = this.b.getPageByIndex(i2);
                if (pageByIndex.getPageContext() != null) {
                    pageByIndex.getPageContext().getEmbedViewManager().onRequestPermissionResult(i, strArr, iArr);
                }
            }
        }
        ((RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class)).onRequestPermissionResult(i, strArr, iArr);
    }

    public void finishAndRemoveTask() {
        doCommonDestroy();
    }

    public void finish() {
        doCommonDestroy();
    }

    public void onDestroy() {
        doCommonDestroy();
    }

    public void onStop() {
        RVLogger.d("AriverApp:ActivityHelper", "onStop");
    }

    public void onPause() {
        RVLogger.d("AriverApp:ActivityHelper", "onResume");
        AppNode appNode = this.b;
        if (appNode != null) {
            appNode.pause();
        }
    }

    public void onUserInteraction() {
        AppNode appNode = this.b;
        if (appNode != null) {
            appNode.onUserInteraction();
        }
    }

    public void onUserLeaveHint() {
        AppNode appNode = this.b;
        if (appNode != null) {
            appNode.onUserLeaveHint();
        }
    }

    public boolean onBackPressed() {
        AppNode appNode = this.b;
        if (appNode != null) {
            if (appNode.isFirstPage()) {
                RVLogger.d("AriverApp:ActivityHelper", "first page onBackPressed");
                return false;
            }
            Boolean intercept = ((BackKeyDownPoint) ExtensionPoint.as(BackKeyDownPoint.class).node(this.b).defaultValue(Boolean.FALSE).create()).intercept(this.b);
            if (intercept == null || !intercept.booleanValue()) {
                return this.b.backPressed();
            }
            return true;
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onKeyDown ");
        sb.append(i);
        RVLogger.d("AriverApp:ActivityHelper", sb.toString());
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.b.isFirstPage()) {
                RVLogger.d("AriverApp:ActivityHelper", "first page onBackPressed");
                return false;
            } else if (this.b != null) {
                Boolean intercept = ((BackKeyDownPoint) ExtensionPoint.as(BackKeyDownPoint.class).node(this.b).defaultValue(Boolean.FALSE).create()).intercept(this.b);
                if (intercept == null || !intercept.booleanValue()) {
                    return this.b.backPressed();
                }
                return true;
            } else {
                FragmentActivity fragmentActivity = this.f5991a;
                if (fragmentActivity != null) {
                    fragmentActivity.finish();
                    return true;
                }
            }
        }
        return false;
    }

    public void doCommonDestroy() {
        synchronized (this) {
            if (this.g) {
                return;
            }
            this.g = true;
            IpcChannelManager.getInstance().unRegisterClientChannel(this.e.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN));
            AppNode appNode = this.b;
            if (appNode != null && !appNode.isDestroyed()) {
                int childCount = this.b.getChildCount();
                StringBuilder sb = new StringBuilder();
                sb.append("doCommonDestroy force mApp.destroy with count: ");
                sb.append(childCount);
                RVLogger.w("AriverApp:ActivityHelper", sb.toString());
                this.b.exit();
            } else {
                this.c.destroy();
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void showLoading(boolean z, EntryInfo entryInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateLoading: ");
        sb.append(entryInfo);
        RVLogger.d("AriverApp:ActivityHelper", sb.toString());
        if (!this.d) {
            StepType appCreateStepType = this.e.getAppCreateStepType();
            this.e.getSceneParams().putInt(RVConstants.EXTRA_PREPARE_STEP_TYPE, appCreateStepType == null ? -1 : appCreateStepType.ordinal());
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.e);
            prepareCallbackParam.action = StartAction.SHOW_LOADING;
            prepareCallbackParam.needWaitIpc = true;
            startApp(prepareCallbackParam);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        bundle.putBoolean(RVConstants.EXTRA_NEED_WAIT_LOADING_ANIM, z);
        IpcServerUtils.sendMsgToClient(this.e.getAppId(), this.e.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 0, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void updateLoading(EntryInfo entryInfo, AppModel appModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateLoading: ");
        sb.append(entryInfo);
        RVLogger.d("AriverApp:ActivityHelper", sb.toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        bundle.putParcelable("appInfo", appModel);
        IpcServerUtils.sendMsgToClient(this.e.getAppId(), this.e.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 1, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareFail(PrepareData prepareData, PrepareException prepareException) {
        RVLogger.e("AriverApp:ActivityHelper", "prepareFail!", prepareException);
        if (!this.d) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.e);
            prepareCallbackParam.action = StartAction.SHOW_ERROR;
            prepareCallbackParam.needWaitIpc = false;
            if (prepareCallbackParam.sceneParams == null) {
                prepareCallbackParam.sceneParams = new Bundle();
            }
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_CODE, prepareException.getCode());
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE, prepareException.getMessage());
            startApp(prepareCallbackParam);
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmbedViewHelper.class.getClassLoader());
        if (prepareException != null) {
            bundle.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_CODE, prepareException.getCode());
            bundle.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE, prepareException.getMessage());
        }
        bundle.putParcelable(RVConstants.EXTRA_PREPARE_DATA, prepareData);
        IpcServerUtils.sendMsgToClient(this.e.getAppId(), this.e.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 3, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareFinish(PrepareData prepareData, AppModel appModel, Bundle bundle, Bundle bundle2) {
        RVLogger.d("AriverApp:ActivityHelper", "prepareFinish");
        if (!this.d) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.e);
            prepareCallbackParam.needWaitIpc = false;
            prepareCallbackParam.action = StartAction.DIRECT_START;
            prepareCallbackParam.startParams = bundle;
            prepareCallbackParam.sceneParams = bundle2;
            startApp(prepareCallbackParam);
        }
        Bundle bundle3 = new Bundle();
        if (bundle != null) {
            bundle3.putParcelable("startParams", bundle);
        }
        if (bundle2 != null) {
            bundle3.putParcelable(RVConstants.EXTRA_SCENE_PARAMS, bundle2);
        }
        if (appModel != null) {
            bundle3.putParcelable("appInfo", appModel);
        }
        bundle3.putParcelable(RVConstants.EXTRA_PREPARE_DATA, prepareData);
        IpcServerUtils.sendMsgToClient(this.e.getAppId(), this.e.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 2, bundle3);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareAbort() {
        StringBuilder sb = new StringBuilder();
        sb.append("forceFinish from stack: ");
        sb.append(Log.getStackTraceString(new Throwable("Just Print")));
        RVLogger.d("AriverApp:ActivityHelper", sb.toString());
        Bundle bundle = new Bundle();
        bundle.putString(RVConstants.EXTRA_PREPARE_ABORT_REASON, "Finish from mStartToken!");
        IpcServerUtils.sendMsgToClient(this.e.getAppId(), this.e.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 4, bundle);
    }

    protected StartClientBundle createStartClient(PrepareCallbackParam prepareCallbackParam) {
        Bundle sceneParams = this.e.getSceneParams();
        if (prepareCallbackParam.appInfo != null) {
            sceneParams.putParcelable("appInfo", prepareCallbackParam.appInfo);
        }
        if (!TextUtils.isEmpty(this.e.appType)) {
            sceneParams.putString("appType", this.e.appType);
        }
        EntryInfo entryInfo = this.e.getEntryInfo();
        if (entryInfo != null) {
            sceneParams.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        }
        sceneParams.putLong(RVConstants.EXTRA_PREPARE_START_CLIENT_TIME, SystemClock.elapsedRealtime());
        sceneParams.putBoolean(RVConstants.EXTRA_PREPARE_NEED_WAIT_IPC, prepareCallbackParam.needWaitIpc);
        Bundle startParams = this.e.getStartParams();
        ParamUtils.unify(startParams, "url", false);
        ParamUtils.parseMagicOptions(startParams, BundleUtils.getString(startParams, "url"));
        ParamUtils.unifyAll(this.e.getStartParams(), false);
        StartClientBundle startClientBundle = new StartClientBundle();
        startClientBundle.appId = this.e.getAppId();
        startClientBundle.appType = this.e.appType;
        startClientBundle.startToken = this.e.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN);
        startClientBundle.startParams = startParams;
        startClientBundle.sceneParams = sceneParams;
        startClientBundle.needWaitIpc = prepareCallbackParam.needWaitIpc;
        if (prepareCallbackParam.action != null) {
            startClientBundle.startAction = prepareCallbackParam.action;
        } else {
            startClientBundle.startAction = StartAction.DIRECT_START;
        }
        sceneParams.putLong(RVConstants.EXTRA_SETUP_END_TIMESTAMP, SystemClock.elapsedRealtime());
        return startClientBundle;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void startApp(PrepareCallbackParam prepareCallbackParam) {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f = createStartClient(prepareCallbackParam);
        AppNode appNode = (AppNode) ((AppManager) RVProxy.get(AppManager.class)).findAppByToken(this.f.startToken);
        this.b = appNode;
        if (appNode != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCreate find quickStarted app! ");
            sb.append(this.b);
            RVLogger.d("AriverApp:ActivityHelper", sb.toString());
            this.b.getStartParams().putAll(this.f.startParams);
            this.b.getSceneParams().putAll(this.f.sceneParams);
        } else {
            this.b = (AppNode) ((AppManager) RVProxy.get(AppManager.class)).startApp(this.f.appId, this.f.startParams, this.f.sceneParams);
        }
        this.c = (AppUIContext) createAppContext(this.b, this.f5991a);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).init("RV_APP_STARTUP", this.b.getAppId(), Long.valueOf(this.f.startToken), this.b.getStartUrl());
        this.b.bindContext(this.c);
        int i = AnonymousClass2.$SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[this.f.startAction.ordinal()];
        if (i == 1) {
            EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(this.b.getSceneParams(), RVConstants.EXTRA_ENTRY_INFO);
            if (this.c.getSplashView() != null) {
                this.c.getSplashView().showLoading(entryInfo);
            }
        } else if (i == 2) {
            String string = BundleUtils.getString(this.b.getSceneParams(), RVConstants.EXTRA_PREPARE_EXCEPTION_CODE);
            String string2 = BundleUtils.getString(this.b.getSceneParams(), RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE);
            if (this.c.getSplashView() != null) {
                this.c.getSplashView().showError(string, string2, null);
            }
        } else if (i == 3) {
            this.b.start();
        }
        if (ProcessUtils.isMainProcess()) {
            IpcChannelManager.getInstance().registerClientChannel(this.b.getStartToken(), new IIpcChannel.Stub() { // from class: com.alibaba.ariver.app.view.EmbedViewHelper.1
                @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                public void sendMessage(IpcMessage ipcMessage) throws RemoteException {
                    ClientMsgReceiver.getInstance().handleMessage(ipcMessage);
                }

                @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                public boolean isFinishing() throws RemoteException {
                    return EmbedViewHelper.this.f5991a.isFinishing();
                }
            });
        }
        ((ActivityHelperOnCreateFinishedPoint) ExtensionPoint.as(ActivityHelperOnCreateFinishedPoint.class).node(this.b).create()).onActivityHelperOnCreateFinished(this.b, this.f5991a, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.ariver.app.view.EmbedViewHelper$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction;

        static {
            int[] iArr = new int[StartAction.values().length];
            $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction = iArr;
            try {
                iArr[StartAction.SHOW_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[StartAction.SHOW_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[StartAction.DIRECT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
