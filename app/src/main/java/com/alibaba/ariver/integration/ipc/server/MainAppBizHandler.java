package com.alibaba.ariver.integration.ipc.server;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.akulaku.AkuEventParamsKey;

/* loaded from: classes3.dex */
public class MainAppBizHandler implements IpcMessageHandler {

    /* renamed from: a */
    private final Bundle f6056a = new Bundle();

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        RVAppRecord appRecord;
        Message message = ipcMessage.bizMsg;
        Bundle data = message.getData();
        if (data == null) {
            data = this.f6056a;
        }
        int i = data.getInt(IpcMessageConstants.EXTRA_LPID);
        String string = data.getString("appId");
        long j = data.getLong(RVConstants.EXTRA_START_TOKEN);
        StringBuilder sb = new StringBuilder();
        sb.append("MainAppBizHandler received msg what: ");
        sb.append(message.what);
        sb.append(" lpid: ");
        sb.append(i);
        sb.append(" token: ");
        sb.append(j);
        RVLogger.d(IpcServerUtils.LOG_TAG, sb.toString());
        int i2 = message.what;
        if (i2 == 1) {
            a(j, i);
            Bundle bundle = (Bundle) BundleUtils.getParcelable(data, "startParams");
            BundleUtils.tryUnparcel(bundle);
            long j2 = BundleUtils.getLong(bundle, RVStartParams.KEY_RESTART_FROM_TOKEN);
            if (j2 <= 0 || (appRecord = RVMain.getAppRecord(j2)) == null) {
                return;
            }
            appRecord.finishClient();
        } else if (i2 == 2) {
            a(j);
        } else if (i2 != 7) {
            if (i2 == 8) {
                Bundle bundle2 = (Bundle) BundleUtils.getParcelable(data, "startParams");
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBoolean(RVStartParams.KEY_RESTART, true);
                if (RVMain.getAppRecord(j) != null) {
                    bundle2.putLong(RVStartParams.KEY_RESTART_FROM_TOKEN, j);
                    bundle2.putInt(RVStartParams.KEY_RESTART_FROM_LPID, i);
                }
                RVMain.startApp(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get(), string, bundle2, null);
            }
        } else {
            String string2 = data.getString("clientId");
            JSONObject unmarshallJSONObject = JSONUtils.unmarshallJSONObject(data.getByteArray(IpcMessageConstants.EXTRA_REMOTE_CALLBACK_DATA));
            boolean z = data.getBoolean(IpcMessageConstants.EXTRA_REMOTE_CALLBACK_KEEP);
            SendToNativeCallback callback = ServerSideCallbackHolder.getInstance().getCallback(j, string2, z);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MainAppBizHandler, CLIENT_MSG_REMOTE_CALLBACK find callback for ");
            sb2.append(string2);
            sb2.append(" ");
            sb2.append(callback);
            RVLogger.d(IpcServerUtils.LOG_TAG, sb2.toString());
            if (callback != null) {
                callback.onCallback(unmarshallJSONObject, z);
            }
        }
    }

    private void a(long j, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleAppStarted, token: ");
        sb.append(j);
        sb.append(" lpid: ");
        sb.append(i);
        RVLogger.d(IpcServerUtils.LOG_TAG, sb.toString());
        RVAppRecord appRecord = RVMain.getAppRecord(j);
        if (appRecord != null) {
            appRecord.setReceivedRemoteReady(i);
            a(appRecord);
        }
    }

    private void a(RVAppRecord rVAppRecord) {
        try {
            if (rVAppRecord.getActivityClz() == null) {
                return;
            }
            String name = rVAppRecord.getActivityClz().getName();
            ActivityManager activityManager = (ActivityManager) ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
            if (activityManager == null) {
                return;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(Integer.MAX_VALUE)) {
                if (runningTaskInfo.topActivity != null && TextUtils.equals(name, runningTaskInfo.topActivity.getClassName())) {
                    rVAppRecord.runningTaskInfo = runningTaskInfo;
                    if (runningTaskInfo.baseActivity != null) {
                        rVAppRecord.isTaskRoot = TextUtils.equals(name, runningTaskInfo.baseActivity.getClassName());
                        return;
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            RVLogger.w(IpcServerUtils.LOG_TAG, "findRecordTaskForBaseActivity exception!", th);
        }
    }

    private void a(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleAppDestroy, token: ");
        sb.append(j);
        RVLogger.d(IpcServerUtils.LOG_TAG, sb.toString());
        IpcChannelManager.getInstance().unRegisterClientChannel(j);
    }
}
