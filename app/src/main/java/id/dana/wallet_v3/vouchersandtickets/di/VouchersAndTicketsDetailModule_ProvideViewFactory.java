package id.dana.wallet_v3.vouchersandtickets.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract;

/* loaded from: classes6.dex */
public final class VouchersAndTicketsDetailModule_ProvideViewFactory implements Factory<VouchersAndTicketsDetailContract.View> {
    private final VouchersAndTicketsDetailModule module;

    public VouchersAndTicketsDetailModule_ProvideViewFactory(VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule) {
        this.module = vouchersAndTicketsDetailModule;
    }

    @Override // javax.inject.Provider
    public final VouchersAndTicketsDetailContract.View get() {
        return provideView(this.module);
    }

    public static VouchersAndTicketsDetailModule_ProvideViewFactory create(VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule) {
        return new VouchersAndTicketsDetailModule_ProvideViewFactory(vouchersAndTicketsDetailModule);
    }

    public static VouchersAndTicketsDetailContract.View provideView(VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule) {
        return (VouchersAndTicketsDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(vouchersAndTicketsDetailModule.getView());
    }
}
