package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.di.modules.WelcomeModule;
import id.dana.di.modules.WelcomeModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.onboarding.welcome.WelcomeFragment;
import id.dana.onboarding.welcome.WelcomePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerWelcomeComponent {
    private DaggerWelcomeComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public WelcomeModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class WelcomeComponentImpl implements WelcomeComponent {
        private final WelcomeModule BuiltInFictitiousFunctionClassFactory;
        private Provider<RegistrationTracker> KClassImpl$Data$declaredNonStaticMembers$2;
        private final WelcomeComponentImpl PlaceComponentResult;

        public /* synthetic */ WelcomeComponentImpl(WelcomeModule welcomeModule, ApplicationComponent applicationComponent, byte b) {
            this(welcomeModule, applicationComponent);
        }

        private WelcomeComponentImpl(WelcomeModule welcomeModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.BuiltInFictitiousFunctionClassFactory = welcomeModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ProvideRegistrationTrackerProvider(applicationComponent);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideRegistrationTrackerProvider implements Provider<RegistrationTracker> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideRegistrationTrackerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationTracker get() {
                return (RegistrationTracker) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.verifyNotNull());
            }
        }

        @Override // id.dana.di.component.WelcomeComponent
        public final void BuiltInFictitiousFunctionClassFactory(WelcomeFragment welcomeFragment) {
            welcomeFragment.presenter = WelcomeModule_ProvidePresenter$app_productionReleaseFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, new WelcomePresenter(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)));
        }
    }
}
