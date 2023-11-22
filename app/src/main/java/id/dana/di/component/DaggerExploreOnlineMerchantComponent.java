package id.dana.di.component;

import android.content.Context;
import dagger.internal.Preconditions;
import id.dana.di.modules.OnlineMerchantAnalyticModule;
import id.dana.di.modules.OnlineMerchantAnalyticModule_ProvideOnlineMerchantMixpanelTracker$app_productionReleaseFactory;
import id.dana.explore.view.ExploreOnlineMerchantView;
import id.dana.explore.view.ExploreOnlineMerchantView_MembersInjector;

/* loaded from: classes4.dex */
public final class DaggerExploreOnlineMerchantComponent {
    private DaggerExploreOnlineMerchantComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public OnlineMerchantAnalyticModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ExploreOnlineMerchantComponentImpl implements ExploreOnlineMerchantComponent {
        private final ExploreOnlineMerchantComponentImpl BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private final OnlineMerchantAnalyticModule getAuthRequestContext;

        public /* synthetic */ ExploreOnlineMerchantComponentImpl(OnlineMerchantAnalyticModule onlineMerchantAnalyticModule, ApplicationComponent applicationComponent, byte b) {
            this(onlineMerchantAnalyticModule, applicationComponent);
        }

        private ExploreOnlineMerchantComponentImpl(OnlineMerchantAnalyticModule onlineMerchantAnalyticModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.getAuthRequestContext = onlineMerchantAnalyticModule;
            this.MyBillsEntityDataFactory = applicationComponent;
        }

        @Override // id.dana.di.component.ExploreOnlineMerchantComponent
        public final void PlaceComponentResult(ExploreOnlineMerchantView exploreOnlineMerchantView) {
            ExploreOnlineMerchantView_MembersInjector.MyBillsEntityDataFactory(exploreOnlineMerchantView, OnlineMerchantAnalyticModule_ProvideOnlineMerchantMixpanelTracker$app_productionReleaseFactory.PlaceComponentResult(this.getAuthRequestContext, (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue())));
        }
    }
}
