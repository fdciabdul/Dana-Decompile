package id.dana.data.synccontact.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.synccontact.SyncContactEntityData;
import id.dana.data.synccontact.repository.source.local.PreferencesSyncContactEntityData;
import id.dana.data.synccontact.repository.source.mock.MockSyncContactEntityData;
import id.dana.data.synccontact.repository.source.network.NetworkSyncContactEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SyncContactDataFactory extends AbstractEntityDataFactory<SyncContactEntityData> {
    private final MockSyncContactEntityData mockSyncContactEntityData;
    private final NetworkSyncContactEntityData networkSyncContactEntityData;
    private final PreferencesSyncContactEntityData preferencesSyncContactEntityData;

    @Inject
    public SyncContactDataFactory(PreferencesSyncContactEntityData preferencesSyncContactEntityData, NetworkSyncContactEntityData networkSyncContactEntityData, MockSyncContactEntityData mockSyncContactEntityData) {
        this.preferencesSyncContactEntityData = preferencesSyncContactEntityData;
        this.networkSyncContactEntityData = networkSyncContactEntityData;
        this.mockSyncContactEntityData = mockSyncContactEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public SyncContactEntityData createData2(String str) {
        char c;
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == 3357066) {
            if (str.equals("mock")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 103145323) {
            if (hashCode == 1843485230 && str.equals("network")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("local")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return null;
                }
                return this.networkSyncContactEntityData;
            }
            return this.preferencesSyncContactEntityData;
        }
        return this.mockSyncContactEntityData;
    }
}
