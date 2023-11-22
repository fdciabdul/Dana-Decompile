package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.MerchantDetailReviewModule;
import id.dana.di.modules.MerchantDetailReviewModule_ProvideMerchantDetailAnalyticTrackerFactory;
import id.dana.di.modules.MerchantDetailReviewModule_ProvideMerchantReviewDetailFactory;
import id.dana.di.modules.MerchantDetailReviewModule_ProvideMerchantReviewDetailPresenterFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantReviews;
import id.dana.domain.nearbyme.interactor.GetMerchantReviews_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers_Factory;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewPresenter;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMerchantDetailReviewComponent {
    private DaggerMerchantDetailReviewComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public MerchantDetailReviewModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantDetailReviewComponentImpl implements MerchantDetailReviewComponent {
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<MerchantDetailReviewContract.View> DatabaseTableConfigUtil;
        private Provider<PostExecutionThread> GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<MerchantInfoRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<MerchantDetailReviewContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<MerchantDetailMixpanelTrackers> getErrorConfigVersion;
        private Provider<MerchantDetailAnalyticTracker> initRecordTimeStamp;
        private Provider<SSLPinningRepository> isLayoutRequested;
        private final MerchantDetailReviewComponentImpl lookAheadTest;
        private Provider<GetMerchantReviews> moveToNextValue;
        private Provider<ThreadExecutor> newProxyInstance;
        private Provider<MerchantDetailReviewPresenter> scheduleImpl;

        public /* synthetic */ MerchantDetailReviewComponentImpl(MerchantDetailReviewModule merchantDetailReviewModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantDetailReviewModule, applicationComponent);
        }

        private MerchantDetailReviewComponentImpl(MerchantDetailReviewModule merchantDetailReviewModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.newProxyInstance = new ThreadExecutorProvider(applicationComponent);
            this.isLayoutRequested = new SSLPinningRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.newProxyInstance, this.GetContactSyncConfig, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.newProxyInstance, this.isLayoutRequested, create);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            MerchantDetailMixpanelTrackers_Factory authRequestContext = MerchantDetailMixpanelTrackers_Factory.getAuthRequestContext(contextProvider);
            this.getErrorConfigVersion = authRequestContext;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(MerchantDetailReviewModule_ProvideMerchantDetailAnalyticTrackerFactory.PlaceComponentResult(merchantDetailReviewModule, authRequestContext));
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(MerchantDetailReviewModule_ProvideMerchantReviewDetailFactory.getAuthRequestContext(merchantDetailReviewModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new MerchantInfoRepositoryProvider(applicationComponent);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            GetMerchantReviews_Factory create2 = GetMerchantReviews_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, accountRepositoryProvider);
            this.moveToNextValue = create2;
            MerchantDetailReviewPresenter_Factory MyBillsEntityDataFactory = MerchantDetailReviewPresenter_Factory.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil, create2);
            this.scheduleImpl = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(MerchantDetailReviewModule_ProvideMerchantReviewDetailPresenterFactory.PlaceComponentResult(merchantDetailReviewModule, MyBillsEntityDataFactory));
        }

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

        /* loaded from: classes4.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getRawPath());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent PlaceComponentResult;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto());
            }
        }

        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.M());
            }
        }

        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
            }
        }

        @Override // id.dana.di.component.MerchantDetailReviewComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewDetailActivity merchantReviewDetailActivity) {
            ((BaseActivity) merchantReviewDetailActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantReviewDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(merchantReviewDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            merchantReviewDetailActivity.tracker = this.initRecordTimeStamp.get();
            merchantReviewDetailActivity.reviewPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda2.get();
        }
    }
}
