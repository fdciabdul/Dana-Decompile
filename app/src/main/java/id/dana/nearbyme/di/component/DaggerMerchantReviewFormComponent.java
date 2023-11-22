package id.dana.nearbyme.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import id.dana.domain.nearbyme.interactor.merchantreview.GetUGCBannerConfig;
import id.dana.domain.nearbyme.interactor.merchantreview.GetUGCBannerConfig_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.SaveDismissedMerchantReviewForm;
import id.dana.domain.nearbyme.interactor.merchantreview.SaveDismissedMerchantReviewForm_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.SaveLastTimeMerchantReviewFormShown;
import id.dana.domain.nearbyme.interactor.merchantreview.SaveLastTimeMerchantReviewFormShown_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus_Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent_Factory;
import id.dana.nearbyme.di.module.MerchantReviewFormModule;
import id.dana.nearbyme.di.module.MerchantReviewFormModule_ProvidePresenterFactory;
import id.dana.nearbyme.di.module.MerchantReviewFormModule_ProvideReviewFormTrackerFactory;
import id.dana.nearbyme.di.module.MerchantReviewFormModule_ProvideViewFactory;
import id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment;
import id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment_MembersInjector;
import id.dana.nearbyme.merchantreview.MerchantReviewFormContract;
import id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter;
import id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter_Factory;
import id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormAnalyticTracker;
import id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormMixpanelTracker;
import id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormMixpanelTracker_Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerMerchantReviewFormComponent {
    private DaggerMerchantReviewFormComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public MerchantReviewFormModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class MerchantReviewFormComponentImpl implements MerchantReviewFormComponent {
        private final MerchantReviewFormComponentImpl BuiltInFictitiousFunctionClassFactory;
        private Provider<SaveDismissedMerchantReviewForm> DatabaseTableConfigUtil;
        private Provider<SaveLastTimeMerchantReviewFormShown> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetUGCBannerConfig> MyBillsEntityDataFactory;
        private Provider<MerchantReviewFormMixpanelTracker> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<MerchantReviewFormAnalyticTracker> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<MerchantReviewFormContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SaveShareFeedConsent> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<GetFeedStatus> getAuthRequestContext;
        private Provider<MerchantReviewFormPresenter> getErrorConfigVersion;
        private Provider<MerchantReviewFormContract.Presenter> initRecordTimeStamp;
        private Provider<FeedInitRepository> lookAheadTest;
        private Provider<FeedsShareRepository> moveToNextValue;
        private Provider<MerchantReviewFormRepository> scheduleImpl;

        public /* synthetic */ MerchantReviewFormComponentImpl(MerchantReviewFormModule merchantReviewFormModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantReviewFormModule, applicationComponent);
        }

        private MerchantReviewFormComponentImpl(MerchantReviewFormModule merchantReviewFormModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(MerchantReviewFormModule_ProvideViewFactory.getAuthRequestContext(merchantReviewFormModule));
            ProvideMerchantReviewRepositoryProvider provideMerchantReviewRepositoryProvider = new ProvideMerchantReviewRepositoryProvider(applicationComponent);
            this.scheduleImpl = provideMerchantReviewRepositoryProvider;
            this.GetContactSyncConfig = SaveLastTimeMerchantReviewFormShown_Factory.create(provideMerchantReviewRepositoryProvider);
            this.DatabaseTableConfigUtil = SaveDismissedMerchantReviewForm_Factory.create(this.scheduleImpl);
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.moveToNextValue = provideFeedsShareRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = SaveShareFeedConsent_Factory.MyBillsEntityDataFactory(provideFeedsShareRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.lookAheadTest = provideFeedInitRepositoryProvider;
            this.getAuthRequestContext = GetFeedStatus_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            GetUGCBannerConfig_Factory create = GetUGCBannerConfig_Factory.create(featureConfigRepositoryProvider);
            this.MyBillsEntityDataFactory = create;
            MerchantReviewFormPresenter_Factory BuiltInFictitiousFunctionClassFactory = MerchantReviewFormPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.GetContactSyncConfig, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.getAuthRequestContext, create);
            this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(MerchantReviewFormModule_ProvidePresenterFactory.PlaceComponentResult(merchantReviewFormModule, BuiltInFictitiousFunctionClassFactory));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.PlaceComponentResult = contextProvider;
            MerchantReviewFormMixpanelTracker_Factory BuiltInFictitiousFunctionClassFactory2 = MerchantReviewFormMixpanelTracker_Factory.BuiltInFictitiousFunctionClassFactory(contextProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(MerchantReviewFormModule_ProvideReviewFormTrackerFactory.MyBillsEntityDataFactory(merchantReviewFormModule, BuiltInFictitiousFunctionClassFactory2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideMerchantReviewRepositoryProvider implements Provider<MerchantReviewFormRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideMerchantReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantReviewFormRepository get() {
                return (MerchantReviewFormRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideFeedsShareRepositoryProvider implements Provider<FeedsShareRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedsShareRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsShareRepository get() {
                return (FeedsShareRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider());
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue());
            }
        }

        @Override // id.dana.nearbyme.di.component.MerchantReviewFormComponent
        public final void BuiltInFictitiousFunctionClassFactory(MerchantReviewDialogFragment merchantReviewDialogFragment) {
            merchantReviewDialogFragment.presenter = this.initRecordTimeStamp.get();
            MerchantReviewDialogFragment_MembersInjector.PlaceComponentResult(merchantReviewDialogFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }
    }
}
