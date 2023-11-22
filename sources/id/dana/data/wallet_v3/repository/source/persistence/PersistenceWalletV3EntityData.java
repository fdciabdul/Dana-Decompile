package id.dana.data.wallet_v3.repository.source.persistence;

import androidx.sqlite.db.SimpleSQLiteQuery;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.pocket.model.UserStatus;
import id.dana.data.wallet_v3.mapper.KtpInfoResultMapper;
import id.dana.data.wallet_v3.mapper.UserIdentityAssetsDaoMapperKt;
import id.dana.data.wallet_v3.mapper.UserPaymentAssetsDaoMapperKt;
import id.dana.data.wallet_v3.mapper.UserPocketAssetsDaoMapperKt;
import id.dana.data.wallet_v3.model.PocketUpdateResult;
import id.dana.data.wallet_v3.model.UserPocketAssetEntity;
import id.dana.data.wallet_v3.model.UserPocketAssetResult;
import id.dana.data.wallet_v3.repository.WalletV3EntityData;
import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetInfosResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetsWrapperResult;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao;
import id.dana.data.wallet_v3.repository.source.persistence.entity.KtpDaoEntity;
import id.dana.data.wallet_v3.repository.source.persistence.entity.UserPaymentAssetsDaoEntity;
import id.dana.data.wallet_v3.repository.source.persistence.entity.UserPocketAssetsDaoEntity;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\f\u0010S\u001a\b\u0012\u0004\u0012\u00020R0N\u0012\f\u0010P\u001a\b\u0012\u0004\u0012\u00020O0N¢\u0006\u0004\bT\u0010UJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014JO\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\tH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\fH\u0016¢\u0006\u0004\b \u0010\u0014J%\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\"\u0010\u000fJU\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010$\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b%\u0010&J#\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f2\u0006\u0010'\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010)J/\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b+\u0010,J5\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\t0\f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b.\u0010,J#\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f2\u0006\u0010'\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u0010)JU\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010$\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b0\u0010&JA\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\t0\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010#\u001a\u0004\u0018\u00010\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b2\u00103J#\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f2\u0006\u0010'\u001a\u00020\nH\u0016¢\u0006\u0004\b4\u0010)J-\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u00106*\u0002052\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0002¢\u0006\u0004\b9\u0010:J\u001d\u0010=\u001a\u00020\u00062\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\tH\u0016¢\u0006\u0004\b=\u0010>J\u001d\u0010A\u001a\u00020\u00062\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\tH\u0016¢\u0006\u0004\bA\u0010>J\u001d\u0010D\u001a\u00020\u00062\f\u0010C\u001a\b\u0012\u0004\u0012\u00020B0\tH\u0016¢\u0006\u0004\bD\u0010>J\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0006\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\bE\u0010)J+\u0010F\u001a\b\u0012\u0004\u0012\u00020*0\f2\u0006\u0010#\u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\bF\u0010GJ+\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\u0006\u0010#\u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\bH\u0010GJ%\u0010L\u001a\b\u0012\u0004\u0012\u00020K0\f2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\bL\u0010MR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020O0N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010Q"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/persistence/PersistenceWalletV3EntityData;", "Lid/dana/data/base/BasePersistence;", "Lid/dana/data/wallet_v3/repository/WalletV3EntityData;", "", "clearAll", "()V", "Lio/reactivex/Completable;", "deleteKtpDetailInfo", "()Lio/reactivex/Completable;", "", "", "uniqueId", "Lio/reactivex/Observable;", "", "deleteUserPaymentAssets", "(Ljava/util/List;)Lio/reactivex/Observable;", "getActiveUserPocketAssetStatus", "()Ljava/util/List;", "Lid/dana/data/pocket/model/KtpAssetResult;", "getKtpDetailInfo", "()Lio/reactivex/Observable;", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "Lid/dana/domain/pocket/model/AssetStatus;", "statuses", "assetTypes", "Lid/dana/data/pocket/model/UserStatus;", "userStatus", "Lid/dana/data/wallet_v3/model/UserPocketAssetResult;", "getPocketRedDotAsset", "(IILjava/util/List;Ljava/util/List;Ljava/util/List;)Lio/reactivex/Observable;", "getSavedAssetTypes", "assetType", "getTotalUserPaymentAssets", "cardTitle", "order", "getTotalUserPocketAssets", "(IILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "query", "getUserIdentityViaQuery", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;", "getUserPaymentAssets", "(Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPaymentAssetsDaoEntity;", "getUserPaymentAssetsBasedOnParam", "getUserPaymentViaQuery", "getUserPocketAssets", "Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPocketAssetsDaoEntity;", "getUserPocketAssetsBasedOnParam", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "getUserPocketViaQuery", "", "T", "Lkotlin/Function0;", "execute", "safeExecuteDatabase", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "ktpResult", "saveKtpDetailInfo", "(Ljava/util/List;)Lio/reactivex/Completable;", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetInfosResult;", "assetInfos", "saveUserPaymentAssets", "Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;", "pocketAssets", "saveUserPocketAssets", "searchUserIdentityAssets", "searchUserPaymentAssets", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "searchUserPocketAssets", "userId", "pocketId", "Lid/dana/data/wallet_v3/model/PocketUpdateResult;", "updateUserPocketAssets", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ldagger/Lazy;", "Lid/dana/data/wallet_v3/mapper/KtpInfoResultMapper;", "ktpInfoResultMapper", "Ldagger/Lazy;", "Lid/dana/data/base/BasePersistenceDao;", "persistenceDao", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PersistenceWalletV3EntityData extends BasePersistence implements WalletV3EntityData {
    private final Lazy<KtpInfoResultMapper> ktpInfoResultMapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PersistenceWalletV3EntityData(Lazy<BasePersistenceDao> lazy, Lazy<KtpInfoResultMapper> lazy2) {
        super(lazy);
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.ktpInfoResultMapper = lazy2;
    }

    private final <T> Observable<T> safeExecuteDatabase(final Function0<? extends T> execute) {
        Observable<T> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object m2232safeExecuteDatabase$lambda0;
                m2232safeExecuteDatabase$lambda0 = PersistenceWalletV3EntityData.m2232safeExecuteDatabase$lambda0(Function0.this);
                return m2232safeExecuteDatabase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* renamed from: safeExecuteDatabase$lambda-0 */
    public static final Object m2232safeExecuteDatabase$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        Object invoke = function0.invoke();
        if (invoke != null) {
            return invoke;
        }
        throw new CallableReturnNullError("PersistenceWalletV3EntityData#safeExecuteDatabase");
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserAssetsWrapperResult> getUserPaymentAssets(List<String> assetType, String cardTitle) {
        Observable<UserAssetsWrapperResult> onErrorReturn = getUserPaymentAssetsBasedOnParam(assetType, cardTitle).map(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserAssetsWrapperResult m2229getUserPaymentAssets$lambda1;
                m2229getUserPaymentAssets$lambda1 = PersistenceWalletV3EntityData.m2229getUserPaymentAssets$lambda1((List) obj);
                return m2229getUserPaymentAssets$lambda1;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserAssetsWrapperResult m2230getUserPaymentAssets$lambda2;
                m2230getUserPaymentAssets$lambda2 = PersistenceWalletV3EntityData.m2230getUserPaymentAssets$lambda2((Throwable) obj);
                return m2230getUserPaymentAssets$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    /* renamed from: getUserPaymentAssets$lambda-1 */
    public static final UserAssetsWrapperResult m2229getUserPaymentAssets$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return new UserAssetsWrapperResult(null, null, UserPaymentAssetsDaoMapperKt.toUserAssetInfosResultList(list));
    }

    /* renamed from: getUserPaymentAssets$lambda-2 */
    public static final UserAssetsWrapperResult m2230getUserPaymentAssets$lambda2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new UserAssetsWrapperResult(null, null, null, 7, null);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Completable saveUserPaymentAssets(final List<UserAssetInfosResult> assetInfos) {
        Intrinsics.checkNotNullParameter(assetInfos, "");
        Completable ignoreElements = safeExecuteDatabase(new Function0<Unit>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$saveUserPaymentAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                UserPaymentAssetsDao userPaymentAssetsDao = PersistenceWalletV3EntityData.this.getDb().userPaymentAssetsDao();
                Object[] array = UserPaymentAssetsDaoMapperKt.toUserPaymentAssetsDaoEntities(assetInfos).toArray(new UserPaymentAssetsDaoEntity[0]);
                if (array != null) {
                    UserPaymentAssetsDaoEntity[] userPaymentAssetsDaoEntityArr = (UserPaymentAssetsDaoEntity[]) array;
                    userPaymentAssetsDao.saveUserPaymentAssets((UserPaymentAssetsDaoEntity[]) Arrays.copyOf(userPaymentAssetsDaoEntityArr, userPaymentAssetsDaoEntityArr.length));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserAssetsWrapperResult> searchUserPaymentAssets(final String cardTitle, final List<String> assetType) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Intrinsics.checkNotNullParameter(assetType, "");
        Observable<UserAssetsWrapperResult> onErrorReturn = safeExecuteDatabase(new Function0<List<? extends UserPaymentAssetsDaoEntity>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$searchUserPaymentAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends UserPaymentAssetsDaoEntity> invoke() {
                return PersistenceWalletV3EntityData.this.getDb().userPaymentAssetsDao().searchUserPaymentAssets(cardTitle, assetType);
            }
        }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserAssetsWrapperResult m2235searchUserPaymentAssets$lambda3;
                m2235searchUserPaymentAssets$lambda3 = PersistenceWalletV3EntityData.m2235searchUserPaymentAssets$lambda3((List) obj);
                return m2235searchUserPaymentAssets$lambda3;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserAssetsWrapperResult m2236searchUserPaymentAssets$lambda4;
                m2236searchUserPaymentAssets$lambda4 = PersistenceWalletV3EntityData.m2236searchUserPaymentAssets$lambda4((Throwable) obj);
                return m2236searchUserPaymentAssets$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    /* renamed from: searchUserPaymentAssets$lambda-3 */
    public static final UserAssetsWrapperResult m2235searchUserPaymentAssets$lambda3(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return new UserAssetsWrapperResult(null, null, UserPaymentAssetsDaoMapperKt.toUserAssetInfosResultList(list));
    }

    /* renamed from: searchUserPaymentAssets$lambda-4 */
    public static final UserAssetsWrapperResult m2236searchUserPaymentAssets$lambda4(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new UserAssetsWrapperResult(null, null, null, 7, null);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<Boolean> deleteUserPaymentAssets(final List<String> uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "");
        return safeExecuteDatabase(new Function0<Boolean>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$deleteUserPaymentAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                if ((!uniqueId.isEmpty()) != false) {
                    this.getDb().userPaymentAssetsDao().deleteUserPaymentAssets(uniqueId);
                }
                return Boolean.TRUE;
            }
        });
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserPocketAssetResult> getPocketRedDotAsset(int pageNum, int r2, List<? extends AssetStatus> statuses, List<String> assetTypes, List<? extends UserStatus> userStatus) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        Intrinsics.checkNotNullParameter(userStatus, "");
        ?? r22 = 0;
        throw new NotImplementedError(r22, 1, r22);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserPocketAssetResult> getUserPocketAssets(int pageNum, int r2, List<? extends AssetStatus> statuses, List<String> assetTypes, String cardTitle, String order) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        List<? extends AssetStatus> list = statuses;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AssetStatus) it.next()).getValue());
        }
        Observable map = getUserPocketAssetsBasedOnParam(assetTypes, cardTitle, arrayList).map(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserPocketAssetResult m2231getUserPocketAssets$lambda6;
                m2231getUserPocketAssets$lambda6 = PersistenceWalletV3EntityData.m2231getUserPocketAssets$lambda6((List) obj);
                return m2231getUserPocketAssets$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getUserPocketAssets$lambda-6 */
    public static final UserPocketAssetResult m2231getUserPocketAssets$lambda6(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return new UserPocketAssetResult(false, UserPocketAssetsDaoMapperKt.toUserPocketAssetEntityList(list), 0);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Completable saveUserPocketAssets(final List<UserPocketAssetEntity> pocketAssets) {
        Intrinsics.checkNotNullParameter(pocketAssets, "");
        Completable ignoreElements = safeExecuteDatabase(new Function0<Unit>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$saveUserPocketAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                UserPocketAssetsDao userPocketAssetsDao = PersistenceWalletV3EntityData.this.getDb().userPocketAssetsDao();
                Object[] array = UserPocketAssetsDaoMapperKt.toUserPocketAssetsDaoEntities(pocketAssets).toArray(new UserPocketAssetsDaoEntity[0]);
                if (array != null) {
                    UserPocketAssetsDaoEntity[] userPocketAssetsDaoEntityArr = (UserPocketAssetsDaoEntity[]) array;
                    userPocketAssetsDao.saveUserPocketAssets((UserPocketAssetsDaoEntity[]) Arrays.copyOf(userPocketAssetsDaoEntityArr, userPocketAssetsDaoEntityArr.length));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserPocketAssetResult> searchUserPocketAssets(final String cardTitle, final List<String> assetType) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Intrinsics.checkNotNullParameter(assetType, "");
        Observable<UserPocketAssetResult> map = safeExecuteDatabase(new Function0<List<? extends UserPocketAssetsDaoEntity>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$searchUserPocketAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends UserPocketAssetsDaoEntity> invoke() {
                List<String> activeUserPocketAssetStatus;
                UserPocketAssetsDao userPocketAssetsDao = PersistenceWalletV3EntityData.this.getDb().userPocketAssetsDao();
                String str = cardTitle;
                List<String> list = assetType;
                activeUserPocketAssetStatus = PersistenceWalletV3EntityData.this.getActiveUserPocketAssetStatus();
                return userPocketAssetsDao.searchUserPocketAssets(str, list, activeUserPocketAssetStatus);
            }
        }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserPocketAssetResult m2237searchUserPocketAssets$lambda7;
                m2237searchUserPocketAssets$lambda7 = PersistenceWalletV3EntityData.m2237searchUserPocketAssets$lambda7((List) obj);
                return m2237searchUserPocketAssets$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: searchUserPocketAssets$lambda-7 */
    public static final UserPocketAssetResult m2237searchUserPocketAssets$lambda7(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return new UserPocketAssetResult(false, UserPocketAssetsDaoMapperKt.toUserPocketAssetEntityList(list), 0);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<PocketUpdateResult> updateUserPocketAssets(String userId, final String pocketId) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(pocketId, "");
        Observable<PocketUpdateResult> map = safeExecuteDatabase(new Function0<Integer>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$updateUserPocketAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(PersistenceWalletV3EntityData.this.getDb().userPocketAssetsDao().deleteUserPocketAssets(pocketId));
            }
        }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PocketUpdateResult m2238updateUserPocketAssets$lambda8;
                m2238updateUserPocketAssets$lambda8 = PersistenceWalletV3EntityData.m2238updateUserPocketAssets$lambda8(pocketId, (Integer) obj);
                return m2238updateUserPocketAssets$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: updateUserPocketAssets$lambda-8 */
    public static final PocketUpdateResult m2238updateUserPocketAssets$lambda8(String str, Integer num) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(num, "");
        return new PocketUpdateResult(str);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<KtpAssetResult> getKtpDetailInfo() {
        Observable<KtpAssetResult> onErrorReturn = safeExecuteDatabase(new Function0<List<? extends KtpDaoEntity>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getKtpDetailInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KtpDaoEntity> invoke() {
                return PersistenceWalletV3EntityData.this.getDb().userIdentityAssetsDao().getUserKtpAssets();
            }
        }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                KtpAssetResult m2227getKtpDetailInfo$lambda9;
                m2227getKtpDetailInfo$lambda9 = PersistenceWalletV3EntityData.m2227getKtpDetailInfo$lambda9(PersistenceWalletV3EntityData.this, (List) obj);
                return m2227getKtpDetailInfo$lambda9;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                KtpAssetResult m2226getKtpDetailInfo$lambda10;
                m2226getKtpDetailInfo$lambda10 = PersistenceWalletV3EntityData.m2226getKtpDetailInfo$lambda10((Throwable) obj);
                return m2226getKtpDetailInfo$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    /* renamed from: getKtpDetailInfo$lambda-9 */
    public static final KtpAssetResult m2227getKtpDetailInfo$lambda9(PersistenceWalletV3EntityData persistenceWalletV3EntityData, List list) {
        Intrinsics.checkNotNullParameter(persistenceWalletV3EntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        List<? extends KtpResult> apply = persistenceWalletV3EntityData.ktpInfoResultMapper.get().apply(list);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        return new KtpAssetResult(false, apply, 0);
    }

    /* renamed from: getKtpDetailInfo$lambda-10 */
    public static final KtpAssetResult m2226getKtpDetailInfo$lambda10(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new KtpAssetResult(false, null, 0, 7, null);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Completable saveKtpDetailInfo(final List<KtpResult> ktpResult) {
        Intrinsics.checkNotNullParameter(ktpResult, "");
        Completable ignoreElements = safeExecuteDatabase(new Function0<Unit>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$saveKtpDetailInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                UserIdentityAssetsDao userIdentityAssetsDao = PersistenceWalletV3EntityData.this.getDb().userIdentityAssetsDao();
                Object[] array = UserIdentityAssetsDaoMapperKt.toKtpEntities(ktpResult).toArray(new KtpDaoEntity[0]);
                if (array != null) {
                    KtpDaoEntity[] ktpDaoEntityArr = (KtpDaoEntity[]) array;
                    userIdentityAssetsDao.saveUserKtpAssets((KtpDaoEntity[]) Arrays.copyOf(ktpDaoEntityArr, ktpDaoEntityArr.length));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Completable deleteKtpDetailInfo() {
        Completable ignoreElements = safeExecuteDatabase(new Function0<Unit>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$deleteKtpDetailInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PersistenceWalletV3EntityData.this.getDb().userIdentityAssetsDao().clearUserIdentityAssets();
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<KtpAssetResult> searchUserIdentityAssets(final String cardTitle) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Observable<KtpAssetResult> onErrorReturn = safeExecuteDatabase(new Function0<List<? extends KtpDaoEntity>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$searchUserIdentityAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KtpDaoEntity> invoke() {
                return PersistenceWalletV3EntityData.this.getDb().userIdentityAssetsDao().searchUserIdentityAssets(cardTitle);
            }
        }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                KtpAssetResult m2233searchUserIdentityAssets$lambda11;
                m2233searchUserIdentityAssets$lambda11 = PersistenceWalletV3EntityData.m2233searchUserIdentityAssets$lambda11(PersistenceWalletV3EntityData.this, (List) obj);
                return m2233searchUserIdentityAssets$lambda11;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                KtpAssetResult m2234searchUserIdentityAssets$lambda12;
                m2234searchUserIdentityAssets$lambda12 = PersistenceWalletV3EntityData.m2234searchUserIdentityAssets$lambda12((Throwable) obj);
                return m2234searchUserIdentityAssets$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    /* renamed from: searchUserIdentityAssets$lambda-11 */
    public static final KtpAssetResult m2233searchUserIdentityAssets$lambda11(PersistenceWalletV3EntityData persistenceWalletV3EntityData, List list) {
        Intrinsics.checkNotNullParameter(persistenceWalletV3EntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        List<? extends KtpResult> apply = persistenceWalletV3EntityData.ktpInfoResultMapper.get().apply(list);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        return new KtpAssetResult(false, apply, 0);
    }

    /* renamed from: searchUserIdentityAssets$lambda-12 */
    public static final KtpAssetResult m2234searchUserIdentityAssets$lambda12(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new KtpAssetResult(false, null, 0, 7, null);
    }

    private final Observable<List<UserPaymentAssetsDaoEntity>> getUserPaymentAssetsBasedOnParam(final List<String> assetType, final String cardTitle) {
        String str = cardTitle;
        if (str == null || str.length() == 0) {
            return safeExecuteDatabase(new Function0<List<? extends UserPaymentAssetsDaoEntity>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getUserPaymentAssetsBasedOnParam$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends UserPaymentAssetsDaoEntity> invoke() {
                    return PersistenceWalletV3EntityData.this.getDb().userPaymentAssetsDao().getAllUserPaymentAssets(assetType);
                }
            });
        }
        return safeExecuteDatabase(new Function0<List<? extends UserPaymentAssetsDaoEntity>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getUserPaymentAssetsBasedOnParam$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends UserPaymentAssetsDaoEntity> invoke() {
                return PersistenceWalletV3EntityData.this.getDb().userPaymentAssetsDao().getFilteredUserPaymentAssets(assetType, cardTitle);
            }
        });
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<List<String>> getSavedAssetTypes() {
        Observable<List<String>> zip = Observable.zip(safeExecuteDatabase(new Function0<List<? extends String>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getSavedAssetTypes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends String> invoke() {
                return PersistenceWalletV3EntityData.this.getDb().userPaymentAssetsDao().getSavedAssetTypes();
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()), safeExecuteDatabase(new Function0<List<? extends String>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getSavedAssetTypes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends String> invoke() {
                List<String> activeUserPocketAssetStatus;
                UserPocketAssetsDao userPocketAssetsDao = PersistenceWalletV3EntityData.this.getDb().userPocketAssetsDao();
                activeUserPocketAssetStatus = PersistenceWalletV3EntityData.this.getActiveUserPocketAssetStatus();
                return userPocketAssetsDao.getSavedAssetTypes(activeUserPocketAssetStatus);
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()), safeExecuteDatabase(new Function0<List<? extends String>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getSavedAssetTypes$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends String> invoke() {
                return PersistenceWalletV3EntityData.this.getDb().userIdentityAssetsDao().getSavedAssetTypes();
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()), new Function3() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                List m2228getSavedAssetTypes$lambda13;
                m2228getSavedAssetTypes$lambda13 = PersistenceWalletV3EntityData.m2228getSavedAssetTypes$lambda13((List) obj, (List) obj2, (List) obj3);
                return m2228getSavedAssetTypes$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* renamed from: getSavedAssetTypes$lambda-13 */
    public static final List m2228getSavedAssetTypes$lambda13(List list, List list2, List list3) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) list, (Iterable) list2), (Iterable) list3);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<Integer> getTotalUserPaymentAssets(final List<String> assetType) {
        return safeExecuteDatabase(new Function0<Integer>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getTotalUserPaymentAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(PersistenceWalletV3EntityData.this.getDb().userPaymentAssetsDao().getAllUserPaymentAssets(assetType).size());
            }
        });
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<Integer> getTotalUserPocketAssets(int pageNum, int r2, final List<? extends AssetStatus> statuses, final List<String> assetTypes, String cardTitle, String order) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        return safeExecuteDatabase(new Function0<Integer>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getTotalUserPocketAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                UserPocketAssetsDao userPocketAssetsDao = PersistenceWalletV3EntityData.this.getDb().userPocketAssetsDao();
                List<String> list = assetTypes;
                List<AssetStatus> list2 = statuses;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AssetStatus) it.next()).getValue());
                }
                return Integer.valueOf(userPocketAssetsDao.getAllUserPocketAssets(list, arrayList).size());
            }
        });
    }

    private final Observable<List<UserPocketAssetsDaoEntity>> getUserPocketAssetsBasedOnParam(final List<String> assetTypes, final String cardTitle, final List<String> statuses) {
        String str = cardTitle;
        if (str == null || str.length() == 0) {
            return safeExecuteDatabase(new Function0<List<? extends UserPocketAssetsDaoEntity>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getUserPocketAssetsBasedOnParam$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends UserPocketAssetsDaoEntity> invoke() {
                    return PersistenceWalletV3EntityData.this.getDb().userPocketAssetsDao().getAllUserPocketAssets(assetTypes, statuses);
                }
            });
        }
        return safeExecuteDatabase(new Function0<List<? extends UserPocketAssetsDaoEntity>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getUserPocketAssetsBasedOnParam$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends UserPocketAssetsDaoEntity> invoke() {
                return PersistenceWalletV3EntityData.this.getDb().userPocketAssetsDao().getFilteredUserPocketAssets(assetTypes, cardTitle, statuses);
            }
        });
    }

    public final List<String> getActiveUserPocketAssetStatus() {
        return CollectionsKt.listOf((Object[]) new String[]{AssetStatus.INIT.getValue(), AssetStatus.EXPIRING.getValue(), AssetStatus.ACTIVE.getValue()});
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<List<String>> getUserPaymentViaQuery(final String query) {
        Intrinsics.checkNotNullParameter(query, "");
        return safeExecuteDatabase(new Function0<List<? extends String>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getUserPaymentViaQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends String> invoke() {
                return this.getDb().userPaymentAssetsDao().getUserPaymentViaQuery(new SimpleSQLiteQuery(query, new Object[0]));
            }
        });
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<List<String>> getUserPocketViaQuery(final String query) {
        Intrinsics.checkNotNullParameter(query, "");
        return safeExecuteDatabase(new Function0<List<? extends String>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getUserPocketViaQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends String> invoke() {
                return this.getDb().userPocketAssetsDao().getUserPocketViaQuery(new SimpleSQLiteQuery(query, new Object[0]));
            }
        });
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<List<String>> getUserIdentityViaQuery(final String query) {
        Intrinsics.checkNotNullParameter(query, "");
        return safeExecuteDatabase(new Function0<List<? extends String>>() { // from class: id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData$getUserIdentityViaQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends String> invoke() {
                return this.getDb().userIdentityAssetsDao().getUserIdentityViaQuery(new SimpleSQLiteQuery(query, new Object[0]));
            }
        });
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final void clearAll() {
        getDb().userPaymentAssetsDao().clearUserPaymentAssets();
        getDb().userPocketAssetsDao().clearUserPocketAssets();
        getDb().userIdentityAssetsDao().clearUserIdentityAssets();
    }
}
