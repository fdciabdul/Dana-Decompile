package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.CheckoutH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.CheckoutH5EventModule_ProvideViewFactory;
import id.dana.di.modules.SavingCreateModule;
import id.dana.di.modules.SavingCreateModule_ProvideSavingCreateViewFactory;
import id.dana.di.modules.SavingCreateModule_ProvideSavingPresenterFactory;
import id.dana.di.modules.SavingUpdateModule;
import id.dana.di.modules.SavingUpdateModule_ProvideSavingUpdateViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event_Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.interactor.CreateSaving;
import id.dana.domain.saving.interactor.CreateSaving_Factory;
import id.dana.domain.saving.interactor.InitSavingCreate;
import id.dana.domain.saving.interactor.InitSavingCreate_Factory;
import id.dana.domain.saving.interactor.InitSavingUpdate;
import id.dana.domain.saving.interactor.InitSavingUpdate_Factory;
import id.dana.domain.saving.interactor.UpdateSaving;
import id.dana.domain.saving.interactor.UpdateSaving_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.h5event.CheckoutH5EventPresenter;
import id.dana.savings.activity.SavingCreateActivity;
import id.dana.savings.activity.SavingCreateActivity_MembersInjector;
import id.dana.savings.activity.SavingUpdateActivity;
import id.dana.savings.activity.SavingUpdateActivity_MembersInjector;
import id.dana.savings.contract.SavingCreateContract;
import id.dana.savings.contract.SavingUpdateContract;
import id.dana.savings.presenter.SavingCreatePresenter;
import id.dana.savings.presenter.SavingCreatePresenter_Factory;
import id.dana.savings.presenter.SavingUpdatePresenter;
import id.dana.savings.presenter.SavingUpdatePresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSavingUpdateComponent {
    private DaggerSavingUpdateComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public SavingCreateModule KClassImpl$Data$declaredNonStaticMembers$2;
        public SavingUpdateModule MyBillsEntityDataFactory;
        public CheckoutH5EventModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final SavingUpdateComponent KClassImpl$Data$declaredNonStaticMembers$2() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, SavingCreateModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, SavingUpdateModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, CheckoutH5EventModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            return new SavingUpdateComponentImpl(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SavingUpdateComponentImpl implements SavingUpdateComponent {
        private final CheckoutH5EventModule BuiltInFictitiousFunctionClassFactory;
        private Provider<SavingCreateContract.View> DatabaseTableConfigUtil;
        private Provider<ThreadExecutor> FragmentBottomSheetPaymentSettingBinding;
        private Provider<IsOfflineF2FPay> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CreateSaving> MyBillsEntityDataFactory;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<InitSavingUpdate> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SavingUpdatePresenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<UpdateSaving> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private final SavingUpdateComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<SavingRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<SavingCategoryRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<SavingUpdateContract.View> PrepareContext;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private Provider<InitSavingCreate> getErrorConfigVersion;
        private Provider<UserRepository> getSupportButtonTintMode;
        private Provider<SavingCreateContract.Presenter> initRecordTimeStamp;
        private Provider<CheckoutH5EventContract.View> isLayoutRequested;
        private Provider<H5EventRepository> lookAheadTest;
        private Provider<GetUserInfoWithKyc> moveToNextValue;
        private Provider<SavingCreatePresenter> newProxyInstance;
        private Provider<GetCheckoutH5Event> scheduleImpl;

        /* synthetic */ SavingUpdateComponentImpl(SavingCreateModule savingCreateModule, SavingUpdateModule savingUpdateModule, CheckoutH5EventModule checkoutH5EventModule, ApplicationComponent applicationComponent, byte b) {
            this(savingCreateModule, savingUpdateModule, checkoutH5EventModule, applicationComponent);
        }

        private SavingUpdateComponentImpl(SavingCreateModule savingCreateModule, SavingUpdateModule savingUpdateModule, CheckoutH5EventModule checkoutH5EventModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.BuiltInFictitiousFunctionClassFactory = checkoutH5EventModule;
            this.FragmentBottomSheetPaymentSettingBinding = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda1, featureConfigRepositoryProvider);
            this.GetContactSyncConfig = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda8, create);
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(SavingCreateModule_ProvideSavingCreateViewFactory.PlaceComponentResult(savingCreateModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new SavingRepositoryProvider(applicationComponent);
            SavingCategoryRepositoryProvider savingCategoryRepositoryProvider = new SavingCategoryRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = savingCategoryRepositoryProvider;
            this.getErrorConfigVersion = InitSavingCreate_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, savingCategoryRepositoryProvider);
            this.MyBillsEntityDataFactory = CreateSaving_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = userRepositoryProvider;
            GetUserInfoWithKyc_Factory create2 = GetUserInfoWithKyc_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda1, userRepositoryProvider);
            this.moveToNextValue = create2;
            SavingCreatePresenter_Factory MyBillsEntityDataFactory = SavingCreatePresenter_Factory.MyBillsEntityDataFactory(this.PlaceComponentResult, this.DatabaseTableConfigUtil, this.getErrorConfigVersion, this.MyBillsEntityDataFactory, create2);
            this.newProxyInstance = MyBillsEntityDataFactory;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(SavingCreateModule_ProvideSavingPresenterFactory.getAuthRequestContext(savingCreateModule, MyBillsEntityDataFactory));
            this.PrepareContext = DoubleCheck.getAuthRequestContext(SavingUpdateModule_ProvideSavingUpdateViewFactory.BuiltInFictitiousFunctionClassFactory(savingUpdateModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = InitSavingUpdate_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            UpdateSaving_Factory create3 = UpdateSaving_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = create3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(SavingUpdatePresenter_Factory.PlaceComponentResult(this.PlaceComponentResult, this.PrepareContext, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create3, this.moveToNextValue));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.lookAheadTest = h5eventRepositoryProvider;
            this.scheduleImpl = GetCheckoutH5Event_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda1, h5eventRepositoryProvider);
            this.isLayoutRequested = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
        }

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
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
        public static final class SavingRepositoryProvider implements Provider<SavingRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SavingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingRepository get() {
                return (SavingRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.useDaemonThreadFactory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SavingCategoryRepositoryProvider implements Provider<SavingCategoryRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SavingCategoryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingCategoryRepository get() {
                return (SavingCategoryRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getTextEndPadding());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }

        @Override // id.dana.di.component.SavingUpdateComponent
        public final void BuiltInFictitiousFunctionClassFactory(SavingCreateActivity savingCreateActivity) {
            ((BaseActivity) savingCreateActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(savingCreateActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(savingCreateActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            SavingCreateActivity_MembersInjector.getAuthRequestContext(savingCreateActivity, this.initRecordTimeStamp.get());
            SavingCreateActivity_MembersInjector.getAuthRequestContext(savingCreateActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext()));
        }

        @Override // id.dana.di.component.SavingUpdateComponent
        public final void getAuthRequestContext(SavingUpdateActivity savingUpdateActivity) {
            ((BaseActivity) savingUpdateActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(savingUpdateActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(savingUpdateActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            SavingCreateActivity_MembersInjector.getAuthRequestContext(savingUpdateActivity, this.initRecordTimeStamp.get());
            SavingCreateActivity_MembersInjector.getAuthRequestContext(savingUpdateActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext()));
            SavingUpdateActivity_MembersInjector.MyBillsEntityDataFactory(savingUpdateActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda3.get());
            savingUpdateActivity.checkoutH5EventPresenter = CheckoutH5EventModule_ProvidePresenterFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, new CheckoutH5EventPresenter(DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested)));
        }
    }
}
