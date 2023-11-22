package id.dana.myprofile.mepagerevamp.smartpay;

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
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting_Factory;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
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
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.mepagerevamp.MePageRevampModule;
import id.dana.myprofile.mepagerevamp.MePageRevampModule_ProvidePresenterFactory;
import id.dana.myprofile.mepagerevamp.MePageRevampModule_ProvideViewFactory;
import id.dana.myprofile.mepagerevamp.MePageRevampPresenter;
import id.dana.myprofile.mepagerevamp.MePageRevampPresenter_Factory;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayContract;
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
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerSmartPayComponent {
    private DaggerSmartPayComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        SmartPayModule BuiltInFictitiousFunctionClassFactory;
        MePageRevampModule PlaceComponentResult;
        ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    static final class SmartPayComponentImpl implements SmartPayComponent {
        private Provider<Context> BuiltInFictitiousFunctionClassFactory;
        private Provider<NicknameChangeConfigRunner> DatabaseTableConfigUtil;
        private Provider<SettingRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<IsOfflineF2FPay> GetContactSyncConfig;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<GetSettingCollection> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<MePageRevampPresenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SmartPayContract.View> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<RestrictedContactConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<ShareFeedSettingConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeedInitRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<MePageRevampContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<AutoRouteRepository> PlaceComponentResult;
        private Provider<SmartPayContract.Presenter> PrepareContext;
        private final SmartPayComponentImpl SubSequence;
        private Provider<AccountRepository> getAuthRequestContext;
        private Provider<UserRepository> getCallingPid;
        private Provider<FeedSharingConfigRunner> getErrorConfigVersion;
        private Provider<SmartPayPresenter> getSupportButtonTintMode;
        private Provider<GetUserInfo> initRecordTimeStamp;
        private Provider<MePageRevampContract.View> isLayoutRequested;
        private Provider<GetAutoRouteInitialSetting> lookAheadTest;
        private Provider<FeatureConfigRepository> moveToNextValue;
        private Provider<FeedsShareRepository> newProxyInstance;
        private Provider<ThreadExecutor> readMicros;
        private Provider<GetAvatarUrl> scheduleImpl;
        private Provider<UsernameChangeConfigRunner> whenAvailable;

        public /* synthetic */ SmartPayComponentImpl(SmartPayModule smartPayModule, MePageRevampModule mePageRevampModule, ApplicationComponent applicationComponent, byte b) {
            this(smartPayModule, mePageRevampModule, applicationComponent);
        }

        private SmartPayComponentImpl(SmartPayModule smartPayModule, MePageRevampModule mePageRevampModule, ApplicationComponent applicationComponent) {
            this.SubSequence = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.readMicros = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.moveToNextValue = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda2, featureConfigRepositoryProvider);
            this.GetContactSyncConfig = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda6, create);
            this.BuiltInFictitiousFunctionClassFactory = new ContextProvider(applicationComponent);
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(MePageRevampModule_ProvideViewFactory.getAuthRequestContext(mePageRevampModule));
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = settingRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetSettingCollection_Factory.create(this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda2, settingRepositoryProvider);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = accountRepositoryProvider;
            this.scheduleImpl = GetAvatarUrl_Factory.create(this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda2, accountRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provideFeedInitRepositoryProvider;
            this.getErrorConfigVersion = FeedSharingConfigRunner_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.newProxyInstance = provideFeedsShareRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = ShareFeedSettingConfigRunner_Factory.getAuthRequestContext(provideFeedsShareRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = RestrictedContactConfigRunner_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.BuiltInFictitiousFunctionClassFactory);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.getCallingPid = userRepositoryProvider;
            this.DatabaseTableConfigUtil = NicknameChangeConfigRunner_Factory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, userRepositoryProvider, this.moveToNextValue);
            UsernameChangeConfigRunner_Factory MyBillsEntityDataFactory = UsernameChangeConfigRunner_Factory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.getCallingPid, this.moveToNextValue);
            this.whenAvailable = MyBillsEntityDataFactory;
            MePageRevampPresenter_Factory MyBillsEntityDataFactory2 = MePageRevampPresenter_Factory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.scheduleImpl, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.DatabaseTableConfigUtil, MyBillsEntityDataFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = MyBillsEntityDataFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleCheck.getAuthRequestContext(MePageRevampModule_ProvidePresenterFactory.PlaceComponentResult(mePageRevampModule, MyBillsEntityDataFactory2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(SmartPayModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(smartPayModule));
            this.initRecordTimeStamp = GetUserInfo_Factory.create(this.getCallingPid);
            AutoRouteRepositoryProvider autoRouteRepositoryProvider = new AutoRouteRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = autoRouteRepositoryProvider;
            GetAutoRouteInitialSetting_Factory create2 = GetAutoRouteInitialSetting_Factory.create(autoRouteRepositoryProvider);
            this.lookAheadTest = create2;
            SmartPayPresenter_Factory authRequestContext = SmartPayPresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.initRecordTimeStamp, create2);
            this.getSupportButtonTintMode = authRequestContext;
            this.PrepareContext = DoubleCheck.getAuthRequestContext(SmartPayModule_ProvidePresenterFactory.MyBillsEntityDataFactory(smartPayModule, authRequestContext));
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.l());
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
        public static final class AutoRouteRepositoryProvider implements Provider<AutoRouteRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            AutoRouteRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AutoRouteRepository get() {
                return (AutoRouteRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl());
            }
        }

        @Override // id.dana.myprofile.mepagerevamp.smartpay.SmartPayComponent
        public final void getAuthRequestContext(SmartPayActivity smartPayActivity) {
            ((BaseActivity) smartPayActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(smartPayActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(smartPayActivity, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
            SmartPayActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(smartPayActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda8.get());
            SmartPayActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(smartPayActivity, this.PrepareContext.get());
        }
    }
}
