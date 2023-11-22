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
import id.dana.di.modules.RequestMoneyQrModule;
import id.dana.di.modules.RequestMoneyQrModule_ProvidePresenterFactory;
import id.dana.di.modules.RequestMoneyQrModule_ProvideViewFactory;
import id.dana.di.modules.UserBankModule;
import id.dana.di.modules.UserBankModule_ProvidePresenterFactory;
import id.dana.di.modules.UserBankModule_ProvideViewFactory;
import id.dana.di.modules.UserBankQrModule;
import id.dana.di.modules.UserBankQrModule_ProvidePresenterFactory;
import id.dana.di.modules.UserBankQrModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.bank.interactor.AddUserBank;
import id.dana.domain.bank.interactor.DeleteUserBank;
import id.dana.domain.bank.interactor.GetUserBanks;
import id.dana.domain.bank.interactor.InitRequestMoney;
import id.dana.domain.bank.interactor.SaveUserBanks;
import id.dana.domain.bank.repository.UserBankRepository;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink_Factory;
import id.dana.domain.deeplink.interactor.GenerateTransferQrDeepLink;
import id.dana.domain.deeplink.interactor.GenerateTransferQrDeepLink_Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckBranchDeepLinkFeature;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.interactor.GetBankQr;
import id.dana.domain.qrbarcode.interactor.GetBankTransferQr;
import id.dana.domain.qrbarcode.interactor.GetTransferQr;
import id.dana.mapper.HomeInfoMapper;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.requestmoney.BaseRequestMoneyQrCardFragment_MembersInjector;
import id.dana.requestmoney.RequestMoneyQrPresenter;
import id.dana.requestmoney.RequestMoneyQrPresenter_Factory;
import id.dana.requestmoney.RequestMoneyQrPresenter_MembersInjector;
import id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment;
import id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment_MembersInjector;
import id.dana.requestmoney.bank.UserBankPresenter;
import id.dana.requestmoney.bank.UserBankQrPresenter;
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
public final class DaggerUserBankCardComponent {
    private DaggerUserBankCardComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public SendMoneyTrackerModule KClassImpl$Data$declaredNonStaticMembers$2;
        public UserBankModule MyBillsEntityDataFactory;
        public RequestMoneyQrModule PlaceComponentResult;
        public GenerateDeepLinkModule getAuthRequestContext;
        public UserBankQrModule moveToNextValue;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class UserBankCardComponentImpl implements UserBankCardComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<GenerateDeepLinkContract.TransferView> DatabaseTableConfigUtil;
        private Provider<SendMoneyMixpanelTracker> GetContactSyncConfig;
        private Provider<GenerateLinkRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<Context> MyBillsEntityDataFactory;
        private Provider<GenerateDeepLinkContract.ProfileView> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private final RequestMoneyQrModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        private final UserBankCardComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GenerateProfileQrDeepLink> PlaceComponentResult;
        private final UserBankModule PrepareContext;
        private Provider<GenerateTransferQrDeepLink> getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<GenerateDeepLinkContract.TransferPresenter> initRecordTimeStamp;
        private final UserBankQrModule isLayoutRequested;
        private Provider<ProfileQrDeepLinkPresenter> lookAheadTest;
        private Provider<SendMoneyAnalyticTracker> moveToNextValue;
        private Provider<TransferQrDeepLinkPresenter> newProxyInstance;
        private Provider<GenerateDeepLinkContract.ProfilePresenter> scheduleImpl;

        public /* synthetic */ UserBankCardComponentImpl(RequestMoneyQrModule requestMoneyQrModule, GenerateDeepLinkModule generateDeepLinkModule, UserBankModule userBankModule, UserBankQrModule userBankQrModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(requestMoneyQrModule, generateDeepLinkModule, userBankModule, userBankQrModule, sendMoneyTrackerModule, applicationComponent);
        }

