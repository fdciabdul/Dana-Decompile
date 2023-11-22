package id.dana.contract.payqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payasset.AddNewCardContract;
import id.dana.contract.payasset.AddNewCardPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class AddNewCardModule_ProvidePresenterFactory implements Factory<AddNewCardContract.Presenter> {
    private final AddNewCardModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AddNewCardPresenter> MyBillsEntityDataFactory;

    private AddNewCardModule_ProvidePresenterFactory(AddNewCardModule addNewCardModule, Provider<AddNewCardPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = addNewCardModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static AddNewCardModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(AddNewCardModule addNewCardModule, Provider<AddNewCardPresenter> provider) {
        return new AddNewCardModule_ProvidePresenterFactory(addNewCardModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AddNewCardContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
