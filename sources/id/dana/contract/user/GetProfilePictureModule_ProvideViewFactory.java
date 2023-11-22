package id.dana.contract.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.user.GetProfilePictureContract;

/* loaded from: classes8.dex */
public final class GetProfilePictureModule_ProvideViewFactory implements Factory<GetProfilePictureContract.View> {
    private final GetProfilePictureModule BuiltInFictitiousFunctionClassFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetProfilePictureContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
    }
}
