package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.MerchantDetailActionInfoModule;
import id.dana.di.modules.MerchantDetailActionInfoModule_ProvideMerchantDetailAnalyticTrackerFactory;
import id.dana.di.modules.MerchantDetailActionInfoModule_ProvideNearbymeTrackerFactory;
import id.dana.drawable.view.MerchantActionListView;
import id.dana.drawable.view.MerchantActionListView_MembersInjector;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers_Factory;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMerchantActionInfoComponent {
    private DaggerMerchantActionInfoComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public MerchantDetailActionInfoModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantActionInfoComponentImpl implements MerchantActionInfoComponent {
        private Provider<MerchantDetailMixpanelTrackers> BuiltInFictitiousFunctionClassFactory;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<NearbyDefaultTracker> MyBillsEntityDataFactory;
        private Provider<MerchantDetailAnalyticTracker> PlaceComponentResult;
        private final MerchantActionInfoComponentImpl getAuthRequestContext;
        private Provider<NearbyAnalyticTracker> moveToNextValue;

        public /* synthetic */ MerchantActionInfoComponentImpl(MerchantDetailActionInfoModule merchantDetailActionInfoModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantDetailActionInfoModule, applicationComponent);
        }

        private MerchantActionInfoComponentImpl(MerchantDetailActionInfoModule merchantDetailActionInfoModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            MerchantDetailMixpanelTrackers_Factory authRequestContext = MerchantDetailMixpanelTrackers_Factory.getAuthRequestContext(contextProvider);
            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
            this.PlaceComponentResult = DoubleCheck.getAuthRequestContext(MerchantDetailActionInfoModule_ProvideMerchantDetailAnalyticTrackerFactory.MyBillsEntityDataFactory(merchantDetailActionInfoModule, authRequestContext));
            NearbyDefaultTracker_Factory BuiltInFictitiousFunctionClassFactory = NearbyDefaultTracker_Factory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(MerchantDetailActionInfoModule_ProvideNearbymeTrackerFactory.PlaceComponentResult(merchantDetailActionInfoModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent getAuthRequestContext;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue());
            }
        }

        @Override // id.dana.di.component.MerchantActionInfoComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantActionListView merchantActionListView) {
            MerchantActionListView_MembersInjector.PlaceComponentResult(merchantActionListView, this.PlaceComponentResult.get());
            MerchantActionListView_MembersInjector.MyBillsEntityDataFactory(merchantActionListView, this.moveToNextValue.get());
        }
    }
}
