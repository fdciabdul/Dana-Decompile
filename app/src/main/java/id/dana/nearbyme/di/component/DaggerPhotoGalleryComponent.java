package id.dana.nearbyme.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.domain.nearbyme.interactor.GetMerchantImage_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.nearbyme.di.module.PhotoGalleryModule;
import id.dana.nearbyme.di.module.PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory;
import id.dana.nearbyme.di.module.PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory;
import id.dana.nearbyme.di.module.PhotoGalleryModule_ProvideViewFactory;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity_MembersInjector;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryModel;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes5.dex */
public final class DaggerPhotoGalleryComponent {
    private DaggerPhotoGalleryComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public PhotoGalleryModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class PhotoGalleryComponentImpl implements PhotoGalleryComponent {
        private Provider<CoroutineDispatcher> BuiltInFictitiousFunctionClassFactory;
        private Provider<SSLPinningRepository> DatabaseTableConfigUtil;
        private Provider<PhotoGalleryContract.View> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<MerchantPhotoGalleryModel> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GetMerchantImage> PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<PhotoGalleryPresenter> getErrorConfigVersion;
        private Provider<PhotoGalleryContract.Presenter> initRecordTimeStamp;
        private Provider<MerchantInfoRepository> lookAheadTest;
        private Provider<PostExecutionThread> moveToNextValue;
        private final PhotoGalleryComponentImpl scheduleImpl;

        public /* synthetic */ PhotoGalleryComponentImpl(PhotoGalleryModule photoGalleryModule, ApplicationComponent applicationComponent, byte b) {
            this(photoGalleryModule, applicationComponent);
        }

        private PhotoGalleryComponentImpl(PhotoGalleryModule photoGalleryModule, ApplicationComponent applicationComponent) {
            this.scheduleImpl = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ThreadExecutorProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new SSLPinningRepositoryProvider(applicationComponent);
            this.moveToNextValue = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.moveToNextValue, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.DatabaseTableConfigUtil, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory.PlaceComponentResult(photoGalleryModule));
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(PhotoGalleryModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(photoGalleryModule));
            this.lookAheadTest = new MerchantInfoRepositoryProvider(applicationComponent);
            DefaultDispatcherProvider defaultDispatcherProvider = new DefaultDispatcherProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = defaultDispatcherProvider;
            GetMerchantImage_Factory create2 = GetMerchantImage_Factory.create(this.lookAheadTest, defaultDispatcherProvider);
            this.PlaceComponentResult = create2;
            PhotoGalleryPresenter_Factory BuiltInFictitiousFunctionClassFactory = PhotoGalleryPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.GetContactSyncConfig, create2);
            this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory.getAuthRequestContext(photoGalleryModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* loaded from: classes5.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent getAuthRequestContext;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature());
            }
        }

        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getRawPath());
            }
        }

        /* loaded from: classes5.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* loaded from: classes5.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* loaded from: classes5.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.M());
            }
        }

        /* loaded from: classes5.dex */
        public static final class DefaultDispatcherProvider implements Provider<CoroutineDispatcher> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            DefaultDispatcherProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CoroutineDispatcher get() {
                return (CoroutineDispatcher) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig());
            }
        }

        @Override // id.dana.nearbyme.di.component.PhotoGalleryComponent
        public final void BuiltInFictitiousFunctionClassFactory(MerchantPhotoGalleryActivity merchantPhotoGalleryActivity) {
            ((BaseActivity) merchantPhotoGalleryActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantPhotoGalleryActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(merchantPhotoGalleryActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            MerchantPhotoGalleryActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantPhotoGalleryActivity, this.initRecordTimeStamp.get());
        }
    }
}
