package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.OtherStoreListContract;

/* loaded from: classes5.dex */
public final class OtherStoreListModule_ProvideOtherStoreListViewFactory implements Factory<OtherStoreListContract.View> {
    private final OtherStoreListModule PlaceComponentResult;

    public static OtherStoreListContract.View getAuthRequestContext(OtherStoreListModule otherStoreListModule) {
        return (OtherStoreListContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(otherStoreListModule.getBuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OtherStoreListContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getBuiltInFictitiousFunctionClassFactory());
    }
}
