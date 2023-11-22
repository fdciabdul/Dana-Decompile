package id.dana.mybills.di;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.MyBillsModule;
import id.dana.di.modules.MyBillsModule_ProvidePresenterFactory;
import id.dana.di.modules.MyBillsModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.mybills.MyBillsRepository;
import id.dana.domain.mybills.interactor.CheckSplitService;
import id.dana.domain.mybills.interactor.CheckSplitService_Factory;
import id.dana.domain.mybills.interactor.GetBizProductOrder;
import id.dana.domain.mybills.interactor.GetBizProductOrder_Factory;
import id.dana.domain.mybills.interactor.GetHighlightPayTransaction;
import id.dana.domain.mybills.interactor.GetHighlightPayTransaction_Factory;
import id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination_Factory;
import id.dana.domain.mybills.interactor.GetListHighlightMyBills;
import id.dana.domain.mybills.interactor.GetListHighlightMyBills_Factory;
import id.dana.domain.mybills.interactor.GetMonthlyAmountMyBills;
import id.dana.domain.mybills.interactor.GetMonthlyAmountMyBills_Factory;
import id.dana.domain.mybills.interactor.GetMonthlyWithConsultView;
import id.dana.domain.mybills.interactor.GetMonthlyWithConsultView_Factory;
import id.dana.domain.mybills.interactor.GetQuickBuyMyBills;
import id.dana.domain.mybills.interactor.GetQuickBuyMyBills_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.user.interactor.GetSingleBalance_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.mybills.ContinualBillsActivity;
import id.dana.mybills.ContinualBillsActivity_MembersInjector;
import id.dana.mybills.di.MyBillsContract;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerContinualBillsComponent {
    private DaggerContinualBillsComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public MyBillsModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class ContinualBillsComponentImpl implements ContinualBillsComponent {
        private Provider<DeviceInformationProvider> BuiltInFictitiousFunctionClassFactory;
        private Provider<IsOfflineF2FPay> DatabaseTableConfigUtil;
        private Provider<ThreadExecutor> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetMonthlyWithConsultView> GetContactSyncConfig;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CheckSplitService> MyBillsEntityDataFactory;
        private Provider<GetBizProductOrder> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetSingleBalance> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetMonthlyAmountMyBills> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<UserRepository> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<MyBillsContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ContinualBillsComponentImpl PlaceComponentResult;
        private Provider<MyBillsRepository> PrepareContext;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<GetHighlightPayTransaction> getErrorConfigVersion;
        private Provider<GetQuickBuyMyBills> initRecordTimeStamp;
        private Provider<MyBillsContract.View> isLayoutRequested;
        private Provider<FeatureConfigRepository> lookAheadTest;
        private Provider<GetListHighlightMyBills> moveToNextValue;
        private Provider<MyBillsPresenter> newProxyInstance;
        private Provider<GetInquirySubscriptionPaylaterWithDestination> scheduleImpl;

        public /* synthetic */ ContinualBillsComponentImpl(MyBillsModule myBillsModule, ApplicationComponent applicationComponent, byte b) {
            this(myBillsModule, applicationComponent);
        }

        private ContinualBillsComponentImpl(MyBillsModule myBillsModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.getAuthRequestContext = applicationComponent;
            this.FragmentBottomSheetPaymentSettingBinding = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.lookAheadTest = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda8, featureConfigRepositoryProvider);
            this.DatabaseTableConfigUtil = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda3, create);
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(MyBillsModule_ProvideViewFactory.MyBillsEntityDataFactory(myBillsModule));
            this.BuiltInFictitiousFunctionClassFactory = new DeviceInformationProviderProvider(applicationComponent);
            ProvideMyBillsRepositoryProvider provideMyBillsRepositoryProvider = new ProvideMyBillsRepositoryProvider(applicationComponent);
            this.PrepareContext = provideMyBillsRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetMonthlyAmountMyBills_Factory.create(provideMyBillsRepositoryProvider);
            this.moveToNextValue = GetListHighlightMyBills_Factory.create(this.PrepareContext);
            this.initRecordTimeStamp = GetQuickBuyMyBills_Factory.create(this.PrepareContext);
            this.MyBillsEntityDataFactory = CheckSplitService_Factory.create(this.PrepareContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetBizProductOrder_Factory.create(this.PrepareContext);
            this.getErrorConfigVersion = GetHighlightPayTransaction_Factory.create(this.PrepareContext);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = userRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetSingleBalance_Factory.create(userRepositoryProvider);
            this.GetContactSyncConfig = GetMonthlyWithConsultView_Factory.create(this.PrepareContext);
            this.scheduleImpl = GetInquirySubscriptionPaylaterWithDestination_Factory.create(this.PrepareContext);
            MyBillsPresenter_Factory authRequestContext = MyBillsPresenter_Factory.getAuthRequestContext(this.isLayoutRequested, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, this.initRecordTimeStamp, this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda1, CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.GetContactSyncConfig, this.scheduleImpl);
            this.newProxyInstance = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(MyBillsModule_ProvidePresenterFactory.MyBillsEntityDataFactory(myBillsModule, authRequestContext));
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
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideMyBillsRepositoryProvider implements Provider<MyBillsRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideMyBillsRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyBillsRepository get() {
                return (MyBillsRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.initAnimators());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BannerEntityDataFactory_Factory());
            }
        }

        @Override // id.dana.mybills.di.ContinualBillsComponent
        public final void MyBillsEntityDataFactory(ContinualBillsActivity continualBillsActivity) {
            ((BaseActivity) continualBillsActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(continualBillsActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(continualBillsActivity, DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
            ContinualBillsActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(continualBillsActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda7.get());
        }
    }
}
