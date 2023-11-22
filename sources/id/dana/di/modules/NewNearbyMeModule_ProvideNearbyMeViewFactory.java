package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.NewNearbyMeContract;

/* loaded from: classes4.dex */
public final class NewNearbyMeModule_ProvideNearbyMeViewFactory implements Factory<NewNearbyMeContract.View> {
    private final NewNearbyMeModule MyBillsEntityDataFactory;

    private NewNearbyMeModule_ProvideNearbyMeViewFactory(NewNearbyMeModule newNearbyMeModule) {
        this.MyBillsEntityDataFactory = newNearbyMeModule;
    }

    public static NewNearbyMeModule_ProvideNearbyMeViewFactory PlaceComponentResult(NewNearbyMeModule newNearbyMeModule) {
        return new NewNearbyMeModule_ProvideNearbyMeViewFactory(newNearbyMeModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NewNearbyMeContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getMyBillsEntityDataFactory());
    }
}
