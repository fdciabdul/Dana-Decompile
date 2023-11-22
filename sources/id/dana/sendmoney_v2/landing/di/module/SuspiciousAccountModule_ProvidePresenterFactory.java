package id.dana.sendmoney_v2.landing.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SuspiciousAccountModule_ProvidePresenterFactory implements Factory<SuspiciousAccountContract.Presenter> {
    private final SuspiciousAccountModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SuspiciousAccountPresenter> PlaceComponentResult;

    private SuspiciousAccountModule_ProvidePresenterFactory(SuspiciousAccountModule suspiciousAccountModule, Provider<SuspiciousAccountPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = suspiciousAccountModule;
        this.PlaceComponentResult = provider;
    }

    public static SuspiciousAccountModule_ProvidePresenterFactory PlaceComponentResult(SuspiciousAccountModule suspiciousAccountModule, Provider<SuspiciousAccountPresenter> provider) {
        return new SuspiciousAccountModule_ProvidePresenterFactory(suspiciousAccountModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SuspiciousAccountContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
