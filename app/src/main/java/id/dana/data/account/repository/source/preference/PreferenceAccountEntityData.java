package id.dana.data.account.repository.source.preference;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.TypeReference;
import dagger.Lazy;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.TransactionEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.base.UnInitializedSecuredPreferencesException;
import id.dana.data.foundation.RpcException;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.homeinfo.model.KybEntity;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.payasset.source.network.result.QueryPayMethodResult;
import id.dana.data.security.ClearCookieThrowable;
import id.dana.data.storage.Druther;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.twilio.repository.source.local.TwilioConsultBackendPreferences;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import j$.util.Optional;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

@Singleton
/* loaded from: classes2.dex */
public class PreferenceAccountEntityData implements AccountEntityData {
    private final Lazy<SecuredAccountPreferences> accountPreferences;
    private final Lazy<LoginLogoutSubject> loginLogoutSubject;
    private final Lazy<SecurityGuardFacade> securityGuardFacade;
    private final Lazy<TwilioConsultBackendPreferences> twilioConsultBackendPreferences;

    public static /* synthetic */ ObservableSource lambda$initAndRetry$26(Observable observable, Boolean bool) throws Exception {
        return observable;
    }

    @Inject
    public PreferenceAccountEntityData(Lazy<SecuredAccountPreferences> lazy, Lazy<SecurityGuardFacade> lazy2, Lazy<TwilioConsultBackendPreferences> lazy3, Lazy<LoginLogoutSubject> lazy4) {
        this.accountPreferences = lazy;
        this.securityGuardFacade = lazy2;
        this.twilioConsultBackendPreferences = lazy3;
        this.loginLogoutSubject = lazy4;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<Boolean> init(final String str) {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda30
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m763x9d53ef29(str);
            }
        });
    }

    /* renamed from: lambda$init$0$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ Boolean m763x9d53ef29(String str) throws Exception {
        this.accountPreferences.get().init(str);
        return Boolean.TRUE;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<Optional<String>> init() {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m764xa47cd16a();
            }
        });
    }

    /* renamed from: lambda$init$1$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ Optional m764xa47cd16a() throws Exception {
        String MyBillsEntityDataFactory = CommonUtil.MyBillsEntityDataFactory(this.securityGuardFacade.get(), null);
        if (TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            return Optional.MyBillsEntityDataFactory();
        }
        this.accountPreferences.get().init(MyBillsEntityDataFactory);
        this.loginLogoutSubject.get().setUserId(MyBillsEntityDataFactory);
        return Optional.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<Boolean> hasAccount() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return initObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(SecuredAccountPreferences.this.hasAccount());
            }
        }, Boolean.FALSE);
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<AccountEntity> getAccount() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return initObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda28
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getAccount();
            }
        }, new AccountEntity());
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Long getLastUpdatedTimeUserPan() {
        try {
            return Long.valueOf(this.accountPreferences.get().getLastUpdatedTimeUserPan());
        } catch (UnInitializedSecuredPreferencesException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PREFERENCE_ACCOUNT, e.getMessage());
            return 0L;
        }
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getUserId() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return initObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda37
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getUserId();
            }
        }, "");
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<AccountEntity> saveAccount(final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda21
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m766x7beae071(str, str2, str3, str4, str5, str6);
            }
        });
    }

    /* renamed from: lambda$saveAccount$2$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ AccountEntity m766x7beae071(String str, String str2, String str3, String str4, String str5, String str6) throws Exception {
        this.accountPreferences.get().saveAccount(str, str2, str3, str4, str5, str6);
        return this.accountPreferences.get().getAccount();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<Boolean> updateAccount(final String str, final String str2, final String str3, final String str4) {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda26
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m778x3f4f9926(str2, str, str3, str4);
            }
        });
    }

    /* renamed from: lambda$updateAccount$3$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ Boolean m778x3f4f9926(String str, String str2, String str3, String str4) throws Exception {
        AccountEntity account = this.accountPreferences.get().getAccount();
        if (account != null) {
            account.setUsername(str);
            account.setNickname(str2);
            account.setAvatarUrl(str3);
            account.setKycLevel(str4);
            this.accountPreferences.get().saveAccount(account);
        }
        return Boolean.TRUE;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getPhoneNumber() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return initObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getPhoneNumber();
            }
        }, "");
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getAvatarUrl() {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda29
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.lambda$getAvatarUrl$4((AccountEntity) obj);
            }
        }));
    }

    public static /* synthetic */ String lambda$getAvatarUrl$4(AccountEntity accountEntity) throws Exception {
        String avatarUrl = accountEntity.getAvatarUrl();
        return avatarUrl == null ? "" : avatarUrl;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> saveAvatarUrl(final String str) {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.this.m767x198622dd(str, (AccountEntity) obj);
            }
        }));
    }

    /* renamed from: lambda$saveAvatarUrl$5$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ String m767x198622dd(String str, AccountEntity accountEntity) throws Exception {
        accountEntity.setAvatarUrl(str);
        this.accountPreferences.get().saveAccount(accountEntity);
        return this.accountPreferences.get().getAccount().getAvatarUrl();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getNickname() {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.lambda$getNickname$6((AccountEntity) obj);
            }
        }));
    }

    public static /* synthetic */ String lambda$getNickname$6(AccountEntity accountEntity) throws Exception {
        String nickname = accountEntity.getNickname();
        return nickname == null ? "" : nickname;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> saveNickname(final String str) {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.this.m772x2bb3ffeb(str, (AccountEntity) obj);
            }
        }));
    }

    /* renamed from: lambda$saveNickname$7$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ String m772x2bb3ffeb(String str, AccountEntity accountEntity) throws Exception {
        accountEntity.setNickname(str);
        this.accountPreferences.get().saveAccount(accountEntity);
        return this.accountPreferences.get().getAccount().getNickname();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getUsername() {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda27
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((AccountEntity) obj).getUsername();
            }
        }));
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<AccountEntity> saveUserInfoWithKyc(final UserInfoRpcResult userInfoRpcResult) {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.this.m774xbfa69080(userInfoRpcResult, (AccountEntity) obj);
            }
        }));
    }

    /* renamed from: lambda$saveUserInfoWithKyc$8$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ AccountEntity m774xbfa69080(UserInfoRpcResult userInfoRpcResult, AccountEntity accountEntity) throws Exception {
        accountEntity.setPhoneMask(userInfoRpcResult.getLoginId());
        accountEntity.setNickname(userInfoRpcResult.getNickname());
        accountEntity.setAvatarUrl(userInfoRpcResult.getAvatarUrl());
        accountEntity.setKycLevel(userInfoRpcResult.getKycLevel());
        accountEntity.setUsername(userInfoRpcResult.getUsername());
        accountEntity.setKybInfo(getJsonStringKybInfo(userInfoRpcResult.getKybInfo()));
        this.accountPreferences.get().saveAccount(accountEntity);
        return this.accountPreferences.get().getAccount();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getKycLevel() {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.lambda$getKycLevel$9((AccountEntity) obj);
            }
        }));
    }

    public static /* synthetic */ String lambda$getKycLevel$9(AccountEntity accountEntity) throws Exception {
        return accountEntity.getKycLevel() == null ? "" : accountEntity.getKycLevel();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<KybEntity> getKybInfo() {
        return initializedRequest(getAccount().flatMap(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.this.m762xa3d73caa((AccountEntity) obj);
            }
        }));
    }

    /* renamed from: lambda$getKybInfo$10$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ ObservableSource m762xa3d73caa(AccountEntity accountEntity) throws Exception {
        KybEntity parseKybInfo = parseKybInfo(accountEntity.getKybInfo());
        if (parseKybInfo != null) {
            return Observable.just(parseKybInfo);
        }
        return Observable.error(new NullPointerException());
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> saveKycLevel(final String str) {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.this.m769xbc9d950b(str, (AccountEntity) obj);
            }
        }));
    }

    /* renamed from: lambda$saveKycLevel$11$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ String m769xbc9d950b(String str, AccountEntity accountEntity) throws Exception {
        accountEntity.setKycLevel(str);
        this.accountPreferences.get().saveAccount(accountEntity);
        return this.accountPreferences.get().getAccount().getKycLevel();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> saveUserPan(final String str) {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda35
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.this.m775xa1b7161d(str, (AccountEntity) obj);
            }
        }));
    }

    /* renamed from: lambda$saveUserPan$12$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ String m775xa1b7161d(String str, AccountEntity accountEntity) throws Exception {
        accountEntity.setUserPan(str);
        this.accountPreferences.get().saveAccount(accountEntity);
        return this.accountPreferences.get().getAccount().getUserPan();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<Boolean> saveLastUpdatedTimeUserPan(final long j) {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m771xe0f9583c(j);
            }
        });
    }

    /* renamed from: lambda$saveLastUpdatedTimeUserPan$13$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ Boolean m771xe0f9583c(long j) throws Exception {
        this.accountPreferences.get().saveLastUpdatedTimeUserPan(j);
        return Boolean.TRUE;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<Boolean> clearAll() {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda39
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m758x39162aa6();
            }
        }).doOnError(new Consumer() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda40
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PreferenceAccountEntityData.lambda$clearAll$15((Throwable) obj);
            }
        });
    }

    /* renamed from: lambda$clearAll$14$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ Boolean m758x39162aa6() throws Exception {
        this.accountPreferences.get().clearAll();
        this.twilioConsultBackendPreferences.get().BuiltInFictitiousFunctionClassFactory.clearAllData();
        return Boolean.TRUE;
    }

    public static /* synthetic */ void lambda$clearAll$15(Throwable th) throws Exception {
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        ClearCookieThrowable clearCookieThrowable = new ClearCookieThrowable(th);
        Intrinsics.checkNotNullParameter(clearCookieThrowable, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(clearCookieThrowable);
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<Boolean> isFirstTime() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return initObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.isFirstTime();
            }
        }, Boolean.FALSE);
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<Boolean> finishFirstTime() {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda31
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m759x51e8ab8c();
            }
        });
    }

    /* renamed from: lambda$finishFirstTime$16$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ Boolean m759x51e8ab8c() throws Exception {
        this.accountPreferences.get().finishFirstTime();
        return this.accountPreferences.get().isFirstTime();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> setOfflinePublicKey(final String str) {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda25
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m777x3576ebe2(str);
            }
        });
    }

    /* renamed from: lambda$setOfflinePublicKey$17$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ String m777x3576ebe2(String str) throws Exception {
        this.accountPreferences.get().setOfflinePublicKey(str);
        return this.accountPreferences.get().getOfflinePublicKey();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getOfflinePublicKey() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getOfflinePublicKey();
            }
        });
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> setCardCredentialPublicKey(final String str) {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m776xa59a0171(str);
            }
        });
    }

    /* renamed from: lambda$setCardCredentialPublicKey$18$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ String m776xa59a0171(String str) throws Exception {
        this.accountPreferences.get().setCardCredentialPublicKey(str);
        return this.accountPreferences.get().getCardCredentialPublicKey();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getCardCredentialPublicKey() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda23
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getCardCredentialPublicKey();
            }
        });
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getPhoneMask() {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.lambda$getPhoneMask$19((AccountEntity) obj);
            }
        }));
    }

    public static /* synthetic */ String lambda$getPhoneMask$19(AccountEntity accountEntity) throws Exception {
        String phoneMask = accountEntity.getPhoneMask();
        return phoneMask == null ? "" : phoneMask;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> savePhoneMask(final String str) {
        return initializedRequest(getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.this.m773x50ad1152(str, (AccountEntity) obj);
            }
        }));
    }

    /* renamed from: lambda$savePhoneMask$20$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ String m773x50ad1152(String str, AccountEntity accountEntity) throws Exception {
        accountEntity.setPhoneMask(str);
        this.accountPreferences.get().saveAccount(accountEntity);
        return this.accountPreferences.get().getAccount().getPhoneMask();
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getUUID() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda20
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getUUID();
            }
        });
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public String getUUIDAsString() {
        try {
            return this.accountPreferences.get().getUUID();
        } catch (UnInitializedSecuredPreferencesException unused) {
            return null;
        }
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<AccountEntity> getDrutherDataForUpdate(final Context context) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m761xa932617a(context);
            }
        });
    }

    /* renamed from: lambda$getDrutherDataForUpdate$21$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ AccountEntity m761xa932617a(Context context) throws Exception {
        String MyBillsEntityDataFactory = CommonUtil.MyBillsEntityDataFactory(this.securityGuardFacade.get(), null);
        if (TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            throw null;
        }
        Druther buildDruther = new LocalStorageFactory.Builder(context).setPreferenceGroup(SecuredAccountPreferences.SECURED_ACCOUNT_PREFERENCES).setPassword(MyBillsEntityDataFactory).buildDruther();
        AccountEntity accountEntity = (AccountEntity) buildDruther.getObject(SecuredAccountPreferences.Key.ACCOUNT, AccountEntity.class);
        buildDruther.clearAllData();
        return accountEntity;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<QueryPayMethodResult> getPayMethod() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return initObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda36
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getPayMethod();
            }
        }, new QueryPayMethodResult());
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<QueryPayMethodResult> queryAsset() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return initObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getAssetCardResult();
            }
        }, new QueryPayMethodResult());
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<Boolean> saveLastTransaction(final TransactionEntity transactionEntity) {
        return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda34
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.this.m770xe737f726(transactionEntity);
            }
        });
    }

    /* renamed from: lambda$saveLastTransaction$22$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ Boolean m770xe737f726(TransactionEntity transactionEntity) throws Exception {
        this.accountPreferences.get().saveLastTransaction(transactionEntity);
        return Boolean.TRUE;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<TransactionEntity> getLatestTransaction() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return initObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda15
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getLatestTransaction();
            }
        }, new TransactionEntity());
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public String getLastChallengeSid() {
        String string = this.twilioConsultBackendPreferences.get().BuiltInFictitiousFunctionClassFactory.getString("LAST_CHALLENGE_SID");
        return string == null ? "" : string;
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Boolean setLastChallengeSid(String str) {
        return Boolean.valueOf(this.twilioConsultBackendPreferences.get().PlaceComponentResult(str));
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> getClientKey() {
        final SecuredAccountPreferences securedAccountPreferences = this.accountPreferences.get();
        Objects.requireNonNull(securedAccountPreferences);
        return initObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda17
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SecuredAccountPreferences.this.getClientKey();
            }
        }, CommonUtil.PlaceComponentResult(this.securityGuardFacade.get(), "")).onErrorReturn(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.this.m760xf5e2623a((Throwable) obj);
            }
        });
    }

    /* renamed from: lambda$getClientKey$23$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ String m760xf5e2623a(Throwable th) throws Exception {
        return CommonUtil.PlaceComponentResult(this.securityGuardFacade.get(), "");
    }

    @Override // id.dana.data.account.repository.source.AccountEntityData
    public Observable<String> saveClientKey(final String str) {
        if (!TextUtils.isEmpty(str)) {
            return unsafeInitObservable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda32
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PreferenceAccountEntityData.this.m768xb5fe387c(str);
                }
            });
        }
        return Observable.just("");
    }

    /* renamed from: lambda$saveClientKey$24$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ String m768xb5fe387c(String str) throws Exception {
        CommonUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.securityGuardFacade.get(), str);
        this.accountPreferences.get().setClientKey(str);
        return str;
    }

    private <T> Observable<T> unsafeInitObservable(Callable<T> callable) {
        return initializedRequest(Observable.fromCallable(callable));
    }

    private <T> Observable<T> initObservable(final Callable<T> callable, final T t) {
        return initializedRequest(Observable.fromCallable(new Callable() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda38
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceAccountEntityData.lambda$initObservable$25(callable, t);
            }
        }));
    }

    public static /* synthetic */ Object lambda$initObservable$25(Callable callable, Object obj) throws Exception {
        Object call = callable.call();
        return call == null ? obj : call;
    }

    private <T> Observable<T> initializedRequest(Observable<T> observable) {
        return observable.onErrorResumeNext(initAndRetry(observable));
    }

    private <T> Function<Throwable, ? extends Observable<? extends T>> initAndRetry(final Observable<T> observable) {
        return new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreferenceAccountEntityData.this.m765x522813b(observable, (Throwable) obj);
            }
        };
    }

    /* renamed from: lambda$initAndRetry$27$id-dana-data-account-repository-source-preference-PreferenceAccountEntityData */
    public /* synthetic */ Observable m765x522813b(final Observable observable, Throwable th) throws Exception {
        if (th instanceof UnInitializedSecuredPreferencesException) {
            String MyBillsEntityDataFactory = CommonUtil.MyBillsEntityDataFactory(this.securityGuardFacade.get(), null);
            if (!TextUtils.isEmpty(MyBillsEntityDataFactory)) {
                return init(MyBillsEntityDataFactory).concatMap(new Function() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData$$ExternalSyntheticLambda33
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return PreferenceAccountEntityData.lambda$initAndRetry$26(Observable.this, (Boolean) obj);
                    }
                });
            }
        }
        return Observable.error(th);
    }

    private String getJsonStringKybInfo(KybEntity kybEntity) {
        if (kybEntity != null) {
            return JsonUtil.getAuthRequestContext(kybEntity);
        }
        return null;
    }

    private KybEntity parseKybInfo(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (KybEntity) JsonUtil.BuiltInFictitiousFunctionClassFactory(str, new TypeReference<KybEntity>() { // from class: id.dana.data.account.repository.source.preference.PreferenceAccountEntityData.1
                {
                    PreferenceAccountEntityData.this = this;
                }
            });
        } catch (RpcException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PREFERENCE_ACCOUNT, e.getMessage());
            return null;
        }
    }
}
