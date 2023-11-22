package id.dana.nearbyme.homeshopping.tnc;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.GetHomeShoppingTnc;
import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class HomeShoppingTncPresenter_Factory implements Factory<HomeShoppingTncPresenter> {
    private final Provider<HomeShoppingTncContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetHomeShoppingTnc> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomeShoppingTncPresenter(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
