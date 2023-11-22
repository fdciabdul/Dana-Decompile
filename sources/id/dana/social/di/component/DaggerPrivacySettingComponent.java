package id.dana.social.di.component;

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
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.activation.interactor.SetDeviceFeedFeatureSwitch;
import id.dana.feeds.domain.activation.interactor.SetDeviceFeedFeatureSwitch_Factory;
import id.dana.feeds.domain.activation.interactor.UpdateFeedUserConfig;
import id.dana.feeds.domain.activation.interactor.UpdateFeedUserConfig_Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent_Factory;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent_Factory;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView;
import id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView_MembersInjector;
import id.dana.social.PrivacySettingActivity;
import id.dana.social.PrivacySettingActivity_MembersInjector;
import id.dana.social.contract.PrivacySettingContract;
import id.dana.social.contract.PrivacySettingPresenter;
import id.dana.social.contract.PrivacySettingPresenter_Factory;
import id.dana.social.di.module.PrivacySettingModule;
import id.dana.social.di.module.PrivacySettingModule_ProvideFriendshipAnalyticTrackerFactory;
import id.dana.social.di.module.PrivacySettingModule_ProvidePrivacySettingModuleFactory;
import id.dana.social.di.module.PrivacySettingModule_ProvidePrivacySettingPresenterFactory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes5.dex */
public final class DaggerPrivacySettingComponent {
    private DaggerPrivacySettingComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public PrivacySettingModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final PrivacySettingComponent BuiltInFictitiousFunctionClassFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, PrivacySettingModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            return new PrivacySettingComponentImpl(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        }
    }

    /* loaded from: classes5.dex */
    public static final class PrivacySettingComponentImpl implements PrivacySettingComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<PrivacySettingPresenter> DatabaseTableConfigUtil;
        private Provider<FriendshipAnalyticTracker> GetContactSyncConfig;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetShareFeedConsent> MyBillsEntityDataFactory;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<FeedsShareRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<FeedInitRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<UpdateFeedUserConfig> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<SetDeviceFeedFeatureSwitch> PrepareContext;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<CoroutineDispatcher> getErrorConfigVersion;
        private Provider<PrivacySettingContract.View> initRecordTimeStamp;
        private Provider<PrivacySettingContract.Presenter> isLayoutRequested;
        private Provider<IsOfflineF2FPay> lookAheadTest;
        private final PrivacySettingComponentImpl moveToNextValue;
        private Provider<SaveShareFeedConsent> newProxyInstance;
        private Provider<CoroutineDispatcher> scheduleImpl;

        /* synthetic */ PrivacySettingComponentImpl(PrivacySettingModule privacySettingModule, ApplicationComponent applicationComponent, byte b) {
            this(privacySettingModule, applicationComponent);
        }

        private PrivacySettingComponentImpl(PrivacySettingModule privacySettingModule, ApplicationComponent applicationComponent) {
            this.moveToNextValue = this;
            this.getAuthRequestContext = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda0, featureConfigRepositoryProvider);
            this.lookAheadTest = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda8, create);
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provideFeedsShareRepositoryProvider;
            this.MyBillsEntityDataFactory = GetShareFeedConsent_Factory.getAuthRequestContext(provideFeedsShareRepositoryProvider);
            this.scheduleImpl = new IoDispatcherProvider(applicationComponent);
            this.getErrorConfigVersion = new MainDispatcherProvider(applicationComponent);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provideFeedInitRepositoryProvider;
            this.PrepareContext = SetDeviceFeedFeatureSwitch_Factory.BuiltInFictitiousFunctionClassFactory(this.scheduleImpl, this.getErrorConfigVersion, provideFeedInitRepositoryProvider);
            this.newProxyInstance = SaveShareFeedConsent_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = UpdateFeedUserConfig_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            Provider<PrivacySettingContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(PrivacySettingModule_ProvidePrivacySettingModuleFactory.KClassImpl$Data$declaredNonStaticMembers$2(privacySettingModule));
            this.initRecordTimeStamp = authRequestContext;
            PrivacySettingPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = PrivacySettingPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.PrepareContext, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda4, authRequestContext);
            this.DatabaseTableConfigUtil = KClassImpl$Data$declaredNonStaticMembers$2;
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(PrivacySettingModule_ProvidePrivacySettingPresenterFactory.getAuthRequestContext(privacySettingModule, KClassImpl$Data$declaredNonStaticMembers$2));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.PlaceComponentResult = contextProvider;
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(PrivacySettingModule_ProvideFriendshipAnalyticTrackerFactory.PlaceComponentResult(privacySettingModule, contextProvider));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getRawPath());
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
        public static final class ProvideFeedsShareRepositoryProvider implements Provider<FeedsShareRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFeedsShareRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsShareRepository get() {
                return (FeedsShareRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class IoDispatcherProvider implements Provider<CoroutineDispatcher> {
            private final ApplicationComponent getAuthRequestContext;

            IoDispatcherProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CoroutineDispatcher get() {
                return (CoroutineDispatcher) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getValueOfTouchPositionAbsolute());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class MainDispatcherProvider implements Provider<CoroutineDispatcher> {
            private final ApplicationComponent PlaceComponentResult;

            MainDispatcherProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CoroutineDispatcher get() {
                return (CoroutineDispatcher) Preconditions.PlaceComponentResult(this.PlaceComponentResult.L());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        @Override // id.dana.social.di.component.PrivacySettingComponent
        public final void MyBillsEntityDataFactory(NewFeedSharingView newFeedSharingView) {
            NewFeedSharingView_MembersInjector.BuiltInFictitiousFunctionClassFactory(newFeedSharingView, this.isLayoutRequested.get());
            NewFeedSharingView_MembersInjector.getAuthRequestContext(newFeedSharingView, this.GetContactSyncConfig.get());
        }

        @Override // id.dana.social.di.component.PrivacySettingComponent
        public final void BuiltInFictitiousFunctionClassFactory(PrivacySettingActivity privacySettingActivity) {
            ((BaseActivity) privacySettingActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(privacySettingActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(privacySettingActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            PrivacySettingActivity_MembersInjector.PlaceComponentResult(privacySettingActivity, this.isLayoutRequested.get());
            PrivacySettingActivity_MembersInjector.PlaceComponentResult(privacySettingActivity, this.GetContactSyncConfig.get());
        }
    }
}
