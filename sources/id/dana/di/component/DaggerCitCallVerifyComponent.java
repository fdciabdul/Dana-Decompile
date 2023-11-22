package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.di.modules.CitCallIntroductionModule;
import id.dana.di.modules.CitCallIntroductionModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.CitCallVerifyModule;
import id.dana.di.modules.CitCallVerifyModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.citcall.CitcallRepository;
import id.dana.domain.citcall.interactor.GetCitcallOtp;
import id.dana.domain.citcall.interactor.GetCitcallPermissionUseCase;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import id.dana.onboarding.citcall.CitCallPresenter;
import id.dana.onboarding.citcall.CitCallVerifyFragment;
import id.dana.onboarding.citcall.CitCallVerifyFragment_MembersInjector;
import id.dana.onboarding.citcall.CitCallVerifyPresenter;
import id.dana.onboarding.citcall.tracker.CitCallTrackerImpl;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerCitCallVerifyComponent {
    private DaggerCitCallVerifyComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public CitCallIntroductionModule KClassImpl$Data$declaredNonStaticMembers$2;
        public CitCallVerifyModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class CitCallVerifyComponentImpl implements CitCallVerifyComponent {
        private final CitCallVerifyModule BuiltInFictitiousFunctionClassFactory;
        private Provider<RegistrationTracker> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private final CitCallVerifyComponentImpl PlaceComponentResult;
        private final CitCallIntroductionModule getAuthRequestContext;

        public /* synthetic */ CitCallVerifyComponentImpl(CitCallVerifyModule citCallVerifyModule, CitCallIntroductionModule citCallIntroductionModule, ApplicationComponent applicationComponent, byte b) {
            this(citCallVerifyModule, citCallIntroductionModule, applicationComponent);
        }

        private CitCallVerifyComponentImpl(CitCallVerifyModule citCallVerifyModule, CitCallIntroductionModule citCallIntroductionModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.BuiltInFictitiousFunctionClassFactory = citCallVerifyModule;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.getAuthRequestContext = citCallIntroductionModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ProvideRegistrationTrackerProvider(applicationComponent);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideRegistrationTrackerProvider implements Provider<RegistrationTracker> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideRegistrationTrackerProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationTracker get() {
                return (RegistrationTracker) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.verifyNotNull());
            }
        }

        @Override // id.dana.di.component.CitCallVerifyComponent
        public final void BuiltInFictitiousFunctionClassFactory(CitCallVerifyFragment citCallVerifyFragment) {
            citCallVerifyFragment.citCallVerifyPresenter = new CitCallVerifyPresenter(CitCallVerifyModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory), new VerifyOtpRisk((CarrierIdentificationRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.e())), (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            CitCallVerifyFragment_MembersInjector.MyBillsEntityDataFactory(citCallVerifyFragment, new CitCallPresenter(CitCallIntroductionModule_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext), new GetCitcallOtp((CitcallRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.f())), new GetCitcallPermissionUseCase((CitcallRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.f())), (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()), new CitCallTrackerImpl(new AnalyticsTrackerFactory(new FirebaseAnalytics((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()), (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.OtpRegistrationPresenter$input$2()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.j())), new MixpanelAnalytics((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.j())), new FullStoryAnalytics()), (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()))));
        }
    }
}
