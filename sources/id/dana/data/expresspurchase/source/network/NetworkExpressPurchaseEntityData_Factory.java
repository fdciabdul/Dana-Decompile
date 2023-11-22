package id.dana.data.expresspurchase.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkExpressPurchaseEntityData_Factory implements Factory<NetworkExpressPurchaseEntityData> {
    private final Provider<ApSecurity> apSecurityProvider;
    private final Provider<Context> contextProvider;
    private final Provider<ExpressPurchaseApi> expressPurchaseApiProvider;

    public NetworkExpressPurchaseEntityData_Factory(Provider<Context> provider, Provider<ApSecurity> provider2, Provider<ExpressPurchaseApi> provider3) {
        this.contextProvider = provider;
        this.apSecurityProvider = provider2;
        this.expressPurchaseApiProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final NetworkExpressPurchaseEntityData get() {
        return newInstance(this.contextProvider.get(), this.apSecurityProvider.get(), this.expressPurchaseApiProvider.get());
    }

    public static NetworkExpressPurchaseEntityData_Factory create(Provider<Context> provider, Provider<ApSecurity> provider2, Provider<ExpressPurchaseApi> provider3) {
        return new NetworkExpressPurchaseEntityData_Factory(provider, provider2, provider3);
    }

    public static NetworkExpressPurchaseEntityData newInstance(Context context, ApSecurity apSecurity, ExpressPurchaseApi expressPurchaseApi) {
        return new NetworkExpressPurchaseEntityData(context, apSecurity, expressPurchaseApi);
    }
}
