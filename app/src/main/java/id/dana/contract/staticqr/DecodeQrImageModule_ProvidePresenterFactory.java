package id.dana.contract.staticqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.staticqr.DecodeQrImageContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DecodeQrImageModule_ProvidePresenterFactory implements Factory<DecodeQrImageContract.Presenter> {
    private final Provider<DecodeQrImagePresenter> BuiltInFictitiousFunctionClassFactory;
    private final DecodeQrImageModule getAuthRequestContext;

    private DecodeQrImageModule_ProvidePresenterFactory(DecodeQrImageModule decodeQrImageModule, Provider<DecodeQrImagePresenter> provider) {
        this.getAuthRequestContext = decodeQrImageModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static DecodeQrImageModule_ProvidePresenterFactory PlaceComponentResult(DecodeQrImageModule decodeQrImageModule, Provider<DecodeQrImagePresenter> provider) {
        return new DecodeQrImageModule_ProvidePresenterFactory(decodeQrImageModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DecodeQrImageContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
