package id.dana.data.deeplink.repository;

import android.app.Activity;
import id.dana.data.authcode.AuthCodeEntity;
import id.dana.data.authcode.repository.source.AuthEntityData;
import id.dana.data.authcode.repository.source.AuthEntityDataFactory;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import id.dana.data.deeplink.DeeplinkException;
import id.dana.data.deeplink.mapper.DeepLinkPayloadEntityMapper;
import id.dana.data.deeplink.repository.source.DeepLinkEntityData;
import id.dana.data.deeplink.repository.source.DeepLinkEntityDataFactory;
import id.dana.data.deeplink.repository.source.LinkApiEntityData;
import id.dana.data.deeplink.repository.source.LinkApiEntityDataFactory;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.util.UrlUtil;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.ServicesRepository;
import id.dana.utils.android.IntentUtil;
import id.dana.utils.deeplink.BranchDeeplinkUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
/* loaded from: classes2.dex */
public class DeepLinkEntityRepository implements DeepLinkRepository {
    private final AuthEntityDataFactory authEntityDataFactory;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final DeepLinkEntityDataFactory deepLinkEntityDataFactory;
    private final DeepLinkPayloadManager deepLinkPayloadManager;
    private final DeepLinkPayloadEntityMapper deepLinkPayloadMapper;
    private final LinkApiEntityDataFactory linkApiEntityDataFactory;
    private final ServicesRepository servicesRepository;

    @Inject
    public DeepLinkEntityRepository(DeepLinkEntityDataFactory deepLinkEntityDataFactory, LinkApiEntityDataFactory linkApiEntityDataFactory, DeepLinkPayloadEntityMapper deepLinkPayloadEntityMapper, DeepLinkPayloadManager deepLinkPayloadManager, AuthEntityDataFactory authEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, ServicesRepository servicesRepository) {
        this.deepLinkEntityDataFactory = deepLinkEntityDataFactory;
        this.linkApiEntityDataFactory = linkApiEntityDataFactory;
        this.deepLinkPayloadMapper = deepLinkPayloadEntityMapper;
        this.deepLinkPayloadManager = deepLinkPayloadManager;
        this.authEntityDataFactory = authEntityDataFactory;
        this.configEntityDataFactory = configEntityDataFactory;
        this.servicesRepository = servicesRepository;
    }

