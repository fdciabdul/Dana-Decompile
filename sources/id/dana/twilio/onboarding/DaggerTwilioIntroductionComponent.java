package id.dana.twilio.onboarding;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.twilio.interactor.CreateTwilioFactor;
import id.dana.domain.twilio.interactor.DeleteTwilioLocalFactor;
import id.dana.domain.twilio.interactor.TwilioBindEnrollment;
import id.dana.domain.twilio.interactor.TwilioConsultEnrollment;
import id.dana.domain.twilio.interactor.TwilioEnrollment;
import id.dana.domain.twilio.interactor.VerifyTwilioFactor;
import id.dana.twilio.onboarding.TwilioIntroductionContract;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerTwilioIntroductionComponent {
    private DaggerTwilioIntroductionComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        TwilioIntroductionModule BuiltInFictitiousFunctionClassFactory;
        ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    static final class TwilioIntroductionComponentImpl implements TwilioIntroductionComponent {
        private Provider<PostExecutionThread> BuiltInFictitiousFunctionClassFactory;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<TwilioIntroductionContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<IsOfflineF2FPay> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<ThreadExecutor> getErrorConfigVersion;
        private final TwilioIntroductionComponentImpl lookAheadTest;
        private Provider<SSLPinningRepository> moveToNextValue;

        public /* synthetic */ TwilioIntroductionComponentImpl(TwilioIntroductionModule twilioIntroductionModule, ApplicationComponent applicationComponent, byte b) {
            this(twilioIntroductionModule, applicationComponent);
        }

        private TwilioIntroductionComponentImpl(TwilioIntroductionModule twilioIntroductionModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.getAuthRequestContext = applicationComponent;
            this.getErrorConfigVersion = new ThreadExecutorProvider(applicationComponent);
            this.moveToNextValue = new SSLPinningRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.getErrorConfigVersion, this.BuiltInFictitiousFunctionClassFactory, featureConfigRepositoryProvider);
            this.PlaceComponentResult = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.getErrorConfigVersion, this.moveToNextValue, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(TwilioIntroductionModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(twilioIntroductionModule));
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

        @Override // id.dana.twilio.onboarding.TwilioIntroductionComponent
        public final void MyBillsEntityDataFactory(TwilioIntroductionActivity twilioIntroductionActivity) {
            ((BaseActivity) twilioIntroductionActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(twilioIntroductionActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(twilioIntroductionActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            TwilioIntroductionActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(twilioIntroductionActivity, new TwilioIntroductionPresenter((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue()), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), new TwilioConsultEnrollment((TwilioRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1())), new CheckTwilioEnrollmentStatus((ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto()), (TwilioSdkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$2())), new TwilioEnrollment((TwilioRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1())), new CreateTwilioFactor((ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto()), (TwilioSdkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$2())), new VerifyTwilioFactor((ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto()), (TwilioSdkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$2())), new DeleteTwilioLocalFactor((ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto()), (TwilioSdkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$2())), new TwilioBindEnrollment((ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto()), (TwilioRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1()))));
        }
    }
}
