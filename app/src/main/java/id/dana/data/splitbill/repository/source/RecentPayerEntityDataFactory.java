package id.dana.data.splitbill.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.splitbill.repository.source.persistence.PersistenceRecentPayerEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class RecentPayerEntityDataFactory extends AbstractEntityDataFactory<RecentPayerEntityData> {
    private final PersistenceRecentPayerEntityData persistenceRecentPayerEntityData;

    @Inject
    public RecentPayerEntityDataFactory(PersistenceRecentPayerEntityData persistenceRecentPayerEntityData) {
        this.persistenceRecentPayerEntityData = persistenceRecentPayerEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public RecentPayerEntityData createData2(String str) {
        return this.persistenceRecentPayerEntityData;
    }
}
