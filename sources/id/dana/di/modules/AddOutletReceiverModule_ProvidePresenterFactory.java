package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.external.outlet.AddOutletReceiverContract;
import id.dana.sendmoney.external.outlet.AddOutletReceiverPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class AddOutletReceiverModule_ProvidePresenterFactory implements Factory<AddOutletReceiverContract.Presenter> {
    private final AddOutletReceiverModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<AddOutletReceiverPresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    private AddOutletReceiverModule_ProvidePresenterFactory(AddOutletReceiverModule addOutletReceiverModule, Provider<AddOutletReceiverPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = addOutletReceiverModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static AddOutletReceiverModule_ProvidePresenterFactory MyBillsEntityDataFactory(AddOutletReceiverModule addOutletReceiverModule, Provider<AddOutletReceiverPresenter> provider) {
        return new AddOutletReceiverModule_ProvidePresenterFactory(addOutletReceiverModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AddOutletReceiverContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
