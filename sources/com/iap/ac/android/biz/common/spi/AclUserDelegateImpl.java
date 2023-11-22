package com.iap.ac.android.biz.common.spi;

import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.member.MemberInfo;
import com.alipay.iap.android.wallet.acl.member.MemberInfoResult;
import com.alipay.iap.android.wallet.acl.member.MemberInfoScope;
import com.alipay.iap.android.wallet.acl.member.MemberService;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.model.OAuthUserInfo;
import com.iap.ac.android.biz.common.model.OpenUserInfo;
import com.iap.ac.android.biz.common.model.OpenUserInfoCallback;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class AclUserDelegateImpl extends AclBaseImpl {
    public String mOpenId;
    public MemberService mUserDelegate;

    public AclUserDelegateImpl() {
        if (isAclAvailable()) {
            this.mUserDelegate = (MemberService) getAclService(MemberService.class);
        }
    }

    public String getOpenId(AclAPIContext aclAPIContext) {
        this.mOpenId = null;
        if (this.mUserDelegate != null) {
            this.mUserDelegate.getMemberInfo(MemberService.MemberInfoFetchStrategy.LOCAL_USER_ID_ONLY, null, APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<MemberInfoResult>() { // from class: com.iap.ac.android.biz.common.spi.AclUserDelegateImpl.1
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(MemberInfoResult memberInfoResult) {
                    MemberInfo memberInfo;
                    if (memberInfoResult != null && (memberInfo = memberInfoResult.memberInfo) != null) {
                        AclUserDelegateImpl.this.mOpenId = memberInfo.userId;
                        return;
                    }
                    AclUserDelegateImpl aclUserDelegateImpl = AclUserDelegateImpl.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ACL getMemberInfo for userId error, result:");
                    sb.append(memberInfoResult);
                    aclUserDelegateImpl.handleForAclCallError("getOpenId", sb.toString());
                }
            });
        } else {
            StringBuilder a2 = a.a("implementation of ACL cannot be found, isAclAvailable: ");
            a2.append(isAclAvailable());
            handleForAclCallError("getOpenId", a2.toString());
        }
        return this.mOpenId;
    }

    public void getOpenUserInfo(OAuthUserInfo oAuthUserInfo, AclAPIContext aclAPIContext, final OpenUserInfoCallback openUserInfoCallback) {
        if (this.mUserDelegate != null) {
            MemberService.MemberInfoFetchStrategy memberInfoFetchStrategy = MemberService.MemberInfoFetchStrategy.REMOTE_FETCH;
            HashSet hashSet = new HashSet();
            List<String> list = oAuthUserInfo.scopes;
            if (list != null && list.size() > 0) {
                hashSet.addAll(oAuthUserInfo.scopes);
            }
            this.mUserDelegate.getMemberInfo(memberInfoFetchStrategy, new MemberInfoScope(oAuthUserInfo.appId, hashSet, null), APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<MemberInfoResult>() { // from class: com.iap.ac.android.biz.common.spi.AclUserDelegateImpl.2
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(MemberInfoResult memberInfoResult) {
                    MemberInfo memberInfo;
                    OpenUserInfo openUserInfo = new OpenUserInfo();
                    if (memberInfoResult != null && (memberInfo = memberInfoResult.memberInfo) != null) {
                        openUserInfo.avatar = memberInfo.avatar;
                        Map<String, String> map = memberInfo.extendedInfo;
                        if (map != null) {
                            openUserInfo.city = map.get("city");
                            openUserInfo.countryCode = memberInfoResult.memberInfo.extendedInfo.get(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
                            openUserInfo.province = memberInfoResult.memberInfo.extendedInfo.get("province");
                            openUserInfo.nickName = memberInfoResult.memberInfo.extendedInfo.get("nickName");
                        }
                        MemberInfo memberInfo2 = memberInfoResult.memberInfo;
                        openUserInfo.gender = memberInfo2.gender;
                        openUserInfo.loginId = memberInfo2.loginId;
                        openUserInfo.userId = memberInfo2.userId;
                        openUserInfo.userName = memberInfo2.userName;
                    } else {
                        AclUserDelegateImpl aclUserDelegateImpl = AclUserDelegateImpl.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ACL getMemberInfo error, result:");
                        sb.append(memberInfoResult);
                        aclUserDelegateImpl.handleForAclCallError(Constants.JS_API_GET_OPEN_USER_INFO, sb.toString());
                    }
                    OpenUserInfoCallback openUserInfoCallback2 = openUserInfoCallback;
                    if (openUserInfoCallback2 != null) {
                        openUserInfoCallback2.onGetOpenUserInfo(openUserInfo);
                    }
                }
            });
            return;
        }
        StringBuilder a2 = a.a("implementation of ACL cannot be found, isAclAvailable: ");
        a2.append(isAclAvailable());
        handleForAclCallError(Constants.JS_API_GET_OPEN_USER_INFO, a2.toString());
    }
}
