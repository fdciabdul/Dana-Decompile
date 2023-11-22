package id.dana.data.bank.repository;

import dagger.Lazy;
import id.dana.data.bank.UserBankExistException;
import id.dana.data.bank.model.StoreBankQrConfig;
import id.dana.data.bank.model.UserConfigBankQrContent;
import id.dana.data.bank.model.UserConfigBankQrContentKt;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.userconfig.BiztypeNotFoundException;
import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.domain.bank.model.RequestMoneyInit;
import id.dana.domain.bank.model.UserBank;
import id.dana.domain.bank.repository.UserBankRepository;
import id.dana.domain.userconfig.model.QueryConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\fJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/data/bank/repository/UserBankEntityRepository;", "Lid/dana/domain/bank/repository/UserBankRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lid/dana/domain/bank/model/UserBank;", "p0", "Lio/reactivex/Observable;", "", "addUserBank", "(Lid/dana/domain/bank/model/UserBank;)Lio/reactivex/Observable;", "deleteUserBank", "", "getUserBanks", "()Lio/reactivex/Observable;", "hasUserBank", "Lid/dana/domain/bank/model/RequestMoneyInit;", "initRequestMoney", "saveUserBanks", "(Ljava/util/List;)Lio/reactivex/Observable;", "Ldagger/Lazy;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "PlaceComponentResult", "Ldagger/Lazy;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "getAuthRequestContext", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "p1", "p2", "<init>", "(Lid/dana/data/userconfig/repository/UserConfigEntityRepository;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserBankEntityRepository implements UserBankRepository, HoldLoginV1Repository {
    private final HoldLoginV1EntityRepository BuiltInFictitiousFunctionClassFactory;
    private final Lazy<ConfigEntityDataFactory> PlaceComponentResult;
    private final UserConfigEntityRepository getAuthRequestContext;

    @Inject
    public UserBankEntityRepository(UserConfigEntityRepository userConfigEntityRepository, HoldLoginV1EntityRepository holdLoginV1EntityRepository, Lazy<ConfigEntityDataFactory> lazy) {
        Intrinsics.checkNotNullParameter(userConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.getAuthRequestContext = userConfigEntityRepository;
        this.BuiltInFictitiousFunctionClassFactory = holdLoginV1EntityRepository;
        this.PlaceComponentResult = lazy;
    }

    @Override // id.dana.domain.bank.repository.UserBankRepository
    public final Observable<List<UserBank>> getUserBanks() {
        Observable<List<UserBank>> map = this.getAuthRequestContext.getUserSpecificConfig(new QueryConfig(UserConfigBizTypeConstant.CONFIG_USER_BANK_ACCOUNT_QR, UserConfigBankQrContent[].class)).onErrorReturn(new Function() { // from class: id.dana.data.bank.repository.UserBankEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserBankEntityRepository.BuiltInFictitiousFunctionClassFactory(UserBankEntityRepository.this, (Throwable) obj);
            }
        }).map(new Function() { // from class: id.dana.data.bank.repository.UserBankEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserBankEntityRepository.MyBillsEntityDataFactory((UserConfigBankQrContent[]) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.bank.repository.UserBankRepository
    public final Observable<Boolean> saveUserBanks(List<UserBank> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        UserConfigEntityRepository userConfigEntityRepository = this.getAuthRequestContext;
        Object[] array = UserConfigBankQrContentKt.PlaceComponentResult(p0).toArray(new UserConfigBankQrContent[0]);
        if (array != null) {
            Observable<Boolean> saveUserSpecificConfig = userConfigEntityRepository.saveUserSpecificConfig(new StoreBankQrConfig((UserConfigBankQrContent[]) array));
            Intrinsics.checkNotNullExpressionValue(saveUserSpecificConfig, "");
            return saveUserSpecificConfig;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // id.dana.domain.bank.repository.UserBankRepository
    public final Observable<Boolean> addUserBank(final UserBank p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = getUserBanks().flatMap(new Function() { // from class: id.dana.data.bank.repository.UserBankEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserBankEntityRepository.MyBillsEntityDataFactory(UserBank.this, this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.domain.bank.repository.UserBankRepository
    public final Observable<Boolean> deleteUserBank(final UserBank p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = getUserBanks().flatMap(new Function() { // from class: id.dana.data.bank.repository.UserBankEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserBankEntityRepository.getAuthRequestContext(UserBank.this, this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.domain.bank.repository.UserBankRepository
    public final Observable<Boolean> hasUserBank(final UserBank p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = getUserBanks().flatMap(new Function() { // from class: id.dana.data.bank.repository.UserBankEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserBankEntityRepository.getAuthRequestContext(UserBank.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    public static /* synthetic */ UserConfigBankQrContent[] BuiltInFictitiousFunctionClassFactory(UserBankEntityRepository userBankEntityRepository, Throwable th) {
        Intrinsics.checkNotNullParameter(userBankEntityRepository, "");
        Intrinsics.checkNotNullParameter(th, "");
        if (!(th instanceof BiztypeNotFoundException)) {
            throw th;
        }
        return new UserConfigBankQrContent[0];
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(UserBank userBank, UserBankEntityRepository userBankEntityRepository, List list) {
        Observable<Boolean> saveUserBanks;
        Intrinsics.checkNotNullParameter(userBank, "");
        Intrinsics.checkNotNullParameter(userBankEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        List<UserBank> mutableList = CollectionsKt.toMutableList((Collection) list);
        if (mutableList.remove(userBank)) {
            saveUserBanks = userBankEntityRepository.saveUserBanks(mutableList);
        } else {
            saveUserBanks = Observable.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(saveUserBanks, "");
        }
        return saveUserBanks;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(UserBank userBank, UserBankEntityRepository userBankEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(userBank, "");
        Intrinsics.checkNotNullParameter(userBankEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (list.contains(userBank)) {
            throw new UserBankExistException();
        }
        List<UserBank> mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.add(userBank);
        return userBankEntityRepository.saveUserBanks(mutableList);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(UserBank userBank, List list) {
        Intrinsics.checkNotNullParameter(userBank, "");
        Intrinsics.checkNotNullParameter(list, "");
        return Observable.just(Boolean.valueOf(list.contains(userBank)));
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(UserConfigBankQrContent[] userConfigBankQrContentArr) {
        Intrinsics.checkNotNullParameter(userConfigBankQrContentArr, "");
        return UserConfigBankQrContentKt.PlaceComponentResult(userConfigBankQrContentArr);
    }

    public static /* synthetic */ RequestMoneyInit MyBillsEntityDataFactory(Integer num, List list) {
        Intrinsics.checkNotNullParameter(num, "");
        Intrinsics.checkNotNullParameter(list, "");
        return new RequestMoneyInit(num.intValue(), list);
    }

    @Override // id.dana.domain.bank.repository.UserBankRepository
    public final Observable<RequestMoneyInit> initRequestMoney() {
        ConfigEntityData createData2 = this.PlaceComponentResult.get().createData2("split");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        Observable zipWith = createData2.getMaxBankAccount().zipWith(getUserBanks(), new BiFunction() { // from class: id.dana.data.bank.repository.UserBankEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return UserBankEntityRepository.MyBillsEntityDataFactory((Integer) obj, (List) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zipWith, "");
        return zipWith;
    }
}
