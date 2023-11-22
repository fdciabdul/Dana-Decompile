package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.kycamledd.KycAmlEddContract;
import id.dana.kycamledd.KycAmlEddPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class KycAmlEddModule_ProvidePresenter$app_productionReleaseFactory implements Factory<KycAmlEddContract.Presenter> {
    private final Provider<KycAmlEddPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final KycAmlEddModule MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KycAmlEddContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
