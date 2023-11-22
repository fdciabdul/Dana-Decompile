package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.MerchantAverageRatingModule;
import id.dana.di.modules.MerchantAverageRatingModule_ProvideMerchantAverageRatingPresenterFactory;
import id.dana.di.modules.MerchantAverageRatingModule_ProvideMerchantAverageRatingViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.account.interactor.GetAccount_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary_Factory;
import id.dana.domain.nearbyme.interactor.GetReviewCoachmark;
import id.dana.domain.nearbyme.interactor.GetReviewCoachmark_Factory;
import id.dana.domain.nearbyme.interactor.SetReviewCoachmark;
import id.dana.domain.nearbyme.interactor.SetReviewCoachmark_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm_Factory;
import id.dana.nearbyme.mapper.ContactAddressMapper_Factory;
import id.dana.nearbyme.mapper.MerchantConsultReviewMapper;
import id.dana.nearbyme.mapper.MerchantConsultReviewMapper_Factory;
import id.dana.nearbyme.mapper.MerchantReviewTagMapper_Factory;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper_Factory;
import id.dana.nearbyme.mapper.PromoInfoMapper;
import id.dana.nearbyme.mapper.PromoInfoMapper_Factory;
import id.dana.nearbyme.mapper.PromoLimitInfoMapper_Factory;
import id.dana.nearbyme.mapper.ShopMapper;
import id.dana.nearbyme.mapper.ShopMapper_Factory;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper_Factory;
import id.dana.nearbyme.merchantdetail.mapper.MerchantAverageRatingMapper_Factory;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter_Factory;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingView_MembersInjector;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMerchantAverageRatingComponent {
    private DaggerMerchantAverageRatingComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public MerchantAverageRatingModule MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantAverageRatingComponentImpl implements MerchantAverageRatingComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<PromoInfoMapper> DatabaseTableConfigUtil;
        private Provider<PostExecutionThread> GetContactSyncConfig;
        private Provider<GetMerchantReviewSummary> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private final MerchantAverageRatingComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<MerchantInfoRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<MerchantAverageRatingContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ShopMapper> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetAccount> PlaceComponentResult;
        private Provider<ConsultMerchantReview> getAuthRequestContext;
        private Provider<GetReviewableMerchantForm> getErrorConfigVersion;
        private Provider<MerchantAverageRatingContract.Presenter> initRecordTimeStamp;
        private Provider<SetReviewCoachmark> isLayoutRequested;
        private Provider<MerchantConsultReviewMapper> lookAheadTest;
        private Provider<MerchantAverageRatingPresenter> moveToNextValue;
        private Provider<MerchantReviewFormRepository> newProxyInstance;
        private Provider<GetReviewCoachmark> scheduleImpl;

        public /* synthetic */ MerchantAverageRatingComponentImpl(MerchantAverageRatingModule merchantAverageRatingModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantAverageRatingModule, applicationComponent);
        }

        private MerchantAverageRatingComponentImpl(MerchantAverageRatingModule merchantAverageRatingModule, ApplicationComponent applicationComponent) {
            PromoLimitInfoMapper_Factory promoLimitInfoMapper_Factory;
            ShopOpenHourListMapper_Factory shopOpenHourListMapper_Factory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(MerchantAverageRatingModule_ProvideMerchantAverageRatingViewFactory.PlaceComponentResult(merchantAverageRatingModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ThreadExecutorProvider(applicationComponent);
            this.GetContactSyncConfig = new PostExecutionThreadProvider(applicationComponent);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            this.PlaceComponentResult = GetAccount_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.GetContactSyncConfig, accountRepositoryProvider);
            this.newProxyInstance = new ProvideMerchantReviewRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new MerchantInfoRepositoryProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            this.getErrorConfigVersion = GetReviewableMerchantForm_Factory.create(this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda1, featureConfigRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetMerchantReviewSummary_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.scheduleImpl = GetReviewCoachmark_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.isLayoutRequested = SetReviewCoachmark_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            CurrencyAmountModelMapper_Factory MyBillsEntityDataFactory = CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory();
            promoLimitInfoMapper_Factory = PromoLimitInfoMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.DatabaseTableConfigUtil = PromoInfoMapper_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, promoLimitInfoMapper_Factory);
            ContactAddressMapper_Factory MyBillsEntityDataFactory2 = ContactAddressMapper_Factory.MyBillsEntityDataFactory();
            Provider<PromoInfoMapper> provider = this.DatabaseTableConfigUtil;
            shopOpenHourListMapper_Factory = ShopOpenHourListMapper_Factory.InstanceHolder.getAuthRequestContext;
            ShopMapper_Factory PlaceComponentResult = ShopMapper_Factory.PlaceComponentResult(MyBillsEntityDataFactory2, provider, shopOpenHourListMapper_Factory, MerchantSubcategoriesMapper_Factory.getAuthRequestContext());
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = PlaceComponentResult;
            this.lookAheadTest = MerchantConsultReviewMapper_Factory.getAuthRequestContext(PlaceComponentResult, MerchantReviewTagMapper_Factory.PlaceComponentResult());
            this.getAuthRequestContext = ConsultMerchantReview_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            MerchantAverageRatingPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MerchantAverageRatingPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.PlaceComponentResult, this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, this.isLayoutRequested, MerchantAverageRatingMapper_Factory.PlaceComponentResult(), this.lookAheadTest, this.getAuthRequestContext);
            this.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(MerchantAverageRatingModule_ProvideMerchantAverageRatingPresenterFactory.BuiltInFictitiousFunctionClassFactory(merchantAverageRatingModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class ProvideMerchantReviewRepositoryProvider implements Provider<MerchantReviewFormRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideMerchantReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantReviewFormRepository get() {
                return (MerchantReviewFormRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        @Override // id.dana.di.component.MerchantAverageRatingComponent
        public final void getAuthRequestContext(MerchantAverageRatingView merchantAverageRatingView) {
            MerchantAverageRatingView_MembersInjector.getAuthRequestContext(merchantAverageRatingView, this.initRecordTimeStamp.get());
        }
    }
}
