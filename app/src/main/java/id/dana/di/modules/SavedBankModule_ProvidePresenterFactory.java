package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.bank.SavedBankCardContract;
import id.dana.contract.sendmoney.bank.SavedBankCardPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavedBankModule_ProvidePresenterFactory implements Factory<SavedBankCardContract.Presenter> {
    private final Provider<SavedBankCardPresenter> BuiltInFictitiousFunctionClassFactory;
    private final SavedBankModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SavedBankModule_ProvidePresenterFactory(SavedBankModule savedBankModule, Provider<SavedBankCardPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = savedBankModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SavedBankModule_ProvidePresenterFactory PlaceComponentResult(SavedBankModule savedBankModule, Provider<SavedBankCardPresenter> provider) {
        return new SavedBankModule_ProvidePresenterFactory(savedBankModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavedBankCardContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
