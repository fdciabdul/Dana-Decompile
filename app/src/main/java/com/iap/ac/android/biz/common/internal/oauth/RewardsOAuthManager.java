package com.iap.ac.android.biz.common.internal.oauth;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.callback.IAuthLoginCallback;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import com.iap.ac.android.biz.common.internal.oauth.authlogin.AuthLoginProcessor;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentLoginResult;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.cookie.CookieUtils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RewardsOAuthManager implements IAuthCallback {
    public String mBizCode;
    public Context mContext;
    public String mGatewayUrl;
    public long mGetAuthCodeStartTime;
    public String mLoginSessionKey;
    public List<IAuthLoginCallback> mAuthLoginCallbacks = new ArrayList();
    public boolean mOnGoing = false;
    public AuthLoginProcessor mAuthLoginProcessor = new AuthLoginProcessor();

    public RewardsOAuthManager(Context context, String str, String str2) {
        this.mContext = context;
        this.mBizCode = str;
        this.mLoginSessionKey = str2;
        this.mGatewayUrl = FoundationProxy.getInstance(this.mBizCode).getGateWayUrl();
    }

    private void doOAuth(OAuthConfig oAuthConfig) {
        if (oAuthConfig != null) {
            ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_REWARDS_GET_AUTHCODE_ENTER).addParams("mode", (Object) 0).addParams("clientId", oAuthConfig.clientId).addParams("authClientId", oAuthConfig.authClientId).addParams("scopes", oAuthConfig.scopes).event();
            this.mGetAuthCodeStartTime = SystemClock.elapsedRealtime();
            SPIManager.getInstance().getAuthCode(oAuthConfig.clientId, oAuthConfig.authClientId, oAuthConfig.scopes, this);
            return;
        }
        reportAuthLoginResult(false, "PARAM_ILLEGAL", "Oops! System busy. Try again later!", 0L, "");
    }

    public void reportAuthLoginResult(boolean z, String str, String str2, long j, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("AuthLoginResult(%s), ");
        sb.append(z);
        ACLog.i(Constants.TAG, String.format(sb.toString(), this.mBizCode));
        synchronized (this) {
            for (IAuthLoginCallback iAuthLoginCallback : this.mAuthLoginCallbacks) {
                if (z) {
                    iAuthLoginCallback.onSuccess();
                } else {
                    iAuthLoginCallback.onFailed();
                }
            }
            if (z) {
                ACLogEvent.commonRpcSuccessEvent("iapconnect_center", LogConstants.EVENT_ID_REWARDS_AUTH_LOGIN, j, str3);
            } else {
                ACLogEvent.commonRpcFailEvent("iapconnect_center", LogConstants.EVENT_ID_REWARDS_AUTH_LOGIN, str, str2, j, str3);
                ACLogEvent.crucialRpcEvent("iapconnect_center", LogConstants.EVENT_ID_REWARDS_AUTH_LOGIN_FAIL, str2, str3);
            }
            this.mAuthLoginCallbacks.clear();
        }
    }

    private void startOAuthLogin(final String str) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.biz.common.internal.oauth.RewardsOAuthManager.1
            {
                RewardsOAuthManager.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                RewardsOAuthManager rewardsOAuthManager;
                synchronized (this) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        MobilePaymentLoginResult rewardsAuthLogin = RewardsOAuthManager.this.mAuthLoginProcessor.rewardsAuthLogin(RewardsOAuthManager.this.mContext, str);
                        if (rewardsAuthLogin == null) {
                            RewardsOAuthManager.this.reportAuthLoginResult(false, ResultCode.INVALID_NETWORK, "Oops! System busy. Try again later!", SystemClock.elapsedRealtime() - elapsedRealtime, "");
                        } else if (rewardsAuthLogin.success) {
                            ACManager.getInstance().save(ACManager.getInstance().getRewardsClientKeyStorageKey(RewardsOAuthManager.this.mBizCode), rewardsAuthLogin.clientKey);
                            ACManager.getInstance().save(ACManager.getInstance().getRewardsOpenIdStorageKey(RewardsOAuthManager.this.mBizCode), rewardsAuthLogin.openId);
                            RewardsOAuthManager.this.reportAuthLoginResult(true, null, null, SystemClock.elapsedRealtime() - elapsedRealtime, rewardsAuthLogin.traceId);
                        } else {
                            RewardsOAuthManager.this.reportAuthLoginResult(false, rewardsAuthLogin.errorCode, rewardsAuthLogin.errorMessage, SystemClock.elapsedRealtime() - elapsedRealtime, rewardsAuthLogin.traceId);
                        }
                        rewardsOAuthManager = RewardsOAuthManager.this;
                    } catch (Throwable th) {
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("RewardsOAuthManager(%s) auth login error with exception: ");
                            sb.append(th);
                            ACLog.e(Constants.TAG, String.format(sb.toString(), RewardsOAuthManager.this.mBizCode));
                            RewardsOAuthManager.this.reportAuthLoginResult(false, ResultCode.INVALID_NETWORK, Utils.e(th), SystemClock.elapsedRealtime() - elapsedRealtime, "");
                            rewardsOAuthManager = RewardsOAuthManager.this;
                        } catch (Throwable th2) {
                            RewardsOAuthManager.this.mOnGoing = false;
                            throw th2;
                        }
                    }
                    rewardsOAuthManager.mOnGoing = false;
                }
            }
        });
    }

    public void clearSessionId() {
        CookieUtils.clearCookies(this.mContext, this.mGatewayUrl, this.mLoginSessionKey);
    }

    public void doAuthLogin(OAuthConfig oAuthConfig, IAuthLoginCallback iAuthLoginCallback) {
        if (FoundationProxy.getInstance(this.mBizCode).getNetworkType() != FoundationProxy.NetworkType.NETWORK_TYPE_ACRPC) {
            iAuthLoginCallback.onSuccess();
            return;
        }
        synchronized (this) {
            if (iAuthLoginCallback != null) {
                this.mAuthLoginCallbacks.add(iAuthLoginCallback);
            }
            if (this.mOnGoing) {
                return;
            }
            this.mOnGoing = true;
            doOAuth(oAuthConfig);
        }
    }

    @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
    public void onResult(AuthResult authResult) {
        if (FoundationProxy.getInstance(this.mBizCode).getNetworkType() != FoundationProxy.NetworkType.NETWORK_TYPE_ACRPC) {
            return;
        }
        String str = authResult != null ? authResult.authCode : "";
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_REWARDS_GET_AUTHCODE).addParams("result", TextUtils.isEmpty(str) ^ true ? "T" : LogConstants.RESULT_FALSE).addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - this.mGetAuthCodeStartTime)).event();
        startOAuthLogin(str);
    }

    public void startOAuthLogout() {
        if (FoundationProxy.getInstance(this.mBizCode).getNetworkType() != FoundationProxy.NetworkType.NETWORK_TYPE_ACRPC) {
            return;
        }
        if (TextUtils.isEmpty(CookieUtils.getCookie(this.mGatewayUrl, this.mLoginSessionKey))) {
            ACLog.d(Constants.TAG, String.format("startOAuthLogout(%s), there is no session %s in cookie, skip it.", this.mBizCode, this.mLoginSessionKey));
        } else {
            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.biz.common.internal.oauth.RewardsOAuthManager.2
                {
                    RewardsOAuthManager.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RewardsOAuthManager.this.clearSessionId();
                }
            });
        }
    }

    public void syncStartOAuthLogout() {
        if (FoundationProxy.getInstance(this.mBizCode).getNetworkType() != FoundationProxy.NetworkType.NETWORK_TYPE_ACRPC) {
            return;
        }
        if (TextUtils.isEmpty(CookieUtils.getCookie(this.mGatewayUrl, this.mLoginSessionKey))) {
            ACLog.d(Constants.TAG, String.format("startOAuthLogout(%s), there is no session %s in cookie, skip it.", this.mBizCode, this.mLoginSessionKey));
        } else {
            clearSessionId();
        }
    }
}
