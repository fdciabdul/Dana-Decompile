package id.dana.data.user.source.persistence;

import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.user.UserInfoMapper;
import id.dana.data.user.source.UserEntityData;
import id.dana.data.user.source.network.request.UserInfoRequest;
import id.dana.data.user.source.network.result.CheckUserInfoResponse;
import id.dana.data.user.source.network.result.MiniProgramUserInfoResult;
import id.dana.data.user.source.network.result.UserCohortResult;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import id.dana.data.user.source.persistence.dao.UserInfoDao;
import id.dana.data.user.source.persistence.entity.UserInfoEntity;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020302¢\u0006\u0004\b5\u00106J3\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0010J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0010J\u0013\u0010\u001a\u001a\u0006*\u00020\u00190\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0010J\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0010J\u001d\u0010!\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u001fH\u0002¢\u0006\u0004\b*\u0010+J-\u0010-\u001a\b\u0012\u0004\u0012\u00020)0\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101"}, d2 = {"Lid/dana/data/user/source/persistence/LocalUserInfoData;", "Lid/dana/data/base/BasePersistence;", "Lid/dana/data/user/source/UserEntityData;", "", "scopes", "clientId", "userId", "Lio/reactivex/Observable;", "Lid/dana/data/user/source/network/result/CheckUserInfoResponse;", "checkUserInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "clearAll", "()V", "Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "getBalance", "()Lio/reactivex/Observable;", "getFaceAuthInfo", "getInfoWithKyc", "Lid/dana/data/user/source/network/result/MiniProgramUserInfoResult;", "getMiniProgramUserInfo", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/user/source/network/result/UserCohortResult;", "getUserCohort", "getUserInfo", "Lid/dana/data/user/source/persistence/dao/UserInfoDao;", "getUserInfoDao", "()Lid/dana/data/user/source/persistence/dao/UserInfoDao;", "getUserInfoWithUserPan", "getUserStatusInfo", "", "Lid/dana/data/user/source/persistence/entity/UserInfoEntity;", "userInfoEntities", "mapUserInfo", "(Ljava/util/List;)Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "Lid/dana/domain/featureconfig/model/QueryUserDataConfig;", "queryUserDataConfig", "setQueryUserDataConfig", "(Lid/dana/domain/featureconfig/model/QueryUserDataConfig;)V", "queryType", "userInfo", "", "updateUserInfo", "(Ljava/lang/String;Lid/dana/data/user/source/persistence/entity/UserInfoEntity;)J", "userInfoRpcResult", "updateUserInfoCache", "(Ljava/lang/String;Lid/dana/data/user/source/network/result/UserInfoRpcResult;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/user/UserInfoMapper;", "userInfoMapper", "Lid/dana/data/user/UserInfoMapper;", "Ldagger/Lazy;", "Lid/dana/data/base/BasePersistenceDao;", "persistenceDao", "<init>", "(Lid/dana/data/user/UserInfoMapper;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalUserInfoData extends BasePersistence implements UserEntityData {
    private final UserInfoMapper userInfoMapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LocalUserInfoData(UserInfoMapper userInfoMapper, Lazy<BasePersistenceDao> lazy) {
        super(lazy);
        Intrinsics.checkNotNullParameter(userInfoMapper, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.userInfoMapper = userInfoMapper;
    }

    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<UserInfoRpcResult> getUserInfo() {
        Observable<UserInfoRpcResult> map = Observable.fromCallable(new Callable() { // from class: id.dana.data.user.source.persistence.LocalUserInfoData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m2116getUserInfo$lambda0;
                m2116getUserInfo$lambda0 = LocalUserInfoData.m2116getUserInfo$lambda0(LocalUserInfoData.this);
                return m2116getUserInfo$lambda0;
            }
        }).map(new Function() { // from class: id.dana.data.user.source.persistence.LocalUserInfoData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserInfoRpcResult m2117getUserInfo$lambda1;
                m2117getUserInfo$lambda1 = LocalUserInfoData.m2117getUserInfo$lambda1(LocalUserInfoData.this, (List) obj);
                return m2117getUserInfo$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getUserInfo$lambda-0 */
    public static final List m2116getUserInfo$lambda0(LocalUserInfoData localUserInfoData) {
        Intrinsics.checkNotNullParameter(localUserInfoData, "");
        List<UserInfoEntity> userInfoFull = localUserInfoData.getUserInfoDao().getUserInfoFull();
        if (userInfoFull != null) {
            return userInfoFull;
        }
        throw new CallableReturnNullError("LocalUserInfoData#getUserInfo");
    }

    /* renamed from: getUserInfo$lambda-1 */
    public static final UserInfoRpcResult m2117getUserInfo$lambda1(LocalUserInfoData localUserInfoData, List list) {
        Intrinsics.checkNotNullParameter(localUserInfoData, "");
        Intrinsics.checkNotNullParameter(list, "");
        return localUserInfoData.mapUserInfo(list);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<CheckUserInfoResponse> checkUserInfo(String scopes, String clientId, String userId) {
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<MiniProgramUserInfoResult> getMiniProgramUserInfo(String clientId, String userId) {
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<UserInfoRpcResult> getFaceAuthInfo() {
        Observable<UserInfoRpcResult> map = Observable.just(getUserInfoDao().getUserInfoFaceAuth()).map(new Function() { // from class: id.dana.data.user.source.persistence.LocalUserInfoData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserInfoRpcResult m2114getFaceAuthInfo$lambda2;
                m2114getFaceAuthInfo$lambda2 = LocalUserInfoData.m2114getFaceAuthInfo$lambda2(LocalUserInfoData.this, (List) obj);
                return m2114getFaceAuthInfo$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getFaceAuthInfo$lambda-2 */
    public static final UserInfoRpcResult m2114getFaceAuthInfo$lambda2(LocalUserInfoData localUserInfoData, List list) {
        Intrinsics.checkNotNullParameter(localUserInfoData, "");
        Intrinsics.checkNotNullParameter(list, "");
        return localUserInfoData.mapUserInfo(list);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<UserInfoRpcResult> getBalance() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<UserInfoRpcResult> getInfoWithKyc() {
        Observable<UserInfoRpcResult> map = Observable.just(getUserInfoDao().getUserInfoKyc()).map(new Function() { // from class: id.dana.data.user.source.persistence.LocalUserInfoData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserInfoRpcResult m2115getInfoWithKyc$lambda3;
                m2115getInfoWithKyc$lambda3 = LocalUserInfoData.m2115getInfoWithKyc$lambda3(LocalUserInfoData.this, (List) obj);
                return m2115getInfoWithKyc$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getInfoWithKyc$lambda-3 */
    public static final UserInfoRpcResult m2115getInfoWithKyc$lambda3(LocalUserInfoData localUserInfoData, List list) {
        Intrinsics.checkNotNullParameter(localUserInfoData, "");
        Intrinsics.checkNotNullParameter(list, "");
        return localUserInfoData.mapUserInfo(list);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<UserInfoRpcResult> getUserInfoWithUserPan() {
        Observable<UserInfoRpcResult> map = Observable.just(getUserInfoDao().getUserInfoPan()).map(new Function() { // from class: id.dana.data.user.source.persistence.LocalUserInfoData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserInfoRpcResult m2118getUserInfoWithUserPan$lambda4;
                m2118getUserInfoWithUserPan$lambda4 = LocalUserInfoData.m2118getUserInfoWithUserPan$lambda4(LocalUserInfoData.this, (List) obj);
                return m2118getUserInfoWithUserPan$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getUserInfoWithUserPan$lambda-4 */
    public static final UserInfoRpcResult m2118getUserInfoWithUserPan$lambda4(LocalUserInfoData localUserInfoData, List list) {
        Intrinsics.checkNotNullParameter(localUserInfoData, "");
        Intrinsics.checkNotNullParameter(list, "");
        return localUserInfoData.mapUserInfo(list);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<UserInfoRpcResult> getUserStatusInfo() {
        Observable<UserInfoRpcResult> map = Observable.just(getUserInfoDao().getUserInfoStatusInfo()).map(new Function() { // from class: id.dana.data.user.source.persistence.LocalUserInfoData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserInfoRpcResult m2119getUserStatusInfo$lambda5;
                m2119getUserStatusInfo$lambda5 = LocalUserInfoData.m2119getUserStatusInfo$lambda5(LocalUserInfoData.this, (List) obj);
                return m2119getUserStatusInfo$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getUserStatusInfo$lambda-5 */
    public static final UserInfoRpcResult m2119getUserStatusInfo$lambda5(LocalUserInfoData localUserInfoData, List list) {
        Intrinsics.checkNotNullParameter(localUserInfoData, "");
        Intrinsics.checkNotNullParameter(list, "");
        return localUserInfoData.mapUserInfo(list);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<Long> updateUserInfoCache(String queryType, UserInfoRpcResult userInfoRpcResult, String userId) {
        Intrinsics.checkNotNullParameter(queryType, "");
        Intrinsics.checkNotNullParameter(userInfoRpcResult, "");
        Intrinsics.checkNotNullParameter(userId, "");
        Observable<Long> just = Observable.just(Long.valueOf(updateUserInfo(queryType, this.userInfoMapper.transformToUserInfoEntity(userInfoRpcResult, userId))));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.user.source.UserEntityData
    public final Observable<UserCohortResult> getUserCohort() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.user.source.UserEntityData
    public final void setQueryUserDataConfig(QueryUserDataConfig queryUserDataConfig) {
        Intrinsics.checkNotNullParameter(queryUserDataConfig, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public final void clearAll() {
        getUserInfoDao().clearUserInfo();
    }

    private final long updateUserInfo(String queryType, UserInfoEntity userInfo) {
        switch (queryType.hashCode()) {
            case 2169487:
                if (queryType.equals("FULL")) {
                    return getUserInfoDao().updateUserInfoFull(userInfo);
                }
                break;
            case 517433865:
                if (queryType.equals(UserInfoRequest.USER_PAN)) {
                    return getUserInfoDao().updateUserInfoPan(userInfo);
                }
                break;
            case 1044132426:
                if (queryType.equals("FACE_AUTH")) {
                    return getUserInfoDao().updateUserInfoFaceAuth(userInfo);
                }
                break;
            case 1253344792:
                if (queryType.equals(UserInfoRequest.KYC_INFO)) {
                    return getUserInfoDao().updateUserInfo(userInfo);
                }
                break;
            case 1290991835:
                if (queryType.equals(UserInfoRequest.STATUS_INFO)) {
                    return getUserInfoDao().updateUserInfoStatusInfo(userInfo);
                }
                break;
        }
        return -1L;
    }

    private final UserInfoDao getUserInfoDao() {
        return getDb().userInfoDao();
    }

    private final UserInfoRpcResult mapUserInfo(List<UserInfoEntity> userInfoEntities) {
        return userInfoEntities.isEmpty() ? new UserInfoRpcResult(null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, false, false, null, 1048575, null) : this.userInfoMapper.transform((UserInfoEntity) CollectionsKt.first((List) userInfoEntities));
    }
}
