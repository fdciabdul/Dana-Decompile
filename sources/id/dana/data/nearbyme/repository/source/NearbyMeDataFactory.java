package id.dana.data.nearbyme.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.nearbyme.NearbyMeEntityData;
import id.dana.data.nearbyme.repository.source.mock.MockNearbyMeEntityRepositoryData;
import id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData;
import id.dana.data.nearbyme.repository.source.session.LocalNearbyMeEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NearbyMeDataFactory extends AbstractEntityDataFactory<NearbyMeEntityData> {
    private final LocalNearbyMeEntityData localNearbyMeEntityData;
    private final MockNearbyMeEntityRepositoryData mockNearbyMeEntityRepositoryData;
    private final NetworkNearbyMeEntityData networkNearbyMeEntityData;

    @Inject
    public NearbyMeDataFactory(NetworkNearbyMeEntityData networkNearbyMeEntityData, MockNearbyMeEntityRepositoryData mockNearbyMeEntityRepositoryData, LocalNearbyMeEntityData localNearbyMeEntityData) {
        this.networkNearbyMeEntityData = networkNearbyMeEntityData;
        this.mockNearbyMeEntityRepositoryData = mockNearbyMeEntityRepositoryData;
        this.localNearbyMeEntityData = localNearbyMeEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public NearbyMeEntityData createData2(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == 3357066) {
            if (str.equals("mock")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 103145323) {
            if (hashCode == 1843485230 && str.equals("network")) {
                c = 3;
            }
            c = 65535;
        } else {
            if (str.equals("local")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c == 1) {
                return this.localNearbyMeEntityData;
            }
            return this.networkNearbyMeEntityData;
        }
        return this.mockNearbyMeEntityRepositoryData;
    }
}
