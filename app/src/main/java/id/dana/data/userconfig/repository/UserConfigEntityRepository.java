package id.dana.data.userconfig.repository;

import android.text.TextUtils;
import com.google.gson.Gson;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.userconfig.BiztypeEmptyException;
import id.dana.data.userconfig.BiztypeNotFoundException;
import id.dana.data.userconfig.BiztypeTooLongException;
import id.dana.data.userconfig.ConfigContentNullException;
import id.dana.data.userconfig.repository.source.EtagEntityData;
import id.dana.data.userconfig.repository.source.UserConfigEntityData;
import id.dana.data.userconfig.repository.source.UserConfigEntityDataFactory;
import id.dana.data.userconfig.repository.source.local.PersistenceEtagEntityData;
import id.dana.data.userconfig.repository.source.network.request.UserConfigQueryRequest;
import id.dana.data.userconfig.repository.source.network.result.UserConfigQueryResult;
import id.dana.data.userconfig.repository.source.network.result.UserConfigStoreResult;
import id.dana.data.userconfig.repository.source.network.result.UserGeneralConfig;
import id.dana.domain.userconfig.model.QueryConfig;
import id.dana.domain.userconfig.model.StoreConfig;
import id.dana.network.exception.NetworkException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Calendar;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UserConfigEntityRepository implements UserConfigRepository {
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final EtagEntityData etagEntityData;
    private final UserConfigEntityData localUserConfigDataSource;
    private final UserConfigEntityData networkUserConfigDataSource;
    private final Gson serializer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ UserConfigQueryResult lambda$getUserConfigFromNetwork$16(UserConfigQueryResult userConfigQueryResult, Boolean bool) throws Exception {
        return userConfigQueryResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ UserConfigStoreResult lambda$saveUserConfigToLocalAfterBackend$3(UserConfigStoreResult userConfigStoreResult) throws Exception {
        return userConfigStoreResult;
    }

    @Inject
    public UserConfigEntityRepository(Gson gson, UserConfigEntityDataFactory userConfigEntityDataFactory, PersistenceEtagEntityData persistenceEtagEntityData, ConfigEntityDataFactory configEntityDataFactory) {
        this.serializer = gson;
        this.localUserConfigDataSource = userConfigEntityDataFactory.createData2("local");
        this.networkUserConfigDataSource = userConfigEntityDataFactory.createData2("network");
        this.etagEntityData = persistenceEtagEntityData;
        this.configEntityDataFactory = configEntityDataFactory;
    }

    @Override // id.dana.data.userconfig.repository.UserConfigRepository
    public <T> Observable<T> getUserSpecificConfig(QueryConfig<T> queryConfig) {
        String bizType = queryConfig.getBizType();
        Class<T> contentType = queryConfig.getContentType();
        return validateInput(bizType, contentType).flatMap(getEtag(bizType)).map(getQueryRequest(bizType)).flatMap(getUserConfig()).flatMap(isContentFound()).map(convertContentToType(contentType));
    }

    @Override // id.dana.data.userconfig.repository.UserConfigRepository
    public Observable<Boolean> saveUserSpecificConfigBackendFirst(StoreConfig storeConfig) {
        return saveUserConfig(storeConfig, saveUserConfigBackendFirst(storeConfig, true));
    }

    @Override // id.dana.data.userconfig.repository.UserConfigRepository
    public Observable<Boolean> saveUserSpecificConfigBackendFirst(StoreConfig storeConfig, boolean z) {
        return saveUserConfig(storeConfig, saveUserConfigBackendFirst(storeConfig, z));
    }

    private Function<Boolean, Observable<UserConfigStoreResult>> saveUserConfigBackendFirst(final StoreConfig storeConfig, final boolean z) {
        final UserGeneralConfig createUserConfigToSave = createUserConfigToSave(storeConfig);
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2127xf846be02(storeConfig, z, createUserConfigToSave, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveUserConfigBackendFirst$2$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m2127xf846be02(StoreConfig storeConfig, boolean z, final UserGeneralConfig userGeneralConfig, Boolean bool) throws Exception {
        return getFeatureAvailability(storeConfig, z).flatMap(new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2126x4b739c1(userGeneralConfig, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveUserConfigBackendFirst$1$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2126x4b739c1(UserGeneralConfig userGeneralConfig, Boolean bool) throws Exception {
        return saveUserConfigToRemote(userGeneralConfig).apply(bool).flatMap(saveUserConfigToLocalAfterBackend(userGeneralConfig)).onErrorResumeNext(new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource just;
                Throwable th = (Throwable) obj;
                just = Observable.just(new UserConfigStoreResult());
                return just;
            }
        });
    }

    private Observable<Boolean> getFeatureAvailability(StoreConfig storeConfig, boolean z) {
        if (z) {
            return getSplitConfigEntityData().isUserConfigSyncEnable(storeConfig.getSyncKey());
        }
        return Observable.just(Boolean.TRUE);
    }

    private Function<UserConfigStoreResult, ObservableSource<UserConfigStoreResult>> saveUserConfigToLocalAfterBackend(final UserGeneralConfig userGeneralConfig) {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2129x95f56e42(userGeneralConfig, (UserConfigStoreResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveUserConfigToLocalAfterBackend$4$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2129x95f56e42(UserGeneralConfig userGeneralConfig, UserConfigStoreResult userConfigStoreResult) throws Exception {
        if (userConfigStoreResult.success) {
            return this.localUserConfigDataSource.saveUserConfig(userGeneralConfig).map(new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda16
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return UserConfigEntityRepository.lambda$saveUserConfigToLocalAfterBackend$3((UserConfigStoreResult) obj);
                }
            });
        }
        return Observable.just(userConfigStoreResult);
    }

    @Override // id.dana.data.userconfig.repository.UserConfigRepository
    public Observable<Boolean> saveUserSpecificConfig(StoreConfig storeConfig) {
        return saveUserSpecificConfig(storeConfig, true);
    }

    @Override // id.dana.data.userconfig.repository.UserConfigRepository
    public Observable<Boolean> saveUserSpecificConfig(StoreConfig storeConfig, boolean z) {
        try {
            return Observable.just(saveUserConfig(storeConfig, saveUserConfigLocalFirst(createUserConfigToSave(storeConfig), storeConfig.getSyncKey(), z)).blockingFirst());
        } catch (Exception e) {
            return Observable.error(e);
        }
    }

    public Observable<Boolean> saveUserConfig(StoreConfig storeConfig, Function<Boolean, Observable<UserConfigStoreResult>> function) {
        return validateInput(storeConfig.bizType, storeConfig.content).flatMap(function).flatMap(handleSaveResult());
    }

    private Function<Boolean, Observable<UserConfigStoreResult>> saveUserConfigLocalFirst(final UserGeneralConfig userGeneralConfig, final String str, final boolean z) {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2128x874f860e(userGeneralConfig, str, z, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveUserConfigLocalFirst$5$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m2128x874f860e(UserGeneralConfig userGeneralConfig, String str, boolean z, Boolean bool) throws Exception {
        return this.localUserConfigDataSource.saveUserConfig(userGeneralConfig).flatMap(isUserConfigSyncEnable(str, z)).flatMap(saveUserConfigToRemote(userGeneralConfig));
    }

    private Function<UserConfigStoreResult, Observable<Boolean>> handleSaveResult() {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.lambda$handleSaveResult$6((UserConfigStoreResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Observable lambda$handleSaveResult$6(UserConfigStoreResult userConfigStoreResult) throws Exception {
        if (!userConfigStoreResult.success) {
            return Observable.error(new NetworkException(userConfigStoreResult));
        }
        return Observable.just(Boolean.TRUE);
    }

    private UserGeneralConfig createUserConfigToSave(StoreConfig storeConfig) {
        return new UserGeneralConfig(storeConfig.bizType, this.serializer.toJson(storeConfig.content), Calendar.getInstance().getTimeInMillis());
    }

    private Function<UserConfigStoreResult, ObservableSource<Boolean>> isUserConfigSyncEnable(final String str, final boolean z) {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2125x5f4c1af6(z, str, (UserConfigStoreResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isUserConfigSyncEnable$7$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2125x5f4c1af6(boolean z, String str, UserConfigStoreResult userConfigStoreResult) throws Exception {
        return z ? getSplitConfigEntityData().isUserConfigSyncEnable(str) : Observable.just(Boolean.TRUE);
    }

    private Function<Boolean, Observable<UserConfigStoreResult>> saveUserConfigToRemote(final UserGeneralConfig userGeneralConfig) {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2130x94018d2d(userGeneralConfig, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveUserConfigToRemote$8$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m2130x94018d2d(UserGeneralConfig userGeneralConfig, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            return this.networkUserConfigDataSource.saveUserConfig(userGeneralConfig);
        }
        return Observable.just(UserConfigStoreResult.success());
    }

    @Override // id.dana.data.userconfig.repository.UserConfigRepository
    public Observable<Boolean> syncInAllUserConfig() {
        return this.networkUserConfigDataSource.getAllUserConfig().flatMap(new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2131x16d9c0b7((UserConfigQueryResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$syncInAllUserConfig$9$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2131x16d9c0b7(UserConfigQueryResult userConfigQueryResult) throws Exception {
        if (userConfigQueryResult.success) {
            return saveUserConfigToLocal(userConfigQueryResult);
        }
        return Observable.error(new NetworkException(userConfigQueryResult));
    }

    private Observable<Boolean> validateInput(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return Observable.error(new BiztypeEmptyException());
        }
        if (str.length() > 35) {
            return Observable.error(new BiztypeTooLongException());
        }
        if (obj == null) {
            return Observable.error(new ConfigContentNullException());
        }
        return Observable.just(Boolean.TRUE);
    }

    private Function<Boolean, ObservableSource<String>> getEtag(final String str) {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2121xb0fadb26(str, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getEtag$10$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2121xb0fadb26(String str, Boolean bool) throws Exception {
        return this.etagEntityData.getEtag(str);
    }

    private Function<String, UserConfigQueryRequest> getQueryRequest(final String str) {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserConfigQueryRequest fromSingleBiztype;
                fromSingleBiztype = UserConfigQueryRequest.fromSingleBiztype(str, (String) obj);
                return fromSingleBiztype;
            }
        };
    }

    private Function<UserConfigQueryRequest, ObservableSource<UserConfigQueryResult>> getUserConfig() {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2123x3b0633d1((UserConfigQueryRequest) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getUserConfig$13$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2123x3b0633d1(final UserConfigQueryRequest userConfigQueryRequest) throws Exception {
        return this.localUserConfigDataSource.getUserConfig(userConfigQueryRequest).flatMap(new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2122x4776af90(userConfigQueryRequest, (UserConfigQueryResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getUserConfig$12$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2122x4776af90(UserConfigQueryRequest userConfigQueryRequest, UserConfigQueryResult userConfigQueryResult) throws Exception {
        if (!userConfigQueryResult.success || userConfigQueryResult.isEmpty()) {
            return getUserConfigFromNetwork(userConfigQueryRequest);
        }
        return Observable.just(userConfigQueryResult);
    }

    private Function<UserConfigQueryResult, Observable<UserGeneralConfig>> isContentFound() {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.lambda$isContentFound$14((UserConfigQueryResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Observable lambda$isContentFound$14(UserConfigQueryResult userConfigQueryResult) throws Exception {
        if (!userConfigQueryResult.success || userConfigQueryResult.isEmpty()) {
            return Observable.error(new BiztypeNotFoundException());
        }
        return Observable.just(userConfigQueryResult.getConfigs().get(0));
    }

    private <T> Function<UserGeneralConfig, T> convertContentToType(final Class<T> cls) {
        return new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2120xc3db3761(cls, (UserGeneralConfig) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$convertContentToType$15$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ Object m2120xc3db3761(Class cls, UserGeneralConfig userGeneralConfig) throws Exception {
        return this.serializer.fromJson(userGeneralConfig.getContent(), cls);
    }

    private ObservableSource<UserConfigQueryResult> getUserConfigFromNetwork(final UserConfigQueryRequest userConfigQueryRequest) {
        return this.networkUserConfigDataSource.getUserConfig(userConfigQueryRequest).flatMap(new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConfigEntityRepository.this.m2124x9f308e1d(userConfigQueryRequest, (UserConfigQueryResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getUserConfigFromNetwork$17$id-dana-data-userconfig-repository-UserConfigEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m2124x9f308e1d(UserConfigQueryRequest userConfigQueryRequest, final UserConfigQueryResult userConfigQueryResult) throws Exception {
        if (!userConfigQueryResult.success) {
            return Observable.error(new NetworkException(userConfigQueryResult));
        }
        if (isContentModified(userConfigQueryRequest, userConfigQueryResult)) {
            return saveUserConfigToLocal(userConfigQueryResult).map(new Function() { // from class: id.dana.data.userconfig.repository.UserConfigEntityRepository$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return UserConfigEntityRepository.lambda$getUserConfigFromNetwork$16(UserConfigQueryResult.this, (Boolean) obj);
                }
            });
        }
        return Observable.just(userConfigQueryResult);
    }

    private boolean isContentModified(UserConfigQueryRequest userConfigQueryRequest, UserConfigQueryResult userConfigQueryResult) {
        return !userConfigQueryRequest.getEtag().equals(userConfigQueryResult.getEtag());
    }

    private Observable<Boolean> saveUserConfigToLocal(UserConfigQueryResult userConfigQueryResult) {
        for (UserGeneralConfig userGeneralConfig : userConfigQueryResult.getConfigs()) {
            this.localUserConfigDataSource.saveUserConfig(userGeneralConfig);
            this.etagEntityData.saveEtag(userGeneralConfig.getBizType(), userConfigQueryResult.getEtag());
        }
        return Observable.just(Boolean.TRUE);
    }

    private ConfigEntityData getSplitConfigEntityData() {
        return this.configEntityDataFactory.createData2("split");
    }
}
