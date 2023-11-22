package id.dana.personalizedhome;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.personalizedhome.HomePersonalizationContract;

/* loaded from: classes5.dex */
public final class HomePersonalizedModule_ProvideViewFactory implements Factory<HomePersonalizationContract.View> {
    private final HomePersonalizedModule MyBillsEntityDataFactory;

    private HomePersonalizedModule_ProvideViewFactory(HomePersonalizedModule homePersonalizedModule) {
        this.MyBillsEntityDataFactory = homePersonalizedModule;
    }

    public static HomePersonalizedModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(HomePersonalizedModule homePersonalizedModule) {
        return new HomePersonalizedModule_ProvideViewFactory(homePersonalizedModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomePersonalizationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
