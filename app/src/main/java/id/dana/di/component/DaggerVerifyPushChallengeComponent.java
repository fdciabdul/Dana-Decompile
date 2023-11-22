package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.challenge.verifypush.VerifyPushChallengeFragment;
import id.dana.challenge.verifypush.VerifyPushChallengeFragment_MembersInjector;
import id.dana.challenge.verifypush.VerifyPushContract;
import id.dana.challenge.verifypush.VerifyPushLoginPresenter;
import id.dana.challenge.verifypush.VerifyPushLoginPresenter_Factory;
import id.dana.di.modules.VerifyPushChallengeModule;
import id.dana.di.modules.VerifyPushChallengeModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetTwilioTimeoutConfig;
import id.dana.domain.featureconfig.interactor.GetTwilioTimeoutConfig_Factory;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.VerifyPushLogin;
import id.dana.domain.login.interactor.VerifyPushLogin_Factory;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge_Factory;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerVerifyPushChallengeComponent {
    private DaggerVerifyPushChallengeComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public VerifyPushChallengeModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class VerifyPushChallengeComponentImpl implements VerifyPushChallengeComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<VerifyPushLoginPresenter> GetContactSyncConfig;
        private Provider<GetTwilioTimeoutConfig> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<VerifyPushContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<VerifyPushLogin> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<LoginRepository> PlaceComponentResult;
        private Provider<PostExecutionThread> getAuthRequestContext;
        private Provider<ThreadExecutor> getErrorConfigVersion;
        private final VerifyPushChallengeComponentImpl lookAheadTest;
        private Provider<TwilioRequestChallenge> moveToNextValue;
        private Provider<TwilioRepository> scheduleImpl;

        public /* synthetic */ VerifyPushChallengeComponentImpl(VerifyPushChallengeModule verifyPushChallengeModule, ApplicationComponent applicationComponent, byte b) {
            this(verifyPushChallengeModule, applicationComponent);
        }

        private VerifyPushChallengeComponentImpl(VerifyPushChallengeModule verifyPushChallengeModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(VerifyPushChallengeModule_ProvideViewFactory.getAuthRequestContext(verifyPushChallengeModule));
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetTwilioTimeoutConfig_Factory.create(featureConfigRepositoryProvider);
            TwilioEnrollmentRepositoryProvider twilioEnrollmentRepositoryProvider = new TwilioEnrollmentRepositoryProvider(applicationComponent);
            this.scheduleImpl = twilioEnrollmentRepositoryProvider;
            this.moveToNextValue = TwilioRequestChallenge_Factory.create(twilioEnrollmentRepositoryProvider);
            this.getErrorConfigVersion = new ThreadExecutorProvider(applicationComponent);
            this.getAuthRequestContext = new PostExecutionThreadProvider(applicationComponent);
            LoginRepositoryProvider loginRepositoryProvider = new LoginRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = loginRepositoryProvider;
            VerifyPushLogin_Factory create = VerifyPushLogin_Factory.create(this.getErrorConfigVersion, this.getAuthRequestContext, loginRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = create;
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(VerifyPushLoginPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.KClassImpl$Data$declaredNonStaticMembers$2, this.moveToNextValue, create));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class TwilioEnrollmentRepositoryProvider implements Provider<TwilioRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            TwilioEnrollmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioRepository get() {
                return (TwilioRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1());
            }
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
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.G());
            }
        }

        @Override // id.dana.di.component.VerifyPushChallengeComponent
        public final void getAuthRequestContext(VerifyPushChallengeFragment verifyPushChallengeFragment) {
            VerifyPushChallengeFragment_MembersInjector.PlaceComponentResult(verifyPushChallengeFragment, this.GetContactSyncConfig.get());
            verifyPushChallengeFragment.twilioMixpanelTracker = new TwilioMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()));
        }
    }
}
