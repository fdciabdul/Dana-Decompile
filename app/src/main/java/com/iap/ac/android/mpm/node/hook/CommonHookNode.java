package com.iap.ac.android.mpm.node.hook;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.base.model.hook.HookConstants;
import com.iap.ac.android.mpm.base.model.hook.PreCreateOrderConfig;
import com.iap.ac.android.mpm.base.model.hook.result.CommonHookResult;
import com.iap.ac.android.mpm.hook.HookRepository;
import com.iap.ac.android.mpm.node.base.BaseNode;
import com.iap.ac.android.mpm.node.base.NodeResponse;

/* loaded from: classes3.dex */
public class CommonHookNode extends BaseNode<CommonHookNodeRequest, CommonHookNodeResponse> {
    public HookRepository getHookRepository() {
        return new HookRepository();
    }

    @Override // com.iap.ac.android.mpm.node.base.BaseNode
    public void handleNode(CommonHookNodeRequest commonHookNodeRequest, INodeCallback<CommonHookNodeResponse> iNodeCallback) {
        String str = commonHookNodeRequest.hookCategory;
        if (HookConstants.HookCategory.HOOK_CATEGORY_TRADEPAY.equals(str)) {
            hookJsApi(commonHookNodeRequest, iNodeCallback);
        } else if ("URL".equals(str)) {
            hookUrl(commonHookNodeRequest, iNodeCallback);
        }
    }

    private void hookUrl(CommonHookNodeRequest commonHookNodeRequest, INodeCallback<CommonHookNodeResponse> iNodeCallback) {
        handleHookResult(getHookRepository().hookUrl(commonHookNodeRequest.hookUrl), false, iNodeCallback);
    }

    private void hookJsApi(CommonHookNodeRequest commonHookNodeRequest, INodeCallback<CommonHookNodeResponse> iNodeCallback) {
        PreCreateOrderConfig preCreateOrderConfig = commonHookNodeRequest.preCreateOrderConfig;
        handleHookResult(getHookRepository().hookJsApi(preCreateOrderConfig), preCreateOrderConfig.isOrderStrFromMiniProgram, iNodeCallback);
    }

    private void handleHookResult(CommonHookResult commonHookResult, boolean z, INodeCallback<CommonHookNodeResponse> iNodeCallback) {
        CommonHookNodeResponse commonHookNodeResponse = new CommonHookNodeResponse();
        Result result = new Result();
        if (commonHookResult == null) {
            ACLog.w(Constants.TAG, "HookCommonUrl error, result invalid");
            result.resultCode = ResultCode.UNKNOWN_EXCEPTION;
            result.resultMessage = "Oops! System busy. Try again later!";
            appendErrorInfo(commonHookNodeResponse, result, ResultCode.UNKNOWN_EXCEPTION, "HookCommonUrl error, result invalid");
            iNodeCallback.onResult(commonHookNodeResponse);
        } else if (!commonHookResult.success) {
            ACLog.w(Constants.TAG, "HookCommonUrl fail");
            result.resultCode = commonHookResult.errorCode;
            result.resultMessage = commonHookResult.errorMessage;
            appendErrorInfo(commonHookNodeResponse, result, commonHookResult.errorCode, commonHookResult.errorMessage);
            iNodeCallback.onResult(commonHookNodeResponse);
        } else if (!HookConstants.HookAction.HOOK_ACTION_DECODE.equals(commonHookResult.action)) {
            StringBuilder sb = new StringBuilder();
            sb.append("HookCommonUrl error, action unknown: ");
            sb.append(commonHookResult.action);
            String obj = sb.toString();
            ACLog.w(Constants.TAG, obj);
            result.resultCode = "PARAM_ILLEGAL";
            result.resultMessage = "Oops! System busy. Try again later!";
            appendErrorInfo(commonHookNodeResponse, result, "PARAM_ILLEGAL", obj);
            iNodeCallback.onResult(commonHookNodeResponse);
        } else if (commonHookResult.decodeParams != null && !TextUtils.isEmpty(commonHookResult.decodeParams.codeValue)) {
            ACLog.i(Constants.TAG, "begin to decode order code");
            commonHookNodeResponse.isSuccess = true;
            commonHookNodeResponse.codeValue = commonHookResult.decodeParams.codeValue;
            commonHookNodeResponse.isAcMiniProgram = z;
            iNodeCallback.onResult(commonHookNodeResponse);
        } else {
            String str = commonHookResult.decodeParams == null ? null : commonHookResult.decodeParams.codeValue;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("HookCommonUrl error, action is DECODE, but decodeParams is: ");
            sb2.append(commonHookResult.decodeParams);
            sb2.append(", payScheme is:");
            sb2.append(str);
            String obj2 = sb2.toString();
            ACLog.w(Constants.TAG, obj2);
            result.resultCode = "PARAM_ILLEGAL";
            result.resultMessage = "Oops! System busy. Try again later!";
            appendErrorInfo(commonHookNodeResponse, result, "PARAM_ILLEGAL", obj2);
            iNodeCallback.onResult(commonHookNodeResponse);
        }
    }

    private void appendErrorInfo(NodeResponse nodeResponse, Result result, String str, String str2) {
        nodeResponse.result = result;
        if (str == null) {
            str = ResultCode.INVALID_NETWORK;
        }
        nodeResponse.logResultCode = str;
        if (str2 == null) {
            str2 = "Oops! System busy. Try again later!";
        }
        nodeResponse.logResultMsg = str2;
        nodeResponse.endNode = LogConstants.Mpm.EndNodeType.HOOK;
    }
}
