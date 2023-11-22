package com.iap.ac.android.gol.biz;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.AcBaseResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.gol.rpc.AuthProcessor;
import com.iap.ac.android.gol.rpc.request.AuthPrepareCallbackRequest;
import com.iap.ac.android.gol.rpc.result.AuthPrepareCallbackResult;
import com.iap.ac.android.gol.utils.GolMonitorUtils;
import java.util.Set;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public abstract class BaseAuthProcessor {
    private static final String AUTH_CODE_PLACEHOLDER = "${authCode}";
    private static final String AUTH_STATE_PLACEHOLDER = "${authState}";
    private static final String KEY_AUTH_CODE = "authCode";
    private static final String KEY_AUTH_STATE = "authState";
    private static final String KEY_PARAMETER_FORMAT = "%s=%s";
    protected boolean fromGoogle;
    protected String mAuthRedirectUrl;
    protected String mAuthState;
    protected AcCallback<AcBaseResult> mCallback;
    protected boolean mNeedCallback;
    protected String mPassThroughInfo;
    protected String mReferenceAgreementId;
    protected long mStartTime;

    public BaseAuthProcessor(boolean z) {
        this.fromGoogle = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleAuthResult(final AuthResult authResult) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.gol.biz.BaseAuthProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                ACLog.i(Constants.TAG, "signContract handleAuthResult enter");
                String str = authResult.authCode;
                if (TextUtils.isEmpty(str)) {
                    String str2 = TextUtils.isEmpty(authResult.errorCode) ? ResultCode.UNKNOWN_EXCEPTION : authResult.errorCode;
                    String str3 = TextUtils.isEmpty(authResult.errorMessage) ? "Oops! System busy. Try again later!" : authResult.errorMessage;
                    StringBuilder sb = new StringBuilder();
                    sb.append("invalid getAuthCode result: ");
                    sb.append(str3);
                    BaseAuthProcessor.this.handleCallback(false, str2, str3, sb.toString());
                    return;
                }
                if (!TextUtils.isEmpty(authResult.authState)) {
                    BaseAuthProcessor.this.mAuthState = authResult.authState;
                }
                if (!TextUtils.isEmpty(authResult.authRedirectUrl)) {
                    BaseAuthProcessor.this.mAuthRedirectUrl = authResult.authRedirectUrl;
                }
                if (!BaseAuthProcessor.this.mNeedCallback) {
                    BaseAuthProcessor.this.jumpToMerchantApp(str);
                    return;
                }
                AuthProcessor authProcessor = new AuthProcessor();
                AuthPrepareCallbackRequest authPrepareCallbackRequest = new AuthPrepareCallbackRequest();
                authPrepareCallbackRequest.authCode = str;
                authPrepareCallbackRequest.authState = BaseAuthProcessor.this.mAuthState;
                authPrepareCallbackRequest.authRedirectUrl = BaseAuthProcessor.this.mAuthRedirectUrl;
                authPrepareCallbackRequest.referenceAgreementId = BaseAuthProcessor.this.mReferenceAgreementId;
                authPrepareCallbackRequest.passThroughInfo = BaseAuthProcessor.this.mPassThroughInfo;
                AuthPrepareCallbackResult authPrepareCallbackResult = null;
                try {
                    authPrepareCallbackResult = authProcessor.prepareCallback(authPrepareCallbackRequest);
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("signContract failed, e: ");
                    sb2.append(th);
                    ACLog.e(Constants.TAG, sb2.toString());
                }
                if (authPrepareCallbackResult != null && authPrepareCallbackResult.success) {
                    if (!TextUtils.isEmpty(authPrepareCallbackResult.authRedirectUrl)) {
                        BaseAuthProcessor.this.mAuthRedirectUrl = authPrepareCallbackResult.authRedirectUrl;
                    }
                    BaseAuthProcessor.this.jumpToMerchantApp(str);
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("auth prepare callback rpc error: ");
                sb3.append(authPrepareCallbackResult);
                BaseAuthProcessor.this.handleCallback(false, authPrepareCallbackResult == null ? ResultCode.INVALID_NETWORK : authPrepareCallbackResult.errorCode, authPrepareCallbackResult != null ? authPrepareCallbackResult.errorMessage : "Oops! System busy. Try again later!", sb3.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleCallback(boolean z, String str, String str2, String str3) {
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("signContract success, redirectUrl is: ");
            sb.append(this.mAuthRedirectUrl);
            ACLog.i(Constants.TAG, sb.toString());
            GolMonitorUtils.signContractFinish(true, this.mAuthRedirectUrl, this.mStartTime, this.fromGoogle);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("signContract fail: ");
            sb2.append(str3);
            ACLog.i(Constants.TAG, sb2.toString());
            GolMonitorUtils.signContractFail(str3, this.mAuthRedirectUrl, this.mStartTime, this.fromGoogle);
        }
        AcBaseResult acBaseResult = new AcBaseResult();
        acBaseResult.success = z;
        acBaseResult.errorCode = str;
        acBaseResult.errorMessage = str2;
        AcCallback<AcBaseResult> acCallback = this.mCallback;
        if (acCallback != null) {
            acCallback.onResult(acBaseResult);
        } else {
            ACLog.i(Constants.TAG, "signContract handleCallback error, callback is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToMerchantApp(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gol signContract, redirect to payRedirectUrl: ");
        sb.append(this.mAuthRedirectUrl);
        ACLog.e(Constants.TAG, sb.toString());
        if (this.fromGoogle) {
            handleCallback(true, "", "", "");
        } else if (TextUtils.isEmpty(this.mAuthRedirectUrl)) {
            handleCallback(false, "PARAM_ILLEGAL", "Oops! System busy. Try again later!", "empty auth redirect url, ignore it");
        } else {
            try {
                Uri parse = Uri.parse(this.mAuthRedirectUrl);
                if (this.mAuthRedirectUrl.contains(AUTH_CODE_PLACEHOLDER)) {
                    String replace = this.mAuthRedirectUrl.replace(AUTH_CODE_PLACEHOLDER, str);
                    this.mAuthRedirectUrl = replace;
                    parse = Uri.parse(replace);
                } else if (!hasKey(parse, "authCode")) {
                    String query = parse.getQuery();
                    String format = String.format(KEY_PARAMETER_FORMAT, "authCode", str);
                    if (!TextUtils.isEmpty(query)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(query);
                        sb2.append(ContainerUtils.FIELD_DELIMITER);
                        sb2.append(format);
                        format = sb2.toString();
                    }
                    parse = new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).encodedQuery(format).build();
                }
                if (this.mAuthState == null) {
                    this.mAuthState = "";
                }
                String obj = parse.toString();
                this.mAuthRedirectUrl = obj;
                if (obj.contains(AUTH_STATE_PLACEHOLDER)) {
                    String replace2 = this.mAuthRedirectUrl.replace(AUTH_STATE_PLACEHOLDER, this.mAuthState);
                    this.mAuthRedirectUrl = replace2;
                    parse = Uri.parse(replace2);
                } else if (!hasKey(parse, "authState")) {
                    String query2 = parse.getQuery();
                    String format2 = String.format(KEY_PARAMETER_FORMAT, "authState", this.mAuthState);
                    if (!TextUtils.isEmpty(query2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(query2);
                        sb3.append(ContainerUtils.FIELD_DELIMITER);
                        sb3.append(format2);
                        format2 = sb3.toString();
                    }
                    parse = new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).encodedQuery(format2).build();
                }
                this.mAuthRedirectUrl = parse.toString();
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                ACManager.getInstance().getContext().startActivity(intent);
                handleCallback(true, "", "", "");
            } catch (Throwable th) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Gol jumpToMerchantApp error:");
                sb4.append(th);
                handleCallback(false, ResultCode.UNKNOWN_EXCEPTION, "Oops! System busy. Try again later!", sb4.toString());
            }
        }
    }

    private boolean hasKey(Uri uri, String str) {
        Set<String> queryParameterNames;
        return (uri == null || (queryParameterNames = uri.getQueryParameterNames()) == null || !queryParameterNames.contains(str)) ? false : true;
    }
}
