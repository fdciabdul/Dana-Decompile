package id.dana.data.account.repository.source;

import android.content.Context;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.TransactionEntity;
import id.dana.data.homeinfo.model.KybEntity;
import id.dana.data.payasset.source.network.result.QueryPayMethodResult;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import io.reactivex.Observable;
import j$.util.Optional;

/* loaded from: classes2.dex */
public interface AccountEntityData {
    Observable<Boolean> clearAll();

    Observable<Boolean> finishFirstTime();

    Observable<AccountEntity> getAccount();

    Observable<String> getAvatarUrl();

    Observable<String> getCardCredentialPublicKey();

    Observable<String> getClientKey();

    Observable<AccountEntity> getDrutherDataForUpdate(Context context);

    Observable<KybEntity> getKybInfo();

    Observable<String> getKycLevel();

    String getLastChallengeSid();

    Long getLastUpdatedTimeUserPan();

    Observable<TransactionEntity> getLatestTransaction();

    Observable<String> getNickname();

    Observable<String> getOfflinePublicKey();

    Observable<QueryPayMethodResult> getPayMethod();

    Observable<String> getPhoneMask();

    Observable<String> getPhoneNumber();

    Observable<String> getUUID();

    String getUUIDAsString();

    Observable<String> getUserId();

    Observable<String> getUsername();

    Observable<Boolean> hasAccount();

    Observable<Optional<String>> init();

    Observable<Boolean> init(String str);

    Observable<Boolean> isFirstTime();

    Observable<QueryPayMethodResult> queryAsset();

    Observable<AccountEntity> saveAccount(String str, String str2, String str3, String str4, String str5, String str6);

    Observable<String> saveAvatarUrl(String str);

    Observable<String> saveClientKey(String str);

    Observable<String> saveKycLevel(String str);

    Observable<Boolean> saveLastTransaction(TransactionEntity transactionEntity);

    Observable<Boolean> saveLastUpdatedTimeUserPan(long j);

    Observable<String> saveNickname(String str);

    Observable<String> savePhoneMask(String str);

    Observable<AccountEntity> saveUserInfoWithKyc(UserInfoRpcResult userInfoRpcResult);

    Observable<String> saveUserPan(String str);

    Observable<String> setCardCredentialPublicKey(String str);

    Boolean setLastChallengeSid(String str);

    Observable<String> setOfflinePublicKey(String str);

    Observable<Boolean> updateAccount(String str, String str2, String str3, String str4);
}
