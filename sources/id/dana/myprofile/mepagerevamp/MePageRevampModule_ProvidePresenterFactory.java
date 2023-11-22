package id.dana.myprofile.mepagerevamp;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MePageRevampModule_ProvidePresenterFactory implements Factory<MePageRevampContract.Presenter> {
    private final Provider<MePageRevampPresenter> BuiltInFictitiousFunctionClassFactory;
    private final MePageRevampModule KClassImpl$Data$declaredNonStaticMembers$2;

    private MePageRevampModule_ProvidePresenterFactory(MePageRevampModule mePageRevampModule, Provider<MePageRevampPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = mePageRevampModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static MePageRevampModule_ProvidePresenterFactory PlaceComponentResult(MePageRevampModule mePageRevampModule, Provider<MePageRevampPresenter> provider) {
        return new MePageRevampModule_ProvidePresenterFactory(mePageRevampModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MePageRevampContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
