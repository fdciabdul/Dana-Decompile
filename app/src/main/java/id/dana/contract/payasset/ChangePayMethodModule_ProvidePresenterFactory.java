package id.dana.contract.payasset;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payasset.ChangePayMethodContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ChangePayMethodModule_ProvidePresenterFactory implements Factory<ChangePayMethodContract.Presenter> {
    private final ChangePayMethodModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ChangePayMethodPresenter> MyBillsEntityDataFactory;

    private ChangePayMethodModule_ProvidePresenterFactory(ChangePayMethodModule changePayMethodModule, Provider<ChangePayMethodPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = changePayMethodModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ChangePayMethodModule_ProvidePresenterFactory PlaceComponentResult(ChangePayMethodModule changePayMethodModule, Provider<ChangePayMethodPresenter> provider) {
        return new ChangePayMethodModule_ProvidePresenterFactory(changePayMethodModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ChangePayMethodContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
