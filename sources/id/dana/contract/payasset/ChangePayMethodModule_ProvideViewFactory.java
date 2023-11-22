package id.dana.contract.payasset;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payasset.ChangePayMethodContract;

/* loaded from: classes4.dex */
public final class ChangePayMethodModule_ProvideViewFactory implements Factory<ChangePayMethodContract.View> {
    private final ChangePayMethodModule MyBillsEntityDataFactory;

    private ChangePayMethodModule_ProvideViewFactory(ChangePayMethodModule changePayMethodModule) {
        this.MyBillsEntityDataFactory = changePayMethodModule;
    }

    public static ChangePayMethodModule_ProvideViewFactory MyBillsEntityDataFactory(ChangePayMethodModule changePayMethodModule) {
        return new ChangePayMethodModule_ProvideViewFactory(changePayMethodModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ChangePayMethodContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
    }
}