    @Override // id.dana.domain.deeplink.repository.DeepLinkRepository
    public Observable<DeepLinkPayload> initSession(Activity activity) {
        Observable<DeepLinkPayloadEntity> deepLinkPayloadEntityFromSplitFirst = BranchDeeplinkUtil.getAuthRequestContext(activity) ? getDeepLinkPayloadEntityFromSplitFirst(activity) : getDeepLinkPayloadEntityFromBranchFirst(activity);
        final DeepLinkPayloadManager deepLinkPayloadManager = this.deepLinkPayloadManager;
        Objects.requireNonNull(deepLinkPayloadManager);
        Observable<DeepLinkPayloadEntity> doOnNext = deepLinkPayloadEntityFromSplitFirst.doOnNext(new Consumer() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DeepLinkPayloadManager.this.saveDeepLinkPayload((DeepLinkPayloadEntity) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DeepLinkEntityRepository.this.m1167xe80d4598((DeepLinkPayloadEntity) obj);
            }
        });
        DeepLinkPayloadEntityMapper deepLinkPayloadEntityMapper = this.deepLinkPayloadMapper;
        Objects.requireNonNull(deepLinkPayloadEntityMapper);
        return doOnNext.map(new DeepLinkEntityRepository$$ExternalSyntheticLambda8(deepLinkPayloadEntityMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initSession$0$id-dana-data-deeplink-repository-DeepLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1167xe80d4598(DeepLinkPayloadEntity deepLinkPayloadEntity) throws Exception {
        this.deepLinkPayloadManager.removeDeepLinkPayloadBackupWithTimer(DeepLinkPayloadManager.RESET_PAYLOAD_BACKUP_DELAY);
    }

    private Observable<DeepLinkPayloadEntity> getDeepLinkPayloadEntityFromSplitFirst(final Activity activity) {
        return checkDeeplinkFeatureConfig(activity.getIntent().getDataString()).onErrorResumeNext(new Function() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DeepLinkEntityRepository.this.m1166xe1bd4aa2(activity, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDeepLinkPayloadEntityFromSplitFirst$1$id-dana-data-deeplink-repository-DeepLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1166xe1bd4aa2(Activity activity, Throwable th) throws Exception {
        return createDeepLinkNetworkData().initSession(activity);
    }

    private Observable<DeepLinkPayloadEntity> getDeepLinkPayloadEntityFromBranchFirst(final Activity activity) {
        return createDeepLinkNetworkData().initSession(activity).timeout(5L, TimeUnit.SECONDS).onErrorResumeNext(new Function() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DeepLinkEntityRepository.this.m1165x8b592de4(activity, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDeepLinkPayloadEntityFromBranchFirst$3$id-dana-data-deeplink-repository-DeepLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1165x8b592de4(Activity activity, final Throwable th) throws Exception {
        final String BuiltInFictitiousFunctionClassFactory = IntentUtil.BuiltInFictitiousFunctionClassFactory(activity);
        if (UrlUtil.isDeepLink(BuiltInFictitiousFunctionClassFactory)) {
            return checkDeeplinkFeatureConfig(BuiltInFictitiousFunctionClassFactory).onErrorResumeNext(new Function() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return DeepLinkEntityRepository.this.m1164x7aa36123(th, BuiltInFictitiousFunctionClassFactory, (Throwable) obj);
                }
            });
        }
        return Observable.error(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDeepLinkPayloadEntityFromBranchFirst$2$id-dana-data-deeplink-repository-DeepLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1164x7aa36123(Throwable th, String str, Throwable th2) throws Exception {
        if (isSplitErrorException(th2)) {
            return Observable.error(new DeeplinkException("", th.getMessage(), str));
        }
        return Observable.error(new DeeplinkException("", th2.getMessage(), str));
    }

    private Observable<DeepLinkPayloadEntity> checkDeeplinkFeatureConfig(final String str) {
        return createConfigEntityNetworkData().getDeeplinkFeatureConfigList().flatMap(new Function() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DeepLinkEntityRepository.this.m1162xe8a63cfa(str, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkDeeplinkFeatureConfig$4$id-dana-data-deeplink-repository-DeepLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1162xe8a63cfa(String str, List list) throws Exception {
        return createConfigEntityNetworkData().getDeeplinkFeatureConfigByKeys(list, str);
    }

    private boolean isSplitErrorException(Throwable th) {
        return (th instanceof UnexpectedTreatment) || (th instanceof SplitNull) || (th instanceof JSONException);
    }

    @Override // id.dana.domain.deeplink.repository.DeepLinkRepository
    public Observable<DeepLinkPayload> getDeepLinkPayload(final boolean z) {
        Observable flatMap = Observable.defer(new Callable() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DeepLinkEntityRepository.this.m1163x11ee0fc3(z);
            }
        }).flatMap(new DeepLinkEntityRepository$$ExternalSyntheticLambda1(this));
        DeepLinkPayloadEntityMapper deepLinkPayloadEntityMapper = this.deepLinkPayloadMapper;
        Objects.requireNonNull(deepLinkPayloadEntityMapper);
        return flatMap.map(new DeepLinkEntityRepository$$ExternalSyntheticLambda8(deepLinkPayloadEntityMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDeepLinkPayload$5$id-dana-data-deeplink-repository-DeepLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1163x11ee0fc3(boolean z) throws Exception {
        return Observable.just(this.deepLinkPayloadManager.getDeepLinkPayloadEntity(z));
    }

    @Override // id.dana.domain.deeplink.repository.DeepLinkRepository
    public Observable<DeepLinkPayload> readProperties(final String str) {
        Observable<R> flatMap = createLinkApiNetworkData().readLink(str).onErrorResumeNext(new Function() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource error;
                error = Observable.error(new DeeplinkException("", r3.getMessage() != null ? ((Throwable) obj).getMessage() : "", str));
                return error;
            }
        }).flatMap(new DeepLinkEntityRepository$$ExternalSyntheticLambda1(this));
        DeepLinkPayloadEntityMapper deepLinkPayloadEntityMapper = this.deepLinkPayloadMapper;
        Objects.requireNonNull(deepLinkPayloadEntityMapper);
        return flatMap.map(new DeepLinkEntityRepository$$ExternalSyntheticLambda8(deepLinkPayloadEntityMapper));
    }

    @Override // id.dana.domain.deeplink.repository.DeepLinkRepository
    public boolean removeDeeplinkPayload() {
        if (this.deepLinkPayloadManager.hasPayload()) {
            this.deepLinkPayloadManager.removeDeepLinkPayload();
            this.deepLinkPayloadManager.removeDeepLinkPayloadBackup();
            return true;
        } else if (this.deepLinkPayloadManager.hasPayloadBackup()) {
            this.deepLinkPayloadManager.removeDeepLinkPayloadBackup();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<DeepLinkPayloadEntity> checkAuthEnable(final DeepLinkPayloadEntity deepLinkPayloadEntity) {
        if (isNeedAuth(deepLinkPayloadEntity)) {
            return this.servicesRepository.getServiceByKey(deepLinkPayloadEntity.getServiceKey()).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Observable authCode;
                    authCode = DeepLinkEntityRepository.this.getAuthCode((ThirdPartyServiceResponse) obj);
                    return authCode;
                }
            }).map(new Function() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda4
                /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                    jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.data.deeplink.repository.DeepLinkEntityRepository.lambda$checkAuthEnable$7(id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity, java.lang.String):id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity
                    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                    	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                    Caused by: java.lang.NullPointerException
                    */
                @Override // io.reactivex.functions.Function
                public final java.lang.Object apply(java.lang.Object r2) {
                    /*
                        r1 = this;
                        id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity r0 = id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity.this
                        java.lang.String r2 = (java.lang.String) r2
                        id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity r2 = id.dana.data.deeplink.repository.DeepLinkEntityRepository.lambda$checkAuthEnable$7(r0, r2)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda4.apply(java.lang.Object):java.lang.Object");
                }
            }).onErrorReturnItem(deepLinkPayloadEntity);
        }
        return Observable.just(deepLinkPayloadEntity);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity lambda$checkAuthEnable$7(id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity r0, java.lang.String r1) throws java.lang.Exception {
        /*
            r0.setAuthCode(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.deeplink.repository.DeepLinkEntityRepository.lambda$checkAuthEnable$7(id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity, java.lang.String):id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity");
    }

    private boolean isNeedAuth(DeepLinkPayloadEntity deepLinkPayloadEntity) {
        return deepLinkPayloadEntity.isNeedAuth() && deepLinkPayloadEntity.getServiceKey() != null && BranchLinkConstant.PathTarget.CONTAINER.equalsIgnoreCase(deepLinkPayloadEntity.getPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<String> getAuthCode(ThirdPartyServiceResponse thirdPartyServiceResponse) {
        return createAuthNetworkData().getAuthCode(thirdPartyServiceResponse.getRedirectUrl(), thirdPartyServiceResponse.getClientId(), thirdPartyServiceResponse.getScopes(), true, "", "", thirdPartyServiceResponse.getAppId() != null).map(new Function() { // from class: id.dana.data.deeplink.repository.DeepLinkEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((AuthCodeEntity) obj).getAuthCode();
            }
        });
    }

    @Nullable
    private ThirdPartyServiceResponse getService(List<ThirdPartyServiceResponse> list, String str) {
        for (ThirdPartyServiceResponse thirdPartyServiceResponse : list) {
            if (thirdPartyServiceResponse.getKey().equals(str)) {
                return thirdPartyServiceResponse;
            }
        }
        return null;
    }

    private AuthEntityData createAuthNetworkData() {
        return this.authEntityDataFactory.createData2("network");
    }

    private LinkApiEntityData createLinkApiNetworkData() {
        return this.linkApiEntityDataFactory.createData2("network");
    }

    private DeepLinkEntityData createDeepLinkNetworkData() {
        return this.deepLinkEntityDataFactory.createData2("network");
    }

    private ConfigEntityData createConfigEntityNetworkData() {
        return this.configEntityDataFactory.createData2("network");
    }
}
