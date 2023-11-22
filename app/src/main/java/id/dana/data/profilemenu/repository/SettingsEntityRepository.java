package id.dana.data.profilemenu.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.profilemenu.mapper.SettingsMapper;
import id.dana.data.profilemenu.model.ProfileNewFlagStoreConfig;
import id.dana.data.profilemenu.model.SettingEntity;
import id.dana.data.profilemenu.repository.source.PaymentAuthenticationEntityData;
import id.dana.data.profilemenu.repository.source.SettingsEntityData;
import id.dana.data.profilemenu.repository.source.SettingsEntityDataFactory;
import id.dana.data.profilemenu.repository.source.local.SettingPreference;
import id.dana.data.profilemenu.repository.source.network.PaymentAuthenticationDataFactory;
import id.dana.data.profilemenu.repository.source.network.result.PaymentSecurityInitResult;
import id.dana.data.profilemenu.settingconfig.ProfileSettingConfigurator;
import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.model.PaymentSecurityInit;
import id.dana.domain.profilemenu.model.PaymentSecuritySwitch;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.model.UserConfigProfileNewFlag;
import id.dana.domain.profilemenu.settingconfig.RawSettingJsonMapper;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.domain.userconfig.model.QueryConfig;
import id.dana.domain.verifytoken.TokenBizScene;
import id.dana.domain.verifytoken.VerifyTokenRepository;
import id.dana.network.response.profilemenu.PaymentSecuritySwitchResult;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SettingsEntityRepository implements SettingRepository {
    private final AccountEntityDataFactory accountEntityDataFactory;
    private final PaymentAuthenticationDataFactory paymentAuthenticationDataFactory;
    private final SettingPreference settingPreference;
    private final SettingsEntityDataFactory settingsEntityDataFactory;
    private final SettingsMapper settingsMapper;
    private final UserConfigEntityRepository userConfigEntityRepository;
    private final VerifyTokenRepository verifyTokenRepository;

    @Inject
    public SettingsEntityRepository(SettingsEntityDataFactory settingsEntityDataFactory, PaymentAuthenticationDataFactory paymentAuthenticationDataFactory, AccountEntityDataFactory accountEntityDataFactory, VerifyTokenRepository verifyTokenRepository, SettingsMapper settingsMapper, UserConfigEntityRepository userConfigEntityRepository, SettingPreference settingPreference) {
        this.settingsEntityDataFactory = settingsEntityDataFactory;
        this.paymentAuthenticationDataFactory = paymentAuthenticationDataFactory;
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.verifyTokenRepository = verifyTokenRepository;
        this.settingsMapper = settingsMapper;
        this.userConfigEntityRepository = userConfigEntityRepository;
        this.settingPreference = settingPreference;
    }

    private Observable<LinkedHashMap<String, LinkedHashMap<String, SettingModel>>> getUnfilteredSettings(String str) {
        Observable flatMap = getSettingCollection(str).map(getSettingCategories()).flatMap(getSettingsByKey());
        final SettingsMapper settingsMapper = this.settingsMapper;
        Objects.requireNonNull(settingsMapper);
        return flatMap.map(new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsMapper.this.transform((LinkedHashMap) obj);
            }
        });
    }

    private Function<LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>, ObservableSource<? extends LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>>> getSettingsByKey() {
        return new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1595x42d222a2((LinkedHashMap) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSettingsByKey$0$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1595x42d222a2(LinkedHashMap linkedHashMap) throws Exception {
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            for (Map.Entry entry2 : ((LinkedHashMap) entry.getValue()).entrySet()) {
                SettingModel blockingFirst = getSettingByKey((String) entry2.getKey()).blockingFirst();
                if (!blockingFirst.isNullObject()) {
                    ((LinkedHashMap) entry.getValue()).put((String) entry2.getKey(), SettingEntity.from(blockingFirst));
                } else {
                    ((LinkedHashMap) entry.getValue()).remove(entry2.getKey());
                }
            }
        }
        return Observable.just(linkedHashMap);
    }

    private Function<LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>, LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>> getSettingCategories() {
        return new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1591x35d387a((LinkedHashMap) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSettingCategories$1$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ LinkedHashMap m1591x35d387a(LinkedHashMap linkedHashMap) throws Exception {
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            LinkedHashMap<String, SettingEntity> blockingFirst = getSettingKeyByCategoryKey((String) entry.getKey()).blockingFirst();
            if (blockingFirst.isEmpty()) {
                ((LinkedHashMap) entry.getValue()).remove(entry.getKey());
            } else {
                entry.setValue(blockingFirst);
            }
        }
        return linkedHashMap;
    }

    public Observable<LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>> getSettingCollection(final String str) {
        return isSettingSplitNeedtoMigrate().flatMap(new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1592x3dc43757(str, (Boolean) obj);
            }
        }).onErrorResumeNext(defaultSettingOrderIsEmpty(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSettingCollection$2$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1592x3dc43757(String str, Boolean bool) throws Exception {
        return createSplitSettings().getSettingCollection(str);
    }

    private Observable<LinkedHashMap<String, SettingEntity>> getSettingKeyByCategoryKey(final String str) {
        return isSettingSplitNeedtoMigrate().flatMap(new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1594xdc835a9(str, (Boolean) obj);
            }
        }).onErrorResumeNext(createDefaultServices().getSettingKeyByCategoryKey(str)).onErrorReturnItem(new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSettingKeyByCategoryKey$3$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1594xdc835a9(String str, Boolean bool) throws Exception {
        return createSplitSettings().getSettingKeyByCategoryKey(str);
    }

    @Override // id.dana.domain.profilemenu.SettingRepository
    public Observable<PaymentSecurityInit> getPaymentSecurityInit() {
        Observable<PaymentSecurityInitResult> paymentSecurityInitResult = createPaymentAuthenticationEntityData().getPaymentSecurityInitResult();
        final SettingsMapper settingsMapper = this.settingsMapper;
        Objects.requireNonNull(settingsMapper);
        return paymentSecurityInitResult.map(new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsMapper.this.transform((PaymentSecurityInitResult) obj);
            }
        });
    }

    @Override // id.dana.domain.profilemenu.SettingRepository
    public Observable<PaymentSecuritySwitch> getPaymentSecuritySwitch(boolean z, String str, String str2, String str3, String str4) {
        return getPinWithVerifiedToken(z, str, str3).flatMap(getSecuritySwitchResult(z, str, str2, str4));
    }

    @Override // id.dana.domain.profilemenu.SettingRepository
    public Observable<List<SettingModel>> getSettings(List<SettingConfigurationRunner> list, String str, RawSettingJsonMapper rawSettingJsonMapper) {
        return getUnfilteredSettings(str).flatMap(filterSettingByRunningConfiguration(list, rawSettingJsonMapper));
    }

    @Override // id.dana.domain.profilemenu.SettingRepository
    public Observable<SettingModel> getSettingByKey(final String str) {
        return isSettingSplitNeedtoMigrate().flatMap(getSettingEntityByKey(str)).onErrorResumeNext(defaultSettingIsEmpty(str)).map(new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1590x184f4e79(str, (SettingEntity) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSettingByKey$4$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ SettingModel m1590x184f4e79(String str, SettingEntity settingEntity) throws Exception {
        return this.settingsMapper.transform(str, settingEntity);
    }

    @Override // id.dana.domain.profilemenu.SettingRepository
    public Observable<UserConfigProfileNewFlag> getUserConfigProfileNewFlag() {
        return this.userConfigEntityRepository.getUserSpecificConfig(new QueryConfig(UserConfigBizTypeConstant.CONFIG_ME_PAGE_NEW_FLAG, UserConfigProfileNewFlag.class));
    }

    @Override // id.dana.domain.profilemenu.SettingRepository
    public Observable<Boolean> saveUserConfigProfileNewFlag(UserConfigProfileNewFlag userConfigProfileNewFlag) {
        return this.userConfigEntityRepository.saveUserSpecificConfigBackendFirst(new ProfileNewFlagStoreConfig(userConfigProfileNewFlag));
    }

    @Override // id.dana.domain.profilemenu.SettingRepository
    public Observable<Long> getLastHideSettingRedDotTimestamp(String str) {
        return Observable.just(Long.valueOf(this.settingPreference.getLastRedDotHideTimestamp(str, getPhoneNumber().blockingFirst())));
    }

    @Override // id.dana.domain.profilemenu.SettingRepository
    public void saveLastHideSettingRedDotTimestamp(String str) {
        this.settingPreference.saveLastRedDotHideTimestamp(str, getPhoneNumber().blockingFirst());
    }

    private Observable<String> getPhoneNumber() {
        return createAccountEntityData().getPhoneNumber();
    }

    private Function<Boolean, ObservableSource<SettingEntity>> getSettingEntityByKey(final String str) {
        return new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1593xcf5def5b(str, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSettingEntityByKey$5$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1593xcf5def5b(String str, Boolean bool) throws Exception {
        return createSplitSettings().getSettingByKey(str);
    }

    private Function<String, ObservableSource<PaymentSecuritySwitch>> getSecuritySwitchResult(final boolean z, final String str, final String str2, final String str3) {
        return new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1589xaa169dde(z, str, str2, str3, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSecuritySwitchResult$6$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1589xaa169dde(boolean z, String str, String str2, String str3, String str4) throws Exception {
        Observable<PaymentSecuritySwitchResult> securitySwitchResult = createPaymentAuthenticationEntityData().getSecuritySwitchResult(z, str, str2, str4, str3);
        final SettingsMapper settingsMapper = this.settingsMapper;
        Objects.requireNonNull(settingsMapper);
        return securitySwitchResult.map(new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsMapper.this.transform((PaymentSecuritySwitchResult) obj);
            }
        });
    }

    private Observable<String> getPinWithVerifiedToken(boolean z, String str, String str2) {
        if (isAuthenticationTypePassword(z, str)) {
            return createAccountEntityData().getPhoneNumber().flatMap(getVerifyToken(str2));
        }
        return Observable.just(str2);
    }

    private boolean isAuthenticationTypePassword(boolean z, String str) {
        return !z && "PASSWORD".equals(str);
    }

    private Function<String, ObservableSource<String>> getVerifyToken(final String str) {
        return new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1596x82de0600(str, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getVerifyToken$7$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1596x82de0600(String str, String str2) throws Exception {
        return this.verifyTokenRepository.getPinWithVerifiedToken(str, str2, TokenBizScene.RISK_CHALLENGE);
    }

    private AccountEntityData createAccountEntityData() {
        return this.accountEntityDataFactory.createData2("local");
    }

    private Function<LinkedHashMap<String, LinkedHashMap<String, SettingModel>>, ObservableSource<List<SettingModel>>> filterSettingByRunningConfiguration(final List<SettingConfigurationRunner> list, final RawSettingJsonMapper rawSettingJsonMapper) {
        return new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource settings;
                settings = new ProfileSettingConfigurator(RawSettingJsonMapper.this, list).getSettings((LinkedHashMap) obj);
                return settings;
            }
        };
    }

    private SettingsEntityData createSplitSettings() {
        return this.settingsEntityDataFactory.createData2("split");
    }

    private Function<Throwable, Observable<LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>>> defaultSettingOrderIsEmpty(final String str) {
        return new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1588xc172bc4(str, (Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$defaultSettingOrderIsEmpty$9$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m1588xc172bc4(String str, Throwable th) throws Exception {
        return createDefaultServices().getSettingCollection(str);
    }

    private Observable<Boolean> isSettingSplitNeedtoMigrate() {
        return createSplitSettings().isSettingSplitNeedtoMigrate().onErrorResumeNext(createDefaultServices().isSettingSplitNeedtoMigrate());
    }

    private Function<Throwable, Observable<SettingEntity>> defaultSettingIsEmpty(final String str) {
        return new Function() { // from class: id.dana.data.profilemenu.repository.SettingsEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SettingsEntityRepository.this.m1587x75f163ce(str, (Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$defaultSettingIsEmpty$10$id-dana-data-profilemenu-repository-SettingsEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m1587x75f163ce(String str, Throwable th) throws Exception {
        return createDefaultServices().getSettingByKey(str);
    }

    private SettingsEntityData createDefaultServices() {
        return this.settingsEntityDataFactory.createData2("local");
    }

    private PaymentAuthenticationEntityData createPaymentAuthenticationEntityData() {
        return this.paymentAuthenticationDataFactory.createData2("network");
    }
}
