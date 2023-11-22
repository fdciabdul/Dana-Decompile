package id.dana.nearbyme.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.drawable.search.searchresult.MerchantSearchResultFragment;
import id.dana.drawable.search.searchresult.MerchantSearchResultFragment_MembersInjector;
import id.dana.nearbyme.di.module.NearbyTrackerModule;
import id.dana.nearbyme.di.module.NearbyTrackerModule_ProvideTrackerFactory;
import id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment;
import id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment_MembersInjector;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker_Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerNearbyTrackerComponent {
    private DaggerNearbyTrackerComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public NearbyTrackerModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final NearbyTrackerComponent getAuthRequestContext() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new NearbyTrackerModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, ApplicationComponent.class);
            return new NearbyTrackerComponentImpl(this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class NearbyTrackerComponentImpl implements NearbyTrackerComponent {
        private final NearbyTrackerComponentImpl BuiltInFictitiousFunctionClassFactory;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<NearbyDefaultTracker> MyBillsEntityDataFactory;
        private Provider<NearbyAnalyticTracker> PlaceComponentResult;

        /* synthetic */ NearbyTrackerComponentImpl(NearbyTrackerModule nearbyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(nearbyTrackerModule, applicationComponent);
        }

        private NearbyTrackerComponentImpl(NearbyTrackerModule nearbyTrackerModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            NearbyDefaultTracker_Factory BuiltInFictitiousFunctionClassFactory = NearbyDefaultTracker_Factory.BuiltInFictitiousFunctionClassFactory(contextProvider);
            this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
            this.PlaceComponentResult = DoubleCheck.getAuthRequestContext(NearbyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(nearbyTrackerModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        @Override // id.dana.nearbyme.di.component.NearbyTrackerComponent
        public final void PlaceComponentResult(HomeShoppingTutorialFragment homeShoppingTutorialFragment) {
            HomeShoppingTutorialFragment_MembersInjector.MyBillsEntityDataFactory(homeShoppingTutorialFragment, this.PlaceComponentResult.get());
        }

        @Override // id.dana.nearbyme.di.component.NearbyTrackerComponent
        public final void MyBillsEntityDataFactory(MerchantSearchResultFragment merchantSearchResultFragment) {
            MerchantSearchResultFragment_MembersInjector.getAuthRequestContext(merchantSearchResultFragment, this.PlaceComponentResult.get());
        }
    }
}
