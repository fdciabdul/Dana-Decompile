package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ipg.IpgGuideContract;
import id.dana.ipg.IpgGuidePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IpgModule_ProvidePresenterFactory implements Factory<IpgGuideContract.Presenter> {
    private final IpgModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<IpgGuidePresenter> getAuthRequestContext;

    public static IpgGuideContract.Presenter PlaceComponentResult(IpgModule ipgModule, IpgGuidePresenter ipgGuidePresenter) {
        return (IpgGuideContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(ipgModule.BuiltInFictitiousFunctionClassFactory(ipgGuidePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (IpgGuideContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