        private UserBankCardComponentImpl(RequestMoneyQrModule requestMoneyQrModule, GenerateDeepLinkModule generateDeepLinkModule, UserBankModule userBankModule, UserBankQrModule userBankQrModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent) {
            ApiHitTimer_Factory apiHitTimer_Factory;
            ApiHitTimer_Factory apiHitTimer_Factory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = this;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = requestMoneyQrModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.PrepareContext = userBankModule;
            this.isLayoutRequested = userBankQrModule;
            this.MyBillsEntityDataFactory = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ThreadExecutorProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = generateLinkRepositoryProvider;
            this.getAuthRequestContext = GenerateTransferQrDeepLink_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getErrorConfigVersion, generateLinkRepositoryProvider);
            Provider<GenerateDeepLinkContract.TransferView> authRequestContext = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideTransferViewFactory.BuiltInFictitiousFunctionClassFactory(generateDeepLinkModule));
            this.DatabaseTableConfigUtil = authRequestContext;
            Provider<Context> provider = this.MyBillsEntityDataFactory;
            Provider<GenerateTransferQrDeepLink> provider2 = this.getAuthRequestContext;
            apiHitTimer_Factory = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<TransferQrDeepLinkPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(TransferQrDeepLinkPresenter_Factory.MyBillsEntityDataFactory(provider, provider2, authRequestContext, apiHitTimer_Factory));
            this.newProxyInstance = authRequestContext2;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideTransferPresenterFactory.getAuthRequestContext(generateDeepLinkModule, authRequestContext2));
            this.PlaceComponentResult = GenerateProfileQrDeepLink_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2);
            Provider<GenerateDeepLinkContract.ProfileView> authRequestContext3 = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfileViewFactory.MyBillsEntityDataFactory(generateDeepLinkModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext3;
            Provider<Context> provider3 = this.MyBillsEntityDataFactory;
            Provider<GenerateProfileQrDeepLink> provider4 = this.PlaceComponentResult;
            apiHitTimer_Factory2 = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<ProfileQrDeepLinkPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(ProfileQrDeepLinkPresenter_Factory.PlaceComponentResult(provider3, provider4, authRequestContext3, apiHitTimer_Factory2));
            this.lookAheadTest = authRequestContext4;
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfilePresenterFactory.PlaceComponentResult(generateDeepLinkModule, authRequestContext4));
            SendMoneyMixpanelTracker_Factory authRequestContext5 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(this.MyBillsEntityDataFactory);
            this.GetContactSyncConfig = authRequestContext5;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext5));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent getAuthRequestContext;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.UserBankCardComponent
        public final void getAuthRequestContext(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment) {
            RequestMoneyQrModule requestMoneyQrModule = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            RequestMoneyQrPresenter authRequestContext = RequestMoneyQrPresenter_Factory.getAuthRequestContext((Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()), new GetAvatarUrl((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (AccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory())), new GetTransferQr((QrBarcodeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SendMoneyScenario()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())), RequestMoneyQrModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda2), new CheckBranchDeepLinkFeature((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())), new GetQrisTcicoConfig((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())), new ApiHitTimer());
            RequestMoneyQrPresenter_MembersInjector.MyBillsEntityDataFactory(authRequestContext, new GetHomeInfo((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (HomeInfoRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.B())), new HomeInfoMapper(new BaseResponseMapper(), new CurrencyAmountModelMapper(), new ThirdPartyServicesMapper(new ServiceCategoryMapper((Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue())))));
            RequestMoneyQrPresenter_MembersInjector.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, new GetRequestMoneyInfoFeature((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())), new RequestMoneyInfoModelMapper());
            BaseRequestMoneyQrCardFragment_MembersInjector.MyBillsEntityDataFactory(requestMoneyBankQrCardFragment, RequestMoneyQrModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(requestMoneyQrModule, authRequestContext));
            requestMoneyBankQrCardFragment.transferDeepLinkPresenter = this.initRecordTimeStamp.get();
            BaseRequestMoneyQrCardFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(requestMoneyBankQrCardFragment, this.scheduleImpl.get());
            BaseRequestMoneyQrCardFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(requestMoneyBankQrCardFragment, this.moveToNextValue.get());
            RequestMoneyBankQrCardFragment_MembersInjector.MyBillsEntityDataFactory(requestMoneyBankQrCardFragment, UserBankModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext, new UserBankPresenter(UserBankModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext), new GetUserBanks((UserBankRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.access$getCapacity$p())), new SaveUserBanks((UserBankRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.access$getCapacity$p())), new AddUserBank((UserBankRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.access$getCapacity$p())), new DeleteUserBank((UserBankRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.access$getCapacity$p())), new InitRequestMoney((UserBankRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.access$getCapacity$p())))));
            RequestMoneyBankQrCardFragment_MembersInjector.MyBillsEntityDataFactory(requestMoneyBankQrCardFragment, UserBankQrModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, new UserBankQrPresenter((Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()), UserBankQrModule_ProvideViewFactory.PlaceComponentResult(this.isLayoutRequested), new GetBankQr((QrBarcodeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SendMoneyScenario())), new GetBankTransferQr((QrBarcodeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SendMoneyScenario())), new ApiHitTimer())));
        }
    }
}
