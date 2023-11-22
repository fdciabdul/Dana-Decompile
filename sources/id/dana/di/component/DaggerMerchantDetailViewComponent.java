package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.MerchantAverageRatingModule;
import id.dana.di.modules.MerchantAverageRatingModule_ProvideMerchantAverageRatingPresenterFactory;
import id.dana.di.modules.MerchantAverageRatingModule_ProvideMerchantAverageRatingViewFactory;
import id.dana.di.modules.MerchantDanaDealsModule;
import id.dana.di.modules.MerchantDanaDealsModule_ProvideMerchantDealsPresenterFactory;
import id.dana.di.modules.MerchantDanaDealsModule_ProvideViewFactory;
import id.dana.di.modules.MerchantDetailConfigModule;
import id.dana.di.modules.MerchantDetailConfigModule_ProvidesPresenterFactory;
import id.dana.di.modules.MerchantDetailConfigModule_ProvidesViewFactory;
import id.dana.di.modules.MerchantDetailReviewModule;
import id.dana.di.modules.MerchantDetailReviewModule_ProvideMerchantDetailAnalyticTrackerFactory;
import id.dana.di.modules.MerchantDetailReviewModule_ProvideMerchantReviewDetailFactory;
import id.dana.di.modules.MerchantDetailReviewModule_ProvideMerchantReviewDetailPresenterFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.account.interactor.GetAccount_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.nearbyme.MerchantConfigRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder;
import id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailActionConfig;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailActionConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary_Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantReviews;
import id.dana.domain.nearbyme.interactor.GetMerchantReviews_Factory;
import id.dana.domain.nearbyme.interactor.GetReviewCoachmark;
import id.dana.domain.nearbyme.interactor.GetReviewCoachmark_Factory;
import id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals;
import id.dana.domain.nearbyme.interactor.SetReviewCoachmark;
import id.dana.domain.nearbyme.interactor.SetReviewCoachmark_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm_Factory;
import id.dana.drawable.merchantdetail.MerchantDetailView;
import id.dana.drawable.merchantdetail.MerchantDetailView_MembersInjector;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.ContactAddressMapper_Factory;
import id.dana.nearbyme.mapper.DanaDealsOrderRequestMapper;
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
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter_Factory;
import id.dana.nearbyme.merchantdetail.mapper.CreateProductVoucherOrderMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantAverageRatingMapper_Factory;
import id.dana.nearbyme.merchantdetail.mapper.MerchantDanaDealsMapper;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers_Factory;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter_Factory;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewPresenter;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewPresenter_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes4.dex */
public final class DaggerMerchantDetailViewComponent {
    private DaggerMerchantDetailViewComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public MerchantAverageRatingModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public MerchantDetailConfigModule MyBillsEntityDataFactory;
        public MerchantDanaDealsModule PlaceComponentResult;
        public MerchantDetailReviewModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantDetailViewComponentImpl implements MerchantDetailViewComponent {
        private Provider<MerchantDetailConfigContract.View> A;
        private Provider<ShopMapper> B;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> C;
        private Provider<GetReviewableMerchantForm> DatabaseTableConfigUtil;
        private Provider<MerchantAverageRatingContract.Presenter> FragmentBottomSheetPaymentSettingBinding;
        private Provider<MerchantConsultReviewMapper> GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<GetMerchantDetailPromoConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<MerchantAverageRatingPresenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetReviewCoachmark> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<MerchantAverageRatingContract.View> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<PromoInfoMapper> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<MerchantInfoRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private final MerchantDetailViewComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<MerchantDetailReviewPresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ConsultMerchantReview> PlaceComponentResult;
        private final MerchantDanaDealsModule PrepareContext;
        private Provider<MerchantDetailReviewContract.View> SubSequence;
        private Provider<SetReviewCoachmark> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<MerchantDetailAnalyticTracker> getCallingPid;
        private Provider<GetAccount> getErrorConfigVersion;
        private Provider<MerchantReviewFormRepository> getSupportButtonTintMode;
        private Provider<MerchantConfigRepository> initRecordTimeStamp;
        private Provider<MerchantDetailMixpanelTrackers> isLayoutRequested;
        private Provider<GetMerchantReviews> lookAheadTest;
        private Provider<GetMerchantReviewSummary> moveToNextValue;
        private Provider<MerchantDetailConfigPresenter> newProxyInstance;
        private Provider<MerchantDetailReviewContract.Presenter> readMicros;
        private Provider<GetMerchantDetailActionConfig> scheduleImpl;
        private Provider<MerchantDetailConfigContract.Presenter> whenAvailable;

        public /* synthetic */ MerchantDetailViewComponentImpl(MerchantDanaDealsModule merchantDanaDealsModule, MerchantAverageRatingModule merchantAverageRatingModule, MerchantDetailConfigModule merchantDetailConfigModule, MerchantDetailReviewModule merchantDetailReviewModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantDanaDealsModule, merchantAverageRatingModule, merchantDetailConfigModule, merchantDetailReviewModule, applicationComponent);
        }

