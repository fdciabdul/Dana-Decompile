package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.RecipientPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RecipientActivityModule_ProvidePresenterFactory implements Factory<RecipientContract.Presenter> {
    private final Provider<RecipientPresenter> BuiltInFictitiousFunctionClassFactory;
    private final RecipientActivityModule PlaceComponentResult;

    private RecipientActivityModule_ProvidePresenterFactory(RecipientActivityModule recipientActivityModule, Provider<RecipientPresenter> provider) {
        this.PlaceComponentResult = recipientActivityModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static RecipientActivityModule_ProvidePresenterFactory getAuthRequestContext(RecipientActivityModule recipientActivityModule, Provider<RecipientPresenter> provider) {
        return new RecipientActivityModule_ProvidePresenterFactory(recipientActivityModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RecipientContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
