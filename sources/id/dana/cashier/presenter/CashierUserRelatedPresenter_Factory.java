package id.dana.cashier.presenter;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.domain.featureconfig.interactor.CheckQrisCardPaymentTncFeature;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierUserRelatedPresenter_Factory implements Factory<CashierUserRelatedPresenter> {
    private final Provider<GetSingleBalance> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RecordAgreementOnlyAgreementKey> MyBillsEntityDataFactory;
    private final Provider<ConsultAgreementOnlyParamSpaceCodes> PlaceComponentResult;
    private final Provider<CheckQrisCardPaymentTncFeature> getAuthRequestContext;
    private final Provider<CashierUserRelatedContract.View> moveToNextValue;

    private CashierUserRelatedPresenter_Factory(Provider<Context> provider, Provider<CashierUserRelatedContract.View> provider2, Provider<CheckQrisCardPaymentTncFeature> provider3, Provider<ConsultAgreementOnlyParamSpaceCodes> provider4, Provider<RecordAgreementOnlyAgreementKey> provider5, Provider<GetSingleBalance> provider6) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.moveToNextValue = provider2;
        this.getAuthRequestContext = provider3;
        this.PlaceComponentResult = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
    }

    public static CashierUserRelatedPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<CashierUserRelatedContract.View> provider2, Provider<CheckQrisCardPaymentTncFeature> provider3, Provider<ConsultAgreementOnlyParamSpaceCodes> provider4, Provider<RecordAgreementOnlyAgreementKey> provider5, Provider<GetSingleBalance> provider6) {
        return new CashierUserRelatedPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierUserRelatedPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
    }
}
