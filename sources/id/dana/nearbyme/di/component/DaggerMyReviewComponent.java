package id.dana.nearbyme.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.nearbyme.MyReviewContract;
import id.dana.contract.nearbyme.MyReviewPresenter;
import id.dana.contract.nearbyme.MyReviewPresenter_Factory;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.nearbyme.di.module.MyReviewModule;
import id.dana.nearbyme.di.module.MyReviewModule_ProvideMyReviewPresenterFactory;
import id.dana.nearbyme.di.module.MyReviewModule_ProvideMyReviewViewFactory;
import id.dana.nearbyme.di.module.MyReviewModule_ProvideNearbyAnalyticTrackerFactory;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper_Factory;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper_Factory;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper_Factory;
import id.dana.nearbyme.merchantreview.MyReviewListActivity;
import id.dana.nearbyme.merchantreview.MyReviewListActivity_MembersInjector;
import id.dana.nearbyme.merchantreview.MyUnReviewedListActivity;
import id.dana.nearbyme.merchantreview.MyUnReviewedListActivity_MembersInjector;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerMyReviewComponent {
    private DaggerMyReviewComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public MyReviewModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final MyReviewComponent MyBillsEntityDataFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, MyReviewModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, ApplicationComponent.class);
            return new MyReviewComponentImpl(this.MyBillsEntityDataFactory, this.PlaceComponentResult, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class MyReviewComponentImpl implements MyReviewComponent {
        private Provider<ConsultMerchantReview> BuiltInFictitiousFunctionClassFactory;
        private Provider<NearbyShopsModelMapper> DatabaseTableConfigUtil;
        private Provider<MyReviewContract.Presenter> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetReviewedMerchantsList> MyBillsEntityDataFactory;
        private final MyReviewModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private final MyReviewComponentImpl getErrorConfigVersion;
        private Provider<MyReviewContract.View> initRecordTimeStamp;
        private Provider<MyReviewPresenter> lookAheadTest;
        private Provider<MerchantInfoRepository> moveToNextValue;
        private Provider<IsOfflineF2FPay> scheduleImpl;

        /* synthetic */ MyReviewComponentImpl(MyReviewModule myReviewModule, ApplicationComponent applicationComponent, byte b) {
            this(myReviewModule, applicationComponent);
        }

        private MyReviewComponentImpl(MyReviewModule myReviewModule, ApplicationComponent applicationComponent) {
            ShopOpenHourListMapper_Factory shopOpenHourListMapper_Factory;
            this.getErrorConfigVersion = this;
            this.getAuthRequestContext = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = myReviewModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda2, featureConfigRepositoryProvider);
            this.scheduleImpl = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda1, create);
            this.initRecordTimeStamp = MyReviewModule_ProvideMyReviewViewFactory.getAuthRequestContext(myReviewModule);
            MerchantInfoRepositoryProvider merchantInfoRepositoryProvider = new MerchantInfoRepositoryProvider(applicationComponent);
            this.moveToNextValue = merchantInfoRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = ConsultMerchantReview_Factory.create(merchantInfoRepositoryProvider);
            this.MyBillsEntityDataFactory = GetReviewedMerchantsList_Factory.create(this.moveToNextValue);
            MerchantSubcategoriesMapper_Factory authRequestContext = MerchantSubcategoriesMapper_Factory.getAuthRequestContext();
            shopOpenHourListMapper_Factory = ShopOpenHourListMapper_Factory.InstanceHolder.getAuthRequestContext;
            NearbyShopsModelMapper_Factory BuiltInFictitiousFunctionClassFactory = NearbyShopsModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext, shopOpenHourListMapper_Factory);
            this.DatabaseTableConfigUtil = BuiltInFictitiousFunctionClassFactory;
            MyReviewPresenter_Factory authRequestContext2 = MyReviewPresenter_Factory.getAuthRequestContext(this.initRecordTimeStamp, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory);
            this.lookAheadTest = authRequestContext2;
            this.GetContactSyncConfig = MyReviewModule_ProvideMyReviewPresenterFactory.getAuthRequestContext(myReviewModule, authRequestContext2);
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
            private final ApplicationComponent PlaceComponentResult;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent getAuthRequestContext;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.M());
            }
        }

        @Override // id.dana.nearbyme.di.component.MyReviewComponent
        public final void MyBillsEntityDataFactory(MyReviewListActivity myReviewListActivity) {
            ((BaseActivity) myReviewListActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(myReviewListActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(myReviewListActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            MyReviewListActivity_MembersInjector.PlaceComponentResult(myReviewListActivity, DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig));
            MyReviewListActivity_MembersInjector.getAuthRequestContext(myReviewListActivity, MyReviewModule_ProvideNearbyAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, new NearbyDefaultTracker((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue()))));
        }

        @Override // id.dana.nearbyme.di.component.MyReviewComponent
        public final void PlaceComponentResult(MyUnReviewedListActivity myUnReviewedListActivity) {
            ((BaseActivity) myUnReviewedListActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(myUnReviewedListActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(myUnReviewedListActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            MyUnReviewedListActivity_MembersInjector.PlaceComponentResult(myUnReviewedListActivity, DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig));
        }
    }
}
