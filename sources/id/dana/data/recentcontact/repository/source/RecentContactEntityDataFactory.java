package id.dana.data.recentcontact.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.recentcontact.repository.source.mock.MockRecentContactEntityData;
import id.dana.data.recentcontact.repository.source.persistence.PersistenceRecentContactEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class RecentContactEntityDataFactory extends AbstractEntityDataFactory<RecentContactEntityData> {
    private final PersistenceRecentContactEntityData persistenceRecentContactEntityData;

    @Inject
    public RecentContactEntityDataFactory(PersistenceRecentContactEntityData persistenceRecentContactEntityData) {
        this.persistenceRecentContactEntityData = persistenceRecentContactEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public RecentContactEntityData createData2(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 3357066) {
            if (hashCode == 103145323 && str.equals("local")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("mock")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            return this.persistenceRecentContactEntityData;
        }
        return new MockRecentContactEntityData();
    }
}
