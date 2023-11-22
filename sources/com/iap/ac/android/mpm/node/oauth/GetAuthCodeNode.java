package com.iap.ac.android.mpm.node.oauth;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.node.base.BaseNode;
import com.iap.ac.android.mpm.utils.EntryCodeData;
import java.util.List;

/* loaded from: classes3.dex */
public class GetAuthCodeNode extends BaseNode<GetAuthCodeNodeRequest, GetAuthCodeNodeResponse> {
    @Override // com.iap.ac.android.mpm.node.base.BaseNode
    public void handleNode(GetAuthCodeNodeRequest getAuthCodeNodeRequest, final INodeCallback<GetAuthCodeNodeResponse> iNodeCallback) {
        String str = getAuthCodeNodeRequest.clientId;
        String str2 = getAuthCodeNodeRequest.authClientId;
        List<String> list = getAuthCodeNodeRequest.scopes;
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_GET_AUTHCODE_ENTER).addParams("mode", (Object) 0).addParams("clientId", str).addParams("authClientId", str2).addParams("scopes", list).event();
        final GetAuthCodeNodeResponse getAuthCodeNodeResponse = new GetAuthCodeNodeResponse();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        SPIManager.getInstance().getAuthCode(str, str2, list, new IAuthCallback() { // from class: com.iap.ac.android.mpm.node.oauth.GetAuthCodeNode.1
            @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
            public void onResult(AuthResult authResult) {
                boolean z = (authResult == null || TextUtils.isEmpty(authResult.authCode)) ? false : true;
                ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_GET_AUTHCODE).addParams("result", z ? "T" : LogConstants.RESULT_FALSE).addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)).addParams(LogConstants.KEY_TIME_STAPM, Long.valueOf(System.currentTimeMillis())).addParams("codeValue", EntryCodeData.getInstance().codeValue).addParams("authCode", z ? Integer.valueOf(authResult.authCode.hashCode()) : "").addParams(LogConstants.KEY_AUTH_METHOD, "REDIRECT").addParams("scene", "entry_code").event();
                getAuthCodeNodeResponse.isSuccess = z;
                if (z) {
                    getAuthCodeNodeResponse.authCode = authResult.authCode;
                } else {
                    Result result = new Result();
                    result.resultCode = ResultCode.INVALID_NETWORK;
                    result.resultMessage = "Oops! System busy. Try again later!";
                    getAuthCodeNodeResponse.logResultCode = ResultCode.INVALID_NETWORK;
                    if (authResult == null) {
                        getAuthCodeNodeResponse.logResultMsg = "get auth code fail: auth result is null ";
                    } else {
                        getAuthCodeNodeResponse.logResultMsg = "get auth code fail: auth code is empty";
                    }
                    getAuthCodeNodeResponse.endNode = "oauth";
                    getAuthCodeNodeResponse.result = result;
                }
                iNodeCallback.onResult(getAuthCodeNodeResponse);
            }
        });
    }
}
