package id.dana.data.senddigitalmoney.repository.source.network;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkDigitalMoneyEntityData_Factory implements Factory<NetworkDigitalMoneyEntityData> {
    private final Provider<CardQueryNoPrefixApi> KClassImpl$Data$declaredNonStaticMembers$2;

    private NetworkDigitalMoneyEntityData_Factory(Provider<CardQueryNoPrefixApi> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static NetworkDigitalMoneyEntityData_Factory PlaceComponentResult(Provider<CardQueryNoPrefixApi> provider) {
        return new NetworkDigitalMoneyEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkDigitalMoneyEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
