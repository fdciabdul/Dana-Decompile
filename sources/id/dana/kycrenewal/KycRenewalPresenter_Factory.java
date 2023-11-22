package id.dana.kycrenewal;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.kycrenewal.interactor.GetKycRenewal;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalButtonClicked;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckDismiss;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckQuery;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckShow;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalButtonClick;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckDismiss;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckQuery;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckShow;
import id.dana.kycrenewal.KycRenewalContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class KycRenewalPresenter_Factory implements Factory<KycRenewalPresenter> {
    private final Provider<GetKycRenewalButtonClicked> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetKycRenewal> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetKycRenewalCheckShow> MyBillsEntityDataFactory;
    private final Provider<SaveKycRenewalCheckShow> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetKycRenewalCheckQuery> PlaceComponentResult;
    private final Provider<GetKycRenewalCheckDismiss> getAuthRequestContext;
    private final Provider<SaveKycRenewalButtonClick> getErrorConfigVersion;
    private final Provider<KycRenewalContract.View> lookAheadTest;
    private final Provider<SaveKycRenewalCheckQuery> moveToNextValue;
    private final Provider<SaveKycRenewalCheckDismiss> scheduleImpl;

    private KycRenewalPresenter_Factory(Provider<KycRenewalContract.View> provider, Provider<GetKycRenewal> provider2, Provider<GetKycRenewalCheckQuery> provider3, Provider<SaveKycRenewalCheckQuery> provider4, Provider<GetKycRenewalCheckShow> provider5, Provider<SaveKycRenewalCheckShow> provider6, Provider<GetKycRenewalCheckDismiss> provider7, Provider<SaveKycRenewalCheckDismiss> provider8, Provider<GetKycRenewalButtonClicked> provider9, Provider<SaveKycRenewalButtonClick> provider10) {
        this.lookAheadTest = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
        this.moveToNextValue = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider6;
        this.getAuthRequestContext = provider7;
        this.scheduleImpl = provider8;
        this.BuiltInFictitiousFunctionClassFactory = provider9;
        this.getErrorConfigVersion = provider10;
    }

    public static KycRenewalPresenter_Factory MyBillsEntityDataFactory(Provider<KycRenewalContract.View> provider, Provider<GetKycRenewal> provider2, Provider<GetKycRenewalCheckQuery> provider3, Provider<SaveKycRenewalCheckQuery> provider4, Provider<GetKycRenewalCheckShow> provider5, Provider<SaveKycRenewalCheckShow> provider6, Provider<GetKycRenewalCheckDismiss> provider7, Provider<SaveKycRenewalCheckDismiss> provider8, Provider<GetKycRenewalButtonClicked> provider9, Provider<SaveKycRenewalButtonClick> provider10) {
        return new KycRenewalPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KycRenewalPresenter(DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion));
    }
}
