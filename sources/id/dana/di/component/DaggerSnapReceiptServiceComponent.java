package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository;
import id.dana.appcontainer.plugin.ocrreceipt.usecase.GetOcrSnapLimit;
import id.dana.danah5.ocrreceipt.usecase.GetOcrPreprocessingConfig;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.PreprocessingAndOcrModule;
import id.dana.di.modules.PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory;
import id.dana.di.modules.PreprocessingAndOcrModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.PreprocessingAndOcrModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.UploadSnapReceiptModule;
import id.dana.di.modules.UploadSnapReceiptModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.UploadSnapReceiptModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.loyalty.LoyaltyRepository;
import id.dana.domain.loyalty.interactor.GetReceiptData;
import id.dana.domain.loyalty.interactor.GetReceiptData_Factory;
import id.dana.domain.loyalty.interactor.RemoveReceiptData;
import id.dana.domain.loyalty.interactor.RemoveReceiptData_Factory;
import id.dana.domain.loyalty.interactor.SaveReceiptData;
import id.dana.domain.loyalty.interactor.SaveReceiptData_Factory;
import id.dana.domain.loyalty.interactor.SubmitSnapReceipt;
import id.dana.domain.loyalty.interactor.SubmitSnapReceipt_Factory;
import id.dana.domain.ocr.OCRRepository;
import id.dana.domain.ocr.interactor.GetOcrFromReceipt;
import id.dana.ocr.PreprocessingAndOcrPresenter;
import id.dana.ocr.UploadSnapReceiptContract;
import id.dana.ocr.UploadSnapReceiptPresenter;
import id.dana.ocr.UploadSnapReceiptPresenter_Factory;
import id.dana.ocr.views.SnapReceiptService;
import id.dana.ocr.views.SnapReceiptService_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerSnapReceiptServiceComponent {
    private DaggerSnapReceiptServiceComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public UploadSnapReceiptModule BuiltInFictitiousFunctionClassFactory;
        public PreprocessingAndOcrModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class SnapReceiptServiceComponentImpl implements SnapReceiptServiceComponent {
        private Provider<GetReceiptData> BuiltInFictitiousFunctionClassFactory;
        private Provider<UploadSnapReceiptContract.Presenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<LoyaltyRepository> MyBillsEntityDataFactory;
        private Provider<SubmitSnapReceipt> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final ApplicationComponent PlaceComponentResult;
        private final PreprocessingAndOcrModule getAuthRequestContext;
        private final SnapReceiptServiceComponentImpl getErrorConfigVersion;
        private Provider<UploadSnapReceiptPresenter> initRecordTimeStamp;
        private Provider<SaveReceiptData> lookAheadTest;
        private Provider<UploadSnapReceiptContract.View> moveToNextValue;
        private Provider<RemoveReceiptData> scheduleImpl;

        public /* synthetic */ SnapReceiptServiceComponentImpl(PreprocessingAndOcrModule preprocessingAndOcrModule, UploadSnapReceiptModule uploadSnapReceiptModule, ApplicationComponent applicationComponent, byte b) {
            this(preprocessingAndOcrModule, uploadSnapReceiptModule, applicationComponent);
        }

        private SnapReceiptServiceComponentImpl(PreprocessingAndOcrModule preprocessingAndOcrModule, UploadSnapReceiptModule uploadSnapReceiptModule, ApplicationComponent applicationComponent) {
            this.getErrorConfigVersion = this;
            this.getAuthRequestContext = preprocessingAndOcrModule;
            this.PlaceComponentResult = applicationComponent;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(UploadSnapReceiptModule_ProvideView$app_productionReleaseFactory.PlaceComponentResult(uploadSnapReceiptModule));
            LoyaltyRepositoryProvider loyaltyRepositoryProvider = new LoyaltyRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = loyaltyRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = SubmitSnapReceipt_Factory.create(loyaltyRepositoryProvider);
            this.lookAheadTest = SaveReceiptData_Factory.create(this.MyBillsEntityDataFactory);
            this.BuiltInFictitiousFunctionClassFactory = GetReceiptData_Factory.create(this.MyBillsEntityDataFactory);
            RemoveReceiptData_Factory create = RemoveReceiptData_Factory.create(this.MyBillsEntityDataFactory);
            this.scheduleImpl = create;
            UploadSnapReceiptPresenter_Factory authRequestContext = UploadSnapReceiptPresenter_Factory.getAuthRequestContext(this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, create);
            this.initRecordTimeStamp = authRequestContext;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DoubleCheck.getAuthRequestContext(UploadSnapReceiptModule_ProvidePresenter$app_productionReleaseFactory.getAuthRequestContext(uploadSnapReceiptModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class LoyaltyRepositoryProvider implements Provider<LoyaltyRepository> {
            private final ApplicationComponent PlaceComponentResult;

            LoyaltyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoyaltyRepository get() {
                return (LoyaltyRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.J());
            }
        }

        @Override // id.dana.di.component.SnapReceiptServiceComponent
        public final void BuiltInFictitiousFunctionClassFactory(SnapReceiptService snapReceiptService) {
            SnapReceiptService_MembersInjector.BuiltInFictitiousFunctionClassFactory(snapReceiptService, PreprocessingAndOcrModule_ProvidePresenter$app_productionReleaseFactory.PlaceComponentResult(this.getAuthRequestContext, new PreprocessingAndOcrPresenter(PreprocessingAndOcrModule_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext), (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto()), PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory.MyBillsEntityDataFactory(this.getAuthRequestContext), new GetOcrFromReceipt((ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto()), (OCRRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.V())), new GetOcrSnapLimit((OcrConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SummaryVoucherView$$ExternalSyntheticLambda2())), new GetOcrPreprocessingConfig((OcrConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SummaryVoucherView$$ExternalSyntheticLambda2())))));
            SnapReceiptService_MembersInjector.getAuthRequestContext(snapReceiptService, this.KClassImpl$Data$declaredNonStaticMembers$2.get());
            SnapReceiptService_MembersInjector.getAuthRequestContext(snapReceiptService, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext()));
        }
    }
}
