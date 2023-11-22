package id.dana.cancelsurvey.di;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.cancelsurvey.presenter.CancelSurveyContract;
import id.dana.cancelsurvey.presenter.CancelSurveyPresenter;
import id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.cancelsurvey.interactor.ConsultCancelSurveyReason;
import id.dana.domain.cancelsurvey.interactor.SubmitCancelSurveyReason;
import id.dana.domain.cancelsurvey.repository.CancelSurveyRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerCancelSurveyComponent {
    private DaggerCancelSurveyComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public CancelSurveyModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class CancelSurveyComponentImpl implements CancelSurveyComponent {
        private Provider<IsOfflineF2FPay> BuiltInFictitiousFunctionClassFactory;
        private final CancelSurveyComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<ThreadExecutor> getErrorConfigVersion;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<CancelSurveyContract.View> moveToNextValue;

        public /* synthetic */ CancelSurveyComponentImpl(CancelSurveyModule cancelSurveyModule, ApplicationComponent applicationComponent, byte b) {
            this(cancelSurveyModule, applicationComponent);
        }

        private CancelSurveyComponentImpl(CancelSurveyModule cancelSurveyModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.getAuthRequestContext = applicationComponent;
            this.getErrorConfigVersion = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SSLPinningRepositoryProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.getErrorConfigVersion, this.lookAheadTest, featureConfigRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda0, create);
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(CancelSurveyModule_ProvideCancelSurveyViewFactory.BuiltInFictitiousFunctionClassFactory(cancelSurveyModule));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto());
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

        @Override // id.dana.cancelsurvey.di.CancelSurveyComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity) {
            ((BaseActivity) bottomSheetCancelSurveyActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(bottomSheetCancelSurveyActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(bottomSheetCancelSurveyActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            bottomSheetCancelSurveyActivity.cancelSurveyPresenter = new CancelSurveyPresenter((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue()), this.moveToNextValue.get(), new ConsultCancelSurveyReason((CancelSurveyRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.TypeProjectionImpl())), new SubmitCancelSurveyReason((CancelSurveyRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.TypeProjectionImpl())));
        }
    }
}
