package id.dana.data.expresspurchase.source.config.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitExpressPurchaseConfigEntityData_Factory implements Factory<SplitExpressPurchaseConfigEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitExpressPurchaseConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitExpressPurchaseConfigEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitExpressPurchaseConfigEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitExpressPurchaseConfigEntityData_Factory(provider);
    }

    public static SplitExpressPurchaseConfigEntityData newInstance(SplitFacade splitFacade) {
        return new SplitExpressPurchaseConfigEntityData(splitFacade);
    }
}