        private MerchantDetailViewComponentImpl(MerchantDanaDealsModule merchantDanaDealsModule, MerchantAverageRatingModule merchantAverageRatingModule, MerchantDetailConfigModule merchantDetailConfigModule, MerchantDetailReviewModule merchantDetailReviewModule, ApplicationComponent applicationComponent) {
            PromoLimitInfoMapper_Factory promoLimitInfoMapper_Factory;
            ShopOpenHourListMapper_Factory shopOpenHourListMapper_Factory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = this;
            this.PrepareContext = merchantDanaDealsModule;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.A = DoubleCheck.getAuthRequestContext(MerchantDetailConfigModule_ProvidesViewFactory.PlaceComponentResult(merchantDetailConfigModule));
            MerchantConfigRepositoryProvider merchantConfigRepositoryProvider = new MerchantConfigRepositoryProvider(applicationComponent);
            this.initRecordTimeStamp = merchantConfigRepositoryProvider;
            this.scheduleImpl = GetMerchantDetailActionConfig_Factory.create(merchantConfigRepositoryProvider);
            GetMerchantDetailPromoConfig_Factory create = GetMerchantDetailPromoConfig_Factory.create(this.initRecordTimeStamp);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            Provider<MerchantDetailConfigPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(MerchantDetailConfigPresenter_Factory.getAuthRequestContext(this.A, this.scheduleImpl, create));
            this.newProxyInstance = authRequestContext;
            this.whenAvailable = DoubleCheck.getAuthRequestContext(MerchantDetailConfigModule_ProvidesPresenterFactory.MyBillsEntityDataFactory(merchantDetailConfigModule, authRequestContext));
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(MerchantAverageRatingModule_ProvideMerchantAverageRatingViewFactory.PlaceComponentResult(merchantAverageRatingModule));
            this.C = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new PostExecutionThreadProvider(applicationComponent);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.getErrorConfigVersion = GetAccount_Factory.create(this.C, this.NetworkUserEntityData$$ExternalSyntheticLambda3, accountRepositoryProvider);
            this.getSupportButtonTintMode = new ProvideMerchantReviewRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new MerchantInfoRepositoryProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            this.DatabaseTableConfigUtil = GetReviewableMerchantForm_Factory.create(this.getSupportButtonTintMode, this.NetworkUserEntityData$$ExternalSyntheticLambda6, featureConfigRepositoryProvider);
            this.moveToNextValue = GetMerchantReviewSummary_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetReviewCoachmark_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = SetReviewCoachmark_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            CurrencyAmountModelMapper_Factory MyBillsEntityDataFactory = CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory();
            promoLimitInfoMapper_Factory = PromoLimitInfoMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = PromoInfoMapper_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, promoLimitInfoMapper_Factory);
            ContactAddressMapper_Factory MyBillsEntityDataFactory2 = ContactAddressMapper_Factory.MyBillsEntityDataFactory();
            Provider<PromoInfoMapper> provider = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            shopOpenHourListMapper_Factory = ShopOpenHourListMapper_Factory.InstanceHolder.getAuthRequestContext;
            ShopMapper_Factory PlaceComponentResult = ShopMapper_Factory.PlaceComponentResult(MyBillsEntityDataFactory2, provider, shopOpenHourListMapper_Factory, MerchantSubcategoriesMapper_Factory.getAuthRequestContext());
            this.B = PlaceComponentResult;
            this.GetContactSyncConfig = MerchantConsultReviewMapper_Factory.getAuthRequestContext(PlaceComponentResult, MerchantReviewTagMapper_Factory.PlaceComponentResult());
            this.PlaceComponentResult = ConsultMerchantReview_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            MerchantAverageRatingPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MerchantAverageRatingPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.getErrorConfigVersion, this.DatabaseTableConfigUtil, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.VerifyPinStateManager$executeRiskChallenge$2$1, MerchantAverageRatingMapper_Factory.PlaceComponentResult(), this.GetContactSyncConfig, this.PlaceComponentResult);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(MerchantAverageRatingModule_ProvideMerchantAverageRatingPresenterFactory.BuiltInFictitiousFunctionClassFactory(merchantAverageRatingModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.SubSequence = DoubleCheck.getAuthRequestContext(MerchantDetailReviewModule_ProvideMerchantReviewDetailFactory.getAuthRequestContext(merchantDetailReviewModule));
            GetMerchantReviews_Factory create2 = GetMerchantReviews_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.BuiltInFictitiousFunctionClassFactory);
            this.lookAheadTest = create2;
            MerchantDetailReviewPresenter_Factory MyBillsEntityDataFactory3 = MerchantDetailReviewPresenter_Factory.MyBillsEntityDataFactory(this.SubSequence, create2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = MyBillsEntityDataFactory3;
            this.readMicros = DoubleCheck.getAuthRequestContext(MerchantDetailReviewModule_ProvideMerchantReviewDetailPresenterFactory.PlaceComponentResult(merchantDetailReviewModule, MyBillsEntityDataFactory3));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            MerchantDetailMixpanelTrackers_Factory authRequestContext2 = MerchantDetailMixpanelTrackers_Factory.getAuthRequestContext(contextProvider);
            this.isLayoutRequested = authRequestContext2;
            this.getCallingPid = DoubleCheck.getAuthRequestContext(MerchantDetailReviewModule_ProvideMerchantDetailAnalyticTrackerFactory.PlaceComponentResult(merchantDetailReviewModule, authRequestContext2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantConfigRepositoryProvider implements Provider<MerchantConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            MerchantConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantConfigRepository get() {
                return (MerchantConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature());
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        @Override // id.dana.di.component.MerchantDetailViewComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantDetailView merchantDetailView) {
            merchantDetailView.merchantDetailConfigPresenter = this.whenAvailable.get();
            MerchantDetailView_MembersInjector.MyBillsEntityDataFactory(merchantDetailView, this.FragmentBottomSheetPaymentSettingBinding.get());
            MerchantDetailView_MembersInjector.getAuthRequestContext(merchantDetailView, MerchantDanaDealsModule_ProvideMerchantDealsPresenterFactory.BuiltInFictitiousFunctionClassFactory(this.PrepareContext, new MerchantDanaDealsPresenter(new CreateDanaDealsVoucherOrder((MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M())), new GetShopPromoAndDeals((MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M()), (CoroutineDispatcher) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.GetContactSyncConfig())), new GetMerchantDanaDeals((MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M())), MerchantDanaDealsModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext), new MerchantDanaDealsMapper(), new NearbyPromoModelMapper(new CurrencyAmountModelMapper()), new CreateProductVoucherOrderMapper(), new DanaDealsOrderRequestMapper())));
            MerchantDetailView_MembersInjector.PlaceComponentResult(merchantDetailView, this.readMicros.get());
            merchantDetailView.tracker = this.getCallingPid.get();
        }
    }
}
