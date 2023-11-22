package id.dana.data.user.source.persistence.dao;

import id.dana.data.user.source.persistence.entity.UserInfoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\r\u0010\nJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0012"}, d2 = {"Lid/dana/data/user/source/persistence/dao/UserInfoDao;", "", "", "clearUserInfo", "()V", "Lid/dana/data/user/source/persistence/entity/UserInfoEntity;", "getLocalUserInfo", "()Lid/dana/data/user/source/persistence/entity/UserInfoEntity;", "", "getUserInfoFaceAuth", "()Ljava/util/List;", "getUserInfoFull", "getUserInfoKyc", "getUserInfoPan", "getUserInfoStatusInfo", "userInfo", "", "updateUserInfo", "(Lid/dana/data/user/source/persistence/entity/UserInfoEntity;)J", "userInfoEntity", "updateUserInfoFaceAuth", "updateUserInfoFull", "updateUserInfoPan", "updateUserInfoStatusInfo", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class UserInfoDao {
    public abstract void clearUserInfo();

    public abstract List<UserInfoEntity> getUserInfoFaceAuth();

    public abstract List<UserInfoEntity> getUserInfoFull();

    public abstract List<UserInfoEntity> getUserInfoKyc();

    public abstract List<UserInfoEntity> getUserInfoPan();

    public abstract List<UserInfoEntity> getUserInfoStatusInfo();

    public abstract long updateUserInfo(UserInfoEntity userInfo);

    public long updateUserInfoFull(UserInfoEntity userInfoEntity) {
        Intrinsics.checkNotNullParameter(userInfoEntity, "");
        UserInfoEntity localUserInfo = getLocalUserInfo();
        localUserInfo.setAccountStatus(userInfoEntity.getAccountStatus());
        localUserInfo.setAvatarUrl(userInfoEntity.getAvatarUrl());
        localUserInfo.setBalance(userInfoEntity.getBalance());
        localUserInfo.setEnrollStatus(userInfoEntity.getEnrollStatus());
        localUserInfo.setFaceAuthStatus(userInfoEntity.getFaceAuthStatus());
        localUserInfo.setFaceLoginReady(userInfoEntity.getFaceLoginReady());
        localUserInfo.setKtpName(userInfoEntity.getKtpName());
        localUserInfo.setKybInfo(userInfoEntity.getKybInfo());
        localUserInfo.setKycCertified(userInfoEntity.getKycCertified());
        localUserInfo.setKycLevel(userInfoEntity.getKycLevel());
        localUserInfo.setLoginId(userInfoEntity.getLoginId());
        localUserInfo.setLoginStatus(userInfoEntity.getLoginStatus());
        localUserInfo.setNickname(userInfoEntity.getNickname());
        localUserInfo.setPendingTransaction(userInfoEntity.getPendingTransaction());
        localUserInfo.setUsername(userInfoEntity.getUsername());
        return updateUserInfo(localUserInfo);
    }

    public long updateUserInfoPan(UserInfoEntity userInfoEntity) {
        Intrinsics.checkNotNullParameter(userInfoEntity, "");
        UserInfoEntity localUserInfo = getLocalUserInfo();
        localUserInfo.setEnrollStatus(userInfoEntity.getEnrollStatus());
        localUserInfo.setFaceAuthStatus(userInfoEntity.getFaceAuthStatus());
        localUserInfo.setFaceLoginReady(userInfoEntity.getFaceLoginReady());
        localUserInfo.setKycCertified(userInfoEntity.getKycCertified());
        localUserInfo.setNcc(userInfoEntity.getNcc());
        localUserInfo.setPendingTransaction(userInfoEntity.getPendingTransaction());
        localUserInfo.setShortcode(userInfoEntity.getShortcode());
        return updateUserInfo(localUserInfo);
    }

    public long updateUserInfoStatusInfo(UserInfoEntity userInfoEntity) {
        Intrinsics.checkNotNullParameter(userInfoEntity, "");
        UserInfoEntity localUserInfo = getLocalUserInfo();
        localUserInfo.setAccountStatus(userInfoEntity.getAccountStatus());
        localUserInfo.setEnrollStatus(userInfoEntity.getEnrollStatus());
        localUserInfo.setFaceAuthStatus(userInfoEntity.getFaceAuthStatus());
        localUserInfo.setFaceLoginReady(userInfoEntity.getFaceLoginReady());
        localUserInfo.setKycCertified(userInfoEntity.getKycCertified());
        localUserInfo.setLoginStatus(userInfoEntity.getLoginStatus());
        localUserInfo.setPendingTransaction(userInfoEntity.getPendingTransaction());
        localUserInfo.setUserStatus(userInfoEntity.getUserStatus());
        return updateUserInfo(localUserInfo);
    }

    public long updateUserInfoFaceAuth(UserInfoEntity userInfoEntity) {
        Intrinsics.checkNotNullParameter(userInfoEntity, "");
        UserInfoEntity localUserInfo = getLocalUserInfo();
        localUserInfo.setEnrollStatus(userInfoEntity.getEnrollStatus());
        localUserInfo.setFaceAuthStatus(userInfoEntity.getFaceAuthStatus());
        localUserInfo.setFaceLoginReady(userInfoEntity.getFaceLoginReady());
        localUserInfo.setKtpName(userInfoEntity.getKtpName());
        localUserInfo.setKybInfo(userInfoEntity.getKybInfo());
        localUserInfo.setKycCertified(userInfoEntity.getKycCertified());
        localUserInfo.setPendingTransaction(userInfoEntity.getPendingTransaction());
        return updateUserInfo(localUserInfo);
    }

    private final UserInfoEntity getLocalUserInfo() {
        List<UserInfoEntity> userInfoKyc = getUserInfoKyc();
        if (userInfoKyc.isEmpty()) {
            return new UserInfoEntity("", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097150, null);
        }
        return (UserInfoEntity) CollectionsKt.first((List) userInfoKyc);
    }
}
