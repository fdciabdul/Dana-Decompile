package id.dana.contract.staticqr;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.staticqr.DecodeQrImageContract;
import id.dana.scanner.gallery.RxQRDecode;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DecodeQrImagePresenter_Factory implements Factory<DecodeQrImagePresenter> {
    private final Provider<RxQRDecode> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DecodeQrImageContract.View> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;

    private DecodeQrImagePresenter_Factory(Provider<DecodeQrImageContract.View> provider, Provider<RxQRDecode> provider2, Provider<Context> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static DecodeQrImagePresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<DecodeQrImageContract.View> provider, Provider<RxQRDecode> provider2, Provider<Context> provider3) {
        return new DecodeQrImagePresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DecodeQrImagePresenter(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
