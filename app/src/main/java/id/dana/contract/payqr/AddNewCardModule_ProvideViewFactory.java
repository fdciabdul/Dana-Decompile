package id.dana.contract.payqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payasset.AddNewCardContract;

/* loaded from: classes4.dex */
public final class AddNewCardModule_ProvideViewFactory implements Factory<AddNewCardContract.View> {
    private final AddNewCardModule MyBillsEntityDataFactory;

    private AddNewCardModule_ProvideViewFactory(AddNewCardModule addNewCardModule) {
        this.MyBillsEntityDataFactory = addNewCardModule;
    }

    public static AddNewCardModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(AddNewCardModule addNewCardModule) {
        return new AddNewCardModule_ProvideViewFactory(addNewCardModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AddNewCardContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
    }
}
