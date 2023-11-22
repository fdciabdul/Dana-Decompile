package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.lazada.LazadaGuideContract;
import id.dana.lazada.LazadaGuidePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class LazadaModule_ProvidePresenterFactory implements Factory<LazadaGuideContract.Presenter> {
    private final Provider<LazadaGuidePresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final LazadaModule MyBillsEntityDataFactory;

    public static LazadaGuideContract.Presenter BuiltInFictitiousFunctionClassFactory(LazadaModule lazadaModule, LazadaGuidePresenter lazadaGuidePresenter) {
        return (LazadaGuideContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(lazadaModule.getAuthRequestContext(lazadaGuidePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LazadaGuideContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
