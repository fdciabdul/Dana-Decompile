package com.iap.ac.android.mpm.node.oauth;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.base.model.oauth.result.PrepareCollectionCodeAuthResult;
import com.iap.ac.android.mpm.node.base.BaseNode;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.oauth.collectioncode.CollectionCodeAuthRepository;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes3.dex */
public class PrepareAuthNode extends BaseNode<PrepareAuthNodeRequest, PrepareAuthNodeResponse> {
    private static final String AC_AUTHCODE = "${AC_AUTHCODE}";
    private static final String DELIMETER_UNDER_LINE = "_";
    private static final String KEY_APP_ID = "app_id";
    private static final String KEY_AUTH_CODE = "auth_code";
    private static final String KEY_ISV_APP_ID = "isv_app_id";
    private static final String KEY_REDIRECT_URI = "redirect_uri";
    private static final String SCOPE_AUTH_BASE_USERINFO = "BASE_USER_INFO";

    public CollectionCodeAuthRepository getCollectionCodeAuthRepository() {
        return new CollectionCodeAuthRepository();
    }

    @Override // com.iap.ac.android.mpm.node.base.BaseNode
    public void handleNode(PrepareAuthNodeRequest prepareAuthNodeRequest, INodeCallback<PrepareAuthNodeResponse> iNodeCallback) {
        PrepareCollectionCodeAuthResult prepare;
        PrepareAuthNodeResponse prepareAuthNodeResponse = new PrepareAuthNodeResponse();
        Result result = new Result();
        try {
            if (ConfigCenter.INSTANCE.isACPrepareOptimizedEnable()) {
                String str = prepareAuthNodeRequest.url;
                String str2 = prepareAuthNodeRequest.acquireId;
                Uri parse = Uri.parse(str);
                prepare = null;
                if (parse != null) {
                    prepare = new PrepareCollectionCodeAuthResult();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("BASE_USER_INFO");
                    prepare.scopes = arrayList;
                    prepare.authClientId = getAuthClientId(parse, str2);
                    prepare.authRedirectUrl = getAuthRedirectUrl(parse);
                    if (!TextUtils.isEmpty(prepare.authClientId) && !TextUtils.isEmpty(prepare.authRedirectUrl)) {
                        prepare.success = true;
                    }
                    prepare.errorCode = "PARAM_ILLEGAL";
                    prepare.errorMessage = "Illegal parameters.";
                }
            } else {
                prepare = getCollectionCodeAuthRepository().prepare(prepareAuthNodeRequest.url, prepareAuthNodeRequest.acquireId);
            }
            if (prepare == null) {
                ACLog.w(Constants.TAG, "collection code prepare result is null");
                result.resultCode = ResultCode.INVALID_NETWORK;
                result.resultMessage = "Oops! System busy. Try again later!";
                appendErrorInfo(prepareAuthNodeResponse, result, ResultCode.INVALID_NETWORK, "collection code prepare result is null");
            } else if (prepare.success) {
                prepareAuthNodeResponse.isSuccess = true;
                prepareAuthNodeResponse.authResult = prepare;
            } else {
                ACLog.w(Constants.TAG, "collection code prepare result.success is false");
                result.resultCode = prepare.errorCode;
                result.resultMessage = prepare.errorMessage;
                appendErrorInfo(prepareAuthNodeResponse, result, prepare.errorCode, prepare.errorMessage);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("prepareCollectionCodeAuth error:");
            sb.append(Utils.e(e));
            String obj = sb.toString();
            result.resultCode = ResultCode.INVALID_NETWORK;
            result.resultMessage = "Oops! System busy. Try again later!";
            appendErrorInfo(prepareAuthNodeResponse, result, ResultCode.INVALID_NETWORK, obj);
        }
        iNodeCallback.onResult(prepareAuthNodeResponse);
    }

    private String getAuthRedirectUrl(Uri uri) {
        Set<String> queryParameterNames;
        if (uri == null || (queryParameterNames = uri.getQueryParameterNames()) == null) {
            return null;
        }
        String queryParameter = uri.getQueryParameter(KEY_REDIRECT_URI);
        if (TextUtils.isEmpty(queryParameter)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : queryParameterNames) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(KEY_REDIRECT_URI, str)) {
                String queryParameter2 = uri.getQueryParameter(str);
                if (!TextUtils.isEmpty(queryParameter2)) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(queryParameter2);
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
            }
        }
        Uri parse = Uri.parse(queryParameter);
        Uri.Builder buildUpon = parse.buildUpon();
        if (!TextUtils.isEmpty(parse.getQuery())) {
            sb.append(parse.getQuery());
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        if (!queryParameterNames.contains("app_id")) {
            if (!queryParameterNames.contains(KEY_ISV_APP_ID) || !isKeyUnique(uri, KEY_ISV_APP_ID)) {
                return null;
            }
            String queryParameter3 = uri.getQueryParameter(KEY_ISV_APP_ID);
            sb.append("app_id");
            sb.append("=");
            sb.append(queryParameter3);
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        buildUpon.encodedQuery(new StringBuilder("auth_code=${AC_AUTHCODE}").toString());
        String obj = buildUpon.build().toString();
        String obj2 = sb.toString();
        if (TextUtils.isEmpty(obj2)) {
            return obj;
        }
        if (obj2.lastIndexOf(ContainerUtils.FIELD_DELIMITER) == obj2.length() - 1) {
            obj2 = obj2.substring(0, obj2.length() - 1);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append(ContainerUtils.FIELD_DELIMITER);
        sb2.append(obj2);
        return sb2.toString();
    }

    private boolean isKeyUnique(Uri uri, String str) {
        int i;
        String[] split;
        if (uri == null) {
            return false;
        }
        String query = uri.getQuery();
        if (TextUtils.isEmpty(query)) {
            return false;
        }
        String[] split2 = query.split(ContainerUtils.FIELD_DELIMITER);
        if (split2 == null || split2.length <= 0) {
            i = 0;
        } else {
            i = 0;
            for (String str2 : split2) {
                if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && split[0].equals(str)) {
                    i++;
                }
            }
        }
        return i == 1;
    }

    private String getAuthClientId(Uri uri, String str) {
        if (uri == null) {
            return null;
        }
        String queryParameter = uri.getQueryParameter("app_id");
        String queryParameter2 = uri.getQueryParameter(KEY_ISV_APP_ID);
        if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2)) {
            return null;
        }
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = queryParameter2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(queryParameter);
        return sb.toString();
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
        nodeResponse.endNode = LogConstants.Mpm.EndNodeType.PREPARE;
    }
}
