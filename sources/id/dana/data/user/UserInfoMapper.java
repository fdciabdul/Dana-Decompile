package id.dana.data.user;

import id.dana.data.account.AccountEntity;
import id.dana.data.homeinfo.model.KybEntity;
import id.dana.data.homeinfo.model.KycEntity;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.sendmoney.mapper.CurrencyAmountResultMapper;
import id.dana.data.storage.Serializer;
import id.dana.data.user.source.network.result.MiniProgramUserInfoResult;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import id.dana.data.user.source.persistence.entity.UserInfoEntity;
import id.dana.domain.homeinfo.KybResponse;
import id.dana.domain.homeinfo.KycResponse;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.MiniProgramUserInfoResponse;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.wallet_v3.model.CardAssetType;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.domain.wallet_v3.model.UserAssetsModel;
import id.dana.domain.wallet_v3.model.UserAssetsWrapperModel;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b)\u0010*J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\b\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\b\u0010\rJ#\u0010\b\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\b\u0010\u0012J\u0015\u0010\b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\b\u0010\u0016J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\u0019J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u0004\u0018\u00010\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010("}, d2 = {"Lid/dana/data/user/UserInfoMapper;", "", "Lid/dana/data/account/AccountEntity;", "accountEntity", "Lid/dana/domain/wallet_v3/model/UserAssetsWrapperModel;", "toUserAssetsWrapperModel", "(Lid/dana/data/account/AccountEntity;)Lid/dana/domain/wallet_v3/model/UserAssetsWrapperModel;", "Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "transform", "(Lid/dana/data/account/AccountEntity;)Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "Lid/dana/data/homeinfo/model/KybEntity;", "entity", "Lid/dana/domain/homeinfo/KybResponse;", "(Lid/dana/data/homeinfo/model/KybEntity;)Lid/dana/domain/homeinfo/KybResponse;", "Lid/dana/data/homeinfo/model/KycEntity;", "", "defaultKycInfo", "Lid/dana/domain/homeinfo/KycResponse;", "(Lid/dana/data/homeinfo/model/KycEntity;Ljava/lang/String;)Lid/dana/domain/homeinfo/KycResponse;", "Lid/dana/data/user/source/network/result/MiniProgramUserInfoResult;", "userInfo", "Lid/dana/domain/user/MiniProgramUserInfoResponse;", "(Lid/dana/data/user/source/network/result/MiniProgramUserInfoResult;)Lid/dana/domain/user/MiniProgramUserInfoResponse;", "userInfoRpcResult", "Lid/dana/domain/user/UserInfoResponse;", "(Lid/dana/data/user/source/network/result/UserInfoRpcResult;)Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/data/user/source/persistence/entity/UserInfoEntity;", "userInfoEntity", "(Lid/dana/data/user/source/persistence/entity/UserInfoEntity;)Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "userId", "transformToUserInfoEntity", "(Lid/dana/data/user/source/network/result/UserInfoRpcResult;Ljava/lang/String;)Lid/dana/data/user/source/persistence/entity/UserInfoEntity;", "accountInfo", "transformToUserInfoResponse", "(Lid/dana/data/account/AccountEntity;)Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/data/sendmoney/mapper/CurrencyAmountResultMapper;", "currencyAmountResultMapper", "Lid/dana/data/sendmoney/mapper/CurrencyAmountResultMapper;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "<init>", "(Lid/dana/data/sendmoney/mapper/CurrencyAmountResultMapper;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserInfoMapper {
    private final CurrencyAmountResultMapper currencyAmountResultMapper;
    private final Serializer serializer;

    @Inject
    public UserInfoMapper(CurrencyAmountResultMapper currencyAmountResultMapper, Serializer serializer) {
        Intrinsics.checkNotNullParameter(currencyAmountResultMapper, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.currencyAmountResultMapper = currencyAmountResultMapper;
        this.serializer = serializer;
    }

    public final UserInfoResponse transform(UserInfoRpcResult userInfoRpcResult) {
        if (userInfoRpcResult != null) {
            CurrencyAmount apply = this.currencyAmountResultMapper.apply(userInfoRpcResult.getBalance());
            String ktpName = userInfoRpcResult.getKtpName();
            String ktpId = userInfoRpcResult.getKtpId();
            String kycLevel = userInfoRpcResult.getKycLevel();
            KycResponse transform = transform(userInfoRpcResult.getKyc(), userInfoRpcResult.getKycLevel());
            KybResponse transform2 = transform(userInfoRpcResult.getKybInfo());
            String loginId = userInfoRpcResult.getLoginId();
            String str = loginId == null ? "" : loginId;
            String nickname = userInfoRpcResult.getNickname();
            String str2 = nickname == null ? "" : nickname;
            String pendingTransaction = userInfoRpcResult.getPendingTransaction();
            boolean kycCertified = userInfoRpcResult.getKycCertified();
            String userPan = userInfoRpcResult.getUserPan();
            boolean faceAuthStatus = userInfoRpcResult.getFaceAuthStatus();
            boolean enrollStatus = userInfoRpcResult.getEnrollStatus();
            boolean faceLoginReady = userInfoRpcResult.getFaceLoginReady();
            String accountStatus = userInfoRpcResult.getAccountStatus();
            String loginStatus = userInfoRpcResult.getLoginStatus();
            String userStatus = userInfoRpcResult.getUserStatus();
            String username = userInfoRpcResult.getUsername();
            String str3 = username == null ? "" : username;
            String avatarUrl = userInfoRpcResult.getAvatarUrl();
            return new UserInfoResponse(apply, ktpName, ktpId, transform2, kycCertified, kycLevel, str, str2, pendingTransaction, userPan, transform, faceAuthStatus, enrollStatus, faceLoginReady, accountStatus, loginStatus, userStatus, str3, avatarUrl == null ? "" : avatarUrl);
        }
        return null;
    }

    public final MiniProgramUserInfoResponse transform(MiniProgramUserInfoResult userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "");
        return new MiniProgramUserInfoResponse(userInfo.getUserInfo());
    }

    private final KycResponse transform(KycEntity entity, String defaultKycInfo) {
        String str;
        KycResponse kycResponse = new KycResponse();
        if (entity != null && (str = entity.level) != null) {
            defaultKycInfo = str;
        }
        kycResponse.setLevel(defaultKycInfo);
        kycResponse.setOrderStatus(entity != null ? entity.orderStatus : null);
        kycResponse.setGovFlag(entity != null ? entity.govFlag : false);
        kycResponse.setTncUrl(entity != null ? entity.tncUrl : null);
        kycResponse.setUserQuits(entity != null ? entity.userQuits : false);
        return kycResponse;
    }

    private final KybResponse transform(KybEntity entity) {
        if (entity != null) {
            KybResponse kybResponse = new KybResponse();
            kybResponse.setOrderStatus(entity.orderStatus);
            kybResponse.setKybLevel(entity.kybLevel);
            kybResponse.setFailedReason(entity.failedReason);
            kybResponse.setCertificateTier(entity.certificateTier);
            kybResponse.setEnableCertificateTier(entity.enableCertificateTier);
            return kybResponse;
        }
        return null;
    }

    public final UserInfoResponse transformToUserInfoResponse(AccountEntity accountInfo) {
        if (accountInfo != null) {
            String str = null;
            UserInfoResponse userInfoResponse = new UserInfoResponse(null, null, null, null, false, null, null, null, null, null, null, false, false, false, str, str, null, null, null, 524287, null);
            userInfoResponse.setBalance(this.currencyAmountResultMapper.apply(accountInfo.getBalance()));
            String nickname = accountInfo.getNickname();
            Intrinsics.checkNotNullExpressionValue(nickname, "");
            userInfoResponse.setNickname(nickname);
            userInfoResponse.setUserPan(accountInfo.getUserPan());
            return userInfoResponse;
        }
        return null;
    }

    public final UserInfoRpcResult transform(AccountEntity accountEntity) {
        if (accountEntity != null) {
            String str = null;
            UserInfoRpcResult userInfoRpcResult = new UserInfoRpcResult(null, null, null, null, null, null, null, false, null, null, null, null, null, null, str, str, false, false, false, null, 1048575, null);
            userInfoRpcResult.success = true;
            userInfoRpcResult.setBalance(accountEntity.getBalance());
            userInfoRpcResult.setLoginId(accountEntity.getPhoneMask());
            userInfoRpcResult.setNickname(accountEntity.getNickname());
            userInfoRpcResult.setUsername(accountEntity.getUsername());
            return userInfoRpcResult;
        }
        return null;
    }

    public final UserInfoEntity transformToUserInfoEntity(UserInfoRpcResult userInfoRpcResult, String userId) {
        Intrinsics.checkNotNullParameter(userInfoRpcResult, "");
        Intrinsics.checkNotNullParameter(userId, "");
        String serialize = this.serializer.serialize(userInfoRpcResult.getBalance());
        String serialize2 = this.serializer.serialize(userInfoRpcResult.getKybInfo());
        String serialize3 = this.serializer.serialize(userInfoRpcResult.getKyc());
        String accountStatus = userInfoRpcResult.getAccountStatus();
        String avatarUrl = userInfoRpcResult.getAvatarUrl();
        String ktpName = userInfoRpcResult.getKtpName();
        boolean kycCertified = userInfoRpcResult.getKycCertified();
        String kycLevel = userInfoRpcResult.getKycLevel();
        String loginStatus = userInfoRpcResult.getLoginStatus();
        String userStatus = userInfoRpcResult.getUserStatus();
        String ncc = userInfoRpcResult.getNcc();
        String loginId = userInfoRpcResult.getLoginId();
        String nickname = userInfoRpcResult.getNickname();
        String pendingTransaction = userInfoRpcResult.getPendingTransaction();
        String shortcode = userInfoRpcResult.getShortcode();
        boolean faceAuthStatus = userInfoRpcResult.getFaceAuthStatus();
        boolean enrollStatus = userInfoRpcResult.getEnrollStatus();
        boolean faceLoginReady = userInfoRpcResult.getFaceLoginReady();
        return new UserInfoEntity(userId, accountStatus, avatarUrl, serialize, ktpName, serialize2, serialize3, Boolean.valueOf(kycCertified), kycLevel, loginStatus, userStatus, ncc, loginId, nickname, pendingTransaction, shortcode, Boolean.valueOf(faceAuthStatus), Boolean.valueOf(enrollStatus), Boolean.valueOf(faceLoginReady), userInfoRpcResult.getUsername(), userInfoRpcResult.getUserPan());
    }

    public final UserInfoRpcResult transform(UserInfoEntity userInfoEntity) {
        Intrinsics.checkNotNullParameter(userInfoEntity, "");
        CurrencyAmountResult currencyAmountResult = (CurrencyAmountResult) this.serializer.deserialize(userInfoEntity.getBalance(), CurrencyAmountResult.class);
        KybEntity kybEntity = (KybEntity) this.serializer.deserialize(userInfoEntity.getKybInfo(), KybEntity.class);
        KycEntity kycEntity = (KycEntity) this.serializer.deserialize(userInfoEntity.getKyc(), KycEntity.class);
        String accountStatus = userInfoEntity.getAccountStatus();
        String avatarUrl = userInfoEntity.getAvatarUrl();
        String ktpName = userInfoEntity.getKtpName();
        Boolean kycCertified = userInfoEntity.getKycCertified();
        boolean booleanValue = kycCertified != null ? kycCertified.booleanValue() : false;
        String kycLevel = userInfoEntity.getKycLevel();
        String loginStatus = userInfoEntity.getLoginStatus();
        String userStatus = userInfoEntity.getUserStatus();
        String ncc = userInfoEntity.getNcc();
        String loginId = userInfoEntity.getLoginId();
        String nickname = userInfoEntity.getNickname();
        String pendingTransaction = userInfoEntity.getPendingTransaction();
        String shortcode = userInfoEntity.getShortcode();
        Boolean faceAuthStatus = userInfoEntity.getFaceAuthStatus();
        boolean booleanValue2 = faceAuthStatus != null ? faceAuthStatus.booleanValue() : false;
        Boolean enrollStatus = userInfoEntity.getEnrollStatus();
        boolean booleanValue3 = enrollStatus != null ? enrollStatus.booleanValue() : false;
        Boolean faceLoginReady = userInfoEntity.getFaceLoginReady();
        return new UserInfoRpcResult(accountStatus, avatarUrl, currencyAmountResult, ktpName, null, kybEntity, kycEntity, booleanValue, kycLevel, loginStatus, userStatus, ncc, loginId, nickname, pendingTransaction, shortcode, booleanValue2, booleanValue3, faceLoginReady != null ? faceLoginReady.booleanValue() : false, userInfoEntity.getUsername(), 16, null);
    }

    public final UserAssetsWrapperModel toUserAssetsWrapperModel(AccountEntity accountEntity) {
        if (accountEntity != null) {
            return new UserAssetsWrapperModel(null, null, MapsKt.emptyMap(), CollectionsKt.listOf(new UserAssetInfosModel("PAYMENT", CardAssetType.BALANCE.getAsset(), new UserAssetsModel(null, accountEntity.amount, accountEntity.currency, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -7, -1, 3, null))));
        }
        return null;
    }
}
