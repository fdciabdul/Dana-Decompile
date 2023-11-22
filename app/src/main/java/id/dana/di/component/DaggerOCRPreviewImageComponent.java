package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository;
import id.dana.appcontainer.plugin.ocrreceipt.usecase.GetOcrSnapLimit;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.danah5.ocrreceipt.usecase.GetOcrPreprocessingConfig;
import id.dana.di.modules.OCRPreviewImageModule;
import id.dana.di.modules.OCRPreviewImageModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.OCRPreviewImageModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.PreprocessingAndOcrModule;
import id.dana.di.modules.PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory;
import id.dana.di.modules.PreprocessingAndOcrModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.PreprocessingAndOcrModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.ocr.OCRRepository;
import id.dana.domain.ocr.interactor.GetOcrFromReceipt;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.ocr.OCRPreviewImageContract;
import id.dana.ocr.OCRPreviewImagePresenter;
import id.dana.ocr.OCRPreviewImagePresenter_Factory;
import id.dana.ocr.PreprocessingAndOcrPresenter;
import id.dana.ocr.views.OCRPreviewImageActivity;
import id.dana.ocr.views.OCRPreviewImageActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerOCRPreviewImageComponent {
    private DaggerOCRPreviewImageComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public PreprocessingAndOcrModule PlaceComponentResult;
        public OCRPreviewImageModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class OCRPreviewImageComponentImpl implements OCRPreviewImageComponent {
        private Provider<IsOfflineF2FPay> BuiltInFictitiousFunctionClassFactory;
        private Provider<SSLPinningRepository> GetContactSyncConfig;
        private final OCRPreviewImageComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<OCRPreviewImagePresenter> getErrorConfigVersion;
        private Provider<OCRPreviewImageContract.View> initRecordTimeStamp;
        private final PreprocessingAndOcrModule lookAheadTest;
        private Provider<CompositeDisposable> moveToNextValue;
        private Provider<OCRPreviewImageContract.Presenter> scheduleImpl;

        public /* synthetic */ OCRPreviewImageComponentImpl(OCRPreviewImageModule oCRPreviewImageModule, PreprocessingAndOcrModule preprocessingAndOcrModule, ApplicationComponent applicationComponent, byte b) {
            this(oCRPreviewImageModule, preprocessingAndOcrModule, applicationComponent);
        }

        private OCRPreviewImageComponentImpl(OCRPreviewImageModule oCRPreviewImageModule, PreprocessingAndOcrModule preprocessingAndOcrModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.PlaceComponentResult = applicationComponent;
            this.lookAheadTest = preprocessingAndOcrModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ThreadExecutorProvider(applicationComponent);
            this.GetContactSyncConfig = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda0, featureConfigRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.GetContactSyncConfig, create);
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(OCRPreviewImageModule_ProvideView$app_productionReleaseFactory.PlaceComponentResult(oCRPreviewImageModule));
            PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory = PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(preprocessingAndOcrModule);
            this.moveToNextValue = BuiltInFictitiousFunctionClassFactory;
            OCRPreviewImagePresenter_Factory PlaceComponentResult = OCRPreviewImagePresenter_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda0, BuiltInFictitiousFunctionClassFactory);
            this.getErrorConfigVersion = PlaceComponentResult;
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(OCRPreviewImageModule_ProvidePresenter$app_productionReleaseFactory.PlaceComponentResult(oCRPreviewImageModule, PlaceComponentResult));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        @Override // id.dana.di.component.OCRPreviewImageComponent
        public final void getAuthRequestContext(OCRPreviewImageActivity oCRPreviewImageActivity) {
            ((BaseActivity) oCRPreviewImageActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(oCRPreviewImageActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(oCRPreviewImageActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            OCRPreviewImageActivity_MembersInjector.PlaceComponentResult(oCRPreviewImageActivity, this.scheduleImpl.get());
            oCRPreviewImageActivity.preprocessingAndOcrPresenter = PreprocessingAndOcrModule_ProvidePresenter$app_productionReleaseFactory.PlaceComponentResult(this.lookAheadTest, new PreprocessingAndOcrPresenter(PreprocessingAndOcrModule_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest), (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto()), PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory.MyBillsEntityDataFactory(this.lookAheadTest), new GetOcrFromReceipt((ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto()), (OCRRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.V())), new GetOcrSnapLimit((OcrConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SummaryVoucherView$$ExternalSyntheticLambda2())), new GetOcrPreprocessingConfig((OcrConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SummaryVoucherView$$ExternalSyntheticLambda2()))));
        }
    }
}
