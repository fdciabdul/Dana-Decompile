package id.dana.kycamledd;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.kycamledd.interactor.GetKycAmlEddConsult;
import id.dana.domain.kycamledd.interactor.SubmitEddAmlKyc;
import id.dana.kycamledd.KycAmlEddContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class KycAmlEddPresenter_Factory implements Factory<KycAmlEddPresenter> {
    private final Provider<GetKycAmlEddConsult> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SubmitEddAmlKyc> PlaceComponentResult;
    private final Provider<KycAmlEddContract.View> getAuthRequestContext;

    private KycAmlEddPresenter_Factory(Provider<KycAmlEddContract.View> provider, Provider<GetKycAmlEddConsult> provider2, Provider<SubmitEddAmlKyc> provider3) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static KycAmlEddPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<KycAmlEddContract.View> provider, Provider<GetKycAmlEddConsult> provider2, Provider<SubmitEddAmlKyc> provider3) {
        return new KycAmlEddPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KycAmlEddPresenter(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
