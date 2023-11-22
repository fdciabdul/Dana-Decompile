package com.ap.zoloz.hummer.common;

import android.content.DialogInterface;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.biz.HummerLogger;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import com.ap.zoloz.hummer.rpc.IRpcCallback;
import com.ap.zoloz.hummer.rpc.RpcManager;
import com.ap.zoloz.hummer.rpc.RpcResponse;
import com.zoloz.zhub.common.factor.model.FactorNextResponse;
import com.zoloz.zhub.common.factor.model.FactorNextResponseInner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class HummerCore {
    public static final String TAG = "HummerCore";
    private HummerContext mHummerContext;
    private IHummerCoreCallback mHummerCoreCallback;
    private IAlertManagerCallback mIAlertManagerCallback;
    private Map<Integer, TaskTracker> mTasks = new HashMap();
    private int mZorder = 0;

    public TaskTracker getCurrentTask() {
        return this.mTasks.get(Integer.valueOf(this.mHummerContext.getCurrentTaskConfig().index));
    }

    public void schedule(HummerContext hummerContext, IHummerCoreCallback iHummerCoreCallback, final boolean z) {
        this.mHummerContext = hummerContext;
        if (hummerContext != null) {
            hummerContext.add(HummerConstants.CURRENT_TASK_NAME, HummerConstants.CONTEXT, TAG);
        }
        this.mHummerCoreCallback = iHummerCoreCallback;
        this.mIAlertManagerCallback = new IAlertManagerCallback() { // from class: com.ap.zoloz.hummer.common.HummerCore.1
            {
                HummerCore.this = this;
            }

            @Override // com.ap.zoloz.hummer.common.IAlertManagerCallback
            public void onHandelSystemError() {
                if (z) {
                    HummerCore.this.cancel();
                }
            }

            @Override // com.ap.zoloz.hummer.common.IAlertManagerCallback
            public void onHandelNetworkError(boolean z2) {
                if (z2) {
                    HummerCore.this.finalizeHummer();
                } else if (HummerCore.this.mHummerContext != null) {
                    HummerResponse hummerResponse = new HummerResponse();
                    hummerResponse.hummerId = HummerCore.this.mHummerContext.mHummerId;
                    hummerResponse.code = 1003;
                    HummerCore.this.mHummerContext.add(HummerConstants.HUMMER_RESPONSE, HummerConstants.CONTEXT, hummerResponse);
                    HummerCore.this.finish();
                }
            }
        };
        this.mZorder = this.mHummerContext.mClientConfig.clientStartIndex;
        handleTask();
    }

    private void handleTask() {
        TaskConfig taskConfig;
        HummerContext hummerContext = this.mHummerContext;
        if (hummerContext == null || hummerContext.mClientConfig == null || this.mHummerContext.mClientConfig.tasks.size() == 0 || (taskConfig = this.mHummerContext.getTaskConfig(this.mZorder)) == null || taskConfig.type == null) {
            return;
        }
        String str = taskConfig.type;
        str.hashCode();
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1825931416) {
            if (hashCode != -1190783428) {
                if (hashCode == 1223404281 && str.equals(HummerConstants.WEB_TASK)) {
                    c = 2;
                }
            } else if (str.equals(HummerConstants.NATIVE_TASK)) {
                c = 1;
            }
        } else if (str.equals(HummerConstants.SERVER_TASK)) {
            c = 0;
        }
        if (c == 0) {
            String str2 = taskConfig.name;
            str2.hashCode();
            if (str2.equals("cancel")) {
                cancel();
            } else if (str2.equals(HummerConstants.TASK_FINALIZE)) {
                finalizeHummer();
            } else {
                this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.INCORRECT_SERVER_TASK_NAME_ERROR_CODE);
                AlertManager.getInstance().alertSystemError(this.mIAlertManagerCallback);
                return;
            }
            HummerContext hummerContext2 = this.mHummerContext;
            if (hummerContext2 != null) {
                hummerContext2.setCurrentTaskConfig(taskConfig);
                this.mHummerContext.add(HummerConstants.CURRENT_TASK_NAME, HummerConstants.CONTEXT, taskConfig.name);
            }
        } else if (c == 1) {
            NativeTask nativeTask = new NativeTask();
            nativeTask.run(this.mHummerContext, taskConfig, new ITaskTrackerCallback() { // from class: com.ap.zoloz.hummer.common.HummerCore.4
                {
                    HummerCore.this = this;
                }

                @Override // com.ap.zoloz.hummer.common.ITaskTrackerCallback
                public void onCompletion(HummerContext hummerContext3, int i) {
                    HummerCore.this.mHummerContext = hummerContext3;
                    HummerCore.this.handleTaskResult(i);
                }
            });
            HummerContext hummerContext3 = this.mHummerContext;
            if (hummerContext3 != null) {
                hummerContext3.setCurrentTaskConfig(taskConfig);
                this.mHummerContext.add(HummerConstants.CURRENT_TASK_NAME, HummerConstants.CONTEXT, taskConfig.name);
                this.mTasks.put(Integer.valueOf(this.mHummerContext.getCurrentTaskConfig().index), nativeTask);
            }
        } else if (c == 2) {
            UIConfig currentUIConfig = this.mHummerContext.getCurrentUIConfig(taskConfig.name);
            if (this.mTasks.size() > 0 && this.mTasks.get(Integer.valueOf(taskConfig.index)) != null) {
                if (this.mZorder < this.mHummerContext.getCurrentTaskConfig().index) {
                    for (Map.Entry<Integer, TaskTracker> entry : this.mTasks.entrySet()) {
                        if (entry.getKey().intValue() > this.mZorder && entry.getKey().intValue() <= this.mHummerContext.getCurrentTaskConfig().index && HummerConstants.WEB_TASK.equals(entry.getValue().mTaskConfig.type)) {
                            WebTask webTask = (WebTask) entry.getValue();
                            if (!StringUtil.isNullorEmpty(webTask.getUrl())) {
                                WebPageManager.getInstance().exitPage(webTask.getUrl());
                            }
                        }
                    }
                } else {
                    this.mTasks.get(Integer.valueOf(this.mZorder)).run(this.mHummerContext, taskConfig, currentUIConfig, new ITaskTrackerCallback() { // from class: com.ap.zoloz.hummer.common.HummerCore.2
                        {
                            HummerCore.this = this;
                        }

                        @Override // com.ap.zoloz.hummer.common.ITaskTrackerCallback
                        public void onCompletion(HummerContext hummerContext4, int i) {
                            HummerCore.this.mHummerContext = hummerContext4;
                            HummerCore.this.handleTaskResult(i);
                        }
                    });
                }
            } else {
                WebTask webTask2 = new WebTask();
                webTask2.run(this.mHummerContext, taskConfig, currentUIConfig, new ITaskTrackerCallback() { // from class: com.ap.zoloz.hummer.common.HummerCore.3
                    {
                        HummerCore.this = this;
                    }

                    @Override // com.ap.zoloz.hummer.common.ITaskTrackerCallback
                    public void onCompletion(HummerContext hummerContext4, int i) {
                        HummerCore.this.mHummerContext = hummerContext4;
                        HummerCore.this.handleTaskResult(i);
                    }
                });
                this.mTasks.put(Integer.valueOf(taskConfig.index), webTask2);
            }
            HummerContext hummerContext4 = this.mHummerContext;
            if (hummerContext4 != null) {
                hummerContext4.setCurrentTaskConfig(taskConfig);
                this.mHummerContext.add(HummerConstants.CURRENT_TASK_NAME, HummerConstants.CONTEXT, taskConfig.name);
            }
        } else {
            this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.INCORRECT_TASK_TYPE_ERROR_CODE);
            AlertManager.getInstance().alertSystemError(this.mIAlertManagerCallback);
        }
    }

    public void handleTaskResult(int i) {
        HummerContext hummerContext = this.mHummerContext;
        if (hummerContext == null) {
            return;
        }
        hummerContext.add(HummerConstants.CURRENT_TASK_NAME, HummerConstants.CONTEXT, TAG);
        this.mHummerContext.add("nextIndex", HummerConstants.CONTEXT, Integer.valueOf(i));
        if (i == -1) {
            exit();
        } else if (i == 0 || i < -1) {
            this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.INCORRECT_TASK_INDEX_ERROR_CODE);
            AlertManager.getInstance().alertSystemError(this.mIAlertManagerCallback);
        } else {
            this.mZorder = i;
            handleTask();
        }
    }

    public void exit() {
        HummerResponse hummerResponse = new HummerResponse();
        HummerContext hummerContext = this.mHummerContext;
        if (hummerContext != null) {
            hummerResponse.hummerId = hummerContext.mHummerId;
            String str = (String) this.mHummerContext.query(HummerConstants.EKYC_STATUS);
            if (!StringUtil.isNullorEmpty(str)) {
                str.hashCode();
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -202516509) {
                    if (hashCode != 578079082) {
                        if (hashCode == 982065527 && str.equals("Pending")) {
                            c = 2;
                        }
                    } else if (str.equals(HummerConstants.EKYC_FAIL)) {
                        c = 1;
                    }
                } else if (str.equals("Success")) {
                    c = 0;
                }
                if (c == 0) {
                    hummerResponse.code = 1000;
                } else if (c == 1) {
                    hummerResponse.code = 2006;
                } else if (c == 2) {
                    hummerResponse.code = 3000;
                } else {
                    this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.KEY_PARAM_ERROR_CODE);
                    AlertManager.getInstance().alertSystemError(this.mIAlertManagerCallback);
                    return;
                }
            } else if (this.mHummerContext.query(HummerConstants.ZIM_RESP) != null) {
                hummerResponse.code = ((Integer) this.mHummerContext.query(HummerConstants.ZIM_RESP)).intValue();
            } else {
                hummerResponse.code = 1003;
            }
            this.mHummerContext.add(HummerConstants.HUMMER_RESPONSE, HummerConstants.CONTEXT, hummerResponse);
            finish();
        }
    }

    public void finish() {
        this.mZorder = 0;
        HummerContext hummerContext = this.mHummerContext;
        if (hummerContext != null) {
            hummerContext.setCurrentTaskConfig(null);
        }
        WebPageManager.getInstance().exitSession();
        IHummerCoreCallback iHummerCoreCallback = this.mHummerCoreCallback;
        if (iHummerCoreCallback != null) {
            iHummerCoreCallback.onCompletion(this.mHummerContext);
        }
    }

    public void release() {
        this.mZorder = 0;
        Iterator<TaskTracker> it = this.mTasks.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.mTasks.clear();
        HummerContext hummerContext = this.mHummerContext;
        if (hummerContext != null) {
            hummerContext.release();
            this.mHummerContext = null;
        }
        this.mHummerCoreCallback = null;
        this.mIAlertManagerCallback = null;
    }

    public void forceQuit() {
        HummerLogger.i("HummerCore forceQuit");
        this.mZorder = 0;
        for (TaskTracker taskTracker : this.mTasks.values()) {
            HummerLogger.i("HummerCore forceQuit task");
            taskTracker.forceQuit();
        }
        this.mTasks.clear();
        HummerContext hummerContext = this.mHummerContext;
        if (hummerContext != null) {
            hummerContext.forceQuit();
        }
    }

    public void cancel() {
        HummerContext hummerContext = this.mHummerContext;
        if (hummerContext == null) {
            return;
        }
        int cancelIndex = hummerContext.getCancelIndex();
        if (cancelIndex == 0) {
            this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.INVALID_CANCEL_INDEX);
            cancelExit();
            return;
        }
        RpcManager.getInstance().sendRpc(new IRpcCallback() { // from class: com.ap.zoloz.hummer.common.HummerCore.5
            {
                HummerCore.this = this;
            }

            @Override // com.ap.zoloz.hummer.rpc.IRpcCallback
            public void onCompletion(RpcResponse rpcResponse) {
                HummerCore.this.cancelExit();
            }
        }, RpcManager.getInstance().formatRequest(this.mHummerContext, cancelIndex, false));
    }

    public void cancelExit() {
        WebPageManager.getInstance().exitSession();
        if (this.mHummerContext != null) {
            HummerResponse hummerResponse = new HummerResponse();
            hummerResponse.code = 1003;
            hummerResponse.hummerId = this.mHummerContext.mHummerId;
            this.mHummerContext.add(HummerConstants.HUMMER_RESPONSE, HummerConstants.CONTEXT, hummerResponse);
        }
        finish();
    }

    public void finalizeHummer() {
        AlertManager.getInstance().showProgressDialog("", false, new DialogInterface.OnCancelListener() { // from class: com.ap.zoloz.hummer.common.HummerCore.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }

            {
                HummerCore.this = this;
            }
        }, true);
        RpcManager rpcManager = RpcManager.getInstance();
        IRpcCallback iRpcCallback = new IRpcCallback() { // from class: com.ap.zoloz.hummer.common.HummerCore.7
            {
                HummerCore.this = this;
            }

            @Override // com.ap.zoloz.hummer.rpc.IRpcCallback
            public void onCompletion(RpcResponse rpcResponse) {
                AlertManager.getInstance().dismissDialog();
                if (HummerCore.this.mHummerContext == null || rpcResponse == null) {
                    return;
                }
                FactorNextResponse factorNextResponse = rpcResponse.factorNextResponse;
                if (factorNextResponse == null || HummerConstants.NETWOTK_EXCEPTION.equals(rpcResponse.exception)) {
                    AlertManager.getInstance().alertNetworkError(HummerCore.this.mIAlertManagerCallback);
                } else if ("exception".equals(rpcResponse.exception) || factorNextResponse.response == null || factorNextResponse.response.size() <= 0) {
                    HummerCore.this.mHummerContext.recordSystemError(HummerCore.TAG, HummerZCodeConstant.RPC_ERROR_CODE);
                    AlertManager.getInstance().alertSystemError(HummerCore.this.mIAlertManagerCallback);
                } else {
                    String str = factorNextResponse.versionToken;
                    if (!StringUtil.isNullorEmpty(str)) {
                        HummerCore.this.mHummerContext.add(HummerConstants.VERSION_TOKEN, HummerConstants.CONTEXT, str);
                    }
                    HummerCore.this.mHummerContext.overwriteZStack(rpcResponse.factorNextResponse.zStack);
                    FactorNextResponseInner factorNextResponseInner = factorNextResponse.response.get(0);
                    if (!"SYSTEM_SUCCESS".equals(factorNextResponseInner.retCode)) {
                        HummerCore.this.mHummerContext.recordSystemError(HummerCore.TAG, factorNextResponseInner.retCodeSub);
                        AlertManager.getInstance().alertSystemError(HummerCore.this.mIAlertManagerCallback);
                        return;
                    }
                    if (factorNextResponse.response.get(0).outParams != null) {
                        for (Map.Entry<String, Object> entry : factorNextResponse.response.get(0).outParams.entrySet()) {
                            HummerCore.this.mHummerContext.add(entry.getKey(), HummerConstants.SERVER_RESPONSE, entry.getValue());
                        }
                    }
                    HummerCore.this.exit();
                }
            }
        };
        RpcManager rpcManager2 = RpcManager.getInstance();
        HummerContext hummerContext = this.mHummerContext;
        rpcManager.sendRpc(iRpcCallback, rpcManager2.formatRequest(hummerContext, ((Integer) hummerContext.query("nextIndex")).intValue(), true));
    }
}
