package id.dana.data.globalnetwork.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.globalnetwork.source.local.GlobalNetworkPreference;
import id.dana.data.globalnetwork.source.local.PreferenceGnPaymentEntityData;
import id.dana.data.globalnetwork.source.mock.MockGlobalNetworkEntityData;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class GnPaymentDataFactory extends AbstractEntityDataFactory<GnPaymentEntityData> {
    private final GlobalNetworkPreference globalNetworkPreference;
    @Inject
    RemoteGnPaymentEntityData remoteGnPaymentEntityData;

    @Inject
    public GnPaymentDataFactory(GlobalNetworkPreference globalNetworkPreference) {
        this.globalNetworkPreference = globalNetworkPreference;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public GnPaymentEntityData createData2(String str) {
        if ("mock".equals(str)) {
            return new MockGlobalNetworkEntityData();
        }
        if ("local".equals(str)) {
            return new PreferenceGnPaymentEntityData(this.globalNetworkPreference);
        }
        return this.remoteGnPaymentEntityData;
    }
}
