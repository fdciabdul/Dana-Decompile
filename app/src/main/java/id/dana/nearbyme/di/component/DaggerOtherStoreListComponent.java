package id.dana.nearbyme.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.nearbyme.OtherStoreListPresenter;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetOtherStoreList;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.OtherStoreListActivity;
import id.dana.nearbyme.OtherStoreListActivity_MembersInjector;
import id.dana.nearbyme.di.module.OtherStoreListModule;
import id.dana.nearbyme.di.module.OtherStoreListModule_ProvideNearbyAnalyticTrackerFactory;
import id.dana.nearbyme.di.module.OtherStoreListModule_ProvideOtherStoreListViewFactory;
import id.dana.nearbyme.di.module.OtherStoreListModule_ProvideOtherStorePresenterFactory;
import id.dana.nearbyme.mapper.ContactAddressMapper;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper;
import id.dana.nearbyme.mapper.OtherStoreListResultModelMapper;
import id.dana.nearbyme.mapper.PromoInfoMapper;
import id.dana.nearbyme.mapper.PromoLimitInfoMapper;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerOtherStoreListComponent {
    private DaggerOtherStoreListComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public OtherStoreListModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class OtherStoreListComponentImpl implements OtherStoreListComponent {
        private Provider<ConnectionStatusReceiver> BuiltInFictitiousFunctionClassFactory;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<IsOfflineF2FPay> MyBillsEntityDataFactory;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final ApplicationComponent PlaceComponentResult;
        private final OtherStoreListComponentImpl getAuthRequestContext;
        private Provider<SSLPinningRepository> lookAheadTest;
        private Provider<PostExecutionThread> moveToNextValue;
        private final OtherStoreListModule scheduleImpl;

        public /* synthetic */ OtherStoreListComponentImpl(OtherStoreListModule otherStoreListModule, ApplicationComponent applicationComponent, byte b) {
            this(otherStoreListModule, applicationComponent);
        }

        private OtherStoreListComponentImpl(OtherStoreListModule otherStoreListModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.PlaceComponentResult = applicationComponent;
            this.scheduleImpl = otherStoreListModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ThreadExecutorProvider(applicationComponent);
            this.lookAheadTest = new SSLPinningRepositoryProvider(applicationComponent);
            this.moveToNextValue = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, featureConfigRepositoryProvider);
            this.MyBillsEntityDataFactory = create;
            this.BuiltInFictitiousFunctionClassFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, create);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        @Override // id.dana.nearbyme.di.component.OtherStoreListComponent
        public final void MyBillsEntityDataFactory(OtherStoreListActivity otherStoreListActivity) {
            ((BaseActivity) otherStoreListActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(otherStoreListActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(otherStoreListActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            OtherStoreListActivity_MembersInjector.getAuthRequestContext(otherStoreListActivity, OtherStoreListModule_ProvideOtherStorePresenterFactory.MyBillsEntityDataFactory(this.scheduleImpl, new OtherStoreListPresenter(new GetOtherStoreList((NearbyMeRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuth())), new GetNearbyShopsPromo((NearbyMeRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuth())), new NearbyPromoModelMapper(new CurrencyAmountModelMapper()), OtherStoreListModule_ProvideOtherStoreListViewFactory.getAuthRequestContext(this.scheduleImpl), new OtherStoreListResultModelMapper(new ShopOpenHourListMapper(), new ContactAddressMapper(), new PromoInfoMapper(new CurrencyAmountModelMapper(), new PromoLimitInfoMapper()), new MerchantSubcategoriesMapper()))));
            OtherStoreListActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(otherStoreListActivity, OtherStoreListModule_ProvideNearbyAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, new NearbyDefaultTracker((Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue()))));
        }
    }
}
