package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pin.LogoutPresenter;
import id.dana.challenge.pin.LogoutPresenter_Factory;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.h5event.repository.ChangePhoneNumberH5EventEntityRepository_Factory;
import id.dana.di.modules.ChangePhoneNumberH5EventModule;
import id.dana.di.modules.ChangePhoneNumberH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.ChangePhoneNumberH5EventModule_ProvideViewFactory;
import id.dana.di.modules.ChangePhoneNumberH5EventModule_ProvidesChangePhoneNumberH5EventRepositoryFactory;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.LogoutModule_ProvideLogoutPresenterFactory;
import id.dana.di.modules.LogoutModule_ProvideLogoutViewFactory;
import id.dana.di.modules.SubMenuModule;
import id.dana.di.modules.SubMenuModule_ProvideFriendshipAnalyticTrackerFactory;
import id.dana.di.modules.SubMenuModule_ProvidePresenterFactory;
import id.dana.di.modules.SubMenuModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState_Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.h5event.interactor.GetChangePhoneNumberH5Event;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.ForceLogout;
import id.dana.domain.login.interactor.ForceLogout_Factory;
import id.dana.domain.login.interactor.Logout;
import id.dana.domain.login.interactor.Logout_Factory;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useremailaddress.interactor.GetUserEmailAddress;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import id.dana.domain.usersecurityquestions.interactor.GetSecurityQuestionState;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.h5event.ChangePhoneNumberH5EventPresenter;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.kyb.domain.interactor.ClearKybData_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.myprofile.SettingMorePresenter;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.myprofile.SettingMoreProfileActivity_MembersInjector;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.settingconfig.FeedSharingConfigRunner;
import id.dana.myprofile.settingconfig.NicknameChangeConfigRunner;
import id.dana.myprofile.settingconfig.RestrictedContactConfigRunner;
import id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner;
import id.dana.myprofile.settingconfig.UsernameChangeConfigRunner;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.session.DanaSessionManager;
import id.dana.utils.session.DanaSessionManager_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSubMenuComponent {
    private DaggerSubMenuComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public LogoutModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ChangePhoneNumberH5EventModule MyBillsEntityDataFactory;
        public SubMenuModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SubMenuComponentImpl implements SubMenuComponent {
        private final SubMenuModule A;
        private Provider<ClearAllDanapolyData> BuiltInFictitiousFunctionClassFactory;
        private final SubMenuComponentImpl C;
        private Provider<DanaSessionManager> DatabaseTableConfigUtil;
        private Provider<FeedInitRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<FeatureConfigRepository> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ClearAllFeedsUsecase> MyBillsEntityDataFactory;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ContactRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<LogoutPresenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<Logout> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<DanapolyClearRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GlobalNetworkRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<KybRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ChangePhoneNumberH5EventModule PlaceComponentResult;
        private Provider<LoginRepository> PrepareContext;
        private Provider<ServicesRepository> SubSequence;
        private Provider<ThreadExecutor> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<ClearAllSyncEngineUseCase> getAuthRequestContext;
        private Provider<SSLPinningRepository> getCallingPid;
        private Provider<ClearKybData> getErrorConfigVersion;
        private Provider<LogoutContract.Presenter> getSupportButtonTintMode;
        private Provider<FaceAuthPopUpConsultationRepository> initRecordTimeStamp;
        private Provider<ForceLogout> isLayoutRequested;
        private Provider<ClearCacheFavoriteServices> lookAheadTest;
        private Provider<ClearFaceAuthSuggestionState> moveToNextValue;
        private Provider<IsOfflineF2FPay> newProxyInstance;
        private Provider<LogoutContract.View> readMicros;
        private Provider<ConnectionStatusReceiver> scheduleImpl;
        private Provider<HomeWidgetClearable> whenAvailable;

        public /* synthetic */ SubMenuComponentImpl(SubMenuModule subMenuModule, ChangePhoneNumberH5EventModule changePhoneNumberH5EventModule, LogoutModule logoutModule, ApplicationComponent applicationComponent, byte b) {
            this(subMenuModule, changePhoneNumberH5EventModule, logoutModule, applicationComponent);
        }

        private SubMenuComponentImpl(SubMenuModule subMenuModule, ChangePhoneNumberH5EventModule changePhoneNumberH5EventModule, LogoutModule logoutModule, ApplicationComponent applicationComponent) {
            this.C = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.A = subMenuModule;
            this.PlaceComponentResult = changePhoneNumberH5EventModule;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = new ThreadExecutorProvider(applicationComponent);
            this.getCallingPid = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1, this.NetworkUserEntityData$$ExternalSyntheticLambda5, featureConfigRepositoryProvider);
            this.newProxyInstance = create;
            this.scheduleImpl = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.VerifyPinStateManager$executeRiskChallenge$2$1, this.getCallingPid, create);
            this.readMicros = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutViewFactory.getAuthRequestContext(logoutModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new DeviceInformationProviderProvider(applicationComponent);
            this.PrepareContext = new LoginRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new GlobalNetworkRepositoryProvider(applicationComponent);
            ProvideHomeWidgetClearableProvider provideHomeWidgetClearableProvider = new ProvideHomeWidgetClearableProvider(applicationComponent);
            this.whenAvailable = provideHomeWidgetClearableProvider;
            this.isLayoutRequested = ForceLogout_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.PrepareContext, this.NetworkUserEntityData$$ExternalSyntheticLambda7, provideHomeWidgetClearableProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Logout_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.PrepareContext, this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = contractRepositoryProvider;
            this.getAuthRequestContext = ClearAllSyncEngineUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = provideFeedInitRepositoryProvider;
            this.MyBillsEntityDataFactory = ClearAllFeedsUsecase_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.SubSequence = servicesRepositoryProvider;
            this.lookAheadTest = ClearCacheFavoriteServices_Factory.create(servicesRepositoryProvider);
            ProvideDanapolyClearRepositoryProvider provideDanapolyClearRepositoryProvider = new ProvideDanapolyClearRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = provideDanapolyClearRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = ClearAllDanapolyData_Factory.MyBillsEntityDataFactory(provideDanapolyClearRepositoryProvider);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = kybRepositoryProvider;
            ClearKybData_Factory authRequestContext = ClearKybData_Factory.getAuthRequestContext(kybRepositoryProvider);
            this.getErrorConfigVersion = authRequestContext;
            this.DatabaseTableConfigUtil = DanaSessionManager_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, authRequestContext);
            FaceAuthPopUpConsultationRepositoryProvider faceAuthPopUpConsultationRepositoryProvider = new FaceAuthPopUpConsultationRepositoryProvider(applicationComponent);
            this.initRecordTimeStamp = faceAuthPopUpConsultationRepositoryProvider;
            ClearFaceAuthSuggestionState_Factory create2 = ClearFaceAuthSuggestionState_Factory.create(faceAuthPopUpConsultationRepositoryProvider);
            this.moveToNextValue = create2;
            Provider<LogoutPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(LogoutPresenter_Factory.getAuthRequestContext(this.readMicros, this.DatabaseTableConfigUtil, create2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = authRequestContext2;
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutPresenterFactory.BuiltInFictitiousFunctionClassFactory(logoutModule, authRequestContext2));
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
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto());
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
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent PlaceComponentResult;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent getAuthRequestContext;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SubSequence());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetClearableProvider implements Provider<HomeWidgetClearable> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideHomeWidgetClearableProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetClearable get() {
                return (HomeWidgetClearable) Preconditions.PlaceComponentResult(this.PlaceComponentResult.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideDanapolyClearRepositoryProvider implements Provider<DanapolyClearRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideDanapolyClearRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanapolyClearRepository get() {
                return (DanapolyClearRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FaceAuthPopUpConsultationRepositoryProvider implements Provider<FaceAuthPopUpConsultationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            FaceAuthPopUpConsultationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthPopUpConsultationRepository get() {
                return (FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3());
            }
        }

        @Override // id.dana.di.component.SubMenuComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SettingMoreProfileActivity settingMoreProfileActivity) {
            ((BaseActivity) settingMoreProfileActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(settingMoreProfileActivity, DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(settingMoreProfileActivity, DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig));
            settingMoreProfileActivity.presenter = SubMenuModule_ProvidePresenterFactory.PlaceComponentResult(this.A, new SettingMorePresenter((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), SubMenuModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.A), new UserInfoMapper(new CurrencyAmountModelMapper()), new UploadAvatar((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (AccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory())), new ShareFeedSettingConfigRunner((FeedsShareRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider())), new RestrictedContactConfigRunner((FeedInitRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.l()), (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())), new FeedSharingConfigRunner((FeedInitRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.l())), new NicknameChangeConfigRunner((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), (UserRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BannerEntityDataFactory_Factory()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5())), new UsernameChangeConfigRunner((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), (UserRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BannerEntityDataFactory_Factory()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5())), new GetUserInfo((UserRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BannerEntityDataFactory_Factory())), new GetAvatarUrl((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (AccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory())), new GetSettingCollection((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (SettingRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isInfoWindowShown())), new GetUserEmailAddress((UserEmailAddressRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.mo2241x461046da())), new GetSecurityQuestionState((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (UserSecurityQuestionStateRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getPhoneMask())), new SaveShareFeedConsent((FeedsShareRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider())), new CheckTwilioEnrollmentStatus((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (TwilioSdkRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.ArrayTable$2())), new GetAutoRouteInitialSetting((AutoRouteRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl())), new InitFeedWithoutContact((FeedInitRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.l()), (FeedsShareRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider()))));
            SettingMoreProfileActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(settingMoreProfileActivity, SubMenuModule_ProvideFriendshipAnalyticTrackerFactory.BuiltInFictitiousFunctionClassFactory(this.A, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
            SettingMoreProfileActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(settingMoreProfileActivity, (ProductPageManager) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.shouldRecycleViewType()));
            SettingMoreProfileActivity_MembersInjector.PlaceComponentResult(settingMoreProfileActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext()));
            settingMoreProfileActivity.logoutPresenter = this.getSupportButtonTintMode.get();
            SettingMoreProfileActivity_MembersInjector.getAuthRequestContext(settingMoreProfileActivity, ChangePhoneNumberH5EventModule_ProvidePresenterFactory.PlaceComponentResult(this.PlaceComponentResult, new ChangePhoneNumberH5EventPresenter(new GetChangePhoneNumberH5Event((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), ChangePhoneNumberH5EventModule_ProvidesChangePhoneNumberH5EventRepositoryFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, ChangePhoneNumberH5EventEntityRepository_Factory.newInstance())), ChangePhoneNumberH5EventModule_ProvideViewFactory.getAuthRequestContext(this.PlaceComponentResult))));
        }
    }
}
