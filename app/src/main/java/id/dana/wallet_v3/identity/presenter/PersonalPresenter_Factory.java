package id.dana.wallet_v3.identity.presenter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.wallet_v3.interactor.CheckKtpConsultPopUp;
import id.dana.domain.wallet_v3.interactor.CheckKtpIsSaved;
import id.dana.domain.wallet_v3.interactor.GetInsuranceAssetList;
import id.dana.domain.wallet_v3.interactor.GetIntervalTimeHitWalletApi;
import id.dana.domain.wallet_v3.interactor.GetKtpInfo;
import id.dana.domain.wallet_v3.interactor.GetUserKYCStatus;
import id.dana.domain.wallet_v3.interactor.SaveKtpConsultPopUp;
import id.dana.wallet.personal.PersonalContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PersonalPresenter_Factory implements Factory<PersonalPresenter> {
    private final Provider<CheckKtpConsultPopUp> checkKtpConsultPopUpProvider;
    private final Provider<CheckKtpIsSaved> checkKtpIsSavedProvider;
    private final Provider<ConsultAgreementOnlyParamSpaceCodes> consultAgreementCenterProvider;
    private final Provider<GetInsuranceAssetList> getInsuranceAssetListProvider;
    private final Provider<GetIntervalTimeHitWalletApi> getIntervalTimeHitWalletApiProvider;
    private final Provider<GetKtpInfo> getKtpInfoProvider;
    private final Provider<GetUserKYCStatus> getUserKYCStatusProvider;
    private final Provider<RecordAgreementOnlyAgreementKey> recordAgreementProvider;
    private final Provider<SaveKtpConsultPopUp> saveKtpConsultPopUpProvider;
    private final Provider<PersonalContract.View> viewProvider;

    public PersonalPresenter_Factory(Provider<PersonalContract.View> provider, Provider<CheckKtpConsultPopUp> provider2, Provider<SaveKtpConsultPopUp> provider3, Provider<GetUserKYCStatus> provider4, Provider<GetKtpInfo> provider5, Provider<GetInsuranceAssetList> provider6, Provider<CheckKtpIsSaved> provider7, Provider<ConsultAgreementOnlyParamSpaceCodes> provider8, Provider<RecordAgreementOnlyAgreementKey> provider9, Provider<GetIntervalTimeHitWalletApi> provider10) {
        this.viewProvider = provider;
        this.checkKtpConsultPopUpProvider = provider2;
        this.saveKtpConsultPopUpProvider = provider3;
        this.getUserKYCStatusProvider = provider4;
        this.getKtpInfoProvider = provider5;
        this.getInsuranceAssetListProvider = provider6;
        this.checkKtpIsSavedProvider = provider7;
        this.consultAgreementCenterProvider = provider8;
        this.recordAgreementProvider = provider9;
        this.getIntervalTimeHitWalletApiProvider = provider10;
    }

    @Override // javax.inject.Provider
    public final PersonalPresenter get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.viewProvider), DoubleCheck.MyBillsEntityDataFactory(this.checkKtpConsultPopUpProvider), DoubleCheck.MyBillsEntityDataFactory(this.saveKtpConsultPopUpProvider), DoubleCheck.MyBillsEntityDataFactory(this.getUserKYCStatusProvider), DoubleCheck.MyBillsEntityDataFactory(this.getKtpInfoProvider), DoubleCheck.MyBillsEntityDataFactory(this.getInsuranceAssetListProvider), DoubleCheck.MyBillsEntityDataFactory(this.checkKtpIsSavedProvider), DoubleCheck.MyBillsEntityDataFactory(this.consultAgreementCenterProvider), DoubleCheck.MyBillsEntityDataFactory(this.recordAgreementProvider), DoubleCheck.MyBillsEntityDataFactory(this.getIntervalTimeHitWalletApiProvider));
    }

    public static PersonalPresenter_Factory create(Provider<PersonalContract.View> provider, Provider<CheckKtpConsultPopUp> provider2, Provider<SaveKtpConsultPopUp> provider3, Provider<GetUserKYCStatus> provider4, Provider<GetKtpInfo> provider5, Provider<GetInsuranceAssetList> provider6, Provider<CheckKtpIsSaved> provider7, Provider<ConsultAgreementOnlyParamSpaceCodes> provider8, Provider<RecordAgreementOnlyAgreementKey> provider9, Provider<GetIntervalTimeHitWalletApi> provider10) {
        return new PersonalPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static PersonalPresenter newInstance(Lazy<PersonalContract.View> lazy, Lazy<CheckKtpConsultPopUp> lazy2, Lazy<SaveKtpConsultPopUp> lazy3, Lazy<GetUserKYCStatus> lazy4, Lazy<GetKtpInfo> lazy5, Lazy<GetInsuranceAssetList> lazy6, Lazy<CheckKtpIsSaved> lazy7, Lazy<ConsultAgreementOnlyParamSpaceCodes> lazy8, Lazy<RecordAgreementOnlyAgreementKey> lazy9, Lazy<GetIntervalTimeHitWalletApi> lazy10) {
        return new PersonalPresenter(lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10);
    }
}
