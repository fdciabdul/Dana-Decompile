package id.dana.di.component;

import android.content.Context;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.di.modules.CitCallIntroductionModule;
import id.dana.di.modules.CitCallIntroductionModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.citcall.CitcallRepository;
import id.dana.domain.citcall.interactor.GetCitcallOtp;
import id.dana.domain.citcall.interactor.GetCitcallPermissionUseCase;
import id.dana.onboarding.citcall.CitCallIntroductionFragment;
import id.dana.onboarding.citcall.CitCallIntroductionFragment_MembersInjector;
import id.dana.onboarding.citcall.CitCallPresenter;
import id.dana.onboarding.citcall.tracker.CitCallTrackerImpl;

/* loaded from: classes4.dex */
public final class DaggerCitCallIntroductionComponent {
    private DaggerCitCallIntroductionComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public CitCallIntroductionModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class CitCallIntroductionComponentImpl implements CitCallIntroductionComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private final CitCallIntroductionModule MyBillsEntityDataFactory;
        private final CitCallIntroductionComponentImpl PlaceComponentResult;

        public /* synthetic */ CitCallIntroductionComponentImpl(CitCallIntroductionModule citCallIntroductionModule, ApplicationComponent applicationComponent, byte b) {
            this(citCallIntroductionModule, applicationComponent);
        }

        private CitCallIntroductionComponentImpl(CitCallIntroductionModule citCallIntroductionModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.MyBillsEntityDataFactory = citCallIntroductionModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
        }

        @Override // id.dana.di.component.CitCallIntroductionComponent
        public final void BuiltInFictitiousFunctionClassFactory(CitCallIntroductionFragment citCallIntroductionFragment) {
            CitCallIntroductionFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(citCallIntroductionFragment, new CitCallPresenter(CitCallIntroductionModule_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory), new GetCitcallOtp((CitcallRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.f())), new GetCitcallPermissionUseCase((CitcallRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.f())), (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()), new CitCallTrackerImpl(new AnalyticsTrackerFactory(new FirebaseAnalytics((Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()), (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.OtpRegistrationPresenter$input$2()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.j())), new MixpanelAnalytics((Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.j())), new FullStoryAnalytics()), (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()))));
        }
    }
}
