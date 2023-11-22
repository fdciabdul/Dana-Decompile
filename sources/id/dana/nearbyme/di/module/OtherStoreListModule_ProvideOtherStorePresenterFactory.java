package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.OtherStoreListContract;
import id.dana.contract.nearbyme.OtherStoreListPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class OtherStoreListModule_ProvideOtherStorePresenterFactory implements Factory<OtherStoreListContract.Presenter> {
    private final Provider<OtherStoreListPresenter> PlaceComponentResult;
    private final OtherStoreListModule getAuthRequestContext;

    public static OtherStoreListContract.Presenter MyBillsEntityDataFactory(OtherStoreListModule otherStoreListModule, OtherStoreListPresenter otherStoreListPresenter) {
        return (OtherStoreListContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(otherStoreListModule.MyBillsEntityDataFactory(otherStoreListPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OtherStoreListContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.PlaceComponentResult.get()));
    }
}
