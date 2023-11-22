package id.dana.contract.ott;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.ott.OttVerifyContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OttVerifyModule_ProvidePresenterFactory implements Factory<OttVerifyContract.Presenter> {
    private final Provider<OttVerifyPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final OttVerifyModule getAuthRequestContext;

    private OttVerifyModule_ProvidePresenterFactory(OttVerifyModule ottVerifyModule, Provider<OttVerifyPresenter> provider) {
        this.getAuthRequestContext = ottVerifyModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static OttVerifyModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(OttVerifyModule ottVerifyModule, Provider<OttVerifyPresenter> provider) {
        return new OttVerifyModule_ProvidePresenterFactory(ottVerifyModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OttVerifyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
