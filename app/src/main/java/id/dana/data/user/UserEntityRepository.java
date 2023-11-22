package id.dana.data.user;

import android.content.Context;
import dagger.Lazy;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.account.AccountEntity;
import id.dana.data.config.model.DanaHomeBalanceConfig;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.sharedpreference.SharedPrefSplitAttributes;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.data.holdlogin.HoldLoginUtils;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.homeinfo.model.KybEntity;
import id.dana.data.sendmoney.mapper.CurrencyAmountResultMapper;
import id.dana.data.user.source.UserEntityData;
import id.dana.data.user.source.UserInfoEntityDataFactory;
import id.dana.data.user.source.network.request.UserInfoRequest;
import id.dana.data.user.source.network.result.CheckUserInfoResponse;
import id.dana.data.user.source.network.result.MiniProgramUserInfoResult;
import id.dana.data.user.source.network.result.UserCohortResult;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import id.dana.data.user.source.persistence.UserInfoPreference;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.domain.user.MiniProgramUserInfoResponse;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* loaded from: classes2.dex */
public class UserEntityRepository implements UserRepository {
    private static final String LAST_FETCH_USER_INFO_FACE_AUTH = "last_fetch_user_info_face_auth";
    private static final String LAST_FETCH_USER_INFO_FULL = "last_fetch_user_info_full";
    private static final String LAST_FETCH_USER_INFO_KYC_INFO = "last_fetch_user_info_kyc_info";
    private static final String LAST_FETCH_USER_INFO_STATUS_INFO = "last_fetch_user_info_status_info";
    private static final String LAST_FETCH_USER_INFO_USER_PAN = "last_fetch_user_info_user_pan";
    public static final Long MINIMUM_FETCH_TIME_USER_INFO = Long.valueOf(TimeUnit.HOURS.toMillis(6));
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final Lazy<ConfigEntityDataFactory> configEntityDataFactory;
    private final Lazy<Context> context;
    private final Lazy<CurrencyAmountResultMapper> currencyAmountResultMapper;
    public DanaHomeBalanceConfigModel danaHomeBalanceConfigModelCache;
    private final Lazy<HoldLoginV1EntityRepository> holdLoginV1EntityRepository;
    private final Lazy<HomeWidgetRepository> homeWidgetRepository;
    private final Lazy<MixpanelRepository> mixpanelRepository;
    private final Lazy<SharedPrefSplitAttributes> sharedPrefSplitAttributes;
    private final Lazy<SharedPrefStartupConfig> sharedPrefStartupConfig;
    private final Lazy<UserInfoEntityDataFactory> userInfoEntityDataFactory;
    private final Lazy<UserInfoMapper> userInfoMapper;
    private final Lazy<UserInfoPreference> userInfoPreference;

    public static /* synthetic */ UserInfoRpcResult lambda$getNetworkUserInfoFull$1(UserInfoRpcResult userInfoRpcResult, Boolean bool) throws Exception {
        return userInfoRpcResult;
    }

    public static /* synthetic */ UserInfoRpcResult lambda$getNetworkUserInfoKyb$10(UserInfoRpcResult userInfoRpcResult, AccountEntity accountEntity) throws Exception {
        return userInfoRpcResult;
    }

    public static /* synthetic */ UserInfoRpcResult lambda$getNetworkUserInfoKyc$6(UserInfoRpcResult userInfoRpcResult, AccountEntity accountEntity) throws Exception {
        return userInfoRpcResult;
    }

