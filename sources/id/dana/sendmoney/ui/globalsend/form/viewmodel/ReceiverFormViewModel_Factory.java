package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.common.interactor.ValidateFormUseCase;
import id.dana.sendmoney.domain.globalsend.interactor.GetProvinceList;
import id.dana.sendmoney.domain.globalsend.interactor.InitGlobalTransfer;
import id.dana.sendmoney.domain.globalsend.interactor.ValidateNewTransaction;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ReceiverFormViewModel_Factory implements Factory<ReceiverFormViewModel> {
    private final Provider<GetProvinceList> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ValidateFormUseCase> MyBillsEntityDataFactory;
    private final Provider<ValidateNewTransaction> PlaceComponentResult;
    private final Provider<InitGlobalTransfer> getAuthRequestContext;

    private ReceiverFormViewModel_Factory(Provider<ValidateFormUseCase> provider, Provider<ValidateNewTransaction> provider2, Provider<InitGlobalTransfer> provider3, Provider<GetProvinceList> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static ReceiverFormViewModel_Factory getAuthRequestContext(Provider<ValidateFormUseCase> provider, Provider<ValidateNewTransaction> provider2, Provider<InitGlobalTransfer> provider3, Provider<GetProvinceList> provider4) {
        return new ReceiverFormViewModel_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReceiverFormViewModel(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
