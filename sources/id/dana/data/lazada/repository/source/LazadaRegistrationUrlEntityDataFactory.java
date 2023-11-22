package id.dana.data.lazada.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.lazada.repository.source.network.NetworkLazadaRegistrationUrlEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class LazadaRegistrationUrlEntityDataFactory extends AbstractEntityDataFactory<LazadaRegistrationUrlEntityData> {
    private final NetworkLazadaRegistrationUrlEntityData networkLazadaRegistrationUrlEntityData;

    @Inject
    public LazadaRegistrationUrlEntityDataFactory(NetworkLazadaRegistrationUrlEntityData networkLazadaRegistrationUrlEntityData) {
        this.networkLazadaRegistrationUrlEntityData = networkLazadaRegistrationUrlEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public LazadaRegistrationUrlEntityData createData2(String str) {
        return this.networkLazadaRegistrationUrlEntityData;
    }
}
