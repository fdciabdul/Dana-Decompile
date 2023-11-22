package com.alibaba.ariver.integration.resource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.activity.StartAction;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareData;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.content.ResourceUtils;
import java.util.ConcurrentModificationException;

/* loaded from: classes3.dex */
public class PrepareCallbackImpl implements PrepareCallback {
    protected static final String TAG = "AriverInt:PrepareCallback";

    /* renamed from: a  reason: collision with root package name */
    private boolean f6063a;
    private boolean b;
    protected boolean mAlreadyStarted;
    protected final RVAppRecord mAppRecord;
    protected PrepareContext mPrepareContext;

    public PrepareCallbackImpl(RVAppRecord rVAppRecord, PrepareContext prepareContext) {
        this(rVAppRecord, prepareContext, false);
    }

    public PrepareCallbackImpl(RVAppRecord rVAppRecord, PrepareContext prepareContext, boolean z) {
        this.mPrepareContext = prepareContext;
        this.mAppRecord = rVAppRecord;
        this.mAlreadyStarted = z;
        this.f6063a = "YES".equalsIgnoreCase(BundleUtils.getString(rVAppRecord.getStartParams(), RVStartParams.KEY_DISABLE_LOADING_VIEW));
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void showLoading(final boolean z, final EntryInfo entryInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("showLoading: ");
        sb.append(entryInfo);
        sb.append(", disableLoadingView: ");
        sb.append(this.f6063a);
        RVLogger.d(TAG, sb.toString());
        this.b = true;
        if (this.f6063a) {
            return;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.integration.resource.PrepareCallbackImpl.1
            @Override // java.lang.Runnable
            public void run() {
                PrepareCallbackImpl.this.a(z, entryInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, EntryInfo entryInfo) {
        if (!this.mAlreadyStarted) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.mPrepareContext);
            prepareCallbackParam.action = StartAction.SHOW_LOADING;
            prepareCallbackParam.needWaitIpc = true;
            startApp(prepareCallbackParam);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        bundle.putBoolean(RVConstants.EXTRA_NEED_WAIT_LOADING_ANIM, z);
        IpcServerUtils.sendMsgToClient(this.mAppRecord.getAppId(), this.mAppRecord.getStartToken(), 0, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void updateLoading(EntryInfo entryInfo, AppModel appModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateLoading: ");
        sb.append(entryInfo);
        sb.append(", disableLoadingView: ");
        sb.append(this.f6063a);
        RVLogger.d(TAG, sb.toString());
        this.b = true;
        if (this.f6063a) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        bundle.putParcelable("appInfo", appModel);
        IpcServerUtils.sendMsgToClient(this.mAppRecord.getAppId(), this.mAppRecord.getStartToken(), 1, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareFail(final PrepareData prepareData, final PrepareException prepareException) {
        RVLogger.e(TAG, "prepareFail!", prepareException);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.integration.resource.PrepareCallbackImpl.2
            @Override // java.lang.Runnable
            public void run() {
                PrepareCallbackImpl.this.a(prepareData, prepareException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PrepareData prepareData, PrepareException prepareException) {
        if (!this.mAlreadyStarted) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.mPrepareContext);
            prepareCallbackParam.action = StartAction.SHOW_ERROR;
            prepareCallbackParam.needWaitIpc = false;
            if (prepareCallbackParam.sceneParams == null) {
                prepareCallbackParam.sceneParams = new Bundle();
            }
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_CODE, prepareException.getCode());
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE, prepareException.getMessage());
            startApp(prepareCallbackParam);
        }
        sendPrepareFailMsgToClient(prepareData, prepareException);
    }

    protected void sendPrepareFailMsgToClient(PrepareData prepareData, PrepareException prepareException) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PrepareCallbackImpl.class.getClassLoader());
        if (prepareException != null) {
            bundle.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_CODE, prepareException.getCode());
            bundle.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE, prepareException.getMessage());
            if (prepareException.getCause() instanceof UpdateAppException) {
                UpdateAppException updateAppException = (UpdateAppException) prepareException.getCause();
                if (updateAppException.getExtras() != null) {
                    Bundle bundle2 = new Bundle();
                    for (String str : updateAppException.getExtras().keySet()) {
                        if (str != null) {
                            bundle2.putString(str, updateAppException.getExtras().get(str));
                        }
                    }
                    bundle.putBundle(RVConstants.EXTRA_PREPARE_EXCEPTION_EXTRAS, bundle2);
                }
            }
        }
        bundle.putParcelable(RVConstants.EXTRA_PREPARE_DATA, prepareData);
        if (this.mPrepareContext.getAppModel() != null) {
            bundle.putParcelable("appInfo", this.mPrepareContext.getAppModel());
        }
        IpcServerUtils.sendMsgToClient(this.mAppRecord.getAppId(), this.mAppRecord.getStartToken(), 3, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareFinish(PrepareData prepareData, AppModel appModel, Bundle bundle, Bundle bundle2) {
        synchronized (this) {
            RVLogger.d(TAG, "prepareFinish");
            IpcServerUtils.addStubToClient(this.mPrepareContext.getAppId(), this.mPrepareContext.getStartToken(), "PrepareStep_Finish", SystemClock.elapsedRealtime());
            a(bundle);
            if (!this.mAlreadyStarted) {
                PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.mPrepareContext);
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
                bundle2.putString("appType", this.mPrepareContext.appType);
                bundle3.putParcelable(RVConstants.EXTRA_SCENE_PARAMS, bundle2);
            }
            if (appModel != null) {
                bundle3.putParcelable("appInfo", appModel);
            }
            bundle3.putParcelable(RVConstants.EXTRA_PREPARE_DATA, prepareData);
            IpcServerUtils.sendMsgToClient(this.mAppRecord.getAppId(), this.mAppRecord.getStartToken(), 2, bundle3);
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareAbort() {
        StringBuilder sb = new StringBuilder();
        sb.append("forceFinish from stack: ");
        sb.append(Log.getStackTraceString(new Throwable("Just Print")));
        RVLogger.d(TAG, sb.toString());
        Bundle bundle = new Bundle();
        bundle.putString(RVConstants.EXTRA_PREPARE_ABORT_REASON, "Finish from mStartToken!");
        IpcServerUtils.sendMsgToClient(this.mAppRecord.getAppId(), this.mAppRecord.getStartToken(), 4, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StartClientBundle createStartClient(PrepareCallbackParam prepareCallbackParam) {
        Bundle sceneParams = this.mAppRecord.getSceneParams();
        if (prepareCallbackParam.appInfo != null) {
            sceneParams.putParcelable("appInfo", prepareCallbackParam.appInfo);
            this.mAppRecord.setAppModel(prepareCallbackParam.appInfo);
        }
        if (!TextUtils.isEmpty(this.mPrepareContext.appType)) {
            sceneParams.putString("appType", this.mPrepareContext.appType);
        }
        EntryInfo entryInfo = this.mPrepareContext.getEntryInfo();
        if (entryInfo == null) {
            entryInfo = ResourceUtils.getEntryInfo(prepareCallbackParam.appInfo);
        }
        if (entryInfo != null) {
            sceneParams.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        }
        StepType appCreateStepType = this.mPrepareContext.getAppCreateStepType();
        sceneParams.putInt(RVConstants.EXTRA_PREPARE_STEP_TYPE, appCreateStepType == null ? -1 : appCreateStepType.ordinal());
        sceneParams.putLong(RVConstants.EXTRA_PREPARE_START_CLIENT_TIME, SystemClock.elapsedRealtime());
        sceneParams.putBoolean(RVConstants.EXTRA_PREPARE_NEED_WAIT_IPC, prepareCallbackParam.needWaitIpc);
        Bundle startParams = this.mPrepareContext.getStartParams();
        ParamUtils.unify(startParams, "url", false);
        ParamUtils.parseMagicOptions(startParams, BundleUtils.getString(startParams, "url"));
        try {
            ParamUtils.unifyAll(this.mAppRecord.getStartParams(), false);
            ParamUtils.unifyAll(startParams, false);
        } catch (ConcurrentModificationException e) {
            RVLogger.e(TAG, "PrepareCallBackImpl unifyAll concurrentModificationException,", e);
        }
        if (this.b && this.f6063a) {
            startParams.putAll(prepareCallbackParam.startParams);
            sceneParams.putAll(prepareCallbackParam.sceneParams);
        }
        StartClientBundle startClientBundle = new StartClientBundle();
        startClientBundle.appId = this.mAppRecord.getAppId();
        startClientBundle.appType = this.mPrepareContext.appType;
        startClientBundle.startToken = this.mAppRecord.getStartToken();
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
        synchronized (this) {
            if (this.mAlreadyStarted) {
                return;
            }
            this.mAlreadyStarted = true;
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_Prepare_StartClient);
            Intent intent = new Intent();
            intent.putExtra(RVConstants.EXTRA_ARIVER_START_BUNDLE, createStartClient(prepareCallbackParam));
            this.mAppRecord.setLastStartClientTimeStamp(SystemClock.elapsedRealtime());
            Class<? extends Activity> startClient = ((RVClientStarter) RVProxy.get(RVClientStarter.class)).startClient(this.mPrepareContext.getStartContext(), this.mAppRecord, intent);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_StartClient);
            this.mAppRecord.setActivityClz(startClient);
        }
    }

    private void a(Bundle bundle) {
        AppInfoModel appInfoModel;
        if (bundle == null) {
            return;
        }
        try {
            AppModel appModel = this.mPrepareContext.getAppModel();
            if (appModel == null || (appInfoModel = appModel.getAppInfoModel()) == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(appModel.getAppId());
            sb.append("(name:");
            sb.append(appInfoModel.getName());
            sb.append(" version:");
            sb.append(appModel.getAppVersion());
            if (!"WEB_H5".equals(this.mPrepareContext.appType)) {
                ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage("66666692");
                String version = resourcePackage != null ? resourcePackage.version() : null;
                if (!TextUtils.isEmpty(version)) {
                    sb.append(" appx:");
                    sb.append(version);
                }
            }
            sb.append(")");
            AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_PREPARE_FINISH).setAppId(sb.toString()).setParentId(BundleUtils.getString(bundle, RVParams.START_APP_SESSION_ID)).setDesc(appModel.toString()).build());
        } catch (Exception e) {
            RVLogger.e(TAG, "onPkgPrepareFinish error ", e);
        }
    }
}
