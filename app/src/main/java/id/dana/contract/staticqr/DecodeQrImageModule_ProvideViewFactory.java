package id.dana.contract.staticqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.staticqr.DecodeQrImageContract;

/* loaded from: classes4.dex */
public final class DecodeQrImageModule_ProvideViewFactory implements Factory<DecodeQrImageContract.View> {
    private final DecodeQrImageModule PlaceComponentResult;

    private DecodeQrImageModule_ProvideViewFactory(DecodeQrImageModule decodeQrImageModule) {
        this.PlaceComponentResult = decodeQrImageModule;
    }

    public static DecodeQrImageModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(DecodeQrImageModule decodeQrImageModule) {
        return new DecodeQrImageModule_ProvideViewFactory(decodeQrImageModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DecodeQrImageContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult());
    }
}
