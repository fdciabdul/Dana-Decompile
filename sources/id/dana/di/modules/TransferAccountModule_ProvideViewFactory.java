package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.transferaccount.transferaccountstatus.TransferAccountContract;

/* loaded from: classes4.dex */
public final class TransferAccountModule_ProvideViewFactory implements Factory<TransferAccountContract.View> {
    private final TransferAccountModule BuiltInFictitiousFunctionClassFactory;

    private TransferAccountModule_ProvideViewFactory(TransferAccountModule transferAccountModule) {
        this.BuiltInFictitiousFunctionClassFactory = transferAccountModule;
    }

    public static TransferAccountModule_ProvideViewFactory getAuthRequestContext(TransferAccountModule transferAccountModule) {
        return new TransferAccountModule_ProvideViewFactory(transferAccountModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TransferAccountContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getPlaceComponentResult());
    }
}
