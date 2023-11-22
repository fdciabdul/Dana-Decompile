package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.base.BaseResponseMapper;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideProfilePresenterFactory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideProfileViewFactory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideTransferPresenterFactory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideTransferViewFactory;
import id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter;
import id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter_Factory;
import id.dana.contract.deeplink.generation.TransferQrDeepLinkPresenter;
import id.dana.contract.deeplink.generation.TransferQrDeepLinkPresenter_Factory;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.contract.staticqr.GetStaticQrModule_ProvidePresenterFactory;
import id.dana.contract.staticqr.GetStaticQrModule_ProvideViewFactory;
import id.dana.contract.staticqr.GetStaticQrPresenter;
import id.dana.contract.staticqr.GetStaticQrPresenter_Factory;
import id.dana.di.modules.RequestMoneyQrModule;
import id.dana.di.modules.RequestMoneyQrModule_ProvidePresenterFactory;
import id.dana.di.modules.RequestMoneyQrModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink_Factory;
import id.dana.domain.deeplink.interactor.GenerateTransferQrDeepLink;
import id.dana.domain.deeplink.interactor.GenerateTransferQrDeepLink_Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckBranchDeepLinkFeature;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.interactor.GetTransferQr;
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr;
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr_Factory;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr_Factory;
import id.dana.mapper.HomeInfoMapper;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.requestmoney.BaseRequestMoneyQrCardFragment_MembersInjector;
import id.dana.requestmoney.RequestMoneyQrPresenter;
import id.dana.requestmoney.RequestMoneyQrPresenter_Factory;
import id.dana.requestmoney.RequestMoneyQrPresenter_MembersInjector;
import id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment;
import id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment_MembersInjector;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import id.dana.sendmoney_v2.tracker.ApiHitTimer_Factory;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerRequestMoneyQrComponent {
    private DaggerRequestMoneyQrComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public RequestMoneyQrModule BuiltInFictitiousFunctionClassFactory;
        public GenerateDeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public SendMoneyTrackerModule PlaceComponentResult;
        public GetStaticQrModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class RequestMoneyQrComponentImpl implements RequestMoneyQrComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<ProfileQrDeepLinkPresenter> DatabaseTableConfigUtil;
        private Provider<SendMoneyMixpanelTracker> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GenerateDeepLinkContract.ProfilePresenter> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GenerateProfileQrDeepLink> MyBillsEntityDataFactory;
        private Provider<GetQrisTcicoConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetStaticQrContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GenerateDeepLinkContract.ProfileView> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private final RequestMoneyQrComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private final RequestMoneyQrModule NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<TransferQrDeepLinkPresenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GenerateDeepLinkContract.TransferPresenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<QrBarcodeRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<GenerateDeepLinkContract.TransferView> PrepareContext;
        private Provider<GenerateLinkRepository> getAuthRequestContext;
        private Provider<GenerateTransferQrDeepLink> getErrorConfigVersion;
        private Provider<PostExecutionThread> initRecordTimeStamp;
        private Provider<SendMoneyAnalyticTracker> isLayoutRequested;
        private Provider<GetUserDynamicQr> lookAheadTest;
        private Provider<GetUserStaticQr> moveToNextValue;
        private Provider<GetStaticQrContract.View> newProxyInstance;
        private Provider<GetStaticQrPresenter> scheduleImpl;

        public /* synthetic */ RequestMoneyQrComponentImpl(RequestMoneyQrModule requestMoneyQrModule, GetStaticQrModule getStaticQrModule, GenerateDeepLinkModule generateDeepLinkModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(requestMoneyQrModule, getStaticQrModule, generateDeepLinkModule, sendMoneyTrackerModule, applicationComponent);
        }

        private RequestMoneyQrComponentImpl(RequestMoneyQrModule requestMoneyQrModule, GetStaticQrModule getStaticQrModule, GenerateDeepLinkModule generateDeepLinkModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent) {
            ApiHitTimer_Factory apiHitTimer_Factory;
            ApiHitTimer_Factory apiHitTimer_Factory2;
            ApiHitTimer_Factory apiHitTimer_Factory3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = this;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = requestMoneyQrModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ThreadExecutorProvider(applicationComponent);
            this.initRecordTimeStamp = new PostExecutionThreadProvider(applicationComponent);
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = generateLinkRepositoryProvider;
            this.getErrorConfigVersion = GenerateTransferQrDeepLink_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.initRecordTimeStamp, generateLinkRepositoryProvider);
            Provider<GenerateDeepLinkContract.TransferView> authRequestContext = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideTransferViewFactory.BuiltInFictitiousFunctionClassFactory(generateDeepLinkModule));
            this.PrepareContext = authRequestContext;
            Provider<Context> provider = this.PlaceComponentResult;
            Provider<GenerateTransferQrDeepLink> provider2 = this.getErrorConfigVersion;
            apiHitTimer_Factory = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<TransferQrDeepLinkPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(TransferQrDeepLinkPresenter_Factory.MyBillsEntityDataFactory(provider, provider2, authRequestContext, apiHitTimer_Factory));
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideTransferPresenterFactory.getAuthRequestContext(generateDeepLinkModule, authRequestContext2));
            this.MyBillsEntityDataFactory = GenerateProfileQrDeepLink_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.initRecordTimeStamp, this.getAuthRequestContext);
            Provider<GenerateDeepLinkContract.ProfileView> authRequestContext3 = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfileViewFactory.MyBillsEntityDataFactory(generateDeepLinkModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext3;
            Provider<Context> provider3 = this.PlaceComponentResult;
            Provider<GenerateProfileQrDeepLink> provider4 = this.MyBillsEntityDataFactory;
            apiHitTimer_Factory2 = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<ProfileQrDeepLinkPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(ProfileQrDeepLinkPresenter_Factory.PlaceComponentResult(provider3, provider4, authRequestContext3, apiHitTimer_Factory2));
            this.DatabaseTableConfigUtil = authRequestContext4;
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfilePresenterFactory.PlaceComponentResult(generateDeepLinkModule, authRequestContext4));
            SendMoneyMixpanelTracker_Factory authRequestContext5 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(this.PlaceComponentResult);
            this.FragmentBottomSheetPaymentSettingBinding = authRequestContext5;
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext5));
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(GetStaticQrModule_ProvideViewFactory.MyBillsEntityDataFactory(getStaticQrModule));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = qrBarcodeRepositoryProvider;
            this.moveToNextValue = GetUserStaticQr_Factory.create(qrBarcodeRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            this.lookAheadTest = GetUserDynamicQr_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, featureConfigRepositoryProvider);
            GetQrisTcicoConfig_Factory create = GetQrisTcicoConfig_Factory.create(this.BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            Provider<Context> provider5 = this.PlaceComponentResult;
            Provider<GetStaticQrContract.View> provider6 = this.newProxyInstance;
            Provider<GetUserStaticQr> provider7 = this.moveToNextValue;
            Provider<GetUserDynamicQr> provider8 = this.lookAheadTest;
            apiHitTimer_Factory3 = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<GetStaticQrPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(GetStaticQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(provider5, provider6, provider7, provider8, create, apiHitTimer_Factory3));
            this.scheduleImpl = authRequestContext6;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(GetStaticQrModule_ProvidePresenterFactory.PlaceComponentResult(getStaticQrModule, authRequestContext6));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SendMoneyScenario());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.RequestMoneyQrComponent
        public final void BuiltInFictitiousFunctionClassFactory(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment) {
            RequestMoneyQrModule requestMoneyQrModule = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            RequestMoneyQrPresenter authRequestContext = RequestMoneyQrPresenter_Factory.getAuthRequestContext((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), new GetAvatarUrl((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (AccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory())), new GetTransferQr((QrBarcodeRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SendMoneyScenario()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5())), RequestMoneyQrModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda5), new CheckBranchDeepLinkFeature((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5())), new GetQrisTcicoConfig((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5())), new ApiHitTimer());
            RequestMoneyQrPresenter_MembersInjector.MyBillsEntityDataFactory(authRequestContext, new GetHomeInfo((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (HomeInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.B())), new HomeInfoMapper(new BaseResponseMapper(), new CurrencyAmountModelMapper(), new ThirdPartyServicesMapper(new ServiceCategoryMapper((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())))));
            RequestMoneyQrPresenter_MembersInjector.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, new GetRequestMoneyInfoFeature((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5())), new RequestMoneyInfoModelMapper());
            BaseRequestMoneyQrCardFragment_MembersInjector.MyBillsEntityDataFactory(requestMoneyBalanceQrCardFragment, RequestMoneyQrModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(requestMoneyQrModule, authRequestContext));
            requestMoneyBalanceQrCardFragment.transferDeepLinkPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
            BaseRequestMoneyQrCardFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(requestMoneyBalanceQrCardFragment, this.GetContactSyncConfig.get());
            BaseRequestMoneyQrCardFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(requestMoneyBalanceQrCardFragment, this.isLayoutRequested.get());
            RequestMoneyBalanceQrCardFragment_MembersInjector.getAuthRequestContext(requestMoneyBalanceQrCardFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }
    }
}
