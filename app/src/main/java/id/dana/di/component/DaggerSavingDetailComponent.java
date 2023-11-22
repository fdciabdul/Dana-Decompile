package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.CheckoutH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.CheckoutH5EventModule_ProvideViewFactory;
import id.dana.di.modules.SavingDetailModule;
import id.dana.di.modules.SavingDetailModule_ProvideSavingDetailViewFactory;
import id.dana.di.modules.SavingTopUpModule;
import id.dana.di.modules.SavingTopUpModule_ProvideSavingTopUpViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event_Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.interactor.GetSavingDetail;
import id.dana.domain.saving.interactor.GetSavingDetail_Factory;
import id.dana.domain.saving.interactor.InitSavingTopUp;
import id.dana.domain.saving.interactor.InitSavingTopUp_Factory;
import id.dana.domain.saving.interactor.RevokeSaving;
import id.dana.domain.saving.interactor.RevokeSaving_Factory;
import id.dana.domain.saving.interactor.TopUpSaving;
import id.dana.domain.saving.interactor.TopUpSaving_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.h5event.CheckoutH5EventPresenter;
import id.dana.savings.activity.SavingDetailActivity;
import id.dana.savings.activity.SavingDetailActivity_MembersInjector;
import id.dana.savings.contract.SavingDetailContract;
import id.dana.savings.contract.SavingTopUpContract;
import id.dana.savings.presenter.SavingDetailPresenter;
import id.dana.savings.presenter.SavingDetailPresenter_Factory;
import id.dana.savings.presenter.SavingTopUpPresenter;
import id.dana.savings.presenter.SavingTopUpPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSavingDetailComponent {
    private DaggerSavingDetailComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SavingTopUpModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public CheckoutH5EventModule PlaceComponentResult;
        public SavingDetailModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SavingDetailComponentImpl implements SavingDetailComponent {
        private final CheckoutH5EventModule BuiltInFictitiousFunctionClassFactory;
        private Provider<CheckoutH5EventContract.View> DatabaseTableConfigUtil;
        private Provider<UserRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SavingDetailContract.View> GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<GetCheckoutH5Event> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<SavingTopUpPresenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<TopUpSaving> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<SavingRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<SavingCategoryRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private final SavingDetailComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private Provider<SavingDetailPresenter> PrepareContext;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<GetSavingDetail> getErrorConfigVersion;
        private Provider<SavingTopUpContract.View> initRecordTimeStamp;
        private Provider<RevokeSaving> isLayoutRequested;
        private Provider<H5EventRepository> lookAheadTest;
        private Provider<InitSavingTopUp> moveToNextValue;
        private Provider<SSLPinningRepository> newProxyInstance;
        private Provider<GetUserInfoWithKyc> scheduleImpl;

        public /* synthetic */ SavingDetailComponentImpl(SavingDetailModule savingDetailModule, SavingTopUpModule savingTopUpModule, CheckoutH5EventModule checkoutH5EventModule, ApplicationComponent applicationComponent, byte b) {
            this(savingDetailModule, savingTopUpModule, checkoutH5EventModule, applicationComponent);
        }

        private SavingDetailComponentImpl(SavingDetailModule savingDetailModule, SavingTopUpModule savingTopUpModule, CheckoutH5EventModule checkoutH5EventModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = this;
            this.getAuthRequestContext = applicationComponent;
            this.BuiltInFictitiousFunctionClassFactory = checkoutH5EventModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new ThreadExecutorProvider(applicationComponent);
            this.newProxyInstance = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda1, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.newProxyInstance, create);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ContextProvider(applicationComponent);
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(SavingDetailModule_ProvideSavingDetailViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(savingDetailModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new SavingRepositoryProvider(applicationComponent);
            SavingCategoryRepositoryProvider savingCategoryRepositoryProvider = new SavingCategoryRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = savingCategoryRepositoryProvider;
            this.getErrorConfigVersion = GetSavingDetail_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, savingCategoryRepositoryProvider);
            RevokeSaving_Factory create2 = RevokeSaving_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.isLayoutRequested = create2;
            this.PrepareContext = DoubleCheck.getAuthRequestContext(SavingDetailPresenter_Factory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.GetContactSyncConfig, this.getErrorConfigVersion, create2));
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(SavingTopUpModule_ProvideSavingTopUpViewFactory.MyBillsEntityDataFactory(savingTopUpModule));
            this.moveToNextValue = InitSavingTopUp_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = TopUpSaving_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = userRepositoryProvider;
            GetUserInfoWithKyc_Factory create3 = GetUserInfoWithKyc_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda1, userRepositoryProvider);
            this.scheduleImpl = create3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(SavingTopUpPresenter_Factory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.initRecordTimeStamp, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda5, create3));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.lookAheadTest = h5eventRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetCheckoutH5Event_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda1, h5eventRepositoryProvider);
            this.DatabaseTableConfigUtil = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
            }
        }

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent getAuthRequestContext;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SavingRepositoryProvider implements Provider<SavingRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SavingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingRepository get() {
                return (SavingRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.useDaemonThreadFactory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SavingCategoryRepositoryProvider implements Provider<SavingCategoryRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SavingCategoryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingCategoryRepository get() {
                return (SavingCategoryRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getTextEndPadding());
            }
        }

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent PlaceComponentResult;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }

        @Override // id.dana.di.component.SavingDetailComponent
        public final void BuiltInFictitiousFunctionClassFactory(SavingDetailActivity savingDetailActivity) {
            ((BaseActivity) savingDetailActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(savingDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(savingDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            savingDetailActivity.savingDetailPresenter = this.PrepareContext.get();
            SavingDetailActivity_MembersInjector.MyBillsEntityDataFactory(savingDetailActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda4.get());
            savingDetailActivity.checkoutH5EventPresenter = CheckoutH5EventModule_ProvidePresenterFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, new CheckoutH5EventPresenter(DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil)));
        }
    }
}
