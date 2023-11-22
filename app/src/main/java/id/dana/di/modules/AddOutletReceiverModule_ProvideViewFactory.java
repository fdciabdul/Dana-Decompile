package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.external.outlet.AddOutletReceiverContract;

/* loaded from: classes4.dex */
public final class AddOutletReceiverModule_ProvideViewFactory implements Factory<AddOutletReceiverContract.View> {
    private final AddOutletReceiverModule getAuthRequestContext;

    private AddOutletReceiverModule_ProvideViewFactory(AddOutletReceiverModule addOutletReceiverModule) {
        this.getAuthRequestContext = addOutletReceiverModule;
    }

    public static AddOutletReceiverModule_ProvideViewFactory getAuthRequestContext(AddOutletReceiverModule addOutletReceiverModule) {
        return new AddOutletReceiverModule_ProvideViewFactory(addOutletReceiverModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AddOutletReceiverContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
