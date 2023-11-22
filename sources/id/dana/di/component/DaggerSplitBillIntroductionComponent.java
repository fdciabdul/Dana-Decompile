package id.dana.di.component;

import android.content.Context;
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
import id.dana.di.modules.SplitBillIntroductionModule;
import id.dana.di.modules.SplitBillIntroductionModule_ProvidePresenterFactory;
import id.dana.di.modules.SplitBillIntroductionModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper_Factory;
import id.dana.splitbill.SplitBillIntroductionContract;
import id.dana.splitbill.SplitBillIntroductionPresenter;
import id.dana.splitbill.SplitBillIntroductionPresenter_Factory;
import id.dana.splitbill.tracker.SplitBillMixpanelTracker;
import id.dana.splitbill.view.SplitBillIntroductionActivity;
import id.dana.splitbill.view.SplitBillIntroductionActivity_MembersInjector;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSplitBillIntroductionComponent {
    private DaggerSplitBillIntroductionComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public BottomSheetOnBoardingModule MyBillsEntityDataFactory;
        public SplitBillIntroductionModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SplitBillIntroductionComponentImpl implements SplitBillIntroductionComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<BottomSheetOnBoardingContract.View> DatabaseTableConfigUtil;
        private Provider<SaveDisplayBottomSheetOnBoarding> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SplitBillIntroductionContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private final SplitBillIntroductionComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<GetBottomSheetOnBoarding> PlaceComponentResult;
        private Provider<UserEducationRepository> PrepareContext;
        private Provider<BottomSheetOnBoardingPresenter> getAuthRequestContext;
        private Provider<GetRequestMoneyInfoFeature> getErrorConfigVersion;
        private Provider<SplitBillIntroductionContract.Presenter> initRecordTimeStamp;
        private Provider<ThreadExecutor> isLayoutRequested;
        private Provider<BottomSheetOnBoardingContract.Presenter> lookAheadTest;
        private Provider<GetSplitBillConfig> moveToNextValue;
        private Provider<SplitBillIntroductionPresenter> newProxyInstance;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ SplitBillIntroductionComponentImpl(SplitBillIntroductionModule splitBillIntroductionModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, ApplicationComponent applicationComponent, byte b) {
            this(splitBillIntroductionModule, bottomSheetOnBoardingModule, applicationComponent);
        }

        private SplitBillIntroductionComponentImpl(SplitBillIntroductionModule splitBillIntroductionModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.isLayoutRequested = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new SSLPinningRepositoryProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.isLayoutRequested, this.scheduleImpl, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda1, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(SplitBillIntroductionModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(splitBillIntroductionModule));
            this.moveToNextValue = GetSplitBillConfig_Factory.create(this.isLayoutRequested, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory);
            GetRequestMoneyInfoFeature_Factory create2 = GetRequestMoneyInfoFeature_Factory.create(this.isLayoutRequested, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory);
            this.getErrorConfigVersion = create2;
            Provider<SplitBillIntroductionContract.View> provider = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Provider<GetSplitBillConfig> provider2 = this.moveToNextValue;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            SplitBillIntroductionPresenter_Factory authRequestContext = SplitBillIntroductionPresenter_Factory.getAuthRequestContext(provider, provider2, create2, requestMoneyInfoModelMapper_Factory);
            this.newProxyInstance = authRequestContext;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(SplitBillIntroductionModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(splitBillIntroductionModule, authRequestContext));
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.PrepareContext = userEducationRepositoryProvider;
            this.PlaceComponentResult = GetBottomSheetOnBoarding_Factory.create(this.isLayoutRequested, this.scheduleImpl, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create3 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.isLayoutRequested, this.scheduleImpl, this.PrepareContext);
            this.GetContactSyncConfig = create3;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil, this.PlaceComponentResult, create3);
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ArrayTable$1());
            }
        }

        @Override // id.dana.di.component.SplitBillIntroductionComponent
        public final void getAuthRequestContext(SplitBillIntroductionActivity splitBillIntroductionActivity) {
            ((BaseActivity) splitBillIntroductionActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(splitBillIntroductionActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(splitBillIntroductionActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            SplitBillIntroductionActivity_MembersInjector.PlaceComponentResult(splitBillIntroductionActivity, this.initRecordTimeStamp.get());
            SplitBillIntroductionActivity_MembersInjector.MyBillsEntityDataFactory(splitBillIntroductionActivity, this.lookAheadTest.get());
            SplitBillIntroductionActivity_MembersInjector.MyBillsEntityDataFactory(splitBillIntroductionActivity, new SplitBillMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
        }
    }
}
