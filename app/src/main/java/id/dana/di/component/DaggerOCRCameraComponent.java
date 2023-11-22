package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.OCRCameraModule;
import id.dana.di.modules.OCRCameraModule_ProvideOcrRequestModel$app_productionReleaseFactory;
import id.dana.di.modules.OCRCameraModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.OCRCameraModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.ocr.OCRCameraContract;
import id.dana.ocr.OCRCameraPresenter;
import id.dana.ocr.OCRCameraPresenter_Factory;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.ocr.views.OCRCameraActivity;
import id.dana.ocr.views.OCRCameraActivity_MembersInjector;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerOCRCameraComponent {
    private DaggerOCRCameraComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public BottomSheetOnBoardingModule PlaceComponentResult;
        public OCRCameraModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class OCRCameraComponentImpl implements OCRCameraComponent {
        private Provider<ConnectionStatusReceiver> BuiltInFictitiousFunctionClassFactory;
        private Provider<SSLPinningRepository> DatabaseTableConfigUtil;
        private Provider<OCRRequestModel> GetContactSyncConfig;
        private Provider<GetBottomSheetOnBoarding> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<BottomSheetOnBoardingContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<OCRCameraContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<BottomSheetOnBoardingContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<UserEducationRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<SaveDisplayBottomSheetOnBoarding> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<BottomSheetOnBoardingPresenter> PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<OCRCameraPresenter> getErrorConfigVersion;
        private Provider<OCRCameraContract.View> initRecordTimeStamp;
        private Provider<ThreadExecutor> isLayoutRequested;
        private final OCRCameraComponentImpl lookAheadTest;
        private Provider<IsOfflineF2FPay> moveToNextValue;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ OCRCameraComponentImpl(OCRCameraModule oCRCameraModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, ApplicationComponent applicationComponent, byte b) {
            this(oCRCameraModule, bottomSheetOnBoardingModule, applicationComponent);
        }

        private OCRCameraComponentImpl(OCRCameraModule oCRCameraModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.isLayoutRequested = new ThreadExecutorProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new SSLPinningRepositoryProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.isLayoutRequested, this.scheduleImpl, featureConfigRepositoryProvider);
            this.moveToNextValue = create;
            this.BuiltInFictitiousFunctionClassFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.isLayoutRequested, this.DatabaseTableConfigUtil, create);
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(OCRCameraModule_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(oCRCameraModule));
            Provider<OCRRequestModel> authRequestContext = DoubleCheck.getAuthRequestContext(OCRCameraModule_ProvideOcrRequestModel$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(oCRCameraModule));
            this.GetContactSyncConfig = authRequestContext;
            OCRCameraPresenter_Factory MyBillsEntityDataFactory = OCRCameraPresenter_Factory.MyBillsEntityDataFactory(this.initRecordTimeStamp, authRequestContext);
            this.getErrorConfigVersion = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(OCRCameraModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(oCRCameraModule, MyBillsEntityDataFactory));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = userEducationRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetBottomSheetOnBoarding_Factory.create(this.isLayoutRequested, this.scheduleImpl, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create2 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.isLayoutRequested, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = create2;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.KClassImpl$Data$declaredNonStaticMembers$2, create2);
            this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent getAuthRequestContext;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$1());
            }
        }

        @Override // id.dana.di.component.OCRCameraComponent
        public final void PlaceComponentResult(OCRCameraActivity oCRCameraActivity) {
            ((BaseActivity) oCRCameraActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(oCRCameraActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(oCRCameraActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            OCRCameraActivity_MembersInjector.MyBillsEntityDataFactory(oCRCameraActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
            OCRCameraActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(oCRCameraActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
        }
    }
}
