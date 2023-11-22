package id.dana.nearbyme.di.component;

import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.GetHomeShoppingTnc;
import id.dana.nearbyme.di.module.HomeShoppingTncModule;
import id.dana.nearbyme.di.module.HomeShoppingTncModule_ProvideViewFactory;
import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncFragment;
import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncPresenter;

/* loaded from: classes5.dex */
public final class DaggerHomeShoppingTncComponent {
    private DaggerHomeShoppingTncComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public HomeShoppingTncModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class HomeShoppingTncComponentImpl implements HomeShoppingTncComponent {
        private final HomeShoppingTncComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent PlaceComponentResult;
        private final HomeShoppingTncModule getAuthRequestContext;

        public /* synthetic */ HomeShoppingTncComponentImpl(HomeShoppingTncModule homeShoppingTncModule, ApplicationComponent applicationComponent, byte b) {
            this(homeShoppingTncModule, applicationComponent);
        }

        private HomeShoppingTncComponentImpl(HomeShoppingTncModule homeShoppingTncModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.PlaceComponentResult = applicationComponent;
            this.getAuthRequestContext = homeShoppingTncModule;
        }

        @Override // id.dana.nearbyme.di.component.HomeShoppingTncComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(HomeShoppingTncFragment homeShoppingTncFragment) {
            homeShoppingTncFragment.presenter = new HomeShoppingTncPresenter(new GetHomeShoppingTnc((MerchantInfoRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.M())), HomeShoppingTncModule_ProvideViewFactory.getAuthRequestContext(this.getAuthRequestContext));
        }
    }
}
