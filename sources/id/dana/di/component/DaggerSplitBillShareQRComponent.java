package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.base.BaseResponseMapper_Factory;
import id.dana.di.modules.SplitBillShareQRModule;
import id.dana.di.modules.SplitBillShareQRModule_ProvideSplitBillSectionViewFactory;
import id.dana.di.modules.SplitBillShareQRModule_ProvideSplitBillShareQRPresenterFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.interactor.GetHomeInfo_Factory;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.mapper.HomeInfoMapper;
import id.dana.mapper.HomeInfoMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.splitbill.SplitBillShareQRContract;
import id.dana.splitbill.SplitBillShareQRPresenter;
import id.dana.splitbill.SplitBillShareQRPresenter_Factory;
import id.dana.splitbill.view.SplitBillShareQrActivity;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSplitBillShareQRComponent {
    private DaggerSplitBillShareQRComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SplitBillShareQRModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SplitBillShareQRComponentImpl implements SplitBillShareQRComponent {
        private Provider<Context> BuiltInFictitiousFunctionClassFactory;
        private Provider<SSLPinningRepository> DatabaseTableConfigUtil;
        private Provider<ServiceCategoryMapper> GetContactSyncConfig;
        private Provider<GetHomeInfo> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<SplitBillShareQRContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final SplitBillShareQRComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SplitBillShareQRContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<HomeInfoMapper> getErrorConfigVersion;
        private Provider<SplitBillShareQRPresenter> initRecordTimeStamp;
        private Provider<IsOfflineF2FPay> lookAheadTest;
        private Provider<HomeInfoRepository> moveToNextValue;
        private Provider<ThirdPartyServicesMapper> newProxyInstance;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ SplitBillShareQRComponentImpl(SplitBillShareQRModule splitBillShareQRModule, ApplicationComponent applicationComponent, byte b) {
            this(splitBillShareQRModule, applicationComponent);
        }

        private SplitBillShareQRComponentImpl(SplitBillShareQRModule splitBillShareQRModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this;
            this.getAuthRequestContext = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ThreadExecutorProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new SSLPinningRepositoryProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.scheduleImpl, featureConfigRepositoryProvider);
            this.lookAheadTest = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.DatabaseTableConfigUtil, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(SplitBillShareQRModule_ProvideSplitBillSectionViewFactory.PlaceComponentResult(splitBillShareQRModule));
            HomeRepositoryProvider homeRepositoryProvider = new HomeRepositoryProvider(applicationComponent);
            this.moveToNextValue = homeRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetHomeInfo_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.scheduleImpl, homeRepositoryProvider);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = contextProvider;
            ServiceCategoryMapper_Factory authRequestContext = ServiceCategoryMapper_Factory.getAuthRequestContext(contextProvider);
            this.GetContactSyncConfig = authRequestContext;
            this.newProxyInstance = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext);
            HomeInfoMapper_Factory PlaceComponentResult = HomeInfoMapper_Factory.PlaceComponentResult(BaseResponseMapper_Factory.MyBillsEntityDataFactory(), CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.newProxyInstance);
            this.getErrorConfigVersion = PlaceComponentResult;
            SplitBillShareQRPresenter_Factory authRequestContext2 = SplitBillShareQRPresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult);
            this.initRecordTimeStamp = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(SplitBillShareQRModule_ProvideSplitBillShareQRPresenterFactory.BuiltInFictitiousFunctionClassFactory(splitBillShareQRModule, authRequestContext2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent PlaceComponentResult;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class HomeRepositoryProvider implements Provider<HomeInfoRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            HomeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeInfoRepository get() {
                return (HomeInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent PlaceComponentResult;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue());
            }
        }

        @Override // id.dana.di.component.SplitBillShareQRComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillShareQrActivity splitBillShareQrActivity) {
            ((BaseActivity) splitBillShareQrActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(splitBillShareQrActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(splitBillShareQrActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            splitBillShareQrActivity.presenter = this.NetworkUserEntityData$$ExternalSyntheticLambda2.get();
        }
    }
}
