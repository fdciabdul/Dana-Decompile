package id.dana.myprofile.mepagerevamp.securitysettings;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.GetAvatarUrl_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetAuthenticationTypeFeature;
import id.dana.domain.featureconfig.interactor.GetAuthenticationTypeFeature_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.profilemenu.interactor.GetSettingCollection_Factory;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.user.interactor.GetUserInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.usercredential.CredentialRepository;
import id.dana.domain.usercredential.interactor.GetPasswordLastModifiedWithConfigChecking;
import id.dana.domain.usercredential.interactor.GetPasswordLastModifiedWithConfigChecking_Factory;
import id.dana.domain.usersecurityquestions.interactor.GetSecurityQuestionState;
import id.dana.domain.usersecurityquestions.interactor.GetSecurityQuestionState_Factory;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.UserInfoMapper_Factory;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.mepagerevamp.MePageRevampModule;
import id.dana.myprofile.mepagerevamp.MePageRevampModule_ProvidePresenterFactory;
import id.dana.myprofile.mepagerevamp.MePageRevampModule_ProvideViewFactory;
import id.dana.myprofile.mepagerevamp.MePageRevampPresenter;
import id.dana.myprofile.mepagerevamp.MePageRevampPresenter_Factory;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract;
import id.dana.myprofile.settingconfig.FeedSharingConfigRunner;
import id.dana.myprofile.settingconfig.FeedSharingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.NicknameChangeConfigRunner;
import id.dana.myprofile.settingconfig.NicknameChangeConfigRunner_Factory;
import id.dana.myprofile.settingconfig.RestrictedContactConfigRunner;
import id.dana.myprofile.settingconfig.RestrictedContactConfigRunner_Factory;
import id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner;
import id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.UsernameChangeConfigRunner;
import id.dana.myprofile.settingconfig.UsernameChangeConfigRunner_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerSecuritySettingsComponent {
    private DaggerSecuritySettingsComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        MePageRevampModule KClassImpl$Data$declaredNonStaticMembers$2;
        ApplicationComponent MyBillsEntityDataFactory;
        SecuritySettingsModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    static final class SecuritySettingsComponentImpl implements SecuritySettingsComponent {
        private Provider<UsernameChangeConfigRunner> A;
        private Provider<ThreadExecutor> B;
        private Provider<UserSecurityQuestionStateRepository> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<Context> BuiltInFictitiousFunctionClassFactory;
        private Provider<UserRepository> C;
        private Provider<IsOfflineF2FPay> DatabaseTableConfigUtil;
        private Provider<RestrictedContactConfigRunner> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetSecurityQuestionState> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<GetAuthenticationTypeFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetUserInfo> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetSettingCollection> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SecuritySettingsContract.View> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<SecuritySettingsContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<MePageRevampContract.View> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<MePageRevampContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<CredentialRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<AccountRepository> PlaceComponentResult;
        private Provider<NicknameChangeConfigRunner> PrepareContext;
        private Provider<ShareFeedSettingConfigRunner> SubSequence;
        private Provider<UserInfoMapper> VerifyPinStateManager$executeRiskChallenge$2$1;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<SettingRepository> getCallingPid;
        private Provider<GetResetAndChangePinNativeEntryConfig> getErrorConfigVersion;
        private Provider<SecuritySettingsPresenter> getSupportButtonTintMode;
        private Provider<MePageRevampPresenter> initRecordTimeStamp;
        private Provider<FeedsShareRepository> isLayoutRequested;
        private Provider<GetPasswordLastModifiedWithConfigChecking> lookAheadTest;
        private Provider<GetAvatarUrl> moveToNextValue;
        private Provider<FeedInitRepository> newProxyInstance;
        private final SecuritySettingsComponentImpl readMicros;
        private Provider<FeedSharingConfigRunner> scheduleImpl;
        private Provider<SSLPinningRepository> whenAvailable;

        public /* synthetic */ SecuritySettingsComponentImpl(SecuritySettingsModule securitySettingsModule, MePageRevampModule mePageRevampModule, ApplicationComponent applicationComponent, byte b) {
            this(securitySettingsModule, mePageRevampModule, applicationComponent);
        }

        private SecuritySettingsComponentImpl(SecuritySettingsModule securitySettingsModule, MePageRevampModule mePageRevampModule, ApplicationComponent applicationComponent) {
            this.readMicros = this;
            this.getAuthRequestContext = applicationComponent;
            this.B = new ThreadExecutorProvider(applicationComponent);
            this.whenAvailable = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.B, this.NetworkUserEntityData$$ExternalSyntheticLambda8, featureConfigRepositoryProvider);
            this.DatabaseTableConfigUtil = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.B, this.whenAvailable, create);
            this.BuiltInFictitiousFunctionClassFactory = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(MePageRevampModule_ProvideViewFactory.getAuthRequestContext(mePageRevampModule));
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getCallingPid = settingRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetSettingCollection_Factory.create(this.B, this.NetworkUserEntityData$$ExternalSyntheticLambda8, settingRepositoryProvider);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = accountRepositoryProvider;
            this.moveToNextValue = GetAvatarUrl_Factory.create(this.B, this.NetworkUserEntityData$$ExternalSyntheticLambda8, accountRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.newProxyInstance = provideFeedInitRepositoryProvider;
            this.scheduleImpl = FeedSharingConfigRunner_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.isLayoutRequested = provideFeedsShareRepositoryProvider;
            this.SubSequence = ShareFeedSettingConfigRunner_Factory.getAuthRequestContext(provideFeedsShareRepositoryProvider);
            this.FragmentBottomSheetPaymentSettingBinding = RestrictedContactConfigRunner_Factory.BuiltInFictitiousFunctionClassFactory(this.newProxyInstance, this.BuiltInFictitiousFunctionClassFactory);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.C = userRepositoryProvider;
            this.PrepareContext = NicknameChangeConfigRunner_Factory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, userRepositoryProvider, this.KClassImpl$Data$declaredNonStaticMembers$2);
            UsernameChangeConfigRunner_Factory MyBillsEntityDataFactory = UsernameChangeConfigRunner_Factory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.C, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.A = MyBillsEntityDataFactory;
            MePageRevampPresenter_Factory MyBillsEntityDataFactory2 = MePageRevampPresenter_Factory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, this.scheduleImpl, this.SubSequence, this.FragmentBottomSheetPaymentSettingBinding, this.PrepareContext, MyBillsEntityDataFactory);
            this.initRecordTimeStamp = MyBillsEntityDataFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(MePageRevampModule_ProvidePresenterFactory.PlaceComponentResult(mePageRevampModule, MyBillsEntityDataFactory2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(SecuritySettingsModule_ProvideViewFactory.PlaceComponentResult(securitySettingsModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetUserInfo_Factory.create(this.C);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = UserInfoMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            UserSecurityQuestionStateRepositoryProvider userSecurityQuestionStateRepositoryProvider = new UserSecurityQuestionStateRepositoryProvider(applicationComponent);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = userSecurityQuestionStateRepositoryProvider;
            this.GetContactSyncConfig = GetSecurityQuestionState_Factory.create(this.B, this.NetworkUserEntityData$$ExternalSyntheticLambda8, userSecurityQuestionStateRepositoryProvider);
            ProvideCredentialRepositoryProvider provideCredentialRepositoryProvider = new ProvideCredentialRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provideCredentialRepositoryProvider;
            this.lookAheadTest = GetPasswordLastModifiedWithConfigChecking_Factory.create(provideCredentialRepositoryProvider);
            this.getErrorConfigVersion = GetResetAndChangePinNativeEntryConfig_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            GetAuthenticationTypeFeature_Factory create2 = GetAuthenticationTypeFeature_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create2;
            SecuritySettingsPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = SecuritySettingsPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.GetContactSyncConfig, this.lookAheadTest, this.getErrorConfigVersion, create2);
            this.getSupportButtonTintMode = KClassImpl$Data$declaredNonStaticMembers$2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(SecuritySettingsModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(securitySettingsModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent PlaceComponentResult;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SettingRepositoryProvider implements Provider<SettingRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isInfoWindowShown());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideFeedsShareRepositoryProvider implements Provider<FeedsShareRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFeedsShareRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsShareRepository get() {
                return (FeedsShareRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class UserSecurityQuestionStateRepositoryProvider implements Provider<UserSecurityQuestionStateRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserSecurityQuestionStateRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserSecurityQuestionStateRepository get() {
                return (UserSecurityQuestionStateRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getPhoneMask());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideCredentialRepositoryProvider implements Provider<CredentialRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideCredentialRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CredentialRepository get() {
                return (CredentialRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.FlowViewUtil$textChanges$2());
            }
        }

        @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsComponent
        public final void PlaceComponentResult(SecuritySettingsActivity securitySettingsActivity) {
            ((BaseActivity) securitySettingsActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(securitySettingsActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(securitySettingsActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            SecuritySettingsActivity_MembersInjector.MyBillsEntityDataFactory(securitySettingsActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda6.get());
            SecuritySettingsActivity_MembersInjector.getAuthRequestContext(securitySettingsActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda4.get());
            SecuritySettingsActivity_MembersInjector.PlaceComponentResult(securitySettingsActivity, (ProductPageManager) Preconditions.PlaceComponentResult(this.getAuthRequestContext.shouldRecycleViewType()));
        }
    }
}
