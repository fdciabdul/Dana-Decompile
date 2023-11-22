package id.dana.contract.boundcard;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.boundcard.BoundCardContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class BoundCardModule_ProvidePresenterFactory implements Factory<BoundCardContract.Presenter> {
    private final Provider<BoundCardPresenter> BuiltInFictitiousFunctionClassFactory;
    private final BoundCardModule getAuthRequestContext;

    public static BoundCardContract.Presenter PlaceComponentResult(BoundCardModule boundCardModule, BoundCardPresenter boundCardPresenter) {
        return (BoundCardContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(boundCardModule.BuiltInFictitiousFunctionClassFactory(boundCardPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BoundCardContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
