package id.dana.data.login.source;

import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;
import id.dana.data.BaseMapper;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import id.dana.domain.model.rpc.LoginInfo;
import id.dana.domain.model.rpc.UserInfo;
import id.dana.domain.model.rpc.response.EvUrlStatus;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.network.response.login.EvUrlStatusResult;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.network.response.login.RpcLoginInfo;
import id.dana.network.response.login.RpcUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\u000bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0005\u0010\u000fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0005\u0010\u0013J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0005\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u0018J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00150\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0019¢\u0006\u0004\b\u0005\u0010\u001b"}, d2 = {"Lid/dana/data/login/source/LoginMapper;", "", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "from", "Lcom/iap/ac/android/rpccommon/model/facade/MobileEnvInfo;", "transform", "(Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;)Lcom/iap/ac/android/rpccommon/model/facade/MobileEnvInfo;", "Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "", "userId", "Lid/dana/network/response/login/RpcUserInfo;", "(Lid/dana/data/user/source/network/result/UserInfoRpcResult;Ljava/lang/String;)Lid/dana/network/response/login/RpcUserInfo;", "Lid/dana/network/response/login/EvUrlStatusResult;", "evUrlStatusResult", "Lid/dana/domain/model/rpc/response/EvUrlStatus;", "(Lid/dana/network/response/login/EvUrlStatusResult;)Lid/dana/domain/model/rpc/response/EvUrlStatus;", "Lid/dana/network/response/login/LoginRpcResult;", "result", "Lid/dana/domain/model/rpc/response/LoginResponse;", "(Lid/dana/network/response/login/LoginRpcResult;)Lid/dana/domain/model/rpc/response/LoginResponse;", "Lid/dana/network/response/login/RpcLoginInfo;", "Lid/dana/domain/model/rpc/LoginInfo;", "(Lid/dana/network/response/login/RpcLoginInfo;)Lid/dana/domain/model/rpc/LoginInfo;", "Lid/dana/domain/model/rpc/UserInfo;", "(Lid/dana/network/response/login/RpcUserInfo;)Lid/dana/domain/model/rpc/UserInfo;", "", "froms", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoginMapper {
    @Inject
    public LoginMapper() {
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [java.lang.String, java.lang.Integer] */
    public final LoginResponse transform(LoginRpcResult result) {
        if (result != null) {
            ?? r16 = 0;
            LoginResponse loginResponse = new LoginResponse(null, null, null, null, null, null, null, null, 0, null, null, r16, r16, null, null, null, 65535, null);
            loginResponse.setVerificationMethods(result.verificationMethods);
            loginResponse.setLockedExpireSeconds(Integer.valueOf(result.lockedExpireSeconds));
            loginResponse.setMaxFailedCount(Integer.valueOf(result.maxFailedCount));
            loginResponse.setFailedCount(result.failedCount);
            loginResponse.setLeftTimes(Integer.valueOf(result.leftTimes));
            loginResponse.setSecurityId(result.securityId);
            loginResponse.setPin(result.pin);
            loginResponse.setKey(result.key);
            loginResponse.setUserInfo(transform(result.userInfo));
            loginResponse.setEvUrlStatus(transform(result.getEvUrlStatusResult()));
            RpcUserInfo rpcUserInfo = result.userInfo;
            loginResponse.setKycLevel(rpcUserInfo != null ? rpcUserInfo.kycLevel : null);
            BaseMapper.transform(loginResponse, result);
            return loginResponse;
        }
        return null;
    }

    public final EvUrlStatus transform(EvUrlStatusResult evUrlStatusResult) {
        if (evUrlStatusResult != null) {
            return new EvUrlStatus(evUrlStatusResult.getCallTime(), evUrlStatusResult.getCalled(), evUrlStatusResult.getComplete());
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [java.util.List, java.lang.String] */
    public final UserInfo transform(RpcUserInfo from) {
        ?? r16 = 0;
        UserInfo userInfo = new UserInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, r16, r16, null, null, null, null, 524287, null);
        if (from != null) {
            userInfo.setAvatarUrl(from.avatarUrl);
            userInfo.setBirthday(from.birthday);
            userInfo.setCertified(Boolean.valueOf(from.certified));
            userInfo.setCertifiedLevel(from.certifiedLevel);
            userInfo.setEmails(from.emails);
            userInfo.setFirstName(from.firstName);
            userInfo.setGender(from.gender);
            userInfo.setJob(from.job);
            userInfo.setLanguage(from.language);
            userInfo.setLastName(from.lastName);
            userInfo.setMiddleName(from.middleName);
            userInfo.setMobileNos(from.mobileNos);
            userInfo.setNationality(from.nationality);
            userInfo.setNickname(from.nickname);
            userInfo.setUserId(from.userId);
            userInfo.setRegisteredTime(from.registeredTime);
            userInfo.setUserStatus(from.userStatus);
            userInfo.setLoginIdInfos(transform(from.loginIdInfos));
            userInfo.setKycLevel(from.kycLevel);
            return userInfo;
        }
        return userInfo;
    }

    public final RpcUserInfo transform(UserInfoRpcResult from, String userId) {
        RpcUserInfo rpcUserInfo = new RpcUserInfo();
        if (from != null) {
            rpcUserInfo.avatarUrl = from.getAvatarUrl();
            rpcUserInfo.nickname = from.getNickname();
            rpcUserInfo.userId = userId;
            rpcUserInfo.kycLevel = from.getKycLevel();
        }
        return rpcUserInfo;
    }

    public final LoginInfo transform(RpcLoginInfo from) {
        if (from != null) {
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setLoginId(from.loginId);
            loginInfo.setLoginIdType(from.loginIdType);
            return loginInfo;
        }
        return null;
    }

    public final List<LoginInfo> transform(List<RpcLoginInfo> froms) {
        ArrayList arrayList = new ArrayList();
        if (froms != null && froms.size() > 0) {
            Iterator<RpcLoginInfo> it = froms.iterator();
            while (it.hasNext()) {
                LoginInfo transform = transform(it.next());
                if (transform != null) {
                    arrayList.add(transform);
                }
            }
        }
        return arrayList;
    }

    public final MobileEnvInfo transform(com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo from) {
        Intrinsics.checkNotNullParameter(from, "");
        MobileEnvInfo mobileEnvInfo = new MobileEnvInfo();
        mobileEnvInfo.sourcePlatform = from.sourcePlatForm;
        mobileEnvInfo.tokenId = from.tokenId;
        mobileEnvInfo.umidToken = "";
        mobileEnvInfo.clientIp = from.clientIp;
        mobileEnvInfo.terminalType = from.terminalType;
        mobileEnvInfo.orderTerminalType = from.orderTerminalType;
        mobileEnvInfo.osType = from.osType;
        mobileEnvInfo.osVersion = from.osVersion;
        mobileEnvInfo.sdkVersion = from.sdkVersion;
        mobileEnvInfo.cashierSdkVersion = from.cashierSdkVersion;
        mobileEnvInfo.appVersion = from.appVersion;
        mobileEnvInfo.clientKey = from.clientKey;
        mobileEnvInfo.locale = from.locale;
        mobileEnvInfo.deliveryToken = from.deliveryToken;
        mobileEnvInfo.channel = from.channel;
        mobileEnvInfo.networkType = from.networkType;
        mobileEnvInfo.imei = from.imei;
        mobileEnvInfo.imsi = from.imsi;
        mobileEnvInfo.model = from.model;
        mobileEnvInfo.longitude = from.longitude;
        mobileEnvInfo.latitude = from.latitude;
        mobileEnvInfo.LBSType = from.LBSType;
        mobileEnvInfo.LBSUpdateTime = from.LBSUpdateTime;
        mobileEnvInfo.thirdChannelDeviceToken = from.thirdChannelDeviceToken;
        mobileEnvInfo.thirdChannel = from.thirdChannel;
        mobileEnvInfo.manufacturer = "";
        mobileEnvInfo.extendInfo = from.extendInfo;
        return mobileEnvInfo;
    }
}
