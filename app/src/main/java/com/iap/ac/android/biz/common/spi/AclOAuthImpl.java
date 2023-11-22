package com.iap.ac.android.biz.common.spi;

import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.oauth.OAuthCodeFlowType;
import com.alipay.iap.android.wallet.acl.oauth.OAuthPageConfirmResult;
import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.model.auth.AuthPageRequest;
import com.iap.ac.android.biz.common.model.auth.AuthPageResult;
import com.iap.ac.android.biz.common.model.auth.AuthRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class AclOAuthImpl extends AclBaseImpl {
    public static final String KEY_AUTH_CLIENT_ID = "authClientId";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    public OAuthService mOAuthService;

    public AclOAuthImpl() {
        if (isAclAvailable()) {
            this.mOAuthService = (OAuthService) getAclService(OAuthService.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void extractAuthPageResultFromAcl(AuthPageResult authPageResult, OAuthPageConfirmResult oAuthPageConfirmResult) {
        authPageResult.success = !oAuthPageConfirmResult.isHasError();
        authPageResult.referenceAgreementId = oAuthPageConfirmResult.getReferenceAgreementId();
        Map<String, String> extendedInfo = oAuthPageConfirmResult.getExtendedInfo();
        if (oAuthPageConfirmResult.isHasError()) {
            if (extendedInfo != null && extendedInfo.size() > 0) {
                authPageResult.errorCode = extendedInfo.get("errorCode");
                authPageResult.errorMessage = extendedInfo.get("errorMessage");
                return;
            }
            authPageResult.errorCode = String.valueOf(oAuthPageConfirmResult.getResultError().errorCode);
            authPageResult.errorMessage = oAuthPageConfirmResult.getResultError().errorDesc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void extractAuthResultFromAcl(AuthResult authResult, OAuthResult oAuthResult) {
        authResult.authCode = oAuthResult.getAuthCode();
        authResult.authState = oAuthResult.getAuthState();
        authResult.authSuccessScopes = oAuthResult.getAuthSuccessScopes() == null ? null : Arrays.asList(oAuthResult.getAuthSuccessScopes());
        authResult.authErrorScopes = oAuthResult.getAuthErrorScopes();
        authResult.authRedirectUrl = oAuthResult.getAuthRedirectUrl();
        Map<String, String> extendedInfo = oAuthResult.getExtendedInfo();
        if (oAuthResult.isHasError()) {
            if (extendedInfo != null && extendedInfo.size() > 0) {
                authResult.errorCode = extendedInfo.get("errorCode");
                authResult.errorMessage = extendedInfo.get("errorMessage");
                return;
            }
            authResult.errorCode = String.valueOf(oAuthResult.getResultError().errorCode);
            authResult.errorMessage = oAuthResult.getResultError().errorDesc;
        }
    }

    public void getAuthCode(String str, String str2, List<String> list, AclAPIContext aclAPIContext, final IAuthCallback iAuthCallback) {
        if (this.mOAuthService != null) {
            HashSet hashSet = new HashSet();
            if (list != null && list.size() > 0) {
                hashSet.addAll(list);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authClientId", str2);
            this.mOAuthService.getAuthCode(str, hashSet, OAuthCodeFlowType.ALIPAY_CONNECT, hashMap, APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<OAuthResult>() { // from class: com.iap.ac.android.biz.common.spi.AclOAuthImpl.1
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(OAuthResult oAuthResult) {
                    AuthResult authResult = new AuthResult();
                    if (oAuthResult != null) {
                        AclOAuthImpl.this.extractAuthResultFromAcl(authResult, oAuthResult);
                    } else {
                        AclOAuthImpl.this.handleForAclCallError(Constants.JS_API_GET_AUTH_CODE, "ACL getAuthCode error, result is null");
                    }
                    IAuthCallback iAuthCallback2 = iAuthCallback;
                    if (iAuthCallback2 != null) {
                        iAuthCallback2.onResult(authResult);
                    }
                }
            });
            return;
        }
        StringBuilder a2 = a.a("No implementation found for getAuthCode, isAclAvailable: ");
        a2.append(isAclAvailable());
        handleForAclCallError(Constants.JS_API_GET_AUTH_CODE, a2.toString());
    }

    public void showAuthPage(AuthPageRequest authPageRequest, AclAPIContext aclAPIContext, final AcCallback<AuthPageResult> acCallback) {
        if (this.mOAuthService != null) {
            HashSet hashSet = new HashSet();
            Set<String> set = authPageRequest.scopes;
            if (set != null && set.size() > 0) {
                hashSet.addAll(authPageRequest.scopes);
            }
            HashMap hashMap = new HashMap();
            String str = authPageRequest.passThroughInfo;
            if (str != null) {
                hashMap.put(AclConstants.PASS_THROUGH_INFO, str);
            }
            this.mOAuthService.showAuthPage(authPageRequest.clientId, authPageRequest.authClientName, authPageRequest.authClientLogo, hashSet, hashMap, APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<OAuthPageConfirmResult>() { // from class: com.iap.ac.android.biz.common.spi.AclOAuthImpl.4
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(OAuthPageConfirmResult oAuthPageConfirmResult) {
                    AuthPageResult authPageResult = new AuthPageResult();
                    if (oAuthPageConfirmResult != null) {
                        AclOAuthImpl.this.extractAuthPageResultFromAcl(authPageResult, oAuthPageConfirmResult);
                    } else {
                        AclOAuthImpl.this.handleForAclCallError(Constants.JS_API_GET_AUTH_CODE, "ACL showAuthPage for agree payment error, result is null");
                    }
                    AcCallback acCallback2 = acCallback;
                    if (acCallback2 != null) {
                        acCallback2.onResult(authPageResult);
                    }
                }
            });
            return;
        }
        StringBuilder a2 = a.a("No implementation found for showAuthPage, isAclAvailable: ");
        a2.append(isAclAvailable());
        handleForAclCallError(Constants.JS_API_GET_AUTH_CODE, a2.toString());
    }

    public void getAuthCode(String str, AclAPIContext aclAPIContext, final IAuthCallback iAuthCallback) {
        if (this.mOAuthService != null) {
            this.mOAuthService.getAuthCode(str, OAuthCodeFlowType.ALIPAY_CONNECT, new HashMap(), APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<OAuthResult>() { // from class: com.iap.ac.android.biz.common.spi.AclOAuthImpl.2
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(OAuthResult oAuthResult) {
                    AuthResult authResult = new AuthResult();
                    if (oAuthResult != null) {
                        AclOAuthImpl.this.extractAuthResultFromAcl(authResult, oAuthResult);
                    } else {
                        AclOAuthImpl.this.handleForAclCallError(Constants.JS_API_GET_AUTH_CODE, "ACL getAuthCode for agree payment error, result is null");
                    }
                    IAuthCallback iAuthCallback2 = iAuthCallback;
                    if (iAuthCallback2 != null) {
                        iAuthCallback2.onResult(authResult);
                    }
                }
            });
            return;
        }
        StringBuilder a2 = a.a("No implementation found for getAuthCode, isAclAvailable: ");
        a2.append(isAclAvailable());
        handleForAclCallError(Constants.JS_API_GET_AUTH_CODE, a2.toString());
    }

    public void getAuthCode(AuthRequest authRequest, AclAPIContext aclAPIContext, final IAuthCallback iAuthCallback) {
        if (this.mOAuthService != null) {
            HashSet hashSet = new HashSet();
            Set<String> set = authRequest.scopes;
            if (set != null && set.size() > 0) {
                hashSet.addAll(authRequest.scopes);
            }
            HashMap hashMap = new HashMap();
            String str = authRequest.acquirerId;
            if (str != null) {
                hashMap.put("acquirerId", str);
            }
            hashMap.put("authClientId", authRequest.authClientId);
            String str2 = authRequest.authRedirectUrl;
            if (str2 != null) {
                hashMap.put(AclConstants.AUTH_REDIRECT_URL, str2);
            }
            String str3 = authRequest.referenceAgreementId;
            if (str3 != null) {
                hashMap.put("referenceAgreementId", str3);
            }
            this.mOAuthService.getAuthCode(authRequest.clientId, hashSet, OAuthCodeFlowType.ALIPAY_CONNECT, hashMap, APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<OAuthResult>() { // from class: com.iap.ac.android.biz.common.spi.AclOAuthImpl.3
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(OAuthResult oAuthResult) {
                    AuthResult authResult = new AuthResult();
                    if (oAuthResult != null) {
                        AclOAuthImpl.this.extractAuthResultFromAcl(authResult, oAuthResult);
                    } else {
                        AclOAuthImpl.this.handleForAclCallError(Constants.JS_API_GET_AUTH_CODE, "ACL getAuthCode for agree payment error, result is null");
                    }
                    IAuthCallback iAuthCallback2 = iAuthCallback;
                    if (iAuthCallback2 != null) {
                        iAuthCallback2.onResult(authResult);
                    }
                }
            });
            return;
        }
        StringBuilder a2 = a.a("No implementation found for getAuthCode, isAclAvailable: ");
        a2.append(isAclAvailable());
        handleForAclCallError(Constants.JS_API_GET_AUTH_CODE, a2.toString());
    }
}
