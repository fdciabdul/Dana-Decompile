package com.iap.ac.android.mpm.node.url;

import android.os.Bundle;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.configcenter.Constant;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.model.ContainerParams;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.interceptor.provider.UAProvider;
import com.iap.ac.android.mpm.node.base.BaseNode;

/* loaded from: classes3.dex */
public class OpenUrlNode extends BaseNode<OpenUrlNodeRequest, OpenUrlNodeResponse> {
    @Override // com.iap.ac.android.mpm.node.base.BaseNode
    public void handleNode(OpenUrlNodeRequest openUrlNodeRequest, INodeCallback<OpenUrlNodeResponse> iNodeCallback) {
        UAProvider.mockUserAgent(openUrlNodeRequest.acDecodeConfig);
        ContainerParams containerParams = new ContainerParams(openUrlNodeRequest.openUrl);
        containerParams.containerBundle = new Bundle();
        containerParams.containerBundle.putString("bizScenario", Constants.H5Param.PARAM_SDK_FLAG);
        if (((Boolean) ConfigCenter.INSTANCE.getKeyOrDefault(Constant.KEY_AC_CODE_PRE_INJECT_JSBRIDGE, Boolean.TRUE)).booleanValue()) {
            containerParams.containerBundle.putBoolean("preInjectJSBridge", true);
        }
        containerParams.containerBundle.putString(Constants.H5Param.PARAM_BIZ_KEY, openUrlNodeRequest.bizKey);
        OpenUrlNodeResponse openUrlNodeResponse = new OpenUrlNodeResponse();
        try {
            WebContainer.getInstance("ac_biz").startContainer(openUrlNodeRequest.context, containerParams, openUrlNodeRequest.listener);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("OpenUrlNode");
            sb.append(e);
            ACLog.w(Constants.TAG, sb.toString());
            openUrlNodeResponse.isSuccess = false;
            Result result = new Result();
            openUrlNodeResponse.logResultCode = ResultCode.INVALID_NETWORK;
            result.resultCode = ResultCode.INVALID_NETWORK;
            result.resultMessage = "Oops! System busy. Try again later!";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("open url exception ");
            sb2.append(e);
            openUrlNodeResponse.logResultMsg = sb2.toString();
            openUrlNodeResponse.endNode = LogConstants.Mpm.EndNodeType.OPEN_URL;
            openUrlNodeResponse.result = result;
        }
        iNodeCallback.onResult(openUrlNodeResponse);
    }
}
