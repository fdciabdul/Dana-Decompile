package id.dana.sendmoney.external.outlet;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.interactor.GetSendMoneyVendorLogo;
import id.dana.sendmoney.external.outlet.AddOutletReceiverContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AddOutletReceiverPresenter_Factory implements Factory<AddOutletReceiverPresenter> {
    private final Provider<AddOutletReceiverContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetSendMoneyVendorLogo> PlaceComponentResult;

    private AddOutletReceiverPresenter_Factory(Provider<GetSendMoneyVendorLogo> provider, Provider<AddOutletReceiverContract.View> provider2) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static AddOutletReceiverPresenter_Factory PlaceComponentResult(Provider<GetSendMoneyVendorLogo> provider, Provider<AddOutletReceiverContract.View> provider2) {
        return new AddOutletReceiverPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AddOutletReceiverPresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
