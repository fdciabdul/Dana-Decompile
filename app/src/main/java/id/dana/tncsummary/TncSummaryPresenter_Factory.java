package id.dana.tncsummary;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.tncsummary.interactor.GetSummaryTncConfigWithSpaceCode;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.tncsummary.TncSummaryContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TncSummaryPresenter_Factory implements Factory<TncSummaryPresenter> {
    private final Provider<TncSummaryContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ConsultAgreementOnlyParamSpaceCodes> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RecordAgreementOnlyAgreementKey> MyBillsEntityDataFactory;
    private final Provider<GetSummaryTncConfigWithSpaceCode> getAuthRequestContext;

    private TncSummaryPresenter_Factory(Provider<TncSummaryContract.View> provider, Provider<GetSummaryTncConfigWithSpaceCode> provider2, Provider<ConsultAgreementOnlyParamSpaceCodes> provider3, Provider<RecordAgreementOnlyAgreementKey> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static TncSummaryPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<TncSummaryContract.View> provider, Provider<GetSummaryTncConfigWithSpaceCode> provider2, Provider<ConsultAgreementOnlyParamSpaceCodes> provider3, Provider<RecordAgreementOnlyAgreementKey> provider4) {
        return new TncSummaryPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TncSummaryPresenter(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
