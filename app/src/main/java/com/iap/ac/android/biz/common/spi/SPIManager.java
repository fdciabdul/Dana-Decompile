package com.iap.ac.android.biz.common.spi;

import android.net.Uri;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.callback.IOAuth;
import com.iap.ac.android.biz.common.callback.IPay;
import com.iap.ac.android.biz.common.callback.IPayCallback;
import com.iap.ac.android.biz.common.callback.OpenAbilityDelegate;
import com.iap.ac.android.biz.common.callback.OpenBizSceneCallback;
import com.iap.ac.android.biz.common.callback.UserDelegate;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.biz.common.model.OAuthUserInfo;
import com.iap.ac.android.biz.common.model.OpenUserInfoCallback;
import com.iap.ac.android.biz.common.model.PayResult;
import com.iap.ac.android.biz.common.model.PayResultCode;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.ScanCallback;
import com.iap.ac.android.biz.common.model.ScanErrorCode;
import com.iap.ac.android.biz.common.model.ScannerOption;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.model.auth.AuthPageRequest;
import com.iap.ac.android.biz.common.model.auth.AuthPageResult;
import com.iap.ac.android.biz.common.model.auth.AuthRequest;
import com.iap.ac.android.biz.common.model.auth.TrustLoginInfo;
import com.iap.ac.android.biz.common.proxy.HttpTransporter;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.common.rpc.model.HttpResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class SPIManager {
    public static volatile SPIManager mInstance;
    public AclOAuthImpl aclOAuth;
    public AclOpenAbilityImpl aclOpenAbility;
    public AclPayImpl aclPay;
    public AclUserDelegateImpl aclUserDelegate;
    public AclOnboardingImpl mAclOnboarding;
    public HttpTransporter mHttpTransporter;
    public boolean mInitialized = false;
    public IOAuth mOAuth;
    public OpenAbilityDelegate mOpenAbilityDelegate;
    public IPay mPay;
    public UserDelegate mUserDelegate;

    public static SPIManager getInstance() {
        if (mInstance == null) {
            synchronized (SPIManager.class) {
                if (mInstance == null) {
                    mInstance = new SPIManager();
                }
            }
        }
        return mInstance;
    }

    private void handleForFetchTrustLoginCredentialsError(String str, AcCallback<TrustLoginInfo> acCallback) {
        ACLog.e(Constants.TAG, str);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SPI_FETCH_LOGIN_CREDENTIALS_FAIL, str);
        if (acCallback != null) {
            TrustLoginInfo trustLoginInfo = new TrustLoginInfo();
            trustLoginInfo.success = false;
            trustLoginInfo.errorCode = ResultCode.UNKNOWN_EXCEPTION;
            trustLoginInfo.errorMessage = str;
            acCallback.onResult(trustLoginInfo);
        }
    }

    private void handleForGetAuthCodeError(String str, IAuthCallback iAuthCallback) {
        ACLog.e(Constants.TAG, str);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SPI_GET_AUTHCODE_FAIL, str);
        if (iAuthCallback != null) {
            iAuthCallback.onResult(new AuthResult());
        }
    }

    private void handleForGetAuthPageError(String str, AcCallback<AuthPageResult> acCallback) {
        ACLog.e(Constants.TAG, str);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SPI_GET_AUTHCODE_FAIL, str);
        if (acCallback != null) {
            acCallback.onResult(new AuthPageResult());
        }
    }

    private void handleForGetOpenIdError(String str) {
        ACLog.e(Constants.TAG, str);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SPI_GET_OPEN_ID_FAIL, str);
    }

    private void handleForGetOpenUserInfoError(String str, OpenUserInfoCallback openUserInfoCallback) {
        ACLog.e(Constants.TAG, str);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SPI_GET_OPEN_USER_INFO_FAIL, str);
        if (openUserInfoCallback != null) {
            openUserInfoCallback.onGetOpenUserInfo(null);
        }
    }

    private void handleForPayError(String str, IPayCallback iPayCallback) {
        ACLog.e(Constants.TAG, str);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SPI_PAY_FAIL, str);
        if (iPayCallback != null) {
            PayResult payResult = new PayResult();
            payResult.setResultCode(PayResultCode.PAY_FAILURE);
            payResult.setResultMessage("Oops! System busy. Try again later!");
            iPayCallback.onResult(payResult);
        }
    }

    private void handleForScanError(ScanErrorCode scanErrorCode, String str, ScanCallback scanCallback) {
        ACLog.e(Constants.TAG, str);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SPI_SCAN_FAIL, str);
        if (scanCallback != null) {
            scanCallback.onFailure(scanErrorCode, str);
        }
    }

    private void handleForSendHttpRequestError(String str) throws IOException {
        ACLog.e(Constants.TAG, str);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SPI_SEND_HTTP_REQUEST_FAIL, str);
        throw new IOException(str);
    }

    private void handleForStartSchemeError(String str) {
        ACLog.e(Constants.TAG, str);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SPI_START_SCHEME_FAIL, str);
    }

    public void fetchTrustLoginCredentials(AcCallback<TrustLoginInfo> acCallback) {
        if (!initialized()) {
            handleForFetchTrustLoginCredentialsError("SPIManager, fetchTrustLoginCredentials error, not initialized", acCallback);
        }
        this.mAclOnboarding.fetchTrustLoginCredentials(APIContextFactory.createACAPIContext(), acCallback);
    }

    public void getAuthCode(String str, String str2, List<String> list, IAuthCallback iAuthCallback) {
        getAuthCode(str, str2, list, APIContextFactory.createACAPIContext(), iAuthCallback);
    }

    public String getOpenId() {
        return getOpenId(APIContextFactory.createACAPIContext());
    }

    public void getOpenUserInfo(OAuthUserInfo oAuthUserInfo, OpenUserInfoCallback openUserInfoCallback) {
        getOpenUserInfo(oAuthUserInfo, APIContextFactory.createACAPIContext(), openUserInfoCallback);
    }

    public void init(InitConfig initConfig) {
        synchronized (this) {
            if (initialized()) {
                ACLog.w(Constants.TAG, "SPIManager initialized, skip it");
                return;
            }
            IOAuth iOAuth = initConfig.oAuth;
            this.mOAuth = iOAuth;
            if (iOAuth == null) {
                this.aclOAuth = new AclOAuthImpl();
            }
            UserDelegate userDelegate = initConfig.userDelegate;
            this.mUserDelegate = userDelegate;
            if (userDelegate == null) {
                this.aclUserDelegate = new AclUserDelegateImpl();
            }
            IPay iPay = initConfig.pay;
            this.mPay = iPay;
            if (iPay == null) {
                this.aclPay = new AclPayImpl();
            }
            OpenAbilityDelegate openAbilityDelegate = initConfig.openAbilityDelegate;
            this.mOpenAbilityDelegate = openAbilityDelegate;
            if (openAbilityDelegate == null) {
                this.aclOpenAbility = new AclOpenAbilityImpl();
            }
            this.mHttpTransporter = initConfig.networkProxy;
            this.mAclOnboarding = new AclOnboardingImpl();
            this.mInitialized = true;
            ACLog.w(Constants.TAG, "SPIManager initialize success");
        }
    }

    public boolean initialized() {
        boolean z;
        synchronized (this) {
            z = this.mInitialized;
        }
        return z;
    }

    public void openBizScene(String str, Map<String, String> map, OpenBizSceneCallback openBizSceneCallback) {
        openBizScene(str, map, APIContextFactory.createACAPIContext(), openBizSceneCallback);
    }

    public boolean openScheme(Uri uri) {
        return openScheme(uri, APIContextFactory.createACAPIContext());
    }

    public void pay(String str, String str2, IPayCallback iPayCallback) {
        pay(str, str2, APIContextFactory.createACAPIContext(), iPayCallback);
    }

    public void scan(ScannerOption scannerOption, ScanCallback scanCallback) {
        scan(scannerOption, APIContextFactory.createACAPIContext(), scanCallback);
    }

    public HttpResponse sendHttpRequest(HttpRequest httpRequest) throws IOException {
        if (!initialized()) {
            handleForSendHttpRequestError("SPIManager, sendHttpRequest error, not initialized");
        }
        if (this.mHttpTransporter == null) {
            handleForSendHttpRequestError("SPIManager, pay error, pay impl is null");
        }
        return this.mHttpTransporter.sendHttpRequest(httpRequest);
    }

    public void showAuthPage(AuthPageRequest authPageRequest, AcCallback<AuthPageResult> acCallback) {
        showAuthPage(authPageRequest, APIContextFactory.createACAPIContext(), acCallback);
    }

    public void getAuthCode(String str, String str2, List<String> list, AclAPIContext aclAPIContext, IAuthCallback iAuthCallback) {
        ACLog.i(Constants.TAG, "getAuthCode with clientId enter");
        if (!initialized()) {
            handleForGetAuthCodeError("SPIManager, getAuthCode error, not initialized", iAuthCallback);
            return;
        }
        IOAuth iOAuth = this.mOAuth;
        if (iOAuth != null) {
            iOAuth.getAuthCode(str, str2, list, iAuthCallback);
            return;
        }
        AclOAuthImpl aclOAuthImpl = this.aclOAuth;
        if (aclOAuthImpl != null) {
            aclOAuthImpl.getAuthCode(str, str2, list, aclAPIContext, iAuthCallback);
        } else {
            handleForGetAuthCodeError("SPIManager, getAuthCode error, oAuth impl is null", iAuthCallback);
        }
    }

    public String getOpenId(AclAPIContext aclAPIContext) {
        if (!initialized()) {
            handleForGetOpenIdError("SPIManager, getOpenId error, not initialized");
            return null;
        }
        UserDelegate userDelegate = this.mUserDelegate;
        if (userDelegate != null) {
            return userDelegate.getOpenId();
        }
        AclUserDelegateImpl aclUserDelegateImpl = this.aclUserDelegate;
        if (aclUserDelegateImpl != null) {
            return aclUserDelegateImpl.getOpenId(aclAPIContext);
        }
        handleForGetOpenIdError("SPIManager, getOpenId error, userDelegate is null");
        return null;
    }

    public void getOpenUserInfo(OAuthUserInfo oAuthUserInfo, AclAPIContext aclAPIContext, OpenUserInfoCallback openUserInfoCallback) {
        ACLog.i(Constants.TAG, "SPIManager, getOpenUserInfo enter");
        if (!initialized()) {
            handleForGetOpenUserInfoError("SPIManager, getOpenUserInfo error, not initialized", openUserInfoCallback);
            return;
        }
        UserDelegate userDelegate = this.mUserDelegate;
        if (userDelegate != null) {
            userDelegate.getOpenUserInfo(oAuthUserInfo, openUserInfoCallback);
            return;
        }
        AclUserDelegateImpl aclUserDelegateImpl = this.aclUserDelegate;
        if (aclUserDelegateImpl != null) {
            aclUserDelegateImpl.getOpenUserInfo(oAuthUserInfo, aclAPIContext, openUserInfoCallback);
        } else {
            handleForGetOpenUserInfoError("SPIManager, getOpenUserInfo error, userDelegate is null", openUserInfoCallback);
        }
    }

    public void openBizScene(String str, Map<String, String> map, AclAPIContext aclAPIContext, OpenBizSceneCallback openBizSceneCallback) {
        if (!initialized()) {
            handleForStartSchemeError("SPIManager, openBizScene error, not initialized");
            return;
        }
        OpenAbilityDelegate openAbilityDelegate = this.mOpenAbilityDelegate;
        if (openAbilityDelegate != null) {
            openAbilityDelegate.openBizScene(str, map, openBizSceneCallback);
            return;
        }
        AclOpenAbilityImpl aclOpenAbilityImpl = this.aclOpenAbility;
        if (aclOpenAbilityImpl != null) {
            aclOpenAbilityImpl.openBizScene(str, map, aclAPIContext, openBizSceneCallback);
        } else {
            handleForStartSchemeError("SPIManager, openBizScene error, open ability delegate is not implemented");
        }
    }

    public boolean openScheme(Uri uri, AclAPIContext aclAPIContext) {
        if (!initialized()) {
            handleForStartSchemeError("SPIManager, startScheme error, not initialized");
            return false;
        }
        OpenAbilityDelegate openAbilityDelegate = this.mOpenAbilityDelegate;
        if (openAbilityDelegate != null) {
            return openAbilityDelegate.openScheme(uri);
        }
        AclOpenAbilityImpl aclOpenAbilityImpl = this.aclOpenAbility;
        if (aclOpenAbilityImpl != null) {
            return aclOpenAbilityImpl.openScheme(uri, aclAPIContext);
        }
        handleForStartSchemeError("SPIManager, startScheme error, open ability delegate is not implemented");
        return false;
    }

    public void pay(String str, String str2, AclAPIContext aclAPIContext, IPayCallback iPayCallback) {
        ACLog.i(Constants.TAG, "SPIManager, pay enter");
        if (!initialized()) {
            handleForPayError("SPIManager, pay error, not initialized", iPayCallback);
            return;
        }
        IPay iPay = this.mPay;
        if (iPay != null) {
            iPay.pay(str, str2, iPayCallback);
            return;
        }
        AclPayImpl aclPayImpl = this.aclPay;
        if (aclPayImpl != null) {
            aclPayImpl.pay(str, str2, aclAPIContext, iPayCallback);
        } else {
            handleForPayError("SPIManager, pay error, pay impl is null", iPayCallback);
        }
    }

    public void scan(ScannerOption scannerOption, AclAPIContext aclAPIContext, ScanCallback scanCallback) {
        if (!initialized()) {
            handleForScanError(ScanErrorCode.OPERATION_FAIL, "SPIManager, startScan error, not initialized", scanCallback);
            return;
        }
        OpenAbilityDelegate openAbilityDelegate = this.mOpenAbilityDelegate;
        if (openAbilityDelegate != null) {
            openAbilityDelegate.scan(scannerOption, scanCallback);
            return;
        }
        AclOpenAbilityImpl aclOpenAbilityImpl = this.aclOpenAbility;
        if (aclOpenAbilityImpl != null) {
            aclOpenAbilityImpl.scan(scannerOption, aclAPIContext, scanCallback);
        } else {
            handleForScanError(ScanErrorCode.OPERATION_FAIL, "SPIManager, startScan error, open ability delegate is not implemented", scanCallback);
        }
    }

    public void showAuthPage(AuthPageRequest authPageRequest, AclAPIContext aclAPIContext, AcCallback<AuthPageResult> acCallback) {
        ACLog.i(Constants.TAG, "SPIManager, showAuthPage enter");
        if (!initialized()) {
            handleForGetAuthPageError("SPIManager, getAuthPage error, not initialized", acCallback);
            return;
        }
        IOAuth iOAuth = this.mOAuth;
        if (iOAuth != null) {
            iOAuth.showAuthPage(authPageRequest, acCallback);
            return;
        }
        AclOAuthImpl aclOAuthImpl = this.aclOAuth;
        if (aclOAuthImpl != null) {
            aclOAuthImpl.showAuthPage(authPageRequest, aclAPIContext, acCallback);
        } else {
            handleForGetAuthPageError("SPIManager, getAuthPage error, oAuth impl is null", acCallback);
        }
    }

    public void getAuthCode(String str, IAuthCallback iAuthCallback) {
        getAuthCode(str, APIContextFactory.createACAPIContext(), iAuthCallback);
    }

    public void getAuthCode(String str, AclAPIContext aclAPIContext, IAuthCallback iAuthCallback) {
        ACLog.i(Constants.TAG, "SPIManager, getAuthCode for authorize with authUrl enter");
        if (!initialized()) {
            handleForGetAuthCodeError("SPIManager, getAuthCode for authorize error, not initialized", iAuthCallback);
            return;
        }
        IOAuth iOAuth = this.mOAuth;
        if (iOAuth != null) {
            iOAuth.getAuthCode(str, iAuthCallback);
            return;
        }
        AclOAuthImpl aclOAuthImpl = this.aclOAuth;
        if (aclOAuthImpl != null) {
            aclOAuthImpl.getAuthCode(str, aclAPIContext, iAuthCallback);
        } else {
            handleForGetAuthCodeError("SPIManager, getAuthCode for authorize error, oAuth impl is null", iAuthCallback);
        }
    }

    public void getAuthCode(AuthRequest authRequest, IAuthCallback iAuthCallback) {
        getAuthCode(authRequest, APIContextFactory.createACAPIContext(), iAuthCallback);
    }

    public void getAuthCode(AuthRequest authRequest, AclAPIContext aclAPIContext, IAuthCallback iAuthCallback) {
        ACLog.i(Constants.TAG, "SPIManager, getAuthCode for authorize with AuthRequest enter");
        if (!initialized()) {
            handleForGetAuthCodeError("SPIManager, getAuthCode for authorize with AuthRequest error, not initialized", iAuthCallback);
            return;
        }
        IOAuth iOAuth = this.mOAuth;
        if (iOAuth != null) {
            iOAuth.getAuthCode(authRequest, iAuthCallback);
            return;
        }
        AclOAuthImpl aclOAuthImpl = this.aclOAuth;
        if (aclOAuthImpl != null) {
            aclOAuthImpl.getAuthCode(authRequest, aclAPIContext, iAuthCallback);
        } else {
            handleForGetAuthCodeError("SPIManager, getAuthCode for authorize with AuthRequest error, oAuth impl is null", iAuthCallback);
        }
    }
}
