package com.iap.ac.android.mpm.node.decode;

import android.net.Uri;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.consts.InnerConstants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.base.model.decode.result.DecodeResult;
import com.iap.ac.android.mpm.base.model.route.DecodeActionType;
import com.iap.ac.android.mpm.decode.DecodeRepository;
import com.iap.ac.android.mpm.node.base.BaseNode;
import com.iap.ac.android.mpm.node.base.NodeResponse;

/* loaded from: classes3.dex */
public class DecodeOrderNode extends BaseNode<DecodeOrderNodeRequest, DecodeOrderNodeResponse> {
    public DecodeRepository getDecodeRepository() {
        return new DecodeRepository();
    }

    @Override // com.iap.ac.android.mpm.node.base.BaseNode
    public void handleNode(DecodeOrderNodeRequest decodeOrderNodeRequest, INodeCallback<DecodeOrderNodeResponse> iNodeCallback) {
        String str = decodeOrderNodeRequest.codeValue;
        if (str != null && str.startsWith(InnerConstants.PREFIX_INTERCEPT_AND_GET_CODE_URL)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter("ACCodeValue");
                if (!TextUtils.isEmpty(queryParameter)) {
                    str = queryParameter;
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("decode error:");
                sb.append(e);
                ACLog.e(Constants.TAG, sb.toString());
                DecodeOrderNodeResponse decodeOrderNodeResponse = new DecodeOrderNodeResponse();
                Result result = new Result();
                decodeOrderNodeResponse.logResultCode = ResultCode.UNKNOWN_EXCEPTION;
                result.resultCode = ResultCode.UNKNOWN_EXCEPTION;
                result.resultMessage = "Oops! System busy. Try again later!";
                decodeOrderNodeResponse.logResultMsg = Utils.e(e);
                decodeOrderNodeResponse.endNode = "scan";
                decodeOrderNodeResponse.result = result;
                iNodeCallback.onResult(decodeOrderNodeResponse);
                return;
            }
        }
        decode(str, decodeOrderNodeRequest.isAcMiniProgram, iNodeCallback);
    }

    private void decode(String str, boolean z, INodeCallback<DecodeOrderNodeResponse> iNodeCallback) {
        DecodeOrderNodeResponse decodeOrderNodeResponse = new DecodeOrderNodeResponse();
        try {
            DecodeResult decode = getDecodeRepository().decode(str, z);
            if (decode == null) {
                ACLog.w(Constants.TAG, "decode result is null");
                appendErrorInfo(decodeOrderNodeResponse, ResultCode.INVALID_NETWORK, "decode result is null");
                iNodeCallback.onResult(decodeOrderNodeResponse);
                return;
            }
            DecodeOrderNodeResponse handleDecodeResult = handleDecodeResult(decode);
            handleDecodeResult.thirdPartyError = decode.thirdPartyError;
            iNodeCallback.onResult(handleDecodeResult);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("decode error:");
            sb.append(e);
            String obj = sb.toString();
            ACLog.w(Constants.TAG, obj);
            appendErrorInfo(decodeOrderNodeResponse, ResultCode.INVALID_NETWORK, obj);
            iNodeCallback.onResult(decodeOrderNodeResponse);
        }
    }

    private DecodeOrderNodeResponse handleDecodeResult(DecodeResult decodeResult) {
        if (!decodeResult.success) {
            ACLog.w(Constants.TAG, "decode result is false");
            DecodeOrderNodeResponse decodeOrderNodeResponse = new DecodeOrderNodeResponse();
            Result result = new Result();
            result.resultCode = decodeResult.errorCode;
            result.resultMessage = decodeResult.errorMessage;
            appendErrorInfo(decodeOrderNodeResponse, result);
            return decodeOrderNodeResponse;
        }
        return parseResponseUri(decodeResult.uri);
    }

