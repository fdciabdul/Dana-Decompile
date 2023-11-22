package id.dana.data.recentrecipient.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.card.repository.CardCredentialEntityRepository;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.recentbank.mapper.RecentBankEntityMapper;
import id.dana.data.recentbank.repository.source.persistance.entity.SecureRecentBankEntity;
import id.dana.data.recentrecipient.BankCardConversionFactory;
import id.dana.data.recentrecipient.mapper.BankCardConversionMapper;
import id.dana.data.recentrecipient.mapper.RecentBankMapper;
import id.dana.data.recentrecipient.mapper.RecentRecipientContactEntityMapper;
import id.dana.data.recentrecipient.mapper.RecentRecipientEntityMapper;
import id.dana.data.recentrecipient.mapper.RecentRecipientMapperKt;
import id.dana.data.recentrecipient.mapper.RecentRecipientPayerEntityMapper;
import id.dana.data.recentrecipient.model.BankCardConversionResult;
import id.dana.data.recentrecipient.model.RecentRecipientEntityExtKt;
import id.dana.data.recentrecipient.source.BankCardConversionEntityData;
import id.dana.data.recentrecipient.source.RecentRecipientEntityData;
import id.dana.data.recentrecipient.source.RecentRecipientEntityDataFactory;
import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.sendmoney.repository.source.SortingSendMoneyPreferenceEntityDataFactory;
import id.dana.data.sendmoney.repository.source.local.PreferenceSortingSendMoneyEntityData;
import id.dana.data.splitbill.repository.source.RecentPayerEntityData;
import id.dana.data.splitbill.repository.source.RecentPayerEntityDataFactory;
import id.dana.data.splitbill.repository.source.persistence.entity.RecentPayerSplitBillEntity;
import id.dana.data.storage.GeneralPreferences;
import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.data.userconfig.model.RecentRecipientStoreConfig;
import id.dana.data.userconfig.model.SecureRecentRecipientStoreConfig;
import id.dana.data.userconfig.model.SecureRecentRecipientStoreConfigKt;
import id.dana.data.userconfig.model.UserConfigRecentRecipientEntity;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.data.userconfig.repository.UserConfigRepository;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.recentbank.model.RecentBank;
import id.dana.domain.recentrecipient.model.RecentBankRecipient;
import id.dana.domain.recentrecipient.model.RecentContactRecipient;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.userconfig.model.QueryConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class RecentRecipientEntityRepository implements RecentRecipientRepository {
    private final AccountEntityDataFactory accountEntityDataFactory;
    private final BankCardConversionFactory bankCardConversionFactory;
    private final BankCardConversionMapper bankCardConversionMapper;
    private final CardCredentialEntityRepository cardCredentialEntityRepository;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final FeatureConfigRepository featureConfigRepository;
    private final GeneralPreferences generalPreferences;
    private final RecentBankEntityMapper recentBankEntityMapper;
    private final RecentBankMapper recentBankMapper;
    private final RecentPayerEntityDataFactory recentPayerEntityDataFactory;
    private final RecentRecipientContactEntityMapper recentRecipientContactEntityMapper;
    private final RecentRecipientEntityDataFactory recentRecipientEntityDataFactory;
    private final RecentRecipientEntityMapper recentRecipientEntityMapper;
    private final RecentRecipientPayerEntityMapper recentRecipientPayerEntityMapper;
    private final QueryConfig<RecentRecipientEntity[]> recentRecipientQueryConfig = new QueryConfig<>(UserConfigBizTypeConstant.CONFIG_RECENT_TRANSACTION, RecentRecipientEntity[].class);
    private final QueryConfig<RecentRecipientEntity[]> recentSecureRecipientQueryConfig = new QueryConfig<>(UserConfigBizTypeConstant.CONFIG_SECURE_RECENT_TRANSACTION, RecentRecipientEntity[].class);
    private final SecurityEntityDataFactory securityEntityDataFactory;
    private final SortingSendMoneyPreferenceEntityDataFactory sortingSendMoneyPreferenceEntityDataFactory;
    private final UserConfigRepository userConfigRepository;

    @Inject
    public RecentRecipientEntityRepository(ConfigEntityDataFactory configEntityDataFactory, RecentPayerEntityDataFactory recentPayerEntityDataFactory, RecentRecipientPayerEntityMapper recentRecipientPayerEntityMapper, RecentRecipientContactEntityMapper recentRecipientContactEntityMapper, RecentRecipientEntityMapper recentRecipientEntityMapper, RecentBankEntityMapper recentBankEntityMapper, UserConfigEntityRepository userConfigEntityRepository, GeneralPreferences generalPreferences, RecentBankMapper recentBankMapper, BankCardConversionFactory bankCardConversionFactory, SecurityEntityDataFactory securityEntityDataFactory, BankCardConversionMapper bankCardConversionMapper, AccountEntityDataFactory accountEntityDataFactory, FeatureConfigRepository featureConfigRepository, SortingSendMoneyPreferenceEntityDataFactory sortingSendMoneyPreferenceEntityDataFactory, RecentRecipientEntityDataFactory recentRecipientEntityDataFactory, CardCredentialEntityRepository cardCredentialEntityRepository) {
        this.configEntityDataFactory = configEntityDataFactory;
        this.userConfigRepository = userConfigEntityRepository;
        this.recentPayerEntityDataFactory = recentPayerEntityDataFactory;
        this.recentRecipientPayerEntityMapper = recentRecipientPayerEntityMapper;
        this.recentRecipientEntityMapper = recentRecipientEntityMapper;
        this.recentRecipientContactEntityMapper = recentRecipientContactEntityMapper;
        this.recentBankEntityMapper = recentBankEntityMapper;
        this.generalPreferences = generalPreferences;
        this.recentBankMapper = recentBankMapper;
        this.bankCardConversionFactory = bankCardConversionFactory;
        this.securityEntityDataFactory = securityEntityDataFactory;
        this.bankCardConversionMapper = bankCardConversionMapper;
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.featureConfigRepository = featureConfigRepository;
        this.sortingSendMoneyPreferenceEntityDataFactory = sortingSendMoneyPreferenceEntityDataFactory;
        this.recentRecipientEntityDataFactory = recentRecipientEntityDataFactory;
        this.cardCredentialEntityRepository = cardCredentialEntityRepository;
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<List<RecentRecipient>> getRecentRecipient(int i, int i2, int i3) {
        return Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda17
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RecentRecipientEntityRepository.this.m1734x70d7691d();
            }
        });
    }

    /* renamed from: lambda$getRecentRecipient$1$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1734x70d7691d() throws Exception {
        return getRecentRecipientFromUserConfig().map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda6()).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1733xa9cb821c((List) obj);
            }
        });
    }

    /* renamed from: lambda$getRecentRecipient$0$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1733xa9cb821c(List list) throws Exception {
        return filterRecentRecipient(list).map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda32());
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<List<RecentRecipient>> getRecentRecipientAll() {
        Observable<RecentRecipientEntity[]> recentRecipientFromUserConfig = getRecentRecipientFromUserConfig();
        final RecentRecipientEntityMapper recentRecipientEntityMapper = this.recentRecipientEntityMapper;
        Objects.requireNonNull(recentRecipientEntityMapper);
        Observable<R> map = recentRecipientFromUserConfig.map(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityMapper.this.toRecentRecipientEntity((RecentRecipientEntity[]) obj);
            }
        });
        RecentRecipientEntityMapper recentRecipientEntityMapper2 = this.recentRecipientEntityMapper;
        Objects.requireNonNull(recentRecipientEntityMapper2);
        return map.map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda5(recentRecipientEntityMapper2));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<List<RecentRecipient>> getSecureRecentRecipient(int i, int i2, int i3) {
        if (i2 == 2) {
            if (i3 == 0) {
                return getSecureRecentRecipientFromUserConfig().map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda31(this)).map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda32());
            }
            return getRecentSplitBillPayer(i);
        } else if (i2 == 1) {
            if (i3 == 0) {
                return getSecureRecentRecipientFromUserConfig().map(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        List filterRecentBankOnly;
                        filterRecentBankOnly = RecentRecipientEntityRepository.this.filterRecentBankOnly((RecentRecipientEntity[]) obj);
                        return filterRecentBankOnly;
                    }
                }).map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda32());
            }
            return getRecentSplitBillPayer(i);
        } else {
            return Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return RecentRecipientEntityRepository.this.m1738x6f8f5628();
                }
            });
        }
    }

    /* renamed from: lambda$getSecureRecentRecipient$3$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1738x6f8f5628() throws Exception {
        return getSecureRecentRecipientFromUserConfig().map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda6()).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1737xa8836f27((List) obj);
            }
        });
    }

    /* renamed from: lambda$getSecureRecentRecipient$2$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1737xa8836f27(List list) throws Exception {
        return filterRecentRecipient(list).map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda32());
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<List<RecentRecipient>> getRecentTransaction(final String str) {
        return getMaxRecentRecipient().flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1735xdaad50a6(str, (Integer) obj);
            }
        });
    }

    /* renamed from: lambda$getRecentTransaction$5$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1735xdaad50a6(String str, final Integer num) throws Exception {
        return createRecentRecipientEntityData().getRecentRecipient(str).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource just;
                just = Observable.just(RecentRecipientEntityExtKt.filterAndSortRecentTransaction((List) obj, num.intValue()));
                return just;
            }
        }).map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda32());
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> saveRecentBank(RecentBankRecipient recentBankRecipient, boolean z) {
        incTransactionCount(recentBankRecipient, z);
        setLastUpdatedTime(recentBankRecipient, z);
        return Observable.just(this.recentBankMapper.getMaskingData(recentBankRecipient)).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1745x1dd2f76f((RecentBankRecipient) obj);
            }
        });
    }

    /* renamed from: lambda$saveRecentBank$7$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1745x1dd2f76f(RecentBankRecipient recentBankRecipient) throws Exception {
        return createRecentRecipientEntityData().saveRecentRecipient(RecentRecipientMapperKt.toRecentRecipientEntity(recentBankRecipient)).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1744x56c7106e((Long) obj);
            }
        });
    }

    /* renamed from: lambda$saveRecentBank$6$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1744x56c7106e(Long l) throws Exception {
        return createRecentRecipientEntityData().getRecentRecipient().flatMap(new RecentRecipientEntityRepository$$ExternalSyntheticLambda0(this));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> removeRecentBank(RecentBankRecipient recentBankRecipient) {
        return createRecentRecipientEntityData().removeRecentBank(this.recentBankMapper.apply((RecentBankMapper) recentBankRecipient)).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda30
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1741x11c4f8b7((Integer) obj);
            }
        });
    }

    /* renamed from: lambda$removeRecentBank$8$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1741x11c4f8b7(Integer num) throws Exception {
        return createRecentRecipientEntityData().getRecentRecipient().flatMap(new RecentRecipientEntityRepository$$ExternalSyntheticLambda0(this));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> removeRecentContact(RecentContactRecipient recentContactRecipient) {
        return createRecentRecipientEntityData().removeRecentRecipient(RecentRecipientMapperKt.toRecentRecipientEntity(recentContactRecipient)).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1742x4dc1964((Integer) obj);
            }
        });
    }

    /* renamed from: lambda$removeRecentContact$9$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1742x4dc1964(Integer num) throws Exception {
        return createRecentRecipientEntityData().getRecentRecipient().flatMap(new RecentRecipientEntityRepository$$ExternalSyntheticLambda0(this));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> removeRecentRecipient(RecentRecipient recentRecipient) {
        return createRecentRecipientEntityData().removeRecentRecipient(RecentRecipientMapperKt.toRecentRecipientEntity(recentRecipient)).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1743xe9ac8671((Integer) obj);
            }
        });
    }

    /* renamed from: lambda$removeRecentRecipient$10$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1743xe9ac8671(Integer num) throws Exception {
        return createRecentRecipientEntityData().getRecentRecipient().flatMap(new RecentRecipientEntityRepository$$ExternalSyntheticLambda0(this));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> saveRecentContact(RecentContactRecipient recentContactRecipient, boolean z) {
        incTransactionCount(recentContactRecipient, z);
        setLastUpdatedTime(recentContactRecipient, z);
        return createRecentRecipientEntityData().saveRecentRecipient(RecentRecipientMapperKt.toRecentRecipientEntity(recentContactRecipient)).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1746xde586144((Long) obj);
            }
        });
    }

    /* renamed from: lambda$saveRecentContact$11$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1746xde586144(Long l) throws Exception {
        return createRecentRecipientEntityData().getRecentRecipient().flatMap(new RecentRecipientEntityRepository$$ExternalSyntheticLambda0(this));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<List<RecentBank>> getRecentBank(String str) {
        return Observable.zip(getRecents(str), getSortingSendMoney(), new BiFunction() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return RecentRecipientEntityExtKt.sortingRecentBanks((List) obj, (String) obj2);
            }
        });
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> migrateRecentRecipientConfigToRoom() {
        return getSecureRecentRecipientFromUserConfig().flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1740xaf243809((RecentRecipientEntity[]) obj);
            }
        });
    }

    /* renamed from: lambda$migrateRecentRecipientConfigToRoom$13$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1740xaf243809(RecentRecipientEntity[] recentRecipientEntityArr) throws Exception {
        if (this.generalPreferences.isRecentRecipientMigratedToRoom()) {
            return Observable.just(Boolean.TRUE);
        }
        if (recentRecipientEntityArr.length > 0) {
            return createRecentRecipientEntityData().saveRecentRecipient(Arrays.asList(recentRecipientEntityArr)).map(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda29
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RecentRecipientEntityRepository.this.m1739xe8185108((Long[]) obj);
                }
            });
        }
        return Observable.just(Boolean.FALSE);
    }

    /* renamed from: lambda$migrateRecentRecipientConfigToRoom$12$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ Boolean m1739xe8185108(Long[] lArr) throws Exception {
        return Boolean.valueOf(this.generalPreferences.setIsRecentRecipientMigratedToRoom(true));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<RecentRecipient> convertCardIndexNo(final RecentRecipient recentRecipient) {
        return splitConfigEntityData().isEncryptCardEnabled().flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1731xd2a0a4e7(recentRecipient, (Boolean) obj);
            }
        });
    }

    /* renamed from: lambda$convertCardIndexNo$16$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1731xd2a0a4e7(final RecentRecipient recentRecipient, final Boolean bool) throws Exception {
        return getCardCredentialPublicKey().flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1729x4488d6e5(recentRecipient, bool, (String) obj);
            }
        }).map(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1730xb94bde6(recentRecipient, (BankCardConversionResult) obj);
            }
        });
    }

    /* renamed from: lambda$convertCardIndexNo$14$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1729x4488d6e5(RecentRecipient recentRecipient, Boolean bool, String str) throws Exception {
        return createBankCardConversionData().convertCardIndexNo(recentRecipient, str, bool.booleanValue());
    }

    /* renamed from: lambda$convertCardIndexNo$15$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ RecentRecipient m1730xb94bde6(RecentRecipient recentRecipient, BankCardConversionResult bankCardConversionResult) throws Exception {
        return this.bankCardConversionMapper.transform(recentRecipient, bankCardConversionResult);
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> storeSecureUserConfig(List<RecentRecipient> list) {
        return this.userConfigRepository.saveUserSpecificConfig(new SecureRecentRecipientStoreConfig((UserConfigRecentRecipientEntity[]) SecureRecentRecipientStoreConfigKt.toUserConfigList(RecentRecipientMapperKt.toRecentRecipientEntityList(list)).toArray(new UserConfigRecentRecipientEntity[0])));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> storeUserConfig(List<RecentRecipient> list) {
        return this.userConfigRepository.saveUserSpecificConfig(new RecentRecipientStoreConfig((UserConfigRecentRecipientEntity[]) SecureRecentRecipientStoreConfigKt.toUserConfigList(RecentRecipientMapperKt.toRecentRecipientEntityList(list)).toArray(new UserConfigRecentRecipientEntity[0])));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> storeLocalSecureUserConfig(List<RecentRecipient> list) {
        return createRecentRecipientEntityData().saveRecentRecipient(RecentRecipientMapperKt.toRecentRecipientEntityList(list)).map(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean bool;
                Long[] lArr = (Long[]) obj;
                bool = Boolean.TRUE;
                return bool;
            }
        });
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Integer> getMaxRecentRecipient() {
        return splitConfigEntityData().getMaxRecentRecipient();
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Integer> getMaxSavedBank() {
        return splitConfigEntityData().getMaxSavedBank();
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Integer> getMaxFavoriteAccount() {
        return splitConfigEntityData().getMaxFavoriteAccount();
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<List<RecentRecipient>> getRecentContact() {
        Observable<R> map = getSecureRecentRecipientFromUserConfig().map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda31(this));
        RecentRecipientEntityMapper recentRecipientEntityMapper = this.recentRecipientEntityMapper;
        Objects.requireNonNull(recentRecipientEntityMapper);
        return map.map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda5(recentRecipientEntityMapper));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<List<RecentRecipient>> getRecentGroup(String str) {
        return createRecentRecipientEntityData().getRecentGroup(str).map(new RecentRecipientEntityRepository$$ExternalSyntheticLambda32());
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> saveRecentGroup(RecentRecipient recentRecipient, boolean z) {
        incTransactionCount(recentRecipient, z);
        setLastUpdatedTime(recentRecipient, z);
        return createRecentRecipientEntityData().saveRecentRecipient(RecentRecipientMapperKt.toRecentRecipientEntity(recentRecipient)).flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1747xd1b77cc((Long) obj);
            }
        });
    }

    /* renamed from: lambda$saveRecentGroup$18$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1747xd1b77cc(Long l) throws Exception {
        return createRecentRecipientEntityData().getRecentRecipient().flatMap(new RecentRecipientEntityRepository$$ExternalSyntheticLambda0(this));
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Integer> getFavoriteAccountCount() {
        return createRecentRecipientEntityData().getFavoriteAccountCount();
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> getGroupFavoriteValue(String str) {
        return createRecentRecipientEntityData().getGroupFavoriteValue(str);
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<RecentRecipient> getLeastTransactionFavoriteAccount() {
        return createRecentRecipientEntityData().getLeastTransactionFavoriteAccount().map(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientMapperKt.toRecentRecipient((RecentRecipientEntity) obj);
            }
        });
    }

    @Override // id.dana.domain.recentrecipient.repository.RecentRecipientRepository
    public Observable<Boolean> getIsRecentRecipientMigratedToRoom() {
        return Observable.just(Boolean.valueOf(this.generalPreferences.isRecentRecipientMigratedToRoom()));
    }

    private Observable<List<RecentBank>> getRecents(final String str) {
        return getMaxSavedBank().flatMap(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientEntityRepository.this.m1736x18a0db8(str, (Integer) obj);
            }
        });
    }

    /* renamed from: lambda$getRecents$19$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ ObservableSource m1736x18a0db8(String str, Integer num) throws Exception {
        Observable<List<SecureRecentBankEntity>> recentBank = createRecentRecipientEntityData().getRecentBank(str, num.intValue());
        final RecentBankEntityMapper recentBankEntityMapper = this.recentBankEntityMapper;
        Objects.requireNonNull(recentBankEntityMapper);
        return recentBank.map(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentBankEntityMapper.this.apply((List) obj);
            }
        });
    }

    private SecurityEntityData createSecurityData() {
        return this.securityEntityDataFactory.createData2("network");
    }

    private Observable<String> getCardCredentialPublicKey() {
        return this.cardCredentialEntityRepository.getCardCredentialPublicKey();
    }

    private AccountEntityData createAccountData() {
        return this.accountEntityDataFactory.createData2("local");
    }

    private Observable<List<RecentRecipient>> getRecentSplitBillPayer(int i) {
        Observable<List<RecentPayerSplitBillEntity>> recentPayers = createRecentPayerEntityData().getRecentPayers(i);
        final RecentRecipientPayerEntityMapper recentRecipientPayerEntityMapper = this.recentRecipientPayerEntityMapper;
        Objects.requireNonNull(recentRecipientPayerEntityMapper);
        Observable<R> map = recentPayers.map(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda27
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientPayerEntityMapper.this.apply((List) obj);
            }
        });
        final RecentRecipientContactEntityMapper recentRecipientContactEntityMapper = this.recentRecipientContactEntityMapper;
        Objects.requireNonNull(recentRecipientContactEntityMapper);
        return map.map(new Function() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda28
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentRecipientContactEntityMapper.this.apply((List) obj);
            }
        });
    }

    public Observable<Boolean> saveRecentRecipient(List<RecentRecipientEntity> list) {
        return this.userConfigRepository.saveUserSpecificConfig(new SecureRecentRecipientStoreConfig((UserConfigRecentRecipientEntity[]) SecureRecentRecipientStoreConfigKt.toUserConfigList(list).toArray(new UserConfigRecentRecipientEntity[0])));
    }

    private Observable<List<RecentRecipientEntity>> filterRecentRecipient(final List<RecentRecipientEntity> list) {
        return Observable.zip(getMaxRecentBank(), getMaxRecentContact(), new BiFunction() { // from class: id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return RecentRecipientEntityRepository.this.m1732xea532984(list, (Integer) obj, (Integer) obj2);
            }
        });
    }

    /* renamed from: lambda$filterRecentRecipient$20$id-dana-data-recentrecipient-repository-RecentRecipientEntityRepository */
    public /* synthetic */ List m1732xea532984(List list, Integer num, Integer num2) throws Exception {
        return filterRecipientWithDifferentMaxValue(list, num2.intValue(), num.intValue());
    }

    private Observable<Integer> getMaxRecentBank() {
        return splitConfigEntityData().getMaxRecentBank();
    }

    private Observable<Integer> getMaxRecentContact() {
        return splitConfigEntityData().getMaxRecentContact();
    }

    public List<RecentRecipientEntity> getContactOnly(RecentRecipientEntity[] recentRecipientEntityArr) {
        ArrayList arrayList = new ArrayList();
        for (RecentRecipientEntity recentRecipientEntity : recentRecipientEntityArr) {
            if (recentRecipientEntity.getType() == 0) {
                arrayList.add(recentRecipientEntity);
            }
        }
        return arrayList;
    }

    private void incTransactionCount(RecentRecipient recentRecipient, boolean z) {
        String id2;
        if (recentRecipient.getType() == 1) {
            id2 = recentRecipient.getCardIndexNo();
        } else {
            id2 = recentRecipient.getId();
        }
        int intValue = createRecentRecipientEntityData().getRecentRecipientTransactionCount(id2).blockingFirst().intValue();
        if (z) {
            recentRecipient.setTransactionCount(intValue);
        } else {
            recentRecipient.setTransactionCount(intValue + 1);
        }
    }

    private void setLastUpdatedTime(RecentRecipient recentRecipient, boolean z) {
        String id2;
        if (recentRecipient.getType() == 1) {
            id2 = recentRecipient.getCardIndexNo();
        } else {
            id2 = recentRecipient.getId();
        }
        long longValue = createRecentRecipientEntityData().getLastUpdatedTime(id2).blockingFirst().longValue();
        if (z) {
            recentRecipient.setLastUpdated(longValue);
        } else {
            recentRecipient.setLastUpdated(DateTimeUtil.getCurrentTimeMillis());
        }
    }

    public List<RecentRecipientEntity> filterRecentBankOnly(RecentRecipientEntity[] recentRecipientEntityArr) {
        ArrayList arrayList = new ArrayList();
        for (RecentRecipientEntity recentRecipientEntity : recentRecipientEntityArr) {
            if (1 == recentRecipientEntity.getType()) {
                arrayList.add(recentRecipientEntity);
            }
        }
        return arrayList;
    }

    private List<RecentRecipientEntity> filterRecipientWithDifferentMaxValue(List<RecentRecipientEntity> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        for (RecentRecipientEntity recentRecipientEntity : list) {
            if (i3 == i2 && i4 == i) {
                break;
            } else if (recentRecipientEntity.getType() == 1 && i3 < i2) {
                arrayList.add(recentRecipientEntity);
                i3++;
            } else if (recentRecipientEntity.getType() == 0 && i4 < i) {
                arrayList.add(recentRecipientEntity);
                i4++;
            }
        }
        return arrayList;
    }

    private Observable<RecentRecipientEntity[]> getSecureRecentRecipientFromUserConfig() {
        return this.userConfigRepository.getUserSpecificConfig(this.recentSecureRecipientQueryConfig).onErrorResumeNext(getRecentRecipientFromUserConfig());
    }

    private Observable<RecentRecipientEntity[]> getRecentRecipientFromUserConfig() {
        return this.userConfigRepository.getUserSpecificConfig(this.recentRecipientQueryConfig).onErrorReturnItem(new RecentRecipientEntity[0]);
    }

    private ConfigEntityData splitConfigEntityData() {
        return this.configEntityDataFactory.createData2("split");
    }

    private RecentPayerEntityData createRecentPayerEntityData() {
        return this.recentPayerEntityDataFactory.createData2("local");
    }

    private RecentRecipientEntityData createRecentRecipientEntityData() {
        return this.recentRecipientEntityDataFactory.createData2("local");
    }

    private BankCardConversionEntityData createBankCardConversionData() {
        return this.bankCardConversionFactory.createData2("network");
    }

    private Observable<String> getSortingSendMoney() {
        return createPreferenceSortingSendMoneyEntityData().getSortingSendMoney();
    }

    private PreferenceSortingSendMoneyEntityData createPreferenceSortingSendMoneyEntityData() {
        return this.sortingSendMoneyPreferenceEntityDataFactory.createData2("local");
    }
}