    @Inject
    public UserEntityRepository(Lazy<UserInfoEntityDataFactory> lazy, Lazy<CurrencyAmountResultMapper> lazy2, Lazy<UserInfoMapper> lazy3, Lazy<ConfigEntityDataFactory> lazy4, Lazy<HoldLoginV1EntityRepository> lazy5, Lazy<UserInfoPreference> lazy6, Lazy<SharedPrefSplitAttributes> lazy7, Lazy<MixpanelRepository> lazy8, Lazy<SharedPrefStartupConfig> lazy9, Lazy<HomeWidgetRepository> lazy10, Lazy<Context> lazy11) {
        this.userInfoEntityDataFactory = lazy;
        this.currencyAmountResultMapper = lazy2;
        this.userInfoMapper = lazy3;
        this.configEntityDataFactory = lazy4;
        this.holdLoginV1EntityRepository = lazy5;
        this.userInfoPreference = lazy6;
        this.sharedPrefSplitAttributes = lazy7;
        this.mixpanelRepository = lazy8;
        this.sharedPrefStartupConfig = lazy9;
        this.homeWidgetRepository = lazy10;
        this.context = lazy11;
        createUserData().setQueryUserDataConfig(lazy9.get().getQueryUserDataConfig());
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<UserInfoResponse> getUserInfo(boolean z) {
        Observable<UserInfoRpcResult> cachedUserInfoApiCall = cachedUserInfoApiCall(new UserInfoApiCallParameter("FULL", LAST_FETCH_USER_INFO_FULL, z, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable localUserInfoFull;
                localUserInfoFull = UserEntityRepository.this.getLocalUserInfoFull();
                return localUserInfoFull;
            }
        }, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable networkUserInfoFull;
                networkUserInfoFull = UserEntityRepository.this.getNetworkUserInfoFull();
                return networkUserInfoFull;
            }
        }));
        UserInfoMapper userInfoMapper = this.userInfoMapper.get();
        Objects.requireNonNull(userInfoMapper);
        return cachedUserInfoApiCall.map(new UserEntityRepository$$ExternalSyntheticLambda42(userInfoMapper));
    }

    public Observable<UserInfoRpcResult> getLocalUserInfoFull() {
        return createLocalUserData().getUserInfo();
    }

    public Observable<UserInfoRpcResult> getNetworkUserInfoFull() {
        createUserData().setQueryUserDataConfig(this.sharedPrefStartupConfig.get().getQueryUserDataConfig());
        return this.holdLoginV1EntityRepository.get().authenticatedRequest(createUserData().getUserInfo()).doOnNext(new Consumer() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserEntityRepository.lambda$getNetworkUserInfoFull$0((UserInfoRpcResult) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2083x4fc2c95b((UserInfoRpcResult) obj);
            }
        });
    }

    public static /* synthetic */ void lambda$getNetworkUserInfoFull$0(UserInfoRpcResult userInfoRpcResult) throws Exception {
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("getUserInfo", "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log("getUserInfo");
    }

    /* renamed from: lambda$getNetworkUserInfoFull$2$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ ObservableSource m2083x4fc2c95b(final UserInfoRpcResult userInfoRpcResult) throws Exception {
        return this.holdLoginV1EntityRepository.get().createAccountData().updateAccount(userInfoRpcResult.getNickname(), userInfoRpcResult.getUsername(), userInfoRpcResult.getAvatarUrl(), userInfoRpcResult.getKycLevel()).map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.lambda$getNetworkUserInfoFull$1(UserInfoRpcResult.this, (Boolean) obj);
            }
        });
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<Map<String, String>> checkUserInfo(String str, String str2, String str3) {
        return createUserData().checkUserInfo(str, str2, str3).map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((CheckUserInfoResponse) obj).getUserInfo();
            }
        });
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<MiniProgramUserInfoResponse> getMiniProgramUserInfo(String str, String str2) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.get().authenticatedRequest(createUserData().getMiniProgramUserInfo(str, str2));
        final UserInfoMapper userInfoMapper = this.userInfoMapper.get();
        Objects.requireNonNull(userInfoMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda39
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserInfoMapper.this.transform((MiniProgramUserInfoResult) obj);
            }
        });
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<UserInfoResponse> getFaceAuthInfo(boolean z) {
        Observable<UserInfoRpcResult> cachedUserInfoApiCall = cachedUserInfoApiCall(new UserInfoApiCallParameter("FACE_AUTH", LAST_FETCH_USER_INFO_FACE_AUTH, z, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable localFaceAuthInfo;
                localFaceAuthInfo = UserEntityRepository.this.getLocalFaceAuthInfo();
                return localFaceAuthInfo;
            }
        }, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable networkFaceAuthInfo;
                networkFaceAuthInfo = UserEntityRepository.this.getNetworkFaceAuthInfo();
                return networkFaceAuthInfo;
            }
        }));
        UserInfoMapper userInfoMapper = this.userInfoMapper.get();
        Objects.requireNonNull(userInfoMapper);
        return cachedUserInfoApiCall.map(new UserEntityRepository$$ExternalSyntheticLambda42(userInfoMapper));
    }

    public Observable<UserInfoRpcResult> getLocalFaceAuthInfo() {
        return createLocalUserData().getFaceAuthInfo();
    }

    public Observable<UserInfoRpcResult> getNetworkFaceAuthInfo() {
        createUserData().setQueryUserDataConfig(this.sharedPrefStartupConfig.get().getQueryUserDataConfig());
        return this.holdLoginV1EntityRepository.get().authenticatedRequest(createUserData().getFaceAuthInfo());
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<CurrencyAmount> getBalance() {
        Observable<CurrencyAmount> balanceCacheFirst = getBalanceCacheFirst(true, new Runnable() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                UserEntityRepository.this.m2081lambda$getBalance$3$iddanadatauserUserEntityRepository();
            }
        });
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Objects.requireNonNull(compositeDisposable);
        return balanceCacheFirst.doOnDispose(new UserEntityRepository$$ExternalSyntheticLambda5(compositeDisposable));
    }

    /* renamed from: lambda$getBalance$3$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ void m2081lambda$getBalance$3$iddanadatauserUserEntityRepository() {
        this.compositeDisposable.getAuthRequestContext(getBalanceNetworkRepeat());
    }

    private Disposable getBalanceNetworkRepeat() {
        Observable map = this.holdLoginV1EntityRepository.get().authenticatedRequest(createUserData().getBalance()).repeatWhen(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda30
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource delay;
                delay = ((Observable) obj).delay(2L, TimeUnit.MINUTES);
                return delay;
            }
        }).map(new UserEntityRepository$$ExternalSyntheticLambda31());
        CurrencyAmountResultMapper currencyAmountResultMapper = this.currencyAmountResultMapper.get();
        Objects.requireNonNull(currencyAmountResultMapper);
        Observable map2 = map.map(new UserEntityRepository$$ExternalSyntheticLambda32(currencyAmountResultMapper));
        HomeWidgetRepository homeWidgetRepository = this.homeWidgetRepository.get();
        Objects.requireNonNull(homeWidgetRepository);
        return map2.doOnNext(new UserEntityRepository$$ExternalSyntheticLambda34(homeWidgetRepository)).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribe();
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<CurrencyAmount> getSingleBalance(boolean z) {
        Observable<CurrencyAmount> balanceCacheFirst = getBalanceCacheFirst(z, new Runnable() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                UserEntityRepository.this.m2086lambda$getSingleBalance$5$iddanadatauserUserEntityRepository();
            }
        });
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Objects.requireNonNull(compositeDisposable);
        return balanceCacheFirst.doOnDispose(new UserEntityRepository$$ExternalSyntheticLambda5(compositeDisposable));
    }

    /* renamed from: lambda$getSingleBalance$5$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ void m2086lambda$getSingleBalance$5$iddanadatauserUserEntityRepository() {
        this.compositeDisposable.getAuthRequestContext(getSingleBalanceNetwork());
    }

    private Observable<CurrencyAmount> getBalanceCacheFirst(boolean z, Runnable runnable) {
        if (z) {
            runnable.run();
        }
        return this.homeWidgetRepository.get().getBalanceFromPersistence();
    }

    private Disposable getSingleBalanceNetwork() {
        Observable map = this.holdLoginV1EntityRepository.get().authenticatedRequest(createUserData().getBalance()).map(new UserEntityRepository$$ExternalSyntheticLambda31());
        CurrencyAmountResultMapper currencyAmountResultMapper = this.currencyAmountResultMapper.get();
        Objects.requireNonNull(currencyAmountResultMapper);
        Observable map2 = map.map(new UserEntityRepository$$ExternalSyntheticLambda32(currencyAmountResultMapper));
        HomeWidgetRepository homeWidgetRepository = this.homeWidgetRepository.get();
        Objects.requireNonNull(homeWidgetRepository);
        return map2.doOnNext(new UserEntityRepository$$ExternalSyntheticLambda34(homeWidgetRepository)).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).ignoreElements().q_();
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<UserInfoResponse> getUserInfoWithKyc(boolean z) {
        Observable<UserInfoRpcResult> cachedUserInfoApiCall = cachedUserInfoApiCall(new UserInfoApiCallParameter(UserInfoRequest.KYC_INFO, LAST_FETCH_USER_INFO_KYC_INFO, z, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable localUserInfoKyc;
                localUserInfoKyc = UserEntityRepository.this.getLocalUserInfoKyc();
                return localUserInfoKyc;
            }
        }, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable networkUserInfoKyc;
                networkUserInfoKyc = UserEntityRepository.this.getNetworkUserInfoKyc();
                return networkUserInfoKyc;
            }
        }));
        Observable<AccountEntity> account = this.holdLoginV1EntityRepository.get().createAccountData().getAccount();
        final UserInfoMapper userInfoMapper = this.userInfoMapper.get();
        Objects.requireNonNull(userInfoMapper);
        Observable<UserInfoRpcResult> startWith = cachedUserInfoApiCall.startWith(account.map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserInfoMapper.this.transform((AccountEntity) obj);
            }
        }));
        UserInfoMapper userInfoMapper2 = this.userInfoMapper.get();
        Objects.requireNonNull(userInfoMapper2);
        return startWith.map(new UserEntityRepository$$ExternalSyntheticLambda42(userInfoMapper2));
    }

    public Observable<UserInfoRpcResult> getLocalUserInfoKyc() {
        return createLocalUserData().getInfoWithKyc();
    }

    public Observable<UserInfoRpcResult> getNetworkUserInfoKyc() {
        createUserData().setQueryUserDataConfig(this.sharedPrefStartupConfig.get().getQueryUserDataConfig());
        return this.holdLoginV1EntityRepository.get().authenticatedRequest(createUserData().getInfoWithKyc()).flatMap(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2085x382e592c((UserInfoRpcResult) obj);
            }
        });
    }

    /* renamed from: lambda$getNetworkUserInfoKyc$7$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ ObservableSource m2085x382e592c(final UserInfoRpcResult userInfoRpcResult) throws Exception {
        return this.holdLoginV1EntityRepository.get().createAccountData().saveUserInfoWithKyc(userInfoRpcResult).map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.lambda$getNetworkUserInfoKyc$6(UserInfoRpcResult.this, (AccountEntity) obj);
            }
        });
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<UserInfoResponse> getUserInfoForKyb(boolean z) {
        Observable<UserInfoRpcResult> cachedUserInfoApiCall = cachedUserInfoApiCall(new UserInfoApiCallParameter(UserInfoRequest.KYC_INFO, LAST_FETCH_USER_INFO_KYC_INFO, z, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable localUserInfoKyb;
                localUserInfoKyb = UserEntityRepository.this.getLocalUserInfoKyb();
                return localUserInfoKyb;
            }
        }, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable networkUserInfoKyb;
                networkUserInfoKyb = UserEntityRepository.this.getNetworkUserInfoKyb();
                return networkUserInfoKyb;
            }
        }));
        UserInfoMapper userInfoMapper = this.userInfoMapper.get();
        Objects.requireNonNull(userInfoMapper);
        return cachedUserInfoApiCall.map(new UserEntityRepository$$ExternalSyntheticLambda42(userInfoMapper));
    }

    public Observable<UserInfoRpcResult> getLocalUserInfoKyb() {
        final UserInfoRpcResult userInfoRpcResult = new UserInfoRpcResult();
        return this.holdLoginV1EntityRepository.get().createAccountData().getKybInfo().flatMap(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.lambda$getLocalUserInfoKyb$8(UserInfoRpcResult.this, (KybEntity) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource just;
                Throwable th = (Throwable) obj;
                just = Observable.just(UserInfoRpcResult.this);
                return just;
            }
        });
    }

    public static /* synthetic */ ObservableSource lambda$getLocalUserInfoKyb$8(UserInfoRpcResult userInfoRpcResult, KybEntity kybEntity) throws Exception {
        userInfoRpcResult.setKybInfo(kybEntity);
        return Observable.just(userInfoRpcResult);
    }

    public Observable<UserInfoRpcResult> getNetworkUserInfoKyb() {
        createUserData().setQueryUserDataConfig(this.sharedPrefStartupConfig.get().getQueryUserDataConfig());
        return this.holdLoginV1EntityRepository.get().authenticatedRequest(createUserData().getInfoWithKyc()).flatMap(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda35
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2084x24973548((UserInfoRpcResult) obj);
            }
        });
    }

    /* renamed from: lambda$getNetworkUserInfoKyb$11$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ ObservableSource m2084x24973548(final UserInfoRpcResult userInfoRpcResult) throws Exception {
        return this.holdLoginV1EntityRepository.get().createAccountData().saveUserInfoWithKyc(userInfoRpcResult).map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.lambda$getNetworkUserInfoKyb$10(UserInfoRpcResult.this, (AccountEntity) obj);
            }
        });
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<UserInfoResponse> getUserInfoWithUserPan() {
        return this.holdLoginV1EntityRepository.get().createAccountData().getAccount().flatMap(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda40
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2090xa8fd2bfa((AccountEntity) obj);
            }
        });
    }

    /* renamed from: lambda$getUserInfoWithUserPan$13$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ ObservableSource m2090xa8fd2bfa(final AccountEntity accountEntity) throws Exception {
        if (accountEntity.getUserPan().isEmpty() || DateTimeUtil.isPastToday(getLastUpdatedTimeUserPan().longValue())) {
            return getUserInfoWithUserPanFromNetwork(accountEntity);
        }
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda41
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UserEntityRepository.this.m2089x51df3b1b(accountEntity);
            }
        });
    }

    /* renamed from: lambda$getUserInfoWithUserPan$12$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ UserInfoResponse m2089x51df3b1b(AccountEntity accountEntity) throws Exception {
        return this.userInfoMapper.get().transformToUserInfoResponse(accountEntity);
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<UserInfoResponse> getUserInfoWithUserPanForCPM() {
        return this.holdLoginV1EntityRepository.get().createAccountData().getAccount().flatMap(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2092x2612a1af((AccountEntity) obj);
            }
        });
    }

    /* renamed from: lambda$getUserInfoWithUserPanForCPM$15$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ ObservableSource m2092x2612a1af(final AccountEntity accountEntity) throws Exception {
        if (accountEntity.getUserPan().isEmpty()) {
            return getUserInfoWithUserPanFromNetwork(accountEntity);
        }
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda45
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UserEntityRepository.this.m2091xcef4b0d0(accountEntity);
            }
        });
    }

    /* renamed from: lambda$getUserInfoWithUserPanForCPM$14$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ UserInfoResponse m2091xcef4b0d0(AccountEntity accountEntity) throws Exception {
        return this.userInfoMapper.get().transformToUserInfoResponse(accountEntity);
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<UserInfoResponse> getUserStatusInfo(boolean z) {
        Observable<UserInfoRpcResult> cachedUserInfoApiCall = cachedUserInfoApiCall(new UserInfoApiCallParameter(UserInfoRequest.STATUS_INFO, LAST_FETCH_USER_INFO_STATUS_INFO, z, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable localUserStatusInfo;
                localUserStatusInfo = UserEntityRepository.this.getLocalUserStatusInfo();
                return localUserStatusInfo;
            }
        }, new Function0() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable networkUserStatusInfo;
                networkUserStatusInfo = UserEntityRepository.this.getNetworkUserStatusInfo();
                return networkUserStatusInfo;
            }
        }));
        UserInfoMapper userInfoMapper = this.userInfoMapper.get();
        Objects.requireNonNull(userInfoMapper);
        return cachedUserInfoApiCall.map(new UserEntityRepository$$ExternalSyntheticLambda42(userInfoMapper));
    }

    public Observable<UserInfoRpcResult> getLocalUserStatusInfo() {
        return createLocalUserData().getUserStatusInfo();
    }

    public Observable<UserInfoRpcResult> getNetworkUserStatusInfo() {
        createUserData().setQueryUserDataConfig(this.sharedPrefStartupConfig.get().getQueryUserDataConfig());
        return this.holdLoginV1EntityRepository.get().authenticatedRequest(createUserData().getUserStatusInfo());
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<Boolean> isHomePersonalizedEnable() {
        return createConfigSplitEntityData().isHomePersonalizedEnable();
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<String> getHomeLandmarkUrl(final String str) {
        return createConfigSplitEntityData().getHomeLandmarkUrlMap().map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.lambda$getHomeLandmarkUrl$16(str, (Map) obj);
            }
        });
    }

    public static /* synthetic */ String lambda$getHomeLandmarkUrl$16(String str, Map map) throws Exception {
        String str2 = (String) map.get(str.toLowerCase());
        if (str2 == null) {
            str2 = (String) map.get("indonesia");
        }
        return str2 == null ? "" : str2;
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<Unit> getUserCohort() {
        return createUserData().getUserCohort().doOnNext(new Consumer() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserEntityRepository.this.m2087lambda$getUserCohort$17$iddanadatauserUserEntityRepository((UserCohortResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2088lambda$getUserCohort$18$iddanadatauserUserEntityRepository((UserCohortResult) obj);
            }
        });
    }

    /* renamed from: lambda$getUserCohort$17$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ void m2087lambda$getUserCohort$17$iddanadatauserUserEntityRepository(UserCohortResult userCohortResult) throws Exception {
        this.sharedPrefSplitAttributes.get().setUserCohort(userCohortResult.getSafeUserCohort());
        saveUserCohortToUserPropertiesMixpanel(userCohortResult.getSafeUserCohort());
    }

    /* renamed from: lambda$getUserCohort$18$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ Unit m2088lambda$getUserCohort$18$iddanadatauserUserEntityRepository(UserCohortResult userCohortResult) throws Exception {
        return createConfigSplitEntityData().saveAttribute("user_cohort", userCohortResult.getSafeUserCohort());
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<DanaHomeBalanceConfigModel> getDanaHomeBalanceConfig() {
        DanaHomeBalanceConfigModel danaHomeBalanceConfigModel = this.danaHomeBalanceConfigModelCache;
        if (danaHomeBalanceConfigModel != null) {
            return Observable.just(danaHomeBalanceConfigModel);
        }
        Observable<R> map = createConfigSplitEntityData().getDanaHomeBalanceConfig().map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.lambda$getDanaHomeBalanceConfig$19((DanaHomeBalanceConfig) obj);
            }
        });
        final SharedPrefSplitAttributes sharedPrefSplitAttributes = this.sharedPrefSplitAttributes.get();
        Objects.requireNonNull(sharedPrefSplitAttributes);
        Observable<DanaHomeBalanceConfigModel> doOnNext = map.doOnNext(new Consumer() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SharedPrefSplitAttributes.this.setDanaHomeBalanceConfigModel((DanaHomeBalanceConfigModel) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserEntityRepository.this.m2082xe247d0da((DanaHomeBalanceConfigModel) obj);
            }
        });
        DanaHomeBalanceConfigModel danaHomeBalanceConfigModel2 = this.sharedPrefSplitAttributes.get().getDanaHomeBalanceConfigModel();
        return danaHomeBalanceConfigModel2 != null ? Observable.concat(Observable.just(danaHomeBalanceConfigModel2), doOnNext) : doOnNext;
    }

    public static /* synthetic */ DanaHomeBalanceConfigModel lambda$getDanaHomeBalanceConfig$19(DanaHomeBalanceConfig danaHomeBalanceConfig) throws Exception {
        return new DanaHomeBalanceConfigModel(danaHomeBalanceConfig.getEnable(), danaHomeBalanceConfig.getLoopUntilInMillis(), danaHomeBalanceConfig.getDelayInMillis(), danaHomeBalanceConfig.getServices());
    }

    /* renamed from: lambda$getDanaHomeBalanceConfig$20$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ void m2082xe247d0da(DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) throws Exception {
        this.danaHomeBalanceConfigModelCache = danaHomeBalanceConfigModel;
    }

    @Override // id.dana.domain.user.repository.UserRepository
    public Observable<Boolean> checkUserInfoCacheExpired(String str) {
        final String preferenceKey = getPreferenceKey(str);
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda29
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UserEntityRepository.this.m2080xa8a443ea(preferenceKey);
            }
        });
    }

    /* renamed from: lambda$checkUserInfoCacheExpired$21$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ Boolean m2080xa8a443ea(String str) throws Exception {
        return Boolean.valueOf(isExceedMinimumUserInfoFetchTime(str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String getPreferenceKey(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case 2169487:
                if (str.equals("FULL")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 517433865:
                if (str.equals(UserInfoRequest.USER_PAN)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1044132426:
                if (str.equals("FACE_AUTH")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1253344792:
                if (str.equals(UserInfoRequest.KYC_INFO)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1290991835:
                if (str.equals(UserInfoRequest.STATUS_INFO)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        return c != 0 ? c != 1 ? c != 2 ? c != 3 ? c != 4 ? "" : LAST_FETCH_USER_INFO_STATUS_INFO : LAST_FETCH_USER_INFO_KYC_INFO : LAST_FETCH_USER_INFO_FACE_AUTH : LAST_FETCH_USER_INFO_USER_PAN : LAST_FETCH_USER_INFO_FULL;
    }

    private void saveUserCohortToUserPropertiesMixpanel(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TrackerDataKey.PeopleProperty.USER_COHORT, str);
        this.mixpanelRepository.get().setPeople(jSONObject);
    }

    private UserEntityData createUserData() {
        return this.userInfoEntityDataFactory.get().createData2("network");
    }

    private UserEntityData createLocalUserData() {
        return this.userInfoEntityDataFactory.get().createData2("local");
    }

    private Observable<UserInfoRpcResult> cachedUserInfoApiCall(final UserInfoApiCallParameter userInfoApiCallParameter) {
        return userInfoApiCallParameter.getLocalUserInfoApiCall().invoke().flatMap(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2078x33a25fa2(userInfoApiCallParameter, (UserInfoRpcResult) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserEntityRepository.this.m2079x8ac05081((UserInfoRpcResult) obj);
            }
        });
    }

    /* renamed from: lambda$cachedUserInfoApiCall$22$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ ObservableSource m2078x33a25fa2(UserInfoApiCallParameter userInfoApiCallParameter, UserInfoRpcResult userInfoRpcResult) throws Exception {
        if (isNeedBackendUpdate(userInfoRpcResult, userInfoApiCallParameter.getPreferenceKey(), userInfoApiCallParameter.getNeedBackendUpdate())) {
            return updateUserInfoIntoLocal(userInfoApiCallParameter.getQueryType(), userInfoApiCallParameter.getPreferenceKey(), userInfoRpcResult, userInfoApiCallParameter.getNetworkUserInfoApiCall().invoke());
        }
        return Observable.just(userInfoRpcResult);
    }

    /* renamed from: lambda$cachedUserInfoApiCall$23$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ void m2079x8ac05081(UserInfoRpcResult userInfoRpcResult) throws Exception {
        sendUserStatus(userInfoRpcResult.getLoginStatus(), userInfoRpcResult.getUserStatus());
    }

    void sendUserStatus(String str, String str2) {
        if ("SUSPENDED".equals(str)) {
            HoldLoginUtils.BuiltInFictitiousFunctionClassFactory(this.context.get(), "SUSPENDED");
        } else if ("FROZEN".equals(str2)) {
            HoldLoginUtils.BuiltInFictitiousFunctionClassFactory(this.context.get(), "FROZEN");
        }
    }

    private ObservableSource<UserInfoResponse> getUserInfoWithUserPanFromNetwork(final AccountEntity accountEntity) {
        createUserData().setQueryUserDataConfig(this.sharedPrefStartupConfig.get().getQueryUserDataConfig());
        return this.holdLoginV1EntityRepository.get().authenticatedRequest(createUserData().getUserInfoWithUserPan()).flatMap(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda28
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2095xfc622328(accountEntity, (UserInfoRpcResult) obj);
            }
        });
    }

    /* renamed from: lambda$getUserInfoWithUserPanFromNetwork$26$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ ObservableSource m2095xfc622328(final AccountEntity accountEntity, final UserInfoRpcResult userInfoRpcResult) throws Exception {
        return this.holdLoginV1EntityRepository.get().createAccountData().saveLastUpdatedTimeUserPan(System.currentTimeMillis()).flatMap(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda37
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2093x4e26416a(userInfoRpcResult, (Boolean) obj);
            }
        }).map(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda38
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2094xa5443249(accountEntity, (String) obj);
            }
        });
    }

    /* renamed from: lambda$getUserInfoWithUserPanFromNetwork$24$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ ObservableSource m2093x4e26416a(UserInfoRpcResult userInfoRpcResult, Boolean bool) throws Exception {
        return this.holdLoginV1EntityRepository.get().createAccountData().saveUserPan(userInfoRpcResult.getUserPan());
    }

    /* renamed from: lambda$getUserInfoWithUserPanFromNetwork$25$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ UserInfoResponse m2094xa5443249(AccountEntity accountEntity, String str) throws Exception {
        accountEntity.setUserPan(str);
        return this.userInfoMapper.get().transformToUserInfoResponse(accountEntity);
    }

    private Long getLastUpdatedTimeUserPan() {
        return this.holdLoginV1EntityRepository.get().createAccountData().getLastUpdatedTimeUserPan();
    }

    private Observable<UserInfoRpcResult> updateUserInfoIntoLocal(final String str, final String str2, final UserInfoRpcResult userInfoRpcResult, Observable<UserInfoRpcResult> observable) {
        return Observable.zip(observable, this.holdLoginV1EntityRepository.get().createAccountData().getUserId(), new BiFunction() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda43
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return UserEntityRepository.this.m2096x5b7d6789(str, str2, (UserInfoRpcResult) obj, (String) obj2);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.user.UserEntityRepository$$ExternalSyntheticLambda44
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEntityRepository.this.m2097xb29b5868(str, userInfoRpcResult, (Throwable) obj);
            }
        });
    }

    /* renamed from: lambda$updateUserInfoIntoLocal$27$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ UserInfoRpcResult m2096x5b7d6789(String str, String str2, UserInfoRpcResult userInfoRpcResult, String str3) throws Exception {
        updateUserInfoCacheAndSetLastFetchUserInfoTime(str, str2, userInfoRpcResult, str3);
        return userInfoRpcResult;
    }

    /* renamed from: lambda$updateUserInfoIntoLocal$28$id-dana-data-user-UserEntityRepository */
    public /* synthetic */ ObservableSource m2097xb29b5868(String str, UserInfoRpcResult userInfoRpcResult, Throwable th) throws Exception {
        UserInfoWorker.startWorker(this.context.get(), str);
        return checkGetLoginId(userInfoRpcResult, th);
    }

    private void updateUserInfoCacheAndSetLastFetchUserInfoTime(String str, String str2, UserInfoRpcResult userInfoRpcResult, String str3) {
        createLocalUserData().updateUserInfoCache(str, userInfoRpcResult, str3);
        this.userInfoPreference.get().setLastFetchUserInfo(str2, DateTimeUtil.getCurrentTimeMillis());
    }

    private boolean isExceedMinimumUserInfoFetchTime(String str) {
        long lastFetchUserInfo = this.userInfoPreference.get().getLastFetchUserInfo(str);
        return lastFetchUserInfo == -1 || getLastFetchTime(Long.valueOf(lastFetchUserInfo)).longValue() > MINIMUM_FETCH_TIME_USER_INFO.longValue();
    }

    private boolean isNeedBackendUpdate(UserInfoRpcResult userInfoRpcResult, String str, boolean z) {
        return userInfoRpcResult == null || isExceedMinimumUserInfoFetchTime(str) || z;
    }

    private Observable<UserInfoRpcResult> checkGetLoginId(UserInfoRpcResult userInfoRpcResult, Throwable th) {
        return userInfoRpcResult.getLoginId() != null ? Observable.just(userInfoRpcResult) : Observable.error(th);
    }

    private Long getLastFetchTime(Long l) {
        return Long.valueOf(System.currentTimeMillis() - l.longValue());
    }

    private ConfigEntityData createConfigSplitEntityData() {
        return this.configEntityDataFactory.get().createData2("split");
    }
}
