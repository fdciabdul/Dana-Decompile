package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.transferaccount.success.TransferAccountSuccessContract;

/* loaded from: classes4.dex */
public final class TransferAccountSuccessModule_ProvideViewFactory implements Factory<TransferAccountSuccessContract.View> {
    private final TransferAccountSuccessModule BuiltInFictitiousFunctionClassFactory;

    private TransferAccountSuccessModule_ProvideViewFactory(TransferAccountSuccessModule transferAccountSuccessModule) {
        this.BuiltInFictitiousFunctionClassFactory = transferAccountSuccessModule;
    }

    public static TransferAccountSuccessModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(TransferAccountSuccessModule transferAccountSuccessModule) {
        return new TransferAccountSuccessModule_ProvideViewFactory(transferAccountSuccessModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TransferAccountSuccessContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getPlaceComponentResult());
    }
}
