package id.dana.contract.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.user.GetProfilePictureContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetProfilePictureModule_ProvidePresenterFactory implements Factory<GetProfilePictureContract.Presenter> {
    private final Provider<GetProfilePicturePresenter> BuiltInFictitiousFunctionClassFactory;
    private final GetProfilePictureModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetProfilePictureContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
