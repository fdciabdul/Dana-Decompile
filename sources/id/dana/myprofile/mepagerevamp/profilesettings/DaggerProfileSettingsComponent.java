package id.dana.myprofile.mepagerevamp.profilesettings;

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
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.account.interactor.UploadAvatar_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.profilemenu.interactor.GetSettingCollection_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.user.interactor.GetUserInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useremailaddress.interactor.GetUserEmailAddress;
import id.dana.domain.useremailaddress.interactor.GetUserEmailAddress_Factory;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact;
import id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact_Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent_Factory;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.UserInfoMapper_Factory;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.mepagerevamp.MePageRevampModule;
import id.dana.myprofile.mepagerevamp.MePageRevampModule_ProvidePresenterFactory;
import id.dana.myprofile.mepagerevamp.MePageRevampModule_ProvideViewFactory;
import id.dana.myprofile.mepagerevamp.MePageRevampPresenter;
import id.dana.myprofile.mepagerevamp.MePageRevampPresenter_Factory;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract;
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
public final class DaggerProfileSettingsComponent {
    private DaggerProfileSettingsComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        MePageRevampModule BuiltInFictitiousFunctionClassFactory;
        ProfileSettingsModule KClassImpl$Data$declaredNonStaticMembers$2;
        ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class ProfileSettingsComponentImpl implements ProfileSettingsComponent {
        private Provider<UserInfoMapper> A;
        private Provider<UploadAvatar> B;
        private Provider<UserRepository> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<UsernameChangeConfigRunner> C;
        private Provider<IsOfflineF2FPay> DatabaseTableConfigUtil;
        private Provider<MePageRevampContract.Presenter> FragmentBottomSheetPaymentSettingBinding;
        private Provider<NicknameChangeConfigRunner> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<FeedSharingConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<InitFeedWithoutContact> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<MePageRevampPresenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ProfileSettingsContract.View> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<ProfileSettingsContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<RestrictedContactConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<MePageRevampContract.View> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeedsShareRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeedInitRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private final ProfileSettingsComponentImpl PrepareContext;
        private Provider<SSLPinningRepository> SubSequence;
        private Provider<UserEmailAddressRepository> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<Context> getAuthRequestContext;
        private Provider<ShareFeedSettingConfigRunner> getCallingPid;
        private Provider<GetUserInfo> getErrorConfigVersion;
        private Provider<SaveShareFeedConsent> getSupportButtonTintMode;
        private Provider<PostExecutionThread> initRecordTimeStamp;
        private final ProfileSettingsModule isLayoutRequested;
        private Provider<GetAvatarUrl> lookAheadTest;
        private Provider<GetSettingCollection> moveToNextValue;
        private Provider<ProfileSettingsPresenter> newProxyInstance;
        private Provider<ThreadExecutor> readMicros;
        private Provider<GetUserEmailAddress> scheduleImpl;
        private Provider<SettingRepository> whenAvailable;

        public /* synthetic */ ProfileSettingsComponentImpl(ProfileSettingsModule profileSettingsModule, MePageRevampModule mePageRevampModule, ApplicationComponent applicationComponent, byte b) {
            this(profileSettingsModule, mePageRevampModule, applicationComponent);
        }

        private ProfileSettingsComponentImpl(ProfileSettingsModule profileSettingsModule, MePageRevampModule mePageRevampModule, ApplicationComponent applicationComponent) {
            this.PrepareContext = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.isLayoutRequested = profileSettingsModule;
            this.readMicros = new ThreadExecutorProvider(applicationComponent);
            this.SubSequence = new SSLPinningRepositoryProvider(applicationComponent);
            this.initRecordTimeStamp = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.readMicros, this.initRecordTimeStamp, featureConfigRepositoryProvider);
            this.DatabaseTableConfigUtil = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.readMicros, this.SubSequence, create);
            this.getAuthRequestContext = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(MePageRevampModule_ProvideViewFactory.getAuthRequestContext(mePageRevampModule));
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.whenAvailable = settingRepositoryProvider;
            this.moveToNextValue = GetSettingCollection_Factory.create(this.readMicros, this.initRecordTimeStamp, settingRepositoryProvider);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.lookAheadTest = GetAvatarUrl_Factory.create(this.readMicros, this.initRecordTimeStamp, accountRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provideFeedInitRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = FeedSharingConfigRunner_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provideFeedsShareRepositoryProvider;
            this.getCallingPid = ShareFeedSettingConfigRunner_Factory.getAuthRequestContext(provideFeedsShareRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = RestrictedContactConfigRunner_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.getAuthRequestContext);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = userRepositoryProvider;
            this.GetContactSyncConfig = NicknameChangeConfigRunner_Factory.getAuthRequestContext(this.getAuthRequestContext, userRepositoryProvider, this.KClassImpl$Data$declaredNonStaticMembers$2);
            UsernameChangeConfigRunner_Factory MyBillsEntityDataFactory = UsernameChangeConfigRunner_Factory.MyBillsEntityDataFactory(this.getAuthRequestContext, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.C = MyBillsEntityDataFactory;
            MePageRevampPresenter_Factory MyBillsEntityDataFactory2 = MePageRevampPresenter_Factory.MyBillsEntityDataFactory(this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.moveToNextValue, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.GetContactSyncConfig, MyBillsEntityDataFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = MyBillsEntityDataFactory2;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(MePageRevampModule_ProvidePresenterFactory.PlaceComponentResult(mePageRevampModule, MyBillsEntityDataFactory2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(ProfileSettingsModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(profileSettingsModule));
            this.B = UploadAvatar_Factory.create(this.readMicros, this.initRecordTimeStamp, this.BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = InitFeedWithoutContact_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.getSupportButtonTintMode = SaveShareFeedConsent_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.getErrorConfigVersion = GetUserInfo_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1);
            this.A = UserInfoMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            UserEmailAddressRepositoryProvider userEmailAddressRepositoryProvider = new UserEmailAddressRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = userEmailAddressRepositoryProvider;
            GetUserEmailAddress_Factory create2 = GetUserEmailAddress_Factory.create(userEmailAddressRepositoryProvider);
            this.scheduleImpl = create2;
            ProfileSettingsPresenter_Factory PlaceComponentResult = ProfileSettingsPresenter_Factory.PlaceComponentResult(this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.lookAheadTest, this.B, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getSupportButtonTintMode, this.getErrorConfigVersion, this.A, create2);
            this.newProxyInstance = PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(ProfileSettingsModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(profileSettingsModule, PlaceComponentResult));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
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
            private final ApplicationComponent getAuthRequestContext;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isInfoWindowShown());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideFeedsShareRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsShareRepository get() {
                return (FeedsShareRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class UserEmailAddressRepositoryProvider implements Provider<UserEmailAddressRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserEmailAddressRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEmailAddressRepository get() {
                return (UserEmailAddressRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.mo2241x461046da());
            }
        }

        @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ProfileSettingsActivity profileSettingsActivity) {
            ((BaseActivity) profileSettingsActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(profileSettingsActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(profileSettingsActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            ProfileSettingsActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(profileSettingsActivity, this.FragmentBottomSheetPaymentSettingBinding.get());
            ProfileSettingsActivity_MembersInjector.PlaceComponentResult(profileSettingsActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda4.get());
            ProfileSettingsActivity_MembersInjector.getAuthRequestContext(profileSettingsActivity, ProfileSettingsModule_ProvideFriendshipAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested, (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue())));
        }
    }
}