    private DecodeOrderNodeResponse parseResponseUri(String str) {
        Uri uri;
        DecodeOrderNodeResponse decodeOrderNodeResponse;
        String str2 = null;
        try {
            uri = Uri.parse(str);
            try {
                str2 = uri.getHost();
            } catch (Exception e) {
                e = e;
                StringBuilder sb = new StringBuilder();
                sb.append("decode action parse error:");
                sb.append(e);
                ACLog.e(Constants.TAG, sb.toString());
                decodeOrderNodeResponse = new DecodeOrderNodeResponse();
                if (uri != null) {
                }
                ACLog.e(Constants.TAG, "decode action parse error: illegal uri");
                appendErrorInfo(decodeOrderNodeResponse, ResultCode.INVALID_NETWORK, "decode action parse error: illegal uri");
                return decodeOrderNodeResponse;
            }
        } catch (Exception e2) {
            e = e2;
            uri = null;
        }
        decodeOrderNodeResponse = new DecodeOrderNodeResponse();
        if (uri != null || !"ac".equalsIgnoreCase(uri.getScheme()) || TextUtils.isEmpty(str2)) {
            ACLog.e(Constants.TAG, "decode action parse error: illegal uri");
            appendErrorInfo(decodeOrderNodeResponse, ResultCode.INVALID_NETWORK, "decode action parse error: illegal uri");
            return decodeOrderNodeResponse;
        } else if ("pay".equalsIgnoreCase(str2)) {
            return handleActionPay(uri, str2);
        } else {
            if (DecodeActionType.OPEN_URL.equalsIgnoreCase(str2)) {
                return handleActionOpenUrl(uri, str2);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("decode action is illegal");
            sb2.append(str2);
            String obj = sb2.toString();
            ACLog.w(Constants.TAG, obj);
            appendErrorInfo(decodeOrderNodeResponse, ResultCode.INVALID_NETWORK, obj);
            return decodeOrderNodeResponse;
        }
    }

    private DecodeOrderNodeResponse handleActionPay(Uri uri, String str) {
        DecodeOrderNodeResponse decodeOrderNodeResponse = new DecodeOrderNodeResponse();
        decodeOrderNodeResponse.result = new Result();
        String queryParameter = uri.getQueryParameter("paymentId");
        String queryParameter2 = uri.getQueryParameter("paymentUrl");
        String queryParameter3 = uri.getQueryParameter("paymentRedirectUrl");
        String queryParameter4 = uri.getQueryParameter(InnerConstants.KEY_PAYMENT_CANCEL_URL);
        String queryParameter5 = uri.getQueryParameter("terminalType");
        if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2)) {
            ACLog.e(Constants.TAG, "decode handle error without payment id");
            appendErrorInfo(decodeOrderNodeResponse, ResultCode.INVALID_NETWORK, "decode handle error without payment id");
        } else {
            decodeOrderNodeResponse.isSuccess = true;
            decodeOrderNodeResponse.paymentId = queryParameter;
            decodeOrderNodeResponse.paymentUrl = queryParameter2;
            decodeOrderNodeResponse.paymentRedirectUrl = queryParameter3;
            decodeOrderNodeResponse.paymentCancelUrl = queryParameter4;
            decodeOrderNodeResponse.decodeAction = str;
            decodeOrderNodeResponse.terminalType = queryParameter5;
        }
        return decodeOrderNodeResponse;
    }

    private DecodeOrderNodeResponse handleActionOpenUrl(Uri uri, String str) {
        DecodeOrderNodeResponse decodeOrderNodeResponse = new DecodeOrderNodeResponse();
        decodeOrderNodeResponse.result = new Result();
        String queryParameter = uri.getQueryParameter("url");
        if (!TextUtils.isEmpty(queryParameter)) {
            decodeOrderNodeResponse.isSuccess = true;
            decodeOrderNodeResponse.openUrl = queryParameter;
            decodeOrderNodeResponse.decodeAction = str;
        } else {
            ACLog.e(Constants.TAG, "decode handle error without open url");
            appendErrorInfo(decodeOrderNodeResponse, ResultCode.INVALID_NETWORK, "decode handle error without open url");
        }
        return decodeOrderNodeResponse;
    }

    private void appendErrorInfo(NodeResponse nodeResponse, Result result) {
        nodeResponse.result = result;
        nodeResponse.logResultCode = result.resultCode;
        nodeResponse.logResultMsg = result.resultMessage;
        nodeResponse.endNode = "scan";
    }

    private void appendErrorInfo(NodeResponse nodeResponse, String str, String str2) {
        Result result = new Result();
        result.resultCode = ResultCode.INVALID_NETWORK;
        result.resultMessage = "Oops! System busy. Try again later!";
        nodeResponse.result = result;
        nodeResponse.logResultCode = str;
        nodeResponse.logResultMsg = str2;
        nodeResponse.endNode = "scan";
    }
}
