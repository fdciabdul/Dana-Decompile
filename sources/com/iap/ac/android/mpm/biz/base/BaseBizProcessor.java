package com.iap.ac.android.mpm.biz.base;

import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.ACConstants;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import com.iap.ac.android.mpm.base.model.route.ACDecodeConfig;
import com.iap.ac.android.mpm.biz.BizProcessResumeParams;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class BaseBizProcessor {
    protected ACDecodeConfig acDecodeConfig;
    protected IDecodeCallback decodeCallback;
    public long startTime;
    protected final String cnAcquireId = "1022088000000000001";
    public String scene = ACConstants.Scene.SOURCE_FROM_SCAN;

    protected abstract boolean isToggleBiz();

    public abstract void onNodeBegin(NodeRequest nodeRequest);

    public abstract void onNodeEnd(NodeRequest nodeRequest, NodeResponse nodeResponse);

    public abstract void onProcessBegin();

    public abstract void onProcessFinish(NodeResponse nodeResponse);

    public abstract void onProcessPause(NodeResponse nodeResponse);

    public abstract void onProcessResume(NodeRequest nodeRequest, BizProcessResumeParams bizProcessResumeParams);

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendResult(Result result) {
        sendResult(result, this.decodeCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendToggleOffResult() {
        Result result = new Result();
        result.resultCode = ResultCode.UNKNOWN_EXCEPTION;
        result.resultMessage = "Oops! System busy. Try again later!";
        sendResult(result, this.decodeCallback);
    }

    public static void sendResult(Result result, IDecodeCallback iDecodeCallback) {
        ACMonitor.getInstance("ac_biz").flush();
        if (iDecodeCallback != null) {
            try {
                ACLog.i(Constants.TAG, String.format("send result code:%s, message:%s ", result.resultCode, result.resultMessage));
                iDecodeCallback.onResult(result);
            } catch (Throwable th) {
                ACLog.e(Constants.TAG, th.getMessage(), th);
                ACLogEvent.exceptionLog(th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading() {
        synchronized (this) {
            if (this.decodeCallback != null && isToggleLoadingSpi()) {
                try {
                    this.decodeCallback.showLoading();
                } catch (Throwable th) {
                    ACLog.e(Constants.TAG, th.getMessage(), th);
                    ACLogEvent.exceptionLog(th.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissLoading() {
        synchronized (this) {
            if (this.decodeCallback != null && isToggleLoadingSpi()) {
                try {
                    this.decodeCallback.dismissLoading();
                } catch (Throwable th) {
                    ACLog.e(Constants.TAG, th.getMessage(), th);
                    ACLogEvent.exceptionLog(th.getMessage());
                }
            }
        }
    }

    private boolean isToggleLoadingSpi() {
        ConfigCenter.INSTANCE.refreshConfigs();
        return ConfigCenter.INSTANCE.getLoadingSpiToggle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendBeginLog(String str, String str2) {
        ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_MPM_DECODE_START).addParams("codeValue", str).addParams(LogConstants.Mpm.CodeInfo.DECODE_CONFIG, this.acDecodeConfig).addParams("bizScenario", str2).event();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendFinishLog(NodeResponse nodeResponse, String str, String str2) {
        String str3 = nodeResponse.logResultCode;
        String str4 = nodeResponse.logResultMsg;
        Result result = new Result();
        if (str3 == null) {
            str3 = ResultCode.INVALID_NETWORK;
        }
        result.resultCode = str3;
        if (str4 == null) {
            str4 = "Oops! System busy. Try again later!";
        }
        result.resultMessage = str4;
        ACLogEvent addParams = ACLogEvent.newLogger(LogConstants.Mpm.AC_MPM_DECODE_END, this.startTime, result).addParams("bizScenario", str).addParams(LogConstants.Mpm.EndNode.END_NODE, nodeResponse.endNode).addParams("scene", this.scene);
        if (str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("paymentRedirectUrl", str2);
            addParams.addAll(hashMap);
        }
        addParams.event();
    }
}
