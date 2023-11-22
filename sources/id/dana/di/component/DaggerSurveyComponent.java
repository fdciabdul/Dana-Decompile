package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.base.BaseResponseMapper_Factory;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.contract.homeinfo.HomeInfoModule;
import id.dana.contract.homeinfo.HomeInfoModule_ProvidePresenterFactory;
import id.dana.contract.homeinfo.HomeInfoModule_ProvideViewFactory;
import id.dana.contract.homeinfo.HomeInfoPresenter;
import id.dana.contract.homeinfo.HomeInfoPresenter_Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.interactor.GetHomeInfo_Factory;
import id.dana.domain.homeinfo.interactor.GetPaylaterChannel;
import id.dana.domain.homeinfo.interactor.GetPaylaterChannel_Factory;
import id.dana.domain.homeinfo.interactor.GetProcessingTransaction;
import id.dana.domain.homeinfo.interactor.GetProcessingTransaction_Factory;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo_Factory;
import id.dana.domain.homeinfo.interactor.GetUpdatedHomeData;
import id.dana.domain.homeinfo.interactor.GetUpdatedHomeData_Factory;
import id.dana.domain.homeinfo.interactor.GetUserConfig;
import id.dana.domain.homeinfo.interactor.GetUserConfig_Factory;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm_Factory;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.interactor.SetPaylaterChannel;
import id.dana.domain.paylater.interactor.SetPaylaterChannel_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip_Factory;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.feeds.mapper.FeedsModelMapper_Factory;
import id.dana.mapper.HasNewModelMapper_Factory;
import id.dana.mapper.HomeDataModelMapper;
import id.dana.mapper.HomeDataModelMapper_Factory;
import id.dana.mapper.HomeInfoMapper;
import id.dana.mapper.HomeInfoMapper_Factory;
import id.dana.mapper.PromotionMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper_Factory;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper_Factory;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper_Factory;
import id.dana.nearbyme.merchantdetail.mapper.MerchantAverageRatingMapper_Factory;
import id.dana.richview.SurveyView;
import id.dana.richview.SurveyView_MembersInjector;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.GetConfigRepeatBackgroundJobUseCase;
import id.dana.sync_engine.domain.interactor.GetConfigRepeatBackgroundJobUseCase_Factory;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission_Factory;
import id.dana.sync_engine.domain.interactor.GetSyncPermissionConfigUseCase;
import id.dana.sync_engine.domain.interactor.GetSyncPermissionConfigUseCase_Factory;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerSurveyComponent {
    private DaggerSurveyComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public HomeInfoModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class SurveyComponentImpl implements SurveyComponent {
        private Provider<SaveIsSyncPermission> A;
        private final SurveyComponentImpl B;
        private Provider<ServiceCategoryMapper> BottomSheetCardBindingView$watcherCardNumberView$1;
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<SaveShowToolTip> C;
        private Provider<GetUpdatedHomeData> DatabaseTableConfigUtil;
        private Provider<NearbyShopsModelMapper> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetSyncPermissionConfigUseCase> GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<GetPaylaterChannel> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetUserConfig> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetSurveyInfo> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<MerchantReviewFormRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<HomeOmniRepository> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<MerchantInfoRepository> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<HomeInfoRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<HomeInfoMapper> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ContactRepository> PlaceComponentResult;
        private Provider<HomeInfoPresenter> PrepareContext;
        private Provider<StartupConfigEntityData> SubSequence;
        private Provider<SetPaylaterChannel> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<ThirdPartyServicesMapper> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetConfigRepeatBackgroundJobUseCase> getAuthRequestContext;
        private Provider<HomeInfoContract.Presenter> getCallingPid;
        private Provider<GetMerchantReviewSummary> getErrorConfigVersion;
        private Provider<ThreadExecutor> getOnBoardingScenario;
        private Provider<HomeInfoContract.View> getSupportButtonTintMode;
        private Provider<UserEducationRepository> getValueOfTouchPositionAbsolute;
        private Provider<GetReviewableMerchantForm> initRecordTimeStamp;
        private Provider<IsNeedToShowToolTip> isLayoutRequested;
        private Provider<GetProcessingTransaction> lookAheadTest;
        private Provider<GetIsSyncPermission> moveToNextValue;
        private Provider<HomeDataModelMapper> newProxyInstance;
        private Provider<PaylaterRepository> readMicros;
        private Provider<GetHomeInfo> scheduleImpl;
        private Provider<RecentRecipientRepository> whenAvailable;

        public /* synthetic */ SurveyComponentImpl(HomeInfoModule homeInfoModule, ApplicationComponent applicationComponent, byte b) {
            this(homeInfoModule, applicationComponent);
        }

        private SurveyComponentImpl(HomeInfoModule homeInfoModule, ApplicationComponent applicationComponent) {
            FeedsModelMapper_Factory feedsModelMapper_Factory;
            ShopOpenHourListMapper_Factory shopOpenHourListMapper_Factory;
            this.B = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(HomeInfoModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(homeInfoModule));
            this.getOnBoardingScenario = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new PostExecutionThreadProvider(applicationComponent);
            HomeRepositoryProvider homeRepositoryProvider = new HomeRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = homeRepositoryProvider;
            this.scheduleImpl = GetHomeInfo_Factory.create(this.getOnBoardingScenario, this.NetworkUserEntityData$$ExternalSyntheticLambda6, homeRepositoryProvider);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            ServiceCategoryMapper_Factory authRequestContext = ServiceCategoryMapper_Factory.getAuthRequestContext(contextProvider);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = authRequestContext;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = HomeInfoMapper_Factory.PlaceComponentResult(BaseResponseMapper_Factory.MyBillsEntityDataFactory(), CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.DatabaseTableConfigUtil = GetUpdatedHomeData_Factory.create(this.getOnBoardingScenario, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            Provider<HomeInfoMapper> provider = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            PromotionMapper_Factory BuiltInFictitiousFunctionClassFactory = PromotionMapper_Factory.BuiltInFictitiousFunctionClassFactory();
            feedsModelMapper_Factory = FeedsModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.newProxyInstance = HomeDataModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(provider, BuiltInFictitiousFunctionClassFactory, feedsModelMapper_Factory, HasNewModelMapper_Factory.MyBillsEntityDataFactory());
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.getValueOfTouchPositionAbsolute = userEducationRepositoryProvider;
            this.isLayoutRequested = IsNeedToShowToolTip_Factory.create(this.getOnBoardingScenario, this.NetworkUserEntityData$$ExternalSyntheticLambda6, userEducationRepositoryProvider);
            this.C = SaveShowToolTip_Factory.create(this.getOnBoardingScenario, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.getValueOfTouchPositionAbsolute);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new ProvideMerchantReviewRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new MerchantInfoRepositoryProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            this.initRecordTimeStamp = GetReviewableMerchantForm_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda5, featureConfigRepositoryProvider);
            MerchantSubcategoriesMapper_Factory authRequestContext2 = MerchantSubcategoriesMapper_Factory.getAuthRequestContext();
            shopOpenHourListMapper_Factory = ShopOpenHourListMapper_Factory.InstanceHolder.getAuthRequestContext;
            this.FragmentBottomSheetPaymentSettingBinding = NearbyShopsModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext2, shopOpenHourListMapper_Factory);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.whenAvailable = recentRecipientRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetUserConfig_Factory.create(this.getOnBoardingScenario, this.NetworkUserEntityData$$ExternalSyntheticLambda6, recentRecipientRepositoryProvider);
            this.getErrorConfigVersion = GetMerchantReviewSummary_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = contractRepositoryProvider;
            this.GetContactSyncConfig = GetSyncPermissionConfigUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            this.moveToNextValue = GetIsSyncPermission_Factory.PlaceComponentResult(this.PlaceComponentResult);
            this.A = SaveIsSyncPermission_Factory.MyBillsEntityDataFactory(this.PlaceComponentResult);
            this.getAuthRequestContext = GetConfigRepeatBackgroundJobUseCase_Factory.getAuthRequestContext(this.PlaceComponentResult);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.readMicros = providePaylaterRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = SetPaylaterChannel_Factory.create(providePaylaterRepositoryProvider);
            this.SubSequence = new ProvideStartupConfigEntityDataProvider(applicationComponent);
            ProvideHomeOmniRepositoryProvider provideHomeOmniRepositoryProvider = new ProvideHomeOmniRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = provideHomeOmniRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetSurveyInfo_Factory.create(provideHomeOmniRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetPaylaterChannel_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.lookAheadTest = GetProcessingTransaction_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            Provider<HomeInfoPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(HomeInfoPresenter_Factory.getAuthRequestContext(this.getSupportButtonTintMode, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.DatabaseTableConfigUtil, this.newProxyInstance, this.isLayoutRequested, this.C, this.initRecordTimeStamp, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getErrorConfigVersion, this.GetContactSyncConfig, this.moveToNextValue, this.A, this.getAuthRequestContext, MerchantAverageRatingMapper_Factory.PlaceComponentResult(), this.VerifyPinStateManager$executeRiskChallenge$2$1, this.SubSequence, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest));
            this.PrepareContext = authRequestContext3;
            this.getCallingPid = DoubleCheck.getAuthRequestContext(HomeInfoModule_ProvidePresenterFactory.MyBillsEntityDataFactory(homeInfoModule, authRequestContext3));
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
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class HomeRepositoryProvider implements Provider<HomeInfoRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            HomeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeInfoRepository get() {
                return (HomeInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ProvideMerchantReviewRepositoryProvider implements Provider<MerchantReviewFormRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideMerchantReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantReviewFormRepository get() {
                return (MerchantReviewFormRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent PlaceComponentResult;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.access$setShowcaseShowing$p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ProvidePaylaterRepositoryProvider implements Provider<PaylaterRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.setNetAuthId());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ProvideStartupConfigEntityDataProvider implements Provider<StartupConfigEntityData> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideStartupConfigEntityDataProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ StartupConfigEntityData get() {
                return (StartupConfigEntityData) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.onDecodeSuccess());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ProvideHomeOmniRepositoryProvider implements Provider<HomeOmniRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideHomeOmniRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeOmniRepository get() {
                return (HomeOmniRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.t());
            }
        }

        @Override // id.dana.di.component.SurveyComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SurveyView surveyView) {
            SurveyView_MembersInjector.PlaceComponentResult(surveyView, this.getCallingPid.get());
            SurveyView_MembersInjector.MyBillsEntityDataFactory(surveyView, (StartupConfigEntityData) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.onDecodeSuccess()));
        }
    }
}
