package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.usereducation.BottomSheetOnBoardingActivity;
import id.dana.usereducation.BottomSheetOnBoardingActivity_MembersInjector;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerBottomSheetOnBoardingComponent {
    private DaggerBottomSheetOnBoardingComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public BottomSheetOnBoardingModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class BottomSheetOnBoardingComponentImpl implements BottomSheetOnBoardingComponent {
        private Provider<BottomSheetOnBoardingPresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> DatabaseTableConfigUtil;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private final BottomSheetOnBoardingComponentImpl MyBillsEntityDataFactory;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<UserEducationRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<BottomSheetOnBoardingContract.Presenter> getErrorConfigVersion;
        private Provider<SaveDisplayBottomSheetOnBoarding> initRecordTimeStamp;
        private Provider<GetBottomSheetOnBoarding> lookAheadTest;
        private Provider<BottomSheetOnBoardingContract.View> moveToNextValue;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ BottomSheetOnBoardingComponentImpl(BottomSheetOnBoardingModule bottomSheetOnBoardingModule, ApplicationComponent applicationComponent, byte b) {
            this(bottomSheetOnBoardingModule, applicationComponent);
        }

        private BottomSheetOnBoardingComponentImpl(BottomSheetOnBoardingModule bottomSheetOnBoardingModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.getAuthRequestContext = applicationComponent;
            this.DatabaseTableConfigUtil = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new SSLPinningRepositoryProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.DatabaseTableConfigUtil, this.scheduleImpl, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create);
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = userEducationRepositoryProvider;
            this.lookAheadTest = GetBottomSheetOnBoarding_Factory.create(this.DatabaseTableConfigUtil, this.scheduleImpl, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create2 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.DatabaseTableConfigUtil, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.initRecordTimeStamp = create2;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.moveToNextValue, this.lookAheadTest, create2);
            this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* loaded from: classes4.dex */
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$1());
            }
        }

        @Override // id.dana.di.component.BottomSheetOnBoardingComponent
        public final void getAuthRequestContext(BottomSheetOnBoardingActivity bottomSheetOnBoardingActivity) {
            ((BaseActivity) bottomSheetOnBoardingActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(bottomSheetOnBoardingActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(bottomSheetOnBoardingActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BottomSheetOnBoardingActivity_MembersInjector.PlaceComponentResult(bottomSheetOnBoardingActivity, this.getErrorConfigVersion.get());
        }
    }
}
