package id.dana.data.expresspurchase.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkExpressPurchaseOfferEntityData_Factory implements Factory<NetworkExpressPurchaseOfferEntityData> {
    private final Provider<ApSecurity> apSecurityProvider;
    private final Provider<Context> contextProvider;
    private final Provider<ExpressPurchaseOfferApi> expressPurchaseOfferApiProvider;

    public NetworkExpressPurchaseOfferEntityData_Factory(Provider<Context> provider, Provider<ApSecurity> provider2, Provider<ExpressPurchaseOfferApi> provider3) {
        this.contextProvider = provider;
        this.apSecurityProvider = provider2;
        this.expressPurchaseOfferApiProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final NetworkExpressPurchaseOfferEntityData get() {
        return newInstance(this.contextProvider.get(), this.apSecurityProvider.get(), this.expressPurchaseOfferApiProvider.get());
    }

    public static NetworkExpressPurchaseOfferEntityData_Factory create(Provider<Context> provider, Provider<ApSecurity> provider2, Provider<ExpressPurchaseOfferApi> provider3) {
        return new NetworkExpressPurchaseOfferEntityData_Factory(provider, provider2, provider3);
    }

    public static NetworkExpressPurchaseOfferEntityData newInstance(Context context, ApSecurity apSecurity, ExpressPurchaseOfferApi expressPurchaseOfferApi) {
        return new NetworkExpressPurchaseOfferEntityData(context, apSecurity, expressPurchaseOfferApi);
    }
}
