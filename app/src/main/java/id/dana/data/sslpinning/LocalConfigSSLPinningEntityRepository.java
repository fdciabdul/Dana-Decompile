package id.dana.data.sslpinning;

import dagger.Lazy;
import id.dana.data.ProductFlavor;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.network.IOkHttpSSLPinningManager;
import id.dana.data.sslpinning.source.SslPinningEntityData;
import id.dana.data.sslpinning.source.SslPinningEntityDataFactory;
import id.dana.domain.featureconfig.model.StartupConfig;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.utils.BuildConfigUtils;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class LocalConfigSSLPinningEntityRepository implements SSLPinningRepository {
    private final Lazy<IOkHttpSSLPinningManager> okHttpSSLPinningManager;
    private final Lazy<SharedPrefStartupConfig> sharedPrefStartupConfig;
    private final Lazy<SplitConfigEntityData> splitConfigEntityData;
    private final Lazy<SslPinningEntityDataFactory> sslPinningEntityDataFactory;
    private final ThreadExecutor threadExecutor;
    boolean work = false;

    @Inject
    public LocalConfigSSLPinningEntityRepository(Lazy<SslPinningEntityDataFactory> lazy, Lazy<SharedPrefStartupConfig> lazy2, ThreadExecutor threadExecutor, Lazy<IOkHttpSSLPinningManager> lazy3, Lazy<SplitConfigEntityData> lazy4) {
        this.sslPinningEntityDataFactory = lazy;
        this.sharedPrefStartupConfig = lazy2;
        this.threadExecutor = threadExecutor;
        this.okHttpSSLPinningManager = lazy3;
        this.splitConfigEntityData = lazy4;
    }

    private SslPinningEntityData createPinningData() {
        return this.sslPinningEntityDataFactory.get().createData2("network");
    }

    @Override // id.dana.domain.sslpinning.SSLPinningRepository
    public Observable<Boolean> pinCertificates() {
        BuildConfigUtils.BuiltInFictitiousFunctionClassFactory();
        if ("production".equals(BuildConfigUtils.PlaceComponentResult()) || ProductFlavor.PREPROD.equals(BuildConfigUtils.PlaceComponentResult())) {
            int pinningMode = this.sharedPrefStartupConfig.get().getStartupConfig().getPinningMode();
            if (pinningMode == 0) {
                return createPinningData().closeSslPinning();
            }
            return createPinningData().addAndPersistRemoteCertificates(pinningMode, this.sharedPrefStartupConfig.get().getStartupConfig().getCertificates());
        }
        return Observable.just(Boolean.TRUE);
    }

    @Override // id.dana.domain.sslpinning.SSLPinningRepository
    public Observable<Boolean> pinHotUpdate() {
        return Observable.defer(new Callable() { // from class: id.dana.data.sslpinning.LocalConfigSSLPinningEntityRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalConfigSSLPinningEntityRepository.this.m2048xa4c0a625();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$pinHotUpdate$0$id-dana-data-sslpinning-LocalConfigSSLPinningEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2048xa4c0a625() throws Exception {
        BuildConfigUtils.BuiltInFictitiousFunctionClassFactory();
        Boolean bool = Boolean.TRUE;
        if ("production".equals(BuildConfigUtils.PlaceComponentResult()) || ProductFlavor.PREPROD.equals(BuildConfigUtils.PlaceComponentResult())) {
            if (this.work) {
                return Observable.just(bool);
            }
            this.work = true;
            monitorPinningMode();
            monitorPinCertificatesUrl();
            monitorPinWhitelist();
        }
        return Observable.just(bool);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$pinCertificateRemote$1$id-dana-data-sslpinning-LocalConfigSSLPinningEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2047x44a417ad(StartupConfig startupConfig) throws Exception {
        return createPinningData().addAndPersistRemoteCertificates(startupConfig.getPinningMode(), startupConfig.getCertificates());
    }

    @Override // id.dana.domain.sslpinning.SSLPinningRepository
    public Observable<Boolean> pinCertificateRemote() {
        return this.splitConfigEntityData.get().getStartupConfig().flatMap(new Function() { // from class: id.dana.data.sslpinning.LocalConfigSSLPinningEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return LocalConfigSSLPinningEntityRepository.this.m2047x44a417ad((StartupConfig) obj);
            }
        });
    }

    @Override // id.dana.domain.sslpinning.SSLPinningRepository
    public Boolean isSslPinningSuccess() {
        return createPinningData().isSslPinningSuccess();
    }

    private void monitorPinningMode() {
        int pinningMode = this.sharedPrefStartupConfig.get().getStartupConfig().getPinningMode();
        if (pinningMode == 0) {
            Completable ignoreElements = createPinningData().closeSslPinning().ignoreElements();
            Scheduler BuiltInFictitiousFunctionClassFactory = Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor);
            ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "scheduler is null");
            Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(ignoreElements, BuiltInFictitiousFunctionClassFactory));
            Scheduler BuiltInFictitiousFunctionClassFactory2 = Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor);
            ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, "scheduler is null");
            RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory2)).q_();
            return;
        }
        Completable ignoreElements2 = createPinningData().addAndPersistRemoteCertificates(pinningMode, this.sharedPrefStartupConfig.get().getStartupConfig().getCertificates()).ignoreElements();
        Scheduler BuiltInFictitiousFunctionClassFactory3 = Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor);
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory3, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(ignoreElements2, BuiltInFictitiousFunctionClassFactory3));
        Scheduler BuiltInFictitiousFunctionClassFactory4 = Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor);
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory4, "scheduler is null");
        RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$22, BuiltInFictitiousFunctionClassFactory4)).q_();
    }

    private void monitorPinCertificatesUrl() {
        Completable ignoreElements = createPinningData().addAndPersistRemoteCertificates(this.sharedPrefStartupConfig.get().getStartupConfig().getPinningMode(), this.sharedPrefStartupConfig.get().getStartupConfig().getCertificates()).ignoreElements();
        Scheduler BuiltInFictitiousFunctionClassFactory = Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor);
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(ignoreElements, BuiltInFictitiousFunctionClassFactory));
        Scheduler BuiltInFictitiousFunctionClassFactory2 = Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor);
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, "scheduler is null");
        RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory2)).q_();
    }

    private void monitorPinWhitelist() {
        this.okHttpSSLPinningManager.get().getAuthRequestContext(this.sharedPrefStartupConfig.get().getStartupConfig().getSslCertificateWhitelistHost());
    }
}
