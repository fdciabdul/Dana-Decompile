package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebaseAnalytics_Factory;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics_Factory;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics_Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory_Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.animation.tracker.HomeTrackerImpl_Factory;
import id.dana.animation.view.FourKingView;
import id.dana.animation.view.FourKingView_MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerFourKingComponent {
    private DaggerFourKingComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class FourKingComponentImpl implements FourKingComponent {
        private Provider<FirebaseAnalytics> BuiltInFictitiousFunctionClassFactory;
        private Provider<DynamicUrlWrapper> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<AnalyticsTrackerFactory> MyBillsEntityDataFactory;
        private Provider<HomeTrackerImpl> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<Context> PlaceComponentResult;
        private final FourKingComponentImpl getAuthRequestContext;
        private Provider<EventTrackerQueue> lookAheadTest;
        private Provider<FirebasePerformanceMonitor> moveToNextValue;
        private Provider<MixpanelAnalytics> scheduleImpl;

        public /* synthetic */ FourKingComponentImpl(ApplicationComponent applicationComponent, byte b) {
            this(applicationComponent);
        }

        private FourKingComponentImpl(ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.getAuthRequestContext = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new DynamicUrlWrapperProvider(applicationComponent);
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.moveToNextValue = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.lookAheadTest = provideEventTrackerQueueProvider;
            this.BuiltInFictitiousFunctionClassFactory = FirebaseAnalytics_Factory.PlaceComponentResult(this.PlaceComponentResult, this.moveToNextValue, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.lookAheadTest);
            this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.BuiltInFictitiousFunctionClassFactory;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.MyBillsEntityDataFactory = PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = HomeTrackerImpl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent getAuthRequestContext;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.getAuthRequestContext.PrepareContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.OtpRegistrationPresenter$input$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.getAuthRequestContext.j());
            }
        }

        @Override // id.dana.di.component.FourKingComponent
        public final void MyBillsEntityDataFactory(FourKingView fourKingView) {
            FourKingView_MembersInjector.MyBillsEntityDataFactory(fourKingView, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            FourKingView_MembersInjector.getAuthRequestContext(fourKingView, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
    }
}
